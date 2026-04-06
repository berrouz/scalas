package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO127 - Full Application Wiring
 *
 * Build a complete ZIO application with all the patterns learned.
 */
object Zio127_FullApp extends App {

  // ============================================================
  // Exercise 1: Full app wiring
  // TODO: Wire a complete application with multiple layers:
  //       Config -> Database -> UserService -> Application
  //       Each layer is a ZLayer. The Application uses all services.
  //       Print the wiring and run a simple operation.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Config loading
  // TODO: Implement config loading from a simulated source:
  //       Provide AppConfig(dbUrl, port, logLevel) as a ZLayer.
  //       Use ZLayer.fromEffect to load config (can fail).
  //       Print the loaded config.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Service composition
  // TODO: Compose multiple services into a complete application:
  //       UserService, OrderService, NotificationService.
  //       UserService depends on Database.
  //       OrderService depends on UserService and Database.
  //       NotificationService depends on Config.
  //       Wire everything. Print the composition.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Error handling
  // TODO: Implement application-level error handling:
  //       - Catch domain errors and log them
  //       - Catch infrastructure errors and retry
  //       - Catch fatal errors and shutdown gracefully
  //       Print error handling flow.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Graceful shutdown
  // TODO: Implement full graceful shutdown:
  //       - Signal to stop accepting new requests
  //       - Wait for in-flight requests to complete (with timeout)
  //       - Close resources in reverse order
  //       - Print shutdown report
  //       Print the full shutdown sequence.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Health check
  // TODO: Add health checks to the application:
  //       - Database health (simulated)
  //       - Service health (simulated)
  //       - Overall application health
  //       Print health check results.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6)
      .exitCode
}
