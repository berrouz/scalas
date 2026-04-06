package org.shev4ik.rockjvm.lists.numbers

import scala.annotation.tailrec

object ReverseInteger extends App {

  println(reverse(Int.MinValue))

  def reverse(num: Int): Int = {
    @tailrec
    def tail(n: Int, acc: Int): Int = {
      if (n * 10 < 0) 0 else if (n == 0) acc else tail(n / 10, acc * 10 + n % 10)
    }
    if (num > 0) tail(num, 0) else -tail(-num, 0)
  }
}
