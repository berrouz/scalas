package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 036 - Service Pattern: the idiomatic ZIO 1.x module pattern.
 *
 * 1. Define a service trait
 * 2. Create accessor methods using ZIO.accessM
 * 3. Provide live and test implementations via ZLayer
 */
object Zio036_ServicePattern {

  // Exercise 1: Define a service trait for a Greeting service
  // TODO: Create a trait Greeting.Service with method greet(name: String): UIO[String]
  trait Greeting {
    def greet(name: String): UIO[String]
  }

  // Exercise 2: Create an accessor method for the Greeting service
  // TODO: def greet(name: String): ZIO[Has[Greeting], Nothing, String] =
  //   ZIO.accessM[Has[Greeting]](_.get.greet(name))
  def greet(name: String): ZIO[Has[Greeting], Nothing, String] = ???

  // Exercise 3: Create a live implementation of Greeting
  // TODO: Implement Greeting that returns s"Hello, $name!"
  val greetingLive: Greeting = ???

  // Exercise 4: Create a ZLayer for the live Greeting
  // TODO: Use ZLayer.succeed(greetingLive)
  val greetingLayer: ZLayer[Any, Nothing, Has[Greeting]] = ???

  // Exercise 5: Create a test implementation of Greeting
  // TODO: Implement Greeting that returns s"Test: $name"
  val greetingTest: Greeting = ???

  // Exercise 6: Create a ZLayer for the test Greeting
  // TODO: Use ZLayer.succeed(greetingTest)
  val greetingTestLayer: ZLayer[Any, Nothing, Has[Greeting]] = ???

  // Exercise 7: Define a service with a dependency on another service
  // TODO: Create a UserGreeting trait with method greetUser(userId: Int): ZIO[Has[Greeting], Nothing, String]
  // that uses the Greeting service internally
  trait UserGreeting {
    def greetUser(userId: Int): UIO[String]
  }

  def greetUser(userId: Int): ZIO[Has[UserGreeting], Nothing, String] = ???

  // Exercise 8: Create a multi-dependency service layer
  // TODO: Create a ZLayer[Has[Greeting] with Has[Int], Nothing, Has[UserGreeting]]
  // The Int represents a "default user id" config value
  val userGreetingLayer: ZLayer[Has[Greeting], Nothing, Has[UserGreeting]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 2 + 4
    val r2 = runtime.unsafeRun(greet("World").provideLayer(greetingLayer))
    assert(r2 == "Hello, World!", s"Exercise 2 failed: expected 'Hello, World!', got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(greetingLive.greet("Alice"))
    assert(r3 == "Hello, Alice!", s"Exercise 3 failed: expected 'Hello, Alice!', got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 5 + 6
    val r5 = runtime.unsafeRun(greet("Bob").provideLayer(greetingTestLayer))
    assert(r5 == "Test: Bob", s"Exercise 5 failed: expected 'Test: Bob', got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 7 + 8
    val fullLayer = greetingLayer >>> userGreetingLayer
    val r7 = runtime.unsafeRun(greetUser(1).provideLayer(fullLayer))
    assert(r7.nonEmpty, s"Exercise 7 failed: got empty result")
    println(s"Exercise 7 passed: $r7")

    println("All Zio036_ServicePattern exercises passed!")
  }
}
