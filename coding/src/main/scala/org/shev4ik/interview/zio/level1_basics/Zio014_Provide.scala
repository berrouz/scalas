package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 014 - Provide and ZLayer: building and composing dependency layers.
 *
 * ZLayer[RIn, E, ROut] describes how to build ROut from RIn.
 * provide / provideLayer supply dependencies to effects.
 */
object Zio014_Provide {

  // Exercise 1: Use provide to supply a simple environment
  // TODO: ZIO.environment[Int].provide(42)
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use ZLayer.succeed to create a layer from a value
  // TODO: ZLayer.succeed(42) creates a ZLayer[Any, Nothing, Has[Int]]
  // Then use provideLayer to supply it
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use ZLayer.fromFunction to create a layer from a function
  // TODO: ZLayer.fromFunction[Has[Int], String](env => env.get.toString)
  // This creates ZLayer[Has[Int], Nothing, Has[String]]
  val exercise3: ZLayer[Has[Int], Nothing, Has[String]] = ???

  // Exercise 4: Use ZLayer.fromEffect to create a layer from an effect
  // TODO: ZLayer.fromEffect(ZIO.succeed(42))
  val exercise4: ZLayer[Any, Nothing, Has[Int]] = ???

  // Exercise 5: Compose layers vertically with >>>
  // TODO: intLayer >>> stringLayer where intLayer provides Int, stringLayer converts Int to String
  val exercise5: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 6: Compose layers horizontally with ++
  // TODO: ZLayer.succeed(42) ++ ZLayer.succeed("hello")
  // Creates ZLayer[Any, Nothing, Has[Int] with Has[String]]
  val exercise6: ZLayer[Any, Nothing, Has[Int] with Has[String]] = ???

  // Exercise 7: Use provideLayer to supply a composed layer
  // TODO: Access both Int and String from environment, provide with composed layer
  val exercise7: UIO[String] = ???

  // Exercise 8: Use provideSomeLayer to partially provide environment
  // TODO: Create an effect that needs Has[Int] with Has[String].
  // Use provideSomeLayer to provide only Has[String], leaving Has[Int] required.
  // Then provide Has[Int] separately.
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 42, s"Exercise 2 failed: expected 42, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3Result = runtime.unsafeRun(ZIO.service[String].provideLayer(ZLayer.succeed(10) >>> exercise3))
    assert(r3Result == "10", s"Exercise 3 failed: expected '10', got $r3Result")
    println(s"Exercise 3 passed: $r3Result")

    val r4Result = runtime.unsafeRun(ZIO.service[Int].provideLayer(exercise4))
    assert(r4Result == 42, s"Exercise 4 failed: expected 42, got $r4Result")
    println(s"Exercise 4 passed: $r4Result")

    val r5Result = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise5))
    assert(r5Result.nonEmpty, s"Exercise 5 failed: expected non-empty string")
    println(s"Exercise 5 passed: $r5Result")

    val r6Result = runtime.unsafeRun(
      (for {
        n <- ZIO.service[Int]
        s <- ZIO.service[String]
      } yield s"$s:$n").provideLayer(exercise6)
    )
    assert(r6Result == "hello:42", s"Exercise 6 failed: expected 'hello:42', got $r6Result")
    println(s"Exercise 6 passed: $r6Result")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.nonEmpty, s"Exercise 7 failed: expected non-empty string")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed: expected non-empty string")
    println(s"Exercise 8 passed: $r8")

    println("All Zio014_Provide exercises passed!")
  }
}
