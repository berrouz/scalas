package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO119 - Event Sourcing with ZIO
 *
 * Learn how to implement event sourcing patterns with ZIO.
 */
object Zio119_EventSourcing extends App {

  // ============================================================
  // Exercise 1: Event store
  // TODO: Implement an event store using Ref[List[Event]].
  //       Support: append(event), getEvents, getEventsSince(version).
  //       Test with several events. Print stored events.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Event handler
  // TODO: Define events: AccountCreated, MoneyDeposited, MoneyWithdrawn.
  //       Implement an event handler that applies events to build current state.
  //       Apply a sequence of events. Print the final state.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Aggregate
  // TODO: Implement an Account aggregate that:
  //       - Accepts commands (CreateAccount, Deposit, Withdraw)
  //       - Validates commands against current state
  //       - Produces events
  //       - Applies events to update state
  //       Print command processing flow.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Snapshot
  // TODO: Implement snapshot support for the aggregate:
  //       After every 5 events, create a snapshot.
  //       On rebuild, start from the latest snapshot.
  //       Print snapshot creation and restoration.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Event replay
  // TODO: Implement event replay: rebuild aggregate state from the event store.
  //       Store 10 events. Replay them to reconstruct the state.
  //       Verify the reconstructed state matches. Print replay progress.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Projection
  // TODO: Implement a read-side projection:
  //       Process events to build a read model (e.g., account summary).
  //       The projection runs asynchronously, consuming events from the store.
  //       Print the projected read model.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Event versioning
  // TODO: Handle event schema evolution:
  //       Define EventV1 and EventV2 (with additional field).
  //       Implement an upcaster that converts V1 events to V2.
  //       Process a mixed stream of V1 and V2 events. Print results.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Event sourcing with ZIO
  // TODO: Build a complete event-sourced system:
  //       - Event store (Ref)
  //       - Command handler (validates and produces events)
  //       - Event handler (applies events)
  //       - Projection (builds read model)
  //       Wire with ZLayers. Run a scenario. Print the full flow.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
