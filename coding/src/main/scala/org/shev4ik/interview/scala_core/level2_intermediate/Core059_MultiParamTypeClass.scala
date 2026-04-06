package org.shev4ik.interview.scala_core.level2_intermediate

object Core059_MultiParamTypeClass {

  // Exercise 1: Multi-param type class
  // TODO: Define a type class CanConvert[A, B] with method convert(a: A): B
  //       Create instances: Int => String, String => Int, Double => Int
  trait CanConvert[A, B] {
    def convert(a: A): B
  }
  object CanConvert {
    implicit val intToString: CanConvert[Int, String] = ???
    implicit val stringToInt: CanConvert[String, Int] = ???
    implicit val doubleToInt: CanConvert[Double, Int] = ???
  }

  def convert[A, B](a: A)(implicit cc: CanConvert[A, B]): B = ???

  // Exercise 2: Functional dependencies concept
  // TODO: In multi-param type classes, sometimes one type determines the other
  //       Define a trait Extract[Source, Target] where Source determines Target
  //       (conceptually - Scala doesn't enforce functional dependencies natively)
  trait Extract[Source] {
    type Target
    def extract(s: Source): Target
  }
  object Extract {
    // Helper type for cleaner usage
    type Aux[S, T] = Extract[S] { type Target = T }

    implicit val stringExtract: Extract[String] { type Target = Int } = ???
    implicit val listExtract: Extract[List[Int]] { type Target = Int } = ???
  }

  def extract[S](s: S)(implicit e: Extract[S]): e.Target = ???

  // Exercise 3: Implicit resolution with multi-param
  // TODO: Create a type class Mappable[F[_], A, B] that maps A to B within container F
  //       Similar to Functor but with explicit types
  trait Mappable[F[_], A, B] {
    def map(fa: F[A])(f: A => B): F[B]
  }
  implicit def listMappable[A, B]: Mappable[List, A, B] = ???
  implicit def optionMappable[A, B]: Mappable[Option, A, B] = ???

  def mapIt[F[_], A, B](fa: F[A])(f: A => B)(implicit m: Mappable[F, A, B]): F[B] = ???

  // Exercise 4: Aux pattern for multi-param
  // TODO: The Aux pattern uses a type alias to expose dependent types
  //       Define a type class Output[A] with type Out
  //       and an Aux type alias: type Aux[A, O] = Output[A] { type Out = O }
  trait Output[A] {
    type Out
    def produce(a: A): Out
  }
  object Output {
    type Aux[A, O] = Output[A] { type Out = O }

    implicit val intOutput: Output.Aux[Int, String] = ???
    implicit val stringOutput: Output.Aux[String, Int] = ???
  }

  def produce[A](a: A)(implicit o: Output[A]): o.Out = ???

  // Exercise 5: Type-level computation
  // TODO: Create a simple type-level computation using multi-param type classes
  //       trait Add[A, B] { type Result; def add(a: A, b: B): Result }
  //       Implement for (Int, Int) => Int and (String, String) => String
  trait Add[A, B] {
    type Result
    def add(a: A, b: B): Result
  }
  object Add {
    type Aux[A, B, R] = Add[A, B] { type Result = R }

    implicit val intAdd: Add.Aux[Int, Int, Int] = ???
    implicit val stringAdd: Add.Aux[String, String, String] = ???
  }

  def add[A, B](a: A, b: B)(implicit ev: Add[A, B]): ev.Result = ???

  // Exercise 6: CanBuildFrom as multi-param
  // TODO: CanBuildFrom[From, Elem, To] was Scala's classic multi-param type class
  //       Create a simplified version: CanCreate[Elem, Collection]
  //       that creates a collection from a list of elements
  trait CanCreate[Elem, Collection] {
    def create(elems: List[Elem]): Collection
  }
  implicit val intArrayCreate: CanCreate[Int, Array[Int]] = ???
  implicit def setCreate[A]: CanCreate[A, Set[A]] = ???

  def createCollection[A, C](elems: List[A])(implicit cc: CanCreate[A, C]): C = ???

  // Exercise 7: Converter type class
  // TODO: Create a bidirectional converter type class
  //       trait Codec[A, B] { def encode(a: A): B; def decode(b: B): A }
  trait Codec[A, B] {
    def encode(a: A): B
    def decode(b: B): A
  }
  implicit val intStringCodec: Codec[Int, String] = ???

  def roundTrip[A, B](a: A)(implicit codec: Codec[A, B]): A = ???

  // Exercise 8: Isomorphism type class
  // TODO: Create an Iso[A, B] type class representing an isomorphism
  //       (a bijection between types A and B)
  //       to: A => B, from: B => A, such that from(to(a)) == a and to(from(b)) == b
  trait Iso[A, B] {
    def to(a: A): B
    def from(b: B): A
  }
  object Iso {
    implicit val boolIntIso: Iso[Boolean, Int] = ???
    def reverse[A, B](implicit iso: Iso[A, B]): Iso[B, A] = ???
  }

  def convertViaIso[A, B](a: A)(implicit iso: Iso[A, B]): B = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(convert[Int, String](42) == "42", "convert Int to String")
    assert(convert[String, Int]("42") == 42, "convert String to Int")
    assert(convert[Double, Int](3.14) == 3, "convert Double to Int")

    // Exercise 2 assertions
    assert(extract("hello") == 5, "extract String => length")
    assert(extract(List(1, 2, 3)) == 3, "extract List => size")

    // Exercise 3 assertions
    assert(mapIt(List(1, 2, 3))(_ * 2) == List(2, 4, 6), "mapIt List")
    assert(mapIt(Option(5))(_ + 1) == Some(6), "mapIt Option")

    // Exercise 4 assertions
    val intOut: String = produce(42)
    assert(intOut == "42", "produce Int => String")
    val strOut: Int = produce("hello")
    assert(strOut == 5, "produce String => Int (length)")

    // Exercise 5 assertions
    assert(add(1, 2) == 3, "add Int Int")
    assert(add("hello", " world") == "hello world", "add String String")

    // Exercise 6 assertions
    val arr = createCollection[Int, Array[Int]](List(1, 2, 3))
    assert(arr.toList == List(1, 2, 3), "createCollection Array")
    val set = createCollection[Int, Set[Int]](List(1, 2, 2, 3))
    assert(set == Set(1, 2, 3), "createCollection Set")

    // Exercise 7 assertions
    assert(roundTrip[Int, String](42) == 42, "roundTrip should be identity")

    // Exercise 8 assertions
    assert(convertViaIso[Boolean, Int](true) == 1, "true to 1")
    assert(convertViaIso[Boolean, Int](false) == 0, "false to 0")
    val reverseIso = Iso.reverse[Boolean, Int]
    assert(reverseIso.to(1) == true, "reverse iso: 1 to true")

    println("All Core059_MultiParamTypeClass exercises passed!")
  }
}
