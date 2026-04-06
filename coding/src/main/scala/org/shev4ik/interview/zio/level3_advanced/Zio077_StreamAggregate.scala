package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.stream._
import zio.console._

/**
 * ZIO077 - Stream Aggregation
 *
 * Learn how to aggregate stream elements using sinks, transducers, and fold operations.
 */
object Zio077_StreamAggregate extends App {

  // ============================================================
  // Exercise 1: Aggregate with sink
  // TODO: Create a stream of integers 1 to 10.
  //       Use .aggregate(ZTransducer.collectAllN(3)) to batch into groups of 3.
  //       Collect and print the batches.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Transducer aggregation
  // TODO: Create a stream of strings: "hello", " ", "world", "!", " ", "zio".
  //       Use a transducer to split by spaces and collect words.
  //       Print the resulting words.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Windowed aggregation
  // TODO: Create a stream of integers 1 to 20.
  //       Use .aggregate(ZTransducer.collectAllN(5)) to create windows of 5,
  //       then compute the sum of each window. Print the sums.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Fold aggregation
  // TODO: Create a stream of integers 1 to 10.
  //       Use .fold(0)(_ + _) to compute the total sum.
  //       Print the result.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: collectAllN
  // TODO: Create a stream of characters 'a' to 'j'.
  //       Use ZTransducer.collectAllN(4) to batch into groups of 4.
  //       Collect and print the batches.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Scan aggregation
  // TODO: Create a stream of integers 1 to 5.
  //       Use .scan(0)(_ + _) to compute running sums.
  //       Collect and print: 0, 1, 3, 6, 10, 15
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Reduce aggregation
  // TODO: Create a stream of integers 1 to 5.
  //       Use .runReduce(_ + _) to reduce to a single sum.
  //       Print the result (should be 15).
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Weighted aggregate
  // TODO: Create a stream of (item, weight) pairs.
  //       Aggregate items into batches where total weight <= 10.
  //       Use a custom transducer or fold logic. Print the batches.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
