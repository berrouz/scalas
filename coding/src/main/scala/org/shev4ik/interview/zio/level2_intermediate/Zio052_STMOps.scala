package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stm._

/**
 * ZIO 052 - STM Operations: retry, check, orTry, and more.
 *
 * STM.retry: retries the transaction when a condition is not met
 * STM.check: retries if the boolean is false
 * orTry: try one transaction, fall back to another
 */
object Zio052_STMOps {

  // Exercise 1: Use STM.retry — a transaction that always retries
  // TODO: Create a TRef, set it from another fiber, use retry until value changes
  // Hint: STM.check(condition) is sugar for if (condition) STM.unit else STM.retry
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use STM.check to conditionally retry
  // TODO: for { ref <- TRef.make(0); _ <- STM.check(ref.get.map(_ > 0)) ... }
  // Fork a fiber that sets the ref to > 0 after a delay
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use orTry to try one STM, fall back to another
  // TODO: STM.retry.orTry(TRef.make(42).flatMap(_.get)).commit => 42
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use fold on STM to handle success and failure
  // TODO: STM.fail("error").fold(_ => "recovered", identity).commit => "recovered"
  val exercise4: UIO[String] = ???

  // Exercise 5: Use STM.collectAll to run multiple STM transactions
  // TODO: STM.collectAll(List(STM.succeed(1), STM.succeed(2), STM.succeed(3))).commit
  val exercise5: UIO[List[Int]] = ???

  // Exercise 6: Use STM.foreach to iterate over a collection in STM
  // TODO: STM.foreach(List(1, 2, 3))(n => STM.succeed(n * 10)).commit
  val exercise6: UIO[List[Int]] = ???

  // Exercise 7: Use STM.succeed to lift a pure value into STM
  // TODO: STM.succeed("hello").commit => "hello"
  val exercise7: UIO[String] = ???

  // Exercise 8: Use STM.fail to create a failing transaction
  // TODO: STM.fail("boom").either.commit => Left("boom")
  val exercise8: UIO[Either[String, Nothing]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 > 0, s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 > 0, s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "recovered", s"Exercise 4 failed: expected recovered, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == List(1, 2, 3), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == List(10, 20, 30), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "hello", s"Exercise 7 failed: expected hello, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Left("boom"), s"Exercise 8 failed: expected Left(boom), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio052_STMOps exercises passed!")
  }
}
