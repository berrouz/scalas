package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 009 - Stream Basics
 *
 * Akka Streams provide a way to process potentially infinite data with back-pressure:
 *   - Source[Out, Mat]: produces elements of type Out
 *   - Sink[In, Mat]: consumes elements of type In
 *   - Flow[In, Out, Mat]: transforms elements from In to Out
 *   - runWith: connects Source to Sink and materializes the stream
 *   - Materializer: allocates resources needed to run the stream
 *   - via: connects a Source or Flow to a Flow
 *   - to: connects a Source to a Sink
 *   - Graph: a reusable stream processing blueprint
 *
 * We model these concepts using pure Scala (List-based simulation).
 */
object Akka009_StreamBasics {

  // --- Domain models (simulating Akka Streams types) ---

  case class Source[A](elements: List[A]) {
    def via[B](flow: Flow[A, B]): Source[B] = Source(elements.map(flow.transform))
    def to(sink: Sink[A]): RunnableGraph[A] = RunnableGraph(this, sink)
    def runWith(sink: Sink[A]): sink.Result = sink.consume(elements)
  }

  case class Flow[A, B](transform: A => B) {
    def via[C](other: Flow[B, C]): Flow[A, C] = Flow(a => other.transform(transform(a)))
  }

  trait Sink[A] {
    type Result
    def consume(elements: List[A]): Result
  }

  object Sink {
    def foreach[A](f: A => Unit): Sink[A] = new Sink[A] {
      type Result = Unit
      def consume(elements: List[A]): Unit = elements.foreach(f)
    }

    def fold[A, B](zero: B)(f: (B, A) => B): Sink[A] = new Sink[A] {
      type Result = B
      def consume(elements: List[A]): B = elements.foldLeft(zero)(f)
    }

    def toList[A]: Sink[A] = new Sink[A] {
      type Result = List[A]
      def consume(elements: List[A]): List[A] = elements
    }
  }

  case class RunnableGraph[A](source: Source[A], sink: Sink[A])

  // Exercise 1: Create a Source from a list of integers
  // TODO: Create a Source containing integers from 1 to n (inclusive).
  //   In real Akka: Source(1 to n)
  def exercise1_createSource(n: Int): Source[Int] = ???

  // Exercise 2: Create a Sink that sums all elements
  // TODO: Create a Sink that folds over integers to produce their sum.
  //   Use Sink.fold with zero=0 and addition.
  //   In real Akka: Sink.fold[Int, Int](0)(_ + _)
  def exercise2_sumSink: Sink[Int] = ???

  // Exercise 3: Create a Flow that doubles each element
  // TODO: Create a Flow[Int, Int] that multiplies each element by 2.
  //   In real Akka: Flow[Int].map(_ * 2)
  def exercise3_doublingFlow: Flow[Int, Int] = ???

  // Exercise 4: Connect Source via Flow and runWith Sink
  // TODO: Given a Source[Int], apply the doubling flow (exercise3),
  //   then run with the sum sink (exercise2).
  //   Return the sum of all doubled elements.
  //   In real Akka: source.via(flow).runWith(sink)
  def exercise4_runWithSink(source: Source[Int]): Int = ???

  // Exercise 5: Materializer concept
  // TODO: A materializer "runs" a stream graph. Simulate materialization:
  //   Given a RunnableGraph, extract the source elements and apply the sink.
  //   Return the number of elements that were processed.
  //   (In real Akka, the materializer allocates threads, buffers, etc.)
  def exercise5_materialize[A](graph: RunnableGraph[A]): Int = ???

  // Exercise 6: Chain multiple Flows using via
  // TODO: Given a Source[String] of words, chain two flows:
  //   1. toUpperCase flow (String => String)
  //   2. addExclamation flow (s => s + "!")
  //   Return the processed list of strings.
  def exercise6_chainFlows(source: Source[String]): List[String] = ???

  // Exercise 7: Connect Source to Sink
  // TODO: Given a Source[Int] and create a pipeline:
  //   Source -> filter even numbers -> multiply by 10 -> collect to List
  //   Implement using via with appropriate Flows and runWith Sink.toList.
  //   Hint: Filter can be modeled as a flow that wraps in Option, then flatten.
  //   Simpler: process all elements through the pipeline, filtering odds to 0,
  //   then filter out zeros from the result.
  def exercise7_sourceToSink(source: Source[Int]): List[Int] = ???

  // Exercise 8: Simple graph — fan-out and merge
  // TODO: Given a Source[Int], simulate a simple graph:
  //   Split elements into two paths:
  //     Path A: multiply by 2
  //     Path B: multiply by 3
  //   Merge results by interleaving (A1, B1, A2, B2, ...).
  //   Return the merged list.
  def exercise8_simpleGraph(source: Source[Int]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_createSource(5)
    assert(r1.elements == List(1, 2, 3, 4, 5), s"Exercise 1 failed: ${r1.elements}")
    println(s"Exercise 1 passed: ${r1.elements}")

    // Exercise 2
    val r2 = exercise2_sumSink
    val sum = r2.consume(List(1, 2, 3, 4, 5))
    assert(sum == 15, s"Exercise 2 failed: sum = $sum")
    println(s"Exercise 2 passed: sum = $sum")

    // Exercise 3
    val r3 = exercise3_doublingFlow
    assert(r3.transform(5) == 10, s"Exercise 3 failed: ${r3.transform(5)}")
    assert(r3.transform(0) == 0, s"Exercise 3 failed: ${r3.transform(0)}")
    println("Exercise 3 passed: doubling flow works")

    // Exercise 4
    val r4 = exercise4_runWithSink(Source(List(1, 2, 3, 4, 5)))
    assert(r4 == 30, s"Exercise 4 failed: expected 30, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val graph5 = RunnableGraph(Source(List(10, 20, 30)), Sink.toList[Int])
    val r5 = exercise5_materialize(graph5)
    assert(r5 == 3, s"Exercise 5 failed: expected 3 elements processed, got $r5")
    println(s"Exercise 5 passed: $r5 elements materialized")

    // Exercise 6
    val r6 = exercise6_chainFlows(Source(List("hello", "world")))
    assert(r6 == List("HELLO!", "WORLD!"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_sourceToSink(Source(List(1, 2, 3, 4, 5, 6)))
    assert(r7 == List(20, 40, 60), s"Exercise 7 failed: expected List(20, 40, 60), got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = exercise8_simpleGraph(Source(List(1, 2, 3)))
    assert(r8 == List(2, 3, 4, 6, 6, 9), s"Exercise 8 failed: expected List(2,3,4,6,6,9), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka009_StreamBasics exercises passed!")
  }
}
