package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Minimum Spanning Tree algorithms.
 *
 * Key concepts:
 * - Prim's: greedy, grow tree from a vertex using min-heap
 * - Kruskal's: greedy, sort edges and use Union-Find
 * - MST properties: cut property, cycle property
 */
object Algo074_MST {

  case class Edge(u: Int, v: Int, weight: Int)

  /** Union-Find (Disjoint Set Union) with path compression and union by rank */
  class UnionFind(n: Int) {
    private val parent = Array.tabulate(n)(identity)
    private val rank = Array.fill(n)(0)

    def find(x: Int): Int = {
      if (parent(x) != x) parent(x) = find(parent(x))
      parent(x)
    }

    def union(x: Int, y: Int): Boolean = {
      val px = find(x); val py = find(y)
      if (px == py) return false
      if (rank(px) < rank(py)) parent(px) = py
      else if (rank(px) > rank(py)) parent(py) = px
      else { parent(py) = px; rank(px) += 1 }
      true
    }
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Prim's algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Prim's algorithm to find the MST weight.
   *       Start from vertex 0, use a priority queue.
   *       Return the total weight of the MST, or -1 if graph is not connected.
   *
   * @param n     number of vertices
   * @param edges list of undirected weighted edges
   * @return total MST weight or -1
   */
  def primMST(n: Int, edges: List[Edge]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Kruskal's algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Kruskal's algorithm using Union-Find.
   *       Return the list of edges in the MST.
   *
   * @param n     number of vertices
   * @param edges list of undirected weighted edges
   * @return list of MST edges
   */
  def kruskalMST(n: Int, edges: List[Edge]): List[Edge] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Min cost to connect all cities
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given n cities and connection costs, find the minimum cost to connect
   *       all cities. Each connection is bidirectional.
   *       Return -1 if it's impossible to connect all cities.
   *
   * @param n           number of cities
   * @param connections list of (city1, city2, cost)
   * @return minimum cost or -1
   */
  def minCostConnectCities(n: Int, connections: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Min cost to supply water to all houses
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: n houses need water. You can build a well at house i for cost wells(i),
   *       or lay a pipe between houses for a cost. Find min cost to supply all houses.
   *       Hint: Add a virtual node 0 connected to each house i with weight wells(i),
   *       then find MST.
   *
   * @param n     number of houses (1-indexed)
   * @param wells cost to build well at each house (0-indexed)
   * @param pipes list of (house1, house2, cost)
   * @return minimum total cost
   */
  def minCostWater(n: Int, wells: Array[Int], pipes: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Critical and pseudo-critical edges in MST
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Classify edges as critical or pseudo-critical for the MST.
   *       Critical: removing it increases MST weight.
   *       Pseudo-critical: can appear in some MST but not all.
   *       Return (criticalIndices, pseudoCriticalIndices).
   *
   * @param n     number of vertices
   * @param edges list of edges with original indices preserved
   * @return (List of critical edge indices, List of pseudo-critical edge indices)
   */
  def criticalAndPseudoCritical(n: Int, edges: List[(Int, Int, Int)]): (List[Int], List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: MST weight
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the MST weight using either Prim's or Kruskal's.
   *       Return None if graph is disconnected.
   *
   * @param n     number of vertices
   * @param edges list of (u, v, weight)
   * @return Option[Int] with MST weight
   */
  def mstWeight(n: Int, edges: List[(Int, Int, Int)]): Option[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Second minimum spanning tree concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the weight of the second minimum spanning tree.
   *       The second MST is the MST with the next-smallest total weight
   *       (it must differ by at least one edge from the first MST).
   *       Return None if no second MST exists.
   *       Hint: For each non-MST edge, try swapping it with the heaviest MST edge on the path.
   *
   * @param n     number of vertices
   * @param edges list of (u, v, weight)
   * @return Option[Int] second MST weight
   */
  def secondMSTWeight(n: Int, edges: List[(Int, Int, Int)]): Option[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Boruvka's algorithm concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Boruvka's algorithm for MST.
   *       In each phase, for each component find the cheapest outgoing edge
   *       and add it. Repeat until one component remains.
   *       Return the total MST weight, or -1 if disconnected.
   *
   * @param n     number of vertices
   * @param edges list of undirected weighted edges
   * @return MST weight or -1
   */
  def boruvkaMST(n: Int, edges: List[Edge]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val edges = List(Edge(0,1,1), Edge(0,2,3), Edge(1,2,2), Edge(1,3,4), Edge(2,3,5))

    // Exercise 1
    val pw = primMST(4, edges)
    assert(pw == 7, s"Expected 7, got $pw")
    println("Exercise 1 (Prim's) passed.")

    // Exercise 2
    val mst2 = kruskalMST(4, edges)
    assert(mst2.map(_.weight).sum == 7)
    println("Exercise 2 (Kruskal's) passed.")

    // Exercise 3
    val conn3 = List((1, 2, 1), (2, 3, 2), (1, 3, 3))
    assert(minCostConnectCities(3, conn3) == 3)
    println("Exercise 3 (Connect cities) passed.")

    // Exercise 4
    val wells4 = Array(1, 2, 2)
    val pipes4 = List((1, 2, 1), (2, 3, 1))
    assert(minCostWater(3, wells4, pipes4) == 3)
    println("Exercise 4 (Water supply) passed.")

    // Exercise 5
    val edges5 = List((0,1,1), (1,2,1), (2,3,2), (0,3,2), (0,2,2))
    val (crit, pseudo) = criticalAndPseudoCritical(4, edges5)
    assert(crit.sorted == List(0, 1), s"Critical: $crit")
    println("Exercise 5 (Critical edges) passed.")

    // Exercise 6
    val w6 = mstWeight(4, List((0,1,1),(1,2,2),(2,3,5),(0,2,3),(1,3,4)))
    assert(w6.contains(7))
    println("Exercise 6 (MST weight) passed.")

    // Exercise 7
    val w7 = secondMSTWeight(4, List((0,1,1),(1,2,2),(2,3,5),(0,2,3),(1,3,4)))
    assert(w7.isDefined)
    println("Exercise 7 (Second MST) passed.")

    // Exercise 8
    val bw = boruvkaMST(4, edges)
    assert(bw == 7, s"Expected 7, got $bw")
    println("Exercise 8 (Boruvka's) passed.")

    println("All Algo074_MST exercises passed!")
  }
}
