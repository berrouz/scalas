package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.clock.Clock
import zio.stm._
import zio.console._

/**
 * ZIO085 - Advanced STM Data Structures
 *
 * Learn about TPromise, TSemaphore, TReentrantLock, TArray, TSet, TQueue, and STM composition.
 */
object Zio085_STMAdvanced extends App {

  // ============================================================
  // Exercise 1: TPromise
  // TODO: Create a TPromise[String, Int]. Fork a fiber that completes it with 42.
  //       In the main fiber, await the promise and print the result.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: TSemaphore
  // TODO: Create a TSemaphore with 3 permits.
  //       Fork 5 fibers that each acquire a permit, do work, then release.
  //       Print when each fiber acquires and releases.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: TReentrantLock
  // TODO: Create a TReentrantLock.
  //       Acquire a read lock in multiple fibers concurrently.
  //       Acquire a write lock that waits for all readers to finish.
  //       Print lock acquisition events.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: TArray
  // TODO: Create a TArray of 10 integers initialized to 0.
  //       Fork 10 fibers, each incrementing a different index.
  //       Collect and print the final array contents.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: TSet
  // TODO: Create an empty TSet[String].
  //       Concurrently add elements from multiple fibers.
  //       Check membership and print the final set contents.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: TQueue priority
  // TODO: Create a TQueue and implement a priority queue pattern.
  //       Enqueue items with priorities. Dequeue in priority order.
  //       Print the dequeued items.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: TRef composition
  // TODO: Create two TRefs: balance1 and balance2, both starting at 100.
  //       Implement an atomic transfer: subtract from one and add to the other
  //       in a single STM transaction. Verify totals are preserved. Print balances.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: STM composition patterns
  // TODO: Compose multiple STM operations:
  //       - Read from TRef A
  //       - Conditionally retry if value < threshold (using STM.check)
  //       - Update TRef B based on A's value
  //       All in one atomic transaction. Print the result.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
