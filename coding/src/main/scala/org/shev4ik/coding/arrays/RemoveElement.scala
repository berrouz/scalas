package org.shev4ik.coding.arrays

object RemoveElement extends App {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    if (nums.length == 0) return 0

    var goodIndex = 0

    for (i <- nums.indices) {
      if (nums(i) != `val`){
        nums(goodIndex) = nums(i)
        goodIndex+=1
      }
    }
    goodIndex
  }

  private val arr: Array[Int] = Array(1)
  println(removeElement(arr, 1))

  println(arr.toList)
}
