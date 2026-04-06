package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Heavy-Light Decomposition - path queries on trees.
 *
 * Key concepts:
 * - Decompose tree into heavy and light chains
 * - Heavy edge: to child with largest subtree
 * - Each root-to-leaf path crosses O(log n) light edges
 * - Combine with segment tree for O(log^2 n) path queries
 */
object Algo094_HeavyLight {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: HLD decomposition
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the Heavy-Light Decomposition of a tree.
   *       Return:
   *       - parent array
   *       - depth array
   *       - subtreeSize array
   *       - chainHead array (head of the chain each node belongs to)
   *       - position array (position of each node in the linear arrangement)
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root node
   * @return (parent, depth, size, chainHead, position)
   */
  def hldDecompose(n: Int, edges: List[(Int, Int)], root: Int): (Array[Int], Array[Int], Array[Int], Array[Int], Array[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Path query with HLD (max on path)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Answer path maximum queries using HLD + segment tree.
   *       Decompose path into O(log n) chains, query segment tree for each.
   *       Return query function.
   *
   * @param n      number of nodes
   * @param edges  tree edges
   * @param values node values
   * @param root   root node
   * @return path max query: (u, v) => max value on path
   */
  def pathMaxQuery(n: Int, edges: List[(Int, Int)], values: Array[Int], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Path update with HLD (add on path)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support path updates (add value to all nodes on path u-v)
   *       and point queries using HLD + segment tree with lazy propagation.
   *       Return (pathUpdate, pointQuery) functions.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root
   * @return (pathUpdate: (u, v, val) => Unit, pointQuery: Int => Long)
   */
  def pathUpdatePointQuery(n: Int, edges: List[(Int, Int)], root: Int): ((Int, Int, Long) => Unit, Int => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Subtree query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Answer subtree sum queries using the HLD linear arrangement.
   *       In the HLD ordering, each subtree occupies a contiguous range.
   *       subtree(v) = [position(v), position(v) + size(v) - 1]
   *       Return (update: (v, val) => Unit, subtreeSum: v => Long)
   *
   * @param n      number of nodes
   * @param edges  tree edges
   * @param values initial node values
   * @param root   root
   * @return (update, subtreeSum)
   */
  def subtreeQuery(n: Int, edges: List[(Int, Int)], values: Array[Long], root: Int): ((Int, Long) => Unit, Int => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: HLD + segment tree (path sum)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Combine HLD with segment tree to answer path sum queries.
   *       Support: updateNode(v, val), pathSum(u, v).
   *
   * @param n      number of nodes
   * @param edges  tree edges
   * @param values initial node values
   * @param root   root
   * @return (updateNode, pathSum) functions
   */
  def hldPathSum(n: Int, edges: List[(Int, Int)], values: Array[Long], root: Int): ((Int, Long) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Chain heads identification
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an HLD decomposition, return the list of chain heads
   *       and the nodes in each chain.
   *
   * @param n         number of nodes
   * @param chainHead array from HLD decomposition
   * @param position  position array from HLD
   * @return Map[chainHead -> sorted list of nodes in chain]
   */
  def getChains(n: Int, chainHead: Array[Int], position: Array[Int]): Map[Int, List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: HLD preprocessing details
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the heavy child for each node.
   *       Heavy child = child with the largest subtree.
   *       Return array where heavyChild(v) = heavy child of v, or -1 if leaf.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @param root  root
   * @return heavy child array
   */
  def computeHeavyChild(n: Int, edges: List[(Int, Int)], root: Int): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Tree path maximum (full solution)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Full HLD solution: given a tree with edge weights,
   *       answer queries for the maximum edge weight on the path u-v.
   *       Place edge weights on the deeper node.
   *
   * @param n     number of nodes
   * @param edges list of (u, v, weight)
   * @param root  root
   * @return query function: (u, v) => max edge weight on path
   */
  def treePathMax(n: Int, edges: List[(Int, Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    //       0
    //      / \
    //     1   2
    //    / \   \
    //   3   4   5
    val edges = List((0,1), (0,2), (1,3), (1,4), (2,5))
    val values = Array(1, 2, 3, 4, 5, 6)

    // Exercise 1
    val (par, dep, sz, ch, pos) = hldDecompose(6, edges, 0)
    assert(par(0) == -1)
    assert(dep(3) == 2)
    assert(sz(0) == 6)
    println("Exercise 1 (HLD decompose) passed.")

    // Exercise 2
    val pmq = pathMaxQuery(6, edges, values, 0)
    assert(pmq(3, 5) == 4 || pmq(3, 5) >= 3) // path 3-1-0-2-5, max of values
    println("Exercise 2 (Path max) passed.")

    // Exercise 3
    val (pUpd, pQry) = pathUpdatePointQuery(6, edges, 0)
    pUpd(3, 5, 10)
    assert(pQry(1) == 10) // node 1 is on path 3->5
    println("Exercise 3 (Path update) passed.")

    // Exercise 4
    val longValues = values.map(_.toLong)
    val (sUpd, sSum) = subtreeQuery(6, edges, longValues, 0)
    assert(sSum(0) == 21) // sum of all
    assert(sSum(1) == 11) // 2+4+5
    println("Exercise 4 (Subtree query) passed.")

    // Exercise 5
    val (nodeUpd, pathS) = hldPathSum(6, edges, longValues, 0)
    assert(pathS(3, 5) == 1 + 2 + 3 + 4 + 6) // 3->1->0->2->5
    println("Exercise 5 (Path sum) passed.")

    // Exercise 6
    val chains = getChains(6, ch, pos)
    assert(chains.nonEmpty)
    println("Exercise 6 (Chain heads) passed.")

    // Exercise 7
    val hc = computeHeavyChild(6, edges, 0)
    assert(hc(0) == 1 || hc(0) == 2) // whichever subtree is bigger
    println("Exercise 7 (Heavy child) passed.")

    // Exercise 8
    val wEdges = List((0,1,3), (0,2,5), (1,3,2), (1,4,7), (2,5,4))
    val tpm = treePathMax(6, wEdges, 0)
    assert(tpm(3, 4) == 7) // path 3->1->4, max(2, 7) = 7
    println("Exercise 8 (Tree path max) passed.")

    println("All Algo094_HeavyLight exercises passed!")
  }
}
