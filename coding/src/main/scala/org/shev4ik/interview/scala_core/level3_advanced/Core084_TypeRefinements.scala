package org.shev4ik.interview.scala_core.level3_advanced

object Core084_TypeRefinements {

  // Exercise 1: Structural refinement
  // TODO: Write a method that takes any object with a `name: String` method
  //       using structural typing (duck typing)
  import scala.language.reflectiveCalls
  def getName(obj: { def name: String }): String = ???

  // Exercise 2: Type refinement
  // TODO: Define a trait with a type member and create a refined type
  trait Container {
    type Element
    def get: Element
    def put(e: Element): Container
  }

  // TODO: Create an IntContainer as a refinement of Container
  def makeIntContainer(value: Int): Container { type Element = Int } = ???

  // Exercise 3: Refined types
  // TODO: Create a simple "refined type" that validates at construction time
  //       NonEmptyString is a String that is guaranteed non-empty
  case class NonEmptyString private (value: String) extends AnyVal

  object NonEmptyString {
    // TODO: Return Option[NonEmptyString] - None if string is empty
    def from(s: String): Option[NonEmptyString] = ???
  }

  // TODO: Create PositiveInt
  case class PositiveInt private (value: Int) extends AnyVal

  object PositiveInt {
    def from(i: Int): Option[PositiveInt] = ???
  }

  // Exercise 4: Compile-time validation concept
  // TODO: Create a simple Email validated type (runtime validation, type-safe wrapper)
  case class Email private (value: String)

  object Email {
    def from(s: String): Either[String, Email] = ???
  }

  // Exercise 5: Refinement type intersection
  // TODO: Write a method that requires an object with BOTH a name and an age method
  def getNameAndAge(obj: { def name: String; def age: Int }): (String, Int) = ???

  // Exercise 6: Refinement type alias
  // TODO: Create a type alias for a structural type and use it
  type Named = { def name: String }
  type Aged = { def age: Int }

  // TODO: Write a method that works with Named
  def greetNamed(named: Named): String = ???

  // Exercise 7: Reflective calls warning
  // TODO: Demonstrate structural types work but use reflection under the hood.
  //       Create a method using structural types and show it works with any conforming object.
  def callClose(resource: { def close(): Unit; def isOpen: Boolean }): Boolean = ???

  // Exercise 8: Refinement vs trait
  // TODO: Show the trait-based alternative to structural typing (preferred in practice)
  trait HasName {
    def name: String
  }

  trait HasAge {
    def age: Int
  }

  case class Person(name: String, age: Int) extends HasName with HasAge

  // TODO: Write methods using traits instead of structural types
  def getNameTrait(obj: HasName): String = ???
  def getAgeTrait(obj: HasAge): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val obj1 = new { def name: String = "Alice" }
    assert(getName(obj1) == "Alice")

    // Exercise 2
    val container = makeIntContainer(42)
    assert(container.get == 42)

    // Exercise 3
    assert(NonEmptyString.from("hello").isDefined)
    assert(NonEmptyString.from("").isEmpty)
    assert(PositiveInt.from(5).isDefined)
    assert(PositiveInt.from(-1).isEmpty)
    assert(PositiveInt.from(0).isEmpty)

    // Exercise 4
    assert(Email.from("user@example.com").isRight)
    assert(Email.from("invalid").isLeft)

    // Exercise 5
    val person = new { def name = "Bob"; def age = 25 }
    assert(getNameAndAge(person) == ("Bob", 25))

    // Exercise 6
    val named = new { def name = "Charlie" }
    assert(greetNamed(named) == "Hello, Charlie")

    // Exercise 7
    var closed = false
    val resource = new {
      def isOpen: Boolean = !closed
      def close(): Unit = { closed = true }
    }
    assert(callClose(resource) == false) // should be closed after calling close
    assert(closed == true)

    // Exercise 8
    val p = Person("Diana", 30)
    assert(getNameTrait(p) == "Diana")
    assert(getAgeTrait(p) == 30)

    println("All Core084_TypeRefinements exercises passed!")
  }
}
