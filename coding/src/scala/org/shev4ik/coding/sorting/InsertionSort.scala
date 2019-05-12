package org.shev4ik.coding.sorting

object InsertionSort extends App {
  val arr = Array(3, 7, 9, 8, 4, 5, 1, 6, 2, 0)

  sort(arr) foreach print

  def sort(arr: Array[Int]): Array[Int] = {
    for (i <- 1 until arr.length) {
      for (j <- i until 0 by -1) {
        while (arr(j) < arr(j - 1)) {
          val temp = arr(j - 1)
          arr(j - 1) = arr(j)
          arr(j) = temp
          Some(arr.mkString(",")) foreach println
        }
      }
    }
    arr
  }
}
