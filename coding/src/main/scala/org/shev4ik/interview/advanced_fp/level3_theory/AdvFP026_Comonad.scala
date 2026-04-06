package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP026 - Comonad
 *
 * A Comonad is the dual of a Monad. While Monad has pure and flatMap,
 * Comonad has extract and coflatMap (or equivalently, extract and duplicate).
 * Laws: extract(duplicate(w)) == w, map(extract)(duplicate(w)) == w,
 *       duplicate(duplicate(w)) == map(duplicate)(duplicate(w))
 */
object AdvFP026_Comonad {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // ============================================================
  // Exercise 1: Define the Comonad typeclass
  // extract: F[A] => A  (dual of pure)
  // coflatMap: F[A] => (F[A] => B) => F[B]  (dual of flatMap)
  // duplicate: F[A] => F[F[A]]  (dual of join/flatten)
  // ============================================================
  trait Comonad[F[_]] extends Functor[F] {
    def extract[A](fa: F[A]): A
    def coflatMap[A, B](fa: F[A])(f: F[A] => B): F[B]
    def duplicate[A](fa: F[A]): F[F[A]] = coflatMap(fa)(identity)
  }

  // ============================================================
  // Exercise 2: Implement Comonad for NonEmptyList
  // extract returns the head, coflatMap applies f to each suffix.
  // ============================================================
  case class NEL[A](head: A, tail: List[A]) {
    def toList: List[A] = head :: tail
  }

  // TODO: Implement Comonad[NEL]
  implicit val nelComonad: Comonad[NEL] = ???

  // ============================================================
  // Exercise 3: Implement the Store comonad
  // Store[S, A] = (S => A, S) - a value in context of a position.
  // extract gets the value at the current position.
  // ============================================================
  case class Store[S, A](peek: S => A, pos: S)

  // TODO: Implement Comonad for Store[S, *]
  def storeComonad[S]: Comonad[({type L[A] = Store[S, A]})#L] = ???

  // ============================================================
  // Exercise 4: Implement the Env comonad (CoReader / Traced)
  // Env[E, A] = (E, A) - a value paired with an environment.
  // extract returns the value, ignoring the environment.
  // ============================================================
  case class Env[E, A](env: E, value: A)

  // TODO: Implement Comonad for Env[E, *]
  def envComonad[E]: Comonad[({type L[A] = Env[E, A]})#L] = ???

  // ============================================================
  // Exercise 5: Verify the left identity law
  // extract(coflatMap(w)(f)) == f(w)
  // ============================================================
  // TODO: Verify the left identity comonad law
  def verifyLeftIdentity[F[_], A, B](w: F[A], f: F[A] => B)(implicit C: Comonad[F]): Boolean = ???

  // ============================================================
  // Exercise 6: Verify the right identity law
  // coflatMap(w)(extract) == w
  // ============================================================
  // TODO: Verify the right identity comonad law
  def verifyRightIdentity[F[_], A](w: F[A])(implicit C: Comonad[F]): Boolean = ???

  // ============================================================
  // Exercise 7: Verify the associativity law
  // coflatMap(coflatMap(w)(f))(g) == coflatMap(w)(x => g(coflatMap(x)(f)))
  // ============================================================
  // TODO: Verify associativity
  def verifyAssociativity[F[_], A, B, C](
    w: F[A],
    f: F[A] => B,
    g: F[B] => C
  )(implicit CM: Comonad[F]): Boolean = ???

  // ============================================================
  // Exercise 8: Implement extend (another name for coflatMap)
  // and use it to compute a moving average.
  // Given NEL[Double], compute the average of each element and its neighbors.
  // ============================================================
  // TODO: Compute moving average using comonad extend
  def movingAverage(data: NEL[Double]): NEL[Double] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2: NEL Comonad
    val nel = NEL(1, List(2, 3, 4))
    assert(nelComonad.extract(nel) == 1)
    val sums = nelComonad.coflatMap(nel)(n => n.toList.sum)
    assert(sums.head == 10) // 1+2+3+4
    assert(sums.tail.head == 9) // 2+3+4
    println("Exercise 2 passed: NEL Comonad")

    // Exercise 3: Store Comonad
    val sc = storeComonad[Int]
    val store = Store[Int, String](i => s"value_$i", 5)
    assert(sc.extract(store) == "value_5")
    val duplicated = sc.duplicate(store)
    assert(sc.extract(sc.extract(duplicated)) == "value_5")
    println("Exercise 3 passed: Store Comonad")

    // Exercise 4: Env Comonad
    val ec = envComonad[String]
    val env = Env("context", 42)
    assert(ec.extract(env) == 42)
    val mapped = ec.map(env)(_ * 2)
    assert(mapped == Env("context", 84))
    println("Exercise 4 passed: Env Comonad")

    // Exercise 5: Left identity
    val f: NEL[Int] => Int = _.toList.sum
    assert(verifyLeftIdentity(nel, f))
    println("Exercise 5 passed: Left identity law")

    // Exercise 6: Right identity
    assert(verifyRightIdentity(nel))
    println("Exercise 6 passed: Right identity law")

    // Exercise 7: Associativity
    val g: NEL[Int] => String = n => n.head.toString
    val h: NEL[String] => Int = n => n.head.length
    assert(verifyAssociativity(nel, g, h))
    println("Exercise 7 passed: Associativity law")

    // Exercise 8: Moving average
    val data = NEL(1.0, List(2.0, 3.0, 4.0, 5.0))
    val avg = movingAverage(data)
    // First element avg includes all remaining elements
    assert(avg.head > 0)
    println("Exercise 8 passed: Moving average via comonad")

    println("\nAll exercises passed!")
  }
}
