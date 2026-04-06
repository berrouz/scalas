package org.shev4ik.interview.scala_core.level2_intermediate

object Core038_TypeClasses {

  // Exercise 1: Typeclass trait
  // TODO: Define a type class `Jsonable[A]` with a single method `toJson(a: A): String`
  trait Jsonable[A] {
    def toJson(a: A): String
  }

  // Exercise 2: Typeclass instance
  // TODO: Create Jsonable instances for Int, String, and List[A] (where A: Jsonable)
  implicit val intJsonable: Jsonable[Int] = ???
  implicit val stringJsonable: Jsonable[String] = ???
  implicit def listJsonable[A](implicit ja: Jsonable[A]): Jsonable[List[A]] = ???

  // Exercise 3: Typeclass interface (object method)
  // TODO: Create a Jsonable companion object with an `apply` summoner
  //       and a `toJson` convenience method
  object Jsonable {
    def apply[A](implicit instance: Jsonable[A]): Jsonable[A] = ???
    def toJson[A: Jsonable](a: A): String = ???
  }

  // Exercise 4: Typeclass interface (syntax / extension methods)
  // TODO: Create syntax via implicit class so you can write `42.toJson`
  object JsonSyntax {
    implicit class JsonOps[A](val a: A) extends AnyVal {
      def toJson(implicit j: Jsonable[A]): String = ???
    }
  }

  // Exercise 5: Context bound sugar
  // TODO: Implement a method `serializeAll` using context bound syntax
  //       that converts a List[A] to List[String] using Jsonable
  def serializeAll[A: Jsonable](items: List[A]): List[String] = ???

  // Exercise 6: Typeclass derivation concept
  // TODO: Create a Jsonable instance for Option[A] given a Jsonable[A]
  //       None should serialize to "null", Some(a) should delegate to A's instance
  implicit def optionJsonable[A](implicit ja: Jsonable[A]): Jsonable[Option[A]] = ???

  // Exercise 7: Ad-hoc polymorphism
  // TODO: Define a type class `Combinable[A]` with method `combine(a: A, b: A): A`
  //       Create instances for Int (addition), String (concatenation), List[A] (append)
  trait Combinable[A] {
    def combine(a: A, b: A): A
  }
  implicit val intCombinable: Combinable[Int] = ???
  implicit val stringCombinable: Combinable[String] = ???
  implicit def listCombinable[A]: Combinable[List[A]] = ???

  def combineAll[A: Combinable](items: List[A], zero: A): A = ???

  // Exercise 8: Typeclass vs inheritance
  // TODO: Demonstrate the advantage of type classes over inheritance.
  //       Create a type class `Printable[A]` and provide instances for
  //       types you don't control: Int, String, and (A, B) tuples
  trait Printable[A] {
    def prettyPrint(a: A): String
  }
  implicit val intPrintable: Printable[Int] = ???
  implicit val stringPrintable: Printable[String] = ???
  implicit def tuplePrintable[A, B](implicit pa: Printable[A], pb: Printable[B]): Printable[(A, B)] = ???

  def prettyPrint[A: Printable](a: A): String = ???

  def main(args: Array[String]): Unit = {
    import JsonSyntax._

    // Exercise 1 & 2 assertions
    assert(intJsonable.toJson(42) == "42", "Int toJson")
    assert(stringJsonable.toJson("hello") == "\"hello\"", "String toJson")

    // Exercise 3 assertions
    assert(Jsonable.toJson(42) == "42", "Jsonable.toJson for Int")
    assert(Jsonable[Int].toJson(42) == "42", "Jsonable[Int] summoner")

    // Exercise 4 assertions
    assert(42.toJson == "42", "syntax: 42.toJson")
    assert("hello".toJson == "\"hello\"", "syntax: string.toJson")

    // Exercise 5 assertions
    assert(serializeAll(List(1, 2, 3)) == List("1", "2", "3"), "serializeAll ints")

    // Exercise 6 assertions
    assert(Jsonable.toJson(Some(42): Option[Int]) == "42", "Some(42) toJson")
    assert(Jsonable.toJson(None: Option[Int]) == "null", "None toJson")

    // Exercise 7 assertions
    assert(combineAll(List(1, 2, 3, 4), 0) == 10, "combineAll ints")
    assert(combineAll(List("a", "b", "c"), "") == "abc", "combineAll strings")
    assert(combineAll(List(List(1), List(2), List(3)), List.empty[Int]) == List(1, 2, 3), "combineAll lists")

    // Exercise 8 assertions
    assert(prettyPrint(42) == "42", "prettyPrint Int")
    assert(prettyPrint("hello") == "hello", "prettyPrint String")
    assert(prettyPrint((1, "two")) == "(1, two)", "prettyPrint tuple")

    println("All Core038_TypeClasses exercises passed!")
  }
}
