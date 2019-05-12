package org.shev4ik.coding.linkedlist

object FlattenNestedList extends App {

  Some(flatten(List(1, List(2, 3), List(List(4, List(99, List(5))))))) foreach println

  def flatten(l: List[_]): List[Any] = {
    def inner(l: List[_], result: List[Any]): List[Any] = {
      l match {
        case (a: List[_]) :: tail ⇒ inner(tail, result ++ inner(a, Nil))
        case a :: tail ⇒ inner(tail, result :+ a)
        case Nil ⇒ result
      }
    }
    inner(l, Nil)
  }
}
