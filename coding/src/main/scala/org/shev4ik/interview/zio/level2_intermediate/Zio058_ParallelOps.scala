package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 058 - Parallel Operations: running effects concurrently.
 *
 * foreachPar, collectAllPar, foreachParN, mergeAllPar, reduceAllPar,
 * validatePar, partitionPar, raceAll.
 */
object Zio058_ParallelOps {

  // Exercise 1: Use foreachPar to run effects in parallel
  // TODO: ZIO.foreachPar(List(1, 2, 3))(n => ZIO.succeed(n * 10)) => List(10, 20, 30)
  val exercise1: UIO[List[Int]] = ???

  // Exercise 2: Use collectAllPar to run a list of effects in parallel
  // TODO: ZIO.collectAllPar(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))
  val exercise2: UIO[List[Int]] = ???

  // Exercise 3: Use foreachParN to limit parallelism
  // TODO: ZIO.foreachParN(2)(List(1, 2, 3, 4))(n => ZIO.succeed(n * 5))
  val exercise3: UIO[List[Int]] = ???

  // Exercise 4: Use mergeAllPar to combine parallel results
  // TODO: ZIO.mergeAllPar(List(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3)))(0)(_ + _) => 6
  val exercise4: UIO[Int] = ???

  // Exercise 5: Use reduceAllPar to reduce parallel results
  // TODO: ZIO.reduceAllPar(ZIO.succeed(1), List(ZIO.succeed(2), ZIO.succeed(3)))(_ + _) => 6
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use validatePar to accumulate errors in parallel
  // TODO: ZIO.validatePar(List(1, 2, 3))(n => if (n > 1) ZIO.fail(s"$n>1") else ZIO.succeed(n))
  val exercise6: UIO[Either[::[String], List[Int]]] = ???

  // Exercise 7: Use partitionPar to separate successes and failures
  // TODO: ZIO.partitionPar(List(1, 2, 3))(n => if (n % 2 == 0) ZIO.fail(s"even:$n") else ZIO.succeed(n))
  val exercise7: UIO[(Iterable[String], Iterable[Int])] = ???

  // Exercise 8: Use raceAll to race multiple effects
  // TODO: ZIO.raceAll(ZIO.succeed(1), List(ZIO.succeed(2), ZIO.succeed(3)))
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1.sorted == List(10, 20, 30), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.sorted == List(1, 2, 3), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.sorted == List(5, 10, 15, 20), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 6, s"Exercise 4 failed: expected 6, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 6, s"Exercise 5 failed: expected 6, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    println(s"Exercise 7 passed: failures=${r7._1}, successes=${r7._2}")

    val r8 = runtime.unsafeRun(exercise8)
    assert(Set(1, 2, 3).contains(r8), s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio058_ParallelOps exercises passed!")
  }
}
