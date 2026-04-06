package org.shev4ik.interview.scala_core.level3_advanced

object Core092_TypeBoundsAdvanced {

  // Exercise 1: Multiple bounds
  // TODO: Write a method with both upper and lower bounds on the same type parameter
  //       T must be a supertype of Int and a subtype of AnyVal
  def wrapNumeric[T >: Int <: AnyVal](value: T): List[T] = ???

  // Exercise 2: Union type simulation
  // TODO: Simulate union types in Scala 2 using a type class
  //       Define IsStringOrInt[T] that only exists for String and Int
  sealed trait IsStringOrInt[T]
  object IsStringOrInt {
    implicit val forInt: IsStringOrInt[Int] = new IsStringOrInt[Int] {}
    implicit val forString: IsStringOrInt[String] = new IsStringOrInt[String] {}
  }

  // TODO: Write a method that only accepts String or Int
  def stringOrInt[T](value: T)(implicit ev: IsStringOrInt[T]): String = ???

  // Exercise 3: Type constraint evidence
  // TODO: Use =:= (type equality) and <:< (subtype) evidence
  def requireEqual[A, B](a: A, b: B)(implicit ev: A =:= B): B = ???
  def requireSubtype[A, B](a: A)(implicit ev: A <:< B): B = ???

  // Exercise 4: Bounded abstract types
  // TODO: Define a trait with bounded abstract type members
  trait NumberContainer {
    type N <: Number
    def value: N
    def doubleValue: Double
  }

  // TODO: Implement for java.lang.Integer
  def intContainer(i: Int): NumberContainer { type N = java.lang.Integer } = ???

  // Exercise 5: Recursive bounds
  // TODO: Define a type with recursive bounds (similar to Enum in Java)
  trait Enum[E <: Enum[E]] { self: E =>
    def name: String
    def compareTo(other: E): Int
  }

  // TODO: Implement for a simple Color enum
  sealed abstract class ColorEnum(val name: String, val ordinal: Int) extends Enum[ColorEnum] {
    def compareTo(other: ColorEnum): Int = ???
  }

  case object RedE extends ColorEnum("Red", 0)
  case object GreenE extends ColorEnum("Green", 1)
  case object BlueE extends ColorEnum("Blue", 2)

  // Exercise 6: Mutual bounds
  // TODO: Define two type parameters that are bounded by each other
  trait Convertible[A, B] {
    def convert(a: A): B
  }

  trait BiConvertible[A, B] {
    def toB(a: A): B
    def toA(b: B): A
  }

  // TODO: Implement BiConvertible for String and List[Char]
  implicit val stringCharList: BiConvertible[String, List[Char]] = ???

  def roundTrip[A, B](a: A)(implicit bc: BiConvertible[A, B]): A = ???

  // Exercise 7: Context bounds + upper bounds
  // TODO: Combine context bounds with upper bounds
  trait Printable[T] {
    def print(t: T): String
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    def print(t: Int): String = s"Int($t)"
  }

  // TODO: Write a method with both context bound and upper bound
  def printValue[T <: AnyVal : Printable](value: T): String = ???

  // Exercise 8: Generalized type constraints
  // TODO: Use generalized type constraints for a method that only works
  //       when the collection element type is a specific type
  class SpecialList[A](val items: List[A]) {
    // TODO: This method should only be available when A =:= Int
    def sum(implicit ev: A =:= Int): Int = ???

    // TODO: This method should only be available when A <:< Comparable[A]
    def sorted(implicit ev: A <:< Comparable[A], ord: Ordering[A]): List[A] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(wrapNumeric(42) == List(42))

    // Exercise 2
    assert(stringOrInt(42) == "Int: 42")
    assert(stringOrInt("hello") == "String: hello")

    // Exercise 3
    assert(requireEqual(42, 42) == 42)
    val str: Any = requireSubtype[String, Any]("hello")
    assert(str == "hello")

    // Exercise 4
    val ic = intContainer(42)
    assert(ic.doubleValue == 42.0)

    // Exercise 5
    assert(RedE.compareTo(GreenE) < 0)
    assert(BlueE.compareTo(RedE) > 0)
    assert(GreenE.compareTo(GreenE) == 0)

    // Exercise 6
    assert(roundTrip[String, List[Char]]("hello") == "hello")

    // Exercise 7
    assert(printValue(42) == "Int(42)")

    // Exercise 8
    val intList = new SpecialList(List(1, 2, 3))
    assert(intList.sum == 6)

    println("All Core092_TypeBoundsAdvanced exercises passed!")
  }
}
