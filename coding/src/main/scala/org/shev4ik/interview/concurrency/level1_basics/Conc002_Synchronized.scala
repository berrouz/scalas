package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent.CountDownLatch

/**
 * Concurrency 002 - Java's synchronized Keyword and Monitor Locks
 *
 * =Overview=
 * The `synchronized` keyword is Java/Scala's built-in mechanism for mutual exclusion.
 * Every JVM object has an '''intrinsic lock''' (also called a '''monitor lock'''). When
 * a thread enters a `synchronized` block on an object, it acquires that object's intrinsic
 * lock, and all other threads attempting to synchronize on the same object will block until
 * the lock is released.
 *
 * =How Monitor Locks Work=
 *  - '''Intrinsic lock''': Every JVM object has exactly one monitor. `synchronized(obj) { ... }`
 *    acquires `obj`'s monitor on entry and releases it on exit (including exceptions).
 *  - '''Reentrant''': A thread that already holds a lock can re-enter synchronized blocks
 *    on the same object without deadlocking (the JVM tracks lock hold counts).
 *  - '''Mutual exclusion''': Only one thread can hold a given object's monitor at a time.
 *
 * =Happens-Before Relationship=
 * The Java Memory Model (JMM) guarantees that an unlock on a monitor '''happens-before'''
 * every subsequent lock on that same monitor. This means:
 *  - All writes made by thread A before releasing the lock are visible to thread B after
 *    it acquires the same lock
 *  - Without synchronization (or volatile/@volatile), threads may see stale cached values
 *    due to CPU caching and compiler reordering
 *
 * =wait(), notify(), notifyAll()=
 * These methods (defined on `Object`) work with the intrinsic lock:
 *  - '''wait()''': Releases the lock and suspends the thread until another thread calls
 *    notify/notifyAll on the same object. Must be called inside synchronized.
 *  - '''notify()''': Wakes up one waiting thread (chosen arbitrarily by the JVM).
 *  - '''notifyAll()''': Wakes up ALL waiting threads; they then compete for the lock.
 *  - Always use wait() in a '''while loop''' (not if) to guard against spurious wakeups.
 *
 * =synchronized vs ReentrantLock=
 * {{{
 *   synchronized:
 *   + Simpler syntax, automatic release (even on exception)
 *   + Built into the language -- no extra imports
 *   - Cannot interrupt a thread waiting for a lock
 *   - Cannot attempt to acquire without blocking (no tryLock)
 *   - Cannot use fair ordering
 *
 *   ReentrantLock:
 *   + tryLock(), lockInterruptibly(), fair mode
 *   + Condition objects (multiple wait sets per lock)
 *   + Can be used across methods (lock/unlock are separate calls)
 *   - Must explicitly unlock in a finally block -- error-prone
 *   - Slightly more verbose
 * }}}
 *
 * =WARNING: Modern Scala Best Practice=
 * '''In modern Scala (Cats Effect / ZIO), prefer `Ref` over synchronized.'''
 *  - `cats.effect.Ref[F, A]` and `zio.Ref[A]` provide atomic, lock-free mutable references
 *  - They are '''composable''' -- you can combine multiple Ref operations in a single
 *    atomic transaction (with `Ref.modify` or `STM`)
 *  - They '''do not block threads''' -- critical for non-blocking runtimes like CE/ZIO
 *    where blocking a thread can starve the thread pool
 *  - `synchronized` blocks the carrier thread and is incompatible with fiber-based
 *    concurrency models
 *
 * =Interview Tip=
 * ''"What's the difference between synchronized and ReentrantLock? When would you use each?"''
 *
 * '''Answer:''' `synchronized` is simpler (automatic lock release, no try/finally boilerplate)
 * and sufficient for most cases. Use `ReentrantLock` when you need: (1) tryLock for
 * non-blocking lock attempts, (2) lockInterruptibly for cancellable waiting, (3) fair lock
 * ordering, or (4) multiple `Condition` objects for fine-grained wait/notify patterns.
 * In modern Scala with Cats Effect or ZIO, prefer `Ref` / `STM` which are non-blocking,
 * composable, and compatible with fiber-based concurrency.
 */
object Conc002_Synchronized {

  // Exercise 1: Basic synchronized block
  // TODO: Create a mutable var counter = 0. Launch 10 threads, each incrementing counter
  //       1000 times inside a synchronized(this) block. Join all threads.
  //       Return the final counter value (should be 10000).
  def exercise1_synchronizedIncrement(): Int = ???

  // Exercise 2: Synchronized on a specific lock object
  // TODO: Create a val lock = new Object(). Use synchronized(lock) { ... } to protect
  //       a shared var list = List.empty[Int]. Launch 5 threads, each prepending its
  //       thread index (0-4) to the list. Join all. Return list.sorted.
  def exercise2_lockObject(): List[Int] = ???

  // Exercise 3: Synchronized method
  // TODO: Create a class Counter with a private var count = 0 and a synchronized method
  //       `increment(): Unit` and a synchronized method `get(): Int`.
  //       Launch 100 threads each calling increment() once. Join all. Return counter.get().
  def exercise3_synchronizedMethod(): Int = ???

  // Exercise 4: Protecting a shared collection
  // TODO: Create a var buffer = scala.collection.mutable.ListBuffer.empty[Int].
  //       Launch 10 threads, each adding numbers 1 to 10 to the buffer inside synchronized.
  //       Join all threads. Return buffer.size (should be 100).
  def exercise4_protectedCollection(): Int = ???

  // Exercise 5: wait() and notify()
  // TODO: Implement a simple producer-consumer with wait/notify.
  //       Use a var slot: Option[Int] = None as a single-element buffer.
  //       Producer puts 42 into slot and calls notify(). Consumer waits until slot.isDefined.
  //       Use synchronized on a shared lock for both. Return the consumed value.
  def exercise5_waitNotify(): Int = ???

  // Exercise 6: notifyAll()
  // TODO: Create a shared var ready = false. Launch 3 consumer threads that each wait()
  //       until ready is true, then record their thread name. The main thread sets ready = true
  //       and calls notifyAll(). Join all threads. Return the count of threads that completed (should be 3).
  def exercise6_notifyAll(): Int = ???

  // Exercise 7: Synchronized and double-checked pattern
  // TODO: Implement a simple lazy initialization using synchronized double-check pattern.
  //       Create a @volatile var instance: Option[String] = None.
  //       Method getInstance() should: if instance is None, synchronize and check again,
  //       then set it to Some("initialized"). Return the instance value.
  //       Call getInstance() from 5 threads. All should get the same value.
  //       Return the value (should be "initialized").
  def exercise7_doubleChecked(): String = ???

  // Exercise 8: Deadlock avoidance with lock ordering
  // TODO: Given two lock objects lockA and lockB, and two vars a = 0, b = 0:
  //       Thread 1 increments a then b. Thread 2 increments b then a.
  //       Both must acquire BOTH locks but always in the same order (lockA first, then lockB)
  //       to avoid deadlock. Join both threads. Return (a, b) — both should be 1.
  def exercise8_lockOrdering(): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_synchronizedIncrement() == 10000, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_lockObject() == List(0, 1, 2, 3, 4), "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_synchronizedMethod() == 100, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_protectedCollection() == 100, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_waitNotify() == 42, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_notifyAll() == 3, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_doubleChecked() == "initialized", "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_lockOrdering() == (1, 1), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc002_Synchronized exercises passed!")
  }
}
