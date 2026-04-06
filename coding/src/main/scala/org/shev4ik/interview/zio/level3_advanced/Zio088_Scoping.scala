package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO088 - Scoping and Resource Management
 *
 * Learn about scope management, scoped resources, and nested scopes with ZManaged.
 */
object Zio088_Scoping extends App {

  // ============================================================
  // Exercise 1: Scope management
  // TODO: Create a ZManaged resource that prints "open" on acquire and
  //       "close" on release. Use .use to run an effect within the scope.
  //       Verify that "close" is printed after the use block.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Scoped resource
  // TODO: Create a scoped resource representing a file handle (simulated).
  //       The resource should print open/close events.
  //       Use the resource to "write" data. Print the lifecycle.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Scope lifetime
  // TODO: Create two ZManaged resources: A and B.
  //       Compose them with for-comprehension (flatMap).
  //       Verify that both are acquired before use and released in reverse order.
  //       Print the lifecycle events.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Nested scope
  // TODO: Create an outer ZManaged that creates an inner ZManaged.
  //       The inner resource depends on the outer.
  //       Use nested .use calls. Print acquisition/release order.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Scope finalization
  // TODO: Create a ZManaged resource. Inside .use, throw an exception.
  //       Verify that the finalizer still runs (resource is released).
  //       Print lifecycle events and catch the error.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Scope transfer
  // TODO: Use ZManaged.reserve to separate acquisition and release.
  //       Acquire a resource, transfer it to a different scope,
  //       and release it in the new scope. Print events.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Scope as managed
  // TODO: Convert a ZManaged into a ZLayer (using .toLayer).
  //       Use the layer to provide a service.
  //       Verify the resource lifecycle matches layer lifecycle.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Scope cleanup ordering
  // TODO: Create 5 ZManaged resources: R1 through R5.
  //       Compose them with for-comprehension.
  //       Verify that cleanup happens in reverse order (R5 first, R1 last).
  //       Print the full acquire/release sequence.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
