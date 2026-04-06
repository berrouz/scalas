package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Advanced LCA (Lowest Common Ancestor) techniques.
 *
 * Key concepts:
 * - Binary lifting: O(n log n) preprocessing, O(log n) query
 * - Euler tour + RMQ: O(n) preprocessing, O(1) query
 * - Applications: distance queries, kth ancestor, weighted paths
 */
object Algo093_LCAAdvanced {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Binary lifting
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement LCA using binary lifting.
   *       up(v)(k) = 2^k-th ancestor of v.
   *       Preprocess in O(n log n), query in O(log n).
   *       Return a query function.
   *
   * @param n     number of nodes
   * @param edges tree edges (undirected)
   * @param root  root node
   * @return LCA query function: (u, v) => lca
   */
  def binaryLiftingLCA(n: Int, edges: List[(Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Euler tour + RMQ
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute LCA using Euler tour and Range Minimum Query.
   *       1. DFS to get Euler tour and depths
   *       2. LCA(u,v) = vertex with min depth between first occurrences of u and v
   *       3. Use sparse table for O(1) RMQ
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root node
   * @return LCA query function
   */
  def eulerTourLCA(n: Int, edges: List[(Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: LCA O(1) with sparse table
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Combine Euler tour + sparse table for O(1) LCA queries
   *       after O(n log n) preprocessing.
   *       Build everything and return a query function.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root
   * @return (query function, depth array)
   */
  def lcaO1(n: Int, edges: List[(Int, Int)], root: Int): ((Int, Int) => Int, Array[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Weighted LCA (max edge weight on path)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a weighted tree, answer queries about the maximum edge weight
   *       on the path between two nodes. Use binary lifting with max weight tracking.
   *       maxWeight(v)(k) = max edge weight on path from v to its 2^k-th ancestor.
   *
   * @param n     number of nodes
   * @param edges list of (u, v, weight)
   * @param root  root node
   * @return query function: (u, v) => max edge weight on path
   */
  def maxWeightOnPath(n: Int, edges: List[(Int, Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: LCA for batch queries
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Answer a batch of LCA queries efficiently.
   *       Preprocess once, then answer all queries.
   *       Return list of LCA results.
   *
   * @param n       number of nodes
   * @param edges   tree edges
   * @param root    root
   * @param queries list of (u, v) queries
   * @return list of LCA answers
   */
  def batchLCA(n: Int, edges: List[(Int, Int)], root: Int, queries: List[(Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Distance between nodes
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the distance (number of edges) between two nodes in a tree.
   *       dist(u, v) = depth(u) + depth(v) - 2 * depth(lca(u, v))
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root
   * @return distance query function: (u, v) => distance
   */
  def distanceQuery(n: Int, edges: List[(Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Kth ancestor
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the k-th ancestor of a node using binary lifting.
   *       Decompose k into binary and jump accordingly.
   *       Return -1 if the k-th ancestor doesn't exist.
   *
   * @param n     number of nodes
   * @param parent parent array (parent(root) = -1)
   * @return kthAncestor function: (node, k) => k-th ancestor or -1
   */
  def kthAncestor(n: Int, parent: Array[Int]): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: LCA in DAG concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the LCA in a DAG (Directed Acyclic Graph).
   *       LCA in DAG: deepest node that is an ancestor of both u and v.
   *       A node a is an ancestor of b if there's a path from a to b.
   *       Use BFS/DFS to find all ancestors of u and v, find deepest common one.
   *
   * @param n     number of nodes
   * @param edges directed edges (parent -> child)
   * @param roots set of root nodes (nodes with no parents)
   * @param u     first node
   * @param v     second node
   * @return LCA node, or -1 if no common ancestor
   */
  def lcaInDAG(n: Int, edges: List[(Int, Int)], roots: Set[Int], u: Int, v: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    //       0
    //      / \
    //     1   2
    //    / \
    //   3   4
    val edges = List((0,1), (0,2), (1,3), (1,4))

    // Exercise 1
    val lca1 = binaryLiftingLCA(5, edges, 0)
    assert(lca1(3, 4) == 1)
    assert(lca1(3, 2) == 0)
    assert(lca1(1, 4) == 1)
    println("Exercise 1 (Binary lifting) passed.")

    // Exercise 2
    val lca2 = eulerTourLCA(5, edges, 0)
    assert(lca2(3, 4) == 1)
    assert(lca2(3, 2) == 0)
    println("Exercise 2 (Euler tour LCA) passed.")

    // Exercise 3
    val (lca3, depth3) = lcaO1(5, edges, 0)
    assert(lca3(3, 4) == 1)
    assert(depth3(3) == 2)
    println("Exercise 3 (LCA O(1)) passed.")

    // Exercise 4
    val wEdges = List((0, 1, 3), (0, 2, 5), (1, 3, 2), (1, 4, 7))
    val mw = maxWeightOnPath(5, wEdges, 0)
    assert(mw(3, 4) == 7) // 3->1->4, max(2, 7) = 7
    assert(mw(3, 2) == 5) // 3->1->0->2, max(2, 3, 5) = 5
    println("Exercise 4 (Weighted LCA) passed.")

    // Exercise 5
    val answers5 = batchLCA(5, edges, 0, List((3, 4), (3, 2), (1, 2)))
    assert(answers5 == List(1, 0, 0))
    println("Exercise 5 (Batch LCA) passed.")

    // Exercise 6
    val dist6 = distanceQuery(5, edges, 0)
    assert(dist6(3, 4) == 2)
    assert(dist6(3, 2) == 3)
    assert(dist6(0, 0) == 0)
    println("Exercise 6 (Distance query) passed.")

    // Exercise 7
    val parent7 = Array(-1, 0, 0, 1, 1) // root=0
    val kAnc = kthAncestor(5, parent7)
    assert(kAnc(3, 1) == 1)
    assert(kAnc(3, 2) == 0)
    assert(kAnc(3, 3) == -1)
    println("Exercise 7 (Kth ancestor) passed.")

    // Exercise 8
    val dagEdges = List((0, 1), (0, 2), (1, 3), (2, 3))
    val lcaDag = lcaInDAG(4, dagEdges, Set(0), 1, 2)
    assert(lcaDag == 0)
    println("Exercise 8 (LCA in DAG) passed.")

    println("All Algo093_LCAAdvanced exercises passed!")
  }
}
