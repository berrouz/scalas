package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO101 - Resource Safety
 *
 * Learn about safe resource acquisition, release guarantees, ordering, and composition.
 */
object Zio101_ResourceSafety extends App {

  // ============================================================
  // Exercise 1: Resource acquisition
  // TODO: Use ZManaged.make to safely acquire a resource (simulated file handle).
  //       The acquire effect should print "opened" and the release should print "closed".
  //       Use the resource and print "using". Verify the lifecycle order.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Resource release guarantee
  // TODO: Acquire a resource, then fail during use.
  //       Verify the resource is STILL released despite the failure.
  //       Catch the error and print lifecycle events.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Resource ordering
  // TODO: Acquire 3 resources: DB, Cache, API (in that order).
  //       Verify they are released in reverse order: API, Cache, DB.
  //       Print acquisition and release events.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Resource composition
  // TODO: Create two ZManaged resources and compose them with zip.
  //       Both should be acquired before use and released after.
  //       Print the lifecycle of the composed resource.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Resource timeout
  // TODO: Create a resource that takes a long time to acquire (simulated).
  //       Apply a timeout to the acquisition. If timeout occurs,
  //       ensure no resource leak. Print events.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Resource error handling
  // TODO: Create a resource where acquisition can fail.
  //       Implement retry logic for acquisition (up to 3 tries).
  //       If all retries fail, ensure clean state. Print events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Nested resources
  // TODO: Create a resource A that, when acquired, creates resource B.
  //       B depends on A. Ensure both are properly cleaned up.
  //       Print the nested lifecycle.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Resource pool safety
  // TODO: Create a pool of 3 resources using ZManaged.
  //       Safely check out and return resources.
  //       Ensure resources are returned even on failure.
  //       Print checkout/return events.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
