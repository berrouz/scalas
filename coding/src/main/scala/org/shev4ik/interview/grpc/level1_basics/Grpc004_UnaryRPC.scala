package org.shev4ik.interview.grpc.level1_basics

import scala.util.{Try, Success, Failure}

/**
 * gRPC 004 - Unary RPC
 *
 * Unary RPCs are the simplest form: one request, one response.
 * Key concepts:
 *   - Request-response pattern (like HTTP request/response)
 *   - Metadata: key-value headers sent with requests/responses
 *   - Deadlines: maximum time a client is willing to wait
 *   - Status codes: OK, CANCELLED, INVALID_ARGUMENT, NOT_FOUND, etc.
 *   - Context propagation: deadlines and metadata flow through the call chain
 */
object Grpc004_UnaryRPC {

  // --- Domain models for exercises ---

  sealed trait StatusCode
  object StatusCode {
    case object OK                 extends StatusCode
    case object Cancelled          extends StatusCode
    case object Unknown            extends StatusCode
    case object InvalidArgument    extends StatusCode
    case object DeadlineExceeded   extends StatusCode
    case object NotFound           extends StatusCode
    case object AlreadyExists      extends StatusCode
    case object PermissionDenied   extends StatusCode
    case object Unauthenticated    extends StatusCode
    case object ResourceExhausted  extends StatusCode
    case object Internal           extends StatusCode
    case object Unavailable        extends StatusCode
    case object Unimplemented      extends StatusCode
  }

  case class Metadata(headers: Map[String, String])

  case class Status(code: StatusCode, message: String)

  case class Deadline(remainingMs: Long) {
    def isExpired: Boolean = remainingMs <= 0
  }

  case class CallOptions(
    metadata: Metadata,
    deadline: Option[Deadline]
  )

  case class UnaryCall[+Req, +Resp](
    method: String,
    request: Req,
    options: CallOptions
  )

  case class UnaryResponse[Resp](
    status: Status,
    metadata: Metadata,
    body: Option[Resp]
  )

  // Exercise 1: Create a basic unary call
  // TODO: Create a UnaryCall[String, String] for method "/user.UserService/GetUser"
  //   with request = "user-123",
  //   metadata containing "authorization" -> "Bearer token123",
  //   and deadline of 5000ms.
  def exercise1_createUnaryCall: UnaryCall[String, String] = ???

  // Exercise 2: Build a successful unary response
  // TODO: Given a response body of type String, create a UnaryResponse with:
  //   status = Status(OK, ""), empty metadata, body = Some(responseBody)
  def exercise2_successResponse(responseBody: String): UnaryResponse[String] = ???

  // Exercise 3: Build an error unary response
  // TODO: Given a StatusCode and error message, create a UnaryResponse[String] with:
  //   the given status code and message, empty metadata, body = None
  def exercise3_errorResponse(code: StatusCode, message: String): UnaryResponse[String] = ???

  // Exercise 4: Check deadline and return appropriate response
  // TODO: Given a UnaryCall, check if the deadline is expired.
  //   - If no deadline is set, return a success response with body "processed"
  //   - If deadline is not expired, return a success response with body "processed"
  //   - If deadline is expired, return an error response with DeadlineExceeded
  //     and message "deadline exceeded"
  def exercise4_checkDeadline(call: UnaryCall[String, String]): UnaryResponse[String] = ???

  // Exercise 5: Extract and validate required metadata
  // TODO: Given a CallOptions and a list of required header keys,
  //   return Right(Metadata) with only the required headers if all are present,
  //   or Left(missingKey) with the first missing key if any are absent.
  def exercise5_validateMetadata(
    options: CallOptions,
    requiredKeys: List[String]
  ): Either[String, Metadata] = ???

  // Exercise 6: Simulate a unary RPC handler
  // TODO: Implement a handler that processes a call with method routing:
  //   - If method contains "GetUser": return success with body "user-data"
  //   - If method contains "DeleteUser": return success with body "deleted"
  //   - If method contains "CreateUser": return success with body "created"
  //   - Otherwise: return error with Unimplemented and message "method not found"
  //   Always check the deadline first (if expired, return DeadlineExceeded).
  def exercise6_handleUnaryCall(call: UnaryCall[String, String]): UnaryResponse[String] = ???

  // Exercise 7: Propagate metadata through a call chain
  // TODO: Given an incoming CallOptions, create a new CallOptions for a downstream call:
  //   - Copy the "x-request-id" header if present
  //   - Copy the "authorization" header if present
  //   - Add a new header "x-forwarded-by" with value "gateway"
  //   - Reduce the deadline by 100ms (for network overhead). If remaining <= 0 after
  //     reduction, set deadline to Some(Deadline(0)).
  //   - If no deadline was set, leave it as None.
  def exercise7_propagateContext(incoming: CallOptions): CallOptions = ???

  // Exercise 8: Map status code to HTTP status
  // TODO: Convert a gRPC StatusCode to the corresponding HTTP status code (as Int):
  //   OK -> 200, Cancelled -> 499, InvalidArgument -> 400, NotFound -> 404,
  //   AlreadyExists -> 409, PermissionDenied -> 403, Unauthenticated -> 401,
  //   ResourceExhausted -> 429, Internal -> 500, Unavailable -> 503,
  //   Unimplemented -> 501, DeadlineExceeded -> 504, Unknown -> 500
  def exercise8_grpcToHttpStatus(code: StatusCode): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val call = exercise1_createUnaryCall
    assert(call.method == "/user.UserService/GetUser", "Exercise 1 failed: wrong method")
    assert(call.request == "user-123", "Exercise 1 failed: wrong request")
    assert(call.options.metadata.headers("authorization") == "Bearer token123", "Exercise 1 failed: wrong auth")
    assert(call.options.deadline.exists(_.remainingMs == 5000), "Exercise 1 failed: wrong deadline")
    println("Exercise 1 passed: unary call created")

    // Exercise 2
    val resp = exercise2_successResponse("hello")
    assert(resp.status.code == StatusCode.OK, "Exercise 2 failed: wrong status")
    assert(resp.body.contains("hello"), "Exercise 2 failed: wrong body")
    println("Exercise 2 passed: success response created")

    // Exercise 3
    val errResp = exercise3_errorResponse(StatusCode.NotFound, "user not found")
    assert(errResp.status.code == StatusCode.NotFound, "Exercise 3 failed: wrong status")
    assert(errResp.status.message == "user not found", "Exercise 3 failed: wrong message")
    assert(errResp.body.isEmpty, "Exercise 3 failed: body should be empty")
    println("Exercise 3 passed: error response created")

    // Exercise 4
    val expiredCall = UnaryCall("test", "req", CallOptions(Metadata(Map.empty), Some(Deadline(0))))
    assert(exercise4_checkDeadline(expiredCall).status.code == StatusCode.DeadlineExceeded, "Exercise 4 failed: expired")
    val validCall = UnaryCall("test", "req", CallOptions(Metadata(Map.empty), Some(Deadline(1000))))
    assert(exercise4_checkDeadline(validCall).status.code == StatusCode.OK, "Exercise 4 failed: valid")
    val noDeadline = UnaryCall("test", "req", CallOptions(Metadata(Map.empty), None))
    assert(exercise4_checkDeadline(noDeadline).status.code == StatusCode.OK, "Exercise 4 failed: no deadline")
    println("Exercise 4 passed: deadline checking correct")

    // Exercise 5
    val opts = CallOptions(Metadata(Map("auth" -> "token", "id" -> "123")), None)
    assert(exercise5_validateMetadata(opts, List("auth", "id")).isRight, "Exercise 5 failed: should be right")
    assert(exercise5_validateMetadata(opts, List("auth", "missing")) == Left("missing"), "Exercise 5 failed: should be left")
    println("Exercise 5 passed: metadata validation correct")

    // Exercise 6
    val getUserCall = UnaryCall("/user.UserService/GetUser", "req", CallOptions(Metadata(Map.empty), Some(Deadline(5000))))
    assert(exercise6_handleUnaryCall(getUserCall).body.contains("user-data"), "Exercise 6 failed: GetUser")
    val unknownCall = UnaryCall("/unknown/Method", "req", CallOptions(Metadata(Map.empty), Some(Deadline(5000))))
    assert(exercise6_handleUnaryCall(unknownCall).status.code == StatusCode.Unimplemented, "Exercise 6 failed: unknown")
    val expiredGetUser = UnaryCall("/user.UserService/GetUser", "req", CallOptions(Metadata(Map.empty), Some(Deadline(0))))
    assert(exercise6_handleUnaryCall(expiredGetUser).status.code == StatusCode.DeadlineExceeded, "Exercise 6 failed: expired")
    println("Exercise 6 passed: unary handler correct")

    // Exercise 7
    val incoming = CallOptions(
      Metadata(Map("x-request-id" -> "abc", "authorization" -> "Bearer xyz", "other" -> "ignored")),
      Some(Deadline(500))
    )
    val propagated = exercise7_propagateContext(incoming)
    assert(propagated.metadata.headers("x-request-id") == "abc", "Exercise 7 failed: request-id")
    assert(propagated.metadata.headers("authorization") == "Bearer xyz", "Exercise 7 failed: auth")
    assert(propagated.metadata.headers("x-forwarded-by") == "gateway", "Exercise 7 failed: forwarded-by")
    assert(!propagated.metadata.headers.contains("other"), "Exercise 7 failed: should not copy other")
    assert(propagated.deadline.exists(_.remainingMs == 400), "Exercise 7 failed: deadline not reduced")
    println("Exercise 7 passed: context propagation correct")

    // Exercise 8
    assert(exercise8_grpcToHttpStatus(StatusCode.OK) == 200, "Exercise 8 failed: OK")
    assert(exercise8_grpcToHttpStatus(StatusCode.NotFound) == 404, "Exercise 8 failed: NotFound")
    assert(exercise8_grpcToHttpStatus(StatusCode.Internal) == 500, "Exercise 8 failed: Internal")
    assert(exercise8_grpcToHttpStatus(StatusCode.Unauthenticated) == 401, "Exercise 8 failed: Unauthenticated")
    assert(exercise8_grpcToHttpStatus(StatusCode.DeadlineExceeded) == 504, "Exercise 8 failed: DeadlineExceeded")
    println("Exercise 8 passed: gRPC to HTTP status mapping correct")

    println("\nAll Grpc004_UnaryRPC exercises passed!")
  }
}
