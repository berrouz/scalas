package org.shev4ik.interview.circe.level1_basics

/**
 * Circe 005 - Semi-Automatic Derivation
 *
 * In circe, semi-automatic derivation uses macros (deriveEncoder/deriveDecoder)
 * to automatically generate Encoder/Decoder instances for case classes and sealed
 * traits. You must explicitly call the derivation in the companion object or
 * at the use site.
 *
 * In real circe: import io.circe.generic.semiauto.{deriveEncoder, deriveDecoder}
 *
 * In this exercise we simulate the concept by building a "derivation" mechanism
 * using a product-based approach: given encoders/decoders for each field, we
 * compose them into an encoder/decoder for the case class.
 *
 * Key concepts: deriveEncoder, deriveDecoder, Codec (Encoder + Decoder pair),
 * companion object placement, sealed trait derivation.
 */
object Circe005_SemiAutoDerivation {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Encoder
  trait Encoder[A] { def apply(a: A): Json }
  object Encoder {
    def apply[A](implicit enc: Encoder[A]): Encoder[A] = enc
    def instance[A](f: A => Json): Encoder[A] = new Encoder[A] { def apply(a: A): Json = f(a) }
  }

  // Simplified Decoder
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

  // A Codec combines Encoder and Decoder
  case class Codec[A](encoder: Encoder[A], decoder: Decoder[A])

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

  // Domain types
  case class User(name: String, email: String)
  case class Product(id: Int, name: String, price: Double)
  case class Wrapper[A](value: A)

  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape

  // -------------------------------------------------------------------------
  // Exercise 1: Simulate deriveEncoder for User.
  // TODO: Create an Encoder[User] that encodes as JObject with "name" and "email".
  //       In real circe, this would be: implicit val enc = deriveEncoder[User]
  // -------------------------------------------------------------------------
  implicit val userEncoder: Encoder[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Simulate deriveDecoder for User.
  // TODO: Create a Decoder[User] that decodes "name" and "email" fields.
  //       In real circe, this would be: implicit val dec = deriveDecoder[User]
  // -------------------------------------------------------------------------
  implicit val userDecoder: Decoder[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Simulate deriveEncoder for Product.
  // TODO: Encode Product as JObject with "id", "name", "price" fields.
  // -------------------------------------------------------------------------
  implicit val productEncoder: Encoder[Product] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Simulate deriveDecoder for Product.
  // TODO: Decode Product from a JObject with "id", "name", "price" fields.
  // -------------------------------------------------------------------------
  implicit val productDecoder: Decoder[Product] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a Codec[User] by combining encoder and decoder.
  // TODO: Return a Codec that pairs the userEncoder and userDecoder.
  //       In real circe, you might define both in the companion object.
  // -------------------------------------------------------------------------
  def exercise5_userCodec: Codec[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Simulate deriveEncoder for a sealed trait (Shape).
  // TODO: Encode Shape by including a "type" discriminator field:
  //   Circle(r)     => {"type": "Circle", "radius": r}
  //   Rectangle(w,h) => {"type": "Rectangle", "width": w, "height": h}
  //   In real circe, sealed traits are handled via deriveEncoder with
  //   a default wrapper or configurable discriminator.
  // -------------------------------------------------------------------------
  implicit val shapeEncoder: Encoder[Shape] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Simulate deriveDecoder for a sealed trait (Shape).
  // TODO: Decode Shape by reading the "type" field to determine the subtype,
  //       then decode the corresponding fields.
  // -------------------------------------------------------------------------
  implicit val shapeDecoder: Decoder[Shape] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Demonstrate round-trip encoding/decoding (codec test).
  // TODO: Given a value of type A, encode it to Json then decode it back.
  //       Return Right(a) if the round-trip succeeds, Left(error) otherwise.
  //       This verifies that encoder and decoder are consistent.
  // -------------------------------------------------------------------------
  def exercise8_roundTrip[A](value: A)(implicit enc: Encoder[A], dec: Decoder[A]): Either[String, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val user = User("Alice", "alice@example.com")
    assert(userEncoder(user) == JObject(Map("name" -> JString("Alice"), "email" -> JString("alice@example.com"))))
    println("Exercise 1 passed: User encoder works")

    // Exercise 2
    val userJson = JObject(Map("name" -> JString("Bob"), "email" -> JString("bob@example.com")))
    assert(userDecoder.decode(Cursor(Some(userJson))) == Right(User("Bob", "bob@example.com")))
    println("Exercise 2 passed: User decoder works")

    // Exercise 3
    val prod = Product(1, "Widget", 9.99)
    assert(productEncoder(prod) == JObject(Map("id" -> JNumber(1.0), "name" -> JString("Widget"), "price" -> JNumber(9.99))))
    println("Exercise 3 passed: Product encoder works")

    // Exercise 4
    val prodJson = JObject(Map("id" -> JNumber(2.0), "name" -> JString("Gadget"), "price" -> JNumber(19.99)))
    assert(productDecoder.decode(Cursor(Some(prodJson))) == Right(Product(2, "Gadget", 19.99)))
    println("Exercise 4 passed: Product decoder works")

    // Exercise 5
    val codec = exercise5_userCodec
    assert(codec.encoder(user) == JObject(Map("name" -> JString("Alice"), "email" -> JString("alice@example.com"))))
    assert(codec.decoder.decode(Cursor(Some(userJson))) == Right(User("Bob", "bob@example.com")))
    println("Exercise 5 passed: Codec works")

    // Exercise 6
    val circle: Shape = Circle(5.0)
    val rect: Shape = Rectangle(3.0, 4.0)
    assert(shapeEncoder(circle) == JObject(Map("type" -> JString("Circle"), "radius" -> JNumber(5.0))))
    assert(shapeEncoder(rect) == JObject(Map("type" -> JString("Rectangle"), "width" -> JNumber(3.0), "height" -> JNumber(4.0))))
    println("Exercise 6 passed: Shape encoder works")

    // Exercise 7
    val circleJson = JObject(Map("type" -> JString("Circle"), "radius" -> JNumber(5.0)))
    val rectJson = JObject(Map("type" -> JString("Rectangle"), "width" -> JNumber(3.0), "height" -> JNumber(4.0)))
    assert(shapeDecoder.decode(Cursor(Some(circleJson))) == Right(Circle(5.0)))
    assert(shapeDecoder.decode(Cursor(Some(rectJson))) == Right(Rectangle(3.0, 4.0)))
    println("Exercise 7 passed: Shape decoder works")

    // Exercise 8
    assert(exercise8_roundTrip(user) == Right(user))
    assert(exercise8_roundTrip(prod) == Right(prod))
    println("Exercise 8 passed: round-trip works")

    println("\nAll Circe005_SemiAutoDerivation exercises passed!")
  }
}
