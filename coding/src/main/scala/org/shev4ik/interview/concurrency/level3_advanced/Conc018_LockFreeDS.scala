package org.shev4ik.interview.concurrency.level3_advanced

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.{AtomicReference, AtomicInteger, AtomicStampedReference}

object Conc018_LockFreeDS {

  // Exercise 1: Lock-free stack - push
  // TODO: Implement a lock-free stack using AtomicReference[List[Int]] (Treiber stack concept).
  //       push(value): CAS loop to prepend value to the list.
  //       Push 1, 2, 3 sequentially. Return the stack contents as a List (should be List(3, 2, 1)).
  def exercise1_lockFreeStackPush(): List[Int] = ???

  // Exercise 2: Lock-free stack - pop
  // TODO: Implement push and pop for the lock-free stack (AtomicReference[List[Int]]).
  //       pop(): CAS loop to remove and return the head. Returns Option[Int].
  //       Push 1, 2, 3. Pop once. Return (popped, remaining).
  //       Should be (Some(3), List(2, 1)).
  def exercise2_lockFreeStackPop(): (Option[Int], List[Int]) = ???

  // Exercise 3: Lock-free stack concurrent push
  // TODO: Create a lock-free stack (AtomicReference[List[Int]](Nil)).
  //       Launch 10 threads, each pushing their index (0-9) onto the stack.
  //       Join all. Return stack.get().sorted (should be List(0,1,2,3,4,5,6,7,8,9)).
  def exercise3_concurrentPush(): List[Int] = ???

  // Exercise 4: CAS loop for atomic update
  // TODO: Implement an atomicMultiply function: given AtomicInteger, multiply its value by n
  //       using a CAS loop. Start with AtomicInteger(3). Multiply by 7.
  //       Return the result (should be 21).
  def exercise4_casLoopUpdate(): Int = ???

  // Exercise 5: Lock-free counter with CAS
  // TODO: Implement a lock-free counter using AtomicInteger and CAS loops (not incrementAndGet).
  //       Implement increment(): read current, CAS(current, current+1), retry if failed.
  //       Launch 10 threads each incrementing 100 times. Return final value (should be 1000).
  def exercise5_casCounter(): Int = ???

  // Exercise 6: ABA problem demonstration
  // TODO: Demonstrate the ABA problem concept:
  //       Create an AtomicInteger(1). Thread A reads 1 (old value).
  //       Thread B changes 1 -> 2 -> 1 (ABA). Thread A does CAS(1, 3) and succeeds
  //       even though the value changed in between.
  //       Use CountDownLatches for coordination.
  //       Return the final value (should be 3, showing CAS succeeded despite ABA).
  def exercise6_abaProblem(): Int = ???

  // Exercise 7: AtomicStampedReference to solve ABA
  // TODO: Create an AtomicStampedReference[Int](1, 0) (value=1, stamp=0).
  //       Thread A reads value=1, stamp=0.
  //       Thread B: CAS(1,0 -> 2,1), then CAS(2,1 -> 1,2). Value is back to 1 but stamp is 2.
  //       Thread A attempts CAS(1,0 -> 3,1) — should FAIL because stamp is now 2, not 0.
  //       Use CountDownLatches for coordination.
  //       Return (casSucceeded, finalValue) — should be (false, 1).
  def exercise7_stampedReference(): (Boolean, Int) = ???

  // Exercise 8: Lock-free queue concept (Michael-Scott)
  // TODO: Implement a simple lock-free FIFO using AtomicReference[List[Int]].
  //       enqueue(value): CAS loop to append value to the end of the list.
  //       dequeue(): CAS loop to remove and return the head.
  //       Enqueue 1, 2, 3. Dequeue twice. Return (first, second, remaining).
  //       Should be (Some(1), Some(2), List(3)).
  def exercise8_lockFreeQueue(): (Option[Int], Option[Int], List[Int]) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_lockFreeStackPush() == List(3, 2, 1), "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_lockFreeStackPop() == (Some(3), List(2, 1)), "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_concurrentPush() == List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_casLoopUpdate() == 21, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_casCounter() == 1000, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_abaProblem() == 3, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_stampedReference() == (false, 1), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_lockFreeQueue() == (Some(1), Some(2), List(3)), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc018_LockFreeDS exercises passed!")
  }
}
