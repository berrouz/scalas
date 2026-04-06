package org.shev4ik.interview.circe.level2_intermediate

/**
 * Circe 007 - Custom Codecs
 *
 * In real circe projects, you often need to customize how types are encoded/decoded:
 *   - Custom field names (e.g. snake_case in JSON, camelCase in Scala)
 *   - Custom key mappings
 *   - Sealed trait discriminators (type field name/value)
 *   - Wrapping/unwrapping single-field types
 *
 * In real circe: use @JsonCodec, Configuration, or manual Encoder/Decoder.
 *
 * Key concepts: custom key transformations, snake_case conversion,
 * discriminator fields, sealed trait encoding strategies.
 */
object Circe007_CustomCodecs {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  trait Encoder[A] { def apply(a: A): Json }
  object Encoder {
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
    def instance[A](f: Cursor => Either[String, A]): Decoder[A] = new Decoder[A] {
      def decode(cursor: Cursor): Either[String, A] = f(cursor)
    }
  }

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

  // Domain types
  case class UserProfile(firstName: String, lastName: String, emailAddress: String)
  case class ApiResponse(statusCode: Int, errorMessage: String, isSuccess: Boolean)

  sealed trait Animal
  case class Dog(name: String, breed: String) extends Animal
  case class Cat(name: String, indoor: Boolean) extends Animal
  case class Fish(species: String) extends Animal

  case class Wrapper(value: String)
  case class Tagged(tag: String, payload: Json)

  // -------------------------------------------------------------------------
  // Exercise 1: Implement camelCase to snake_case conversion.
  // TODO: Convert "firstName" => "first_name", "emailAddress" => "email_address".
  // Hint: Insert '_' before each uppercase letter, then lowercase everything.
  // -------------------------------------------------------------------------
  def exercise1_toSnakeCase(camelCase: String): String = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Encode UserProfile with snake_case keys.
  // TODO: Encode as JObject but use snake_case field names:
  //   "first_name", "last_name", "email_address"
  //   In real circe, this is done via Configuration with snakeCaseTransformation.
  // -------------------------------------------------------------------------
  def exercise2_snakeCaseEncoder: Encoder[UserProfile] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Decode UserProfile from snake_case JSON.
  // TODO: Read "first_name", "last_name", "email_address" from JSON.
  // -------------------------------------------------------------------------
  def exercise3_snakeCaseDecoder: Decoder[UserProfile] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Encode a sealed trait with a custom discriminator field.
  // TODO: Encode Animal with a "kind" discriminator (not the default "type"):
  //   Dog("Rex", "Lab")  => {"kind": "dog", "name": "Rex", "breed": "Lab"}
  //   Cat("Mew", true)   => {"kind": "cat", "name": "Mew", "indoor": true}
  //   Fish("Goldfish")    => {"kind": "fish", "species": "Goldfish"}
  //   Note: discriminator values are lowercase.
  // -------------------------------------------------------------------------
  def exercise4_customDiscriminatorEncoder: Encoder[Animal] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Decode a sealed trait using the custom discriminator.
  // TODO: Read "kind" to determine subtype, then decode fields accordingly.
  // -------------------------------------------------------------------------
  def exercise5_customDiscriminatorDecoder: Decoder[Animal] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Encode a single-field case class as an unwrapped value.
  // TODO: Instead of {"value": "hello"}, encode Wrapper("hello") as just "hello".
  //       In circe, this is done with Encoder[String].contramap[Wrapper](_.value).
  // -------------------------------------------------------------------------
  def exercise6_unwrappedEncoder: Encoder[Wrapper] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Decode an unwrapped value into a single-field case class.
  // TODO: Decode a raw JString into Wrapper. "hello" => Wrapper("hello").
  // -------------------------------------------------------------------------
  def exercise7_unwrappedDecoder: Decoder[Wrapper] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a custom key-mapping encoder that applies an
  //             arbitrary transformation function to all field names.
  // TODO: Given a key transformation function (String => String) and a list
  //       of (originalFieldName, Json) pairs, produce a JObject with
  //       transformed keys. This generalizes snake_case, kebab-case, etc.
  // -------------------------------------------------------------------------
  def exercise8_keyMappingEncoder(transform: String => String, fields: List[(String, Json)]): Json = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_toSnakeCase("firstName") == "first_name")
    assert(exercise1_toSnakeCase("emailAddress") == "email_address")
    assert(exercise1_toSnakeCase("statusCode") == "status_code")
    assert(exercise1_toSnakeCase("name") == "name")
    println("Exercise 1 passed: snake_case conversion works")

    // Exercise 2
    val profile = UserProfile("Alice", "Smith", "alice@test.com")
    assert(exercise2_snakeCaseEncoder(profile) == JObject(Map(
      "first_name" -> JString("Alice"),
      "last_name" -> JString("Smith"),
      "email_address" -> JString("alice@test.com")
    )))
    println("Exercise 2 passed: snake_case encoder works")

    // Exercise 3
    val profileJson = JObject(Map(
      "first_name" -> JString("Bob"),
      "last_name" -> JString("Jones"),
      "email_address" -> JString("bob@test.com")
    ))
    assert(exercise3_snakeCaseDecoder.decode(Cursor(Some(profileJson))) == Right(UserProfile("Bob", "Jones", "bob@test.com")))
    println("Exercise 3 passed: snake_case decoder works")

    // Exercise 4
    val enc = exercise4_customDiscriminatorEncoder
    assert(enc(Dog("Rex", "Lab")) == JObject(Map("kind" -> JString("dog"), "name" -> JString("Rex"), "breed" -> JString("Lab"))))
    assert(enc(Cat("Mew", true)) == JObject(Map("kind" -> JString("cat"), "name" -> JString("Mew"), "indoor" -> JBool(true))))
    assert(enc(Fish("Goldfish")) == JObject(Map("kind" -> JString("fish"), "species" -> JString("Goldfish"))))
    println("Exercise 4 passed: custom discriminator encoder works")

    // Exercise 5
    val dec = exercise5_customDiscriminatorDecoder
    val dogJson = JObject(Map("kind" -> JString("dog"), "name" -> JString("Rex"), "breed" -> JString("Lab")))
    val catJson = JObject(Map("kind" -> JString("cat"), "name" -> JString("Mew"), "indoor" -> JBool(true)))
    val fishJson = JObject(Map("kind" -> JString("fish"), "species" -> JString("Goldfish")))
    assert(dec.decode(Cursor(Some(dogJson))) == Right(Dog("Rex", "Lab")))
    assert(dec.decode(Cursor(Some(catJson))) == Right(Cat("Mew", true)))
    assert(dec.decode(Cursor(Some(fishJson))) == Right(Fish("Goldfish")))
    println("Exercise 5 passed: custom discriminator decoder works")

    // Exercise 6
    assert(exercise6_unwrappedEncoder(Wrapper("hello")) == JString("hello"))
    assert(exercise6_unwrappedEncoder(Wrapper("")) == JString(""))
    println("Exercise 6 passed: unwrapped encoder works")

    // Exercise 7
    assert(exercise7_unwrappedDecoder.decode(Cursor(Some(JString("world")))) == Right(Wrapper("world")))
    assert(exercise7_unwrappedDecoder.decode(Cursor(Some(JNumber(42)))).isLeft)
    println("Exercise 7 passed: unwrapped decoder works")

    // Exercise 8
    val fields = List("firstName" -> JString("A"), "lastName" -> JString("B"))
    assert(exercise8_keyMappingEncoder(exercise1_toSnakeCase, fields) == JObject(Map(
      "first_name" -> JString("A"), "last_name" -> JString("B")
    )))
    val upper: String => String = _.toUpperCase
    assert(exercise8_keyMappingEncoder(upper, List("name" -> JString("X"))) == JObject(Map("NAME" -> JString("X"))))
    println("Exercise 8 passed: key mapping encoder works")

    println("\nAll Circe007_CustomCodecs exercises passed!")
  }
}
