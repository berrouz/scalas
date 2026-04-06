package org.shev4ik.interview.system_design.level2_patterns

object SysDes006_EventSourcing {

  // ---- Domain types ----

  sealed trait BankEvent
  case class AccountCreated(accountId: String, timestamp: Long) extends BankEvent
  case class MoneyDeposited(accountId: String, amount: Double, timestamp: Long) extends BankEvent
  case class MoneyWithdrawn(accountId: String, amount: Double, timestamp: Long) extends BankEvent

  case class AccountState(accountId: String, balance: Double, isOpen: Boolean)

  sealed trait BankCommand
  case class CreateAccount(accountId: String) extends BankCommand
  case class Deposit(accountId: String, amount: Double) extends BankCommand
  case class Withdraw(accountId: String, amount: Double) extends BankCommand

  case class Snapshot[S](state: S, eventIndex: Int, timestamp: Long)

  // ---- Exercise 1 ----
  // TODO: Implement an event store.
  // - `append(event)`: add an event to the store, return updated store
  // - `events`: return all events in order
  // - `eventsForAggregate(aggregateId)`: return events for a specific aggregate
  //   (use the accountId from each event)
  // - `eventsSince(index)`: return events from index (0-based) onward
  trait EventStore {
    def append(event: BankEvent): EventStore
    def events: List[BankEvent]
    def eventsForAggregate(aggregateId: String): List[BankEvent]
    def eventsSince(index: Int): List[BankEvent]
    def size: Int
  }

  def createEventStore(): EventStore = ???

  // ---- Exercise 2 ----
  // TODO: Implement event replay to reconstruct state.
  // Given a list of events, fold them to produce the final AccountState.
  // Start from AccountState("", 0.0, isOpen=false).
  // - AccountCreated => set accountId, isOpen=true
  // - MoneyDeposited => add amount to balance
  // - MoneyWithdrawn => subtract amount from balance
  def replayEvents(events: List[BankEvent]): AccountState = ???

  // ---- Exercise 3 ----
  // TODO: Implement snapshotting.
  // Given an event store and a snapshot interval, produce snapshots.
  // `createSnapshot(events, upToIndex)`: replay events[0..upToIndex] and produce a Snapshot.
  // `replayFromSnapshot(snapshot, remainingEvents)`: start from snapshot state and replay.
  def createSnapshot(events: List[BankEvent], upToIndex: Int): Snapshot[AccountState] = ???

  def replayFromSnapshot(snapshot: Snapshot[AccountState], remainingEvents: List[BankEvent]): AccountState = ???

  // ---- Exercise 4 ----
  // TODO: Implement a projection.
  // A projection transforms the event stream into a read-optimized view.
  // Build a "balance summary" projection: Map[accountId, Double] from events.
  // Also build a "transaction count" projection: Map[accountId, Int] counting
  // deposits + withdrawals per account.
  def balanceSummaryProjection(events: List[BankEvent]): Map[String, Double] = ???

  def transactionCountProjection(events: List[BankEvent]): Map[String, Int] = ???

  // ---- Exercise 5 ----
  // TODO: Implement an aggregate.
  // An aggregate encapsulates state + event handling for a single entity.
  // - `applyEvent(event)`: return updated aggregate
  // - `state`: current AccountState
  // - `uncommittedEvents`: events produced but not yet persisted
  // - `handleCommand(command)`: validate and produce events (or return Left with error)
  trait AccountAggregate {
    def state: AccountState
    def uncommittedEvents: List[BankEvent]
    def applyEvent(event: BankEvent): AccountAggregate
    def handleCommand(command: BankCommand, timestamp: Long): Either[String, AccountAggregate]
    def markCommitted: AccountAggregate
  }

  def createAggregate(): AccountAggregate = ???

  // ---- Exercise 6 ----
  // TODO: Implement a command handler.
  // Given an event store and a command, load the aggregate (replay events for that account),
  // handle the command, and if successful, append new events to the store.
  // Return Either[String, EventStore] (Left = error, Right = updated store).
  def handleCommand(
    store: EventStore,
    command: BankCommand,
    timestamp: Long
  ): Either[String, EventStore] = ???

  // ---- Exercise 7 ----
  // TODO: Implement an event handler / event processor.
  // Given a list of event handlers (functions BankEvent => Unit that produce side effects),
  // process all events through all handlers.
  // For testability: instead of side effects, collect results.
  // Each handler is a function BankEvent => Option[String] that returns a log message or None.
  // Return all non-None results as a flat list.
  def processEvents(
    events: List[BankEvent],
    handlers: List[BankEvent => Option[String]]
  ): List[String] = ???

  // ---- Exercise 8 ----
  // TODO: Implement a temporal query.
  // Given an event store, reconstruct the state of an account at a specific timestamp.
  // Only replay events with timestamp <= the given time.
  def stateAtTime(events: List[BankEvent], accountId: String, atTimestamp: Long): AccountState = ???

  def main(args: Array[String]): Unit = {
    val e1 = AccountCreated("acc1", timestamp = 100)
    val e2 = MoneyDeposited("acc1", 500.0, timestamp = 200)
    val e3 = MoneyWithdrawn("acc1", 100.0, timestamp = 300)
    val e4 = AccountCreated("acc2", timestamp = 150)
    val e5 = MoneyDeposited("acc2", 1000.0, timestamp = 250)

    // Exercise 1: Event Store
    val store0 = createEventStore()
    val store1 = store0.append(e1).append(e2).append(e3).append(e4).append(e5)
    assert(store1.size == 5)
    assert(store1.eventsForAggregate("acc1").length == 3)
    assert(store1.eventsForAggregate("acc2").length == 2)
    assert(store1.eventsSince(3).length == 2)
    println("Exercise 1 passed: Event Store")

    // Exercise 2: Event Replay
    val state1 = replayEvents(List(e1, e2, e3))
    assert(state1.accountId == "acc1")
    assert(state1.balance == 400.0)
    assert(state1.isOpen)
    println("Exercise 2 passed: Event Replay")

    // Exercise 3: Snapshotting
    val snap = createSnapshot(List(e1, e2, e3), upToIndex = 1) // replay e1, e2
    assert(snap.state.balance == 500.0)
    val finalState = replayFromSnapshot(snap, List(e3))
    assert(finalState.balance == 400.0)
    println("Exercise 3 passed: Snapshotting")

    // Exercise 4: Projections
    val allEvents = List(e1, e2, e3, e4, e5)
    val balances = balanceSummaryProjection(allEvents)
    assert(balances("acc1") == 400.0)
    assert(balances("acc2") == 1000.0)
    val txCounts = transactionCountProjection(allEvents)
    assert(txCounts("acc1") == 2) // deposit + withdrawal
    assert(txCounts("acc2") == 1) // deposit only
    println("Exercise 4 passed: Projections")

    // Exercise 5: Aggregate
    val agg0 = createAggregate()
    val agg1 = agg0.applyEvent(e1).applyEvent(e2)
    assert(agg1.state.balance == 500.0)
    val agg2Result = agg1.handleCommand(Withdraw("acc1", 200.0), 400)
    assert(agg2Result.isRight)
    val agg2 = agg2Result.toOption.get
    assert(agg2.uncommittedEvents.length == 1)
    val failResult = agg1.handleCommand(Withdraw("acc1", 999.0), 400)
    assert(failResult.isLeft) // insufficient funds
    println("Exercise 5 passed: Aggregate")

    // Exercise 6: Command Handler
    val s0 = createEventStore().append(e1).append(e2)
    val s1 = handleCommand(s0, Deposit("acc1", 100.0), 400)
    assert(s1.isRight)
    assert(s1.toOption.get.size == 3)
    val s2 = handleCommand(s0, Withdraw("acc1", 999.0), 400)
    assert(s2.isLeft)
    println("Exercise 6 passed: Command Handler")

    // Exercise 7: Event Handlers
    val logHandler: BankEvent => Option[String] = {
      case MoneyDeposited(id, amt, _) => Some(s"Deposited $amt to $id")
      case MoneyWithdrawn(id, amt, _) => Some(s"Withdrew $amt from $id")
      case _ => None
    }
    val logs = processEvents(List(e1, e2, e3), List(logHandler))
    assert(logs.length == 2)
    assert(logs.head.contains("500.0"))
    println("Exercise 7 passed: Event Handlers")

    // Exercise 8: Temporal Query
    val stateAt200 = stateAtTime(List(e1, e2, e3), "acc1", atTimestamp = 200)
    assert(stateAt200.balance == 500.0) // withdrawal at 300 not included
    val stateAt100 = stateAtTime(List(e1, e2, e3), "acc1", atTimestamp = 100)
    assert(stateAt100.balance == 0.0) // only created, no deposit yet
    println("Exercise 8 passed: Temporal Query")

    println("All SysDes006_EventSourcing exercises passed!")
  }
}
