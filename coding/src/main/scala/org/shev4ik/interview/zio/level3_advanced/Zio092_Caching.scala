package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO092 - Caching
 *
 * Learn how to implement various caching strategies with ZIO.
 */
object Zio092_Caching extends App {

  // ============================================================
  // Exercise 1: Simple cache with Ref
  // TODO: Implement a simple cache using Ref[Map[String, Int]].
  //       Provide get (returns Option) and put methods.
  //       Test with several puts and gets. Print cache hits/misses.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: TTL cache
  // TODO: Implement a cache where entries expire after a TTL.
  //       Store (value, expiresAt) in the Ref. On get, check expiry.
  //       Print cache hit/miss/expired events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: LRU cache with ZIO
  // TODO: Implement an LRU cache with max size 3.
  //       When full, evict the least recently used entry.
  //       Use Ref with a data structure tracking access order.
  //       Print eviction events.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Cache refresh
  // TODO: Implement a cache that refreshes entries in the background.
  //       When an entry is near expiry (80% of TTL), trigger async refresh.
  //       Serve stale data while refreshing. Print refresh events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Cache invalidation
  // TODO: Implement cache invalidation: single key, pattern-based, and full flush.
  //       Test each invalidation type. Print cache state after each operation.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Cache stampede protection
  // TODO: Implement cache with stampede protection: when a key is missing,
  //       only ONE fiber fetches the value while others wait.
  //       Use Promise to coordinate. Print which fiber fetches vs waits.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Cache warming
  // TODO: Implement a cache that pre-warms on startup.
  //       Define a list of keys to pre-load. Warm the cache before serving.
  //       Print warming progress and readiness.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Cache metrics
  // TODO: Add metrics to a cache: hits, misses, evictions, avg lookup time.
  //       Use Refs for counters. Run a workload and print final metrics.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
