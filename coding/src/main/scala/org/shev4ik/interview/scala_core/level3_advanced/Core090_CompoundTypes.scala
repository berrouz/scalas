package org.shev4ik.interview.scala_core.level3_advanced

object Core090_CompoundTypes {

  // Exercise 1: with for compound types
  // TODO: Define traits Resettable and Updatable, and a method that requires both
  trait Resettable {
    def reset(): String
  }

  trait Updatable {
    def update(value: String): String
  }

  // TODO: Write a method that takes something that is both Resettable and Updatable
  def resetAndUpdate(obj: Resettable with Updatable, value: String): (String, String) = ???

  // Exercise 2: Intersection types concept
  // TODO: Define multiple traits and create a value that satisfies all of them
  trait Printable {
    def print: String
  }

  trait Serializable2 {
    def serialize: Array[Byte]
  }

  trait Loggable {
    def log: String
  }

  // TODO: Create an object that implements all three traits
  def createAllInOne(data: String): Printable with Serializable2 with Loggable = ???

  // Exercise 3: Compound type inference
  // TODO: Show how the compiler infers compound types
  trait A { def a: String = "A" }
  trait B { def b: String = "B" }

  class AB extends A with B

  // TODO: Write a method that returns the inferred compound type
  def makeAB(): A with B = ???

  // Exercise 4: Mixin composition
  // TODO: Define a mixin-based system with stackable modifications
  trait Base {
    def process(s: String): String
  }

  trait UpperCase extends Base {
    abstract override def process(s: String): String = super.process(s.toUpperCase)
  }

  trait Trimmed extends Base {
    abstract override def process(s: String): String = super.process(s.trim)
  }

  trait Prefixed extends Base {
    abstract override def process(s: String): String = super.process(s"[processed] $s")
  }

  class BasicProcessor extends Base {
    def process(s: String): String = s
  }

  // TODO: Create a processor that trims, uppercases, and prefixes (using mixin)
  def createProcessor(): Base = ???

  // Exercise 5: Structural intersection
  // TODO: Use structural types combined with named traits
  import scala.language.reflectiveCalls

  trait HasName { def name: String }
  trait HasAge { def age: Int }

  def describePerson(p: HasName with HasAge): String = ???

  // Exercise 6: Compound type as bound
  // TODO: Write a generic method that requires its type parameter to extend multiple traits
  trait Measurable {
    def measure: Double
  }

  trait Comparable2 {
    def compareTo(other: Double): Int
  }

  def measureAndCompare[T <: Measurable with Comparable2](item: T, threshold: Double): (Double, Int) = ???

  // Exercise 7: Anonymous compound
  // TODO: Create an anonymous class with compound type
  def createAnonymous(): Resettable with Updatable = ???

  // Exercise 8: Compound with refinement
  // TODO: Combine compound types with structural refinement
  trait Container {
    type Elem
    def elements: List[Elem]
  }

  trait Sizeable {
    def size: Int
  }

  // TODO: Write a method that requires both Container and Sizeable, with Elem = String
  type StringContainerWithSize = Container with Sizeable { type Elem = String }
  def processContainer(c: StringContainerWithSize): (List[String], Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val obj = new Resettable with Updatable {
      def reset(): String = "reset"
      def update(value: String): String = s"updated: $value"
    }
    val (r, u) = resetAndUpdate(obj, "hello")
    assert(r == "reset")
    assert(u == "updated: hello")

    // Exercise 2
    val allInOne = createAllInOne("test")
    assert(allInOne.print == "test")
    assert(new String(allInOne.serialize) == "test")
    assert(allInOne.log.contains("test"))

    // Exercise 3
    val ab = makeAB()
    assert(ab.a == "A")
    assert(ab.b == "B")

    // Exercise 4
    val processor = createProcessor()
    assert(processor.process("  hello  ").contains("HELLO"))

    // Exercise 5
    val person = new HasName with HasAge {
      def name: String = "Alice"
      def age: Int = 30
    }
    assert(describePerson(person) == "Alice, age 30")

    // Exercise 6
    val item = new Measurable with Comparable2 {
      def measure: Double = 42.0
      def compareTo(other: Double): Int = 42.0.compareTo(other)
    }
    val (m, c) = measureAndCompare(item, 40.0)
    assert(m == 42.0)
    assert(c > 0)

    // Exercise 7
    val anon = createAnonymous()
    assert(anon.reset() == "reset")
    assert(anon.update("test") == "updated: test")

    // Exercise 8
    val container = new Container with Sizeable {
      type Elem = String
      def elements: List[String] = List("a", "b", "c")
      def size: Int = 3
    }
    val (elems, sz) = processContainer(container)
    assert(elems == List("a", "b", "c"))
    assert(sz == 3)

    println("All Core090_CompoundTypes exercises passed!")
  }
}
