package org.shev4ik.interview.scala_core.level3_advanced

object Core080_TypeInference {

  // Exercise 1: Inference algorithm
  // TODO: Write a method `firstOrDefault` where the compiler infers the return type.
  //       Takes a List[T] and a default T, returns the head or default.
  def firstOrDefault[T](list: List[T], default: T): T = ???

  // Exercise 2: Inference limitations
  // TODO: Write a method where type inference fails and requires explicit type parameters.
  //       `widen` should take a value and return it as a wider type.
  //       For example: widen[Int, AnyVal](42) should return 42: AnyVal
  def widen[A, B >: A](a: A): B = ???

  // Exercise 3: Type ascription
  // TODO: Write a method that demonstrates type ascription (value: Type syntax)
  //       Return a List[Any] by ascending a List[Int]
  def ascribeToAny(list: List[Int]): List[Any] = ???

  // Exercise 4: Explicit type params
  // TODO: Write a method `create` that creates a collection. Without explicit type params,
  //       the compiler might infer Nothing. Show how to call it correctly.
  //       create should return an empty collection of type T
  def create[T](): List[T] = ???

  // TODO: Write a helper that calls create with explicit type parameter
  def createIntList(): List[Int] = ???
  def createStringList(): List[String] = ???

  // Exercise 5: SI-2712 / Partial unification
  // TODO: Demonstrate partial unification: write a method that takes F[_] and uses
  //       Either[String, *] as F. In Scala 2.13 partial unification is enabled by default.
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // TODO: Implement Functor for Either[String, *] - this works in 2.13 due to partial unification
  implicit def eitherFunctor[E]: Functor[({type L[A] = Either[E, A]})#L] = ???

  def mapRight[E, A, B](either: Either[E, A])(f: A => B)(implicit F: Functor[({type L[X] = Either[E, X]})#L]): Either[E, B] = ???

  // Exercise 6: Partial unification detail
  // TODO: Write a method that takes a Function1[Int, *] and maps over it
  //       This leverages partial unification treating Function1[Int, A] as F[A]
  implicit val function1Functor: Functor[({type L[A] = Int => A})#L] = ???

  def mapFunction(f: Int => String)(g: String => Boolean): Int => Boolean = ???

  // Exercise 7: Inference in pattern match
  // TODO: Write a method that uses pattern matching where type inference
  //       narrows the type in each branch
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape

  // TODO: Implement area using pattern matching (inference narrows Shape to specific subtype)
  def area(shape: Shape): Double = ???

  // Exercise 8: Inference with implicits
  // TODO: Write a method that combines type inference with implicit resolution.
  //       The implicit should be inferred based on the inferred type of the argument.
  trait Printable[T] {
    def print(t: T): String
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    def print(t: Int): String = s"Int($t)"
  }
  implicit val printableString: Printable[String] = new Printable[String] {
    def print(t: String): String = s"Str($t)"
  }

  // TODO: The compiler should infer T from the argument and then find the implicit
  def autoPrint[T](value: T)(implicit p: Printable[T]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(firstOrDefault(List(1, 2, 3), 0) == 1)
    assert(firstOrDefault(List.empty[Int], 42) == 42)

    // Exercise 2
    val widened: AnyVal = widen[Int, AnyVal](42)
    assert(widened == 42)

    // Exercise 3
    val result = ascribeToAny(List(1, 2, 3))
    assert(result == List(1, 2, 3))

    // Exercise 4
    val intList = createIntList()
    assert(intList.isEmpty)
    val strList = createStringList()
    assert(strList.isEmpty)

    // Exercise 5
    val mapped = mapRight(Right(10): Either[String, Int])(_ * 2)
    assert(mapped == Right(20))

    // Exercise 6
    val composed = mapFunction((i: Int) => i.toString)(_.length > 1)
    assert(composed(5) == false)
    assert(composed(10) == true)

    // Exercise 7
    assert(area(Circle(5.0)) == Math.PI * 25.0)
    assert(area(Rectangle(3.0, 4.0)) == 12.0)

    // Exercise 8
    assert(autoPrint(42) == "Int(42)")
    assert(autoPrint("hello") == "Str(hello)")

    println("All Core080_TypeInference exercises passed!")
  }
}
