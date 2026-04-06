package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.test._
import zio.test.Assertion._
import zio.test.environment._
import zio.random.Random

/**
 * ZIO073 - Property-Based Testing
 *
 * Learn how to use Gen and check/checkM for property-based testing in ZIO Test.
 */
object Zio073_PropertyTest extends DefaultRunnableSpec {

  // ============================================================
  // Exercise 1: Gen basics
  // TODO: Use Gen.anyInt to generate integers and check that
  //       for any int n, n + 0 == n (identity property of addition)
  // ============================================================
  val exercise1 = testM("Gen basics - addition identity") {
    ???
  }

  // ============================================================
  // Exercise 2: Gen.int with bounds
  // TODO: Use Gen.int(1, 100) to generate bounded integers.
  //       Check that all generated values are between 1 and 100 inclusive.
  // ============================================================
  val exercise2 = testM("Gen.int bounded") {
    ???
  }

  // ============================================================
  // Exercise 3: Gen.string
  // TODO: Use Gen.anyString to generate strings.
  //       Check that for any string s, s.reverse.reverse == s
  // ============================================================
  val exercise3 = testM("Gen.string reverse property") {
    ???
  }

  // ============================================================
  // Exercise 4: check with multiple generators
  // TODO: Use check with Gen.anyInt and Gen.anyInt to verify
  //       commutativity of addition: a + b == b + a
  // ============================================================
  val exercise4 = testM("commutativity of addition") {
    ???
  }

  // ============================================================
  // Exercise 5: checkM for effectful properties
  // TODO: Use checkM with Gen.int(1, 1000) to verify that
  //       Ref.make(n).flatMap(_.get) returns n for any n
  // ============================================================
  val exercise5 = testM("checkM with Ref") {
    ???
  }

  // ============================================================
  // Exercise 6: sample - generate a single value
  // TODO: Use Gen.int(1, 10).sample to generate a single sample value.
  //       Map over the sample stream, take one element and assert it's between 1 and 10.
  // ============================================================
  val exercise6 = testM("sample single value") {
    ???
  }

  // ============================================================
  // Exercise 7: Gen.listOf
  // TODO: Use Gen.listOf(Gen.int(0, 100)) to generate lists of ints.
  //       Check that sorting a list twice gives the same result as sorting once:
  //       list.sorted.sorted == list.sorted
  // ============================================================
  val exercise7 = testM("Gen.listOf sort idempotent") {
    ???
  }

  // ============================================================
  // Exercise 8: Gen.oneOf
  // TODO: Use Gen.oneOf(Gen.const("red"), Gen.const("green"), Gen.const("blue"))
  //       to generate color strings. Check that the generated value is one of
  //       the three colors.
  // ============================================================
  val exercise8 = testM("Gen.oneOf colors") {
    ???
  }

  override def spec = suite("Zio073_PropertyTest")(
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
