package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO120 - CQRS (Command Query Responsibility Segregation)
 *
 * Learn how to implement CQRS patterns with ZIO.
 */
object Zio120_CQRS extends App {

  // ============================================================
  // Exercise 1: Command side
  // TODO: Define commands: CreateUser, UpdateEmail, DeactivateUser.
  //       Implement a command handler that validates and processes commands.
  //       Commands produce events. Print command processing.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Query side
  // TODO: Define queries: GetUser, ListActiveUsers, SearchByEmail.
  //       Implement a query handler that reads from a read model (Ref[Map]).
  //       Print query results.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Command handler
  // TODO: Implement a full command handler service:
  //       - Validate command
  //       - Load aggregate state
  //       - Process command (produce events)
  //       - Persist events
  //       - Publish events
  //       Wire as a ZLayer. Print the processing pipeline.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Event publisher
  // TODO: Implement an event publisher using Hub or Queue.
  //       Command handler publishes events.
  //       Subscribers (projections) receive events asynchronously.
  //       Print publish and receive events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Read model
  // TODO: Implement a read model backed by Ref[Map]:
  //       - UserSummary: id, name, email, active status
  //       The read model is updated by processing events.
  //       Query the read model. Print the state.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Projection builder
  // TODO: Implement a projection that transforms events into read model updates:
  //       UserCreated -> insert into read model
  //       EmailUpdated -> update email in read model
  //       UserDeactivated -> mark inactive in read model
  //       Print each projection step.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Eventual consistency
  // TODO: Demonstrate eventual consistency between command and query sides:
  //       Execute a command. Immediately query (may see stale data).
  //       Wait for projection to catch up. Query again (sees updated data).
  //       Print the consistency timeline.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: CQRS testing
  // TODO: Write tests for the CQRS system:
  //       - Command produces expected events
  //       - Events update read model correctly
  //       - Query returns correct results after events
  //       Print test results.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
