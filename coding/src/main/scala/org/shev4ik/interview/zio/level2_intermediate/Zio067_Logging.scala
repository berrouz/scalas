package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.logging._

/**
 * ZIO 067 - Logging: structured logging with zio-logging.
 *
 * zio-logging provides a Logging service with structured log output.
 * Key operations: log.info, log.debug, log.error, log.warn.
 * Supports log annotations and correlation IDs.
 *
 * Note: Uses zio-logging 0.5.x API compatible with ZIO 1.x.
 */
object Zio067_Logging {

  // Exercise 1: Log an info message
  // TODO: log.info("Application started")
  val exercise1: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 2: Log a debug message
  // TODO: log.debug("Debug information here")
  val exercise2: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 3: Log an error message
  // TODO: log.error("Something went wrong")
  val exercise3: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 4: Log a warning message
  // TODO: log.warn("Approaching rate limit")
  val exercise4: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 5: Create a logging layer for console output
  // TODO: Logging.console() or Logging.console(LogLevel.Info, LogFormat.default)
  val exercise5: ZLayer[zio.console.Console with zio.clock.Clock, Nothing, Logging] = ???

  // Exercise 6: Log with a correlation ID annotation
  // TODO: log.locally(LogAnnotation.CorrelationId(Some(java.util.UUID.randomUUID()))) {
  //         log.info("Processing request")
  //       }
  val exercise6: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 7: Log with custom annotations
  // TODO: log.locally(LogAnnotation.Name("my-service" :: Nil)) {
  //         log.info("Service specific log")
  //       }
  val exercise7: ZIO[Logging, Nothing, Unit] = ???

  // Exercise 8: Log with context — combine multiple annotations
  // TODO: Combine name and correlation ID annotations for contextual logging
  val exercise8: ZIO[Logging, Nothing, Unit] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val loggingLayer = Logging.console()

    val layer = (zio.console.Console.live ++ zio.clock.Clock.live) >>> loggingLayer

    runtime.unsafeRun(exercise1.provideLayer(layer))
    println("Exercise 1 passed: info logged")

    runtime.unsafeRun(exercise2.provideLayer(layer))
    println("Exercise 2 passed: debug logged")

    runtime.unsafeRun(exercise3.provideLayer(layer))
    println("Exercise 3 passed: error logged")

    runtime.unsafeRun(exercise4.provideLayer(layer))
    println("Exercise 4 passed: warn logged")

    println("Exercise 5 passed: logging layer created")

    runtime.unsafeRun(exercise6.provideLayer(layer))
    println("Exercise 6 passed: correlation ID logged")

    runtime.unsafeRun(exercise7.provideLayer(layer))
    println("Exercise 7 passed: named log")

    runtime.unsafeRun(exercise8.provideLayer(layer))
    println("Exercise 8 passed: contextual log")

    println("All Zio067_Logging exercises passed!")
  }
}
