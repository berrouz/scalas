package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 019 - HTTP Routing Basics
 *
 * Akka HTTP provides a powerful routing DSL for building REST APIs:
 *   - Route: a function from RequestContext to RouteResult
 *   - path/get/post/put/delete: HTTP method and path matching directives
 *   - pathPrefix: matches a path prefix for nested routes
 *   - complete: completes the request with a response
 *   - entity: extracts the request body
 *   - parameter: extracts query parameters
 *   - reject: explicitly reject a request
 *   - Exception handling: custom error responses
 *
 * We model the routing DSL using pure Scala ADTs and pattern matching.
 */
object Akka019_HTTP {

  // --- Domain models ---

  sealed trait HttpMethod
  case object GET extends HttpMethod
  case object POST extends HttpMethod
  case object PUT extends HttpMethod
  case object DELETE extends HttpMethod

  case class HttpRequest(
    method: HttpMethod,
    path: String,
    body: Option[String],
    parameters: Map[String, String]
  )

  sealed trait HttpResponse
  case class Ok(body: String) extends HttpResponse
  case class Created(body: String) extends HttpResponse
  case class BadRequest(message: String) extends HttpResponse
  case class NotFound(message: String) extends HttpResponse
  case class InternalError(message: String) extends HttpResponse
  case class Rejected(reason: String) extends HttpResponse

  type Route = HttpRequest => HttpResponse

  // Exercise 1: Basic route definition
  // TODO: Define a route that handles:
  //   GET /hello -> Ok("Hello, World!")
  //   Any other request -> NotFound("Route not found")
  def exercise1_basicRoute: Route = ???

  // Exercise 2: Path matching with get/post/put/delete
  // TODO: Define routes for a /users resource:
  //   GET /users -> Ok("List of users")
  //   POST /users -> Created("User created")
  //   PUT /users -> Ok("User updated")
  //   DELETE /users -> Ok("User deleted")
  //   Any other path -> NotFound("Not found")
  def exercise2_methodRoutes: Route = ???

  // Exercise 3: PathPrefix for nested routes
  // TODO: Define routes with pathPrefix:
  //   /api/v1/users -> Ok("Users API v1")
  //   /api/v1/orders -> Ok("Orders API v1")
  //   /api/v2/users -> Ok("Users API v2")
  //   /api/* (anything else under /api) -> NotFound("API endpoint not found")
  //   Other paths -> NotFound("Not found")
  //   Match by checking if path starts with the prefix.
  def exercise3_pathPrefix: Route = ???

  // Exercise 4: Complete with response
  // TODO: Define a route for GET /status that:
  //   - If parameter "format" is "json", return Ok("""{"status": "ok"}""")
  //   - If parameter "format" is "text", return Ok("Status: ok")
  //   - If no format parameter, return Ok("ok")
  //   - Other methods -> Rejected("Method not allowed")
  def exercise4_complete: Route = ???

  // Exercise 5: Entity extraction (request body)
  // TODO: Define a route for POST /echo that:
  //   - Extracts the request body
  //   - If body is present, return Ok(body)
  //   - If body is empty/None, return BadRequest("Empty body")
  //   - Other methods -> Rejected("Only POST allowed")
  def exercise5_entity: Route = ???

  // Exercise 6: Parameter extraction
  // TODO: Define a route for GET /search that:
  //   - Requires parameter "q" (query string)
  //   - Optional parameter "limit" (defaults to "10")
  //   - Returns Ok(s"Searching for: $q, limit: $limit")
  //   - If "q" is missing, return BadRequest("Missing required parameter: q")
  def exercise6_parameter: Route = ???

  // Exercise 7: Rejection handling
  // TODO: Define a route that:
  //   GET /public/* -> Ok("Public content: " + remaining path after /public/)
  //   GET /private/* -> Rejected("Authentication required")
  //   POST /private/* -> Rejected("Authentication required")
  //   Other -> NotFound("Not found")
  def exercise7_rejection: Route = ???

  // Exercise 8: Exception handling
  // TODO: Define a route for GET /divide?a=X&b=Y that:
  //   - Parses a and b as integers
  //   - Returns Ok((a / b).toString)
  //   - If b is "0", return BadRequest("Division by zero")
  //   - If a or b are not valid integers, return BadRequest("Invalid number format")
  //   - If a or b are missing, return BadRequest("Missing parameters a and b")
  def exercise8_exceptionHandling: Route = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1a = exercise1_basicRoute(HttpRequest(GET, "/hello", None, Map.empty))
    assert(r1a == Ok("Hello, World!"), s"Exercise 1 failed: $r1a")
    val r1b = exercise1_basicRoute(HttpRequest(POST, "/hello", None, Map.empty))
    assert(r1b == NotFound("Route not found"), s"Exercise 1 failed: $r1b")
    println("Exercise 1 passed: basic route")

    // Exercise 2
    assert(exercise2_methodRoutes(HttpRequest(GET, "/users", None, Map.empty)) == Ok("List of users"))
    assert(exercise2_methodRoutes(HttpRequest(POST, "/users", None, Map.empty)) == Created("User created"))
    assert(exercise2_methodRoutes(HttpRequest(PUT, "/users", None, Map.empty)) == Ok("User updated"))
    assert(exercise2_methodRoutes(HttpRequest(DELETE, "/users", None, Map.empty)) == Ok("User deleted"))
    println("Exercise 2 passed: method routes")

    // Exercise 3
    assert(exercise3_pathPrefix(HttpRequest(GET, "/api/v1/users", None, Map.empty)) == Ok("Users API v1"))
    assert(exercise3_pathPrefix(HttpRequest(GET, "/api/v2/users", None, Map.empty)) == Ok("Users API v2"))
    assert(exercise3_pathPrefix(HttpRequest(GET, "/api/v1/orders", None, Map.empty)) == Ok("Orders API v1"))
    assert(exercise3_pathPrefix(HttpRequest(GET, "/api/v3/test", None, Map.empty)) == NotFound("API endpoint not found"))
    println("Exercise 3 passed: pathPrefix routes")

    // Exercise 4
    val r4a = exercise4_complete(HttpRequest(GET, "/status", None, Map("format" -> "json")))
    assert(r4a == Ok("""{"status": "ok"}"""), s"Exercise 4 failed: $r4a")
    val r4b = exercise4_complete(HttpRequest(GET, "/status", None, Map.empty))
    assert(r4b == Ok("ok"), s"Exercise 4 failed: $r4b")
    println("Exercise 4 passed: complete with response")

    // Exercise 5
    val r5a = exercise5_entity(HttpRequest(POST, "/echo", Some("test body"), Map.empty))
    assert(r5a == Ok("test body"), s"Exercise 5 failed: $r5a")
    val r5b = exercise5_entity(HttpRequest(POST, "/echo", None, Map.empty))
    assert(r5b == BadRequest("Empty body"), s"Exercise 5 failed: $r5b")
    println("Exercise 5 passed: entity extraction")

    // Exercise 6
    val r6a = exercise6_parameter(HttpRequest(GET, "/search", None, Map("q" -> "scala", "limit" -> "5")))
    assert(r6a == Ok("Searching for: scala, limit: 5"), s"Exercise 6 failed: $r6a")
    val r6b = exercise6_parameter(HttpRequest(GET, "/search", None, Map("q" -> "akka")))
    assert(r6b == Ok("Searching for: akka, limit: 10"), s"Exercise 6 failed: $r6b")
    val r6c = exercise6_parameter(HttpRequest(GET, "/search", None, Map.empty))
    assert(r6c == BadRequest("Missing required parameter: q"), s"Exercise 6 failed: $r6c")
    println("Exercise 6 passed: parameter extraction")

    // Exercise 7
    val r7a = exercise7_rejection(HttpRequest(GET, "/public/page.html", None, Map.empty))
    assert(r7a == Ok("Public content: page.html"), s"Exercise 7 failed: $r7a")
    val r7b = exercise7_rejection(HttpRequest(GET, "/private/secret", None, Map.empty))
    assert(r7b == Rejected("Authentication required"), s"Exercise 7 failed: $r7b")
    println("Exercise 7 passed: rejection handling")

    // Exercise 8
    val r8a = exercise8_exceptionHandling(HttpRequest(GET, "/divide", None, Map("a" -> "10", "b" -> "3")))
    assert(r8a == Ok("3"), s"Exercise 8 failed: $r8a")
    val r8b = exercise8_exceptionHandling(HttpRequest(GET, "/divide", None, Map("a" -> "10", "b" -> "0")))
    assert(r8b == BadRequest("Division by zero"), s"Exercise 8 failed: $r8b")
    val r8c = exercise8_exceptionHandling(HttpRequest(GET, "/divide", None, Map("a" -> "abc", "b" -> "3")))
    assert(r8c == BadRequest("Invalid number format"), s"Exercise 8 failed: $r8c")
    println("Exercise 8 passed: exception handling")

    println("\nAll Akka019_HTTP exercises passed!")
  }
}
