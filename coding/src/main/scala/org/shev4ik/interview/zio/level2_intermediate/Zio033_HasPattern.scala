package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 033 - Has[A] pattern: the building block for ZIO 1.x environment.
 *
 * Has[A] is a heterogeneous map keyed by service type.
 * It enables type-safe dependency injection in ZIO 1.x.
 * Has values can be combined with ++ and accessed with get.
 */
object Zio033_HasPattern {

  trait Logging {
    def log(msg: String): UIO[Unit]
  }

  trait Database {
    def query(sql: String): Task[String]
  }

  // Exercise 1: Create a Has[String] containing "hello"
  // TODO: Use Has("hello") to create a Has value wrapping a String
  val exercise1: Has[String] = ???

  // Exercise 2: Create a Has[Int] containing 42
  // TODO: Use Has(42) to wrap an Int in Has
  val exercise2: Has[Int] = ???

  // Exercise 3: Combine Has[String] and Has[Int] using ++
  // TODO: Combine two Has values into Has[String] with Has[Int]
  val exercise3: Has[String] with Has[Int] = ???

  // Exercise 4: Access the String from a combined Has[String] with Has[Int]
  // TODO: Use .get[String] on the combined Has to extract the String value
  val exercise4: String = ???

  // Exercise 5: Access the Int from a combined Has[String] with Has[Int]
  // TODO: Use .get[Int] on the combined Has to extract the Int value
  val exercise5: Int = ???

  // Exercise 6: Create a ZLayer that provides a Has[String]
  // TODO: Use ZLayer.succeed("world") to create a layer that produces Has[String]
  val exercise6: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 7: Create a ZIO that accesses a String from the environment
  // TODO: Use ZIO.service[String] or ZIO.access[Has[String]](_.get) to read from environment
  val exercise7: ZIO[Has[String], Nothing, String] = ???

  // Exercise 8: Create a Has with a custom service trait and access it
  // TODO: Create Has[Logging] with a Logging implementation that prints to console
  // Then extract it with .get[Logging]
  val exercise8: Has[Logging] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = exercise1.get[String]
    assert(r1 == "hello", s"Exercise 1 failed: expected hello, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2.get[Int]
    assert(r2 == 42, s"Exercise 2 failed: expected 42, got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3s = exercise3.get[String]
    val r3i = exercise3.get[Int]
    assert(r3s.nonEmpty && r3i > 0, s"Exercise 3 failed: got $r3s, $r3i")
    println(s"Exercise 3 passed: String=$r3s, Int=$r3i")

    // Exercise 4
    assert(exercise4.nonEmpty, s"Exercise 4 failed: got $exercise4")
    println(s"Exercise 4 passed: $exercise4")

    // Exercise 5
    assert(exercise5 > 0, s"Exercise 5 failed: got $exercise5")
    println(s"Exercise 5 passed: $exercise5")

    // Exercise 6
    val r6 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise6))
    assert(r6 == "world", s"Exercise 6 failed: expected world, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7.provideLayer(ZLayer.succeed("test")))
    assert(r7 == "test", s"Exercise 7 failed: expected test, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = exercise8.get[Logging]
    assert(r8 != null, "Exercise 8 failed: Logging service is null")
    println(s"Exercise 8 passed: got Logging service")

    println("All Zio033_HasPattern exercises passed!")
  }
}
