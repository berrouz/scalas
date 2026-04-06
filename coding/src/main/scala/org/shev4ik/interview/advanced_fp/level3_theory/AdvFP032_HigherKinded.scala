package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP032 - Higher-Kinded Types
 *
 * Scala's kind system: * (types), * -> * (type constructors like List),
 * (* -> *) -> * (higher-kinded like Functor). Understanding kinds is
 * essential for advanced FP abstractions.
 */
object AdvFP032_HigherKinded {

  // ============================================================
  // Exercise 1: Kind * (proper types)
  // Int, String, Boolean are all kind *.
  // Implement a typeclass for types of kind * that provides a default value.
  // ============================================================
  trait Default[A] {
    def value: A
  }

  // TODO: Implement Default for Int, String, Boolean
  implicit val defaultInt: Default[Int] = ???
  implicit val defaultString: Default[String] = ???
  implicit val defaultBoolean: Default[Boolean] = ???

  def getDefault[A: Default]: A = implicitly[Default[A]].value

  // ============================================================
  // Exercise 2: Kind * -> * (type constructors)
  // List, Option, Future are kind * -> *.
  // Implement Functor (which takes * -> * as parameter).
  // ============================================================
  trait Functor[F[_]] {  // F has kind * -> *
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // TODO: Implement Functor for Option
  implicit val optionFunctor: Functor[Option] = ???

  // TODO: Implement Functor for List
  implicit val listFunctor: Functor[List] = ???

  // ============================================================
  // Exercise 3: Kind (* -> *) -> * (higher-kinded)
  // FunctorOf takes a type constructor and produces a type.
  // Implement a typeclass that works on any Functor.
  // ============================================================
  trait FunctorOps[F[_]] {
    def void[A](fa: F[A])(implicit F: Functor[F]): F[Unit]
    def as[A, B](fa: F[A], b: B)(implicit F: Functor[F]): F[B]
  }

  // TODO: Implement FunctorOps generically
  def functorOps[F[_]]: FunctorOps[F] = ???

  // ============================================================
  // Exercise 4: Type Lambdas (partial application of types)
  // Either[String, *] is a type lambda: ({type L[A] = Either[String, A]})#L
  // Implement Functor for Either[E, *].
  // ============================================================
  // TODO: Implement Functor for Either[E, *] using type lambda
  def eitherFunctor[E]: Functor[({type L[A] = Either[E, A]})#L] = ???

  // ============================================================
  // Exercise 5: Kind Projector style
  // With kind-projector plugin, Either[String, *] is written directly.
  // Without it, we use type lambdas. Implement Functor for Function1[R, *].
  // ============================================================
  // TODO: Implement Functor for R => * (Reader functor)
  def readerFunctor[R]: Functor[({type L[A] = R => A})#L] = ???

  // ============================================================
  // Exercise 6: Rank-2 types concept
  // A rank-2 type is: forall A. F[A] => G[A] (natural transformation).
  // Scala can encode this with a trait.
  // ============================================================
  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // TODO: Implement a rank-2 function: Option ~> List
  val optionToList: Option ~> List = ???

  // TODO: Implement a function that takes a rank-2 function and applies it
  def applyNatTrans[F[_], G[_], A](nt: F ~> G, fa: F[A]): G[A] = ???

  // ============================================================
  // Exercise 7: Existential types
  // An existential type hides the type parameter: exists A. F[A]
  // In Scala, we use abstract type members or forSome.
  // ============================================================
  trait Existential[F[_]] {
    type A
    val value: F[A]
  }

  // TODO: Create an existential that hides the type
  def hideType[F[_], B](fb: F[B]): Existential[F] = ???

  // TODO: Use the existential by providing a natural transformation
  def useExistential[F[_], G[_]](ex: Existential[F], nt: F ~> G): Existential[G] = ???

  // ============================================================
  // Exercise 8: Partial type application
  // Implement a technique to partially apply a two-parameter type.
  // StateT[F, S, A] - we want to fix F and S to get a Functor.
  // ============================================================
  case class StateT[F[_], S, A](run: S => F[(A, S)])

  // TODO: Implement Functor for StateT[F, S, *] given Functor[F]
  def stateTFunctor[F[_]: Functor, S]: Functor[({type L[A] = StateT[F, S, A]})#L] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Default values
    assert(getDefault[Int] == 0)
    assert(getDefault[String] == "")
    assert(getDefault[Boolean] == false)
    println("Exercise 1 passed: Kind * defaults")

    // Exercise 2: Functor
    assert(optionFunctor.map(Some(3))(_ * 2) == Some(6))
    assert(listFunctor.map(List(1, 2, 3))(_ + 10) == List(11, 12, 13))
    println("Exercise 2 passed: Kind * -> * functors")

    // Exercise 3: Higher-kinded ops
    val ops = functorOps[Option]
    assert(ops.void(Some(42)) == Some(()))
    assert(ops.as(Some(42), "hello") == Some("hello"))
    println("Exercise 3 passed: (* -> *) -> * operations")

    // Exercise 4: Type lambda Functor
    val ef = eitherFunctor[String]
    assert(ef.map(Right(42): Either[String, Int])(_ + 1) == Right(43))
    assert(ef.map(Left("err"): Either[String, Int])(_ + 1) == Left("err"))
    println("Exercise 4 passed: Either functor via type lambda")

    // Exercise 5: Reader Functor
    val rf = readerFunctor[Int]
    val fn: Int => String = _.toString
    val mapped = rf.map(fn)("Result: " + _)
    assert(mapped(42) == "Result: 42")
    println("Exercise 5 passed: Reader functor")

    // Exercise 6: Rank-2 types
    assert(optionToList(Some(42)) == List(42))
    assert(optionToList(None) == Nil)
    assert(applyNatTrans(optionToList, Some("hi")) == List("hi"))
    println("Exercise 6 passed: Rank-2 / natural transformation")

    // Exercise 7: Existential types
    val hidden = hideType[Option, Int](Some(42))
    val transformed = useExistential(hidden, optionToList)
    println("Exercise 7 passed: Existential types")

    // Exercise 8: StateT Functor
    val stf = stateTFunctor[Option, Int]
    val st = StateT[Option, Int, String](s => Some(("hello", s + 1)))
    val mapped8 = stf.map(st)(_.length)
    assert(mapped8.run(0) == Some((5, 1)))
    println("Exercise 8 passed: StateT functor via partial type application")

    println("\nAll exercises passed!")
  }
}
