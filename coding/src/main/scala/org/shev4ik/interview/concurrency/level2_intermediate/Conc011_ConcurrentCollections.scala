package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent._
import java.util.concurrent.atomic.AtomicInteger
import scala.jdk.CollectionConverters._

object Conc011_ConcurrentCollections {

  // Exercise 1: ConcurrentHashMap basics
  // TODO: Create a ConcurrentHashMap[String, Int]. Put ("a", 1), ("b", 2), ("c", 3).
  //       Return the size (should be 3).
  def exercise1_concurrentHashMap(): Int = ???

  // Exercise 2: ConcurrentHashMap putIfAbsent
  // TODO: Create a ConcurrentHashMap[String, Int]. Put ("key", 10).
  //       Call putIfAbsent("key", 20) — should return 10 (existing value).
  //       Call putIfAbsent("key2", 30) — should return null (was absent).
  //       Return (map.get("key"), map.get("key2")) — should be (10, 30).
  def exercise2_putIfAbsent(): (Int, Int) = ???

  // Exercise 3: ConcurrentHashMap concurrent access
  // TODO: Create a ConcurrentHashMap[String, AtomicInteger].
  //       Launch 10 threads, each calling computeIfAbsent("counter", _ => new AtomicInteger(0))
  //       and then incrementing the AtomicInteger. Join all threads.
  //       Return map.get("counter").get() (should be 10).
  def exercise3_concurrentAccess(): Int = ???

  // Exercise 4: CopyOnWriteArrayList
  // TODO: Create a CopyOnWriteArrayList[Int]. Add 1, 2, 3.
  //       Launch 5 reader threads that sum all elements (should be 6 each time).
  //       Use a CountDownLatch for coordination. Return the size (should be 3).
  def exercise4_copyOnWriteList(): Int = ???

  // Exercise 5: CopyOnWriteArrayList iteration safety
  // TODO: Create a CopyOnWriteArrayList[Int] with elements 1, 2, 3.
  //       Get an iterator. Then add element 4 to the list.
  //       Iterate using the previously obtained iterator and collect elements.
  //       The iterator should see the snapshot (1, 2, 3) — not 4.
  //       Return (iteratorElements, listSize) — should be (List(1,2,3), 4).
  def exercise5_iterationSafety(): (List[Int], Int) = ???

  // Exercise 6: ConcurrentLinkedQueue
  // TODO: Create a ConcurrentLinkedQueue[Int]. Launch 5 producer threads, each offering
  //       numbers 1 to 4. Then poll all elements and sum them.
  //       Return the sum (should be 5 * (1+2+3+4) = 50).
  def exercise6_concurrentLinkedQueue(): Int = ???

  // Exercise 7: ConcurrentHashMap compute
  // TODO: Create a ConcurrentHashMap[String, Int]. Use compute("key", (_, v) => ...)
  //       to set "key" to 1 if null, or increment by 1 if present. Call compute 5 times.
  //       Return map.get("key") (should be 5).
  def exercise7_compute(): Int = ???

  // Exercise 8: ConcurrentHashMap forEach
  // TODO: Create a ConcurrentHashMap with ("a", 1), ("b", 2), ("c", 3).
  //       Use forEach(1, ...) to sum all values into an AtomicInteger.
  //       Return the sum (should be 6).
  def exercise8_forEach(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_concurrentHashMap() == 3, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_putIfAbsent() == (10, 30), "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_concurrentAccess() == 10, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_copyOnWriteList() == 3, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_iterationSafety() == (List(1, 2, 3), 4), "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_concurrentLinkedQueue() == 50, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_compute() == 5, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_forEach() == 6, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc011_ConcurrentCollections exercises passed!")
  }
}
