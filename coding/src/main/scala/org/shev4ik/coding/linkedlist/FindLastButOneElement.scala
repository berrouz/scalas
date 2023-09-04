package org.shev4ik.coding.linkedlist

object FindLastButOneElement extends App {

  Some(lastButOne(1 :: 1 :: 2 :: 3 :: 5 :: 8 :: Nil)) foreach println

  def lastButOne(list: List[Int]): Int = {
    def inner(list: List[Int]): Int = {
      list match {
        case prev :: _ :: Nil ⇒ prev
        case _ :: tail        ⇒ inner(tail)
      }
    }
    inner(list)
  }
}
