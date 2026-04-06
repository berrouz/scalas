package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 046 - IO Concurrency (Modeled as concepts)
 *
 * IO supports concurrent operations: parMapN, race, both, fibers, etc.
 * These concepts are modeled here using simplified types to demonstrate
 * the patterns used in cats-effect IO concurrency.
 */
object Cats046_IOConcurrency {

  // Simplified IO reuse from Cats045
  sealed trait SimpleIO[+A] { self =>
    def unsafeRunSync(): A = self match {
      case SimpleIO.Pure(a) => a
      case SimpleIO.Delay(thunk) => thunk()
      case SimpleIO.FlatMap(fa, f) => f(fa.unsafeRunSync()).unsafeRunSync()
      case SimpleIO.HandleError(fa, h) =>
        try fa.unsafeRunSync()
        catch { case e: Throwable => h(e).unsafeRunSync() }
    }
    def map[B](f: A => B): SimpleIO[B] = SimpleIO.FlatMap(self, (a: A) => SimpleIO.Pure(f(a)))
    def flatMap[B](f: A => SimpleIO[B]): SimpleIO[B] = SimpleIO.FlatMap(self, f)
    def handleErrorWith[B >: A](f: Throwable => SimpleIO[B]): SimpleIO[B] = SimpleIO.HandleError(self, f)
  }

  object SimpleIO {
    case class Pure[A](a: A) extends SimpleIO[A]
    case class Delay[A](thunk: () => A) extends SimpleIO[A]
    case class FlatMap[A, B](fa: SimpleIO[A], f: A => SimpleIO[B]) extends SimpleIO[B]
    case class HandleError[A](fa: SimpleIO[A], f: Throwable => SimpleIO[A]) extends SimpleIO[A]

    def pure[A](a: A): SimpleIO[A] = Pure(a)
    def delay[A](thunk: => A): SimpleIO[A] = Delay(() => thunk)

    // Simplified parMapN: runs both computations (sequentially in this model)
    def parMapN[A, B, C](fa: SimpleIO[A], fb: SimpleIO[B])(f: (A, B) => C): SimpleIO[C] =
      for { a <- fa; b <- fb } yield f(a, b)

    // Simplified race: runs both, returns first to complete (Left wins in this model)
    def race[A, B](fa: SimpleIO[A], fb: SimpleIO[B]): SimpleIO[Either[A, B]] =
      fa.map(a => Left(a): Either[A, B])

    // Simplified both: runs both, returns pair
    def both[A, B](fa: SimpleIO[A], fb: SimpleIO[B]): SimpleIO[(A, B)] =
      for { a <- fa; b <- fb } yield (a, b)
  }

  // Simplified Fiber concept
  case class Fiber[A](join: SimpleIO[A], cancel: SimpleIO[Unit])

  // Exercise 1: IO.parMapN - run two IOs concurrently and combine results
  // TODO: Use parMapN to combine two IO computations.
  def exercise1_parMapN(): SimpleIO[String] = {
    val fetchName: SimpleIO[String] = SimpleIO.delay("Alice")
    val fetchAge: SimpleIO[Int] = SimpleIO.delay(30)

    // Combine using parMapN to produce "Alice is 30"
    ???
  }

  // Exercise 2: IO.race - race two IOs, return the first to complete
  // TODO: Use race to get the result of the faster computation.
  def exercise2_race(): SimpleIO[Either[String, Int]] = {
    val fast: SimpleIO[String] = SimpleIO.delay("fast-result")
    val slow: SimpleIO[Int] = SimpleIO.delay { Thread.sleep(10); 42 }

    // Race the two computations
    ???
  }

  // Exercise 3: IO.both - run two IOs concurrently, get both results
  // TODO: Use both to run two computations and get a tuple of results.
  def exercise3_both(): SimpleIO[(String, Int)] = {
    val io1: SimpleIO[String] = SimpleIO.delay("hello")
    val io2: SimpleIO[Int] = SimpleIO.delay(42)

    // Run both and get a tuple
    ???
  }

  // Exercise 4: IO.start (Fiber concept) - start a computation as a fiber
  // TODO: Model starting an IO as a fiber and joining it.
  def exercise4_fiber(): SimpleIO[String] = {
    // Model: start a computation, get a Fiber, then join it
    val computation: SimpleIO[String] = SimpleIO.delay("fiber-result")

    // Simulate fiber: start returns a Fiber, join gets the result
    val fiber = Fiber(
      join = computation,
      cancel = SimpleIO.pure(())
    )

    // Join the fiber to get its result
    ???
  }

  // Exercise 5: IO.cancelable concept - model cancellation
  // TODO: Model a cancelable computation concept.
  def exercise5_cancelable(): SimpleIO[String] = {
    var cancelled = false

    // Model a cancelable computation
    // If not cancelled, return "completed"
    // The cancellation token sets cancelled = true
    val computation: SimpleIO[String] = SimpleIO.delay {
      if (cancelled) "cancelled" else "completed"
    }

    ???
  }

  // Exercise 6: IO.sleep concept - model a delayed computation
  // TODO: Model IO.sleep as a delayed unit effect.
  def exercise6_sleep(): SimpleIO[String] = {
    // Model: sleep for a duration, then return a value
    val sleepIO: SimpleIO[Unit] = SimpleIO.delay(()) // simulate sleep

    // After "sleeping", return "woke up"
    ???
  }

  // Exercise 7: IO.timeout concept - model timeout behavior
  // TODO: Model a computation with a timeout.
  def exercise7_timeout(): SimpleIO[Either[String, String]] = {
    val computation: SimpleIO[String] = SimpleIO.delay("completed in time")

    // Model timeout: if computation completes in time, Right(result)
    // if it times out, Left("timeout")
    ???
  }

  // Exercise 8: Concurrent patterns - combine concurrency primitives
  // TODO: Build a pattern using multiple concurrency concepts.
  def exercise8_concurrentPattern(): SimpleIO[List[String]] = {
    def fetchData(id: Int): SimpleIO[String] = SimpleIO.delay(s"data-$id")

    // Fetch data for ids 1, 2, 3 "concurrently" and collect results
    // Use parMapN or sequential flatMap to simulate concurrent fetches
    val ids = List(1, 2, 3)
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_parMapN().unsafeRunSync()
    assert(r1 == "Alice is 30", s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: parMapN => $r1")

    // Exercise 2
    val r2 = exercise2_race().unsafeRunSync()
    assert(r2.isLeft, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: race => $r2")

    // Exercise 3
    val r3 = exercise3_both().unsafeRunSync()
    assert(r3 == ("hello", 42), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: both => $r3")

    // Exercise 4
    val r4 = exercise4_fiber().unsafeRunSync()
    assert(r4 == "fiber-result", s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: fiber => $r4")

    // Exercise 5
    val r5 = exercise5_cancelable().unsafeRunSync()
    assert(r5 == "completed", s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: cancelable => $r5")

    // Exercise 6
    val r6 = exercise6_sleep().unsafeRunSync()
    assert(r6 == "woke up", s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: sleep => $r6")

    // Exercise 7
    val r7 = exercise7_timeout().unsafeRunSync()
    assert(r7 == Right("completed in time"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: timeout => $r7")

    // Exercise 8
    val r8 = exercise8_concurrentPattern().unsafeRunSync()
    assert(r8 == List("data-1", "data-2", "data-3"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: concurrent pattern => $r8")

    println("\nAll Cats046_IOConcurrency exercises passed!")
  }
}
