package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._
import zio.stream._

/**
 * ZIO103 - Backpressure Design
 *
 * Learn how to design backpressure strategies for different scenarios.
 */
object Zio103_BackpressureDesign extends App {

  // ============================================================
  // Exercise 1: Backpressure strategy
  // TODO: Implement and compare three strategies for a fast producer / slow consumer:
  //       (a) Block producer (bounded queue)
  //       (b) Drop newest (when full)
  //       (c) Drop oldest (sliding window)
  //       Print which elements each strategy delivers.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Bounded queue backpressure
  // TODO: Create a bounded Queue of size 5.
  //       Producer adds 20 items (with logging).
  //       Consumer processes slowly (100ms per item).
  //       Observe that producer blocks when queue is full. Print events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Dropping strategy
  // TODO: Create a dropping Queue (capacity 5).
  //       Producer adds 20 items rapidly.
  //       Consumer processes slowly.
  //       Print which items were dropped and which were processed.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Sliding strategy
  // TODO: Create a sliding Queue (capacity 5).
  //       Producer adds 20 items rapidly.
  //       Consumer processes slowly.
  //       Print which items the consumer actually receives (should be latest).
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Throttle design
  // TODO: Design a throttling mechanism: allow at most N items per second.
  //       Excess items are queued. Print throughput metrics.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Flow control
  // TODO: Implement flow control: consumer signals producer to slow down
  //       or speed up based on queue depth. Use Ref for signaling.
  //       Print rate adjustments.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Producer-consumer balance
  // TODO: Implement adaptive producer-consumer balance:
  //       Monitor queue depth. If > 80% full, slow producer.
  //       If < 20% full, speed up producer.
  //       Print queue depth and rate adjustments.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Backpressure metrics
  // TODO: Add metrics to a backpressure system:
  //       - Items produced/consumed per second
  //       - Queue depth over time
  //       - Number of blocked/dropped items
  //       Print a metrics summary.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
