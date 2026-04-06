package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Floyd-Warshall Algorithm - all-pairs shortest paths.
 *
 * Key concepts:
 * - Dynamic programming over intermediate vertices
 * - Time: O(V^3), Space: O(V^2)
 * - Can detect negative cycles
 * - Works with negative edges
 */
object Algo073_FloydWarshall {

  val INF: Double = Double.MaxValue / 2 // avoid overflow on addition

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: All pairs shortest path
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Floyd-Warshall to compute shortest paths between all pairs.
   *       dist(i)(j) = weight of edge from i to j, or INF if no edge.
   *       dist(i)(i) = 0 for all i.
   *       Return the updated distance matrix.
   *
   * @param dist initial distance matrix (will be modified conceptually; return new one)
   * @return all-pairs shortest distance matrix
   */
  def floydWarshall(dist: Array[Array[Double]]): Array[Array[Double]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Detect negative cycles
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: After running Floyd-Warshall, detect if there is a negative cycle.
   *       A negative cycle exists if dist(i)(i) < 0 for any vertex i.
   *
   * @param dist initial distance matrix
   * @return true if a negative cycle exists
   */
  def hasNegativeCycle(dist: Array[Array[Double]]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Transitive closure
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the transitive closure of a directed graph.
   *       reachable(i)(j) = true if there is a path from i to j.
   *       Use a Floyd-Warshall-like approach with Boolean OR instead of min.
   *
   * @param adj adjacency matrix (true if direct edge exists)
   * @return transitive closure matrix
   */
  def transitiveClosure(adj: Array[Array[Boolean]]): Array[Array[Boolean]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Shortest path matrix from edge list
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given n vertices and a list of weighted directed edges,
   *       build the distance matrix and run Floyd-Warshall.
   *       Return the all-pairs shortest path matrix.
   *
   * @param n     number of vertices
   * @param edges list of (from, to, weight)
   * @return all-pairs shortest distance matrix
   */
  def shortestPathMatrix(n: Int, edges: List[(Int, Int, Double)]): Array[Array[Double]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Path reconstruction
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Floyd-Warshall with path reconstruction.
   *       Maintain a `next` matrix where next(i)(j) = first vertex on shortest path from i to j.
   *       Return (dist, next) and a function to reconstruct the path.
   *
   * @param n     number of vertices
   * @param edges list of (from, to, weight)
   * @return (distance matrix, path as list of vertices from src to dst)
   */
  def floydWithPath(n: Int, edges: List[(Int, Int, Double)]): (Array[Array[Double]], (Int, Int) => Option[List[Int]]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: City with smallest number of reachable neighbors at threshold
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given n cities and weighted edges, find the city with the smallest number
   *       of other cities reachable within `threshold` distance.
   *       If tied, return the city with the largest index.
   *
   * @param n         number of cities
   * @param edges     list of (from, to, weight) -- undirected
   * @param threshold max distance
   * @return city index with fewest reachable neighbors
   */
  def cityWithFewestReachable(n: Int, edges: List[(Int, Int, Int)], threshold: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Min cost to reach every city from every city
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a weighted directed graph, compute the total minimum cost to
   *       travel from every city to every other city. Sum of all shortest paths.
   *       Return -1 if any pair is unreachable.
   *
   * @param n     number of cities
   * @param edges list of (from, to, weight)
   * @return total sum of all shortest paths, or -1 if not fully connected
   */
  def totalMinCost(n: Int, edges: List[(Int, Int, Double)]): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Graph connectivity check
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Using Floyd-Warshall / transitive closure, determine if the directed
   *       graph is strongly connected (every vertex can reach every other vertex).
   *
   * @param n     number of vertices
   * @param edges list of (from, to)
   * @return true if the graph is strongly connected
   */
  def isStronglyConnected(n: Int, edges: List[(Int, Int)]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val d = Array(
      Array(0.0,   3.0, INF, 7.0),
      Array(INF,   0.0, 2.0, INF),
      Array(INF,   INF, 0.0, 1.0),
      Array(6.0,   INF, INF, 0.0)
    )
    val result1 = floydWarshall(d)
    assert(result1(0)(2) == 5.0, s"Expected 5.0, got ${result1(0)(2)}")
    assert(result1(0)(3) == 6.0, s"Expected 6.0, got ${result1(0)(3)}")
    println("Exercise 1 (Floyd-Warshall) passed.")

    // Exercise 2
    assert(!hasNegativeCycle(d))
    val dNeg = Array(
      Array(0.0, 1.0),
      Array(-2.0, 0.0)
    )
    assert(hasNegativeCycle(dNeg))
    println("Exercise 2 (Negative cycle) passed.")

    // Exercise 3
    val adj3 = Array(
      Array(false, true,  false),
      Array(false, false, true),
      Array(false, false, false)
    )
    val tc = transitiveClosure(adj3)
    assert(tc(0)(2))
    assert(!tc(2)(0))
    println("Exercise 3 (Transitive closure) passed.")

    // Exercise 4
    val edges4 = List((0, 1, 3.0), (1, 2, 2.0), (2, 3, 1.0), (0, 3, 7.0), (3, 0, 6.0))
    val mat4 = shortestPathMatrix(4, edges4)
    assert(mat4(0)(2) == 5.0)
    println("Exercise 4 (Shortest path matrix) passed.")

    // Exercise 5
    val (distM, getPath) = floydWithPath(4, edges4)
    val path = getPath(0, 3)
    assert(path.contains(List(0, 1, 2, 3)), s"Expected Some(List(0,1,2,3)), got $path")
    println("Exercise 5 (Path reconstruction) passed.")

    // Exercise 6
    val edges6 = List((0, 1, 3), (1, 2, 1), (1, 3, 4), (2, 3, 1))
    assert(cityWithFewestReachable(4, edges6, 4) == 3)
    println("Exercise 6 (Fewest reachable) passed.")

    // Exercise 7
    val edges7 = List((0, 1, 1.0), (1, 0, 1.0), (0, 2, 2.0), (2, 0, 2.0), (1, 2, 1.0), (2, 1, 1.0))
    val total = totalMinCost(3, edges7)
    // 0->1=1, 0->2=2, 1->0=1, 1->2=1, 2->0=2, 2->1=1 => total=8
    assert(total == 8.0, s"Expected 8.0, got $total")
    println("Exercise 7 (Total min cost) passed.")

    // Exercise 8
    val edges8 = List((0, 1), (1, 2), (2, 0))
    assert(isStronglyConnected(3, edges8))
    val edges8b = List((0, 1), (1, 2))
    assert(!isStronglyConnected(3, edges8b))
    println("Exercise 8 (Strongly connected) passed.")

    println("All Algo073_FloydWarshall exercises passed!")
  }
}
