package org.shev4ik.interview.http4s.level3_advanced

/**
 * Http4s 013 - Testing HTTP Services
 *
 * Testing HTTP routes, clients, and services. Key concepts:
 *   - Testing routes with synthetic requests
 *   - Response assertions (status, headers, body)
 *   - Mock clients for testing service integrations
 *   - Test fixtures and helpers
 *   - Property-based testing concepts for HTTP
 *   - Integration test patterns
 */
object Http013_Testing {

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
    val BadRequest: Status = Status(400, "Bad Request")
    val NotFound: Status = Status(404, "Not Found")
    val InternalServerError: Status = Status(500, "Internal Server Error")
  }

  case class Header(name: String, value: String)
  case class Request(method: Method, path: String, headers: List[Header], body: Option[String])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  type Service = Request => Response

  // Test assertion result
  sealed trait AssertionResult {
    def isSuccess: Boolean
  }
  object AssertionResult {
    case object Passed extends AssertionResult { def isSuccess = true }
    case class Failed(message: String) extends AssertionResult { def isSuccess = false }
  }

  // Test case representation
  case class HttpTestCase(
    name: String,
    request: Request,
    expectedStatus: Status,
    expectedBodyContains: Option[String],
    expectedHeaders: List[Header]
  )

  // Test result
  case class TestResult(
    testCase: HttpTestCase,
    actualResponse: Response,
    assertions: List[AssertionResult]
  ) {
    def passed: Boolean = assertions.forall(_.isSuccess)
    def failedAssertions: List[String] = assertions.collect { case AssertionResult.Failed(msg) => msg }
  }

  // Exercise 1: Create a test request builder
  // TODO: Create helper functions that build test requests:
  //   get(path) -> GET request with no body
  //   post(path, body) -> POST request with JSON content-type and given body
  //   put(path, body) -> PUT request with JSON content-type and given body
  //   delete(path) -> DELETE request with no body
  //   Return as a Map of function names to functions for testing.
  def exercise1_get(path: String): Request = ???
  def exercise1_post(path: String, body: String): Request = ???
  def exercise1_put(path: String, body: String): Request = ???
  def exercise1_delete(path: String): Request = ???

  // Exercise 2: Assert response status
  // TODO: Given a Response and an expected Status, return AssertionResult.
  //   Passed if status matches, Failed with descriptive message if not.
  def exercise2_assertStatus(response: Response, expected: Status): AssertionResult = ???

  // Exercise 3: Assert response body contains a string
  // TODO: Given a Response and a string, check if the body contains that string.
  //   If body is None, return Failed("response body is empty").
  //   If body doesn't contain the string, return Failed with details.
  def exercise3_assertBodyContains(response: Response, expected: String): AssertionResult = ???

  // Exercise 4: Assert response has specific headers
  // TODO: Given a Response and a list of expected Headers, check that ALL
  //   expected headers are present in the response (name AND value match).
  //   Return Passed if all found, Failed listing the missing headers.
  def exercise4_assertHeaders(response: Response, expectedHeaders: List[Header]): AssertionResult = ???

  // Exercise 5: Run a single test case against a service
  // TODO: Given a Service and an HttpTestCase, execute the request and check:
  //   - Status matches expectedStatus
  //   - If expectedBodyContains is Some, body contains that string
  //   - All expectedHeaders are present
  //   Return a TestResult with all assertion results.
  def exercise5_runTestCase(service: Service, testCase: HttpTestCase): TestResult = ???

  // Exercise 6: Run a test suite (multiple test cases) and summarize
  // TODO: Given a Service and a list of HttpTestCases, run all tests.
  //   Return a tuple: (passed: Int, failed: Int, results: List[TestResult])
  def exercise6_runTestSuite(
    service: Service,
    testCases: List[HttpTestCase]
  ): (Int, Int, List[TestResult]) = ???

  // Exercise 7: Create a recording mock service
  // TODO: Return a tuple of (service, getRecordedRequests) where:
  //   service: always returns the given default response, but records each request
  //   getRecordedRequests: returns the list of all requests that were sent to the service
  def exercise7_recordingMock(
    defaultResponse: Response
  ): (Service, () => List[Request]) = ???

  // Exercise 8: Create a stateful mock service with programmed responses
  // TODO: Given a list of responses, return a service that returns them in order.
  //   First call returns responses(0), second returns responses(1), etc.
  //   If all responses are exhausted, return Response(Status.InternalServerError, ..., Some("no more mock responses"))
  def exercise8_sequentialMock(responses: List[Response]): Service = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val getReq = exercise1_get("/users")
    assert(getReq.method == Method.GET && getReq.path == "/users" && getReq.body.isEmpty, "Exercise 1 failed: get")
    val postReq = exercise1_post("/users", """{"name":"Alice"}""")
    assert(postReq.method == Method.POST && postReq.body.contains("""{"name":"Alice"}"""), "Exercise 1 failed: post")
    assert(postReq.headers.exists(h => h.name == "Content-Type" && h.value == "application/json"), "Exercise 1 failed: post content-type")
    val putReq = exercise1_put("/users/1", """{"name":"Bob"}""")
    assert(putReq.method == Method.PUT, "Exercise 1 failed: put")
    val delReq = exercise1_delete("/users/1")
    assert(delReq.method == Method.DELETE && delReq.body.isEmpty, "Exercise 1 failed: delete")
    println("Exercise 1 passed: test request builders work")

    // Exercise 2
    val okResp = Response(Status.Ok, List.empty, Some("ok"))
    assert(exercise2_assertStatus(okResp, Status.Ok).isSuccess, "Exercise 2 failed: matching status")
    assert(!exercise2_assertStatus(okResp, Status.NotFound).isSuccess, "Exercise 2 failed: non-matching status")
    println("Exercise 2 passed: status assertion works")

    // Exercise 3
    assert(exercise3_assertBodyContains(okResp, "ok").isSuccess, "Exercise 3 failed: body contains")
    assert(!exercise3_assertBodyContains(okResp, "missing").isSuccess, "Exercise 3 failed: body doesn't contain")
    val emptyResp = Response(Status.Ok, List.empty, None)
    assert(!exercise3_assertBodyContains(emptyResp, "anything").isSuccess, "Exercise 3 failed: empty body")
    println("Exercise 3 passed: body assertion works")

    // Exercise 4
    val headeredResp = Response(Status.Ok, List(Header("Content-Type", "application/json"), Header("X-Custom", "yes")), None)
    assert(exercise4_assertHeaders(headeredResp, List(Header("Content-Type", "application/json"))).isSuccess, "Exercise 4 failed: header present")
    assert(!exercise4_assertHeaders(headeredResp, List(Header("X-Missing", "no"))).isSuccess, "Exercise 4 failed: header missing")
    println("Exercise 4 passed: header assertion works")

    // Exercise 5
    val testService: Service = {
      case Request(Method.GET, "/users", _, _) => Response(Status.Ok, List(Header("Content-Type", "application/json")), Some("[{\"id\":1}]"))
      case _ => Response(Status.NotFound, List.empty, Some("not found"))
    }
    val tc = HttpTestCase("get users", exercise1_get("/users"), Status.Ok, Some("id"), List(Header("Content-Type", "application/json")))
    val result = exercise5_runTestCase(testService, tc)
    assert(result.passed, s"Exercise 5 failed: test should pass, failures: ${result.failedAssertions}")
    val failTc = HttpTestCase("get missing", exercise1_get("/nope"), Status.Ok, None, List.empty)
    val failResult = exercise5_runTestCase(testService, failTc)
    assert(!failResult.passed, "Exercise 5 failed: test should fail")
    println("Exercise 5 passed: test case execution works")

    // Exercise 6
    val testCases = List(
      HttpTestCase("get users", exercise1_get("/users"), Status.Ok, Some("id"), List.empty),
      HttpTestCase("get missing", exercise1_get("/nope"), Status.Ok, None, List.empty)
    )
    val (passed, failed, _) = exercise6_runTestSuite(testService, testCases)
    assert(passed == 1, s"Exercise 6 failed: expected 1 passed, got $passed")
    assert(failed == 1, s"Exercise 6 failed: expected 1 failed, got $failed")
    println("Exercise 6 passed: test suite execution works")

    // Exercise 7
    val (mockService, getRecorded) = exercise7_recordingMock(Response(Status.Ok, List.empty, Some("mock")))
    mockService(exercise1_get("/a"))
    mockService(exercise1_post("/b", "body"))
    val recorded = getRecorded()
    assert(recorded.length == 2, "Exercise 7 failed: should record 2 requests")
    assert(recorded.head.path == "/a", "Exercise 7 failed: wrong first path")
    assert(recorded(1).path == "/b", "Exercise 7 failed: wrong second path")
    println("Exercise 7 passed: recording mock works")

    // Exercise 8
    val seqMock = exercise8_sequentialMock(List(
      Response(Status.Ok, List.empty, Some("first")),
      Response(Status.Created, List.empty, Some("second"))
    ))
    assert(seqMock(exercise1_get("/")).body.contains("first"), "Exercise 8 failed: first response")
    assert(seqMock(exercise1_get("/")).body.contains("second"), "Exercise 8 failed: second response")
    assert(seqMock(exercise1_get("/")).status == Status.InternalServerError, "Exercise 8 failed: exhausted")
    println("Exercise 8 passed: sequential mock works")

    println("\nAll Http013_Testing exercises passed!")
  }
}
