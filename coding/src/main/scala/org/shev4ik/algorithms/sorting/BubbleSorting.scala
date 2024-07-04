package org.shev4ik.algorithms.sorting

object BubbleSorting extends App {

  val arr = Array(4,1,2,3,5,6)

  for(index <- arr.indices){
    for (j <- 1.until(arr.length-index)) {
      if (arr(j - 1) > arr(j)) {
        val temp = arr(j - 1)
        arr(j - 1) = arr(j)
        arr(j) = temp
      }
    }
  }

  println(arr.toList)

}
