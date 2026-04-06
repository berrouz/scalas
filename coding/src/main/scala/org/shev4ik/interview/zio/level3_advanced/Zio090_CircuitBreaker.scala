package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO090 - Circuit Breaker Pattern
 *
 * Implement the circuit breaker pattern with ZIO for resilient service calls.
 */
object Zio090_CircuitBreaker extends App {

  sealed trait CircuitState
  case object Closed   extends CircuitState
  case object Open     extends CircuitState
  case object HalfOpen extends CircuitState

  // ============================================================
  // Exercise 1: Circuit breaker states
  // TODO: Create a Ref[CircuitState] starting as Closed.
  //       Implement transitions: Closed -> Open (on failure threshold),
  //       Open -> HalfOpen (after timeout), HalfOpen -> Closed (on success).
  //       Print state transitions.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Failure counting
  // TODO: Implement failure counting with a Ref[Int].
  //       After 3 consecutive failures, transition to Open state.
  //       Reset count on success. Print failure counts.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Half-open test
  // TODO: When in Open state, after a timeout, transition to HalfOpen.
  //       Allow one test request. If it succeeds, go to Closed.
  //       If it fails, go back to Open. Print the test flow.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Reset timer
  // TODO: Implement an Open -> HalfOpen timer using ZIO.sleep.
  //       The circuit stays Open for 5 seconds before transitioning.
  //       Use a fiber for the timer. Print timer events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Circuit breaker with Ref
  // TODO: Build a complete circuit breaker using Ref[CircuitState] and Ref[Int] (failures).
  //       Implement def call[A](effect: Task[A]): Task[A] that wraps the effect
  //       with circuit breaker logic. Test with a flaky effect. Print events.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Circuit breaker metrics
  // TODO: Add metrics to the circuit breaker:
  //       totalCalls, successCount, failureCount, rejectedCount (while open).
  //       Print metrics after running a series of calls.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Circuit breaker with Schedule
  // TODO: Use ZIO Schedule to implement the retry/backoff behavior
  //       of the circuit breaker. Combine Schedule.recurs with
  //       Schedule.exponential for the Open -> HalfOpen transition.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Circuit breaker composition
  // TODO: Create two circuit breakers for two different services.
  //       Implement a fallback: if service A's circuit is open, try service B.
  //       Print which service handles each request.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
