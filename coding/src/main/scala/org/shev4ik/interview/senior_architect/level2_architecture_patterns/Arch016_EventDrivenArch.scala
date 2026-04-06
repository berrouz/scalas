package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Event-Driven Architecture
 *
 * Senior/Architect focus:
 * - Event publishing and subscribing patterns
 * - Event store design and replay
 * - Eventual consistency and ordering
 */
object Arch016_EventDrivenArch {

  // ============================================================
  // Exercise 1: Event Publisher
  // ============================================================
  // TODO: Design an event publisher that supports multiple
  //  topics, partitioning, and delivery guarantees.

  case class EventEnvelope(
    eventId: String,
    eventType: String,
    topic: String,
    partitionKey: String,
    payload: String,        // serialized event data
    metadata: EventMetadata,
    timestamp: Long
  )

  case class EventMetadata(
    correlationId: String,
    causationId: String,
    source: String,
    schemaVersion: Int,
    headers: Map[String, String] = Map.empty
  )

  sealed trait DeliveryGuarantee
  case object AtMostOnce extends DeliveryGuarantee
  case object AtLeastOnce extends DeliveryGuarantee
  case object ExactlyOnce extends DeliveryGuarantee

  trait EventPublisher {
    def publish(event: EventEnvelope): Either[String, Unit]
    def publishBatch(events: List[EventEnvelope]): Either[String, Unit]
    def publishWithGuarantee(event: EventEnvelope, guarantee: DeliveryGuarantee): Either[String, Unit]
  }

  // TODO: Implement event publisher with partitioning
  class PartitionedEventPublisher(numPartitions: Int) extends EventPublisher {
    def publish(event: EventEnvelope): Either[String, Unit] = ???
    def publishBatch(events: List[EventEnvelope]): Either[String, Unit] = ???
    def publishWithGuarantee(event: EventEnvelope, guarantee: DeliveryGuarantee): Either[String, Unit] = ???
    private def resolvePartition(partitionKey: String): Int = ???
  }

  // ============================================================
  // Exercise 2: Event Subscriber
  // ============================================================
  // TODO: Design an event subscriber with consumer groups,
  //  offset management, and error handling.

  trait EventHandler {
    def handle(event: EventEnvelope): Either[String, Unit]
    def eventTypes: Set[String]  // which event types this handler processes
  }

  case class SubscriptionConfig(
    topic: String,
    consumerGroup: String,
    maxRetries: Int,
    retryDelayMs: Long,
    batchSize: Int
  )

  trait EventSubscriber {
    def subscribe(config: SubscriptionConfig, handler: EventHandler): Either[String, Unit]
    def unsubscribe(topic: String): Either[String, Unit]
    def pause(topic: String): Either[String, Unit]
    def resume(topic: String): Either[String, Unit]
  }

  // TODO: Implement event subscriber with retry logic
  class RetryingEventSubscriber extends EventSubscriber {
    def subscribe(config: SubscriptionConfig, handler: EventHandler): Either[String, Unit] = ???
    def unsubscribe(topic: String): Either[String, Unit] = ???
    def pause(topic: String): Either[String, Unit] = ???
    def resume(topic: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 3: Event Bus
  // ============================================================
  // TODO: Design an in-process event bus for decoupling components.
  //  Support synchronous and asynchronous delivery.

  trait EventBus {
    def publish(event: EventEnvelope): Either[String, Unit]
    def subscribe(eventType: String, handler: EventHandler): Either[String, String]  // returns subscription ID
    def unsubscribe(subscriptionId: String): Either[String, Unit]
    def subscriberCount(eventType: String): Int
  }

  // TODO: Implement an in-memory event bus
  class InMemoryEventBus extends EventBus {
    private val handlers = scala.collection.mutable.Map.empty[String, List[(String, EventHandler)]]

    def publish(event: EventEnvelope): Either[String, Unit] = ???
    def subscribe(eventType: String, handler: EventHandler): Either[String, String] = ???
    def unsubscribe(subscriptionId: String): Either[String, Unit] = ???
    def subscriberCount(eventType: String): Int = ???
  }

  // ============================================================
  // Exercise 4: Event Store
  // ============================================================
  // TODO: Design an event store that persists events in order.
  //  Support append, read stream, and global ordering.

  case class StreamPosition(value: Long)
  case class GlobalPosition(value: Long)

  trait EventStore {
    def append(streamId: String, events: List[EventEnvelope], expectedVersion: Long): Either[String, Long]
    def readStream(streamId: String, fromPosition: Long = 0): Either[String, List[EventEnvelope]]
    def readAll(fromPosition: GlobalPosition, maxCount: Int): Either[String, List[EventEnvelope]]
    def streamVersion(streamId: String): Either[String, Long]
  }

  // TODO: Implement an in-memory event store
  class InMemoryEventStore extends EventStore {
    def append(streamId: String, events: List[EventEnvelope], expectedVersion: Long): Either[String, Long] = ???
    def readStream(streamId: String, fromPosition: Long): Either[String, List[EventEnvelope]] = ???
    def readAll(fromPosition: GlobalPosition, maxCount: Int): Either[String, List[EventEnvelope]] = ???
    def streamVersion(streamId: String): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 5: Event Replay
  // ============================================================
  // TODO: Design event replay functionality for rebuilding state,
  //  fixing projections, or debugging. Include filtering and speed control.

  case class ReplayConfig(
    fromPosition: GlobalPosition,
    toPosition: Option[GlobalPosition],
    eventTypes: Option[Set[String]],
    speedMultiplier: Double,     // 1.0 = real-time, 10.0 = 10x speed
    batchSize: Int
  )

  case class ReplayProgress(
    currentPosition: GlobalPosition,
    totalEvents: Long,
    processedEvents: Long,
    errorCount: Long,
    startedAt: Long
  )

  trait EventReplayer {
    def startReplay(config: ReplayConfig, handler: EventHandler): Either[String, String]  // returns replay ID
    def getProgress(replayId: String): Either[String, ReplayProgress]
    def pauseReplay(replayId: String): Either[String, Unit]
    def cancelReplay(replayId: String): Either[String, Unit]
  }

  // TODO: Implement event replayer
  class SimpleEventReplayer(eventStore: EventStore) extends EventReplayer {
    def startReplay(config: ReplayConfig, handler: EventHandler): Either[String, String] = ???
    def getProgress(replayId: String): Either[String, ReplayProgress] = ???
    def pauseReplay(replayId: String): Either[String, Unit] = ???
    def cancelReplay(replayId: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 6: Event Versioning
  // ============================================================
  // TODO: Design event versioning strategy for schema evolution.
  //  Handle adding fields, renaming, and structural changes.

  trait EventUpgrader[From, To] {
    def upgrade(from: From): To
  }

  // Version 1 of OrderCreated
  case class OrderCreatedV1(orderId: String, customerId: String, total: BigDecimal)
  // Version 2: added items list
  case class OrderCreatedV2(orderId: String, customerId: String, total: BigDecimal, items: List[String])
  // Version 3: added shipping address
  case class OrderCreatedV3(orderId: String, customerId: String, total: BigDecimal, items: List[String], shippingAddress: Option[String])

  // TODO: Implement upgraders
  implicit val v1ToV2: EventUpgrader[OrderCreatedV1, OrderCreatedV2] = ???
  implicit val v2ToV3: EventUpgrader[OrderCreatedV2, OrderCreatedV3] = ???

  // TODO: Chain upgraders for multi-version jumps
  def upgradeEvent[A, B, C](event: A)(implicit ab: EventUpgrader[A, B], bc: EventUpgrader[B, C]): C = ???

  // ============================================================
  // Exercise 7: Event Ordering
  // ============================================================
  // TODO: Design event ordering guarantees. Handle partition-level
  //  ordering, causal ordering, and total ordering.

  sealed trait OrderingGuarantee
  case object NoOrdering extends OrderingGuarantee
  case object PartitionOrdering extends OrderingGuarantee  // ordered within partition key
  case object CausalOrdering extends OrderingGuarantee     // respects causal relationships
  case object TotalOrdering extends OrderingGuarantee       // global order

  // Causal ordering via vector clocks (simplified)
  case class VectorClock(clocks: Map[String, Long]) {
    def increment(nodeId: String): VectorClock = ???
    def merge(other: VectorClock): VectorClock = ???
    def happensBefore(other: VectorClock): Boolean = ???
    def concurrent(other: VectorClock): Boolean = ???
  }

  // TODO: Implement causal ordering
  class CausalEventOrderer {
    def addEvent(event: EventEnvelope, clock: VectorClock): Either[String, Unit] = ???
    def getOrderedEvents(): Either[String, List[EventEnvelope]] = ???
  }

  // ============================================================
  // Exercise 8: Eventual Consistency Handling
  // ============================================================
  // TODO: Design patterns for handling eventual consistency in
  //  event-driven systems. Include read-your-writes and conflict resolution.

  // Read-your-writes consistency
  trait ConsistencyGuarantee {
    def waitForConsistency(streamId: String, expectedVersion: Long, timeoutMs: Long): Either[String, Boolean]
  }

  // Conflict resolution strategies
  sealed trait ConflictResolution
  case object LastWriterWins extends ConflictResolution
  case object FirstWriterWins extends ConflictResolution
  case class MergeStrategy(merge: (Any, Any) => Any) extends ConflictResolution
  case class CustomResolution(resolve: (List[EventEnvelope]) => EventEnvelope) extends ConflictResolution

  // TODO: Implement eventual consistency handler
  class EventualConsistencyManager(
    eventStore: EventStore,
    resolutionStrategy: ConflictResolution
  ) {
    def handleConflict(streamId: String, conflictingEvents: List[EventEnvelope]): Either[String, EventEnvelope] = ???
    def ensureConsistency(streamId: String, timeoutMs: Long): Either[String, Boolean] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch016: Event-Driven Architecture ===")
    println()
    println("Exercise 1: Event Publisher")
    println("Exercise 2: Event Subscriber")
    println("Exercise 3: Event Bus")
    println("Exercise 4: Event Store")
    println("Exercise 5: Event Replay")
    println("Exercise 6: Event Versioning")
    println("Exercise 7: Event Ordering")
    println("Exercise 8: Eventual Consistency Handling")
  }
}
