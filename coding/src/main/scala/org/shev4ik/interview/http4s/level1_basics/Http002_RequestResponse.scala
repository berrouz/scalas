package org.shev4ik.interview.http4s.level1_basics

/**
 * Http4s 002 - Request[F] and Response[F]
 *
 * =Overview=
 * In http4s, the core HTTP primitives are `Request[F]` and `Response[F]`, where `F[_]`
 * is an effect type (typically `IO` from Cats Effect, but can be any `Async[F]`). This
 * parameterization on `F` is known as '''effect polymorphism''' and is a defining design
 * choice in http4s.
 *
 * =Request[F] Structure=
 *  - '''Method''': GET, POST, PUT, DELETE, PATCH, etc. (sealed ADT in http4s)
 *  - '''Uri''': Parsed, type-safe URI with path segments, query parameters, and fragment
 *  - '''Headers''': Typed header collection (`Headers`) with type-safe accessors for
 *    standard headers (Content-Type, Accept, Authorization, etc.)
 *  - '''Body''': `EntityBody[F]` which is actually `Stream[F, Byte]` -- an FS2 stream.
 *    This means request bodies are streamed lazily, not loaded entirely into memory.
 *
 * =Response[F] Structure=
 *  - '''Status''': HTTP status code with reason phrase (e.g., `Status.Ok`, `Status.NotFound`)
 *  - '''Headers''': Same typed header collection as Request
 *  - '''Body''': Also `EntityBody[F]` (streamed via FS2)
 *
 * =Effect Polymorphism (the F[_] parameter)=
 * http4s parameterizes on `F[_]` instead of hardcoding `IO` for several reasons:
 *  1. '''Testability''': You can substitute `IO` with `SyncIO` or a test monad
 *  2. '''Flexibility''': Works with ZIO (via interop), Monix Task, or any Cats Effect compatible type
 *  3. '''Abstraction''': Library code written against `Async[F]` or `Concurrent[F]` is
 *     reusable across different effect systems
 *  4. '''Separation of concerns''': Business logic describes ''what'' effects to perform,
 *     while the runtime decides ''how'' to execute them
 *
 * =Immutability=
 * Both Request and Response are '''immutable case classes'''. Modifications use `.withXxx`
 * builder methods or `.copy()`, returning new instances. This is essential for thread safety
 * and referential transparency in functional code.
 *
 * =Real-World Usage=
 * In production http4s services, you pattern-match on `Request[F]` method and URI to
 * route requests, use `EntityDecoder[F, A]` to parse bodies (JSON via circe, form data,
 * multipart), and construct `Response[F]` values with appropriate status, headers, and
 * entity-encoded bodies. The entire request-response cycle is a pure function:
 * `Request[F] => F[Response[F]]` (which is `HttpRoutes[F]` via Kleisli).
 *
 * =Interview Tip=
 * ''"Why does http4s parameterize on F[_] instead of hardcoding IO?"''
 *
 * '''Answer:''' Effect polymorphism allows http4s to be runtime-agnostic. Your HTTP
 * routes and middleware can work with any effect type that satisfies the required type
 * class constraints (Async, Concurrent, etc.). This means the same server code can run
 * on Cats Effect IO, ZIO (via zio-interop-cats), or Monix Task. It also improves
 * testability -- you can run routes with `SyncIO` in unit tests to avoid async complexity.
 * The trade-off is slightly more complex type signatures, but the flexibility in large
 * codebases is substantial.
 */
object Http002_RequestResponse {

  // --- Domain models ---

  sealed trait Method
  object Method {
    case object GET    extends Method
    case object POST   extends Method
    case object PUT    extends Method
    case object DELETE extends Method
  }

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val Created: Status = Status(201, "Created")
    val NoContent: Status = Status(204, "No Content")
    val BadRequest: Status = Status(400, "Bad Request")
    val NotFound: Status = Status(404, "Not Found")
  }

  case class Header(name: String, value: String)

  case class Request(
    method: Method,
    uri: String,
    headers: List[Header],
    body: Option[String]
  )

  case class Response(
    status: Status,
    headers: List[Header],
    body: Option[String]
  )

  sealed trait ContentType
  object ContentType {
    case object Json      extends ContentType { override def toString = "application/json" }
    case object PlainText extends ContentType { override def toString = "text/plain" }
    case object Html       extends ContentType { override def toString = "text/html" }
    case object Xml        extends ContentType { override def toString = "application/xml" }
    case object FormData   extends ContentType { override def toString = "application/x-www-form-urlencoded" }
  }

  // Exercise 1: Build a GET request
  // TODO: Create a GET Request to "/api/users" with:
  //   headers: [Header("Accept", "application/json")]
  //   body: None (GET requests typically have no body)
  def exercise1_buildGetRequest: Request = ???

  // Exercise 2: Build a POST request with JSON body
  // TODO: Create a POST Request to "/api/users" with:
  //   headers: [Header("Content-Type", "application/json"), Header("Accept", "application/json")]
  //   body: Some("""{"name":"Alice","age":30}""")
  def exercise2_buildPostRequest: Request = ???

  // Exercise 3: Build a successful JSON response
  // TODO: Create a Response with Status.Ok, Content-Type application/json header,
  //   and body = Some("""{"id":1,"name":"Alice"}""")
  def exercise3_buildOkResponse: Response = ???

  // Exercise 4: Add a header to an existing request immutably
  // TODO: Given a Request and a Header, return a new Request with the header appended.
  //   Do NOT mutate the original request.
  def exercise4_addHeader(request: Request, header: Header): Request = ???

  // Exercise 5: Extract the Content-Type from a request/response's headers
  // TODO: Given a list of Headers, find the "Content-Type" header and return
  //   the matching ContentType. Return None if not found or unrecognized.
  //   Match: "application/json" -> Json, "text/plain" -> PlainText,
  //          "text/html" -> Html, "application/xml" -> Xml,
  //          "application/x-www-form-urlencoded" -> FormData
  def exercise5_extractContentType(headers: List[Header]): Option[ContentType] = ???

  // Exercise 6: Transform a request's body
  // TODO: Given a Request and a function String => String, apply the function
  //   to the body if present. Return the updated Request.
  //   If body is None, return the request unchanged.
  def exercise6_transformBody(request: Request, f: String => String): Request = ???

  // Exercise 7: Build a response from a status code and optional body
  // TODO: Given a status code (Int) and an Option[String] body:
  //   - Look up the Status (200 -> Ok, 201 -> Created, 204 -> NoContent,
  //     400 -> BadRequest, 404 -> NotFound). Default to Status(code, "Unknown").
  //   - If body is Some, add Content-Type: text/plain header
  //   - If body is None, no headers
  def exercise7_buildResponse(code: Int, body: Option[String]): Response = ???

  // Exercise 8: Content negotiation - choose response content type
  // TODO: Given a Request, look at its "Accept" header and return the best
  //   ContentType match. Priority order: Json > Xml > Html > PlainText
  //   If Accept header contains "application/json" -> Json
  //   If Accept header contains "application/xml" -> Xml
  //   If Accept header contains "text/html" -> Html
  //   If Accept header contains "*/*" or "text/plain" -> PlainText
  //   If no Accept header, default to PlainText
  def exercise8_negotiateContentType(request: Request): ContentType = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val getReq = exercise1_buildGetRequest
    assert(getReq.method == Method.GET, "Exercise 1 failed: wrong method")
    assert(getReq.uri == "/api/users", "Exercise 1 failed: wrong uri")
    assert(getReq.body.isEmpty, "Exercise 1 failed: GET should have no body")
    assert(getReq.headers.exists(h => h.name == "Accept" && h.value == "application/json"), "Exercise 1 failed: missing Accept header")
    println("Exercise 1 passed: GET request built")

    // Exercise 2
    val postReq = exercise2_buildPostRequest
    assert(postReq.method == Method.POST, "Exercise 2 failed: wrong method")
    assert(postReq.body.contains("""{"name":"Alice","age":30}"""), "Exercise 2 failed: wrong body")
    assert(postReq.headers.exists(h => h.name == "Content-Type"), "Exercise 2 failed: missing Content-Type")
    println("Exercise 2 passed: POST request built")

    // Exercise 3
    val okResp = exercise3_buildOkResponse
    assert(okResp.status == Status.Ok, "Exercise 3 failed: wrong status")
    assert(okResp.body.contains("""{"id":1,"name":"Alice"}"""), "Exercise 3 failed: wrong body")
    println("Exercise 3 passed: OK response built")

    // Exercise 4
    val withHeader = exercise4_addHeader(getReq, Header("X-Request-Id", "abc"))
    assert(withHeader.headers.length == getReq.headers.length + 1, "Exercise 4 failed: header not added")
    assert(withHeader.headers.exists(_.name == "X-Request-Id"), "Exercise 4 failed: wrong header")
    assert(getReq.headers.length == 1, "Exercise 4 failed: original mutated")
    println("Exercise 4 passed: header added immutably")

    // Exercise 5
    val jsonHeaders = List(Header("Content-Type", "application/json"))
    assert(exercise5_extractContentType(jsonHeaders).contains(ContentType.Json), "Exercise 5 failed: json")
    assert(exercise5_extractContentType(List.empty).isEmpty, "Exercise 5 failed: empty")
    val htmlHeaders = List(Header("Content-Type", "text/html"))
    assert(exercise5_extractContentType(htmlHeaders).contains(ContentType.Html), "Exercise 5 failed: html")
    println("Exercise 5 passed: content type extraction works")

    // Exercise 6
    val transformed = exercise6_transformBody(postReq, _.toUpperCase)
    assert(transformed.body.exists(_.contains("ALICE")), "Exercise 6 failed: transform not applied")
    val noBodyReq = exercise6_transformBody(getReq, _.toUpperCase)
    assert(noBodyReq.body.isEmpty, "Exercise 6 failed: None body should stay None")
    println("Exercise 6 passed: body transformation works")

    // Exercise 7
    val resp200 = exercise7_buildResponse(200, Some("hello"))
    assert(resp200.status == Status.Ok, "Exercise 7 failed: wrong status")
    assert(resp200.headers.exists(_.name == "Content-Type"), "Exercise 7 failed: missing header")
    val resp204 = exercise7_buildResponse(204, None)
    assert(resp204.status == Status.NoContent, "Exercise 7 failed: 204")
    assert(resp204.headers.isEmpty, "Exercise 7 failed: should have no headers")
    println("Exercise 7 passed: response building works")

    // Exercise 8
    val jsonReq = Request(Method.GET, "/", List(Header("Accept", "application/json")), None)
    assert(exercise8_negotiateContentType(jsonReq) == ContentType.Json, "Exercise 8 failed: json")
    val anyReq = Request(Method.GET, "/", List(Header("Accept", "*/*")), None)
    assert(exercise8_negotiateContentType(anyReq) == ContentType.PlainText, "Exercise 8 failed: any")
    val noAccept = Request(Method.GET, "/", List.empty, None)
    assert(exercise8_negotiateContentType(noAccept) == ContentType.PlainText, "Exercise 8 failed: default")
    println("Exercise 8 passed: content negotiation works")

    println("\nAll Http002_RequestResponse exercises passed!")
  }
}
