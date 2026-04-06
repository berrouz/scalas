package org.shev4ik.algorithms.leetcode_classic

import jdk.internal.joptsimple.internal.Strings

object ReverseLinkedList206Scala extends App {

  val node = Node(1, Node(2, Node(3)))

  println(node)
  println(reverseLinkedList(node))

  def reverseLinkedList(node: Node): Node = {
    var current = node
    var prev: Node = null

    while (current != null){

      var next = current.next
      current.next = prev

      prev = current
      current = next
    }

    prev
  }

  case class Node(val value: Int, var next: Node = null) {
    override def toString: String = {
      value.toString + (if (next == null) Strings.EMPTY else {
        " -> " ++ next.toString
      })
    }
  }
}
