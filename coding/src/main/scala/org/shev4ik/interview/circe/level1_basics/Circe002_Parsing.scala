package org.shev4ik.interview.circe.level1_basics

/**
 * Circe 002 - Parsing and Navigating JSON
 *
 * =Overview=
 * Circe is a '''pure functional JSON library''' for Scala, built on Cats. It is the
 * de facto standard for JSON handling in Typelevel/Cats Effect projects. Circe emphasizes
 * immutability, type safety, and composability over runtime reflection or mutation.
 *
 * =Parsing: String => Json AST=
 * Circe uses '''jawn''' (a fast, streaming JSON parser) under the hood:
 * {{{
 *   import io.circe.parser._
 *   val result: Either[ParsingFailure, Json] = parse("""{"name":"Alice","age":30}""")
 * }}}
 * Parsing always returns `Either` -- it never throws exceptions. `ParsingFailure` contains
 * the error message and the location in the input where parsing failed.
 *
 * =Cursor-Based Navigation (HCursor)=
 * Once parsed, you navigate the JSON tree using '''cursors''' rather than unsafe `.get` calls:
 *  - '''HCursor''': A cursor focused on a position in the JSON tree
 *  - '''downField("name")''': Move into an object field (returns a new cursor)
 *  - '''downArray''': Move into the first element of an array
 *  - '''downN(i)''': Move to the i-th array element
 *  - '''as[A]''': Decode the focused value into Scala type A (returns `Either[DecodingFailure, A]`)
 *  - Cursors are '''composable''': `cursor.downField("address").downField("city").as[String]`
 *
 * =Codec Derivation=
 * Circe supports multiple ways to create Encoder/Decoder instances:
 *  - '''circe-generic''' (semi-automatic): `deriveEncoder[A]`, `deriveDecoder[A]` using Shapeless
 *  - '''circe-generic-extras''': Customizable (snake_case keys, default values, discriminator fields)
 *  - '''Manual codecs''': Full control via `Encoder.instance[A]` and `Decoder.instance[A]`
 *  - '''@JsonCodec annotation''': Macro-based automatic derivation (compile-time generation)
 *
 * =Key Types=
 *  - `Json`: Algebraic data type (JNull, JBoolean, JNumber, JString, JArray, JObject)
 *  - `Encoder[A]`: Converts `A => Json`
 *  - `Decoder[A]`: Converts `HCursor => Either[DecodingFailure, A]`
 *  - `Codec[A]`: Combined Encoder + Decoder
 *
 * =Real-World Usage=
 * In production http4s + Circe services, you typically:
 *  1. Define case classes for your domain model
 *  2. Derive codecs: `implicit val codec: Codec[User] = deriveCodec[User]`
 *  3. Use `EntityDecoder` / `EntityEncoder` integration: `req.as[User]`, `Ok(user)`
 *  4. Handle missing/malformed JSON via `Either` composition -- no exceptions
 *
 * =Interview Tip=
 * ''"Circe vs Play JSON vs spray-json -- when would you choose each?"''
 *
 * '''Answer:''' Circe is the standard choice for Typelevel/Cats Effect projects -- it is
 * immutable, type-safe, and integrates seamlessly with http4s. Play JSON is tightly coupled
 * to the Play framework and uses mutable builders internally. spray-json is legacy (tied to
 * Akka/Spray) and lacks Cats integration. For new projects using Cats Effect / http4s / ZIO,
 * Circe is the clear winner due to its ecosystem integration, cursor-based navigation, and
 * excellent codec derivation.
 *
 * In this exercise we build a simplified parser to understand how circe's
 * `io.circe.parser.parse` works, including error handling and cursor navigation.
 */
object Circe002_Parsing {

  // Reuse the Json ADT from Circe001
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified error type mirroring circe's ParsingFailure
  case class ParsingFailure(message: String)

  // Simplified cursor for navigating JSON structures
  case class Cursor(focus: Option[Json]) {
    def downField(name: String): Cursor = focus match {
      case Some(JObject(fields)) => Cursor(fields.get(name))
      case _                     => Cursor(None)
    }

    def downArray: Cursor = focus match {
      case Some(JArray(vs)) if vs.nonEmpty => Cursor(Some(vs.head))
      case _                               => Cursor(None)
    }

    def as[A](implicit f: Json => Option[A]): Either[String, A] =
      focus.flatMap(f) match {
        case Some(a) => Right(a)
        case None    => Left("Decoding failed")
      }
  }

  implicit val extractString: Json => Option[String] = {
    case JString(s) => Some(s)
    case _          => None
  }

  implicit val extractDouble: Json => Option[Double] = {
    case JNumber(n) => Some(n)
    case _          => None
  }

  implicit val extractBoolean: Json => Option[Boolean] = {
    case JBool(b) => Some(b)
    case _        => None
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Implement a simple parse function that handles basic JSON.
  // TODO: Parse a raw string to Json. Support these cases:
  //   "null"           => Right(JNull)
  //   "true"           => Right(JBool(true))
  //   "false"          => Right(JBool(false))
  //   starts with '"'  => Right(JString(content without quotes))
  //   numeric string   => Right(JNumber(value))
  //   anything else    => Left(ParsingFailure("Invalid JSON"))
  // Hint: Use s.trim, s.toDoubleOption for number parsing.
  // -------------------------------------------------------------------------
  def exercise1_parseSimple(raw: String): Either[ParsingFailure, Json] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use the Cursor to navigate into a field of a JObject.
  // TODO: Given a Json object and a field name, return the focused Json
  //       wrapped in Option. Use Cursor(Some(json)).downField(name).focus.
  // -------------------------------------------------------------------------
  def exercise2_navigateField(json: Json, fieldName: String): Option[Json] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Chain multiple downField calls to access a nested value.
  // TODO: Given json like {"a": {"b": {"c": 42}}}, extract the value at a.b.c.
  //       Return the focused Json as Option.
  // -------------------------------------------------------------------------
  def exercise3_navigateNested(json: Json, path: List[String]): Option[Json] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use cursor.as[String] to extract a string from a field.
  // TODO: Navigate to the given field and decode as String.
  //       Return Either[String, String].
  // -------------------------------------------------------------------------
  def exercise4_decodeField(json: Json, fieldName: String): Either[String, String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Parse and then navigate. Combine parse + cursor navigation.
  // TODO: Given a raw JSON string (a simple object like {"name":"Alice"}),
  //       first parse it manually by building the JObject, then navigate
  //       to the given field. For this exercise, assume the input is a
  //       pre-built Json and just navigate.
  //       Return the focused value as Option[Json].
  // -------------------------------------------------------------------------
  def exercise5_parseAndNavigate(json: Json, field: String): Option[Json] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Handle parse errors gracefully using Either.
  // TODO: Attempt to parse the raw string. If successful, return the Json
  //       as a Right. If it fails, return a Left with the error message string.
  //       Use exercise1_parseSimple and map the Left side to its message.
  // -------------------------------------------------------------------------
  def exercise6_handleParseError(raw: String): Either[String, Json] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Extract a Double from a nested path.
  // TODO: Navigate the json using the given path (list of field names),
  //       then extract the value as Double using cursor.as[Double].
  // -------------------------------------------------------------------------
  def exercise7_extractNestedDouble(json: Json, path: List[String]): Either[String, Double] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Navigate into the first element of a JSON array field.
  // TODO: Given json like {"items": [1, 2, 3]}, navigate to field "items"
  //       then use downArray to focus on the first element.
  //       Return the focused Json as Option.
  // -------------------------------------------------------------------------
  def exercise8_navigateArrayHead(json: Json, arrayField: String): Option[Json] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_parseSimple("null") == Right(JNull))
    assert(exercise1_parseSimple("true") == Right(JBool(true)))
    assert(exercise1_parseSimple("false") == Right(JBool(false)))
    assert(exercise1_parseSimple("\"hello\"") == Right(JString("hello")))
    assert(exercise1_parseSimple("42.0") == Right(JNumber(42.0)))
    assert(exercise1_parseSimple("???").isLeft)
    println("Exercise 1 passed: simple parsing works")

    // Exercise 2
    val obj = JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30)))
    assert(exercise2_navigateField(obj, "name") == Some(JString("Alice")))
    assert(exercise2_navigateField(obj, "missing") == None)
    println("Exercise 2 passed: field navigation works")

    // Exercise 3
    val nested = JObject(Map("a" -> JObject(Map("b" -> JObject(Map("c" -> JNumber(42)))))))
    assert(exercise3_navigateNested(nested, List("a", "b", "c")) == Some(JNumber(42)))
    assert(exercise3_navigateNested(nested, List("a", "x")) == None)
    println("Exercise 3 passed: nested navigation works")

    // Exercise 4
    assert(exercise4_decodeField(obj, "name") == Right("Alice"))
    assert(exercise4_decodeField(obj, "age").isLeft)
    println("Exercise 4 passed: field decoding works")

    // Exercise 5
    assert(exercise5_parseAndNavigate(obj, "name") == Some(JString("Alice")))
    assert(exercise5_parseAndNavigate(obj, "unknown") == None)
    println("Exercise 5 passed: parse and navigate works")

    // Exercise 6
    assert(exercise6_handleParseError("true") == Right(JBool(true)))
    assert(exercise6_handleParseError("!!!").isLeft)
    println("Exercise 6 passed: error handling works")

    // Exercise 7
    assert(exercise7_extractNestedDouble(nested, List("a", "b", "c")) == Right(42.0))
    assert(exercise7_extractNestedDouble(nested, List("a", "x")).isLeft)
    println("Exercise 7 passed: nested double extraction works")

    // Exercise 8
    val withArray = JObject(Map("items" -> JArray(Vector(JNumber(10), JNumber(20)))))
    assert(exercise8_navigateArrayHead(withArray, "items") == Some(JNumber(10)))
    assert(exercise8_navigateArrayHead(obj, "name") == None)
    println("Exercise 8 passed: array head navigation works")

    println("\nAll Circe002_Parsing exercises passed!")
  }
}
