package org.shev4ik.interview.system_design.level2_patterns

object SysDes005_MessageQueue {

  // ---- Domain types ----

  case class Message(id: String, payload: String, priority: Int = 0, timestamp: Long = 0L)

  // ---- Exercise 1 ----
  // TODO: Implement a simple FIFO message queue.
  // - `enqueue(msg)`: add message to the back
  // - `dequeue`: remove and return message from the front as (updatedQueue, Option[Message])
  // - `peek`: return front message without removing
  // - `size`: number of messages in the queue
  trait SimpleQueue {
    def enqueue(msg: Message): SimpleQueue
    def dequeue: (SimpleQueue, Option[Message])
    def peek: Option[Message]
    def size: Int
  }

  def createSimpleQueue(): SimpleQueue = ???

  // ---- Exercise 2 ----
  // TODO: Implement a priority message queue.
  // Higher priority value = higher priority (dequeued first).
  // Break ties by timestamp (earlier first).
  // Same interface as SimpleQueue.
  def createPriorityQueue(): SimpleQueue = ???

  // ---- Exercise 3 ----
  // TODO: Implement a publish/subscribe pattern.
  // - `subscribe(topic, subscriberId)`: register a subscriber to a topic
  // - `unsubscribe(topic, subscriberId)`: remove subscriber from a topic
  // - `publish(topic, message)`: deliver message to all subscribers of the topic.
  //   Store delivered messages per subscriber.
  // - `messagesFor(subscriberId)`: return all messages delivered to a subscriber
  trait PubSub {
    def subscribe(topic: String, subscriberId: String): PubSub
    def unsubscribe(topic: String, subscriberId: String): PubSub
    def publish(topic: String, message: Message): PubSub
    def messagesFor(subscriberId: String): List[Message]
  }

  def createPubSub(): PubSub = ???

  // ---- Exercise 4 ----
  // TODO: Implement message ordering guarantee.
  // Given messages with a sequence number (use `priority` field as seqNum),
  // reorder a list of potentially out-of-order messages into sequence order.
  // If there are gaps, only return the contiguous prefix starting from `startSeqNum`.
  // Example: msgs=[seq3, seq1, seq2, seq5], start=1 => [seq1, seq2, seq3]
  def reorderMessages(messages: List[Message], startSeqNum: Int): List[Message] = ???

  // ---- Exercise 5 ----
  // TODO: Simulate at-least-once delivery.
  // Process each message with a handler. If the handler returns false (failure),
  // the message is retried up to `maxRetries` times.
  // Return the list of (messageId, attempts) for all messages.
  def atLeastOnceDelivery(
    messages: List[Message],
    handler: Message => Boolean,
    maxRetries: Int
  ): List[(String, Int)] = ???

  // ---- Exercise 6 ----
  // TODO: Simulate at-most-once delivery.
  // Process each message exactly once with the handler. No retries.
  // Return list of (messageId, success: Boolean).
  def atMostOnceDelivery(
    messages: List[Message],
    handler: Message => Boolean
  ): List[(String, Boolean)] = ???

  // ---- Exercise 7 ----
  // TODO: Implement a dead letter queue (DLQ).
  // Process messages from the main queue. If processing fails after `maxRetries`,
  // move the message to the DLQ.
  // Return (successfullyProcessed: List[Message], deadLetterQueue: List[Message])
  def processWithDLQ(
    messages: List[Message],
    handler: Message => Boolean,
    maxRetries: Int
  ): (List[Message], List[Message]) = ???

  // ---- Exercise 8 ----
  // TODO: Implement message deduplication.
  // Given a stream of messages (some with duplicate IDs), return only unique messages.
  // Keep the first occurrence of each message ID.
  // Also provide a function that takes a queue and a new message, and only enqueues
  // if the message ID hasn't been seen before.
  def deduplicateMessages(messages: List[Message]): List[Message] = ???

  def enqueueWithDedup(
    queue: SimpleQueue,
    seenIds: Set[String],
    msg: Message
  ): (SimpleQueue, Set[String]) = ???

  def main(args: Array[String]): Unit = {
    val m1 = Message("m1", "hello", timestamp = 1)
    val m2 = Message("m2", "world", timestamp = 2)
    val m3 = Message("m3", "foo", timestamp = 3)

    // Exercise 1: Simple Queue
    val q0 = createSimpleQueue()
    val q1 = q0.enqueue(m1).enqueue(m2).enqueue(m3)
    assert(q1.size == 3)
    assert(q1.peek.contains(m1))
    val (q2, d1) = q1.dequeue
    assert(d1.contains(m1))
    val (q3, d2) = q2.dequeue
    assert(d2.contains(m2))
    assert(q3.size == 1)
    println("Exercise 1 passed: Simple Queue")

    // Exercise 2: Priority Queue
    val pm1 = Message("pm1", "low", priority = 1, timestamp = 1)
    val pm2 = Message("pm2", "high", priority = 10, timestamp = 2)
    val pm3 = Message("pm3", "mid", priority = 5, timestamp = 3)
    val pq = createPriorityQueue().enqueue(pm1).enqueue(pm2).enqueue(pm3)
    val (pq2, pd1) = pq.dequeue
    assert(pd1.get.id == "pm2") // highest priority
    val (_, pd2) = pq2.dequeue
    assert(pd2.get.id == "pm3") // next highest
    println("Exercise 2 passed: Priority Queue")

    // Exercise 3: Pub/Sub
    val ps0 = createPubSub()
    val ps1 = ps0.subscribe("news", "sub1").subscribe("news", "sub2").subscribe("sports", "sub1")
    val ps2 = ps1.publish("news", m1).publish("sports", m2)
    assert(ps2.messagesFor("sub1").length == 2) // gets news + sports
    assert(ps2.messagesFor("sub2").length == 1) // gets news only
    val ps3 = ps2.unsubscribe("news", "sub2")
    val ps4 = ps3.publish("news", m3)
    assert(ps4.messagesFor("sub2").length == 1) // still 1, unsubscribed
    println("Exercise 3 passed: Pub/Sub")

    // Exercise 4: Message ordering
    val unordered = List(
      Message("a", "x", priority = 3),
      Message("b", "x", priority = 1),
      Message("c", "x", priority = 2),
      Message("d", "x", priority = 5)
    )
    val ordered = reorderMessages(unordered, startSeqNum = 1)
    assert(ordered.map(_.priority) == List(1, 2, 3)) // gap at 4, stops at 3
    println("Exercise 4 passed: Message ordering")

    // Exercise 5: At-least-once delivery
    var attempt = 0
    val failFirst: Message => Boolean = _ => { attempt += 1; attempt > 1 }
    val results5 = atLeastOnceDelivery(List(Message("x", "data")), failFirst, maxRetries = 3)
    assert(results5.head._2 == 2) // succeeded on 2nd attempt
    println("Exercise 5 passed: At-least-once delivery")

    // Exercise 6: At-most-once delivery
    val results6 = atMostOnceDelivery(List(m1, m2), _ => true)
    assert(results6 == List(("m1", true), ("m2", true)))
    val results6b = atMostOnceDelivery(List(m1), _ => false)
    assert(results6b == List(("m1", false)))
    println("Exercise 6 passed: At-most-once delivery")

    // Exercise 7: Dead Letter Queue
    val (processed, dlq) = processWithDLQ(
      List(m1, m2, m3),
      msg => msg.id != "m2",
      maxRetries = 2
    )
    assert(processed.map(_.id) == List("m1", "m3"))
    assert(dlq.map(_.id) == List("m2"))
    println("Exercise 7 passed: Dead Letter Queue")

    // Exercise 8: Message deduplication
    val duped = List(
      Message("m1", "first"),
      Message("m2", "second"),
      Message("m1", "duplicate")
    )
    val deduped = deduplicateMessages(duped)
    assert(deduped.length == 2)
    assert(deduped.head.payload == "first")
    val (eq, seenIds) = enqueueWithDedup(createSimpleQueue(), Set.empty, m1)
    val (eq2, seenIds2) = enqueueWithDedup(eq, seenIds, m1)
    assert(eq2.size == 1) // duplicate not added
    assert(seenIds2.contains("m1"))
    println("Exercise 8 passed: Message deduplication")

    println("All SysDes005_MessageQueue exercises passed!")
  }
}
