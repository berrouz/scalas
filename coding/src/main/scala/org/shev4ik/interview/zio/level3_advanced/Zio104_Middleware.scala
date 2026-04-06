package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO104 - Middleware Pattern
 *
 * Learn how to implement composable middleware with ZIO.
 */
object Zio104_Middleware extends App {

  // A simple request/response model
  case class Request(path: String, headers: Map[String, String] = Map.empty)
  case class Response(status: Int, body: String)

  type Handler = Request => Task[Response]
  type Middleware = Handler => Handler

  // ============================================================
  // Exercise 1: Middleware type
  // TODO: Define a basic handler that returns Response(200, "OK") for any request.
  //       Define a middleware type as Handler => Handler.
  //       Apply an identity middleware (does nothing). Print the response.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Logging middleware
  // TODO: Implement a logging middleware that prints the request path
  //       and the response status before/after calling the handler.
  //       Apply it to a handler. Print the log output.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Timing middleware
  // TODO: Implement a middleware that measures handler execution time.
  //       Print the duration after each request. Use clock.nanoTime.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Auth middleware
  // TODO: Implement an auth middleware that checks for an "Authorization" header.
  //       If missing, return Response(401, "Unauthorized") without calling the handler.
  //       If present, call the handler. Test both cases.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Rate limit middleware
  // TODO: Implement a rate limit middleware using a Ref[Int] counter.
  //       Allow at most 5 requests. After that, return Response(429, "Too Many Requests").
  //       Test with 7 requests. Print results.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Retry middleware
  // TODO: Implement a retry middleware that retries the handler up to 3 times
  //       on failure. Use a Ref to track attempts. Print retry events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Middleware composition
  // TODO: Compose logging, timing, and auth middleware.
  //       Apply them in order: logging(timing(auth(handler))).
  //       Test with a request. Print all middleware effects.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Middleware ordering
  // TODO: Show that middleware ordering matters.
  //       Apply auth before logging vs logging before auth.
  //       With an unauthorized request, show different log outputs.
  //       Print both orderings.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
