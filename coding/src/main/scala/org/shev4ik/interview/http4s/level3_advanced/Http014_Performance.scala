package org.shev4ik.interview.http4s.level3_advanced

/**
 * Http4s 014 - Performance
 *
 * HTTP performance patterns. Key concepts:
 *   - Connection pooling
 *   - Timeouts (connect, read, idle)
 *   - Retry strategies (exponential backoff, jitter)
 *   - Circuit breaker pattern
 *   - Rate limiting
 *   - Caching strategies (ETag, Cache-Control)
 */
object Http014_Performance {

  // --- Domain models ---

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val NotModified: Status = Status(304, "Not Modified")
    val TooManyRequests: Status = Status(429, "Too Many Requests")
    val InternalServerError: Status = Status(500, "Internal Server Error")
    val ServiceUnavailable: Status = Status(503, "Service Unavailable")
  }

  case class Header(name: String, value: String)
  case class Request(method: String, url: String, headers: List[Header])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  // Connection Pool
  case class ConnectionPool(
    maxConnections: Int,
    activeConnections: Int,
    idleConnections: Int,
    waitingRequests: Int
  ) {
    def available: Int = maxConnections - activeConnections
  }

  // Timeout configuration
  case class TimeoutConfig(
    connectTimeout: Long,   // millis
    readTimeout: Long,      // millis
    idleTimeout: Long,      // millis
    requestTimeout: Long    // millis, total end-to-end
  )

  // Retry configuration
  case class RetryConfig(
    maxRetries: Int,
    initialDelay: Long,     // millis
    maxDelay: Long,         // millis
    backoffMultiplier: Double
  )

  // Circuit Breaker
  sealed trait CircuitState
  object CircuitState {
    case object Closed   extends CircuitState  // normal operation
    case object Open     extends CircuitState  // failing, reject requests
    case object HalfOpen extends CircuitState  // testing if service recovered
  }

  case class CircuitBreaker(
    state: CircuitState,
    failureCount: Int,
    successCount: Int,
    failureThreshold: Int,
    successThreshold: Int,    // successes needed in HalfOpen to close
    lastFailureTime: Long
  )

  // Cache entry
  case class CacheEntry(
    url: String,
    response: Response,
    etag: Option[String],
    maxAge: Long,            // seconds
    cachedAt: Long           // timestamp millis
  ) {
    def isExpired(now: Long): Boolean = (now - cachedAt) > (maxAge * 1000)
  }

  // Exercise 1: Calculate retry delay with exponential backoff
  // TODO: Given a RetryConfig and the current attempt number (0-based),
  //   calculate the delay: initialDelay * (backoffMultiplier ^ attempt)
  //   Cap at maxDelay. Return the delay in milliseconds as Long.
  def exercise1_retryDelay(config: RetryConfig, attempt: Int): Long = ???

  // Exercise 2: Add jitter to a retry delay
  // TODO: Given a base delay and a jitter factor (0.0 to 1.0),
  //   return a range (min, max) for the jittered delay.
  //   min = delay * (1 - jitterFactor)
  //   max = delay * (1 + jitterFactor)
  //   Return as (Long, Long)
  def exercise2_jitteredDelay(baseDelay: Long, jitterFactor: Double): (Long, Long) = ???

  // Exercise 3: Update a circuit breaker on a request result
  // TODO: Given a CircuitBreaker and a boolean (true=success, false=failure):
  //   In Closed state:
  //     - failure: increment failureCount, if >= threshold -> Open state, record time
  //     - success: reset failureCount to 0
  //   In Open state:
  //     - Do not change (requests should be rejected, checked separately)
  //   In HalfOpen state:
  //     - success: increment successCount, if >= successThreshold -> Closed state (reset counts)
  //     - failure: -> Open state, reset successCount, record time
  //   Return updated CircuitBreaker.
  def exercise3_updateCircuitBreaker(
    cb: CircuitBreaker,
    success: Boolean,
    currentTime: Long
  ): CircuitBreaker = ???

  // Exercise 4: Determine if a circuit breaker should allow a request
  // TODO: Given a CircuitBreaker and the current time:
  //   Closed -> allow (true)
  //   Open -> allow only if cooldown period (5000ms) has passed since lastFailureTime
  //           (transition to HalfOpen and return true)
  //   HalfOpen -> allow (true, to test if service recovered)
  //   Return (shouldAllow: Boolean, updatedCircuitBreaker: CircuitBreaker)
  def exercise4_shouldAllowRequest(
    cb: CircuitBreaker,
    currentTime: Long
  ): (Boolean, CircuitBreaker) = ???

  // Exercise 5: Manage a connection pool - acquire and release
  // TODO: Given a ConnectionPool:
  //   acquire: if available > 0, decrement idle (if > 0) or just increment active.
  //     Return (Some(connectionId), updatedPool). connectionId = s"conn-$activeConnections"
  //     If no available connections, increment waitingRequests, return (None, updatedPool).
  //   release: decrement active, increment idle (up to maxConnections - active).
  //     If waitingRequests > 0, decrement waitingRequests.
  //     Return updatedPool.
  def exercise5_acquireConnection(pool: ConnectionPool): (Option[String], ConnectionPool) = ???
  def exercise5_releaseConnection(pool: ConnectionPool): ConnectionPool = ???

  // Exercise 6: Implement HTTP caching logic
  // TODO: Given a cache (Map[String, CacheEntry]), a Request URL, and current time:
  //   - If URL is in cache and not expired, return (Some(cachedResponse), cache) (cache hit)
  //   - If URL is in cache but expired, return (None, cache) (stale, should re-fetch)
  //   - If URL is not in cache, return (None, cache) (cache miss)
  def exercise6_checkCache(
    cache: Map[String, CacheEntry],
    url: String,
    now: Long
  ): (Option[Response], Map[String, CacheEntry]) = ???

  // Exercise 7: Build Cache-Control header directives
  // TODO: Given parameters, build a Cache-Control header value string:
  //   isPublic: true -> "public", false -> "private"
  //   maxAge: Some(n) -> "max-age=n"
  //   noCache: true -> "no-cache"
  //   noStore: true -> "no-store"
  //   Combine with ", " separator. noStore takes precedence (if true, only "no-store").
  def exercise7_buildCacheControl(
    isPublic: Boolean,
    maxAge: Option[Int],
    noCache: Boolean,
    noStore: Boolean
  ): String = ???

  // Exercise 8: Determine if a response should be retried
  // TODO: Given a response status code and a RetryConfig with current attempt count:
  //   - Retry on 429 (Too Many Requests), 500, 502, 503, 504
  //   - Do NOT retry on success (2xx), client errors (4xx except 429)
  //   - Only retry if attempt < maxRetries
  //   Return (shouldRetry: Boolean, nextAttempt: Int)
  def exercise8_shouldRetry(
    statusCode: Int,
    config: RetryConfig,
    currentAttempt: Int
  ): (Boolean, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val retryConfig = RetryConfig(maxRetries = 5, initialDelay = 100, maxDelay = 5000, backoffMultiplier = 2.0)
    assert(exercise1_retryDelay(retryConfig, 0) == 100, "Exercise 1 failed: attempt 0")
    assert(exercise1_retryDelay(retryConfig, 1) == 200, "Exercise 1 failed: attempt 1")
    assert(exercise1_retryDelay(retryConfig, 2) == 400, "Exercise 1 failed: attempt 2")
    assert(exercise1_retryDelay(retryConfig, 10) == 5000, "Exercise 1 failed: should cap at maxDelay")
    println("Exercise 1 passed: retry delay calculation works")

    // Exercise 2
    val (min, max) = exercise2_jitteredDelay(1000, 0.5)
    assert(min == 500, s"Exercise 2 failed: min should be 500, got $min")
    assert(max == 1500, s"Exercise 2 failed: max should be 1500, got $max")
    val (min2, max2) = exercise2_jitteredDelay(1000, 0.0)
    assert(min2 == 1000 && max2 == 1000, "Exercise 2 failed: zero jitter")
    println("Exercise 2 passed: jittered delay works")

    // Exercise 3
    import CircuitState._
    val cb = CircuitBreaker(Closed, 0, 0, 3, 2, 0)
    val afterFail1 = exercise3_updateCircuitBreaker(cb, false, 1000)
    assert(afterFail1.failureCount == 1 && afterFail1.state == Closed, "Exercise 3 failed: first failure")
    val afterFail3 = (1 to 3).foldLeft(cb)((c, _) => exercise3_updateCircuitBreaker(c, false, 1000))
    assert(afterFail3.state == Open, "Exercise 3 failed: should open after 3 failures")
    val halfOpenCb = CircuitBreaker(HalfOpen, 0, 0, 3, 2, 0)
    val afterHOSuccess = exercise3_updateCircuitBreaker(halfOpenCb, true, 2000)
    assert(afterHOSuccess.successCount == 1, "Exercise 3 failed: half-open success")
    val afterHOFail = exercise3_updateCircuitBreaker(halfOpenCb, false, 2000)
    assert(afterHOFail.state == Open, "Exercise 3 failed: half-open failure should open")
    println("Exercise 3 passed: circuit breaker updates work")

    // Exercise 4
    val closedCb = CircuitBreaker(Closed, 0, 0, 3, 2, 0)
    val (allow1, _) = exercise4_shouldAllowRequest(closedCb, 1000)
    assert(allow1, "Exercise 4 failed: closed should allow")
    val openCb = CircuitBreaker(Open, 3, 0, 3, 2, 1000)
    val (allow2, _) = exercise4_shouldAllowRequest(openCb, 2000)
    assert(!allow2, "Exercise 4 failed: open within cooldown should reject")
    val (allow3, updCb) = exercise4_shouldAllowRequest(openCb, 7000)
    assert(allow3, "Exercise 4 failed: open after cooldown should allow")
    assert(updCb.state == HalfOpen, "Exercise 4 failed: should transition to HalfOpen")
    println("Exercise 4 passed: request allowance check works")

    // Exercise 5
    val pool = ConnectionPool(maxConnections = 3, activeConnections = 1, idleConnections = 1, waitingRequests = 0)
    val (connId, pool2) = exercise5_acquireConnection(pool)
    assert(connId.isDefined, "Exercise 5 failed: should acquire connection")
    assert(pool2.activeConnections == 2, "Exercise 5 failed: active should increment")
    val fullPool = ConnectionPool(3, 3, 0, 0)
    val (noConn, fullPool2) = exercise5_acquireConnection(fullPool)
    assert(noConn.isEmpty, "Exercise 5 failed: full pool should return None")
    assert(fullPool2.waitingRequests == 1, "Exercise 5 failed: should increment waiting")
    val released = exercise5_releaseConnection(pool2)
    assert(released.activeConnections == 1, "Exercise 5 failed: active should decrement on release")
    println("Exercise 5 passed: connection pool management works")

    // Exercise 6
    val now = 10000L
    val entry = CacheEntry("/api/data", Response(Status.Ok, List.empty, Some("cached")), Some("etag1"), 60, 9000)
    val cache = Map("/api/data" -> entry)
    val (hit, _) = exercise6_checkCache(cache, "/api/data", now)
    assert(hit.isDefined && hit.get.body.contains("cached"), "Exercise 6 failed: should be cache hit")
    val (miss, _) = exercise6_checkCache(cache, "/api/other", now)
    assert(miss.isEmpty, "Exercise 6 failed: should be cache miss")
    val (stale, _) = exercise6_checkCache(cache, "/api/data", 100000)
    assert(stale.isEmpty, "Exercise 6 failed: expired entry should not hit")
    println("Exercise 6 passed: cache lookup works")

    // Exercise 7
    assert(exercise7_buildCacheControl(true, Some(3600), false, false) == "public, max-age=3600", "Exercise 7 failed: public")
    assert(exercise7_buildCacheControl(false, Some(300), false, false) == "private, max-age=300", "Exercise 7 failed: private")
    assert(exercise7_buildCacheControl(false, None, true, false) == "private, no-cache", "Exercise 7 failed: no-cache")
    assert(exercise7_buildCacheControl(false, None, false, true) == "no-store", "Exercise 7 failed: no-store")
    println("Exercise 7 passed: Cache-Control building works")

    // Exercise 8
    val rc = RetryConfig(3, 100, 5000, 2.0)
    assert(exercise8_shouldRetry(500, rc, 0) == (true, 1), "Exercise 8 failed: 500 should retry")
    assert(exercise8_shouldRetry(503, rc, 2) == (true, 3), "Exercise 8 failed: 503 attempt 2")
    assert(exercise8_shouldRetry(503, rc, 3) == (false, 3), "Exercise 8 failed: max retries exceeded")
    assert(exercise8_shouldRetry(200, rc, 0) == (false, 0), "Exercise 8 failed: success should not retry")
    assert(exercise8_shouldRetry(404, rc, 0) == (false, 0), "Exercise 8 failed: 404 should not retry")
    assert(exercise8_shouldRetry(429, rc, 0) == (true, 1), "Exercise 8 failed: 429 should retry")
    println("Exercise 8 passed: retry decision works")

    println("\nAll Http014_Performance exercises passed!")
  }
}
