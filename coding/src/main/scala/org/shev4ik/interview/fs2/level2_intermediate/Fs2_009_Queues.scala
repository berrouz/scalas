package org.shev4ik.interview.fs2.level2_intermediate

/**
 * FS2 009 - Queues
 *
 * fs2 provides Queue for asynchronous communication between streams.
 * Queues enable back-pressure: producers block when the queue is full,
 * consumers block when it's empty.
 *
 * Types of queues:
 * - Unbounded: no limit on size
 * - Bounded: fixed capacity, back-pressure when full
 * - Sliding: drops oldest when full
 * - Dropping: drops newest when full
 *
 * This exercise models queue-based patterns with simplified synchronous types.
 *
 * Key concepts: Queue creation, offer/take, back-pressure, bounded vs unbounded,
 * producer-consumer pattern, sliding/dropping strategies.
 */
object Fs2_009_Queues {

  // Simplified Queue modeling fs2.concurrent.Queue
  class Queue[A](capacity: Int) {
    private val buffer = scala.collection.mutable.Queue.empty[A]

    def offer(a: A): Boolean = {
      if (capacity <= 0 || buffer.size < capacity) { buffer.enqueue(a); true }
      else false
    }

    def take(): Option[A] = if (buffer.nonEmpty) Some(buffer.dequeue()) else None
    def tryTake(): Option[A] = take()
    def size: Int = buffer.size
    def isFull: Boolean = capacity > 0 && buffer.size >= capacity
    def isEmpty: Boolean = buffer.isEmpty
    def toList: List[A] = buffer.toList
  }

  object Queue {
    def unbounded[A]: Queue[A] = new Queue[A](0)
    def bounded[A](capacity: Int): Queue[A] = new Queue[A](capacity)
  }

  case class Stream[+O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create an unbounded queue and enqueue elements.
  // TODO: Create an unbounded queue, offer all elements from the list,
  //       then drain the queue to a List.
  // Hint: In fs2, Queue.unbounded[IO, A] creates a queue with no limit.
  // -------------------------------------------------------------------------
  def exercise1_unboundedQueue[A](items: List[A]): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a bounded queue with back-pressure behavior.
  // TODO: Create a bounded queue of given capacity, attempt to offer all items.
  //       Return a tuple: (items successfully enqueued count, items in queue).
  // Hint: In fs2, Queue.bounded[IO, A](capacity) blocks on full.
  //       Here we model by returning false when full.
  // -------------------------------------------------------------------------
  def exercise2_boundedQueue[A](items: List[A], capacity: Int): (Int, List[A]) = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement a sliding queue (drops oldest when full).
  // TODO: Offer all items to a queue of given capacity. When full, drop the
  //       oldest element before adding the new one. Return final queue contents.
  // Hint: In fs2, Queue.sliding[IO, A](capacity) implements this strategy.
  // -------------------------------------------------------------------------
  def exercise3_slidingQueue[A](items: List[A], capacity: Int): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement a dropping queue (drops newest when full).
  // TODO: Offer all items to a queue of given capacity. When full, discard
  //       the new element. Return final queue contents.
  // Hint: In fs2, Queue.dropping[IO, A](capacity) implements this strategy.
  // -------------------------------------------------------------------------
  def exercise4_droppingQueue[A](items: List[A], capacity: Int): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Producer-consumer pattern with a queue.
  // TODO: Producer offers integers 1..n to a bounded queue.
  //       Consumer takes items, applies transform function, collects results.
  //       Return the transformed results.
  // Hint: This models the core fs2 pattern of stream -> queue -> stream.
  // -------------------------------------------------------------------------
  def exercise5_producerConsumer(n: Int, capacity: Int)(transform: Int => String): List[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Multi-producer single-consumer pattern.
  // TODO: Given multiple lists of items (producers), each offers to the same
  //       bounded queue in round-robin order. Consumer drains all items.
  //       Return the items in the order they were consumed.
  // Hint: Models multiple streams feeding into one queue.
  // -------------------------------------------------------------------------
  def exercise6_multiProducer[A](producers: List[List[A]], capacity: Int): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Queue as a buffer between fast producer and slow consumer.
  // TODO: Producer generates items quickly. Consumer processes with given
  //       transform. Queue buffers up to `capacity` items.
  //       Return (produced count, consumed results).
  // Hint: Models back-pressure where queue limits how far ahead producer gets.
  // -------------------------------------------------------------------------
  def exercise7_bufferedProcessing(
    items: List[Int],
    capacity: Int
  )(transform: Int => String): (Int, List[String]) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a priority queue using two queues.
  // TODO: Given items with priorities (true=high, false=low), route high
  //       priority to highQ and low to lowQ. Drain highQ first, then lowQ.
  //       Return all items in priority order.
  // Hint: Models priority routing in stream processing pipelines.
  // -------------------------------------------------------------------------
  def exercise8_priorityQueue[A](
    items: List[(A, Boolean)],
    capacity: Int
  ): List[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_unboundedQueue(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5))
    assert(exercise1_unboundedQueue(List.empty[Int]) == Nil)
    println("Exercise 1 passed: unbounded queue enqueues and drains")

    // Exercise 2
    val (count2, items2) = exercise2_boundedQueue(List(1, 2, 3, 4, 5), 3)
    assert(count2 == 3)
    assert(items2 == List(1, 2, 3))
    println("Exercise 2 passed: bounded queue respects capacity")

    // Exercise 3
    assert(exercise3_slidingQueue(List(1, 2, 3, 4, 5), 3) == List(3, 4, 5))
    assert(exercise3_slidingQueue(List(1, 2), 3) == List(1, 2))
    println("Exercise 3 passed: sliding queue drops oldest")

    // Exercise 4
    assert(exercise4_droppingQueue(List(1, 2, 3, 4, 5), 3) == List(1, 2, 3))
    assert(exercise4_droppingQueue(List(1, 2), 3) == List(1, 2))
    println("Exercise 4 passed: dropping queue drops newest")

    // Exercise 5
    val result5 = exercise5_producerConsumer(5, 3)(i => s"item-$i")
    assert(result5 == List("item-1", "item-2", "item-3", "item-4", "item-5"))
    println("Exercise 5 passed: producer-consumer pattern works")

    // Exercise 6
    val producers = List(List("a1", "a2"), List("b1", "b2"), List("c1"))
    val result6 = exercise6_multiProducer(producers, 10)
    assert(result6 == List("a1", "b1", "c1", "a2", "b2"))
    println("Exercise 6 passed: multi-producer round-robin works")

    // Exercise 7
    val (produced7, consumed7) = exercise7_bufferedProcessing(List(1, 2, 3, 4, 5), 3)(i => s"processed-$i")
    assert(produced7 == 5)
    assert(consumed7 == List("processed-1", "processed-2", "processed-3", "processed-4", "processed-5"))
    println("Exercise 7 passed: buffered processing works")

    // Exercise 8
    val items8 = List(("low1", false), ("high1", true), ("low2", false), ("high2", true), ("low3", false))
    assert(exercise8_priorityQueue(items8, 5) == List("high1", "high2", "low1", "low2", "low3"))
    println("Exercise 8 passed: priority queue routes by priority")

    println("\nAll Fs2_009_Queues exercises passed!")
  }
}
