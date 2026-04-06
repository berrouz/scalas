package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 010 - Stream Operations
 *
 * Akka Streams provides rich transformation operators:
 *   - map: transform each element
 *   - filter: keep elements matching a predicate
 *   - mapConcat: flatMap equivalent — one element to many
 *   - grouped: batch elements into fixed-size groups
 *   - sliding: sliding window over elements
 *   - scan: like fold but emits intermediate results
 *   - fold: reduce to a single value
 *   - reduce: fold without initial value
 *
 * We simulate these as pure functions on Lists.
 */
object Akka010_StreamOps {

  // Exercise 1: Map operation
  // TODO: Given a list of integers, apply a transformation function to each element.
  //   In real Akka: Source(list).map(f).runWith(Sink.seq)
  def exercise1_map[A, B](elements: List[A], f: A => B): List[B] = ???

  // Exercise 2: Filter operation
  // TODO: Given a list of integers, keep only elements that satisfy the predicate.
  //   In real Akka: Source(list).filter(predicate).runWith(Sink.seq)
  def exercise2_filter[A](elements: List[A], predicate: A => Boolean): List[A] = ???

  // Exercise 3: MapConcat operation (flatMap for streams)
  // TODO: Given a list of strings, split each string by spaces and flatten into a single list.
  //   In real Akka: Source(sentences).mapConcat(_.split(" ").toList).runWith(Sink.seq)
  def exercise3_mapConcat(sentences: List[String]): List[String] = ???

  // Exercise 4: Grouped operation (batching)
  // TODO: Given a list of elements and a group size, batch elements into groups.
  //   The last group may have fewer elements.
  //   In real Akka: Source(list).grouped(size).runWith(Sink.seq)
  def exercise4_grouped[A](elements: List[A], size: Int): List[List[A]] = ???

  // Exercise 5: Sliding window operation
  // TODO: Given a list of elements, window size, and step, produce sliding windows.
  //   In real Akka: Source(list).sliding(size, step).runWith(Sink.seq)
  //   Example: List(1,2,3,4,5), size=3, step=1 -> List(List(1,2,3), List(2,3,4), List(3,4,5))
  def exercise5_sliding[A](elements: List[A], size: Int, step: Int): List[List[A]] = ???

  // Exercise 6: Scan operation (running fold with intermediate results)
  // TODO: Given a list of integers, an initial value, and a function,
  //   produce a list containing all intermediate accumulator values.
  //   The result includes the initial value.
  //   In real Akka: Source(list).scan(zero)(f).runWith(Sink.seq)
  //   Example: scan(0)(_ + _) on List(1,2,3) -> List(0, 1, 3, 6)
  def exercise6_scan[A, B](elements: List[A], zero: B)(f: (B, A) => B): List[B] = ???

  // Exercise 7: Fold operation (reduce to single value)
  // TODO: Given a list of integers, fold them into a single value.
  //   In real Akka: Source(list).runFold(zero)(f)
  def exercise7_fold[A, B](elements: List[A], zero: B)(f: (B, A) => B): B = ???

  // Exercise 8: Reduce operation (fold without initial value)
  // TODO: Given a non-empty list, reduce to a single value using the first element as initial.
  //   Return None for empty lists.
  //   In real Akka: Source(list).runReduce(f)
  def exercise8_reduce[A](elements: List[A])(f: (A, A) => A): Option[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_map(List(1, 2, 3, 4, 5), (x: Int) => x * x)
    assert(r1 == List(1, 4, 9, 16, 25), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2_filter(List(1, 2, 3, 4, 5, 6), (x: Int) => x % 2 == 0)
    assert(r2 == List(2, 4, 6), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = exercise3_mapConcat(List("hello world", "foo bar baz", "scala"))
    assert(r3 == List("hello", "world", "foo", "bar", "baz", "scala"), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = exercise4_grouped(List(1, 2, 3, 4, 5), 2)
    assert(r4 == List(List(1, 2), List(3, 4), List(5)), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = exercise5_sliding(List(1, 2, 3, 4, 5), 3, 1)
    assert(r5 == List(List(1, 2, 3), List(2, 3, 4), List(3, 4, 5)), s"Exercise 5 failed: $r5")
    val r5b = exercise5_sliding(List(1, 2, 3, 4, 5), 2, 2)
    assert(r5b == List(List(1, 2), List(3, 4), List(5)), s"Exercise 5b failed: $r5b")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = exercise6_scan(List(1, 2, 3, 4), 0)(_ + _)
    assert(r6 == List(0, 1, 3, 6, 10), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_fold(List(1, 2, 3, 4, 5), 0)(_ + _)
    assert(r7 == 15, s"Exercise 7 failed: $r7")
    val r7b = exercise7_fold(List("a", "b", "c"), "")(_ + _)
    assert(r7b == "abc", s"Exercise 7b failed: $r7b")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = exercise8_reduce(List(1, 2, 3, 4))(_ + _)
    assert(r8 == Some(10), s"Exercise 8 failed: $r8")
    val r8b = exercise8_reduce(List.empty[Int])(_ + _)
    assert(r8b.isEmpty, s"Exercise 8 failed: should be None for empty list")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka010_StreamOps exercises passed!")
  }
}
