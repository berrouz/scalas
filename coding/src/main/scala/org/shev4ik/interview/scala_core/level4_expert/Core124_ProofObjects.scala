package org.shev4ik.interview.scala_core.level4_expert

object Core124_ProofObjects {

  // Curry-Howard Correspondence:
  // Types = Propositions, Values = Proofs
  // A => B = Implication (if A then B)
  // (A, B) = Conjunction (A and B)
  // Either[A, B] = Disjunction (A or B)
  // Nothing = Absurdity (False)
  // Unit = Truth (True)

  // Exercise 1: Curry-Howard correspondence
  // TODO: Prove that "True" is provable (there exists a value of type Unit)
  def proveTrue: Unit = ???

  // TODO: Show that "A implies A" (identity function is a proof)
  def identity[A](a: A): A = ???

  // Exercise 2: Proofs as types
  // TODO: Prove that "if A then (if B then A)" - the K combinator
  def kCombinator[A, B](a: A)(b: B): A = ???

  // TODO: Prove "if (A => B) then (if (B => C) then (A => C))" - transitivity
  def transitivity[A, B, C](f: A => B)(g: B => C): A => C = ???

  // Exercise 3: Terms as proofs
  // TODO: Prove "if A and B, then B and A" (conjunction commutativity)
  def conjCommutative[A, B](pair: (A, B)): (B, A) = ???

  // TODO: Prove "if A and B, then A" (conjunction elimination / projection)
  def conjElimLeft[A, B](pair: (A, B)): A = ???
  def conjElimRight[A, B](pair: (A, B)): B = ???

  // Exercise 4: Conjunction proof
  // TODO: Prove "if A and (B and C), then (A and B) and C" (associativity)
  def conjAssoc[A, B, C](abc: (A, (B, C))): ((A, B), C) = ???

  // TODO: Prove "if A, and if B, then A and B" (conjunction introduction)
  def conjIntro[A, B](a: A, b: B): (A, B) = ???

  // Exercise 5: Disjunction proof
  // TODO: Prove "if A, then A or B" (disjunction introduction)
  def disjIntroLeft[A, B](a: A): Either[A, B] = ???
  def disjIntroRight[A, B](b: B): Either[A, B] = ???

  // TODO: Prove "if A or B, and A => C, and B => C, then C" (disjunction elimination)
  def disjElim[A, B, C](ab: Either[A, B])(f: A => C)(g: B => C): C = ???

  // Exercise 6: Implication proof
  // TODO: Prove "if (A and B) => C, then A => (B => C)" (currying)
  def curry[A, B, C](f: ((A, B)) => C): A => B => C = ???

  // TODO: Prove "if A => (B => C), then (A and B) => C" (uncurrying)
  def uncurry[A, B, C](f: A => B => C): ((A, B)) => C = ???

  // Exercise 7: Void (absurdity)
  // TODO: Prove "if False, then A" (ex falso quodlibet / principle of explosion)
  def exFalso[A](void: Nothing): A = ???

  // TODO: Define negation: Not[A] = A => Nothing
  type Not[A] = A => Nothing

  // Prove "if A and not A, then False"
  def contradiction[A](a: A, notA: Not[A]): Nothing = ???

  // Exercise 8: Proof by contradiction (double negation)
  // TODO: Prove "A implies not-not-A"
  //       Note: not-not-A implies A is NOT provable in constructive logic!
  def doubleNegIntro[A](a: A): Not[Not[A]] = ???

  // TODO: Prove "if not-not-not-A, then not-A" (triple negation elimination)
  def tripleNegElim[A](nnnA: Not[Not[Not[A]]]): Not[A] = ???

  // Additional: De Morgan's law (one direction is constructive)
  // TODO: Prove "not (A or B) implies (not A and not B)"
  def deMorgan[A, B](notAorB: Not[Either[A, B]]): (Not[A], Not[B]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(proveTrue == ())
    assert(identity(42) == 42)

    // Exercise 2
    assert(kCombinator("hello")(42) == "hello")
    val composed = transitivity[Int, String, Boolean](_.toString)(_.nonEmpty)
    assert(composed(42) == true)

    // Exercise 3
    assert(conjCommutative((1, "a")) == ("a", 1))
    assert(conjElimLeft((1, "a")) == 1)
    assert(conjElimRight((1, "a")) == "a")

    // Exercise 4
    assert(conjAssoc((1, (2, 3))) == ((1, 2), 3))
    assert(conjIntro(1, "a") == (1, "a"))

    // Exercise 5
    assert(disjIntroLeft[Int, String](42) == Left(42))
    assert(disjIntroRight[Int, String]("hello") == Right("hello"))
    assert(disjElim(Left(42): Either[Int, String])(_.toString)(identity) == "42")

    // Exercise 6
    val curried = curry[Int, String, Boolean] { case (i, s) => s.length == i }
    assert(curried(5)("hello") == true)
    val uncurried = uncurry[Int, String, Boolean](i => s => s.length == i)
    assert(uncurried((5, "hello")) == true)

    // Exercise 8
    val dnn: Not[Not[Int]] = doubleNegIntro(42)
    // dnn would throw if called with a function that returns Nothing from Int

    val nnn: Not[Int] = tripleNegElim[Int](na => na((i: Int) => throw new RuntimeException("absurd")))
    // nnn is a function from Int to Nothing

    println("All Core124_ProofObjects exercises passed!")
  }
}
