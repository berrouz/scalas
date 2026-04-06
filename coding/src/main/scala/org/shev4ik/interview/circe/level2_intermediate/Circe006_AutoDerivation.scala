package org.shev4ik.interview.circe.level2_intermediate

/**
 * Circe 006 - Automatic Derivation
 *
 * In circe, automatic derivation generates Encoder/Decoder instances at each use
 * site without explicit implicit vals. You import io.circe.generic.auto._
 * and codecs are derived on-the-fly via Shapeless.
 *
 * Trade-offs:
 *   + Less boilerplate (no need to write implicit vals)
 *   - Slower compilation (derivation happens at every use site)
 *   - Harder to debug (implicit resolution is more complex)
 *   - Can generate unexpected encodings for sealed traits
 *
 * In this exercise, we simulate auto-derivation by building a generic mechanism
 * that derives encoders/decoders from field metadata.
 *
 * Key concepts: auto._ import, compile-time derivation, performance implications,
 * when to use auto vs semi-auto.
 */
object Circe006_AutoDerivation {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Encoder & Decoder
  trait Encoder[A] { def apply(a: A): Json }
  object Encoder {
    def apply[A](implicit enc: Encoder[A]): Encoder[A] = enc
    def instance[A](f: A => Json): Encoder[A] = new Encoder[A] { def apply(a: A): Json = f(a) }
  }

  case class Cursor(focus: Option[Json]) {
    def downField(name: String): Cursor = focus match {
      case Some(JObject(fields)) => Cursor(fields.get(name))
      case _                     => Cursor(None)
    }
  }

  trait Decoder[A] { def decode(cursor: Cursor): Either[String, A] }
  object Decoder {
    def apply[A](implicit dec: Decoder[A]): Decoder[A] = dec
    def instance[A](f: Cursor => Either[String, A]): Decoder[A] = new Decoder[A] {
      def decode(cursor: Cursor): Either[String, A] = f(cursor)
    }
  }

  // Primitive instances
  implicit val stringEnc: Encoder[String] = Encoder.instance(JString)
  implicit val intEnc: Encoder[Int] = Encoder.instance(i => JNumber(i.toDouble))
  implicit val doubleEnc: Encoder[Double] = Encoder.instance(JNumber)
  implicit val boolEnc: Encoder[Boolean] = Encoder.instance(JBool)

  implicit val stringDec: Decoder[String] = Decoder.instance(c => c.focus match {
    case Some(JString(s)) => Right(s); case _ => Left("Expected String")
  })
  implicit val intDec: Decoder[Int] = Decoder.instance(c => c.focus match {
    case Some(JNumber(n)) => Right(n.toInt); case _ => Left("Expected Number")
  })
  implicit val doubleDec: Decoder[Double] = Decoder.instance(c => c.focus match {
    case Some(JNumber(n)) => Right(n); case _ => Left("Expected Number")
  })
  implicit val boolDec: Decoder[Boolean] = Decoder.instance(c => c.focus match {
    case Some(JBool(b)) => Right(b); case _ => Left("Expected Boolean")
  })

  // Field metadata for simulated derivation
  case class FieldEncoder[A](name: String, encoder: Encoder[A], getter: Any => A)
  case class FieldDecoder[A](name: String, decoder: Decoder[A])

  // Domain types (in auto derivation, these would NOT need explicit implicits)
  case class Coordinates(lat: Double, lng: Double)
  case class Location(name: String, coords: Coordinates)
  case class AppConfig(appName: String, version: Int, debug: Boolean)
  case class Nested(inner: AppConfig, label: String)

  // -------------------------------------------------------------------------
  // Exercise 1: Simulate auto-derived Encoder for Coordinates.
  // TODO: Build the encoder using field metadata. Encode as JObject with
  //       "lat" and "lng" fields. Imagine this is what auto._ generates.
  // -------------------------------------------------------------------------
  implicit val coordinatesEncoder: Encoder[Coordinates] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Simulate auto-derived Decoder for Coordinates.
  // TODO: Decode "lat" and "lng" from a JObject.
  // -------------------------------------------------------------------------
  implicit val coordinatesDecoder: Decoder[Coordinates] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Simulate auto-derived Encoder for a nested type (Location).
  // TODO: Encode Location as JObject with "name" (String) and "coords"
  //       (encoded using coordinatesEncoder). This shows how auto derivation
  //       resolves nested implicits automatically.
  // -------------------------------------------------------------------------
  implicit val locationEncoder: Encoder[Location] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Simulate auto-derived Decoder for Location (nested).
  // TODO: Decode "name" as String and "coords" as Coordinates (using
  //       coordinatesDecoder). This shows chained implicit resolution.
  // -------------------------------------------------------------------------
  implicit val locationDecoder: Decoder[Location] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Simulate auto-derived Encoder for AppConfig (3 fields).
  // TODO: Encode as JObject with "appName", "version", "debug" fields.
  // -------------------------------------------------------------------------
  implicit val appConfigEncoder: Encoder[AppConfig] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Simulate auto-derived Decoder for AppConfig.
  // TODO: Decode "appName" as String, "version" as Int, "debug" as Boolean.
  // -------------------------------------------------------------------------
  implicit val appConfigDecoder: Decoder[AppConfig] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Demonstrate that auto derivation resolves deeply nested types.
  // TODO: Create Encoder and Decoder for Nested, which contains an AppConfig.
  //       This exercises the transitive implicit resolution that auto._ provides.
  //       Return a tuple (Encoder[Nested], Decoder[Nested]).
  // -------------------------------------------------------------------------
  def exercise7_nestedCodecs: (Encoder[Nested], Decoder[Nested]) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Explain the trade-offs by implementing a function that
  //             demonstrates the "explicit vs auto" choice.
  // TODO: Given a list of Coordinates, encode them as a JArray.
  //       Use the implicit Encoder[Coordinates] to encode each element.
  //       Return the JArray. This shows that with auto._, you just call
  //       .asJson and everything resolves, but with semi-auto you need
  //       explicit implicit vals for every type.
  // -------------------------------------------------------------------------
  def exercise8_encodeList(coords: List[Coordinates])(implicit enc: Encoder[Coordinates]): Json = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val coords = Coordinates(40.7128, -74.0060)
    assert(coordinatesEncoder(coords) == JObject(Map("lat" -> JNumber(40.7128), "lng" -> JNumber(-74.0060))))
    println("Exercise 1 passed: Coordinates encoder works")

    // Exercise 2
    val coordsJson = JObject(Map("lat" -> JNumber(51.5074), "lng" -> JNumber(-0.1278)))
    assert(coordinatesDecoder.decode(Cursor(Some(coordsJson))) == Right(Coordinates(51.5074, -0.1278)))
    println("Exercise 2 passed: Coordinates decoder works")

    // Exercise 3
    val loc = Location("NYC", Coordinates(40.7128, -74.0060))
    val locJson = locationEncoder(loc)
    assert(locJson == JObject(Map(
      "name" -> JString("NYC"),
      "coords" -> JObject(Map("lat" -> JNumber(40.7128), "lng" -> JNumber(-74.0060)))
    )))
    println("Exercise 3 passed: Location encoder works (nested)")

    // Exercise 4
    val locJsonInput = JObject(Map(
      "name" -> JString("London"),
      "coords" -> JObject(Map("lat" -> JNumber(51.5074), "lng" -> JNumber(-0.1278)))
    ))
    assert(locationDecoder.decode(Cursor(Some(locJsonInput))) == Right(Location("London", Coordinates(51.5074, -0.1278))))
    println("Exercise 4 passed: Location decoder works (nested)")

    // Exercise 5
    val config = AppConfig("MyApp", 3, true)
    assert(appConfigEncoder(config) == JObject(Map(
      "appName" -> JString("MyApp"), "version" -> JNumber(3.0), "debug" -> JBool(true)
    )))
    println("Exercise 5 passed: AppConfig encoder works")

    // Exercise 6
    val configJson = JObject(Map("appName" -> JString("TestApp"), "version" -> JNumber(1.0), "debug" -> JBool(false)))
    assert(appConfigDecoder.decode(Cursor(Some(configJson))) == Right(AppConfig("TestApp", 1, false)))
    println("Exercise 6 passed: AppConfig decoder works")

    // Exercise 7
    val (nestedEnc, nestedDec) = exercise7_nestedCodecs
    val nested = Nested(AppConfig("X", 1, true), "test")
    val nestedJson = nestedEnc(nested)
    assert(nestedJson == JObject(Map(
      "inner" -> JObject(Map("appName" -> JString("X"), "version" -> JNumber(1.0), "debug" -> JBool(true))),
      "label" -> JString("test")
    )))
    assert(nestedDec.decode(Cursor(Some(nestedJson))) == Right(nested))
    println("Exercise 7 passed: deeply nested codecs work")

    // Exercise 8
    val coordsList = List(Coordinates(1.0, 2.0), Coordinates(3.0, 4.0))
    val result = exercise8_encodeList(coordsList)
    assert(result == JArray(Vector(
      JObject(Map("lat" -> JNumber(1.0), "lng" -> JNumber(2.0))),
      JObject(Map("lat" -> JNumber(3.0), "lng" -> JNumber(4.0)))
    )))
    println("Exercise 8 passed: list encoding works")

    println("\nAll Circe006_AutoDerivation exercises passed!")
  }
}
