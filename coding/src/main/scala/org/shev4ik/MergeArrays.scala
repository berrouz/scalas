package org.shev4ik

object MergeArrays extends App {

  val a = Array(5,9,0,0)
  val b = Array(2,5)

  merge(a, 2, b, 2)

  println(a.toList)

  def merge(a: Array[Int], m: Int, b: Array[Int], n: Int): Unit = {
    var i = m -1
    var j = n - 1

    var pointer = m+n -1
    while (j >= 0) {
      if (i >= 0 && a(i) > b(j)) {
        a(pointer) = a(i)
        i-=1
      } else {
        a(pointer) = b(j)
        j-=1
      }
      pointer -=1
    }
  }
}
