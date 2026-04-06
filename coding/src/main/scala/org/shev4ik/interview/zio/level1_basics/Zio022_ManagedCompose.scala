package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 022 - ZManaged composition: flatMap, zip, foreach, collectAll.
 *
 * ZManaged supports the same composition patterns as ZIO.
 * Finalizers run in reverse order of acquisition.
 */
object Zio022_ManagedCompose {

  // Exercise 1: Use flatMap to compose two managed resources
  // TODO: ZManaged.succeed(1).flatMap(a => ZManaged.succeed(a + 1)).use(n => ZIO.succeed(n))
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use zip to combine two managed resources into a tuple
  // TODO: ZManaged.succeed(1).zip(ZManaged.succeed("a")).use(t => ZIO.succeed(t))
  val exercise2: UIO[(Int, String)] = ???

  // Exercise 3: Use zipWith to combine with a function
  // TODO: ZManaged.succeed(10).zipWith(ZManaged.succeed(20))(_ + _).use(n => ZIO.succeed(n))
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use ZManaged.foreach to manage a collection of resources
  // TODO: ZManaged.foreach(List(1, 2, 3))(n => ZManaged.succeed(n * 10))
  //   .use(list => ZIO.succeed(list))
  val exercise4: UIO[List[Int]] = ???

  // Exercise 5: Use ZManaged.collectAll to collect managed resources
  // TODO: ZManaged.collectAll(List(ZManaged.succeed(1), ZManaged.succeed(2)))
  //   .use(list => ZIO.succeed(list))
  val exercise5: UIO[List[Int]] = ???

  // Exercise 6: Verify finalizers run in reverse order
  // TODO: Create a Ref[List[String]].
  // val m1 = ZManaged.make(ZIO.unit)(_ => ref.update("first" :: _).unit)
  // val m2 = ZManaged.make(ZIO.unit)(_ => ref.update("second" :: _).unit)
  // (m1 *> m2).use(_ => ZIO.unit)
  // After use, ref should be List("first", "second") — reversed acquisition order
  val exercise6: UIO[List[String]] = ???

  // Exercise 7: Use for-comprehension with ZManaged
  // TODO: (for {
  //   a <- ZManaged.succeed(10)
  //   b <- ZManaged.succeed(20)
  //   c <- ZManaged.succeed(30)
  // } yield a + b + c).use(n => ZIO.succeed(n))
  val exercise7: UIO[Int] = ???

  // Exercise 8: Use mapN on ZManaged to combine multiple managed values
  // TODO: ZManaged.mapN(ZManaged.succeed(1), ZManaged.succeed(2), ZManaged.succeed(3))(_ + _ + _)
  //   .use(n => ZIO.succeed(n))
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 2, s"Exercise 1 failed: expected 2, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == (1, "a"), s"Exercise 2 failed: expected (1,a), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 30, s"Exercise 3 failed: expected 30, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == List(10, 20, 30), s"Exercise 4 failed: expected List(10,20,30), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == List(1, 2), s"Exercise 5 failed: expected List(1,2), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.contains("first") && r6.contains("second"), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 60, s"Exercise 7 failed: expected 60, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 6, s"Exercise 8 failed: expected 6, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio022_ManagedCompose exercises passed!")
  }
}
