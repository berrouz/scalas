package org.shev4ik.interview.testing.level3_advanced

import java.util.concurrent.atomic.{AtomicInteger, AtomicReference, AtomicBoolean}
import java.util.concurrent.{CountDownLatch, CyclicBarrier, TimeUnit}

/**
 * Test017 - Concurrency Testing
 *
 * Race condition detection, deterministic testing, thread-safe assertions,
 * and building concurrency testing utilities.
 */
object Test017_ConcurrencyTesting {

  // ==========================================================================
  // Exercise 1: Implement a thread-safe assertion collector
  // ==========================================================================
  // TODO: Implement `ConcurrentAssertionCollector` that collects assertion results
  //       from multiple threads safely:
  //       - assert_(condition: Boolean, message: String): Unit
  //         (records pass/fail without throwing, thread-safe)
  //       - assertAll(): Boolean  (throws if any assertion failed, with all messages)
  //       - passCount: Int
  //       - failCount: Int
  //       - failures: List[String]  (thread-safe read of all failure messages)
  //       Use AtomicReference or ConcurrentLinkedQueue for thread safety.
  class ConcurrentAssertionCollector {
    def assert_(condition: Boolean, message: String): Unit = ???
    def assertAll(): Boolean = ???
    def passCount: Int = ???
    def failCount: Int = ???
    def failures: List[String] = ???
  }

  // ==========================================================================
  // Exercise 2: Implement a race condition detector
  // ==========================================================================
  // TODO: Implement `RaceDetector` that tries to detect race conditions by running
  //       an operation concurrently many times:
  //       - testForRace[A](numThreads: Int, iterations: Int)(op: => A): RaceResult[A]
  //       RaceResult contains:
  //       - uniqueResults: Set[A]  (all distinct values observed)
  //       - totalRuns: Int
  //       - possibleRace: Boolean  (true if more than one unique result observed)
  //       - exceptions: List[Throwable]  (any exceptions caught)
  //       Use CyclicBarrier to start all threads simultaneously for max contention.
  case class RaceResult[A](
    uniqueResults: Set[A],
    totalRuns: Int,
    possibleRace: Boolean,
    exceptions: List[Throwable]
  )

  def testForRace[A](numThreads: Int, iterations: Int)(op: => A): RaceResult[A] = ???

  // ==========================================================================
  // Exercise 3: Implement a deterministic concurrent scheduler
  // ==========================================================================
  // TODO: Implement `DeterministicScheduler` that executes tasks in a controlled order:
  //       - submit(name: String)(task: => Unit): Unit  (queue a task)
  //       - runNext(): Option[String]  (run the next queued task, return its name)
  //       - runAll(): List[String]  (run all queued tasks in order)
  //       - runInOrder(order: List[String]): List[String]
  //         (run tasks in specified order; skip missing tasks; return actually run)
  //       - pending: List[String]  (names of queued tasks)
  class DeterministicScheduler {
    def submit(name: String)(task: => Unit): Unit = ???
    def runNext(): Option[String] = ???
    def runAll(): List[String] = ???
    def runInOrder(order: List[String]): List[String] = ???
    def pending: List[String] = ???
  }

  // ==========================================================================
  // Exercise 4: Implement a thread interleaving tester
  // ==========================================================================
  // TODO: Implement `InterleavingTester` that tests specific thread interleavings:
  //       - addThread(name: String, steps: List[() => Unit]): Unit
  //       - runInterleaving(order: List[String]): Boolean
  //         (execute one step from the named thread in the given order)
  //         Returns true if all steps complete without error.
  //       - allInterleavings(): List[List[String]]
  //         For 2 threads with m and n steps, generate all possible orderings.
  //         (This is a combinatorial exercise -- return all valid interleavings.)
  class InterleavingTester {
    def addThread(name: String, steps: List[() => Unit]): Unit = ???
    def runInterleaving(order: List[String]): Boolean = ???
    def allInterleavings(): List[List[String]] = ???
  }

  // ==========================================================================
  // Exercise 5: Implement a concurrent data structure tester
  // ==========================================================================
  // TODO: Implement `ConcurrentStructureTester` that verifies thread safety:
  //       - testAtomicity[A](initial: A, operations: List[A => A], expected: A)(
  //           applyOp: (AtomicReference[A], A => A) => Unit): Boolean
  //         Runs all operations concurrently on an AtomicReference, then checks result.
  //       - testLinearizability(
  //           operations: List[(String, () => Any)],
  //           numRuns: Int): LinearizabilityResult
  //         Runs operations concurrently many times, recording all (op, result) pairs.
  //         Returns whether results are consistent with some sequential ordering.
  case class LinearizabilityResult(
    consistent: Boolean,
    runs: Int,
    inconsistencies: List[String]
  )

  def testAtomicity[A](initial: A, operations: List[A => A], expected: A)(
    applyOp: (AtomicReference[A], A => A) => Unit
  ): Boolean = ???

  def testLinearizability(
    operations: List[(String, () => Any)],
    numRuns: Int
  ): LinearizabilityResult = ???

  // ==========================================================================
  // Exercise 6: Implement a deadlock detector
  // ==========================================================================
  // TODO: Implement `DeadlockDetector` that detects potential deadlocks:
  //       - addLockOrder(threadName: String, locks: List[String]): Unit
  //         (records which locks a thread acquires in order)
  //       - detectDeadlock(): Option[DeadlockInfo]
  //         Analyzes lock orders: if thread A acquires lock1 then lock2,
  //         and thread B acquires lock2 then lock1, there's a potential deadlock.
  //       - DeadlockInfo: involved threads, involved locks, cycle description
  case class DeadlockInfo(
    involvedThreads: Set[String],
    involvedLocks: Set[String],
    cycleDescription: String
  )

  class DeadlockDetector {
    def addLockOrder(threadName: String, locks: List[String]): Unit = ???
    def detectDeadlock(): Option[DeadlockInfo] = ???
  }

  // ==========================================================================
  // Exercise 7: Implement a concurrent test harness
  // ==========================================================================
  // TODO: Implement `ConcurrentTestHarness` that orchestrates concurrent tests:
  //       - withConcurrentActors(n: Int)(action: Int => Unit): ConcurrentResult
  //         Creates n threads, each running action(threadIndex), waits for all.
  //       - withSynchronizedStart(n: Int)(action: Int => Unit): ConcurrentResult
  //         Same but all threads start simultaneously (using barrier).
  //       - ConcurrentResult: completed (Int), failed (Int), errors (List), durationMs
  case class ConcurrentResult(
    completed: Int,
    failed: Int,
    errors: List[Throwable],
    durationMs: Long
  )

  def withConcurrentActors(n: Int)(action: Int => Unit): ConcurrentResult = ???
  def withSynchronizedStart(n: Int)(action: Int => Unit): ConcurrentResult = ???

  // ==========================================================================
  // Exercise 8: Implement a stress test framework
  // ==========================================================================
  // TODO: Implement `StressTest` that hammers a function to find concurrency bugs:
  //       - run[A](numThreads: Int, numOps: Int, timeout: Long)(op: => A): StressResult
  //       StressResult:
  //       - opsPerSecond: Double
  //       - totalOps: Int
  //       - errors: List[Throwable]
  //       - uniqueErrorTypes: Set[String]  (distinct exception class names)
  //       - successRate: Double  (0.0 to 1.0)
  //       - durationMs: Long
  case class StressResult(
    opsPerSecond: Double,
    totalOps: Int,
    errors: List[Throwable],
    uniqueErrorTypes: Set[String],
    successRate: Double,
    durationMs: Long
  )

  def stressTest[A](numThreads: Int, numOps: Int, timeoutMs: Long)(op: => A): StressResult = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val collector = new ConcurrentAssertionCollector
    val threads = (1 to 10).map { i =>
      new Thread(() => {
        collector.assert_(i > 0, s"$i should be positive")
        collector.assert_(i <= 10, s"$i should be <= 10")
        collector.assert_(i != 5, s"$i should not be 5")
      })
    }
    threads.foreach(_.start())
    threads.foreach(_.join())
    assert(collector.failCount == 1)
    assert(collector.failures.head.contains("5"))
    println("Exercise 1 passed: concurrent assertion collector works")

    // Exercise 2
    val counter = new AtomicInteger(0)
    val raceResult = testForRace[Int](4, 100) {
      val c = counter.get()
      counter.set(c + 1) // intentionally non-atomic read-modify-write
      c
    }
    // With non-atomic increment, we should see a possible race
    assert(raceResult.totalRuns > 0)
    println("Exercise 2 passed: race condition detection works")

    // Exercise 3
    val scheduler = new DeterministicScheduler
    var log = List.empty[String]
    scheduler.submit("taskA") { log :+= "A" }
    scheduler.submit("taskB") { log :+= "B" }
    scheduler.submit("taskC") { log :+= "C" }
    val ran = scheduler.runInOrder(List("taskC", "taskA", "taskB"))
    assert(ran == List("taskC", "taskA", "taskB"))
    assert(log == List("C", "A", "B"))
    println("Exercise 3 passed: deterministic scheduler works")

    // Exercise 4
    val interleaver = new InterleavingTester
    var trace = List.empty[String]
    interleaver.addThread("T1", List(
      () => { trace :+= "T1-1" },
      () => { trace :+= "T1-2" }
    ))
    interleaver.addThread("T2", List(
      () => { trace :+= "T2-1" }
    ))
    assert(interleaver.runInterleaving(List("T1", "T2", "T1")))
    assert(trace == List("T1-1", "T2-1", "T1-2"))
    // All interleavings for 2+1 steps = C(3,1) = 3
    val allOrders = interleaver.allInterleavings()
    assert(allOrders.length == 3)
    println("Exercise 4 passed: interleaving tester works")

    // Exercise 5
    val atomicResult = testAtomicity[Int](
      initial = 0,
      operations = (1 to 100).map(i => (x: Int) => x + 1).toList,
      expected = 100
    ) { (ref, op) =>
      var done = false
      while (!done) {
        val current = ref.get()
        done = ref.compareAndSet(current, op(current))
      }
    }
    assert(atomicResult)
    println("Exercise 5 passed: concurrent structure testing works")

    // Exercise 6
    val detector = new DeadlockDetector
    detector.addLockOrder("thread1", List("lockA", "lockB"))
    detector.addLockOrder("thread2", List("lockB", "lockA"))
    val deadlock = detector.detectDeadlock()
    assert(deadlock.isDefined)
    assert(deadlock.get.involvedLocks == Set("lockA", "lockB"))
    val noDeadlock = new DeadlockDetector
    noDeadlock.addLockOrder("t1", List("lockA", "lockB"))
    noDeadlock.addLockOrder("t2", List("lockA", "lockB"))
    assert(noDeadlock.detectDeadlock().isEmpty)
    println("Exercise 6 passed: deadlock detection works")

    // Exercise 7
    val concResult = withSynchronizedStart(4) { idx =>
      Thread.sleep(10)
    }
    assert(concResult.completed == 4 && concResult.failed == 0)
    val failResult = withConcurrentActors(3) { idx =>
      if (idx == 1) throw new RuntimeException("fail")
    }
    assert(failResult.failed == 1 && failResult.completed == 2)
    println("Exercise 7 passed: concurrent test harness works")

    // Exercise 8
    val stressResult = stressTest(2, 100, 5000) {
      Thread.sleep(1)
      42
    }
    assert(stressResult.successRate == 1.0)
    assert(stressResult.totalOps >= 100)
    println("Exercise 8 passed: stress testing works")

    println("\nAll Test017 exercises passed!")
  }
}
