package org.shev4ik.interview.zio.level3_advanced

import zio.test._
import zio.test.Assertion._
import zio.test.environment._

/**
 * ZIO071 - ZIO Test Framework Basics
 *
 * Learn how to write tests using ZIO Test (ZIO 1.x DefaultRunnableSpec).
 */
object Zio071_ZIOTest extends DefaultRunnableSpec {

  // ============================================================
  // Exercise 1: Basic test spec
  // TODO: Create a simple test that checks 1 + 1 == 2 using assertTrue
  // ============================================================
  val exercise1 = test("simple addition") {
    assert(2)(equalTo(2))
  }

  // ============================================================
  // Exercise 2: assert with Assertion combinators
  // TODO: Write a test using assert that checks a string "Hello ZIO" contains "ZIO"
  //       Use assert(...)(containsString(...))
  // ============================================================
  val exercise2 = test("string contains") {
    ???
  }

  // ============================================================
  // Exercise 3: assertM for effectful assertions
  // TODO: Write a test using assertM that checks ZIO.succeed(42) equals 42
  //       Use assertM(...)(equalTo(...))
  // ============================================================
  val exercise3 = testM("effectful assertion") {
    ???
  }

  // ============================================================
  // Exercise 4: testM with effects
  // TODO: Write a testM that creates a Ref with value 0, updates it to 10,
  //       then asserts the value is 10
  // ============================================================
  val exercise4 = testM("ref update") {
    ???
  }

  // ============================================================
  // Exercise 5: suite grouping
  // TODO: Create a suite called "math suite" containing two tests:
  //       - "addition" that checks 2 + 3 == 5
  //       - "multiplication" that checks 3 * 4 == 12
  // ============================================================
  val exercise5 = suite("math suite")(
    ???
  )

  // ============================================================
  // Exercise 6: nested suites (spec)
  // TODO: Create a nested spec with an outer suite "outer" containing
  //       an inner suite "inner" containing a test "nested test"
  //       that asserts true
  // ============================================================
  val exercise6 = suite("outer")(
    ???
  )

  // ============================================================
  // Exercise 7: test labels and descriptions
  // TODO: Create a suite "labeled tests" with tests that have descriptive names:
  //       - "should return empty list for empty input"
  //       - "should handle null gracefully"
  //       Both tests should assert on List.empty being empty (isEmpty)
  // ============================================================
  val exercise7 = suite("labeled tests")(
    ???
  )

  // ============================================================
  // Exercise 8: combining multiple assertions
  // TODO: Write a testM that checks multiple properties of ZIO.succeed(List(1,2,3)):
  //       - hasSize(equalTo(3))
  //       - contains(2)
  //       Combine them with && operator
  // ============================================================
  val exercise8 = testM("multiple assertions") {
    ???
  }

  override def spec = suite("Zio071_ZIOTest")(
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
