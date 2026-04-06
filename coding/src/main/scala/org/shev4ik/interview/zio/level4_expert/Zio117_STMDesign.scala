package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.stm._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO117 - STM Design Patterns
 *
 * Master STM architecture, transactional data structures, coordination, and performance.
 */
object Zio117_STMDesign extends App {

  // ============================================================
  // Exercise 1: STM architecture
  // TODO: Design a transactional service using STM:
  //       BankingService with accounts (TMap-like using TRef[Map]).
  //       Support: createAccount, getBalance, transfer.
  //       All operations are atomic. Print results.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Transactional data structures
  // TODO: Build a transactional bounded queue using TRef[Vector] and TRef[Int].
  //       Support: enqueue (blocks when full), dequeue (blocks when empty).
  //       Test with concurrent producers and consumers. Print events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: STM for coordination
  // TODO: Use STM to coordinate a barrier:
  //       N fibers arrive at a barrier and wait until all N are present.
  //       Then all proceed simultaneously. Use TRef[Int] as counter.
  //       Print arrival and release events.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: STM composition rules
  // TODO: Demonstrate STM composition:
  //       - STM flatMap (sequential within transaction)
  //       - STM orTry (try alternative on retry)
  //       - STM check (conditional retry)
  //       Show each rule with examples. Print results.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: STM retry semantics
  // TODO: Demonstrate STM retry:
  //       Create a TRef[Int] = 0. Start a transaction that waits for value > 5.
  //       A separate fiber increments the value periodically.
  //       Show that the transaction automatically retries when the value changes.
  //       Print the progression.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: STM performance
  // TODO: Compare STM vs Ref for concurrent counter:
  //       Both: 10 fibers each incrementing 1000 times.
  //       STM uses TRef, Ref uses Ref.
  //       Measure and compare performance. Print timing.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: STM vs locks
  // TODO: Solve the same problem (transfer between 2 accounts) using:
  //       (a) Lock-based: two Refs with Semaphore ordering
  //       (b) STM: two TRefs in one transaction
  //       Compare correctness and simplicity. Print results.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: STM testing
  // TODO: Write tests for STM operations:
  //       - Test atomicity: partial updates don't leak
  //       - Test retry: blocked transaction resumes correctly
  //       - Test composition: composed transactions are atomic
  //       Print test results.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
