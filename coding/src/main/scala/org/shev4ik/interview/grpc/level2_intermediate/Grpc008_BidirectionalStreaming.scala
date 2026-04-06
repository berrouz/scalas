package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC 008 - Bidirectional Streaming
 *
 * Bidirectional streaming: both client and server send streams of messages.
 * Key concepts:
 *   - Both sides can read and write independently
 *   - Messages can be interleaved in any order
 *   - Common patterns: chat, real-time collaboration, game state sync
 *   - Each side can close its half independently (half-close)
 *   - Order is preserved within each direction but not across
 *   - Useful for long-lived connections with ongoing data exchange
 */
object Grpc008_BidirectionalStreaming {

  // --- Domain models for exercises ---

  sealed trait Direction
  object Direction {
    case object ClientToServer extends Direction
    case object ServerToClient extends Direction
  }

  case class BidiMessage[T](
    value: T,
    direction: Direction,
    sequenceNumber: Int,
    timestamp: Long
  )

  case class BidiStream[T](
    messages: List[BidiMessage[T]],
    clientClosed: Boolean,
    serverClosed: Boolean
  )

  case class ChatMessage(
    sender: String,
    content: String,
    timestamp: Long
  )

  case class ChatRoom(
    name: String,
    participants: Set[String],
    history: List[ChatMessage]
  )

  // Exercise 1: Create a bidirectional stream from interleaved messages
  // TODO: Given a list of (value, direction) pairs, create a BidiStream with:
  //   - sequenceNumber starting at 0, incrementing for each message
  //   - timestamp = sequenceNumber * 100 (simulated)
  //   - clientClosed = false, serverClosed = false
  def exercise1_createBidiStream[T](
    messages: List[(T, Direction)]
  ): BidiStream[T] = ???

  // Exercise 2: Separate a bidi stream into client and server message lists
  // TODO: Given a BidiStream[T], return a tuple (clientMessages, serverMessages)
  //   where each is a List[T] of values in their original order.
  def exercise2_separateDirections[T](stream: BidiStream[T]): (List[T], List[T]) = ???

  // Exercise 3: Implement a simple echo protocol
  // TODO: Given a list of client messages (Strings), simulate an echo server.
  //   For each client message, the server responds with "echo: " + message.
  //   Return a BidiStream[String] with alternating client/server messages.
  //   Sequence numbers should be global (0, 1, 2, 3, ...).
  //   Timestamp = sequenceNumber * 100. Both sides closed at the end.
  def exercise3_echoProtocol(clientMessages: List[String]): BidiStream[String] = ???

  // Exercise 4: Simulate a chat room
  // TODO: Given a ChatRoom and a new ChatMessage, add the message to history
  //   only if the sender is a participant. Return the updated ChatRoom.
  //   If sender is not a participant, return the room unchanged.
  def exercise4_addChatMessage(room: ChatRoom, message: ChatMessage): ChatRoom = ???

  // Exercise 5: Process a bidi stream with a request-response pattern
  // TODO: Given a BidiStream[String] where client messages are "commands",
  //   produce a new BidiStream[String] that includes both the original client
  //   messages and server responses. Server response rules:
  //     "ping" -> server responds "pong"
  //     "time" -> server responds "1000" (simulated timestamp)
  //     anything else -> server responds "unknown command"
  //   Output should have client msg followed by server response, alternating.
  //   Re-number all sequence numbers from 0. Timestamps = seq * 100.
  //   Both sides closed.
  def exercise5_requestResponsePattern(
    clientMessages: List[String]
  ): BidiStream[String] = ???

  // Exercise 6: Detect out-of-order messages in a bidi stream
  // TODO: Given a BidiStream[T], check if messages within each direction
  //   are ordered by timestamp (each message's timestamp >= previous in same direction).
  //   Return (clientOrdered: Boolean, serverOrdered: Boolean).
  def exercise6_checkOrdering[T](stream: BidiStream[T]): (Boolean, Boolean) = ???

  // Exercise 7: Implement windowed aggregation on a bidi stream
  // TODO: Given a BidiStream[Int] and a windowSize, collect all values
  //   (regardless of direction) in sliding windows of the given size.
  //   Return a List[Int] where each element is the sum of one window.
  //   Use a sliding window with step 1.
  //   Example: values [1,2,3,4,5], windowSize=3 -> [6, 9, 12]
  def exercise7_windowedAggregation(stream: BidiStream[Int], windowSize: Int): List[Int] = ???

  // Exercise 8: Implement rate limiting on a bidi stream
  // TODO: Given a BidiStream[T] and a maxMessagesPerDirection Int,
  //   truncate each direction to at most maxMessagesPerDirection messages
  //   (keeping the earliest ones). Preserve the overall ordering of remaining messages.
  //   Re-number sequence numbers from 0. Keep original timestamps.
  //   clientClosed and serverClosed should both be true.
  def exercise8_rateLimitStream[T](
    stream: BidiStream[T],
    maxMessagesPerDirection: Int
  ): BidiStream[T] = ???

  def main(args: Array[String]): Unit = {
    import Direction._

    // Exercise 1
    val bidi = exercise1_createBidiStream(List(
      ("hello", ClientToServer),
      ("hi", ServerToClient),
      ("how are you", ClientToServer)
    ))
    assert(bidi.messages.length == 3, "Exercise 1 failed: wrong count")
    assert(bidi.messages.head.sequenceNumber == 0, "Exercise 1 failed: wrong seq")
    assert(bidi.messages(1).direction == ServerToClient, "Exercise 1 failed: wrong direction")
    assert(bidi.messages(2).timestamp == 200, "Exercise 1 failed: wrong timestamp")
    println("Exercise 1 passed: bidi stream created")

    // Exercise 2
    val (clientMsgs, serverMsgs) = exercise2_separateDirections(bidi)
    assert(clientMsgs == List("hello", "how are you"), "Exercise 2 failed: wrong client msgs")
    assert(serverMsgs == List("hi"), "Exercise 2 failed: wrong server msgs")
    println("Exercise 2 passed: directions separated")

    // Exercise 3
    val echo = exercise3_echoProtocol(List("a", "b"))
    assert(echo.messages.length == 4, "Exercise 3 failed: wrong count")
    assert(echo.messages(0).value == "a", "Exercise 3 failed: first msg")
    assert(echo.messages(1).value == "echo: a", "Exercise 3 failed: first echo")
    assert(echo.messages(2).value == "b", "Exercise 3 failed: second msg")
    assert(echo.messages(3).value == "echo: b", "Exercise 3 failed: second echo")
    assert(echo.clientClosed && echo.serverClosed, "Exercise 3 failed: not closed")
    println("Exercise 3 passed: echo protocol correct")

    // Exercise 4
    val room = ChatRoom("general", Set("alice", "bob"), List.empty)
    val updated = exercise4_addChatMessage(room, ChatMessage("alice", "hello", 1000))
    assert(updated.history.length == 1, "Exercise 4 failed: message not added")
    val unchanged = exercise4_addChatMessage(room, ChatMessage("eve", "hack", 1001))
    assert(unchanged.history.isEmpty, "Exercise 4 failed: non-participant added")
    println("Exercise 4 passed: chat room messaging correct")

    // Exercise 5
    val reqResp = exercise5_requestResponsePattern(List("ping", "time", "foo"))
    assert(reqResp.messages.length == 6, "Exercise 5 failed: wrong count")
    assert(reqResp.messages(1).value == "pong", "Exercise 5 failed: ping response")
    assert(reqResp.messages(3).value == "1000", "Exercise 5 failed: time response")
    assert(reqResp.messages(5).value == "unknown command", "Exercise 5 failed: unknown")
    println("Exercise 5 passed: request-response pattern correct")

    // Exercise 6
    val orderedStream = exercise1_createBidiStream(List(
      ("a", ClientToServer), ("b", ServerToClient), ("c", ClientToServer), ("d", ServerToClient)
    ))
    val (co, so) = exercise6_checkOrdering(orderedStream)
    assert(co && so, "Exercise 6 failed: should both be ordered")
    println("Exercise 6 passed: ordering check correct")

    // Exercise 7
    val numStream = exercise1_createBidiStream(List(
      (1, ClientToServer), (2, ServerToClient), (3, ClientToServer), (4, ServerToClient), (5, ClientToServer)
    ))
    val windows = exercise7_windowedAggregation(numStream, 3)
    assert(windows == List(6, 9, 12), "Exercise 7 failed: wrong windows " + windows)
    println("Exercise 7 passed: windowed aggregation correct")

    // Exercise 8
    val mixedStream = exercise1_createBidiStream(List(
      ("c1", ClientToServer), ("s1", ServerToClient),
      ("c2", ClientToServer), ("s2", ServerToClient),
      ("c3", ClientToServer), ("s3", ServerToClient)
    ))
    val limited = exercise8_rateLimitStream(mixedStream, 2)
    val (limClient, limServer) = exercise2_separateDirections(limited)
    assert(limClient == List("c1", "c2"), "Exercise 8 failed: wrong client msgs " + limClient)
    assert(limServer == List("s1", "s2"), "Exercise 8 failed: wrong server msgs " + limServer)
    assert(limited.messages.head.sequenceNumber == 0, "Exercise 8 failed: not renumbered")
    assert(limited.clientClosed && limited.serverClosed, "Exercise 8 failed: not closed")
    println("Exercise 8 passed: rate limiting correct")

    println("\nAll Grpc008_BidirectionalStreaming exercises passed!")
  }
}
