package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 015 - Stream Sink Types
 *
 * Akka Streams provides many Sink constructors:
 *   - Sink.head: materializes to the first element
 *   - Sink.last: materializes to the last element
 *   - Sink.seq: collects all elements into a Seq
 *   - Sink.fold: reduces elements with an accumulator
 *   - Sink.foreach: applies a side-effect to each element
 *   - Sink.ignore: discards all elements
 *   - Sink.actorRef: sends elements to an actor
 *   - Sink.combine: merges multiple sinks using a fan-out strategy
 *
 * We simulate these using pure Scala.
 */
object Akka015_StreamSink {

  // --- Domain models ---

  case class ActorInbox(name: String, messages: List[Any], completionMessage: Option[String])

  // Exercise 1: Sink.head — first element
  // TODO: Given a non-empty list, return Some(firstElement).
  //   For an empty list, return None.
  //   In real Akka: source.runWith(Sink.head)
  def exercise1_head[A](elements: List[A]): Option[A] = ???

  // Exercise 2: Sink.last — last element
  // TODO: Given a non-empty list, return Some(lastElement).
  //   For an empty list, return None.
  //   In real Akka: source.runWith(Sink.last)
  def exercise2_last[A](elements: List[A]): Option[A] = ???

  // Exercise 3: Sink.seq — collect all elements
  // TODO: Given a list, return it as a Vector (Akka's Sink.seq returns Future[Seq[T]]).
  //   In real Akka: source.runWith(Sink.seq)
  def exercise3_seq[A](elements: List[A]): Vector[A] = ???

  // Exercise 4: Sink.fold — reduce to single value
  // TODO: Given a list of elements, an initial value, and a fold function,
  //   reduce to a single value.
  //   In real Akka: source.runWith(Sink.fold(zero)(f))
  def exercise4_fold[A, B](elements: List[A], zero: B)(f: (B, A) => B): B = ???

  // Exercise 5: Sink.foreach — apply side effect
  // TODO: Given a list of elements and a side-effect function,
  //   apply the function to each element. Return the count of elements processed.
  //   In real Akka: source.runWith(Sink.foreach(f))
  def exercise5_foreach[A](elements: List[A], sideEffect: A => Unit): Int = ???

  // Exercise 6: Sink.ignore — discard all
  // TODO: Given a list of elements, consume them all and return Unit.
  //   Also return the count of elements that were ignored.
  //   In real Akka: source.runWith(Sink.ignore) materializes to Future[Done]
  def exercise6_ignore[A](elements: List[A]): Int = ???

  // Exercise 7: Sink.actorRef simulation
  // TODO: Simulate sending stream elements to an actor's inbox.
  //   Given a list of elements, actor name, and a completion message string,
  //   create an ActorInbox with all elements as messages.
  //   When the stream completes, add the completion message.
  //   In real Akka: Sink.actorRef(actorRef, onCompleteMessage)
  def exercise7_actorRef[A](elements: List[A], actorName: String, onComplete: String): ActorInbox = ???

  // Exercise 8: Sink.combine — fan-out to multiple sinks
  // TODO: Given a list of integers and two sink functions:
  //   sink1: collects even numbers into a list
  //   sink2: sums all odd numbers
  //   Process each element through BOTH sinks (broadcast to both).
  //   Return (evenList, oddSum).
  //   In real Akka: Sink.combine(sink1, sink2)(Broadcast(_))
  def exercise8_combine(elements: List[Int]): (List[Int], Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_head(List(10, 20, 30))
    assert(r1 == Some(10), s"Exercise 1 failed: $r1")
    assert(exercise1_head(List.empty[Int]).isEmpty, "Exercise 1 failed: should be None for empty")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2_last(List(10, 20, 30))
    assert(r2 == Some(30), s"Exercise 2 failed: $r2")
    assert(exercise2_last(List.empty[Int]).isEmpty, "Exercise 2 failed: should be None for empty")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = exercise3_seq(List(1, 2, 3))
    assert(r3 == Vector(1, 2, 3), s"Exercise 3 failed: $r3")
    assert(r3.isInstanceOf[Vector[_]], "Exercise 3 failed: should be Vector")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = exercise4_fold(List(1, 2, 3, 4, 5), 0)(_ + _)
    assert(r4 == 15, s"Exercise 4 failed: $r4")
    val r4b = exercise4_fold(List("a", "b", "c"), "")(_ + _)
    assert(r4b == "abc", s"Exercise 4b failed: $r4b")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    var collected5 = List.empty[Int]
    val r5 = exercise5_foreach(List(1, 2, 3), (x: Int) => collected5 = collected5 :+ x)
    assert(r5 == 3, s"Exercise 5 failed: count = $r5")
    assert(collected5 == List(1, 2, 3), s"Exercise 5 failed: collected = $collected5")
    println(s"Exercise 5 passed: processed $r5 elements")

    // Exercise 6
    val r6 = exercise6_ignore(List(1, 2, 3, 4, 5))
    assert(r6 == 5, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: ignored $r6 elements")

    // Exercise 7
    val r7 = exercise7_actorRef(List("msg1", "msg2", "msg3"), "my-actor", "StreamComplete")
    assert(r7.name == "my-actor", s"Exercise 7 failed: name = ${r7.name}")
    assert(r7.messages == List("msg1", "msg2", "msg3"), s"Exercise 7 failed: messages = ${r7.messages}")
    assert(r7.completionMessage == Some("StreamComplete"), s"Exercise 7 failed: completion = ${r7.completionMessage}")
    println(s"Exercise 7 passed: ${r7.messages.size} messages sent to ${r7.name}")

    // Exercise 8
    val (evens8, oddSum8) = exercise8_combine(List(1, 2, 3, 4, 5, 6))
    assert(evens8 == List(2, 4, 6), s"Exercise 8 failed: evens = $evens8")
    assert(oddSum8 == 9, s"Exercise 8 failed: oddSum = $oddSum8")
    println(s"Exercise 8 passed: evens=$evens8, oddSum=$oddSum8")

    println("\nAll Akka015_StreamSink exercises passed!")
  }
}
