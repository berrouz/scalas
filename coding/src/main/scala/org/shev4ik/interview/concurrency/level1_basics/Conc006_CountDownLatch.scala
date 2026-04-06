package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent.{CountDownLatch, TimeUnit}
import java.util.concurrent.atomic.{AtomicInteger, AtomicBoolean}

object Conc006_CountDownLatch {

  // Exercise 1: Basic CountDownLatch
  // TODO: Create a CountDownLatch with count = 1. Launch a thread that counts down the latch
  //       after setting an AtomicInteger to 42. In the main thread, await() the latch
  //       and return the AtomicInteger value.
  def exercise1_basicLatch(): Int = ???

  // Exercise 2: Latch with multiple threads
  // TODO: Create a CountDownLatch with count = 5. Launch 5 threads, each incrementing
  //       an AtomicInteger and then calling countDown(). Await the latch in main thread.
  //       Return counter.get() (should be 5).
  def exercise2_multipleCountDown(): Int = ???

  // Exercise 3: Start gate pattern
  // TODO: Create a "start gate" latch with count = 1. Launch 5 threads that each
  //       await the start gate, then increment an AtomicInteger counter.
  //       CountDown the start gate from main to release all threads simultaneously.
  //       Use a "done gate" latch with count = 5 to wait for all threads to finish.
  //       Return counter.get() (should be 5).
  def exercise3_startGate(): Int = ???

  // Exercise 4: await with timeout
  // TODO: Create a CountDownLatch with count = 1 (never counted down).
  //       Call await(100, TimeUnit.MILLISECONDS). It should return false (timeout).
  //       Return the result of await().
  def exercise4_awaitTimeout(): Boolean = ???

  // Exercise 5: getCount
  // TODO: Create a CountDownLatch with count = 3. Call countDown() twice.
  //       Return latch.getCount() (should be 1).
  def exercise5_getCount(): Long = ???

  // Exercise 6: Worker initialization pattern
  // TODO: Simulate 3 "services" starting up. Each service is a thread that does some work
  //       (sets its index in an Array[AtomicBoolean] to true) and counts down a latch.
  //       Main thread awaits the latch, then checks all services are ready.
  //       Return true if all 3 services initialized (all AtomicBooleans are true).
  def exercise6_workerInit(): Boolean = ???

  // Exercise 7: Countdown latch cannot be reused
  // TODO: Create a CountDownLatch(1). Count it down. Verify getCount() is 0.
  //       Count it down again. Verify getCount() is still 0 (latches cannot be reset).
  //       Return latch.getCount() (should be 0).
  def exercise7_cannotReuse(): Long = ???

  // Exercise 8: Coordinated multi-phase work
  // TODO: Phase 1: 3 threads each append their index to a shared synchronized list and count down latch1.
  //       Phase 2: After latch1 completes, 3 more threads double each element in the list and count down latch2.
  //       Await latch2. Return the sorted list.
  //       Hint: Phase 1 produces List(0, 1, 2) (sorted), Phase 2 doubles them to List(0, 2, 4).
  def exercise8_multiPhase(): List[Int] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicLatch() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_multipleCountDown() == 5, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_startGate() == 5, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_awaitTimeout() == false, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_getCount() == 1L, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_workerInit() == true, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_cannotReuse() == 0L, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_multiPhase() == List(0, 2, 4), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc006_CountDownLatch exercises passed!")
  }
}
