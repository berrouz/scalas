package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Basic Types and the Unified Type System=
 *
 * ==Theory: Scala's Type Hierarchy==
 *
 * Scala has a unified type system rooted at `Any`:
 * {{{
 *        Any
 *       /   \
 *   AnyVal  AnyRef (= java.lang.Object)
 *    / | \     / | \
 * Int Double  String List ...
 *  Boolean ...   (all Java/Scala classes)
 *       \     /
 *        Null     (subtype of all AnyRef types; has one instance: null)
 *         \
 *       Nothing   (subtype of ALL types; has no instances; used for Nil, ???, throw)
 * }}}
 *
 * '''Value Types (AnyVal):''' Int, Long, Double, Float, Byte, Short, Char, Boolean, Unit.
 * These correspond to JVM primitives and are NOT allocated on the heap (unless boxed).
 *
 * '''Reference Types (AnyRef):''' Everything else -- String, List, your own classes, etc.
 * Equivalent to `java.lang.Object` on the JVM.
 *
 * ==Boxing and Unboxing==
 *
 * In Scala, `Int` is the primitive `int` on the JVM in most cases. However, when used
 * in a generic context (e.g., `List[Int]`), the compiler auto-boxes it to `java.lang.Integer`.
 * This is called '''autoboxing'''. The reverse (Integer -> int) is '''unboxing'''.
 *
 * Scala hides this complexity, but it matters for performance in tight loops and large collections.
 * Libraries like `cats` and `spire` offer specialized numeric abstractions to avoid boxing.
 *
 * ==Key Distinctions==
 *
 *  - `Nothing` is the bottom type -- it is a subtype of every type. The expression `???`
 *    has type `Nothing`, allowing it to stand in for any return type.
 *  - `Null` is a subtype of all reference types. Its only value is `null`. Idiomatic Scala
 *    avoids `null` in favor of `Option`, `Either`, or `Try`.
 *  - `Unit` is the "void" equivalent with exactly one value: `()`.
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "What is the difference between Int and java.lang.Integer in Scala?"'''
 *    Answer: `Int` in Scala is the primitive `int` on the JVM. It gets boxed to `java.lang.Integer`
 *    when used in generic contexts (e.g., `List[Int]`, `Option[Int]`). Scala's compiler
 *    automatically handles boxing/unboxing, but you can use `@specialized` or value classes
 *    to reduce boxing overhead in performance-critical code.
 *
 *  - '''Follow-up: "What is the type hierarchy root in Scala?"'''
 *    Answer: `Any` is the root of ALL types. `AnyVal` is the root of value types (primitives),
 *    and `AnyRef` is the root of reference types (equivalent to `java.lang.Object`).
 *
 *  - '''Follow-up: "What is Nothing and when is it used?"'''
 *    Answer: `Nothing` is the bottom type with no instances. It is the return type of
 *    expressions that never complete normally (`throw`, `???`, `sys.error`). It is also
 *    the element type of `Nil` (empty list): `Nil: List[Nothing]`, which allows `Nil`
 *    to be assigned to any `List[T]` since `Nothing <: T` for all `T`.
 *
 * ==Approach Hints==
 *
 * When solving these exercises:
 *  - Use Long literals (e.g., `2000000000L`) to avoid Int overflow.
 *  - Remember that integer division truncates in Scala (17 / 5 == 3, not 3.4).
 *  - BigInt and BigDecimal provide arbitrary precision but are slower than primitives.
 *  - Type conversions: `.toInt` truncates (3.99.toInt == 3), `.toDouble` widens, `.toChar`
 *    converts an Int to the corresponding Unicode character.
 */
object Core002_BasicTypes {

  // Exercise 1: Int operations
  // TODO: Compute the sum of 1000000 and 2000000, the product of 123 * 456,
  //       and the integer division 17 / 5. Return (sum, product, intDiv).
  def exercise1_intOps: (Int, Int, Int) = ???

  // Exercise 2: Long and overflow awareness
  // TODO: Compute 2000000000L * 3L (must use Long to avoid overflow).
  //       Also compute Int.MaxValue as a Long and add 1L to it.
  //       Return (product, overflowResult).
  def exercise2_long: (Long, Long) = ???

  // Exercise 3: Double precision
  // TODO: Compute 0.1 + 0.2 and store in `sum`. Compute 1.0 / 3.0 and store in `third`.
  //       Return (sum, third). Note: sum will NOT be exactly 0.3 due to floating point.
  def exercise3_doublePrecision: (Double, Double) = ???

  // Exercise 4: Boolean logic
  // TODO: Compute: (true && false), (true || false), (!true), (5 > 3 && 2 < 4).
  //       Return them as a tuple of 4 Booleans.
  def exercise4_booleanLogic: (Boolean, Boolean, Boolean, Boolean) = ???

  // Exercise 5: Char and String basics
  // TODO: Declare a Char 'A', get its numeric value using .toInt, concatenate "Hello" + " " + "World".
  //       Return (char, numericValue, concatenated).
  def exercise5_charString: (Char, Int, String) = ???

  // Exercise 6: BigInt
  // TODO: Compute BigInt(Long.MaxValue) + BigInt(1) and factorial of 20 using BigInt.
  //       For factorial, use (BigInt(1) to BigInt(20)).product
  //       Return (beyondLong, factorial20).
  def exercise6_bigInt: (BigInt, BigInt) = ???

  // Exercise 7: BigDecimal
  // TODO: Compute BigDecimal("0.1") + BigDecimal("0.2") (exact arithmetic).
  //       Also compute BigDecimal("1.0") / BigDecimal("3.0") with a MathContext of 10 digits.
  //       Return (exactSum, preciseThird).
  def exercise7_bigDecimal: (BigDecimal, BigDecimal) = ???

  // Exercise 8: Type conversions
  // TODO: Convert 42 to Double, 3.99 to Int (truncation), 65 to Char, "123" to Int, "3.14" to Double.
  //       Return (intToDouble, doubleToInt, intToChar, strToInt, strToDouble).
  def exercise8_typeConversions: (Double, Int, Char, Int, Double) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (sum, prod, intDiv) = exercise1_intOps
    assert(sum == 3000000, "Exercise 1 failed: sum")
    assert(prod == 56088, "Exercise 1 failed: product")
    assert(intDiv == 3, "Exercise 1 failed: intDiv")

    // Exercise 2
    val (longProd, overflow) = exercise2_long
    assert(longProd == 6000000000L, "Exercise 2 failed: longProd")
    assert(overflow == Int.MaxValue.toLong + 1L, "Exercise 2 failed: overflow")

    // Exercise 3
    val (dblSum, third) = exercise3_doublePrecision
    assert(math.abs(dblSum - 0.30000000000000004) < 1e-15, "Exercise 3 failed: sum")
    assert(math.abs(third - 0.3333333333333333) < 1e-15, "Exercise 3 failed: third")

    // Exercise 4
    assert(exercise4_booleanLogic == (false, true, false, true), "Exercise 4 failed")

    // Exercise 5
    assert(exercise5_charString == ('A', 65, "Hello World"), "Exercise 5 failed")

    // Exercise 6
    val (beyondLong, fact20) = exercise6_bigInt
    assert(beyondLong == BigInt("9223372036854775808"), "Exercise 6 failed: beyondLong")
    assert(fact20 == BigInt("2432902008176640000"), "Exercise 6 failed: factorial20")

    // Exercise 7
    val (exactSum, _) = exercise7_bigDecimal
    assert(exactSum == BigDecimal("0.3"), "Exercise 7 failed: exactSum")

    // Exercise 8
    assert(exercise8_typeConversions == (42.0, 3, 'A', 123, 3.14), "Exercise 8 failed")

    println("All Core002_BasicTypes exercises passed!")
  }
}
