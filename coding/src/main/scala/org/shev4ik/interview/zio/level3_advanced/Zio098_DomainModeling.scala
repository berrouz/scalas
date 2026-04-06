package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._

/**
 * ZIO098 - Domain Modeling with ZIO
 *
 * Learn how to model domain types, services, and use cases with ZIO.
 */
object Zio098_DomainModeling extends App {

  // ============================================================
  // Exercise 1: Domain types
  // TODO: Define domain types: UserId, Email, Money.
  //       Use value classes or case classes for type safety.
  //       Write functions that accept these types (not raw String/Int).
  //       Print example values.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Smart constructors
  // TODO: Implement smart constructors for Email and Age:
  //       Email.make(s: String): IO[ValidationError, Email]
  //       Age.make(n: Int): IO[ValidationError, Age]
  //       Test with valid and invalid inputs. Print results.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Domain events
  // TODO: Define domain events: UserCreated, UserUpdated, UserDeleted.
  //       Create an event log using Ref[List[DomainEvent]].
  //       Emit events during operations. Print the event log.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Domain services
  // TODO: Define a UserService trait with ZIO methods:
  //       create, findById, update, delete.
  //       Implement it with an in-memory Ref[Map[Int, User]].
  //       Test CRUD operations. Print results.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Aggregate
  // TODO: Model an Order aggregate with OrderId, items list, and status.
  //       Implement aggregate methods: addItem, removeItem, checkout.
  //       Each method validates invariants. Print the aggregate state.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Repository interface
  // TODO: Define a generic Repository trait:
  //       trait Repository[K, V] { def find(id: K): Task[Option[V]]; ... }
  //       Implement UserRepository using Ref[Map].
  //       Provide it as a ZLayer. Write a test. Print results.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Use case
  // TODO: Implement a "CreateOrder" use case that:
  //       1. Validates the user exists
  //       2. Validates items are in stock
  //       3. Creates the order
  //       4. Emits an event
  //       Use ZIO to chain the steps. Print the result.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Domain validation
  // TODO: Implement a domain validator that checks:
  //       - Order total > 0
  //       - All items have positive quantities
  //       - Shipping address is not empty
  //       Accumulate all validation errors. Print validation result.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
