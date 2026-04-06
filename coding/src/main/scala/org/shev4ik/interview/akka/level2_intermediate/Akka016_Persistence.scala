package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 016 - Persistence Basics
 *
 * Akka Persistence enables actors to persist their state through events:
 *   - PersistentActor: an actor that persists events before updating state
 *   - persist(event): writes an event to the journal, then applies handler
 *   - Command: incoming message that may generate events
 *   - Event: immutable fact that has happened, stored in the journal
 *   - Recovery: replay events from journal to rebuild state
 *   - Snapshot: periodic state capture for faster recovery
 *   - Journal: append-only event storage
 *   - Event adaptor: transforms events for schema evolution
 *
 * We model these concepts using pure Scala.
 */
object Akka016_Persistence {

  // --- Domain models ---

  sealed trait BankCommand
  case class Deposit(amount: Double) extends BankCommand
  case class Withdraw(amount: Double) extends BankCommand
  case class GetBalance(replyTo: Double => Unit) extends BankCommand

  sealed trait BankEvent
  case class Deposited(amount: Double) extends BankEvent
  case class Withdrawn(amount: Double) extends BankEvent

  case class BankState(balance: Double, eventCount: Int)

  case class Journal(persistenceId: String, events: List[BankEvent], sequenceNr: Long)

  case class Snapshot(persistenceId: String, state: BankState, sequenceNr: Long)

  /** Event adaptor: transforms events between versions */
  sealed trait BankEventV2
  case class DepositedV2(amount: Double, currency: String) extends BankEventV2
  case class WithdrawnV2(amount: Double, currency: String) extends BankEventV2

  // Exercise 1: PersistentActor — command to event mapping
  // TODO: Given a BankCommand and current BankState, determine which event(s) to persist:
  //   - Deposit(amount) -> List(Deposited(amount))
  //   - Withdraw(amount) -> if balance >= amount, List(Withdrawn(amount)), else Nil (rejected)
  //   - GetBalance -> Nil (read-only, no events)
  //   Return the list of events to persist.
  def exercise1_commandToEvents(state: BankState, cmd: BankCommand): List[BankEvent] = ???

  // Exercise 2: Apply events to update state
  // TODO: Given a BankState and a BankEvent, return the updated state:
  //   - Deposited(amount) -> increase balance, increment eventCount
  //   - Withdrawn(amount) -> decrease balance, increment eventCount
  //   In real Akka: this is the event handler in receiveRecover and after persist.
  def exercise2_applyEvent(state: BankState, event: BankEvent): BankState = ???

  // Exercise 3: Persist — write event to journal and update state
  // TODO: Given a Journal, BankState, and a BankCommand:
  //   1. Generate events using exercise1 logic
  //   2. For each event, append to journal (increment sequenceNr)
  //   3. Apply each event to state using exercise2 logic
  //   Return (updatedJournal, updatedState)
  def exercise3_persist(journal: Journal, state: BankState, cmd: BankCommand): (Journal, BankState) = ???

  // Exercise 4: Recovery — replay events to rebuild state
  // TODO: Given a Journal, replay all events starting from BankState(0.0, 0)
  //   to reconstruct the current state. Return the recovered state.
  //   In real Akka: receiveRecover replays all events from journal on startup.
  def exercise4_recover(journal: Journal): BankState = ???

  // Exercise 5: Snapshot — save and restore state
  // TODO: Given a Journal and a snapshot interval (every N events),
  //   simulate processing: replay events, take a snapshot every N events.
  //   Return the last snapshot taken.
  //   If no events, return Snapshot with BankState(0, 0) at sequenceNr=0.
  def exercise5_snapshot(journal: Journal, snapshotInterval: Int): Snapshot = ???

  // Exercise 6: Recovery from snapshot + events
  // TODO: Given a Snapshot and a list of events that occurred AFTER the snapshot,
  //   recover state by starting from the snapshot state and applying the remaining events.
  //   Return the final recovered state.
  def exercise6_recoverFromSnapshot(snapshot: Snapshot, remainingEvents: List[BankEvent]): BankState = ???

  // Exercise 7: Journal operations — append and query
  // TODO: Process a list of BankCommands, building up the journal and state.
  //   Start from empty journal and BankState(0, 0).
  //   Return (finalJournal, finalState, rejectedCount) where rejectedCount
  //   is the number of commands that produced no events (rejected withdrawals + reads).
  def exercise7_journalOperations(
    persistenceId: String,
    commands: List[BankCommand]
  ): (Journal, BankState, Int) = ???

  // Exercise 8: Event adaptor — schema evolution
  // TODO: Given a list of BankEvent (V1), transform them to BankEventV2
  //   by adding a default currency "USD":
  //   - Deposited(amount) -> DepositedV2(amount, "USD")
  //   - Withdrawn(amount) -> WithdrawnV2(amount, "USD")
  //   This models schema evolution in Akka Persistence.
  def exercise8_eventAdaptor(events: List[BankEvent]): List[BankEventV2] = ???

  def main(args: Array[String]): Unit = {
    val emptyState = BankState(0.0, 0)

    // Exercise 1
    val e1a = exercise1_commandToEvents(BankState(100, 0), Deposit(50))
    assert(e1a == List(Deposited(50)), s"Exercise 1 failed: $e1a")
    val e1b = exercise1_commandToEvents(BankState(30, 0), Withdraw(50))
    assert(e1b == Nil, s"Exercise 1 failed: should reject overdraft, got $e1b")
    val e1c = exercise1_commandToEvents(BankState(100, 0), Withdraw(50))
    assert(e1c == List(Withdrawn(50)), s"Exercise 1 failed: $e1c")
    println("Exercise 1 passed: command to event mapping")

    // Exercise 2
    val s2 = exercise2_applyEvent(BankState(100, 0), Deposited(50))
    assert(s2 == BankState(150, 1), s"Exercise 2 failed: $s2")
    val s2b = exercise2_applyEvent(s2, Withdrawn(30))
    assert(s2b == BankState(120, 2), s"Exercise 2 failed: $s2b")
    println("Exercise 2 passed: event application")

    // Exercise 3
    val j0 = Journal("account-1", Nil, 0)
    val (j3, s3) = exercise3_persist(j0, emptyState, Deposit(100))
    assert(s3.balance == 100, s"Exercise 3 failed: balance = ${s3.balance}")
    assert(j3.events == List(Deposited(100)), s"Exercise 3 failed: journal = ${j3.events}")
    assert(j3.sequenceNr == 1, s"Exercise 3 failed: seqNr = ${j3.sequenceNr}")
    println("Exercise 3 passed: persist works")

    // Exercise 4
    val j4 = Journal("acc", List(Deposited(100), Withdrawn(30), Deposited(50)), 3)
    val s4 = exercise4_recover(j4)
    assert(s4 == BankState(120, 3), s"Exercise 4 failed: $s4")
    println(s"Exercise 4 passed: recovered state = $s4")

    // Exercise 5
    val j5 = Journal("acc", List(Deposited(10), Deposited(20), Deposited(30), Deposited(40)), 4)
    val snap5 = exercise5_snapshot(j5, 2)
    assert(snap5.state.balance == 40, s"Exercise 5 failed: snap balance = ${snap5.state.balance}")
    assert(snap5.sequenceNr == 4, s"Exercise 5 failed: snap seqNr = ${snap5.sequenceNr}")
    println(s"Exercise 5 passed: snapshot at seqNr=${snap5.sequenceNr}")

    // Exercise 6
    val snap6 = Snapshot("acc", BankState(100, 5), 5)
    val remaining6 = List(Deposited(25), Withdrawn(10))
    val s6 = exercise6_recoverFromSnapshot(snap6, remaining6)
    assert(s6 == BankState(115, 7), s"Exercise 6 failed: $s6")
    println(s"Exercise 6 passed: $s6")

    // Exercise 7
    val cmds7 = List(
      Deposit(100), Withdraw(30), GetBalance(_ => ()), Withdraw(200), Deposit(50)
    )
    val (j7, s7, rejected7) = exercise7_journalOperations("acc-1", cmds7)
    assert(s7.balance == 120, s"Exercise 7 failed: balance = ${s7.balance}")
    assert(rejected7 == 2, s"Exercise 7 failed: rejected = $rejected7")
    assert(j7.events.size == 3, s"Exercise 7 failed: events = ${j7.events.size}")
    println(s"Exercise 7 passed: balance=${s7.balance}, rejected=$rejected7")

    // Exercise 8
    val events8 = List(Deposited(100), Withdrawn(30), Deposited(50))
    val v2events = exercise8_eventAdaptor(events8)
    assert(v2events == List(DepositedV2(100, "USD"), WithdrawnV2(30, "USD"), DepositedV2(50, "USD")),
      s"Exercise 8 failed: $v2events")
    println(s"Exercise 8 passed: $v2events")

    println("\nAll Akka016_Persistence exercises passed!")
  }
}
