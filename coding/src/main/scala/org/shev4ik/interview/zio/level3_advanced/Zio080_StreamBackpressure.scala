package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.stream._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO080 - Stream Backpressure
 *
 * Learn about buffering strategies and flow control in ZIO Streams.
 */
object Zio080_StreamBackpressure extends App {

  // ============================================================
  // Exercise 1: Buffer
  // TODO: Create a fast-producing stream of integers 1 to 100.
  //       Use .buffer(16) to add a bounded buffer between producer and consumer.
  //       Add a slow consumer (ZIO.sleep per element). Print elements as consumed.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: bufferDropping
  // TODO: Create a fast stream. Use .bufferDropping(8) so that when the buffer
  //       is full, new elements are dropped. Count how many elements the
  //       consumer actually receives. Print the count.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: bufferSliding
  // TODO: Create a fast stream. Use .bufferSliding(8) so that when the buffer
  //       is full, the oldest element is dropped. Consume slowly and print
  //       the elements received (should see later elements, not earlier ones).
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: throttleShape
  // TODO: Create a stream of integers 1 to 50.
  //       Use .throttleShape(5, 1.second)(_.size.toLong) to allow 5 elements/second.
  //       Take 10 elements and print them with timestamps.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Back-pressure design
  // TODO: Design a producer-consumer system using ZStream and ZSink:
  //       - Producer: emits events at high rate
  //       - Consumer: processes at lower rate
  //       - Use buffer to decouple them
  //       Print producer/consumer rates.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Overflow strategies comparison
  // TODO: Create the same fast stream and slow consumer combination.
  //       Run it with three strategies: buffer, bufferDropping, bufferSliding.
  //       Compare the number of elements received in each case. Print results.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Buffer sizing
  // TODO: Create a stream processing pipeline. Experiment with different
  //       buffer sizes (1, 10, 100, 1000). Measure throughput for each.
  //       Print the throughput comparison.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Flow control
  // TODO: Implement a flow control mechanism using a Semaphore:
  //       - Allow at most N elements to be in-flight at once.
  //       - Producer waits when N elements are being processed.
  //       - Consumer releases the semaphore after processing.
  //       Print processing progress.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
