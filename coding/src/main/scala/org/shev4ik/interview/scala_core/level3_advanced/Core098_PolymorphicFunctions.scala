package org.shev4ik.interview.scala_core.level3_advanced

object Core098_PolymorphicFunctions {

  // Exercise 1: Polymorphic function value
  // TODO: In Scala 2, function values are monomorphic (e.g., Int => String).
  //       Show the limitation and the workaround using a trait.
  //       Define a trait PolyFunction that can be applied to any type.
  trait PolyFunction {
    def apply[A](a: A): String
  }

  // TODO: Implement a PolyFunction that calls .toString on any value
  val toStringPoly: PolyFunction = ???

  // Exercise 2: FunctionK (~>)
  // TODO: Define FunctionK (natural transformation) - a function from F[_] to G[_]
  trait FunctionK[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // Alias for natural transformation
  type ~>[F[_], G[_]] = FunctionK[F, G]

  // TODO: Implement a natural transformation from Option to List
  val optionToList: Option ~> List = ???

  // TODO: Implement a natural transformation from List to Option (headOption)
  val listToOption: List ~> Option = ???

  // Exercise 3: Rank-1 vs rank-2 polymorphism
  // TODO: Show that regular functions are rank-1 (type fixed at call site)
  //       while FunctionK is rank-2 (polymorphic across invocations)
  val rank1: Int => String = _.toString  // monomorphic: Int => String

  // TODO: Show rank-2 using a trait
  trait Rank2Function {
    def apply[A](list: List[A]): Int
  }

  val listLength: Rank2Function = ???

  // Exercise 4: Polymorphic lambda
  // TODO: Create a "polymorphic lambda" using an anonymous class
  val headOrDefault: PolyFunction = ???

  // Exercise 5: Natural transformation as function
  // TODO: Use FunctionK to transform a program from one effect to another
  trait MyIO[A] {
    def run(): A
  }

  object MyIO {
    def pure[A](a: => A): MyIO[A] = new MyIO[A] { def run(): A = a }
  }

  // TODO: Implement a natural transformation from MyIO to Option (always Some)
  val ioToOption: MyIO ~> Option = ???

  // TODO: Implement a natural transformation from MyIO to List (singleton list)
  val ioToList: MyIO ~> List = ???

  // Exercise 6: Generic function
  // TODO: Create a generic function that works with any Functor
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  // TODO: Write a generic function `doubleAll` that works with any Functor of Int
  def doubleAll[F[_]](fi: F[Int])(implicit F: Functor[F]): F[Int] = ???

  // Exercise 7: Polymorphic method vs function
  // TODO: Show that methods can be polymorphic but functions cannot (in Scala 2)
  //       Define a polymorphic method and show it can't be directly assigned to a val
  def identity2[A](a: A): A = a  // polymorphic method

  // This would fail: val identityFn = identity2 _  (would need a specific type)
  // TODO: Work around by wrapping in a trait
  trait IdentityFn {
    def apply[A](a: A): A
  }

  val identityPoly: IdentityFn = ???

  // Exercise 8: Composing natural transformations
  // TODO: Implement composition of natural transformations
  def compose[F[_], G[_], H[_]](fg: F ~> G, gh: G ~> H): F ~> H = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(toStringPoly(42) == "42")
    assert(toStringPoly("hello") == "hello")
    assert(toStringPoly(true) == "true")

    // Exercise 2
    assert(optionToList(Some(42)) == List(42))
    assert(optionToList(None) == Nil)
    assert(listToOption(List(1, 2, 3)) == Some(1))
    assert(listToOption(Nil) == None)

    // Exercise 3
    assert(listLength(List(1, 2, 3)) == 3)
    assert(listLength(List("a", "b")) == 2)

    // Exercise 5
    assert(ioToOption(MyIO.pure(42)) == Some(42))
    assert(ioToList(MyIO.pure("hello")) == List("hello"))

    // Exercise 6
    assert(doubleAll(List(1, 2, 3)) == List(2, 4, 6))
    assert(doubleAll(Some(5): Option[Int]) == Some(10))

    // Exercise 7
    assert(identityPoly(42) == 42)
    assert(identityPoly("hello") == "hello")

    // Exercise 8
    val optionToListToOption: Option ~> Option = compose(optionToList, listToOption)
    assert(optionToListToOption(Some(42)) == Some(42))
    assert(optionToListToOption(None) == None)

    println("All Core098_PolymorphicFunctions exercises passed!")
  }
}
