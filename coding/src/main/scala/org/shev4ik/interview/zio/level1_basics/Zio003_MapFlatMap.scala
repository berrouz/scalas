package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 003 - Monadic Composition: map, flatMap, and for-comprehensions
 *
 * == Core Concept: ZIO as a Monad ==
 * ZIO forms a monad, which means it supports two fundamental operations:
 *   - `flatMap` (also called `bind` or `>>=` in Haskell) — sequences two effects where the
 *     second effect can depend on the result of the first.
 *   - `map` — transforms the success value inside a ZIO without introducing a new effect.
 *
 * These two operations, together with a constructor (`ZIO.succeed`), satisfy the three monad laws:
 *   1. '''Left identity:'''  `ZIO.succeed(a).flatMap(f) == f(a)`
 *   2. '''Right identity:''' `m.flatMap(ZIO.succeed) == m`
 *   3. '''Associativity:'''  `m.flatMap(f).flatMap(g) == m.flatMap(a => f(a).flatMap(g))`
 *
 * == How for-comprehensions desugar ==
 * Scala's for-comprehension is syntactic sugar that the compiler rewrites:
 * {{{
 *   // This for-comprehension:
 *   for {
 *     a <- ZIO.succeed(1)
 *     b <- ZIO.succeed(2)
 *     c <- ZIO.succeed(a + b)
 *   } yield c
 *
 *   // Desugars to:
 *   ZIO.succeed(1).flatMap { a =>
 *     ZIO.succeed(2).flatMap { b =>
 *       ZIO.succeed(a + b).map { c =>
 *         c
 *       }
 *     }
 *   }
 * }}}
 * The last generator uses `map` (via `yield`), and all preceding generators use `flatMap`.
 * Guards (`if` conditions) desugar to `.withFilter`, which ZIO does not support — use
 * `ZIO.when` or `ZIO.cond` instead.
 *
 * == Key operators covered ==
 * | Operator      | Signature (simplified)                              | Purpose                                         |
 * |---------------|-----------------------------------------------------|-------------------------------------------------|
 * | `map`         | `ZIO[R,E,A] => (A => B) => ZIO[R,E,B]`             | Transform success value                          |
 * | `flatMap`     | `ZIO[R,E,A] => (A => ZIO[R,E,B]) => ZIO[R,E,B]`   | Sequence dependent effects                       |
 * | `as`          | `ZIO[R,E,A] => B => ZIO[R,E,B]`                    | Replace success value (equivalent to `map(_ => b)`) |
 * | `unit`        | `ZIO[R,E,A] => ZIO[R,E,Unit]`                      | Discard success value (equivalent to `as(())`)   |
 * | `tap`         | `ZIO[R,E,A] => (A => ZIO[R,E,_]) => ZIO[R,E,A]`   | Side-effect on success without changing value    |
 * | `mapError`    | `ZIO[R,E,A] => (E => E2) => ZIO[R,E2,A]`           | Transform error value                            |
 * | `flatMapError`| `ZIO[R,E,A] => (E => ZIO[R,_,E2]) => ZIO[R,E2,A]` | Transform error with an effectful computation    |
 *
 * == Interview Tip ==
 * '''Q: What happens if the first ZIO in a for-comprehension fails? Does the second one execute?'''
 *
 * No. Because for-comprehensions desugar to `flatMap` chains, and `flatMap` implements
 * short-circuit semantics: if the first effect fails (with a typed error or a defect),
 * the subsequent effects are never executed. The failure propagates immediately. This is
 * analogous to how `Option.flatMap` short-circuits on `None`, or how `Either.flatMap`
 * short-circuits on `Left`.
 *
 * {{{
 *   for {
 *     a <- ZIO.fail("boom")         // Fails here
 *     b <- ZIO.succeed(42)          // Never reached
 *   } yield b
 *   // Result: a failed ZIO with error "boom"
 * }}}
 *
 * '''Follow-up:''' "How do you run the second effect even if the first fails?"
 * Use error recovery (`catchAll`, `orElse`, `fold`) before the second step, or use
 * `zipPar`/`collectAllPar` if you want concurrent independent execution.
 *
 * == Real-World Context ==
 * For-comprehensions are the bread and butter of ZIO application code. A typical service
 * method reads like a sequential script: validate input, call repository, transform result,
 * publish event — each step is a line in a for-comprehension. The monadic structure guarantees
 * that if any step fails, the remaining steps are skipped and the error propagates to the
 * caller, where it can be handled at the appropriate level (e.g., in the HTTP error handler).
 */
object Zio003_MapFlatMap {

  // Exercise 1: Use map to transform ZIO.succeed(21) by doubling it
  // TODO: ZIO.succeed(21).map(...)
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use flatMap to chain two effects
  // TODO: ZIO.succeed(10).flatMap(a => ZIO.succeed(a + 20))
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use a for-comprehension to combine three effects
  // TODO: for { a <- ZIO.succeed(1); b <- ZIO.succeed(2); c <- ZIO.succeed(3) } yield a + b + c
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use `as` to replace the success value
  // TODO: ZIO.succeed(42).as("hello") — ignores 42 and succeeds with "hello"
  val exercise4: UIO[String] = ???

  // Exercise 5: Use `unit` to discard the success value
  // TODO: ZIO.succeed(42).unit — succeeds with ()
  val exercise5: UIO[Unit] = ???

  // Exercise 6: Use `tap` to perform a side effect without changing the value
  // TODO: ZIO.succeed(42).tap(n => ZIO.effectTotal(println(s"tap: $n")))
  // The result should still be 42
  val exercise6: UIO[Int] = ???

  // Exercise 7: Use mapError to transform the error channel
  // TODO: ZIO.fail("error").mapError(_.length) — transforms error "error" to its length (5)
  // Then use .either to get Left(5)
  val exercise7: UIO[Either[Int, Nothing]] = ???

  // Exercise 8: Use flatMapError to transform the error with an effectful computation
  // TODO: ZIO.fail("boom").flatMapError(e => ZIO.succeed(e + "!"))
  // Then use .either to get Left("boom!")
  val exercise8: UIO[Either[String, Nothing]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 30, s"Exercise 2 failed: expected 30, got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 6, s"Exercise 3 failed: expected 6, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "hello", s"Exercise 4 failed: expected hello, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == (), s"Exercise 5 failed: expected (), got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == Left(5), s"Exercise 7 failed: expected Left(5), got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Left("boom!"), s"Exercise 8 failed: expected Left(boom!), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio003_MapFlatMap exercises passed!")
  }
}
