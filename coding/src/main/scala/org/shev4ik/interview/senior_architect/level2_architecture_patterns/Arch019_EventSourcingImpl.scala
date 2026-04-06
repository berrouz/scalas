package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Event Sourcing Implementation
 *
 * Senior/Architect focus:
 * - Event store and aggregate reconstruction
 * - Snapshots, upcasting, and projection rebuilding
 * - Saga coordination for distributed workflows
 */
object Arch019_EventSourcingImpl {

  // ============================================================
  // Exercise 1: Event Store Interface
  // ============================================================
  sealed trait ESEvent {
    def eventId: String
    def aggregateId: String
    def aggregateType: String
    def version: Long
    def timestamp: Long
    def data: Map[String, Any]
  }

  case class StoredEvent(
    eventId: String,
    aggregateId: String,
    aggregateType: String,
    eventType: String,
    version: Long,
    timestamp: Long,
    data: Map[String, Any],
    metadata: Map[String, String]
  ) extends ESEvent

  trait EventStoreES {
    def append(aggregateId: String, events: List[StoredEvent], expectedVersion: Long): Either[String, Long]
    def load(aggregateId: String): Either[String, List[StoredEvent]]
    def loadFromVersion(aggregateId: String, fromVersion: Long): Either[String, List[StoredEvent]]
    def readAll(fromPosition: Long, maxCount: Int): Either[String, List[StoredEvent]]
  }

  // TODO: Implement in-memory event store with optimistic concurrency
  class InMemoryEventStoreES extends EventStoreES {
    def append(aggregateId: String, events: List[StoredEvent], expectedVersion: Long): Either[String, Long] = ???
    def load(aggregateId: String): Either[String, List[StoredEvent]] = ???
    def loadFromVersion(aggregateId: String, fromVersion: Long): Either[String, List[StoredEvent]] = ???
    def readAll(fromPosition: Long, maxCount: Int): Either[String, List[StoredEvent]] = ???
  }

  // ============================================================
  // Exercise 2: Aggregate with Events
  // ============================================================
  // TODO: Design an event-sourced aggregate. State is rebuilt
  //  by replaying events. Commands produce new events.

  case class OrderState(
    id: String,
    customerId: String,
    items: List[(String, Int, BigDecimal)],
    status: String,
    version: Long
  )

  object OrderState {
    def initial(id: String): OrderState = OrderState(id, "", List.empty, "draft", 0)
  }

  trait EventSourcedAggregate[S, E, C] {
    def initialState(id: String): S
    def applyEvent(state: S, event: E): S
    def handleCommand(state: S, command: C): Either[String, List[E]]
  }

  // TODO: Implement event-sourced Order aggregate
  sealed trait OrderESEvent
  case class OrderCreatedES(customerId: String) extends OrderESEvent
  case class ItemAddedES(productId: String, quantity: Int, price: BigDecimal) extends OrderESEvent
  case class OrderSubmittedES(timestamp: Long) extends OrderESEvent
  case class OrderCancelledES(reason: String) extends OrderESEvent

  sealed trait OrderESCommand
  case class CreateOrderES(customerId: String) extends OrderESCommand
  case class AddItemES(productId: String, quantity: Int, price: BigDecimal) extends OrderESCommand
  case object SubmitOrderES extends OrderESCommand
  case class CancelOrderES(reason: String) extends OrderESCommand

  object OrderAggregate extends EventSourcedAggregate[OrderState, OrderESEvent, OrderESCommand] {
    def initialState(id: String): OrderState = ???
    def applyEvent(state: OrderState, event: OrderESEvent): OrderState = ???
    def handleCommand(state: OrderState, command: OrderESCommand): Either[String, List[OrderESEvent]] = ???
  }

  // ============================================================
  // Exercise 3: Event Handler
  // ============================================================
  trait EventHandler[E] {
    def handle(event: E): Either[String, Unit]
    def eventTypes: Set[String]
  }

  class OrderProjectionHandler extends EventHandler[StoredEvent] {
    private val projections = scala.collection.mutable.Map.empty[String, Map[String, Any]]

    def handle(event: StoredEvent): Either[String, Unit] = ???
    def eventTypes: Set[String] = ???
    def getProjection(aggregateId: String): Option[Map[String, Any]] = ???
  }

  // ============================================================
  // Exercise 4: Snapshot Strategy
  // ============================================================
  // TODO: Design snapshot strategy to avoid replaying all events.
  //  Take snapshots at intervals and replay from last snapshot.

  case class Snapshot[S](
    aggregateId: String,
    state: S,
    version: Long,
    timestamp: Long
  )

  trait SnapshotStore[S] {
    def save(snapshot: Snapshot[S]): Either[String, Unit]
    def load(aggregateId: String): Either[String, Option[Snapshot[S]]]
  }

  // TODO: Implement aggregate loading with snapshots
  class SnapshotAwareRepository[S](
    eventStore: EventStoreES,
    snapshotStore: SnapshotStore[S],
    aggregate: EventSourcedAggregate[S, StoredEvent, _],
    snapshotEvery: Int
  ) {
    def load(aggregateId: String): Either[String, S] = ???
    def save(aggregateId: String, events: List[StoredEvent], currentState: S, currentVersion: Long): Either[String, Unit] = ???
    private def shouldTakeSnapshot(version: Long): Boolean = ???
  }

  // ============================================================
  // Exercise 5: Event Replay
  // ============================================================
  // TODO: Implement event replay for rebuilding projections,
  //  debugging, and temporal queries.

  trait EventReplayer {
    def replayAll(handler: StoredEvent => Either[String, Unit]): Either[String, Long]
    def replayFrom(position: Long, handler: StoredEvent => Either[String, Unit]): Either[String, Long]
    def replayAggregate(aggregateId: String, handler: StoredEvent => Either[String, Unit]): Either[String, Long]
    def replayRange(from: Long, to: Long, handler: StoredEvent => Either[String, Unit]): Either[String, Long]
  }

  class SimpleEventReplayer(eventStore: EventStoreES) extends EventReplayer {
    def replayAll(handler: StoredEvent => Either[String, Unit]): Either[String, Long] = ???
    def replayFrom(position: Long, handler: StoredEvent => Either[String, Unit]): Either[String, Long] = ???
    def replayAggregate(aggregateId: String, handler: StoredEvent => Either[String, Unit]): Either[String, Long] = ???
    def replayRange(from: Long, to: Long, handler: StoredEvent => Either[String, Unit]): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 6: Event Upcasting
  // ============================================================
  // TODO: Design event upcasting for schema evolution.
  //  Old events are transformed to the current schema on read.

  trait EventUpcaster {
    def canUpcast(eventType: String, fromVersion: Int): Boolean
    def upcast(event: StoredEvent): StoredEvent
  }

  // TODO: Implement upcasting chain
  class UpcasterChain(upcasters: List[EventUpcaster]) {
    def upcast(event: StoredEvent): StoredEvent = ???
  }

  // Example: OrderCreated v1 -> v2 -> v3
  class OrderCreatedV1ToV2Upcaster extends EventUpcaster {
    def canUpcast(eventType: String, fromVersion: Int): Boolean = ???
    def upcast(event: StoredEvent): StoredEvent = ???
  }

  // ============================================================
  // Exercise 7: Projection Rebuilding
  // ============================================================
  trait Projection {
    def name: String
    def handleEvent(event: StoredEvent): Either[String, Unit]
    def reset(): Either[String, Unit]
    def currentPosition: Long
  }

  class ProjectionManager(eventStore: EventStoreES, projections: List[Projection]) {
    def rebuildProjection(projectionName: String): Either[String, Long] = ???
    def rebuildAll(): Either[String, Map[String, Long]] = ???
    def getProjectionLag(projectionName: String): Either[String, Long] = ???
    def startCatchUp(projectionName: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 8: Saga Coordination
  // ============================================================
  // TODO: Design a saga for coordinating distributed transactions.
  //  Each step has a compensating action for rollback.

  sealed trait SagaStepStatus
  case object StepPending extends SagaStepStatus
  case object StepCompleted extends SagaStepStatus
  case object StepFailed extends SagaStepStatus
  case object StepCompensated extends SagaStepStatus

  case class SagaStep(
    name: String,
    execute: () => Either[String, Unit],
    compensate: () => Either[String, Unit],
    status: SagaStepStatus
  )

  sealed trait SagaStatus
  case object SagaRunning extends SagaStatus
  case object SagaCompleted extends SagaStatus
  case object SagaCompensating extends SagaStatus
  case object SagaCompensated extends SagaStatus
  case object SagaFailed extends SagaStatus

  case class Saga(
    id: String,
    steps: List[SagaStep],
    status: SagaStatus,
    currentStep: Int,
    startedAt: Long
  )

  trait SagaCoordinator {
    def startSaga(id: String, steps: List[SagaStep]): Either[String, Saga]
    def getSagaStatus(id: String): Either[String, Saga]
  }

  // TODO: Implement saga coordinator with compensation
  class SimpleSagaCoordinator extends SagaCoordinator {
    def startSaga(id: String, steps: List[SagaStep]): Either[String, Saga] = ???
    def getSagaStatus(id: String): Either[String, Saga] = ???
    private def compensate(saga: Saga, failedAt: Int): Either[String, Saga] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch019: Event Sourcing Implementation ===")
    println()
    println("Exercise 1: Event Store Interface")
    println("Exercise 2: Aggregate with Events")
    println("Exercise 3: Event Handler")
    println("Exercise 4: Snapshot Strategy")
    println("Exercise 5: Event Replay")
    println("Exercise 6: Event Upcasting")
    println("Exercise 7: Projection Rebuilding")
    println("Exercise 8: Saga Coordination")
  }
}
