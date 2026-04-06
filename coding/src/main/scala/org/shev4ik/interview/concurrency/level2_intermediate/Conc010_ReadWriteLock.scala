package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantReadWriteLock

object Conc010_ReadWriteLock {

  // Exercise 1: Basic ReadWriteLock - write lock
  // TODO: Create a ReentrantReadWriteLock. Use the write lock to protect a var counter.
  //       Launch 10 threads, each incrementing counter 100 times under write lock.
  //       Join all. Return counter (should be 1000).
  def exercise1_writeLock(): Int = ???

  // Exercise 2: Read lock allows concurrent readers
  // TODO: Create a ReentrantReadWriteLock and a var data = "hello".
  //       Launch 5 reader threads that each acquire the read lock and read data.
  //       Use an AtomicInteger to track how many readers successfully read.
  //       Use a CountDownLatch for coordination. Return count (should be 5).
  def exercise2_concurrentReaders(): Int = ???

  // Exercise 3: Write lock is exclusive
  // TODO: Create a ReentrantReadWriteLock. Acquire the write lock in main thread.
  //       Launch a thread that tries to acquire the read lock with tryLock().
  //       It should fail (return false) because write lock is held.
  //       Release write lock. Return the tryLock result (should be false).
  def exercise3_writeExcludesRead(): Boolean = ???

  // Exercise 4: Read lock excludes writers
  // TODO: Create a ReentrantReadWriteLock. Acquire the read lock in main thread.
  //       Launch a thread that tries writeLock().tryLock(). Should return false.
  //       Release read lock. Return the tryLock result.
  def exercise4_readExcludesWrite(): Boolean = ???

  // Exercise 5: getReadLockCount
  // TODO: Create a ReentrantReadWriteLock. Acquire read lock twice (reentrant).
  //       Return rwLock.getReadHoldCount() (should be 2). Unlock both.
  def exercise5_readHoldCount(): Int = ???

  // Exercise 6: Cache pattern with ReadWriteLock
  // TODO: Implement a simple cache: var cache = Map.empty[String, Int].
  //       Use read lock for get(), write lock for put().
  //       put("a", 1), put("b", 2), get("a") should return Some(1).
  //       Return (get("a"), get("b"), get("c")) — should be (Some(1), Some(2), None).
  def exercise6_cachePattern(): (Option[Int], Option[Int], Option[Int]) = ???

  // Exercise 7: Write lock hold count
  // TODO: Create a ReentrantReadWriteLock. Acquire write lock twice (reentrant).
  //       Return getWriteHoldCount() (should be 2). Unlock both.
  def exercise7_writeHoldCount(): Int = ???

  // Exercise 8: Concurrent read/write scenario
  // TODO: Create a ReentrantReadWriteLock protecting a var data = 0.
  //       Launch 3 writer threads, each setting data to their index (1, 2, 3) under write lock.
  //       After all writers complete (use CountDownLatch), launch 5 reader threads that
  //       each read data under read lock and add it to an AtomicInteger sum.
  //       The data should be 3 (last writer). Return sum.get() (should be 15 = 5 * 3).
  def exercise8_concurrentReadWrite(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_writeLock() == 1000, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_concurrentReaders() == 5, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_writeExcludesRead() == false, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_readExcludesWrite() == false, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_readHoldCount() == 2, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_cachePattern() == (Some(1), Some(2), None), "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_writeHoldCount() == 2, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_concurrentReadWrite() == 15, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc010_ReadWriteLock exercises passed!")
  }
}
