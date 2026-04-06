package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 008 - Runtime: executing ZIO effects, unsafeRun variants, custom runtimes.
 *
 * Runtime[R] provides the capability to run ZIO[R, E, A] effects.
 * Runtime.default provides the standard environment (Clock, Console, System, Random).
 */
object Zio008_Runtime {

  // Exercise 1: Use Runtime.default.unsafeRun to execute a simple effect
  // TODO: val result = Runtime.default.unsafeRun(ZIO.succeed(42))
  def exercise1: Int = ???

  // Exercise 2: Use unsafeRunSync to get an Exit value
  // TODO: Runtime.default.unsafeRunSync(ZIO.succeed(42)) returns Exit[Nothing, Int]
  // Extract the value from Exit.Success
  def exercise2: Exit[Nothing, Int] = ???

  // Exercise 3: Use unsafeRunSync on a failing effect
  // TODO: Runtime.default.unsafeRunSync(ZIO.fail("boom")) returns Exit[String, Nothing]
  // Should be Exit.Failure(Cause.Fail("boom"))
  def exercise3: Exit[String, Nothing] = ???

  // Exercise 4: Use unsafeRunAsync to run an effect with a callback
  // TODO: Create a promise-like mechanism using a var + unsafeRunAsync
  // Runtime.default.unsafeRunAsync(ZIO.succeed(42))(exit => ...)
  // For simplicity, just run it and return the value
  def exercise4: Int = ???

  // Exercise 5: Access the platform from Runtime.default
  // TODO: Runtime.default.platform — returns the Platform
  // Check that the platform is not null
  def exercise5: Boolean = ???

  // Exercise 6: Create a custom Runtime with a specific environment
  // TODO: Runtime(42, Runtime.default.platform) — creates Runtime[Int]
  // Then use it to run ZIO.environment[Int]
  def exercise6: Int = ???

  // Exercise 7: Use unsafeRunSync to capture an exit code from a successful effect
  // TODO: Runtime.default.unsafeRunSync(ZIO.succeed("ok"))
  // Check that it's a success exit
  def exercise7: Boolean = ???

  // Exercise 8: Use Runtime.default.platform to inspect default executor settings
  // TODO: Access Runtime.default.platform and check it exists
  // Return the string representation of the platform (just verify it's non-empty)
  def exercise8: Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2
    assert(r2 == Exit.succeed(42), s"Exercise 2 failed: expected Exit.Success(42), got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = exercise3
    assert(r3.succeeded == false, s"Exercise 3 failed: expected failure")
    println(s"Exercise 3 passed: failure detected")

    // Exercise 4
    val r4 = exercise4
    assert(r4 == 42, s"Exercise 4 failed: expected 42, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = exercise5
    assert(r5, "Exercise 5 failed: platform should not be null")
    println(s"Exercise 5 passed: platform exists")

    // Exercise 6
    val r6 = exercise6
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7
    assert(r7, "Exercise 7 failed: expected success exit")
    println(s"Exercise 7 passed: success exit")

    // Exercise 8
    val r8 = exercise8
    assert(r8, "Exercise 8 failed: platform string should be non-empty")
    println(s"Exercise 8 passed: platform info available")

    println("All Zio008_Runtime exercises passed!")
  }
}
