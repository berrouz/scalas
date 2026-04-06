package org.shev4ik.interview.scala_core.level3_advanced

object Core082_AuxPattern {

  // Exercise 1: Aux type alias
  // TODO: Define a type class TypeSize[T] with a type member `Size` and a value `size: Int`.
  //       Then define an Aux type alias.
  trait TypeSize[T] {
    type Size
    def size: Int
  }

  object TypeSize {
    // Aux pattern: expose the type member as a type parameter
    type Aux[T, S] = TypeSize[T] { type Size = S }

    // TODO: Define instance for Int where Size = Int (4 bytes)
    implicit val intSize: TypeSize.Aux[Int, Int] = ???

    // TODO: Define instance for String where Size = Long (variable length)
    implicit val stringSize: TypeSize.Aux[String, Long] = ???
  }

  // Exercise 2: Type-level computation result
  // TODO: Define a type class that computes the result type of appending two HList-like structures
  sealed trait HList
  case class HCons[H, T <: HList](head: H, tail: T) extends HList
  case object HNil extends HList {
    type HNilType = HNil.type
  }

  trait Append[A, B] {
    type Out
    def apply(a: A, b: B): Out
  }

  object Append {
    type Aux[A, B, O] = Append[A, B] { type Out = O }

    // TODO: Base case: appending HNil to B gives B
    implicit def nilAppend[B]: Append.Aux[HNil.type, B, B] = ???
  }

  // Exercise 3: Dependent types with Aux
  // TODO: Define a type class Second[L] that extracts the second element type from a pair-like type
  trait Second[L] {
    type Out
    def apply(l: L): Out
  }

  object Second {
    type Aux[L, O] = Second[L] { type Out = O }

    // TODO: Implement for (A, B) tuples
    implicit def tupleSecond[A, B]: Second.Aux[(A, B), B] = ???
  }

  // TODO: Write a method that uses Second with Aux to return the second element
  def getSecond[L](l: L)(implicit s: Second[L]): s.Out = ???

  // Exercise 4: Shapeless-style Aux
  // TODO: Define a Generic-like type class that converts between a case class and its representation
  trait MyGeneric[T] {
    type Repr
    def to(t: T): Repr
    def from(r: Repr): T
  }

  object MyGeneric {
    type Aux[T, R] = MyGeneric[T] { type Repr = R }

    // TODO: Implement for a simple case class Point(x: Int, y: Int) => (Int, Int)
    case class Point(x: Int, y: Int)

    implicit val pointGeneric: MyGeneric.Aux[Point, (Int, Int)] = ???
  }

  // Exercise 5: Chaining dependent types
  // TODO: Write a method that chains two Aux-pattern type classes together
  //       First extract the second element, then get its type size
  def secondElementSize[L, S](l: L)(implicit
    sec: Second.Aux[L, S],
    ts: TypeSize[S]
  ): Int = ???

  // Exercise 6: Aux for type inference
  // TODO: Define a type class Converter that depends on another type class for its output type
  trait Converter[A] {
    type Target
    def convert(a: A): Target
  }

  object Converter {
    type Aux[A, T] = Converter[A] { type Target = T }

    // TODO: Int converts to String
    implicit val intConverter: Converter.Aux[Int, String] = ???

    // TODO: String converts to Int (parse)
    implicit val stringConverter: Converter.Aux[String, Int] = ???
  }

  def convert[A](a: A)(implicit c: Converter[A]): c.Target = ???

  // Exercise 7: Aux for implicit resolution
  // TODO: Write a method that uses Aux to help the compiler resolve the correct implicit chain
  trait Serializer[T] {
    def serialize(t: T): String
  }

  implicit val intSerializer: Serializer[Int] = new Serializer[Int] {
    def serialize(t: Int): String = t.toString
  }
  implicit val stringSerializer: Serializer[String] = new Serializer[String] {
    def serialize(t: String): String = s""""$t""""
  }

  // TODO: Write `convertAndSerialize` that converts A to its Target, then serializes Target
  def convertAndSerialize[A, T](a: A)(implicit
    conv: Converter.Aux[A, T],
    ser: Serializer[T]
  ): String = ???

  // Exercise 8: Aux alternatives
  // TODO: Show an alternative to Aux using dependent method types
  //       Write a method that achieves the same as Aux but without the type alias
  def convertDirect[A](a: A)(implicit c: Converter[A]): c.Target = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(implicitly[TypeSize[Int]].size == 4)
    assert(implicitly[TypeSize[String]].size > 0)

    // Exercise 3
    assert(getSecond((1, "hello")) == "hello")
    assert(getSecond(("a", 42)) == 42)

    // Exercise 4
    import MyGeneric._
    val p = Point(3, 4)
    val repr = pointGeneric.to(p)
    assert(repr == (3, 4))
    assert(pointGeneric.from((5, 6)) == Point(5, 6))

    // Exercise 5
    assert(secondElementSize(("hello", 42)) == 4)

    // Exercise 6
    val converted: String = convert(42)
    assert(converted == "42")
    val parsed: Int = convert("123")
    assert(parsed == 123)

    // Exercise 7
    assert(convertAndSerialize(42) == "\"42\"")
    assert(convertAndSerialize("123") == "123")

    // Exercise 8
    assert(convertDirect(42) == "42")

    println("All Core082_AuxPattern exercises passed!")
  }
}
