package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO126 - Custom Schedule Design
 *
 * Learn how to design custom schedules with state, metrics, and adaptive behavior.
 */
object Zio126_CustomSchedule extends App {

  // ============================================================
  // Exercise 1: Custom recurrence
  // TODO: Create a custom schedule that retries exactly on Fibonacci intervals:
  //       1ms, 1ms, 2ms, 3ms, 5ms, 8ms, ...
  //       Use Schedule.unfold to build the Fibonacci sequence.
  //       Test with a failing effect. Print retry delays.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Custom delay
  // TODO: Create a schedule with custom delay calculation:
  //       Base delay * (attempt number) capped at 5 seconds.
  //       E.g., 100ms, 200ms, 300ms, ..., 5000ms, 5000ms, ...
  //       Print each delay.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Schedule with state
  // TODO: Create a schedule that tracks state:
  //       - Tracks total retry count
  //       - Tracks cumulative delay
  //       - Stops when cumulative delay exceeds 10 seconds
  //       Print state at each step.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Schedule metrics
  // TODO: Create a schedule wrapper that collects metrics:
  //       - Number of executions
  //       - Min/max/avg delay
  //       - Total elapsed time
  //       Print metrics after the schedule completes.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Adaptive schedule
  // TODO: Create a schedule that adapts based on the error type:
  //       - TransientError: fast retry (100ms)
  //       - RateLimitError: slow retry (5 seconds)
  //       - PermanentError: no retry
  //       Print which strategy is used.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Feedback schedule
  // TODO: Create a schedule that adjusts delay based on the result:
  //       If the result is "partial", retry quickly.
  //       If the result is "almost", retry with medium delay.
  //       If the result is "success", stop.
  //       Use Schedule.recurWhile with custom logic. Print progression.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6)
      .exitCode
}
