package org.shev4ik.rockjvm.lists.numbers

import scala.annotation.tailrec

object NumberProblems extends App {

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTail(div: Int): Boolean = {
      if (div > Math.sqrt(Math.abs(n))){
        true
      } else
        n%div != 0 && isPrimeTail(div +1)
    }
    (n != 0 && n != 1) && isPrimeTail(2)
  }


  def decompose(n: Int): List[Int] = {
    @tailrec
    def decomposeTailRec(divisor: Int, remaining: Int, acc: List[Int]): List[Int] = {
      if (divisor > Math.sqrt(n)){
        remaining :: acc
      } else if (remaining % divisor == 0){
        decomposeTailRec(divisor, remaining/divisor, divisor::acc)
      } else {
        decomposeTailRec(divisor + 1, remaining, acc)
      }
    }
    decomposeTailRec(2, n, Nil)
  }

  //println(decompose(11))
  //0.to(100).map(x => s"$x -> ${isPrime(x)}").foreach(println)


}
