package org.shev4ik.interview.scala_core.level1_beginner

import scala.annotation.tailrec

object Core020_Recursion {

  // Exercise 1: Factorial
  // TODO: Implement factorial recursively: factorial(n) = n * factorial(n-1), base case: factorial(0) = 1
  def exercise1_factorial(n: Int): Long = ???

  // Exercise 2: Fibonacci
  // TODO: Implement fibonacci: fib(0)=0, fib(1)=1, fib(n) = fib(n-1) + fib(n-2)
  def exercise2_fibonacci(n: Int): Int = ???

  // Exercise 3: Sum of a list
  // TODO: Implement sum of a list recursively:
  //       Nil => 0, head :: tail => head + sum(tail)
  def exercise3_sumList(list: List[Int]): Int = ???

  // Exercise 4: Reverse a list
  // TODO: Implement list reversal recursively.
  //       Nil => Nil, head :: tail => reverse(tail) :+ head
  //       (Note: this is O(n^2), but fine for learning)
  def exercise4_reverseList[A](list: List[A]): List[A] = ???

  // Exercise 5: Flatten nested lists
  // TODO: Given a List[Any] that may contain nested Lists, flatten it.
  //       e.g., List(1, List(2, 3), List(4, List(5, 6))) => List(1, 2, 3, 4, 5, 6)
  //       Use pattern matching: case (head: List[_]) :: tail => flatten(head) ++ flatten(tail)
  def exercise5_flatten(list: List[Any]): List[Any] = ???

  // Exercise 6: Binary search (recursive)
  // TODO: Implement binary search on a sorted Array[Int].
  //       Return the index of the target, or -1 if not found.
  //       Use helper with low and high bounds.
  def exercise6_binarySearch(arr: Array[Int], target: Int): Int = ???

  // Exercise 7: Tail recursion with @tailrec
  // TODO: Implement factorial using tail recursion with @tailrec annotation.
  //       Use an accumulator: factTail(n, acc) where acc starts at 1.
  def exercise7_tailRecFactorial(n: Int): Long = ???

  // Exercise 8: Accumulator pattern
  // TODO: Implement a tail-recursive sum of 1 to n using the accumulator pattern.
  //       @tailrec def sumAcc(n: Int, acc: Int): Int
  //       Return the sum.
  def exercise8_accumulatorPattern(n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_factorial(0) == 1, "Exercise 1 failed: 0!")
    assert(exercise1_factorial(5) == 120, "Exercise 1 failed: 5!")
    assert(exercise1_factorial(10) == 3628800, "Exercise 1 failed: 10!")

    assert(exercise2_fibonacci(0) == 0, "Exercise 2 failed: fib(0)")
    assert(exercise2_fibonacci(1) == 1, "Exercise 2 failed: fib(1)")
    assert(exercise2_fibonacci(10) == 55, "Exercise 2 failed: fib(10)")

    assert(exercise3_sumList(List(1, 2, 3, 4, 5)) == 15, "Exercise 3 failed")
    assert(exercise3_sumList(Nil) == 0, "Exercise 3 failed: empty")

    assert(exercise4_reverseList(List(1, 2, 3)) == List(3, 2, 1), "Exercise 4 failed")
    assert(exercise4_reverseList(Nil) == Nil, "Exercise 4 failed: empty")

    assert(exercise5_flatten(List(1, List(2, 3), List(4, List(5, 6)))) == List(1, 2, 3, 4, 5, 6),
      "Exercise 5 failed")

    val sorted = Array(1, 3, 5, 7, 9, 11, 13)
    assert(exercise6_binarySearch(sorted, 7) == 3, "Exercise 6 failed: found")
    assert(exercise6_binarySearch(sorted, 4) == -1, "Exercise 6 failed: not found")

    assert(exercise7_tailRecFactorial(5) == 120, "Exercise 7 failed: 5!")
    assert(exercise7_tailRecFactorial(0) == 1, "Exercise 7 failed: 0!")
    assert(exercise7_tailRecFactorial(20) == 2432902008176640000L, "Exercise 7 failed: 20!")

    assert(exercise8_accumulatorPattern(10) == 55, "Exercise 8 failed: 10")
    assert(exercise8_accumulatorPattern(100) == 5050, "Exercise 8 failed: 100")

    println("All Core020_Recursion exercises passed!")
  }
}
