package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * API Design
 *
 * Senior/Architect focus:
 * - RESTful API principles and trade-offs
 * - Versioning, pagination, error responses
 * - API security and rate limiting design
 */
object Arch008_APIDesign {

  // ============================================================
  // Exercise 1: RESTful API Design
  // ============================================================
  // TODO: Design a type-safe RESTful API model for a user management
  //  service. Define resource representations, HTTP methods mapping,
  //  and proper status code usage.

  // HTTP method mapping to operations
  sealed trait HttpMethod
  case object GET extends HttpMethod
  case object POST extends HttpMethod
  case object PUT extends HttpMethod
  case object PATCH extends HttpMethod
  case object DELETE extends HttpMethod

  case class ApiEndpoint(
    method: HttpMethod,
    path: String,
    description: String,
    requestBody: Option[String],   // Schema name
    responseBody: String,          // Schema name
    statusCodes: Map[Int, String]  // status code -> meaning
  )

  // TODO: Define REST endpoints for User resource
  // GET /users          - list users
  // GET /users/:id      - get user
  // POST /users         - create user
  // PUT /users/:id      - replace user
  // PATCH /users/:id    - partial update
  // DELETE /users/:id   - delete user
  val userEndpoints: List[ApiEndpoint] = ???

  // TODO: Design resource representations
  case class UserResource(
    id: Long,
    name: String,
    email: String,
    createdAt: String,
    links: Map[String, String]  // HATEOAS links
  )

  case class CreateUserRequest(name: String, email: String)
  case class UpdateUserRequest(name: Option[String], email: Option[String])

  // ============================================================
  // Exercise 2: API Versioning
  // ============================================================
  // TODO: Design an API versioning strategy. Compare URL-based,
  //  header-based, and content-type versioning approaches.

  sealed trait VersioningStrategy
  case class UrlVersioning(version: String) extends VersioningStrategy   // /api/v1/users
  case class HeaderVersioning(header: String, version: String) extends VersioningStrategy  // X-API-Version: 1
  case class ContentTypeVersioning(mediaType: String) extends VersioningStrategy  // application/vnd.api.v1+json

  // TODO: Implement a version resolver
  trait VersionResolver {
    def resolveVersion(
      path: String,
      headers: Map[String, String],
      contentType: Option[String]
    ): Either[String, Int]
  }

  class MultiStrategyVersionResolver extends VersionResolver {
    def resolveVersion(
      path: String,
      headers: Map[String, String],
      contentType: Option[String]
    ): Either[String, Int] = ???
  }

  // TODO: Design version-specific request routing
  trait VersionedRouter {
    def route(version: Int, path: String, method: HttpMethod): Either[String, String] = ???
  }

  // ============================================================
  // Exercise 3: Pagination Design
  // ============================================================
  // TODO: Design pagination strategies: offset-based, cursor-based,
  //  and keyset-based. Discuss trade-offs for each.

  // Offset-based pagination (simple but O(n) skip)
  case class OffsetPagination(offset: Int, limit: Int)
  case class OffsetPagedResponse[A](
    data: List[A],
    offset: Int,
    limit: Int,
    total: Long
  )

  // Cursor-based pagination (stable, no skipping issues)
  case class CursorPagination(cursor: Option[String], limit: Int)
  case class CursorPagedResponse[A](
    data: List[A],
    nextCursor: Option[String],
    previousCursor: Option[String],
    hasMore: Boolean
  )

  // TODO: Implement pagination logic
  def paginateWithOffset[A](items: List[A], pagination: OffsetPagination): OffsetPagedResponse[A] = ???
  def paginateWithCursor[A](items: List[A], pagination: CursorPagination, getId: A => String): CursorPagedResponse[A] = ???

  // TODO: Design pagination response headers
  def paginationHeaders(total: Long, offset: Int, limit: Int): Map[String, String] = ???

  // ============================================================
  // Exercise 4: Error Response Format
  // ============================================================
  // TODO: Design a consistent API error response format that provides
  //  useful information to clients without leaking internals.

  case class ApiErrorResponse(
    status: Int,
    error: String,       // machine-readable error code
    message: String,     // human-readable message
    details: List[FieldError],
    traceId: String,     // correlation ID for debugging
    timestamp: String,
    path: String
  )

  case class FieldError(
    field: String,
    code: String,
    message: String
  )

  // TODO: Implement error response builders
  object ApiErrorResponse {
    def badRequest(message: String, fieldErrors: List[FieldError], traceId: String, path: String): ApiErrorResponse = ???
    def notFound(resource: String, id: String, traceId: String, path: String): ApiErrorResponse = ???
    def conflict(message: String, traceId: String, path: String): ApiErrorResponse = ???
    def internalError(traceId: String, path: String): ApiErrorResponse = ???
    def unauthorized(message: String, traceId: String, path: String): ApiErrorResponse = ???
    def forbidden(message: String, traceId: String, path: String): ApiErrorResponse = ???
    def tooManyRequests(retryAfter: Int, traceId: String, path: String): ApiErrorResponse = ???
  }

  // ============================================================
  // Exercise 5: HATEOAS Concept
  // ============================================================
  // TODO: Design a HATEOAS (Hypermedia As The Engine Of Application State)
  //  response format. Resources include links to related actions.

  case class HypermediaLink(
    rel: String,     // relationship type: self, next, prev, collection
    href: String,    // URL
    method: String,  // HTTP method
    title: Option[String] = None
  )

  case class HypermediaResource[A](
    data: A,
    links: List[HypermediaLink]
  )

  // TODO: Build HATEOAS responses for an order resource
  case class OrderResource(id: Long, status: String, total: BigDecimal)

  def buildOrderHateoas(order: OrderResource, baseUrl: String): HypermediaResource[OrderResource] = ???

  // TODO: Links should be context-aware (e.g., cancelled orders don't have "cancel" link)
  def linksForOrder(order: OrderResource, baseUrl: String): List[HypermediaLink] = ???

  // ============================================================
  // Exercise 6: API Rate Limiting Design
  // ============================================================
  // TODO: Design a rate limiting system with multiple strategies:
  //  fixed window, sliding window, token bucket.

  sealed trait RateLimitStrategy
  case class FixedWindow(maxRequests: Int, windowSeconds: Int) extends RateLimitStrategy
  case class SlidingWindow(maxRequests: Int, windowSeconds: Int) extends RateLimitStrategy
  case class TokenBucket(capacity: Int, refillRate: Double) extends RateLimitStrategy

  case class RateLimitResult(
    allowed: Boolean,
    remaining: Int,
    resetAt: Long,
    retryAfter: Option[Int]
  )

  trait RateLimiter {
    def checkLimit(clientId: String): RateLimitResult
    def consumeToken(clientId: String): RateLimitResult
  }

  // TODO: Implement a token bucket rate limiter
  class TokenBucketLimiter(capacity: Int, refillRate: Double) extends RateLimiter {
    def checkLimit(clientId: String): RateLimitResult = ???
    def consumeToken(clientId: String): RateLimitResult = ???
  }

  // TODO: Design rate limit response headers
  def rateLimitHeaders(result: RateLimitResult): Map[String, String] = ???

  // ============================================================
  // Exercise 7: API Authentication Design
  // ============================================================
  // TODO: Design an API authentication system supporting multiple
  //  auth methods: API key, JWT, OAuth2 bearer token.

  sealed trait AuthMethod
  case class ApiKeyAuth(key: String, headerName: String = "X-API-Key") extends AuthMethod
  case class BearerTokenAuth(token: String) extends AuthMethod
  case class BasicAuth(username: String, password: String) extends AuthMethod

  case class AuthenticatedPrincipal(
    id: String,
    roles: Set[String],
    permissions: Set[String],
    metadata: Map[String, String]
  )

  trait Authenticator {
    def authenticate(method: AuthMethod): Either[String, AuthenticatedPrincipal]
  }

  // TODO: Implement a multi-strategy authenticator
  class MultiAuthenticator(strategies: Map[String, Authenticator]) extends Authenticator {
    def authenticate(method: AuthMethod): Either[String, AuthenticatedPrincipal] = ???
  }

  // TODO: Design authentication middleware
  def authMiddleware(
    authenticator: Authenticator,
    requiredPermissions: Set[String]
  ): Map[String, String] => Either[String, AuthenticatedPrincipal] = ???

  // ============================================================
  // Exercise 8: GraphQL vs REST Trade-offs
  // ============================================================
  // TODO: Model the same data access pattern in both REST and
  //  GraphQL styles. Compare the approaches and their trade-offs.

  // REST approach: multiple endpoints, potential over/under-fetching
  object RESTApproach {
    case class UserRest(id: Long, name: String, email: String)
    case class OrderRest(id: Long, userId: Long, total: BigDecimal, status: String)
    case class OrderItemRest(id: Long, orderId: Long, productName: String, quantity: Int)

    // To get user with orders and items: 3 API calls
    // GET /users/1
    // GET /users/1/orders
    // GET /orders/123/items
    def getUserWithOrders(userId: Long): Either[String, (UserRest, List[(OrderRest, List[OrderItemRest])])] = ???
  }

  // GraphQL approach: single query, client specifies shape
  object GraphQLApproach {
    // Query model
    case class GraphQLQuery(query: String, variables: Map[String, Any])

    // Resolver trait
    trait Resolver[A] {
      def resolve(args: Map[String, Any]): Either[String, A]
    }

    // TODO: Design a simple field resolver system
    case class FieldDefinition(
      name: String,
      fieldType: String,
      args: List[(String, String)],
      description: String
    )

    // TODO: Define the schema for User type with nested orders
    val userType: List[FieldDefinition] = ???
  }

  // TODO: Document trade-offs between REST and GraphQL
  // REST pros: cacheability, simplicity, standards
  // REST cons: over-fetching, N+1 problem, rigid structure
  // GraphQL pros: flexible queries, single endpoint, no over-fetching
  // GraphQL cons: complexity, caching difficulty, N+1 in resolvers

  def main(args: Array[String]): Unit = {
    println("=== Arch008: API Design ===")
    println()
    println("Exercise 1: RESTful API Design")
    println("Exercise 2: API Versioning")
    println("Exercise 3: Pagination Design")
    println("Exercise 4: Error Response Format")
    println("Exercise 5: HATEOAS Concept")
    println("Exercise 6: API Rate Limiting Design")
    println("Exercise 7: API Authentication Design")
    println("Exercise 8: GraphQL vs REST Trade-offs")
  }
}
