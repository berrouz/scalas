package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 047 - FiberRef: fiber-local mutable references.
 *
 * FiberRef[A] is like Ref but scoped to a fiber. Child fibers inherit
 * the parent's value. Changes in a child do not affect the parent.
 */
object Zio047_FiberRef {

  // Exercise 1: Create a FiberRef and get its value
  // TODO: FiberRef.make(42).flatMap(_.get) => 42
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a FiberRef, set a new value, and get it
  // TODO: for { ref <- FiberRef.make(0); _ <- ref.set(99); v <- ref.get } yield v => 99
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use update to modify the FiberRef value
  // TODO: for { ref <- FiberRef.make(10); _ <- ref.update(_ + 5); v <- ref.get } yield v => 15
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use modify to atomically read and update
  // TODO: ref.modify(old => ("was:" + old, old * 2)) returns "was:X" and sets ref to X*2
  val exercise4: UIO[(String, Int)] = ???

  // Exercise 5: Use locally to temporarily change the value for a scoped computation
  // TODO: for { ref <- FiberRef.make("global")
  //             inner <- ref.locally("local")(ref.get)
  //             outer <- ref.get } yield (inner, outer)
  // => ("local", "global")
  val exercise5: UIO[(String, String)] = ???

  // Exercise 6: Demonstrate that child fibers inherit FiberRef values
  // TODO: Set FiberRef to "parent", fork a child that reads it => child sees "parent"
  val exercise6: UIO[String] = ???

  // Exercise 7: Demonstrate that child FiberRef changes don't affect parent
  // TODO: FiberRef("parent"), fork child that sets to "child", join, parent reads => "parent"
  val exercise7: UIO[(String, String)] = ???

  // Exercise 8: FiberRef with initial value propagation to multiple fibers
  // TODO: Create FiberRef(0), fork 3 fibers that each update(_ + 1) and get,
  // each should see 1 (not accumulated) because FiberRef is fiber-local
  val exercise8: UIO[List[Int]] = ???

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
    assert(r5 == ("local", "global"), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == "parent", s"Exercise 6 failed: expected parent, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7._2 == "parent", s"Exercise 7 failed: parent should still be 'parent', got ${r7._2}")
    println(s"Exercise 7 passed: child=${r7._1}, parent=${r7._2}")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.forall(_ == 1), s"Exercise 8 failed: expected all 1s, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio047_FiberRef exercises passed!")
  }
}
