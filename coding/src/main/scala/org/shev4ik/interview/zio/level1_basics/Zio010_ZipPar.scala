package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 010 - Zipping effects: zip, zipRight (*>), zipLeft (<*), zipWith, parallel variants.
 *
 * zip combines two effects into a tuple.
 * zipRight (*>) sequences effects, keeping only the right result.
 * zipLeft (<*) sequences effects, keeping only the left result.
 */
object Zio010_ZipPar {

  // Exercise 1: Use zip to combine two effects into a tuple
  // TODO: ZIO.succeed(1).zip(ZIO.succeed("a")) => (1, "a")
  val exercise1: UIO[(Int, String)] = ???

  // Exercise 2: Use zipRight (*>) to sequence, keeping right result
  // TODO: ZIO.succeed(1) *> ZIO.succeed("hello") => "hello"
  val exercise2: UIO[String] = ???

  // Exercise 3: Use zipLeft (<*) to sequence, keeping left result
  // TODO: ZIO.succeed(42) <* ZIO.succeed("ignored") => 42
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use zipWith to combine with a function
  // TODO: ZIO.succeed(10).zipWith(ZIO.succeed(20))(_ + _) => 30
  val exercise4: UIO[Int] = ???

  // Exercise 5: Use zipPar to run two effects in parallel and combine results
  // TODO: ZIO.succeed(1).zipPar(ZIO.succeed(2)) => (1, 2)
  val exercise5: UIO[(Int, Int)] = ???

  // Exercise 6: Use zipWithPar to combine parallel results with a function
  // TODO: ZIO.succeed("hello").zipWithPar(ZIO.succeed(" world"))(_ + _) => "hello world"
  val exercise6: UIO[String] = ???

  // Exercise 7: Use tupled to combine a tuple of effects (via ZIO.tupled)
  // TODO: ZIO.tupled(ZIO.succeed(1), ZIO.succeed("a"), ZIO.succeed(true))
  val exercise7: UIO[(Int, String, Boolean)] = ???

  // Exercise 8: Use mapN to combine multiple effects with a function
  // TODO: ZIO.mapN(ZIO.succeed(1), ZIO.succeed(2), ZIO.succeed(3))(_ + _ + _) => 6
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == (1, "a"), s"Exercise 1 failed: expected (1,a), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "hello", s"Exercise 2 failed: expected hello, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 30, s"Exercise 4 failed: expected 30, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == (1, 2), s"Exercise 5 failed: expected (1,2), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == "hello world", s"Exercise 6 failed: expected 'hello world', got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == (1, "a", true), s"Exercise 7 failed: expected (1,a,true), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 6, s"Exercise 8 failed: expected 6, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio010_ZipPar exercises passed!")
  }
}
