package org.shev4ik.interview.senior_architect.level3_zio_architecture

object Arch029_ZIOErrorArch {

  // Exercise 1: Typed Error Design
  sealed trait AppError { def code: String; def message: String }
  sealed trait DomainError extends AppError
  sealed trait InfraError extends AppError
  case class UserNotFound(userId: String) extends DomainError { val code = "USER_NOT_FOUND"; val message = s"User $userId not found" }
  case class InvalidOperation(op: String, reason: String) extends DomainError { val code = "INVALID_OP"; val message = s"$op: $reason" }
  case class DbError(cause: String) extends InfraError { val code = "DB_ERROR"; val message = cause }
  case class NetworkError(cause: String) extends InfraError { val code = "NETWORK_ERROR"; val message = cause }

  // Exercise 2: Error Hierarchy
  // TODO: Design a multi-level error hierarchy for a complex application.
  sealed trait OrderError extends AppError
  case class OrderNotFound(id: String) extends OrderError { val code = "ORDER_NOT_FOUND"; val message = ??? }
  case class OrderInvalidState(id: String, current: String, attempted: String) extends OrderError { val code = "INVALID_STATE"; val message = ??? }
  case class PaymentFailed(orderId: String, reason: String) extends OrderError { val code = "PAYMENT_FAILED"; val message = ??? }
  def classifyError(error: AppError): String = ???  // "retryable", "client_error", "server_error"

  // Exercise 3: Error Recovery Strategy
  trait ErrorRecovery[E] {
    def canRecover(error: E): Boolean
    def recover[A](error: E, fallback: => Either[E, A]): Either[E, A]
    def retry[A](action: => Either[E, A], maxRetries: Int): Either[E, A]
  }
  class AppErrorRecovery extends ErrorRecovery[AppError] {
    def canRecover(error: AppError): Boolean = ???
    def recover[A](error: AppError, fallback: => Either[AppError, A]): Either[AppError, A] = ???
    def retry[A](action: => Either[AppError, A], maxRetries: Int): Either[AppError, A] = ???
  }

  // Exercise 4: Error Logging
  trait ErrorLogContext { def traceId: String; def service: String; def operation: String }
  trait ErrorLogger {
    def logError(error: AppError, context: ErrorLogContext): Unit
    def logWarning(error: AppError, context: ErrorLogContext): Unit
    def shouldAlert(error: AppError): Boolean
  }
  class StructuredErrorLogger extends ErrorLogger {
    def logError(error: AppError, context: ErrorLogContext): Unit = ???
    def logWarning(error: AppError, context: ErrorLogContext): Unit = ???
    def shouldAlert(error: AppError): Boolean = ???
  }

  // Exercise 5: Error Metrics
  case class ErrorMetrics(errorCounts: Map[String, Long], errorRatePerMinute: Double, topErrors: List[(String, Long)])
  trait ErrorMetricsCollector {
    def recordError(error: AppError): Unit
    def getMetrics(windowMinutes: Int): ErrorMetrics
    def errorBudgetRemaining(sloTarget: Double): Double
  }
  class InMemoryErrorMetrics extends ErrorMetricsCollector {
    def recordError(error: AppError): Unit = ???
    def getMetrics(windowMinutes: Int): ErrorMetrics = ???
    def errorBudgetRemaining(sloTarget: Double): Double = ???
  }

  // Exercise 6: Error Alerting
  case class ErrorAlertRule(errorCode: String, threshold: Int, windowMinutes: Int, severity: String)
  trait ErrorAlerter {
    def evaluate(metrics: ErrorMetrics): List[String]
    def addRule(rule: ErrorAlertRule): Unit
    def removeRule(errorCode: String): Unit
  }
  class ThresholdAlerter extends ErrorAlerter {
    private val rules = scala.collection.mutable.ListBuffer.empty[ErrorAlertRule]
    def evaluate(metrics: ErrorMetrics): List[String] = ???
    def addRule(rule: ErrorAlertRule): Unit = ???
    def removeRule(errorCode: String): Unit = ???
  }

  // Exercise 7: Error Propagation
  // TODO: Design error propagation across service boundaries.
  trait ErrorTranslator[From, To] { def translate(error: From): To }
  implicit val infraToDomain: ErrorTranslator[InfraError, DomainError] = new ErrorTranslator[InfraError, DomainError] {
    def translate(error: InfraError): DomainError = ???
  }
  def withErrorTranslation[E1, E2, A](action: => Either[E1, A])(implicit translator: ErrorTranslator[E1, E2]): Either[E2, A] = ???

  // Exercise 8: Defect vs Failure
  // ZIO distinction: Failure (expected, typed E) vs Defect (unexpected, untyped)
  sealed trait EffectOutcome[+E, +A]
  case class Success[A](value: A) extends EffectOutcome[Nothing, A]
  case class Failure[E](error: E) extends EffectOutcome[E, Nothing]     // expected, recoverable
  case class Defect(throwable: Throwable) extends EffectOutcome[Nothing, Nothing]  // unexpected, bug
  def handleOutcome[E, A](outcome: EffectOutcome[E, A])(onFailure: E => String)(onDefect: Throwable => String): Either[String, A] = ???
  def isDefect(throwable: Throwable): Boolean = ???
  def classifyThrowable(t: Throwable): EffectOutcome[AppError, Nothing] = ???

  def main(args: Array[String]): Unit = {
    println("=== Arch029: ZIO Error Architecture ===")
    println()
    println("Exercise 1: Typed Error Design")
    println("Exercise 2: Error Hierarchy")
    println("Exercise 3: Error Recovery Strategy")
    println("Exercise 4: Error Logging")
    println("Exercise 5: Error Metrics")
    println("Exercise 6: Error Alerting")
    println("Exercise 7: Error Propagation")
    println("Exercise 8: Defect vs Failure")
  }
}
