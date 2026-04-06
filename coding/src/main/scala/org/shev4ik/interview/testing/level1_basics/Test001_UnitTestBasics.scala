package org.shev4ik.interview.testing.level1_basics

/**
 * Test001 - Unit Testing Basics in Scala
 *
 * =Overview=
 * Testing is a critical skill for Scala engineers. The Scala ecosystem offers a rich set
 * of testing frameworks, each with distinct philosophies. This exercise covers the
 * fundamentals: assertions, test runners, lifecycle management, and retry strategies.
 *
 * =Testing Philosophy: The Test Pyramid=
 * {{{
 *        /  E2E  \        <- Few: slow, brittle, but test real user flows
 *       /----------\
 *      / Integration \    <- Some: test component boundaries (DB, HTTP, queues)
 *     /----------------\
 *    /   Unit Tests      \  <- Many: fast, isolated, test individual functions
 *   /____________________\
 * }}}
 *  - '''Unit tests''': Test a single function or class in isolation. Dependencies are
 *    mocked or stubbed. Should be fast (<100ms) and deterministic.
 *  - '''Integration tests''': Test interactions between components (e.g., service + database,
 *    service + HTTP client). Often use testcontainers to spin up real Postgres/Kafka/Redis.
 *  - '''End-to-end tests''': Test full user workflows through the entire system.
 *
 * =Scala Testing Frameworks=
 *  - '''ScalaTest''': Most popular, supports multiple styles (FunSuite, FlatSpec, WordSpec,
 *    FreeSpec). Rich matcher DSL (`should`, `must`). Good IDE integration.
 *  - '''MUnit''': Lightweight, Scala-idiomatic. From the Scala Center. No magic -- tests
 *    are plain methods. Excellent for Typelevel/Cats Effect projects.
 *  - '''Specs2''': Acceptance-style testing with "should/in" syntax. Supports data tables.
 *  - '''ScalaCheck''': '''Property-based testing''' -- generates random inputs and verifies
 *    properties hold for all of them. Essential for testing invariants.
 *    Example: `forAll { (xs: List[Int]) => xs.sorted.size == xs.size }` generates hundreds
 *    of random lists and verifies sorting preserves length.
 *  - '''Weaver-test''': Cats Effect native test framework with parallel test execution
 *    and shared resources.
 *
 * =Testing in Cats Effect / ZIO=
 *  - For Cats Effect: Use `munit-cats-effect` or `weaver-test` to test `IO` values directly
 *  - For ZIO: Use `zio-test` which provides `assertTrue`, `Gen` for generators, and
 *    `TestEnvironment` for mocking clocks/consoles/random
 *
 * =Property-Based Testing (PBT)=
 * Instead of manually writing test cases, PBT generates inputs from combinators:
 *  - Finds edge cases humans miss (empty lists, negative numbers, Unicode strings)
 *  - When a failure is found, the framework '''shrinks''' the input to the minimal
 *    failing case -- extremely useful for debugging
 *  - Libraries: ScalaCheck, zio-test Gen, Hedgehog
 *
 * =Real-World Testing Tips=
 *  - Use '''testcontainers-scala''' for integration tests with real databases/message brokers
 *  - Use '''WireMock''' or '''http4s test client''' for mocking external HTTP services
 *  - For flaky tests: investigate root cause before adding retries (timing issues,
 *    shared mutable state, port conflicts)
 *  - Prefer '''deterministic tests''' -- avoid Thread.sleep, use test clocks instead
 *
 * =Interview Tip=
 * ''"What testing frameworks do you prefer in Scala and why?"''
 *
 * '''Good answer:''' "For unit tests, I use ScalaTest (FunSuite style) or MUnit for its
 * simplicity. For integration tests, testcontainers-scala gives me real Postgres/Kafka
 * instances in Docker. For property-based testing, ScalaCheck helps me verify invariants
 * across generated inputs -- for example, testing that serialization roundtrips are
 * lossless: `forAll { (a: MyType) => decode(encode(a)) == a }`. In Cats Effect projects,
 * I prefer munit-cats-effect or weaver-test for native IO support."
 *
 * Fundamentals of unit testing: test structure, assertions,
 * setup/teardown concepts, and building a minimal test framework.
 */
object Test001_UnitTestBasics {

  // ==========================================================================
  // Exercise 1: Implement a simple assertion function
  // ==========================================================================
  // TODO: Implement `assertEquals` that compares two values of the same type.
  //       If they are equal, return true.
  //       If they are not equal, throw an AssertionError with a message like:
  //       "Expected [expected] but got [actual]"
  def assertEquals[A](expected: A, actual: A): Boolean = ???

  // ==========================================================================
  // Exercise 2: Implement an assertion for exceptions
  // ==========================================================================
  // TODO: Implement `assertThrows` that takes a block of code and a class tag.
  //       It should return true if the block throws an exception of the expected type.
  //       If no exception is thrown, throw an AssertionError("Expected exception not thrown").
  //       If a different exception type is thrown, rethrow it.
  import scala.reflect.ClassTag
  def assertThrows[E <: Throwable : ClassTag](block: => Any): Boolean = ???

  // ==========================================================================
  // Exercise 3: Implement a test case runner
  // ==========================================================================
  // TODO: Implement `runTest` that takes a test name (String) and a test body (=> Unit).
  //       It should execute the body and return a TestResult.
  //       If the body completes normally, return TestResult(name, passed = true, None).
  //       If the body throws, return TestResult(name, passed = false, Some(exception)).
  case class TestResult(name: String, passed: Boolean, error: Option[Throwable])

  def runTest(name: String)(body: => Unit): TestResult = ???

  // ==========================================================================
  // Exercise 4: Implement a test suite runner
  // ==========================================================================
  // TODO: Implement `runSuite` that takes a suite name and a list of (testName, testBody) pairs.
  //       Run each test using `runTest` and return a SuiteResult containing:
  //       - the suite name
  //       - the list of TestResults
  //       - total count, passed count, failed count
  case class SuiteResult(
    name: String,
    results: List[TestResult],
    total: Int,
    passed: Int,
    failed: Int
  )

  def runSuite(name: String)(tests: List[(String, () => Unit)]): SuiteResult = ???

  // ==========================================================================
  // Exercise 5: Implement setup/teardown lifecycle
  // ==========================================================================
  // TODO: Implement `withSetupTeardown` that takes:
  //       - setup: () => A  (creates a resource/context)
  //       - teardown: A => Unit  (cleans up the resource)
  //       - test: A => Unit  (the test body that uses the resource)
  //       It should: run setup, pass result to test, always run teardown (even if test fails),
  //       and return a TestResult. Use "lifecycle-test" as the test name.
  def withSetupTeardown[A](setup: () => A)(teardown: A => Unit)(test: A => Unit): TestResult = ???

  // ==========================================================================
  // Exercise 6: Implement a soft assertion collector
  // ==========================================================================
  // TODO: Implement `softAssertAll` that takes a list of assertion functions (() => Unit).
  //       Unlike hard assertions, it runs ALL of them even if some fail.
  //       Return a tuple: (passedCount: Int, failures: List[String])
  //       where failures contains the exception messages of failed assertions.
  def softAssertAll(assertions: List[() => Unit]): (Int, List[String]) = ???

  // ==========================================================================
  // Exercise 7: Implement a timeout-aware test runner
  // ==========================================================================
  // TODO: Implement `runWithTimeout` that takes a test name, a timeout in milliseconds,
  //       and a test body. It should run the body in a separate thread.
  //       If the body completes within the timeout, return the TestResult normally.
  //       If it exceeds the timeout, return TestResult(name, false, Some(new TimeoutException(...))).
  import java.util.concurrent.TimeoutException
  def runWithTimeout(name: String, timeoutMs: Long)(body: => Unit): TestResult = ???

  // ==========================================================================
  // Exercise 8: Implement a test retry mechanism
  // ==========================================================================
  // TODO: Implement `runWithRetry` that takes a test name, max retries (Int),
  //       and a test body. It should run the test up to maxRetries times.
  //       Return a RetryResult containing:
  //       - the final TestResult (passed if ANY attempt passed)
  //       - the number of attempts made
  //       Stop retrying as soon as the test passes.
  case class RetryResult(result: TestResult, attempts: Int)

  def runWithRetry(name: String, maxRetries: Int)(body: => Unit): RetryResult = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(assertEquals(42, 42))
    assert(assertEquals("hello", "hello"))
    var threw = false
    try { assertEquals(1, 2) } catch { case _: AssertionError => threw = true }
    assert(threw, "assertEquals should throw on mismatch")
    println("Exercise 1 passed: assertEquals works correctly")

    // Exercise 2
    assert(assertThrows[ArithmeticException] { 1 / 0 })
    assert(assertThrows[NullPointerException] { (null: String).length })
    var threwOnNoException = false
    try { assertThrows[RuntimeException] { "no exception" } }
    catch { case _: AssertionError => threwOnNoException = true }
    assert(threwOnNoException)
    println("Exercise 2 passed: assertThrows works correctly")

    // Exercise 3
    val passed = runTest("good test") { assert(1 + 1 == 2) }
    assert(passed.passed && passed.error.isEmpty)
    val failed = runTest("bad test") { throw new RuntimeException("boom") }
    assert(!failed.passed && failed.error.isDefined)
    println("Exercise 3 passed: runTest works correctly")

    // Exercise 4
    val suite = runSuite("math suite")(List(
      ("add", () => assert(1 + 1 == 2)),
      ("sub", () => assert(2 - 1 == 1)),
      ("fail", () => assert(1 == 2))
    ))
    assert(suite.total == 3 && suite.passed == 2 && suite.failed == 1)
    println("Exercise 4 passed: runSuite works correctly")

    // Exercise 5
    var teardownCalled = false
    val lifecycleResult = withSetupTeardown(() => new StringBuilder("setup"))(sb => { teardownCalled = true }) { sb =>
      assert(sb.toString() == "setup")
    }
    assert(lifecycleResult.passed && teardownCalled)
    println("Exercise 5 passed: withSetupTeardown works correctly")

    // Exercise 6
    val (passCount, failures) = softAssertAll(List(
      () => assert(true),
      () => throw new AssertionError("fail1"),
      () => assert(true),
      () => throw new AssertionError("fail2")
    ))
    assert(passCount == 2 && failures.size == 2)
    println("Exercise 6 passed: softAssertAll works correctly")

    // Exercise 7
    val quickResult = runWithTimeout("quick", 1000) { Thread.sleep(10) }
    assert(quickResult.passed)
    val slowResult = runWithTimeout("slow", 50) { Thread.sleep(5000) }
    assert(!slowResult.passed && slowResult.error.exists(_.isInstanceOf[TimeoutException]))
    println("Exercise 7 passed: runWithTimeout works correctly")

    // Exercise 8
    var attemptCount = 0
    val retryResult = runWithRetry("flaky", 3) {
      attemptCount += 1
      if (attemptCount < 3) throw new RuntimeException("not yet")
    }
    assert(retryResult.result.passed && retryResult.attempts == 3)
    println("Exercise 8 passed: runWithRetry works correctly")

    println("\nAll Test001 exercises passed!")
  }
}
