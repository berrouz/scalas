package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Hexagonal Architecture (Ports & Adapters)
 *
 * Senior/Architect focus:
 * - Domain isolation from infrastructure
 * - Port (interface) and Adapter (implementation) design
 * - Testability through port substitution
 */
object Arch013_HexagonalArch {

  // ============================================================
  // Exercise 1: Ports and Adapters Overview
  // ============================================================
  // TODO: Design the hexagonal architecture for an order management
  //  system. Define the domain core, inbound ports (driving),
  //  and outbound ports (driven).

  // Domain Core - pure business logic, no dependencies
  object Domain {
    case class OrderId(value: String)
    case class CustomerId(value: String)
    case class ProductId(value: String)

    case class OrderItem(productId: ProductId, quantity: Int, unitPrice: BigDecimal)
    case class Order(
      id: OrderId,
      customerId: CustomerId,
      items: List[OrderItem],
      status: OrderStatus,
      createdAt: Long
    ) {
      def totalAmount: BigDecimal = ???
      def canBeCancelled: Boolean = ???
    }

    sealed trait OrderStatus
    case object Draft extends OrderStatus
    case object Submitted extends OrderStatus
    case object Paid extends OrderStatus
    case object Shipped extends OrderStatus
    case object Cancelled extends OrderStatus

    sealed trait OrderError
    case class OrderNotFound(id: OrderId) extends OrderError
    case class InvalidTransition(from: OrderStatus, to: OrderStatus) extends OrderError
    case class InsufficientStock(productId: ProductId) extends OrderError
    case class PaymentFailed(reason: String) extends OrderError
  }

  // ============================================================
  // Exercise 2: Inbound Port (Driving Port)
  // ============================================================
  // TODO: Design inbound ports that define the use cases.
  //  These are the entry points into the domain from the outside world.

  import Domain._

  // Inbound port: defines what the application CAN DO
  trait OrderManagementPort {
    def createOrder(customerId: CustomerId, items: List[(ProductId, Int)]): Either[OrderError, Order]
    def submitOrder(orderId: OrderId): Either[OrderError, Order]
    def cancelOrder(orderId: OrderId, reason: String): Either[OrderError, Order]
    def getOrder(orderId: OrderId): Either[OrderError, Order]
    def listOrders(customerId: CustomerId): Either[OrderError, List[Order]]
  }

  // ============================================================
  // Exercise 3: Outbound Port (Driven Port)
  // ============================================================
  // TODO: Design outbound ports that define what the domain NEEDS
  //  from the outside world. The domain defines these interfaces;
  //  infrastructure implements them.

  // Outbound port: what the domain needs
  trait OrderRepositoryPort {
    def save(order: Order): Either[OrderError, Order]
    def findById(id: OrderId): Either[OrderError, Option[Order]]
    def findByCustomer(customerId: CustomerId): Either[OrderError, List[Order]]
    def delete(id: OrderId): Either[OrderError, Unit]
  }

  trait InventoryPort {
    def checkAvailability(productId: ProductId, quantity: Int): Either[OrderError, Boolean]
    def reserve(productId: ProductId, quantity: Int): Either[OrderError, String]
    def release(reservationId: String): Either[OrderError, Unit]
  }

  trait PaymentPort {
    def charge(customerId: CustomerId, amount: BigDecimal): Either[OrderError, String]
    def refund(transactionId: String): Either[OrderError, Unit]
  }

  trait NotificationPort {
    def notifyOrderCreated(order: Order): Either[OrderError, Unit]
    def notifyOrderShipped(order: Order): Either[OrderError, Unit]
    def notifyOrderCancelled(order: Order, reason: String): Either[OrderError, Unit]
  }

  // ============================================================
  // Exercise 4: Adapter Implementation
  // ============================================================
  // TODO: Implement adapters for the outbound ports.
  //  Adapters translate between domain and infrastructure.

  // Database adapter
  class PostgresOrderRepository extends OrderRepositoryPort {
    def save(order: Order): Either[OrderError, Order] = ???
    def findById(id: OrderId): Either[OrderError, Option[Order]] = ???
    def findByCustomer(customerId: CustomerId): Either[OrderError, List[Order]] = ???
    def delete(id: OrderId): Either[OrderError, Unit] = ???
  }

  // In-memory adapter (for testing)
  class InMemoryOrderRepository extends OrderRepositoryPort {
    private val store = scala.collection.mutable.Map.empty[OrderId, Order]

    def save(order: Order): Either[OrderError, Order] = ???
    def findById(id: OrderId): Either[OrderError, Option[Order]] = ???
    def findByCustomer(customerId: CustomerId): Either[OrderError, List[Order]] = ???
    def delete(id: OrderId): Either[OrderError, Unit] = ???
  }

  // External service adapter
  class HttpInventoryAdapter(baseUrl: String) extends InventoryPort {
    def checkAvailability(productId: ProductId, quantity: Int): Either[OrderError, Boolean] = ???
    def reserve(productId: ProductId, quantity: Int): Either[OrderError, String] = ???
    def release(reservationId: String): Either[OrderError, Unit] = ???
  }

  // ============================================================
  // Exercise 5: Domain Layer Isolation
  // ============================================================
  // TODO: Implement domain services that contain pure business logic.
  //  Domain services should have NO infrastructure dependencies.

  object OrderDomainService {
    // Pure business logic
    def calculateTotal(items: List[OrderItem]): BigDecimal = ???

    def validateTransition(from: OrderStatus, to: OrderStatus): Either[OrderError, OrderStatus] = ???

    def applyDiscount(order: Order, discountPercent: BigDecimal): Either[OrderError, Order] = ???

    def canShip(order: Order): Either[OrderError, Boolean] = ???

    // Validate business rules
    def validateOrder(order: Order): Either[OrderError, Order] = ???
  }

  // ============================================================
  // Exercise 6: Infrastructure Layer
  // ============================================================
  // TODO: Design the infrastructure layer that wires adapters
  //  to ports. This is where the "main" composition happens.

  case class InfrastructureConfig(
    dbUrl: String,
    inventoryServiceUrl: String,
    paymentServiceUrl: String,
    emailServiceUrl: String
  )

  // TODO: Wire everything together
  class InfrastructureWiring(config: InfrastructureConfig) {
    // Create adapters
    lazy val orderRepo: OrderRepositoryPort = ???
    lazy val inventory: InventoryPort = ???
    lazy val payment: PaymentPort = ???
    lazy val notification: NotificationPort = ???

    // Create application service (uses ports)
    lazy val orderManagement: OrderManagementPort = ???
  }

  // ============================================================
  // Exercise 7: Application Service
  // ============================================================
  // TODO: Implement the application service that orchestrates
  //  domain logic with port calls. This is the use case layer.

  class OrderApplicationService(
    orderRepo: OrderRepositoryPort,
    inventory: InventoryPort,
    payment: PaymentPort,
    notification: NotificationPort
  ) extends OrderManagementPort {

    override def createOrder(customerId: CustomerId, items: List[(ProductId, Int)]): Either[OrderError, Order] = ???

    override def submitOrder(orderId: OrderId): Either[OrderError, Order] = ???

    override def cancelOrder(orderId: OrderId, reason: String): Either[OrderError, Order] = ???

    override def getOrder(orderId: OrderId): Either[OrderError, Order] = ???

    override def listOrders(customerId: CustomerId): Either[OrderError, List[Order]] = ???
  }

  // ============================================================
  // Exercise 8: Hexagonal Architecture with ZIO Concepts
  // ============================================================
  // TODO: Show how hexagonal architecture maps to ZIO's service
  //  pattern. Ports become ZIO service traits, adapters become
  //  ZLayer implementations.

  // In ZIO, ports are service traits:
  // trait OrderRepository {
  //   def save(order: Order): ZIO[Any, OrderError, Order]
  // }

  // Adapters are ZLayer:
  // val live: ZLayer[DataSource, Nothing, OrderRepository] = ...

  // TODO: Design the ZIO-style hexagonal architecture
  // Simulate with traits and Either

  trait ZIOStyleOrderRepo {
    def save(order: Order): Either[OrderError, Order]
    def findById(id: OrderId): Either[OrderError, Option[Order]]
  }

  // "ZLayer" - factory for creating the service
  object ZIOStyleOrderRepo {
    def live(dbUrl: String): ZIOStyleOrderRepo = ???
    def test(): ZIOStyleOrderRepo = ???
  }

  // Application wiring (like ZLayer composition)
  def buildApplication(config: InfrastructureConfig): OrderManagementPort = ???

  def main(args: Array[String]): Unit = {
    println("=== Arch013: Hexagonal Architecture ===")
    println()
    println("Exercise 1: Ports and Adapters Overview")
    println("Exercise 2: Inbound Port (Driving)")
    println("Exercise 3: Outbound Port (Driven)")
    println("Exercise 4: Adapter Implementation")
    println("Exercise 5: Domain Layer Isolation")
    println("Exercise 6: Infrastructure Layer")
    println("Exercise 7: Application Service")
    println("Exercise 8: Hexagonal with ZIO Concepts")
  }
}
