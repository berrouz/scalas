package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Error Modeling in Scala / ZIO
 *
 * Senior/Architect focus:
 * - Designing comprehensive error hierarchies
 * - Business errors vs technical errors separation
 * - Error propagation, accumulation, and recovery strategies
 */
object Arch003_ErrorModeling {

  // ============================================================
  // Exercise 1: Error ADT Hierarchy
  // ============================================================
  // TODO: Design a comprehensive error hierarchy for an e-commerce
  //  platform. Errors should be organized by domain concern and
  //  carry enough context for debugging and user-facing messages.

  sealed trait AppError {
    def code: String
    def message: String
    def context: Map[String, String]
  }

  sealed trait OrderError extends AppError
  case class OrderNotFound(orderId: String) extends OrderError {
    val code = "ORDER_NOT_FOUND"
    val message = s"Order $orderId not found"
    val context: Map[String, String] = ???
  }
  case class OrderAlreadySubmitted(orderId: String) extends OrderError {
    val code = "ORDER_ALREADY_SUBMITTED"
    val message: String = ???
    val context: Map[String, String] = ???
  }
  case class InsufficientStock(productId: String, requested: Int, available: Int) extends OrderError {
    val code: String = ???
    val message: String = ???
    val context: Map[String, String] = ???
  }

  sealed trait PaymentError extends AppError
  // TODO: Define PaymentDeclined, PaymentTimeout, PaymentGatewayError
  case class PaymentDeclinedErr(reason: String, cardLast4: String) extends PaymentError {
    val code: String = ???
    val message: String = ???
    val context: Map[String, String] = ???
  }

  sealed trait AuthError extends AppError
  // TODO: Define InvalidCredentials, TokenExpired, InsufficientPermissions
  case class InvalidCredentials(username: String) extends AuthError {
    val code: String = ???
    val message: String = ???
    val context: Map[String, String] = ???
  }

  // ============================================================
  // Exercise 2: Business Errors vs Technical Errors
  // ============================================================
  // TODO: Separate business errors (expected, recoverable) from
  //  technical errors (unexpected, infrastructure failures).
  //  Business errors should be part of the API contract.
  //  Technical errors should be logged and result in generic messages.

  // Business errors: expected, part of domain logic
  sealed trait BusinessError {
    def userMessage: String  // safe to show to users
  }
  case class ValidationFailed(field: String, reason: String) extends BusinessError {
    def userMessage: String = ???
  }
  case class BusinessRuleViolation(rule: String, details: String) extends BusinessError {
    def userMessage: String = ???
  }

  // Technical errors: unexpected, infrastructure failures
  sealed trait TechnicalError {
    def internalMessage: String  // for logs only, never shown to users
    def cause: Option[Throwable]
  }
  case class DatabaseConnectionFailed(host: String, cause: Option[Throwable] = None) extends TechnicalError {
    def internalMessage: String = ???
  }
  case class ExternalServiceUnavailable(service: String, statusCode: Int, cause: Option[Throwable] = None) extends TechnicalError {
    def internalMessage: String = ???
  }

  // TODO: Design an error handler that treats business vs technical errors differently
  def handleError(error: Either[BusinessError, TechnicalError]): (Int, String) = ???

  // ============================================================
  // Exercise 3: Error Channels in ZIO
  // ============================================================
  // TODO: Design typed error channels for a ZIO-based service.
  //  Use ZIO's error channel to carry domain-specific errors.
  //  Model the difference between expected failures and defects.

  // Simulating ZIO error concepts without ZIO dependency
  // In real ZIO: ZIO[R, E, A] where E is the typed error channel

  sealed trait ServiceError
  case class NotFound(resource: String, id: String) extends ServiceError
  case class Conflict(resource: String, reason: String) extends ServiceError
  case class Forbidden(action: String, reason: String) extends ServiceError

  // TODO: Design service methods with typed error returns
  // In real ZIO these would be ZIO[Any, ServiceError, A]
  trait UserServiceWithErrors {
    def getUser(id: String): Either[ServiceError, UserDTO]
    def createUser(request: CreateUserRequest): Either[ServiceError, UserDTO]
    def updateUser(id: String, request: UpdateUserRequest): Either[ServiceError, UserDTO]
    def deleteUser(id: String): Either[ServiceError, Unit]
  }

  case class UserDTO(id: String, name: String, email: String)
  case class CreateUserRequest(name: String, email: String)
  case class UpdateUserRequest(name: Option[String], email: Option[String])

  // TODO: Implement the service with proper error channel usage
  class UserServiceImpl extends UserServiceWithErrors {
    def getUser(id: String): Either[ServiceError, UserDTO] = ???
    def createUser(request: CreateUserRequest): Either[ServiceError, UserDTO] = ???
    def updateUser(id: String, request: UpdateUserRequest): Either[ServiceError, UserDTO] = ???
    def deleteUser(id: String): Either[ServiceError, Unit] = ???
  }

  // ============================================================
  // Exercise 4: Typed Error Handling
  // ============================================================
  // TODO: Implement a typed error handling strategy that preserves
  //  error type information through the call chain.
  //  Use union types / sealed trait composition for error aggregation.

  sealed trait RegistrationError
  case class InvalidEmail(email: String) extends RegistrationError
  case class DuplicateEmail(email: String) extends RegistrationError
  case class WeakPassword(reason: String) extends RegistrationError
  case class RegistrationRateLimited(ip: String) extends RegistrationError

  // TODO: Chain operations that may fail with different error types
  def validateEmail(email: String): Either[InvalidEmail, String] = ???
  def checkDuplicate(email: String): Either[DuplicateEmail, String] = ???
  def validatePassword(password: String): Either[WeakPassword, String] = ???
  def checkRateLimit(ip: String): Either[RegistrationRateLimited, Unit] = ???

  // TODO: Compose all validations into a registration flow
  //  The result error type should be RegistrationError (the union)
  def register(email: String, password: String, ip: String): Either[RegistrationError, String] = ???

  // ============================================================
  // Exercise 5: Error Accumulation Strategy
  // ============================================================
  // TODO: Implement error accumulation (collect ALL errors) vs
  //  fail-fast (stop at first error). Use Validated-style pattern.

  // Fail-fast: stops at first error (Either / flatMap)
  def failFastValidation(name: String, email: String, age: Int): Either[String, (String, String, Int)] = ???

  // Error accumulation: collects all errors
  case class Validated[+E, +A](value: Either[List[E], A]) {
    def map[B](f: A => B): Validated[E, B] = ???
    def flatMap[EE >: E, B](f: A => Validated[EE, B]): Validated[EE, B] = ???
  }

  object Validated {
    def valid[A](a: A): Validated[Nothing, A] = ???
    def invalid[E](error: E): Validated[E, Nothing] = ???

    // TODO: Implement mapN for combining validated values
    def mapN[E, A, B, C](va: Validated[E, A], vb: Validated[E, B])(f: (A, B) => C): Validated[E, C] = ???
    def mapN3[E, A, B, C, D](va: Validated[E, A], vb: Validated[E, B], vc: Validated[E, C])(f: (A, B, C) => D): Validated[E, D] = ???
  }

  // TODO: Use accumulating validation for a form submission
  def accumulatingValidation(name: String, email: String, age: Int): Validated[String, (String, String, Int)] = ???

  // ============================================================
  // Exercise 6: Error Recovery Patterns
  // ============================================================
  // TODO: Implement common error recovery strategies:
  //  fallback, retry, circuit breaker, default values.

  // Recovery strategy: provide a fallback value
  def withFallback[E, A](primary: => Either[E, A], fallback: => Either[E, A]): Either[E, A] = ???

  // Recovery strategy: retry with exponential backoff (simulated)
  def withRetry[E, A](action: => Either[E, A], maxRetries: Int, shouldRetry: E => Boolean): Either[E, A] = ???

  // Recovery strategy: map to a default on specific errors
  def withDefault[E, A](action: => Either[E, A], default: A, recoverFrom: E => Boolean): Either[E, A] = ???

  // TODO: Compose recovery strategies for a resilient operation
  def resilientFetch(url: String): Either[String, String] = ???

  // ============================================================
  // Exercise 7: Error Logging Strategy
  // ============================================================
  // TODO: Design an error logging strategy that captures sufficient
  //  context without leaking sensitive information.

  trait ErrorLogger {
    def logError(error: AppError, additionalContext: Map[String, String] = Map.empty): Unit
  }

  // TODO: Implement structured error logging
  class StructuredErrorLogger extends ErrorLogger {
    // Should produce structured log entries with:
    // - error code, message, context
    // - correlation ID for tracing
    // - sanitized fields (no PII in logs)
    def logError(error: AppError, additionalContext: Map[String, String]): Unit = ???
  }

  // TODO: Implement PII sanitization for error context
  def sanitizeContext(context: Map[String, String]): Map[String, String] = ???

  // ============================================================
  // Exercise 8: Error Propagation Design
  // ============================================================
  // TODO: Design error propagation across service boundaries.
  //  Errors from downstream services should be translated to
  //  upstream error types, not leaked directly.

  // Downstream service errors (external)
  sealed trait InventoryServiceError
  case class ItemOutOfStock(sku: String) extends InventoryServiceError
  case class InventoryServiceDown(retryAfter: Long) extends InventoryServiceError

  // Upstream errors (our API contract)
  sealed trait CheckoutError
  case class CheckoutItemUnavailable(productName: String) extends CheckoutError
  case class CheckoutTemporarilyUnavailable(retryAfterSeconds: Int) extends CheckoutError
  case class CheckoutInternalError(correlationId: String) extends CheckoutError

  // TODO: Implement error translation at the boundary
  def translateInventoryError(error: InventoryServiceError, correlationId: String): CheckoutError = ???

  // TODO: Design an anti-corruption layer for error translation
  trait ErrorTranslator[From, To] {
    def translate(error: From, correlationId: String): To
  }

  implicit val inventoryErrorTranslator: ErrorTranslator[InventoryServiceError, CheckoutError] =
    new ErrorTranslator[InventoryServiceError, CheckoutError] {
      def translate(error: InventoryServiceError, correlationId: String): CheckoutError = ???
    }

  def main(args: Array[String]): Unit = {
    println("=== Arch003: Error Modeling ===")
    println()
    println("Exercise 1: Error ADT Hierarchy")
    println("Exercise 2: Business Errors vs Technical Errors")
    println("Exercise 3: Error Channels in ZIO")
    println("Exercise 4: Typed Error Handling")
    println("Exercise 5: Error Accumulation Strategy")
    println("Exercise 6: Error Recovery Patterns")
    println("Exercise 7: Error Logging Strategy")
    println("Exercise 8: Error Propagation Design")
  }
}
