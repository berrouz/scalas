package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP005 - Adjunction
 *
 * An adjunction is a pair of functors F (left adjoint) and G (right adjoint)
 * such that Hom(F(A), B) ≅ Hom(A, G(B)) naturally. Adjunctions give rise
 * to monads: G ∘ F with unit and join derived from the adjunction.
 */
object AdvFP005_Adjunction {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // ============================================================
  // Exercise 1: Demonstrate the curry-uncurry adjunction
  // (A × B) => C  ≅  A => (B => C)
  // Implement curry and uncurry showing they are inverses.
  // ============================================================
  // TODO: Implement curry
  def curry[A, B, C](f: ((A, B)) => C): A => B => C = ???

  // TODO: Implement uncurry
  def uncurry[A, B, C](f: A => B => C): ((A, B)) => C = ???

  // ============================================================
  // Exercise 2: Implement the unit of the curry/uncurry adjunction
  // unit: A => G(F(A)) where F(A) = (A, B) and G(X) = B => X
  // So unit: A => (B => (A, B))
  // ============================================================
  // TODO: Implement unit of the adjunction
  def adjunctionUnit[A, B]: A => B => (A, B) = ???

  // ============================================================
  // Exercise 3: Implement the counit of the curry/uncurry adjunction
  // counit: F(G(A)) => A where F(X) = (X, B) and G(A) = B => A
  // So counit: (B => A, B) => A
  // ============================================================
  // TODO: Implement counit of the adjunction
  def adjunctionCounit[A, B]: ((B => A, B)) => A = ???

  // ============================================================
  // Exercise 4: Derive the State monad from the adjunction
  // The pair of adjoint functors: F(A) = (A, S) and G(B) = S => B
  // The monad is G ∘ F, i.e., S => (A, S) which is the State monad.
  // Implement pure and flatMap for State using the adjunction intuition.
  // ============================================================
  case class State[S, A](run: S => (A, S))

  // TODO: Implement Monad for State[S, *]
  def stateMonad[S]: Monad[({type L[A] = State[S, A]})#L] = ???

  // ============================================================
  // Exercise 5: Derive the Reader monad from an adjunction
  // Left adjoint: F(A) = (A, E)  (product with E)
  // Right adjoint: G(B) = E => B  (function from E)
  // But for Reader we use the diagonal adjunction:
  // F = Const_E and G = (_ => E => A). Reader is just E => A.
  // Implement pure and flatMap for Reader.
  // ============================================================
  case class Reader[E, A](run: E => A)

  // TODO: Implement Monad for Reader[E, *]
  def readerMonad[E]: Monad[({type L[A] = Reader[E, A]})#L] = ???

  // ============================================================
  // Exercise 6: Demonstrate that left adjoints preserve colimits
  // In practical terms: left adjoints preserve coproducts (Either).
  // Given F left adjoint, show F(Either[A, B]) ≅ Either[F(A), F(B)]
  // Implement distribute for the product functor F(X) = (X, C).
  // ============================================================
  // TODO: Distribute product over Either
  def distributeProduct[A, B, C](pair: (Either[A, B], C)): Either[(A, C), (B, C)] = ???

  // ============================================================
  // Exercise 7: Implement the "homset" isomorphism of an adjunction
  // Hom(F(A), B) ≅ Hom(A, G(B))
  // For the curry/uncurry adjunction: ((A, S) => B) ≅ (A => S => B)
  // Implement leftAdjunct and rightAdjunct.
  // ============================================================
  // TODO: leftAdjunct: (F(A) => B) => (A => G(B))
  def leftAdjunct[A, S, B](f: ((A, S)) => B): A => S => B = ???

  // TODO: rightAdjunct: (A => G(B)) => (F(A) => B)
  def rightAdjunct[A, S, B](f: A => S => B): ((A, S)) => B = ???

  // ============================================================
  // Exercise 8: Verify the adjunction laws (triangle identities)
  // counit ∘ F(unit) = id_F  and  G(counit) ∘ unit = id_G
  // For our curry/uncurry adjunction:
  // Verify: counit(fmap_F(unit)(fa)) == fa   for F(A) = (A, S)
  // Return true if the identity holds.
  // ============================================================
  // TODO: Verify triangle identity for the (×S, S=>) adjunction
  def verifyTriangleIdentity[A, S](a: A, s: S): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Curry/uncurry
    val add: ((Int, Int)) => Int = { case (a, b) => a + b }
    val curried = curry(add)
    assert(curried(3)(4) == 7)
    val uncurried = uncurry(curried)
    assert(uncurried((3, 4)) == 7)
    println("Exercise 1 passed: Curry/uncurry adjunction")

    // Exercise 2: Adjunction unit
    val unit = adjunctionUnit[Int, String]
    assert(unit(42)("hello") == (42, "hello"))
    println("Exercise 2 passed: Adjunction unit")

    // Exercise 3: Adjunction counit
    val counit = adjunctionCounit[Int, String]
    assert(counit((_.length, "hello")) == 5)
    println("Exercise 3 passed: Adjunction counit")

    // Exercise 4: State monad
    val sm = stateMonad[Int]
    val inc = State[Int, String](s => (s.toString, s + 1))
    val prog = sm.flatMap(inc)(str => State(s => (str + "!" + s, s * 2)))
    val (result, finalState) = prog.run(10)
    assert(result == "10!11")
    assert(finalState == 22)
    println("Exercise 4 passed: State monad from adjunction")

    // Exercise 5: Reader monad
    val rm = readerMonad[Int]
    val r1 = Reader[Int, String](n => s"value=$n")
    val r2 = rm.flatMap(r1)(s => Reader(n => s"$s, doubled=${n * 2}"))
    assert(r2.run(5) == "value=5, doubled=10")
    println("Exercise 5 passed: Reader monad from adjunction")

    // Exercise 6: Distribute product over Either
    val leftCase: (Either[String, Int], Boolean) = (Left("hi"), true)
    val rightCase: (Either[String, Int], Boolean) = (Right(42), false)
    assert(distributeProduct(leftCase) == Left(("hi", true)))
    assert(distributeProduct(rightCase) == Right((42, false)))
    println("Exercise 6 passed: Left adjoint preserves coproducts")

    // Exercise 7: Homset isomorphism
    val f: ((Int, String)) => Boolean = { case (n, s) => n.toString == s }
    val la = leftAdjunct(f)
    assert(la(42)("42") == true)
    assert(la(42)("43") == false)
    val ra = rightAdjunct(la)
    assert(ra((42, "42")) == true)
    println("Exercise 7 passed: Homset isomorphism")

    // Exercise 8: Triangle identity
    assert(verifyTriangleIdentity(42, "hello"), "Triangle identity should hold")
    println("Exercise 8 passed: Triangle identity verified")

    println("\nAll exercises passed!")
  }
}
