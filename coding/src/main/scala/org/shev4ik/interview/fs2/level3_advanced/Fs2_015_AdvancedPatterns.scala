package org.shev4ik.interview.fs2.level3_advanced

/**
 * FS2 015 - Advanced Patterns
 *
 * Advanced stream processing patterns used in production fs2 code:
 * - scan: running fold that emits intermediate results
 * - mapAccumulate: map with state, emitting both state and output
 * - interleave: deterministic alternation of two streams
 * - zip patterns: zipWith, zipWithIndex, zipWithPrevious
 * - broadcasting: sending one stream to multiple consumers
 * - groupBy / partition: splitting streams by criteria
 *
 * Key concepts: stateful transformations, multi-consumer patterns,
 * stream splitting and merging, indexed processing, accumulation patterns.
 */
object Fs2_015_AdvancedPatterns {

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def drop(n: Int): Stream[O] = Stream(toList.drop(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
    def empty[O]: Stream[O] = Stream(Nil)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Implement scan - running fold emitting all intermediate values.
  // TODO: Starting from `init`, apply f(acc, elem) for each element,
  //       emitting the accumulated value after each step.
  //       The output stream starts with `init` and has length input.size + 1.
  //       E.g., scan(Stream(1,2,3))(0)(_ + _) => Stream(0, 1, 3, 6)
  // Hint: In fs2, stream.scan(init)(f) emits running results.
  // -------------------------------------------------------------------------
  def exercise1_scan[O, S](s: Stream[O])(init: S)(f: (S, O) => S): Stream[S] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement mapAccumulate - map with accumulating state.
  // TODO: Like scan but emit both the state and a mapped output.
  //       f(state, elem) returns (newState, output).
  //       Return Stream of (state, output) pairs.
  //       E.g., mapAccumulate(Stream("a","b"))(0)((s,e) => (s+1, e.toUpperCase))
  //       => Stream((1,"A"), (2,"B"))
  // Hint: In fs2, stream.mapAccumulate(init)(f) returns Stream[(S, O)].
  // -------------------------------------------------------------------------
  def exercise2_mapAccumulate[O, S, O2](
    s: Stream[O]
  )(init: S)(f: (S, O) => (S, O2)): Stream[(S, O2)] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement interleave - alternate elements from two streams.
  // TODO: Take one element from s1, then one from s2, alternating.
  //       Stop when EITHER stream is exhausted (unlike merge which continues).
  //       E.g., interleave(Stream(1,3,5), Stream(2,4)) => Stream(1,2,3,4)
  // Hint: In fs2, s1.interleave(s2) alternates strictly.
  // -------------------------------------------------------------------------
  def exercise3_interleave[O](s1: Stream[O], s2: Stream[O]): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement zipWithIndex - pair each element with its index.
  // TODO: Pair each element with its 0-based index.
  //       E.g., Stream("a","b","c") => Stream(("a",0), ("b",1), ("c",2))
  // Hint: In fs2, stream.zipWithIndex.
  // -------------------------------------------------------------------------
  def exercise4_zipWithIndex[O](s: Stream[O]): Stream[(O, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement zipWithPrevious - pair each element with its predecessor.
  // TODO: Pair each element with Option of the previous element.
  //       First element gets None, subsequent get Some(previous).
  //       E.g., Stream(1,2,3) => Stream((None,1), (Some(1),2), (Some(2),3))
  // Hint: In fs2, stream.zipWithPrevious.
  // -------------------------------------------------------------------------
  def exercise5_zipWithPrevious[O](s: Stream[O]): Stream[(Option[O], O)] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement broadcast - send stream to multiple consumers.
  // TODO: Given a stream and a list of transformation functions (consumers),
  //       apply each consumer to the full stream independently.
  //       Return a list of results, one per consumer.
  // Hint: In fs2, stream.broadcastThrough(pipe1, pipe2, ...).
  // -------------------------------------------------------------------------
  def exercise6_broadcast[O, O2](
    s: Stream[O],
    consumers: List[Stream[O] => Stream[O2]]
  ): List[Stream[O2]] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement groupBy - split stream into sub-streams by key.
  // TODO: Given a key function, partition the stream into a Map where each
  //       key maps to a Stream of elements with that key.
  //       E.g., groupBy(Stream(1,2,3,4))(_ % 2) => Map(1 -> Stream(1,3), 0 -> Stream(2,4))
  // Hint: In fs2, stream.groupBy(f) creates a stream of (key, substream) pairs.
  // -------------------------------------------------------------------------
  def exercise7_groupBy[O, K](s: Stream[O])(key: O => K): Map[K, Stream[O]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a windowed aggregation pattern.
  // TODO: Split the stream into non-overlapping windows of size `windowSize`.
  //       Apply the aggregation function to each window.
  //       E.g., windowedAggregate(Stream(1,2,3,4,5))(2)(_.sum) => Stream(3, 7, 5)
  //       Window 1: [1,2] => 3, Window 2: [3,4] => 7, Window 3: [5] => 5
  // Hint: Combines groupWithin + fold patterns from earlier exercises.
  // -------------------------------------------------------------------------
  def exercise8_windowedAggregate[O, O2](
    s: Stream[O]
  )(windowSize: Int)(aggregate: List[O] => O2): Stream[O2] = ???

  def main(args: Array[String]): Unit = {
    val nums = Stream(1, 2, 3, 4, 5)

    // Exercise 1
    assert(exercise1_scan(Stream(1, 2, 3))(0)(_ + _).toList == List(0, 1, 3, 6))
    assert(exercise1_scan(Stream.empty[Int])(0)(_ + _).toList == List(0))
    assert(exercise1_scan(Stream(1, 2, 3))(1)(_ * _).toList == List(1, 1, 2, 6))
    println("Exercise 1 passed: scan emits running fold results")

    // Exercise 2
    val acc = exercise2_mapAccumulate(Stream("a", "b", "c"))(0)(
      (count, s) => (count + 1, s.toUpperCase)
    )
    assert(acc.toList == List((1, "A"), (2, "B"), (3, "C")))
    println("Exercise 2 passed: mapAccumulate tracks state and output")

    // Exercise 3
    assert(exercise3_interleave(Stream(1, 3, 5), Stream(2, 4, 6)).toList == List(1, 2, 3, 4, 5, 6))
    assert(exercise3_interleave(Stream(1, 3, 5), Stream(2, 4)).toList == List(1, 2, 3, 4))
    assert(exercise3_interleave(Stream.empty[Int], Stream(1)).toList == Nil)
    println("Exercise 3 passed: interleave alternates elements")

    // Exercise 4
    assert(exercise4_zipWithIndex(Stream("a", "b", "c")).toList ==
      List(("a", 0), ("b", 1), ("c", 2)))
    assert(exercise4_zipWithIndex(Stream.empty[String]).toList == Nil)
    println("Exercise 4 passed: zipWithIndex pairs with indices")

    // Exercise 5
    assert(exercise5_zipWithPrevious(Stream(1, 2, 3)).toList ==
      List((None, 1), (Some(1), 2), (Some(2), 3)))
    assert(exercise5_zipWithPrevious(Stream(42)).toList == List((None, 42)))
    println("Exercise 5 passed: zipWithPrevious pairs with predecessor")

    // Exercise 6
    val consumers: List[Stream[Int] => Stream[Int]] = List(
      s => s.map(_ * 2),
      s => s.filter(_ % 2 == 0),
      s => s.map(_ + 100)
    )
    val results6 = exercise6_broadcast(nums, consumers)
    assert(results6(0).toList == List(2, 4, 6, 8, 10))
    assert(results6(1).toList == List(2, 4))
    assert(results6(2).toList == List(101, 102, 103, 104, 105))
    println("Exercise 6 passed: broadcast sends to multiple consumers")

    // Exercise 7
    val groups = exercise7_groupBy(nums)(_ % 2)
    assert(groups(1).toList == List(1, 3, 5))
    assert(groups(0).toList == List(2, 4))
    println("Exercise 7 passed: groupBy partitions by key")

    // Exercise 8
    assert(exercise8_windowedAggregate(nums)(2)(_.sum).toList == List(3, 7, 5))
    assert(exercise8_windowedAggregate(nums)(3)(_.size).toList == List(3, 2))
    assert(exercise8_windowedAggregate(Stream.empty[Int])(2)(_.sum).toList == Nil)
    println("Exercise 8 passed: windowed aggregation works")

    println("\nAll Fs2_015_AdvancedPatterns exercises passed!")
  }
}
