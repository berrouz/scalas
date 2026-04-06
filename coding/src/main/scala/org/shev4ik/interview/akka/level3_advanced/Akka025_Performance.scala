package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 025 - Performance Tuning
 *
 * Performance optimization in Akka:
 *   - Mailbox types: unbounded, bounded, priority
 *   - Bounded mailbox: limits queue size with overflow strategies
 *   - Priority mailbox: orders messages by priority
 *   - Throughput tuning: messages per actor invocation
 *   - Serialization: choosing efficient serialization formats
 *   - Remote config: Akka Remoting for cross-JVM communication
 *   - Artery transport: high-performance remoting with Aeron/TCP
 *   - Back-pressure: flow control in actor messaging
 *
 * We model these concepts using pure Scala.
 */
object Akka025_Performance {

  // --- Domain models ---

  sealed trait MailboxType
  case object UnboundedMailbox extends MailboxType
  case class BoundedMailbox(capacity: Int, pushTimeoutMs: Long) extends MailboxType
  case class PriorityMailbox(priorityFn: Any => Int) extends MailboxType

  case class Mailbox(
    mailboxType: MailboxType,
    messages: List[(Any, Int)], // (message, priority)
    droppedCount: Int
  )

  sealed trait SerializationFormat
  case object JavaSerialization extends SerializationFormat
  case object ProtobufSerialization extends SerializationFormat
  case object KryoSerialization extends SerializationFormat
  case object JsonSerialization extends SerializationFormat

  case class SerializationConfig(
    format: SerializationFormat,
    estimatedSizeBytes: Int,
    estimatedLatencyMs: Double
  )

  case class RemoteConfig(
    hostname: String,
    port: Int,
    transport: String, // "artery-tcp", "artery-aeron", "classic-netty"
    maxFrameSize: Int,
    heartbeatIntervalMs: Long
  )

  case class ThroughputConfig(
    throughput: Int,           // messages per batch
    throughputDeadlineMs: Long // max time per batch
  )

  case class BackPressureState(
    pendingMessages: Int,
    maxPending: Int,
    isBackPressured: Boolean,
    droppedCount: Int
  )

  // Exercise 1: Mailbox types — unbounded, bounded, priority
  // TODO: Given a MailboxType and a list of messages, simulate mailbox behavior:
  //   - UnboundedMailbox: accept all messages with priority 0
  //   - BoundedMailbox: accept up to capacity, drop newest when full (increment droppedCount)
  //   - PriorityMailbox: accept all, assign priority using priorityFn, sort by priority (lowest first)
  //   Return the final Mailbox state.
  def exercise1_mailboxTypes(mailboxType: MailboxType, messages: List[Any]): Mailbox = ???

  // Exercise 2: Bounded mailbox with overflow strategy
  // TODO: Simulate a bounded mailbox with different overflow strategies.
  //   Given a capacity and messages:
  //   strategy "drop-newest": reject new messages when full
  //   strategy "drop-oldest": drop oldest message, add new one
  //   strategy "drop-head": same as drop-oldest
  //   Return (final messages in mailbox, dropped count).
  def exercise2_boundedMailbox(
    capacity: Int,
    messages: List[String],
    strategy: String
  ): (List[String], Int) = ???

  // Exercise 3: Priority mailbox — message ordering
  // TODO: Given a list of messages with priorities (message, priority),
  //   dequeue them in priority order (lowest priority value = highest priority).
  //   For equal priorities, maintain insertion order (stable sort).
  //   Return the messages in dequeue order.
  def exercise3_priorityMailbox(messages: List[(String, Int)]): List[String] = ???

  // Exercise 4: Throughput tuning simulation
  // TODO: Given a ThroughputConfig and a list of messages with processing times (ms),
  //   simulate batch processing:
  //   Process up to `throughput` messages or until `throughputDeadlineMs` is reached.
  //   Return list of batches, where each batch is a list of messages processed together.
  def exercise4_throughputTuning(
    config: ThroughputConfig,
    messagesWithTime: List[(String, Long)] // (message, processingTimeMs)
  ): List[List[String]] = ???

  // Exercise 5: Serialization format comparison
  // TODO: Given a message size (bytes) and a list of SerializationFormats,
  //   calculate estimated metrics for each format:
  //   - JavaSerialization: size * 2.0 bytes, 1.0 ms latency per KB
  //   - ProtobufSerialization: size * 0.6 bytes, 0.2 ms latency per KB
  //   - KryoSerialization: size * 0.8 bytes, 0.3 ms latency per KB
  //   - JsonSerialization: size * 1.5 bytes, 0.5 ms latency per KB
  //   Return list of SerializationConfig sorted by estimated latency (fastest first).
  def exercise5_serializationComparison(
    messageSizeBytes: Int,
    formats: List[SerializationFormat]
  ): List[SerializationConfig] = ???

  // Exercise 6: Remote config generation
  // TODO: Given hostname, port, and transport type, create a RemoteConfig:
  //   "artery-tcp": maxFrameSize = 256000, heartbeatIntervalMs = 1000
  //   "artery-aeron": maxFrameSize = 1048576, heartbeatIntervalMs = 500
  //   "classic-netty": maxFrameSize = 128000, heartbeatIntervalMs = 2000
  def exercise6_remoteConfig(hostname: String, port: Int, transport: String): RemoteConfig = ???

  // Exercise 7: Artery transport — frame size validation
  // TODO: Given a RemoteConfig and a list of message sizes (bytes),
  //   determine which messages can be sent (size <= maxFrameSize).
  //   Return (sendable count, oversized count, largest oversized or 0).
  def exercise7_arteryTransport(
    config: RemoteConfig,
    messageSizes: List[Int]
  ): (Int, Int, Int) = ???

  // Exercise 8: Back-pressure simulation
  // TODO: Simulate back-pressure in actor messaging.
  //   Given a BackPressureState and a list of operations:
  //   "send": if pendingMessages < maxPending, increment pending; else increment dropped, set isBackPressured
  //   "ack": if pendingMessages > 0, decrement pending; if pending < maxPending/2, clear isBackPressured
  //   Return the final BackPressureState.
  def exercise8_backPressure(
    initial: BackPressureState,
    operations: List[String]
  ): BackPressureState = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1a = exercise1_mailboxTypes(UnboundedMailbox, List("a", "b", "c"))
    assert(r1a.messages.size == 3, s"Exercise 1 failed: unbounded size = ${r1a.messages.size}")
    assert(r1a.droppedCount == 0, "Exercise 1 failed: unbounded should not drop")

    val r1b = exercise1_mailboxTypes(BoundedMailbox(2, 0), List("a", "b", "c", "d"))
    assert(r1b.messages.size == 2, s"Exercise 1 failed: bounded size = ${r1b.messages.size}")
    assert(r1b.droppedCount == 2, s"Exercise 1 failed: bounded dropped = ${r1b.droppedCount}")

    val priorityFn: Any => Int = {
      case s: String if s.startsWith("HIGH") => 0
      case s: String if s.startsWith("LOW") => 2
      case _ => 1
    }
    val r1c = exercise1_mailboxTypes(PriorityMailbox(priorityFn), List("LOW-1", "MED-1", "HIGH-1", "MED-2"))
    assert(r1c.messages.head._1 == "HIGH-1", s"Exercise 1 failed: priority head = ${r1c.messages.head}")
    println("Exercise 1 passed: mailbox types")

    // Exercise 2
    val (msgs2a, drop2a) = exercise2_boundedMailbox(3, List("a", "b", "c", "d", "e"), "drop-newest")
    assert(msgs2a == List("a", "b", "c"), s"Exercise 2 failed: drop-newest = $msgs2a")
    assert(drop2a == 2, s"Exercise 2 failed: dropped = $drop2a")
    val (msgs2b, drop2b) = exercise2_boundedMailbox(3, List("a", "b", "c", "d", "e"), "drop-oldest")
    assert(msgs2b == List("c", "d", "e"), s"Exercise 2 failed: drop-oldest = $msgs2b")
    assert(drop2b == 2, s"Exercise 2 failed: dropped = $drop2b")
    println("Exercise 2 passed: bounded mailbox strategies")

    // Exercise 3
    val r3 = exercise3_priorityMailbox(List(("low", 3), ("high", 1), ("med", 2), ("high2", 1)))
    assert(r3 == List("high", "high2", "med", "low"), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = exercise4_throughputTuning(
      ThroughputConfig(3, 100),
      List(("a", 30L), ("b", 30L), ("c", 30L), ("d", 30L), ("e", 30L))
    )
    assert(r4(0) == List("a", "b", "c"), s"Exercise 4 failed: batch 1 = ${r4(0)}")
    assert(r4(1) == List("d", "e"), s"Exercise 4 failed: batch 2 = ${r4(1)}")
    println(s"Exercise 4 passed: ${r4.size} batches")

    // Exercise 5
    val r5 = exercise5_serializationComparison(1024, List(JavaSerialization, ProtobufSerialization, KryoSerialization))
    assert(r5.head.format == ProtobufSerialization, s"Exercise 5 failed: fastest = ${r5.head.format}")
    println(s"Exercise 5 passed: fastest = ${r5.head.format}")

    // Exercise 6
    val r6 = exercise6_remoteConfig("10.0.0.1", 2551, "artery-tcp")
    assert(r6.maxFrameSize == 256000, s"Exercise 6 failed: maxFrameSize = ${r6.maxFrameSize}")
    assert(r6.heartbeatIntervalMs == 1000, s"Exercise 6 failed: heartbeat = ${r6.heartbeatIntervalMs}")
    println(s"Exercise 6 passed: ${r6.transport} configured")

    // Exercise 7
    val (sendable7, oversized7, largest7) = exercise7_arteryTransport(r6, List(100, 256000, 300000, 50000))
    assert(sendable7 == 3, s"Exercise 7 failed: sendable = $sendable7")
    assert(oversized7 == 1, s"Exercise 7 failed: oversized = $oversized7")
    assert(largest7 == 300000, s"Exercise 7 failed: largest = $largest7")
    println(s"Exercise 7 passed: sendable=$sendable7, oversized=$oversized7")

    // Exercise 8
    val bp0 = BackPressureState(0, 3, isBackPressured = false, 0)
    val r8 = exercise8_backPressure(bp0, List("send", "send", "send", "send", "ack", "ack", "send"))
    assert(r8.pendingMessages == 2, s"Exercise 8 failed: pending = ${r8.pendingMessages}")
    assert(r8.droppedCount == 1, s"Exercise 8 failed: dropped = ${r8.droppedCount}")
    assert(!r8.isBackPressured, s"Exercise 8 failed: should not be back-pressured after acks")
    println(s"Exercise 8 passed: pending=${r8.pendingMessages}, dropped=${r8.droppedCount}")

    println("\nAll Akka025_Performance exercises passed!")
  }
}
