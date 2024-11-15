//
// Algoritmos e Estruturas de Dados --- 2023/2024
//
// Joaquim Madeira, Joao Manuel Rodrigues - June 2021, Nov 2023
//
// Graph EXAMPLE : Creating and displaying graphs
//

#include "Graph.h"

#include <stdio.h>
#include <stdlib.h>


int main(void) {
  // What kind of graph is g01?
  Graph* g01 = GraphCreate(6, 0, 0);
  GraphAddEdge(g01, 1, 2);
  GraphAddEdge(g01, 1, 4);
  GraphAddEdge(g01, 3, 4);
  printf("The first graph:\n");
  GraphDisplay(g01);
  for (int i = 0; i < 6; i++) {
    GraphListAdjacents(g01, i);
  }
  printf("Check invariants\n");
  GraphCheckInvariants(g01);
  printf("Average degree: %f\n", GraphGetAverageDegree(g01));
  
  printf("Copy the graph\n");
  Graph* g01_copy = GraphCopy(g01);
  printf("The copy of the first graph:\n");
  GraphDisplay(g01_copy);
  for (int i = 0; i < 6; i++) {
    GraphListAdjacents(g01_copy, i);
  }
  
  printf("Remove edge (1,2) from the first graph\n");
  GraphRemoveEdge(g01, 1, 2);
  GraphDisplay(g01);
  
  printf("The copy of the first graph:\n");
  GraphDisplay(g01_copy);
  printf("Remove edge (1,2) from the copy of the first graph\n");
  GraphRemoveEdge(g01_copy, 1, 2);
  GraphDisplay(g01_copy);


  printf("\n\n\n\n\n\n");


  Graph* dig01 = GraphCreate(6, 1, 0);
  GraphAddEdge(dig01, 1, 2);
  GraphAddEdge(dig01, 1, 4);
  GraphAddEdge(dig01, 3, 4);
  printf("The second graph:\n");
  GraphDisplay(dig01);
  printf("Remove edge (1,2)\n");
  GraphRemoveEdge(dig01, 1, 2);
  GraphDisplay(dig01);

  Graph* g03 = GraphCreate(6, 0, 1);
  GraphAddWeightedEdge(g03, 1, 2, 3);
  GraphAddWeightedEdge(g03, 1, 4, 5);
  GraphAddWeightedEdge(g03, 3, 4, 10);
  printf("The third graph:\n");
  GraphDisplay(g03);
  printf("Remove edge (1,2)\n");
  GraphRemoveEdge(g03, 1, 2);
  GraphDisplay(g03);

  GraphDestroy(&g01);
  GraphDestroy(&dig01);
  GraphDestroy(&g03);
  GraphDestroy(&g01_copy);


  FILE* file = fopen("GRAPHS/SWtinyG.txt", "r");

  Graph* g04 = GraphFromFile(file);
  GraphDisplay(g04);
  printf("Check invariants: ");
  printf(GraphCheckInvariants(g04) ? "true\n" : "false\n");

  FILE* file2 = fopen("GRAPHS/SWtinyDG.txt", "r");

  Graph* g05 = GraphFromFile(file2);
  GraphDisplay(g05);
  printf("Check invariants: ");
  printf(GraphCheckInvariants(g05) ? "true\n" : "false\n");

  FILE* file3 = fopen("GRAPHS/SWmediumEWD.txt", "r");

  Graph* g06 = GraphFromFile(file3);
  printf("The graph from file SWmediumEWD.txt:\n");
  GraphDisplay(g06);
  printf("Check invariants: ");
  printf(GraphCheckInvariants(g06) ? "true\n" : "false\n");

  GraphDestroy(&g04);
  GraphDestroy(&g05);
  GraphDestroy(&g06);
  fclose(file);
  fclose(file2);
  fclose(file3);

  return 0;
}