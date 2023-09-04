package org.shev4ik.coding.arrays

object MountainArray extends App {
  println(validMountainArray(Array(0, 3, 2, 1)))

  def validMountainArray(A: Array[Int]): Boolean = {
    if (A.length < 3 || A(0) >= A(1)) return false
    var isIncrease = true

    for (i <- 1 until A.length) {
      if (A(i - 1) > A(i)) {
        isIncrease = false
      } else if (isIncrease && A(i - 1) > A(i)) {
        return false
      } else if (!isIncrease && A(i - 1) < A(i)) {
        return false
      }
    }
    !isIncrease
  }
}
