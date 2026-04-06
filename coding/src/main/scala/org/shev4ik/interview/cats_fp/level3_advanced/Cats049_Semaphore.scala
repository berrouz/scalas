package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 049 - Semaphore (Modeled as concept)
 *
 * Semaphore is a concurrency primitive that controls access to shared resources.
 * It maintains a count of permits. acquire decrements, release increments.
 * This models cats-effect Semaphore concepts using a simplified implementation.
 */
object Cats049_Semaphore {

  // Simplified Semaphore model
  // In real code, use cats.effect.concurrent.Semaphore
  class SimpleSemaphore(private var permits: Long) {
    def available: Long = synchronized(permits)

    def acquire(): Unit = synchronized {
      while (permits <= 0) wait()
      permits -= 1
    }

    def release(): Unit = synchronized {
      permits += 1
      notifyAll()
    }

    def tryAcquire(): Boolean = synchronized {
      if (permits > 0) { permits -= 1; true }
      else false
    }

    def withPermit[A](f: => A): A = {
      acquire()
      try f
      finally release()
    }
  }

  object SimpleSemaphore {
    def apply(permits: Long): SimpleSemaphore = new SimpleSemaphore(permits)
  }

  var eventLog: List[String] = Nil
  def resetLog(): Unit = { eventLog = Nil }
  def log(msg: String): Unit = synchronized { eventLog = eventLog :+ msg }

  // Exercise 1: Semaphore creation - create a semaphore with N permits
  // TODO: Create a semaphore with 3 permits.
  def exercise1_create(): SimpleSemaphore = {
    // Create a semaphore with 3 permits
    ???
  }

  // Exercise 2: acquire - acquire a permit from the semaphore
  // TODO: Acquire a permit and observe the count decrease.
  def exercise2_acquire(): (Long, Long) = {
    val sem = SimpleSemaphore(3)
    val before = sem.available

    // Acquire one permit
    ???

    val after = sem.available
    (before, after)
  }

  // Exercise 3: release - release a permit back to the semaphore
  // TODO: Release a permit and observe the count increase.
  def exercise3_release(): (Long, Long) = {
    val sem = SimpleSemaphore(1)
    sem.acquire() // take the one permit
    val before = sem.available

    // Release the permit
    ???

    val after = sem.available
    (before, after)
  }

  // Exercise 4: withPermit - acquire, run computation, release automatically
  // TODO: Use withPermit for safe acquire/release around a computation.
  def exercise4_withPermit(): (String, Long) = {
    val sem = SimpleSemaphore(1)

    // Use withPermit to run a computation
    // Inside: return "computed", outside: verify permit was released
    val result: String = ???

    (result, sem.available)
  }

  // Exercise 5: Rate limiting - use Semaphore to limit concurrent access
  // TODO: Model rate limiting with a semaphore.
  def exercise5_rateLimiting(): List[String] = {
    resetLog()
    val sem = SimpleSemaphore(2) // max 2 concurrent operations

    def limitedOperation(id: Int): String = {
      sem.withPermit {
        log(s"op-$id-start")
        val result = s"result-$id"
        log(s"op-$id-end")
        result
      }
    }

    // Run 3 operations with rate limiting
    // (in this simplified model they run sequentially)
    ???
  }

  // Exercise 6: Mutual exclusion - use Semaphore(1) as a mutex
  // TODO: Use a semaphore with 1 permit as a mutual exclusion lock.
  def exercise6_mutex(): Int = {
    val mutex = SimpleSemaphore(1)
    var sharedCounter = 0

    def safeIncrement(): Unit = {
      // Use the mutex to safely increment the shared counter
      ???
    }

    // Increment 5 times
    (1 to 5).foreach(_ => safeIncrement())

    sharedCounter
  }

  // Exercise 7: Resource pool - use Semaphore to manage a pool of resources
  // TODO: Model a resource pool with bounded access using Semaphore.
  def exercise7_resourcePool(): List[String] = {
    resetLog()
    val poolSize = 3
    val pool = SimpleSemaphore(poolSize)
    val resources = (1 to poolSize).map(i => s"resource-$i").toArray
    var nextResource = 0

    def borrowResource[A](f: String => A): A = {
      pool.withPermit {
        val idx = synchronized {
          val i = nextResource
          nextResource = (nextResource + 1) % poolSize
          i
        }
        val resource = resources(idx)
        log(s"borrowed-$resource")
        val result = f(resource)
        log(s"returned-$resource")
        result
      }
    }

    // Borrow and use resources
    val results = (1 to 3).map(i => borrowResource(r => s"used-$r-for-task-$i")).toList

    // Return the results
    ???
  }

  // Exercise 8: tryAcquire - non-blocking attempt to acquire a permit
  // TODO: Use tryAcquire to attempt non-blocking permit acquisition.
  def exercise8_tryAcquire(): (Boolean, Boolean, Boolean) = {
    val sem = SimpleSemaphore(1)

    // First try should succeed
    val first: Boolean = ???

    // Second try should fail (no permits left)
    val second: Boolean = ???

    // Release, then third try should succeed
    sem.release()
    val third: Boolean = ???

    (first, second, third)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_create()
    assert(r1.available == 3, s"Exercise 1 failed: ${r1.available}")
    println(s"Exercise 1 passed: Semaphore(3) => available=${r1.available}")

    // Exercise 2
    val (r2before, r2after) = exercise2_acquire()
    assert(r2before == 3 && r2after == 2, s"Exercise 2 failed: before=$r2before, after=$r2after")
    println(s"Exercise 2 passed: acquire => before=$r2before, after=$r2after")

    // Exercise 3
    val (r3before, r3after) = exercise3_release()
    assert(r3before == 0 && r3after == 1, s"Exercise 3 failed: before=$r3before, after=$r3after")
    println(s"Exercise 3 passed: release => before=$r3before, after=$r3after")

    // Exercise 4
    val (r4result, r4avail) = exercise4_withPermit()
    assert(r4result == "computed" && r4avail == 1, s"Exercise 4 failed: result=$r4result, avail=$r4avail")
    println(s"Exercise 4 passed: withPermit => result=$r4result, available=$r4avail")

    // Exercise 5
    val r5 = exercise5_rateLimiting()
    assert(r5.size == 3, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: rate limiting => $r5, log=$eventLog")

    // Exercise 6
    val r6 = exercise6_mutex()
    assert(r6 == 5, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: mutex => counter=$r6")

    // Exercise 7
    val r7 = exercise7_resourcePool()
    assert(r7.size == 3, s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: resource pool => $r7, log=$eventLog")

    // Exercise 8
    val (r8a, r8b, r8c) = exercise8_tryAcquire()
    assert(r8a && !r8b && r8c, s"Exercise 8 failed: first=$r8a, second=$r8b, third=$r8c")
    println(s"Exercise 8 passed: tryAcquire => first=$r8a, second=$r8b, third=$r8c")

    println("\nAll Cats049_Semaphore exercises passed!")
  }
}
