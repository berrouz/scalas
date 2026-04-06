package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO100 - Tracing Concepts
 *
 * Learn how to implement tracing patterns with ZIO using FiberRef and manual span management.
 */
object Zio100_Tracing extends App {

  // ============================================================
  // Exercise 1: Tracing concept
  // TODO: Define a Span case class with spanId, name, startTime, endTime.
  //       Create a simple span around an effect.
  //       Print the span info after completion.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Span creation
  // TODO: Implement a withSpan helper:
  //       def withSpan[R, E, A](name: String)(effect: ZIO[R, E, A]): ZIO[R with Clock, E, A]
  //       that records start/end times and prints span info. Test it.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Context propagation
  // TODO: Use FiberRef to propagate a traceId through the call chain.
  //       functionA calls functionB calls functionC.
  //       Each function logs its name with the traceId. Print the logs.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Trace ID generation
  // TODO: Implement trace ID generation (e.g., UUID-like string).
  //       Set the trace ID at the entry point. Propagate it via FiberRef.
  //       Multiple concurrent requests should each have unique trace IDs.
  //       Print trace IDs from each request.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Span attributes
  // TODO: Extend the Span model with attributes: Map[String, String].
  //       Add attributes like "http.method" -> "GET", "http.url" -> "/api/users".
  //       Print the span with its attributes.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Nested spans
  // TODO: Implement nested spans: a parent span contains child spans.
  //       Use FiberRef to track the current span.
  //       Create parent "handleRequest" with children "validate", "process", "respond".
  //       Print the span tree.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Trace across services
  // TODO: Simulate tracing across 3 services: API -> UserService -> Database.
  //       Propagate trace context between services (via parameters or FiberRef).
  //       Each service creates its own span. Print the distributed trace.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Trace reporting
  // TODO: Implement a trace reporter that collects all spans into a
  //       Ref[List[Span]]. After the request, print a formatted trace report
  //       showing the call tree with durations.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
