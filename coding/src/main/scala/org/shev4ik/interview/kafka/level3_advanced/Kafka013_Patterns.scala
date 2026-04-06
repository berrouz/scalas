package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka 013 - Kafka Patterns (6 exercises)
 *
 * Common architectural patterns built on Kafka:
 *   - Event Sourcing: store state changes as an immutable event log
 *   - CQRS: separate read and write models, Kafka as the bridge
 *   - Outbox Pattern: reliably publish events from a database transaction
 *   - Saga Pattern: distributed transactions via choreography or orchestration
 *   - Change Data Capture (CDC): stream database changes to Kafka
 *   - Dead Letter Topic: handle poison pills and processing failures
 */
object Kafka013_Patterns {

  // --- Domain models ---

  // Event Sourcing
  sealed trait AccountEvent
  object AccountEvent {
    case class Created(accountId: String, owner: String)            extends AccountEvent
    case class Deposited(accountId: String, amount: Double)         extends AccountEvent
    case class Withdrawn(accountId: String, amount: Double)         extends AccountEvent
    case class Closed(accountId: String)                            extends AccountEvent
  }

  case class AccountState(
    accountId: String,
    owner: String,
    balance: Double,
    isOpen: Boolean
  )

  // CQRS
  sealed trait Command
  object Command {
    case class CreateOrder(orderId: String, product: String, qty: Int)  extends Command
    case class UpdateOrder(orderId: String, newQty: Int)                extends Command
    case class CancelOrder(orderId: String)                            extends Command
  }

  sealed trait Event
  object Event {
    case class OrderCreated(orderId: String, product: String, qty: Int) extends Event
    case class OrderUpdated(orderId: String, newQty: Int)               extends Event
    case class OrderCancelled(orderId: String)                          extends Event
  }

  case class OrderReadModel(orderId: String, product: String, qty: Int, status: String)

  // Outbox Pattern
  case class OutboxEntry(
    id: Long,
    aggregateType: String,
    aggregateId: String,
    eventType: String,
    payload: String,
    published: Boolean
  )

  // Saga Pattern
  sealed trait SagaStep
  object SagaStep {
    case class Execute(name: String, action: String)     extends SagaStep
    case class Compensate(name: String, action: String)  extends SagaStep
  }

  sealed trait SagaState
  object SagaState {
    case object Pending     extends SagaState
    case object Running     extends SagaState
    case object Completed   extends SagaState
    case object Compensating extends SagaState
    case object Failed      extends SagaState
  }

  case class Saga(
    sagaId: String,
    steps: List[SagaStep],
    completedSteps: List[String],
    state: SagaState
  )

  // CDC
  case class CdcEvent(
    table: String,
    operation: String, // "INSERT", "UPDATE", "DELETE"
    before: Option[Map[String, String]],
    after: Option[Map[String, String]],
    timestamp: Long
  )

  // Dead Letter
  case class DeadLetterRecord(
    originalTopic: String,
    originalPartition: Int,
    originalOffset: Long,
    errorMessage: String,
    retryCount: Int,
    value: String
  )

  // Exercise 1: Event Sourcing - Rebuild account state from events
  // TODO: Given a list of AccountEvents, fold them into an AccountState.
  //   Start with AccountState("", "", 0.0, false).
  //   Created(id, owner) -> AccountState(id, owner, 0.0, true)
  //   Deposited(_, amt)  -> add amt to balance (only if isOpen)
  //   Withdrawn(_, amt)  -> subtract amt from balance (only if isOpen and balance >= amt)
  //   Closed(_)          -> set isOpen = false
  def exercise1_rebuildState(events: List[AccountEvent]): AccountState = ???

  // Exercise 2: CQRS - Convert commands to events and build read model
  // TODO: Given a list of Commands, convert each to the corresponding Event:
  //   CreateOrder(id, p, q) -> OrderCreated(id, p, q)
  //   UpdateOrder(id, q)    -> OrderUpdated(id, q)
  //   CancelOrder(id)       -> OrderCancelled(id)
  //   Then fold events into a Map[String, OrderReadModel]:
  //   OrderCreated -> add entry with status "ACTIVE"
  //   OrderUpdated -> update qty, keep status
  //   OrderCancelled -> set status to "CANCELLED"
  //   Return (events, readModels).
  def exercise2_cqrs(
    commands: List[Command]
  ): (List[Event], Map[String, OrderReadModel]) = ???

  // Exercise 3: Outbox Pattern - Process outbox entries
  // TODO: Given a list of OutboxEntry, return a tuple:
  //   (toPublish, alreadyPublished) where toPublish are entries with published=false
  //   and alreadyPublished are entries with published=true.
  //   Also mark the toPublish entries as published=true in the returned list.
  def exercise3_processOutbox(
    entries: List[OutboxEntry]
  ): (List[OutboxEntry], List[OutboxEntry]) = ???

  // Exercise 4: Saga Pattern - Execute saga steps with compensation on failure
  // TODO: Given a Saga and a function that processes each step name and returns
  //   Either[String, String] (Left=error, Right=success), execute steps in order.
  //   On success: add step name to completedSteps, continue.
  //   On failure: stop, set state to Compensating, and build compensation steps
  //     for all completed steps (in reverse order).
  //   Return the updated Saga. If all succeed, state = Completed.
  //   Compensation steps are SagaStep.Compensate with name = "compensate-{stepName}"
  //   and action = "undo".
  def exercise4_executeSaga(
    saga: Saga,
    executor: String => Either[String, String]
  ): Saga = ???

  // Exercise 5: CDC - Transform CDC events into Kafka producer records
  // TODO: Given a list of CdcEvents, transform them into a list of (topic, key, value) tuples:
  //   topic = "cdc-{table}"
  //   key = the "id" field from `after` (for INSERT/UPDATE) or `before` (for DELETE), or "unknown"
  //   value = operation + ":" + after.getOrElse(before.getOrElse(Map())).mkString(",")
  //     where map entries are formatted as "k=v" and sorted by key
  def exercise5_cdcToRecords(
    events: List[CdcEvent]
  ): List[(String, String, String)] = ???

  // Exercise 6: Dead Letter Topic - Manage retry and DLQ routing
  // TODO: Given a DeadLetterRecord and maxRetries,
  //   if retryCount < maxRetries, return Left(record with retryCount + 1) meaning "retry"
  //   if retryCount >= maxRetries, return Right(record) meaning "send to final DLQ"
  def exercise6_deadLetterRouting(
    record: DeadLetterRecord,
    maxRetries: Int
  ): Either[DeadLetterRecord, DeadLetterRecord] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val events = List(
      AccountEvent.Created("acc-1", "Alice"),
      AccountEvent.Deposited("acc-1", 100.0),
      AccountEvent.Withdrawn("acc-1", 30.0),
      AccountEvent.Deposited("acc-1", 50.0)
    )
    val state = exercise1_rebuildState(events)
    assert(state.accountId == "acc-1", "Exercise 1 failed: wrong id")
    assert(state.balance == 120.0, s"Exercise 1 failed: balance=${state.balance}")
    assert(state.isOpen, "Exercise 1 failed: should be open")

    val withClose = events :+ AccountEvent.Closed("acc-1")
    val closedState = exercise1_rebuildState(withClose)
    assert(!closedState.isOpen, "Exercise 1 failed: should be closed")

    val overdraft = List(AccountEvent.Created("a", "B"), AccountEvent.Withdrawn("a", 100.0))
    val odState = exercise1_rebuildState(overdraft)
    assert(odState.balance == 0.0, "Exercise 1 failed: withdrawal should fail on 0 balance")
    println("Exercise 1 passed: event sourcing rebuild")

    // Exercise 2
    val commands = List(
      Command.CreateOrder("o1", "Widget", 5),
      Command.UpdateOrder("o1", 10),
      Command.CreateOrder("o2", "Gadget", 3),
      Command.CancelOrder("o1")
    )
    val (evts, readModels) = exercise2_cqrs(commands)
    assert(evts.length == 4, "Exercise 2 failed: wrong event count")
    assert(readModels("o1").status == "CANCELLED", "Exercise 2 failed: o1 status")
    assert(readModels("o2").qty == 3, "Exercise 2 failed: o2 qty")
    println("Exercise 2 passed: CQRS")

    // Exercise 3
    val outbox = List(
      OutboxEntry(1, "Order", "o1", "created", "{}", false),
      OutboxEntry(2, "Order", "o2", "created", "{}", true),
      OutboxEntry(3, "Order", "o3", "created", "{}", false)
    )
    val (toPublish, alreadyPublished) = exercise3_processOutbox(outbox)
    assert(toPublish.length == 2, "Exercise 3 failed: wrong toPublish count")
    assert(toPublish.forall(_.published), "Exercise 3 failed: should be marked published")
    assert(alreadyPublished.length == 1, "Exercise 3 failed: wrong alreadyPublished count")
    println("Exercise 3 passed: outbox pattern")

    // Exercise 4
    val saga = Saga("s1",
      List(SagaStep.Execute("reserve", "reserve-inventory"), SagaStep.Execute("charge", "charge-payment")),
      Nil, SagaState.Pending
    )
    val successSaga = exercise4_executeSaga(saga, _ => Right("ok"))
    assert(successSaga.state == SagaState.Completed, "Exercise 4 failed: should be completed")
    assert(successSaga.completedSteps == List("reserve", "charge"), "Exercise 4 failed")

    val failSaga = exercise4_executeSaga(saga, name => if (name == "charge") Left("declined") else Right("ok"))
    assert(failSaga.state == SagaState.Compensating, "Exercise 4 failed: should be compensating")
    assert(failSaga.completedSteps == List("reserve"), "Exercise 4 failed: only reserve completed")
    println("Exercise 4 passed: saga pattern")

    // Exercise 5
    val cdcEvents = List(
      CdcEvent("users", "INSERT", None, Some(Map("id" -> "1", "name" -> "Alice")), 100L),
      CdcEvent("users", "DELETE", Some(Map("id" -> "2", "name" -> "Bob")), None, 200L)
    )
    val records = exercise5_cdcToRecords(cdcEvents)
    assert(records.head._1 == "cdc-users", "Exercise 5 failed: wrong topic")
    assert(records.head._2 == "1", "Exercise 5 failed: wrong key")
    assert(records(1)._2 == "2", "Exercise 5 failed: wrong delete key")
    println("Exercise 5 passed: CDC records")

    // Exercise 6
    val dlr = DeadLetterRecord("orders", 0, 100, "parse error", 1, "bad data")
    val retry = exercise6_deadLetterRouting(dlr, 3)
    assert(retry.isLeft, "Exercise 6 failed: should retry")
    assert(retry.left.get.retryCount == 2, "Exercise 6 failed: wrong retry count")

    val maxedOut = exercise6_deadLetterRouting(dlr.copy(retryCount = 3), 3)
    assert(maxedOut.isRight, "Exercise 6 failed: should go to DLQ")
    println("Exercise 6 passed: dead letter routing")

    println("\nAll Kafka013_Patterns exercises passed!")
  }
}
