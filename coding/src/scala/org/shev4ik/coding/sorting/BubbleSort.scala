package org.shev4ik.coding.sorting

object BubbleSort extends App {
  val arr = Array(3, 7, 9, 8, 4, 5, 1, 6, 2, 0)

  sort(arr) foreach print

  def sort(arr: Array[Int]): Array[Int] = {
    for (i <- arr.indices) {
      for (j <- 0 until i) {
        if (arr(i) < arr(j)) {
          val temp = arr(i)
          arr(i) = arr(j)
          arr(j) = temp
        }
      }
    }
    arr
  }
}
