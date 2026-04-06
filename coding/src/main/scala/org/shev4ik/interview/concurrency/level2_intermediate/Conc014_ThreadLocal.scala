package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

object Conc014_ThreadLocal {

  // Exercise 1: Basic ThreadLocal
  // TODO: Create a ThreadLocal[String] with initial value "default" using ThreadLocal.withInitial(() => "default").
  //       In main thread, get() should return "default". Set it to "main".
  //       Get() again should return "main". Return (initial, afterSet).
  //       Note: initial here means the first get() call result.
  def exercise1_basicThreadLocal(): (String, String) = ???

  // Exercise 2: ThreadLocal isolation between threads
  // TODO: Create a ThreadLocal[Int] with initial value 0.
  //       In main thread, set it to 100.
  //       Launch a thread that gets the value (should be 0, not 100) and stores it in AtomicInteger.
  //       Join. Return (mainValue, threadValue) — should be (100, 0).
  def exercise2_isolation(): (Int, Int) = ???

  // Exercise 3: ThreadLocal per-thread accumulator
  // TODO: Create a ThreadLocal[Int] initialized to 0.
  //       Launch 3 threads. Each thread increments its ThreadLocal value 5 times.
  //       Each thread stores its final value in a shared AtomicInteger (addAndGet).
  //       Use CountDownLatch for coordination. Return sum (should be 15 = 3 * 5).
  def exercise3_perThreadAccumulator(): Int = ???

  // Exercise 4: ThreadLocal.remove()
  // TODO: Create a ThreadLocal[String] with initial "init". Set it to "modified".
  //       Call remove(). Get() should return "init" again (resets to initial value).
  //       Return the value after remove().
  def exercise4_remove(): String = ???

  // Exercise 5: ThreadLocal with custom initial value
  // TODO: Create a ThreadLocal that initializes to Thread.currentThread().getName.
  //       Launch a thread named "worker-thread". Get the ThreadLocal value in that thread.
  //       Return the value (should be "worker-thread").
  def exercise5_customInitial(): String = ???

  // Exercise 6: InheritableThreadLocal
  // TODO: Create an InheritableThreadLocal[String] with initial value "parent".
  //       In main thread, set it to "inherited-value".
  //       Launch a child thread that gets the value (should inherit "inherited-value").
  //       Store in AtomicReference. Return the child's value.
  def exercise6_inheritableThreadLocal(): String = ???

  // Exercise 7: ThreadLocal memory leak awareness
  // TODO: Create a ThreadLocal[Array[Byte]] initialized to null.
  //       In a thread: set a large array (new Array[Byte](1024)), then remove() it.
  //       Return true if remove() was called successfully (demonstrating cleanup pattern).
  //       Use CountDownLatch for coordination.
  def exercise7_cleanupPattern(): Boolean = ???

  // Exercise 8: ThreadLocal for request context pattern
  // TODO: Simulate a request context: Create a ThreadLocal[Map[String, String]] initialized to Map.empty.
  //       In thread "request-1": set context to Map("userId" -> "123", "role" -> "admin").
  //       In thread "request-2": set context to Map("userId" -> "456", "role" -> "user").
  //       Each thread reads its own context and stores the userId in an AtomicReference.
  //       Return the two userIds sorted: should be List("123", "456").
  def exercise8_requestContext(): List[String] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicThreadLocal() == ("default", "main"), "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_isolation() == (100, 0), "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_perThreadAccumulator() == 15, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_remove() == "init", "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_customInitial() == "worker-thread", "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_inheritableThreadLocal() == "inherited-value", "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_cleanupPattern() == true, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_requestContext() == List("123", "456"), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc014_ThreadLocal exercises passed!")
  }
}
