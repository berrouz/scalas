package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._
import scala.concurrent.Future

/**
 * ZIO106 - Migration to ZIO
 *
 * Learn how to migrate from Future, Akka, cats-effect, and Java APIs to ZIO.
 */
object Zio106_Migration extends App {

  // ============================================================
  // Exercise 1: Future to ZIO
  // TODO: Convert a Scala Future into a ZIO effect using ZIO.fromFuture.
  //       The Future computes 42. Convert and print the result.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Akka to ZIO (conceptual)
  // TODO: Show the ZIO equivalent of an Akka actor pattern:
  //       Define a "message handler" as a ZIO service with a Queue.
  //       Send messages to the queue, process them. Print processed messages.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: cats-effect to ZIO (conceptual)
  // TODO: Show ZIO equivalents of common cats-effect patterns:
  //       - IO.pure -> ZIO.succeed
  //       - IO.raiseError -> ZIO.fail
  //       - IO.delay -> ZIO.effect
  //       - Resource.make -> ZManaged.make
  //       Demonstrate each. Print results.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Java CompletableFuture
  // TODO: Convert a Java CompletableFuture to ZIO using ZIO.fromCompletionStage.
  //       Create a CompletableFuture that returns "hello from Java".
  //       Convert and print the result.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Callback to ZIO
  // TODO: Convert a callback-based API to ZIO using ZIO.effectAsync.
  //       Simulate an async API that calls a callback with a result after some delay.
  //       Print the result.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Blocking to async
  // TODO: Convert a blocking call to an async ZIO effect using zio.blocking.effectBlocking.
  //       Simulate a blocking database call. Run it on the blocking thread pool.
  //       Print the result.
  // ============================================================
  val exercise6: ZIO[Console with zio.blocking.Blocking, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: ExecutionContext to ZIO
  // TODO: Show how to run ZIO effects that need an ExecutionContext.
  //       Use ZIO.fromFuture which provides an EC.
  //       Demonstrate running Future-based code within ZIO. Print result.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Migration strategy
  // TODO: Demonstrate a gradual migration pattern:
  //       - Wrap existing imperative code in ZIO.effect
  //       - Compose wrapped effects with ZIO combinators
  //       - Show how legacy and ZIO code can coexist
  //       Print the mixed execution flow.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
