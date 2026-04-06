package org.shev4ik.interview.fs2.level3_advanced

/**
 * FS2 011 - Pull
 *
 * Pull is the low-level building block underlying fs2 streams. A Pull[F, O, R]
 * can output values of type O and return a result R (or terminate).
 *
 * Key operations:
 * - Pull.output1(o): output a single element
 * - Pull.output(chunk): output a chunk of elements
 * - Pull.done: terminate the pull
 * - stream.pull.uncons: deconstruct stream into head chunk + tail
 * - pull.stream: convert Pull back to Stream
 *
 * Pull enables writing custom stateful stream transformations that process
 * one chunk at a time.
 *
 * Key concepts: uncons, Pull-based transformations, chunk-by-chunk processing,
 * building custom stream operators from Pull.
 */
object Fs2_011_Pull {

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def isEmpty: Boolean = toList.isEmpty
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
    def empty[O]: Stream[O] = Stream(Nil)
  }

  // Simplified Pull result modeling fs2's Pull.uncons return
  // Returns Option[(head element, remaining stream)]
  type Uncons[O] = Option[(O, Stream[O])]

  // -------------------------------------------------------------------------
  // Exercise 1: Implement uncons - deconstruct a stream into head and tail.
  // TODO: If stream is non-empty, return Some((head, tail)). Else None.
  // Hint: In fs2, stream.pull.uncons returns Pull[F, Nothing, Option[(Chunk, Stream)]].
  // -------------------------------------------------------------------------
  def exercise1_uncons[O](s: Stream[O]): Uncons[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement take using Pull-style recursion.
  // TODO: Using uncons, take the first n elements from the stream.
  //       Recursively uncons, collect head, decrement n, continue with tail.
  // Hint: In fs2, take is implemented as a Pull that unconsN and outputs.
  // -------------------------------------------------------------------------
  def exercise2_takeViaPull[O](s: Stream[O], n: Int): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement drop using Pull-style recursion.
  // TODO: Using uncons, skip the first n elements, return the rest.
  //       Recursively uncons and decrement n without outputting.
  // Hint: In fs2, drop is implemented as a Pull that skips n elements.
  // -------------------------------------------------------------------------
  def exercise3_dropViaPull[O](s: Stream[O], n: Int): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement takeWhile using Pull-style recursion.
  // TODO: Using uncons, take elements while predicate is true.
  //       Stop as soon as predicate returns false for a head element.
  // Hint: In fs2, takeWhile uses Pull to check each element.
  // -------------------------------------------------------------------------
  def exercise4_takeWhileViaPull[O](s: Stream[O])(p: O => Boolean): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement a Pull-based scan (running fold).
  // TODO: Produce a stream where each element is the cumulative result of
  //       applying f. Start with init, then for each element e, output f(acc, e).
  //       E.g., scan(Stream(1,2,3))(0)(_ + _) => Stream(0, 1, 3, 6)
  // Hint: In fs2, scan uses a Pull that maintains accumulator state.
  // -------------------------------------------------------------------------
  def exercise5_scanViaPull[O, S](s: Stream[O])(init: S)(f: (S, O) => S): Stream[S] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a Pull-based stateful filter (deduplicate).
  // TODO: Remove consecutive duplicate elements, keeping only the first
  //       of each run. Maintain the "last seen" element as state.
  //       E.g., Stream(1,1,2,2,3,1,1) => Stream(1,2,3,1)
  // Hint: In fs2, changes uses Pull with Option[O] state.
  // -------------------------------------------------------------------------
  def exercise6_deduplicateViaPull[O](s: Stream[O]): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement intersperse using Pull-style processing.
  // TODO: Insert a separator element between every pair of elements.
  //       E.g., intersperse(Stream(1,2,3))(0) => Stream(1,0,2,0,3)
  // Hint: In fs2, intersperse uses Pull to track whether to emit separator.
  // -------------------------------------------------------------------------
  def exercise7_intersperseViaPull[O](s: Stream[O])(separator: O): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement sliding window using Pull-style processing.
  // TODO: Produce a stream of sliding windows of size n.
  //       E.g., sliding(Stream(1,2,3,4,5))(3) => Stream(List(1,2,3), List(2,3,4), List(3,4,5))
  // Hint: In fs2, sliding uses Pull with a buffer of recent elements.
  // -------------------------------------------------------------------------
  def exercise8_slidingViaPull[O](s: Stream[O])(windowSize: Int): Stream[List[O]] = ???

  def main(args: Array[String]): Unit = {
    val nums = Stream(1, 2, 3, 4, 5)

    // Exercise 1
    val uc = exercise1_uncons(nums)
    assert(uc.contains((1, Stream(List(2, 3, 4, 5)))))
    assert(exercise1_uncons(Stream.empty[Int]).isEmpty)
    println("Exercise 1 passed: uncons deconstructs stream")

    // Exercise 2
    assert(exercise2_takeViaPull(nums, 3).toList == List(1, 2, 3))
    assert(exercise2_takeViaPull(nums, 0).toList == Nil)
    assert(exercise2_takeViaPull(nums, 10).toList == List(1, 2, 3, 4, 5))
    println("Exercise 2 passed: take via Pull works")

    // Exercise 3
    assert(exercise3_dropViaPull(nums, 2).toList == List(3, 4, 5))
    assert(exercise3_dropViaPull(nums, 0).toList == List(1, 2, 3, 4, 5))
    assert(exercise3_dropViaPull(nums, 10).toList == Nil)
    println("Exercise 3 passed: drop via Pull works")

    // Exercise 4
    assert(exercise4_takeWhileViaPull(nums)(_ < 4).toList == List(1, 2, 3))
    assert(exercise4_takeWhileViaPull(nums)(_ > 10).toList == Nil)
    println("Exercise 4 passed: takeWhile via Pull works")

    // Exercise 5
    assert(exercise5_scanViaPull(Stream(1, 2, 3))(0)(_ + _).toList == List(0, 1, 3, 6))
    assert(exercise5_scanViaPull(Stream.empty[Int])(0)(_ + _).toList == List(0))
    println("Exercise 5 passed: scan via Pull produces running fold")

    // Exercise 6
    val dupes = Stream(1, 1, 2, 2, 2, 3, 1, 1)
    assert(exercise6_deduplicateViaPull(dupes).toList == List(1, 2, 3, 1))
    assert(exercise6_deduplicateViaPull(Stream(5, 5, 5)).toList == List(5))
    println("Exercise 6 passed: deduplicate via Pull removes consecutive dupes")

    // Exercise 7
    assert(exercise7_intersperseViaPull(Stream(1, 2, 3))(0).toList == List(1, 0, 2, 0, 3))
    assert(exercise7_intersperseViaPull(Stream(1))(0).toList == List(1))
    assert(exercise7_intersperseViaPull(Stream.empty[Int])(0).toList == Nil)
    println("Exercise 7 passed: intersperse via Pull inserts separators")

    // Exercise 8
    assert(exercise8_slidingViaPull(nums)(3).toList == List(List(1, 2, 3), List(2, 3, 4), List(3, 4, 5)))
    assert(exercise8_slidingViaPull(Stream(1, 2))(3).toList == Nil)
    println("Exercise 8 passed: sliding window via Pull works")

    println("\nAll Fs2_011_Pull exercises passed!")
  }
}
