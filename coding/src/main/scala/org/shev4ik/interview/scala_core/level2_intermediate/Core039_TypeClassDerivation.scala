package org.shev4ik.interview.scala_core.level2_intermediate

object Core039_TypeClassDerivation {

  // Exercise 1: Derive Show
  // TODO: Define a type class `Show[A]` with method `show(a: A): String`
  //       Create instances for Int, String, Boolean, and derive for case classes
  //       by manually implementing for a Person(name: String, age: Int)
  trait Show[A] {
    def show(a: A): String
  }
  object Show {
    def apply[A](implicit s: Show[A]): Show[A] = s
    implicit val intShow: Show[Int] = ???
    implicit val stringShow: Show[String] = ???
    implicit val boolShow: Show[Boolean] = ???
  }

  case class Person(name: String, age: Int)
  // TODO: Create a Show[Person] that outputs "Person(name=..., age=...)"
  implicit val personShow: Show[Person] = ???

  // Exercise 2: Derive Eq
  // TODO: Define a type class `Eq[A]` with method `eqv(a: A, b: A): Boolean`
  //       Create instances for Int, String, and derive for Person
  trait Eq[A] {
    def eqv(a: A, b: A): Boolean
  }
  implicit val intEq: Eq[Int] = ???
  implicit val stringEq: Eq[String] = ???
  implicit val personEq: Eq[Person] = ???

  // Exercise 3: Derive Ordering
  // TODO: Create an Ordering[Person] that sorts by age, then by name
  implicit val personOrdering: Ordering[Person] = ???

  // Exercise 4: Derive JsonEncoder
  // TODO: Define a trait JsonEncoder[A] with method `encode(a: A): String`
  //       Create instances for Int, String, Boolean
  //       Derive for Person producing: {"name":"...","age":...}
  trait JsonEncoder[A] {
    def encode(a: A): String
  }
  object JsonEncoder {
    implicit val intEncoder: JsonEncoder[Int] = ???
    implicit val stringEncoder: JsonEncoder[String] = ???
    implicit val boolEncoder: JsonEncoder[Boolean] = ???
  }
  implicit val personEncoder: JsonEncoder[Person] = ???

  // Exercise 5: Derive from product
  // TODO: Implement a generic product encoder for tuples (A, B)
  //       given JsonEncoder[A] and JsonEncoder[B], produce [encodedA, encodedB]
  implicit def tupleEncoder[A, B](implicit ea: JsonEncoder[A], eb: JsonEncoder[B]): JsonEncoder[(A, B)] = ???

  // Exercise 6: Derive from coproduct
  // TODO: Define a sealed trait Shape with Circle(radius: Double) and Rectangle(w: Double, h: Double)
  //       Create a Show[Shape] that handles both cases
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape

  implicit val shapeShow: Show[Shape] = ???

  // Exercise 7: Semi-automatic derivation
  // TODO: Create a method `deriveShow` that, given Show instances for all fields,
  //       creates a Show for a simple wrapper class. Demonstrate for Wrapper(value: Int).
  case class Wrapper(value: Int)
  // Semi-auto: user explicitly calls derive
  def deriveWrapperShow(implicit intShow: Show[Int]): Show[Wrapper] = ???

  // Exercise 8: Auto derivation concept
  // TODO: Create implicit def that automatically derives Show for Option[A]
  //       given Show[A]. None shows as "None", Some(a) shows as "Some(show(a))"
  implicit def optionShow[A](implicit sa: Show[A]): Show[Option[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(Show[Int].show(42) == "42", "Show Int")
    assert(Show[String].show("hello") == "hello", "Show String")
    val alice = Person("Alice", 30)
    assert(personShow.show(alice) == "Person(name=Alice, age=30)", "Show Person")

    // Exercise 2 assertions
    assert(intEq.eqv(1, 1), "Eq Int equal")
    assert(!intEq.eqv(1, 2), "Eq Int not equal")
    assert(personEq.eqv(alice, Person("Alice", 30)), "Eq Person equal")
    assert(!personEq.eqv(alice, Person("Bob", 30)), "Eq Person not equal")

    // Exercise 3 assertions
    val people = List(Person("Bob", 25), Person("Alice", 30), Person("Alice", 25))
    val sorted = people.sorted
    assert(sorted == List(Person("Alice", 25), Person("Bob", 25), Person("Alice", 30)), "Person ordering by age then name")

    // Exercise 4 assertions
    assert(personEncoder.encode(alice) == """{"name":"Alice","age":30}""", "JsonEncoder Person")

    // Exercise 5 assertions
    assert(tupleEncoder[Int, String].encode((1, "hello")) == """[1,"hello"]""", "tuple encoder")

    // Exercise 6 assertions
    assert(shapeShow.show(Circle(5.0)).contains("Circle"), "Show Circle")
    assert(shapeShow.show(Rectangle(3.0, 4.0)).contains("Rectangle"), "Show Rectangle")

    // Exercise 7 assertions
    val wrapperShow = deriveWrapperShow
    assert(wrapperShow.show(Wrapper(42)) == "Wrapper(value=42)", "derived Wrapper Show")

    // Exercise 8 assertions
    assert(optionShow[Int].show(Some(42)) == "Some(42)", "Show Some")
    assert(optionShow[Int].show(None) == "None", "Show None")

    println("All Core039_TypeClassDerivation exercises passed!")
  }
}
