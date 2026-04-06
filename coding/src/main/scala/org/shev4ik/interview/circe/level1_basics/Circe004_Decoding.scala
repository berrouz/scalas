package org.shev4ik.interview.circe.level1_basics

/**
 * Circe 004 - Decoding (Decoder Type Class)
 *
 * In circe, Decoder[A] is a type class that converts Json into Either[DecodingFailure, A].
 * It uses a cursor (HCursor) to navigate the JSON structure and extract values.
 *
 * Key methods: downField, as[A], map, flatMap, emap.
 *
 * Key concepts: Decoder trait, cursor-based decoding, error accumulation,
 * composing decoders with map/flatMap/emap.
 */
object Circe004_Decoding {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Cursor
  case class Cursor(focus: Option[Json]) {
    def downField(name: String): Cursor = focus match {
      case Some(JObject(fields)) => Cursor(fields.get(name))
      case _                     => Cursor(None)
    }
  }

  // Simplified Decoder type class mirroring circe's io.circe.Decoder
  trait Decoder[A] {
    def decode(cursor: Cursor): Either[String, A]

    def map[B](f: A => B): Decoder[B] = {
      val self = this
      new Decoder[B] {
        def decode(cursor: Cursor): Either[String, B] = self.decode(cursor).map(f)
      }
    }

    def flatMap[B](f: A => Decoder[B]): Decoder[B] = {
      val self = this
      new Decoder[B] {
        def decode(cursor: Cursor): Either[String, B] =
          self.decode(cursor).flatMap(a => f(a).decode(cursor))
      }
    }

    def emap[B](f: A => Either[String, B]): Decoder[B] = {
      val self = this
      new Decoder[B] {
        def decode(cursor: Cursor): Either[String, B] =
          self.decode(cursor).flatMap(f)
      }
    }
  }

  object Decoder {
    def apply[A](implicit dec: Decoder[A]): Decoder[A] = dec

    def instance[A](f: Cursor => Either[String, A]): Decoder[A] = new Decoder[A] {
      def decode(cursor: Cursor): Either[String, A] = f(cursor)
    }
  }

  // Pre-defined decoders for primitive types
  implicit val stringDecoder: Decoder[String] = Decoder.instance { c =>
    c.focus match {
      case Some(JString(s)) => Right(s)
      case _                => Left("Expected String")
    }
  }

  implicit val doubleDecoder: Decoder[Double] = Decoder.instance { c =>
    c.focus match {
      case Some(JNumber(n)) => Right(n)
      case _                => Left("Expected Number")
    }
  }

  implicit val intDecoder: Decoder[Int] = Decoder.instance { c =>
    c.focus match {
      case Some(JNumber(n)) => Right(n.toInt)
      case _                => Left("Expected Number")
    }
  }

  implicit val boolDecoder: Decoder[Boolean] = Decoder.instance { c =>
    c.focus match {
      case Some(JBool(b)) => Right(b)
      case _              => Left("Expected Boolean")
    }
  }

  // Domain types
  case class Person(name: String, age: Int)
  case class Point(x: Double, y: Double)
  case class Config(host: String, port: Int, debug: Boolean)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a Decoder for Person.
  // TODO: Navigate to "name" (decode as String) and "age" (decode as Int).
  //       Combine them into a Person.
  // Hint: Use cursor.downField("name") then stringDecoder.decode(...),
  //       and similarly for age. Use for-comprehension or flatMap.
  // -------------------------------------------------------------------------
  implicit val personDecoder: Decoder[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a Decoder for Point.
  // TODO: Decode fields "x" and "y" as Double, combine into Point.
  // -------------------------------------------------------------------------
  implicit val pointDecoder: Decoder[Point] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Decoder for Config.
  // TODO: Decode "host" as String, "port" as Int, "debug" as Boolean.
  // -------------------------------------------------------------------------
  implicit val configDecoder: Decoder[Config] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Decode a List[A] given a Decoder[A].
  // TODO: If the focus is a JArray, decode each element using the given decoder.
  //       If any element fails to decode, return the first error.
  //       If the focus is not a JArray, return Left("Expected Array").
  // -------------------------------------------------------------------------
  implicit def listDecoder[A](implicit dec: Decoder[A]): Decoder[List[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Decode an Option[A] given a Decoder[A].
  // TODO: If the focus is JNull or None, return Right(None).
  //       Otherwise, attempt to decode as A and wrap in Some.
  // -------------------------------------------------------------------------
  implicit def optionDecoder[A](implicit dec: Decoder[A]): Decoder[Option[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use emap to add validation to a decoder.
  // TODO: Create a Decoder[Int] that only succeeds for positive numbers.
  //       Start with intDecoder and use emap to validate.
  //       Return Left("Must be positive") if the value is <= 0.
  // -------------------------------------------------------------------------
  def exercise6_positiveIntDecoder: Decoder[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use map to transform a decoder's output.
  // TODO: Create a Decoder[String] that decodes a String and converts to uppercase.
  //       Use stringDecoder.map(_.toUpperCase).
  // -------------------------------------------------------------------------
  def exercise7_upperCaseDecoder: Decoder[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Write a generic decode function that uses the Decoder type class.
  // TODO: Given a Json value and an implicit Decoder[A], wrap the json in a
  //       Cursor and call decoder.decode.
  //       This mirrors circe's json.as[A] syntax.
  // -------------------------------------------------------------------------
  def exercise8_decode[A](json: Json)(implicit dec: Decoder[A]): Either[String, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val personJson = JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30)))
    assert(personDecoder.decode(Cursor(Some(personJson))) == Right(Person("Alice", 30)))
    val badPerson = JObject(Map("name" -> JString("Alice")))
    assert(personDecoder.decode(Cursor(Some(badPerson))).isLeft)
    println("Exercise 1 passed: Person decoder works")

    // Exercise 2
    val pointJson = JObject(Map("x" -> JNumber(1.5), "y" -> JNumber(2.5)))
    assert(pointDecoder.decode(Cursor(Some(pointJson))) == Right(Point(1.5, 2.5)))
    println("Exercise 2 passed: Point decoder works")

    // Exercise 3
    val configJson = JObject(Map("host" -> JString("localhost"), "port" -> JNumber(8080), "debug" -> JBool(true)))
    assert(configDecoder.decode(Cursor(Some(configJson))) == Right(Config("localhost", 8080, true)))
    println("Exercise 3 passed: Config decoder works")

    // Exercise 4
    val arrayJson = JArray(Vector(JNumber(1), JNumber(2), JNumber(3)))
    assert(listDecoder[Int].decode(Cursor(Some(arrayJson))) == Right(List(1, 2, 3)))
    assert(listDecoder[Int].decode(Cursor(Some(JString("nope")))).isLeft)
    println("Exercise 4 passed: List decoder works")

    // Exercise 5
    assert(optionDecoder[String].decode(Cursor(Some(JString("hi")))) == Right(Some("hi")))
    assert(optionDecoder[String].decode(Cursor(Some(JNull))) == Right(None))
    assert(optionDecoder[String].decode(Cursor(None)) == Right(None))
    println("Exercise 5 passed: Option decoder works")

    // Exercise 6
    val posDecoder = exercise6_positiveIntDecoder
    assert(posDecoder.decode(Cursor(Some(JNumber(5)))) == Right(5))
    assert(posDecoder.decode(Cursor(Some(JNumber(-1)))).isLeft)
    assert(posDecoder.decode(Cursor(Some(JNumber(0)))).isLeft)
    println("Exercise 6 passed: positive int decoder works")

    // Exercise 7
    val upperDec = exercise7_upperCaseDecoder
    assert(upperDec.decode(Cursor(Some(JString("hello")))) == Right("HELLO"))
    println("Exercise 7 passed: uppercase decoder works")

    // Exercise 8
    assert(exercise8_decode[String](JString("hi")) == Right("hi"))
    assert(exercise8_decode[Int](JNumber(42)) == Right(42))
    assert(exercise8_decode[Person](personJson) == Right(Person("Alice", 30)))
    println("Exercise 8 passed: generic decode works")

    println("\nAll Circe004_Decoding exercises passed!")
  }
}
