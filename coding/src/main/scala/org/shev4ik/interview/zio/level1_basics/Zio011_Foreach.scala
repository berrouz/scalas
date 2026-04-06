package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 011 - Foreach: iterating over collections with effects.
 *
 * ZIO.foreach runs an effectful function over each element sequentially.
 * ZIO.foreachPar runs in parallel.
 * ZIO.foreachParN limits parallelism.
 */
object Zio011_Foreach {

  // Exercise 1: Use ZIO.foreach to transform a list with an effectful function
  // TODO: ZIO.foreach(List(1, 2, 3))(n => ZIO.succeed(n * 2)) => List(2, 4, 6)
  val exercise1: UIO[List[Int]] = ???

  // Exercise 2: Use ZIO.foreach_ to execute effects for side effects only
  // TODO: Create a Ref[Int], then ZIO.foreach_(List(1,2,3))(n => ref.update(_ + n))
  // Return the final ref value (should be 6)
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use ZIO.foreachPar to run effects in parallel
  // TODO: ZIO.foreachPar(List(1, 2, 3))(n => ZIO.succeed(n * 10))
  // Results should contain 10, 20, 30 (order preserved)
  val exercise3: UIO[List[Int]] = ???

  // Exercise 4: Use ZIO.foreachPar_ to run parallel side effects
  // TODO: Create a Ref[Int], then foreachPar_(List(1,2,3))(n => ref.update(_ + n))
  // Return the final ref value (should be 6)
  val exercise4: UIO[Int] = ???

  // Exercise 5: Use ZIO.foreachParN to limit parallelism
  // TODO: ZIO.foreachParN(2)(List(1, 2, 3, 4))(n => ZIO.succeed(n * 5))
  // Results should be List(5, 10, 15, 20)
  val exercise5: UIO[List[Int]] = ???

  // Exercise 6: Use ZIO.collectAll to combine a list of effects
  // TODO: ZIO.collectAll(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))
  val exercise6: UIO[List[Int]] = ???

  // Exercise 7: Use ZIO.collectAllPar to combine effects in parallel
  // TODO: ZIO.collectAllPar(List(ZIO.succeed("a"), ZIO.succeed("b"), ZIO.succeed("c")))
  val exercise7: UIO[List[String]] = ???

  // Exercise 8: Use ZIO.partition to separate successes and failures
  // TODO: ZIO.partition(List(1, 2, 3, 4))(n =>
  //   if (n % 2 == 0) ZIO.succeed(n) else ZIO.fail(s"odd: $n"))
  // Returns (failures, successes)
  val exercise8: UIO[(Iterable[String], Iterable[Int])] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == List(2, 4, 6), s"Exercise 1 failed: expected List(2,4,6), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 6, s"Exercise 2 failed: expected 6, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == List(10, 20, 30), s"Exercise 3 failed: expected List(10,20,30), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 6, s"Exercise 4 failed: expected 6, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == List(5, 10, 15, 20), s"Exercise 5 failed: expected List(5,10,15,20), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == List(1, 2, 3), s"Exercise 6 failed: expected List(1,2,3), got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == List("a", "b", "c"), s"Exercise 7 failed: expected List(a,b,c), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8._1.toList == List("odd: 1", "odd: 3"), s"Exercise 8 failures failed: got ${r8._1}")
    assert(r8._2.toList == List(2, 4), s"Exercise 8 successes failed: got ${r8._2}")
    println(s"Exercise 8 passed: failures=${r8._1.toList}, successes=${r8._2.toList}")

    println("All Zio011_Foreach exercises passed!")
  }
}
