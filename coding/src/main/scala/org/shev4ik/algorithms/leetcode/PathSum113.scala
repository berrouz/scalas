package org.shev4ik.algorithms.leetcode

object PathSum113 extends App {
  def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
    def inner(
        root: TreeNode,
        targetSum: Int,
        path: List[Int],
        results: List[List[Int]]
    ): List[List[Int]] = {
      if (root == null) {
        results
      } else {
        if (root.left != null && root.right != null && targetSum - root.value == 0) {
          results :+ (path :+ root.value)
        } else {

          inner(root.left, targetSum - root.value, path :+ root.value, results) ++
            inner(root.right, targetSum - root.value, path :+ root.value, results)
        }
      }
    }
    inner(root, targetSum, Nil, Nil)
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int      = _value
    var left: TreeNode  = _left
    var right: TreeNode = _right
  }
}
