package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO125 - Interop with Cats Effect (Conceptual)
 *
 * Learn the conceptual mapping between cats-effect and ZIO (simulated without cats dependency).
 */
object Zio125_InteropCats extends App {

  // ============================================================
  // Exercise 1: cats-effect IO equivalents
  // TODO: Show ZIO equivalents of cats-effect IO operations:
  //       IO.pure(42) -> ZIO.succeed(42)
  //       IO.raiseError(e) -> ZIO.fail(e)
  //       IO.delay(expr) -> ZIO.effect(expr)
  //       IO.async(cb => ...) -> ZIO.effectAsync(cb => ...)
  //       Print results of each ZIO equivalent.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: IO to ZIO conversion pattern
  // TODO: Show how to convert a cats-effect style API to ZIO:
  //       trait CatsStyleService { def getData: Task[String] }
  //       (Task is ZIO's Task which is similar to cats IO)
  //       Implement and use the service. Print the result.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: ZIO to IO conversion pattern
  // TODO: Show how ZIO effects can be described in a way that maps to cats IO:
  //       ZIO[Any, Throwable, A] ~ IO[A]
  //       Demonstrate the equivalence. Print type information.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Resource to ZManaged
  // TODO: Show the mapping between cats Resource and ZManaged:
  //       Resource.make(acquire)(release) -> ZManaged.make(acquire)(release)
  //       Implement the same resource pattern with ZManaged.
  //       Print lifecycle events.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Cats type class equivalents
  // TODO: Show ZIO equivalents of common cats type classes:
  //       Functor (map) -> ZIO.map
  //       Monad (flatMap) -> ZIO.flatMap
  //       MonadError (handleError) -> ZIO.catchAll
  //       Applicative (pure) -> ZIO.succeed
  //       Print examples of each.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Interop layer pattern
  // TODO: Show how to create an adapter layer between cats-effect style
  //       and ZIO style code. Define a wrapper service that translates.
  //       Print the adaptation flow.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Mixed code pattern (6 exercises for last-ish file)
  // TODO: Show a pattern for gradually migrating cats-effect code to ZIO:
  //       - Start with Task (ZIO[Any, Throwable, A])
  //       - Gradually add environment (R) and typed errors (E)
  //       - Show the migration path
  //       Print the migration steps.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7)
      .exitCode
}
