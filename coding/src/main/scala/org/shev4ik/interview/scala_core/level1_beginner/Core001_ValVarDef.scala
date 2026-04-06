package org.shev4ik.interview.scala_core.level1_beginner

/**
 * Core 001 - val, var, def, and lazy val: evaluation semantics and memory model.
 *
 * === Evaluation Semantics ===
 *
 * val:
 *   - Evaluated ONCE, eagerly, at the point of definition (or when the enclosing object/class
 *     is initialized). The result is stored in a final field -- it cannot be reassigned.
 *   - Memory: occupies a field in the enclosing object/class for the lifetime of that object.
 *   - Equivalent to Java's `final` field assigned in the constructor.
 *
 * var:
 *   - Evaluated ONCE, eagerly, at the point of definition (like val), but CAN be reassigned.
 *   - Memory: occupies a non-final field; generates both a getter and a setter method.
 *   - Avoid in idiomatic Scala -- mutable state makes reasoning about concurrency difficult.
 *
 * def:
 *   - Evaluated EVERY TIME it is called. No value is stored -- it is a method.
 *   - Memory: no field is allocated; the computation runs fresh on each invocation.
 *   - Use def for computations that depend on mutable state, parameters, or when you want
 *     lazy/deferred evaluation without caching.
 *
 * lazy val:
 *   - Evaluated AT MOST ONCE, on first access (lazy initialization). The result is then
 *     cached in a field and reused for subsequent accesses.
 *   - Memory: occupies a field plus a bitmap/flag to track initialization state.
 *   - In Scala 2, initialization is thread-safe via double-checked locking (synchronized block),
 *     which adds some overhead and can cause deadlocks with circular lazy val dependencies.
 *   - In Scala 3, a different, more efficient mechanism is used (based on a bitmap approach
 *     without full synchronization in common cases).
 *
 * === Interview Tips ===
 *
 * INTERVIEW TIP: Common interview question: "What happens with lazy val in a
 * multi-threaded context?"
 * Answer: In Scala 2, lazy val uses double-checked locking (synchronized) to ensure
 * thread-safe initialization. This means the first thread to access it acquires a lock,
 * computes the value, and stores it; subsequent threads see the cached value without
 * locking. However, this can cause DEADLOCKS if two lazy vals have circular dependencies
 * and are accessed from different threads (each thread holds one lock and waits for the other).
 * In Scala 3, the mechanism avoids some of these pitfalls but circular dependencies remain
 * problematic.
 *
 * INTERVIEW TIP: "What is the difference between val, def, and lazy val for a
 * class member that computes something expensive?"
 * Answer: val computes eagerly at construction time (slows down object creation, caches result),
 * def re-computes every time (no caching overhead, but repeated cost), lazy val computes on
 * first access and caches (best of both worlds but adds synchronization overhead in Scala 2).
 */
object Core001_ValVarDef {

  // Exercise 1: val vs var
  // TODO: Declare a val `immutableName` with value "Scala" and a var `mutableAge` with value 10.
  //       Then reassign `mutableAge` to 20. Return a tuple (immutableName, mutableAge).
  def exercise1_valVsVar: (String, Int) = ???

  // Exercise 2: Type inference
  // TODO: Declare a val `inferred` and assign 42 to it (let the compiler infer the type).
  //       Declare a val `inferredStr` and assign "hello".
  //       Return (inferred, inferredStr).
  def exercise2_typeInference: (Int, String) = ???

  // Exercise 3: Type annotation
  // TODO: Declare a val `annotated: Double` and assign 3.14 to it.
  //       Declare a val `annotatedList: List[Int]` and assign List(1, 2, 3).
  //       Return (annotated, annotatedList).
  def exercise3_typeAnnotation: (Double, List[Int]) = ???

  // Exercise 4: Final vals
  // TODO: Declare a final val `PI` with value 3.14159.
  //       Declare a final val `APP_NAME` with value "MyApp".
  //       Return (PI, APP_NAME).
  def exercise4_finalVals: (Double, String) = ???

  // Exercise 5: Constants and naming conventions
  // TODO: Following Scala convention, define a val `MaxRetries` = 3 (upper camel for constants)
  //       and a val `defaultTimeout` = 1000L.
  //       Return (MaxRetries, defaultTimeout).
  def exercise5_constants: (Int, Long) = ???

  // Exercise 6: Multiple assignment via tuple destructuring
  // TODO: Use a single val declaration to extract (x, y, z) from the tuple (1, "two", 3.0).
  //       Return (x, y, z).
  def exercise6_multipleAssignment: (Int, String, Double) = ???

  // Exercise 7: Lazy val basics
  // TODO: Declare a lazy val `lazyValue` that computes 40 + 2.
  //       Declare a var `counter` = 0, and a lazy val `lazyWithSideEffect` that increments
  //       counter and returns "evaluated". Return (lazyValue, counter) -- counter should be 0
  //       because lazyWithSideEffect has not been accessed yet.
  // Note: In Scala 2, lazy val initialization is thread-safe but has overhead due to
  // double-checked locking (a hidden synchronized block + volatile bitmap field).
  // Scala 3 uses a different, more efficient mechanism that avoids the synchronized block
  // in the common (already-initialized) path. In both versions, circular lazy val
  // dependencies can still lead to deadlocks or stack overflows.
  def exercise7_lazyVal: (Int, Int) = ???

  // Exercise 8: Block expressions
  // TODO: Use a block expression { ... } to compute a value:
  //       Inside the block, declare val a = 10, val b = 20, and the last expression a + b.
  //       Assign the block result to `blockResult`. Return blockResult.
  def exercise8_blockExpressions: Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_valVsVar == ("Scala", 20), "Exercise 1 failed")

    // Exercise 2
    assert(exercise2_typeInference == (42, "hello"), "Exercise 2 failed")

    // Exercise 3
    assert(exercise3_typeAnnotation == (3.14, List(1, 2, 3)), "Exercise 3 failed")

    // Exercise 4
    assert(exercise4_finalVals == (3.14159, "MyApp"), "Exercise 4 failed")

    // Exercise 5
    assert(exercise5_constants == (3, 1000L), "Exercise 5 failed")

    // Exercise 6
    assert(exercise6_multipleAssignment == (1, "two", 3.0), "Exercise 6 failed")

    // Exercise 7
    assert(exercise7_lazyVal == (42, 0), "Exercise 7 failed")

    // Exercise 8
    assert(exercise8_blockExpressions == 30, "Exercise 8 failed")

    println("All Core001_ValVarDef exercises passed!")
  }
}
