package org.shev4ik.interview.testing.level1_basics

/**
 * Test002 - Assertion Patterns
 *
 * Building various assertion utilities: equality checks, exception testing,
 * collection assertions, custom matchers, and fluent assertion APIs.
 */
object Test002_AssertionPatterns {

  // ==========================================================================
  // Exercise 1: Implement a deep equality assertion for nested structures
  // ==========================================================================
  // TODO: Implement `assertDeepEquals` that compares two values deeply.
  //       For case classes and collections, compare element by element.
  //       On mismatch, return a Left with a descriptive path-based message
  //       like "Mismatch at .field1.field2: expected X but got Y".
  //       On match, return Right(true).
  //       For simplicity, handle: primitives, Strings, Lists, Maps, Options, and Products.
  def assertDeepEquals(expected: Any, actual: Any, path: String = ""): Either[String, Boolean] = ???

  // ==========================================================================
  // Exercise 2: Implement collection-specific assertions
  // ==========================================================================
  // TODO: Implement a CollectionAssertions object with methods:
  //       - assertContainsAll[A](collection: Seq[A], elements: Seq[A]): Boolean
  //         (all elements must be present in collection)
  //       - assertContainsNone[A](collection: Seq[A], elements: Seq[A]): Boolean
  //         (none of elements should be present in collection)
  //       - assertSameElements[A](c1: Seq[A], c2: Seq[A]): Boolean
  //         (same elements regardless of order)
  //       Throw AssertionError with descriptive messages on failure.
  object CollectionAssertions {
    def assertContainsAll[A](collection: Seq[A], elements: Seq[A]): Boolean = ???
    def assertContainsNone[A](collection: Seq[A], elements: Seq[A]): Boolean = ???
    def assertSameElements[A](c1: Seq[A], c2: Seq[A]): Boolean = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a custom matcher DSL
  // ==========================================================================
  // TODO: Implement a Matcher[A] trait with:
  //       - def matches(value: A): Boolean
  //       - def describe: String  (human-readable description of what it matches)
  //       Then implement these factory methods:
  //       - Matcher.equalTo[A](expected: A): Matcher[A]
  //       - Matcher.greaterThan(n: Int): Matcher[Int]
  //       - Matcher.containsString(sub: String): Matcher[String]
  //       - Matcher.and[A](m1: Matcher[A], m2: Matcher[A]): Matcher[A]
  trait Matcher[A] {
    def matches(value: A): Boolean
    def describe: String
  }

  object Matcher {
    def equalTo[A](expected: A): Matcher[A] = ???
    def greaterThan(n: Int): Matcher[Int] = ???
    def containsString(sub: String): Matcher[String] = ???
    def and[A](m1: Matcher[A], m2: Matcher[A]): Matcher[A] = ???
  }

  // ==========================================================================
  // Exercise 4: Implement assertEventually with polling
  // ==========================================================================
  // TODO: Implement `assertEventually` that keeps evaluating a condition
  //       until it returns true or a timeout is reached.
  //       Parameters: condition (=> Boolean), timeoutMs: Long, intervalMs: Long
  //       Return true if condition eventually holds.
  //       Throw AssertionError("Condition not met within [timeout]ms") if it times out.
  def assertEventually(condition: => Boolean, timeoutMs: Long, intervalMs: Long = 50): Boolean = ???

  // ==========================================================================
  // Exercise 5: Implement numeric approximate assertion
  // ==========================================================================
  // TODO: Implement `assertApproxEquals` that checks if two Doubles are
  //       approximately equal within a given tolerance (epsilon).
  //       Return true if |actual - expected| <= epsilon.
  //       Throw AssertionError with message showing both values and epsilon on failure.
  //       Also implement `assertRelativeEquals` that uses relative tolerance:
  //       |actual - expected| / max(|expected|, 1e-10) <= relativeTolerance
  def assertApproxEquals(expected: Double, actual: Double, epsilon: Double): Boolean = ???
  def assertRelativeEquals(expected: Double, actual: Double, relativeTolerance: Double): Boolean = ???

  // ==========================================================================
  // Exercise 6: Implement string-specific assertions
  // ==========================================================================
  // TODO: Implement a StringAssertions object with:
  //       - assertMatchesRegex(s: String, pattern: String): Boolean
  //       - assertStartsWith(s: String, prefix: String): Boolean
  //       - assertContainsIgnoreCase(s: String, substring: String): Boolean
  //       - assertLinesEqual(s1: String, s2: String): Either[String, Boolean]
  //         (compare line by line, returning Left with first differing line info)
  object StringAssertions {
    def assertMatchesRegex(s: String, pattern: String): Boolean = ???
    def assertStartsWith(s: String, prefix: String): Boolean = ???
    def assertContainsIgnoreCase(s: String, substring: String): Boolean = ???
    def assertLinesEqual(s1: String, s2: String): Either[String, Boolean] = ???
  }

  // ==========================================================================
  // Exercise 7: Implement a fluent assertion API
  // ==========================================================================
  // TODO: Implement an `Expect[A]` class that wraps a value and provides
  //       fluent assertions:
  //       - def toBe(expected: A): Boolean
  //       - def toSatisfy(predicate: A => Boolean, desc: String): Boolean
  //       - def toBeOneOf(options: A*): Boolean
  //       Each should throw AssertionError with descriptive message on failure.
  //       Implement the companion `expect[A](value: A): Expect[A]` method.
  class Expect[A](value: A) {
    def toBe(expected: A): Boolean = ???
    def toSatisfy(predicate: A => Boolean, desc: String): Boolean = ???
    def toBeOneOf(options: A*): Boolean = ???
  }

  def expect[A](value: A): Expect[A] = ???

  // ==========================================================================
  // Exercise 8: Implement assertion message formatting
  // ==========================================================================
  // TODO: Implement `formatDiff` that produces a human-readable diff between
  //       two strings (similar to test framework output).
  //       For each line that differs, show:
  //       "Line N: - [expected line]"
  //       "Line N: + [actual line]"
  //       Lines that match should be shown as "Line N:   [line]"
  //       Return the formatted string. Limit output to first 20 lines of diff.
  def formatDiff(expected: String, actual: String): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(assertDeepEquals(List(1, 2, 3), List(1, 2, 3)).isRight)
    assert(assertDeepEquals(Map("a" -> 1), Map("a" -> 2)).isLeft)
    assert(assertDeepEquals(Some(42), Some(42)).isRight)
    println("Exercise 1 passed: assertDeepEquals works correctly")

    // Exercise 2
    assert(CollectionAssertions.assertContainsAll(List(1, 2, 3, 4), List(2, 4)))
    assert(CollectionAssertions.assertContainsNone(List(1, 2, 3), List(4, 5)))
    assert(CollectionAssertions.assertSameElements(List(3, 1, 2), List(1, 2, 3)))
    println("Exercise 2 passed: CollectionAssertions works correctly")

    // Exercise 3
    val m1 = Matcher.greaterThan(5)
    val m2 = Matcher.equalTo(10)
    val combined = Matcher.and(m1, m2)
    assert(combined.matches(10))
    assert(!combined.matches(3))
    assert(Matcher.containsString("ello").matches("hello"))
    println("Exercise 3 passed: Matcher DSL works correctly")

    // Exercise 4
    var counter = 0
    assert(assertEventually({ counter += 1; counter >= 3 }, timeoutMs = 1000, intervalMs = 10))
    println("Exercise 4 passed: assertEventually works correctly")

    // Exercise 5
    assert(assertApproxEquals(3.14, 3.14159, 0.01))
    assert(assertRelativeEquals(100.0, 100.5, 0.01))
    println("Exercise 5 passed: approximate assertions work correctly")

    // Exercise 6
    assert(StringAssertions.assertMatchesRegex("abc123", "^[a-z]+\\d+$"))
    assert(StringAssertions.assertStartsWith("hello world", "hello"))
    assert(StringAssertions.assertContainsIgnoreCase("Hello World", "hello"))
    assert(StringAssertions.assertLinesEqual("a\nb\nc", "a\nb\nc").isRight)
    assert(StringAssertions.assertLinesEqual("a\nb", "a\nc").isLeft)
    println("Exercise 6 passed: StringAssertions works correctly")

    // Exercise 7
    assert(expect(42).toBe(42))
    assert(expect("hello").toSatisfy(_.length == 5, "has length 5"))
    assert(expect(3).toBeOneOf(1, 2, 3, 4))
    println("Exercise 7 passed: Fluent Expect API works correctly")

    // Exercise 8
    val diff = formatDiff("line1\nline2\nline3", "line1\nchanged\nline3")
    assert(diff.contains("+") && diff.contains("-"))
    println("Exercise 8 passed: formatDiff works correctly")

    println("\nAll Test002 exercises passed!")
  }
}
