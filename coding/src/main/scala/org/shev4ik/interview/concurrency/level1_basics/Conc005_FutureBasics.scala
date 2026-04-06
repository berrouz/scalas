package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent._

object Conc005_FutureBasics {

  // Exercise 1: Submit a Callable and retrieve the result
  // TODO: Create an ExecutorService with a single thread. Submit a Callable[String]
  //       that returns "future-result". Call future.get() to retrieve the value.
  //       Shutdown the executor. Return the result.
  def exercise1_basicCallable(): String = ???

  // Exercise 2: Future.get() with timeout
  // TODO: Create an ExecutorService. Submit a Callable[Int] that returns 100.
  //       Use future.get(5, TimeUnit.SECONDS) to retrieve the result with a timeout.
  //       Shutdown. Return the result.
  def exercise2_getWithTimeout(): Int = ???

  // Exercise 3: Future.isDone
  // TODO: Create an ExecutorService. Submit a Callable[Int] that returns 1.
  //       Call future.get() to ensure it completes, then check future.isDone().
  //       Shutdown. Return isDone (should be true).
  def exercise3_isDone(): Boolean = ???

  // Exercise 4: Future.cancel
  // TODO: Create an ExecutorService. Submit a Callable that uses a CountDownLatch to
  //       wait indefinitely (latch.await()). Cancel the future with mayInterruptIfRunning = true.
  //       Return future.isCancelled() (should be true). Shutdown the executor.
  def exercise4_cancelFuture(): Boolean = ???

  // Exercise 5: Multiple Callables returning different types
  // TODO: Create an ExecutorService with 3 threads. Submit:
  //       - Callable[Int] returning 10
  //       - Callable[String] returning "hello"
  //       - Callable[Boolean] returning true
  //       Get all results. Shutdown. Return (intResult, stringResult, boolResult).
  def exercise5_multipleTypes(): (Int, String, Boolean) = ???

  // Exercise 6: Callable with computation
  // TODO: Create an ExecutorService. Submit a Callable[List[Int]] that computes
  //       (1 to 10).filter(_ % 2 == 0).toList.
  //       Get the result. Shutdown. Return the list.
  def exercise6_callableComputation(): List[Int] = ???

  // Exercise 7: Exception handling with Future.get()
  // TODO: Create an ExecutorService. Submit a Callable[Int] that throws
  //       new RuntimeException("computation failed").
  //       Wrap future.get() in a try-catch for ExecutionException.
  //       Return the cause's message (should be "computation failed"). Shutdown.
  def exercise7_futureException(): String = ???

  // Exercise 8: Collecting results from parallel tasks
  // TODO: Create a fixed thread pool with 4 threads. Submit 10 Callable[Int] tasks
  //       where task i returns i * i (for i from 0 to 9).
  //       Collect all results into a List[Int] and return the sum.
  //       Expected: 0 + 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 = 285. Shutdown.
  def exercise8_parallelCollect(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicCallable() == "future-result", "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_getWithTimeout() == 100, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_isDone() == true, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_cancelFuture() == true, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_multipleTypes() == (10, "hello", true), "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_callableComputation() == List(2, 4, 6, 8, 10), "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_futureException() == "computation failed", "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_parallelCollect() == 285, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc005_FutureBasics exercises passed!")
  }
}
