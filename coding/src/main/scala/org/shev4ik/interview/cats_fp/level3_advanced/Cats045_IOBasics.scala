package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 045 - IO Basics (Modeled as concept)
 *
 * IO[A] represents a description of a side-effectful computation that
 * produces a value of type A. It is lazy, referentially transparent,
 * and only executes when explicitly run. This models cats-effect IO concepts.
 */
object Cats045_IOBasics {

  // Simplified IO model for exercise purposes
  // In real code, use cats.effect.IO
  sealed trait SimpleIO[+A] { self =>
    def unsafeRunSync(): A = self match {
      case SimpleIO.Pure(a) => a
      case SimpleIO.Delay(thunk) => thunk()
      case SimpleIO.RaiseError(e) => throw e
      case SimpleIO.FlatMap(fa, f) => f(fa.unsafeRunSync()).unsafeRunSync()
      case SimpleIO.HandleError(fa, handler) =>
        try fa.unsafeRunSync()
        catch { case e: Throwable => handler(e).unsafeRunSync() }
    }

    def map[B](f: A => B): SimpleIO[B] =
      SimpleIO.FlatMap(self, (a: A) => SimpleIO.Pure(f(a)))

    def flatMap[B](f: A => SimpleIO[B]): SimpleIO[B] =
      SimpleIO.FlatMap(self, f)

    def handleErrorWith[B >: A](f: Throwable => SimpleIO[B]): SimpleIO[B] =
      SimpleIO.HandleError(self, f)

    def attempt: SimpleIO[Either[Throwable, A]] =
      self.map(a => Right(a): Either[Throwable, A])
        .handleErrorWith(e => SimpleIO.Pure(Left(e)))
  }

  object SimpleIO {
    case class Pure[A](a: A) extends SimpleIO[A]
    case class Delay[A](thunk: () => A) extends SimpleIO[A]
    case class RaiseError(e: Throwable) extends SimpleIO[Nothing]
    case class FlatMap[A, B](fa: SimpleIO[A], f: A => SimpleIO[B]) extends SimpleIO[B]
    case class HandleError[A](fa: SimpleIO[A], f: Throwable => SimpleIO[A]) extends SimpleIO[A]

    def pure[A](a: A): SimpleIO[A] = Pure(a)
    def delay[A](thunk: => A): SimpleIO[A] = Delay(() => thunk)
    def raiseError(e: Throwable): SimpleIO[Nothing] = RaiseError(e)
  }

  // Exercise 1: IO.pure - wrap a pure value in IO (no side effects)
  // TODO: Create an IO that wraps a pure value.
  def exercise1_pure(): SimpleIO[Int] = {
    // Wrap 42 in IO.pure - this should NOT evaluate any side effects
    ???
  }

  // Exercise 2: IO.delay - wrap a side-effectful computation (lazy)
  // TODO: Create an IO that delays a computation until run.
  var sideEffectCounter: Int = 0

  def exercise2_delay(): SimpleIO[Int] = {
    // Use IO.delay to wrap a computation that increments sideEffectCounter and returns it
    // The computation should NOT run until unsafeRunSync is called
    ???
  }

  // Exercise 3: IO.raiseError - create an IO that represents a failure
  // TODO: Create an IO that fails with an exception.
  def exercise3_raiseError(): SimpleIO[Int] = {
    // Create an IO that raises an IllegalArgumentException("invalid input")
    ???
  }

  // Exercise 4: IO.async concept - represent an async computation
  // TODO: Model an asynchronous computation concept.
  def exercise4_asyncConcept(): SimpleIO[String] = {
    // Model an async computation that "fetches" data
    // Use IO.delay to simulate async behavior
    // Return "async-result"
    ???
  }

  // Exercise 5: map - transform the value inside IO
  // TODO: Use map to transform an IO value.
  def exercise5_map(): SimpleIO[String] = {
    val io: SimpleIO[Int] = SimpleIO.pure(42)
    // Map to convert the Int to a String: "value: 42"
    ???
  }

  // Exercise 6: flatMap - chain IO computations sequentially
  // TODO: Use flatMap to chain dependent IO computations.
  def exercise6_flatMap(): SimpleIO[String] = {
    def fetchUserId(): SimpleIO[Int] = SimpleIO.pure(123)
    def fetchUserName(id: Int): SimpleIO[String] = SimpleIO.pure(s"user-$id")

    // Chain: fetchUserId then fetchUserName
    ???
  }

  // Exercise 7: handleErrorWith - recover from errors in IO
  // TODO: Use handleErrorWith to recover from an IO error.
  def exercise7_handleError(): SimpleIO[String] = {
    val failing: SimpleIO[String] = SimpleIO.raiseError(new RuntimeException("boom"))

    // Handle the error and return "recovered from: boom"
    ???
  }

  // Exercise 8: attempt - convert IO[A] to IO[Either[Throwable, A]]
  // TODO: Use attempt to safely capture errors as values.
  def exercise8_attempt(): (Either[Throwable, Int], Either[Throwable, Int]) = {
    val success: SimpleIO[Int] = SimpleIO.pure(42)
    val failure: SimpleIO[Int] = SimpleIO.raiseError(new RuntimeException("error"))

    // Use attempt on both to get Either values
    val r1: Either[Throwable, Int] = ???
    val r2: Either[Throwable, Int] = ???
    (r1, r2)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_pure().unsafeRunSync()
    assert(r1 == 42, s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: IO.pure => $r1")

    // Exercise 2
    sideEffectCounter = 0
    val io2 = exercise2_delay()
    assert(sideEffectCounter == 0, s"Exercise 2 failed: delay should not have run yet")
    val r2 = io2.unsafeRunSync()
    assert(sideEffectCounter == 1, s"Exercise 2 failed: counter=$sideEffectCounter")
    println(s"Exercise 2 passed: IO.delay => $r2 (counter=$sideEffectCounter)")

    // Exercise 3
    val r3 = try {
      exercise3_raiseError().unsafeRunSync()
      "no error"
    } catch {
      case e: IllegalArgumentException => e.getMessage
    }
    assert(r3 == "invalid input", s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: IO.raiseError => $r3")

    // Exercise 4
    val r4 = exercise4_asyncConcept().unsafeRunSync()
    assert(r4 == "async-result", s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: async concept => $r4")

    // Exercise 5
    val r5 = exercise5_map().unsafeRunSync()
    assert(r5 == "value: 42", s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: map => $r5")

    // Exercise 6
    val r6 = exercise6_flatMap().unsafeRunSync()
    assert(r6 == "user-123", s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: flatMap => $r6")

    // Exercise 7
    val r7 = exercise7_handleError().unsafeRunSync()
    assert(r7 == "recovered from: boom", s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: handleError => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_attempt()
    assert(r8a == Right(42), s"Exercise 8 failed: $r8a")
    assert(r8b.isLeft, s"Exercise 8 failed: $r8b")
    println(s"Exercise 8 passed: attempt => success=$r8a, failure=$r8b")

    println("\nAll Cats045_IOBasics exercises passed!")
  }
}
