package org.shev4ik.interview.scala_core.level1_beginner

object Core021_LazyVal {

  // Exercise 1: Lazy val basics
  // TODO: Create a var counter = 0. Define a lazy val that increments counter and returns "done".
  //       Check that counter is 0 before accessing the lazy val, then access it and check counter is 1.
  //       Return (counterBefore, counterAfter, lazyResult).
  def exercise1_lazyValBasics: (Int, Int, String) = ???

  // Exercise 2: By-name parameters (=> T)
  // TODO: Define a function `logIfTrue(condition: Boolean, message: => String): String`
  //       that only evaluates `message` if condition is true, otherwise returns "skipped".
  //       This demonstrates that by-name params are only evaluated when used.
  def exercise2_byNameParam(condition: Boolean, message: => String): String = ???

  // Exercise 3: Call-by-name vs call-by-value
  // TODO: Demonstrate the difference. Create a var counter = 0.
  //       Define def sideEffect(): Int = { counter += 1; counter }
  //       Call a by-name method that uses its parameter twice — counter should be incremented twice.
  //       Return the counter value after calling byNameTwice.
  def exercise3_callByNameVsValue: Int = {
    var counter = 0
    def sideEffect(): Int = { counter += 1; counter }
    def useByNameTwice(x: => Int): (Int, Int) = (x, x) // each access evaluates x
    useByNameTwice(sideEffect())
    ???
  }

  // Exercise 4: Lazy evaluation benefits
  // TODO: Demonstrate that lazy val avoids unnecessary computation.
  //       Create a lazy val `expensive` that computes (1 to 1000000).sum.
  //       Create a condition = false. If condition is true, use expensive, else return 0.
  //       The expensive computation should never run. Return 0.
  def exercise4_lazyBenefits: Int = ???

  // Exercise 5: Infinite sequences concept
  // TODO: Use LazyList (Scala 2.13) to create a lazy infinite sequence of natural numbers.
  //       LazyList.from(1) creates 1, 2, 3, ...
  //       Take the first 5 and return as a List.
  def exercise5_infiniteSequences: List[Int] = ???

  // Exercise 6: LazyList basics
  // TODO: Create a LazyList of Fibonacci numbers using LazyList.iterate.
  //       LazyList.iterate((0, 1)) { case (a, b) => (b, a + b) }.map(_._1)
  //       Take the first 10 and return as a List.
  def exercise6_lazyListBasics: List[Int] = ???

  // Exercise 7: Lazy val evaluation is once-only
  // TODO: Demonstrate that lazy val is evaluated at most once.
  //       Create a var counter = 0. Define lazy val x = { counter += 1; 42 }.
  //       Access x three times. Return (x, x, x, counter) — counter should be 1.
  def exercise7_onceOnly: (Int, Int, Int, Int) = ???

  // Exercise 8: Thunks (functions with no arguments)
  // TODO: A thunk is () => A, a function that delays computation.
  //       Create a thunk that returns 42: val thunk: () => Int = () => 42
  //       Call it twice and return the sum.
  def exercise8_thunks: Int = ???

  def main(args: Array[String]): Unit = {
    val (before, after, result) = exercise1_lazyValBasics
    assert(before == 0, "Exercise 1 failed: before")
    assert(after == 1, "Exercise 1 failed: after")
    assert(result == "done", "Exercise 1 failed: result")

    assert(exercise2_byNameParam(true, "hello") == "hello", "Exercise 2 failed: true")
    assert(exercise2_byNameParam(false, throw new RuntimeException("should not evaluate")) == "skipped",
      "Exercise 2 failed: false — message should not be evaluated")

    assert(exercise3_callByNameVsValue == 2, "Exercise 3 failed")

    assert(exercise4_lazyBenefits == 0, "Exercise 4 failed")

    assert(exercise5_infiniteSequences == List(1, 2, 3, 4, 5), "Exercise 5 failed")

    assert(exercise6_lazyListBasics == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), "Exercise 6 failed")

    val (v1, v2, v3, cnt) = exercise7_onceOnly
    assert(v1 == 42 && v2 == 42 && v3 == 42, "Exercise 7 failed: values")
    assert(cnt == 1, "Exercise 7 failed: counter")

    assert(exercise8_thunks == 84, "Exercise 8 failed")

    println("All Core021_LazyVal exercises passed!")
  }
}
