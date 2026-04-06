package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Module Design in Scala
 *
 * Senior/Architect focus:
 * - Designing cohesive, loosely-coupled modules
 * - API boundaries and backward compatibility
 * - Module composition and dependency management
 */
object Arch006_ModuleDesign {

  // ============================================================
  // Exercise 1: Thin Interface Principle
  // ============================================================
  // TODO: Design a module with a thin public API that hides
  //  internal complexity. Only expose what clients need.
  //  Internal details should be package-private or hidden.

  // Public API - thin, stable interface
  trait UserModule {
    def createUser(name: String, email: String): Either[String, Long]
    def getUser(id: Long): Either[String, UserView]
    def listUsers(page: Int, pageSize: Int): Either[String, PagedResult[UserView]]
  }

  case class UserView(id: Long, name: String, email: String)
  case class PagedResult[A](items: List[A], total: Long, page: Int, pageSize: Int)

  // TODO: Implement the module with internal complexity hidden
  // Internal: validation, caching, auditing, event publishing
  class UserModuleImpl extends UserModule {
    // These are internal details, not exposed in the interface
    private def validateName(name: String): Either[String, String] = ???
    private def validateEmail(email: String): Either[String, String] = ???
    private def persistUser(name: String, email: String): Either[String, Long] = ???
    private def publishUserCreated(userId: Long): Unit = ???

    override def createUser(name: String, email: String): Either[String, Long] = ???
    override def getUser(id: Long): Either[String, UserView] = ???
    override def listUsers(page: Int, pageSize: Int): Either[String, PagedResult[UserView]] = ???
  }

  // ============================================================
  // Exercise 2: Module Cohesion
  // ============================================================
  // TODO: Analyze and improve module cohesion. Group related
  //  functionality together. Each module should have a single,
  //  well-defined purpose.

  // BAD: Low cohesion - this module does unrelated things
  trait LowCohesionModule {
    def processPayment(amount: BigDecimal): Unit
    def sendEmail(to: String, body: String): Unit
    def generateReport(month: Int): String
    def validateAddress(address: String): Boolean
  }

  // GOOD: High cohesion modules
  // TODO: Decompose into focused modules
  trait PaymentModule {
    def processPayment(amount: BigDecimal, method: String): Either[String, String] = ???
    def refundPayment(transactionId: String): Either[String, String] = ???
    def getPaymentStatus(transactionId: String): Either[String, String] = ???
  }

  trait NotificationModule {
    def sendEmail(to: String, subject: String, body: String): Either[String, Unit] = ???
    def sendSms(to: String, message: String): Either[String, Unit] = ???
  }

  trait ReportingModule {
    def generateMonthlyReport(month: Int, year: Int): Either[String, String] = ???
    def generateDailyReport(date: String): Either[String, String] = ???
  }

  // ============================================================
  // Exercise 3: Module Coupling
  // ============================================================
  // TODO: Reduce coupling between modules. Modules should communicate
  //  through well-defined interfaces, not concrete implementations.

  // BAD: Tight coupling - direct dependency on concrete class
  // class OrderService {
  //   val db = new PostgresDatabase()    // tightly coupled
  //   val mailer = new SmtpMailer()      // tightly coupled
  // }

  // GOOD: Loose coupling through abstractions
  trait Database {
    def query[A](sql: String, params: List[Any]): Either[String, List[A]]
    def execute(sql: String, params: List[Any]): Either[String, Int]
  }

  trait Mailer {
    def send(to: String, subject: String, body: String): Either[String, Unit]
  }

  // TODO: Implement OrderService with loose coupling
  class OrderService(db: Database, mailer: Mailer) {
    def placeOrder(customerId: Long, items: List[(Long, Int)]): Either[String, Long] = ???
    def cancelOrder(orderId: Long): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 4: Dependency Direction
  // ============================================================
  // TODO: Ensure dependencies flow in the correct direction.
  //  Domain/business logic should NOT depend on infrastructure.
  //  Infrastructure depends on domain abstractions.

  // Domain layer (no external dependencies)
  object DomainLayer {
    case class OrderDomain(id: Long, items: List[(Long, Int)], status: String)

    // Domain defines the interface it needs (port)
    trait OrderRepository {
      def save(order: OrderDomain): Either[String, Long]
      def findById(id: Long): Either[String, Option[OrderDomain]]
    }

    // Domain service uses the abstraction
    class OrderDomainService(repo: OrderRepository) {
      def createOrder(items: List[(Long, Int)]): Either[String, OrderDomain] = ???
      def getOrder(id: Long): Either[String, OrderDomain] = ???
    }
  }

  // Infrastructure layer (depends on domain abstractions)
  object InfrastructureLayer {
    // TODO: Implement the domain's port using concrete infrastructure
    class PostgresOrderRepository extends DomainLayer.OrderRepository {
      def save(order: DomainLayer.OrderDomain): Either[String, Long] = ???
      def findById(id: Long): Either[String, Option[DomainLayer.OrderDomain]] = ???
    }
  }

  // ============================================================
  // Exercise 5: Module Boundaries
  // ============================================================
  // TODO: Define clear module boundaries with explicit public APIs.
  //  Use Scala's access modifiers and package organization to
  //  enforce boundaries.

  // Module boundary: everything inside is private, only the trait is public
  trait InventoryModule {
    def checkStock(productId: Long): Either[String, Int]
    def reserveStock(productId: Long, quantity: Int): Either[String, String]
    def releaseReservation(reservationId: String): Either[String, Unit]
  }

  // TODO: Implement with internal details hidden
  object InventoryModuleFactory {
    def create(): InventoryModule = {
      // All internal classes are private to this factory
      new InventoryModule {
        private case class Reservation(id: String, productId: Long, quantity: Int)
        private val stock = scala.collection.mutable.Map.empty[Long, Int]
        private val reservations = scala.collection.mutable.Map.empty[String, Reservation]

        override def checkStock(productId: Long): Either[String, Int] = ???
        override def reserveStock(productId: Long, quantity: Int): Either[String, String] = ???
        override def releaseReservation(reservationId: String): Either[String, Unit] = ???
      }
    }
  }

  // ============================================================
  // Exercise 6: API Design
  // ============================================================
  // TODO: Design a clean, intuitive API for a caching module.
  //  Consider: naming conventions, error handling, type safety,
  //  default values, and ease of use.

  // Good API design principles:
  // - Clear naming that reveals intent
  // - Sensible defaults
  // - Type-safe keys
  // - Explicit error handling

  trait CacheKey[V] {
    def key: String
    def ttlSeconds: Int
  }

  trait CacheModule {
    def get[V](key: CacheKey[V]): Either[String, Option[V]]
    def put[V](key: CacheKey[V], value: V): Either[String, Unit]
    def invalidate[V](key: CacheKey[V]): Either[String, Unit]
    def invalidateAll(): Either[String, Unit]
    def getOrElse[V](key: CacheKey[V], compute: => Either[String, V]): Either[String, V]
  }

  // TODO: Implement a type-safe cache key builder
  object CacheKey {
    def apply[V](namespace: String, id: String, ttl: Int = 300): CacheKey[V] = ???
  }

  // TODO: Implement an in-memory cache module
  class InMemoryCacheModule extends CacheModule {
    override def get[V](key: CacheKey[V]): Either[String, Option[V]] = ???
    override def put[V](key: CacheKey[V], value: V): Either[String, Unit] = ???
    override def invalidate[V](key: CacheKey[V]): Either[String, Unit] = ???
    override def invalidateAll(): Either[String, Unit] = ???
    override def getOrElse[V](key: CacheKey[V], compute: => Either[String, V]): Either[String, V] = ???
  }

  // ============================================================
  // Exercise 7: Backward Compatibility
  // ============================================================
  // TODO: Design a module API that supports backward compatibility
  //  when evolving. Show how to add new functionality without
  //  breaking existing clients.

  // Version 1 of the API
  trait SearchModuleV1 {
    def search(query: String): Either[String, List[String]]
  }

  // Version 2: adds pagination without breaking V1 clients
  trait SearchModuleV2 extends SearchModuleV1 {
    // Default implementation maintains backward compatibility
    override def search(query: String): Either[String, List[String]] = {
      searchPaged(query, page = 0, pageSize = 20).map(_.items)
    }
    def searchPaged(query: String, page: Int, pageSize: Int): Either[String, PagedResult[String]]
  }

  // TODO: Design V3 that adds filtering without breaking V1 or V2 clients
  trait SearchModuleV3 extends SearchModuleV2 {
    def searchFiltered(
      query: String,
      filters: Map[String, String],
      page: Int,
      pageSize: Int
    ): Either[String, PagedResult[String]] = ???

    // Backward compatible default
    override def searchPaged(query: String, page: Int, pageSize: Int): Either[String, PagedResult[String]] = ???
  }

  // ============================================================
  // Exercise 8: Module Versioning
  // ============================================================
  // TODO: Design a versioning strategy for modules. Support
  //  multiple versions running simultaneously during migration.

  object Versioning {
    // Semantic versioning in types
    case class Version(major: Int, minor: Int, patch: Int) {
      def isCompatibleWith(other: Version): Boolean = ???
      override def toString: String = s"$major.$minor.$patch"
    }

    // Versioned module wrapper
    trait VersionedModule[M] {
      def version: Version
      def module: M
      def isCompatibleWith(requiredVersion: Version): Boolean = ???
    }

    // TODO: Implement a module registry that manages versions
    class ModuleRegistry {
      private var modules: Map[String, List[VersionedModule[_]]] = Map.empty

      def register[M](name: String, versioned: VersionedModule[M]): Unit = ???
      def getLatest[M](name: String): Option[VersionedModule[M]] = ???
      def getCompatible[M](name: String, requiredVersion: Version): Option[VersionedModule[M]] = ???
    }
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch006: Module Design ===")
    println()
    println("Exercise 1: Thin Interface Principle")
    println("Exercise 2: Module Cohesion")
    println("Exercise 3: Module Coupling")
    println("Exercise 4: Dependency Direction")
    println("Exercise 5: Module Boundaries")
    println("Exercise 6: API Design")
    println("Exercise 7: Backward Compatibility")
    println("Exercise 8: Module Versioning")
  }
}
