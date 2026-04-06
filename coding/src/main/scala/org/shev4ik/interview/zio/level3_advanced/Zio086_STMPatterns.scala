package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.stm._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO086 - STM Patterns (Classic Concurrency Problems)
 *
 * Solve classic concurrency problems using STM.
 */
object Zio086_STMPatterns extends App {

  // ============================================================
  // Exercise 1: Dining philosophers
  // TODO: Implement the dining philosophers problem using STM.
  //       5 philosophers, 5 forks (TRefs). Each philosopher picks up
  //       two forks atomically (no deadlock). Print eating events.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Producer-Consumer
  // TODO: Implement producer-consumer with a bounded TQueue.
  //       Producer adds items, blocks when full.
  //       Consumer takes items, blocks when empty.
  //       Print production and consumption events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Readers-Writers
  // TODO: Implement the readers-writers problem using TReentrantLock or TRefs.
  //       Multiple readers can read concurrently.
  //       Writers need exclusive access.
  //       Print read/write events.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Bounded buffer
  // TODO: Implement a bounded buffer of size 5 using TArray and TRefs.
  //       Support put (blocks when full) and take (blocks when empty).
  //       Print buffer operations.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Bank transfer
  // TODO: Implement atomic bank transfers between accounts (TRefs).
  //       Transfer should fail if source has insufficient funds.
  //       Run multiple concurrent transfers. Print final balances.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Inventory management
  // TODO: Implement a transactional inventory system with TMap-like structure.
  //       Support: addStock, removeStock (blocks if insufficient), getStock.
  //       Run concurrent operations. Print final inventory.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Voting system
  // TODO: Implement a voting system with TMap[String, Int] (candidate -> votes).
  //       Multiple voters vote concurrently.
  //       Print results after all votes are cast.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Concurrent counter with STM
  // TODO: Implement a concurrent counter that supports:
  //       increment, decrement, waitUntilZero (blocks until counter is 0).
  //       Fork fibers that increment/decrement. Wait until zero. Print events.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
