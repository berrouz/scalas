package org.shev4ik.algorithms.leetcode_classic

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 *
 * Pattern: BFS with Queue
 * Time: O(n)
 * Space: O(n)
 */
object L102_BinaryTreeLevelOrder {

  class TreeNode(var _value: Int = 0) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  // BFS solution
  def levelOrder(root: TreeNode): List[List[Int]] = {
    // TODO: Implement using BFS
    // Hint: Use queue, process level by level
    ???
  }

  // DFS solution
  def levelOrderDFS(root: TreeNode): List[List[Int]] = {
    // TODO: Implement using DFS with depth tracking
    ???
  }

  // Functional recursive solution
  def levelOrderFunctional(root: TreeNode): List[List[Int]] = {
    def traverse(nodes: List[TreeNode]): List[List[Int]] = {
      if (nodes.isEmpty) Nil
      else {
        val values = nodes.map(_.value)
        val nextLevel = nodes.flatMap(n => List(n.left, n.right)).filter(_ != null)
        values :: traverse(nextLevel)
      }
    }
    if (root == null) Nil else traverse(List(root))
  }

  def main(args: Array[String]): Unit = {
    // Tree: [3,9,20,null,null,15,7]
    val root = new TreeNode(3)
    root.left = new TreeNode(9)
    root.right = new TreeNode(20)
    root.right.left = new TreeNode(15)
    root.right.right = new TreeNode(7)

    println(levelOrder(root)) // Expected: List(List(3), List(9, 20), List(15, 7))
  }
}
