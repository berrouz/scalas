package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 054 - RefM: effectful mutable references.
 *
 * RefM[A] is like Ref[A] but its update/modify functions can perform effects.
 * This is useful when the update logic itself is effectful.
 * Note: In ZIO 1.x this is RefM, in ZIO 2.x it became Ref.Synchronized.
 */
object Zio054_RefM {

  // Exercise 1: Create a RefM and get its value
  // TODO: RefM.make(42).flatMap(_.get) => 42
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a RefM, set a new value, get it
  // TODO: for { ref <- RefM.make(0); _ <- ref.set(99); v <- ref.get } yield v => 99
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use update with an effectful function
  // TODO: ref.update(n => UIO(n + 10)) — the update function returns a ZIO
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use modify with an effectful function
  // TODO: ref.modify(n => UIO(("was:" + n, n * 2))) — returns (output, newState)
  val exercise4: UIO[(String, Int)] = ???

  // Exercise 5: Use updateAndGet to update and return the new value
  // TODO: ref.updateAndGet(n => UIO(n + 5)) => new value
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use getAndUpdate to get old value then update
  // TODO: ref.getAndUpdate(n => UIO(n * 3)) => old value, ref has new value
  val exercise6: UIO[(Int, Int)] = ???

  // Exercise 7: RefM with effectful validation
  // TODO: Create a RefM that only updates if the new value passes validation
  // Use update with an effect that checks the condition
  val exercise7: UIO[Int] = ???

  // Exercise 8: Use modifySome for conditional modification
  // TODO: ref.modifySome("default") { case n if n > 0 => UIO(("positive:" + n, n - 1)) }
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 99, s"Exercise 2 failed: expected 99, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 > 0, s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4._1.startsWith("was:"), s"Exercise 4 failed: got ${r4._1}")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 > 0, s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    println(s"Exercise 6 passed: old=${r6._1}, new=${r6._2}")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 > 0, s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty string")
    println(s"Exercise 8 passed: $r8")

    println("All Zio054_RefM exercises passed!")
  }
}
