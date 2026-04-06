package org.shev4ik.interview.circe.level1_basics

/**
 * Circe 003 - Encoding (Encoder Type Class)
 *
 * In circe, Encoder[A] is a type class that converts a value of type A into Json.
 * It has a single abstract method: def apply(a: A): Json.
 *
 * Encoders can be composed using contramap: if you have Encoder[B] and a function
 * A => B, you can derive Encoder[A].
 *
 * Key concepts: Encoder trait, manual encoder creation, contramap, encoding
 * case classes, encoding collections.
 */
object Circe003_Encoding {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Encoder type class mirroring circe's io.circe.Encoder
  trait Encoder[A] {
    def apply(a: A): Json

    def contramap[B](f: B => A): Encoder[B] = {
      val self = this
      new Encoder[B] {
        def apply(b: B): Json = self.apply(f(b))
      }
    }
  }

  object Encoder {
    def apply[A](implicit enc: Encoder[A]): Encoder[A] = enc

    def instance[A](f: A => Json): Encoder[A] = new Encoder[A] {
      def apply(a: A): Json = f(a)
    }
  }

  // Pre-defined encoders for primitive types
  implicit val stringEncoder: Encoder[String] = Encoder.instance(JString)
  implicit val doubleEncoder: Encoder[Double] = Encoder.instance(JNumber)
  implicit val intEncoder: Encoder[Int] = Encoder.instance(i => JNumber(i.toDouble))
  implicit val boolEncoder: Encoder[Boolean] = Encoder.instance(JBool)

  // Domain types
  case class Person(name: String, age: Int)
  case class Address(street: String, city: String, zip: String)
  case class Employee(person: Person, role: String, salary: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a manual Encoder for Person.
  // TODO: Encode Person as a JObject with fields "name" (JString) and "age" (JNumber).
  // -------------------------------------------------------------------------
  implicit val personEncoder: Encoder[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a manual Encoder for Address.
  // TODO: Encode Address as a JObject with fields "street", "city", "zip"
  //       (all JString).
  // -------------------------------------------------------------------------
  implicit val addressEncoder: Encoder[Address] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Encode a List[A] given an Encoder[A].
  // TODO: Implement a generic Encoder for List[A] that produces a JArray.
  // Hint: Map each element using the given Encoder[A], then wrap in JArray.
  // -------------------------------------------------------------------------
  implicit def listEncoder[A](implicit enc: Encoder[A]): Encoder[List[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Encode an Option[A] given an Encoder[A].
  // TODO: Some(a) should encode as enc(a), None should encode as JNull.
  // -------------------------------------------------------------------------
  implicit def optionEncoder[A](implicit enc: Encoder[A]): Encoder[Option[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create an Encoder for Employee using nested encoding.
  // TODO: Encode Employee as a JObject with fields:
  //   "person" -> encoded Person (use personEncoder)
  //   "role"   -> JString
  //   "salary" -> JNumber
  // -------------------------------------------------------------------------
  implicit val employeeEncoder: Encoder[Employee] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use contramap to derive an Encoder[Int] from Encoder[Double].
  // TODO: Use doubleEncoder.contramap to create an Encoder[Int].
  //       The function should convert Int to Double.
  // -------------------------------------------------------------------------
  def exercise6_contramapEncoder: Encoder[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Encode a Map[String, A] given an Encoder[A].
  // TODO: Produce a JObject where each key maps to the encoded value.
  // -------------------------------------------------------------------------
  implicit def mapEncoder[A](implicit enc: Encoder[A]): Encoder[Map[String, A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Write a generic encode function that uses the Encoder type class.
  // TODO: Given a value of type A and an implicit Encoder[A], return the Json.
  //       This mirrors circe's .asJson syntax extension.
  // -------------------------------------------------------------------------
  def exercise8_encode[A](value: A)(implicit enc: Encoder[A]): Json = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val alice = Person("Alice", 30)
    assert(personEncoder(alice) == JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30.0))))
    println("Exercise 1 passed: Person encoder works")

    // Exercise 2
    val addr = Address("123 Main St", "Springfield", "62701")
    assert(addressEncoder(addr) == JObject(Map(
      "street" -> JString("123 Main St"),
      "city" -> JString("Springfield"),
      "zip" -> JString("62701")
    )))
    println("Exercise 2 passed: Address encoder works")

    // Exercise 3
    val names = List("Alice", "Bob", "Charlie")
    assert(listEncoder[String].apply(names) == JArray(Vector(
      JString("Alice"), JString("Bob"), JString("Charlie")
    )))
    assert(listEncoder[Int].apply(List(1, 2, 3)) == JArray(Vector(
      JNumber(1.0), JNumber(2.0), JNumber(3.0)
    )))
    println("Exercise 3 passed: List encoder works")

    // Exercise 4
    assert(optionEncoder[String].apply(Some("hello")) == JString("hello"))
    assert(optionEncoder[String].apply(None) == JNull)
    println("Exercise 4 passed: Option encoder works")

    // Exercise 5
    val emp = Employee(Person("Bob", 25), "Engineer", 75000.0)
    val empJson = employeeEncoder(emp)
    assert(empJson == JObject(Map(
      "person" -> JObject(Map("name" -> JString("Bob"), "age" -> JNumber(25.0))),
      "role" -> JString("Engineer"),
      "salary" -> JNumber(75000.0)
    )))
    println("Exercise 5 passed: Employee encoder works")

    // Exercise 6
    val intEnc = exercise6_contramapEncoder
    assert(intEnc(42) == JNumber(42.0))
    assert(intEnc(-1) == JNumber(-1.0))
    println("Exercise 6 passed: contramap encoder works")

    // Exercise 7
    val scores = Map("alice" -> 95, "bob" -> 87)
    assert(mapEncoder[Int].apply(scores) == JObject(Map(
      "alice" -> JNumber(95.0),
      "bob" -> JNumber(87.0)
    )))
    println("Exercise 7 passed: Map encoder works")

    // Exercise 8
    assert(exercise8_encode("hello") == JString("hello"))
    assert(exercise8_encode(42) == JNumber(42.0))
    assert(exercise8_encode(alice) == JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30.0))))
    println("Exercise 8 passed: generic encode works")

    println("\nAll Circe003_Encoding exercises passed!")
  }
}
