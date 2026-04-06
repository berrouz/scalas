package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 031 - StateT Monad Transformer
 *
 * StateT[F, S, A] wraps S => F[(S, A)], combining stateful computation
 * with an additional effect F. When F = Eval, StateT becomes State.
 */
object Cats031_StateT {

  // Using Option as our effect
  type Eff[A] = Option[A]

  // Exercise 1: StateT creation - create a StateT[Option, S, A]
  // TODO: Create a StateT that increments an Int state and returns the old value.
  def exercise1_creation(): StateT[Eff, Int, Int] = {
    // StateT[Option, Int, Int]: s => Some((s + 1, s))
    ???
  }

  // Exercise 2: run - execute StateT with an initial state
  // TODO: Run a StateT computation and extract the result.
  def exercise2_run(): Eff[(Int, String)] = {
    val computation: StateT[Eff, Int, String] =
      StateT(s => Some((s + 10, s"state was $s")))

    // Run with initial state 5
    ???
  }

  // Exercise 3: get - read the current state in StateT
  // TODO: Use StateT.get to inspect the current state within an effect.
  def exercise3_get(): Eff[(Int, Int)] = {
    val program: StateT[Eff, Int, Int] = for {
      s <- StateT.get[Eff, Int]
    } yield s * 2

    // Run with initial state 21
    ???
  }

  // Exercise 4: set - replace the state in StateT
  // TODO: Use StateT.set to overwrite the state.
  def exercise4_set(): Eff[(Int, Unit)] = {
    val program: StateT[Eff, Int, Unit] = for {
      _ <- StateT.set[Eff, Int](99)
    } yield ()

    // Run with initial state 0
    ???
  }

  // Exercise 5: modify - transform the state in StateT
  // TODO: Use StateT.modify to update the state with a function.
  def exercise5_modify(): Eff[(Int, Int)] = {
    val program: StateT[Eff, Int, Int] = for {
      _ <- StateT.modify[Eff, Int](_ + 5)
      _ <- StateT.modify[Eff, Int](_ * 2)
      s <- StateT.get[Eff, Int]
    } yield s

    // Run with initial state 10. Expected: (10+5)*2 = 30
    ???
  }

  // Exercise 6: liftF - lift an F[A] into StateT[F, S, A]
  // TODO: Use StateT.liftF to lift an Option value into StateT.
  def exercise6_liftF(): Eff[(Int, String)] = {
    val program: StateT[Eff, Int, String] = for {
      _ <- StateT.modify[Eff, Int](_ + 1)
      greeting <- StateT.liftF[Eff, Int, String](Some("hello"))
      s <- StateT.get[Eff, Int]
    } yield s"$greeting from state $s"

    // Run with initial state 0
    ???
  }

  // Exercise 7: mapK - transform the effect type using a natural transformation
  // TODO: Use mapK to change the outer effect from Option to Either.
  //       mapK applies a FunctionK (natural transformation) F ~> G.
  def exercise7_mapK(): Either[String, (Int, Int)] = {
    val optionState: StateT[Eff, Int, Int] =
      StateT(s => Some((s + 1, s)))

    // Define a natural transformation from Option to Either[String, ?]
    type EitherS[A] = Either[String, A]
    val optionToEither: Eff ~> EitherS = new (Eff ~> EitherS) {
      def apply[A](fa: Eff[A]): Either[String, A] = fa.toRight("was None")
    }

    // Use mapK to transform StateT[Option, Int, Int] to StateT[Either[String, ?], Int, Int]
    val eitherState: StateT[EitherS, Int, Int] = ???

    eitherState.run(5)
  }

  // Exercise 8: Combining StateT with other effects
  // TODO: Build a program that uses StateT with Option, where None short-circuits.
  def exercise8_combining(): (Eff[(Int, String)], Eff[(Int, String)]) = {
    def safeDivide(a: Int, b: Int): Eff[Int] =
      if (b != 0) Some(a / b) else None

    val successProgram: StateT[Eff, Int, String] = for {
      s <- StateT.get[Eff, Int]
      result <- StateT.liftF[Eff, Int, Int](safeDivide(s, 2))
      _ <- StateT.set[Eff, Int](result)
      finalState <- StateT.get[Eff, Int]
    } yield s"Result: $finalState"

    val failProgram: StateT[Eff, Int, String] = for {
      s <- StateT.get[Eff, Int]
      result <- StateT.liftF[Eff, Int, Int](safeDivide(s, 0))  // Division by zero!
      _ <- StateT.set[Eff, Int](result)
      finalState <- StateT.get[Eff, Int]
    } yield s"Result: $finalState"

    // Run both with initial state 100
    val success: Eff[(Int, String)] = ???
    val failure: Eff[(Int, String)] = ???
    (success, failure)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_creation().run(5)
    assert(r1 == Some((6, 5)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: StateT creation => $r1")

    // Exercise 2
    val r2 = exercise2_run()
    assert(r2 == Some((15, "state was 5")), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: run => $r2")

    // Exercise 3
    val r3 = exercise3_get()
    assert(r3 == Some((21, 42)), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: get => $r3")

    // Exercise 4
    val r4 = exercise4_set()
    assert(r4 == Some((99, ())), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: set => $r4")

    // Exercise 5
    val r5 = exercise5_modify()
    assert(r5 == Some((30, 30)), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: modify => $r5")

    // Exercise 6
    val r6 = exercise6_liftF()
    assert(r6 == Some((1, "hello from state 1")), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: liftF => $r6")

    // Exercise 7
    val r7 = exercise7_mapK()
    assert(r7 == Right((6, 5)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: mapK => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_combining()
    assert(r8a == Some((50, "Result: 50")), s"Exercise 8 failed: success=$r8a")
    assert(r8b == None, s"Exercise 8 failed: failure=$r8b")
    println(s"Exercise 8 passed: combining => success=$r8a, failure=$r8b")

    println("\nAll Cats031_StateT exercises passed!")
  }
}
