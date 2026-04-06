package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.clock.Clock
import zio.console._
import zio.internal.{Executor, Platform}

/**
 * ZIO109 - Custom Runtime
 *
 * Learn how to customize the ZIO Runtime, Platform, Executor, and runtime hooks.
 */
object Zio109_CustomRuntime extends App {

  // ============================================================
  // Exercise 1: Custom Runtime
  // TODO: Create a custom Runtime[ZEnv] with the default environment.
  //       Use Runtime.default as a base. Run a simple effect with it.
  //       Print the result.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Custom Platform
  // TODO: Create a custom Platform that logs all fatal errors.
  //       Override the reportFatal method. Use Platform.default as base.
  //       Print platform configuration info.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Custom Executor
  // TODO: Create a custom Executor backed by a fixed thread pool of size 4.
  //       Use it to run CPU-bound computations.
  //       Print which thread executes the work.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Runtime configuration
  // TODO: Configure a Runtime with:
  //       - Custom executor
  //       - Custom fatal error reporter
  //       - Custom tracing enabled/disabled
  //       Print the configuration details.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Runtime hooks
  // TODO: Create a Runtime with hooks that log:
  //       - When a fiber starts
  //       - When a fiber completes
  //       Use Supervisor for this. Fork 3 fibers and print events.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Runtime tracing
  // TODO: Enable execution tracing in the runtime.
  //       Run an effect that chains several operations.
  //       Access and print the execution trace.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Runtime metrics
  // TODO: Create a runtime wrapper that tracks:
  //       - Number of effects executed
  //       - Total fiber count
  //       Use Refs and Supervisor. Print metrics after running workload.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Custom fiber scheduler
  // TODO: Demonstrate how executor affects fiber scheduling.
  //       Create two executors: one with 1 thread, one with 4 threads.
  //       Run the same parallel workload on each. Compare execution patterns.
  //       Print timing differences.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
