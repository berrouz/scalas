package org.shev4ik.rockjvm.lists.numbers

import scala.annotation.tailrec
import scala.util.Random

object NumberProblems extends App {

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTail(div: Int): Boolean = {
      if (div > Math.sqrt(Math.abs(n))) {
        true
      } else
        n % div != 0 && isPrimeTail(div + 1)
    }
    (n != 0 && n != 1) && isPrimeTail(2)
  }

  def decompose(n: Int): List[Int] = {
    @tailrec
    def decomposeTailRec(divisor: Int, remaining: Int, acc: List[Int]): List[Int] = {
      if (divisor > Math.sqrt(n)) {
        remaining :: acc
      } else if (remaining % divisor == 0) {
        decomposeTailRec(divisor, remaining / divisor, divisor :: acc)
      } else {
        decomposeTailRec(divisor + 1, remaining, acc)
      }
    }
    decomposeTailRec(2, n, Nil)
  }

  val random = new Random(System.currentTimeMillis)
  // compute Pi
  def approximatePi(nPoints: Int): Double = {
    val n = (1 to nPoints)
      .map { _ =>
        val x = random.nextDouble
        val y = random.nextDouble
        x * x + y * y
      }
      .count(_ < 1)
    n * 4.0 / nPoints
  }

  // println(decompose(11))
  // 0.to(100).map(x => s"$x -> ${isPrime(x)}").foreach(println)
  println(approximatePi(1000))
  println(approximatePi(10000))
  println(approximatePi(10000000))
  println(approximatePi(100000000))

}
