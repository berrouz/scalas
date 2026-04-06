package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Onion Architecture
 *
 * Senior/Architect focus:
 * - Concentric layers with domain at the core
 * - Dependency direction: always inward
 * - Comparison with hexagonal and clean architecture
 */
object Arch015_OnionArch {

  // ============================================================
  // Exercise 1: Domain Model Core
  // ============================================================
  // TODO: Design the innermost layer - domain model with entities,
  //  value objects, and domain events. No dependencies on anything.

  object DomainModel {
    // Value objects
    case class Email private (value: String)
    object Email {
      def create(raw: String): Either[String, Email] = ???
    }

    case class Money(amount: BigDecimal, currency: String) {
      def add(other: Money): Either[String, Money] = ???
      def subtract(other: Money): Either[String, Money] = ???
    }

    // Entity
    case class CustomerId(value: String)
    case class Customer(
      id: CustomerId,
      name: String,
      email: Email,
      tier: CustomerTier
    )

    sealed trait CustomerTier
    case object Standard extends CustomerTier
    case object Premium extends CustomerTier
    case object VIP extends CustomerTier

    // Domain events
    sealed trait CustomerEvent
    case class CustomerRegistered(customer: Customer) extends CustomerEvent
    case class CustomerUpgraded(customerId: CustomerId, from: CustomerTier, to: CustomerTier) extends CustomerEvent
    case class CustomerDeactivated(customerId: CustomerId, reason: String) extends CustomerEvent
  }

  // ============================================================
  // Exercise 2: Domain Services
  // ============================================================
  // TODO: Implement domain services that encapsulate business logic
  //  spanning multiple entities. Domain services depend only on
  //  domain model objects.

  import DomainModel._

  object DomainServices {
    // Pricing rules depend only on domain objects
    def calculateDiscount(customer: Customer, orderTotal: Money): Either[String, Money] = ???

    // Tier upgrade rules
    def evaluateTierUpgrade(customer: Customer, totalSpend: Money): Either[String, Option[CustomerTier]] = ???

    // Validation rules
    def validateCustomerRegistration(name: String, email: String): Either[List[String], (String, Email)] = ???
  }

  // ============================================================
  // Exercise 3: Application Services
  // ============================================================
  // TODO: Design application services that orchestrate domain
  //  services and infrastructure ports. This layer defines use cases.

  // Repository interfaces (defined in app services layer, implemented in infra)
  trait CustomerRepository {
    def findById(id: CustomerId): Either[String, Option[Customer]]
    def save(customer: Customer): Either[String, Customer]
    def findByEmail(email: Email): Either[String, Option[Customer]]
  }

  trait EventPublisher {
    def publish(event: CustomerEvent): Either[String, Unit]
  }

  // Application service orchestrates the flow
  class CustomerApplicationService(
    repo: CustomerRepository,
    eventPublisher: EventPublisher
  ) {
    def registerCustomer(name: String, emailRaw: String): Either[String, Customer] = ???
    def upgradeCustomer(customerId: CustomerId, newTier: CustomerTier): Either[String, Customer] = ???
    def getCustomer(customerId: CustomerId): Either[String, Customer] = ???
  }

  // ============================================================
  // Exercise 4: Infrastructure Layer
  // ============================================================
  // TODO: Implement the outermost layer with concrete infrastructure.
  //  Database, HTTP clients, message queues, etc.

  class PostgresCustomerRepository extends CustomerRepository {
    def findById(id: CustomerId): Either[String, Option[Customer]] = ???
    def save(customer: Customer): Either[String, Customer] = ???
    def findByEmail(email: Email): Either[String, Option[Customer]] = ???
  }

  class KafkaEventPublisher(bootstrapServers: String) extends EventPublisher {
    def publish(event: CustomerEvent): Either[String, Unit] = ???
  }

  // HTTP API layer (infrastructure)
  class CustomerHttpApi(service: CustomerApplicationService) {
    def handleRegister(body: Map[String, String]): (Int, Map[String, Any]) = ???
    def handleGetCustomer(id: String): (Int, Map[String, Any]) = ???
  }

  // ============================================================
  // Exercise 5: Onion Layers Visualization
  // ============================================================
  // TODO: Clearly define each onion layer and what belongs where.
  //  Each layer can only reference layers closer to the center.

  // Layer 1 (Core): Domain Model - entities, value objects, domain events
  // Layer 2: Domain Services - business logic operating on domain model
  // Layer 3: Application Services - use cases, orchestration, port definitions
  // Layer 4 (Outer): Infrastructure - DB, HTTP, messaging, framework code

  // TODO: Classify these components into the correct layer
  object LayerClassification {
    // Which layer does each belong to?
    // Customer case class -> ???
    // calculateDiscount function -> ???
    // CustomerRepository trait -> ???
    // PostgresCustomerRepository class -> ???
    // CustomerApplicationService -> ???
    // KafkaEventPublisher -> ???

    def classifyComponent(component: String): String = component match {
      case "Customer"                    => ???  // "Domain Model"
      case "Money"                       => ???  // "Domain Model"
      case "calculateDiscount"           => ???  // "Domain Services"
      case "CustomerRepository"          => ???  // "Application Services"
      case "CustomerApplicationService"  => ???  // "Application Services"
      case "PostgresCustomerRepository"  => ???  // "Infrastructure"
      case "KafkaEventPublisher"         => ???  // "Infrastructure"
      case _                             => "Unknown"
    }
  }

  // ============================================================
  // Exercise 6: Dependency Direction
  // ============================================================
  // TODO: Demonstrate correct dependency direction in onion architecture.
  //  Show a violation and its fix.

  // VIOLATION: Domain model importing infrastructure
  // case class BadCustomer(id: String, connection: java.sql.Connection)  // WRONG!

  // FIX: Domain model is pure
  // Infrastructure adapts to domain

  // TODO: Design dependency inversion at each boundary
  trait DependencyDirectionDemo {
    // Application services define what they need (port)
    trait EmailSender {
      def sendWelcomeEmail(customer: Customer): Either[String, Unit]
    }

    // Infrastructure provides it
    class SmtpEmailSender(host: String) extends EmailSender {
      def sendWelcomeEmail(customer: Customer): Either[String, Unit] = ???
    }

    // Application service uses the port
    class RegistrationService(repo: CustomerRepository, emailSender: EmailSender) {
      def register(name: String, email: String): Either[String, Customer] = ???
    }
  }

  // ============================================================
  // Exercise 7: Onion vs Hexagonal
  // ============================================================
  // TODO: Compare onion and hexagonal architectures. Show how the
  //  same system looks in both styles. Note similarities and differences.

  object Comparison {
    // Hexagonal: Ports (interfaces) + Adapters (implementations)
    // Driving adapter -> [Port] -> Domain -> [Port] -> Driven adapter

    // Onion: Concentric layers
    // Infrastructure -> Application Services -> Domain Services -> Domain Model

    // Key differences:
    // - Hexagonal focuses on ports/adapters at boundaries
    // - Onion focuses on concentric layers with strict dependency direction
    // - Hexagonal has two types of ports (driving/driven)
    // - Onion has multiple ring layers

    // TODO: Map hexagonal concepts to onion concepts
    def hexToOnion(hexConcept: String): String = hexConcept match {
      case "Driving Port"       => ???  // "Application Service interface"
      case "Driven Port"        => ???  // "Repository/Gateway interface in App Services"
      case "Driving Adapter"    => ???  // "Infrastructure (Controllers)"
      case "Driven Adapter"     => ???  // "Infrastructure (Repositories)"
      case "Domain"             => ???  // "Domain Model + Domain Services"
      case _                    => "Unknown"
    }
  }

  // ============================================================
  // Exercise 8: Onion Architecture with ZIO Concepts
  // ============================================================
  // TODO: Map onion architecture to ZIO patterns. Each layer
  //  becomes a set of ZIO services with proper dependency wiring.

  object OnionWithZIO {
    // Domain Model layer: pure case classes (no ZIO needed)
    // Domain Services layer: pure functions (no ZIO needed)
    // Application Services layer: ZIO service traits
    // Infrastructure layer: ZLayer implementations

    // Application service as ZIO service
    trait CustomerService {
      def register(name: String, email: String): Either[String, Customer]
      def get(id: String): Either[String, Customer]
      def upgrade(id: String, tier: CustomerTier): Either[String, Customer]
    }

    // "ZLayer" composition
    object CustomerService {
      def live(repo: CustomerRepository, events: EventPublisher): CustomerService =
        new CustomerApplicationService(repo, events) with CustomerService {
          def register(name: String, email: String): Either[String, Customer] =
            registerCustomer(name, email)
          def get(id: String): Either[String, Customer] =
            getCustomer(CustomerId(id))
          def upgrade(id: String, tier: CustomerTier): Either[String, Customer] =
            upgradeCustomer(CustomerId(id), tier)
        }

      def test(initialCustomers: List[Customer]): CustomerService = ???
    }

    // Full application wiring
    def wireApplication(dbUrl: String, kafkaServers: String): CustomerService = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch015: Onion Architecture ===")
    println()
    println("Exercise 1: Domain Model Core")
    println("Exercise 2: Domain Services")
    println("Exercise 3: Application Services")
    println("Exercise 4: Infrastructure Layer")
    println("Exercise 5: Onion Layers Visualization")
    println("Exercise 6: Dependency Direction")
    println("Exercise 7: Onion vs Hexagonal")
    println("Exercise 8: Onion with ZIO Concepts")
  }
}
