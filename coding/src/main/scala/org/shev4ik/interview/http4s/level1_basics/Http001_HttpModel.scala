package org.shev4ik.interview.http4s.level1_basics

/**
 * Http4s 001 - HTTP Model
 *
 * Foundation of HTTP: methods, status codes, headers, and URIs.
 *
 * http4s design philosophy:
 *   http4s is a typeful, purely functional HTTP library for Scala. Its core idea is
 *   that an HTTP service is simply a Kleisli[F, Request[F], Response[F]] — a function
 *   from request to effectful response. This makes services composable, testable, and
 *   referentially transparent. There is no mutable state, no thread-local magic, and
 *   no annotation-based routing.
 *
 * Comparison with other Scala HTTP libraries:
 *   - vs Play Framework: Play uses an MVC architecture with controllers, action builders,
 *     and a global application lifecycle. It is opinionated and batteries-included.
 *     http4s is minimal, composable, and designed for Cats Effect / ZIO effect systems.
 *   - vs Akka HTTP: Akka HTTP uses a directive-based DSL built on Akka Streams and Actors.
 *     It is powerful but tightly coupled to the Akka ecosystem. http4s is lighter-weight,
 *     purely functional, and works with any CE-compatible runtime (Blaze, Ember, Netty).
 *
 * Note on real http4s internals:
 *   In real http4s, Method is an ADT (sealed case classes with a registry for extension
 *   methods), Status wraps an Int with companion vals for all standard codes, Uri is a
 *   proper parser built with cats-parse supporting full RFC 3986 syntax, and Headers use
 *   a typed Vault (org.typelevel.vault.Vault) for type-safe header access via Header[A]
 *   type classes — no raw string lookups needed.
 *
 * Key concepts:
 *   - HTTP Methods: GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS
 *   - Status Codes: 1xx informational, 2xx success, 3xx redirect, 4xx client error, 5xx server error
 *   - Headers: key-value pairs for metadata (Content-Type, Authorization, etc.)
 *   - URI: scheme, authority, path, query, fragment
 */
object Http001_HttpModel {

  // --- Domain models ---

  sealed trait Method
  object Method {
    case object GET     extends Method
    case object POST    extends Method
    case object PUT     extends Method
    case object DELETE  extends Method
    case object PATCH   extends Method
    case object HEAD    extends Method
    case object OPTIONS extends Method
  }

  case class Status(code: Int, reason: String) {
    def isSuccess: Boolean = code >= 200 && code < 300
    def isClientError: Boolean = code >= 400 && code < 500
    def isServerError: Boolean = code >= 500 && code < 600
    def isRedirect: Boolean = code >= 300 && code < 400
  }

  object Status {
    val Ok: Status = Status(200, "OK")
    val Created: Status = Status(201, "Created")
    val NoContent: Status = Status(204, "No Content")
    val MovedPermanently: Status = Status(301, "Moved Permanently")
    val NotFound: Status = Status(404, "Not Found")
    val BadRequest: Status = Status(400, "Bad Request")
    val Unauthorized: Status = Status(401, "Unauthorized")
    val Forbidden: Status = Status(403, "Forbidden")
    val InternalServerError: Status = Status(500, "Internal Server Error")
    val ServiceUnavailable: Status = Status(503, "Service Unavailable")
  }

  case class Header(name: String, value: String)

  object Header {
    def contentType(value: String): Header = Header("Content-Type", value)
    def authorization(value: String): Header = Header("Authorization", value)
    def accept(value: String): Header = Header("Accept", value)
  }

  case class Uri(
    scheme: Option[String],
    authority: Option[String],
    path: String,
    query: Map[String, String],
    fragment: Option[String]
  )

  // Exercise 1: Parse an HTTP method from a string
  // TODO: Given a string like "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS",
  //   return the corresponding Method. Case-insensitive.
  //   Return None for unrecognized methods.
  def exercise1_parseMethod(raw: String): Option[Method] = ???

  // Exercise 2: Classify a status code into a category
  // TODO: Given a status code (Int), return a string describing its category:
  //   1xx -> "informational", 2xx -> "success", 3xx -> "redirect",
  //   4xx -> "client_error", 5xx -> "server_error"
  //   For anything else, return "unknown"
  def exercise2_classifyStatus(code: Int): String = ???

  // Exercise 3: Build a set of headers from a Map
  // TODO: Given a Map[String, String] of header names to values,
  //   return a List[Header] sorted alphabetically by header name.
  def exercise3_buildHeaders(headerMap: Map[String, String]): List[Header] = ???

  // Exercise 4: Parse a URI string into a Uri case class
  // TODO: Parse a simplified URI of the form "scheme://authority/path?key1=val1&key2=val2#fragment"
  //   All parts except path are optional. If no query string, query map is empty.
  //   For simplicity, parse: "http://localhost:8080/api/users?page=1&size=10"
  //   Return Uri(Some("http"), Some("localhost:8080"), "/api/users", Map("page"->"1","size"->"10"), None)
  def exercise4_parseUri(raw: String): Uri = ???

  // Exercise 5: Check if a method is idempotent
  // TODO: Return true if the method is idempotent (safe to retry).
  //   Idempotent methods: GET, PUT, DELETE, HEAD, OPTIONS
  //   Non-idempotent: POST, PATCH
  //
  // Interview tip: PATCH is technically not idempotent in general, though specific
  // PATCH implementations can be. For example, a JSON Merge Patch that sets a field
  // to a fixed value is idempotent, but a JSON Patch that says "increment counter"
  // is not. This is a common interview trick question — the RFC (5789) explicitly
  // states PATCH is not idempotent, but interviewers may probe whether you understand
  // the nuance that idempotency depends on the patch format, not the method alone.
  def exercise5_isIdempotent(method: Method): Boolean = ???

  // Exercise 6: Merge two header lists, with the second overriding duplicates
  // TODO: Given two List[Header], merge them so that if both contain a header
  //   with the same name, the value from the second list wins.
  //   Return the merged list sorted by header name.
  def exercise6_mergeHeaders(base: List[Header], overrides: List[Header]): List[Header] = ???

  // Exercise 7: Build a query string from a Uri's query map
  // TODO: Given a Uri, produce the query string portion like "?key1=val1&key2=val2"
  //   Keys should be sorted alphabetically. Return "" if query map is empty.
  def exercise7_buildQueryString(uri: Uri): String = ???

  // Exercise 8: Determine the appropriate status code for a scenario
  // TODO: Given a string scenario, return the correct Status:
  //   "resource_created" -> Status.Created
  //   "not_found" -> Status.NotFound
  //   "unauthorized" -> Status.Unauthorized
  //   "server_crash" -> Status.InternalServerError
  //   "no_content" -> Status.NoContent
  //   "bad_input" -> Status.BadRequest
  //   anything else -> Status.Ok
  def exercise8_statusForScenario(scenario: String): Status = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_parseMethod("GET").contains(Method.GET), "Exercise 1 failed: GET")
    assert(exercise1_parseMethod("post").contains(Method.POST), "Exercise 1 failed: post")
    assert(exercise1_parseMethod("delete").contains(Method.DELETE), "Exercise 1 failed: delete")
    assert(exercise1_parseMethod("UNKNOWN").isEmpty, "Exercise 1 failed: UNKNOWN should be None")
    println("Exercise 1 passed: method parsing works")

    // Exercise 2
    assert(exercise2_classifyStatus(100) == "informational", "Exercise 2 failed: 100")
    assert(exercise2_classifyStatus(200) == "success", "Exercise 2 failed: 200")
    assert(exercise2_classifyStatus(301) == "redirect", "Exercise 2 failed: 301")
    assert(exercise2_classifyStatus(404) == "client_error", "Exercise 2 failed: 404")
    assert(exercise2_classifyStatus(500) == "server_error", "Exercise 2 failed: 500")
    assert(exercise2_classifyStatus(600) == "unknown", "Exercise 2 failed: 600")
    println("Exercise 2 passed: status classification works")

    // Exercise 3
    val headers = exercise3_buildHeaders(Map("Content-Type" -> "application/json", "Accept" -> "text/html"))
    assert(headers.length == 2, "Exercise 3 failed: wrong length")
    assert(headers.head.name == "Accept", "Exercise 3 failed: not sorted")
    println("Exercise 3 passed: header building works")

    // Exercise 4
    val uri = exercise4_parseUri("http://localhost:8080/api/users?page=1&size=10")
    assert(uri.scheme.contains("http"), "Exercise 4 failed: scheme")
    assert(uri.authority.contains("localhost:8080"), "Exercise 4 failed: authority")
    assert(uri.path == "/api/users", "Exercise 4 failed: path")
    assert(uri.query == Map("page" -> "1", "size" -> "10"), "Exercise 4 failed: query")
    println("Exercise 4 passed: URI parsing works")

    // Exercise 5
    assert(exercise5_isIdempotent(Method.GET), "Exercise 5 failed: GET is idempotent")
    assert(exercise5_isIdempotent(Method.PUT), "Exercise 5 failed: PUT is idempotent")
    assert(!exercise5_isIdempotent(Method.POST), "Exercise 5 failed: POST is not idempotent")
    assert(!exercise5_isIdempotent(Method.PATCH), "Exercise 5 failed: PATCH is not idempotent")
    println("Exercise 5 passed: idempotency check works")

    // Exercise 6
    val base = List(Header("A", "1"), Header("B", "2"))
    val over = List(Header("B", "3"), Header("C", "4"))
    val merged = exercise6_mergeHeaders(base, over)
    assert(merged.length == 3, "Exercise 6 failed: wrong length")
    assert(merged.find(_.name == "B").exists(_.value == "3"), "Exercise 6 failed: override not applied")
    println("Exercise 6 passed: header merging works")

    // Exercise 7
    val testUri = Uri(Some("http"), Some("host"), "/path", Map("b" -> "2", "a" -> "1"), None)
    assert(exercise7_buildQueryString(testUri) == "?a=1&b=2", "Exercise 7 failed")
    assert(exercise7_buildQueryString(testUri.copy(query = Map.empty)) == "", "Exercise 7 failed: empty")
    println("Exercise 7 passed: query string building works")

    // Exercise 8
    assert(exercise8_statusForScenario("resource_created") == Status.Created, "Exercise 8 failed: created")
    assert(exercise8_statusForScenario("not_found") == Status.NotFound, "Exercise 8 failed: not_found")
    assert(exercise8_statusForScenario("unauthorized") == Status.Unauthorized, "Exercise 8 failed: unauth")
    assert(exercise8_statusForScenario("anything") == Status.Ok, "Exercise 8 failed: default")
    println("Exercise 8 passed: status for scenario works")

    println("\nAll Http001_HttpModel exercises passed!")
  }
}
