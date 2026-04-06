package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP008 - Arrow
 *
 * Arrow is a typeclass for computation that generalizes functions.
 * It provides arr (lift a function), compose, first, second, *** (split), and &&& (fanout).
 * ArrowChoice adds left/right for working with Either.
 */
object AdvFP008_Arrow {

  // ============================================================
  // Exercise 1: Define the Arrow typeclass
  // arr: (A => B) => F[A, B]  -- lift a pure function
  // compose: (F[B, C], F[A, B]) => F[A, C]  -- compose two arrows
  // first: F[A, B] => F[(A, C), (B, C)]  -- run arrow on first of pair
  // ============================================================
  trait Arrow[F[_, _]] {
    def arr[A, B](f: A => B): F[A, B]
    def compose[A, B, C](f: F[B, C], g: F[A, B]): F[A, C]
    def first[A, B, C](f: F[A, B]): F[(A, C), (B, C)]
  }

  // TODO: Implement Arrow for Function1
  val function1Arrow: Arrow[Function1] = ???

  // ============================================================
  // Exercise 2: Derive 'second' from Arrow
  // second runs the arrow on the second element of a pair.
  // second: F[A, B] => F[(C, A), (C, B)]
  // Hint: use arr to swap, then first, then arr to swap back.
  // ============================================================
  // TODO: Implement second using Arrow primitives
  def second[F[_, _], A, B, C](f: F[A, B])(implicit ar: Arrow[F]): F[(C, A), (C, B)] = ???

  // ============================================================
  // Exercise 3: Implement *** (split/parallel)
  // f *** g takes (A, C) and applies f to A and g to C, producing (B, D).
  // Implement using first, second, and compose.
  // ============================================================
  // TODO: Implement split (***): run two arrows in parallel on a pair
  def split[F[_, _], A, B, C, D](f: F[A, B], g: F[C, D])(implicit ar: Arrow[F]): F[(A, C), (B, D)] = ???

  // ============================================================
  // Exercise 4: Implement &&& (fanout)
  // f &&& g takes a single input A and produces (B, C) by running both arrows.
  // Hint: first duplicate the input with arr(a => (a, a)), then use ***.
  // ============================================================
  // TODO: Implement fanout (&&&): run two arrows on the same input
  def fanout[F[_, _], A, B, C](f: F[A, B], g: F[A, C])(implicit ar: Arrow[F]): F[A, (B, C)] = ???

  // ============================================================
  // Exercise 5: Define ArrowChoice extending Arrow
  // ArrowChoice adds: left: F[A, B] => F[Either[A, C], Either[B, C]]
  // ============================================================
  trait ArrowChoice[F[_, _]] extends Arrow[F] {
    def left[A, B, C](f: F[A, B]): F[Either[A, C], Either[B, C]]
  }

  // TODO: Implement ArrowChoice for Function1
  val function1ArrowChoice: ArrowChoice[Function1] = ???

  // ============================================================
  // Exercise 6: Derive 'right' from ArrowChoice
  // right: F[A, B] => F[Either[C, A], Either[C, B]]
  // ============================================================
  // TODO: Implement right using ArrowChoice primitives
  def right[F[_, _], A, B, C](f: F[A, B])(implicit ar: ArrowChoice[F]): F[Either[C, A], Either[C, B]] = ???

  // ============================================================
  // Exercise 7: Show Kleisli as an Arrow
  // Kleisli[Option, A, B] = A => Option[B] forms an Arrow.
  // ============================================================
  case class KleisliOpt[A, B](run: A => Option[B])

  // TODO: Implement Arrow for KleisliOpt
  val kleisliOptArrow: Arrow[KleisliOpt] = ???

  // ============================================================
  // Exercise 8: Build a pipeline using Arrow combinators
  // Given Arrow[Function1], build a pipeline that:
  // - Takes an Int
  // - Produces (String, Boolean) where String is the number as text,
  //   and Boolean is whether it's even.
  // Use fanout (&&& / Exercise 4).
  // ============================================================
  // TODO: Build the pipeline using Arrow combinators
  def pipeline(n: Int): (String, Boolean) = ???

  def main(args: Array[String]): Unit = {
    implicit val fa: Arrow[Function1] = function1Arrow

    // Exercise 1: Arrow for Function1
    val inc = fa.arr[Int, Int](_ + 1)
    assert(inc(5) == 6)
    val composed = fa.compose(fa.arr[Int, String](_.toString), inc)
    assert(composed(5) == "6")
    println("Exercise 1 passed: Arrow for Function1")

    // Exercise 2: second
    val addOne = fa.arr[Int, Int](_ + 1)
    val sec = second[Function1, Int, Int, String](addOne)(fa)
    assert(sec(("hello", 5)) == ("hello", 6))
    println("Exercise 2 passed: second")

    // Exercise 3: split (***)
    val toString_ = fa.arr[Int, String](_.toString)
    val double = fa.arr[Int, Int](_ * 2)
    val sp = split[Function1, Int, String, Int, Int](toString_, double)(fa)
    assert(sp((42, 3)) == ("42", 6))
    println("Exercise 3 passed: split (***)")

    // Exercise 4: fanout (&&&)
    val fo = fanout[Function1, Int, String, Boolean](
      fa.arr(_.toString),
      fa.arr(_ % 2 == 0)
    )(fa)
    assert(fo(42) == ("42", true))
    assert(fo(3) == ("3", false))
    println("Exercise 4 passed: fanout (&&&)")

    // Exercise 5: ArrowChoice
    implicit val fac: ArrowChoice[Function1] = function1ArrowChoice
    val incChoice = fac.left[Int, Int, String](_ + 1)
    assert(incChoice(Left(5)) == Left(6))
    assert(incChoice(Right("hi")) == Right("hi"))
    println("Exercise 5 passed: ArrowChoice for Function1")

    // Exercise 6: right
    val r = right[Function1, Int, Int, String](_ + 1)
    assert(r(Right(5)) == Right(6))
    assert(r(Left("hi")) == Left("hi"))
    println("Exercise 6 passed: right from ArrowChoice")

    // Exercise 7: Kleisli Arrow
    val ka = kleisliOptArrow
    val parseK = KleisliOpt[String, Int](s => scala.util.Try(s.toInt).toOption)
    val halfK = KleisliOpt[Int, Int](n => if (n % 2 == 0) Some(n / 2) else None)
    val composed7 = ka.compose(halfK, parseK)
    assert(composed7.run("10") == Some(5))
    assert(composed7.run("abc") == None)
    println("Exercise 7 passed: Kleisli as Arrow")

    // Exercise 8: Pipeline
    assert(pipeline(42) == ("42", true))
    assert(pipeline(3) == ("3", false))
    println("Exercise 8 passed: Arrow pipeline")

    println("\nAll exercises passed!")
  }
}
