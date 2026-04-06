package org.shev4ik.interview.scala3.level2_intermediate

/**
 * Scala 3: Typeclass Derivation (derives keyword, Mirror)
 * (modeled with manual derivation patterns in Scala 2.13)
 *
 * In Scala 3, `case class Foo(x: Int) derives Eq, Show` auto-derives type class instances.
 * The Mirror trait provides compile-time reflection for product/sum types.
 * In Scala 2.13, we model this with manual derivation helpers and macro-free patterns.
 */
object Sc3_008_TypeclassDerivation {

  // === Type class definitions ===

  trait MyEq[A] {
    def eqv(a: A, b: A): Boolean
  }

  trait MyShow[A] {
    def show(a: A): String
  }

  trait MyEncoder[A] {
    def encode(a: A): Map[String, Any]
  }

  trait MyDecoder[A] {
    def decode(m: Map[String, Any]): Option[A]
  }

  // Exercise 1: Manual product derivation (Scala 3 auto-derives for case classes)
  // In Scala 3: case class Point(x: Int, y: Int) derives Eq
  // TODO: Create case class Point(x: Int, y: Int).
  //       Manually implement MyEq[Point] that compares field-by-field.
  //       This is what Scala 3 `derives` does automatically.
  case class Point(x: Int, y: Int)
  implicit val pointEq: MyEq[Point] = ???
  def exercise1_areEqual(a: Point, b: Point)(implicit eq: MyEq[Point]): Boolean = ???

  // Exercise 2: Manual Show derivation for products
  // In Scala 3: case class Person(name: String, age: Int) derives Show
  // TODO: Create case class Person(name: String, age: Int).
  //       Implement MyShow[Person] that produces "Person(name=<name>,age=<age>)".
  //       This models what Scala 3 derives would generate.
  case class Person(name: String, age: Int)
  implicit val personShow: MyShow[Person] = ???
  def exercise2_show(p: Person)(implicit s: MyShow[Person]): String = ???

  // Exercise 3: Derivation for sum types (sealed traits / enums)
  // In Scala 3: enum Shape derives Eq { case Circle(r: Double); case Rect(w: Double, h: Double) }
  // TODO: Model Shape as sealed trait with Circle and Rect case classes.
  //       Implement MyEq[Shape] that handles all combinations.
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rect(width: Double, height: Double) extends Shape
  implicit val shapeEq: MyEq[Shape] = ???
  def exercise3_shapesEqual(a: Shape, b: Shape)(implicit eq: MyEq[Shape]): Boolean = ???

  // Exercise 4: Generic product encoder (modeling Mirror.ProductOf)
  // Scala 3 Mirror provides: type MirroredElemTypes, type MirroredLabel, etc.
  // TODO: Implement MyEncoder[Person] that converts to Map("name" -> "...", "age" -> ...).
  //       Implement MyDecoder[Person] that reads from a Map.
  //       This models what Scala 3 auto-derivation does using Mirror.
  implicit val personEncoder: MyEncoder[Person] = ???
  implicit val personDecoder: MyDecoder[Person] = ???
  def exercise4_encode(p: Person)(implicit enc: MyEncoder[Person]): Map[String, Any] = ???
  def exercise4_decode(m: Map[String, Any])(implicit dec: MyDecoder[Person]): Option[Person] = ???

  // Exercise 5: Derivation combinator pattern
  // Build type class instances from smaller pieces (Scala 2 approach to what derives does).
  // TODO: Create a `ProductEq` helper that derives MyEq for case classes from their fields.
  //       Implement `tupleEq` that creates MyEq[(A, B)] from MyEq[A] and MyEq[B].
  //       Implement `tripleEq` for (A, B, C).
  //       This shows the building blocks Scala 3 automates.
  def exercise5_tupleEq[A, B](implicit ea: MyEq[A], eb: MyEq[B]): MyEq[(A, B)] = ???
  def exercise5_tripleEq[A, B, C](implicit ea: MyEq[A], eb: MyEq[B], ec: MyEq[C]): MyEq[(A, B, C)] = ???
  implicit val intEq: MyEq[Int] = ???
  implicit val stringEq: MyEq[String] = ???
  implicit val doubleEq: MyEq[Double] = ???
  def exercise5_testTupleEq(a: (Int, String), b: (Int, String)): Boolean = ???

  // Exercise 6: Sum type encoder (modeling Mirror.SumOf)
  // TODO: Implement MyEncoder[Shape] and MyDecoder[Shape].
  //       Encoding should include a "type" field: Map("type" -> "Circle", "radius" -> 5.0)
  //       Decoding should dispatch based on the "type" field.
  implicit val shapeEncoder: MyEncoder[Shape] = ???
  implicit val shapeDecoder: MyDecoder[Shape] = ???
  def exercise6_encodeShape(s: Shape)(implicit enc: MyEncoder[Shape]): Map[String, Any] = ???
  def exercise6_decodeShape(m: Map[String, Any])(implicit dec: MyDecoder[Shape]): Option[Shape] = ???

  // Exercise 7: Typeclass derivation with defaults
  // Scala 3 allows: case class Config(host: String = "localhost", port: Int = 8080) derives Decoder
  // TODO: Implement a decoder that supports default values.
  //       `decodeWithDefaults` should fill in defaults from a provided defaults map
  //       when keys are missing from the input map.
  case class AppConfig(host: String, port: Int, debug: Boolean)
  val appConfigDefaults: Map[String, Any] = Map("host" -> "localhost", "port" -> 8080, "debug" -> false)
  def exercise7_decodeWithDefaults(input: Map[String, Any]): Option[AppConfig] = ???

  // Exercise 8: Summary — the derives keyword
  // TODO: Answer conceptual questions about Scala 3 typeclass derivation.
  //       Return the answers as strings.
  // Q1: What does `case class Foo(x: Int) derives Eq` generate?
  def exercise8_q1: String = ???  // "An implicit/given Eq[Foo] instance in Foo's companion object"
  // Q2: What Scala 3 trait provides compile-time structural info about types?
  def exercise8_q2: String = ???  // "Mirror (Mirror.ProductOf for case classes, Mirror.SumOf for enums/sealed traits)"
  // Q3: What is the Scala 2 equivalent pattern for derives?
  def exercise8_q3: String = ???  // "Manual implicit instances or Shapeless-based generic derivation"
  // Q4: Can derives work with any type class in Scala 3?
  def exercise8_q4: String = ???  // "Only type classes that define a derived method using Mirror"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_areEqual(Point(1, 2), Point(1, 2)), "Exercise 1 failed: equal points")
    assert(!exercise1_areEqual(Point(1, 2), Point(3, 4)), "Exercise 1 failed: unequal points")

    // Exercise 2
    assert(exercise2_show(Person("Alice", 30)) == "Person(name=Alice,age=30)", "Exercise 2 failed")

    // Exercise 3
    assert(exercise3_shapesEqual(Circle(5.0), Circle(5.0)), "Exercise 3 failed: equal circles")
    assert(!exercise3_shapesEqual(Circle(5.0), Rect(5.0, 5.0)), "Exercise 3 failed: different shapes")

    // Exercise 4
    val encoded = exercise4_encode(Person("Bob", 25))
    assert(encoded == Map("name" -> "Bob", "age" -> 25), "Exercise 4 encode failed")
    assert(exercise4_decode(Map("name" -> "Bob", "age" -> 25)) == Some(Person("Bob", 25)), "Exercise 4 decode failed")
    assert(exercise4_decode(Map("name" -> "Bob")) == None, "Exercise 4 decode missing field failed")

    // Exercise 5
    assert(exercise5_testTupleEq((1, "a"), (1, "a")), "Exercise 5 equal failed")
    assert(!exercise5_testTupleEq((1, "a"), (2, "b")), "Exercise 5 unequal failed")

    // Exercise 6
    val circleMap = exercise6_encodeShape(Circle(5.0))
    assert(circleMap("type") == "Circle", "Exercise 6 encode type failed")
    assert(circleMap("radius") == 5.0, "Exercise 6 encode radius failed")
    assert(exercise6_decodeShape(Map("type" -> "Circle", "radius" -> 5.0)) == Some(Circle(5.0)), "Exercise 6 decode failed")
    assert(exercise6_decodeShape(Map("type" -> "Rect", "width" -> 3.0, "height" -> 4.0)) == Some(Rect(3.0, 4.0)), "Exercise 6 decode rect failed")

    // Exercise 7
    assert(exercise7_decodeWithDefaults(Map("host" -> "prod.example.com", "port" -> 9090, "debug" -> true))
      == Some(AppConfig("prod.example.com", 9090, true)), "Exercise 7 full config failed")
    assert(exercise7_decodeWithDefaults(Map.empty)
      == Some(AppConfig("localhost", 8080, false)), "Exercise 7 all defaults failed")
    assert(exercise7_decodeWithDefaults(Map("debug" -> true))
      == Some(AppConfig("localhost", 8080, true)), "Exercise 7 partial config failed")

    // Exercise 8
    assert(exercise8_q1 == "An implicit/given Eq[Foo] instance in Foo's companion object", "Exercise 8 Q1 failed")
    assert(exercise8_q2 == "Mirror (Mirror.ProductOf for case classes, Mirror.SumOf for enums/sealed traits)", "Exercise 8 Q2 failed")
    assert(exercise8_q3 == "Manual implicit instances or Shapeless-based generic derivation", "Exercise 8 Q3 failed")
    assert(exercise8_q4 == "Only type classes that define a derived method using Mirror", "Exercise 8 Q4 failed")

    println("All Sc3_008_TypeclassDerivation exercises passed!")
  }
}
