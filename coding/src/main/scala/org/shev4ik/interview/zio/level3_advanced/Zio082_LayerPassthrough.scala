package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._

/**
 * ZIO082 - Layer Passthrough and Mapping
 *
 * Learn advanced layer operations: passthrough, project, tap, map, flatMap, to, compose.
 */
object Zio082_LayerPassthrough extends App {

  // ---- Service definitions ----
  trait Config { def dbUrl: String }
  trait DbConnection { def query(sql: String): Task[String] }
  trait UserService { def getUser(id: Int): Task[String] }

  // ============================================================
  // Exercise 1: Passthrough
  // TODO: Create a layer Config => DbConnection.
  //       Use .passthrough so the output includes BOTH Config and DbConnection.
  //       Write an effect that uses both services.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Project
  // TODO: Create a layer that provides (Config, DbConnection).
  //       Use .project to narrow it to only provide DbConnection.
  //       Write an effect that uses only DbConnection.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Tap
  // TODO: Create a layer for DbConnection.
  //       Use .tap to log "DbConnection created" when the layer is built.
  //       Write an effect that uses the tapped layer.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Map on layer
  // TODO: Create a layer that provides Config with dbUrl = "localhost:5432".
  //       Use .map to transform Config into a new Config with dbUrl prefixed
  //       by "jdbc:postgresql://". Verify the transformed value.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: FlatMap on layer
  // TODO: Create a Config layer.
  //       Use .flatMap (or >>>) with another layer that uses Config to build DbConnection.
  //       Write an effect that uses the resulting DbConnection.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: to (layer composition)
  // TODO: Create configLayer: ULayer[Has[Config]].
  //       Create dbLayer: ZLayer[Has[Config], Nothing, Has[DbConnection]].
  //       Compose them using configLayer >>> dbLayer (or .to).
  //       Write an effect that uses DbConnection.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Compose (horizontal)
  // TODO: Create two independent layers: configLayer and a LoggingLayer.
  //       Compose them horizontally using ++ to get a layer providing both.
  //       Write an effect requiring both services.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Layer mapping chain
  // TODO: Build a multi-step layer pipeline:
  //       Config => DbConnection => UserService
  //       Each step transforms the previous layer's output.
  //       Write an effect that uses UserService and print the result.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
