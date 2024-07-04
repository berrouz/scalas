package org.shev4ik.algorithms.sorting

object InsertionSorting extends App {

  val arr = Array(6,3,2,4,1,5)

  for(index <- 1.until(arr.length)){

    val elem = arr(index)
    var insertIndex = index - 1
    while(insertIndex >= 0 && arr(insertIndex) > elem){
      arr(insertIndex+1) = arr(insertIndex)
      insertIndex -= 1
    }

    arr(insertIndex+1) = elem
  }

  println(arr.toList)
}
