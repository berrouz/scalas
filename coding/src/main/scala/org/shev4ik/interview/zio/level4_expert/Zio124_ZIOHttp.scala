package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO124 - ZIO HTTP Patterns (Simulated)
 *
 * Learn HTTP server patterns simulated with ZIO services: routing, handlers, middleware.
 */
object Zio124_ZIOHttp extends App {

  // Simulated HTTP types
  case class HttpRequest(method: String, path: String, headers: Map[String, String] = Map.empty, body: String = "")
  case class HttpResponse(status: Int, body: String, headers: Map[String, String] = Map.empty)

  type HttpHandler = HttpRequest => Task[HttpResponse]
  type HttpMiddleware = HttpHandler => HttpHandler

  // ============================================================
  // Exercise 1: Route
  // TODO: Implement a simple router that matches requests to handlers based on path.
  //       Define routes: GET /hello, GET /users, POST /users.
  //       Return 404 for unmatched routes. Print request routing.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Handler
  // TODO: Implement handlers for each route:
  //       GET /hello -> 200 "Hello, World!"
  //       GET /users -> 200 "[list of users]"
  //       POST /users -> 201 "User created"
  //       Print request/response pairs.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Middleware
  // TODO: Implement logging middleware that logs request method, path,
  //       response status, and duration. Apply to all routes.
  //       Print the middleware output.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Request/Response
  // TODO: Implement request parsing and response formatting:
  //       - Parse query parameters from path
  //       - Parse JSON body (simulated)
  //       - Format response with content-type header
  //       Print parsed request and formatted response.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Error handling
  // TODO: Implement HTTP error handling:
  //       - Map domain errors to HTTP status codes
  //       - NotFound -> 404, Unauthorized -> 401, Validation -> 400
  //       - Unhandled errors -> 500
  //       Print error responses.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Static files (simulated)
  // TODO: Implement a static file handler that serves content from
  //       a simulated file system (Map[String, String]).
  //       Serve files for /static/* paths. Return 404 if not found.
  //       Print served files.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: WebSocket concept (simulated)
  // TODO: Simulate a WebSocket connection using two Queues (in/out).
  //       Client sends messages to the in queue.
  //       Server echoes (transformed) messages to the out queue.
  //       Print the message exchange.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: HTTP client (simulated)
  // TODO: Implement a simulated HTTP client that:
  //       - Sends requests to a simulated server (handler function)
  //       - Supports GET, POST, PUT, DELETE
  //       - Handles timeouts and retries
  //       Print client requests and responses.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
