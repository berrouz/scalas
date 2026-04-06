package org.shev4ik.interview.scala_core.level3_advanced

object Core100_ImplicitPriority {

  // Exercise 1: LowPriority trait
  // TODO: Define a type class with a low-priority default instance
  trait Format[T] {
    def format(t: T): String
  }

  trait LowPriorityFormat {
    // TODO: Default format for any type (lowest priority)
    implicit def defaultFormat[T]: Format[T] = ???
  }

  object Format extends LowPriorityFormat {
    def apply[T](implicit f: Format[T]): Format[T] = f

    // TODO: Higher-priority instance for Int
    implicit val intFormat: Format[Int] = ???

    // TODO: Higher-priority instance for String
    implicit val stringFormat: Format[String] = ???
  }

  def format[T](value: T)(implicit f: Format[T]): String = ???

  // Exercise 2: Priority levels (3 levels)
  // TODO: Define a type class with 3 levels of priority
  trait Describe[T] {
    def describe(t: T): String
  }

  trait LowestPriorityDescribe {
    implicit def fallback[T]: Describe[T] = ???
  }

  trait LowPriorityDescribe extends LowestPriorityDescribe {
    implicit def numericDescribe[T](implicit n: Numeric[T]): Describe[T] = ???
  }

  object Describe extends LowPriorityDescribe {
    def apply[T](implicit d: Describe[T]): Describe[T] = d

    implicit val intDescribe: Describe[Int] = ???
  }

  def describe[T](value: T)(implicit d: Describe[T]): String = ???

  // Exercise 3: Implicit not found
  // TODO: Define a type class with @implicitNotFound for clear error messages
  @annotation.implicitNotFound("No Serializer found for ${T}. Did you forget to import or define one?")
  trait Serializer[T] {
    def serialize(t: T): String
  }

  object Serializer {
    implicit val intSerializer: Serializer[Int] = ???
    implicit val stringSerializer: Serializer[String] = ???
  }

  def serialize[T](value: T)(implicit s: Serializer[T]): String = ???

  // Exercise 4: Default instances
  // TODO: Provide sensible default instances that can be overridden
  trait Config[T] {
    def defaultValue: T
  }

  trait LowPriorityConfig {
    implicit def nullDefault[T >: Null]: Config[T] = ???
  }

  object Config extends LowPriorityConfig {
    implicit val intConfig: Config[Int] = ???
    implicit val stringConfig: Config[String] = ???
    implicit val boolConfig: Config[Boolean] = ???
  }

  def getDefault[T](implicit c: Config[T]): T = ???

  // Exercise 5: Override priority
  // TODO: Show how to override a low-priority implicit with a local one
  def localOverride(): String = {
    // TODO: Define a local implicit that overrides Format.intFormat
    ???
  }

  // Exercise 6: Shadowing
  // TODO: Demonstrate implicit shadowing - local implicits shadow imported ones
  object SpecialFormats {
    implicit val intFormat: Format[Int] = new Format[Int] {
      def format(t: Int): String = s"special:$t"
    }
  }

  def withShadowing(): String = {
    // TODO: Import SpecialFormats.intFormat to shadow Format.intFormat
    ???
  }

  // Exercise 7: Priority in companion
  // TODO: Show how companion object implicits interact with priority
  case class MyType(value: Int)

  object MyType {
    // This has higher priority than any inherited trait implicits
    implicit val myTypeFormat: Format[MyType] = ???
  }

  // Exercise 8: Multi-level priority
  // TODO: Implement a full priority chain for JSON encoding
  trait JsonEncoder[T] {
    def encode(t: T): String
  }

  trait Level3JsonEncoder {
    implicit def anyEncoder[T]: JsonEncoder[T] = ???
  }

  trait Level2JsonEncoder extends Level3JsonEncoder {
    implicit def iterableEncoder[T](implicit inner: JsonEncoder[T]): JsonEncoder[Iterable[T]] = ???
  }

  trait Level1JsonEncoder extends Level2JsonEncoder {
    implicit val intEncoder: JsonEncoder[Int] = ???
    implicit val stringEncoder: JsonEncoder[String] = ???
    implicit val boolEncoder: JsonEncoder[Boolean] = ???
  }

  object JsonEncoder extends Level1JsonEncoder {
    def apply[T](implicit e: JsonEncoder[T]): JsonEncoder[T] = e

    // Highest priority: specific collection types
    implicit def listEncoder[T](implicit inner: JsonEncoder[T]): JsonEncoder[List[T]] = ???
  }

  def toJson[T](value: T)(implicit e: JsonEncoder[T]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(format(42) == "Int: 42")
    assert(format("hello") == "String: hello")
    assert(format(3.14).contains("3.14"))

    // Exercise 2
    assert(describe(42) == "Int: 42")
    assert(describe(3.14).contains("Numeric"))
    assert(describe(true).contains("Unknown") || describe(true).contains("true"))

    // Exercise 3
    assert(serialize(42) == "42")
    assert(serialize("hello") == "\"hello\"")

    // Exercise 4
    assert(getDefault[Int] == 0)
    assert(getDefault[String] == "")
    assert(getDefault[Boolean] == false)

    // Exercise 5
    assert(localOverride().contains("custom"))

    // Exercise 6
    assert(withShadowing() == "special:42")

    // Exercise 7
    assert(format(MyType(42)).contains("42"))

    // Exercise 8
    assert(toJson(42) == "42")
    assert(toJson("hello") == "\"hello\"")
    assert(toJson(true) == "true")
    assert(toJson(List(1, 2, 3)) == "[1, 2, 3]")

    println("All Core100_ImplicitPriority exercises passed!")
  }
}
