package org.shev4ik.algorithms.leetcode_classic
/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Pattern: DFS / BFS
 * Time: O(n)
 * Space: O(h) for recursion, O(n) for BFS
 */
object L226_InvertBinaryTree {

  class TreeNode(var _value: Int = 0) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  // Recursive DFS
  def invertTree(root: TreeNode): TreeNode = {
    // TODO: Implement recursively
    // Swap left and right, then recursively invert children
    ???
  }

  // Pattern matching solution
  def invertTreePM(root: TreeNode): TreeNode = root match {
    case null => null
    case node =>
      val temp = node.left
      node.left = invertTreePM(node.right)
      node.right = invertTreePM(temp)
      node
  }

  // Iterative BFS
  def invertTreeBFS(root: TreeNode): TreeNode = {
    // TODO: Implement using BFS with Queue
    ???
  }

  // Helper to print tree (level order)
  def printTree(root: TreeNode): String = {
    if (root == null) "[]"
    else {
      val queue = collection.mutable.Queue[TreeNode](root)
      val result = collection.mutable.ListBuffer[String]()
      while (queue.nonEmpty) {
        val node = queue.dequeue()
        if (node == null) result += "null"
        else {
          result += node.value.toString
          queue.enqueue(node.left, node.right)
        }
      }
      ???
      /*// Remove trailing nulls
      while (result.nonEmpty && result.last == "null")  //result.dropRightInPlace(1)
      result.mkString("[", ",", "]")*/
    }
  }

  def main(args: Array[String]): Unit = {
    // Tree: [4,2,7,1,3,6,9]
    val root = new TreeNode(4)
    root.left = new TreeNode(2)
    root.right = new TreeNode(7)
    root.left.left = new TreeNode(1)
    root.left.right = new TreeNode(3)
    root.right.left = new TreeNode(6)
    root.right.right = new TreeNode(9)

    println(s"Before: ${printTree(root)}")
    invertTree(root)
    println(s"After: ${printTree(root)}") // Expected: [4,7,2,9,6,3,1]
  }
}
