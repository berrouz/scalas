package org.shev4ik.coding.customtypes

object CustomLinkedList extends App {

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

  println(1 → 3 → 4 → 5)

  case class →[Int](head: Int, tail: List[Int])
}
