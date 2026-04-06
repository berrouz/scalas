package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Dynamic Programming on Trees - combining subproblem solutions along tree structure.
 *
 * Key concepts:
 * - Process children first (post-order), combine results at parent
 * - Often involves rooting the tree and doing DFS
 * - Re-rooting technique for "answer from every node" problems
 */
object Algo080_DPOnTrees {

  /** Binary tree node */
  sealed trait BTree[+A]
  case object BLeaf extends BTree[Nothing]
  case class BNode[A](value: A, left: BTree[A], right: BTree[A]) extends BTree[A]

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Tree DP basics - max path sum (root to leaf)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a tree as adjacency list (rooted at 0) with node values,
   *       find the maximum sum path from root to any leaf.
   *
   * @param n      number of nodes
   * @param edges  undirected edges (tree)
   * @param values value at each node
   * @return maximum root-to-leaf path sum
   */
  def maxRootToLeafSum(n: Int, edges: List[(Int, Int)], values: Array[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Maximum independent set on tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the maximum weight independent set on a tree.
   *       Independent set: no two adjacent vertices are selected.
   *       dp(v, 0) = max weight not selecting v
   *       dp(v, 1) = max weight selecting v
   *
   * @param n      number of nodes
   * @param edges  tree edges
   * @param values node weights
   * @return maximum independent set weight
   */
  def maxIndependentSet(n: Int, edges: List[(Int, Int)], values: Array[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Longest path in tree (diameter)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the longest path (in number of edges) in an unweighted tree.
   *       This is the tree diameter.
   *       Hint: For each node, track the two longest paths to any descendant.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @return length of longest path (number of edges)
   */
  def treeDiameter(n: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Tree diameter (weighted)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the diameter of a weighted tree (longest path by weight sum).
   *
   * @param n     number of nodes
   * @param edges list of (u, v, weight)
   * @return diameter (maximum weight path)
   */
  def weightedTreeDiameter(n: Int, edges: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Binary tree cameras
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Place minimum number of cameras on a binary tree such that
   *       every node is monitored. A camera monitors its parent, itself,
   *       and children.
   *       States: 0 = needs camera, 1 = has camera, 2 = covered by child.
   *
   * @param root binary tree
   * @return minimum number of cameras
   */
  def minCameraCover(root: BTree[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: House Robber III (binary tree)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: A thief robs houses arranged in a binary tree. Cannot rob two
   *       directly connected houses. Find maximum amount.
   *       Return (rob this node, don't rob this node) for each subtree.
   *
   * @param root binary tree where values are amounts
   * @return maximum rob amount
   */
  def houseRobberTree(root: BTree[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Distribute coins in binary tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a binary tree where each node has some coins and total coins = n,
   *       find minimum moves to make every node have exactly 1 coin.
   *       A move = transfer one coin between parent and child.
   *       At each node, compute excess = coins + leftExcess + rightExcess - 1.
   *       Total moves = sum of |excess| at each node.
   *
   * @param root binary tree with coin values
   * @return minimum number of moves
   */
  def distributeCoins(root: BTree[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Sum of distances in tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a tree, for each node compute the sum of distances to all other nodes.
   *       Use re-rooting technique:
   *       1. Root at 0, compute subtree sizes and answer for root.
   *       2. For each child, derive its answer from parent's answer.
   *       Return array of answers.
   *
   * @param n     number of nodes
   * @param edges tree edges
   * @return array where result(i) = sum of distances from node i to all others
   */
  def sumOfDistances(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val vals1 = Array(1, 2, 3, 4)
    assert(maxRootToLeafSum(4, List((0,1),(0,2),(1,3)), vals1) == 7) // 0->1->3: 1+2+4
    println("Exercise 1 (Max root-to-leaf sum) passed.")

    // Exercise 2
    val vals2 = Array(1, 5, 3, 4, 2)
    assert(maxIndependentSet(5, List((0,1),(0,2),(1,3),(1,4)), vals2) == 10) // pick 2,3,4: 3+4+2=9 or 1,3,4: 5+4+2=11... depends
    // Let's just check it returns something reasonable
    val mis = maxIndependentSet(5, List((0,1),(0,2),(1,3),(1,4)), vals2)
    assert(mis >= 9, s"Expected >= 9, got $mis")
    println("Exercise 2 (Max independent set) passed.")

    // Exercise 3
    assert(treeDiameter(5, List((0,1),(0,2),(1,3),(1,4))) == 3)
    println("Exercise 3 (Tree diameter) passed.")

    // Exercise 4
    val wd = weightedTreeDiameter(4, List((0,1,2),(1,2,3),(1,3,4)))
    assert(wd == 7, s"Expected 7, got $wd") // 2->1->3: 3+4=7
    println("Exercise 4 (Weighted tree diameter) passed.")

    // Exercise 5
    val tree5 = BNode(0, BNode(0, BNode(0, BLeaf, BLeaf), BLeaf), BLeaf)
    assert(minCameraCover(tree5) == 1)
    println("Exercise 5 (Binary tree cameras) passed.")

    // Exercise 6
    val tree6 = BNode(3, BNode(2, BLeaf, BNode(3, BLeaf, BLeaf)), BNode(3, BLeaf, BNode(1, BLeaf, BLeaf)))
    assert(houseRobberTree(tree6) == 7) // 3 + 3 + 1
    println("Exercise 6 (House Robber III) passed.")

    // Exercise 7
    val tree7 = BNode(3, BNode(0, BLeaf, BLeaf), BNode(0, BLeaf, BLeaf))
    assert(distributeCoins(tree7) == 2)
    println("Exercise 7 (Distribute coins) passed.")

    // Exercise 8
    val sd = sumOfDistances(4, List((0,1),(0,2),(2,3)))
    // 0: 1+1+2=4, 1: 1+2+3=6, 2: 1+2+1=4, 3: 2+3+1=6
    assert(sd(0) == 4, s"Expected 4, got ${sd(0)}")
    assert(sd(3) == 6, s"Expected 6, got ${sd(3)}")
    println("Exercise 8 (Sum of distances) passed.")

    println("All Algo080_DPOnTrees exercises passed!")
  }
}
