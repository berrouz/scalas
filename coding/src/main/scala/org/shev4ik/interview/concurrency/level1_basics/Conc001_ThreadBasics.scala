package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger

/**
 * Conc 001 - JVM Thread Basics: creation, lifecycle, and low-level thread management.
 *
 * === Java Thread Model ===
 *
 * In the JVM, each java.lang.Thread maps 1:1 to an OS (kernel) thread (on most platforms,
 * via POSIX pthreads on Linux/macOS or Windows threads). This means:
 *   - Thread creation is expensive (~1MB stack allocation + OS overhead).
 *   - Context switching between threads is managed by the OS scheduler.
 *   - The number of concurrent threads is limited by OS resources (typically thousands,
 *     not millions).
 *
 * This is why modern Scala uses lightweight fibers (ZIO Fiber, Cats Effect Fiber) which
 * multiplex many fibers onto a small pool of OS threads (M:N threading model).
 *
 * === JVM Thread Lifecycle (java.lang.Thread.State) ===
 *
 *   NEW          -> Thread object created but start() not yet called.
 *   RUNNABLE     -> Thread is executing or ready to execute (OS may or may not be
 *                   scheduling it right now).
 *   BLOCKED      -> Thread is waiting to acquire a monitor lock (synchronized block).
 *   WAITING      -> Thread is waiting indefinitely (Object.wait(), Thread.join(),
 *                   LockSupport.park()).
 *   TIMED_WAITING -> Thread is waiting with a timeout (Thread.sleep(ms), Object.wait(ms),
 *                    Thread.join(ms)).
 *   TERMINATED   -> Thread's run() method has completed (normally or via exception).
 *
 * === Interview Context ===
 *
 * While direct thread manipulation is rare in modern Scala (we use ZIO/CE fibers),
 * understanding the JVM thread model is crucial for:
 *   - Debugging thread dumps and deadlocks in production.
 *   - Understanding what fibers abstract over (and their limitations).
 *   - Configuring thread pool sizes for blocking vs. CPU-bound work.
 *   - Answering interview questions about concurrency fundamentals.
 */
object Conc001_ThreadBasics {

  // Exercise 1: Create and start a thread using Runnable
  // TODO: Create a Thread that sets the AtomicInteger `result` to 42 using a Runnable.
  //       Start the thread and join it. Return result.get().
  def exercise1_runnableThread(): Int = ???

  // Exercise 2: Create a thread by extending Thread
  // TODO: Create a class (or anonymous class) that extends Thread, overrides run(),
  //       and appends "hello" to the given StringBuilder. Start and join the thread.
  //       Return sb.toString.
  def exercise2_extendThread(): String = ???

  // Exercise 3: Thread.join() for ordering
  // TODO: Create two threads. Thread A sets result to 1, Thread B reads result and adds 1.
  //       Use join() to ensure A completes before B starts.
  //       Return the final value of result (should be 2).
  def exercise3_joinOrdering(): Int = ???

  // Exercise 4: Multiple threads incrementing a counter
  // TODO: Create 10 threads, each incrementing an AtomicInteger counter 1000 times.
  //       Start all threads, join all threads. Return counter.get() (should be 10000).
  // Note: AtomicInteger.incrementAndGet() is thread-safe because it uses CAS
  // (Compare-And-Swap) operations, not locks. CAS is a CPU-level atomic instruction
  // that reads the current value, computes the new value, and writes it back only if
  // the current value hasn't changed since the read. If another thread modified it
  // in between, the CAS fails and retries (spin loop). This is lock-free and typically
  // faster than synchronized blocks under moderate contention.
  def exercise4_multipleThreads(): Int = ???

  // Exercise 5: Thread.currentThread() and getName
  // TODO: Create a thread with name "worker-1". Inside the thread, store
  //       Thread.currentThread().getName into the AtomicReference.
  //       Start and join. Return the stored name.
  def exercise5_threadName(): String = ???

  // Exercise 6: isDaemon / setDaemon
  // TODO: Create a thread, set it as a daemon thread using setDaemon(true) BEFORE starting.
  //       Return thread.isDaemon after setting it.
  def exercise6_daemonThread(): Boolean = ???

  // Exercise 7: Thread.sleep and isAlive
  // TODO: Create a thread that uses a CountDownLatch to signal it has started,
  //       then waits on a second latch before finishing.
  //       After the first latch is released, check thread.isAlive (should be true).
  //       Then release the second latch, join the thread, and check isAlive again (should be false).
  //       Return (aliveWhileRunning, aliveAfterJoin).
  def exercise7_isAlive(): (Boolean, Boolean) = ???

  // Exercise 8: Thread priority
  // TODO: Create two threads. Set one to Thread.MAX_PRIORITY and the other to Thread.MIN_PRIORITY.
  //       Return a tuple of their priorities: (maxPriorityThread.getPriority, minPriorityThread.getPriority).
  //       Note: priority is a hint to the scheduler and may not affect execution order.
  def exercise8_threadPriority(): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_runnableThread() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_extendThread() == "hello", "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_joinOrdering() == 2, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_multipleThreads() == 10000, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_threadName() == "worker-1", "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_daemonThread() == true, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_isAlive() == (true, false), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_threadPriority() == (Thread.MAX_PRIORITY, Thread.MIN_PRIORITY), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc001_ThreadBasics exercises passed!")
  }
}
