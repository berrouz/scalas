package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO113 - Advanced Layer Patterns
 *
 * Learn about dynamic layers, conditional layers, factories, lifecycle hooks, and refresh.
 */
object Zio113_AdvancedLayers extends App {

  // ============================================================
  // Exercise 1: Dynamic layers
  // TODO: Create a layer that is selected dynamically based on a config value.
  //       If config says "prod", use ProdService layer.
  //       If config says "dev", use DevService layer.
  //       Print which layer was selected.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Conditional layers
  // TODO: Create a layer that conditionally includes a feature:
  //       If featureFlag is true, include CachingLayer.
  //       Otherwise, include NoopCachingLayer.
  //       Print the active configuration.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Layer from config
  // TODO: Build a layer from configuration:
  //       Read config (simulated) -> create DB connection layer.
  //       Use ZLayer.fromEffect to create the layer from an effect.
  //       Print the configured layer.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Layer factory
  // TODO: Create a layer factory function:
  //       def makeServiceLayer(name: String): ZLayer[Any, Nothing, Has[Service]]
  //       That creates differently configured service instances.
  //       Print service configuration for each.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Layer lifecycle hooks
  // TODO: Create a layer with lifecycle hooks:
  //       - onCreate: log creation
  //       - onReady: log ready
  //       - onShutdown: log shutdown
  //       Use ZManaged for acquire/release. Print all lifecycle events.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Layer refresh
  // TODO: Implement a refreshable layer pattern:
  //       A service backed by a Ref that can be refreshed.
  //       Provide a refresh method that recreates the underlying resource.
  //       Print refresh events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Layer composition advanced
  // TODO: Demonstrate advanced layer composition:
  //       - Horizontal (++) : independent services
  //       - Vertical (>>>) : dependent services
  //       - Passthrough : keep input in output
  //       - Fresh : no sharing
  //       Print the composition structure.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Layer dependency graph
  // TODO: Build a complex dependency graph:
  //       Config -> (Database, Cache) -> UserService -> (OrderService, NotificationService)
  //       Wire all layers. Provide to an effect that uses OrderService.
  //       Print the dependency chain.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
