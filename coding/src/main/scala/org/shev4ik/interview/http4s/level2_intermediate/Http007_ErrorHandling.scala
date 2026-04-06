package org.shev4ik.interview.http4s.level2_intermediate

/**
 * Http4s 007 - Error Handling
 *
 * Handling errors gracefully in HTTP services. Key concepts:
 *   - Mapping exceptions to HTTP status codes
 *   - Custom error types with ADTs
 *   - Error response bodies (structured error messages)
 *   - Recovery strategies (fallback responses)
 *   - Error middleware for centralized handling
 *   - Either-based error handling in service logic
 */
object Http007_ErrorHandling {

  // --- Domain models ---

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val BadRequest: Status = Status(400, "Bad Request")
    val Unauthorized: Status = Status(401, "Unauthorized")
    val Forbidden: Status = Status(403, "Forbidden")
    val NotFound: Status = Status(404, "Not Found")
    val Conflict: Status = Status(409, "Conflict")
    val UnprocessableEntity: Status = Status(422, "Unprocessable Entity")
    val InternalServerError: Status = Status(500, "Internal Server Error")
    val ServiceUnavailable: Status = Status(503, "Service Unavailable")
  }

  case class Header(name: String, value: String)
  case class Response(status: Status, headers: List[Header], body: Option[String])

  // Custom error ADT
  sealed trait AppError {
    def message: String
  }
  object AppError {
    case class NotFound(resource: String, id: String) extends AppError {
      def message: String = s"$resource with id '$id' not found"
    }
    case class ValidationError(field: String, reason: String) extends AppError {
      def message: String = s"Validation failed for '$field': $reason"
    }
    case class AuthenticationError(reason: String) extends AppError {
      def message: String = s"Authentication failed: $reason"
    }
    case class AuthorizationError(action: String, resource: String) extends AppError {
      def message: String = s"Not authorized to $action on $resource"
    }
    case class ConflictError(resource: String, detail: String) extends AppError {
      def message: String = s"Conflict on $resource: $detail"
    }
    case class InternalError(cause: String) extends AppError {
      def message: String = s"Internal error: $cause"
    }
  }

  case class ErrorBody(error: String, message: String, details: Option[String])

  type Service = String => Either[AppError, String]

  // Exercise 1: Map an AppError to an HTTP Status
  // TODO: Return the appropriate Status for each AppError type:
  //   NotFound -> Status.NotFound
  //   ValidationError -> Status.UnprocessableEntity
  //   AuthenticationError -> Status.Unauthorized
  //   AuthorizationError -> Status.Forbidden
  //   ConflictError -> Status.Conflict
  //   InternalError -> Status.InternalServerError
  def exercise1_errorToStatus(error: AppError): Status = ???

  // Exercise 2: Build an error response from an AppError
  // TODO: Given an AppError, create a Response with:
  //   - Appropriate status (use exercise1_errorToStatus logic)
  //   - Header("Content-Type", "application/json")
  //   - Body as JSON string: {"error":"<errorType>","message":"<error.message>"}
  //   where errorType is the simple class name (e.g., "NotFound", "ValidationError")
  def exercise2_buildErrorResponse(error: AppError): Response = ???

  // Exercise 3: Create an error-handling wrapper for a service
  // TODO: Given a function that may throw exceptions, wrap it to catch exceptions
  //   and return an appropriate Either[AppError, A].
  //   - IllegalArgumentException -> Left(ValidationError("input", exception.getMessage))
  //   - NoSuchElementException -> Left(NotFound("resource", "unknown"))
  //   - Any other exception -> Left(InternalError(exception.getMessage))
  def exercise3_safeExecute[A](f: => A): Either[AppError, A] = ???

  // Exercise 4: Chain multiple validations, collecting all errors
  // TODO: Given a list of validation functions that each return Either[AppError, Unit],
  //   run all of them and collect ALL errors (not short-circuit on first).
  //   Return Right(()) if all pass, Left(list of error messages) if any fail.
  def exercise4_validateAll(
    validations: List[() => Either[AppError, Unit]]
  ): Either[List[String], Unit] = ???

  // Exercise 5: Implement a fallback/recovery strategy
  // TODO: Given a primary service function and a fallback, try the primary first.
  //   If primary returns Left, try the fallback.
  //   If both fail, return the primary error (the first one).
  def exercise5_withFallback[A](
    primary: => Either[AppError, A],
    fallback: => Either[AppError, A]
  ): Either[AppError, A] = ???

  // Exercise 6: Map between different error types
  // TODO: Given an Either[Throwable, A], convert it to Either[AppError, A] using:
  //   - IllegalArgumentException -> ValidationError("input", msg)
  //   - IllegalStateException -> ConflictError("state", msg)
  //   - SecurityException -> AuthenticationError(msg)
  //   - Any other -> InternalError(msg)
  def exercise6_mapThrowableToAppError[A](result: Either[Throwable, A]): Either[AppError, A] = ???

  // Exercise 7: Create an error-handling middleware
  // TODO: Return a function that wraps a service (String => Response).
  //   If the service throws an exception, catch it and return
  //   Response(Status.InternalServerError, ..., Some(s"Unexpected error: ${e.getMessage}"))
  //   Add Header("Content-Type", "text/plain") to error responses.
  def exercise7_errorMiddleware(service: String => Response): String => Response = ???

  // Exercise 8: Implement error accumulation with custom error types
  // TODO: Given a Map[String, String] representing form data and a list of required fields,
  //   validate that all required fields are present and non-empty.
  //   Return Right(data) if valid, or Left(List[ValidationError]) for all missing/empty fields.
  //   Missing field -> ValidationError(field, "is required")
  //   Empty field -> ValidationError(field, "must not be empty")
  def exercise8_validateForm(
    data: Map[String, String],
    requiredFields: List[String]
  ): Either[List[AppError.ValidationError], Map[String, String]] = ???

  def main(args: Array[String]): Unit = {
    import AppError._

    // Exercise 1
    assert(exercise1_errorToStatus(NotFound("user", "1")) == Status.NotFound, "Exercise 1 failed: NotFound")
    assert(exercise1_errorToStatus(ValidationError("email", "invalid")) == Status.UnprocessableEntity, "Exercise 1 failed: Validation")
    assert(exercise1_errorToStatus(AuthenticationError("expired")) == Status.Unauthorized, "Exercise 1 failed: Auth")
    assert(exercise1_errorToStatus(InternalError("boom")) == Status.InternalServerError, "Exercise 1 failed: Internal")
    println("Exercise 1 passed: error to status mapping works")

    // Exercise 2
    val errResp = exercise2_buildErrorResponse(NotFound("user", "42"))
    assert(errResp.status == Status.NotFound, "Exercise 2 failed: wrong status")
    assert(errResp.body.exists(_.contains("NotFound")), "Exercise 2 failed: wrong error type in body")
    assert(errResp.body.exists(_.contains("not found")), "Exercise 2 failed: wrong message in body")
    println("Exercise 2 passed: error response building works")

    // Exercise 3
    assert(exercise3_safeExecute(42) == Right(42), "Exercise 3 failed: success case")
    assert(exercise3_safeExecute(throw new IllegalArgumentException("bad")).isLeft, "Exercise 3 failed: IllegalArg")
    assert(exercise3_safeExecute(throw new NoSuchElementException("nope")).isLeft, "Exercise 3 failed: NoSuchElement")
    val internalErr = exercise3_safeExecute(throw new RuntimeException("boom"))
    assert(internalErr.isLeft && internalErr.swap.toOption.get.isInstanceOf[InternalError], "Exercise 3 failed: RuntimeException")
    println("Exercise 3 passed: safe execution works")

    // Exercise 4
    val allGood: List[() => Either[AppError, Unit]] = List(
      () => Right(()), () => Right(())
    )
    assert(exercise4_validateAll(allGood) == Right(()), "Exercise 4 failed: all good")
    val someBad: List[() => Either[AppError, Unit]] = List(
      () => Right(()),
      () => Left(ValidationError("name", "required")),
      () => Left(ValidationError("email", "invalid"))
    )
    val result4 = exercise4_validateAll(someBad)
    assert(result4.isLeft, "Exercise 4 failed: should have errors")
    assert(result4.swap.toOption.get.length == 2, "Exercise 4 failed: should collect all errors")
    println("Exercise 4 passed: validation accumulation works")

    // Exercise 5
    assert(exercise5_withFallback(Right(1), Right(2)) == Right(1), "Exercise 5 failed: primary success")
    assert(exercise5_withFallback(Left(NotFound("x", "1")), Right(2)) == Right(2), "Exercise 5 failed: fallback")
    val bothFail = exercise5_withFallback(Left(NotFound("x", "1")), Left(InternalError("boom")))
    assert(bothFail == Left(NotFound("x", "1")), "Exercise 5 failed: both fail should return primary error")
    println("Exercise 5 passed: fallback strategy works")

    // Exercise 6
    assert(exercise6_mapThrowableToAppError(Right(42)) == Right(42), "Exercise 6 failed: success")
    val mapped = exercise6_mapThrowableToAppError(Left(new IllegalArgumentException("bad")))
    assert(mapped.isLeft && mapped.swap.toOption.get.isInstanceOf[ValidationError], "Exercise 6 failed: IllegalArg")
    println("Exercise 6 passed: throwable mapping works")

    // Exercise 7
    val goodService: String => Response = _ => Response(Status.Ok, List.empty, Some("ok"))
    val badService: String => Response = _ => throw new RuntimeException("kaboom")
    val mw = exercise7_errorMiddleware(goodService)
    assert(mw("test").status == Status.Ok, "Exercise 7 failed: good service")
    val mwBad = exercise7_errorMiddleware(badService)
    val errorResp = mwBad("test")
    assert(errorResp.status == Status.InternalServerError, "Exercise 7 failed: should catch exception")
    assert(errorResp.body.exists(_.contains("kaboom")), "Exercise 7 failed: should include error message")
    println("Exercise 7 passed: error middleware works")

    // Exercise 8
    val goodData = Map("name" -> "Alice", "email" -> "alice@test.com")
    assert(exercise8_validateForm(goodData, List("name", "email")).isRight, "Exercise 8 failed: valid data")
    val badData = Map("name" -> "", "age" -> "30")
    val result8 = exercise8_validateForm(badData, List("name", "email"))
    assert(result8.isLeft, "Exercise 8 failed: should have errors")
    val errs = result8.swap.toOption.get
    assert(errs.length == 2, s"Exercise 8 failed: should have 2 errors, got ${errs.length}")
    println("Exercise 8 passed: form validation works")

    println("\nAll Http007_ErrorHandling exercises passed!")
  }
}
