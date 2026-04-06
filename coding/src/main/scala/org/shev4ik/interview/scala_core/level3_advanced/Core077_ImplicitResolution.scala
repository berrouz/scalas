package org.shev4ik.interview.scala_core.level3_advanced

object Core077_ImplicitResolution {

  // Exercise 1: Implicit scope - local scope
  // TODO: Define a type class Show[T] and resolve an implicit from local scope
  trait Show[T] {
    def show(t: T): String
  }

  object Show {
    def apply[T](implicit s: Show[T]): Show[T] = s
  }

  // TODO: Create a method that uses an implicit Show[T] to convert to string
  def stringify[T](value: T)(implicit s: Show[T]): String = ???

  // Exercise 2: Companion object implicit scope
  // TODO: Define a case class MyValue and put a Show instance in its companion object
  //       The implicit should be found automatically without import
  case class MyValue(x: Int)

  object MyValue {
    // TODO: Define implicit Show[MyValue] here
    implicit val showMyValue: Show[MyValue] = ???
  }

  // Exercise 3: Package object concept
  // TODO: Define implicit instances that would typically live in a package object
  //       For this exercise, put them in a trait that simulates package object behavior
  trait DefaultInstances {
    implicit val showInt: Show[Int] = new Show[Int] {
      def show(t: Int): String = t.toString
    }
    implicit val showString: Show[String] = new Show[String] {
      def show(t: String): String = s""""$t""""
    }
  }

  object Defaults extends DefaultInstances

  // Exercise 4: Implicit priority
  // TODO: Demonstrate implicit priority: local > import > companion > package
  //       Define a method that shows which implicit is selected
  trait Priority {
    def level: String
  }

  object LowPriorityImplicits {
    implicit val lowPriority: Priority = new Priority { val level = "low" }
  }

  // TODO: Define a method that takes an implicit Priority and returns its level
  def currentPriority(implicit p: Priority): String = ???

  // Exercise 5: Implicit not found
  // TODO: Create a type class with @implicitNotFound annotation
  @annotation.implicitNotFound("No Encoder found for type ${T}. Define an implicit Encoder[${T}].")
  trait Encoder[T] {
    def encode(t: T): String
  }

  // TODO: Implement Encoder for Int and String
  implicit val intEncoder: Encoder[Int] = ???
  implicit val stringEncoder: Encoder[String] = ???

  def encode[T](value: T)(implicit enc: Encoder[T]): String = ???

  // Exercise 6: Ambiguous implicits
  // TODO: Create a scenario where two implicits of the same type exist
  //       and show how to resolve the ambiguity using explicit parameter
  trait Formatter {
    def format(s: String): String
  }

  val upperFormatter: Formatter = new Formatter {
    def format(s: String): String = s.toUpperCase
  }

  val lowerFormatter: Formatter = new Formatter {
    def format(s: String): String = s.toLowerCase
  }

  // TODO: Define a method that takes an explicit Formatter (not implicit) to avoid ambiguity
  def formatWith(s: String)(formatter: Formatter): String = ???

  // Exercise 7: @implicitNotFound custom message
  // TODO: Define a type class CanConvert[A, B] with @implicitNotFound
  @annotation.implicitNotFound("Cannot convert from ${A} to ${B}")
  trait CanConvert[A, B] {
    def convert(a: A): B
  }

  // TODO: Implement CanConvert[String, Int] and CanConvert[Int, String]
  implicit val stringToInt: CanConvert[String, Int] = ???
  implicit val intToString: CanConvert[Int, String] = ???

  def convert[A, B](a: A)(implicit cc: CanConvert[A, B]): B = ???

  // Exercise 8: Debugging implicit resolution
  // TODO: Create a method that manually searches for an implicit and returns
  //       information about whether it was found, simulating implicitly[T]
  def findImplicit[T](implicit ev: T = null.asInstanceOf[T]): Option[T] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    implicit val localShowInt: Show[Int] = new Show[Int] {
      def show(t: Int): String = s"number:$t"
    }
    assert(stringify(42) == "number:42")

    // Exercise 2
    assert(stringify(MyValue(10)) == "MyValue(10)" || stringify(MyValue(10)).contains("10"))

    // Exercise 3
    import Defaults._
    assert(showString.show("hello") == "\"hello\"")
    assert(showInt.show(42) == "42")

    // Exercise 4
    implicit val highPriority: Priority = new Priority { val level = "high" }
    assert(currentPriority == "high")

    // Exercise 5
    assert(encode(42) == "42")
    assert(encode("hello") == "hello")

    // Exercise 6
    assert(formatWith("Hello")(upperFormatter) == "HELLO")
    assert(formatWith("Hello")(lowerFormatter) == "hello")

    // Exercise 7
    assert(convert[String, Int]("42") == 42)
    assert(convert[Int, String](42) == "42")

    // Exercise 8
    assert(findImplicit[Show[String]].isDefined)

    println("All Core077_ImplicitResolution exercises passed!")
  }
}
