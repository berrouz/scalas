package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC 006 - Server Streaming
 *
 * Server streaming RPCs: client sends one request, server returns a stream of responses.
 * Key concepts:
 *   - Server sends multiple messages before completing with a status
 *   - Flow control: backpressure prevents overwhelming the client
 *   - Client can cancel the stream at any time
 *   - Common use cases: real-time feeds, large dataset pagination, event subscriptions
 *   - Server signals completion by closing the stream (sending trailing metadata + status)
 *   - Client reads messages one at a time from the stream
 */
object Grpc006_ServerStreaming {

  // --- Domain models for exercises ---

  sealed trait StreamStatus
  object StreamStatus {
    case object Active    extends StreamStatus
    case object Completed extends StreamStatus
    case object Cancelled extends StreamStatus
    case class Error(message: String) extends StreamStatus
  }

  case class StreamMessage[T](value: T, sequenceNumber: Int)

  case class ServerStream[T](
    messages: List[StreamMessage[T]],
    status: StreamStatus
  )

  case class FlowControl(
    windowSize: Int,     // max messages before needing acknowledgment
    pendingAcks: Int     // how many messages awaiting ack
  ) {
    def canSend: Boolean = pendingAcks < windowSize
    def messageSent: FlowControl = copy(pendingAcks = pendingAcks + 1)
    def ackReceived(count: Int): FlowControl = copy(pendingAcks = math.max(0, pendingAcks - count))
  }

  case class StreamRequest(
    query: String,
    maxResults: Int,
    pageSize: Int
  )

  // Exercise 1: Create a server stream from a list of items
  // TODO: Given a List[T], produce a ServerStream[T] where each item becomes
  //   a StreamMessage with sequenceNumber starting at 0, incrementing by 1.
  //   The stream status should be Completed.
  def exercise1_createStream[T](items: List[T]): ServerStream[T] = ???

  // Exercise 2: Apply pagination to a stream
  // TODO: Given a full list of items and a StreamRequest, return a ServerStream[T]
  //   containing at most `maxResults` items, split into pages of `pageSize`.
  //   Only return the items (up to maxResults). Sequence numbers start at 0.
  //   Status = Completed.
  def exercise2_paginatedStream[T](items: List[T], request: StreamRequest): ServerStream[T] = ???

  // Exercise 3: Filter a server stream
  // TODO: Given a ServerStream[T] and a predicate T => Boolean, return a new
  //   ServerStream containing only messages whose values pass the predicate.
  //   Re-number the sequence numbers starting from 0. Preserve the original status.
  def exercise3_filterStream[T](stream: ServerStream[T], predicate: T => Boolean): ServerStream[T] = ???

  // Exercise 4: Simulate flow control on a stream
  // TODO: Given a list of items and a FlowControl configuration, simulate sending.
  //   Send items while canSend is true. When the window is full, simulate receiving
  //   an ack for all pending messages, then continue sending.
  //   Return a tuple: (sentItems: List[T], totalAckRounds: Int)
  //   where totalAckRounds is how many times we had to wait for acks.
  def exercise4_flowControlSend[T](items: List[T], flowControl: FlowControl): (List[T], Int) = ???

  // Exercise 5: Cancel a stream after N messages
  // TODO: Given a ServerStream[T], return a new stream with only the first N messages
  //   and status = Cancelled. If the stream has <= N messages, return it as-is
  //   with its original status.
  def exercise5_cancelAfterN[T](stream: ServerStream[T], n: Int): ServerStream[T] = ???

  // Exercise 6: Implement a stream transformer (map)
  // TODO: Given a ServerStream[A] and a function A => B, return a ServerStream[B]
  //   with each message value transformed. Preserve sequence numbers and status.
  def exercise6_mapStream[A, B](stream: ServerStream[A], f: A => B): ServerStream[B] = ???

  // Exercise 7: Merge two server streams into one
  // TODO: Given two ServerStreams of the same type, merge them by interleaving
  //   messages (take one from stream1, then one from stream2, alternating).
  //   If one stream is exhausted, append remaining messages from the other.
  //   Re-number sequence numbers starting from 0.
  //   Status: if either stream has an Error, use that error. If either is Cancelled,
  //   use Cancelled. Otherwise use Completed.
  def exercise7_mergeStreams[T](s1: ServerStream[T], s2: ServerStream[T]): ServerStream[T] = ???

  // Exercise 8: Calculate stream statistics
  // TODO: Given a ServerStream[Int], calculate and return a tuple:
  //   (messageCount: Int, sum: Long, min: Int, max: Int, average: Double)
  //   If the stream is empty, return (0, 0L, Int.MaxValue, Int.MinValue, 0.0)
  def exercise8_streamStats(stream: ServerStream[Int]): (Int, Long, Int, Int, Double) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val s1 = exercise1_createStream(List("a", "b", "c"))
    assert(s1.messages.length == 3, "Exercise 1 failed: wrong count")
    assert(s1.messages.head.sequenceNumber == 0, "Exercise 1 failed: wrong seq 0")
    assert(s1.messages(2).sequenceNumber == 2, "Exercise 1 failed: wrong seq 2")
    assert(s1.messages(1).value == "b", "Exercise 1 failed: wrong value")
    assert(s1.status == StreamStatus.Completed, "Exercise 1 failed: wrong status")
    println("Exercise 1 passed: server stream created")

    // Exercise 2
    val items = (1 to 20).toList
    val req = StreamRequest("all", maxResults = 10, pageSize = 5)
    val paginated = exercise2_paginatedStream(items, req)
    assert(paginated.messages.length == 10, "Exercise 2 failed: expected 10 items")
    assert(paginated.messages.last.value == 10, "Exercise 2 failed: wrong last item")
    println("Exercise 2 passed: paginated stream correct")

    // Exercise 3
    val intStream = exercise1_createStream(List(1, 2, 3, 4, 5, 6))
    val filtered = exercise3_filterStream(intStream, (x: Int) => x % 2 == 0)
    assert(filtered.messages.length == 3, "Exercise 3 failed: wrong count")
    assert(filtered.messages.map(_.value) == List(2, 4, 6), "Exercise 3 failed: wrong values")
    assert(filtered.messages.head.sequenceNumber == 0, "Exercise 3 failed: not renumbered")
    println("Exercise 3 passed: stream filtering correct")

    // Exercise 4
    val (sent, ackRounds) = exercise4_flowControlSend((1 to 7).toList, FlowControl(windowSize = 3, pendingAcks = 0))
    assert(sent == (1 to 7).toList, "Exercise 4 failed: not all items sent")
    assert(ackRounds == 2, s"Exercise 4 failed: expected 2 ack rounds, got $ackRounds")
    println("Exercise 4 passed: flow control simulation correct")

    // Exercise 5
    val fullStream = exercise1_createStream(List(1, 2, 3, 4, 5))
    val cancelled = exercise5_cancelAfterN(fullStream, 3)
    assert(cancelled.messages.length == 3, "Exercise 5 failed: wrong count")
    assert(cancelled.status == StreamStatus.Cancelled, "Exercise 5 failed: wrong status")
    val smallStream = exercise1_createStream(List(1, 2))
    val notCancelled = exercise5_cancelAfterN(smallStream, 5)
    assert(notCancelled.messages.length == 2, "Exercise 5 failed: should keep all")
    assert(notCancelled.status == StreamStatus.Completed, "Exercise 5 failed: should keep original status")
    println("Exercise 5 passed: stream cancellation correct")

    // Exercise 6
    val mapped = exercise6_mapStream(exercise1_createStream(List(1, 2, 3)), (x: Int) => x * 10)
    assert(mapped.messages.map(_.value) == List(10, 20, 30), "Exercise 6 failed: wrong values")
    assert(mapped.messages.head.sequenceNumber == 0, "Exercise 6 failed: seq preserved")
    println("Exercise 6 passed: stream mapping correct")

    // Exercise 7
    val sa = exercise1_createStream(List("a", "b", "c"))
    val sb = exercise1_createStream(List("1", "2"))
    val merged = exercise7_mergeStreams(sa, sb)
    assert(merged.messages.map(_.value) == List("a", "1", "b", "2", "c"), "Exercise 7 failed: wrong merge")
    assert(merged.messages.head.sequenceNumber == 0, "Exercise 7 failed: not renumbered")
    assert(merged.messages.last.sequenceNumber == 4, "Exercise 7 failed: wrong last seq")
    println("Exercise 7 passed: stream merging correct")

    // Exercise 8
    val statsStream = exercise1_createStream(List(10, 20, 30, 40))
    val (count, sum, min, max, avg) = exercise8_streamStats(statsStream)
    assert(count == 4, "Exercise 8 failed: wrong count")
    assert(sum == 100L, "Exercise 8 failed: wrong sum")
    assert(min == 10, "Exercise 8 failed: wrong min")
    assert(max == 40, "Exercise 8 failed: wrong max")
    assert(avg == 25.0, "Exercise 8 failed: wrong avg")
    val emptyStats = exercise8_streamStats(exercise1_createStream(List.empty[Int]))
    assert(emptyStats._1 == 0, "Exercise 8 failed: empty count")
    println("Exercise 8 passed: stream statistics correct")

    println("\nAll Grpc006_ServerStreaming exercises passed!")
  }
}
