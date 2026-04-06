package org.shev4ik.interview.http4s.level1_basics

/**
 * Http4s 003 - Routing
 *
 * HTTP routing maps incoming requests to handlers. Key concepts:
 *   - Route matching by method and path
 *   - Path parameters (e.g., /users/:id)
 *   - Query parameters (e.g., /users?page=1)
 *   - Route composition and fallthrough
 *   - Partial functions as route definitions
 */
object Http003_Routing {

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
    val NotFound: Status = Status(404, "Not Found")
    val MethodNotAllowed: Status = Status(405, "Method Not Allowed")
  }

  case class Request(
    method: Method,
    path: String,
    queryParams: Map[String, String],
    body: Option[String]
  )

  case class Response(status: Status, body: Option[String])

  // A Route is a partial function from Request to Response
  type Route = PartialFunction[Request, Response]

  // Exercise 1: Create a simple route that matches GET /health
  // TODO: Return a Route (PartialFunction) that:
  //   - Matches requests with method GET and path "/health"
  //   - Returns Response(Status.Ok, Some("OK"))
  //   - Does NOT match any other request
  def exercise1_healthRoute: Route = ???

  // Exercise 2: Extract a path parameter
  // TODO: Given a path pattern like "/users/{id}" and an actual path like "/users/42",
  //   extract the path parameter value. Return None if the path doesn't match.
  //   Pattern uses {name} for parameters. Only supports a single parameter.
  //   Example: extractPathParam("/users/{id}", "/users/42") -> Some(("id", "42"))
  def exercise2_extractPathParam(pattern: String, actualPath: String): Option[(String, String)] = ???

  // Exercise 3: Extract query parameters from a raw query string
  // TODO: Parse a query string like "page=1&size=10&sort=name" into Map[String, String].
  //   Handle empty query string by returning empty Map.
  //   Ignore malformed entries (entries without '=').
  def exercise3_parseQueryString(queryString: String): Map[String, String] = ???

  // Exercise 4: Create a CRUD route set for /users
  // TODO: Return a Route that handles:
  //   GET  /users       -> Response(Status.Ok, Some("list_users"))
  //   GET  /users/{id}  -> Response(Status.Ok, Some(s"get_user_$id"))  (where id is the path segment)
  //   POST /users       -> Response(Status.Created, Some("user_created"))
  //   Anything else under /users -> Response(Status.MethodNotAllowed, None)
  //   Hint: Match on (method, path) using pattern matching on the path segments
  def exercise4_usersRoute: Route = ???

  // Exercise 5: Compose two routes with fallthrough
  // TODO: Given two Routes, compose them so that if the first doesn't match,
  //   the second is tried. If neither matches, return None (the PartialFunction is not defined).
  //   Hint: Use orElse
  def exercise5_composeRoutes(route1: Route, route2: Route): Route = ???

  // Exercise 6: Create a route with query parameter handling
  // TODO: Return a Route for GET /search that:
  //   - If query param "q" is present, return Response(Status.Ok, Some(s"searching: $q"))
  //   - If "q" is missing, return Response(Status.BadRequest, Some("missing query param: q"))
  //     where Status.BadRequest = Status(400, "Bad Request")
  def exercise6_searchRoute: Route = ???

  // Exercise 7: Path prefix matching - create a route that matches any path under a prefix
  // TODO: Given a prefix (e.g., "/api/v1"), return a function that takes a Request
  //   and returns true if the request path starts with that prefix.
  def exercise7_pathPrefixMatcher(prefix: String): Request => Boolean = ???

  // Exercise 8: Build a simple router that matches a list of route definitions
  // TODO: Given a list of (Method, String, String => Response) tuples representing
  //   (method, exactPath, handlerThatTakesPath), create a function that takes a Request
  //   and returns an Option[Response]. Try each route definition in order.
  //   Return the first match or None.
  def exercise8_buildRouter(
    routes: List[(Method, String, String => Response)]
  ): Request => Option[Response] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val healthReq = Request(Method.GET, "/health", Map.empty, None)
    val healthResp = exercise1_healthRoute(healthReq)
    assert(healthResp.status == Status.Ok, "Exercise 1 failed: wrong status")
    assert(healthResp.body.contains("OK"), "Exercise 1 failed: wrong body")
    assert(!exercise1_healthRoute.isDefinedAt(Request(Method.POST, "/health", Map.empty, None)), "Exercise 1 failed: should not match POST")
    println("Exercise 1 passed: health route works")

    // Exercise 2
    assert(exercise2_extractPathParam("/users/{id}", "/users/42") == Some(("id", "42")), "Exercise 2 failed: basic")
    assert(exercise2_extractPathParam("/users/{id}", "/posts/42").isEmpty, "Exercise 2 failed: no match")
    assert(exercise2_extractPathParam("/items/{sku}", "/items/ABC-123") == Some(("sku", "ABC-123")), "Exercise 2 failed: alphanumeric")
    println("Exercise 2 passed: path param extraction works")

    // Exercise 3
    assert(exercise3_parseQueryString("page=1&size=10") == Map("page" -> "1", "size" -> "10"), "Exercise 3 failed")
    assert(exercise3_parseQueryString("") == Map.empty, "Exercise 3 failed: empty")
    assert(exercise3_parseQueryString("q=hello&bad&good=yes") == Map("q" -> "hello", "good" -> "yes"), "Exercise 3 failed: malformed")
    println("Exercise 3 passed: query string parsing works")

    // Exercise 4
    val usersRoute = exercise4_usersRoute
    assert(usersRoute(Request(Method.GET, "/users", Map.empty, None)).body.contains("list_users"), "Exercise 4 failed: list")
    assert(usersRoute(Request(Method.GET, "/users/42", Map.empty, None)).body.contains("get_user_42"), "Exercise 4 failed: get by id")
    assert(usersRoute(Request(Method.POST, "/users", Map.empty, Some("{}"))).status == Status.Created, "Exercise 4 failed: create")
    assert(usersRoute(Request(Method.DELETE, "/users", Map.empty, None)).status == Status.MethodNotAllowed, "Exercise 4 failed: method not allowed")
    println("Exercise 4 passed: CRUD routes work")

    // Exercise 5
    val route1: Route = { case Request(Method.GET, "/a", _, _) => Response(Status.Ok, Some("a")) }
    val route2: Route = { case Request(Method.GET, "/b", _, _) => Response(Status.Ok, Some("b")) }
    val composed = exercise5_composeRoutes(route1, route2)
    assert(composed(Request(Method.GET, "/a", Map.empty, None)).body.contains("a"), "Exercise 5 failed: route1")
    assert(composed(Request(Method.GET, "/b", Map.empty, None)).body.contains("b"), "Exercise 5 failed: route2")
    assert(!composed.isDefinedAt(Request(Method.GET, "/c", Map.empty, None)), "Exercise 5 failed: should not match /c")
    println("Exercise 5 passed: route composition works")

    // Exercise 6
    val searchRoute = exercise6_searchRoute
    val searchReq = Request(Method.GET, "/search", Map("q" -> "scala"), None)
    assert(searchRoute(searchReq).body.contains("searching: scala"), "Exercise 6 failed: with q")
    val noQReq = Request(Method.GET, "/search", Map.empty, None)
    assert(searchRoute(noQReq).status.code == 400, "Exercise 6 failed: missing q")
    println("Exercise 6 passed: search route with query params works")

    // Exercise 7
    val apiMatcher = exercise7_pathPrefixMatcher("/api/v1")
    assert(apiMatcher(Request(Method.GET, "/api/v1/users", Map.empty, None)), "Exercise 7 failed: match")
    assert(!apiMatcher(Request(Method.GET, "/api/v2/users", Map.empty, None)), "Exercise 7 failed: no match")
    println("Exercise 7 passed: path prefix matcher works")

    // Exercise 8
    val routeDefs: List[(Method, String, String => Response)] = List(
      (Method.GET, "/foo", _ => Response(Status.Ok, Some("foo"))),
      (Method.POST, "/bar", _ => Response(Status.Created, Some("bar")))
    )
    val router = exercise8_buildRouter(routeDefs)
    assert(router(Request(Method.GET, "/foo", Map.empty, None)).exists(_.body.contains("foo")), "Exercise 8 failed: foo")
    assert(router(Request(Method.POST, "/bar", Map.empty, None)).exists(_.status == Status.Created), "Exercise 8 failed: bar")
    assert(router(Request(Method.GET, "/baz", Map.empty, None)).isEmpty, "Exercise 8 failed: no match")
    println("Exercise 8 passed: router builder works")

    println("\nAll Http003_Routing exercises passed!")
  }
}
