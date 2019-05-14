package org.shev4ik.coding.sorting

object MergeSort extends App {

  Some(sort(List(3, 1, 9, 12, 34, 2, 4)).mkString(" -> ")) foreach println
  def sort(list: List[Int]): List[Int] = {
    def merge(a: List[Int], b: List[Int]): List[Int] = {
      (a, b) match {
        case (Nil, _) ⇒ b
        case (_, Nil) ⇒ a
        case (aHead :: aTail, bHead :: bTail) ⇒
          if (aHead < bHead)
            aHead :: merge(aTail, b)
          else
            bHead :: merge(bTail, a)
      }
    }

    val middle = list.length / 2
    if (middle == 0) {
      list
    } else {
      val (a, b) = list.splitAt(middle)
      merge(sort(a), sort(b))
    }
  }
}
