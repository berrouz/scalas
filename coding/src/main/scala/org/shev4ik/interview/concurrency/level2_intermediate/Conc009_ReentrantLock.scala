package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.{ReentrantLock, Condition}
import java.util.concurrent.TimeUnit

object Conc009_ReentrantLock {

  // Exercise 1: Basic ReentrantLock
  // TODO: Create a ReentrantLock. Use lock()/unlock() in a try-finally block to protect
  //       a shared var counter. Launch 10 threads each incrementing counter 1000 times.
  //       Join all. Return counter (should be 10000).
  def exercise1_basicLock(): Int = ???

  // Exercise 2: tryLock
  // TODO: Create a ReentrantLock. Acquire it in the main thread.
  //       Launch a thread that calls tryLock() and stores the result in an AtomicBoolean.
  //       Join the thread. Unlock from main. Return the tryLock result (should be false).
  def exercise2_tryLock(): Boolean = ???

  // Exercise 3: tryLock with timeout
  // TODO: Create a ReentrantLock. Acquire it in the main thread.
  //       Launch a thread that calls tryLock(100, TimeUnit.MILLISECONDS).
  //       The thread should timeout and return false. Join. Unlock from main.
  //       Return the tryLock result (should be false).
  def exercise3_tryLockTimeout(): Boolean = ???

  // Exercise 4: Lock is reentrant
  // TODO: Create a ReentrantLock. In a single thread, call lock() twice (reentrant acquisition).
  //       Check getHoldCount() after second lock (should be 2).
  //       Unlock twice. Return holdCount before unlocking.
  def exercise4_reentrant(): Int = ???

  // Exercise 5: Condition - signal and await
  // TODO: Create a ReentrantLock and a Condition via lock.newCondition().
  //       Create a var ready = false. Launch a thread that locks, sets ready = true,
  //       signals the condition, and unlocks. Main thread locks, awaits the condition
  //       while !ready, then unlocks. Return ready (should be true).
  def exercise5_condition(): Boolean = ???

  // Exercise 6: Condition - producer consumer
  // TODO: Implement a bounded buffer of size 1 using ReentrantLock with two Conditions:
  //       notEmpty and notFull. Producer puts 42, consumer takes it.
  //       Return the consumed value.
  def exercise6_conditionProducerConsumer(): Int = ???

  // Exercise 7: Fair lock
  // TODO: Create a fair ReentrantLock(true). Verify isFair() returns true.
  //       Use it to protect a counter incremented by 5 threads (100 times each).
  //       Return (isFair, counter) — should be (true, 500).
  def exercise7_fairLock(): (Boolean, Int) = ???

  // Exercise 8: isLocked and isHeldByCurrentThread
  // TODO: Create a ReentrantLock. Before locking: isLocked should be false.
  //       Lock it: isLocked should be true, isHeldByCurrentThread should be true.
  //       Unlock. Return (lockedBefore, lockedAfter, heldByCurrent).
  def exercise8_lockState(): (Boolean, Boolean, Boolean) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicLock() == 10000, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_tryLock() == false, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_tryLockTimeout() == false, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_reentrant() == 2, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_condition() == true, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_conditionProducerConsumer() == 42, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_fairLock() == (true, 500), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_lockState() == (false, true, true), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc009_ReentrantLock exercises passed!")
  }
}
