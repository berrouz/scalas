package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 037 - Layer Provide: different ways to provide layers to ZIO effects.
 *
 * provideLayer: fully satisfy environment
 * provideSomeLayer: partially satisfy environment
 * provideCustomLayer: provide a layer while keeping standard ZEnv
 */
object Zio037_LayerProvide {

  val stringLayer: ZLayer[Any, Nothing, Has[String]] = ZLayer.succeed("provided")
  val intLayer: ZLayer[Any, Nothing, Has[Int]] = ZLayer.succeed(42)

  // Exercise 1: Use provideLayer to fully satisfy a ZIO's environment
  // TODO: Create a ZIO[Has[String], Nothing, String] and provide stringLayer
  val exercise1: UIO[String] = ???

  // Exercise 2: Use provideSomeLayer to provide part of the environment
  // TODO: Given ZIO[Has[String] with Has[Int], Nothing, String], provide only intLayer
  // Result should still need Has[String]
  val exercise2: ZIO[Has[String], Nothing, String] = ???

  // Exercise 3: Provide a custom layer alongside ZEnv (console, clock)
  // TODO: Use provideCustomLayer to add Has[String] while keeping console access
  val exercise3: ZIO[zio.console.Console, Nothing, String] = ???

  // Exercise 4: Layer ordering — provide layers in the correct order
  // TODO: Create two dependent layers and compose them with >>> then provide
  val exercise4: UIO[String] = ???

  // Exercise 5: Debug layer construction by adding a tap/log
  // TODO: Create a layer that logs "constructing layer" during creation
  // Use ZLayer.fromEffect(UIO(println("constructing")) *> UIO("debug-value"))
  val exercise5: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 6: Create a layer from config-like values
  // TODO: Create a case class AppConfig(host: String, port: Int) and a layer providing it
  case class AppConfig(host: String, port: Int)
  val exercise6: ZLayer[Any, Nothing, Has[AppConfig]] = ???

  // Exercise 7: Compose multiple layers for a complete application environment
  // TODO: Combine stringLayer ++ intLayer ++ exercise6 into one layer
  val exercise7: ZLayer[Any, Nothing, Has[String] with Has[Int] with Has[AppConfig]] = ???

  // Exercise 8: Use a layer with fallback — orElse on layers
  // TODO: Create a failing layer and use orElse to fall back to a succeeding layer
  val exercise8: ZLayer[Any, Nothing, Has[String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == "provided", s"Exercise 1 failed: expected provided, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.provideLayer(stringLayer))
    assert(r2.nonEmpty, s"Exercise 2 failed: got empty string")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.provideLayer(zio.console.Console.live))
    assert(r3.nonEmpty, s"Exercise 3 failed: got empty string")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.nonEmpty, s"Exercise 4 failed: got empty string")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise5))
    assert(r5 == "debug-value", s"Exercise 5 failed: expected debug-value, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(ZIO.service[AppConfig].provideLayer(exercise6))
    assert(r6.host.nonEmpty, s"Exercise 6 failed: got empty host")
    println(s"Exercise 6 passed: ${r6.host}:${r6.port}")

    val r7 = runtime.unsafeRun(ZIO.service[AppConfig].provideLayer(exercise7))
    assert(r7.host.nonEmpty, s"Exercise 7 failed")
    println(s"Exercise 7 passed: full environment provided")

    val r8 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise8))
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty string")
    println(s"Exercise 8 passed: $r8")

    println("All Zio037_LayerProvide exercises passed!")
  }
}
