package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 034 - ZLayer: constructing layers for dependency injection.
 *
 * ZLayer[RIn, E, ROut] describes how to build ROut from RIn.
 * Key constructors: succeed, fromFunction, fromEffect, fromManaged,
 * identity, requires, fromService, fromServices.
 */
object Zio034_ZLayer {

  trait Logger {
    def log(msg: String): UIO[Unit]
  }

  trait Config {
    val host: String
    val port: Int
  }

  // Exercise 1: Create a ZLayer that succeeds with a String value "hello"
  // TODO: Use ZLayer.succeed("hello")
  val exercise1: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 2: Create a ZLayer from a function Int => String
  // TODO: Use ZLayer.fromFunction[Int, String](i => s"value:$i") — note that ZLayer.fromFunction
  // in ZIO 1.x works with Has types: ZLayer.fromFunction[Has[Int], String](has => ...)
  val exercise2: ZLayer[Has[Int], Nothing, Has[String]] = ???

  // Exercise 3: Create a ZLayer from an effect
  // TODO: Use ZLayer.fromEffect(ZIO.succeed(42)) to create a layer from an effectful computation
  val exercise3: ZLayer[Any, Nothing, Has[Int]] = ???

  // Exercise 4: Create a ZLayer from a ZManaged
  // TODO: Use ZLayer.fromManaged(ZManaged.succeed("managed-value"))
  val exercise4: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 5: Create an identity ZLayer that passes through Has[String]
  // TODO: Use ZLayer.identity[Has[String]] — it requires Has[String] and outputs Has[String]
  val exercise5: ZLayer[Has[String], Nothing, Has[String]] = ???

  // Exercise 6: Create a ZLayer using ZLayer.requires[Has[Int]]
  // TODO: ZLayer.requires[Has[Int]] is the same as ZLayer.identity[Has[Int]]
  val exercise6: ZLayer[Has[Int], Nothing, Has[Int]] = ???

  // Exercise 7: Create a ZLayer using fromService to transform a dependency
  // TODO: Use ZLayer.fromService[Int, String](i => s"transformed:$i")
  val exercise7: ZLayer[Has[Int], Nothing, Has[String]] = ???

  // Exercise 8: Create a ZLayer using fromServices to combine two dependencies
  // TODO: Use ZLayer.fromServices[Int, String, String]((i, s) => s"$s=$i")
  val exercise8: ZLayer[Has[Int] with Has[String], Nothing, Has[String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise1))
    assert(r1 == "hello", s"Exercise 1 failed: expected hello, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(ZIO.service[String].provideLayer(ZLayer.succeed(10) >>> exercise2))
    assert(r2 == "value:10", s"Exercise 2 failed: expected value:10, got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(ZIO.service[Int].provideLayer(exercise3))
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise4))
    assert(r4 == "managed-value", s"Exercise 4 failed: expected managed-value, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(ZIO.service[String].provideLayer(ZLayer.succeed("pass-through") >>> exercise5))
    assert(r5 == "pass-through", s"Exercise 5 failed: expected pass-through, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(ZIO.service[Int].provideLayer(ZLayer.succeed(99) >>> exercise6))
    assert(r6 == 99, s"Exercise 6 failed: expected 99, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(ZIO.service[String].provideLayer(ZLayer.succeed(7) >>> exercise7))
    assert(r7 == "transformed:7", s"Exercise 7 failed: expected transformed:7, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val inputLayer = ZLayer.succeed(5) ++ ZLayer.succeed("count")
    val r8 = runtime.unsafeRun(ZIO.service[String].provideLayer(inputLayer >>> exercise8))
    assert(r8 == "count=5", s"Exercise 8 failed: expected count=5, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio034_ZLayer exercises passed!")
  }
}
