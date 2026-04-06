package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka 002 - Consumer Basics
 *
 * =Core Concepts=
 *
 * '''Consumer Groups''': Consumers with the same `group.id` form a consumer group. Kafka assigns
 * each partition to exactly one consumer within a group, enabling parallel consumption. If there
 * are more consumers than partitions, some consumers sit idle. If a consumer fails, its partitions
 * are reassigned to surviving members (rebalancing).
 *
 * '''Partition Assignment Strategies''':
 *   - '''Range''' (default): assigns contiguous partition ranges per topic to each consumer.
 *   - '''RoundRobin''': distributes partitions across consumers one by one.
 *   - '''Sticky''': like RoundRobin but minimizes partition movement during rebalance.
 *   - '''CooperativeSticky''': incremental rebalancing -- only revokes partitions that must move.
 *
 * '''Offset Management''':
 *   - Each consumer tracks its position (offset) per partition.
 *   - '''Auto-commit''': offsets committed periodically (default every 5s). Risk: processing
 *     fails after commit -> message lost (at-most-once). Processing succeeds before commit and
 *     consumer crashes -> message reprocessed (at-least-once).
 *   - '''Manual sync commit''' (`commitSync`): blocks until broker confirms. Guarantees at-least-once.
 *   - '''Manual async commit''' (`commitAsync`): non-blocking, no retry on failure. Faster but
 *     less reliable.
 *   - '''Commit at specific offset''': fine-grained control, commit after processing each record
 *     or batch.
 *
 * '''Delivery Semantics''':
 *   - '''At-most-once''': commit before processing. If processing fails, message is skipped.
 *   - '''At-least-once''': commit after processing. If commit fails, message is reprocessed.
 *     Requires idempotent processing.
 *   - '''Exactly-once''': requires Kafka transactions (read-process-write atomicity) or
 *     external idempotency. Supported since Kafka 0.11 with `isolation.level=read_committed`
 *     and transactional producers.
 *
 * '''Consumer Rebalancing''':
 * Triggers: new consumer joins, existing consumer leaves/crashes, new partitions added,
 * consumer fails to send heartbeat within `session.timeout.ms`.
 * During rebalance (eager protocol), all consumers release all partitions and get new assignments.
 * This causes a processing pause. Cooperative rebalancing (KIP-429) reduces this disruption.
 *
 * '''Key Configuration Properties''':
 *   - `group.id`: consumer group identifier.
 *   - `auto.offset.reset`: what to do when no committed offset exists -- `earliest`, `latest`, `none`.
 *   - `enable.auto.commit` / `auto.commit.interval.ms`: auto-commit toggle and frequency.
 *   - `max.poll.records`: max records returned per poll() call.
 *   - `max.poll.interval.ms`: max time between poll() calls before consumer is considered dead.
 *   - `session.timeout.ms` / `heartbeat.interval.ms`: liveness detection.
 *
 * =Interview Tips=
 *   - "Kafka consumer group rebalancing is a common interview topic -- explain what triggers it
 *     and how to handle it gracefully." Mention `ConsumerRebalanceListener` for committing
 *     offsets on revocation and initializing state on assignment.
 *   - Know the difference between `session.timeout.ms` (heartbeat-based liveness) and
 *     `max.poll.interval.ms` (processing-based liveness). A slow consumer that calls poll()
 *     infrequently gets kicked out via the latter.
 *   - Explain the poll loop pattern: `while(true) { records = consumer.poll(timeout); process(records); commit(); }`
 *   - Discuss consumer lag (logEndOffset - currentOffset) as a key operational metric.
 *   - Exactly-once is the hardest to explain -- mention idempotent producers + transactional
 *     read-process-write + `isolation.level=read_committed`.
 */
object Kafka002_ConsumerBasics {

  // --- Domain models ---

  sealed trait OffsetResetStrategy
  object OffsetResetStrategy {
    case object Earliest extends OffsetResetStrategy
    case object Latest   extends OffsetResetStrategy
    case object None     extends OffsetResetStrategy
  }

  sealed trait CommitStrategy
  object CommitStrategy {
    case object AutoCommit                    extends CommitStrategy
    case object ManualSync                    extends CommitStrategy
    case object ManualAsync                   extends CommitStrategy
    case class  ManualAtOffset(offset: Long)  extends CommitStrategy
  }

  case class ConsumerConfig(
    bootstrapServers: String,
    groupId: String,
    keyDeserializer: String,
    valueDeserializer: String,
    autoOffsetReset: OffsetResetStrategy,
    enableAutoCommit: Boolean,
    autoCommitIntervalMs: Int,
    maxPollRecords: Int
  )

  case class ConsumerRecord[K, V](
    topic: String,
    partition: Int,
    offset: Long,
    key: Option[K],
    value: V
  )

  case class TopicPartition(topic: String, partition: Int)

  case class OffsetAndMetadata(offset: Long, metadata: String)

  sealed trait RebalanceEvent
  object RebalanceEvent {
    case class PartitionsRevoked(partitions: Set[TopicPartition])  extends RebalanceEvent
    case class PartitionsAssigned(partitions: Set[TopicPartition]) extends RebalanceEvent
  }

  // Exercise 1: Configure basic consumer group properties
  // TODO: Create a ConsumerConfig with:
  //   bootstrapServers = "localhost:9092"
  //   groupId = "order-processing-group"
  //   keyDeserializer = "org.apache.kafka.common.serialization.StringDeserializer"
  //   valueDeserializer = "org.apache.kafka.common.serialization.StringDeserializer"
  //   autoOffsetReset = OffsetResetStrategy.Earliest
  //   enableAutoCommit = true
  //   autoCommitIntervalMs = 5000
  //   maxPollRecords = 500
  def exercise1_consumerGroupConfig: ConsumerConfig = ???

  // Exercise 2: Simulate subscribing to topics and returning topic list
  // TODO: Given a list of topic names, return the Set[String] of subscribed topics.
  //   A consumer can subscribe to multiple topics at once.
  //   Return the set of topic names.
  def exercise2_subscribeToTopics(topics: List[String]): Set[String] = ???

  // Exercise 3: Implement a poll loop simulation
  // TODO: Given a list of ConsumerRecord[String, String] (simulating what poll returns),
  //   process each record by extracting the value, and return List[String] of all values.
  //   This models the core poll-process loop pattern.
  def exercise3_pollLoop(
    records: List[ConsumerRecord[String, String]]
  ): List[String] = ???

  // Exercise 4: Implement manual commit offset calculation
  // TODO: Given a list of ConsumerRecord[String, String], calculate the offset to commit
  //   for each partition. The committed offset should be lastOffset + 1 (next to read).
  //   Return Map[TopicPartition, OffsetAndMetadata].
  def exercise4_manualCommitOffsets(
    records: List[ConsumerRecord[String, String]]
  ): Map[TopicPartition, OffsetAndMetadata] = ???

  // Exercise 5: Decide commit strategy based on requirements
  // TODO: Given two booleans — `atLeastOnce` and `exactControl`:
  //   (false, false) -> CommitStrategy.AutoCommit (simplest, at-most-once risk)
  //   (true, false)  -> CommitStrategy.ManualAsync (at-least-once, non-blocking)
  //   (true, true)   -> CommitStrategy.ManualSync  (at-least-once, blocking confirmation)
  //   (false, true)  -> CommitStrategy.ManualSync  (exact control implies sync)
  def exercise5_commitStrategy(atLeastOnce: Boolean, exactControl: Boolean): CommitStrategy = ???

  // Exercise 6: Calculate consumer offsets from position data
  // TODO: Given currentOffset (where consumer is) and logEndOffset (latest in partition),
  //   return the consumer lag as a Long. Lag = logEndOffset - currentOffset.
  //   If lag is negative (shouldn't happen normally), return 0.
  def exercise6_offsetLag(currentOffset: Long, logEndOffset: Long): Long = ???

  // Exercise 7: Handle consumer rebalance events
  // TODO: Given a RebalanceEvent, return a description string:
  //   PartitionsRevoked(parts) -> "Revoked: " + sorted partition strings "topic-N" joined by ", "
  //   PartitionsAssigned(parts) -> "Assigned: " + sorted partition strings "topic-N" joined by ", "
  //   For example: "Revoked: orders-0, orders-1"
  def exercise7_handleRebalance(event: RebalanceEvent): String = ???

  // Exercise 8: Configure consumer with manual commit (no auto-commit)
  // TODO: Create a ConsumerConfig identical to exercise1 but with:
  //   enableAutoCommit = false, autoCommitIntervalMs = 0
  //   This is the prerequisite for manual offset management.
  def exercise8_manualCommitConfig: ConsumerConfig = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val cfg = exercise1_consumerGroupConfig
    assert(cfg.groupId == "order-processing-group", "Exercise 1 failed: wrong groupId")
    assert(cfg.enableAutoCommit, "Exercise 1 failed: auto commit should be true")
    assert(cfg.autoOffsetReset == OffsetResetStrategy.Earliest, "Exercise 1 failed: wrong reset")
    println("Exercise 1 passed: consumer group config created")

    // Exercise 2
    val topics = exercise2_subscribeToTopics(List("orders", "payments", "orders"))
    assert(topics == Set("orders", "payments"), "Exercise 2 failed: wrong topics")
    println(s"Exercise 2 passed: subscribed to $topics")

    // Exercise 3
    val records = List(
      ConsumerRecord("t", 0, 0L, Some("k1"), "v1"),
      ConsumerRecord("t", 0, 1L, Some("k2"), "v2")
    )
    val values = exercise3_pollLoop(records)
    assert(values == List("v1", "v2"), "Exercise 3 failed")
    println(s"Exercise 3 passed: poll loop extracted $values")

    // Exercise 4
    val recs = List(
      ConsumerRecord("orders", 0, 5L, Some("k"), "v"),
      ConsumerRecord("orders", 0, 8L, Some("k"), "v"),
      ConsumerRecord("orders", 1, 3L, Some("k"), "v")
    )
    val offsets = exercise4_manualCommitOffsets(recs)
    assert(offsets(TopicPartition("orders", 0)).offset == 9L, "Exercise 4 failed: partition 0")
    assert(offsets(TopicPartition("orders", 1)).offset == 4L, "Exercise 4 failed: partition 1")
    println(s"Exercise 4 passed: commit offsets calculated")

    // Exercise 5
    assert(exercise5_commitStrategy(false, false) == CommitStrategy.AutoCommit, "Exercise 5 failed")
    assert(exercise5_commitStrategy(true, false) == CommitStrategy.ManualAsync, "Exercise 5 failed")
    assert(exercise5_commitStrategy(true, true) == CommitStrategy.ManualSync, "Exercise 5 failed")
    println("Exercise 5 passed: commit strategy selection correct")

    // Exercise 6
    assert(exercise6_offsetLag(100L, 150L) == 50L, "Exercise 6 failed: wrong lag")
    assert(exercise6_offsetLag(150L, 100L) == 0L, "Exercise 6 failed: negative lag")
    println("Exercise 6 passed: offset lag calculated")

    // Exercise 7
    val revoked = exercise7_handleRebalance(
      RebalanceEvent.PartitionsRevoked(Set(TopicPartition("orders", 1), TopicPartition("orders", 0)))
    )
    assert(revoked == "Revoked: orders-0, orders-1", s"Exercise 7 failed: got '$revoked'")
    println(s"Exercise 7 passed: $revoked")

    // Exercise 8
    val manualCfg = exercise8_manualCommitConfig
    assert(!manualCfg.enableAutoCommit, "Exercise 8 failed: auto commit should be false")
    assert(manualCfg.autoCommitIntervalMs == 0, "Exercise 8 failed: interval should be 0")
    println("Exercise 8 passed: manual commit config created")

    println("\nAll Kafka002_ConsumerBasics exercises passed!")
  }
}
