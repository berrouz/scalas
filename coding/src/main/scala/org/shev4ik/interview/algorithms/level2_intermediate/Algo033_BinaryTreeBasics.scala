package org.shev4ik.interview.algorithms.level2_intermediate

object Algo033_BinaryTreeBasics {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Insert a value into a BST, returning the new root
  // TODO: If tree is empty, create new node. Otherwise, recurse left if value < node, right if value > node.
  def insertBST(root: Option[TreeNode], value: Int): TreeNode = ???

  // Exercise 2: Search for a value in a BST, returning the subtree rooted at that node
  // TODO: Return None if not found. Compare value with current node and recurse accordingly.
  def searchBST(root: Option[TreeNode], target: Int): Option[TreeNode] = ???

  // Exercise 3: Inorder traversal (left, root, right) — returns list of values
  // TODO: Recursively traverse left, append current, traverse right.
  def inorderTraversal(root: Option[TreeNode]): List[Int] = ???

  // Exercise 4: Preorder traversal (root, left, right) — returns list of values
  // TODO: Append current, recursively traverse left, then right.
  def preorderTraversal(root: Option[TreeNode]): List[Int] = ???

  // Exercise 5: Postorder traversal (left, right, root) — returns list of values
  // TODO: Recursively traverse left, traverse right, then append current.
  def postorderTraversal(root: Option[TreeNode]): List[Int] = ???

  // Exercise 6: Level-order traversal (BFS) — returns list of lists, each list is one level
  // TODO: Use a queue. Process level by level, collecting values at each depth.
  def levelOrderTraversal(root: Option[TreeNode]): List[List[Int]] = ???

  // Exercise 7: Count total number of nodes in the tree
  // TODO: Empty tree has 0 nodes. Otherwise 1 + count(left) + count(right).
  def countNodes(root: Option[TreeNode]): Int = ???

  // Exercise 8: Count the number of leaf nodes (nodes with no children)
  // TODO: A leaf has both left and right as None.
  def countLeaves(root: Option[TreeNode]): Int = ???

  def main(args: Array[String]): Unit = {
    // Build BST: insert 5, 3, 7, 1, 4, 6, 8
    val values = List(5, 3, 7, 1, 4, 6, 8)
    val root = values.foldLeft(Option.empty[TreeNode])((tree, v) => Some(insertBST(tree, v)))

    // Exercise 1
    assert(root.exists(_.value == 5), "Root should be 5")

    // Exercise 2
    assert(searchBST(root, 3).exists(_.value == 3), "Should find node 3")
    assert(searchBST(root, 10).isEmpty, "Should not find 10")

    // Exercise 3
    assert(inorderTraversal(root) == List(1, 3, 4, 5, 6, 7, 8), "Inorder should be sorted")

    // Exercise 4
    assert(preorderTraversal(root) == List(5, 3, 1, 4, 7, 6, 8), "Preorder check")

    // Exercise 5
    assert(postorderTraversal(root) == List(1, 4, 3, 6, 8, 7, 5), "Postorder check")

    // Exercise 6
    val levels = levelOrderTraversal(root)
    assert(levels == List(List(5), List(3, 7), List(1, 4, 6, 8)), "Level order check")

    // Exercise 7
    assert(countNodes(root) == 7, "Should have 7 nodes")

    // Exercise 8
    assert(countLeaves(root) == 4, "Should have 4 leaves")

    println("All Algo033_BinaryTreeBasics exercises passed!")
  }
}
