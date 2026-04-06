package org.shev4ik.interview.system_design.level2_patterns

object SysDes009_CircuitBreaker {

  // ---- Domain types ----

  sealed trait CircuitState
  case object Closed extends CircuitState       // Normal operation, requests pass through
  case object Open extends CircuitState         // Failing, requests are blocked
  case object HalfOpen extends CircuitState     // Testing if service recovered

  case class CircuitBreakerConfig(
    failureThreshold: Int,    // failures before opening
    successThreshold: Int,    // successes in half-open before closing
    timeoutMs: Long,          // how long to stay open before trying half-open
    maxConcurrentHalfOpen: Int = 1  // max requests in half-open state
  )

  case class CircuitBreaker(
    config: CircuitBreakerConfig,
    state: CircuitState = Closed,
    failureCount: Int = 0,
    successCount: Int = 0,
    lastFailureTime: Long = 0L,
    totalRequests: Long = 0L,
    totalFailures: Long = 0L,
    totalSuccesses: Long = 0L
  )

  // ---- Exercise 1 ----
  // TODO: Implement the Closed state behavior.
  // In Closed state, requests pass through. On success, reset failure count.
  // On failure, increment failure count. If failures >= threshold, transition to Open.
  // `onResult(cb, success, currentTime)` returns the updated CircuitBreaker.
  def onResultClosed(cb: CircuitBreaker, success: Boolean, currentTime: Long): CircuitBreaker = ???

  // ---- Exercise 2 ----
  // TODO: Implement the Open state behavior.
  // In Open state, all requests are rejected immediately.
  // `canAttempt(cb, currentTime)`: check if enough time has passed since last failure
  //   to transition to HalfOpen. If currentTime - lastFailureTime >= timeoutMs, return true.
  // `tryTransitionToHalfOpen(cb, currentTime)`: if canAttempt, move to HalfOpen and reset successCount.
  def canAttempt(cb: CircuitBreaker, currentTime: Long): Boolean = ???

  def tryTransitionToHalfOpen(cb: CircuitBreaker, currentTime: Long): CircuitBreaker = ???

  // ---- Exercise 3 ----
  // TODO: Implement the HalfOpen state behavior.
  // In HalfOpen, allow limited requests through.
  // On success, increment successCount. If successCount >= successThreshold, transition to Closed.
  // On failure, transition immediately back to Open.
  def onResultHalfOpen(cb: CircuitBreaker, success: Boolean, currentTime: Long): CircuitBreaker = ???

  // ---- Exercise 4 ----
  // TODO: Implement the full circuit breaker `execute` function.
  // Given a circuit breaker and a function to call:
  // 1. If Closed: execute the function, handle result
  // 2. If Open: check if we can transition to HalfOpen; if not, return failure
  // 3. If HalfOpen: execute the function, handle result
  // The function returns Either[String, A] (Left=failure, Right=success).
  // Return (updatedCB, Either[String, A]) where Left("circuit-open") if blocked.
  def execute[A](
    cb: CircuitBreaker,
    currentTime: Long,
    call: () => Either[String, A]
  ): (CircuitBreaker, Either[String, A]) = ???

  // ---- Exercise 5 ----
  // TODO: Implement a reset timer.
  // After the circuit opens, it should automatically try half-open after the timeout.
  // Implement `stateAtTime(cb, currentTime)` that returns what the effective state
  // should be at the given time (considering automatic transitions).
  def effectiveState(cb: CircuitBreaker, currentTime: Long): CircuitState = ???

  // ---- Exercise 6 ----
  // TODO: Implement circuit breaker metrics.
  // Given a CircuitBreaker, calculate:
  // - `failureRate`: totalFailures / totalRequests (0.0 if no requests)
  // - `successRate`: totalSuccesses / totalRequests
  // - `isHealthy`: failureRate < 0.5
  case class CBMetrics(failureRate: Double, successRate: Double, isHealthy: Boolean)

  def metrics(cb: CircuitBreaker): CBMetrics = ???

  // ---- Exercise 7 ----
  // TODO: Implement a fallback mechanism.
  // When the circuit is open (or call fails), use a fallback function instead.
  // `executeWithFallback(cb, currentTime, call, fallback)`:
  //   - Try the primary call via the circuit breaker.
  //   - If the circuit is open or the call fails, invoke the fallback.
  //   - Return (updatedCB, result) where result is from call or fallback.
  def executeWithFallback[A](
    cb: CircuitBreaker,
    currentTime: Long,
    call: () => Either[String, A],
    fallback: () => A
  ): (CircuitBreaker, A) = ???

  // ---- Exercise 8 ----
  // TODO: Implement circuit breaker with retry.
  // Before opening the circuit, retry the call up to `maxRetries` times.
  // Only count as a failure (toward the threshold) if ALL retries fail.
  // Return (updatedCB, Either[String, A], attempts: Int)
  def executeWithRetry[A](
    cb: CircuitBreaker,
    currentTime: Long,
    call: () => Either[String, A],
    maxRetries: Int
  ): (CircuitBreaker, Either[String, A], Int) = ???

  def main(args: Array[String]): Unit = {
    val config = CircuitBreakerConfig(
      failureThreshold = 3,
      successThreshold = 2,
      timeoutMs = 5000
    )
    val cb0 = CircuitBreaker(config)

    // Exercise 1: Closed state
    val cb1 = onResultClosed(cb0, success = true, 100)
    assert(cb1.state == Closed)
    assert(cb1.failureCount == 0)
    val cb2 = onResultClosed(cb0, success = false, 100)
    assert(cb2.failureCount == 1)
    val cb3 = (1 to 3).foldLeft(cb0)((cb, _) => onResultClosed(cb, success = false, 100))
    assert(cb3.state == Open)
    println("Exercise 1 passed: Closed state")

    // Exercise 2: Open state
    assert(!canAttempt(cb3, 100)) // just opened
    assert(canAttempt(cb3, 6000)) // after timeout
    val cb4 = tryTransitionToHalfOpen(cb3, 6000)
    assert(cb4.state == HalfOpen)
    println("Exercise 2 passed: Open state")

    // Exercise 3: HalfOpen state
    val cbHo = cb4.copy(state = HalfOpen, successCount = 0)
    val cbHo1 = onResultHalfOpen(cbHo, success = true, 7000)
    assert(cbHo1.state == HalfOpen) // need 2 successes
    val cbHo2 = onResultHalfOpen(cbHo1, success = true, 7000)
    assert(cbHo2.state == Closed) // recovered
    val cbHoFail = onResultHalfOpen(cbHo, success = false, 7000)
    assert(cbHoFail.state == Open) // back to open
    println("Exercise 3 passed: HalfOpen state")

    // Exercise 4: Full execute
    val (cb5, r5) = execute(cb0, 100, () => Right(42))
    assert(r5 == Right(42))
    assert(cb5.state == Closed)
    val cbOpen = cb3 // Open state
    val (cb6, r6) = execute(cbOpen, 100, () => Right(42))
    assert(r6 == Left("circuit-open"))
    println("Exercise 4 passed: Full execute")

    // Exercise 5: Effective state
    assert(effectiveState(cb0, 100) == Closed)
    assert(effectiveState(cb3, 100) == Open)
    assert(effectiveState(cb3, 6000) == HalfOpen) // timeout passed
    println("Exercise 5 passed: Effective state")

    // Exercise 6: Metrics
    val cbMetrics = cb0.copy(totalRequests = 100, totalFailures = 20, totalSuccesses = 80)
    val m = metrics(cbMetrics)
    assert(m.failureRate == 0.2)
    assert(m.successRate == 0.8)
    assert(m.isHealthy)
    assert(metrics(cb0).failureRate == 0.0)
    println("Exercise 6 passed: Metrics")

    // Exercise 7: Fallback
    val (_, fResult) = executeWithFallback(cbOpen, 100, () => Right(42), () => -1)
    assert(fResult == -1) // circuit open, fallback used
    val (_, sResult) = executeWithFallback(cb0, 100, () => Right(42), () => -1)
    assert(sResult == 42) // circuit closed, primary call used
    println("Exercise 7 passed: Fallback")

    // Exercise 8: Circuit breaker with retry
    var callCount = 0
    val flakyCall: () => Either[String, Int] = () => {
      callCount += 1
      if (callCount >= 3) Right(99) else Left("fail")
    }
    callCount = 0
    val (cbR, rR, attempts) = executeWithRetry(cb0, 100, flakyCall, maxRetries = 5)
    assert(rR == Right(99))
    assert(attempts == 3)
    assert(cbR.state == Closed) // succeeded, no failure counted
    println("Exercise 8 passed: Circuit breaker with retry")

    println("All SysDes009_CircuitBreaker exercises passed!")
  }
}
