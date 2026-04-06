package org.shev4ik.interview.senior_architect.level3_zio_architecture

/**
 * ZIO Service Architecture
 *
 * Senior/Architect focus:
 * - Service trait design, implementation, and composition
 * - Service lifecycle, configuration, and metrics
 */
object Arch027_ZIOServiceArch {

  // Exercise 1: Service Trait Design
  // TODO: Design ZIO-style service traits with proper error types.
  trait UserService {
    def getUser(id: String): Either[ServiceError, User]
    def createUser(request: CreateUserReq): Either[ServiceError, User]
    def updateUser(id: String, request: UpdateUserReq): Either[ServiceError, User]
    def deleteUser(id: String): Either[ServiceError, Unit]
  }
  case class User(id: String, name: String, email: String, status: String)
  case class CreateUserReq(name: String, email: String)
  case class UpdateUserReq(name: Option[String], email: Option[String])
  sealed trait ServiceError
  case class NotFound(resource: String, id: String) extends ServiceError
  case class ValidationError(errors: List[String]) extends ServiceError
  case class ConflictError(message: String) extends ServiceError

  // Exercise 2: Service Implementation
  trait UserRepository { def find(id: String): Either[String, Option[User]]; def save(user: User): Either[String, User] }
  class UserServiceLive(repo: UserRepository) extends UserService {
    def getUser(id: String): Either[ServiceError, User] = ???
    def createUser(request: CreateUserReq): Either[ServiceError, User] = ???
    def updateUser(id: String, request: UpdateUserReq): Either[ServiceError, User] = ???
    def deleteUser(id: String): Either[ServiceError, Unit] = ???
  }

  // Exercise 3: Service Dependencies
  // TODO: Model service dependency graph and validate it.
  case class ServiceDescriptor(name: String, dependencies: List[String], provides: List[String])
  def validateDependencyGraph(services: List[ServiceDescriptor]): Either[String, List[String]] = ???
  val orderServiceDescriptor: ServiceDescriptor = ???
  val userServiceDescriptor: ServiceDescriptor = ???

  // Exercise 4: Service Testing
  class TestUserRepository(users: Map[String, User]) extends UserRepository {
    def find(id: String): Either[String, Option[User]] = ???
    def save(user: User): Either[String, User] = ???
  }
  object ServiceTests {
    def testGetUser(): Either[String, Boolean] = ???
    def testCreateUser(): Either[String, Boolean] = ???
    def testUserNotFound(): Either[String, Boolean] = ???
  }

  // Exercise 5: Service Composition
  trait OrderService { def placeOrder(userId: String, items: List[(String, Int)]): Either[ServiceError, String] }
  trait NotificationService { def notify(userId: String, message: String): Either[ServiceError, Unit] }
  class OrderWorkflow(users: UserService, orders: OrderService, notifications: NotificationService) {
    def placeAndNotify(userId: String, items: List[(String, Int)]): Either[ServiceError, String] = ???
  }

  // Exercise 6: Service Lifecycle
  sealed trait ServiceState
  case object Initializing extends ServiceState
  case object Ready extends ServiceState
  case object Degraded extends ServiceState
  case object ShuttingDown extends ServiceState
  trait ManagedService {
    def name: String; def state: ServiceState
    def initialize(): Either[String, Unit]; def healthCheck(): Either[String, Boolean]
    def shutdown(): Either[String, Unit]
  }
  class ManagedUserService(repo: UserRepository) extends ManagedService with UserService {
    var state: ServiceState = Initializing
    val name = "user-service"
    def initialize(): Either[String, Unit] = ???
    def healthCheck(): Either[String, Boolean] = ???
    def shutdown(): Either[String, Unit] = ???
    def getUser(id: String): Either[ServiceError, User] = ???
    def createUser(request: CreateUserReq): Either[ServiceError, User] = ???
    def updateUser(id: String, request: UpdateUserReq): Either[ServiceError, User] = ???
    def deleteUser(id: String): Either[ServiceError, Unit] = ???
  }

  // Exercise 7: Service Configuration
  case class ServiceConfig(name: String, host: String, port: Int, maxConnections: Int, timeoutMs: Long, retries: Int)
  trait ConfigurableService[C] { def configure(config: C): Either[String, Unit]; def currentConfig: C }
  class ConfigurableUserService(var config: ServiceConfig) extends ConfigurableService[ServiceConfig] {
    def configure(newConfig: ServiceConfig): Either[String, Unit] = ???
    def currentConfig: ServiceConfig = config
  }

  // Exercise 8: Service Metrics
  case class ServiceMetrics(requestCount: Long, errorCount: Long, avgLatencyMs: Double, p99LatencyMs: Double, activeConnections: Int)
  trait InstrumentedService { def metrics: ServiceMetrics; def resetMetrics(): Unit }
  class MetricsCollector {
    def recordRequest(service: String, duration: Long, success: Boolean): Unit = ???
    def getMetrics(service: String): ServiceMetrics = ???
    def getAllMetrics(): Map[String, ServiceMetrics] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch027: ZIO Service Architecture ===")
    println()
    println("Exercise 1: Service Trait Design")
    println("Exercise 2: Service Implementation")
    println("Exercise 3: Service Dependencies")
    println("Exercise 4: Service Testing")
    println("Exercise 5: Service Composition")
    println("Exercise 6: Service Lifecycle")
    println("Exercise 7: Service Configuration")
    println("Exercise 8: Service Metrics")
  }
}
