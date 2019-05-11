package org.shev4ik.coding.linkedlist

import scala.annotation.tailrec

object ReverseLinkedList extends App {

  (1 :: 2 :: 3 :: Nil).reverse.foreach(print)

  implicit class ListOps(l: List[Int]) {
    val reverse: List[Int] = rev(l)
  }

  val rev: List[Int] ⇒ List[Int] = list ⇒ {
    @tailrec
    def inner(l: List[Int], r: List[Int]): List[Int] = {
      l match {
        case Nil ⇒ r
        case h :: tail ⇒ inner(tail, h +: r)
      }
    }

    inner(list, Nil)
  }
}
