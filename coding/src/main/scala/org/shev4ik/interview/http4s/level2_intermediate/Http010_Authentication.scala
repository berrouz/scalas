package org.shev4ik.interview.http4s.level2_intermediate

/**
 * Http4s 010 - Authentication
 *
 * HTTP authentication patterns. Key concepts:
 *   - Basic Authentication (base64 encoded username:password)
 *   - Bearer Token authentication
 *   - JWT structure (header.payload.signature)
 *   - Auth middleware for route protection
 *   - Role-based access control (RBAC)
 *   - Token validation and expiration
 */
object Http010_Authentication {

  // --- Domain models ---

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val Unauthorized: Status = Status(401, "Unauthorized")
    val Forbidden: Status = Status(403, "Forbidden")
  }

  case class Header(name: String, value: String)
  case class Request(method: String, path: String, headers: List[Header], body: Option[String])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  case class Credentials(username: String, password: String)
  case class User(id: String, username: String, roles: Set[String])

  case class JwtHeader(alg: String, typ: String)
  case class JwtPayload(sub: String, name: String, roles: List[String], exp: Long, iat: Long)
  case class JwtToken(header: JwtHeader, payload: JwtPayload, signature: String)

  sealed trait AuthResult[+A]
  object AuthResult {
    case class Authenticated[A](value: A)       extends AuthResult[A]
    case class Failed(reason: String)           extends AuthResult[Nothing]
    case class Expired(reason: String)          extends AuthResult[Nothing]
  }

  type Service = Request => Response
  type Middleware = Service => Service

  // Exercise 1: Encode credentials for Basic Authentication
  // TODO: Given Credentials, produce the Basic Auth header value.
  //   Format: "Basic " + base64encode("username:password")
  //   Use java.util.Base64.getEncoder.encodeToString for encoding.
  def exercise1_encodeBasicAuth(credentials: Credentials): String = ???

  // Exercise 2: Decode a Basic Auth header value
  // TODO: Given a header value like "Basic dXNlcjpwYXNz", decode it to Credentials.
  //   Return None if the format is invalid or not Basic auth.
  //   Use java.util.Base64.getDecoder.decode for decoding.
  def exercise2_decodeBasicAuth(headerValue: String): Option[Credentials] = ???

  // Exercise 3: Extract the Bearer token from a request
  // TODO: Look for the "Authorization" header in the request.
  //   If it starts with "Bearer ", extract and return the token string.
  //   Return None if no Authorization header or not Bearer auth.
  def exercise3_extractBearerToken(request: Request): Option[String] = ???

  // Exercise 4: Validate a token against a token store
  // TODO: Given a token string and a Map[String, User] (token -> User),
  //   look up the token and return AuthResult.Authenticated(user) if found,
  //   or AuthResult.Failed("invalid token") if not found.
  def exercise4_validateToken(token: String, tokenStore: Map[String, User]): AuthResult[User] = ???

  // Exercise 5: Create a Basic Auth middleware
  // TODO: Return a Middleware that:
  //   1. Extracts the Authorization header
  //   2. Decodes Basic Auth credentials
  //   3. Validates against the provided credentials map (username -> password)
  //   4. If valid, passes through to the wrapped service
  //   5. If invalid, returns Response(Status.Unauthorized, [Header("WWW-Authenticate", "Basic")], Some("Invalid credentials"))
  def exercise5_basicAuthMiddleware(validCredentials: Map[String, String]): Middleware = ???

  // Exercise 6: Check role-based access
  // TODO: Given a User and a required role, return true if the user has the role.
  //   Also check for a wildcard role "*" which grants access to everything.
  def exercise6_hasRole(user: User, requiredRole: String): Boolean = ???

  // Exercise 7: Create a role-based authorization middleware
  // TODO: Given a required role and a function to extract User from Request
  //   (simulating an already-authenticated request), return a Middleware that:
  //   - Calls extractUser(request) to get Option[User]
  //   - If user is present and has the required role, pass through
  //   - If user is present but lacks the role, return Response(Status.Forbidden, ..., Some("Insufficient permissions"))
  //   - If no user, return Response(Status.Unauthorized, ..., Some("Not authenticated"))
  def exercise7_roleMiddleware(
    requiredRole: String,
    extractUser: Request => Option[User]
  ): Middleware = ???

  // Exercise 8: Parse a simplified JWT token string
  // TODO: A JWT has three base64-encoded parts separated by dots: "header.payload.signature"
  //   Given a JWT string, parse it into a JwtToken:
  //   - Header JSON (simplified): {"alg":"HS256","typ":"JWT"}
  //   - Payload JSON (simplified): {"sub":"user1","name":"Alice","roles":["admin"],"exp":9999999999,"iat":1000000000}
  //   For this exercise, validate the structure has 3 parts and return:
  //   - Right(JwtToken) with the decoded header/payload strings stored as-is
  //   - Left("invalid JWT format") if not exactly 3 parts
  //   Simplified: return JwtToken with hardcoded JwtHeader("HS256","JWT"),
  //   JwtPayload parsed from the middle part (sub, name, roles, exp, iat extracted simply),
  //   and the signature as the third part.
  //   For simplicity: Just validate 3 parts exist, decode middle part from base64,
  //   and build JwtPayload(sub=parts(0), name="", roles=Nil, exp=0, iat=0) with signature=parts(2)
  //   Actually - keep it simple: validate 3 dot-separated parts, return
  //   Right(JwtToken(JwtHeader("HS256","JWT"), JwtPayload(sub=part1decoded, "", Nil, 0, 0), part3))
  //   where part1decoded is base64-decode of parts(1).
  //   Return Left("invalid JWT format") if not 3 parts.
  def exercise8_parseJwt(token: String): Either[String, JwtToken] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val encoded = exercise1_encodeBasicAuth(Credentials("user", "pass"))
    assert(encoded == "Basic dXNlcjpwYXNz", s"Exercise 1 failed: got $encoded")
    println("Exercise 1 passed: Basic Auth encoding works")

    // Exercise 2
    val decoded = exercise2_decodeBasicAuth("Basic dXNlcjpwYXNz")
    assert(decoded.contains(Credentials("user", "pass")), "Exercise 2 failed: wrong credentials")
    assert(exercise2_decodeBasicAuth("Bearer token").isEmpty, "Exercise 2 failed: should reject Bearer")
    assert(exercise2_decodeBasicAuth("garbage").isEmpty, "Exercise 2 failed: should reject garbage")
    println("Exercise 2 passed: Basic Auth decoding works")

    // Exercise 3
    val reqWithBearer = Request("GET", "/", List(Header("Authorization", "Bearer mytoken123")), None)
    assert(exercise3_extractBearerToken(reqWithBearer).contains("mytoken123"), "Exercise 3 failed: token extraction")
    val reqNoAuth = Request("GET", "/", List.empty, None)
    assert(exercise3_extractBearerToken(reqNoAuth).isEmpty, "Exercise 3 failed: no auth header")
    println("Exercise 3 passed: Bearer token extraction works")

    // Exercise 4
    val alice = User("1", "alice", Set("admin"))
    val tokenStore = Map("valid-token" -> alice)
    assert(exercise4_validateToken("valid-token", tokenStore) == AuthResult.Authenticated(alice), "Exercise 4 failed: valid token")
    assert(exercise4_validateToken("bad-token", tokenStore).isInstanceOf[AuthResult.Failed], "Exercise 4 failed: invalid token")
    println("Exercise 4 passed: token validation works")

    // Exercise 5
    val creds = Map("admin" -> "secret")
    val basicAuth = exercise5_basicAuthMiddleware(creds)
    val echoService: Service = _ => Response(Status.Ok, List.empty, Some("ok"))
    val protected1 = basicAuth(echoService)
    val validAuthReq = Request("GET", "/", List(Header("Authorization", exercise1_encodeBasicAuth(Credentials("admin", "secret")))), None)
    assert(protected1(validAuthReq).status == Status.Ok, "Exercise 5 failed: valid creds should pass")
    val invalidAuthReq = Request("GET", "/", List(Header("Authorization", exercise1_encodeBasicAuth(Credentials("admin", "wrong")))), None)
    assert(protected1(invalidAuthReq).status == Status.Unauthorized, "Exercise 5 failed: invalid creds should fail")
    println("Exercise 5 passed: Basic Auth middleware works")

    // Exercise 6
    val adminUser = User("1", "admin", Set("admin", "user"))
    assert(exercise6_hasRole(adminUser, "admin"), "Exercise 6 failed: has admin role")
    assert(!exercise6_hasRole(adminUser, "superadmin"), "Exercise 6 failed: no superadmin role")
    val superUser = User("2", "super", Set("*"))
    assert(exercise6_hasRole(superUser, "anything"), "Exercise 6 failed: wildcard should match")
    println("Exercise 6 passed: role check works")

    // Exercise 7
    val userExtractor: Request => Option[User] = req =>
      req.headers.find(_.name == "X-User-Role").map(h => User("1", "test", Set(h.value)))
    val roleMw = exercise7_roleMiddleware("admin", userExtractor)
    val protectedService = roleMw(echoService)
    val adminReq = Request("GET", "/", List(Header("X-User-Role", "admin")), None)
    assert(protectedService(adminReq).status == Status.Ok, "Exercise 7 failed: admin should pass")
    val userReq = Request("GET", "/", List(Header("X-User-Role", "user")), None)
    assert(protectedService(userReq).status == Status.Forbidden, "Exercise 7 failed: user should be forbidden")
    val anonReq = Request("GET", "/", List.empty, None)
    assert(protectedService(anonReq).status == Status.Unauthorized, "Exercise 7 failed: anon should be unauthorized")
    println("Exercise 7 passed: role middleware works")

    // Exercise 8
    val b64Header = java.util.Base64.getEncoder.encodeToString("header".getBytes)
    val b64Payload = java.util.Base64.getEncoder.encodeToString("user1".getBytes)
    val jwtString = s"$b64Header.$b64Payload.signature123"
    val parsed = exercise8_parseJwt(jwtString)
    assert(parsed.isRight, "Exercise 8 failed: should parse valid JWT")
    assert(parsed.toOption.get.payload.sub == "user1", s"Exercise 8 failed: wrong sub: ${parsed.toOption.get.payload.sub}")
    assert(parsed.toOption.get.signature == "signature123", "Exercise 8 failed: wrong signature")
    assert(exercise8_parseJwt("only.two").isLeft, "Exercise 8 failed: should reject invalid format")
    println("Exercise 8 passed: JWT parsing works")

    println("\nAll Http010_Authentication exercises passed!")
  }
}
