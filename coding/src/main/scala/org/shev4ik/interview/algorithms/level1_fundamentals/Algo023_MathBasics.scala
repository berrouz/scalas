package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo023_MathBasics {

  // TODO: Calculate the Greatest Common Divisor of two numbers using Euclidean algorithm
  // Example: gcd(12, 8) => 4
  def gcd(a: Int, b: Int): Int = ???

  // TODO: Calculate the Least Common Multiple of two numbers
  // Hint: lcm(a,b) = a * b / gcd(a,b)
  // Example: lcm(4, 6) => 12
  def lcm(a: Int, b: Int): Int = ???

  // TODO: Check if a number is prime
  // Example: 7 => true, 4 => false, 1 => false
  def isPrime(n: Int): Boolean = ???

  // TODO: Find all prime numbers up to n using the Sieve of Eratosthenes
  // Example: 20 => List(2,3,5,7,11,13,17,19)
  def sieveOfEratosthenes(n: Int): List[Int] = ???

  // TODO: Find the prime factorization of a number
  // Return as a list of factors (with repetition)
  // Example: 60 => List(2,2,3,5), 13 => List(13)
  def primeFactors(n: Int): List[Int] = ???

  // TODO: Calculate (base^exp) % mod efficiently using modular exponentiation
  // Example: powerMod(2, 10, 1000) => 24
  def powerMod(base: Long, exp: Long, mod: Long): Long = ???

  // TODO: Count trailing zeros in n! (factorial of n)
  // Trailing zeros come from factors of 10 = 2*5, and there are always more 2s than 5s
  // Example: 25 => 6 (25! has 6 trailing zeros)
  def countTrailingZerosFactorial(n: Int): Int = ???

  // TODO: Determine if a number is happy
  // A happy number: replace with sum of squares of digits, repeat until 1 or cycle
  // Example: 19 => true (1^2+9^2=82, 8^2+2^2=68, 6^2+8^2=100, 1^2+0+0=1)
  def happyNumber(n: Int): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: gcd
    assert(gcd(12, 8) == 4)
    assert(gcd(17, 13) == 1)
    assert(gcd(0, 5) == 5)
    println("Exercise 1 passed: gcd")

    // Exercise 2: lcm
    assert(lcm(4, 6) == 12)
    assert(lcm(3, 7) == 21)
    println("Exercise 2 passed: lcm")

    // Exercise 3: isPrime
    assert(isPrime(7) == true)
    assert(isPrime(4) == false)
    assert(isPrime(1) == false)
    assert(isPrime(2) == true)
    println("Exercise 3 passed: isPrime")

    // Exercise 4: sieveOfEratosthenes
    assert(sieveOfEratosthenes(20) == List(2, 3, 5, 7, 11, 13, 17, 19))
    assert(sieveOfEratosthenes(2) == List(2))
    println("Exercise 4 passed: sieveOfEratosthenes")

    // Exercise 5: primeFactors
    assert(primeFactors(60) == List(2, 2, 3, 5))
    assert(primeFactors(13) == List(13))
    assert(primeFactors(1) == List())
    println("Exercise 5 passed: primeFactors")

    // Exercise 6: powerMod
    assert(powerMod(2, 10, 1000) == 24)
    assert(powerMod(3, 13, 1000000007) == 1594323)
    println("Exercise 6 passed: powerMod")

    // Exercise 7: countTrailingZerosFactorial
    assert(countTrailingZerosFactorial(25) == 6)
    assert(countTrailingZerosFactorial(5) == 1)
    assert(countTrailingZerosFactorial(100) == 24)
    println("Exercise 7 passed: countTrailingZerosFactorial")

    // Exercise 8: happyNumber
    assert(happyNumber(19) == true)
    assert(happyNumber(2) == false)
    assert(happyNumber(1) == true)
    println("Exercise 8 passed: happyNumber")

    println("All Algo023_MathBasics exercises passed!")
  }
}
