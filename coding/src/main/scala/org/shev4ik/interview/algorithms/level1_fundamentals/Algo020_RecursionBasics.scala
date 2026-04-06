package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo020_RecursionBasics {

  // TODO: Calculate factorial of n recursively
  // Example: 5 => 120, 0 => 1
  def factorial(n: Int): Long = ???

  // TODO: Calculate the nth Fibonacci number recursively
  // fib(0)=0, fib(1)=1, fib(n)=fib(n-1)+fib(n-2)
  // Example: 6 => 8 (0,1,1,2,3,5,8)
  def fibonacci(n: Int): Long = ???

  // TODO: Calculate base^exp recursively using fast exponentiation
  // Example: power(2, 10) => 1024
  def power(base: Long, exp: Int): Long = ???

  // TODO: Calculate the sum of digits of a number recursively
  // Example: 1234 => 10, 999 => 27
  def sumOfDigits(n: Int): Int = ???

  // TODO: Reverse a string recursively
  // Example: "hello" => "olleh"
  def reverseStringRecursive(s: String): String = ???

  // TODO: Check if a string is a palindrome recursively
  // Example: "racecar" => true, "hello" => false
  def isPalindromeRecursive(s: String): Boolean = ???

  // TODO: Solve Tower of Hanoi — return the list of moves as (from, to) pairs
  // Move n disks from source to target using auxiliary peg
  // Example: towerOfHanoi(2, 'A', 'C', 'B') => List(('A','B'), ('A','C'), ('B','C'))
  def towerOfHanoi(n: Int, source: Char, target: Char, auxiliary: Char): List[(Char, Char)] = ???

  // TODO: Count the number of distinct ways to climb n stairs
  // You can climb 1 or 2 stairs at a time
  // Example: 3 => 3 (1+1+1, 1+2, 2+1), 4 => 5
  def countWaysToClimbStairs(n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: factorial
    assert(factorial(5) == 120)
    assert(factorial(0) == 1)
    assert(factorial(10) == 3628800)
    println("Exercise 1 passed: factorial")

    // Exercise 2: fibonacci
    assert(fibonacci(0) == 0)
    assert(fibonacci(1) == 1)
    assert(fibonacci(6) == 8)
    assert(fibonacci(10) == 55)
    println("Exercise 2 passed: fibonacci")

    // Exercise 3: power
    assert(power(2, 10) == 1024)
    assert(power(3, 5) == 243)
    assert(power(5, 0) == 1)
    println("Exercise 3 passed: power")

    // Exercise 4: sumOfDigits
    assert(sumOfDigits(1234) == 10)
    assert(sumOfDigits(999) == 27)
    assert(sumOfDigits(0) == 0)
    println("Exercise 4 passed: sumOfDigits")

    // Exercise 5: reverseStringRecursive
    assert(reverseStringRecursive("hello") == "olleh")
    assert(reverseStringRecursive("") == "")
    assert(reverseStringRecursive("a") == "a")
    println("Exercise 5 passed: reverseStringRecursive")

    // Exercise 6: isPalindromeRecursive
    assert(isPalindromeRecursive("racecar") == true)
    assert(isPalindromeRecursive("hello") == false)
    assert(isPalindromeRecursive("") == true)
    println("Exercise 6 passed: isPalindromeRecursive")

    // Exercise 7: towerOfHanoi
    assert(towerOfHanoi(2, 'A', 'C', 'B') == List(('A', 'B'), ('A', 'C'), ('B', 'C')))
    assert(towerOfHanoi(1, 'A', 'C', 'B') == List(('A', 'C')))
    assert(towerOfHanoi(3, 'A', 'C', 'B').length == 7)
    println("Exercise 7 passed: towerOfHanoi")

    // Exercise 8: countWaysToClimbStairs
    assert(countWaysToClimbStairs(1) == 1)
    assert(countWaysToClimbStairs(2) == 2)
    assert(countWaysToClimbStairs(3) == 3)
    assert(countWaysToClimbStairs(4) == 5)
    println("Exercise 8 passed: countWaysToClimbStairs")

    println("All Algo020_RecursionBasics exercises passed!")
  }
}
