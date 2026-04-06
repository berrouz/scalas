package org.shev4ik.interview.algorithms.level2_intermediate

object Algo069_TreeConstruction {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Helper: inorder traversal for verification
  private def inorder(root: Option[TreeNode]): List[Int] = root match {
    case None => Nil
    case Some(n) => inorder(n.left) ::: List(n.value) ::: inorder(n.right)
  }

  private def preorder(root: Option[TreeNode]): List[Int] = root match {
    case None => Nil
    case Some(n) => List(n.value) ::: preorder(n.left) ::: preorder(n.right)
  }

  // Exercise 1: Build binary tree from preorder and inorder traversal
  // TODO: First preorder element is root. Find in inorder to split left/right. Recurse.
  def buildFromPreorderInorder(preorder: Array[Int], inorder: Array[Int]): Option[TreeNode] = ???

  // Exercise 2: Build binary tree from inorder and postorder traversal
  // TODO: Last postorder element is root. Find in inorder to split. Recurse.
  def buildFromInorderPostorder(inorder: Array[Int], postorder: Array[Int]): Option[TreeNode] = ???

  // Exercise 3: Build BST from preorder traversal alone
  // TODO: Use upper bound approach. First element is root. Recurse with bounds.
  def bstFromPreorder(preorder: Array[Int]): Option[TreeNode] = ???

  // Exercise 4: Build complete binary tree from level-order traversal
  // TODO: Root is index 0. Left child of i is 2*i+1, right is 2*i+2. Recurse.
  def buildFromLevelOrder(levelOrder: Array[Int]): Option[TreeNode] = ???

  // Exercise 5: Serialize and deserialize a binary tree (using preorder with null markers)
  // TODO: Serialize: preorder, write "null" for None. Deserialize: read tokens, reconstruct.
  def serialize(root: Option[TreeNode]): String = ???
  def deserialize(data: String): Option[TreeNode] = ???

  // Exercise 6: Construct Maximum Binary Tree — root is max element, left from left subarray, right from right
  // TODO: Find max index. Root = max. Left = construct(nums[0..maxIdx-1]). Right = construct(nums[maxIdx+1..]).
  def constructMaximumBinaryTree(nums: Array[Int]): Option[TreeNode] = ???

  // Exercise 7: Build binary tree from a bracket string like "4(2(3)(1))(6(5))"
  // TODO: Parse number as root. If '(' follows, parse left subtree. If another '(' follows, parse right.
  def buildFromString(s: String): Option[TreeNode] = ???

  // Exercise 8: Construct Quad Tree concept — divide 2D grid into 4 quadrants
  // TODO: If all cells same value, leaf node. Otherwise split into 4 quadrants and recurse.
  // Return a simplified representation: either Leaf(value) or Internal(topLeft, topRight, bottomLeft, bottomRight).
  sealed trait QuadTree
  case class Leaf(value: Boolean) extends QuadTree
  case class Internal(tl: QuadTree, tr: QuadTree, bl: QuadTree, br: QuadTree) extends QuadTree

  def constructQuadTree(grid: Array[Array[Int]]): QuadTree = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val pre1 = Array(3, 9, 20, 15, 7)
    val ino1 = Array(9, 3, 15, 20, 7)
    val tree1 = buildFromPreorderInorder(pre1, ino1)
    assert(tree1.exists(_.value == 3), "Root is 3")
    assert(inorder(tree1) == List(9, 3, 15, 20, 7), "Inorder matches")

    // Exercise 2
    val ino2 = Array(9, 3, 15, 20, 7)
    val post2 = Array(9, 15, 7, 20, 3)
    val tree2 = buildFromInorderPostorder(ino2, post2)
    assert(tree2.exists(_.value == 3), "Root is 3")

    // Exercise 3
    val bstPre = Array(8, 5, 1, 7, 10, 12)
    val bst = bstFromPreorder(bstPre)
    assert(bst.exists(_.value == 8), "BST root is 8")
    assert(inorder(bst) == List(1, 5, 7, 8, 10, 12), "BST inorder is sorted")

    // Exercise 4
    val lo = Array(1, 2, 3, 4, 5, 6, 7)
    val tree4 = buildFromLevelOrder(lo)
    assert(tree4.exists(_.value == 1), "Root is 1")

    // Exercise 5
    val tree5 = Some(TreeNode(1, Some(TreeNode(2)), Some(TreeNode(3, Some(TreeNode(4)), Some(TreeNode(5))))))
    val ser = serialize(tree5)
    val deser = deserialize(ser)
    assert(preorder(deser) == preorder(tree5), "Serialize/deserialize round-trip")

    // Exercise 6
    val maxTree = constructMaximumBinaryTree(Array(3, 2, 1, 6, 0, 5))
    assert(maxTree.exists(_.value == 6), "Max tree root is 6")

    // Exercise 7
    val strTree = buildFromString("4(2(3)(1))(6(5))")
    assert(strTree.exists(_.value == 4), "String tree root is 4")

    // Exercise 8
    val grid = Array(
      Array(1, 1, 0, 0),
      Array(1, 1, 0, 0),
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 1)
    )
    val qt = constructQuadTree(grid)
    assert(qt.isInstanceOf[Internal], "Mixed grid is internal node")

    println("All Algo069_TreeConstruction exercises passed!")
  }
}
