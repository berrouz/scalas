package org.shev4ik.interviews._11_2023

object PrimeNumber extends App {

  def isPrime(n: Int): Boolean = {
    for (i <- 2.to(Math.sqrt(n).toInt)) {
      if (n % i == 0) return false
    }
    true
  }

  1.to(100).map(x => (x, isPrime(x))).foreach(println)

  List(1, 2, 3).scan(0)((a, b) => Math.min(Math.abs(a - b), 0))
}
