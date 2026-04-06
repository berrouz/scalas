package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.clock.Clock
import zio.duration._
import zio.test._
import zio.test.Assertion._
import zio.test.environment._

/**
 * ZIO075 - Custom Test Environment
 *
 * Learn how to use TestClock, TestConsole, TestRandom, and custom test environments.
 */
object Zio075_CustomTestEnv extends DefaultRunnableSpec {

  // ============================================================
  // Exercise 1: Custom test environment
  // TODO: Create a custom service trait Counter with increment and get.
  //       Implement it with a Ref. Provide it as a test layer and write
  //       a test that increments 3 times and checks the count is 3.
  // ============================================================
  val exercise1 = testM("custom test env") {
    ???
  }

  // ============================================================
  // Exercise 2: TestClock - adjust time
  // TODO: Write a testM that creates a fiber sleeping for 10.seconds,
  //       then use TestClock.adjust(10.seconds) to advance time,
  //       then join the fiber and assert it completes.
  // ============================================================
  val exercise2 = testM("test clock adjust") {
    ???
  }

  // ============================================================
  // Exercise 3: TestConsole - feed input
  // TODO: Use TestConsole.feedLines("Alice") to feed input,
  //       then use zio.console.getStrLn to read it,
  //       and assert the result is "Alice".
  // ============================================================
  val exercise3 = testM("test console feed") {
    ???
  }

  // ============================================================
  // Exercise 4: TestRandom - set seed
  // TODO: Use TestRandom.setSeed(42L) to set a deterministic seed,
  //       then generate a random int with zio.random.nextInt,
  //       and assert the result is a specific expected value.
  //       (Run once to discover the value, then hardcode it.)
  // ============================================================
  val exercise4 = testM("test random setSeed") {
    ???
  }

  // ============================================================
  // Exercise 5: Combining test environments
  // TODO: Write a testM that uses both TestClock and TestConsole:
  //       - Feed a line "start" via TestConsole
  //       - Read the line
  //       - Fork a fiber that sleeps 5.seconds then writes "done" to console
  //       - Adjust TestClock by 5.seconds
  //       - Join the fiber
  //       - Read output from TestConsole and assert it contains "done"
  // ============================================================
  val exercise5 = testM("combining test envs") {
    ???
  }

  // ============================================================
  // Exercise 6: Test environment composition
  // TODO: Create a custom service Logger that logs to a Ref[List[String]].
  //       Compose it with the default test environment.
  //       Write a test that logs messages and verifies the log content.
  // ============================================================
  val exercise6 = testM("test env composition") {
    ???
  }

  // ============================================================
  // Exercise 7: Custom assertion
  // TODO: Create a custom Assertion called `isEven` that checks if an Int is even.
  //       Use Assertion.assertion("isEven")()(n => n % 2 == 0).
  //       Write a test using this custom assertion.
  // ============================================================
  val exercise7 = test("custom assertion") {
    ???
  }

  // ============================================================
  // Exercise 8: Test annotation
  // TODO: Write a suite with TestAspect.annotate to add custom
  //       annotations/tags to tests. Create a tagged suite with
  //       "integration" annotation.
  // ============================================================
  val exercise8 = suite("test annotation")(
    ???
  )

  override def spec = suite("Zio075_CustomTestEnv")(
    exercise1,
    exercise2,
    exercise3,
    exercise4,
    exercise5,
    exercise6,
    exercise7,
    exercise8
  )
}
