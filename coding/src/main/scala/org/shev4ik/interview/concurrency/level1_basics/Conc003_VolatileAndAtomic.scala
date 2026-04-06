package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent.atomic.{AtomicInteger, AtomicLong, AtomicReference, AtomicBoolean}
import java.util.concurrent.CountDownLatch

object Conc003_VolatileAndAtomic {

  // Exercise 1: AtomicInteger basics
  // TODO: Create an AtomicInteger initialized to 0. Use incrementAndGet() 5 times.
  //       Return the final value (should be 5).
  def exercise1_atomicIntBasic(): Int = ???

  // Exercise 2: AtomicInteger with multiple threads
  // TODO: Create an AtomicInteger counter = 0. Launch 10 threads, each calling
  //       counter.incrementAndGet() 1000 times. Join all threads.
  //       Return counter.get() (should be 10000).
  def exercise2_atomicIntConcurrent(): Int = ???

  // Exercise 3: AtomicLong accumulator
  // TODO: Create an AtomicLong sum = 0. Launch 5 threads, each adding 100 to sum
  //       using addAndGet(100) called 10 times. Join all.
  //       Return sum.get() (should be 5000).
  def exercise3_atomicLong(): Long = ???

  // Exercise 4: compareAndSet (CAS)
  // TODO: Create an AtomicInteger value = 10.
  //       Attempt CAS: compareAndSet(10, 20) — should succeed, returns true.
  //       Attempt CAS: compareAndSet(10, 30) — should fail (current is 20), returns false.
  //       Return (firstResult, secondResult, value.get()) — should be (true, false, 20).
  def exercise4_compareAndSet(): (Boolean, Boolean, Int) = ???

  // Exercise 5: AtomicReference
  // TODO: Create an AtomicReference[String]("hello").
  //       Use compareAndSet("hello", "world") to update it.
  //       Return the current value (should be "world").
  def exercise5_atomicReference(): String = ???

  // Exercise 6: AtomicBoolean as a flag
  // TODO: Create an AtomicBoolean running = true.
  //       Launch a thread that spins while running.get() is true, incrementing an AtomicInteger counter.
  //       From the main thread, set running to false.
  //       Join the worker thread. Return true if counter.get() > 0.
  def exercise6_atomicBoolean(): Boolean = ???

  // Exercise 7: CAS loop pattern
  // TODO: Implement a method that atomically multiplies an AtomicInteger by 2 using a CAS loop:
  //       Repeatedly read the current value, compute newVal = current * 2,
  //       and attempt compareAndSet(current, newVal) until it succeeds.
  //       Start with AtomicInteger(5). Call the method once. Return the result (should be 10).
  def exercise7_casLoop(): Int = ???

  // Exercise 8: getAndUpdate / updateAndGet
  // TODO: Create an AtomicInteger initialized to 10.
  //       Use getAndSet(20) to swap the value — store the old value.
  //       Then use get() to read the new value.
  //       Return (oldValue, newValue) — should be (10, 20).
  def exercise8_getAndSet(): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_atomicIntBasic() == 5, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_atomicIntConcurrent() == 10000, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_atomicLong() == 5000L, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_compareAndSet() == (true, false, 20), "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_atomicReference() == "world", "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_atomicBoolean() == true, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_casLoop() == 10, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_getAndSet() == (10, 20), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc003_VolatileAndAtomic exercises passed!")
  }
}
