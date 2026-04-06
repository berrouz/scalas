package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent.{Semaphore, CountDownLatch}
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

object Conc007_Semaphore {

  // Exercise 1: Basic Semaphore with 1 permit (binary semaphore)
  // TODO: Create a Semaphore with 1 permit. Launch 10 threads, each acquiring the permit,
  //       incrementing a var counter (protected by the semaphore), and releasing.
  //       Use a CountDownLatch to wait for all threads. Return counter (should be 10).
  def exercise1_binarySemaphore(): Int = ???

  // Exercise 2: Semaphore with multiple permits
  // TODO: Create a Semaphore with 3 permits. Track the max concurrent accesses using
  //       an AtomicInteger for current count and an AtomicInteger for maxSeen.
  //       Launch 10 threads, each acquires, increments current, updates maxSeen if current > maxSeen,
  //       then decrements current and releases. Return true if maxSeen <= 3.
  def exercise2_multiplePermits(): Boolean = ???

  // Exercise 3: tryAcquire
  // TODO: Create a Semaphore with 1 permit. Acquire it in the main thread.
  //       Call tryAcquire() — should return false (no permits available).
  //       Release the permit. Call tryAcquire() again — should return true.
  //       Return (firstTry, secondTry).
  def exercise3_tryAcquire(): (Boolean, Boolean) = ???

  // Exercise 4: availablePermits
  // TODO: Create a Semaphore with 5 permits. Acquire 3. Return availablePermits() (should be 2).
  //       Then release all 3 back. Return final availablePermits() (should be 5).
  //       Return (afterAcquire, afterRelease).
  def exercise4_availablePermits(): (Int, Int) = ???

  // Exercise 5: Fair semaphore
  // TODO: Create a fair Semaphore(1, true). Verify it is fair via isFair().
  //       Return isFair() (should be true).
  def exercise5_fairSemaphore(): Boolean = ???

  // Exercise 6: Resource pool pattern
  // TODO: Simulate a connection pool of size 3 using Semaphore(3).
  //       Launch 6 threads. Each acquires a permit, adds its thread index to a result list
  //       (synchronized), and releases. Use a CountDownLatch to wait for all.
  //       Return result.size (should be 6 — all 6 tasks completed).
  def exercise6_resourcePool(): Int = ???

  // Exercise 7: acquireUninterruptibly
  // TODO: Create a Semaphore(1). Call acquireUninterruptibly() to acquire it.
  //       Verify availablePermits() == 0. Release. Verify availablePermits() == 1.
  //       Return (permitsAfterAcquire, permitsAfterRelease).
  def exercise7_uninterruptible(): (Int, Int) = ???

  // Exercise 8: Rate limiter concept with Semaphore
  // TODO: Simulate a simple rate limiter: Semaphore with 5 permits.
  //       Launch 10 threads. Each thread tries tryAcquire(). Count how many succeed
  //       (using AtomicInteger). Do NOT release permits after acquiring.
  //       Use a CountDownLatch for coordination. Return the count of successful acquires (should be 5).
  def exercise8_rateLimiter(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_binarySemaphore() == 10, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_multiplePermits() == true, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_tryAcquire() == (false, true), "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_availablePermits() == (2, 5), "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_fairSemaphore() == true, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_resourcePool() == 6, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_uninterruptible() == (0, 1), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_rateLimiter() == 5, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc007_Semaphore exercises passed!")
  }
}
