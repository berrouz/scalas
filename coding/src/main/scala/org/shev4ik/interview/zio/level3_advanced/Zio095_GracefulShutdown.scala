package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO095 - Graceful Shutdown
 *
 * Learn how to implement graceful shutdown patterns in ZIO applications.
 */
object Zio095_GracefulShutdown extends App {

  // ============================================================
  // Exercise 1: Shutdown hook
  // TODO: Create an application that registers a shutdown hook using
  //       ZIO.addFinalizer or ZManaged. When the app completes,
  //       the hook should print "Shutting down...". Print lifecycle events.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Graceful stop
  // TODO: Create a long-running fiber (simulating a server).
  //       Implement graceful stop: set a flag (Ref[Boolean]) to signal stop,
  //       then wait for the fiber to finish its current work before joining.
  //       Print progress and shutdown events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Drain queue
  // TODO: Create a Queue with pending items. On shutdown, drain all
  //       remaining items before exiting. Print each drained item.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Wait for completion
  // TODO: Fork 5 worker fibers processing tasks.
  //       On shutdown signal, stop accepting new tasks but wait for
  //       all in-progress tasks to complete. Print completion events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Timeout shutdown
  // TODO: Implement shutdown with a timeout: try graceful shutdown first,
  //       but if it takes longer than 3 seconds, force shutdown (interrupt).
  //       Print whether shutdown was graceful or forced.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Signal handling concept
  // TODO: Simulate signal handling: create a Promise that represents
  //       a shutdown signal. A background fiber waits on the promise.
  //       The main logic completes the promise to trigger shutdown.
  //       Print signal handling events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Shutdown coordination
  // TODO: Coordinate shutdown of multiple services:
  //       ServiceA, ServiceB, ServiceC (simulated with Refs).
  //       Shut them down in reverse startup order.
  //       Print startup and shutdown order.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Cleanup ordering
  // TODO: Use ZManaged to create 3 resources with cleanup.
  //       Verify that cleanup happens in reverse acquisition order.
  //       One cleanup should fail - verify other cleanups still run.
  //       Print all lifecycle events.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
