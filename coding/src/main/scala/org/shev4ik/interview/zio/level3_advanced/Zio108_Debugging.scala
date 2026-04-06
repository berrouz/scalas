package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO108 - Debugging ZIO Applications
 *
 * Learn debugging techniques: fiber dumps, traces, cause analysis, and profiling.
 */
object Zio108_Debugging extends App {

  // ============================================================
  // Exercise 1: Fiber dump
  // TODO: Fork several fibers in different states (running, sleeping, completed).
  //       Dump their status. Print a summary of fiber states.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Trace
  // TODO: Create a chain of effects: a -> b -> c -> d.
  //       When d fails, capture the execution trace.
  //       Print the trace showing the chain of calls.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Cause analysis
  // TODO: Create an effect that fails with a complex Cause:
  //       Cause.fail + Cause.die + Cause.interrupt (combined).
  //       Use .sandbox to capture the full Cause.
  //       Analyze and print each component of the Cause.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Error logging
  // TODO: Implement an error logging middleware:
  //       def withErrorLogging[R, E, A](label: String)(effect: ZIO[R, E, A]): ZIO[R, E, A]
  //       On failure, log the error with the label. On success, do nothing.
  //       Test with both succeeding and failing effects.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Debug print
  // TODO: Use .tap and .tapError to add debug print statements
  //       at various points in an effect chain.
  //       Print intermediate values as they flow through the chain.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Timing
  // TODO: Implement a timing utility:
  //       def timed[R, E, A](label: String)(effect: ZIO[R, E, A]): ZIO[R with Clock with Console, E, A]
  //       Measure and print the duration with the label. Test with several effects.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Profiling (6 exercises for last file)
  // TODO: Build a simple profiler that tracks:
  //       - Call count per operation
  //       - Total time per operation
  //       - Average time per operation
  //       Print a profiling report.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7)
      .exitCode
}
