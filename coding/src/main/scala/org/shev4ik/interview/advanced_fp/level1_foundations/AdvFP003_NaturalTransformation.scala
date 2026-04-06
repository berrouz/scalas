package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP003 - Natural Transformation
 *
 * A natural transformation is a mapping between functors that preserves structure.
 * In Scala, it's polymorphic function F[A] => G[A] for all A (often written F ~> G).
 * Law: natTrans(F.map(fa)(f)) == G.map(natTrans(fa))(f)
 */
object AdvFP003_NaturalTransformation {

  // Higher-kinded function: F ~> G
  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // Minimal Functor for our exercises
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  implicit val vectorFunctor: Functor[Vector] = new Functor[Vector] {
    def map[A, B](fa: Vector[A])(f: A => B): Vector[B] = fa.map(f)
  }

  // ============================================================
  // Exercise 1: Implement a natural transformation Option ~> List
  // None => Nil, Some(a) => List(a)
  // ============================================================
  // TODO: Implement Option ~> List
  val optionToList: Option ~> List = ???

  // ============================================================
  // Exercise 2: Implement a natural transformation List ~> Vector
  // ============================================================
  // TODO: Implement List ~> Vector
  val listToVector: List ~> Vector = ???

  // ============================================================
  // Exercise 3: Implement a natural transformation List ~> Option
  // Return the head of the list if non-empty, None otherwise.
  // ============================================================
  // TODO: Implement List ~> Option (headOption)
  val listToOption: List ~> Option = ???

  // ============================================================
  // Exercise 4: Compose two natural transformations
  // Given F ~> G and G ~> H, produce F ~> H
  // ============================================================
  // TODO: Implement composition of natural transformations
  def compose[F[_], G[_], H[_]](fg: F ~> G, gh: G ~> H): F ~> H = ???

  // ============================================================
  // Exercise 5: Implement the identity natural transformation
  // The identity nat trans maps F[A] to F[A] unchanged.
  // ============================================================
  // TODO: Implement identity natural transformation
  def idNatTrans[F[_]]: F ~> F = ???

  // ============================================================
  // Exercise 6: Verify the naturality condition
  // For nat trans alpha: F ~> G, and function f: A => B:
  // alpha(F.map(fa)(f)) == G.map(alpha(fa))(f)
  // Return true if the condition holds.
  // ============================================================
  // TODO: Verify naturality condition
  def verifyNaturality[F[_], G[_], A, B](
    alpha: F ~> G,
    fa: F[A],
    f: A => B
  )(implicit FF: Functor[F], GF: Functor[G]): Boolean = ???

  // ============================================================
  // Exercise 7: Implement FunctionK-style natural transformation
  // that flattens Option[Option[A]] => Option[A] (join / flatten).
  // This is a natural transformation from Composed(Option, Option) to Option.
  // We model it directly since Scala doesn't have easy type-level composition.
  // ============================================================
  type OptionOption[A] = Option[Option[A]]

  // TODO: Implement flatten as a function polymorphic in A
  def flattenOption[A](ooa: Option[Option[A]]): Option[A] = ???

  // ============================================================
  // Exercise 8: Implement a natural transformation that acts as
  // a "safe" converter: Try ~> Either[Throwable, *]
  // Use scala.util.Try, Success, Failure.
  // Since we can't partially apply Either easily, use a wrapper.
  // ============================================================
  import scala.util.{Try, Success, Failure}

  type EitherThrowable[A] = Either[Throwable, A]

  // TODO: Implement Try ~> EitherThrowable
  val tryToEither: Try ~> EitherThrowable = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Option ~> List
    assert(optionToList(Some(42)) == List(42))
    assert(optionToList(None) == Nil)
    println("Exercise 1 passed: Option ~> List")

    // Exercise 2: List ~> Vector
    assert(listToVector(List(1, 2, 3)) == Vector(1, 2, 3))
    assert(listToVector(Nil) == Vector.empty)
    println("Exercise 2 passed: List ~> Vector")

    // Exercise 3: List ~> Option
    assert(listToOption(List(1, 2, 3)) == Some(1))
    assert(listToOption(Nil) == None)
    println("Exercise 3 passed: List ~> Option (headOption)")

    // Exercise 4: Compose nat trans
    val optionToVector = compose(optionToList, listToVector)
    assert(optionToVector(Some("hi")) == Vector("hi"))
    assert(optionToVector(None) == Vector.empty)
    println("Exercise 4 passed: Composed natural transformations")

    // Exercise 5: Identity nat trans
    val idOpt = idNatTrans[Option]
    assert(idOpt(Some(1)) == Some(1))
    assert(idOpt(None) == None)
    println("Exercise 5 passed: Identity natural transformation")

    // Exercise 6: Naturality condition
    val natCheck = verifyNaturality[Option, List, Int, String](
      optionToList, Some(42), _.toString
    )
    assert(natCheck, "Naturality condition should hold")
    println("Exercise 6 passed: Naturality condition verified")

    // Exercise 7: Flatten Option
    assert(flattenOption(Some(Some(42))) == Some(42))
    assert(flattenOption(Some(None)) == None)
    assert(flattenOption(None) == None)
    println("Exercise 7 passed: Flatten Option")

    // Exercise 8: Try ~> Either
    assert(tryToEither(Success(42)) == Right(42))
    val ex = new RuntimeException("boom")
    assert(tryToEither(Failure(ex)) == Left(ex))
    println("Exercise 8 passed: Try ~> Either")

    println("\nAll exercises passed!")
  }
}
