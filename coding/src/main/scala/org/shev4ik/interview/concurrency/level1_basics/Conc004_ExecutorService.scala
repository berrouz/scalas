package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent._
import java.util.concurrent.atomic.AtomicInteger

object Conc004_ExecutorService {

  // Exercise 1: Single thread executor
  // TODO: Create a single thread executor using Executors.newSingleThreadExecutor().
  //       Submit a Runnable that sets an AtomicInteger to 42.
  //       Shutdown the executor and awaitTermination. Return the value.
  def exercise1_singleThreadExecutor(): Int = ???

  // Exercise 2: Fixed thread pool
  // TODO: Create a fixed thread pool with 4 threads using Executors.newFixedThreadPool(4).
  //       Submit 8 tasks, each incrementing an AtomicInteger counter.
  //       Shutdown and await termination. Return counter.get() (should be 8).
  def exercise2_fixedThreadPool(): Int = ???

  // Exercise 3: Cached thread pool
  // TODO: Create a cached thread pool using Executors.newCachedThreadPool().
  //       Submit 20 tasks, each incrementing an AtomicInteger.
  //       Shutdown and await termination. Return counter.get() (should be 20).
  def exercise3_cachedThreadPool(): Int = ???

  // Exercise 4: Submit Callable and get Future result
  // TODO: Create a fixed thread pool with 2 threads.
  //       Submit a Callable[Int] that returns 10 + 32.
  //       Get the result from the Future. Shutdown the pool. Return the result.
  def exercise4_callableAndFuture(): Int = ???

  // Exercise 5: Multiple Futures
  // TODO: Create a fixed thread pool. Submit 5 Callable[Int] tasks returning 1, 2, 3, 4, 5.
  //       Collect all Future results into a List and sum them.
  //       Shutdown pool. Return the sum (should be 15).
  def exercise5_multipleFutures(): Int = ???

  // Exercise 6: ScheduledExecutorService
  // TODO: Create a ScheduledExecutorService with 1 thread.
  //       Schedule a Callable[String] that returns "scheduled" with a delay of 0 seconds.
  //       Get the result from the ScheduledFuture. Shutdown. Return the result.
  def exercise6_scheduledExecutor(): String = ???

  // Exercise 7: Shutdown vs shutdownNow
  // TODO: Create a fixed thread pool with 2 threads. Submit 4 tasks that each
  //       increment an AtomicInteger and then wait on a CountDownLatch.
  //       Call shutdown() — verify isShutdown returns true.
  //       Release the latch so tasks complete. Await termination.
  //       Return (isShutdown, isTerminated) after awaiting — both should be true.
  def exercise7_shutdownBehavior(): (Boolean, Boolean) = ???

  // Exercise 8: invokeAll
  // TODO: Create a fixed thread pool. Use invokeAll() to submit a list of 3 Callable[Int]
  //       tasks returning 10, 20, 30. Collect the results from the returned List[Future[Int]].
  //       Shutdown pool. Return the sum (should be 60).
  def exercise8_invokeAll(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_singleThreadExecutor() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_fixedThreadPool() == 8, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_cachedThreadPool() == 20, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_callableAndFuture() == 42, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_multipleFutures() == 15, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_scheduledExecutor() == "scheduled", "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_shutdownBehavior() == (true, true), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_invokeAll() == 60, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc004_ExecutorService exercises passed!")
  }
}
