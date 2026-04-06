package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 023 - Queue: concurrent, back-pressured queue.
 *
 * Queue[A] is a lightweight, asynchronous queue.
 * offer adds elements, take removes them.
 */
object Zio023_Queue {

  // Exercise 1: Create a bounded queue, offer an element, and take it
  // TODO: for { q <- Queue.bounded[Int](10); _ <- q.offer(42); v <- q.take } yield v
  val exercise1: UIO[Int] = ???

  // Exercise 2: Offer multiple elements and take them all
  // TODO: for { q <- Queue.bounded[Int](10); _ <- q.offerAll(List(1,2,3)); all <- q.takeAll } yield all
  val exercise2: UIO[List[Int]] = ???

  // Exercise 3: Use poll to take without blocking (returns Option)
  // TODO: for { q <- Queue.bounded[Int](10); empty <- q.poll; _ <- q.offer(1); full <- q.poll } yield (empty, full)
  val exercise3: UIO[(Option[Int], Option[Int])] = ???

  // Exercise 4: Use takeAll to drain the queue
  // TODO: for { q <- Queue.bounded[Int](10); _ <- q.offerAll(List(1,2,3)); all <- q.takeAll } yield all
  val exercise4: UIO[List[Int]] = ???

  // Exercise 5: Use size to check the queue length
  // TODO: for { q <- Queue.bounded[Int](10); _ <- q.offerAll(List(1,2,3)); s <- q.size } yield s
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use shutdown to close the queue
  // TODO: for { q <- Queue.bounded[Int](10); _ <- q.shutdown; r <- q.offer(1).either } yield r.isLeft
  val exercise6: UIO[Boolean] = ???

  // Exercise 7: Use awaitShutdown to wait for queue shutdown
  // TODO: for {
  //   q <- Queue.bounded[Int](10)
  //   fiber <- q.awaitShutdown.as("shutdown complete").fork
  //   _ <- q.shutdown
  //   result <- fiber.join
  // } yield result
  val exercise7: UIO[String] = ???

  // Exercise 8: Use Queue as a producer-consumer pattern
  // TODO: for {
  //   q <- Queue.bounded[Int](10)
  //   producer <- ZIO.foreach_(1 to 5)(n => q.offer(n)).fork
  //   results <- ZIO.foreach(1 to 5)(_ => q.take)
  //   _ <- producer.join
  // } yield results.toList
  val exercise8: UIO[List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == List(1, 2, 3), s"Exercise 2 failed: expected List(1,2,3), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == (None, Some(1)), s"Exercise 3 failed: expected (None, Some(1)), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == List(1, 2, 3), s"Exercise 4 failed: expected List(1,2,3), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 3, s"Exercise 5 failed: expected 3, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6, "Exercise 6 failed: offer after shutdown should fail")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "shutdown complete", s"Exercise 7 failed: expected 'shutdown complete', got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == List(1, 2, 3, 4, 5), s"Exercise 8 failed: expected List(1,2,3,4,5), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio023_Queue exercises passed!")
  }
}
