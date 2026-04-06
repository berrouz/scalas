package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO094 - Fiber Local (FiberRef)
 *
 * Learn how to use FiberRef for fiber-local storage, context propagation, and correlation IDs.
 */
object Zio094_FiberLocal extends App {

  // ============================================================
  // Exercise 1: FiberRef local
  // TODO: Create a FiberRef[String] with initial value "default".
  //       Set it to "custom" in the current fiber. Read and print the value.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Inherited values
  // TODO: Create a FiberRef[String] with value "parent-value".
  //       Fork a child fiber. Verify the child inherits the parent's value.
  //       Print values from both parent and child.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Fiber-local context
  // TODO: Create a FiberRef for a Map[String, String] representing context.
  //       Add "user" -> "Alice" to the context. Fork a fiber that reads it.
  //       Print the context in both parent and child.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Correlation ID
  // TODO: Create a FiberRef for correlation ID (String).
  //       Implement a helper that sets a random correlation ID.
  //       Fork multiple fibers, each with its own correlation ID.
  //       Print the correlation ID in each fiber.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Request context
  // TODO: Model a request context with FiberRef:
  //       case class RequestCtx(traceId: String, userId: String)
  //       Set context at the entry point. Access it deep in the call stack.
  //       Print the context at various levels.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Thread-local replacement
  // TODO: Show how FiberRef replaces Java ThreadLocal in ZIO.
  //       Create a FiberRef, fork 5 fibers that each set different values.
  //       Verify each fiber has its own isolated value. Print all values.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Fiber context propagation
  // TODO: Implement context propagation through a chain of function calls:
  //       functionA -> functionB -> functionC
  //       Each function adds to the FiberRef context. The final function
  //       prints the accumulated context.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Context management
  // TODO: Implement a ContextManager service that provides:
  //       - withContext[A](key: String, value: String)(effect: ZIO[...]): ZIO[...]
  //       - getContext(key: String): ZIO[..., Option[String]]
  //       Use FiberRef internally. Test with nested withContext calls.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
