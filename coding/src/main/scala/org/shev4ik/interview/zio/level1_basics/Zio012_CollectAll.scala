package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 012 - CollectAll, mergeAll, reduceAll, validate: combining multiple effects.
 *
 * collectAll gathers results from a collection of effects.
 * mergeAll combines results with a binary function.
 * validate collects all errors instead of short-circuiting.
 */
object Zio012_CollectAll {

  // Exercise 1: Use ZIO.collectAll to collect results from a list of effects
  // TODO: ZIO.collectAll(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))
  val exercise1: UIO[List[Int]] = ???

  // Exercise 2: Use ZIO.collectAllPar to collect results in parallel
  // TODO: ZIO.collectAllPar(List(ZIO.succeed("x"), ZIO.succeed("y")))
  val exercise2: UIO[List[String]] = ???

  // Exercise 3: Use ZIO.collectAllParN to limit parallelism
  // TODO: ZIO.collectAllParN(2)(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))
  val exercise3: UIO[List[Int]] = ???

  // Exercise 4: Use ZIO.mergeAll to combine results with a binary function
  // TODO: ZIO.mergeAll(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))(0)(_ + _)
  // Start with 0, sum all results => 6
  val exercise4: UIO[Int] = ???

  // Exercise 5: Use ZIO.reduceAll to reduce without an initial value
  // TODO: ZIO.reduceAll(ZIO.succeed(1), List(ZIO.succeed(2), ZIO.succeed(3)))(_ + _) => 6
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use ZIO.collectAllSuccesses to collect only successes, ignoring failures
  // TODO: ZIO.collectAllSuccesses(List(ZIO.succeed(1), ZIO.fail("err"), ZIO.succeed(3)))
  // Should return List(1, 3)
  val exercise6: UIO[List[Int]] = ???

  // Exercise 7: Use ZIO.validate to collect ALL errors (not short-circuit)
  // TODO: ZIO.validate(List(1, 2, 3, 4))(n =>
  //   if (n % 2 == 0) ZIO.succeed(n) else ZIO.fail(s"odd:$n"))
  // On failure, collects all errors. Use .either to inspect.
  // Left should contain a chunk/list of errors for odd numbers
  val exercise7: UIO[Either[::[String], List[Int]]] = ???

  // Exercise 8: Use ZIO.validatePar to validate in parallel
  // TODO: ZIO.validatePar(List(2, 4, 6))(n => ZIO.succeed(n / 2))
  // All succeed => Right(List(1, 2, 3))
  val exercise8: IO[::[Throwable], List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == List(1, 2, 3), s"Exercise 1 failed: expected List(1,2,3), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == List("x", "y"), s"Exercise 2 failed: expected List(x,y), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == List(1, 2, 3), s"Exercise 3 failed: expected List(1,2,3), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 6, s"Exercise 4 failed: expected 6, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 6, s"Exercise 5 failed: expected 6, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == List(1, 3), s"Exercise 6 failed: expected List(1,3), got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.isLeft, s"Exercise 7 failed: expected Left with errors, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == List(1, 2, 3), s"Exercise 8 failed: expected List(1,2,3), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio012_CollectAll exercises passed!")
  }
}
