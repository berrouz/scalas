package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.stream._

/**
 * ZIO123 - ZIO JSON Patterns (Simulated)
 *
 * Learn JSON encoding/decoding patterns using ZIO idioms (simulated without zio-json dependency).
 */
object Zio123_ZIOJson extends App {

  // Simulated JSON types (since we may not have zio-json as a dependency)
  sealed trait Json
  case class JsonStr(value: String) extends Json
  case class JsonNum(value: Double) extends Json
  case class JsonBool(value: Boolean) extends Json
  case class JsonArr(values: List[Json]) extends Json
  case class JsonObj(fields: Map[String, Json]) extends Json
  case object JsonNull extends Json

  // ============================================================
  // Exercise 1: Encoder
  // TODO: Define a simple Encoder[A] trait with encode(a: A): Json.
  //       Implement encoders for String, Int, Boolean.
  //       Encode sample values and print the JSON representation.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Decoder
  // TODO: Define a Decoder[A] trait with decode(json: Json): Either[String, A].
  //       Implement decoders for String, Int, Boolean.
  //       Decode sample JSON values and print results.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Codec (encoder + decoder)
  // TODO: Define a Codec[A] that combines Encoder and Decoder.
  //       Implement Codec for a case class User(name: String, age: Int).
  //       Round-trip test: encode then decode. Print results.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Auto derivation (simulated)
  // TODO: Implement a simple macro-free derivation for product types:
  //       Given encoders for fields, derive encoder for a case class.
  //       Demonstrate with Person(name: String, age: Int, active: Boolean).
  //       Print the derived JSON.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Custom codec
  // TODO: Implement a custom codec for a sealed trait hierarchy:
  //       Shape: Circle(radius), Rectangle(width, height)
  //       Add a "type" discriminator field. Print encoded/decoded shapes.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Error handling
  // TODO: Implement robust JSON decoding error handling:
  //       - Missing field error
  //       - Wrong type error
  //       - Nested error with path
  //       Print detailed error messages for each case.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Streaming JSON
  // TODO: Implement streaming JSON processing:
  //       Given a ZStream of Json objects, decode each and collect results.
  //       Handle individual decode failures without stopping the stream.
  //       Print successfully decoded items and error count.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: JSON validation
  // TODO: Implement JSON schema validation:
  //       Define a schema (required fields, types, ranges).
  //       Validate JSON against the schema.
  //       Accumulate all validation errors. Print validation results.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
