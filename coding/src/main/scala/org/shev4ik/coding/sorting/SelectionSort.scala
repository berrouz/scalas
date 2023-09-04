package org.shev4ik.coding.sorting

object SelectionSort extends App {
  val arr = Array(3, 7, 9, 8, 4, 5, 1, 6, 2, 0)

  sort(arr) foreach print
  println("")
  sortRecursion(arr) foreach print

  def sort(arr: Array[Int]): Array[Int] = {
    for (i <- arr.indices) {
      var min = Integer.MAX_VALUE
      var ind = -1
      for (j <- i until arr.length) {
        if (min > arr(j)) {
          min = arr(j)
          ind = j
        }
      }
      val temp = arr(i)
      arr(i) = min
      arr(ind) = temp
    }
    arr
  }

  def sortRecursion(arr: Array[Int]): Array[Int] = {
    def inner(l: List[Int], result: List[Int]): List[Int] = {
      l match {
        case Nil ⇒ result
        case list: List[Any] ⇒
          val m      = list.min
          val (h, t) = list.span(_ != m)
          inner(h ++ t.tail, result :+ m)
      }
    }
    inner(arr.toList, Nil).toArray
  }
}
