package org.shev4ik.interview.scala_core.level4_expert

/**
 * Core118 - Literal and Singleton Types
 * Level: Expert
 *
 * Literal types in Scala 2.13 via singleton types and .type.
 * Full literal type parameters (x: 42) are Scala 3 — here we use
 * Scala 2.13 patterns: .type, ValueOf, and singleton witnesses.
 *
 * Key concepts:
 * - Singleton types with .type
 * - ValueOf for literal materialization
 * - Type-safe APIs via singleton patterns
 */
object Core118_LiteralTypes {

  // Exercise 1: Singleton object types
  // TODO: Use .type to accept only a specific singleton object
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color

  def describeRed(c: Red.type): String = ???
  def describeGreen(c: Green.type): String = ???

  // Exercise 2: Singleton val types
  // TODO: Demonstrate .type on val references for singleton types
  val mySpecialValue: Int = 42

  // In Scala 2.13, stable identifiers can serve as singleton types
  // In Scala 2.12, .type on val references is limited to AnyRef; simplify for 2.12
  def acceptSpecial(x: Int): Int = ???

  // Exercise 3: ValueOf type class
  // TODO: Use a custom ValueOf to materialize values at the type level (scala.ValueOf is 2.13+)
  trait ValueOf[T] { def value: T }
  object ValueOf {
    implicit val intValue: ValueOf[Int] = new ValueOf[Int] { def value = 42 }
    implicit val stringValue: ValueOf[String] = new ValueOf[String] { def value = "hello" }
  }
  def materialize[T](implicit v: ValueOf[T]): T = ???

  // Exercise 4: Type-safe configuration using singleton types
  // TODO: Create a config system where keys are singleton types
  trait ConfigKey {
    type Value
    def key: String
  }

  object HostKey extends ConfigKey {
    type Value = String
    val key = "host"
  }

  object PortKey extends ConfigKey {
    type Value = Int
    val key = "port"
  }

  trait ConfigStore {
    def get(k: ConfigKey): k.Value
  }

  def exercise4(): ConfigStore = ???

  // Exercise 5: Refined types (smart constructors)
  // TODO: Create refined types with compile-time-like safety via smart constructors
  case class Port private (value: Int)

  object Port {
    def from(p: Int): Option[Port] = ???
  }

  case class NonEmptyString private (value: String)

  object NonEmptyString {
    def from(s: String): Option[NonEmptyString] = ???
  }

  case class Percentage private (value: Double)

  object Percentage {
    def from(d: Double): Option[Percentage] = ???
  }

  // Exercise 6: Type-safe HTTP method API
  // TODO: Use singleton types for type-safe route definitions
  sealed trait HttpMethod
  case object GET extends HttpMethod
  case object POST extends HttpMethod
  case object PUT extends HttpMethod
  case object DELETE extends HttpMethod

  trait Route[M <: HttpMethod] {
    def path: String
    def method: M
  }

  def getRoute(p: String): Route[GET.type] = ???
  def postRoute(p: String): Route[POST.type] = ???

  // Exercise 7: Witness pattern (Shapeless-style)
  // TODO: Implement a Witness that carries a value at the type level
  trait Witness {
    type T
    val value: T
  }

  object Witness {
    type Aux[T0] = Witness { type T = T0 }

    def apply[T0](v: T0): Aux[T0] = ???
  }

  // Exercise 8: TypeName type class
  // TODO: Implement a type class that returns the name of a type
  trait TypeName[T] {
    def name: String
  }

  implicit val intName: TypeName[Int] = new TypeName[Int] { def name = "Int" }
  implicit val stringName: TypeName[String] = new TypeName[String] { def name = "String" }
  implicit val boolName: TypeName[Boolean] = new TypeName[Boolean] { def name = "Boolean" }

  def typeName[T](implicit tn: TypeName[T]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(describeRed(Red) == "Red")
    assert(describeGreen(Green) == "Green")
    println("Exercise 1 passed: Singleton object types")

    // Exercise 5
    assert(Port.from(8080).isDefined)
    assert(Port.from(-1).isEmpty)
    assert(Port.from(70000).isEmpty)
    assert(NonEmptyString.from("hello").isDefined)
    assert(NonEmptyString.from("").isEmpty)
    assert(Percentage.from(0.5).isDefined)
    assert(Percentage.from(1.5).isEmpty)
    println("Exercise 5 passed: Refined types")

    // Exercise 6
    val route = getRoute("/api/users")
    assert(route.path == "/api/users")
    assert(route.method == GET)
    println("Exercise 6 passed: Type-safe routes")

    // Exercise 7
    val w = Witness(42)
    assert(w.value == 42)
    println("Exercise 7 passed: Witness pattern")

    // Exercise 8
    assert(typeName[Int] == "Int")
    assert(typeName[String] == "String")
    assert(typeName[Boolean] == "Boolean")
    println("Exercise 8 passed: TypeName")

    println("\nAll Core118 exercises passed!")
  }
}
