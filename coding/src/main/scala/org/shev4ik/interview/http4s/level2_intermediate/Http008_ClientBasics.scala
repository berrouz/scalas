package org.shev4ik.interview.http4s.level2_intermediate

/**
 * Http4s 008 - HTTP Client Basics
 *
 * Building and using HTTP clients. Key concepts:
 *   - Client as a function: Request => Response
 *   - Building GET/POST/PUT/DELETE requests
 *   - Response handling and body extraction
 *   - Client configuration (timeouts, headers)
 *   - Request/response interceptors
 *   - Retry logic for transient failures
 */
object Http008_ClientBasics {

  // --- Domain models ---

  sealed trait Method
  object Method {
    case object GET    extends Method
    case object POST   extends Method
    case object PUT    extends Method
    case object DELETE extends Method
  }

  case class Status(code: Int, reason: String) {
    def isSuccess: Boolean = code >= 200 && code < 300
  }
  object Status {
    val Ok: Status = Status(200, "OK")
    val Created: Status = Status(201, "Created")
    val NoContent: Status = Status(204, "No Content")
    val BadRequest: Status = Status(400, "Bad Request")
    val NotFound: Status = Status(404, "Not Found")
    val InternalServerError: Status = Status(500, "Internal Server Error")
  }

  case class Header(name: String, value: String)
  case class Request(method: Method, url: String, headers: List[Header], body: Option[String])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  case class ClientConfig(
    baseUrl: String,
    defaultHeaders: List[Header],
    connectTimeout: Long,    // millis
    readTimeout: Long,       // millis
    maxRetries: Int
  )

  // Client is a function from Request to Either[Throwable, Response]
  type HttpClient = Request => Either[Throwable, Response]

  // Exercise 1: Build a GET request for a URL
  // TODO: Create a Request with Method.GET, the given URL, Accept: application/json header,
  //   and no body.
  def exercise1_buildGetRequest(url: String): Request = ???

  // Exercise 2: Build a POST request with a JSON body
  // TODO: Create a Request with Method.POST, the given URL,
  //   Content-Type: application/json and Accept: application/json headers,
  //   and the given JSON string as the body.
  def exercise2_buildPostRequest(url: String, jsonBody: String): Request = ???

  // Exercise 3: Create a client configuration
  // TODO: Create a ClientConfig with:
  //   baseUrl as given, defaultHeaders = [Header("User-Agent", "scala-http-client/1.0")],
  //   connectTimeout = 5000, readTimeout = 30000, maxRetries = 3
  def exercise3_createClientConfig(baseUrl: String): ClientConfig = ???

  // Exercise 4: Apply base URL and default headers to a request
  // TODO: Given a ClientConfig and a Request with a relative URL (e.g., "/api/users"),
  //   return a new Request with:
  //   - URL prefixed by baseUrl (e.g., "http://localhost:8080/api/users")
  //   - Default headers from config prepended (request headers take priority for duplicates)
  def exercise4_prepareRequest(config: ClientConfig, request: Request): Request = ???

  // Exercise 5: Extract and parse the response body
  // TODO: Given a Response, extract the body. Return:
  //   Right(body) if status is success (2xx) and body is Some
  //   Left("empty response body") if status is success but body is None
  //   Left(s"HTTP error ${status.code}: ${body.getOrElse(status.reason)}") for non-success status
  def exercise5_extractBody(response: Response): Either[String, String] = ???

  // Exercise 6: Implement a simple retry mechanism
  // TODO: Given a function that produces Either[Throwable, Response] and maxRetries,
  //   retry the function up to maxRetries times on failure (Left).
  //   Also retry on 5xx responses (server errors).
  //   Return the first successful response or the last error.
  def exercise6_withRetry(
    maxRetries: Int,
    execute: () => Either[Throwable, Response]
  ): Either[Throwable, Response] = ???

  // Exercise 7: Create a request interceptor
  // TODO: Given an HttpClient and a request transformation function,
  //   return a new HttpClient that applies the transformation before sending.
  //   This is useful for adding auth tokens, request IDs, etc.
  def exercise7_withRequestInterceptor(
    client: HttpClient,
    interceptor: Request => Request
  ): HttpClient = ???

  // Exercise 8: Implement a mock HTTP client for testing
  // TODO: Given a Map of (Method, String) -> Response (method + URL path -> canned response),
  //   return an HttpClient that looks up the request and returns the matching response.
  //   If no match found, return Left(new NoSuchElementException(s"No mock for ${method} ${url}"))
  def exercise8_mockClient(mocks: Map[(Method, String), Response]): HttpClient = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val getReq = exercise1_buildGetRequest("http://api.example.com/users")
    assert(getReq.method == Method.GET, "Exercise 1 failed: wrong method")
    assert(getReq.url == "http://api.example.com/users", "Exercise 1 failed: wrong url")
    assert(getReq.body.isEmpty, "Exercise 1 failed: GET should have no body")
    assert(getReq.headers.exists(h => h.name == "Accept" && h.value == "application/json"), "Exercise 1 failed: missing Accept")
    println("Exercise 1 passed: GET request built")

    // Exercise 2
    val postReq = exercise2_buildPostRequest("http://api.example.com/users", """{"name":"Alice"}""")
    assert(postReq.method == Method.POST, "Exercise 2 failed: wrong method")
    assert(postReq.body.contains("""{"name":"Alice"}"""), "Exercise 2 failed: wrong body")
    assert(postReq.headers.exists(h => h.name == "Content-Type"), "Exercise 2 failed: missing Content-Type")
    println("Exercise 2 passed: POST request built")

    // Exercise 3
    val cfg = exercise3_createClientConfig("http://localhost:8080")
    assert(cfg.baseUrl == "http://localhost:8080", "Exercise 3 failed: wrong baseUrl")
    assert(cfg.maxRetries == 3, "Exercise 3 failed: wrong maxRetries")
    assert(cfg.defaultHeaders.exists(_.name == "User-Agent"), "Exercise 3 failed: missing User-Agent")
    println("Exercise 3 passed: client config created")

    // Exercise 4
    val relReq = Request(Method.GET, "/api/users", List(Header("Accept", "text/html")), None)
    val prepared = exercise4_prepareRequest(cfg, relReq)
    assert(prepared.url == "http://localhost:8080/api/users", "Exercise 4 failed: URL not prefixed")
    assert(prepared.headers.exists(_.name == "User-Agent"), "Exercise 4 failed: missing default header")
    println("Exercise 4 passed: request preparation works")

    // Exercise 5
    val okResp = Response(Status.Ok, List.empty, Some("""{"data":"value"}"""))
    assert(exercise5_extractBody(okResp) == Right("""{"data":"value"}"""), "Exercise 5 failed: ok response")
    val emptyResp = Response(Status.Ok, List.empty, None)
    assert(exercise5_extractBody(emptyResp).isLeft, "Exercise 5 failed: empty body")
    val errResp = Response(Status.NotFound, List.empty, Some("not found"))
    assert(exercise5_extractBody(errResp).isLeft, "Exercise 5 failed: error response")
    assert(exercise5_extractBody(errResp).swap.toOption.get.contains("404"), "Exercise 5 failed: should include status code")
    println("Exercise 5 passed: body extraction works")

    // Exercise 6
    var attempt = 0
    val flakyExecute: () => Either[Throwable, Response] = () => {
      attempt += 1
      if (attempt < 3) Left(new RuntimeException("connection failed"))
      else Right(Response(Status.Ok, List.empty, Some("success")))
    }
    val retryResult = exercise6_withRetry(5, flakyExecute)
    assert(retryResult.isRight, "Exercise 6 failed: should succeed after retries")
    assert(attempt == 3, s"Exercise 6 failed: expected 3 attempts, got $attempt")
    println("Exercise 6 passed: retry mechanism works")

    // Exercise 7
    val mockClient: HttpClient = req => Right(Response(Status.Ok, req.headers, Some("ok")))
    val authClient = exercise7_withRequestInterceptor(mockClient, req =>
      req.copy(headers = Header("Authorization", "Bearer token123") :: req.headers)
    )
    val authResp = authClient(Request(Method.GET, "/", List.empty, None))
    assert(authResp.isRight, "Exercise 7 failed: should succeed")
    assert(authResp.toOption.get.headers.exists(h => h.name == "Authorization"), "Exercise 7 failed: auth header not added")
    println("Exercise 7 passed: request interceptor works")

    // Exercise 8
    val mocks: Map[(Method, String), Response] = Map(
      (Method.GET: Method, "/users") -> Response(Status.Ok, List.empty, Some("[{\"id\":1}]")),
      (Method.POST: Method, "/users") -> Response(Status.Created, List.empty, Some("{\"id\":2}"))
    )
    val mock = exercise8_mockClient(mocks)
    assert(mock(Request(Method.GET, "/users", List.empty, None)).isRight, "Exercise 8 failed: GET /users")
    assert(mock(Request(Method.POST, "/users", List.empty, Some("{}"))).toOption.get.status == Status.Created, "Exercise 8 failed: POST /users")
    assert(mock(Request(Method.DELETE, "/users", List.empty, None)).isLeft, "Exercise 8 failed: unmocked request")
    println("Exercise 8 passed: mock client works")

    println("\nAll Http008_ClientBasics exercises passed!")
  }
}
