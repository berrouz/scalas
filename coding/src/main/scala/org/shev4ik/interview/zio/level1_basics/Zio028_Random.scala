package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.random._

/**
 * ZIO 028 - Random service: generating random values.
 *
 * In ZIO 1.x, use zio.random._ functions.
 * Random is part of the default ZEnv environment.
 */
object Zio028_Random {

  // Exercise 1: Generate a random Int
  // TODO: random.nextInt — returns a random Int
  def exercise1: URIO[Random, Int] = ???

  // Exercise 2: Generate a random Int bounded by a max value
  // TODO: random.nextIntBounded(100) — returns random Int in [0, 100)
  def exercise2: URIO[Random, Int] = ???

  // Exercise 3: Generate a random Long
  // TODO: random.nextLong
  def exercise3: URIO[Random, Long] = ???

  // Exercise 4: Generate a random Double in [0.0, 1.0)
  // TODO: random.nextDouble
  def exercise4: URIO[Random, Double] = ???

  // Exercise 5: Generate a random Boolean
  // TODO: random.nextBoolean
  def exercise5: URIO[Random, Boolean] = ???

  // Exercise 6: Generate a random String of given length
  // TODO: random.nextString(10) — returns a random string of length 10
  def exercise6: URIO[Random, String] = ???

  // Exercise 7: Shuffle a list randomly
  // TODO: random.shuffle(List(1, 2, 3, 4, 5))
  def exercise7: URIO[Random, List[Int]] = ???

  // Exercise 8: Use setSeed to make random deterministic
  // TODO: for {
  //   _ <- random.setSeed(42L)
  //   a <- random.nextInt
  //   _ <- random.setSeed(42L)
  //   b <- random.nextInt
  // } yield a == b
  def exercise8: URIO[Random, Boolean] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    println(s"Exercise 1 passed: random int = $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 >= 0 && r2 < 100, s"Exercise 2 failed: expected [0,100), got $r2")
    println(s"Exercise 2 passed: bounded int = $r2")

    val r3 = runtime.unsafeRun(exercise3)
    println(s"Exercise 3 passed: random long = $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 >= 0.0 && r4 < 1.0, s"Exercise 4 failed: expected [0.0,1.0), got $r4")
    println(s"Exercise 4 passed: random double = $r4")

    val r5 = runtime.unsafeRun(exercise5)
    println(s"Exercise 5 passed: random boolean = $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.length == 10, s"Exercise 6 failed: expected length 10, got ${r6.length}")
    println(s"Exercise 6 passed: random string = $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.sorted == List(1, 2, 3, 4, 5), s"Exercise 7 failed: elements changed")
    println(s"Exercise 7 passed: shuffled = $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8, "Exercise 8 failed: same seed should produce same values")
    println(s"Exercise 8 passed: deterministic = $r8")

    println("All Zio028_Random exercises passed!")
  }
}
