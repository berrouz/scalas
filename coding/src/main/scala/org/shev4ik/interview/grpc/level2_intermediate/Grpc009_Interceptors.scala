package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC 009 - Interceptors
 *
 * Interceptors are middleware that process requests/responses in the gRPC pipeline.
 * Key concepts:
 *   - Client interceptors: modify outgoing requests and incoming responses
 *   - Server interceptors: modify incoming requests and outgoing responses
 *   - Chaining: multiple interceptors execute in order (like a pipeline)
 *   - Common uses: logging, authentication, metrics, retry logic, tracing
 *   - Interceptors can short-circuit (return error without calling the next handler)
 *   - Metadata manipulation: add/remove/modify headers in interceptors
 */
object Grpc009_Interceptors {

  // --- Domain models for exercises ---

  case class Metadata(headers: Map[String, String])

  case class Request(
    method: String,
    body: String,
    metadata: Metadata
  )

  sealed trait StatusCode
  object StatusCode {
    case object OK              extends StatusCode
    case object Unauthenticated extends StatusCode
    case object PermissionDenied extends StatusCode
    case object Internal        extends StatusCode
    case object RateLimited     extends StatusCode
  }

  case class Response(
    statusCode: StatusCode,
    body: String,
    metadata: Metadata
  )

  // An interceptor takes a request, a next handler, and returns a response
  type Handler = Request => Response
  type Interceptor = (Request, Handler) => Response

  case class InterceptorChain(
    interceptors: List[Interceptor],
    finalHandler: Handler
  )

  case class LogEntry(
    method: String,
    direction: String, // "request" or "response"
    message: String
  )

  // Exercise 1: Implement a logging interceptor
  // TODO: Create an interceptor that appends log entries to a mutable buffer.
  //   Before calling next: log (method, "request", "incoming request")
  //   After calling next: log (method, "response", "status: <statusCode>")
  //   Return the response from next unchanged.
  def exercise1_loggingInterceptor(logBuffer: scala.collection.mutable.ListBuffer[LogEntry]): Interceptor = ???

  // Exercise 2: Implement an authentication interceptor
  // TODO: Create an interceptor that checks for an "authorization" header.
  //   - If the header is present and starts with "Bearer ", call next handler
  //   - If the header is missing or doesn't start with "Bearer ", return
  //     Response(Unauthenticated, "missing or invalid auth token", empty metadata)
  //     WITHOUT calling the next handler.
  def exercise2_authInterceptor: Interceptor = ???

  // Exercise 3: Implement a metadata injection interceptor
  // TODO: Create an interceptor that adds headers to the request before passing
  //   it to the next handler. Given a Map[String, String] of headers to add,
  //   merge them into the request's existing metadata (new headers override existing).
  def exercise3_metadataInjector(extraHeaders: Map[String, String]): Interceptor = ???

  // Exercise 4: Build and execute an interceptor chain
  // TODO: Given an InterceptorChain, execute it by nesting interceptors.
  //   The first interceptor in the list wraps the second, which wraps the third, etc.
  //   The innermost interceptor wraps the finalHandler.
  //   Return the response from executing the chain with the given request.
  def exercise4_executeChain(chain: InterceptorChain, request: Request): Response = ???

  // Exercise 5: Implement a retry interceptor
  // TODO: Create an interceptor that retries the request if the response status is Internal.
  //   Retry up to `maxRetries` times. If all retries fail, return the last response.
  //   For each retry, add a header "x-retry-count" -> current retry number (as String).
  def exercise5_retryInterceptor(maxRetries: Int): Interceptor = ???

  // Exercise 6: Implement a rate limiting interceptor
  // TODO: Create an interceptor that tracks call counts in a mutable map (method -> count).
  //   If the count for a method exceeds `maxCallsPerMethod`, return
  //   Response(RateLimited, "rate limit exceeded", empty metadata) without calling next.
  //   Otherwise, increment the count and call next.
  def exercise6_rateLimitInterceptor(
    maxCallsPerMethod: Int,
    callCounts: scala.collection.mutable.Map[String, Int]
  ): Interceptor = ???

  // Exercise 7: Implement a response transformation interceptor
  // TODO: Create an interceptor that transforms the response body.
  //   Given a function String => String, apply it to the response body after
  //   calling the next handler. Preserve status and metadata.
  def exercise7_responseTransformer(transform: String => String): Interceptor = ???

  // Exercise 8: Implement a circuit breaker interceptor
  // TODO: Create an interceptor using mutable state:
  //   - Track consecutive failures (non-OK responses) in a mutable var wrapper
  //   - If consecutiveFailures >= threshold, the circuit is "open":
  //     return Response(Internal, "circuit breaker open", empty metadata)
  //     without calling next
  //   - If the circuit is "closed" (failures < threshold), call next:
  //     - On OK response, reset failures to 0
  //     - On non-OK response, increment failures
  //   Use the provided mutable state holder.
  case class CircuitState(var consecutiveFailures: Int)

  def exercise8_circuitBreakerInterceptor(
    threshold: Int,
    state: CircuitState
  ): Interceptor = ???

  def main(args: Array[String]): Unit = {
    val okHandler: Handler = _ => Response(StatusCode.OK, "success", Metadata(Map.empty))
    val testReq = Request("/test", "body", Metadata(Map.empty))

    // Exercise 1
    val logBuffer = scala.collection.mutable.ListBuffer.empty[LogEntry]
    val logger = exercise1_loggingInterceptor(logBuffer)
    val logResp = logger(testReq, okHandler)
    assert(logResp.statusCode == StatusCode.OK, "Exercise 1 failed: wrong status")
    assert(logBuffer.length == 2, "Exercise 1 failed: expected 2 log entries, got " + logBuffer.length)
    assert(logBuffer(0).direction == "request", "Exercise 1 failed: first entry should be request")
    assert(logBuffer(1).direction == "response", "Exercise 1 failed: second entry should be response")
    println("Exercise 1 passed: logging interceptor works")

    // Exercise 2
    val auth = exercise2_authInterceptor
    val noAuthResp = auth(testReq, okHandler)
    assert(noAuthResp.statusCode == StatusCode.Unauthenticated, "Exercise 2 failed: no auth")
    val authReq = Request("/test", "body", Metadata(Map("authorization" -> "Bearer token123")))
    val authResp = auth(authReq, okHandler)
    assert(authResp.statusCode == StatusCode.OK, "Exercise 2 failed: valid auth rejected")
    println("Exercise 2 passed: auth interceptor works")

    // Exercise 3
    val injector = exercise3_metadataInjector(Map("x-trace-id" -> "abc123"))
    var capturedReq: Option[Request] = None
    val capturingHandler: Handler = req => { capturedReq = Some(req); okHandler(req) }
    injector(testReq, capturingHandler)
    assert(capturedReq.exists(_.metadata.headers("x-trace-id") == "abc123"),
      "Exercise 3 failed: header not injected")
    println("Exercise 3 passed: metadata injection works")

    // Exercise 4
    val logBuf2 = scala.collection.mutable.ListBuffer.empty[LogEntry]
    val chain = InterceptorChain(
      List(exercise1_loggingInterceptor(logBuf2), exercise2_authInterceptor),
      okHandler
    )
    val chainResp = exercise4_executeChain(chain, authReq)
    assert(chainResp.statusCode == StatusCode.OK, "Exercise 4 failed: chain should succeed")
    assert(logBuf2.nonEmpty, "Exercise 4 failed: logger should have entries")
    val chainResp2 = exercise4_executeChain(chain, testReq)
    assert(chainResp2.statusCode == StatusCode.Unauthenticated, "Exercise 4 failed: should fail auth")
    println("Exercise 4 passed: interceptor chain execution works")

    // Exercise 5
    var callCount = 0
    val failingHandler: Handler = req => {
      callCount += 1
      if (callCount <= 2) Response(StatusCode.Internal, "error", Metadata(Map.empty))
      else Response(StatusCode.OK, "recovered", Metadata(Map.empty))
    }
    callCount = 0
    val retry = exercise5_retryInterceptor(3)
    val retryResp = retry(testReq, failingHandler)
    assert(retryResp.statusCode == StatusCode.OK, "Exercise 5 failed: should have recovered")
    assert(callCount == 3, s"Exercise 5 failed: expected 3 calls, got $callCount")
    println("Exercise 5 passed: retry interceptor works")

    // Exercise 6
    val counts = scala.collection.mutable.Map.empty[String, Int]
    val limiter = exercise6_rateLimitInterceptor(2, counts)
    assert(limiter(testReq, okHandler).statusCode == StatusCode.OK, "Exercise 6 failed: first call")
    assert(limiter(testReq, okHandler).statusCode == StatusCode.OK, "Exercise 6 failed: second call")
    assert(limiter(testReq, okHandler).statusCode == StatusCode.RateLimited, "Exercise 6 failed: third call")
    println("Exercise 6 passed: rate limiting works")

    // Exercise 7
    val transformer = exercise7_responseTransformer(_.toUpperCase)
    val transResp = transformer(testReq, okHandler)
    assert(transResp.body == "SUCCESS", "Exercise 7 failed: body not transformed")
    assert(transResp.statusCode == StatusCode.OK, "Exercise 7 failed: status changed")
    println("Exercise 7 passed: response transformation works")

    // Exercise 8
    val cbState = CircuitState(0)
    val cb = exercise8_circuitBreakerInterceptor(2, cbState)
    val errorHandler: Handler = _ => Response(StatusCode.Internal, "error", Metadata(Map.empty))
    cb(testReq, errorHandler)
    assert(cbState.consecutiveFailures == 1, "Exercise 8 failed: should be 1 failure")
    cb(testReq, errorHandler)
    assert(cbState.consecutiveFailures == 2, "Exercise 8 failed: should be 2 failures")
    val cbOpen = cb(testReq, okHandler)
    assert(cbOpen.body == "circuit breaker open", "Exercise 8 failed: circuit should be open")
    cbState.consecutiveFailures = 0 // manually reset
    val cbClosed = cb(testReq, okHandler)
    assert(cbClosed.statusCode == StatusCode.OK, "Exercise 8 failed: circuit should be closed")
    assert(cbState.consecutiveFailures == 0, "Exercise 8 failed: should reset on OK")
    println("Exercise 8 passed: circuit breaker works")

    println("\nAll Grpc009_Interceptors exercises passed!")
  }
}
