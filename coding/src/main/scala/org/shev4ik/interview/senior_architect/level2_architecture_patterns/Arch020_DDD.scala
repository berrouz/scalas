package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Domain-Driven Design (DDD)
 *
 * Senior/Architect focus:
 * - Strategic DDD: bounded contexts, context mapping
 * - Tactical DDD: aggregates, services, repositories
 * - Anti-corruption layers and shared kernels
 */
object Arch020_DDD {

  // ============================================================
  // Exercise 1: Bounded Context
  // ============================================================
  // TODO: Define bounded contexts for an e-commerce platform.
  //  Each context has its own ubiquitous language and models.
  //  The same real-world concept may have different representations.

  // "Customer" means different things in different contexts
  object SalesContext {
    case class CustomerId(value: String)
    case class Customer(id: CustomerId, name: String, loyaltyTier: String, totalSpend: BigDecimal)
  }

  object ShippingContext {
    case class RecipientId(value: String)
    case class Recipient(id: RecipientId, name: String, address: Address, phoneNumber: String)
    case class Address(street: String, city: String, state: String, zip: String, country: String)
  }

  object BillingContext {
    case class AccountId(value: String)
    case class BillingAccount(id: AccountId, name: String, paymentMethod: String, creditLimit: BigDecimal)
  }

  // TODO: Identify the bounded contexts and their relationships
  case class BoundedContextDefinition(
    name: String,
    coreEntities: List[String],
    ubiquitousLanguage: Map[String, String],
    upstreamContexts: List[String],
    downstreamContexts: List[String]
  )

  val salesBoundedContext: BoundedContextDefinition = ???
  val shippingBoundedContext: BoundedContextDefinition = ???
  val billingBoundedContext: BoundedContextDefinition = ???

  // ============================================================
  // Exercise 2: Context Mapping
  // ============================================================
  // TODO: Define relationships between bounded contexts.
  //  Types: shared kernel, customer-supplier, conformist,
  //  anti-corruption layer, open host, published language.

  sealed trait ContextRelationship
  case class SharedKernel(sharedModel: String) extends ContextRelationship
  case class CustomerSupplier(upstream: String, downstream: String) extends ContextRelationship
  case class Conformist(upstream: String, downstream: String) extends ContextRelationship
  case class AntiCorruptionLayerRel(upstream: String, downstream: String) extends ContextRelationship
  case class OpenHostService(provider: String, protocol: String) extends ContextRelationship
  case class PublishedLanguage(format: String, schema: String) extends ContextRelationship

  case class ContextMap(
    contexts: List[BoundedContextDefinition],
    relationships: List[(String, String, ContextRelationship)]
  )

  // TODO: Build context map for e-commerce platform
  val ecommerceContextMap: ContextMap = ???

  // ============================================================
  // Exercise 3: Anti-Corruption Layer
  // ============================================================
  // TODO: Implement an anti-corruption layer between contexts.
  //  Translate external models to internal domain models.

  // External system (legacy or third-party)
  object ExternalPaymentSystem {
    case class PaymentResponse(
      txn_id: String,
      status_code: Int,      // 0=success, 1=declined, 2=error
      amount_cents: Long,
      currency_code: String,
      error_msg: Option[String]
    )
  }

  // Our domain model
  object PaymentDomain {
    sealed trait PaymentStatus
    case object PaymentSuccess extends PaymentStatus
    case object PaymentDeclined extends PaymentStatus
    case object PaymentError extends PaymentStatus

    case class PaymentResult(
      transactionId: String,
      status: PaymentStatus,
      amount: BigDecimal,
      currency: String,
      errorMessage: Option[String]
    )
  }

  // TODO: Implement anti-corruption layer
  trait PaymentACL {
    def translateResponse(external: ExternalPaymentSystem.PaymentResponse): Either[String, PaymentDomain.PaymentResult]
    def translateRequest(amount: BigDecimal, currency: String): Map[String, Any]
  }

  class PaymentAntiCorruptionLayer extends PaymentACL {
    def translateResponse(external: ExternalPaymentSystem.PaymentResponse): Either[String, PaymentDomain.PaymentResult] = ???
    def translateRequest(amount: BigDecimal, currency: String): Map[String, Any] = ???
  }

  // ============================================================
  // Exercise 4: Shared Kernel
  // ============================================================
  // TODO: Design a shared kernel - a small, explicitly shared
  //  model between two bounded contexts.

  object SharedKernelModule {
    // Shared types agreed upon by multiple contexts
    case class Money(amount: BigDecimal, currency: String)
    case class DateRange(start: Long, end: Long)

    // Shared domain events
    sealed trait IntegrationEvent {
      def eventId: String
      def timestamp: Long
      def source: String
    }
    case class OrderPlacedIntegration(eventId: String, orderId: String, customerId: String, total: Money, timestamp: Long, source: String) extends IntegrationEvent
    case class PaymentReceivedIntegration(eventId: String, orderId: String, amount: Money, timestamp: Long, source: String) extends IntegrationEvent

    // TODO: Rules for shared kernel:
    // - Changes require agreement from all sharing teams
    // - Keep it minimal
    // - Version it explicitly
    def validateSharedKernelChange(change: String, approvals: List[String], requiredApprovals: List[String]): Either[String, Boolean] = ???
  }

  // ============================================================
  // Exercise 5: Domain Event
  // ============================================================
  // TODO: Design domain events that communicate state changes
  //  between aggregates and bounded contexts.

  trait DomainEvent {
    def eventId: String
    def aggregateId: String
    def occurredAt: Long
  }

  // Events within the Order bounded context
  case class OrderPlaced(eventId: String, aggregateId: String, customerId: String, items: List[(String, Int)], occurredAt: Long) extends DomainEvent
  case class OrderPaid(eventId: String, aggregateId: String, paymentId: String, amount: BigDecimal, occurredAt: Long) extends DomainEvent
  case class OrderShipped(eventId: String, aggregateId: String, trackingNumber: String, occurredAt: Long) extends DomainEvent

  // TODO: Implement domain event dispatcher
  trait DomainEventDispatcher {
    def dispatch(event: DomainEvent): Either[String, Unit]
    def register(eventType: String, handler: DomainEvent => Either[String, Unit]): Unit
  }

  class SimpleDomainEventDispatcher extends DomainEventDispatcher {
    private val handlers = scala.collection.mutable.Map.empty[String, List[DomainEvent => Either[String, Unit]]]

    def dispatch(event: DomainEvent): Either[String, Unit] = ???
    def register(eventType: String, handler: DomainEvent => Either[String, Unit]): Unit = ???
  }

  // ============================================================
  // Exercise 6: Domain Service
  // ============================================================
  // TODO: Implement domain services for operations that span
  //  multiple aggregates or don't naturally belong to an entity.

  // Domain service: pricing logic that spans Product and Customer
  trait PricingService {
    def calculatePrice(productId: String, customerId: String, quantity: Int): Either[String, BigDecimal]
    def applyPromotions(items: List[(String, Int, BigDecimal)], promotionCodes: List[String]): Either[String, BigDecimal]
    def calculateShipping(items: List[(String, Int)], destination: String): Either[String, BigDecimal]
  }

  class PricingDomainService extends PricingService {
    def calculatePrice(productId: String, customerId: String, quantity: Int): Either[String, BigDecimal] = ???
    def applyPromotions(items: List[(String, Int, BigDecimal)], promotionCodes: List[String]): Either[String, BigDecimal] = ???
    def calculateShipping(items: List[(String, Int)], destination: String): Either[String, BigDecimal] = ???
  }

  // ============================================================
  // Exercise 7: Application Service
  // ============================================================
  // TODO: Implement application services that coordinate domain
  //  objects and infrastructure. Application services are thin
  //  orchestrators, not business logic containers.

  trait OrderApplicationService {
    def placeOrder(customerId: String, items: List[(String, Int)]): Either[String, String]
    def payOrder(orderId: String, paymentMethod: String): Either[String, Unit]
    def cancelOrder(orderId: String, reason: String): Either[String, Unit]
    def getOrderDetails(orderId: String): Either[String, Map[String, Any]]
  }

  // TODO: Implement - orchestrate domain objects, NO business logic here
  class OrderApplicationServiceImpl(
    orderRepo: OrderRepository,
    pricingService: PricingService,
    eventDispatcher: DomainEventDispatcher
  ) extends OrderApplicationService {
    def placeOrder(customerId: String, items: List[(String, Int)]): Either[String, String] = ???
    def payOrder(orderId: String, paymentMethod: String): Either[String, Unit] = ???
    def cancelOrder(orderId: String, reason: String): Either[String, Unit] = ???
    def getOrderDetails(orderId: String): Either[String, Map[String, Any]] = ???
  }

  // ============================================================
  // Exercise 8: Repository Pattern
  // ============================================================
  // TODO: Implement the repository pattern for aggregate persistence.
  //  Repository operates on aggregate roots only.

  trait OrderRepository {
    def save(order: OrderAggregate): Either[String, OrderAggregate]
    def findById(id: String): Either[String, Option[OrderAggregate]]
    def findByCustomerId(customerId: String): Either[String, List[OrderAggregate]]
    def nextId(): String
  }

  case class OrderAggregate(
    id: String,
    customerId: String,
    items: List[OrderLineItem],
    status: String,
    version: Long
  )

  case class OrderLineItem(productId: String, quantity: Int, unitPrice: BigDecimal)

  // TODO: Implement in-memory repository
  class InMemoryOrderRepository extends OrderRepository {
    private val store = scala.collection.mutable.Map.empty[String, OrderAggregate]
    def save(order: OrderAggregate): Either[String, OrderAggregate] = ???
    def findById(id: String): Either[String, Option[OrderAggregate]] = ???
    def findByCustomerId(customerId: String): Either[String, List[OrderAggregate]] = ???
    def nextId(): String = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch020: Domain-Driven Design ===")
    println()
    println("Exercise 1: Bounded Context")
    println("Exercise 2: Context Mapping")
    println("Exercise 3: Anti-Corruption Layer")
    println("Exercise 4: Shared Kernel")
    println("Exercise 5: Domain Event")
    println("Exercise 6: Domain Service")
    println("Exercise 7: Application Service")
    println("Exercise 8: Repository Pattern")
  }
}
