package org.shev4ik.coding.linkedlist

import scala.annotation.tailrec

object ReverseLinkedList extends App {

  import implicits._

  (1 → 2 → 3 reverse) foreach print

  val rev: List[Int] ⇒ List[Int] = list ⇒ {
    @tailrec
    def inner(l: List[Int], r: List[Int]): List[Int] = {
      l match {
        case Nil       ⇒ r
        case h :: tail ⇒ inner(tail, h +: r)
      }
    }

    inner(list, Nil)
  }
}

object implicits {

  implicit class IntOps(i: Int) {
    def →(i2: Int): List[Int] = {
      i :: i2 :: Nil
    }
  }

  implicit class ListOps(list: List[Int]) {
    def →(i2: Int): List[Int] = {
      list :+ i2
    }
  }

}
