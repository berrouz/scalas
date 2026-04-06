package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 047 - Ref (Mutable Reference - Modeled as concept)
 *
 * Ref[F, A] is a purely functional mutable reference. It provides safe
 * concurrent access to mutable state. All operations are atomic.
 * This models cats-effect Ref concepts using a simplified implementation.
 */
object Cats047_Ref {

  // Simplified Ref model for exercise purposes
  // In real code, use cats.effect.concurrent.Ref
  class SimpleRef[A](private var value: A) {
    def get: A = synchronized(value)
    def set(a: A): Unit = synchronized { value = a }
    def update(f: A => A): Unit = synchronized { value = f(value) }
    def modify[B](f: A => (A, B)): B = synchronized {
      val (newA, b) = f(value)
      value = newA
      b
    }
    def updateAndGet(f: A => A): A = synchronized {
      value = f(value)
      value
    }
    def getAndUpdate(f: A => A): A = synchronized {
      val old = value
      value = f(value)
      old
    }
  }

  object SimpleRef {
    def of[A](initial: A): SimpleRef[A] = new SimpleRef(initial)
  }

  // Exercise 1: Ref.of - create a Ref with an initial value
  // TODO: Create a SimpleRef with initial value 0.
  def exercise1_refOf(): SimpleRef[Int] = {
    // Create a Ref initialized to 0
    ???
  }

  // Exercise 2: get - read the current value of a Ref
  // TODO: Read a value from a Ref.
  def exercise2_get(): Int = {
    val ref = SimpleRef.of(42)
    // Get the current value
    ???
  }

  // Exercise 3: set - replace the value in a Ref
  // TODO: Set a new value in a Ref.
  def exercise3_set(): Int = {
    val ref = SimpleRef.of(0)
    // Set the value to 100, then get it
    ???
  }

  // Exercise 4: update - atomically modify a Ref's value
  // TODO: Use update to atomically transform the value.
  def exercise4_update(): Int = {
    val ref = SimpleRef.of(10)
    // Update by adding 5, then get the result
    ???
  }

  // Exercise 5: modify - atomically modify and extract a value
  // TODO: Use modify to atomically update state and return a derived value.
  def exercise5_modify(): (Int, String) = {
    val ref = SimpleRef.of(0)
    // modify: increment by 1, return the OLD value as a string
    val oldValueStr: String = ???
    val newValue: Int = ref.get
    (newValue, oldValueStr)
  }

  // Exercise 6: updateAndGet - atomically update and return new value
  // TODO: Use updateAndGet to update and immediately get the new value.
  def exercise6_updateAndGet(): Int = {
    val ref = SimpleRef.of(5)
    // Multiply by 3 and get the new value in one atomic operation
    ???
  }

  // Exercise 7: Ref for shared state - use Ref as shared mutable state
  // TODO: Use a Ref to accumulate state across multiple operations.
  def exercise7_sharedState(): List[String] = {
    val ref = SimpleRef.of(List.empty[String])

    // Add items to the list using update
    // Add "first", "second", "third"
    ???

    ref.get
  }

  // Exercise 8: Ref for counter - implement a thread-safe counter
  // TODO: Use Ref to implement a counter with increment, decrement, and reset.
  class Counter(ref: SimpleRef[Int]) {
    def increment(): Unit = ???  // atomically add 1
    def decrement(): Unit = ???  // atomically subtract 1
    def reset(): Int = ???       // atomically reset to 0 and return old value
    def get: Int = ref.get
  }

  def exercise8_counter(): (Int, Int) = {
    val counter = new Counter(SimpleRef.of(0))

    // Increment 5 times, decrement 2 times, get value (should be 3)
    // Then reset and get the old value
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_refOf()
    assert(r1.get == 0, s"Exercise 1 failed: ${r1.get}")
    println(s"Exercise 1 passed: Ref.of => ${r1.get}")

    // Exercise 2
    val r2 = exercise2_get()
    assert(r2 == 42, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: get => $r2")

    // Exercise 3
    val r3 = exercise3_set()
    assert(r3 == 100, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: set => $r3")

    // Exercise 4
    val r4 = exercise4_update()
    assert(r4 == 15, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: update => $r4")

    // Exercise 5
    val (r5new, r5old) = exercise5_modify()
    assert(r5new == 1 && r5old == "0", s"Exercise 5 failed: new=$r5new, old=$r5old")
    println(s"Exercise 5 passed: modify => new=$r5new, oldStr=$r5old")

    // Exercise 6
    val r6 = exercise6_updateAndGet()
    assert(r6 == 15, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: updateAndGet => $r6")

    // Exercise 7
    val r7 = exercise7_sharedState()
    assert(r7 == List("first", "second", "third"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: shared state => $r7")

    // Exercise 8
    val (r8val, r8reset) = exercise8_counter()
    assert(r8val == 3, s"Exercise 8 failed: counter value=$r8val")
    assert(r8reset == 3, s"Exercise 8 failed: reset returned=$r8reset")
    println(s"Exercise 8 passed: counter => value=$r8val, reset=$r8reset")

    println("\nAll Cats047_Ref exercises passed!")
  }
}
