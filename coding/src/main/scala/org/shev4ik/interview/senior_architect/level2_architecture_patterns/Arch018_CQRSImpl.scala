package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * CQRS Implementation
 *
 * Senior/Architect focus:
 * - Command/Query separation with distinct models
 * - Event publishing for read model projections
 * - Testing CQRS systems
 */
object Arch018_CQRSImpl {

  // ============================================================
  // Exercise 1: Command Handler
  // ============================================================
  // TODO: Design the command side of CQRS. Commands represent
  //  intent to change state. Handlers validate and execute.

  sealed trait Command {
    def commandId: String
    def aggregateId: String
    def timestamp: Long
  }

  case class CreateOrderCommand(commandId: String, aggregateId: String, customerId: String, items: List[(String, Int, BigDecimal)], timestamp: Long) extends Command
  case class AddItemCommand(commandId: String, aggregateId: String, productId: String, quantity: Int, price: BigDecimal, timestamp: Long) extends Command
  case class SubmitOrderCommand(commandId: String, aggregateId: String, timestamp: Long) extends Command
  case class CancelOrderCommand(commandId: String, aggregateId: String, reason: String, timestamp: Long) extends Command

  sealed trait CommandResult
  case class CommandAccepted(commandId: String, events: List[DomainEvent]) extends CommandResult
  case class CommandRejected(commandId: String, reason: String) extends CommandResult

  trait CommandHandler[C <: Command] {
    def handle(command: C): Either[String, CommandResult]
    def validate(command: C): Either[String, C]
  }

  // TODO: Implement command handler for order commands
  class OrderCommandHandler extends CommandHandler[Command] {
    def handle(command: Command): Either[String, CommandResult] = ???
    def validate(command: Command): Either[String, Command] = ???
  }

  // ============================================================
  // Exercise 2: Query Handler
  // ============================================================
  // TODO: Design the query side. Queries read from optimized
  //  read models. They should be fast and not affect write state.

  sealed trait Query
  case class GetOrderById(orderId: String) extends Query
  case class GetOrdersByCustomer(customerId: String, page: Int, pageSize: Int) extends Query
  case class SearchOrders(query: String, status: Option[String], from: Option[Long], to: Option[Long]) extends Query
  case class GetOrderStats(customerId: String) extends Query

  // Read models (optimized for queries)
  case class OrderReadModel(
    orderId: String,
    customerName: String,
    itemCount: Int,
    totalAmount: BigDecimal,
    status: String,
    createdAt: Long,
    updatedAt: Long
  )

  case class OrderDetailReadModel(
    orderId: String,
    customerName: String,
    customerEmail: String,
    items: List[OrderItemReadModel],
    subtotal: BigDecimal,
    tax: BigDecimal,
    total: BigDecimal,
    status: String,
    statusHistory: List[(String, Long)]
  )

  case class OrderItemReadModel(productName: String, quantity: Int, unitPrice: BigDecimal, lineTotal: BigDecimal)
  case class OrderStatsReadModel(totalOrders: Int, totalSpent: BigDecimal, averageOrderValue: BigDecimal)

  trait QueryHandler[Q <: Query, R] {
    def handle(query: Q): Either[String, R]
  }

  // TODO: Implement query handlers
  class GetOrderByIdHandler extends QueryHandler[GetOrderById, OrderDetailReadModel] {
    def handle(query: GetOrderById): Either[String, OrderDetailReadModel] = ???
  }

  class GetOrdersByCustomerHandler extends QueryHandler[GetOrdersByCustomer, List[OrderReadModel]] {
    def handle(query: GetOrdersByCustomer): Either[String, List[OrderReadModel]] = ???
  }

  // ============================================================
  // Exercise 3: Command Validation
  // ============================================================
  // TODO: Design command validation that checks both structural
  //  validity and business rule compliance.

  sealed trait ValidationError
  case class MissingField(field: String) extends ValidationError
  case class InvalidValue(field: String, reason: String) extends ValidationError
  case class BusinessRuleViolation(rule: String, details: String) extends ValidationError

  trait CommandValidator[C <: Command] {
    def validate(command: C): Either[List[ValidationError], C]
  }

  // TODO: Implement validators
  class CreateOrderValidator extends CommandValidator[CreateOrderCommand] {
    def validate(command: CreateOrderCommand): Either[List[ValidationError], CreateOrderCommand] = ???
  }

  // Composable validation
  def combineValidations[C <: Command](validators: List[C => Either[List[ValidationError], C]])(command: C): Either[List[ValidationError], C] = ???

  // ============================================================
  // Exercise 4: Event Publisher (CQRS Bridge)
  // ============================================================
  // TODO: Design the event publisher that bridges command side
  //  events to the query side for projection updates.

  sealed trait DomainEvent {
    def eventId: String
    def aggregateId: String
    def timestamp: Long
    def version: Int
  }

  case class OrderCreatedEvent(eventId: String, aggregateId: String, customerId: String, timestamp: Long, version: Int) extends DomainEvent
  case class ItemAddedEvent(eventId: String, aggregateId: String, productId: String, quantity: Int, price: BigDecimal, timestamp: Long, version: Int) extends DomainEvent
  case class OrderSubmittedEvent(eventId: String, aggregateId: String, timestamp: Long, version: Int) extends DomainEvent
  case class OrderCancelledEvent(eventId: String, aggregateId: String, reason: String, timestamp: Long, version: Int) extends DomainEvent

  trait CQRSEventPublisher {
    def publish(events: List[DomainEvent]): Either[String, Unit]
    def subscribe(eventType: String, handler: DomainEvent => Either[String, Unit]): Either[String, String]
  }

  // TODO: Implement event publisher
  class InMemoryCQRSEventPublisher extends CQRSEventPublisher {
    def publish(events: List[DomainEvent]): Either[String, Unit] = ???
    def subscribe(eventType: String, handler: DomainEvent => Either[String, Unit]): Either[String, String] = ???
  }

  // ============================================================
  // Exercise 5: Read Model Projection
  // ============================================================
  // TODO: Design projections that update read models from events.
  //  Projections transform events into queryable data.

  trait Projection[E <: DomainEvent] {
    def apply(event: E): Either[String, Unit]
    def rebuild(events: List[E]): Either[String, Unit]
  }

  // TODO: Implement projections for order read models
  class OrderSummaryProjection extends Projection[DomainEvent] {
    private val summaries = scala.collection.mutable.Map.empty[String, OrderReadModel]

    def apply(event: DomainEvent): Either[String, Unit] = ???
    def rebuild(events: List[DomainEvent]): Either[String, Unit] = ???
    def getSummary(orderId: String): Option[OrderReadModel] = ???
  }

  class OrderDetailProjection extends Projection[DomainEvent] {
    def apply(event: DomainEvent): Either[String, Unit] = ???
    def rebuild(events: List[DomainEvent]): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 6: Eventual Consistency
  // ============================================================
  // TODO: Handle eventual consistency between write and read sides.
  //  Design mechanisms for read-your-writes consistency when needed.

  trait ConsistencyManager {
    // Check if read model is up to date with write model
    def isConsistent(aggregateId: String): Either[String, Boolean]

    // Wait for read model to catch up
    def awaitConsistency(aggregateId: String, timeoutMs: Long): Either[String, Boolean]

    // Get the latest write version
    def writeVersion(aggregateId: String): Either[String, Long]

    // Get the latest projected version
    def readVersion(aggregateId: String): Either[String, Long]
  }

  // TODO: Implement consistency manager
  class EventualConsistencyManager extends ConsistencyManager {
    def isConsistent(aggregateId: String): Either[String, Boolean] = ???
    def awaitConsistency(aggregateId: String, timeoutMs: Long): Either[String, Boolean] = ???
    def writeVersion(aggregateId: String): Either[String, Long] = ???
    def readVersion(aggregateId: String): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 7: CQRS with Kafka Concept
  // ============================================================
  // TODO: Design CQRS with Kafka as the event backbone.
  //  Commands produce events to Kafka topics.
  //  Projections consume from Kafka to update read models.

  case class KafkaCQRSConfig(
    commandTopic: String,
    eventTopic: String,
    consumerGroup: String,
    bootstrapServers: String,
    schemaRegistryUrl: String
  )

  trait KafkaCQRSBridge {
    def publishEvents(events: List[DomainEvent]): Either[String, Unit]
    def startProjection(projectionName: String, handler: DomainEvent => Either[String, Unit]): Either[String, Unit]
    def stopProjection(projectionName: String): Either[String, Unit]
    def getProjectionLag(projectionName: String): Either[String, Long]
  }

  // TODO: Implement Kafka CQRS bridge
  class KafkaCQRS(config: KafkaCQRSConfig) extends KafkaCQRSBridge {
    def publishEvents(events: List[DomainEvent]): Either[String, Unit] = ???
    def startProjection(projectionName: String, handler: DomainEvent => Either[String, Unit]): Either[String, Unit] = ???
    def stopProjection(projectionName: String): Either[String, Unit] = ???
    def getProjectionLag(projectionName: String): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 8: CQRS Testing
  // ============================================================
  // TODO: Design testing strategies for CQRS systems.
  //  Test commands, projections, and consistency separately.

  object CQRSTesting {
    // Given-When-Then style for command testing
    case class CommandTestCase(
      given: List[DomainEvent],   // existing state (events)
      when: Command,              // command to execute
      thenExpect: Either[String, List[DomainEvent]]  // expected events or error
    )

    // TODO: Implement test runner for commands
    def runCommandTest(testCase: CommandTestCase): Either[String, Boolean] = ???

    // Projection testing: given events, assert read model state
    case class ProjectionTestCase(
      events: List[DomainEvent],
      expectedReadModel: OrderReadModel
    )

    def runProjectionTest(testCase: ProjectionTestCase): Either[String, Boolean] = ???

    // End-to-end CQRS test
    def testCommandToQueryFlow(command: Command, expectedQueryResult: OrderReadModel): Either[String, Boolean] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch018: CQRS Implementation ===")
    println()
    println("Exercise 1: Command Handler")
    println("Exercise 2: Query Handler")
    println("Exercise 3: Command Validation")
    println("Exercise 4: Event Publisher (CQRS Bridge)")
    println("Exercise 5: Read Model Projection")
    println("Exercise 6: Eventual Consistency")
    println("Exercise 7: CQRS with Kafka Concept")
    println("Exercise 8: CQRS Testing")
  }
}
