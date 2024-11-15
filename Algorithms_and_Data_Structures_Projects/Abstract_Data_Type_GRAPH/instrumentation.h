/// A generic instrumentation module.
///
/// João Manuel Rodrigues, AED, 2023
/// Code for cpu_time() by
/// Tomás Oliveira e Silva, AED, October 2021
///
/// Use as follows:
///
/// // Name the counters you're going to use: 
/// InstrName[0] = "memops";
/// InstrName[1] = "adds";
/// InstrCalibrate();  // Call once, to measure CTU
/// ...
/// InstrReset();  // reset to zero
/// for (...) {
///   InstrCount[0] += 3;  // to count array acesses
///   InstrCount[1] += 1;  // to count addition
///   a[k] = a[i] + a[j];
/// }
/// InstrPrint();  // to show time and counters

#ifndef INSTRUMENTATION_H
#define INSTRUMENTATION_H

/// Cpu time in seconds
double cpu_time(void) ; ///

/// Ten counters should be more than enough
#define NUMCOUNTERS 10

/// Array of operation counters:
extern unsigned long InstrCount[NUMCOUNTERS];  ///extern

// Macros to simplify accessing instrumentation counters:
#define REMOVE_EDGE_OPS InstrCount[0]
#define COPY_GRAPH_OPS InstrCount[1]
#define OUTER_LOOP_ITER InstrCount[2]
#define INNER_LOOP_ITER InstrCount[3]
#define DFS_COMPS InstrCount[4]
#define ADJACENTS_OPS InstrCount[5]
#define SORTING_OPS InstrCount[6]
#define BFS_OPS InstrCount[7]
#define QUEUE_ENQUEUE_OPS InstrCount[8]
#define QUEUE_DEQUEUE_OPS InstrCount[9]

/// Array of names for the counters:
extern char* InstrName[NUMCOUNTERS];  ///extern

/// Cpu_time read on previous reset (~seconds)
extern double InstrTime;  ///extern

/// Calibrated Time Unit (in seconds, initially 1s)
extern double InstrCTU;  ///extern

/// Find the Calibrated Time Unit (CTU).
/// Run and time a loop of basic memory and arithmetic operations to set
/// a reasonably cpu-independent time unit.
void InstrCalibrate(void) ;

/// Reset counters to zero and store cpu_time.
void InstrReset(void) ;

void InstrPrint(void) ;

#endif

