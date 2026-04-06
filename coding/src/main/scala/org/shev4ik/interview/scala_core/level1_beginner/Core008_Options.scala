package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Option Type=
 *
 * ==Theory: Option as a Collection of 0 or 1 Elements==
 *
 * `Option[A]` is a sealed abstract class with exactly two subtypes:
 *  - `Some[A](value: A)` -- contains exactly one value.
 *  - `None` -- represents the absence of a value (the empty case).
 *
 * You can think of Option as a collection that holds either zero or one element.
 * This is why Option supports collection operations like `map`, `flatMap`, `filter`,
 * `fold`, `foreach`, `exists`, `forall`, `toList`, etc.
 *
 * {{{
 * Some(42).toList   // List(42)
 * None.toList       // List()
 * }}}
 *
 * ==Theory: Why .get is Dangerous==
 *
 * Calling `.get` on an Option defeats its purpose. `None.get` throws a
 * `NoSuchElementException` at runtime -- exactly the kind of failure Option is designed
 * to prevent. Idiomatic Scala NEVER uses `.get` on Option. Instead, use:
 *  - `getOrElse(default)` -- provide a fallback value.
 *  - `map` / `flatMap` -- transform the value if present.
 *  - `fold(ifEmpty)(ifPresent)` -- handle both cases in one call.
 *  - `match` / `case Some(x) => ... case None => ...` -- pattern matching.
 *  - `orElse(alternativeOption)` -- chain Options.
 *
 * ==Theory: Option vs null==
 *
 * In Java, `null` can be returned from any method that returns a reference type, leading
 * to `NullPointerException` at unexpected places. Option makes the absence of a value
 * '''explicit in the type system''':
 *
 * {{{
 * // Java style (dangerous -- caller might forget to check for null):
 * def findUser(id: Int): User = if (...) user else null
 *
 * // Scala style (the type signature tells you the value might be absent):
 * def findUser(id: Int): Option[User] = if (...) Some(user) else None
 * }}}
 *
 * To interoperate with Java code that returns null:
 * {{{
 * val opt: Option[String] = Option(javaMethodThatMayReturnNull())
 * // Option(null) == None; Option("value") == Some("value")
 * }}}
 *
 * ==Theory: Option in For-Comprehensions==
 *
 * Because Option has `map`, `flatMap`, and `withFilter`, it works seamlessly in
 * for-comprehensions:
 * {{{
 * val result: Option[Int] = for {
 *   a <- Some(10)
 *   b <- Some(20)
 *   if a + b > 25
 * } yield a + b
 * // result == Some(30)
 * }}}
 * If any step yields None, the entire for-comprehension short-circuits to None.
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "How would you convert Java code using null checks to idiomatic Scala?"'''
 *    Answer: Wrap nullable values in `Option(...)` at the boundary (Option(null) == None).
 *    Replace null checks with `map`/`flatMap`/`getOrElse`/pattern matching. Chain multiple
 *    optional values using for-comprehensions. Never pass or return `null` in Scala code.
 *
 *  - '''Follow-up: "Why is Option better than null?"'''
 *    Answer: Option encodes the possibility of absence in the type system, so the compiler
 *    forces you to handle both cases. With null, the type system gives no warning and
 *    NullPointerExceptions surface at runtime. Option also composes: you can `map`, `flatMap`,
 *    and chain Options, while null checks lead to deeply nested if-else pyramids.
 *
 *  - '''Follow-up: "When would you use Option vs Either vs Try?"'''
 *    Answer: Use `Option` when you only care whether a value is present or absent.
 *    Use `Either[Error, Value]` when you want to carry an error message or error type.
 *    Use `Try[Value]` when you need to capture exceptions from code that might throw.
 *
 * ==Approach Hints==
 *
 *  - `getOrElse` and `fold` are the two most common ways to extract an Option's value safely.
 *  - `orElse` is for chaining: "try this Option, and if it's None, try that one."
 *  - `filter` turns `Some(x)` into `None` if the predicate fails.
 *  - `contains` is a concise way to check if an Option holds a specific value.
 */
object Core008_Options {

  // Exercise 1: Some and None
  // TODO: Create an Option containing 42 (Some(42)) and an empty Option[Int] (None).
  //       Return (someValue, noneValue).
  def exercise1_someNone: (Option[Int], Option[Int]) = ???

  // Exercise 2: getOrElse
  // TODO: Given an Option[String], return its value or "default" if None.
  def exercise2_getOrElse(opt: Option[String]): String = ???

  // Exercise 3: map and flatMap on Option
  // TODO: Given Option(5), use map to double it => Some(10).
  //       Given Option("hello"), use flatMap to return Some(length) if non-empty, None otherwise.
  //       Use: opt.flatMap(s => if (s.nonEmpty) Some(s.length) else None)
  //       Return (doubled, length).
  def exercise3_mapFlatMap: (Option[Int], Option[Int]) = ???

  // Exercise 4: filter
  // TODO: Given Option(42), filter with _ > 40 (should return Some(42)).
  //       Given Option(42), filter with _ > 50 (should return None).
  //       Return (filtered1, filtered2).
  def exercise4_filter: (Option[Int], Option[Int]) = ???

  // Exercise 5: fold
  // TODO: Use fold to handle Option: provide a default value and a transformation function.
  //       Option(10).fold(0)(_ * 2) should return 20.
  //       None.asInstanceOf[Option[Int]].fold(0)(_ * 2) should return 0.
  //       Return (someResult, noneResult).
  def exercise5_fold: (Int, Int) = ???

  // Exercise 6: orElse
  // TODO: Chain Options using orElse.
  //       Given primary = None and fallback = Some("fallback"), return primary.orElse(fallback).
  //       Given primary = Some("primary") and fallback = Some("fallback"), return primary.orElse(fallback).
  //       Return (firstResult, secondResult).
  def exercise6_orElse: (Option[String], Option[String]) = ???

  // Exercise 7: contains
  // TODO: Check if Option(42) contains 42 (true) and if Option(42) contains 0 (false).
  //       Also check if (None: Option[Int]).contains(42) (false).
  //       Return (contains42, contains0, noneContains).
  def exercise7_contains: (Boolean, Boolean, Boolean) = ???

  // Exercise 8: Pattern matching Option
  // TODO: Given an Option[Int], pattern match to return:
  //       Some(x) if x > 0 => s"Positive: $x"
  //       Some(x) => s"Non-positive: $x"
  //       None => "Empty"
  def exercise8_patternMatch(opt: Option[Int]): String = ???

  def main(args: Array[String]): Unit = {
    val (some, none) = exercise1_someNone
    assert(some == Some(42), "Exercise 1 failed: some")
    assert(none == None, "Exercise 1 failed: none")

    assert(exercise2_getOrElse(Some("hello")) == "hello", "Exercise 2 failed: some")
    assert(exercise2_getOrElse(None) == "default", "Exercise 2 failed: none")

    val (doubled, length) = exercise3_mapFlatMap
    assert(doubled == Some(10), "Exercise 3 failed: doubled")
    assert(length == Some(5), "Exercise 3 failed: length")

    val (f1, f2) = exercise4_filter
    assert(f1 == Some(42), "Exercise 4 failed: f1")
    assert(f2 == None, "Exercise 4 failed: f2")

    assert(exercise5_fold == (20, 0), "Exercise 5 failed")

    val (orElse1, orElse2) = exercise6_orElse
    assert(orElse1 == Some("fallback"), "Exercise 6 failed: fallback")
    assert(orElse2 == Some("primary"), "Exercise 6 failed: primary")

    assert(exercise7_contains == (true, false, false), "Exercise 7 failed")

    assert(exercise8_patternMatch(Some(5)) == "Positive: 5", "Exercise 8 failed: positive")
    assert(exercise8_patternMatch(Some(-3)) == "Non-positive: -3", "Exercise 8 failed: non-positive")
    assert(exercise8_patternMatch(None) == "Empty", "Exercise 8 failed: none")

    println("All Core008_Options exercises passed!")
  }
}
