package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 001 - Creating ZIO values with succeed, fail, and type aliases.
 *
 * ZIO[R, E, A] is the core type:
 *   R = environment (dependencies), E = error type, A = success type
 *
 * Key constructors: ZIO.succeed, ZIO.fail
 * Type aliases: UIO[A], Task[A], IO[E,A], URIO[R,A], RIO[R,A]
 *
 * === ZIO.succeed vs ZIO.attempt (formerly ZIO.effect) ===
 *
 * ZIO.succeed(value):
 *   - The argument is EAGERLY evaluated (call-by-value in ZIO 1.x, by-name but
 *     semantically assumed pure in ZIO 2.x). It wraps an already-computed, PURE value
 *     into a ZIO effect.
 *   - Should ONLY be used with pure, total expressions (no side effects, no exceptions).
 *   - The ZIO runtime trusts that the wrapped computation is pure and will not
 *     re-execute it or protect against exceptions.
 *
 * ZIO.attempt(computation) (ZIO 2.x) / ZIO.effect(computation) (ZIO 1.x):
 *   - The argument is LAZILY evaluated (call-by-name). It wraps a potentially
 *     side-effecting computation that may throw exceptions.
 *   - The ZIO runtime will catch any thrown exceptions and translate them into
 *     the error channel (Throwable).
 *   - Use this for interacting with legacy/Java code, I/O, or anything impure.
 *
 * Why does this matter? If you write ZIO.succeed(println("hi")), the println
 * executes IMMEDIATELY at construction time, outside the ZIO runtime's control.
 * The resulting ZIO just wraps the Unit value. If you write ZIO.attempt(println("hi")),
 * the println is deferred and only runs when the ZIO effect is interpreted by the runtime.
 *
 * INTERVIEW TIP: Common interview question: "What's the difference between
 * ZIO.succeed(println("hi")) and ZIO.attempt(println("hi"))?"
 * Answer: ZIO.succeed evaluates its argument eagerly at construction time -- the
 * println fires immediately and the ZIO just wraps (). ZIO.attempt captures the
 * computation lazily -- the println only fires when the ZIO runtime runs the effect.
 * Using succeed with side effects is a bug because it breaks referential transparency.
 */
object Zio001_Succeed {

  // Exercise 1: Create a ZIO that succeeds with the integer 42
  // TODO: Use ZIO.succeed to wrap a pure value
  // UIO[Int] = ZIO[Any, Nothing, Int] -- no environment needed, cannot fail, produces Int.
  // Use UIO when you have a pure computation that will never fail (e.g., wrapping constants,
  // pure transformations). It communicates to callers that no error handling is needed.
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a ZIO that fails with the string "boom"
  // TODO: Use ZIO.fail to create a failed effect
  // IO[String, Nothing] = ZIO[Any, String, Nothing] -- no environment, fails with String, never succeeds.
  // Use IO[E, A] when your effect doesn't require an environment but can fail with a custom
  // error type E (not necessarily Throwable). Great for domain-specific error modeling.
  val exercise2: IO[String, Nothing] = ???

  // Exercise 3: Create a UIO that succeeds with the string "hello"
  // TODO: UIO[A] is an alias for ZIO[Any, Nothing, A] -- it cannot fail
  // In real code, use UIO for infallible operations: logging wrappers, metrics, pure calculations.
  // Because E = Nothing, the compiler guarantees no error handling is needed downstream.
  val exercise3: UIO[String] = ???

  // Exercise 4: Create a Task that succeeds with the value 100
  // TODO: Task[A] is an alias for ZIO[Any, Throwable, A]
  // Task is the most commonly used alias in real applications. Use it when wrapping Java/Scala
  // code that may throw exceptions (e.g., HTTP calls, DB queries, file I/O). It is the ZIO
  // equivalent of scala.concurrent.Future[A] or cats.effect.IO[A].
  val exercise4: Task[Int] = ???

  // Exercise 5: Create an IO[String, Int] that succeeds with 10
  // TODO: IO[E, A] is an alias for ZIO[Any, E, A]
  // Use IO[E, A] when you want typed errors that are NOT Throwable. For example,
  // IO[DomainError, User] in a service layer where DomainError is a sealed trait.
  // This is one of ZIO's strengths over Future/cats-IO: first-class typed error channels.
  val exercise5: IO[String, Int] = ???

  // Exercise 6: Return ZIO.unit -- a ZIO that succeeds with ()
  // TODO: ZIO.unit is a convenience for ZIO.succeed(())
  // In real code, use ZIO.unit as the return value for fire-and-forget operations,
  // or as the "do nothing" branch in conditional logic (e.g., ZIO.when(cond)(action)).
  val exercise6: UIO[Unit] = ???

  // Exercise 7: Return ZIO.none -- a ZIO that succeeds with None
  // TODO: ZIO.none is a convenience for ZIO.succeed(None)
  // Useful when implementing lookups/caches that return Option -- e.g., returning ZIO.none
  // when a key is not found, paired with ZIO.some(value) when it is.
  val exercise7: UIO[Option[Nothing]] = ???

  // Exercise 8: Return ZIO.some(42) -- a ZIO that succeeds with Some(42)
  // TODO: ZIO.some(a) is a convenience for ZIO.succeed(Some(a))
  // ZIO.some/ZIO.none pair well with ZIO's Option-based combinators like .someOrFail,
  // .someOrElse, making optional value handling ergonomic in effect pipelines.
  val exercise8: UIO[Option[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2.either)
    assert(r2 == Left("boom"), s"Exercise 2 failed: expected Left(boom), got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "hello", s"Exercise 3 failed: expected hello, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 100, s"Exercise 4 failed: expected 100, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 10, s"Exercise 5 failed: expected 10, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == (), s"Exercise 6 failed: expected (), got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.isEmpty, s"Exercise 7 failed: expected None, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.contains(42), s"Exercise 8 failed: expected Some(42), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio001_Succeed exercises passed!")
  }
}
