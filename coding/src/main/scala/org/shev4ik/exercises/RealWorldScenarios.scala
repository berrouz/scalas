package org.shev4ik.exercises

/**
 * Real-World Interview Scenarios
 *
 * These are common scenarios you'll face in senior-level interviews.
 * They test practical application of functional programming concepts.
 */

/**
 * Scenario 1: Design a Retry Mechanism with Exponential Backoff
 *
 * Requirements:
 * - Retry failed operations up to N times
 * - Exponential backoff between retries
 * - Only retry on specific exceptions
 * - Type-safe and composable
 */

import scala.concurrent.{Future, ExecutionContext}
import scala.concurrent.duration._
import scala.util.{Try, Success, Failure}

object RetryMechanism {

  case class RetryConfig(
    maxAttempts: Int,
    initialDelay: FiniteDuration,
    maxDelay: FiniteDuration,
    backoffMultiplier: Double = 2.0
  )

  sealed trait RetryError
  case class MaxRetriesExceeded(attempts: Int, lastError: Throwable) extends RetryError
  case class NonRetryableError(error: Throwable) extends RetryError

  // TODO: Implement retry for synchronous operations
  def retrySyncOperation[A](
    operation: => A,
    config: RetryConfig,
    isRetryable: Throwable => Boolean = _ => true
  ): Either[RetryError, A] = ???

  // TODO: Implement retry for Future-based operations
  def retryFuture[A](
    operation: => Future[A],
    config: RetryConfig,
    isRetryable: Throwable => Boolean = _ => true
  )(implicit ec: ExecutionContext): Future[Either[RetryError, A]] = ???

  // TODO: Implement with cats-effect IO (bonus)
  /*
  import cats.effect.IO
  def retryIO[A](
    operation: IO[A],
    config: RetryConfig
  ): IO[Either[RetryError, A]] = ???
  */

  // Example usage
  def unreliableApiCall(attemptNumber: Int): String = {
    if (attemptNumber < 3) throw new Exception("Temporary failure")
    else "Success!"
  }

  def test(): Unit = {
    val config = RetryConfig(
      maxAttempts = 5,
      initialDelay = 100.millis,
      maxDelay = 5.seconds
    )

    var attempt = 0
    val result = retrySyncOperation(
      { attempt += 1; unreliableApiCall(attempt) },
      config
    )

    result match {
      case Right(value) =>
        println(s"✓ Retry succeeded after $attempt attempts: $value")
        assert(attempt == 3)
      case Left(error) =>
        println(s"✗ Retry failed: $error")
        assert(false)
    }
  }
}

/**
 * Scenario 2: Implement a Type-Safe Configuration System
 *
 * Requirements:
 * - Load config from multiple sources (env vars, files, defaults)
 * - Type-safe access to config values
 * - Validation at load time
 * - Clear error messages for missing/invalid config
 */

object ConfigSystem {

  sealed trait ConfigError
  case class MissingKey(key: String) extends ConfigError
  case class InvalidFormat(key: String, expected: String, actual: String) extends ConfigError
  case class ValidationFailed(key: String, reason: String) extends ConfigError

  // TODO: Implement ConfigReader type class
  trait ConfigReader[A] {
    def read(value: String): Either[ConfigError, A]
  }

  object ConfigReader {
    def apply[A](implicit reader: ConfigReader[A]): ConfigReader[A] = reader

    // TODO: Implement instances for common types
    implicit val stringReader: ConfigReader[String] = ???
    implicit val intReader: ConfigReader[Int] = ???
    implicit val booleanReader: ConfigReader[Boolean] = ???
    implicit val doubleReader: ConfigReader[Double] = ???

    // TODO: Implement for Option
    implicit def optionReader[A: ConfigReader]: ConfigReader[Option[A]] = ???

    // TODO: Implement for List (comma-separated)
    implicit def listReader[A: ConfigReader]: ConfigReader[List[A]] = ???
  }

  // Config source abstraction
  trait ConfigSource {
    def get(key: String): Option[String]
  }

  case class MapConfigSource(values: Map[String, String]) extends ConfigSource {
    def get(key: String): Option[String] = values.get(key)
  }

  // TODO: Implement Config class with validation
  class Config(sources: List[ConfigSource]) {

    def get[A: ConfigReader](key: String): Either[ConfigError, A] = ???

    def getOrElse[A: ConfigReader](key: String, default: A): A = ???

    def validate[A: ConfigReader](
      key: String,
      predicate: A => Boolean,
      errorMsg: String
    ): Either[ConfigError, A] = ???
  }

  // Example: Application config
  case class DatabaseConfig(
    host: String,
    port: Int,
    database: String,
    username: String,
    password: String,
    maxConnections: Int
  )

  case class ServerConfig(
    port: Int,
    host: String,
    timeout: Int
  )

  case class AppConfig(
    db: DatabaseConfig,
    server: ServerConfig,
    logLevel: String
  )

  // TODO: Implement loading and validation
  def loadAppConfig(config: Config): Either[List[ConfigError], AppConfig] = ???

  def test(): Unit = {
    val source = MapConfigSource(Map(
      "db.host" -> "localhost",
      "db.port" -> "5432",
      "db.database" -> "myapp",
      "db.username" -> "user",
      "db.password" -> "pass",
      "db.maxConnections" -> "10",
      "server.port" -> "8080",
      "server.host" -> "0.0.0.0",
      "server.timeout" -> "30",
      "log.level" -> "INFO"
    ))

    val config = new Config(List(source))
    val appConfig = loadAppConfig(config)

    appConfig match {
      case Right(cfg) =>
        println(s"✓ Loaded config: ${cfg.db.host}:${cfg.db.port}")
        assert(cfg.db.port == 5432)
      case Left(errors) =>
        println(s"✗ Config errors: $errors")
        assert(false)
    }
  }
}

/**
 * Scenario 3: Implement a Rate Limiter
 *
 * Requirements:
 * - Token bucket algorithm
 * - Thread-safe
 * - Configurable rate
 * - Works with async operations
 */

import java.util.concurrent.atomic.AtomicReference
import java.time.Instant

object RateLimiter {

  case class TokenBucket(
    tokens: Double,
    lastRefill: Instant,
    capacity: Double,
    refillRate: Double // tokens per second
  )

  class RateLimiter(
    capacity: Double,
    refillRate: Double
  ) {
    private val bucket = new AtomicReference(
      TokenBucket(capacity, Instant.now(), capacity, refillRate)
    )

    // TODO: Implement tryAcquire
    // Try to acquire N tokens, return true if successful
    def tryAcquire(tokens: Double = 1.0): Boolean = ???

    // TODO: Implement acquire
    // Block until tokens are available
    def acquire(tokens: Double = 1.0): Unit = ???

    // TODO: Implement withRateLimit for sync operations
    def withRateLimit[A](operation: => A): Option[A] = ???

    // TODO: Implement withRateLimitAsync for Futures
    def withRateLimitAsync[A](operation: => Future[A])(
      implicit ec: ExecutionContext
    ): Future[Option[A]] = ???

    // Helper: Refill tokens based on elapsed time
    private def refillTokens(bucket: TokenBucket): TokenBucket = {
      val now = Instant.now()
      val elapsedSeconds = (now.toEpochMilli - bucket.lastRefill.toEpochMilli) / 1000.0
      val newTokens = Math.min(
        bucket.capacity,
        bucket.tokens + elapsedSeconds * bucket.refillRate
      )
      TokenBucket(newTokens, now, bucket.capacity, bucket.refillRate)
    }
  }

  def test(): Unit = {
    val limiter = new RateLimiter(capacity = 5.0, refillRate = 1.0) // 1 token/sec

    // Test: Should allow up to capacity
    val results = (1 to 5).map(_ => limiter.tryAcquire())
    assert(results.forall(identity), "Should allow up to capacity")
    println(s"✓ Acquired 5 tokens: ${results.mkString(", ")}")

    // Test: Should reject when exhausted
    val rejected = limiter.tryAcquire()
    assert(!rejected, "Should reject when exhausted")
    println(s"✓ Rejected when exhausted: $rejected")

    // Test: Should refill over time
    Thread.sleep(2000) // Wait for 2 tokens to refill
    val afterRefill = (1 to 2).map(_ => limiter.tryAcquire())
    assert(afterRefill.forall(identity), "Should refill over time")
    println(s"✓ Refilled tokens after 2 seconds: ${afterRefill.mkString(", ")}")
  }
}

/**
 * Scenario 4: Implement a Circuit Breaker
 *
 * Requirements:
 * - Three states: Closed, Open, Half-Open
 * - Open after threshold failures
 * - Half-Open allows test requests
 * - Auto-reset after timeout
 */

object CircuitBreaker {

  sealed trait State
  case object Closed extends State
  case object Open extends State
  case object HalfOpen extends State

  sealed trait CircuitBreakerError
  case object CircuitOpen extends CircuitBreakerError
  case class CallFailed(error: Throwable) extends CircuitBreakerError

  case class CircuitBreakerState(
    state: State,
    failureCount: Int,
    lastFailureTime: Option[Instant],
    successCount: Int
  )

  case class CircuitBreakerConfig(
    failureThreshold: Int,
    resetTimeout: FiniteDuration,
    halfOpenSuccessThreshold: Int
  )

  class CircuitBreaker(config: CircuitBreakerConfig) {
    private val state = new AtomicReference(
      CircuitBreakerState(Closed, 0, None, 0)
    )

    // TODO: Implement call
    def call[A](operation: => A): Either[CircuitBreakerError, A] = ???

    // TODO: Implement callAsync
    def callAsync[A](operation: => Future[A])(
      implicit ec: ExecutionContext
    ): Future[Either[CircuitBreakerError, A]] = ???

    // TODO: Implement state transitions
    private def onSuccess(): Unit = ???
    private def onFailure(): Unit = ???
    private def shouldAttemptReset(): Boolean = ???

    // Get current state (for monitoring)
    def getState: State = state.get().state
    def getFailureCount: Int = state.get().failureCount
  }

  def test(): Unit = {
    val config = CircuitBreakerConfig(
      failureThreshold = 3,
      resetTimeout = 1.second,
      halfOpenSuccessThreshold = 2
    )
    val breaker = new CircuitBreaker(config)

    var callCount = 0
    def unreliableOperation(): String = {
      callCount += 1
      if (callCount <= 3) throw new Exception("Failing")
      else "Success"
    }

    // Generate 3 failures to open circuit
    (1 to 3).foreach { _ =>
      breaker.call(unreliableOperation())
    }
    assert(breaker.getState == Open, "Should be Open after threshold failures")
    println(s"✓ Circuit opened after 3 failures")

    // Next call should be rejected immediately
    val rejected = breaker.call(unreliableOperation())
    assert(rejected.isLeft, "Should reject when Open")
    println(s"✓ Call rejected while circuit is open")

    // Wait for reset timeout
    Thread.sleep(1100)

    // Should be in HalfOpen and allow test request
    val testCall = breaker.call(unreliableOperation())
    assert(testCall.isRight, "Should allow test call in HalfOpen")
    println(s"✓ Test call succeeded, circuit should close")
  }
}

/**
 * Scenario 5: Implement Saga Pattern for Distributed Transactions
 *
 * Requirements:
 * - Execute steps sequentially
 * - Rollback on failure
 * - Composable steps
 * - Type-safe
 */

object SagaPattern {

  // Each step has: action and compensation
  case class SagaStep[A, B](
    action: A => Either[String, B],
    compensation: B => Either[String, Unit]
  )

  // TODO: Implement Saga
  case class Saga[A, B](steps: List[SagaStep[_, _]]) {

    // Execute all steps, rollback on failure
    def execute(input: A): Either[String, B] = ???

    // Compose with another saga
    def andThen[C](next: SagaStep[B, C]): Saga[A, C] = ???
  }

  object Saga {
    def step[A, B](
      action: A => Either[String, B],
      compensation: B => Either[String, Unit]
    ): Saga[A, B] = Saga(List(SagaStep(action, compensation)))
  }

  // Example: E-commerce order processing
  case class Order(id: String, userId: String, amount: BigDecimal)
  case class Payment(orderId: String, amount: BigDecimal)
  case class Inventory(items: List[String])
  case class Shipment(orderId: String)

  def test(): Unit = {
    // Step 1: Reserve inventory
    val reserveInventory = SagaStep[Order, Inventory](
      order => {
        println(s"Reserving inventory for order ${order.id}")
        Right(Inventory(List("item1", "item2")))
      },
      inventory => {
        println(s"Releasing inventory: ${inventory.items}")
        Right(())
      }
    )

    // Step 2: Process payment
    val processPayment = SagaStep[Inventory, Payment](
      _ => {
        println("Processing payment")
        // Simulate failure
        Left("Payment failed")
      },
      payment => {
        println(s"Refunding payment for order ${payment.orderId}")
        Right(())
      }
    )

    // Step 3: Create shipment
    val createShipment = SagaStep[Payment, Shipment](
      payment => {
        println(s"Creating shipment for order ${payment.orderId}")
        Right(Shipment(payment.orderId))
      },
      shipment => {
        println(s"Cancelling shipment for order ${shipment.orderId}")
        Right(())
      }
    )

    val orderSaga = Saga.step(reserveInventory.action, reserveInventory.compensation)
      .andThen(processPayment)
      .andThen(createShipment)

    val order = Order("ORD-001", "USER-123", BigDecimal(99.99))
    val result = orderSaga.execute(order)

    result match {
      case Left(error) =>
        println(s"✓ Saga failed and rolled back: $error")
      case Right(_) =>
        println("✗ Saga should have failed")
    }
  }
}

/**
 * Main test runner
 */
object RealWorldScenariosSpec extends App {
  println("Testing Real-World Scenarios...\n")

  println("1. Retry Mechanism:")
  RetryMechanism.test()

  println("\n2. Configuration System:")
  ConfigSystem.test()

  println("\n3. Rate Limiter:")
  RateLimiter.test()

  println("\n4. Circuit Breaker:")
  CircuitBreaker.test()

  println("\n5. Saga Pattern:")
  SagaPattern.test()

  println("\n✓ All real-world scenario tests passed!")
}

/**
 * Discussion Questions:
 *
 * 1. How would you handle retry logic with Circuit Breaker?
 * 2. What's the difference between Circuit Breaker and Bulkhead pattern?
 * 3. How would you implement distributed rate limiting?
 * 4. What are the trade-offs of Saga pattern vs 2-Phase Commit?
 * 5. How would you monitor and alert on circuit breaker state?
 * 6. How does the Saga pattern relate to the State monad?
 * 7. What are idempotency concerns with retry mechanisms?
 * 8. How would you implement these patterns with Akka actors?
 * 9. How do these patterns compose together in a real system?
 * 10. What testing strategies would you use for these patterns?
 */
