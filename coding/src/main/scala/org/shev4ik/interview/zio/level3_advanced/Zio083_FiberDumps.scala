package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO083 - Fiber Dumps and Diagnostics
 *
 * Learn how to inspect fiber state, traces, supervision, and naming.
 */
object Zio083_FiberDumps extends App {

  // ============================================================
  // Exercise 1: Fiber dump
  // TODO: Fork a long-running fiber (e.g., ZIO.sleep(10.seconds)).
  //       Use fiber.dump to get its dump/status. Print the dump info.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Fiber trace
  // TODO: Fork a fiber that performs several steps (flatMap chain).
  //       Use fiber.trace to get the execution trace. Print the trace.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Fiber supervision
  // TODO: Fork a parent fiber that forks two child fibers.
  //       Use Fiber.children (or equivalent) to list child fibers.
  //       Print the number of children.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Fiber naming
  // TODO: Fork a fiber and give it a name using Fiber.dump or
  //       by wrapping the effect. Retrieve and print the fiber's id.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Fiber local context
  // TODO: Create a FiberRef with a default value "default".
  //       Fork a fiber that sets the FiberRef to "custom".
  //       In the parent, verify the FiberRef is still "default".
  //       In the child, verify it's "custom". Print both values.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Fiber status
  // TODO: Fork a fiber that sleeps for 5 seconds.
  //       Immediately check its status (should be suspended/running).
  //       After interrupting it, check status again (should be done).
  //       Print both statuses.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Supervision tree
  // TODO: Create a supervision tree: parent -> 2 children -> each has 1 grandchild.
  //       Use fiber dumps to visualize the tree structure.
  //       Print a tree-like representation.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Dump analysis
  // TODO: Fork multiple fibers with different states (running, sleeping, completed).
  //       Collect all fiber dumps and categorize them by status.
  //       Print a summary: "Running: N, Suspended: M, Done: K"
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
