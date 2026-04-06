package org.shev4ik.interview.fs2.level1_basics

/**
 * FS2 002 - Stream Transformation Operations
 *
 * =Overview=
 * FS2 (Functional Streams for Scala) provides a rich set of stream transformation
 * operations that mirror familiar Scala collection methods but with a critical
 * difference: they are '''lazy''' and '''resource-safe'''. No elements are produced
 * or consumed until the stream is ''compiled'' (e.g., `.compile.toList`, `.compile.drain`).
 *
 * =Core Transformation Operations=
 *  - '''map(f: O => O2)''': Transform each element. Like List.map but lazy -- nothing
 *    happens until the stream is pulled.
 *  - '''flatMap(f: O => Stream[F, O2])''': Each element produces a sub-stream; results
 *    are concatenated. This is how you express dynamic, data-dependent stream generation.
 *  - '''filter(p: O => Boolean)''': Keep elements matching the predicate. Lazy -- skipped
 *    elements are never materialized downstream.
 *  - '''take(n: Long)''': Emit only the first n elements, then halt the stream. Because
 *    FS2 is pull-based, upstream producers stop immediately when take is satisfied.
 *  - '''drop(n: Long)''': Skip the first n elements, then emit the rest.
 *  - '''through(pipe: Pipe[F, O, O2])''': Apply a reusable transformation pipeline. A
 *    `Pipe[F, I, O]` is simply `Stream[F, I] => Stream[F, O]`, enabling composable
 *    middleware-style transformations.
 *  - '''fold(init)(f)''': Aggregate all elements into a single value (emitted when
 *    upstream completes). The FS2 equivalent is `stream.fold(z)(f)` which produces a
 *    single-element stream.
 *  - '''collect(pf: PartialFunction[O, O2])''': Combined filter + map using a partial
 *    function -- only elements where `pf.isDefinedAt` passes are transformed and emitted.
 *  - '''takeWhile(p: O => Boolean)''': Emit elements as long as the predicate holds,
 *    then terminate the stream at the first failing element.
 *
 * =Lazy Evaluation vs Standard Collections=
 * Standard Scala collections (List, Vector) are '''eager''' -- calling `list.map(f).filter(p)`
 * creates intermediate collections at each step. FS2 streams are '''pull-based and lazy''':
 * transformations are fused into a single pass, and elements are produced on demand.
 * This means you can safely express `Stream.range(0, Int.MaxValue).filter(isPrime).take(100)`
 * without materializing billions of integers.
 *
 * =Real-World Usage=
 * In production, these operations are used to build ETL pipelines, process log streams,
 * transform HTTP response bodies, and handle database result sets -- all with constant
 * memory usage regardless of data volume. Pipes (`through`) are particularly powerful
 * for reusable concerns like compression, encryption, or batching.
 *
 * =Interview Tip=
 * ''"How does FS2's lazy evaluation differ from standard Scala collections?"''
 *
 * '''Answer:''' Scala collections are eager -- each transformation (map, filter) produces
 * a fully materialized intermediate collection. FS2 streams are pull-based: no element
 * is computed until downstream demands it. Transformations are fused, so
 * `stream.map(f).filter(p).take(n)` runs in a single pass with O(1) memory, even on
 * infinite streams. Additionally, FS2 integrates resource safety via `bracket`/`Resource`,
 * ensuring file handles, connections, etc. are released when the stream terminates or
 * fails -- something standard collections cannot guarantee.
 */
object Fs2_002_StreamOps {

  case class Stream[O](toList: List[O]) {
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Apply map to transform every element in a stream.
  // TODO: Implement streamMap that applies f to each element of the stream.
  // Hint: In fs2 this is stream.map(f).
  // -------------------------------------------------------------------------
  def exercise1_map[A, B](s: Stream[A])(f: A => B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Apply filter to keep only elements matching a predicate.
  // TODO: Implement streamFilter that keeps elements where p returns true.
  // Hint: In fs2 this is stream.filter(p).
  // -------------------------------------------------------------------------
  def exercise2_filter[A](s: Stream[A])(p: A => Boolean): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Apply flatMap to expand each element into a sub-stream.
  // TODO: Implement streamFlatMap that maps each element to a Stream and
  //       concatenates all results.
  // Hint: In fs2 this is stream.flatMap(f).
  // -------------------------------------------------------------------------
  def exercise3_flatMap[A, B](s: Stream[A])(f: A => Stream[B]): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Take the first n elements from a stream.
  // TODO: Implement streamTake that returns only the first n elements.
  // Hint: In fs2 this is stream.take(n).
  // -------------------------------------------------------------------------
  def exercise4_take[A](s: Stream[A], n: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Drop the first n elements from a stream.
  // TODO: Implement streamDrop that skips the first n elements.
  // Hint: In fs2 this is stream.drop(n).
  // -------------------------------------------------------------------------
  def exercise5_drop[A](s: Stream[A], n: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Fold a stream into a single value using an initial value
  //             and a combining function.
  // TODO: Implement streamFold that reduces the stream left-to-right.
  // Hint: In fs2 this is stream.fold(init)(f).compile.lastOrError.
  // -------------------------------------------------------------------------
  def exercise6_fold[A, B](s: Stream[A])(init: B)(f: (B, A) => B): B = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use collect with a partial function to filter and transform.
  // TODO: Implement streamCollect that applies pf where defined.
  // Hint: In fs2 this is stream.collect { case ... => ... }.
  // -------------------------------------------------------------------------
  def exercise7_collect[A, B](s: Stream[A])(pf: PartialFunction[A, B]): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Combine takeWhile - take elements while predicate holds.
  // TODO: Implement streamTakeWhile that takes elements as long as p is true,
  //       stopping at the first element where p returns false.
  // Hint: In fs2 this is stream.takeWhile(p).
  // -------------------------------------------------------------------------
  def exercise8_takeWhile[A](s: Stream[A])(p: A => Boolean): Stream[A] = ???

  def main(args: Array[String]): Unit = {
    val nums = Stream(1, 2, 3, 4, 5)

    // Exercise 1
    assert(exercise1_map(nums)(_ * 10).toList == List(10, 20, 30, 40, 50))
    assert(exercise1_map(nums)(_.toString).toList == List("1", "2", "3", "4", "5"))
    println("Exercise 1 passed: map transforms elements")

    // Exercise 2
    assert(exercise2_filter(nums)(_ % 2 == 0).toList == List(2, 4))
    assert(exercise2_filter(nums)(_ > 10).toList == Nil)
    println("Exercise 2 passed: filter keeps matching elements")

    // Exercise 3
    val expanded = exercise3_flatMap(nums)(n => Stream(n, n * 10))
    assert(expanded.toList == List(1, 10, 2, 20, 3, 30, 4, 40, 5, 50))
    println("Exercise 3 passed: flatMap expands elements into sub-streams")

    // Exercise 4
    assert(exercise4_take(nums, 3).toList == List(1, 2, 3))
    assert(exercise4_take(nums, 0).toList == Nil)
    println("Exercise 4 passed: take returns first n elements")

    // Exercise 5
    assert(exercise5_drop(nums, 2).toList == List(3, 4, 5))
    assert(exercise5_drop(nums, 10).toList == Nil)
    println("Exercise 5 passed: drop skips first n elements")

    // Exercise 6
    assert(exercise6_fold(nums)(0)(_ + _) == 15)
    assert(exercise6_fold(nums)("")(_ + _.toString) == "12345")
    println("Exercise 6 passed: fold reduces stream to single value")

    // Exercise 7
    val mixed = Stream.emits[Any](Seq(1, "hello", 2, "world", 3))
    val strings = exercise7_collect(mixed) { case s: String => s.toUpperCase }
    assert(strings.toList == List("HELLO", "WORLD"))
    println("Exercise 7 passed: collect filters and transforms with partial function")

    // Exercise 8
    assert(exercise8_takeWhile(nums)(_ < 4).toList == List(1, 2, 3))
    assert(exercise8_takeWhile(nums)(_ > 10).toList == Nil)
    println("Exercise 8 passed: takeWhile takes elements while predicate holds")

    println("\nAll Fs2_002_StreamOps exercises passed!")
  }
}
