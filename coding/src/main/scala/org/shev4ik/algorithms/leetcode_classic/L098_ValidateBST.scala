package org.shev4ik.algorithms.leetcode_classic

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree.
 *
 * Pattern: DFS with range validation
 * Time: O(n)
 * Space: O(h) where h is height
 */
object L098_ValidateBST {

  class TreeNode(var _value: Int = 0) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def isValidBST(root: TreeNode): Boolean = {
    // TODO: Implement using range validation
    // Each node must be within (min, max) range
    ???
  }

  // Helper with range
  private def validate(node: TreeNode, min: Option[Int], max: Option[Int]): Boolean = {
    // TODO: Implement recursive validation
    // 1. Null node is valid
    // 2. Check current value against min/max
    // 3. Recursively check left (max = current) and right (min = current)
    ???
  }

  // Inorder traversal solution
  def isValidBSTInorder(root: TreeNode): Boolean = {
    // TODO: Implement using inorder traversal
    // BST inorder traversal should be strictly increasing
    ???
  }

  def main(args: Array[String]): Unit = {
    // Tree: [2,1,3]
    val root1 = new TreeNode(2)
    root1.left = new TreeNode(1)
    root1.right = new TreeNode(3)
    println(isValidBST(root1)) // Expected: true

    // Tree: [5,1,4,null,null,3,6]
    val root2 = new TreeNode(5)
    root2.left = new TreeNode(1)
    root2.right = new TreeNode(4)
    root2.right.left = new TreeNode(3)
    root2.right.right = new TreeNode(6)
    println(isValidBST(root2)) // Expected: false
  }
}
