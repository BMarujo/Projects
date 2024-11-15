//
// Algoritmos e Estruturas de Dados --- 2023/2024
//
// Joaquim Madeira, Joao Manuel Rodrigues - June 2021, Nov 2023
//
// Graph - Using a list of adjacency lists representation
//

#include "Graph.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "SortedList.h"
#include "instrumentation.h"



struct _Vertex {
  unsigned int id;
  unsigned int inDegree;
  unsigned int outDegree;
  List* edgesList;
};

struct _Edge {
  unsigned int adjVertex;
  double weight;
};

struct _GraphHeader {
  int isDigraph;
  int isComplete;
  int isWeighted;
  unsigned int numVertices;
  unsigned int numEdges;
  List* verticesList;
};

// The comparator for the VERTICES LIST

int graphVerticesComparator(const void* p1, const void* p2) {
  unsigned int v1 = ((struct _Vertex*)p1)->id;
  unsigned int v2 = ((struct _Vertex*)p2)->id;
  int d = v1 - v2;
  return (d > 0) - (d < 0);
}

// The comparator for the EDGES LISTS

int graphEdgesComparator(const void* p1, const void* p2) {
  unsigned int v1 = ((struct _Edge*)p1)->adjVertex;
  unsigned int v2 = ((struct _Edge*)p2)->adjVertex;
  int d = v1 - v2;
  return (d > 0) - (d < 0);
}

Graph* GraphCreate(unsigned int numVertices, int isDigraph, int isWeighted) {
  Graph* g = (Graph*)malloc(sizeof(struct _GraphHeader));
  if (g == NULL) abort();

  g->isDigraph = isDigraph;
  g->isComplete = 0;
  g->isWeighted = isWeighted;

  g->numVertices = numVertices;
  g->numEdges = 0;

  g->verticesList = ListCreate(graphVerticesComparator);

  for (unsigned int i = 0; i < numVertices; i++) {
    struct _Vertex* v = (struct _Vertex*)malloc(sizeof(struct _Vertex));
    if (v == NULL) abort();

    v->id = i;
    v->inDegree = 0;
    v->outDegree = 0;

    v->edgesList = ListCreate(graphEdgesComparator);

    ListInsert(g->verticesList, v);
  }

  assert(g->numVertices == ListGetSize(g->verticesList));

  return g;
}

Graph* GraphCreateComplete(unsigned int numVertices, int isDigraph) {
  Graph* g = GraphCreate(numVertices, isDigraph, 0);

  g->isComplete = 1;

  List* vertices = g->verticesList;
  ListMoveToHead(vertices);
  unsigned int i = 0;
  for (; i < g->numVertices; ListMoveToNext(vertices), i++) {
    struct _Vertex* v = ListGetCurrentItem(vertices);
    List* edges = v->edgesList;
    for (unsigned int j = 0; j < g->numVertices; j++) {
      if (i == j) {
        continue;
      }
      struct _Edge* new = (struct _Edge*)malloc(sizeof(struct _Edge));
      if (new == NULL) abort();
      new->adjVertex = j;
      new->weight = 1;

      ListInsert(edges, new);
    }
    if (g->isDigraph) {
      v->inDegree = g->numVertices - 1;
      v->outDegree = g->numVertices - 1;
    } else {
      v->outDegree = g->numVertices - 1;
    }
  }
  if (g->isDigraph) {
    g->numEdges = numVertices * (numVertices - 1);
  } else {
    g->numEdges = numVertices * (numVertices - 1) / 2;
  }

  return g;
}

void GraphDestroy(Graph** p) {
  assert(*p != NULL);
  Graph* g = *p;

  List* vertices = g->verticesList;
  if (ListIsEmpty(vertices) == 0) {
    ListMoveToHead(vertices);
    unsigned int i = 0;
    for (; i < g->numVertices; ListMoveToNext(vertices), i++) {
      struct _Vertex* v = ListGetCurrentItem(vertices);

      List* edges = v->edgesList;
      if (ListIsEmpty(edges) == 0) {
        unsigned int i = 0;
        ListMoveToHead(edges);
        for (; i < ListGetSize(edges); ListMoveToNext(edges), i++) {
          struct _Edge* e = ListGetCurrentItem(edges);
          free(e);
        }
      }
      ListDestroy(&(v->edgesList));
      free(v);
    }
  }

  ListDestroy(&(g->verticesList));
  free(g);

  *p = NULL;
}

/*
*/
Graph* GraphCopy(const Graph* g) {
  assert(g != NULL);

  // Create a new graph
  Graph* newGraph = GraphCreate(g->numVertices, g->isDigraph, g->isWeighted);
  if (newGraph == NULL) return NULL;
  newGraph->isComplete = g->isComplete;
  newGraph->numEdges = g->numEdges;
  
  // Copy the vertices
  List* originalVertices = g->verticesList;
  List* copyVertices = newGraph->verticesList;
  ListMoveToHead(originalVertices);
  ListMoveToHead(copyVertices);
  unsigned int i = 0;
  for (; i < g->numVertices; ListMoveToNext(originalVertices), ListMoveToNext(copyVertices), i++) {
    struct _Vertex* originalVertex = ListGetCurrentItem(originalVertices);
    struct _Vertex* copyVertex = ListGetCurrentItem(copyVertices);

    // Copy the edges
    List* originalEdges = originalVertex->edgesList;
    List* copyEdges = copyVertex->edgesList;
    ListMoveToHead(originalEdges);
    ListMoveToHead(copyEdges);
    unsigned int j = 0;
    for (; j < originalVertex->outDegree; ListMoveToNext(originalEdges), ListMoveToNext(copyEdges), j++) {
      struct _Edge* originalEdge = ListGetCurrentItem(originalEdges);
      struct _Edge* copyEdge = (struct _Edge*)malloc(sizeof(struct _Edge));

      // Copy the edge
      copyEdge->adjVertex = originalEdge->adjVertex;
      copyEdge->weight = originalEdge->weight;

      // Insert the edge in the edges list
      ListInsert(copyEdges, copyEdge);
      COPY_GRAPH_OPS++;
    }

    // Copy the degrees
    copyVertex->inDegree = originalVertex->inDegree;
    copyVertex->outDegree = originalVertex->outDegree;

    // Insert the vertex in the vertices list
    ListInsert(copyVertices, copyVertex);
    COPY_GRAPH_OPS++;
  }

  // Check invariants
  if (GraphCheckInvariants(newGraph) == 0) {
    fprintf(stderr, "ERROR: Graph invariants not met\n");
    GraphDestroy(&newGraph);
    return NULL;
  }

  return newGraph;
}




/* Read a graph from a file
  * Read the first line of the file to get the graph properties
  * Create a new graph with the properties
  * Read the remaining lines of the file to get the edges
  * Return a pointer to the new graph
  * Return NULL if there is an error
*/
Graph* GraphFromFile(FILE* f) {
  assert(f != NULL);

  int isDigraph, isWeighted;
  unsigned int numVertices, numEdges;

  fscanf(f, "%d %d %u %u", &isDigraph, &isWeighted, &numVertices, &numEdges);

  // Create a new graph
  Graph* g = NULL;
  
  // Check if graph is complete
  if (numEdges == numVertices * (numVertices - 1) / 2)
    g = GraphCreateComplete(numVertices, isDigraph);
  else g = GraphCreate(numVertices, isDigraph, isWeighted);
  
  // Check if graph was created
  if (g == NULL) return NULL;

  // Read the file line by line, breaking when the last valid line is read
  unsigned int v, w;
  double weight = 0;
  while ((isWeighted ? fscanf(f, "%u %u %lf", &v, &w, &weight) == 3 :
                       fscanf(f, "%u %u", &v, &w) == 2)) {
    // Check if the vertices are valid
    if (v >= numVertices || w >= numVertices || v == w) continue;

    // Round the weight to the nearest integer
    int roundedWeight = (int)(weight * 100 + 0.5) + 1;  // Add 1 to avoid 0 weights

    if ((isWeighted ? GraphAddWeightedEdge(g, v, w, roundedWeight) : GraphAddEdge(g, v, w)) == 0) {
      // Error adding edge
      GraphDestroy(&g);
      return NULL;
    }
  }

  // Check if the number of edges is correct
  if (g->numEdges != numEdges || GraphCheckInvariants(g) == 0) {
    GraphDestroy(&g);
    return NULL;
  }

  // Return the graph
  return g;
}

// Graph

int GraphIsDigraph(const Graph* g) { return g->isDigraph; }

int GraphIsComplete(const Graph* g) { return g->isComplete; }

int GraphIsWeighted(const Graph* g) { return g->isWeighted; }

unsigned int GraphGetNumVertices(const Graph* g) { return g->numVertices; }

unsigned int GraphGetNumEdges(const Graph* g) { return g->numEdges; }

//
// For a graph
//
double GraphGetAverageDegree(const Graph* g) {
  assert(g->isDigraph == 0);
  return 2.0 * (double)g->numEdges / (double)g->numVertices;
}

static unsigned int _GetMaxDegree(const Graph* g) {
  List* vertices = g->verticesList;
  if (ListIsEmpty(vertices)) return 0;

  unsigned int maxDegree = 0;
  ListMoveToHead(vertices);
  unsigned int i = 0;
  for (; i < g->numVertices; ListMoveToNext(vertices), i++) {
    struct _Vertex* v = ListGetCurrentItem(vertices);
    if (v->outDegree > maxDegree) {
      maxDegree = v->outDegree;
    }
  }
  return maxDegree;
}

//
// For a graph
//
unsigned int GraphGetMaxDegree(const Graph* g) {
  assert(g->isDigraph == 0);
  return _GetMaxDegree(g);
}

//
// For a digraph
//
unsigned int GraphGetMaxOutDegree(const Graph* g) {
  assert(g->isDigraph == 1);
  return _GetMaxDegree(g);
}

// Vertices

//
// returns an array of size (outDegree + 1)
// element 0, stores the number of adjacent vertices
// and is followed by indices of the adjacent vertices
//
unsigned int* GraphGetAdjacentsTo(const Graph* g, unsigned int v) {
  assert(v < g->numVertices);

  // Node in the list of vertices
  List* vertices = g->verticesList;
  ListMove(vertices, v);
  struct _Vertex* vPointer = ListGetCurrentItem(vertices);
  unsigned int numAdjVertices = vPointer->outDegree;

  unsigned int* adjacent =
      (unsigned int*)calloc(1 + numAdjVertices, sizeof(unsigned int));

  if (numAdjVertices > 0) {
    adjacent[0] = numAdjVertices;
    List* adjList = vPointer->edgesList;
    ListMoveToHead(adjList);
    for (unsigned int i = 0; i < numAdjVertices; ListMoveToNext(adjList), i++) {
      struct _Edge* ePointer = ListGetCurrentItem(adjList);
      adjacent[i + 1] = ePointer->adjVertex;
      ADJACENTS_OPS++;
    }
  }

  return adjacent;
}

//
// returns an array of size (outDegree + 1)
// element 0, stores the number of adjacent vertices
// and is followed by the distances to the adjacent vertices
//
double* GraphGetDistancesToAdjacents(const Graph* g, unsigned int v) {
  assert(v < g->numVertices);

  // Node in the list of vertices
  List* vertices = g->verticesList;
  ListMove(vertices, v);
  struct _Vertex* vPointer = ListGetCurrentItem(vertices);
  unsigned int numAdjVertices = vPointer->outDegree;

  double* distance = (double*)calloc(1 + numAdjVertices, sizeof(double));

  if (numAdjVertices > 0) {
    distance[0] = numAdjVertices;
    List* adjList = vPointer->edgesList;
    ListMoveToHead(adjList);
    for (unsigned int i = 0; i < numAdjVertices; ListMoveToNext(adjList), i++) {
      struct _Edge* ePointer = ListGetCurrentItem(adjList);
      distance[i + 1] = ePointer->weight;
    }
  }

  return distance;
}

//
// For a graph
//
unsigned int GraphGetVertexDegree(Graph* g, unsigned int v) {
  assert(g->isDigraph == 0);
  assert(v < g->numVertices);

  ListMove(g->verticesList, v);
  struct _Vertex* p = ListGetCurrentItem(g->verticesList);

  return p->outDegree;
}

//
// For a digraph
//
unsigned int GraphGetVertexOutDegree(Graph* g, unsigned int v) {
  assert(g->isDigraph == 1);
  assert(v < g->numVertices);

  ListMove(g->verticesList, v);
  struct _Vertex* p = ListGetCurrentItem(g->verticesList);

  return p->outDegree;
}

//
// For a digraph
//
unsigned int GraphGetVertexInDegree(Graph* g, unsigned int v) {
  assert(g->isDigraph == 1);
  assert(v < g->numVertices);

  ListMove(g->verticesList, v);
  struct _Vertex* p = ListGetCurrentItem(g->verticesList);

  return p->inDegree;
}

static int _addEdge(Graph* g, unsigned int v, unsigned int w, double weight) {  
  struct _Edge* edge = (struct _Edge*)malloc(sizeof(struct _Edge));
  edge->adjVertex = w;
  edge->weight = weight;

  ListMove(g->verticesList, v);
  struct _Vertex* vertex = ListGetCurrentItem(g->verticesList);
  int result = ListInsert(vertex->edgesList, edge);

  if (result == -1) {
    return 0;
  } else {
    g->numEdges++;
    vertex->outDegree++;

    ListMove(g->verticesList, w);
    struct _Vertex* destVertex = ListGetCurrentItem(g->verticesList);
    destVertex->inDegree++;
  }

  if (g->isDigraph == 0) {
    // Bidirectional edge
    struct _Edge* edge = (struct _Edge*)malloc(sizeof(struct _Edge));
    edge->adjVertex = v;
    edge->weight = weight;

    ListMove(g->verticesList, w);
    struct _Vertex* vertex = ListGetCurrentItem(g->verticesList);
    result = ListInsert(vertex->edgesList, edge);

    if (result == -1) {
      return 0;
    } else {
      // g->numEdges++; // Do not count the same edge twice on a undirected
      // graph !!
      vertex->outDegree++;
    }
  }

  return 1;
}

int GraphAddEdge(Graph* g, unsigned int v, unsigned int w) {
  assert(g->isWeighted == 0);
  assert(v != w);
  assert(v < g->numVertices);
  assert(w < g->numVertices);

  return _addEdge(g, v, w, 1.0);
}

int GraphAddWeightedEdge(Graph* g, unsigned int v, unsigned int w,
                         double weight) {
  assert(g->isWeighted == 1);
  assert(v != w);
  assert(v < g->numVertices);
  assert(w < g->numVertices);

  return _addEdge(g, v, w, weight);
}


/*  Remove an edge from the graph
  * Move verticesList's cursor to v and get the vertex
  * Locate the edge in the adjacency list of v that points to w
  * It may be necessary to locate the edge in the adjacency list 
  *   of w that points to v, if the graph is undirected
  * Remove the edge(s) from the adjacency list(s)
  * Update the number of edges
  * Update the degrees of the vertices
  * Free the memory of the edge(s)
  * Return 1 on success and 0 on failure of doing any of the above
*/
int GraphRemoveEdge(Graph* g, unsigned int v, unsigned int w) {
  // Ensure the graph and vertex indices are valid
  assert(g != NULL);
  assert(v < g->numVertices);
  assert(w < g->numVertices);

  // Move verticesList's cursor to v and get the vertex
  if(ListMove(g->verticesList, v) == -1) {
    fprintf(stderr, "ERROR: Vertex %d not found\n", v);
    return 0;
  }
  struct _Vertex* vertex = ListGetCurrentItem(g->verticesList);

  // Locate the edge in the adjacency list of v that points to w
  List* adjList = vertex->edgesList;
  ListMoveToHead(adjList);
  if(ListSearch(adjList, &w) == -1) {
    fprintf(stderr, "ERROR: Edge (%d, %d) not found\n", v, w);
    return 0;
  }
  struct _Edge* edge = ListGetCurrentItem(adjList);

  // Remove the edge from the adjacency list of v
  if(ListRemoveCurrent(adjList) == NULL) {
    fprintf(stderr, "ERROR: Edge (%d, %d) not removed\n", v, w);
    return 0;
  }

  // Update the number of edges and degrees of the vertices
  g->numEdges--;
  vertex->outDegree--;
  ListMove(g->verticesList, w);
  struct _Vertex* destVertex = ListGetCurrentItem(g->verticesList);
  destVertex->inDegree--;

  ListMoveToHead(adjList);

  // Free the memory of the edge
  free(edge);
  
  // If the graph is undirected, remove the edge from the adjacency list of w
  if(g->isDigraph == 0) {
    // Move verticesList's cursor to w and get the vertex
    if(ListMove(g->verticesList, w) == -1) {
      fprintf(stderr, "ERROR: Vertex %d not found\n", w);
      return 0;
    }

    // Locate the edge in the adjacency list of w that points to v
    List* destAdjList = destVertex->edgesList;
    ListMoveToHead(destAdjList);
    if(ListSearch(destAdjList, &v) == -1) {
      fprintf(stderr, "ERROR: Edge (%d, %d) not found\n", v, w);
      return 0;
    }
    struct _Edge* destEdge = ListGetCurrentItem(destAdjList);

    // Remove the edge from the adjacency list of w
    if(ListRemoveCurrent(destAdjList) == NULL) {
      fprintf(stderr, "ERROR: Edge (%d, %d) not removed\n", v, w);
      return 0;
    }

    // Update the degrees of the vertices
    destVertex->outDegree--;

    // Free the memory of the edge
    free(destEdge);
  }

  // Return 1 on success
  REMOVE_EDGE_OPS++;
  return 1;
}

// CHECKING

/*  Check the invariants of the graph
  * Check if the number of vertices is correct
  * Check if the number of edges is correct
  * Check if the graph is complete and if it has the correct number of edges
  * Check if the graph is weighted and if the edges have weights
  * Return 1 if all the invariants are correct and 0 otherwise
*/
int GraphCheckInvariants(const Graph* g) {
  assert(g != NULL);

  // Check if the number of vertices is correct
  if (g->numVertices != ListGetSize(g->verticesList)) {
    fprintf(stderr, "Error: Number of vertices mismatch.\n");
    return 0;
  }

  // Check if the number of edges is correct
  List* vertices = g->verticesList;
  ListMoveToHead(vertices);
  unsigned int i = 0;
  unsigned int numEdges = 0;
  for (; i < g->numVertices; ListMoveToNext(vertices), i++) {
    struct _Vertex* v = ListGetCurrentItem(vertices);
    numEdges += v->outDegree;
  }
  if (g->isDigraph == 0) numEdges /= 2;
  else if (g->isDigraph != 1) {
    fprintf(stderr, "Error: Directed graph flag is incorrect.\n");
    return 0;
  }
  if (g->numEdges != numEdges) {
    fprintf(stderr, "Error: Number of edges mismatch.\n");
    return 0;
  }

  // Check if the graph is complete and if the number of edges is correct
  if (g->isComplete == 1) {
    if (g->isDigraph == 1) {
      fprintf(stderr, "Error: Directed graph cannot be complete.\n");
      return 0;
    }
    if (g->numEdges != g->numVertices * (g->numVertices - 1) / 2) {
      fprintf(stderr, "Error: Number of edges in complete graph mismatch.\n");
      return 0;
    }
  }
  // If not complete, isComplete should be 0
  else if (g->isComplete != 0) {
    fprintf(stderr, "Error: Complete graph flag is incorrect.\n");
    return 0;
  }
  
  // Check if the graph is weighted and if the edges have weights
  if (g->isWeighted == 1) {
    ListMoveToHead(vertices);
    for (unsigned int i = 0; i < g->numVertices; ListMoveToNext(vertices), i++) {
      struct _Vertex* v = ListGetCurrentItem(vertices);
      List* edges = v->edgesList;
      ListMoveToHead(edges);
      for (unsigned int j = 0; j < v->outDegree; ListMoveToNext(edges), j++) {
        struct _Edge* e = ListGetCurrentItem(edges);
        if (e->weight == 0) {
          fprintf(stderr, "Error: Weighted graph has edge with weight 0.\n");
          return 0;
        }
      }
    }
  }
  // If not weighted, isWeighted should be 0
  else if (g->isWeighted != 0) {
    fprintf(stderr, "Error: Weighted graph flag is incorrect.\n");
    return 0;
  }

  // If all invariants are correct, return 1
  return 1;
}

// DISPLAYING on the console

void GraphDisplay(const Graph* g) {
  printf("---\n");
  if (g->isWeighted) {
    printf("Weighted ");
  }
  if (g->isComplete) {
    printf("COMPLETE ");
  }
  if (g->isDigraph) {
    printf("Digraph\n");
    printf("Max Out-Degree = %d\n", GraphGetMaxOutDegree(g));
  } else {
    printf("Graph\n");
    printf("Max Degree = %d\n", GraphGetMaxDegree(g));
  }
  printf("Vertices = %2d | Edges = %2d\n", g->numVertices, g->numEdges);

  List* vertices = g->verticesList;
  ListMoveToHead(vertices);
  unsigned int i = 0;
  for (; i < g->numVertices; ListMoveToNext(vertices), i++) {
    printf("%2d ->", i);
    struct _Vertex* v = ListGetCurrentItem(vertices);
    if (ListIsEmpty(v->edgesList)) {
      printf("\n");
    } else {
      List* edges = v->edgesList;
      unsigned int i = 0;
      ListMoveToHead(edges);
      for (; i < ListGetSize(edges); ListMoveToNext(edges), i++) {
        struct _Edge* e = ListGetCurrentItem(edges);
        if (g->isWeighted) {
          printf("   %2d(%4.2f)", e->adjVertex, e->weight);
        } else {
          printf("   %2d", e->adjVertex);
        }
      }
      printf("\n");
    }
  }
  printf("---\n");
}

void GraphListAdjacents(const Graph* g, unsigned int v) {
  printf("---\n");

  unsigned int* array = GraphGetAdjacentsTo(g, v);

  printf("Vertex %d has %d adjacent vertices -> ", v, array[0]);

  for (unsigned int i = 1; i <= array[0]; i++) {
    printf("%d ", array[i]);
  }

  printf("\n");

  free(array);

  printf("---\n");
}
