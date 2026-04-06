package org.shev4ik.interview.algorithms.level4_expert

import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

/**
 * Concurrent Data Structures - lock-free and thread-safe algorithms.
 *
 * Key concepts:
 * - Compare-and-swap (CAS) as the fundamental primitive
 * - Lock-free queues, stacks, linked lists
 * - ABA problem and solutions (stamped references)
 * - Memory ordering and visibility
 */
object Algo123_ConcurrentDS {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Concurrent queue (lock-free concept)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a lock-free queue using CAS operations.
   *       Use a linked list with atomic head and tail pointers.
   *       Enqueue: CAS tail.next from null to newNode, then advance tail.
   *       Dequeue: CAS head to head.next, return head.next.value.
   *       For testing: enqueue elements, dequeue them, verify FIFO order.
   *       Return elements in dequeue order.
   *
   * @param elements elements to enqueue
   * @return elements in dequeue order (should be same order = FIFO)
   */
  def lockFreeQueueOps(elements: List[Int]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Concurrent stack (Treiber stack)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a Treiber stack (lock-free stack using CAS).
   *       Push: create new node pointing to current top, CAS top.
   *       Pop: read top, CAS top to top.next, return old top value.
   *       For testing: push elements, pop all, verify LIFO order.
   *       Return elements in pop order.
   *
   * @param elements elements to push
   * @return elements in pop order (should be reverse = LIFO)
   */
  def treiberStackOps(elements: List[Int]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Concurrent hash map concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simple concurrent hash map with striped locking.
   *       Use an array of buckets, each bucket has its own lock.
   *       Operations: put(key, value), get(key), remove(key).
   *       Number of stripes = concurrencyLevel.
   *       For testing: perform concurrent puts and gets.
   *       Return map contents as sorted list of (key, value) pairs.
   *
   * @param operations list of ("put"/"get"/"remove", key, value) operations
   * @param numBuckets number of hash buckets
   * @return final contents as sorted list of (key, value)
   */
  def concurrentHashMapOps(operations: List[(String, Int, Int)], numBuckets: Int): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Compare-and-swap implementation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a lock-free counter using AtomicInteger and CAS.
   *       incrementAndGet: loop { read old; if CAS(old, old+1) return old+1 }
   *       Simulate concurrent increments from multiple "threads"
   *       (sequentially but verifying CAS logic).
   *       Return final counter value after n increments.
   *
   * @param initial initial counter value
   * @param increments number of increments to perform
   * @return final counter value
   */
  def casCounter(initial: Int, increments: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: ABA problem demonstration
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Demonstrate the ABA problem and its solution.
   *       ABA: thread reads A, another changes A->B->A, first thread's
   *       CAS succeeds but semantics are wrong.
   *       Solution: use a version stamp (AtomicStampedReference concept).
   *       Simulate: perform operations that would trigger ABA,
   *       show that stamped CAS correctly detects the change.
   *       Return (naiveCasSucceeds, stampedCasSucceeds).
   *       Naive CAS incorrectly succeeds; stamped CAS correctly fails.
   *
   * @return (naive CAS result on ABA, stamped CAS result on ABA)
   */
  def abaProblemDemo(): (Boolean, Boolean) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Lock-free linked list concept (Harris list)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified lock-free sorted linked list.
   *       Use logical deletion: mark a node before physically removing.
   *       Insert: find position, CAS next pointer.
   *       Delete: mark node (CAS), then physically remove.
   *       Contains: traverse, skip marked nodes.
   *       For testing: insert elements, delete some, list remaining.
   *       Return sorted list of remaining elements.
   *
   * @param inserts  elements to insert
   * @param deletes  elements to delete
   * @return sorted list of remaining elements
   */
  def lockFreeListOps(inserts: List[Int], deletes: List[Int]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Concurrent skip list concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified concurrent skip list.
   *       Random levels for each node, lock-based or lock-free insertion.
   *       Support: add, contains, remove.
   *       For testing: add elements, check containment, remove, verify.
   *       Return (containsResults before removal, sorted remaining elements).
   *
   * @param elements      elements to add
   * @param searchFor     elements to search for
   * @param toRemove      elements to remove
   * @return (list of contains results for searchFor, sorted remaining elements)
   */
  def concurrentSkipListOps(
    elements: List[Int],
    searchFor: List[Int],
    toRemove: List[Int]
  ): (List[Boolean], List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Memory ordering concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Demonstrate the need for memory ordering/barriers.
   *       Simulate a producer-consumer scenario where:
   *       - Producer sets data, then sets ready flag (with barrier)
   *       - Consumer reads ready flag, then reads data
   *       Without proper ordering, consumer might see stale data.
   *       Use @volatile or Atomic operations to ensure visibility.
   *       Return (consumerSeesCorrectData: Boolean, explanation: String).
   *
   * @param data  the data value to publish
   * @return (true if consumer sees correct data, explanation)
   */
  def memoryOrderingDemo(data: Int): (Boolean, String) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val qResult = lockFreeQueueOps(List(1, 2, 3, 4, 5))
    assert(qResult == List(1, 2, 3, 4, 5), s"Expected FIFO order, got $qResult")
    println("Exercise 1 (Lock-free queue) passed.")

    // Exercise 2
    val sResult = treiberStackOps(List(1, 2, 3, 4, 5))
    assert(sResult == List(5, 4, 3, 2, 1), s"Expected LIFO order, got $sResult")
    println("Exercise 2 (Treiber stack) passed.")

    // Exercise 3
    val mapResult = concurrentHashMapOps(
      List(("put", 1, 10), ("put", 2, 20), ("put", 3, 30), ("remove", 2, 0)),
      numBuckets = 4
    )
    assert(mapResult == List((1, 10), (3, 30)), s"Got $mapResult")
    println("Exercise 3 (Concurrent hash map) passed.")

    // Exercise 4
    val counter = casCounter(0, 100)
    assert(counter == 100, s"Expected 100, got $counter")
    println("Exercise 4 (CAS counter) passed.")

    // Exercise 5
    val (naiveOk, stampedOk) = abaProblemDemo()
    assert(naiveOk, "Naive CAS should (incorrectly) succeed on ABA")
    assert(!stampedOk, "Stamped CAS should correctly detect ABA")
    println("Exercise 5 (ABA problem) passed.")

    // Exercise 6
    val listResult = lockFreeListOps(List(5, 3, 7, 1, 9), List(3, 7))
    assert(listResult == List(1, 5, 9), s"Expected List(1,5,9), got $listResult")
    println("Exercise 6 (Lock-free list) passed.")

    // Exercise 7
    val (containsRes, remaining) = concurrentSkipListOps(
      List(3, 1, 4, 1, 5, 9),
      List(1, 2, 4, 6),
      List(1, 4)
    )
    assert(containsRes == List(true, false, true, false), s"Got $containsRes")
    assert(remaining == List(3, 5, 9), s"Expected List(3,5,9), got $remaining")
    println("Exercise 7 (Concurrent skip list) passed.")

    // Exercise 8
    val (correct, explanation) = memoryOrderingDemo(42)
    assert(correct, "Consumer should see correct data with proper ordering")
    assert(explanation.nonEmpty, "Expected explanation")
    println(s"Exercise 8 (Memory ordering) passed. $explanation")

    println("All Algo123_ConcurrentDS exercises passed!")
  }
}
