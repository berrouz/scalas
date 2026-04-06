package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Bipartite Matching - matching in bipartite graphs.
 *
 * Key concepts:
 * - Bipartite graph: vertices split into two disjoint sets
 * - Maximum matching: largest set of edges with no shared vertices
 * - Hungarian algorithm: weighted bipartite matching in O(n^3)
 * - Konig's theorem: min vertex cover = max matching in bipartite graphs
 */
object Algo076_BipartiteMatch {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Bipartite check
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Check if an undirected graph is bipartite using BFS/DFS coloring.
   *       Return true if the graph is bipartite.
   *
   * @param n     number of vertices
   * @param edges list of undirected edges (u, v)
   * @return true if bipartite
   */
  def isBipartite(n: Int, edges: List[(Int, Int)]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Hungarian algorithm concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the Hungarian algorithm for minimum cost assignment.
   *       Given an n x n cost matrix, find the assignment that minimizes total cost.
   *       Return (minimum cost, assignment) where assignment(i) = j means worker i assigned to job j.
   *
   * @param cost n x n cost matrix
   * @return (min cost, assignment array)
   */
  def hungarianAlgorithm(cost: Array[Array[Int]]): (Int, Array[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Maximum bipartite matching (Kuhn's algorithm)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find maximum bipartite matching using augmenting paths (Kuhn's algorithm).
   *       Left vertices: 0..leftSize-1, Right vertices: 0..rightSize-1.
   *       Return the matching as a Map[leftVertex -> rightVertex].
   *
   * @param leftSize  number of left vertices
   * @param rightSize number of right vertices
   * @param adj       adj(leftV) = list of right vertices it can match with
   * @return Map of matched pairs
   */
  def maxMatching(leftSize: Int, rightSize: Int, adj: Map[Int, List[Int]]): Map[Int, Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Hopcroft-Karp concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Hopcroft-Karp algorithm for maximum bipartite matching.
   *       Uses BFS to find shortest augmenting paths, then DFS to augment along them.
   *       Time: O(E * sqrt(V)).
   *       Return the size of maximum matching.
   *
   * @param leftSize  number of left vertices
   * @param rightSize number of right vertices
   * @param adj       adjacency list for left vertices
   * @return size of maximum matching
   */
  def hopcroftKarp(leftSize: Int, rightSize: Int, adj: Map[Int, List[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Stable matching concept (Gale-Shapley)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the Gale-Shapley algorithm for stable matching.
   *       n proposers and n responders. Each has a preference list.
   *       Return a stable matching as array where result(proposer) = responder.
   *
   * @param n          number of participants on each side
   * @param proposerPrefs proposerPrefs(i) = preference list for proposer i (most preferred first)
   * @param responderPrefs responderPrefs(j) = preference list for responder j
   * @return stable matching array
   */
  def stableMatching(n: Int, proposerPrefs: Array[Array[Int]], responderPrefs: Array[Array[Int]]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Assignment problem (min cost matching)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve the assignment problem: n workers, n jobs, cost(i)(j) = cost
   *       of assigning worker i to job j. Minimize total cost.
   *       Use the Hungarian algorithm or any approach.
   *       Return the minimum total cost.
   *
   * @param cost n x n cost matrix
   * @return minimum total assignment cost
   */
  def minCostAssignment(cost: Array[Array[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Weighted bipartite matching (max weight)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find maximum weight matching in a weighted bipartite graph.
   *       Not all pairs need to be matched; maximize the total weight of matched pairs.
   *       Hint: Negate weights and use Hungarian, or adapt the algorithm.
   *
   * @param leftSize  number of left vertices
   * @param rightSize number of right vertices
   * @param weights   list of (left, right, weight)
   * @return maximum total weight of matching
   */
  def maxWeightMatching(leftSize: Int, rightSize: Int, weights: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Minimum vertex cover (Konig's theorem)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find a minimum vertex cover in a bipartite graph.
   *       By Konig's theorem, min vertex cover = max matching size.
   *       Return the actual set of vertices in the cover.
   *       Hint: After finding max matching, use alternating path analysis.
   *
   * @param leftSize  number of left vertices
   * @param rightSize number of right vertices
   * @param adj       adjacency list
   * @return set of vertices in the minimum vertex cover
   *         (left vertices as (0, v), right vertices as (1, v))
   */
  def minVertexCover(leftSize: Int, rightSize: Int, adj: Map[Int, List[Int]]): Set[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(isBipartite(4, List((0, 1), (1, 2), (2, 3), (3, 0))))
    assert(!isBipartite(3, List((0, 1), (1, 2), (2, 0))))
    println("Exercise 1 (Bipartite check) passed.")

    // Exercise 2
    val cost2 = Array(
      Array(3, 1, 2),
      Array(2, 3, 1),
      Array(1, 2, 3)
    )
    val (minCost2, assign2) = hungarianAlgorithm(cost2)
    assert(minCost2 == 3, s"Expected 3, got $minCost2")
    println("Exercise 2 (Hungarian) passed.")

    // Exercise 3
    val adj3 = Map(0 -> List(0, 1), 1 -> List(0, 2), 2 -> List(1))
    val m3 = maxMatching(3, 3, adj3)
    assert(m3.size == 3, s"Expected matching of size 3, got ${m3.size}")
    println("Exercise 3 (Max matching) passed.")

    // Exercise 4
    val hk4 = hopcroftKarp(3, 3, adj3)
    assert(hk4 == 3, s"Expected 3, got $hk4")
    println("Exercise 4 (Hopcroft-Karp) passed.")

    // Exercise 5
    val pp = Array(Array(0, 1, 2), Array(1, 0, 2), Array(0, 1, 2))
    val rp = Array(Array(1, 0, 2), Array(0, 1, 2), Array(0, 1, 2))
    val sm = stableMatching(3, pp, rp)
    assert(sm.length == 3)
    assert(sm.toSet.size == 3) // all different
    println("Exercise 5 (Stable matching) passed.")

    // Exercise 6
    val mc6 = minCostAssignment(cost2)
    assert(mc6 == 3)
    println("Exercise 6 (Assignment problem) passed.")

    // Exercise 7
    val mw7 = maxWeightMatching(2, 2, List((0, 0, 5), (0, 1, 3), (1, 0, 4), (1, 1, 6)))
    assert(mw7 == 11, s"Expected 11, got $mw7") // 0->0(5), 1->1(6)
    println("Exercise 7 (Max weight matching) passed.")

    // Exercise 8
    val adj8 = Map(0 -> List(0, 1), 1 -> List(0))
    val cover = minVertexCover(2, 2, adj8)
    assert(cover.size == 2, s"Expected 2, got ${cover.size}")
    println("Exercise 8 (Min vertex cover) passed.")

    println("All Algo076_BipartiteMatch exercises passed!")
  }
}
