package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.clock.Clock
import zio.stream._
import zio.console._
import zio.duration._

/**
 * ZIO079 - Stream Broadcasting
 *
 * Learn how to broadcast streams to multiple consumers.
 */
object Zio079_StreamBroadcast extends App {

  // ============================================================
  // Exercise 1: broadcast
  // TODO: Create a stream of integers 1 to 10.
  //       Use .broadcast(3, 16) to broadcast to 3 consumers.
  //       Consumer 1: sum all elements
  //       Consumer 2: count elements
  //       Consumer 3: find max element
  //       Print all three results.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: broadcastDynamic
  // TODO: Create a stream of events (strings).
  //       Use .broadcastDynamic(16) to create a managed subscription mechanism.
  //       Create 2 subscribers that each process the stream. Print their outputs.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: broadcastQueues
  // TODO: Create a stream of integers 1 to 5.
  //       Use .broadcastQueues(2, 16) to get 2 queues.
  //       Read from each queue concurrently and print.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Fan-out pattern
  // TODO: Implement a fan-out pattern: one source stream distributes work
  //       to N worker fibers. Each worker processes elements and writes
  //       results to a shared output queue. Collect and print all results.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Multicast
  // TODO: Create a "multicast" helper that takes a stream and a list of
  //       processing functions, runs each function on the full stream
  //       concurrently, and returns all results.
  //       Test with a stream of 1 to 5 and three different transformations.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Subscriber management
  // TODO: Simulate a pub/sub system using Hub:
  //       - Create a Hub[String]
  //       - Subscribe 2 consumers
  //       - Publish 3 messages
  //       - Each consumer prints received messages
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Broadcast with backpressure
  // TODO: Create a stream that produces faster than consumers can handle.
  //       Use .broadcast(2, 4) with a small buffer.
  //       One consumer is slow (adds delay), one is fast.
  //       Observe backpressure behavior. Print processing info.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Broadcast error handling
  // TODO: Create a stream of integers 1 to 10.
  //       Broadcast to 2 consumers. One consumer fails at element 5.
  //       Handle the error so the other consumer continues.
  //       Print results from both consumers.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
