package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 011 - Stream Async Operations
 *
 * Akka Streams provides operators for asynchronous and rate-controlled processing:
 *   - mapAsync: parallel async mapping preserving order
 *   - mapAsyncUnordered: parallel async mapping without order guarantee
 *   - buffer: decouples upstream/downstream rates
 *   - throttle: rate-limits element emission
 *   - conflate: merge elements when downstream is slow
 *   - extrapolate: repeat/expand elements when upstream is slow
 *   - batch: accumulate elements into batches based on cost
 *   - async boundary: introduces async processing between stages
 *
 * We simulate these concepts using pure Scala.
 */
object Akka011_StreamAsync {

  // --- Domain models ---

  sealed trait OverflowStrategy
  case object DropHead extends OverflowStrategy
  case object DropTail extends OverflowStrategy
  case object DropBuffer extends OverflowStrategy
  case object BackPressure extends OverflowStrategy

  case class BufferConfig(size: Int, strategy: OverflowStrategy)

  case class ThrottleConfig(elements: Int, perMillis: Long)

  // Exercise 1: mapAsync simulation (ordered parallel processing)
  // TODO: Given a list of elements and a function that processes each element,
  //   simulate mapAsync with a given parallelism level.
  //   Process elements in groups of `parallelism`, but maintain original order.
  //   Return the processed list in order.
  //   In real Akka: Source(list).mapAsync(parallelism)(f).runWith(Sink.seq)
  def exercise1_mapAsync[A, B](elements: List[A], parallelism: Int)(f: A => B): List[B] = ???

  // Exercise 2: mapAsyncUnordered simulation
  // TODO: Given a list of elements and a processing function with a "priority" function
  //   that assigns priority (Int) to each element, process in priority order
  //   (highest first) to simulate out-of-order completion.
  //   Return the list in priority-processed order.
  def exercise2_mapAsyncUnordered[A, B](
    elements: List[A],
    priority: A => Int
  )(f: A => B): List[B] = ???

  // Exercise 3: Buffer with overflow strategy
  // TODO: Simulate a bounded buffer. Given a stream of elements arriving one at a time,
  //   and a BufferConfig:
  //   - DropHead: when buffer is full, drop oldest element, add new one
  //   - DropTail: when buffer is full, drop newest element (don't add)
  //   - DropBuffer: when buffer is full, clear entire buffer, add new element
  //   - BackPressure: when buffer is full, reject new element (don't add)
  //   Return the final buffer contents after processing all elements.
  def exercise3_buffer[A](elements: List[A], config: BufferConfig): List[A] = ???

  // Exercise 4: Throttle simulation
  // TODO: Given a list of timestamps (Long, in ms) at which elements arrive,
  //   and a ThrottleConfig (elements per perMillis window),
  //   return the list of elements that are allowed through.
  //   Elements that exceed the rate within a window are dropped.
  //   Windows are sliding: each allowed element starts a new window.
  def exercise4_throttle[A](
    elementsWithTime: List[(A, Long)],
    config: ThrottleConfig
  ): List[A] = ???

  // Exercise 5: Conflate simulation (merge when downstream is slow)
  // TODO: Given a list of integers, simulate conflation with a seed and merge function.
  //   Group elements by a "batch boundary" predicate. When the predicate returns true
  //   for an element, emit the current aggregate and start fresh.
  //   Seed: first element of each group. Merge: aggregate function.
  //   Return the list of aggregated values.
  //   Example: elements=List(1,2,3,10,4,5), boundary = _ >= 10
  //     Group 1: [1,2,3] -> merge(1,2,3) -> 6, then 10 starts new group
  //     Group 2: [10,4,5] -> merge(10,4,5) -> 19
  def exercise5_conflate(
    elements: List[Int],
    boundary: Int => Boolean,
    merge: (Int, Int) => Int
  ): List[Int] = ???

  // Exercise 6: Extrapolate simulation (expand when upstream is slow)
  // TODO: Given a sparse list of Option[A] where None means "no upstream element",
  //   fill in the gaps using the extrapolate function.
  //   When Some(a) arrives, use it. When None arrives, apply extrapolate to the last value.
  //   If no value has been seen yet, skip.
  //   Return the dense list without Nones.
  def exercise6_extrapolate[A](
    sparseElements: List[Option[A]],
    extrapolate: A => A
  ): List[A] = ???

  // Exercise 7: Batch simulation (cost-based batching)
  // TODO: Given a list of elements with costs, a max batch cost, and a seed/aggregate function,
  //   batch elements until adding the next element would exceed maxCost.
  //   Each batch is aggregated using the seed (for first element) and aggregate function.
  //   Return the list of batch results.
  def exercise7_batch[A, B](
    elements: List[A],
    maxCost: Long,
    costFn: A => Long,
    seed: A => B,
    aggregate: (B, A) => B
  ): List[B] = ???

  // Exercise 8: Async boundary simulation
  // TODO: Simulate async boundaries by partitioning a pipeline into stages.
  //   Given a list of elements and a list of transformation functions (one per stage),
  //   apply each stage's function to all elements sequentially.
  //   Return a list of lists: one list per stage showing intermediate results.
  //   In real Akka: .async introduces a buffer/async boundary between stages.
  def exercise8_asyncBoundary[A](
    elements: List[A],
    stages: List[A => A]
  ): List[List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_mapAsync(List(1, 2, 3, 4, 5), 2)(_ * 10)
    assert(r1 == List(10, 20, 30, 40, 50), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2_mapAsyncUnordered[String, String](List("low", "high", "med"), {
      case "high" => 3
      case "med"  => 2
      case _      => 1
    })(_.toUpperCase)
    assert(r2 == List("HIGH", "MED", "LOW"), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3a = exercise3_buffer(List(1, 2, 3, 4, 5), BufferConfig(3, DropHead))
    assert(r3a == List(3, 4, 5), s"Exercise 3a failed: $r3a")
    val r3b = exercise3_buffer(List(1, 2, 3, 4, 5), BufferConfig(3, DropTail))
    assert(r3b == List(1, 2, 3), s"Exercise 3b failed: $r3b")
    val r3c = exercise3_buffer(List(1, 2, 3, 4, 5), BufferConfig(3, BackPressure))
    assert(r3c == List(1, 2, 3), s"Exercise 3c failed: $r3c")
    println("Exercise 3 passed: buffer overflow strategies work")

    // Exercise 4
    val throttled = exercise4_throttle(
      List(("a", 0L), ("b", 50L), ("c", 100L), ("d", 150L), ("e", 600L)),
      ThrottleConfig(2, 200L)
    )
    assert(throttled == List("a", "b", "e"), s"Exercise 4 failed: $throttled")
    println(s"Exercise 4 passed: $throttled")

    // Exercise 5
    val r5 = exercise5_conflate(List(1, 2, 3, 10, 4, 5), _ >= 10, _ + _)
    assert(r5 == List(6, 19), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = exercise6_extrapolate(
      List(Some(1), None, None, Some(10), None),
      (x: Int) => x * 2
    )
    assert(r6 == List(1, 2, 4, 10, 20), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_batch(
      List(1, 2, 3, 4, 5),
      maxCost = 5L,
      costFn = (x: Int) => x.toLong,
      seed = (x: Int) => List(x),
      aggregate = (acc: List[Int], x: Int) => acc :+ x
    )
    // Batch 1: [1,2] cost=3, adding 3 would be 6>5 -> emit List(1,2)
    // Batch 2: [3] cost=3, adding 4 would be 7>5 -> emit List(3)
    // Batch 3: [4] cost=4, adding 5 would be 9>5 -> emit List(4)
    // Batch 4: [5] cost=5 -> emit List(5)
    assert(r7 == List(List(1, 2), List(3), List(4), List(5)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = exercise8_asyncBoundary(
      List(1, 2, 3),
      List((x: Int) => x + 1, (x: Int) => x * 2)
    )
    assert(r8 == List(List(2, 3, 4), List(4, 6, 8)), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka011_StreamAsync exercises passed!")
  }
}
