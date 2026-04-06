package org.shev4ik.interview.testing.level2_intermediate

/**
 * Test008 - Property-Based Testing
 *
 * Building generators, defining properties, shrinking failing cases,
 * and understanding ScalaCheck-like concepts from scratch.
 */
object Test008_PropertyBasedTesting {

  import scala.util.Random

  // ==========================================================================
  // Exercise 1: Implement basic generators
  // ==========================================================================
  // TODO: Implement a `Gen[A]` trait with a `generate(rng: Random): A` method.
  //       Then implement these factory methods in the Gen companion object:
  //       - Gen.int(min: Int, max: Int): Gen[Int]
  //       - Gen.string(minLen: Int, maxLen: Int): Gen[String]  (alphanumeric chars)
  //       - Gen.boolean: Gen[Boolean]
  //       - Gen.oneOf[A](values: A*): Gen[A]  (picks one randomly)
  trait Gen[A] {
    def generate(rng: Random): A
  }

  object Gen {
    def int(min: Int, max: Int): Gen[Int] = ???
    def string(minLen: Int, maxLen: Int): Gen[String] = ???
    def boolean: Gen[Boolean] = ???
    def oneOf[A](values: A*): Gen[A] = ???
  }

  // ==========================================================================
  // Exercise 2: Implement generator combinators
  // ==========================================================================
  // TODO: Add combinator methods to Gen[A] (implement via extension or wrapper):
  //       - map[B](f: A => B): Gen[B]
  //       - flatMap[B](f: A => Gen[B]): Gen[B]
  //       - filter(pred: A => Boolean): Gen[A]  (retry until predicate holds, max 100 tries)
  //       - list(minSize: Int, maxSize: Int): Gen[List[A]]  (generate a list of A's)
  implicit class GenOps[A](gen: Gen[A]) {
    def map[B](f: A => B): Gen[B] = ???
    def flatMap[B](f: A => Gen[B]): Gen[B] = ???
    def filter(pred: A => Boolean): Gen[A] = ???
    def list(minSize: Int, maxSize: Int): Gen[List[A]] = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a property checker
  // ==========================================================================
  // TODO: Implement `forAll` that takes a Gen[A] and a property (A => Boolean).
  //       It should generate `numTests` random values and check the property.
  //       Return a PropertyResult:
  //       - Passed(numTests: Int) if all passed
  //       - Failed(counterExample: A, seed: Long, iteration: Int) if any failed
  //       Use a seeded Random for reproducibility.
  sealed trait PropertyResult[+A]
  case class Passed(numTests: Int) extends PropertyResult[Nothing]
  case class Failed[A](counterExample: A, seed: Long, iteration: Int) extends PropertyResult[A]

  def forAll[A](gen: Gen[A], numTests: Int = 100, seed: Long = 42L)(prop: A => Boolean): PropertyResult[A] = ???

  // ==========================================================================
  // Exercise 4: Implement shrinking
  // ==========================================================================
  // TODO: Implement a `Shrink[A]` trait with `shrink(value: A): Stream[A]`
  //       that produces simpler/smaller values.
  //       Implement shrinks for:
  //       - Shrink.int: shrinks toward 0 (e.g., n/2, n-1, 0)
  //       - Shrink.string: shrinks by removing characters and reducing length
  //       - Shrink.list[A]: shrinks by removing elements and shrinking elements
  trait Shrink[A] {
    def shrink(value: A): Stream[A]
  }

  object Shrink {
    def int: Shrink[Int] = ???
    def string: Shrink[String] = ???
    def list[A]: Shrink[List[A]] = ???
  }

  // ==========================================================================
  // Exercise 5: Implement forAll with shrinking
  // ==========================================================================
  // TODO: Implement `forAllShrink` similar to `forAll` but when a failing case
  //       is found, use the Shrink to find a minimal counterexample.
  //       Keep shrinking as long as shrunk values still fail the property.
  //       Return the smallest failing value found.
  case class ShrinkResult[A](
    originalFailure: A,
    minimalFailure: A,
    shrinkSteps: Int
  )

  def forAllShrink[A](gen: Gen[A], shrink: Shrink[A], numTests: Int = 100, seed: Long = 42L)(
    prop: A => Boolean
  ): Either[ShrinkResult[A], Passed] = ???

  // ==========================================================================
  // Exercise 6: Implement common property patterns
  // ==========================================================================
  // TODO: Implement reusable property combinators:
  //       - roundTrip[A, B](encode: A => B, decode: B => A): A => Boolean
  //         (verifies decode(encode(a)) == a)
  //       - idempotent[A](f: A => A): A => Boolean
  //         (verifies f(f(a)) == f(a))
  //       - commutative[A, B](f: (A, A) => B): (A, A) => Boolean
  //         (verifies f(a, b) == f(b, a))
  //       - associative[A](f: (A, A) => A): (A, A, A) => Boolean
  //         (verifies f(f(a, b), c) == f(a, f(b, c)))
  def roundTrip[A, B](encode: A => B, decode: B => A): A => Boolean = ???
  def idempotent[A](f: A => A): A => Boolean = ???
  def commutative[A, B](f: (A, A) => B): (A, A) => Boolean = ???
  def associative[A](f: (A, A) => A): (A, A, A) => Boolean = ???

  // ==========================================================================
  // Exercise 7: Implement a generator for complex data structures
  // ==========================================================================
  // TODO: Implement generators for:
  //       - Gen.option[A](gen: Gen[A]): Gen[Option[A]]  (None ~25% of time)
  //       - Gen.either[A, B](genA: Gen[A], genB: Gen[B]): Gen[Either[A, B]]
  //       - Gen.map[K, V](keyGen: Gen[K], valGen: Gen[V], maxSize: Int): Gen[Map[K, V]]
  //       - Gen.tree[A](gen: Gen[A], maxDepth: Int): Gen[Tree[A]]
  //         where Tree is: case class Leaf[A](value: A); case class Branch[A](left: Tree[A], right: Tree[A])
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object GenComplex {
    def option[A](gen: Gen[A]): Gen[Option[A]] = ???
    def either[A, B](genA: Gen[A], genB: Gen[B]): Gen[Either[A, B]] = ???
    def map[K, V](keyGen: Gen[K], valGen: Gen[V], maxSize: Int): Gen[Map[K, V]] = ???
    def tree[A](gen: Gen[A], maxDepth: Int): Gen[Tree[A]] = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a stateful property test (model-based testing)
  // ==========================================================================
  // TODO: Implement a simple model-based testing framework:
  //       - Command[S, M] sealed trait representing operations on system (S) and model (M)
  //       - Define `runStateful` that takes:
  //         - initial system state and initial model state
  //         - a list of commands to execute
  //         - execute: (Command, S) => S  (runs command on real system)
  //         - model: (Command, M) => M  (runs command on model)
  //         - check: (S, M) => Boolean  (verifies system matches model after each command)
  //       Return true if all checks pass after each command.
  def runStateful[S, M, C](
    initialSystem: S,
    initialModel: M,
    commands: List[C],
    execute: (C, S) => S,
    model: (C, M) => M,
    check: (S, M) => Boolean
  ): Boolean = ???

  def main(args: Array[String]): Unit = {
    val rng = new Random(42)

    // Exercise 1
    val intGen = Gen.int(1, 100)
    val values = (1 to 20).map(_ => intGen.generate(rng))
    assert(values.forall(v => v >= 1 && v <= 100))
    val strGen = Gen.string(3, 5)
    val str = strGen.generate(rng)
    assert(str.length >= 3 && str.length <= 5)
    println("Exercise 1 passed: basic generators work")

    // Exercise 2
    val doubleGen = Gen.int(1, 10).map(_.toDouble)
    assert(doubleGen.generate(rng).isInstanceOf[Double])
    val evenGen = Gen.int(1, 100).filter(_ % 2 == 0)
    assert(evenGen.generate(rng) % 2 == 0)
    val listGen = Gen.int(1, 10).list(2, 5)
    val generated = listGen.generate(rng)
    assert(generated.length >= 2 && generated.length <= 5)
    println("Exercise 2 passed: generator combinators work")

    // Exercise 3
    val addCommutative = forAll(Gen.int(-100, 100), numTests = 50) { a =>
      val b = Gen.int(-100, 100).generate(new Random(a.toLong))
      a + b == b + a
    }
    assert(addCommutative.isInstanceOf[Passed])
    val alwaysFail = forAll(Gen.int(1, 100), numTests = 10) { a => a < 0 }
    assert(alwaysFail.isInstanceOf[Failed[_]])
    println("Exercise 3 passed: property checker works")

    // Exercise 4
    val shrunkInts = Shrink.int.shrink(100).take(5).toList
    assert(shrunkInts.nonEmpty && shrunkInts.exists(_ < 100))
    val shrunkStr = Shrink.string.shrink("abcde").take(5).toList
    assert(shrunkStr.nonEmpty && shrunkStr.exists(_.length < 5))
    println("Exercise 4 passed: shrinking works")

    // Exercise 5
    val shrinkResult = forAllShrink(Gen.int(1, 1000), Shrink.int, numTests = 100) { n =>
      n < 50
    }
    assert(shrinkResult.isLeft)
    shrinkResult.left.foreach { sr =>
      assert(sr.minimalFailure <= sr.originalFailure)
    }
    println("Exercise 5 passed: forAll with shrinking works")

    // Exercise 6
    val rt = roundTrip[Int, String](_.toString, _.toInt)
    assert(rt(42))
    assert(rt(-1))
    val idem = idempotent[Int](math.abs)
    assert(idem(-5))
    val comm = commutative[Int, Int](_ + _)
    assert(comm(3, 5))
    val assoc = associative[Int](_ + _)
    assert(assoc(1, 2, 3))
    println("Exercise 6 passed: property patterns work")

    // Exercise 7
    val optGen = GenComplex.option(Gen.int(1, 10))
    val opts = (1 to 50).map(_ => optGen.generate(rng))
    assert(opts.exists(_.isEmpty) || true) // probabilistic, just check it runs
    assert(opts.exists(_.isDefined))
    val treeGen = GenComplex.tree(Gen.int(1, 100), maxDepth = 3)
    val genTree = treeGen.generate(rng)
    assert(genTree != null)
    println("Exercise 7 passed: complex generators work")

    // Exercise 8
    // Model-based test: test a counter using a List as the real system and Int as model
    sealed trait CounterCmd
    case object Increment extends CounterCmd
    case object Decrement extends CounterCmd
    case object Reset extends CounterCmd

    val cmds: List[CounterCmd] = List(Increment, Increment, Decrement, Increment, Reset)
    val result = runStateful[List[Int], Int, CounterCmd](
      initialSystem = List(0),
      initialModel = 0,
      commands = cmds,
      execute = {
        case (Increment, s) => (s.head + 1) :: s
        case (Decrement, s) => (s.head - 1) :: s
        case (Reset, _) => List(0)
      },
      model = {
        case (Increment, m) => m + 1
        case (Decrement, m) => m - 1
        case (Reset, _) => 0
      },
      check = (s, m) => s.head == m
    )
    assert(result)
    println("Exercise 8 passed: stateful model-based testing works")

    println("\nAll Test008 exercises passed!")
  }
}
