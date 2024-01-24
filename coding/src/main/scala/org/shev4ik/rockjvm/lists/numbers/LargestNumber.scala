package org.shev4ik.rockjvm.lists.numbers

object LargestNumber extends App {
  // [3,30,34,5,9] -> 9,5,34,3,30
  def largestNumber(number: Seq[Int]): String = {
    number.map(_.toString).sorted.map(_.toInt).mkString(",")
  }
  println(largestNumber(Seq(3,30,34,5,9)))
}
