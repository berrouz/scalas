package org.shev4ik.interview.algorithms.level2_intermediate

object Algo037_BST {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Validate BST — check if a binary tree is a valid BST
  // TODO: Use min/max bounds. Each node must be within (min, max). Recurse with updated bounds.
  def isValidBST(root: Option[TreeNode]): Boolean = ???

  // Exercise 2: Kth smallest element in a BST (1-indexed)
  // TODO: Inorder traversal gives sorted order. Return the kth element.
  def kthSmallest(root: Option[TreeNode], k: Int): Int = ???

  // Exercise 3: Inorder successor in BST — next node in inorder after given value
  // TODO: If target has right subtree, successor is leftmost in right. Otherwise, track ancestor.
  def inorderSuccessor(root: Option[TreeNode], target: Int): Option[Int] = ???

  // Exercise 4: Convert sorted array to a height-balanced BST
  // TODO: Pick middle element as root. Recurse on left and right halves.
  def sortedArrayToBST(nums: Array[Int]): Option[TreeNode] = ???

  // Exercise 5: Convert BST to sorted doubly linked list (flatten inorder, return as list of values)
  // TODO: Inorder traversal to produce sorted list. (Simplified: return List[Int] of values in order.)
  def bstToSortedList(root: Option[TreeNode]): List[Int] = ???

  // Exercise 6: Closest value in BST to a given target (Double)
  // TODO: Track closest. If target < node, go left; if target > node, go right. Update closest.
  def closestValue(root: Option[TreeNode], target: Double): Int = ???

  // Exercise 7: Range sum of BST — sum all node values in [low, high]
  // TODO: If node.value < low, only recurse right. If node.value > high, only recurse left. Otherwise add and recurse both.
  def rangeSumBST(root: Option[TreeNode], low: Int, high: Int): Int = ???

  // Exercise 8: Recover BST — exactly two nodes are swapped, find them and return their values
  // TODO: Inorder traversal. Find two places where order is violated. Return the two swapped values as (Int, Int).
  def recoverBST(root: Option[TreeNode]): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    val bst = Some(TreeNode(4,
      Some(TreeNode(2, Some(TreeNode(1)), Some(TreeNode(3)))),
      Some(TreeNode(6, Some(TreeNode(5)), Some(TreeNode(7))))
    ))

    // Exercise 1
    assert(isValidBST(bst), "Valid BST")
    val invalid = Some(TreeNode(5, Some(TreeNode(1)), Some(TreeNode(4, Some(TreeNode(3)), Some(TreeNode(6))))))
    assert(!isValidBST(invalid), "Invalid BST")

    // Exercise 2
    assert(kthSmallest(bst, 1) == 1, "1st smallest is 1")
    assert(kthSmallest(bst, 3) == 3, "3rd smallest is 3")

    // Exercise 3
    assert(inorderSuccessor(bst, 3).contains(4), "Successor of 3 is 4")
    assert(inorderSuccessor(bst, 7).isEmpty, "No successor for 7")

    // Exercise 4
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    val balanced = sortedArrayToBST(arr)
    assert(balanced.exists(_.value == 4), "Root of balanced BST from 1-7 is 4")

    // Exercise 5
    assert(bstToSortedList(bst) == List(1, 2, 3, 4, 5, 6, 7), "BST to sorted list")

    // Exercise 6
    assert(closestValue(bst, 3.7) == 4, "Closest to 3.7 is 4")
    assert(closestValue(bst, 4.2) == 4, "Closest to 4.2 is 4")

    // Exercise 7
    assert(rangeSumBST(bst, 3, 6) == 18, "Sum of 3+4+5+6 = 18")

    // Exercise 8
    // Swapped 1 and 7:  4, 2(7,3), 6(5,1)
    val swapped = Some(TreeNode(4,
      Some(TreeNode(2, Some(TreeNode(7)), Some(TreeNode(3)))),
      Some(TreeNode(6, Some(TreeNode(5)), Some(TreeNode(1))))
    ))
    val (a, b) = recoverBST(swapped)
    assert(Set(a, b) == Set(1, 7), "Swapped nodes are 1 and 7")

    println("All Algo037_BST exercises passed!")
  }
}
