package org.shev4ik.interview.concurrency.level3_advanced

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference, AtomicBoolean}

object Conc017_MemoryModel {

  // Exercise 1: Volatile guarantees visibility
  // TODO: Create a @volatile var flag = false and a @volatile var data = 0.
  //       Thread A sets data = 42 then flag = true.
  //       Thread B spins while !flag, then reads data.
  //       Use a CountDownLatch for Thread B to signal its result.
  //       Return the data read by Thread B (should be 42 due to volatile ordering).
  def exercise1_volatileVisibility(): Int = ???

  // Exercise 2: Happens-before via synchronized
  // TODO: Create a var data = 0 and a lock object. Thread A synchronized(lock) { data = 99 }.
  //       Thread B (after A completes via CountDownLatch) synchronized(lock) { read data }.
  //       The happens-before from synchronized ensures B sees 99.
  //       Return the value read by B.
  def exercise2_happensBefore(): Int = ???

  // Exercise 3: Happens-before via Thread.join
  // TODO: Create a var result = 0. Thread A sets result = 77.
  //       Main thread calls A.join(), then reads result.
  //       join() establishes happens-before, so main sees 77.
  //       Return result.
  def exercise3_joinHappensBefore(): Int = ???

  // Exercise 4: Happens-before via CountDownLatch
  // TODO: Create a var data = 0 and a CountDownLatch(1).
  //       Thread A sets data = 55, then calls latch.countDown().
  //       Main thread awaits the latch, then reads data.
  //       The latch establishes happens-before. Return data (should be 55).
  def exercise4_latchHappensBefore(): Int = ???

  // Exercise 5: AtomicReference for safe publication
  // TODO: Create an AtomicReference[List[Int]](Nil).
  //       Thread A publishes List(1, 2, 3) via atomicRef.set().
  //       Thread B (after A via latch) reads via atomicRef.get().
  //       AtomicReference ensures safe publication. Return the list.
  def exercise5_safePublication(): List[Int] = ???

  // Exercise 6: Piggybacking on synchronized for multiple variables
  // TODO: Create var x = 0 and var y = 0 and a lock object.
  //       Thread A: synchronized(lock) { x = 10; y = 20 }.
  //       Thread B (after A via latch): synchronized(lock) { read x and y }.
  //       Both writes in A are visible to B due to happens-before.
  //       Return (x, y) as read by B — should be (10, 20).
  def exercise6_piggyback(): (Int, Int) = ???

  // Exercise 7: Final fields and safe construction
  // TODO: Create a class ImmutableHolder(val value: Int, val name: String).
  //       Construct ImmutableHolder(42, "safe") in Thread A and publish via AtomicReference.
  //       Thread B reads it. Final (val) fields in a properly constructed object are safely published.
  //       Return (holder.value, holder.name) — should be (42, "safe").
  def exercise7_finalFields(): (Int, String) = ???

  // Exercise 8: Demonstrating ordering with volatile
  // TODO: Create @volatile var step = 0, var a = 0, var b = 0.
  //       Thread A: a = 1; step = 1 (volatile write).
  //       Thread B: while (step < 1) {}; b = a + 1; step = 2 (volatile write).
  //       Main: while (step < 2) {}; read b.
  //       Use CountDownLatch for final synchronization.
  //       Return b (should be 2 — volatile writes establish ordering for a).
  def exercise8_volatileOrdering(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_volatileVisibility() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_happensBefore() == 99, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_joinHappensBefore() == 77, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_latchHappensBefore() == 55, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_safePublication() == List(1, 2, 3), "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_piggyback() == (10, 20), "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_finalFields() == (42, "safe"), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_volatileOrdering() == 2, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc017_MemoryModel exercises passed!")
  }
}
