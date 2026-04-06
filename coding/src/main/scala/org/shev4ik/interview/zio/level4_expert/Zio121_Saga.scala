package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO121 - Saga Pattern
 *
 * Implement the saga pattern for distributed transactions with compensation.
 */
object Zio121_Saga extends App {

  // ============================================================
  // Exercise 1: Saga step
  // TODO: Define a SagaStep[A] that has an action: Task[A] and a
  //       compensate: A => Task[Unit]. Create a step that reserves
  //       inventory (action) and releases it (compensate). Print events.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Compensation
  // TODO: Implement compensation logic: when a saga step fails,
  //       run all previous compensations in reverse order.
  //       Create 3 steps where step 3 fails. Print compensation events.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Saga coordinator
  // TODO: Implement a SagaCoordinator that orchestrates saga execution:
  //       - Runs steps sequentially
  //       - On failure, runs compensations
  //       - Returns either success or compensation result
  //       Print the orchestration flow.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Saga with ZIO
  // TODO: Build a complete saga for an order process:
  //       Step 1: Reserve inventory
  //       Step 2: Charge payment
  //       Step 3: Create shipment
  //       Step 4: Send notification
  //       If any step fails, compensate all. Print the full flow.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Parallel saga
  // TODO: Implement a saga where some steps can run in parallel:
  //       Step 1: sequential (reserve inventory)
  //       Step 2a & 2b: parallel (charge payment & create label)
  //       Step 3: sequential (ship order)
  //       Print timing and execution order.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Saga timeout
  // TODO: Add timeout to saga execution:
  //       If the entire saga takes > 5 seconds, abort and compensate.
  //       Simulate a slow step. Print timeout and compensation events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Saga retry
  // TODO: Add retry logic to individual saga steps:
  //       A step can retry up to 3 times before failing the saga.
  //       Only after all retries are exhausted, trigger compensation.
  //       Print retry and compensation events.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Saga monitoring
  // TODO: Add monitoring to the saga:
  //       Track: step durations, success/failure counts, compensation events.
  //       Use Refs for metrics. Print a saga execution report.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
