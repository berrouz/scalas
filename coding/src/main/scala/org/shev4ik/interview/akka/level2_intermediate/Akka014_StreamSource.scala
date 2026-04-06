package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 014 - Stream Source Types
 *
 * Akka Streams provides many Source constructors:
 *   - Source.single: emits one element then completes
 *   - Source.apply (Source(iterable)): emits all elements from a collection
 *   - Source.repeat: infinitely repeats a single element
 *   - Source.tick: emits elements at regular intervals
 *   - Source.unfold: generates elements from a state function
 *   - Source.queue: allows external pushing of elements
 *   - Source.actorRef: allows an actor to push elements into a stream
 *   - Source.fromPublisher: interop with Reactive Streams Publisher
 *
 * We simulate these using pure Scala.
 */
object Akka014_StreamSource {

  // Exercise 1: Source.single — emit one element
  // TODO: Create a list containing a single element.
  //   In real Akka: Source.single(element)
  def exercise1_single[A](element: A): List[A] = ???

  // Exercise 2: Source.apply — emit from collection
  // TODO: Given a collection (Seq), return it as a List.
  //   In real Akka: Source(collection)
  def exercise2_fromCollection[A](collection: Seq[A]): List[A] = ???

  // Exercise 3: Source.repeat — repeat element N times
  // TODO: Given an element and a take count, produce a list of that element repeated.
  //   In real Akka: Source.repeat(element).take(n)
  def exercise3_repeat[A](element: A, n: Int): List[A] = ???

  // Exercise 4: Source.tick simulation
  // TODO: Simulate a tick source that emits a value at regular intervals.
  //   Given initialDelayMs, intervalMs, totalDurationMs, and element,
  //   return a list of (timestamp, element) pairs for each tick.
  //   First tick at initialDelayMs, then every intervalMs.
  //   Only include ticks where timestamp <= totalDurationMs.
  //   In real Akka: Source.tick(initialDelay, interval, element)
  def exercise4_tick[A](
    initialDelayMs: Long,
    intervalMs: Long,
    totalDurationMs: Long,
    element: A
  ): List[(Long, A)] = ???

  // Exercise 5: Source.unfold — generate from state
  // TODO: Given an initial state and a function that returns Option[(nextState, element)],
  //   generate elements until the function returns None.
  //   In real Akka: Source.unfold(initialState)(f)
  //   Example: unfold(10)(s => if (s > 0) Some((s-3, s)) else None) -> List(10, 7, 4, 1)
  def exercise5_unfold[S, A](initialState: S)(f: S => Option[(S, A)]): List[A] = ???

  // Exercise 6: Source.queue simulation
  // TODO: Simulate an external queue source. Given a list of operations:
  //   "offer:X" -> add X to the queue
  //   "complete" -> stop accepting, drain remaining
  //   "fail:msg" -> fail with message, discard remaining
  //   Return all successfully offered elements before complete/fail.
  def exercise6_queue(operations: List[String]): List[String] = ???

  // Exercise 7: Source.actorRef simulation
  // TODO: Simulate an actor-backed source with a buffer.
  //   Given a bufferSize and a list of messages (Some(element) or None for completion),
  //   buffer elements up to bufferSize. If buffer overflows, drop the oldest.
  //   When None is encountered, drain the buffer and return all elements.
  def exercise7_actorRef[A](bufferSize: Int, messages: List[Option[A]]): List[A] = ???

  // Exercise 8: Source.fromPublisher concept — Reactive Streams interop
  // TODO: Simulate a publisher that produces elements on demand.
  //   Given a request function (requestCount: Int => List[A]) and total demand,
  //   request elements in batches of batchSize until totalDemand is met.
  //   Return all collected elements (up to totalDemand).
  //   This models the Reactive Streams request(n) / onNext pattern.
  def exercise8_fromPublisher[A](
    requestFn: Int => List[A],
    batchSize: Int,
    totalDemand: Int
  ): List[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_single(42)
    assert(r1 == List(42), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2_fromCollection(Vector(1, 2, 3, 4, 5))
    assert(r2 == List(1, 2, 3, 4, 5), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = exercise3_repeat("hello", 4)
    assert(r3 == List("hello", "hello", "hello", "hello"), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = exercise4_tick(100L, 200L, 600L, "tick")
    assert(r4 == List((100L, "tick"), (300L, "tick"), (500L, "tick")),
      s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = exercise5_unfold(10)(s => if (s > 0) Some((s - 3, s)) else None)
    assert(r5 == List(10, 7, 4, 1), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = exercise6_queue(List("offer:a", "offer:b", "offer:c", "complete", "offer:d"))
    assert(r6 == List("a", "b", "c"), s"Exercise 6 failed: $r6")
    val r6b = exercise6_queue(List("offer:x", "fail:error", "offer:y"))
    assert(r6b == List("x"), s"Exercise 6b failed: $r6b")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_actorRef(3, List(Some(1), Some(2), Some(3), Some(4), Some(5), None))
    // buffer of 3: [1,2,3] -> overflow [2,3,4] -> overflow [3,4,5] -> drain
    assert(r7 == List(3, 4, 5), s"Exercise 7 failed: $r7")
    val r7b = exercise7_actorRef(10, List(Some(1), Some(2), None))
    assert(r7b == List(1, 2), s"Exercise 7b failed: $r7b")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    var batch8 = 0
    val r8 = exercise8_fromPublisher(
      (n: Int) => { batch8 += 1; (1 to n).map(_ + batch8 * 10).toList },
      batchSize = 3,
      totalDemand = 7
    )
    assert(r8.length == 7, s"Exercise 8 failed: expected 7 elements, got ${r8.length}")
    println(s"Exercise 8 passed: ${r8.length} elements from publisher")

    println("\nAll Akka014_StreamSource exercises passed!")
  }
}
