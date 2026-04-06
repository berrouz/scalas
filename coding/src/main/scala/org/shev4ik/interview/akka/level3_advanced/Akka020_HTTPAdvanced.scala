package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 020 - HTTP Advanced Features
 *
 * Advanced Akka HTTP features:
 *   - Marshalling/Unmarshalling: converting between domain types and HTTP entities
 *   - JSON with circe/spray: JSON serialization libraries
 *   - Authentication: basic auth, OAuth, bearer tokens
 *   - CORS: Cross-Origin Resource Sharing headers
 *   - File upload: multipart form data handling
 *   - WebSocket: bidirectional communication
 *   - SSE (Server-Sent Events): server push to clients
 *   - Custom directives: composable route building blocks
 *
 * We model these concepts using pure Scala.
 */
object Akka020_HTTPAdvanced {

  // --- Domain models ---

  case class User(id: Int, name: String, email: String)

  case class JsonValue(raw: String) {
    def as[A](implicit decoder: String => Option[A]): Option[A] = decoder(raw)
  }

  case class AuthCredentials(username: String, password: String)
  case class BearerToken(token: String)

  case class CorsHeaders(
    allowOrigin: String,
    allowMethods: List[String],
    allowHeaders: List[String],
    maxAge: Long
  )

  case class FileUpload(filename: String, contentType: String, data: Array[Byte])

  sealed trait WsMessage
  case class TextMessage(text: String) extends WsMessage
  case class BinaryMessage(data: Array[Byte]) extends WsMessage

  case class SseEvent(data: String, eventType: Option[String], id: Option[String])

  // Exercise 1: Marshalling — convert domain object to JSON string
  // TODO: Given a User, marshal it to a JSON string:
  //   {"id": 1, "name": "Alice", "email": "alice@example.com"}
  //   In real Akka HTTP: implicit marshaller converts automatically.
  def exercise1_marshal(user: User): String = ???

  // Exercise 2: Unmarshalling — parse JSON string to domain object
  // TODO: Given a JSON string, extract User fields.
  //   Parse simple JSON format: {"id": N, "name": "...", "email": "..."}
  //   Return Some(User) if valid, None if parsing fails.
  //   Hint: Use simple string manipulation (indexOf, substring).
  def exercise2_unmarshal(json: String): Option[User] = ???

  // Exercise 3: Authentication — basic auth
  // TODO: Given an AuthCredentials and a user database Map[String, String] (username -> password),
  //   verify the credentials. Return Right(username) if valid, Left("Unauthorized") if not.
  def exercise3_basicAuth(
    credentials: AuthCredentials,
    userDb: Map[String, String]
  ): Either[String, String] = ???

  // Exercise 4: CORS headers generation
  // TODO: Given an origin string and a list of allowed origins,
  //   generate CorsHeaders:
  //   - If origin is in allowedOrigins, set allowOrigin = origin
  //   - If "*" is in allowedOrigins, set allowOrigin = "*"
  //   - Otherwise return None (CORS rejected)
  //   allowMethods = List("GET", "POST", "PUT", "DELETE")
  //   allowHeaders = List("Content-Type", "Authorization")
  //   maxAge = 3600
  def exercise4_cors(origin: String, allowedOrigins: List[String]): Option[CorsHeaders] = ???

  // Exercise 5: File upload processing
  // TODO: Given a list of FileUploads, validate and process them:
  //   - Reject files larger than maxSizeBytes (return Left with filename)
  //   - Reject files with disallowed content types (return Left with filename)
  //   - Accept valid files (return Right with filename)
  //   allowedTypes = the provided set of content type strings.
  //   Return a list of Either[String, String] (Left=rejected filename, Right=accepted filename).
  def exercise5_fileUpload(
    uploads: List[FileUpload],
    maxSizeBytes: Int,
    allowedTypes: Set[String]
  ): List[Either[String, String]] = ???

  // Exercise 6: WebSocket message handling
  // TODO: Given a list of incoming WsMessages and a handler function:
  //   - TextMessage(text): apply handler, return TextMessage with result
  //   - BinaryMessage(data): echo back with data length as TextMessage("Binary: N bytes")
  //   Return the list of response WsMessages.
  def exercise6_websocket(
    messages: List[WsMessage],
    textHandler: String => String
  ): List[WsMessage] = ???

  // Exercise 7: Server-Sent Events
  // TODO: Given a list of data strings, create SseEvents:
  //   - Each event has the data string
  //   - eventType = Some("update") for all
  //   - id = Some(index.toString) where index starts at 1
  //   Also create a final "heartbeat" event with data="", eventType=Some("heartbeat"), id=None.
  //   Return all events including the heartbeat.
  def exercise7_sse(dataItems: List[String]): List[SseEvent] = ???

  // Exercise 8: Custom directive — rate limiting
  // TODO: Implement a rate limiter directive simulation.
  //   Given a maxRequests per windowMs, and a list of (requestId, timestampMs),
  //   determine which requests are allowed and which are rate-limited.
  //   A request is allowed if fewer than maxRequests occurred in the preceding windowMs.
  //   Return a list of (requestId, allowed: Boolean).
  def exercise8_rateLimiter(
    maxRequests: Int,
    windowMs: Long,
    requests: List[(String, Long)]
  ): List[(String, Boolean)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_marshal(User(1, "Alice", "alice@example.com"))
    assert(r1.contains("\"id\": 1"), s"Exercise 1 failed: $r1")
    assert(r1.contains("\"name\": \"Alice\""), s"Exercise 1 failed: $r1")
    assert(r1.contains("\"email\": \"alice@example.com\""), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val json2 = """{"id": 42, "name": "Bob", "email": "bob@test.com"}"""
    val r2 = exercise2_unmarshal(json2)
    assert(r2.contains(User(42, "Bob", "bob@test.com")), s"Exercise 2 failed: $r2")
    val r2b = exercise2_unmarshal("invalid json")
    assert(r2b.isEmpty, "Exercise 2 failed: should return None for invalid JSON")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val db = Map("admin" -> "secret123", "user1" -> "pass456")
    val r3a = exercise3_basicAuth(AuthCredentials("admin", "secret123"), db)
    assert(r3a == Right("admin"), s"Exercise 3 failed: $r3a")
    val r3b = exercise3_basicAuth(AuthCredentials("admin", "wrong"), db)
    assert(r3b == Left("Unauthorized"), s"Exercise 3 failed: $r3b")
    println("Exercise 3 passed: basic auth works")

    // Exercise 4
    val r4a = exercise4_cors("https://example.com", List("https://example.com", "https://other.com"))
    assert(r4a.exists(_.allowOrigin == "https://example.com"), s"Exercise 4 failed: $r4a")
    val r4b = exercise4_cors("https://evil.com", List("https://example.com"))
    assert(r4b.isEmpty, "Exercise 4 failed: should reject unknown origin")
    val r4c = exercise4_cors("https://any.com", List("*"))
    assert(r4c.exists(_.allowOrigin == "*"), "Exercise 4 failed: wildcard should work")
    println("Exercise 4 passed: CORS headers generated")

    // Exercise 5
    val uploads = List(
      FileUpload("doc.pdf", "application/pdf", new Array[Byte](1000)),
      FileUpload("big.zip", "application/zip", new Array[Byte](5000)),
      FileUpload("hack.exe", "application/exe", new Array[Byte](100))
    )
    val r5 = exercise5_fileUpload(uploads, 2000, Set("application/pdf", "application/zip"))
    assert(r5(0) == Right("doc.pdf"), s"Exercise 5 failed: ${r5(0)}")
    assert(r5(1) == Left("big.zip"), s"Exercise 5 failed: ${r5(1)}")
    assert(r5(2) == Left("hack.exe"), s"Exercise 5 failed: ${r5(2)}")
    println("Exercise 5 passed: file upload validation")

    // Exercise 6
    val wsIn = List(TextMessage("hello"), BinaryMessage(new Array[Byte](42)), TextMessage("world"))
    val r6 = exercise6_websocket(wsIn, _.toUpperCase)
    assert(r6(0) == TextMessage("HELLO"), s"Exercise 6 failed: ${r6(0)}")
    assert(r6(1) == TextMessage("Binary: 42 bytes"), s"Exercise 6 failed: ${r6(1)}")
    assert(r6(2) == TextMessage("WORLD"), s"Exercise 6 failed: ${r6(2)}")
    println("Exercise 6 passed: WebSocket handling")

    // Exercise 7
    val r7 = exercise7_sse(List("data1", "data2"))
    assert(r7.length == 3, s"Exercise 7 failed: expected 3 events, got ${r7.length}")
    assert(r7(0) == SseEvent("data1", Some("update"), Some("1")), s"Exercise 7 failed: ${r7(0)}")
    assert(r7(2) == SseEvent("", Some("heartbeat"), None), s"Exercise 7 failed: ${r7(2)}")
    println("Exercise 7 passed: SSE events created")

    // Exercise 8
    val requests = List(("r1", 0L), ("r2", 100L), ("r3", 200L), ("r4", 300L), ("r5", 1100L))
    val r8 = exercise8_rateLimiter(3, 1000L, requests)
    assert(r8(0) == ("r1", true), s"Exercise 8 failed: ${r8(0)}")
    assert(r8(1) == ("r2", true), s"Exercise 8 failed: ${r8(1)}")
    assert(r8(2) == ("r3", true), s"Exercise 8 failed: ${r8(2)}")
    assert(r8(3) == ("r4", false), s"Exercise 8 failed: ${r8(3)}")
    assert(r8(4) == ("r5", true), s"Exercise 8 failed: ${r8(4)}")
    println("Exercise 8 passed: rate limiter works")

    println("\nAll Akka020_HTTPAdvanced exercises passed!")
  }
}
