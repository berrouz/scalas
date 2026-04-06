package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO096 - Workflow Orchestration
 *
 * Learn how to model and execute multi-step workflows with compensation, retry, and monitoring.
 */
object Zio096_Workflow extends App {

  // ============================================================
  // Exercise 1: Workflow steps
  // TODO: Define a 3-step workflow: validate -> process -> notify.
  //       Each step is a ZIO effect. Chain them with flatMap.
  //       Print each step's execution.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Workflow compensation (saga-like)
  // TODO: Define a 3-step workflow where step 3 fails.
  //       Each step has a compensating action (undo).
  //       On failure, run compensations in reverse order.
  //       Print execution and compensation events.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Workflow retry
  // TODO: Define a workflow where step 2 is flaky (fails sometimes).
  //       Retry step 2 up to 3 times with a Schedule.
  //       Print retry attempts and final result.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Workflow timeout
  // TODO: Define a workflow with a global timeout of 5 seconds.
  //       If any step is too slow, the entire workflow fails with timeout.
  //       Print timeout events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Parallel workflow
  // TODO: Define a workflow with 3 independent steps that can run in parallel.
  //       Use ZIO.collectAllPar. After parallel steps complete,
  //       run a final aggregation step. Print timing info.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Conditional workflow
  // TODO: Define a workflow with conditional branching:
  //       Step 1 produces a result. Based on the result,
  //       either run Path A (2 steps) or Path B (3 steps).
  //       Print which path was taken.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Workflow state
  // TODO: Model workflow state using Ref[Map[String, Any]].
  //       Each step reads/writes to the shared state.
  //       Print the state after each step.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Workflow monitoring
  // TODO: Add monitoring to a workflow: track step durations,
  //       success/failure per step, total workflow time.
  //       Use Refs for metrics. Print a summary after workflow completion.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
