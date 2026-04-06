package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._
import zio.stream._

/**
 * ZIO089 - Concurrency Patterns
 *
 * Implement common concurrency patterns: pub/sub, pipelines, fan-out/fan-in, worker pools.
 */
object Zio089_ConcurrencyPatterns extends App {

  // ============================================================
  // Exercise 1: Pub/Sub with Hub
  // TODO: Create a Hub[String]. Subscribe 3 consumers.
  //       Publish 5 messages. Each consumer should receive all messages.
  //       Print what each consumer receives.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Pipeline with Queue
  // TODO: Build a 3-stage pipeline using Queues:
  //       Stage 1: Generate numbers -> Queue1
  //       Stage 2: Double numbers Queue1 -> Queue2
  //       Stage 3: Print results from Queue2
  //       Each stage runs in its own fiber.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Fan-out / Fan-in
  // TODO: Implement fan-out: distribute work from one source to N workers.
  //       Implement fan-in: collect results from N workers into one sink.
  //       Source: numbers 1-20, Workers: 4, each squares the number.
  //       Print collected results.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Worker pool
  // TODO: Create a worker pool with 3 workers using Semaphore.
  //       Submit 10 tasks. Each task takes 100ms.
  //       Print task assignments and completions.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Batch processor
  // TODO: Implement a batch processor that collects items into batches
  //       of size 5 (or timeout after 1 second) and processes each batch.
  //       Use a Queue and a background fiber for batching.
  //       Print each batch as it's processed.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Rate-limited processor
  // TODO: Implement a processor that handles at most 5 requests per second.
  //       Use a Semaphore + Schedule or token bucket pattern.
  //       Submit 20 requests. Print timestamps of processing.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Priority processor
  // TODO: Implement a priority task processor using multiple queues
  //       (high, medium, low priority). Processor drains high first,
  //       then medium, then low. Print processing order.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Pipeline with backpressure
  // TODO: Build a pipeline where each stage has a bounded queue.
  //       If a stage is slow, it backpressures the previous stage.
  //       Stage 1: fast producer, Stage 2: slow transformer, Stage 3: consumer.
  //       Print progress and show backpressure effects.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
