package org.shev4ik.interview.concurrency.level3_advanced

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

object Conc020_STMConcepts {

  // Software Transactional Memory (STM) concepts implemented using atomic references.
  // These exercises simulate STM patterns without requiring an STM library.

  // Exercise 1: TRef (Transactional Reference) concept
  // TODO: Implement a simple TRef[A] class backed by AtomicReference[A].
  //       It should support get() and set(a: A) methods.
  //       Create a TRef[Int](0), set it to 42, get it. Return the value.
  def exercise1_tref(): Int = ???

  // Exercise 2: Atomic transfer between two TRefs
  // TODO: Simulate an atomic transfer between two "accounts" (AtomicInteger).
  //       Account A starts with 100, Account B starts with 50.
  //       Transfer 30 from A to B atomically using synchronized block
  //       (simulating a transaction). Return (a.get(), b.get()) — should be (70, 80).
  def exercise2_atomicTransfer(): (Int, Int) = ???

  // Exercise 3: Retry concept - spin until condition met
  // TODO: Simulate STM "retry" pattern: a thread reads a TRef[Int] and retries
  //       (spins/waits) until the value is > 0. Another thread sets it to 42.
  //       Use AtomicInteger and a CountDownLatch for coordination.
  //       Return the value read after retry succeeds (should be 42).
  def exercise3_retryConcept(): Int = ???

  // Exercise 4: OrElse concept - try alternative
  // TODO: Simulate STM "orElse" pattern: try to read from source1 (AtomicReference[Option[Int]]).
  //       If source1 is None, try source2. If source2 is also None, return -1.
  //       Set source1 = None, source2 = Some(99). Return the result (should be 99).
  def exercise4_orElseConcept(): Int = ???

  // Exercise 5: Composable transactions
  // TODO: Simulate composable transactions: deposit and withdraw functions that operate
  //       on an AtomicInteger balance. Compose them:
  //       balance starts at 100. Deposit 50, then withdraw 30. All in one synchronized block.
  //       Return the final balance (should be 120).
  def exercise5_composable(): Int = ???

  // Exercise 6: Multi-variable transaction
  // TODO: Simulate a transaction that reads and writes multiple variables atomically.
  //       Three AtomicIntegers: x=1, y=2, z=3. Transaction: set x=y+z, y=x+z, z=x+y
  //       using the ORIGINAL values (snapshot). Use synchronized to ensure atomicity.
  //       Return (x, y, z) — should be (5, 4, 3) using original values: x=2+3, y=1+3, z=1+2.
  def exercise6_multiVariable(): (Int, Int, Int) = ???

  // Exercise 7: Optimistic concurrency (version-based)
  // TODO: Implement optimistic concurrency: a value with a version number.
  //       Create a case class Versioned[A](value: A, version: Int) in AtomicReference.
  //       Read version, compute new value, CAS with expected version.
  //       Start with Versioned(10, 0). Update to value * 2 (version 1). Return new value (should be 20).
  def exercise7_optimisticConcurrency(): Int = ???

  // Exercise 8: Concurrent bank transfers with deadlock-free locking
  // TODO: Simulate 3 bank accounts (AtomicIntegers): A=100, B=100, C=100.
  //       Perform transfers concurrently: A->B(10), B->C(20), C->A(30).
  //       Use ordered locking (lock lower-indexed account first) to avoid deadlock.
  //       Return (a, b, c) — total should still be 300.
  //       Expected: A=100-10+30=120, B=100+10-20=90, C=100+20-30=90.
  def exercise8_concurrentTransfers(): (Int, Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_tref() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_atomicTransfer() == (70, 80), "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_retryConcept() == 42, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_orElseConcept() == 99, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_composable() == 120, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_multiVariable() == (5, 4, 3), "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_optimisticConcurrency() == 20, "Exercise 7 failed")
    println("Exercise 7 passed")

    val (a, b, c) = exercise8_concurrentTransfers()
    assert(a + b + c == 300, s"Exercise 8 failed: total is ${a + b + c}, expected 300")
    assert((a, b, c) == (120, 90, 90), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc020_STMConcepts exercises passed!")
  }
}
