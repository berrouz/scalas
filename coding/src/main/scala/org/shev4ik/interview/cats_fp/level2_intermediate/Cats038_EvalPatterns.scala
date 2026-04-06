package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 038 - Eval Patterns
 *
 * Advanced patterns with Eval: stack-safe recursion, foldRight,
 * lazy computation, trampolining, and memoization strategies.
 */
object Cats038_EvalPatterns {

  // Exercise 1: Stack-safe recursion with Eval
  // TODO: Implement a stack-safe fibonacci using Eval.defer.
  //       Standard recursive fib overflows the stack for large n.
  def exercise1_stackSafeRecursion(): BigInt = {
    // Stack-safe fib using Eval with accumulator pattern
    def fib(n: Int, a: BigInt, b: BigInt): Eval[BigInt] = {
      if (n <= 0) Eval.now(a)
      else ??? // Eval.defer(fib(n - 1, b, a + b))
    }

    // Compute fib(50)
    fib(50, BigInt(0), BigInt(1)).value
  }

  // Exercise 2: foldRight with Eval - Cats' Foldable uses Eval for stack safety
  // TODO: Implement a stack-safe foldRight using Eval.
  //       This is how Cats' Foldable.foldRight works internally.
  def exercise2_foldRightEval(): String = {
    def foldRight[A, B](list: List[A], init: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B] =
      list match {
        case Nil => init
        case head :: tail => ??? // f(head, Eval.defer(foldRight(tail, init)(f)))
      }

    // Use our foldRight to concatenate strings
    val words = List("hello", " ", "world")
    val result = foldRight(words, Eval.now("")) { (word, acc) =>
      acc.map(word + _)
    }

    result.value
  }

  // Exercise 3: Eval for lazy computation - deferred expensive work
  // TODO: Use Eval.later to defer expensive computation until needed.
  def exercise3_lazyComputation(): (Int, Boolean) = {
    var computed = false

    // This expensive computation should only run if we call .value
    val expensive: Eval[Int] = ??? // Eval.later({ computed = true; (1 to 1000).sum })

    // Before accessing - should not have computed yet
    val beforeAccess = computed

    // Now access the value
    val result = expensive.value

    (result, beforeAccess)
  }

  // Exercise 4: Eval.defer for trampolining - mutual recursion
  // TODO: Use Eval.defer to make mutually recursive functions stack-safe.
  def exercise4_trampolining(): Boolean = {
    // isEven and isOdd are mutually recursive
    def isEven(n: Long): Eval[Boolean] = {
      if (n == 0) Eval.now(true)
      else ??? // Eval.defer(isOdd(n - 1))
    }

    def isOdd(n: Long): Eval[Boolean] = {
      if (n == 0) Eval.now(false)
      else ??? // Eval.defer(isEven(n - 1))
    }

    // This would stack overflow without Eval!
    isEven(100000L).value
  }

  // Exercise 5: Eval vs lazy val - compare evaluation strategies
  // TODO: Demonstrate how Eval.later is similar to lazy val but composable.
  def exercise5_evalVsLazy(): (Int, Int, Int) = {
    var counter1 = 0
    var counter2 = 0
    var counter3 = 0

    // Eval.now ~ val (eager, computed once)
    val eagerEval: Eval[Int] = Eval.now({ counter1 += 1; 1 })

    // Eval.later ~ lazy val (lazy, computed once)
    val lazyEval: Eval[Int] = Eval.later({ counter2 += 1; 2 })

    // Eval.always ~ def (lazy, computed every time)
    val alwaysEval: Eval[Int] = Eval.always({ counter3 += 1; 3 })

    // Access each twice
    eagerEval.value; eagerEval.value
    lazyEval.value; lazyEval.value
    alwaysEval.value; alwaysEval.value

    // Return counters: (now=1, later=1, always=2)
    ???
  }

  // Exercise 6: Mutual recursion with Eval - more complex example
  // TODO: Implement a stack-safe mutual recursion pattern.
  def exercise6_mutualRecursion(): List[String] = {
    // Classify numbers as "fizz" (div by 3), "buzz" (div by 5), "fizzbuzz", or number
    def classify(n: Int): String =
      (n % 3 == 0, n % 5 == 0) match {
        case (true, true)  => "fizzbuzz"
        case (true, false) => "fizz"
        case (false, true) => "buzz"
        case _             => n.toString
      }

    // Stack-safe range processing using Eval
    def processRange(from: Int, to: Int, acc: List[String]): Eval[List[String]] = {
      if (from > to) Eval.now(acc.reverse)
      else ??? // Eval.defer(processRange(from + 1, to, classify(from) :: acc))
    }

    // Process 1 to 15
    processRange(1, 15, Nil).value
  }

  // Exercise 7: Eval in Foldable - how Cats uses Eval internally
  // TODO: Use Foldable's Eval-based foldRight to implement a stack-safe operation.
  def exercise7_evalInFoldable(): Boolean = {
    // Foldable[List].foldRight uses Eval internally for stack safety
    // Check if all elements in a large list are positive
    val largeList = (1 to 100000).toList

    // Use Foldable[List].foldRight with Eval
    val result: Eval[Boolean] = Foldable[List].foldRight(largeList, Eval.now(true)) {
      (elem, acc) => ???  // if (elem > 0) acc else Eval.now(false)
    }

    result.value
  }

  // Exercise 8: Eval memoization patterns - control when to cache
  // TODO: Demonstrate different memoization strategies with Eval.
  def exercise8_memoization(): (Int, Int) = {
    var computeCount = 0

    // An Eval.always that we'll selectively memoize
    val base: Eval[Int] = Eval.always({ computeCount += 1; 42 })

    // Chain of transformations on the always Eval
    val transformed: Eval[Int] = base.map(_ * 2).map(_ + 1)

    // Access transformed twice - computeCount increases each time (no memoization)
    transformed.value
    transformed.value
    val withoutMemo = computeCount

    // Reset counter
    computeCount = 0

    // Now memoize the base
    val base2: Eval[Int] = Eval.always({ computeCount += 1; 42 })
    val memoized: Eval[Int] = ??? // base2.memoize.map(_ * 2).map(_ + 1)

    // Access memoized twice - computeCount should only be 1
    memoized.value
    memoized.value
    val withMemo = computeCount

    (withoutMemo, withMemo)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_stackSafeRecursion()
    assert(r1 == BigInt("12586269025"), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: stack-safe fib(50) => $r1")

    // Exercise 2
    val r2 = exercise2_foldRightEval()
    assert(r2 == "hello world", s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: foldRight with Eval => $r2")

    // Exercise 3
    val (val3, before3) = exercise3_lazyComputation()
    assert(val3 == 500500 && !before3, s"Exercise 3 failed: val=$val3, before=$before3")
    println(s"Exercise 3 passed: lazy computation => value=$val3, computedBeforeAccess=$before3")

    // Exercise 4
    val r4 = exercise4_trampolining()
    assert(r4 == true, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: trampolining => isEven(100000) = $r4")

    // Exercise 5
    val (now5, later5, always5) = exercise5_evalVsLazy()
    assert(now5 == 1 && later5 == 1 && always5 == 2,
      s"Exercise 5 failed: now=$now5, later=$later5, always=$always5")
    println(s"Exercise 5 passed: Eval vs lazy => now=$now5, later=$later5, always=$always5")

    // Exercise 6
    val r6 = exercise6_mutualRecursion()
    assert(r6.length == 15, s"Exercise 6 failed: length=${r6.length}")
    assert(r6.head == "1" && r6(2) == "fizz" && r6(14) == "fizzbuzz",
      s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: mutual recursion => ${r6.take(5)}...")

    // Exercise 7
    val r7 = exercise7_evalInFoldable()
    assert(r7 == true, s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: Eval in Foldable => allPositive=$r7")

    // Exercise 8
    val (without8, with8) = exercise8_memoization()
    assert(without8 == 2 && with8 == 1,
      s"Exercise 8 failed: withoutMemo=$without8, withMemo=$with8")
    println(s"Exercise 8 passed: memoization => without=$without8, with=$with8")

    println("\nAll Cats038_EvalPatterns exercises passed!")
  }
}
