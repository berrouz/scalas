package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 025 - Semaphore: limiting concurrent access.
 *
 * Semaphore controls how many fibers can access a resource concurrently.
 * withPermit acquires a permit, runs the effect, then releases.
 */
object Zio025_Semaphore {

  // Exercise 1: Create a Semaphore and use withPermit
  // TODO: for { sem <- Semaphore.make(1); r <- sem.withPermit(ZIO.succeed(42)) } yield r
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use withPermits to acquire multiple permits
  // TODO: for { sem <- Semaphore.make(3); r <- sem.withPermits(2)(ZIO.succeed("ok")) } yield r
  val exercise2: UIO[String] = ???

  // Exercise 3: Check available permits
  // TODO: for { sem <- Semaphore.make(5); a <- sem.available } yield a
  val exercise3: UIO[Long] = ???

  // Exercise 4: Check that withPermit reduces available permits during execution
  // TODO: for {
  //   sem <- Semaphore.make(2)
  //   promise <- Promise.make[Nothing, Long]
  //   fiber <- sem.withPermit(sem.available.flatMap(promise.succeed) *> ZIO.unit).fork
  //   during <- promise.await
  //   _ <- fiber.join
  //   after <- sem.available
  // } yield (during, after)
  // during should be 1 (one permit used), after should be 2 (released)
  val exercise4: UIO[(Long, Long)] = ???

  // Exercise 5: Use Semaphore to limit concurrency of parallel operations
  // TODO: for {
  //   sem <- Semaphore.make(2)
  //   ref <- Ref.make(0)
  //   maxRef <- Ref.make(0)
  //   _ <- ZIO.foreachPar_(1 to 10)(_ =>
  //     sem.withPermit(
  //       for {
  //         _ <- ref.update(_ + 1)
  //         current <- ref.get
  //         _ <- maxRef.update(max => if (current > max) current else max)
  //         _ <- ref.update(_ - 1)
  //       } yield ()
  //     )
  //   )
  //   maxConcurrent <- maxRef.get
  // } yield maxConcurrent <= 2
  val exercise5: UIO[Boolean] = ???

  // Exercise 6: Acquire and release permits manually
  // TODO: for {
  //   sem <- Semaphore.make(3)
  //   _ <- sem.acquire
  //   a1 <- sem.available
  //   _ <- sem.release
  //   a2 <- sem.available
  // } yield (a1, a2)
  val exercise6: UIO[(Long, Long)] = ???

  // Exercise 7: Use withPermitManaged to get a managed permit
  // TODO: for {
  //   sem <- Semaphore.make(1)
  //   result <- sem.withPermitManaged.use(_ => ZIO.succeed("managed permit"))
  // } yield result
  val exercise7: UIO[String] = ???

  // Exercise 8: Binary semaphore (mutex) pattern — Semaphore.make(1)
  // TODO: Create a Semaphore(1) as a mutex.
  // Fork 100 fibers each incrementing a Ref inside withPermit.
  // Verify the final count is 100.
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "ok", s"Exercise 2 failed: expected 'ok', got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 5L, s"Exercise 3 failed: expected 5, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4._1 == 1L && r4._2 == 2L, s"Exercise 4 failed: expected (1,2), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5, "Exercise 5 failed: max concurrent should be <= 2")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == (2L, 3L), s"Exercise 6 failed: expected (2,3), got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "managed permit", s"Exercise 7 failed: expected 'managed permit', got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 100, s"Exercise 8 failed: expected 100, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio025_Semaphore exercises passed!")
  }
}
