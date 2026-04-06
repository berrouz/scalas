package org.shev4ik.interview.http4s.level2_intermediate

/**
 * Http4s 006 - Middleware
 *
 * Middleware wraps HTTP handlers to add cross-cutting concerns.
 * Key concepts:
 *   - Middleware as function transformation: Service => Service
 *   - Logging middleware (request/response logging)
 *   - CORS middleware (cross-origin resource sharing)
 *   - Authentication middleware (extracting credentials)
 *   - Middleware composition (stacking multiple middlewares)
 *   - Before/after hooks in the request pipeline
 */
object Http006_Middleware {

  // --- Domain models ---

  sealed trait Method
  object Method {
    case object GET     extends Method
    case object POST    extends Method
    case object PUT     extends Method
    case object DELETE  extends Method
    case object OPTIONS extends Method
  }

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val Forbidden: Status = Status(403, "Forbidden")
    val Unauthorized: Status = Status(401, "Unauthorized")
  }

  case class Header(name: String, value: String)
  case class Request(method: Method, path: String, headers: List[Header], body: Option[String])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  // A Service is a function from Request to Response
  type Service = Request => Response

  // A Middleware transforms a Service into a new Service
  type Middleware = Service => Service

  // Exercise 1: Create a logging middleware
  // TODO: Return a Middleware that logs each request and response.
  //   Use the provided log function to record:
  //     Before: log(s">> ${request.method} ${request.path}")
  //     After:  log(s"<< ${response.status.code}")
  //   Then pass through to the wrapped service.
  def exercise1_loggingMiddleware(log: String => Unit): Middleware = ???

  // Exercise 2: Create a CORS middleware
  // TODO: Return a Middleware that adds CORS headers to every response:
  //   Header("Access-Control-Allow-Origin", allowedOrigin)
  //   Header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS")
  //   Header("Access-Control-Allow-Headers", "Content-Type,Authorization")
  //   For OPTIONS requests, return Status.Ok with empty body and the CORS headers
  //   (without calling the wrapped service).
  def exercise2_corsMiddleware(allowedOrigin: String): Middleware = ???

  // Exercise 3: Create an authentication middleware
  // TODO: Return a Middleware that checks for an "Authorization" header.
  //   If the header value matches the expectedToken, pass through to the wrapped service.
  //   If the header is missing or doesn't match, return Response(Status.Unauthorized, ..., Some("Unauthorized"))
  //   Add Header("WWW-Authenticate", "Bearer") to the 401 response.
  def exercise3_authMiddleware(expectedToken: String): Middleware = ???

  // Exercise 4: Create a request ID middleware
  // TODO: Return a Middleware that adds a Header("X-Request-Id", requestId) to both
  //   the request (passed to the service) and the response (returned to the caller).
  //   Use the provided generateId function to create the ID.
  def exercise4_requestIdMiddleware(generateId: () => String): Middleware = ???

  // Exercise 5: Compose two middlewares
  // TODO: Given two Middlewares (outer and inner), compose them so that
  //   outer wraps inner wraps service. The outer middleware executes first on request
  //   and last on response (like layers of an onion).
  //   Hint: outer(inner(service))
  def exercise5_composeMiddleware(outer: Middleware, inner: Middleware): Middleware = ???

  // Exercise 6: Create a rate-limiting middleware (simplified)
  // TODO: Return a Middleware that tracks request count using a mutable counter.
  //   If the counter exceeds maxRequests, return Response(Status(429, "Too Many Requests"), ..., Some("Rate limit exceeded"))
  //   Otherwise, increment the counter and pass through.
  //   Use the provided counter (a var wrapped in a function for thread-safety simulation).
  def exercise6_rateLimitMiddleware(maxRequests: Int, getAndIncrement: () => Int): Middleware = ???

  // Exercise 7: Create a response transformation middleware
  // TODO: Return a Middleware that applies a transformation function to the response body.
  //   If the response body is Some(text), apply the transform function.
  //   If the response body is None, leave it unchanged.
  def exercise7_responseTransformMiddleware(transform: String => String): Middleware = ???

  // Exercise 8: Create a path-scoped middleware
  // TODO: Return a Middleware that only applies the given inner middleware
  //   to requests whose path starts with the given prefix.
  //   For requests that don't match the prefix, pass through directly to the service.
  def exercise8_scopedMiddleware(prefix: String, inner: Middleware): Middleware = ???

  def main(args: Array[String]): Unit = {
    val echoService: Service = req => Response(Status.Ok, List.empty, req.body)

    // Exercise 1
    var logs = List.empty[String]
    val logging = exercise1_loggingMiddleware(msg => logs = logs :+ msg)
    val loggedService = logging(echoService)
    loggedService(Request(Method.GET, "/test", List.empty, Some("hello")))
    assert(logs.exists(_.contains("GET /test")), "Exercise 1 failed: request not logged")
    assert(logs.exists(_.contains("200")), "Exercise 1 failed: response not logged")
    println("Exercise 1 passed: logging middleware works")

    // Exercise 2
    val cors = exercise2_corsMiddleware("http://example.com")
    val corsService = cors(echoService)
    val corsResp = corsService(Request(Method.GET, "/api", List.empty, Some("data")))
    assert(corsResp.headers.exists(h => h.name == "Access-Control-Allow-Origin" && h.value == "http://example.com"), "Exercise 2 failed: missing CORS origin")
    val optionsResp = corsService(Request(Method.OPTIONS, "/api", List.empty, None))
    assert(optionsResp.status == Status.Ok, "Exercise 2 failed: OPTIONS should return 200")
    assert(optionsResp.body.isEmpty, "Exercise 2 failed: OPTIONS should have empty body")
    println("Exercise 2 passed: CORS middleware works")

    // Exercise 3
    val auth = exercise3_authMiddleware("Bearer secret123")
    val authService = auth(echoService)
    val goodReq = Request(Method.GET, "/", List(Header("Authorization", "Bearer secret123")), Some("data"))
    assert(authService(goodReq).status == Status.Ok, "Exercise 3 failed: valid token should pass")
    val badReq = Request(Method.GET, "/", List(Header("Authorization", "Bearer wrong")), None)
    assert(authService(badReq).status == Status.Unauthorized, "Exercise 3 failed: bad token should fail")
    val noAuthReq = Request(Method.GET, "/", List.empty, None)
    assert(authService(noAuthReq).status == Status.Unauthorized, "Exercise 3 failed: no token should fail")
    println("Exercise 3 passed: auth middleware works")

    // Exercise 4
    var idCounter = 0
    val reqId = exercise4_requestIdMiddleware(() => { idCounter += 1; s"req-$idCounter" })
    val idService = reqId(echoService)
    val idResp = idService(Request(Method.GET, "/", List.empty, None))
    assert(idResp.headers.exists(h => h.name == "X-Request-Id" && h.value == "req-1"), "Exercise 4 failed: missing request ID in response")
    println("Exercise 4 passed: request ID middleware works")

    // Exercise 5
    var order = List.empty[String]
    val mw1: Middleware = svc => req => { order = order :+ "mw1-before"; val r = svc(req); order = order :+ "mw1-after"; r }
    val mw2: Middleware = svc => req => { order = order :+ "mw2-before"; val r = svc(req); order = order :+ "mw2-after"; r }
    val composed = exercise5_composeMiddleware(mw1, mw2)
    composed(echoService)(Request(Method.GET, "/", List.empty, None))
    assert(order == List("mw1-before", "mw2-before", "mw2-after", "mw1-after"), s"Exercise 5 failed: wrong order $order")
    println("Exercise 5 passed: middleware composition works")

    // Exercise 6
    var counter = 0
    val rateLimit = exercise6_rateLimitMiddleware(2, () => { val c = counter; counter += 1; c })
    val limitedService = rateLimit(echoService)
    assert(limitedService(Request(Method.GET, "/", List.empty, None)).status == Status.Ok, "Exercise 6 failed: req 1 should pass")
    assert(limitedService(Request(Method.GET, "/", List.empty, None)).status == Status.Ok, "Exercise 6 failed: req 2 should pass")
    assert(limitedService(Request(Method.GET, "/", List.empty, None)).status.code == 429, "Exercise 6 failed: req 3 should be rate limited")
    println("Exercise 6 passed: rate limiting middleware works")

    // Exercise 7
    val upper = exercise7_responseTransformMiddleware(_.toUpperCase)
    val upperService = upper(echoService)
    val upperResp = upperService(Request(Method.GET, "/", List.empty, Some("hello")))
    assert(upperResp.body.contains("HELLO"), "Exercise 7 failed: body not transformed")
    println("Exercise 7 passed: response transform middleware works")

    // Exercise 8
    logs = List.empty[String]
    val scopedLog = exercise8_scopedMiddleware("/api", exercise1_loggingMiddleware(msg => logs = logs :+ msg))
    val scopedService = scopedLog(echoService)
    scopedService(Request(Method.GET, "/api/users", List.empty, None))
    assert(logs.nonEmpty, "Exercise 8 failed: /api path should be logged")
    logs = List.empty[String]
    scopedService(Request(Method.GET, "/health", List.empty, None))
    assert(logs.isEmpty, "Exercise 8 failed: /health should NOT be logged")
    println("Exercise 8 passed: scoped middleware works")

    println("\nAll Http006_Middleware exercises passed!")
  }
}
