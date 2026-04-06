package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO087 - Pooled Resources
 *
 * Learn how to build and manage resource pools using ZManaged.
 */
object Zio087_PooledResources extends App {

  // ============================================================
  // Exercise 1: Resource pool concept
  // TODO: Create a simple resource pool using a Queue[Int] representing
  //       available connection IDs. Implement acquire (take from queue)
  //       and release (offer back). Print acquire/release events.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Pool with ZManaged
  // TODO: Create a ZManaged-based pool that automatically returns resources.
  //       Use ZManaged.make to acquire from pool and release back.
  //       Use the managed resource in multiple sequential operations.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Connection pool
  // TODO: Simulate a database connection pool with max 3 connections.
  //       Fork 5 fibers that each need a connection for some work.
  //       Print when connections are acquired, used, and returned.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Thread pool (simulated)
  // TODO: Simulate a fixed-size thread pool (size 4) using Semaphore.
  //       Submit 10 tasks. Only 4 can run concurrently.
  //       Print task start/end with timestamps.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Pool with health check
  // TODO: Create a pool where resources can become "unhealthy".
  //       Use a Ref to track resource health. Before returning a resource
  //       to the consumer, check its health. If unhealthy, create a new one.
  //       Print health check events.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Pool sizing
  // TODO: Create a dynamic pool that starts with minSize=2 and grows to maxSize=5.
  //       Track current pool size with a Ref. Grow when all resources are in use.
  //       Print pool size changes.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Pool eviction
  // TODO: Create a pool where resources have a TTL.
  //       Use a background fiber that periodically checks for expired resources
  //       and removes them. Print eviction events.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Pool metrics
  // TODO: Create a pool that tracks metrics:
  //       - total acquires, total releases, current in-use, wait time
  //       Use Refs for counters. Print metrics after running some workload.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
