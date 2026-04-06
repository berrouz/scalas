package org.shev4ik.interview.concurrency.level1_basics

import java.util.concurrent._
import java.util.concurrent.atomic.AtomicInteger

object Conc008_BlockingQueue {

  // Exercise 1: ArrayBlockingQueue basics
  // TODO: Create an ArrayBlockingQueue[Int] with capacity 5.
  //       Put values 1, 2, 3 into the queue. Return the queue size (should be 3).
  def exercise1_arrayBlockingQueue(): Int = ???

  // Exercise 2: put and take
  // TODO: Create an ArrayBlockingQueue[String] with capacity 1.
  //       Launch a producer thread that puts "message" into the queue.
  //       In the main thread, take() from the queue. Return the taken value.
  def exercise2_putAndTake(): String = ???

  // Exercise 3: offer and poll
  // TODO: Create an ArrayBlockingQueue[Int] with capacity 2.
  //       offer(1) and offer(2) — both should return true.
  //       offer(3) — should return false (queue full).
  //       poll() — should return 1. poll() — should return 2.
  //       Return (offer1, offer2, offer3, poll1, poll2).
  def exercise3_offerAndPoll(): (Boolean, Boolean, Boolean, Int, Int) = ???

  // Exercise 4: LinkedBlockingQueue
  // TODO: Create an unbounded LinkedBlockingQueue[Int].
  //       Put values 1 to 100. Return the queue size (should be 100).
  def exercise4_linkedBlockingQueue(): Int = ???

  // Exercise 5: Producer-Consumer pattern
  // TODO: Create an ArrayBlockingQueue[Int] with capacity 10.
  //       Launch a producer thread that puts numbers 1 to 20 into the queue.
  //       Launch a consumer thread that takes 20 items and sums them using AtomicInteger.
  //       Join both threads. Return the sum (should be 210).
  def exercise5_producerConsumer(): Int = ???

  // Exercise 6: Multiple producers, single consumer
  // TODO: Create an ArrayBlockingQueue[Int] with capacity 5.
  //       Launch 3 producer threads, each putting 10 items (value = 1) into the queue.
  //       Launch 1 consumer thread that takes 30 items and counts them with AtomicInteger.
  //       Join all threads. Return counter.get() (should be 30).
  def exercise6_multiProducerSingleConsumer(): Int = ???

  // Exercise 7: poll with timeout
  // TODO: Create an empty ArrayBlockingQueue[Int] with capacity 5.
  //       Call poll(100, TimeUnit.MILLISECONDS). Since queue is empty and times out,
  //       it should return null. Return true if result is null.
  def exercise7_pollTimeout(): Boolean = ???

  // Exercise 8: drainTo
  // TODO: Create an ArrayBlockingQueue[Int] with capacity 10. Put values 1, 2, 3, 4, 5.
  //       Create a java.util.ArrayList[Int]. Call queue.drainTo(arrayList).
  //       Return the size of the arrayList (should be 5) and queue.size (should be 0).
  //       Return (arrayListSize, queueSize).
  def exercise8_drainTo(): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_arrayBlockingQueue() == 3, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_putAndTake() == "message", "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_offerAndPoll() == (true, true, false, 1, 2), "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_linkedBlockingQueue() == 100, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_producerConsumer() == 210, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_multiProducerSingleConsumer() == 30, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_pollTimeout() == true, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_drainTo() == (5, 0), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc008_BlockingQueue exercises passed!")
  }
}
