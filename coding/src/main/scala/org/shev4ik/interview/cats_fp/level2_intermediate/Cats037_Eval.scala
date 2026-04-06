package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 037 - Eval
 *
 * Eval[A] is a monad for controlling evaluation semantics:
 * - Eval.now: eager evaluation (computed immediately)
 * - Eval.later: lazy evaluation (computed once, memoized)
 * - Eval.always: lazy evaluation (computed every time)
 * Eval also provides stack-safe monadic recursion via defer/flatMap.
 */
object Cats037_Eval {

  // Exercise 1: Eval.now - eager evaluation, computed immediately
  // TODO: Create an Eval.now and extract its value.
  //       The expression is evaluated at creation time.
  def exercise1_now(): Int = {
    var counter = 0
    val eval: Eval[Int] = ??? // Eval.now({ counter += 1; counter })

    // Access value twice - counter should only be 1 (evaluated once at creation)
    val v1 = eval.value
    val v2 = eval.value
    counter // Should be 1
  }

  // Exercise 2: Eval.later - lazy, memoized evaluation
  // TODO: Create an Eval.later and show it's computed on first access only.
  //       Like lazy val: computed once, cached.
  def exercise2_later(): (Int, Int) = {
    var counter = 0
    val eval: Eval[Int] = ??? // Eval.later({ counter += 1; 42 })

    // Before access, counter should be 0 (lazy)
    val beforeAccess = counter

    // After first access, counter becomes 1
    val _v1 = eval.value
    val _v2 = eval.value  // Second access doesn't re-evaluate
    val afterAccess = counter

    (beforeAccess, afterAccess)
  }

  // Exercise 3: Eval.always - lazy, NOT memoized (re-evaluated every time)
  // TODO: Create an Eval.always and show it's re-computed on each access.
  //       Like a def: computed every time.
  def exercise3_always(): Int = {
    var counter = 0
    val eval: Eval[Int] = ??? // Eval.always({ counter += 1; counter })

    // Access three times - counter increments each time
    val _a1 = eval.value
    val _a2 = eval.value
    val _a3 = eval.value
    counter // Should be 3
  }

  // Exercise 4: map - transform the value inside Eval
  // TODO: Use map to transform Eval's value.
  def exercise4_map(): Int = {
    val eval: Eval[Int] = Eval.now(21)

    // Map to double the value
    val doubled: Eval[Int] = ???

    doubled.value
  }

  // Exercise 5: flatMap - chain Eval computations
  // TODO: Use flatMap (for-comprehension) to chain Eval computations.
  def exercise5_flatMap(): String = {
    val greeting: Eval[String] = Eval.now("Hello")
    val name: Eval[String] = Eval.later("World")

    // Combine using for-comprehension
    val message: Eval[String] = ???

    message.value
  }

  // Exercise 6: memoize - convert an Eval.always to a memoized version
  // TODO: Use .memoize to cache the result of an Eval.always.
  def exercise6_memoize(): Int = {
    var counter = 0
    val always: Eval[Int] = Eval.always({ counter += 1; 42 })
    val memoized: Eval[Int] = ??? // always.memoize

    // Access twice - should only evaluate once due to memoization
    val _m1 = memoized.value
    val _m2 = memoized.value
    counter // Should be 1 (memoized after first access)
  }

  // Exercise 7: defer - create a deferred Eval (for stack safety)
  // TODO: Use Eval.defer to wrap an Eval computation lazily.
  //       defer is crucial for trampolining (stack-safe recursion).
  def exercise7_defer(): BigInt = {
    // Stack-safe factorial using Eval.defer
    def factorial(n: BigInt): Eval[BigInt] = {
      if (n <= 1) Eval.now(BigInt(1))
      else ??? // Eval.defer(factorial(n - 1).map(_ * n))
    }

    // Compute factorial(20)
    factorial(20).value
  }

  // Exercise 8: Trampolining with Eval - stack-safe recursion
  // TODO: Use Eval.defer + flatMap to create stack-safe recursive sum.
  //       Without Eval, this would overflow the stack for large inputs.
  def exercise8_trampolining(): BigInt = {
    // Stack-safe sum of 1 to n
    def sum(n: Long, acc: BigInt): Eval[BigInt] = {
      if (n <= 0) Eval.now(acc)
      else ??? // Eval.defer(sum(n - 1, acc + n))
    }

    // Sum from 1 to 50000 - would stack overflow without trampolining!
    sum(50000L, BigInt(0)).value
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_now()
    assert(r1 == 1, s"Exercise 1 failed: counter=$r1")
    println(s"Exercise 1 passed: Eval.now => counter=$r1 (evaluated once at creation)")

    // Exercise 2
    val (before2, after2) = exercise2_later()
    assert(before2 == 0 && after2 == 1, s"Exercise 2 failed: before=$before2, after=$after2")
    println(s"Exercise 2 passed: Eval.later => before=$before2, after=$after2 (lazy + memoized)")

    // Exercise 3
    val r3 = exercise3_always()
    assert(r3 == 3, s"Exercise 3 failed: counter=$r3")
    println(s"Exercise 3 passed: Eval.always => counter=$r3 (re-evaluated each time)")

    // Exercise 4
    val r4 = exercise4_map()
    assert(r4 == 42, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: map => $r4")

    // Exercise 5
    val r5 = exercise5_flatMap()
    assert(r5 == "Hello, World!", s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: flatMap => $r5")

    // Exercise 6
    val r6 = exercise6_memoize()
    assert(r6 == 1, s"Exercise 6 failed: counter=$r6")
    println(s"Exercise 6 passed: memoize => counter=$r6 (evaluated only once)")

    // Exercise 7
    val r7 = exercise7_defer()
    assert(r7 == BigInt("2432902008176640000"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: defer => factorial(20) = $r7")

    // Exercise 8
    val r8 = exercise8_trampolining()
    val expected8 = BigInt(50000L) * BigInt(50001L) / 2
    assert(r8 == expected8, s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: trampolining => sum(1..50000) = $r8")

    println("\nAll Cats037_Eval exercises passed!")
  }
}
