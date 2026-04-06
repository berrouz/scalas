package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC 007 - Client Streaming
 *
 * Client streaming RPCs: client sends a stream of requests, server returns a single response.
 * Key concepts:
 *   - Client sends multiple messages and then closes the send stream
 *   - Server processes all messages and returns one response
 *   - Common patterns: file upload, batch data ingestion, aggregation
 *   - Server can respond early (before client finishes sending)
 *   - Half-close: client signals it's done sending; server can still respond
 *   - Aggregation: server accumulates client messages into a single result
 */
object Grpc007_ClientStreaming {

  // --- Domain models for exercises ---

  sealed trait ClientStreamState
  object ClientStreamState {
    case object Open      extends ClientStreamState
    case object HalfClosed extends ClientStreamState // client done sending
    case object Closed    extends ClientStreamState
  }

  case class ClientMessage[T](value: T, sequenceNumber: Int)

  case class ClientStream[T](
    messages: List[ClientMessage[T]],
    state: ClientStreamState
  )

  case class AggregateResponse[T](
    result: T,
    messagesProcessed: Int
  )

  case class UploadChunk(
    data: Array[Byte],
    offset: Long,
    isLast: Boolean
  )

  case class UploadResult(
    totalBytes: Long,
    chunkCount: Int,
    checksum: Long
  )

  // Exercise 1: Build a client stream from a list of items
  // TODO: Given a List[T], create a ClientStream where each item becomes
  //   a ClientMessage with sequenceNumber starting at 0.
  //   The state should be HalfClosed (client done sending).
  def exercise1_buildClientStream[T](items: List[T]): ClientStream[T] = ???

  // Exercise 2: Aggregate a client stream of numbers into a sum
  // TODO: Given a ClientStream[Int], sum all message values and return
  //   an AggregateResponse[Long] with the sum and the count of messages processed.
  def exercise2_aggregateSum(stream: ClientStream[Int]): AggregateResponse[Long] = ???

  // Exercise 3: Aggregate a client stream into a collected list
  // TODO: Given a ClientStream[T], collect all values into a List[T]
  //   in the order they were sent. Return AggregateResponse[List[T]].
  def exercise3_collectAll[T](stream: ClientStream[T]): AggregateResponse[List[T]] = ???

  // Exercise 4: Simulate file upload from chunks
  // TODO: Given a List[UploadChunk], simulate reassembling an upload:
  //   - totalBytes = sum of all chunk data lengths
  //   - chunkCount = number of chunks
  //   - checksum = sum of all bytes across all chunks (as Long, treating bytes as unsigned 0-255)
  //   Return an UploadResult.
  def exercise4_processUpload(chunks: List[UploadChunk]): UploadResult = ???

  // Exercise 5: Implement a running average aggregator
  // TODO: Given a ClientStream[Double], compute the running average.
  //   Process messages in order, maintaining a running sum and count.
  //   Return a List[(Double, Double)] where each tuple is (messageValue, runningAverage)
  //   at that point in the stream.
  def exercise5_runningAverage(stream: ClientStream[Double]): List[(Double, Double)] = ???

  // Exercise 6: Implement early termination
  // TODO: Given a ClientStream[Int] and a threshold, process messages until
  //   the running sum exceeds the threshold. Return an AggregateResponse[Long]
  //   with the sum at the point of termination and the count of messages
  //   actually processed (not the total in the stream).
  def exercise6_earlyTermination(stream: ClientStream[Int], threshold: Long): AggregateResponse[Long] = ???

  // Exercise 7: Deduplicate a client stream
  // TODO: Given a ClientStream[T] where T has a natural equality, remove
  //   duplicate values (keep the first occurrence). Return a new ClientStream[T]
  //   with re-numbered sequence numbers starting from 0 and state = HalfClosed.
  def exercise7_deduplicateStream[T](stream: ClientStream[T]): ClientStream[T] = ???

  // Exercise 8: Batch client stream messages
  // TODO: Given a ClientStream[T] and a batchSize, group messages into batches
  //   of at most batchSize. Return a List[List[T]] where each inner list
  //   is one batch of values (in order). The last batch may be smaller.
  def exercise8_batchMessages[T](stream: ClientStream[T], batchSize: Int): List[List[T]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val stream = exercise1_buildClientStream(List("a", "b", "c"))
    assert(stream.messages.length == 3, "Exercise 1 failed: wrong count")
    assert(stream.messages.head.sequenceNumber == 0, "Exercise 1 failed: wrong seq")
    assert(stream.messages(2).value == "c", "Exercise 1 failed: wrong value")
    assert(stream.state == ClientStreamState.HalfClosed, "Exercise 1 failed: wrong state")
    println("Exercise 1 passed: client stream built")

    // Exercise 2
    val intStream = exercise1_buildClientStream(List(10, 20, 30))
    val sumResult = exercise2_aggregateSum(intStream)
    assert(sumResult.result == 60L, "Exercise 2 failed: wrong sum")
    assert(sumResult.messagesProcessed == 3, "Exercise 2 failed: wrong count")
    println("Exercise 2 passed: sum aggregation correct")

    // Exercise 3
    val collected = exercise3_collectAll(exercise1_buildClientStream(List(1, 2, 3)))
    assert(collected.result == List(1, 2, 3), "Exercise 3 failed: wrong collection")
    assert(collected.messagesProcessed == 3, "Exercise 3 failed: wrong count")
    println("Exercise 3 passed: collect all correct")

    // Exercise 4
    val chunks = List(
      UploadChunk(Array[Byte](1, 2, 3), 0, isLast = false),
      UploadChunk(Array[Byte](4, 5), 3, isLast = true)
    )
    val uploadResult = exercise4_processUpload(chunks)
    assert(uploadResult.totalBytes == 5, "Exercise 4 failed: wrong total bytes")
    assert(uploadResult.chunkCount == 2, "Exercise 4 failed: wrong chunk count")
    assert(uploadResult.checksum == 15L, "Exercise 4 failed: wrong checksum")
    println("Exercise 4 passed: upload processing correct")

    // Exercise 5
    val doubleStream = exercise1_buildClientStream(List(10.0, 20.0, 30.0))
    val running = exercise5_runningAverage(doubleStream)
    assert(running.length == 3, "Exercise 5 failed: wrong length")
    assert(running(0) == (10.0, 10.0), "Exercise 5 failed: first avg")
    assert(running(1) == (20.0, 15.0), "Exercise 5 failed: second avg")
    assert(running(2) == (30.0, 20.0), "Exercise 5 failed: third avg")
    println("Exercise 5 passed: running average correct")

    // Exercise 6
    val earlyStream = exercise1_buildClientStream(List(10, 20, 30, 40, 50))
    val early = exercise6_earlyTermination(earlyStream, 35)
    assert(early.result == 60L, "Exercise 6 failed: wrong sum, got " + early.result)
    assert(early.messagesProcessed == 3, "Exercise 6 failed: wrong count, got " + early.messagesProcessed)
    println("Exercise 6 passed: early termination correct")

    // Exercise 7
    val dupStream = exercise1_buildClientStream(List(1, 2, 3, 2, 1, 4))
    val deduped = exercise7_deduplicateStream(dupStream)
    assert(deduped.messages.map(_.value) == List(1, 2, 3, 4), "Exercise 7 failed: wrong values")
    assert(deduped.messages.head.sequenceNumber == 0, "Exercise 7 failed: not renumbered")
    assert(deduped.messages.last.sequenceNumber == 3, "Exercise 7 failed: wrong last seq")
    println("Exercise 7 passed: deduplication correct")

    // Exercise 8
    val batchStream = exercise1_buildClientStream(List(1, 2, 3, 4, 5, 6, 7))
    val batches = exercise8_batchMessages(batchStream, 3)
    assert(batches == List(List(1, 2, 3), List(4, 5, 6), List(7)),
      "Exercise 8 failed: wrong batches " + batches)
    println("Exercise 8 passed: batching correct")

    println("\nAll Grpc007_ClientStreaming exercises passed!")
  }
}
