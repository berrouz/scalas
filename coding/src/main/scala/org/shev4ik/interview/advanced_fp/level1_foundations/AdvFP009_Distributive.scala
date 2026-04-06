package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP009 - Distributive Functor
 *
 * Distributive is the dual of Traverse. While Traverse sequences effects,
 * Distributive distributes a functor over another: F[G[A]] => G[F[A]].
 * A functor is Distributive iff it is Representable. Functions (R => _) are
 * the canonical Distributive functor.
 */
object AdvFP009_Distributive {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // ============================================================
  // Exercise 1: Define the Distributive typeclass
  // distribute: F[G[A]] => G[F[A]]  (dual of sequence/traverse)
  // cosequence: G[F[A]] => F[G[A]]  (but only needs Functor[G])
  // ============================================================
  trait Distributive[F[_]] extends Functor[F] {
    def distribute[G[_]: Functor, A, B](ga: G[A])(f: A => F[B]): F[G[B]]
    def cosequence[G[_]: Functor, A](gfa: G[F[A]]): F[G[A]] =
      distribute(gfa)(identity)
  }

  // ============================================================
  // Exercise 2: Implement Distributive for the function functor (R => _)
  // distribute takes G[A] and (A => R => B), returns R => G[B]
  // ============================================================
  type Reader[R] = { type L[A] = R => A }

  // TODO: Implement Distributive for (R => _)
  def readerDistributive[R]: Distributive[({type L[A] = R => A})#L] = ???

  // ============================================================
  // Exercise 3: Implement Distributive for a Pair type (representable by Boolean)
  // ============================================================
  case class Pair[A](first: A, second: A)

  // TODO: Implement Distributive[Pair]
  val pairDistributive: Distributive[Pair] = ???

  // ============================================================
  // Exercise 4: Define a Representable functor
  // A functor F is Representable if F[A] ≅ (Rep => A) for some type Rep.
  // tabulate: (Rep => A) => F[A]
  // index: F[A] => Rep => A
  // ============================================================
  trait Representable[F[_]] extends Functor[F] {
    type Rep
    def tabulate[A](f: Rep => A): F[A]
    def index[A](fa: F[A]): Rep => A
  }

  // TODO: Implement Representable[Pair] with Rep = Boolean
  val pairRepresentable: Representable[Pair] = ???

  // ============================================================
  // Exercise 5: Derive Distributive from Representable
  // If F is Representable, then distribute(ga)(f) = tabulate(r => fmap(ga)(a => index(f(a))(r)))
  // ============================================================
  // TODO: Derive Distributive from Representable
  def distributiveFromRepresentable[F[_]](rep: Representable[F]): Distributive[F] = ???

  // ============================================================
  // Exercise 6: Show Distributive vs Traverse duality
  // Traverse: F[G[A]] => G[F[A]] where F is Traversable, G is Applicative
  // Distributive: G[F[A]] => F[G[A]] where F is Distributive, G is Functor
  // Implement sequence for List (Traverse-like) using Option as the Applicative.
  // Then implement cosequence for Pair (Distributive) using List as the Functor.
  // ============================================================
  // TODO: Implement sequence for List[Option[A]] => Option[List[A]]
  def sequenceOption[A](list: List[Option[A]]): Option[List[A]] = ???

  // TODO: Implement cosequence: List[Pair[A]] => Pair[List[A]]
  def cosequencePair[A](list: List[Pair[A]]): Pair[List[A]] = ???

  // ============================================================
  // Exercise 7: Implement the "logarithm" of a Representable functor
  // The logarithm is the Rep type itself. For Pair, log = Boolean (2 positions).
  // For Reader[R], log = R. Implement a function that extracts all
  // "positions" from a Representable functor (for Pair, returns List(true, false)).
  // ============================================================
  // TODO: Implement positions: return all Rep values (for Pair)
  def pairPositions: List[Boolean] = ???

  // ============================================================
  // Exercise 8: Implement tabulate and index for a triple (3 positions)
  // A Triple[A] has three elements, representable by an enum with 3 values.
  // ============================================================
  case class Triple[A](a: A, b: A, c: A)

  sealed trait TripleIndex
  case object First extends TripleIndex
  case object Second extends TripleIndex
  case object Third extends TripleIndex

  // TODO: Implement tabulate for Triple
  def tabulateTriple[A](f: TripleIndex => A): Triple[A] = ???

  // TODO: Implement index for Triple
  def indexTriple[A](t: Triple[A]): TripleIndex => A = ???

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 2: Reader distributive
    val rd = readerDistributive[String]
    val listOfFns: List[String => Int] = List(_.length, _ => 42)
    val distributed = rd.distribute[List, String => Int, Int](listOfFns)(identity)
    assert(distributed("hello") == List(5, 42))
    println("Exercise 2 passed: Reader distributive")

    // Exercise 3: Pair distributive
    val pd = pairDistributive
    val listOfPairs = List(Pair(1, 2), Pair(3, 4), Pair(5, 6))
    val coseq = pd.cosequence[List, Int](listOfPairs)
    assert(coseq == Pair(List(1, 3, 5), List(2, 4, 6)))
    println("Exercise 3 passed: Pair distributive")

    // Exercise 4: Representable Pair
    val pr = pairRepresentable
    val p = pr.tabulate[Int]((b: pr.Rep) => if (b.asInstanceOf[Boolean]) 10 else 20)
    assert(p == Pair(10, 20) || p == Pair(20, 10))
    assert(pr.index(Pair(10, 20))(true.asInstanceOf[pr.Rep]) == 10)
    assert(pr.index(Pair(10, 20))(false.asInstanceOf[pr.Rep]) == 20)
    println("Exercise 4 passed: Representable Pair")

    // Exercise 5: Distributive from Representable
    val derived = distributiveFromRepresentable(pairRepresentable)
    val coseq2 = derived.cosequence[List, Int](listOfPairs)
    assert(coseq2 == Pair(List(1, 3, 5), List(2, 4, 6)))
    println("Exercise 5 passed: Distributive from Representable")

    // Exercise 6: Sequence vs Cosequence
    assert(sequenceOption(List(Some(1), Some(2), Some(3))) == Some(List(1, 2, 3)))
    assert(sequenceOption(List(Some(1), None, Some(3))) == None)
    val cp = cosequencePair(List(Pair("a", "b"), Pair("c", "d")))
    assert(cp == Pair(List("a", "c"), List("b", "d")))
    println("Exercise 6 passed: Sequence vs Cosequence")

    // Exercise 7: Logarithm / positions
    assert(pairPositions == List(true, false))
    println("Exercise 7 passed: Pair positions")

    // Exercise 8: Triple representable
    val t = tabulateTriple[String] {
      case First  => "one"
      case Second => "two"
      case Third  => "three"
    }
    assert(t == Triple("one", "two", "three"))
    assert(indexTriple(t)(Second) == "two")
    println("Exercise 8 passed: Triple tabulate/index")

    println("\nAll exercises passed!")
  }
}
