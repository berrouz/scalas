package org.shev4ik.interview.scala3.level2_intermediate

/**
 * Scala 3: inline, transparent inline, and compiletime ops
 * (modeled conceptually in Scala 2.13)
 *
 * In Scala 3:
 *   - `inline def` guarantees inlining at compile time
 *   - `transparent inline` allows the return type to be specialized
 *   - `compiletime` package provides compile-time operations
 * In Scala 2.13, we model these concepts using @inline, macros awareness, and value-level computation.
 */
object Sc3_007_InlineMeta {

  // Exercise 1: Basic inline concept (Scala 3: inline def)
  // Scala 3: inline def double(x: Int): Int = x + x
  // In Scala 2, @inline is a hint to the JIT, not a guarantee.
  // TODO: Implement `power` using @inline annotation.
  //       power(base, exp) computes base^exp recursively.
  //       Answer: What is the key difference between Scala 2 @inline and Scala 3 inline?
  @inline def exercise1_power(base: Int, exp: Int): Int = ???
  def exercise1_difference: String = ???  // TODO: "Scala 3 inline is guaranteed by compiler; Scala 2 @inline is a JIT hint"

  // Exercise 2: Inline val concept (Scala 3: inline val)
  // Scala 3: inline val Pi = 3.14159 (compile-time constant)
  // In Scala 2, final val achieves similar effect for literals.
  // TODO: Define final vals for mathematical constants.
  //       Implement `circleArea(radius: Double): Double` using the constant.
  //       Answer: What does Scala 3 `inline val` guarantee that Scala 2 `final val` may not?
  final val Pi: Double = 3.14159
  final val E: Double = 2.71828
  def exercise2_circleArea(radius: Double): Double = ???
  def exercise2_inlineValAnswer: String = ???  // TODO: "inline val is always inlined at use site; final val may or may not be"

  // Exercise 3: Transparent inline concept
  // Scala 3: transparent inline def choose(b: Boolean) = if b then 1 else "one"
  // The return type is narrowed: choose(true) has type Int, choose(false) has type String.
  // In Scala 2, this returns Any. Model the concept and explain the difference.
  // TODO: Implement `choose(b: Boolean): Any` that returns 1 if true, "one" if false.
  //       Answer: What type does Scala 3 `transparent inline def choose(true)` return?
  def exercise3_choose(b: Boolean): Any = ???
  def exercise3_transparentAnswer: String = ???  // TODO: "Int (the type is narrowed to the specific branch taken)"

  // Exercise 4: Compiletime ops concept (Scala 3: scala.compiletime.constValue)
  // Scala 3 can compute at compile time: constValue[42] == 42
  // TODO: Implement a value-level analog. Create a trait `ConstValue[N]` that holds a value.
  //       Provide instances for common literal types (model as singleton-like classes).
  //       Implement `exercise4_constValue` that returns the value associated with a type parameter.
  //       Since Scala 2 lacks singleton types, use implicit values to model this.
  trait NatValue[N] {
    def value: Int
  }
  // Model natural numbers at type level
  trait Zero
  trait Succ[N]
  implicit val zeroValue: NatValue[Zero] = ???
  implicit def succValue[N](implicit prev: NatValue[N]): NatValue[Succ[N]] = ???
  def exercise4_natToInt[N](implicit ev: NatValue[N]): Int = ???

  // Exercise 5: Inline match concept (Scala 3: inline x match { ... })
  // Scala 3 can eliminate branches at compile time with inline match.
  // TODO: Model this as a regular match that "simulates" compile-time selection.
  //       Implement `typeLabel[A](implicit tag: scala.reflect.ClassTag[A]): String` that returns:
  //       - "integer" for Int
  //       - "string" for String
  //       - "boolean" for Boolean
  //       - "unknown" for anything else
  //       Answer: What is the difference between Scala 3 inline match and runtime match?
  def exercise5_typeLabel[A](implicit tag: scala.reflect.ClassTag[A]): String = ???
  def exercise5_inlineMatchAnswer: String = ???  // TODO: "inline match resolves at compile time and eliminates dead branches"

  // Exercise 6: Error reporting with compiletime (Scala 3: compiletime.error)
  // Scala 3: inline def fail = compiletime.error("This should not be called")
  // In Scala 2, we use ??? or require for runtime errors, @compileTimeOnly for compile-time.
  // TODO: Implement `safeDivide` that:
  //       - Returns result if divisor != 0
  //       - Throws IllegalArgumentException with "division by zero" if divisor is 0
  //       Answer: How does Scala 3 compiletime.error differ from runtime exceptions?
  def exercise6_safeDivide(a: Int, b: Int): Int = ???
  def exercise6_compiletimeErrorAnswer: String = ???  // TODO: "compiletime.error produces a compile-time error, preventing the code from compiling"

  // Exercise 7: Inline parameters and specialization
  // Scala 3: inline def log(inline msg: String) = println(msg) (msg is inlined at call site)
  // Scala 2: @specialized annotation for primitive specialization.
  // TODO: Implement a `Benchmark` utility:
  //       - `measure[A](label: String)(block: => A): (A, Long)` — returns (result, elapsed_ms)
  //       - `measureAverage[A](label: String, runs: Int)(block: => A): (A, Double)` — average time
  //       Answer: What does Scala 3 `inline` parameter guarantee about evaluation?
  def exercise7_measure[A](label: String)(block: => A): (A, Long) = ???
  def exercise7_measureAverage[A](label: String, runs: Int)(block: => A): (A, Double) = ???
  def exercise7_inlineParamAnswer: String = ???  // TODO: "inline parameters are substituted at the call site before compilation"

  // Exercise 8: Summary — modeling Scala 3 compiletime features
  // TODO: For each Scala 3 feature, return the best Scala 2.13 approximation as a string.
  //       Map each Scala 3 feature to its Scala 2 equivalent.
  def exercise8_equivalents: Map[String, String] = ???
  // Expected map:
  // "inline def" -> "@inline annotation (hint only)"
  // "inline val" -> "final val for literals"
  // "transparent inline" -> "no direct equivalent (returns widened type)"
  // "compiletime.error" -> "@compileTimeOnly annotation or macro-based"
  // "inline match" -> "no direct equivalent (runtime match only)"
  // "inline parameter" -> "by-name parameter (=> A)"
  // "scala.compiletime.constValue" -> "no direct equivalent (use implicit evidence)"
  // "summonInline" -> "implicitly[T]"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_power(2, 10) == 1024, "Exercise 1 failed: 2^10")
    assert(exercise1_power(3, 3) == 27, "Exercise 1 failed: 3^3")
    assert(exercise1_difference == "Scala 3 inline is guaranteed by compiler; Scala 2 @inline is a JIT hint", "Exercise 1 answer failed")

    // Exercise 2
    assert(Math.abs(exercise2_circleArea(1.0) - Pi) < 0.001, "Exercise 2 failed")
    assert(exercise2_inlineValAnswer == "inline val is always inlined at use site; final val may or may not be", "Exercise 2 answer failed")

    // Exercise 3
    assert(exercise3_choose(true) == 1, "Exercise 3 failed: true")
    assert(exercise3_choose(false) == "one", "Exercise 3 failed: false")
    assert(exercise3_transparentAnswer == "Int (the type is narrowed to the specific branch taken)", "Exercise 3 answer failed")

    // Exercise 4
    assert(exercise4_natToInt[Zero] == 0, "Exercise 4 failed: Zero")
    assert(exercise4_natToInt[Succ[Succ[Zero]]] == 2, "Exercise 4 failed: Succ[Succ[Zero]]")

    // Exercise 5
    assert(exercise5_typeLabel[Int] == "integer", "Exercise 5 Int failed")
    assert(exercise5_typeLabel[String] == "string", "Exercise 5 String failed")
    assert(exercise5_typeLabel[Boolean] == "boolean", "Exercise 5 Boolean failed")
    assert(exercise5_typeLabel[Double] == "unknown", "Exercise 5 Double failed")
    assert(exercise5_inlineMatchAnswer == "inline match resolves at compile time and eliminates dead branches", "Exercise 5 answer failed")

    // Exercise 6
    assert(exercise6_safeDivide(10, 2) == 5, "Exercise 6 failed")
    try { exercise6_safeDivide(10, 0); assert(false, "Exercise 6 should throw") }
    catch { case _: IllegalArgumentException => () }
    assert(exercise6_compiletimeErrorAnswer == "compiletime.error produces a compile-time error, preventing the code from compiling", "Exercise 6 answer failed")

    // Exercise 7
    val (result, elapsed) = exercise7_measure("test") { (1 to 1000).sum }
    assert(result == 500500, "Exercise 7 measure failed")
    assert(elapsed >= 0, "Exercise 7 elapsed should be non-negative")
    assert(exercise7_inlineParamAnswer == "inline parameters are substituted at the call site before compilation", "Exercise 7 answer failed")

    // Exercise 8
    val eq = exercise8_equivalents
    assert(eq("inline def") == "@inline annotation (hint only)", "Exercise 8 failed")
    assert(eq("inline val") == "final val for literals", "Exercise 8 failed")
    assert(eq("summonInline") == "implicitly[T]", "Exercise 8 failed")
    assert(eq.size == 8, "Exercise 8 should have 8 entries")

    println("All Sc3_007_InlineMeta exercises passed!")
  }
}
