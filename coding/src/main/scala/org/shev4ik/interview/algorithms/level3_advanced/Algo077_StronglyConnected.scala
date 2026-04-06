package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Strongly Connected Components - decomposing directed graphs.
 *
 * Key concepts:
 * - SCC: maximal set of vertices where every vertex is reachable from every other
 * - Kosaraju's: two DFS passes (one on reverse graph)
 * - Tarjan's: single DFS with stack and low-link values
 * - Bridges and articulation points
 */
object Algo077_StronglyConnected {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Kosaraju's algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Kosaraju's algorithm to find all SCCs.
   *       1. DFS on original graph, push vertices to stack by finish time.
   *       2. Transpose the graph.
   *       3. DFS on transposed graph in stack order.
   *       Return list of SCCs (each SCC is a list of vertices).
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return list of SCCs
   */
  def kosaraju(n: Int, edges: List[(Int, Int)]): List[List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Tarjan's algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Tarjan's algorithm to find all SCCs.
   *       Uses DFS with disc/low arrays and a stack.
   *       Return list of SCCs.
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return list of SCCs
   */
  def tarjan(n: Int, edges: List[(Int, Int)]): List[List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Condensation graph (DAG of SCCs)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build the condensation graph: contract each SCC into a single node.
   *       The result is a DAG.
   *       Return (scc assignment array, adjacency list of condensed DAG).
   *       sccId(v) = which SCC vertex v belongs to.
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return (sccId array, DAG adjacency list)
   */
  def condensationGraph(n: Int, edges: List[(Int, Int)]): (Array[Int], Map[Int, Set[Int]]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Critical connections (bridges)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find all bridges in an undirected graph.
   *       A bridge is an edge whose removal disconnects the graph.
   *       Use Tarjan's bridge-finding algorithm.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return list of bridges as (u, v) pairs
   */
  def findBridges(n: Int, edges: List[(Int, Int)]): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Articulation points
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find all articulation points in an undirected graph.
   *       An articulation point is a vertex whose removal disconnects the graph.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return set of articulation points
   */
  def articulationPoints(n: Int, edges: List[(Int, Int)]): Set[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: 2-SAT concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve 2-SAT problem using SCC.
   *       Given n boolean variables and clauses of form (x_i OR x_j),
   *       determine if a satisfying assignment exists.
   *       Hint: Build implication graph, find SCCs; if x and !x are in same SCC, unsatisfiable.
   *       Variables: 0..n-1 represent x_0..x_{n-1}.
   *       Negation of variable i is represented as i + n.
   *
   * @param n       number of variables
   * @param clauses list of (literal1, literal2) where literal is var index or var+n for negation
   * @return Option[Array[Boolean]] - satisfying assignment or None
   */
  def solve2SAT(n: Int, clauses: List[(Int, Int)]): Option[Array[Boolean]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Strongly connected component count
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of strongly connected components.
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return number of SCCs
   */
  def sccCount(n: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Bridges in directed graph
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the number of bridges in an undirected graph using
   *       the DFS tree approach with discovery and low values.
   *       Return the count of bridges.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return number of bridges
   */
  def bridgeCount(n: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val edges = List((0,1), (1,2), (2,0), (2,3), (3,4), (4,5), (5,3))

    // Exercise 1
    val sccs1 = kosaraju(6, edges)
    assert(sccs1.size == 2, s"Expected 2 SCCs, got ${sccs1.size}")
    println("Exercise 1 (Kosaraju) passed.")

    // Exercise 2
    val sccs2 = tarjan(6, edges)
    assert(sccs2.size == 2, s"Expected 2 SCCs, got ${sccs2.size}")
    println("Exercise 2 (Tarjan) passed.")

    // Exercise 3
    val (sccIds, dag) = condensationGraph(6, edges)
    assert(sccIds.distinct.length == 2)
    println("Exercise 3 (Condensation) passed.")

    // Exercise 4 (undirected)
    val uEdges4 = List((0,1), (1,2), (2,0), (2,3), (3,4))
    val bridges = findBridges(5, uEdges4)
    assert(bridges.size == 2, s"Expected 2 bridges, got ${bridges.size}")
    println("Exercise 4 (Bridges) passed.")

    // Exercise 5
    val aps = articulationPoints(5, uEdges4)
    assert(aps.contains(2), s"Expected 2 to be articulation point, got $aps")
    assert(aps.contains(3), s"Expected 3 to be articulation point, got $aps")
    println("Exercise 5 (Articulation points) passed.")

    // Exercise 6
    // (x0 OR x1) AND (!x0 OR x1) AND (x0 OR !x1)
    // should be satisfiable with x0=true, x1=true
    val sat = solve2SAT(2, List((0, 1), (2, 1), (0, 3)))
    assert(sat.isDefined, "Expected satisfiable")
    println("Exercise 6 (2-SAT) passed.")

    // Exercise 7
    assert(sccCount(6, edges) == 2)
    println("Exercise 7 (SCC count) passed.")

    // Exercise 8
    assert(bridgeCount(5, uEdges4) == 2)
    println("Exercise 8 (Bridge count) passed.")

    println("All Algo077_StronglyConnected exercises passed!")
  }
}
