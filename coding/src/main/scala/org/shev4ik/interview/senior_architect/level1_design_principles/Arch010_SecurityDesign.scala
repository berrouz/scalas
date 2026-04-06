package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Security Design
 *
 * Senior/Architect focus:
 * - Authentication and authorization architecture
 * - Token design and secrets management
 * - Input validation and security headers
 */
object Arch010_SecurityDesign {

  // ============================================================
  // Exercise 1: Authentication Flow Design
  // ============================================================
  // TODO: Design a multi-step authentication flow with support for
  //  MFA (multi-factor authentication), session management, and
  //  account lockout policies.

  sealed trait AuthStep
  case class CredentialsStep(username: String, password: String) extends AuthStep
  case class MFAStep(code: String, method: MFAMethod) extends AuthStep
  case class DeviceVerificationStep(deviceId: String, fingerprint: String) extends AuthStep

  sealed trait MFAMethod
  case object TOTP extends MFAMethod     // Time-based One Time Password
  case object SMSCode extends MFAMethod
  case object EmailCode extends MFAMethod

  sealed trait AuthResult
  case class AuthSuccess(sessionToken: String, expiresAt: Long, user: AuthUser) extends AuthResult
  case class AuthRequiresMFA(tempToken: String, methods: List[MFAMethod]) extends AuthResult
  case class AuthFailed(reason: String, attemptsRemaining: Int) extends AuthResult
  case class AuthAccountLocked(unlockAt: Long) extends AuthResult

  case class AuthUser(id: String, username: String, roles: Set[String])

  trait AuthenticationService {
    def authenticate(step: AuthStep): Either[String, AuthResult]
    def validateSession(token: String): Either[String, AuthUser]
    def logout(token: String): Either[String, Unit]
    def refreshSession(token: String): Either[String, AuthResult]
  }

  // TODO: Implement authentication with lockout policy
  class SecureAuthService extends AuthenticationService {
    private val maxAttempts = 5
    private val lockoutDurationMs = 15 * 60 * 1000L  // 15 minutes

    def authenticate(step: AuthStep): Either[String, AuthResult] = ???
    def validateSession(token: String): Either[String, AuthUser] = ???
    def logout(token: String): Either[String, Unit] = ???
    def refreshSession(token: String): Either[String, AuthResult] = ???
  }

  // ============================================================
  // Exercise 2: Authorization Model (RBAC/ABAC)
  // ============================================================
  // TODO: Design both RBAC (Role-Based Access Control) and ABAC
  //  (Attribute-Based Access Control) systems. Compare approaches.

  // RBAC
  case class Role(name: String, permissions: Set[Permission])
  case class Permission(resource: String, action: String)

  trait RBACAuthorizer {
    def hasPermission(userId: String, resource: String, action: String): Either[String, Boolean]
    def getRoles(userId: String): Either[String, Set[Role]]
    def assignRole(userId: String, roleName: String): Either[String, Unit]
    def revokeRole(userId: String, roleName: String): Either[String, Unit]
  }

  // TODO: Implement RBAC
  class SimpleRBAC extends RBACAuthorizer {
    def hasPermission(userId: String, resource: String, action: String): Either[String, Boolean] = ???
    def getRoles(userId: String): Either[String, Set[Role]] = ???
    def assignRole(userId: String, roleName: String): Either[String, Unit] = ???
    def revokeRole(userId: String, roleName: String): Either[String, Unit] = ???
  }

  // ABAC: more flexible, policy-based
  case class AccessRequest(
    subject: Map[String, String],    // who: userId, department, clearance
    resource: Map[String, String],   // what: type, owner, classification
    action: String,                  // how: read, write, delete
    environment: Map[String, String] // context: time, ip, location
  )

  trait ABACPolicy {
    def evaluate(request: AccessRequest): Either[String, Boolean]
    def description: String
  }

  // TODO: Implement ABAC policies
  class TimeBasedPolicy(allowedHours: Range) extends ABACPolicy {
    def evaluate(request: AccessRequest): Either[String, Boolean] = ???
    def description: String = ???
  }

  class OwnershipPolicy extends ABACPolicy {
    def evaluate(request: AccessRequest): Either[String, Boolean] = ???
    def description: String = ???
  }

  // ============================================================
  // Exercise 3: JWT Token Design
  // ============================================================
  // TODO: Design a JWT token system with proper claims, signing,
  //  validation, and refresh token strategy.

  case class JWTHeader(alg: String, typ: String = "JWT")

  case class JWTClaims(
    sub: String,           // subject (user ID)
    iss: String,           // issuer
    aud: String,           // audience
    exp: Long,             // expiration
    iat: Long,             // issued at
    jti: String,           // JWT ID (unique identifier)
    roles: List[String],
    permissions: List[String],
    customClaims: Map[String, String] = Map.empty
  )

  case class JWTToken(header: JWTHeader, claims: JWTClaims, signature: String)

  trait JWTService {
    def createToken(userId: String, roles: List[String], permissions: List[String]): Either[String, String]
    def validateToken(token: String): Either[String, JWTClaims]
    def createRefreshToken(userId: String): Either[String, String]
    def refreshAccessToken(refreshToken: String): Either[String, String]
    def revokeToken(jti: String): Either[String, Unit]
  }

  // TODO: Implement JWT service with proper validation
  class JWTServiceImpl(secret: String, issuer: String, audience: String) extends JWTService {
    def createToken(userId: String, roles: List[String], permissions: List[String]): Either[String, String] = ???
    def validateToken(token: String): Either[String, JWTClaims] = ???
    def createRefreshToken(userId: String): Either[String, String] = ???
    def refreshAccessToken(refreshToken: String): Either[String, String] = ???
    def revokeToken(jti: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 4: OAuth2 Flow Concept
  // ============================================================
  // TODO: Model the OAuth2 authorization code flow.
  //  Design the state machine for the flow steps.

  sealed trait OAuth2State
  case class AuthorizationPending(
    clientId: String,
    redirectUri: String,
    scope: Set[String],
    state: String,
    codeChallenge: Option[String]  // PKCE
  ) extends OAuth2State

  case class AuthorizationGranted(
    code: String,
    clientId: String,
    redirectUri: String,
    expiresAt: Long
  ) extends OAuth2State

  case class TokenIssued(
    accessToken: String,
    refreshToken: String,
    tokenType: String,
    expiresIn: Int,
    scope: Set[String]
  ) extends OAuth2State

  trait OAuth2Provider {
    def authorize(clientId: String, redirectUri: String, scope: Set[String], state: String): Either[String, String]
    def exchangeCode(code: String, clientId: String, clientSecret: String, redirectUri: String): Either[String, TokenIssued]
    def refreshToken(refreshToken: String, clientId: String, clientSecret: String): Either[String, TokenIssued]
    def introspect(token: String): Either[String, Map[String, Any]]
    def revoke(token: String): Either[String, Unit]
  }

  // TODO: Implement OAuth2 provider
  class OAuth2ProviderImpl extends OAuth2Provider {
    def authorize(clientId: String, redirectUri: String, scope: Set[String], state: String): Either[String, String] = ???
    def exchangeCode(code: String, clientId: String, clientSecret: String, redirectUri: String): Either[String, TokenIssued] = ???
    def refreshToken(refreshToken: String, clientId: String, clientSecret: String): Either[String, TokenIssued] = ???
    def introspect(token: String): Either[String, Map[String, Any]] = ???
    def revoke(token: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 5: API Key Management
  // ============================================================
  // TODO: Design an API key management system with key rotation,
  //  scoping, and rate limiting per key.

  case class ApiKey(
    id: String,
    hashedKey: String,    // never store raw key
    prefix: String,       // first 8 chars for identification
    name: String,
    scopes: Set[String],
    rateLimit: Int,       // requests per minute
    createdAt: Long,
    expiresAt: Option[Long],
    lastUsedAt: Option[Long],
    isActive: Boolean
  )

  trait ApiKeyManager {
    def createKey(name: String, scopes: Set[String], rateLimit: Int): Either[String, (String, ApiKey)]  // returns raw key + metadata
    def validateKey(rawKey: String): Either[String, ApiKey]
    def rotateKey(keyId: String): Either[String, (String, ApiKey)]
    def revokeKey(keyId: String): Either[String, Unit]
    def listKeys(userId: String): Either[String, List[ApiKey]]
  }

  // TODO: Implement API key manager
  class SecureApiKeyManager extends ApiKeyManager {
    def createKey(name: String, scopes: Set[String], rateLimit: Int): Either[String, (String, ApiKey)] = ???
    def validateKey(rawKey: String): Either[String, ApiKey] = ???
    def rotateKey(keyId: String): Either[String, (String, ApiKey)] = ???
    def revokeKey(keyId: String): Either[String, Unit] = ???
    def listKeys(userId: String): Either[String, List[ApiKey]] = ???
  }

  // ============================================================
  // Exercise 6: Secrets Management Pattern
  // ============================================================
  // TODO: Design a secrets management system that loads secrets
  //  from vault/env, rotates them, and prevents leaking.

  sealed trait SecretSource
  case object EnvironmentVariable extends SecretSource
  case object VaultKV extends SecretSource
  case object AWSSecretsManager extends SecretSource
  case object ConfigFile extends SecretSource

  case class SecretRef(
    name: String,
    source: SecretSource,
    path: String,
    rotationPeriodDays: Option[Int]
  )

  // Secret value wrapper that prevents accidental logging
  case class SecretValue private (private val raw: String) {
    // toString does NOT reveal the secret
    override def toString: String = "SecretValue(***)"
    def use[A](f: String => A): A = f(raw)
  }

  object SecretValue {
    def apply(raw: String): SecretValue = new SecretValue(raw)
  }

  trait SecretsManager {
    def getSecret(ref: SecretRef): Either[String, SecretValue]
    def rotateSecret(ref: SecretRef): Either[String, SecretValue]
    def listSecrets(): Either[String, List[SecretRef]]
  }

  // TODO: Implement secrets manager
  class MultiSourceSecretsManager extends SecretsManager {
    def getSecret(ref: SecretRef): Either[String, SecretValue] = ???
    def rotateSecret(ref: SecretRef): Either[String, SecretValue] = ???
    def listSecrets(): Either[String, List[SecretRef]] = ???
  }

  // ============================================================
  // Exercise 7: Input Validation Strategy
  // ============================================================
  // TODO: Design a comprehensive input validation strategy that
  //  prevents injection attacks, XSS, and other input-based vulnerabilities.

  trait InputValidator[A] {
    def validate(input: A): Either[List[String], A]
  }

  // TODO: Implement validators for common attack vectors
  object InputValidators {
    // SQL injection prevention
    def sanitizeSqlInput(input: String): Either[String, String] = ???

    // XSS prevention
    def sanitizeHtml(input: String): Either[String, String] = ???

    // Path traversal prevention
    def sanitizePath(input: String): Either[String, String] = ???

    // Email validation
    def validateEmail(input: String): Either[String, String] = ???

    // URL validation
    def validateUrl(input: String): Either[String, String] = ???

    // Composed validator
    def validateUserInput(name: String, email: String, bio: String): Either[List[String], (String, String, String)] = ???
  }

  // ============================================================
  // Exercise 8: Security Headers
  // ============================================================
  // TODO: Design security headers configuration for a web API.
  //  Include all recommended security headers with proper values.

  case class SecurityHeaders(
    contentSecurityPolicy: String,
    strictTransportSecurity: String,
    xContentTypeOptions: String,
    xFrameOptions: String,
    xXssProtection: String,
    referrerPolicy: String,
    permissionsPolicy: String,
    cacheControl: String
  ) {
    def toMap: Map[String, String] = ???
  }

  object SecurityHeaders {
    // TODO: Implement secure defaults
    def strictDefaults: SecurityHeaders = ???

    // Relaxed for development
    def devDefaults: SecurityHeaders = ???

    // Custom CORS headers
    def corsHeaders(
      allowedOrigins: List[String],
      allowedMethods: List[String],
      allowedHeaders: List[String],
      maxAge: Int
    ): Map[String, String] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch010: Security Design ===")
    println()
    println("Exercise 1: Authentication Flow Design")
    println("Exercise 2: Authorization Model (RBAC/ABAC)")
    println("Exercise 3: JWT Token Design")
    println("Exercise 4: OAuth2 Flow Concept")
    println("Exercise 5: API Key Management")
    println("Exercise 6: Secrets Management Pattern")
    println("Exercise 7: Input Validation Strategy")
    println("Exercise 8: Security Headers")
  }
}
