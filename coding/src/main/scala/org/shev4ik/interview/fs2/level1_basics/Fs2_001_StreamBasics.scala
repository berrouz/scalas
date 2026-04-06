package org.shev4ik.interview.fs2.level1_basics

/**
 * FS2 001 - Stream Basics
 *
 * FS2 (Functional Streams for Scala) models streaming data as lazy, compositional
 * values. A pure Stream[Pure, O] produces values of type O with no effects.
 *
 * Why FS2 matters:
 *   - Backpressure: FS2 streams are pull-based, meaning the consumer drives evaluation.
 *     This naturally prevents fast producers from overwhelming slow consumers, unlike
 *     push-based models that require explicit buffering or dropping strategies.
 *   - Resource safety: FS2 integrates with Cats Effect's Resource to guarantee that
 *     acquired resources (file handles, sockets, DB connections) are released even
 *     when streams are interrupted or fail. This is built into the Stream type itself.
 *   - Compositionality: Streams compose via standard FP combinators (map, flatMap, ++,
 *     through, merge, zip). Complex pipelines are built from small, testable pieces.
 *
 * Comparison with other streaming libraries:
 *   - vs Akka Streams: Akka Streams are push-based with backpressure via the Reactive
 *     Streams protocol. FS2 is pull-based and purely functional (no ActorSystem needed).
 *     Akka Streams use a graph DSL; FS2 uses monadic composition.
 *   - vs Java Streams: Java Streams are single-use, eager (terminal ops force evaluation),
 *     and have no effect tracking or resource safety. FS2 streams are reusable values,
 *     lazy by default, and track effects in the type system via F[_].
 *
 * This exercise models a simplified pure Stream to teach core creation patterns:
 * emit, emits, range, constant, empty, unfold, iterate, and apply.
 *
 * Key concepts: lazy evaluation, chunked output, pure stream construction.
 */
object Fs2_001_StreamBasics {

  // ---------------------------------------------------------------------------
  // Theory: How real FS2 streams work
  //
  // In real FS2, streams are pull-based (the consumer drives evaluation). A Stream
  // is internally a Pull that can emit chunks of output and then either stop or
  // continue. This pull-based model is what gives FS2 its backpressure guarantees:
  // no element is produced until downstream asks for it.
  //
  // Streams support chunked processing for efficiency. Rather than handling one
  // element at a time, FS2 batches elements into Chunk[O] — backed by arrays or
  // vectors — allowing operations like map and filter to work on contiguous memory.
  // This is why Stream.emits is preferred over repeated Stream.emit.
  //
  // FS2 integrates with Cats Effect for resource management. Stream.bracket and
  // Stream.resource ensure that acquired resources are released on completion,
  // error, or interruption. The effect type F[_] (typically IO) tracks side effects
  // in the type system, making streams referentially transparent.
  // ---------------------------------------------------------------------------

  // Simplified pure Stream for exercises (models fs2.Stream[fs2.Pure, O])
  case class Stream[O](toList: List[O]) {
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def isEmpty: Boolean = toList.isEmpty
    def size: Int = toList.size
  }

  object Stream {
    def empty[O]: Stream[O] = Stream(Nil)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a stream that emits a single element.
  // TODO: Implement emit(a) which produces a Stream containing just `a`.
  // Hint: In fs2 this is Stream.emit(a).
  // -------------------------------------------------------------------------
  def exercise1_emit[A](a: A): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a stream from a sequence of elements.
  // TODO: Implement emits(as) which produces a Stream containing all elements.
  // Hint: In fs2 this is Stream.emits(Seq(...)).
  // -------------------------------------------------------------------------
  def exercise2_emits[A](as: Seq[A]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a stream of integers in a range [start, end).
  // TODO: Implement range(start, end) producing start, start+1, ..., end-1.
  // Hint: In fs2 this is Stream.range(start, end).
  // -------------------------------------------------------------------------
  def exercise3_range(start: Int, end: Int): Stream[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create an infinite constant stream, taken to n elements.
  // TODO: Implement constant(a, n) which repeats `a` exactly `n` times.
  // Hint: In fs2, Stream.constant(a).take(n) produces n copies.
  // -------------------------------------------------------------------------
  def exercise4_constant[A](a: A, n: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a stream using unfold with a state function.
  // TODO: Implement unfold(start)(f) where f returns Some((output, nextState))
  //       or None to stop. Collect all outputs into a Stream.
  // Hint: In fs2 this is Stream.unfold(s)(f).
  //
  // Theory: unfold is the dual of fold — fold consumes a structure, unfold
  // produces one. This is a fundamental concept in corecursion. Where fold
  // (catamorphism) tears down a data structure step by step, unfold
  // (anamorphism) builds one up from a seed value. Together they form the
  // basis of recursion schemes. Many useful streams (Fibonacci, pagination
  // tokens, stateful generators) are naturally expressed as unfolds.
  // -------------------------------------------------------------------------
  def exercise5_unfold[S, O](start: S)(f: S => Option[(O, S)]): Stream[O] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Create a stream using iterate (infinite, then take n).
  // TODO: Implement iterate(start)(f, n) which applies f repeatedly,
  //       producing start, f(start), f(f(start)), ... for n elements.
  // Hint: In fs2 this is Stream.iterate(start)(f).take(n).
  // -------------------------------------------------------------------------
  def exercise6_iterate[A](start: A)(f: A => A, n: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Concatenate two streams into one.
  // TODO: Implement concat(s1, s2) which produces all elements of s1 then s2.
  // Hint: In fs2 this is s1 ++ s2.
  // -------------------------------------------------------------------------
  def exercise7_concat[A](s1: Stream[A], s2: Stream[A]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Create a stream from a variable number of arguments.
  // TODO: Implement apply(args) which creates a Stream from varargs.
  // Hint: In fs2 this is Stream(...).
  // -------------------------------------------------------------------------
  def exercise8_apply[A](args: A*): Stream[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_emit(42).toList == List(42))
    assert(exercise1_emit("hello").toList == List("hello"))
    println("Exercise 1 passed: emit creates a single-element stream")

    // Exercise 2
    assert(exercise2_emits(Seq(1, 2, 3)).toList == List(1, 2, 3))
    assert(exercise2_emits(Seq.empty[Int]).toList == Nil)
    println("Exercise 2 passed: emits creates a stream from a sequence")

    // Exercise 3
    assert(exercise3_range(0, 5).toList == List(0, 1, 2, 3, 4))
    assert(exercise3_range(3, 3).toList == Nil)
    println("Exercise 3 passed: range produces [start, end)")

    // Exercise 4
    assert(exercise4_constant("x", 4).toList == List("x", "x", "x", "x"))
    assert(exercise4_constant(1, 0).toList == Nil)
    println("Exercise 4 passed: constant repeats an element n times")

    // Exercise 5
    val fib5 = exercise5_unfold((0, 1)) { case (a, b) =>
      if (a > 10) None else Some((a, (b, a + b)))
    }
    assert(fib5.toList == List(0, 1, 1, 2, 3, 5, 8))
    println("Exercise 5 passed: unfold builds stream from state function")

    // Exercise 6
    assert(exercise6_iterate(1)(_ * 2, 5).toList == List(1, 2, 4, 8, 16))
    println("Exercise 6 passed: iterate applies function repeatedly")

    // Exercise 7
    val s1 = Stream(List(1, 2))
    val s2 = Stream(List(3, 4))
    assert(exercise7_concat(s1, s2).toList == List(1, 2, 3, 4))
    println("Exercise 7 passed: concat joins two streams")

    // Exercise 8
    assert(exercise8_apply(10, 20, 30).toList == List(10, 20, 30))
    assert(exercise8_apply[Int]().toList == Nil)
    println("Exercise 8 passed: apply creates stream from varargs")

    println("\nAll Fs2_001_StreamBasics exercises passed!")
  }
}
