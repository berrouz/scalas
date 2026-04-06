package org.shev4ik.interview.concurrency.level3_advanced

import java.util.concurrent._
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference, AtomicBoolean}
import java.util.concurrent.locks.ReentrantLock

object Conc021_ConcurrencyPatterns {

  // Exercise 1: Dining Philosophers (deadlock-free)
  // TODO: Implement 5 dining philosophers using ordered lock acquisition to prevent deadlock.
  //       Each philosopher has a left and right fork (ReentrantLock).
  //       Each philosopher eats 3 times (acquire both forks, increment eatCount, release).
  //       Always acquire the lower-numbered fork first.
  //       Return total eat count across all philosophers (should be 15 = 5 * 3).
  def exercise1_diningPhilosophers(): Int = ???

  // Exercise 2: Readers-Writers problem (readers priority)
  // TODO: Implement readers-writers using ReentrantReadWriteLock.
  //       Shared var data = 0. Launch 3 writers that each write their index (1,2,3) sequentially.
  //       After writers finish (CountDownLatch), launch 5 readers that read data.
  //       All readers should see the same value (3, the last write).
  //       Return the sum of reader results (should be 15 = 5 * 3).
  def exercise2_readersWriters(): Int = ???

  // Exercise 3: Producer-Consumer with bounded buffer
  // TODO: Implement a bounded buffer of size 5 using ArrayBlockingQueue.
  //       Launch 2 producers, each producing 10 items (integers 1-10).
  //       Launch 2 consumers, each consuming 10 items and adding to AtomicInteger sum.
  //       Return sum.get() (should be 2 * (1+2+...+10) = 110).
  def exercise3_producerConsumerBounded(): Int = ???

  // Exercise 4: Double-checked locking singleton
  // TODO: Implement a singleton using double-checked locking pattern.
  //       @volatile var instance: Option[String] = None.
  //       getInstance(): if None, synchronized { if still None, set to Some("singleton") }.
  //       Launch 10 threads all calling getInstance(). Collect results.
  //       All should get "singleton". Return true if all 10 got the same value.
  def exercise4_doubleCheckedLocking(): Boolean = ???

  // Exercise 5: Producer-Consumer with poison pill
  // TODO: Create a LinkedBlockingQueue[Int]. Producer puts 1, 2, 3, 4, 5, then -1 (poison pill).
  //       Consumer takes items until it sees -1, summing all non-poison items.
  //       Return the sum (should be 15).
  def exercise5_poisonPill(): Int = ???

  // Exercise 6: Thread pool with work queue
  // TODO: Create a ThreadPoolExecutor with coreSize=2, maxSize=4, keepAlive=1s,
  //       and a LinkedBlockingQueue[Runnable](10) as the work queue.
  //       Submit 8 tasks, each incrementing an AtomicInteger.
  //       Shutdown and await termination. Return counter.get() (should be 8).
  def exercise6_threadPoolWorkQueue(): Int = ???

  // Exercise 7: Barrier-based parallel computation
  // TODO: Use CyclicBarrier to coordinate a parallel matrix row sum.
  //       Given a 3x3 matrix as Array[Array[Int]], launch 3 threads.
  //       Each thread sums one row and stores in results[i].
  //       After all threads pass the barrier, main thread sums all row sums.
  //       Matrix: [[1,2,3],[4,5,6],[7,8,9]]. Return total sum (should be 45).
  def exercise7_barrierComputation(): Int = ???

  // Exercise 8: Pipeline pattern
  // TODO: Implement a 3-stage pipeline using blocking queues:
  //       Stage 1: reads from input queue, multiplies by 2, puts to stage2 queue.
  //       Stage 2: reads from stage2 queue, adds 10, puts to stage3 queue.
  //       Stage 3: reads from stage3 queue, adds to result AtomicInteger.
  //       Input: 1, 2, 3, 4, 5 (then poison pill -1 for each stage).
  //       Expected per item: (x * 2) + 10. Sum = 12+14+16+18+20 = 80.
  //       Return result.get().
  def exercise8_pipeline(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_diningPhilosophers() == 15, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_readersWriters() == 15, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_producerConsumerBounded() == 110, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_doubleCheckedLocking() == true, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_poisonPill() == 15, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_threadPoolWorkQueue() == 8, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_barrierComputation() == 45, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_pipeline() == 80, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc021_ConcurrencyPatterns exercises passed!")
  }
}
