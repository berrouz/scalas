package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 021 - ZManaged: safe resource acquisition and release.
 *
 * ZManaged[R, E, A] guarantees that the finalizer runs after use.
 * ZManaged.make(acquire)(release) is the core constructor.
 */
object Zio021_Managed {

  // Exercise 1: Create a ZManaged that acquires and releases a resource
  // TODO: Use ZManaged.make(Ref.make(0))(ref => ref.set(-1).unit)
  // Then .use(ref => ref.get) — should return 0 during use
  val exercise1: UIO[Int] = ???

  // Exercise 2: Verify that the finalizer runs after use
  // TODO: Create a Ref[String]("init").
  // ZManaged.make(ZIO.succeed("resource"))(r => ref.set("released").unit)
  //   .use(_ => ref.get) — during use, ref is still "init"
  // After use, check ref is "released"
  val exercise2: UIO[String] = ???

  // Exercise 3: Use ZManaged.succeed to create a managed value without a finalizer
  // TODO: ZManaged.succeed(42).use(n => ZIO.succeed(n))
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use ZManaged.fromEffect to lift an effect into ZManaged
  // TODO: ZManaged.fromEffect(ZIO.succeed(42)).use(n => ZIO.succeed(n * 2))
  val exercise4: UIO[Int] = ???

  // Exercise 5: Use ZManaged.fromAutoCloseable to manage Java AutoCloseable resources
  // TODO: ZManaged.fromAutoCloseable(ZIO.effect(new java.io.ByteArrayInputStream("hello".getBytes)))
  //   .use(stream => ZIO.effect(stream.available()))
  val exercise5: Task[Int] = ???

  // Exercise 6: Use ensuring on a ZManaged to add extra finalization
  // TODO: Create a Ref[List[String]].
  // ZManaged.make(ZIO.unit)(_ => ref.update("release" :: _).unit)
  //   .ensuring(ref.update("ensuring" :: _))
  //   .use(_ => ZIO.unit)
  // After use, ref should contain both "ensuring" and "release"
  val exercise6: UIO[List[String]] = ???

  // Exercise 7: Use ZManaged.finalizer to create a managed value that only has a finalizer
  // TODO: Create a Ref[Boolean](false).
  // (ZManaged.finalizer(ref.set(true)) *> ZManaged.succeed(42)).use(n => ZIO.succeed(n))
  // After use, ref should be true
  val exercise7: UIO[(Int, Boolean)] = ???

  // Exercise 8: Use useNow (or use_) to execute a managed without using its value
  // TODO: Create a Ref[Boolean](false).
  // ZManaged.make(ref.set(true))(_ => ZIO.unit).useNow
  // After, ref should be true
  val exercise8: UIO[Boolean] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 0, s"Exercise 1 failed: expected 0, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "released", s"Exercise 2 failed: expected 'released', got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 84, s"Exercise 4 failed: expected 84, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 5, s"Exercise 5 failed: expected 5, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.contains("release") && r6.contains("ensuring"), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7._1 == 42 && r7._2, s"Exercise 7 failed: expected (42,true), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8, "Exercise 8 failed: expected true")
    println(s"Exercise 8 passed: $r8")

    println("All Zio021_Managed exercises passed!")
  }
}
