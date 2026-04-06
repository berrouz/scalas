package org.shev4ik.coding.tree

object TreeHeight extends App {
  def height(root: Node): Int = {
    def rec(root: Node, counter: Int): Int =
      if (root == null)
        counter
      else Math.max(rec(root.left, counter + 1), rec(root.right, counter + 1))
    rec(root, 0)
  }
  case class Node(date: Int, left: Node, right: Node)
  println(
    height(
      Node(
        1,
        Node(1, Node(1, null, null), Node(1, Node(1, null, null), null)),
        null
      )
    )
  )
}
