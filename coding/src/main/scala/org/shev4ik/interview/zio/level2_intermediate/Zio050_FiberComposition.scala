package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 050 - Fiber Composition: combining and transforming fibers.
 *
 * Fiber[E, A] can be composed with zip, zipWith, orElse, map, flatMap.
 * Use join, await, and collectAll for gathering results.
 */
object Zio050_FiberComposition {

  // Exercise 1: Zip two fibers to get a tuple of results
  // TODO: fiber1.zip(fiber2) => (result1, result2)
  val exercise1: UIO[(Int, String)] = ???

  // Exercise 2: Use zipWith to combine fiber results with a function
  // TODO: fiber1.zipWith(fiber2)(_ + _) => combined result
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use orElse on fibers — if first fails, use second
  // TODO: failingFiber.orElse(succeedingFiber) => result of second
  val exercise3: UIO[String] = ???

  // Exercise 4: Map over a fiber's result
  // TODO: fiber.map(_ * 2) transforms the fiber's eventual result
  val exercise4: UIO[Int] = ???

  // Exercise 5: FlatMap fibers to chain dependent computations
  // TODO: fiber1.flatMap(v => Fiber.succeed(v + 10))
  val exercise5: UIO[Int] = ???

  // Exercise 6: Join a fiber to get its result
  // TODO: Fork an effect, then join the fiber to wait for the result
  val exercise6: UIO[Int] = ???

  // Exercise 7: Await a fiber to get its Exit value
  // TODO: fiber.await returns Exit[E, A] which can be Success or Failure
  val exercise7: UIO[Exit[Nothing, Int]] = ???

  // Exercise 8: Use Fiber.collectAll to gather results from multiple fibers
  // TODO: Fork multiple effects, collect all fibers, join them all
  val exercise8: UIO[List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1._1 > 0 && r1._2.nonEmpty, s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 > 0, s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 > 0, s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 > 0, s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 > 0, s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.succeeded, s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.length >= 3, s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio050_FiberComposition exercises passed!")
  }
}
