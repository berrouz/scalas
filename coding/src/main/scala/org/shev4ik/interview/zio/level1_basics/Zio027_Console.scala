package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.console._

/**
 * ZIO 027 - Console service: reading and writing to the console.
 *
 * In ZIO 1.x, use zio.console.putStrLn, getStrLn, etc.
 * Console is part of the default ZEnv environment.
 */
object Zio027_Console {

  // Exercise 1: Use putStr to print without a newline
  // TODO: console.putStr("hello") *> ZIO.succeed("printed")
  def exercise1: URIO[Console, String] = ???

  // Exercise 2: Use putStrLn to print with a newline
  // TODO: console.putStrLn("hello world") *> ZIO.succeed("printed")
  def exercise2: URIO[Console, String] = ???

  // Exercise 3: Use putStrLn with string interpolation
  // TODO: val name = "ZIO"
  // console.putStrLn(s"Hello, $name!") *> ZIO.succeed(s"Hello, $name!")
  def exercise3: URIO[Console, String] = ???

  // Exercise 4: Print multiple lines sequentially
  // TODO: for {
  //   _ <- console.putStrLn("line 1")
  //   _ <- console.putStrLn("line 2")
  //   _ <- console.putStrLn("line 3")
  // } yield 3
  def exercise4: URIO[Console, Int] = ???

  // Exercise 5: Access the Console service directly
  // TODO: ZIO.access[Console](_.get) — returns Console.Service
  // Just verify it's not null
  def exercise5: URIO[Console, Boolean] = ???

  // Exercise 6: Use putStrLn to print to stderr (putStrLnErr)
  // TODO: console.putStrLnErr("error message") *> ZIO.succeed("logged to stderr")
  // Note: In ZIO 1.x this might be console.putStrLnErr or similar
  def exercise6: URIO[Console, String] = ???

  // Exercise 7: Combine console output with computations
  // TODO: for {
  //   a <- ZIO.succeed(21)
  //   b <- ZIO.succeed(21)
  //   sum = a + b
  //   _ <- console.putStrLn(s"$a + $b = $sum")
  // } yield sum
  def exercise7: URIO[Console, Int] = ???

  // Exercise 8: Print a collection of items
  // TODO: ZIO.foreach_(List("a", "b", "c"))(item => console.putStrLn(item)) *> ZIO.succeed("done")
  def exercise8: URIO[Console, String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == "printed", s"Exercise 1 failed: expected 'printed', got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "printed", s"Exercise 2 failed: expected 'printed', got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "Hello, ZIO!", s"Exercise 3 failed: expected 'Hello, ZIO!', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 3, s"Exercise 4 failed: expected 3, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5, "Exercise 5 failed: Console service should be available")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == "logged to stderr", s"Exercise 6 failed: expected 'logged to stderr', got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 42, s"Exercise 7 failed: expected 42, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == "done", s"Exercise 8 failed: expected 'done', got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio027_Console exercises passed!")
  }
}
