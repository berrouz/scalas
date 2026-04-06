package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.clock.Clock
import zio.stream._
import zio.console._
import zio.duration._

/**
 * ZIO076 - Stream Grouping Operations
 *
 * Learn how to group, partition, and broadcast ZIO Streams.
 */
object Zio076_StreamGrouped extends App {

  // ============================================================
  // Exercise 1: groupByKey
  // TODO: Create a stream of (String, Int) pairs representing (category, value).
  //       Use groupByKey to group by category and sum values per group.
  //       Print each group's total.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: grouped
  // TODO: Create a stream of integers 1 to 20.
  //       Use .grouped(5) to batch them into chunks of 5.
  //       Collect and print each chunk.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: groupedWithin
  // TODO: Create a stream of integers.
  //       Use .groupedWithin(10, 1.second) to batch by size OR time.
  //       Collect and print the batches.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: groupAdjacentBy
  // TODO: Create a stream: 1, 1, 2, 2, 2, 3, 1, 1
  //       Use groupAdjacentBy(identity) to group adjacent equal elements.
  //       Collect and print the groups.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: partition
  // TODO: Create a stream of integers 1 to 10.
  //       Use .partition(n => n % 2 == 0) to split into even and odd streams.
  //       Collect both and print results.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: broadcast
  // TODO: Create a stream of integers 1 to 5.
  //       Use .broadcast(2, 16) to broadcast to 2 consumers.
  //       Each consumer should process the stream differently
  //       (e.g., one sums, the other counts). Print both results.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: distributedWith
  // TODO: Create a stream of integers 1 to 10.
  //       Use .distributedWith(2, 16, n => ZIO.succeed(n % 2))
  //       to distribute evens to one consumer and odds to another.
  //       Collect and print each consumer's elements.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: distributedWithDynamic
  // TODO: Create a stream of strings: "a1", "b1", "a2", "b2", "a3".
  //       Distribute them dynamically based on the first character.
  //       Collect and print elements per group.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
