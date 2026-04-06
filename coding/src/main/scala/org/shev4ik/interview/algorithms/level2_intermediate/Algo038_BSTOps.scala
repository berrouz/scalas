package org.shev4ik.interview.algorithms.level2_intermediate

object Algo038_BSTOps {

  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  // Exercise 1: Delete a node with given value from BST, return new root
  // TODO: Find node. If leaf, remove. If one child, replace with child. If two children, replace with inorder successor.
  def deleteNode(root: Option[TreeNode], key: Int): Option[TreeNode] = ???

  // Exercise 2: Floor in BST — largest value <= given key
  // TODO: If node.value == key, return key. If node.value > key, go left. If node.value < key, floor is max(node.value, floor(right)).
  def floorBST(root: Option[TreeNode], key: Int): Option[Int] = ???

  // Exercise 3: Ceiling in BST — smallest value >= given key
  // TODO: Mirror of floor. If node.value < key, go right. If node.value > key, ceil is min(node.value, ceil(left)).
  def ceilingBST(root: Option[TreeNode], key: Int): Option[Int] = ???

  // Exercise 4: BST Iterator — returns values in sorted order one at a time
  // TODO: Use controlled inorder traversal with a stack. Implement next() and hasNext().
  class BSTIterator(root: Option[TreeNode]) {
    // TODO: Initialize internal state (e.g., stack with leftmost path)
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 5: Serialize BST to string and deserialize back
  // TODO: Use preorder traversal for serialize. For deserialize, use bounds to reconstruct.
  def serializeBST(root: Option[TreeNode]): String = ???
  def deserializeBST(data: String): Option[TreeNode] = ???

  // Exercise 6: Count nodes in BST within range [low, high]
  // TODO: If node.value < low, only count right. If node.value > high, only count left. Otherwise 1 + both.
  def countInRange(root: Option[TreeNode], low: Int, high: Int): Int = ???

  // Exercise 7: Trim BST — remove all nodes outside [low, high], return new root
  // TODO: If node.value < low, return trim(right). If node.value > high, return trim(left). Otherwise trim both children.
  def trimBST(root: Option[TreeNode], low: Int, high: Int): Option[TreeNode] = ???

  // Exercise 8: Balance a BST — convert to height-balanced BST with same values
  // TODO: Inorder traversal to get sorted array. Then build balanced BST from sorted array.
  def balanceBST(root: Option[TreeNode]): Option[TreeNode] = ???

  def main(args: Array[String]): Unit = {
    val bst = Some(TreeNode(5,
      Some(TreeNode(3, Some(TreeNode(2)), Some(TreeNode(4)))),
      Some(TreeNode(7, Some(TreeNode(6)), Some(TreeNode(8))))
    ))

    // Exercise 1
    val deleted = deleteNode(bst, 3)
    // After deleting 3, inorder should be 2,4,5,6,7,8
    def inorder(n: Option[TreeNode]): List[Int] = n match {
      case None => Nil
      case Some(nd) => inorder(nd.left) ::: List(nd.value) ::: inorder(nd.right)
    }
    assert(inorder(deleted) == List(2, 4, 5, 6, 7, 8), "Delete node 3")

    // Exercise 2
    assert(floorBST(bst, 4).contains(4), "Floor of 4 is 4")
    assert(floorBST(bst, 4).contains(4), "Floor of 4 is 4")
    assert(floorBST(bst, 1).isEmpty, "No floor for 1")

    // Exercise 3
    assert(ceilingBST(bst, 4).contains(4), "Ceiling of 4 is 4")
    assert(ceilingBST(bst, 9).isEmpty, "No ceiling for 9")

    // Exercise 4
    val iter = new BSTIterator(bst)
    assert(iter.hasNext, "Iterator has next")
    assert(iter.next() == 2, "First is 2")
    assert(iter.next() == 3, "Second is 3")

    // Exercise 5
    val serialized = serializeBST(bst)
    val deserialized = deserializeBST(serialized)
    assert(inorder(deserialized) == List(2, 3, 4, 5, 6, 7, 8), "Serialize/deserialize round-trip")

    // Exercise 6
    assert(countInRange(bst, 3, 7) == 5, "Nodes 3,4,5,6,7 in range")

    // Exercise 7
    val trimmed = trimBST(bst, 3, 6)
    assert(inorder(trimmed) == List(3, 4, 5, 6), "Trimmed to [3,6]")

    // Exercise 8
    val unbalanced = Some(TreeNode(1, None, Some(TreeNode(2, None, Some(TreeNode(3, None, Some(TreeNode(4))))))))
    val balanced = balanceBST(unbalanced)
    assert(inorder(balanced) == List(1, 2, 3, 4), "Balanced BST has same values")

    println("All Algo038_BSTOps exercises passed!")
  }
}
