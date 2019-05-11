package org.shev4ik.coding.linkedlist

object ReverseLinkedList extends App {

  (1 :: 2 :: 3 :: Nil).reverse.foreach(print)

  implicit class ListOps(l: List[Int]) {
    def reverse(): List[Int] = {
      rev(l)
    }
  }

  def rev(l: List[Int]): List[Int] = {
    def inner(l: List[Int], r: List[Int]): List[Int] = {
      l match {
        case Nil       => r
        case h :: tail => inner(tail, h +: r)
      }
    }
    inner(l, Nil)
  }
}
