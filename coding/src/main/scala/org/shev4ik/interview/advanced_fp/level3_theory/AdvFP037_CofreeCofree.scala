package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP037 - Cofree Comonad
 *
 * Cofree[F, A] is the cofree comonad over functor F. It is an infinite
 * annotated tree: each node has a value A and children shaped by F.
 * Cofree is dual to Free: Free builds computations, Cofree provides contexts.
 * Pairing Free[F, A] with Cofree[G, B] when F and G are "paired" functors
 * gives an interpreter.
 */
object AdvFP037_CofreeCofree {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Comonad[F[_]] extends Functor[F] {
    def extract[A](fa: F[A]): A
    def coflatMap[A, B](fa: F[A])(f: F[A] => B): F[B]
    def duplicate[A](fa: F[A]): F[F[A]] = coflatMap(fa)(identity)
  }

  // ============================================================
  // Exercise 1: Define Cofree
  // Cofree[F, A] = (A, F[Cofree[F, A]])
  // An annotated tree with value A at each node and F-shaped children.
  // ============================================================
  case class Cofree[F[_], A](head: A, tail: F[Cofree[F, A]])

  // TODO: Implement Functor for Cofree[F, *] given Functor[F]
  def cofreeFunctor[F[_]](implicit F: Functor[F]): Functor[({type L[A] = Cofree[F, A]})#L] = ???

  // ============================================================
  // Exercise 2: Implement Comonad for Cofree
  // extract returns the head value.
  // coflatMap applies f to each subtree.
  // ============================================================
  // TODO: Implement Comonad for Cofree[F, *]
  def cofreeComonad[F[_]](implicit F: Functor[F]): Comonad[({type L[A] = Cofree[F, A]})#L] = ???

  // ============================================================
  // Exercise 3: Build a Cofree stream (Cofree over Identity-like functor)
  // An infinite stream annotated with values.
  // ============================================================
  // Using Option as a simple functor (finite streams)
  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  type CofreeStream[A] = Cofree[Option, A]

  // TODO: Build a finite cofree stream from a list
  def fromList[A](list: List[A]): Option[CofreeStream[A]] = ???

  // TODO: Convert cofree stream back to list
  def toList[A](stream: CofreeStream[A]): List[A] = ???

  // ============================================================
  // Exercise 4: Cofree as an annotated tree
  // Use Cofree over a pair functor to create a binary tree with annotations.
  // ============================================================
  case class PairF[A](left: A, right: A)

  implicit val pairFunctor: Functor[PairF] = new Functor[PairF] {
    def map[A, B](fa: PairF[A])(f: A => B): PairF[B] = PairF(f(fa.left), f(fa.right))
  }

  type AnnotatedTree[A] = Cofree[PairF, A]

  // TODO: Create a simple annotated binary tree
  def annotatedLeaf[A](value: A, defaultChild: A): AnnotatedTree[A] = ???

  // ============================================================
  // Exercise 5: Implement unfold for Cofree (build from a coalgebra)
  // Given a seed and a coalgebra A => (A, F[A]), build Cofree[F, A].
  // ============================================================
  // TODO: Unfold a Cofree from a seed
  def unfoldCofree[F[_]: Functor, A](seed: A)(f: A => F[A]): Cofree[F, A] = ???

  // ============================================================
  // Exercise 6: Cofree and coalgebras
  // A coalgebra A => F[A] gives rise to a Cofree.
  // Implement a coalgebra for counting down and build the Cofree.
  // ============================================================
  // TODO: Build a countdown cofree stream: n, n-1, ..., 0
  def countdown(n: Int): CofreeStream[Int] = ???

  // ============================================================
  // Exercise 7: Pairing Free and Cofree
  // If F and G are "paired" functors (there's a natural way to combine them),
  // then Free[F, A] can be interpreted by Cofree[G, B].
  // Implement a simple pairing for a request/response pattern.
  // ============================================================
  // Request functor: asking for a value
  sealed trait RequestF[+A]
  case class Ask[A](prompt: String, cont: String => A) extends RequestF[A]

  implicit val requestFunctor: Functor[RequestF] = new Functor[RequestF] {
    def map[A, B](fa: RequestF[A])(f: A => B): RequestF[B] = fa match {
      case Ask(p, cont) => Ask(p, s => f(cont(s)))
    }
  }

  // Response functor: providing answers
  case class ResponseF[+A](answers: Map[String, String], next: A)

  implicit val responseFunctor: Functor[ResponseF] = new Functor[ResponseF] {
    def map[A, B](fa: ResponseF[A])(f: A => B): ResponseF[B] =
      ResponseF(fa.answers, f(fa.next))
  }

  // Free for requests
  sealed trait Free[F[_], A]
  case class FPure[F[_], A](a: A) extends Free[F, A]
  case class FSuspend[F[_], A](fa: F[Free[F, A]]) extends Free[F, A]

  type FreeRequest[A] = Free[RequestF, A]
  type CofreeResponse[A] = Cofree[ResponseF, A]

  // TODO: Pair a FreeRequest with a CofreeResponse to interpret requests
  def pair[A, B](free: FreeRequest[A], cofree: CofreeResponse[B]): (A, B) = ???

  // ============================================================
  // Exercise 8: Cofree interpreter
  // Use Cofree to create a stateful interpreter for a simple language.
  // The Cofree holds the current state and transition function.
  // ============================================================
  sealed trait CommandF[+A]
  case class Increment[A](next: A) extends CommandF[A]
  case class GetValue[A](next: Int => A) extends CommandF[A]

  implicit val commandFunctor: Functor[CommandF] = new Functor[CommandF] {
    def map[A, B](fa: CommandF[A])(f: A => B): CommandF[B] = fa match {
      case Increment(n) => Increment(f(n))
      case GetValue(g) => GetValue(i => f(g(i)))
    }
  }

  // TODO: Build a Cofree interpreter that maintains a counter
  def counterInterpreter(initialValue: Int): Cofree[CommandF, Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Cofree functor
    val cf = cofreeFunctor[Option]
    val stream = Cofree[Option, Int](1, Some(Cofree[Option, Int](2, Some(Cofree[Option, Int](3, None)))))
    val mapped = cf.map(stream)(_ * 10)
    assert(mapped.head == 10)
    println("Exercise 1 passed: Cofree functor")

    // Exercise 2: Cofree comonad
    val cc = cofreeComonad[Option]
    assert(cc.extract(stream) == 1)
    val extended = cc.coflatMap(stream)(s => toList(s).sum)
    assert(extended.head == 6) // 1+2+3
    println("Exercise 2 passed: Cofree comonad")

    // Exercise 3: Cofree stream
    val fromL = fromList(List(1, 2, 3))
    assert(fromL.isDefined)
    assert(toList(fromL.get) == List(1, 2, 3))
    println("Exercise 3 passed: Cofree stream from/to list")

    // Exercise 4: Annotated tree
    val tree = annotatedLeaf(42, 0)
    assert(tree.head == 42)
    println("Exercise 4 passed: Annotated tree")

    // Exercise 5: Unfold Cofree
    val unfolded = unfoldCofree[Option, Int](5)(n => if (n > 0) Some(n - 1) else None)
    assert(unfolded.head == 5)
    assert(toList(unfolded) == List(5, 4, 3, 2, 1, 0))
    println("Exercise 5 passed: Unfold Cofree")

    // Exercise 6: Countdown
    val cd = countdown(3)
    assert(toList(cd) == List(3, 2, 1, 0))
    println("Exercise 6 passed: Countdown cofree stream")

    // Exercise 7: Pairing (compile check + basic test)
    val req: FreeRequest[String] = FSuspend[RequestF, String](Ask[Free[RequestF, String]]("name", answer => FPure[RequestF, String](answer)))
    val resp = Cofree[ResponseF, Unit]((), ResponseF(Map("name" -> "Alice"), Cofree[ResponseF, Unit]((), ResponseF(Map.empty, null))))
    val (result, _) = pair(req, resp)
    assert(result == "Alice")
    println("Exercise 7 passed: Free-Cofree pairing")

    // Exercise 8: Counter interpreter
    val counter = counterInterpreter(0)
    assert(counter.head == 0) // initial value
    println("Exercise 8 passed: Cofree interpreter")

    println("\nAll exercises passed!")
  }
}
