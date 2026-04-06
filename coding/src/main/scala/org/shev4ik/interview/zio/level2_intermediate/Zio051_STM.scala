package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stm._

/**
 * ZIO 051 - STM: Software Transactional Memory basics.
 *
 * STM provides composable, lock-free concurrent data structures.
 * TRef is the transactional equivalent of Ref.
 * Use atomically (commit) to execute STM transactions.
 */
object Zio051_STM {

  // Exercise 1: Create a TRef and read its value inside a transaction
  // TODO: STM.atomically(TRef.make(42).flatMap(_.get)) or
  //       TRef.makeCommit(42).flatMap(ref => ref.get.commit)
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a TRef, set a value, and read it
  // TODO: for { ref <- TRef.make(0); _ <- ref.set(99); v <- ref.get } yield v — then commit
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use TRef.update inside a transaction
  // TODO: for { ref <- TRef.make(10); _ <- ref.update(_ + 5); v <- ref.get } yield v => 15
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use TRef.modify for atomic read-modify-write
  // TODO: ref.modify(old => ("was:" + old, old * 2)) — returns string, sets ref to doubled
  val exercise4: UIO[(String, Int)] = ???

  // Exercise 5: Compose multiple TRef operations in a single transaction
  // TODO: Create two TRefs, transfer value from one to another atomically
  val exercise5: UIO[(Int, Int)] = ???

  // Exercise 6: Use STM.atomically (commit) to run a transaction
  // TODO: val stm: STM[Nothing, Int] = TRef.make(42).flatMap(_.get)
  //       stm.commit => UIO[Int]
  val exercise6: UIO[Int] = ???

  // Exercise 7: Create multiple TRefs and read them all in one transaction
  // TODO: Create TRef(1), TRef(2), TRef(3) and read all three atomically
  val exercise7: UIO[(Int, Int, Int)] = ???

  // Exercise 8: Implement an atomic counter using TRef
  // TODO: Create a TRef(0), atomically increment it 100 times from concurrent fibers
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 99, s"Exercise 2 failed: expected 99, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 15, s"Exercise 3 failed: expected 15, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4._1.startsWith("was:"), s"Exercise 4 failed: got ${r4._1}")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == (1, 2, 3), s"Exercise 7 failed: expected (1,2,3), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 100, s"Exercise 8 failed: expected 100, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio051_STM exercises passed!")
  }
}
