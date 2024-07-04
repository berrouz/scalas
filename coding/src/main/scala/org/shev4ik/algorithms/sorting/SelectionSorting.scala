package org.shev4ik.algorithms.sorting

object SelectionSorting extends App {

  val arr = Array(3,5,2,1,4,6)

  for(index <- arr.indices){

    var minIndex = index

    for(j <- (index + 1).until(arr.length)){
      minIndex = if (arr(j) < arr(minIndex)) j else minIndex
    }

    val temp = arr(index)
    arr(index) = arr(minIndex)
    arr(minIndex) = temp
  }

  println(arr.toList)

}
