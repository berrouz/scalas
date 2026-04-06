package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 024 - Hub: publish-subscribe messaging.
 *
 * Hub[A] allows publishing messages to multiple subscribers.
 * Each subscriber gets its own copy of each message.
 * Note: Hub was added in ZIO 1.0.5.
 */
object Zio024_Hub {

  // Exercise 1: Create a bounded Hub, subscribe, publish, and take
  // TODO: for {
  //   hub <- Hub.bounded[String](10)
  //   result <- hub.subscribe.use(sub => hub.publish("hello") *> sub.take)
  // } yield result
  val exercise1: UIO[String] = ???

  // Exercise 2: Multiple subscribers each receive the message
  // TODO: for {
  //   hub <- Hub.bounded[Int](10)
  //   result <- (hub.subscribe zip hub.subscribe).use { case (s1, s2) =>
  //     hub.publish(42) *> s1.take.zip(s2.take)
  //   }
  // } yield result
  val exercise2: UIO[(Int, Int)] = ???

  // Exercise 3: Use Hub capacity to check the hub's capacity
  // TODO: for { hub <- Hub.bounded[Int](16); c <- ZIO.succeed(hub.capacity) } yield c
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use Hub size to check current number of messages
  // TODO: for {
  //   hub <- Hub.bounded[Int](10)
  //   s <- hub.size
  // } yield s
  val exercise4: UIO[Int] = ???

  // Exercise 5: Publish multiple messages and take them from a subscriber
  // TODO: for {
  //   hub <- Hub.bounded[Int](10)
  //   result <- hub.subscribe.use(sub =>
  //     ZIO.foreach_(List(1,2,3))(hub.publish) *> ZIO.foreach(1 to 3)(_ => sub.take)
  //   )
  // } yield result.toList
  val exercise5: UIO[List[Int]] = ???

  // Exercise 6: Use Hub.shutdown to close the hub
  // TODO: for {
  //   hub <- Hub.bounded[Int](10)
  //   _ <- hub.shutdown
  //   r <- hub.publish(1).either
  // } yield r.isLeft
  val exercise6: UIO[Boolean] = ???

  // Exercise 7: Use Hub.sliding to create a sliding (non-blocking) hub
  // TODO: for {
  //   hub <- Hub.sliding[Int](2)
  //   _ <- hub.publish(1)
  //   _ <- hub.publish(2)
  //   _ <- hub.publish(3)  // slides — oldest message dropped if no subscribers
  // } yield "ok"
  val exercise7: UIO[String] = ???

  // Exercise 8: Use Hub.dropping to create a dropping (non-blocking) hub
  // TODO: for {
  //   hub <- Hub.dropping[Int](2)
  //   _ <- hub.publish(1)
  //   _ <- hub.publish(2)
  //   _ <- hub.publish(3)  // dropped if no subscribers
  // } yield "ok"
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == "hello", s"Exercise 1 failed: expected 'hello', got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == (42, 42), s"Exercise 2 failed: expected (42,42), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 16, s"Exercise 3 failed: expected 16, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 0, s"Exercise 4 failed: expected 0, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == List(1, 2, 3), s"Exercise 5 failed: expected List(1,2,3), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6, "Exercise 6 failed: publish after shutdown should fail")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "ok", s"Exercise 7 failed")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == "ok", s"Exercise 8 failed")
    println(s"Exercise 8 passed: $r8")

    println("All Zio024_Hub exercises passed!")
  }
}
