package org.shev4ik.algorithms

object Palindrome extends App {

  def isPal(x: Int, r: Int): Int =
    if (x > r)
      isPal(x/10, r*10 + x%10)
    else
      r


  def get(x: Int) = {
    var reverted = 0
    var xx = x
    while (xx > reverted) {
      reverted = reverted * 10 + xx % 10
      xx /= 10
    }
    (xx,reverted)
  }

  println(get(121))
}
