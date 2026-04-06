package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO110 - Fiber Runtime Internals
 *
 * Explore fiber internals: scheduler, stack, continuations, suspend/resume, mailbox, and execution model.
 */
object Zio110_FiberRuntime extends App {

  // ============================================================
  // Exercise 1: Fiber internals
  // TODO: Fork a fiber and inspect its internal state.
  //       Use fiber.id, fiber.status, and fiber.dump.
  //       Print the fiber's internal information.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Fiber scheduler
  // TODO: Demonstrate how the fiber scheduler works by creating
  //       many fibers (100) that yield (ZIO.yieldNow) between steps.
  //       Print which fiber is executing at each step to show interleaving.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Fiber stack
  // TODO: Create a deeply nested effect (1000 levels of flatMap).
  //       Demonstrate that ZIO handles this without stack overflow
  //       (thanks to trampolining). Print completion message.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Fiber continuation
  // TODO: Demonstrate the continuation model:
  //       Create an effect with multiple flatMap steps.
  //       Show that each step is a continuation by logging at each step.
  //       Print the execution flow.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Fiber suspend/resume
  // TODO: Demonstrate fiber suspend and resume:
  //       Fork a fiber that waits on a Promise (suspended).
  //       After a delay, complete the Promise (resumes the fiber).
  //       Print suspend/resume events with timestamps.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Fiber mailbox (interruption)
  // TODO: Demonstrate the fiber mailbox concept by sending an interrupt
  //       to a running fiber. The fiber should be doing work when interrupted.
  //       Use ensuring to show that the interrupt was received.
  //       Print interrupt handling events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Fiber execution model
  // TODO: Show the cooperative execution model:
  //       Create 3 fibers that each do compute-bound work with periodic yields.
  //       Use ZIO.yieldNow to show cooperative scheduling.
  //       Print interleaved execution evidence.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Fiber optimization
  // TODO: Compare:
  //       (a) Many small fibers (10,000 fibers, 1 unit of work each)
  //       (b) Fewer fibers with more work (10 fibers, 1000 units each)
  //       Measure and compare overhead. Print timing results.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
