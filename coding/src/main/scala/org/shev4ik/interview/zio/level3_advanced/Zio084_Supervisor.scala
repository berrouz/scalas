package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO084 - Supervisor
 *
 * Learn how to track and supervise fibers using Supervisor.
 */
object Zio084_Supervisor extends App {

  // ============================================================
  // Exercise 1: Supervisor.track
  // TODO: Create a Supervisor.track(true) to track all fibers.
  //       Fork 5 fibers under this supervisor.
  //       Use supervisor.value to get the set of tracked fibers.
  //       Print the count of tracked fibers.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Custom Supervisor
  // TODO: Create a custom Supervisor that logs when fibers start and end.
  //       Use Supervisor.fromEffect or similar to create it.
  //       Fork 3 fibers and observe the log output.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Fiber tracking
  // TODO: Use a Supervisor to track fibers. Fork fibers that complete at
  //       different times. Periodically check the supervisor for active fibers.
  //       Print the count at each check.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Supervision strategy
  // TODO: Implement a supervision strategy that restarts a fiber if it fails.
  //       Use a Ref to count restarts. Limit to 3 restarts max.
  //       Print restart events and final count.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Restart count
  // TODO: Create a fiber that fails intermittently (use a Ref counter).
  //       Implement supervision that tracks the number of restarts.
  //       After the fiber eventually succeeds, print total restart count.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Supervision metrics
  // TODO: Track supervision metrics: total fibers started, total completed,
  //       total failed. Use Refs to maintain counters.
  //       Fork a mix of succeeding and failing fibers.
  //       Print the final metrics.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Child fiber management
  // TODO: Fork a parent fiber that forks child fibers.
  //       When the parent is interrupted, ensure all children are also interrupted.
  //       Use a Ref to track which fibers were interrupted. Print the result.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Supervision tree
  // TODO: Build a supervision tree with 3 levels: root -> managers -> workers.
  //       Each level supervises the next. If a worker fails, its manager
  //       restarts it. Print the tree activity.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
