//
// Algoritmos e Estruturas de Dados --- 2023/2024
//
// Topological Sorting
//

#include "GraphTopologicalSorting.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"
#include "instrumentation.h"

struct _GraphTopoSort {
  int* marked;                     // Aux array
  unsigned int* numIncomingEdges;  // Aux array
  unsigned int* vertexSequence;    // The result
  int validResult;                 // 0 or 1
  unsigned int numVertices;        // From the graph
  Graph* graph;
};

// AUXILIARY FUNCTION
// Allocate memory for the struct
// And for its array fields
// Initialize all struct fields
//
static GraphTopoSort* _create(Graph* g) {
  assert(g != NULL);

  GraphTopoSort* p = (GraphTopoSort*)malloc(sizeof(GraphTopoSort));

  if (p != NULL) {
    // Inicializar numVertices
    p->numVertices = GraphGetNumVertices(g);

    // Alocar e inicializar o array marked
    p->marked = (int*)calloc(p->numVertices, sizeof(int));
  

    // Alocar e inicializar o array numIncomingEdges
    p->numIncomingEdges = (unsigned int*)calloc(p->numVertices, sizeof(unsigned int));
    // Alocar espaço para o array vertexSequence
    p->vertexSequence = (unsigned int*)calloc(p->numVertices, sizeof(unsigned int));


    // Inicializar validResult a 0
    p->validResult = 0;

    // Guardar referência para o grafo
    p->graph = g;
  }

  return p;
}


//
// Computing the topological sorting, if any, using the 1st algorithm:
// 1 - Create a copy of the graph
// 2 - Successively identify vertices without incoming edges and remove their
//     outgoing edges
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//

GraphTopoSort* GraphTopoSortComputeV1(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct
  GraphTopoSort* topoSort = _create(g);

  // Build the topological sorting
  unsigned int* sequence = topoSort->vertexSequence;
  unsigned int numVertices = topoSort->numVertices;

  // Create a copy of the graph
  Graph* copyGraph = GraphCopy(g);


  // Loop to find vertices without incoming edges
  unsigned int NumberVertexSequence = 0;
  for (unsigned int i = 0; i < numVertices; ++i) {
    OUTER_LOOP_ITER++;

    for (unsigned int v = 0; v < numVertices; ++v) {
      INNER_LOOP_ITER++;
      if (GraphGetVertexInDegree(copyGraph, v) == 0 && !topoSort->marked[v]) {
        // Vertex with no incoming edges found
        sequence[i] = v;  // Add the vertex to the sequence
        NumberVertexSequence++;
        topoSort->marked[v] = 1;  // Mark the vertex as visited

        // Remove outgoing edges of the current vertex in the copy graph
        unsigned int* adjacents = GraphGetAdjacentsTo(copyGraph, v);
        for (unsigned int j = 1; j<=adjacents[0] ; ++j) {
          unsigned int adjacentVertex = adjacents[j];
          topoSort->numIncomingEdges[v]=adjacents[0];
          GraphRemoveEdge(copyGraph, v, adjacentVertex);
        }
        free(adjacents);

        break;  // Move to the next iteration
      }
    }

  }
  if ( NumberVertexSequence == topoSort->numVertices) {
    topoSort->validResult = 1;
  }

 

  printf("Number of vertices: %d\n", numVertices);
  printf("Number of edges: %d\n", GraphGetNumEdges(g));
  printf("Number of vertices in the sequence: %d\n", NumberVertexSequence);

  // Free the copy graph
  GraphDestroy(&copyGraph);
  printf("Number of operations: %ld\n", REMOVE_EDGE_OPS + COPY_GRAPH_OPS + OUTER_LOOP_ITER + INNER_LOOP_ITER);
  return topoSort;
}


static void DFS(Graph* g, int v, int* visited, int* finishingTimes, int* time, unsigned int* numberVertexSequence) {
  
  visited[v] = 1;

  unsigned int* adjacents = GraphGetAdjacentsTo(g, v);
  for (unsigned int i = 1; i <= adjacents[0]; ++i) {
    int adjacentVertex = adjacents[i];
    DFS_COMPS++;
    if (!visited[adjacentVertex]) {
      DFS(g, adjacentVertex, visited, finishingTimes, time, numberVertexSequence);
    }
  }

  (*numberVertexSequence)++;

  finishingTimes[(*time)++] = v;
  free(adjacents);
}
//
// Computing the topological sorting, if any, using the 2nd algorithm
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//
GraphTopoSort* GraphTopoSortComputeV2(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct
  GraphTopoSort* topoSort = _create(g);

  // Perform DFS to compute finishing times
  int* visited = (int*)calloc(topoSort->numVertices, sizeof(int));
  int* finishingTimes = (int*)malloc(topoSort->numVertices * sizeof(int));
  int time = 0;
  unsigned int numberVertexSequence = 0;

  for (unsigned int i = 0; i < topoSort->numVertices; ++i) {
    if (!visited[i]) {
      DFS(g, i, visited, finishingTimes, &time, &numberVertexSequence);
    }
  }

  free(visited);

  // Build the topological sorting based on finishing times
  unsigned int* sequence = topoSort->vertexSequence;
  unsigned int numVertices = topoSort->numVertices;

  for (unsigned int i = topoSort->numVertices - 1, j = 0; j < numVertices; --i, ++j) {
    sequence[j] = finishingTimes[i];
    topoSort->marked[finishingTimes[i]] = 1; // Mark the vertex as visited
    SORTING_OPS++;
  }

  free(finishingTimes);

  printf("Number of vertices: %d\n", numVertices);
  printf("Number of edges: %d\n", GraphGetNumEdges(g));
  printf("Number of vertices in the sequence: %d\n", numberVertexSequence);


  // Check if a valid sorting was computed
  if (numberVertexSequence == numVertices) {
    topoSort->validResult = 1;
  }
  
  printf("Number of operations: %ld\n", DFS_COMPS + ADJACENTS_OPS + SORTING_OPS);

  return topoSort;
}



//
// Computing the topological sorting, if any, using the 3rd algorithm
// Check if a valid sorting was computed and set the isValid field
// For instance, by checking if the number of elements in the vertexSequence is
// the number of graph vertices
//

GraphTopoSort* GraphTopoSortComputeV3(Graph* g) {
  assert(g != NULL && GraphIsDigraph(g) == 1);

  // Create and initialize the struct
  GraphTopoSort* topoSort = _create(g);
  unsigned int numVertices = topoSort->numVertices;

  // Create a queue for BFS
  Queue* queue = QueueCreate(numVertices);

  // Perform BFS and generate topological sorting
  unsigned int numberVertexSequence = 0;

  for (unsigned int startVertex = 0; startVertex < numVertices; ++startVertex) {
    if (topoSort->marked[startVertex] == 0) {
      QueueEnqueue(queue, startVertex);
      topoSort->marked[startVertex] = 1;

      while (QueueIsEmpty(queue) == 0) {
        unsigned int vertex = QueueDequeue(queue);
        topoSort->vertexSequence[numberVertexSequence++] = vertex;

        unsigned int* neighbors = GraphGetAdjacentsTo(topoSort->graph, vertex);

        for (unsigned int i = 1; i <= neighbors[0]; i++) {
          unsigned int w = neighbors[i];

          BFS_OPS++;
          if (topoSort->marked[w] == 0) {
            // Reached for the first time
            topoSort->marked[w] = 1;
            QueueEnqueue(queue, w);
          }
        }

        free(neighbors);
      }
    }
  }

  printf("Number of vertices: %d\n", numVertices);
  printf("Number of edges: %d\n", GraphGetNumEdges(g));
  printf("Number of vertices in the sequence: %d\n", numberVertexSequence);

  // Check if a valid sorting was computed
  if (numberVertexSequence == numVertices) {
    topoSort->validResult = 1;
  }

  printf("Number of operations: %ld\n", BFS_OPS + QUEUE_ENQUEUE_OPS + QUEUE_DEQUEUE_OPS);

  // Free allocated memory
  QueueDestroy(&queue);

  return topoSort;
}



void GraphTopoSortDestroy(GraphTopoSort** p) {
  assert(*p != NULL);

  GraphTopoSort* aux = *p;

  free(aux->marked);
  free(aux->numIncomingEdges);
  free(aux->vertexSequence);

  free(*p);
  *p = NULL;
}

//
// A valid sorting was computed?
//
int GraphTopoSortIsValid(const GraphTopoSort* p) { return p->validResult; }

//
// Getting an array containing the topological sequence of vertex indices
// Or NULL, if no sequence could be computed
// MEMORY IS ALLOCATED FOR THE RESULTING ARRAY
//
unsigned int* GraphTopoSortGetSequence(const GraphTopoSort* p) {
  assert(p != NULL);

  // Verifique se uma ordenação topológica válida foi calculada
  if (!GraphTopoSortIsValid(p)) {
    fprintf(stderr, "Error: Invalid topological sorting result.\n");
    return NULL;
  }

  // Alocar memória para o array resultante
  unsigned int* sequence = (unsigned int*)malloc(p->numVertices * sizeof(unsigned int));

  if (sequence != NULL) {
    // Copiar a sequência topológica para o array
    for (unsigned int i = 0; i < p->numVertices; ++i) {
      sequence[i] = p->vertexSequence[i];
    }
  }

  return sequence;
}


// DISPLAYING on the console

//
// The toplogical sequence of vertex indices, if it could be computed
//
void GraphTopoSortDisplaySequence(const GraphTopoSort* p) {
  assert(p != NULL);

  if (p->validResult == 0) {
    printf(" *** The topological sorting could not be computed!! *** \n");
    return;
  }

  printf("Topological Sorting - Vertex indices:\n");
  for (unsigned int i = 0; i < GraphGetNumVertices(p->graph); i++) {
    printf("%d ", p->vertexSequence[i]);
  }
  printf("\n");
}

//
// The toplogical sequence of vertex indices, if it could be computed
// Followed by the digraph displayed using the adjecency lists
// Adjacency lists are presented in topologic sorted order
//
void GraphTopoSortDisplay(const GraphTopoSort* p) {
  assert(p != NULL);

  // The topological order
  GraphTopoSortDisplaySequence(p);

  if (p->validResult == 0) {
    return;
  }

  // The Digraph
  for (unsigned int i = 0; i < GraphGetNumVertices(p->graph); i++) {
    GraphListAdjacents(p->graph, p->vertexSequence[i]);
  }
  printf("\n");
}