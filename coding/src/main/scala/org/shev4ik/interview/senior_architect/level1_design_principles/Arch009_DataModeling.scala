package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Data Modeling
 *
 * Senior/Architect focus:
 * - Event schema design and evolution
 * - CQRS read/write model separation
 * - Schema evolution and compatibility strategies
 */
object Arch009_DataModeling {

  // ============================================================
  // Exercise 1: Event Schema Design
  // ============================================================
  // TODO: Design event schemas for an e-commerce domain.
  //  Events should be immutable facts about what happened.
  //  Include metadata for tracing, versioning, and ordering.

  case class EventMetadata(
    eventId: String,
    eventType: String,
    aggregateId: String,
    aggregateType: String,
    version: Int,
    timestamp: Long,
    correlationId: String,
    causationId: String,
    userId: Option[String]
  )

  sealed trait DomainEvent {
    def metadata: EventMetadata
  }

  // TODO: Design order events
  case class OrderCreated(
    metadata: EventMetadata,
    customerId: String,
    items: List[OrderItemEvent]
  ) extends DomainEvent

  case class OrderItemEvent(productId: String, quantity: Int, unitPrice: BigDecimal)

  case class OrderPaid(
    metadata: EventMetadata,
    paymentId: String,
    amount: BigDecimal,
    method: String
  ) extends DomainEvent

  case class OrderShipped(
    metadata: EventMetadata,
    trackingNumber: String,
    carrier: String,
    estimatedDelivery: String
  ) extends DomainEvent

  case class OrderCancelled(
    metadata: EventMetadata,
    reason: String,
    cancelledBy: String
  ) extends DomainEvent

  // TODO: Implement event builder with proper metadata
  def createEvent(aggregateId: String, aggregateType: String, correlationId: String): EventMetadata = ???

  // ============================================================
  // Exercise 2: CQRS Read/Write Models
  // ============================================================
  // TODO: Design separate read and write models for an order system.
  //  Write model optimized for business rules and invariants.
  //  Read model optimized for queries and display.

  // Write Model: enforces business rules
  object WriteModel {
    case class OrderAggregate(
      id: String,
      customerId: String,
      items: List[OrderItem],
      status: OrderStatus,
      version: Int
    ) {
      def addItem(item: OrderItem): Either[String, (OrderAggregate, DomainEvent)] = ???
      def submit(): Either[String, (OrderAggregate, DomainEvent)] = ???
      def cancel(reason: String): Either[String, (OrderAggregate, DomainEvent)] = ???
    }

    case class OrderItem(productId: String, quantity: Int, unitPrice: BigDecimal)
    sealed trait OrderStatus
    case object Draft extends OrderStatus
    case object Submitted extends OrderStatus
    case object Paid extends OrderStatus
    case object Cancelled extends OrderStatus
  }

  // Read Model: optimized for display
  object ReadModel {
    // Denormalized for fast querying
    case class OrderSummary(
      orderId: String,
      customerName: String,
      customerEmail: String,
      totalAmount: BigDecimal,
      itemCount: Int,
      status: String,
      createdAt: String,
      lastUpdatedAt: String
    )

    case class OrderDetail(
      orderId: String,
      customerName: String,
      items: List[OrderItemView],
      subtotal: BigDecimal,
      tax: BigDecimal,
      total: BigDecimal,
      status: String,
      statusHistory: List[StatusChange],
      shippingAddress: Option[String]
    )

    case class OrderItemView(productName: String, quantity: Int, unitPrice: BigDecimal, lineTotal: BigDecimal)
    case class StatusChange(status: String, timestamp: String, changedBy: String)

    // TODO: Implement projection from events to read model
    def projectOrderSummary(events: List[DomainEvent]): Either[String, OrderSummary] = ???
    def projectOrderDetail(events: List[DomainEvent]): Either[String, OrderDetail] = ???
  }

  // ============================================================
  // Exercise 3: Denormalization Strategy
  // ============================================================
  // TODO: Design a denormalization strategy for read-optimized views.
  //  Trade storage space for query performance.

  // Normalized (write-optimized)
  object Normalized {
    case class Customer(id: String, name: String, email: String)
    case class Order(id: String, customerId: String, status: String)
    case class OrderLine(orderId: String, productId: String, quantity: Int)
    case class Product(id: String, name: String, price: BigDecimal)

    // Requires 4 JOINs to get order with customer and product details
    def getOrderView(orderId: String): String = ???
  }

  // Denormalized (read-optimized)
  object Denormalized {
    case class OrderView(
      orderId: String,
      customerName: String,
      customerEmail: String,
      items: List[OrderItemView],
      totalAmount: BigDecimal,
      status: String
    )
    case class OrderItemView(productName: String, quantity: Int, unitPrice: BigDecimal, lineTotal: BigDecimal)

    // Single read, no joins
    def getOrderView(orderId: String): Either[String, OrderView] = ???
  }

  // TODO: Design the denormalization update strategy
  trait DenormalizationUpdater {
    def onCustomerUpdated(customerId: String, name: String, email: String): Either[String, Unit] = ???
    def onProductUpdated(productId: String, name: String, price: BigDecimal): Either[String, Unit] = ???
    def onOrderCreated(event: OrderCreated): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 4: Schema Evolution
  // ============================================================
  // TODO: Design a schema evolution strategy that handles
  //  adding fields, removing fields, renaming fields, and
  //  changing field types across versions.

  // Schema version tracking
  case class SchemaVersion(version: Int, changes: List[SchemaChange])

  sealed trait SchemaChange
  case class AddField(name: String, fieldType: String, defaultValue: Option[String]) extends SchemaChange
  case class RemoveField(name: String) extends SchemaChange
  case class RenameField(oldName: String, newName: String) extends SchemaChange
  case class ChangeType(name: String, oldType: String, newType: String, migration: String) extends SchemaChange

  // TODO: Implement schema migration
  trait SchemaMigrator {
    def migrate(data: Map[String, Any], fromVersion: Int, toVersion: Int): Either[String, Map[String, Any]]
    def canMigrate(fromVersion: Int, toVersion: Int): Boolean
  }

  class EventSchemaMigrator(versions: List[SchemaVersion]) extends SchemaMigrator {
    def migrate(data: Map[String, Any], fromVersion: Int, toVersion: Int): Either[String, Map[String, Any]] = ???
    def canMigrate(fromVersion: Int, toVersion: Int): Boolean = ???
  }

  // ============================================================
  // Exercise 5: Backward/Forward Compatibility
  // ============================================================
  // TODO: Design data schemas with backward and forward compatibility.
  //  New readers can read old data (backward).
  //  Old readers can read new data (forward).

  // Strategy: optional fields, default values, unknown field tolerance
  case class EventEnvelope(
    schemaVersion: Int,
    eventType: String,
    payload: Map[String, Any],   // flexible payload
    metadata: Map[String, Any]
  )

  // TODO: Implement a tolerant reader that handles missing/extra fields
  trait TolerantReader[A] {
    def read(envelope: EventEnvelope): Either[String, A]
    def supportedVersions: Range
  }

  // TODO: Implement for OrderCreated across versions
  // V1: {customerId, items}
  // V2: {customerId, items, shippingAddress}  -- added field
  // V3: {customerId, items, shippingAddress, priority}  -- added field
  class OrderCreatedReader extends TolerantReader[OrderCreated] {
    def read(envelope: EventEnvelope): Either[String, OrderCreated] = ???
    def supportedVersions: Range = ???
  }

  // ============================================================
  // Exercise 6: Data Migration Strategy
  // ============================================================
  // TODO: Design a data migration strategy for evolving schemas
  //  in production. Handle large datasets, rollback, and validation.

  sealed trait MigrationStatus
  case object Pending extends MigrationStatus
  case object Running extends MigrationStatus
  case object Completed extends MigrationStatus
  case object Failed extends MigrationStatus
  case object RolledBack extends MigrationStatus

  case class Migration(
    id: String,
    version: Int,
    description: String,
    status: MigrationStatus,
    upScript: String,
    downScript: String,
    checksum: String,
    appliedAt: Option[Long]
  )

  trait MigrationRunner {
    def pendingMigrations(): Either[String, List[Migration]]
    def applyMigration(migration: Migration): Either[String, Unit]
    def rollbackMigration(migration: Migration): Either[String, Unit]
    def validateSchema(): Either[String, Boolean]
  }

  // TODO: Implement a migration runner with safety checks
  class SafeMigrationRunner extends MigrationRunner {
    def pendingMigrations(): Either[String, List[Migration]] = ???
    def applyMigration(migration: Migration): Either[String, Unit] = ???
    def rollbackMigration(migration: Migration): Either[String, Unit] = ???
    def validateSchema(): Either[String, Boolean] = ???

    // Safety: dry-run mode
    def dryRun(migration: Migration): Either[String, String] = ???
  }

  // ============================================================
  // Exercise 7: Temporal Data Modeling
  // ============================================================
  // TODO: Design temporal data models that track how data changes
  //  over time. Support "as-of" queries and bi-temporal modeling.

  // Uni-temporal: tracks when data was valid in business time
  case class TemporalRecord[A](
    data: A,
    validFrom: Long,
    validTo: Option[Long],    // None = currently valid
    recordedAt: Long
  )

  // Bi-temporal: tracks both business time and system time
  case class BiTemporalRecord[A](
    data: A,
    validFrom: Long,          // business time start
    validTo: Option[Long],    // business time end
    transactionFrom: Long,    // system time start (when recorded)
    transactionTo: Option[Long] // system time end (when superseded)
  )

  // TODO: Implement temporal queries
  trait TemporalRepository[A] {
    def save(record: TemporalRecord[A]): Either[String, Unit]
    def asOf(businessTime: Long): Either[String, Option[A]]
    def history(): Either[String, List[TemporalRecord[A]]]
    def validAt(from: Long, to: Long): Either[String, List[TemporalRecord[A]]]
  }

  // TODO: Implement price history with temporal modeling
  case class ProductPrice(productId: String, price: BigDecimal, currency: String)

  class TemporalPriceRepository extends TemporalRepository[ProductPrice] {
    def save(record: TemporalRecord[ProductPrice]): Either[String, Unit] = ???
    def asOf(businessTime: Long): Either[String, Option[ProductPrice]] = ???
    def history(): Either[String, List[TemporalRecord[ProductPrice]]] = ???
    def validAt(from: Long, to: Long): Either[String, List[TemporalRecord[ProductPrice]]] = ???
  }

  // ============================================================
  // Exercise 8: Audit Trail Design
  // ============================================================
  // TODO: Design an audit trail system that records who did what,
  //  when, and why. Support regulatory compliance requirements.

  case class AuditEntry(
    id: String,
    timestamp: Long,
    actor: AuditActor,
    action: String,
    resource: AuditResource,
    changes: List[FieldChange],
    reason: Option[String],
    ipAddress: Option[String],
    correlationId: String
  )

  sealed trait AuditActor
  case class UserActor(userId: String, username: String, roles: Set[String]) extends AuditActor
  case class SystemActor(serviceName: String, processId: String) extends AuditActor

  case class AuditResource(resourceType: String, resourceId: String, resourceName: Option[String])
  case class FieldChange(field: String, oldValue: Option[String], newValue: Option[String])

  trait AuditTrail {
    def record(entry: AuditEntry): Either[String, Unit]
    def getHistory(resourceType: String, resourceId: String): Either[String, List[AuditEntry]]
    def getByActor(actorId: String, from: Long, to: Long): Either[String, List[AuditEntry]]
    def search(query: AuditQuery): Either[String, List[AuditEntry]]
  }

  case class AuditQuery(
    resourceType: Option[String],
    actorId: Option[String],
    action: Option[String],
    from: Option[Long],
    to: Option[Long],
    limit: Int = 100
  )

  // TODO: Implement an append-only audit trail
  class ImmutableAuditTrail extends AuditTrail {
    def record(entry: AuditEntry): Either[String, Unit] = ???
    def getHistory(resourceType: String, resourceId: String): Either[String, List[AuditEntry]] = ???
    def getByActor(actorId: String, from: Long, to: Long): Either[String, List[AuditEntry]] = ???
    def search(query: AuditQuery): Either[String, List[AuditEntry]] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch009: Data Modeling ===")
    println()
    println("Exercise 1: Event Schema Design")
    println("Exercise 2: CQRS Read/Write Models")
    println("Exercise 3: Denormalization Strategy")
    println("Exercise 4: Schema Evolution")
    println("Exercise 5: Backward/Forward Compatibility")
    println("Exercise 6: Data Migration Strategy")
    println("Exercise 7: Temporal Data Modeling")
    println("Exercise 8: Audit Trail Design")
  }
}
