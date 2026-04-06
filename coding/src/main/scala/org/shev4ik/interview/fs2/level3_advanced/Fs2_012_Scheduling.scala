package org.shev4ik.interview.fs2.level3_advanced

import scala.concurrent.duration._

/**
 * FS2 012 - Scheduling and Time-Based Streams
 *
 * fs2 provides time-based stream operations via the Temporal type class:
 * - awakeEvery: emit a unit at regular intervals
 * - sleep: delay stream execution
 * - debounce: suppress rapid emissions, emit only after quiet period
 * - groupWithin: batch elements by count or time window
 * - fixedRate / fixedDelay: periodic scheduling variants
 * - timeout: fail if stream takes too long
 *
 * This exercise models time-based patterns with simulated timestamps since
 * real temporal operations require cats-effect runtime.
 *
 * Key concepts: periodic emission, debouncing, time-windowed grouping,
 * rate limiting, delayed execution, timed batching.
 */
object Fs2_012_Scheduling {

  // Simulated timestamped element
  case class Timed[+A](value: A, timestampMs: Long) {
    override def toString: String = s"Timed($value, ${timestampMs}ms)"
  }

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Simulate awakeEvery - emit indices at regular intervals.
  // TODO: Produce a stream of n timestamps, each `intervalMs` apart,
  //       starting at startMs.
  //       E.g., awakeEvery(0, 100, 3) => Stream(Timed(0, 0), Timed(1, 100), Timed(2, 200))
  // Hint: In fs2, Stream.awakeEvery[IO](interval).take(n) emits FiniteDurations.
  // -------------------------------------------------------------------------
  def exercise1_awakeEvery(startMs: Long, intervalMs: Long, n: Int): Stream[Timed[Int]] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Simulate fixedRate - adjust timestamps for consistent rate.
  // TODO: Given a list of elements with actual processing durations,
  //       produce timestamps that maintain a fixed rate (intervalMs apart).
  //       If processing takes longer than interval, emit immediately.
  //       E.g., items=[a,b,c], processingTimes=[50,150,30], interval=100
  //       => timestamps=[0, 100, 200] (fixed rate ignores processing time)
  // Hint: In fs2, Stream.fixedRate[IO](interval) maintains constant period.
  // -------------------------------------------------------------------------
  def exercise2_fixedRate[A](
    items: List[A],
    intervalMs: Long
  ): Stream[Timed[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Simulate fixedDelay - wait interval AFTER each processing.
  // TODO: Given items with processing times, produce timestamps where each
  //       next item starts intervalMs AFTER the previous one finished.
  //       E.g., items=[a,b], processingTimes=[50,30], interval=100
  //       => timestamps=[0, 150] (0 + 50 processing + 100 delay = 150)
  // Hint: In fs2, Stream.fixedDelay[IO](interval) waits after each tick.
  // -------------------------------------------------------------------------
  def exercise3_fixedDelay[A](
    items: List[A],
    processingTimes: List[Long],
    intervalMs: Long
  ): Stream[Timed[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Simulate debounce - suppress rapid emissions.
  // TODO: Given timestamped elements, only emit an element if no new element
  //       arrives within `quietPeriodMs`. Keep the last element of each burst.
  //       E.g., timestamps=[0,50,200,210,500], quietPeriod=100
  //       => keep elements at times 50 (gap 150 to next), 210 (gap 290), 500
  // Hint: In fs2, stream.debounce(duration) waits before emitting.
  // -------------------------------------------------------------------------
  def exercise4_debounce[A](
    events: List[Timed[A]],
    quietPeriodMs: Long
  ): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Simulate groupWithin - batch by count OR time window.
  // TODO: Group elements into batches of at most `maxSize` elements,
  //       OR when `windowMs` has elapsed since the batch started,
  //       whichever comes first. Use timestamps to determine window.
  // Hint: In fs2, stream.groupWithin(maxSize, duration) batches elements.
  // -------------------------------------------------------------------------
  def exercise5_groupWithin[A](
    events: List[Timed[A]],
    maxSize: Int,
    windowMs: Long
  ): List[List[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Simulate rate limiting - allow at most n events per window.
  // TODO: Given timestamped events, allow at most `maxPerWindow` events
  //       within each `windowMs` window. Drop excess events.
  //       Windows start at time 0, windowMs, 2*windowMs, etc.
  // Hint: Models token-bucket rate limiting in stream processing.
  // -------------------------------------------------------------------------
  def exercise6_rateLimit[A](
    events: List[Timed[A]],
    maxPerWindow: Int,
    windowMs: Long
  ): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Simulate timeout - fail if no element within duration.
  // TODO: Given timestamped elements, check that the gap between consecutive
  //       elements never exceeds timeoutMs. Return elements up to (but not
  //       including) the first timeout violation. If no violation, return all.
  // Hint: In fs2, stream.timeout(duration) raises error on timeout.
  // -------------------------------------------------------------------------
  def exercise7_timeout[A](
    events: List[Timed[A]],
    timeoutMs: Long
  ): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Simulate a scheduled pipeline with delay and batching.
  // TODO: Given events arriving at various times:
  //       1. Delay each event by `delayMs` (add delayMs to its timestamp)
  //       2. Group into fixed time windows of `windowMs`
  //       3. Return groups of values per window
  // Hint: Models a pipeline with Stream.sleep >> groupWithin.
  // -------------------------------------------------------------------------
  def exercise8_delayAndBatch[A](
    events: List[Timed[A]],
    delayMs: Long,
    windowMs: Long
  ): List[List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val ticks = exercise1_awakeEvery(0L, 100L, 3)
    assert(ticks.toList == List(Timed(0, 0), Timed(1, 100), Timed(2, 200)))
    println("Exercise 1 passed: awakeEvery produces periodic timestamps")

    // Exercise 2
    val fixed = exercise2_fixedRate(List("a", "b", "c"), 100L)
    assert(fixed.toList == List(Timed("a", 0), Timed("b", 100), Timed("c", 200)))
    println("Exercise 2 passed: fixedRate maintains constant period")

    // Exercise 3
    val delayed = exercise3_fixedDelay(
      List("a", "b", "c"),
      List(50L, 30L, 20L),
      100L
    )
    assert(delayed.toList == List(Timed("a", 0), Timed("b", 150), Timed("c", 280)))
    println("Exercise 3 passed: fixedDelay waits after processing")

    // Exercise 4
    val bursts = List(
      Timed("a", 0), Timed("b", 50), Timed("c", 200), Timed("d", 210), Timed("e", 500)
    )
    assert(exercise4_debounce(bursts, 100L) == List("b", "d", "e"))
    println("Exercise 4 passed: debounce keeps last of each burst")

    // Exercise 5
    val timedItems = List(
      Timed("a", 0), Timed("b", 30), Timed("c", 80),
      Timed("d", 150), Timed("e", 160), Timed("f", 300)
    )
    val grouped = exercise5_groupWithin(timedItems, 2, 100L)
    assert(grouped == List(List("a", "b"), List("c", "d"), List("e"), List("f")))
    println("Exercise 5 passed: groupWithin batches by count or time")

    // Exercise 6
    val events6 = List(
      Timed("a", 10), Timed("b", 20), Timed("c", 30),
      Timed("d", 110), Timed("e", 120), Timed("f", 130)
    )
    assert(exercise6_rateLimit(events6, 2, 100L) == List("a", "b", "d", "e"))
    println("Exercise 6 passed: rateLimit enforces max per window")

    // Exercise 7
    val events7 = List(Timed("a", 0), Timed("b", 80), Timed("c", 100), Timed("d", 350))
    assert(exercise7_timeout(events7, 200L) == List("a", "b", "c"))
    val events7b = List(Timed("a", 0), Timed("b", 50))
    assert(exercise7_timeout(events7b, 200L) == List("a", "b"))
    println("Exercise 7 passed: timeout detects gaps")

    // Exercise 8
    val events8 = List(Timed("a", 10), Timed("b", 40), Timed("c", 110), Timed("d", 160))
    // After delay of 50: timestamps become 60, 90, 160, 210
    // Window 100: [60,90] => [a,b], [160] => [c], [210] => [d]
    assert(exercise8_delayAndBatch(events8, 50L, 100L) == List(List("a", "b"), List("c"), List("d")))
    println("Exercise 8 passed: delay and batch pipeline works")

    println("\nAll Fs2_012_Scheduling exercises passed!")
  }
}
