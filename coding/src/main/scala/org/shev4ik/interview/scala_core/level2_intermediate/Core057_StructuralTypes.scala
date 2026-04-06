package org.shev4ik.interview.scala_core.level2_intermediate

import scala.language.reflectiveCalls

object Core057_StructuralTypes {

  // Exercise 1: Structural type
  // TODO: Define a method that accepts any object with a `name: String` method
  //       using structural typing (duck typing)
  def getName(obj: { def name: String }): String = ???

  // Exercise 2: Duck typing
  // TODO: Define a method that accepts any object with a `close(): Unit` method
  //       Call close and return "closed"
  def closeIt(resource: { def close(): Unit }): String = ???

  // Exercise 3: Reflective calls
  // TODO: Note: structural types in Scala use reflection at runtime (performance cost)
  //       Define a type alias for a structural type and use it
  type Closeable = { def close(): Unit; def isOpen: Boolean }

  def checkAndClose(resource: Closeable): String = ???

  // Exercise 4: Structural type with refinement
  // TODO: Create a method that accepts an object with both
  //       `read(): String` and `write(s: String): Unit` methods
  type ReadWrite = {
    def read(): String
    def write(s: String): Unit
  }

  def copyContent(from: { def read(): String }, to: ReadWrite): Unit = ???

  // Exercise 5: Structural subtyping
  // TODO: Show that any class matching the structure works, without extending a trait
  //       Create two unrelated classes that both have `area: Double`
  //       and a method that works with both via structural typing
  class Circle2(val radius: Double) {
    def area: Double = ???
  }
  class Square(val side: Double) {
    def area: Double = ???
  }

  def getArea(shape: { def area: Double }): Double = ???

  // Exercise 6: Performance implications
  // TODO: Structural types use reflection which has performance overhead
  //       Compare calling via structural type vs trait
  //       Return a note about performance
  trait Sized {
    def size: Int
  }
  class MyCollection(val elements: List[Int]) extends Sized {
    def size: Int = ???
  }

  // Using trait (fast, no reflection)
  def sizeViaTrait(s: Sized): Int = ???
  // Using structural type (slow, uses reflection)
  def sizeViaStructural(s: { def size: Int }): Int = ???

  // Exercise 7: Structural types in generics
  // TODO: Create a generic method that works with any type having a `toInt: Int` method
  def extractInt(obj: { def toInt: Int }): Int = ???

  // Exercise 8: Structural types vs traits
  // TODO: Demonstrate when to prefer traits over structural types
  //       Create a method using a trait (preferred for performance and clarity)
  //       and an equivalent using structural types
  trait Describable {
    def describe: String
  }

  class Product(val name: String, val price: Double) extends Describable {
    def describe: String = ???
  }

  // Trait-based (preferred)
  def describeViaTrait(d: Describable): String = ???
  // Structural type (more flexible but slower)
  def describeViaStructural(d: { def describe: String }): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val person = new { def name: String = "Alice" }
    assert(getName(person) == "Alice", "getName should work with structural type")

    // Exercise 2 assertions
    var wasClosed = false
    val resource = new { def close(): Unit = { wasClosed = true } }
    assert(closeIt(resource) == "closed", "closeIt should return 'closed'")
    assert(wasClosed, "close should have been called")

    // Exercise 3 assertions
    // Using a simpler test
    val closeable2 = new {
      var _open = true
      def close(): Unit = { _open = false }
      def isOpen: Boolean = _open
    }
    val result3 = checkAndClose(closeable2)
    assert(result3.nonEmpty, "checkAndClose should return a message")

    // Exercise 4 assertions
    var storage = ""
    val reader = new { def read(): String = "hello" }
    val writer = new {
      def read(): String = storage
      def write(s: String): Unit = { storage = s }
    }
    copyContent(reader, writer)
    assert(storage == "hello", "copyContent should copy from reader to writer")

    // Exercise 5 assertions
    assert(math.abs(getArea(new Circle2(5.0)) - 78.5398) < 0.01, "circle area")
    assert(getArea(new Square(4.0)) == 16.0, "square area")

    // Exercise 6 assertions
    val coll = new MyCollection(List(1, 2, 3))
    assert(sizeViaTrait(coll) == 3, "size via trait")
    assert(sizeViaStructural(coll) == 3, "size via structural")

    // Exercise 7 assertions
    assert(extractInt(new { def toInt: Int = 42 }) == 42, "extractInt from structural")

    // Exercise 8 assertions
    val prod = new Product("Widget", 9.99)
    assert(describeViaTrait(prod).contains("Widget"), "describe via trait")
    assert(describeViaStructural(prod).contains("Widget"), "describe via structural")

    println("All Core057_StructuralTypes exercises passed!")
  }
}
