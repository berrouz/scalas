package org.shev4ik.interview.http4s.level3_advanced

/**
 * Http4s 012 - Server-Sent Events (SSE)
 *
 * One-way streaming from server to client. Key concepts:
 *   - SSE protocol: text/event-stream content type
 *   - Event format: data, event type, id, retry
 *   - Event source (client-side reconnection)
 *   - Last-Event-ID header for resumption
 *   - Multiple data lines in a single event
 *   - Named event types for client-side dispatch
 */
object Http012_ServerSentEvents {

  // --- Domain models ---

  case class ServerSentEvent(
    data: String,
    eventType: Option[String],
    id: Option[String],
    retry: Option[Int]   // milliseconds
  )

  case class EventSource(
    url: String,
    lastEventId: Option[String],
    retryInterval: Int,   // millis, default 3000
    connected: Boolean
  )

  case class EventStream(events: List[ServerSentEvent]) {
    def isEmpty: Boolean = events.isEmpty
    def size: Int = events.size
  }

  sealed trait EventSourceState
  object EventSourceState {
    case object Connecting extends EventSourceState
    case object Open       extends EventSourceState
    case object Closed     extends EventSourceState
  }

  // Exercise 1: Serialize a single SSE event to wire format
  // TODO: Convert a ServerSentEvent to its text representation:
  //   If eventType is Some(t): "event: $t\n"
  //   If id is Some(i): "id: $i\n"
  //   If retry is Some(r): "retry: $r\n"
  //   Data lines: "data: $data\n" (split multi-line data into separate "data: " lines)
  //   End with an extra "\n" (blank line terminates the event)
  //   Example: ServerSentEvent("hello", Some("message"), Some("1"), None) ->
  //     "event: message\nid: 1\ndata: hello\n\n"
  def exercise1_serializeEvent(event: ServerSentEvent): String = ???

  // Exercise 2: Parse an SSE event from wire format
  // TODO: Given a string in SSE format, parse it into a ServerSentEvent.
  //   Lines starting with "data: " contribute to the data field (join with "\n" if multiple).
  //   Lines starting with "event: " set the eventType.
  //   Lines starting with "id: " set the id.
  //   Lines starting with "retry: " set the retry (parse as Int).
  //   Ignore lines starting with ":" (comments) and empty lines.
  //   Return the parsed event.
  def exercise2_parseEvent(raw: String): ServerSentEvent = ???

  // Exercise 3: Create an event stream from a list of data strings
  // TODO: Given a list of (data, eventType) pairs and a starting ID (Int),
  //   create an EventStream where each event has:
  //   - data from the pair
  //   - eventType from the pair
  //   - id = Some(startId + index) as string
  //   - retry = None
  def exercise3_createStream(
    items: List[(String, String)],
    startId: Int
  ): EventStream = ???

  // Exercise 4: Filter events by type
  // TODO: Given an EventStream and a set of allowed event types,
  //   return a new EventStream containing only events whose eventType
  //   is in the allowed set. Events with None eventType are excluded.
  def exercise4_filterByType(stream: EventStream, allowedTypes: Set[String]): EventStream = ???

  // Exercise 5: Resume an event stream from a Last-Event-ID
  // TODO: Given an EventStream and a lastEventId string, return a new EventStream
  //   that contains only events AFTER the one with the given id.
  //   If the id is not found, return the full stream.
  //   Events without ids are always included if they come after the matching event.
  def exercise5_resumeFrom(stream: EventStream, lastEventId: String): EventStream = ???

  // Exercise 6: Merge two event streams in order of their IDs
  // TODO: Given two EventStreams where events have numeric string IDs,
  //   merge them into a single stream sorted by ID (ascending, numeric order).
  //   Events without IDs go to the end.
  def exercise6_mergeStreams(stream1: EventStream, stream2: EventStream): EventStream = ???

  // Exercise 7: Create a heartbeat/keep-alive event
  // TODO: Given a stream of events, insert a "heartbeat" event (SSE comment)
  //   every N events. A heartbeat event has data = "", eventType = Some("heartbeat"),
  //   id = None, retry = None.
  //   Insert AFTER every N regular events.
  //   Example: N=2, events [A, B, C, D] -> [A, B, heartbeat, C, D, heartbeat]
  def exercise7_withHeartbeats(stream: EventStream, interval: Int): EventStream = ???

  // Exercise 8: Serialize a full event stream to wire format
  // TODO: Serialize all events in the stream to a single string.
  //   Set the retry on the FIRST event only (if retryMs is provided).
  //   Each event is separated by a blank line (already part of serialization).
  //   Prepend a comment line ": stream start\n" at the beginning.
  def exercise8_serializeStream(stream: EventStream, retryMs: Option[Int]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val event = ServerSentEvent("hello", Some("message"), Some("1"), None)
    val serialized = exercise1_serializeEvent(event)
    assert(serialized.contains("event: message"), "Exercise 1 failed: missing event type")
    assert(serialized.contains("id: 1"), "Exercise 1 failed: missing id")
    assert(serialized.contains("data: hello"), "Exercise 1 failed: missing data")
    assert(serialized.endsWith("\n\n"), "Exercise 1 failed: should end with blank line")
    val multiLine = ServerSentEvent("line1\nline2", None, None, None)
    val multiSer = exercise1_serializeEvent(multiLine)
    assert(multiSer.contains("data: line1\ndata: line2"), "Exercise 1 failed: multi-line data")
    println("Exercise 1 passed: event serialization works")

    // Exercise 2
    val parsed = exercise2_parseEvent("event: update\nid: 42\ndata: hello world\n\n")
    assert(parsed.data == "hello world", s"Exercise 2 failed: wrong data '${parsed.data}'")
    assert(parsed.eventType.contains("update"), "Exercise 2 failed: wrong event type")
    assert(parsed.id.contains("42"), "Exercise 2 failed: wrong id")
    val multiParsed = exercise2_parseEvent("data: line1\ndata: line2\n\n")
    assert(multiParsed.data == "line1\nline2", "Exercise 2 failed: multi-line data")
    println("Exercise 2 passed: event parsing works")

    // Exercise 3
    val items = List(("user joined", "join"), ("message sent", "msg"))
    val stream = exercise3_createStream(items, 100)
    assert(stream.size == 2, "Exercise 3 failed: wrong size")
    assert(stream.events.head.id.contains("100"), "Exercise 3 failed: wrong first id")
    assert(stream.events(1).eventType.contains("msg"), "Exercise 3 failed: wrong event type")
    println("Exercise 3 passed: stream creation works")

    // Exercise 4
    val mixedStream = EventStream(List(
      ServerSentEvent("a", Some("chat"), Some("1"), None),
      ServerSentEvent("b", Some("system"), Some("2"), None),
      ServerSentEvent("c", Some("chat"), Some("3"), None),
      ServerSentEvent("d", None, Some("4"), None)
    ))
    val chatOnly = exercise4_filterByType(mixedStream, Set("chat"))
    assert(chatOnly.size == 2, "Exercise 4 failed: should have 2 chat events")
    println("Exercise 4 passed: event filtering works")

    // Exercise 5
    val fullStream = exercise3_createStream(
      List(("a", "msg"), ("b", "msg"), ("c", "msg"), ("d", "msg")),
      1
    )
    val resumed = exercise5_resumeFrom(fullStream, "2")
    assert(resumed.size == 2, s"Exercise 5 failed: expected 2 events after id 2, got ${resumed.size}")
    assert(resumed.events.head.data == "c", "Exercise 5 failed: wrong first resumed event")
    val noMatch = exercise5_resumeFrom(fullStream, "99")
    assert(noMatch.size == 4, "Exercise 5 failed: no match should return full stream")
    println("Exercise 5 passed: stream resumption works")

    // Exercise 6
    val s1 = EventStream(List(
      ServerSentEvent("a", None, Some("1"), None),
      ServerSentEvent("c", None, Some("3"), None)
    ))
    val s2 = EventStream(List(
      ServerSentEvent("b", None, Some("2"), None),
      ServerSentEvent("d", None, Some("4"), None)
    ))
    val merged = exercise6_mergeStreams(s1, s2)
    assert(merged.events.map(_.data) == List("a", "b", "c", "d"), "Exercise 6 failed: wrong merge order")
    println("Exercise 6 passed: stream merging works")

    // Exercise 7
    val regularStream = EventStream(List(
      ServerSentEvent("a", Some("msg"), Some("1"), None),
      ServerSentEvent("b", Some("msg"), Some("2"), None),
      ServerSentEvent("c", Some("msg"), Some("3"), None),
      ServerSentEvent("d", Some("msg"), Some("4"), None)
    ))
    val withHb = exercise7_withHeartbeats(regularStream, 2)
    assert(withHb.size == 6, s"Exercise 7 failed: expected 6 events (4 + 2 heartbeats), got ${withHb.size}")
    assert(withHb.events(2).eventType.contains("heartbeat"), "Exercise 7 failed: 3rd event should be heartbeat")
    println("Exercise 7 passed: heartbeat insertion works")

    // Exercise 8
    val outStream = exercise3_createStream(List(("hello", "msg"), ("world", "msg")), 1)
    val output = exercise8_serializeStream(outStream, Some(3000))
    assert(output.startsWith(": stream start\n"), "Exercise 8 failed: missing stream comment")
    assert(output.contains("retry: 3000"), "Exercise 8 failed: missing retry")
    assert(output.contains("data: hello"), "Exercise 8 failed: missing data")
    println("Exercise 8 passed: stream serialization works")

    println("\nAll Http012_ServerSentEvents exercises passed!")
  }
}
