package org.shev4ik.interview.fs2.level2_intermediate

import scala.concurrent.{Future, Await, ExecutionContext}
import scala.concurrent.duration._

/**
 * FS2 008 - Concurrency
 *
 * FS2 provides powerful concurrency primitives for composing streams:
 * - merge: interleave two streams concurrently
 * - concurrently: run a background stream for its effects
 * - parJoin: flatten a stream of streams with bounded concurrency
 * - parEvalMap: effectful map with bounded parallelism
 *
 * This exercise models concurrency concepts using simplified types.
 * We simulate concurrent behavior with collections since real concurrency
 * requires cats-effect runtime.
 *
 * Key concepts: merging streams, parallel evaluation, bounded parallelism,
 * concurrent side-effects, fan-out/fan-in patterns.
 */
object Fs2_008_Concurrency {

  implicit val ec: ExecutionContext = ExecutionContext.global

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Merge two streams by interleaving their elements.
  // TODO: Implement merge that interleaves elements from s1 and s2.
  //       Take one element from s1, then one from s2, alternating.
  //       If one is longer, append remaining elements.
  // Hint: In fs2, s1.merge(s2) interleaves non-deterministically.
  //       Here we model it as deterministic round-robin interleave.
  // -------------------------------------------------------------------------
  def exercise1_merge[A](s1: Stream[A], s2: Stream[A]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Run a background stream for its side-effects only (concurrently).
  // TODO: Given a main stream and a background stream, return main stream's
  //       elements but also run the background stream's side-effects.
  //       Accumulate background results in the provided buffer.
  // Hint: In fs2, main.concurrently(background) runs background for effects.
  // -------------------------------------------------------------------------
  def exercise2_concurrently[A, B](
    main: Stream[A],
    background: Stream[B],
    sideEffectLog: scala.collection.mutable.ListBuffer[B]
  ): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Flatten a stream of streams (parJoin-like).
  // TODO: Given a Stream of Streams, flatten them all into a single stream.
  //       Concatenate in order (modeling parJoin with maxConcurrency=1).
  // Hint: In fs2, streams.parJoin(n) flattens with bounded concurrency.
  // -------------------------------------------------------------------------
  def exercise3_parJoin[A](streams: Stream[Stream[A]]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Parallel evalMap with bounded concurrency (simulated).
  // TODO: Apply f to each element. In real fs2, parEvalMap runs up to n
  //       effects concurrently. Here, model by applying f to all elements
  //       and collecting results. Track the "parallelism" as batch size.
  // Hint: In fs2, stream.parEvalMap(maxConcurrent)(f).
  // -------------------------------------------------------------------------
  def exercise4_parEvalMap[A, B](
    s: Stream[A],
    maxConcurrent: Int
  )(f: A => B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement a fan-out pattern: duplicate stream to two consumers.
  // TODO: Given a stream and two transformation functions, apply each to
  //       the stream independently and return both results as a tuple.
  // Hint: In fs2, this is done via stream.broadcastThrough(pipe1, pipe2).
  // -------------------------------------------------------------------------
  def exercise5_fanOut[A, B, C](
    s: Stream[A]
  )(f1: Stream[A] => Stream[B])(f2: Stream[A] => Stream[C]): (Stream[B], Stream[C]) = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement zip - pair elements from two streams positionally.
  // TODO: Pair each element from s1 with the corresponding element from s2.
  //       Stop when either stream is exhausted.
  // Hint: In fs2 this is s1.zip(s2).
  // -------------------------------------------------------------------------
  def exercise6_zip[A, B](s1: Stream[A], s2: Stream[B]): Stream[(A, B)] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement zipWith - like zip but with a combining function.
  // TODO: Pair elements from s1 and s2 and combine them using f.
  // Hint: In fs2 this is s1.zipWith(s2)(f).
  // -------------------------------------------------------------------------
  def exercise7_zipWith[A, B, C](
    s1: Stream[A],
    s2: Stream[B]
  )(f: (A, B) => C): Stream[C] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement parEvalMapUnordered simulation.
  // TODO: Apply f to each element. Unlike ordered parEvalMap, results may
  //       be in any order. Here, simulate by reversing the result order
  //       to show that ordering is not guaranteed.
  // Hint: In fs2, stream.parEvalMapUnordered(n)(f) doesn't preserve order.
  // -------------------------------------------------------------------------
  def exercise8_parEvalMapUnordered[A, B](
    s: Stream[A],
    maxConcurrent: Int
  )(f: A => B): Stream[B] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val s1 = Stream(1, 3, 5)
    val s2 = Stream(2, 4, 6)
    assert(exercise1_merge(s1, s2).toList == List(1, 2, 3, 4, 5, 6))
    val s3 = Stream(1, 3, 5, 7)
    assert(exercise1_merge(s3, s2).toList == List(1, 2, 3, 4, 5, 6, 7))
    println("Exercise 1 passed: merge interleaves streams")

    // Exercise 2
    val log2 = scala.collection.mutable.ListBuffer.empty[String]
    val mainStream = Stream(1, 2, 3)
    val bgStream = Stream("bg1", "bg2")
    val result2 = exercise2_concurrently(mainStream, bgStream, log2)
    assert(result2.toList == List(1, 2, 3))
    assert(log2.toList == List("bg1", "bg2"))
    println("Exercise 2 passed: concurrently runs background effects")

    // Exercise 3
    val nested = Stream(Stream(1, 2), Stream(3, 4), Stream(5))
    assert(exercise3_parJoin(nested).toList == List(1, 2, 3, 4, 5))
    println("Exercise 3 passed: parJoin flattens stream of streams")

    // Exercise 4
    val nums = Stream(1, 2, 3, 4, 5)
    assert(exercise4_parEvalMap(nums, 3)(_ * 10).toList == List(10, 20, 30, 40, 50))
    println("Exercise 4 passed: parEvalMap applies function to elements")

    // Exercise 5
    val (evens, odds) = exercise5_fanOut(nums)(
      _.filter(_ % 2 == 0)
    )(
      _.filter(_ % 2 != 0)
    )
    assert(evens.toList == List(2, 4))
    assert(odds.toList == List(1, 3, 5))
    println("Exercise 5 passed: fan-out duplicates stream to two consumers")

    // Exercise 6
    val za = Stream("a", "b", "c")
    val zb = Stream(1, 2, 3, 4)
    assert(exercise6_zip(za, zb).toList == List(("a", 1), ("b", 2), ("c", 3)))
    println("Exercise 6 passed: zip pairs elements positionally")

    // Exercise 7
    val combined = exercise7_zipWith(Stream(1, 2, 3), Stream(10, 20, 30))(_ + _)
    assert(combined.toList == List(11, 22, 33))
    println("Exercise 7 passed: zipWith combines with function")

    // Exercise 8
    val unordered = exercise8_parEvalMapUnordered(Stream(1, 2, 3), 2)(_ * 10)
    assert(unordered.toList.sorted == List(10, 20, 30))
    assert(unordered.toList == List(30, 20, 10)) // reversed to show unordered
    println("Exercise 8 passed: parEvalMapUnordered doesn't preserve order")

    println("\nAll Fs2_008_Concurrency exercises passed!")
  }
}
