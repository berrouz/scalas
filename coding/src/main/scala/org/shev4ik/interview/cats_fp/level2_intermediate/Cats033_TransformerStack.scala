package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 033 - Transformer Stacks
 *
 * Monad transformers can be stacked to combine multiple effects.
 * The ordering matters, and lifting values through layers requires care.
 */
object Cats033_TransformerStack {

  // Exercise 1: Stacking EitherT + Reader pattern
  // TODO: Create a stack that provides both error handling and dependency injection.
  //       EitherT[Reader[Config, ?], String, A] = Config => Either[String, A]
  case class Config(maxSize: Int)

  def exercise1_eitherTReader(): Config => Either[String, Int] = {
    type ReaderConfig[A] = Reader[Config, A]
    type Stack[A] = EitherT[ReaderConfig, String, A]

    def validate(n: Int): Stack[Int] = EitherT[ReaderConfig, String, Int] {
      Reader { (cfg: Config) =>
        if (n <= cfg.maxSize) Right(n)
        else Left(s"$n exceeds max size ${cfg.maxSize}")
      }
    }

    // Validate the number 5, then run with Config(10)
    // Return a function Config => Either[String, Int]
    val program: Stack[Int] = ???

    // Return a function that takes Config and produces Either
    (cfg: Config) => program.value.run(cfg)
  }

  // Exercise 2: Stacking OptionT + Either (simulating IO concept)
  // TODO: Create a stack with OptionT over Either for error + optionality.
  //       OptionT[Either[String, ?], A] = Either[String, Option[A]]
  def exercise2_optionTEither(): Either[String, Option[Int]] = {
    type EitherS[A] = Either[String, A]
    type Stack[A] = OptionT[EitherS, A]

    def findItem(id: Int): Stack[Int] =
      if (id > 0) OptionT.some[EitherS](id * 10)
      else OptionT.none[EitherS, Int]

    def validateItem(value: Int): Stack[Int] =
      if (value > 0) OptionT.liftF[EitherS, Int](Right(value))
      else OptionT.liftF[EitherS, Int](Left("invalid value"))

    // Find item 3 and validate it
    val program: Stack[Int] = ???

    program.value
  }

  // Exercise 3: Stacking StateT + Either - stateful computation with errors
  // TODO: Create a StateT[Either[String, ?], Int, A] stack.
  def exercise3_stateTEither(): Either[String, (Int, String)] = {
    type EitherS[A] = Either[String, A]
    type Stack[A] = StateT[EitherS, Int, A]

    def increment: Stack[Unit] = StateT.modify[EitherS, Int](_ + 1)

    def failIfOver(limit: Int): Stack[Unit] = StateT[EitherS, Int, Unit] { s =>
      if (s > limit) Left(s"State $s exceeds limit $limit")
      else Right((s, ()))
    }

    // Increment 3 times, then check if over limit 5
    val program: Stack[String] = ???

    program.run(0)
  }

  // Exercise 4: Ordering of transformers - demonstrate that order matters
  // TODO: Show the difference between EitherT[Option, E, A] and OptionT[Either[E, ?], A].
  //       EitherT[Option, E, A] = Option[Either[E, A]]
  //       OptionT[Either[E, ?], A] = Either[E, Option[A]]
  def exercise4_ordering(): (Option[Either[String, Int]], Either[String, Option[Int]]) = {
    type EitherS[A] = Either[String, A]

    // Stack 1: EitherT[Option, String, Int] = Option[Either[String, Int]]
    val stack1: EitherT[Option, String, Int] = ???  // Create a Right(42) inside Some

    // Stack 2: OptionT[Either[String, ?], Int] = Either[String, Option[Int]]
    val stack2: OptionT[EitherS, Int] = ???  // Create a Some(42) inside Right

    (stack1.value, stack2.value)
  }

  // Exercise 5: Lift helpers - lifting values through transformer layers
  // TODO: Demonstrate lifting values from inner to outer layers.
  def exercise5_liftHelpers(): Either[String, Option[Int]] = {
    type EitherS[A] = Either[String, A]
    type Stack[A] = OptionT[EitherS, A]

    // Lift a pure value
    val fromPure: Stack[Int] = ???  // OptionT.pure or OptionT.some

    // Lift from Either (the outer effect)
    val fromEither: Stack[Int] = ???  // OptionT.liftF

    // Lift from Option (the inner layer)
    val fromOption: Stack[Int] = ???  // OptionT.fromOption with [EitherS]

    // Use fromPure's value
    fromPure.value
  }

  // Exercise 6: Natural transformation between stacks
  // TODO: Use mapK to transform the outer effect of a transformer.
  def exercise6_naturalTransformation(): Either[String, (Int, Int)] = {
    type EitherS[A] = Either[String, A]

    val optionState: StateT[Option, Int, Int] =
      StateT(s => Some((s + 1, s * 2)))

    // Transform from StateT[Option, ...] to StateT[Either[String, ?], ...]
    val toEither: Option ~> EitherS = new (Option ~> EitherS) {
      def apply[A](fa: Option[A]): Either[String, A] = fa.toRight("was None")
    }

    val eitherState: StateT[EitherS, Int, Int] = ???

    eitherState.run(5)
  }

  // Exercise 7: Performance considerations - stacking has overhead
  // TODO: Demonstrate a simple computation and note the overhead pattern.
  //       Each layer adds one wrapper. Deep stacks = more allocation.
  def exercise7_performance(): Either[String, Option[Int]] = {
    // Instead of deep stacking, consider a custom effect type.
    // But for learning, here's a two-layer stack:
    type EitherS[A] = Either[String, A]
    type Stack[A] = OptionT[EitherS, A]

    // Simple computation: add numbers
    val program: Stack[Int] = for {
      a <- OptionT.some[EitherS](10)
      b <- OptionT.some[EitherS](20)
      c <- OptionT.some[EitherS](30)
    } yield a + b + c

    // This is equivalent to: Right(Some(60))
    // Each step wraps/unwraps through two layers
    ???
  }

  // Exercise 8: When to avoid stacking - use a single effect instead
  // TODO: Show an alternative to stacking: a combined ADT or type.
  //       Sometimes Either[Error, Option[A]] is simpler than OptionT[Either[Error, ?], A].
  sealed trait AppError
  case class NotFound(id: Int) extends AppError
  case class ValidationError(msg: String) extends AppError

  def exercise8_avoidStacking(): Either[AppError, Int] = {
    // Instead of OptionT[Either[...], A], use Either with a richer error type
    def findUser(id: Int): Either[AppError, Int] =
      if (id > 0) Right(id) else Left(NotFound(id))

    def validateAge(age: Int): Either[AppError, Int] =
      if (age >= 0 && age < 150) Right(age) else Left(ValidationError(s"Invalid age: $age"))

    // Compose using plain Either - simpler than transformer stacks!
    val result: Either[AppError, Int] = ???

    result
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_eitherTReader()
    assert(r1(Config(10)) == Right(5), s"Exercise 1 failed: ${r1(Config(10))}")
    println(s"Exercise 1 passed: EitherT + Reader => ${r1(Config(10))}")

    // Exercise 2
    val r2 = exercise2_optionTEither()
    assert(r2 == Right(Some(30)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: OptionT + Either => $r2")

    // Exercise 3
    val r3 = exercise3_stateTEither()
    assert(r3.isRight, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: StateT + Either => $r3")

    // Exercise 4
    val (r4a, r4b) = exercise4_ordering()
    assert(r4a == Some(Right(42)) && r4b == Right(Some(42)), s"Exercise 4 failed: ($r4a, $r4b)")
    println(s"Exercise 4 passed: ordering => stack1=$r4a, stack2=$r4b")

    // Exercise 5
    val r5 = exercise5_liftHelpers()
    assert(r5 == Right(Some(42)), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: lift helpers => $r5")

    // Exercise 6
    val r6 = exercise6_naturalTransformation()
    assert(r6 == Right((6, 10)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: natural transformation => $r6")

    // Exercise 7
    val r7 = exercise7_performance()
    assert(r7 == Right(Some(60)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: performance => $r7")

    // Exercise 8
    val r8 = exercise8_avoidStacking()
    assert(r8.isRight, s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: avoid stacking => $r8")

    println("\nAll Cats033_TransformerStack exercises passed!")
  }
}
