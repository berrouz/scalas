package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.stm._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO102 - Deadlock Prevention
 *
 * Learn about deadlock detection, prevention, and deadlock-free design patterns.
 */
object Zio102_Deadlock extends App {

  // ============================================================
  // Exercise 1: Deadlock detection concept
  // TODO: Demonstrate a potential deadlock scenario with two Promises.
  //       Fiber A waits on Promise 1 before completing Promise 2.
  //       Fiber B waits on Promise 2 before completing Promise 1.
  //       Use timeout to detect the deadlock. Print the result.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Lock ordering
  // TODO: Implement a deadlock-free solution using consistent lock ordering.
  //       Two fibers need locks A and B. Both acquire A first, then B.
  //       Use Semaphores. Print lock acquisition events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Timeout for deadlock
  // TODO: Implement a "lock with timeout" pattern.
  //       If a lock can't be acquired within a timeout, give up and retry.
  //       Simulate contention. Print timeout/retry events.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Deadlock prevention
  // TODO: Implement a resource manager that prevents deadlocks by
  //       assigning numeric IDs to resources and always acquiring
  //       in ascending order. Print acquisition order.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: STM vs locks
  // TODO: Solve the same problem (transfer between accounts) using:
  //       (a) Semaphores (risk of deadlock if not careful)
  //       (b) STM (deadlock-free by design)
  //       Compare and print results from both approaches.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Deadlock-free design
  // TODO: Design a service that needs to update two shared resources atomically.
  //       Use STM to ensure deadlock-free atomic updates.
  //       Fork multiple fibers updating concurrently. Print final state.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Resource hierarchy
  // TODO: Implement a resource hierarchy: top-level lock must be acquired
  //       before lower-level locks. Enforce this with a FiberRef tracking
  //       the current hierarchy level. Print violations.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: tryAcquire pattern
  // TODO: Implement a tryAcquire pattern: attempt to acquire multiple locks.
  //       If any lock can't be acquired immediately, release all acquired locks
  //       and retry. Print acquisition attempts.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
