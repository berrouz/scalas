package org.shev4ik.interview.algorithms.level2_intermediate

object Algo035_BinaryTreeProperties {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Maximum depth (height) of a binary tree
  // TODO: Empty tree has depth 0. Otherwise 1 + max(depth(left), depth(right)).
  def maxDepth(root: Option[TreeNode]): Int = ???

  // Exercise 2: Minimum depth — shortest path from root to nearest leaf
  // TODO: If one child is None, take the other side's depth. If both exist, take min.
  def minDepth(root: Option[TreeNode]): Int = ???

  // Exercise 3: Check if the tree is height-balanced (every subtree heights differ by at most 1)
  // TODO: Use a helper that returns height or -1 if unbalanced. Avoid recomputing heights.
  def isBalanced(root: Option[TreeNode]): Boolean = ???

  // Exercise 4: Check if the tree is symmetric (mirror of itself)
  // TODO: Compare left subtree with right subtree. Two trees are mirrors if roots equal, and left.left mirrors right.right, etc.
  def isSymmetric(root: Option[TreeNode]): Boolean = ???

  // Exercise 5: Diameter of a binary tree (longest path between any two nodes, in edges)
  // TODO: For each node, diameter passes through it = depth(left) + depth(right). Track global max.
  def diameter(root: Option[TreeNode]): Int = ???

  // Exercise 6: Check if two trees are structurally identical with same values
  // TODO: Both None => true. Both Some with same value => recurse on children. Otherwise false.
  def isSameTree(p: Option[TreeNode], q: Option[TreeNode]): Boolean = ???

  // Exercise 7: Check if tree t is a subtree of tree s
  // TODO: For each node in s, check if the subtree rooted there equals t.
  def isSubtree(s: Option[TreeNode], t: Option[TreeNode]): Boolean = ???

  // Exercise 8: Count the number of leaf nodes
  // TODO: A leaf node has no left and no right child.
  def countLeaves(root: Option[TreeNode]): Int = ???

  def main(args: Array[String]): Unit = {
    //       1
    //      / \
    //     2   2
    //    / \ / \
    //   3  4 4  3
    val symmetric = Some(TreeNode(1,
      Some(TreeNode(2, Some(TreeNode(3)), Some(TreeNode(4)))),
      Some(TreeNode(2, Some(TreeNode(4)), Some(TreeNode(3))))
    ))

    val unbalanced = Some(TreeNode(1,
      Some(TreeNode(2, Some(TreeNode(3, Some(TreeNode(4)), None)), None)),
      None
    ))

    // Exercise 1
    assert(maxDepth(symmetric) == 3, "Max depth of symmetric tree is 3")

    // Exercise 2
    assert(minDepth(symmetric) == 3, "Min depth of symmetric tree is 3")
    assert(minDepth(Some(TreeNode(1, Some(TreeNode(2)), None))) == 2, "Min depth skips None children")

    // Exercise 3
    assert(isBalanced(symmetric), "Symmetric tree is balanced")
    assert(!isBalanced(unbalanced), "Unbalanced tree detected")

    // Exercise 4
    assert(isSymmetric(symmetric), "Tree is symmetric")

    // Exercise 5
    assert(diameter(symmetric) == 4, "Diameter is 4 edges")

    // Exercise 6
    val treeA = Some(TreeNode(1, Some(TreeNode(2)), Some(TreeNode(3))))
    val treeB = Some(TreeNode(1, Some(TreeNode(2)), Some(TreeNode(3))))
    assert(isSameTree(treeA, treeB), "Identical trees")
    assert(!isSameTree(treeA, Some(TreeNode(1))), "Different trees")

    // Exercise 7
    val sub = Some(TreeNode(2, Some(TreeNode(3)), Some(TreeNode(4))))
    assert(isSubtree(symmetric, sub), "Subtree found")

    // Exercise 8
    assert(countLeaves(symmetric) == 4, "4 leaves in symmetric tree")

    println("All Algo035_BinaryTreeProperties exercises passed!")
  }
}
