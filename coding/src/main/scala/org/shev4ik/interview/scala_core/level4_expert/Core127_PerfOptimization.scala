package org.shev4ik.interview.scala_core.level4_expert

/**
 * Core127 - Performance Optimization
 * Level: Expert
 *
 * Scala-specific performance optimization techniques including
 * specialization, inlining, value classes, and boxing avoidance.
 *
 * Key concepts:
 * - @specialized annotation
 * - @inline annotation
 * - Value classes for zero-overhead wrappers
 * - Boxing/unboxing avoidance
 */
object Core127_PerfOptimization {

  // Exercise 1: Value class for zero-cost abstraction
  // TODO: Implement value classes for type-safe IDs that have
  // no runtime overhead (no boxing).
  case class UserId(value: Long) extends AnyVal
  case class OrderId(value: Long) extends AnyVal

  def exercise1(): Unit = ???

  // Exercise 2: Specialized generic method
  // TODO: Implement a generic sum function that is specialized for
  // Int, Long, and Double to avoid boxing overhead.
  // Use @specialized annotation.
  def sum[@specialized(Int, Long, Double) A](xs: Array[A])(implicit num: Numeric[A]): A = ???

  // Exercise 3: Manual specialization pattern
  // TODO: When @specialized isn't enough, implement manual specialization
  // with a sealed trait and concrete implementations for primitive types.
  sealed trait FastBuffer[A] {
    def append(value: A): Unit
    def get(index: Int): A
    def size: Int
  }

  def exercise3IntBuffer(capacity: Int): FastBuffer[Int] = ???

  // Exercise 4: Avoiding boxing in collections
  // TODO: Demonstrate the difference between List[Int] (boxed) and
  // Array[Int] (unboxed). Implement a function that processes an
  // array of primitives without boxing.
  def sumArray(arr: Array[Int]): Long = ???
  def dotProduct(a: Array[Double], b: Array[Double]): Double = ???

  // Exercise 5: Inline for performance
  // TODO: Implement small utility functions with @inline to suggest
  // the compiler inline them for reduced call overhead.
  @inline def square(x: Double): Double = ???
  @inline def clamp(value: Int, min: Int, max: Int): Int = ???

  // Exercise 6: Tail-recursive optimization
  // TODO: Implement algorithms that are tail-recursive to avoid
  // stack overflow and enable compiler optimization to loop form.
  // @scala.annotation.tailrec — will be added when implemented
  def gcd(a: Long, b: Long): Long = ???

  def factorial(n: BigInt): BigInt = {
    // TODO: Implement with tail-recursive helper using accumulator
    ???
  }

  // Exercise 7: String building optimization
  // TODO: Implement efficient string building using StringBuilder
  // instead of string concatenation. Show the difference.
  def buildStringEfficient(parts: Seq[String], separator: String): String = ???
  def repeatChar(c: Char, n: Int): String = ???

  // Exercise 8: Collection operation fusion
  // TODO: Implement a pipeline of operations using .view to avoid
  // creating intermediate collections (lazy evaluation).
  def processLargeCollection(data: Vector[Int]): Vector[Int] = {
    // TODO: Use .view to fuse map/filter/take operations
    // without creating intermediate collections
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val uid = UserId(42L)
    val oid = OrderId(42L)
    // These are different types despite same underlying value
    // uid == oid  // won't compile - type safe!
    assert(uid.value == 42L)
    println("Exercise 1 passed: Value classes")

    // Exercise 2
    assert(sum(Array(1, 2, 3, 4, 5)) == 15)
    assert(sum(Array(1.0, 2.0, 3.0)) == 6.0)
    println("Exercise 2 passed: Specialized sum")

    // Exercise 4
    assert(sumArray(Array(1, 2, 3, 4, 5)) == 15L)
    assert(dotProduct(Array(1.0, 2.0, 3.0), Array(4.0, 5.0, 6.0)) == 32.0)
    println("Exercise 4 passed: Unboxed array operations")

    // Exercise 5
    assert(square(3.0) == 9.0)
    assert(clamp(15, 0, 10) == 10)
    assert(clamp(-5, 0, 10) == 0)
    assert(clamp(5, 0, 10) == 5)
    println("Exercise 5 passed: Inline functions")

    // Exercise 6
    assert(gcd(48, 18) == 6)
    assert(gcd(100, 75) == 25)
    assert(factorial(BigInt(10)) == BigInt(3628800))
    println("Exercise 6 passed: Tail-recursive optimization")

    // Exercise 7
    assert(buildStringEfficient(Seq("a", "b", "c"), ",") == "a,b,c")
    assert(repeatChar('x', 5) == "xxxxx")
    println("Exercise 7 passed: String building")

    // Exercise 8
    val data = (1 to 1000000).toVector
    val result = processLargeCollection(data)
    assert(result.nonEmpty)
    println("Exercise 8 passed: Collection fusion")

    println("\nAll Core127 exercises passed!")
  }
}
