package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.duration._
import zio.test._
import zio.test.Assertion._
import zio.test.environment._
import zio.test.TestAspect._

/**
 * ZIO074 - Test Aspects
 *
 * Learn how to use TestAspect to modify test behavior (timeout, retry, flaky, etc.).
 */
object Zio074_TestAspects extends DefaultRunnableSpec {

  // ============================================================
  // Exercise 1: Timeout aspect
  // TODO: Write a testM that sleeps for 2 seconds and then succeeds.
  //       Apply TestAspect.timeout(1.second) to make it fail due to timeout.
  //       (Use TestClock or real clock as appropriate.)
  // ============================================================
  val exercise1 = testM("timeout aspect") {
    ???
  } @@ timeout(1.second)

  // ============================================================
  // Exercise 2: Retry aspect
  // TODO: Create a Ref[Int] starting at 0. Write a testM that increments
  //       the ref and asserts the ref value is 3. Apply TestAspect.retry(Schedule.recurs(5))
  //       so the test retries until the ref reaches 3.
  // ============================================================
  val exercise2 = testM("retry aspect") {
    ???
  }

  // ============================================================
  // Exercise 3: Flaky aspect
  // TODO: Write a testM that uses zio.random.nextIntBounded(10) and
  //       asserts the result is 7 (unlikely on first try).
  //       Apply TestAspect.flaky to retry until it passes.
  // ============================================================
  val exercise3 = testM("flaky aspect") {
    ???
  } @@ flaky

  // ============================================================
  // Exercise 4: Ignore aspect
  // TODO: Write a test that would fail (assert(1)(equalTo(2))).
  //       Apply TestAspect.ignore so it is skipped.
  // ============================================================
  val exercise4 = test("ignore aspect") {
    ???
  } @@ ignore

  // ============================================================
  // Exercise 5: Sequential aspect
  // TODO: Create a suite with 3 tests that each append to a shared Ref[List[Int]].
  //       Apply TestAspect.sequential to ensure they run in order.
  //       Verify the final list is List(1, 2, 3).
  // ============================================================
  val exercise5 = suite("sequential aspect")(
    ???
  ) @@ sequential

  // ============================================================
  // Exercise 6: Parallel aspect
  // TODO: Create a suite with 3 independent tests.
  //       Apply TestAspect.parallel to run them concurrently.
  // ============================================================
  val exercise6 = suite("parallel aspect")(
    ???
  ) @@ parallel

  // ============================================================
  // Exercise 7: nonFlaky aspect
  // TODO: Write a testM that always succeeds.
  //       Apply TestAspect.nonFlaky(100) to verify it passes 100 times consistently.
  // ============================================================
  val exercise7 = testM("nonFlaky aspect") {
    ???
  } @@ nonFlaky(100)

  // ============================================================
  // Exercise 8: Timed aspect
  // TODO: Write a testM that does some work (e.g., ZIO.succeed(42)).
  //       Apply TestAspect.timed to measure its execution time.
  // ============================================================
  val exercise8 = testM("timed aspect") {
    ???
  } @@ timed

  override def spec = suite("Zio074_TestAspects")(
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
