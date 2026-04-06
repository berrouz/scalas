package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Centroid Decomposition - divide and conquer on trees.
 *
 * Key concepts:
 * - Centroid: vertex whose removal splits tree into components of size <= n/2
 * - Centroid decomposition tree has O(log n) height
 * - Used for distance queries, path counting, nearest marked node
 */
object Algo095_CentroidDecomp {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Find centroid
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the centroid of a tree (or subtree defined by removed array).
   *       Centroid = vertex v where all subtrees after removing v have size <= n/2.
   *       Steps: compute subtree sizes, find vertex where max component size <= n/2.
   *
   * @param n       number of nodes
   * @param adj     adjacency list
   * @param removed which nodes are already removed
   * @param start   starting node for size computation
   * @return centroid vertex
   */
  def findCentroid(n: Int, adj: Map[Int, List[Int]], removed: Array[Boolean], start: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Centroid decomposition tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build the centroid decomposition tree.
   *       1. Find centroid c of current tree
   *       2. Remove c, recursively decompose each subtree
   *       3. c becomes parent of all sub-centroids in the decomposition tree
   *       Return the parent array of the centroid decomposition tree.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @return parent array of centroid decomposition tree (-1 for root)
   */
  def centroidDecomposition(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Distance queries via centroid decomposition
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Using centroid decomposition, answer distance queries efficiently.
   *       Preprocess: for each centroid c, store distances from c to all nodes
   *       in its subtree (in the original tree).
   *       Query dist(u, v): find LCA in centroid tree, use stored distances.
   *
   * @param n     number of nodes
   * @param edges tree edges (unweighted)
   * @return distance query function: (u, v) => distance
   */
  def centroidDistanceQuery(n: Int, edges: List[(Int, Int)]): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Count pairs with distance exactly k
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of pairs of nodes at distance exactly k.
   *       For each centroid, count pairs whose path passes through it.
   *       Collect distances to centroid, count pairs summing to k.
   *       Subtract pairs within same subtree to avoid double counting.
   *
   * @param n     number of nodes
   * @param edges tree edges (unweighted)
   * @param k     target distance
   * @return number of pairs at distance k
   */
  def countPairsDistK(n: Int, edges: List[(Int, Int)], k: Int): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Path with constraint via centroid decomposition
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a weighted tree, find the number of paths where
   *       the sum of edge weights is <= maxWeight.
   *       Use centroid decomposition: for each centroid, collect path weights,
   *       count valid pairs.
   *
   * @param n         number of nodes
   * @param edges     list of (u, v, weight)
   * @param maxWeight maximum path weight
   * @return number of valid paths
   */
  def countPathsWithinWeight(n: Int, edges: List[(Int, Int, Int)], maxWeight: Int): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Centroid + BIT (dynamic distance counting)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support dynamic operations on centroid decomposition:
   *       - mark(v): mark node v
   *       - query(v): find distance to nearest marked node from v
   *       Use centroid decomposition + BIT or simple array at each centroid level.
   *       Initially no nodes are marked.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @return (mark, queryNearest) functions
   */
  def dynamicCentroid(n: Int, edges: List[(Int, Int)]): (Int => Unit, Int => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: XOR path queries
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a tree where each edge has a value, find the maximum XOR
   *       of any path from node u to some other node.
   *       Use centroid decomposition: for each centroid, collect XOR distances,
   *       use a trie to find maximum XOR pair.
   *       For simplicity, find the path with maximum XOR value in the entire tree.
   *
   * @param n     number of nodes
   * @param edges list of (u, v, value)
   * @return maximum XOR of any path
   */
  def maxXORPath(n: Int, edges: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Closest marked node
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a tree, support two operations:
   *       - mark(v): mark node v as special
   *       - closest(v): find the distance to the closest marked node from v
   *       Initially, node 0 is marked.
   *       Use centroid decomposition for efficient queries.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @return (mark, closest) functions
   */
  def closestMarkedNode(n: Int, edges: List[(Int, Int)]): (Int => Unit, Int => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    //       0
    //      /|\
    //     1 2 3
    //    /|
    //   4 5
    val edges = List((0,1),(0,2),(0,3),(1,4),(1,5))

    // Exercise 1
    val adj = edges.flatMap { case (u, v) => List(u -> v, v -> u) }
      .groupBy(_._1).map { case (k, vs) => k -> vs.map(_._2) }
      .withDefaultValue(Nil)
    val centroid = findCentroid(6, adj, Array.fill(6)(false), 0)
    assert(centroid == 0 || centroid == 1) // either could be centroid depending on tie-breaking
    println("Exercise 1 (Find centroid) passed.")

    // Exercise 2
    val cdParent = centroidDecomposition(6, edges)
    assert(cdParent.count(_ == -1) == 1) // exactly one root
    println("Exercise 2 (Centroid decomposition) passed.")

    // Exercise 3
    val distQ = centroidDistanceQuery(6, edges)
    assert(distQ(4, 5) == 2) // 4->1->5
    assert(distQ(4, 2) == 3) // 4->1->0->2
    println("Exercise 3 (Distance queries) passed.")

    // Exercise 4
    val pairs = countPairsDistK(6, edges, 2)
    assert(pairs >= 3) // several pairs at distance 2
    println("Exercise 4 (Count pairs distance k) passed.")

    // Exercise 5
    val wEdges = List((0,1,2),(0,2,3),(0,3,4),(1,4,1),(1,5,5))
    val cp5 = countPathsWithinWeight(6, wEdges, 5)
    assert(cp5 > 0)
    println("Exercise 5 (Paths within weight) passed.")

    // Exercise 6
    val (mark6, qNearest6) = dynamicCentroid(6, edges)
    mark6(0)
    assert(qNearest6(4) == 2) // 4->1->0
    mark6(1)
    assert(qNearest6(4) == 1) // 4->1
    println("Exercise 6 (Dynamic centroid) passed.")

    // Exercise 7
    val xorEdges = List((0,1,3),(0,2,5),(1,3,7),(1,4,2))
    val mxor = maxXORPath(5, xorEdges)
    assert(mxor > 0)
    println("Exercise 7 (XOR path queries) passed.")

    // Exercise 8
    val (mark8, closest8) = closestMarkedNode(6, edges)
    // node 0 is initially marked
    assert(closest8(0) == 0)
    assert(closest8(4) == 2) // 4->1->0
    mark8(1)
    assert(closest8(4) == 1) // 4->1
    println("Exercise 8 (Closest marked node) passed.")

    println("All Algo095_CentroidDecomp exercises passed!")
  }
}
