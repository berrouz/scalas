package org.shev4ik.interview.grpc.level1_basics

/**
 * gRPC 005 - Error Handling
 *
 * gRPC uses status codes and rich error details for error handling.
 * Key concepts:
 *   - 16 standard status codes (OK through DataLoss)
 *   - Status has code + message (human-readable description)
 *   - Rich error model: status + error details (google.rpc.Status proto)
 *   - Error details: BadRequest, RetryInfo, DebugInfo, ErrorInfo, etc.
 *   - Errors propagate through interceptors and across service boundaries
 *   - Clients should handle specific status codes appropriately
 */
object Grpc005_ErrorHandling {

  // --- Domain models for exercises ---

  sealed trait StatusCode { def value: Int }
  object StatusCode {
    case object OK                extends StatusCode { val value = 0 }
    case object Cancelled         extends StatusCode { val value = 1 }
    case object Unknown           extends StatusCode { val value = 2 }
    case object InvalidArgument   extends StatusCode { val value = 3 }
    case object DeadlineExceeded  extends StatusCode { val value = 4 }
    case object NotFound          extends StatusCode { val value = 5 }
    case object AlreadyExists     extends StatusCode { val value = 6 }
    case object PermissionDenied  extends StatusCode { val value = 7 }
    case object ResourceExhausted extends StatusCode { val value = 8 }
    case object FailedPrecondition extends StatusCode { val value = 9 }
    case object Aborted           extends StatusCode { val value = 10 }
    case object OutOfRange        extends StatusCode { val value = 11 }
    case object Unimplemented     extends StatusCode { val value = 12 }
    case object Internal          extends StatusCode { val value = 13 }
    case object Unavailable       extends StatusCode { val value = 14 }
    case object DataLoss          extends StatusCode { val value = 15 }
    case object Unauthenticated   extends StatusCode { val value = 16 }
  }

  case class Status(code: StatusCode, message: String)

  sealed trait ErrorDetail
  object ErrorDetail {
    case class BadRequest(fieldViolations: List[FieldViolation])   extends ErrorDetail
    case class FieldViolation(field: String, description: String)
    case class RetryInfo(retryDelayMs: Long)                       extends ErrorDetail
    case class DebugInfo(stackTrace: String, detail: String)       extends ErrorDetail
    case class ErrorInfo(reason: String, domain: String, metadata: Map[String, String]) extends ErrorDetail
    case class QuotaFailure(violations: List[QuotaViolation])      extends ErrorDetail
    case class QuotaViolation(subject: String, description: String)
  }

  case class RichStatus(
    status: Status,
    details: List[ErrorDetail]
  )

  case class GrpcException(richStatus: RichStatus) extends Exception(richStatus.status.message)

  // Exercise 1: Create a simple error status
  // TODO: Given a StatusCode and message, create a RichStatus with no details.
  def exercise1_simpleError(code: StatusCode, message: String): RichStatus = ???

  // Exercise 2: Create a validation error with field violations
  // TODO: Given a list of (fieldName, description) pairs, create a RichStatus with:
  //   - Status code = InvalidArgument, message = "validation failed"
  //   - One BadRequest detail containing all FieldViolations
  def exercise2_validationError(
    violations: List[(String, String)]
  ): RichStatus = ???

  // Exercise 3: Determine if a status code is retryable
  // TODO: The following codes are generally retryable:
  //   Unavailable, DeadlineExceeded, ResourceExhausted, Aborted, Internal, Unknown
  //   Return true if the given code is retryable, false otherwise.
  def exercise3_isRetryable(code: StatusCode): Boolean = ???

  // Exercise 4: Create a retryable error with retry info
  // TODO: Given a StatusCode and retryDelayMs, create a RichStatus with:
  //   - The given status code and message "temporary failure, retry suggested"
  //   - A RetryInfo detail with the given delay
  //   - If the code is not retryable (per exercise3 logic), return a RichStatus
  //     with just the status and no details.
  def exercise4_retryableError(code: StatusCode, retryDelayMs: Long): RichStatus = ???

  // Exercise 5: Map an exception to a gRPC status
  // TODO: Given a Throwable, map it to a RichStatus:
  //   - IllegalArgumentException -> InvalidArgument with exception message
  //   - NoSuchElementException -> NotFound with exception message
  //   - UnsupportedOperationException -> Unimplemented with exception message
  //   - SecurityException -> PermissionDenied with exception message
  //   - Any other exception -> Internal with "internal error"
  //   All should have empty details list.
  def exercise5_exceptionToStatus(t: Throwable): RichStatus = ???

  // Exercise 6: Extract retry delay from a RichStatus
  // TODO: Given a RichStatus, find the first RetryInfo detail and return
  //   Some(retryDelayMs). If no RetryInfo is present, return None.
  def exercise6_extractRetryDelay(status: RichStatus): Option[Long] = ???

  // Exercise 7: Combine multiple errors into a single error response
  // TODO: Given a list of RichStatus errors, combine them into one:
  //   - If the list is empty, return OK status with empty details
  //   - If there's exactly one error, return it as-is
  //   - If there are multiple errors:
  //     - Use the status code with the highest .value among all errors
  //     - Concatenate all messages with "; " separator
  //     - Concatenate all details from all errors
  def exercise7_combineErrors(errors: List[RichStatus]): RichStatus = ???

  // Exercise 8: Implement error propagation across service boundaries
  // TODO: When a downstream service returns an error, the upstream service
  //   should wrap it. Given a downstream RichStatus error and the upstream service name:
  //   - Keep the same status code
  //   - Prepend the service name to the message: "[serviceName] original message"
  //   - Add a DebugInfo detail with stackTrace = "" and detail = "propagated from <serviceName>"
  //   - Keep all existing details from the downstream error
  def exercise8_propagateError(
    downstream: RichStatus,
    serviceName: String
  ): RichStatus = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val simple = exercise1_simpleError(StatusCode.NotFound, "user not found")
    assert(simple.status.code == StatusCode.NotFound, "Exercise 1 failed: wrong code")
    assert(simple.status.message == "user not found", "Exercise 1 failed: wrong message")
    assert(simple.details.isEmpty, "Exercise 1 failed: should have no details")
    println("Exercise 1 passed: simple error created")

    // Exercise 2
    val validation = exercise2_validationError(List(
      ("email", "invalid format"),
      ("name", "required field")
    ))
    assert(validation.status.code == StatusCode.InvalidArgument, "Exercise 2 failed: wrong code")
    assert(validation.details.length == 1, "Exercise 2 failed: wrong detail count")
    validation.details.head match {
      case ErrorDetail.BadRequest(violations) =>
        assert(violations.length == 2, "Exercise 2 failed: wrong violation count")
        assert(violations.head.field == "email", "Exercise 2 failed: wrong field")
      case _ => assert(false, "Exercise 2 failed: wrong detail type")
    }
    println("Exercise 2 passed: validation error created")

    // Exercise 3
    assert(exercise3_isRetryable(StatusCode.Unavailable), "Exercise 3 failed: Unavailable")
    assert(exercise3_isRetryable(StatusCode.DeadlineExceeded), "Exercise 3 failed: DeadlineExceeded")
    assert(!exercise3_isRetryable(StatusCode.NotFound), "Exercise 3 failed: NotFound should not retry")
    assert(!exercise3_isRetryable(StatusCode.InvalidArgument), "Exercise 3 failed: InvalidArgument")
    println("Exercise 3 passed: retryable status codes identified")

    // Exercise 4
    val retryable = exercise4_retryableError(StatusCode.Unavailable, 1000)
    assert(retryable.details.length == 1, "Exercise 4 failed: should have retry info")
    retryable.details.head match {
      case ErrorDetail.RetryInfo(delay) => assert(delay == 1000, "Exercise 4 failed: wrong delay")
      case _ => assert(false, "Exercise 4 failed: wrong detail type")
    }
    val nonRetryable = exercise4_retryableError(StatusCode.NotFound, 1000)
    assert(nonRetryable.details.isEmpty, "Exercise 4 failed: NotFound should have no details")
    println("Exercise 4 passed: retryable error with retry info")

    // Exercise 5
    assert(exercise5_exceptionToStatus(new IllegalArgumentException("bad")).status.code == StatusCode.InvalidArgument,
      "Exercise 5 failed: IllegalArgument")
    assert(exercise5_exceptionToStatus(new NoSuchElementException("missing")).status.code == StatusCode.NotFound,
      "Exercise 5 failed: NoSuchElement")
    assert(exercise5_exceptionToStatus(new RuntimeException("boom")).status.code == StatusCode.Internal,
      "Exercise 5 failed: RuntimeException")
    println("Exercise 5 passed: exception to status mapping")

    // Exercise 6
    val withRetry = RichStatus(
      Status(StatusCode.Unavailable, ""),
      List(ErrorDetail.RetryInfo(2000))
    )
    assert(exercise6_extractRetryDelay(withRetry).contains(2000), "Exercise 6 failed: should find retry")
    assert(exercise6_extractRetryDelay(simple).isEmpty, "Exercise 6 failed: should be None")
    println("Exercise 6 passed: retry delay extraction")

    // Exercise 7
    assert(exercise7_combineErrors(List.empty).status.code == StatusCode.OK, "Exercise 7 failed: empty")
    val combined = exercise7_combineErrors(List(
      exercise1_simpleError(StatusCode.NotFound, "a"),
      exercise1_simpleError(StatusCode.Internal, "b")
    ))
    assert(combined.status.code == StatusCode.Internal, "Exercise 7 failed: should pick highest code")
    assert(combined.status.message == "a; b", "Exercise 7 failed: wrong message, got: " + combined.status.message)
    println("Exercise 7 passed: error combining correct")

    // Exercise 8
    val downstream = RichStatus(
      Status(StatusCode.Internal, "db connection failed"),
      List(ErrorDetail.RetryInfo(500))
    )
    val propagated = exercise8_propagateError(downstream, "UserService")
    assert(propagated.status.message == "[UserService] db connection failed", "Exercise 8 failed: wrong message")
    assert(propagated.details.length == 2, "Exercise 8 failed: wrong detail count")
    assert(propagated.details.exists {
      case ErrorDetail.DebugInfo(_, d) => d == "propagated from UserService"
      case _ => false
    }, "Exercise 8 failed: missing debug info")
    println("Exercise 8 passed: error propagation correct")

    println("\nAll Grpc005_ErrorHandling exercises passed!")
  }
}
