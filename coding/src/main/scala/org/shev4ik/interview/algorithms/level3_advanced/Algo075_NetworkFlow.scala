package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Network Flow - Ford-Fulkerson method, max-flow min-cut theorem.
 *
 * Key concepts:
 * - Augmenting paths in residual graph
 * - Edmonds-Karp (BFS-based Ford-Fulkerson): O(V * E^2)
 * - Max-flow = Min-cut (duality)
 */
object Algo075_NetworkFlow {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Ford-Fulkerson (BFS-based Edmonds-Karp)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the Edmonds-Karp algorithm (BFS-based Ford-Fulkerson).
   *       Given a capacity matrix, find the maximum flow from source to sink.
   *
   * @param capacity capacity(u)(v) = capacity of edge u -> v
   * @param source   source vertex
   * @param sink     sink vertex
   * @return maximum flow value
   */
  def edmondsKarp(capacity: Array[Array[Int]], source: Int, sink: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Max flow min cut
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: After computing max flow, find the minimum cut.
   *       The min cut is the set of edges (u, v) where u is reachable from source
   *       in the residual graph and v is not.
   *       Return (maxFlow, list of cut edges as (u, v)).
   *
   * @param capacity capacity matrix
   * @param source   source vertex
   * @param sink     sink vertex
   * @return (max flow, list of min-cut edges)
   */
  def maxFlowMinCut(capacity: Array[Array[Int]], source: Int, sink: Int): (Int, List[(Int, Int)]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Bipartite matching via flow
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve maximum bipartite matching using max flow.
   *       Left nodes: 0..leftSize-1, Right nodes: leftSize..leftSize+rightSize-1
   *       Add source connected to all left nodes, sink connected from all right nodes.
   *       Return the size of maximum matching.
   *
   * @param leftSize  number of left nodes
   * @param rightSize number of right nodes
   * @param edges     list of (left, right) edges (0-indexed within each side)
   * @return maximum matching size
   */
  def bipartiteMatchingFlow(leftSize: Int, rightSize: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Flow network modeling
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Model and solve: given a grid where 1 = open, 0 = blocked,
   *       find the maximum number of non-overlapping paths from top row to bottom row.
   *       Each cell can be used at most once.
   *       Hint: Split each cell into in/out nodes with capacity 1.
   *
   * @param grid 2D grid of 0s and 1s
   * @return max number of non-overlapping top-to-bottom paths
   */
  def maxNonOverlappingPaths(grid: Array[Array[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Residual graph
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a capacity matrix and a flow matrix, compute the residual graph.
   *       residual(u)(v) = capacity(u)(v) - flow(u)(v) + flow(v)(u)
   *       (forward residual capacity + backward residual capacity)
   *
   * @param capacity capacity matrix
   * @param flow     current flow matrix
   * @return residual capacity matrix
   */
  def residualGraph(capacity: Array[Array[Int]], flow: Array[Array[Int]]): Array[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Find augmenting path (BFS)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find an augmenting path from source to sink in the residual graph
   *       using BFS. Return the path and the bottleneck capacity.
   *       Return None if no augmenting path exists.
   *
   * @param residual residual capacity matrix
   * @param source   source vertex
   * @param sink     sink vertex
   * @return Option[(path as list of vertices, bottleneck capacity)]
   */
  def findAugmentingPath(residual: Array[Array[Int]], source: Int, sink: Int): Option[(List[Int], Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Maximum students in seats
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a classroom grid where '.' is a seat and '#' is broken,
   *       students can see neighbors to their left, right, upper-left, upper-right.
   *       Place maximum students such that no one can see another's paper.
   *       Model as max independent set on bipartite graph (checkerboard pattern).
   *       Return max students.
   *
   * @param seats grid of '.' and '#'
   * @return maximum number of students
   */
  def maxStudents(seats: Array[Array[Char]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Project selection (max weight closure)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given projects with profits (positive or negative) and dependencies,
   *       select a subset of projects to maximize total profit.
   *       If you select project A that depends on B, you must also select B.
   *       Model as max-weight closure problem using min-cut.
   *       Return maximum profit.
   *
   * @param profits profit for each project (can be negative)
   * @param deps    list of (A, B) meaning A depends on B
   * @return maximum achievable profit
   */
  def maxProfitProjects(profits: Array[Int], deps: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val cap1 = Array(
      Array(0, 16, 13, 0, 0, 0),
      Array(0, 0, 10, 12, 0, 0),
      Array(0, 4, 0, 0, 14, 0),
      Array(0, 0, 9, 0, 0, 20),
      Array(0, 0, 0, 7, 0, 4),
      Array(0, 0, 0, 0, 0, 0)
    )
    assert(edmondsKarp(cap1, 0, 5) == 23)
    println("Exercise 1 (Edmonds-Karp) passed.")

    // Exercise 2
    val (flow2, cuts2) = maxFlowMinCut(cap1, 0, 5)
    assert(flow2 == 23)
    assert(cuts2.nonEmpty)
    println("Exercise 2 (Max flow min cut) passed.")

    // Exercise 3
    val bm3 = bipartiteMatchingFlow(3, 3, List((0, 0), (0, 1), (1, 0), (1, 2), (2, 1)))
    assert(bm3 == 3, s"Expected 3, got $bm3")
    println("Exercise 3 (Bipartite matching) passed.")

    // Exercise 4
    val grid4 = Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1)
    )
    val paths4 = maxNonOverlappingPaths(grid4)
    assert(paths4 == 2, s"Expected 2, got $paths4")
    println("Exercise 4 (Non-overlapping paths) passed.")

    // Exercise 5
    val cap5 = Array(Array(0, 10), Array(0, 0))
    val flow5 = Array(Array(0, 7), Array(0, 0))
    val res5 = residualGraph(cap5, flow5)
    assert(res5(0)(1) == 3)
    assert(res5(1)(0) == 7)
    println("Exercise 5 (Residual graph) passed.")

    // Exercise 6
    val resG = Array(Array(0, 5, 0), Array(0, 0, 3), Array(0, 0, 0))
    val aug6 = findAugmentingPath(resG, 0, 2)
    assert(aug6.isDefined)
    assert(aug6.get._2 == 3)
    println("Exercise 6 (Augmenting path) passed.")

    // Exercise 7
    val seats7 = Array(
      Array('.', '#', '.'),
      Array('.', '.', '.'),
      Array('#', '.', '#')
    )
    val ms7 = maxStudents(seats7)
    assert(ms7 >= 4, s"Expected >= 4, got $ms7")
    println("Exercise 7 (Max students) passed.")

    // Exercise 8
    val profits8 = Array(5, -3, 8, -2)
    val deps8 = List((0, 1), (2, 3))
    val mp8 = maxProfitProjects(profits8, deps8)
    assert(mp8 == 8, s"Expected 8, got $mp8")
    println("Exercise 8 (Project selection) passed.")

    println("All Algo075_NetworkFlow exercises passed!")
  }
}
