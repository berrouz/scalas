package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent.{ForkJoinPool, RecursiveTask, RecursiveAction}
import java.util.concurrent.atomic.AtomicInteger

object Conc013_ForkJoinPool {

  // Exercise 1: Basic ForkJoinPool submit
  // TODO: Create a ForkJoinPool. Submit a RecursiveTask[Int] that returns 42.
  //       Get the result. Shutdown. Return it.
  def exercise1_basicForkJoin(): Int = ???

  // Exercise 2: RecursiveTask - sum of array
  // TODO: Implement a RecursiveTask[Long] that sums an Array[Int] using fork/join.
  //       If array segment length <= 10, compute directly. Otherwise split in half,
  //       fork left, compute right, then join left and add results.
  //       Sum Array(1 to 100). Return the result (should be 5050).
  def exercise2_recursiveSum(): Long = ???

  // Exercise 3: RecursiveTask - fibonacci
  // TODO: Implement a RecursiveTask[Int] that computes fibonacci(n) using fork/join.
  //       Base cases: fib(0) = 0, fib(1) = 1.
  //       For n > 1: fork fib(n-1), compute fib(n-2), join fib(n-1), return sum.
  //       Compute fib(10). Return the result (should be 55).
  def exercise3_fibonacci(): Int = ???

  // Exercise 4: RecursiveAction (no return value)
  // TODO: Implement a RecursiveAction that increments each element of an Array[Int] by 1.
  //       If segment length <= 5, do it directly. Otherwise split and fork both halves.
  //       Start with Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0). Invoke the action.
  //       Return the array sum (should be 10).
  def exercise4_recursiveAction(): Int = ???

  // Exercise 5: ForkJoinPool parallelism
  // TODO: Create a ForkJoinPool with parallelism = 4.
  //       Return pool.getParallelism() (should be 4). Shutdown.
  def exercise5_parallelism(): Int = ???

  // Exercise 6: Work stealing
  // TODO: Create a ForkJoinPool(2). Submit 4 RecursiveTasks that each return their index.
  //       Collect all results. Return the sum (0+1+2+3 = 6). Shutdown.
  def exercise6_workStealing(): Int = ???

  // Exercise 7: RecursiveTask - max element
  // TODO: Implement a RecursiveTask[Int] that finds the max element in an Array[Int].
  //       If segment length <= 5, find max directly. Otherwise split, fork, join, return max.
  //       Find max of Array(3, 7, 1, 9, 2, 8, 4, 6, 5, 10). Return the result (should be 10).
  def exercise7_maxElement(): Int = ???

  // Exercise 8: Common ForkJoinPool
  // TODO: Use ForkJoinPool.commonPool() to submit a RecursiveTask[String] that returns "common".
  //       Get the result. Return it. (Do NOT shutdown the common pool.)
  def exercise8_commonPool(): String = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicForkJoin() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_recursiveSum() == 5050L, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_fibonacci() == 55, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_recursiveAction() == 10, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_parallelism() == 4, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_workStealing() == 6, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_maxElement() == 10, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_commonPool() == "common", "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc013_ForkJoinPool exercises passed!")
  }
}
