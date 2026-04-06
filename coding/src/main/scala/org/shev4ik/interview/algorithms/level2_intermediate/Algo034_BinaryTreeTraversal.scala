package org.shev4ik.interview.algorithms.level2_intermediate

object Algo034_BinaryTreeTraversal {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Iterative inorder traversal using an explicit stack
  // TODO: Use a mutable stack. Push nodes going left, pop and visit, then go right.
  def iterativeInorder(root: Option[TreeNode]): List[Int] = ???

  // Exercise 2: Iterative preorder traversal using an explicit stack
  // TODO: Push root, pop and visit, push right then left children.
  def iterativePreorder(root: Option[TreeNode]): List[Int] = ???

  // Exercise 3: Iterative postorder traversal using two stacks (or reverse trick)
  // TODO: Use two stacks or reverse the modified preorder (root, right, left).
  def iterativePostorder(root: Option[TreeNode]): List[Int] = ???

  // Exercise 4: Morris inorder traversal concept — O(1) space inorder
  // TODO: Thread the tree using predecessor's right pointer. No stack needed.
  // For simplicity, return the inorder list. Modify tree temporarily then restore.
  def morrisInorder(root: Option[TreeNode]): List[Int] = ???

  // Exercise 5: Zigzag (spiral) level-order traversal
  // TODO: BFS level by level. Alternate the direction of each level (left-to-right, right-to-left).
  def zigzagLevelOrder(root: Option[TreeNode]): List[List[Int]] = ???

  // Exercise 6: Vertical order traversal — group nodes by horizontal distance
  // TODO: BFS with column index. Root is 0, left child col-1, right child col+1. Sort by column.
  def verticalOrderTraversal(root: Option[TreeNode]): List[List[Int]] = ???

  // Exercise 7: Boundary traversal — left boundary + leaves + right boundary (reverse)
  // TODO: Collect left boundary (top-down), leaves (left-to-right), right boundary (bottom-up). Avoid duplicates.
  def boundaryTraversal(root: Option[TreeNode]): List[Int] = ???

  // Exercise 8: Right side view — values visible from the right at each level
  // TODO: BFS level by level, take last element of each level. Or DFS visiting right before left.
  def rightSideView(root: Option[TreeNode]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    //       1
    //      / \
    //     2   3
    //    / \   \
    //   4   5   6
    val tree = Some(TreeNode(1,
      Some(TreeNode(2, Some(TreeNode(4)), Some(TreeNode(5)))),
      Some(TreeNode(3, None, Some(TreeNode(6))))
    ))

    // Exercise 1
    assert(iterativeInorder(tree) == List(4, 2, 5, 1, 3, 6), "Iterative inorder")

    // Exercise 2
    assert(iterativePreorder(tree) == List(1, 2, 4, 5, 3, 6), "Iterative preorder")

    // Exercise 3
    assert(iterativePostorder(tree) == List(4, 5, 2, 6, 3, 1), "Iterative postorder")

    // Exercise 4
    assert(morrisInorder(tree) == List(4, 2, 5, 1, 3, 6), "Morris inorder")

    // Exercise 5
    assert(zigzagLevelOrder(tree) == List(List(1), List(3, 2), List(4, 5, 6)), "Zigzag level order")

    // Exercise 6
    val vertical = verticalOrderTraversal(tree)
    assert(vertical == List(List(4), List(2), List(1, 5, 3), List(6)), "Vertical order")

    // Exercise 7
    assert(boundaryTraversal(tree) == List(1, 2, 4, 5, 6, 3), "Boundary traversal")

    // Exercise 8
    assert(rightSideView(tree) == List(1, 3, 6), "Right side view")

    println("All Algo034_BinaryTreeTraversal exercises passed!")
  }
}
