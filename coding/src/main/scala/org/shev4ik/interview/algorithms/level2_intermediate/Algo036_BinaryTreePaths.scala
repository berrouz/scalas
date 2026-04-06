package org.shev4ik.interview.algorithms.level2_intermediate

object Algo036_BinaryTreePaths {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Has path sum — does any root-to-leaf path sum to targetSum?
  // TODO: Subtract current value from target. At a leaf, check if remaining == 0.
  def hasPathSum(root: Option[TreeNode], targetSum: Int): Boolean = ???

  // Exercise 2: All root-to-leaf paths as strings like "1->2->3"
  // TODO: DFS, accumulate path. At leaf, convert path to string.
  def binaryTreePaths(root: Option[TreeNode]): List[String] = ???

  // Exercise 3: Path Sum II — find all root-to-leaf paths that sum to targetSum
  // TODO: Backtracking DFS. Accumulate path and remaining sum. Collect at leaf if sum matches.
  def pathSumII(root: Option[TreeNode], targetSum: Int): List[List[Int]] = ???

  // Exercise 4: Maximum path sum — path can start and end at any node
  // TODO: For each node, compute max gain from left and right children (clamp to 0 if negative).
  // Update global max with left + right + node.value. Return node.value + max(left, right).
  def maxPathSum(root: Option[TreeNode]): Int = ???

  // Exercise 5: Lowest Common Ancestor of two nodes p and q in a binary tree
  // TODO: If root is p or q, return root. Recurse left and right. If both non-None, root is LCA.
  def lowestCommonAncestor(root: Option[TreeNode], p: Int, q: Int): Option[TreeNode] = ???

  // Exercise 6: Sum root-to-leaf numbers (each path forms a number, e.g., 1->2->3 = 123)
  // TODO: DFS carrying current number. At leaf, add to total.
  def sumNumbers(root: Option[TreeNode]): Int = ???

  // Exercise 7: Flatten binary tree to linked list (preorder, using right pointers)
  // TODO: Return a new tree where all nodes are chained via right, left is always None.
  def flatten(root: Option[TreeNode]): Option[TreeNode] = ???

  // Exercise 8: Construct binary tree from preorder and inorder traversal arrays
  // TODO: First element of preorder is root. Find it in inorder to split left/right subtrees.
  def buildTree(preorder: Array[Int], inorder: Array[Int]): Option[TreeNode] = ???

  def main(args: Array[String]): Unit = {
    //       5
    //      / \
    //     4   8
    //    /   / \
    //   11  13  4
    //  / \     / \
    // 7   2   5   1
    val tree = Some(TreeNode(5,
      Some(TreeNode(4, Some(TreeNode(11, Some(TreeNode(7)), Some(TreeNode(2)))), None)),
      Some(TreeNode(8, Some(TreeNode(13)), Some(TreeNode(4, Some(TreeNode(5)), Some(TreeNode(1))))))
    ))

    // Exercise 1
    assert(hasPathSum(tree, 22), "Path 5->4->11->2 sums to 22")
    assert(!hasPathSum(tree, 1), "No path sums to 1")

    // Exercise 2
    val simple = Some(TreeNode(1, Some(TreeNode(2)), Some(TreeNode(3))))
    assert(binaryTreePaths(simple).toSet == Set("1->2", "1->3"), "All paths")

    // Exercise 3
    assert(pathSumII(tree, 22) == List(List(5, 4, 11, 2)), "Path sum II")

    // Exercise 4
    val pathTree = Some(TreeNode(-10, Some(TreeNode(9)), Some(TreeNode(20, Some(TreeNode(15)), Some(TreeNode(7))))))
    assert(maxPathSum(pathTree) == 42, "Max path sum: 15 + 20 + 7 = 42")

    // Exercise 5
    assert(lowestCommonAncestor(tree, 7, 2).exists(_.value == 11), "LCA of 7 and 2 is 11")
    assert(lowestCommonAncestor(tree, 4, 13).exists(_.value == 5), "LCA of 4 and 13 is 5 (root)")

    // Exercise 6
    val numTree = Some(TreeNode(1, Some(TreeNode(2)), Some(TreeNode(3))))
    assert(sumNumbers(numTree) == 25, "12 + 13 = 25")

    // Exercise 7
    val flatTree = flatten(simple)
    assert(flatTree.exists(n => n.value == 1 && n.left.isEmpty), "Flattened root is 1")

    // Exercise 8
    val pre = Array(3, 9, 20, 15, 7)
    val ino = Array(9, 3, 15, 20, 7)
    val built = buildTree(pre, ino)
    assert(built.exists(_.value == 3), "Root is 3")
    assert(built.flatMap(_.left).exists(_.value == 9), "Left child is 9")

    println("All Algo036_BinaryTreePaths exercises passed!")
  }
}
