package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka 011 - ZIO Kafka
 *
 * ZIO Kafka provides a purely functional Kafka client built on ZIO:
 *   - Producer: effectful message sending with ZIO error handling
 *   - Consumer: stream-based consumption with backpressure
 *   - Offset committing: manual and automatic via ZIO streams
 *   - Partition assignment: custom strategies with ZIO
 *   - Settings: type-safe configuration for producer and consumer
 *
 * Since ZIO Kafka requires the library, exercises model the concepts in pure Scala.
 */
object Kafka011_ZIOKafka {

  // --- Domain models simulating ZIO Kafka concepts ---

  // Simplified ZIO-like effect type for exercises
  sealed trait ZEffect[+E, +A]
  object ZEffect {
    case class Succeed[A](value: A)         extends ZEffect[Nothing, A]
    case class Fail[E](error: E)            extends ZEffect[E, Nothing]
    case class FlatMap[E, A, B](fa: ZEffect[E, A], f: A => ZEffect[E, B]) extends ZEffect[E, B]
  }

  case class ProducerSettings(
    bootstrapServers: List[String],
    clientId: String,
    acks: String,          // "all", "1", "0"
    enableIdempotence: Boolean,
    properties: Map[String, String]
  )

  case class ConsumerSettings(
    bootstrapServers: List[String],
    groupId: String,
    clientId: String,
    autoOffsetReset: String, // "earliest", "latest"
    maxPollRecords: Int,
    properties: Map[String, String]
  )

  case class ProducerRecord[K, V](topic: String, key: K, value: V)
  case class RecordMetadata(topic: String, partition: Int, offset: Long)

  case class CommittableRecord[K, V](
    record: ConsumerRecord[K, V],
    offset: CommittableOffset
  )

  case class ConsumerRecord[K, V](
    topic: String,
    partition: Int,
    offset: Long,
    key: K,
    value: V
  )

  case class CommittableOffset(
    topic: String,
    partition: Int,
    offset: Long
  )

  case class OffsetBatch(offsets: Map[(String, Int), Long]) {
    def merge(other: OffsetBatch): OffsetBatch =
      OffsetBatch(offsets ++ other.offsets.map { case (k, v) =>
        k -> math.max(offsets.getOrElse(k, 0L), v)
      })
  }

  sealed trait PartitionAssignmentStrategy
  object PartitionAssignmentStrategy {
    case object Range             extends PartitionAssignmentStrategy
    case object RoundRobin        extends PartitionAssignmentStrategy
    case object CooperativeSticky extends PartitionAssignmentStrategy
  }

  // Exercise 1: Configure ZIO Kafka producer settings
  // TODO: Create ProducerSettings with:
  //   bootstrapServers = List("broker1:9092", "broker2:9092")
  //   clientId = "order-producer"
  //   acks = "all"
  //   enableIdempotence = true
  //   properties = Map("linger.ms" -> "10", "batch.size" -> "32768")
  def exercise1_producerSettings: ProducerSettings = ???

  // Exercise 2: Configure ZIO Kafka consumer settings
  // TODO: Create ConsumerSettings with:
  //   bootstrapServers = List("broker1:9092", "broker2:9092")
  //   groupId = "order-consumers"
  //   clientId = "order-consumer-1"
  //   autoOffsetReset = "earliest"
  //   maxPollRecords = 100
  //   properties = Map("session.timeout.ms" -> "30000")
  def exercise2_consumerSettings: ConsumerSettings = ???

  // Exercise 3: Model ZIO Kafka producer send as effect
  // TODO: Given a ProducerRecord[String, String], simulate producing it.
  //   If the key is non-empty, return ZEffect.Succeed(RecordMetadata(record.topic, 0, 42L)).
  //   If the key is empty, return ZEffect.Fail("Empty key not allowed").
  def exercise3_producerSend(
    record: ProducerRecord[String, String]
  ): ZEffect[String, RecordMetadata] = ???

  // Exercise 4: Process a consumer stream (map + filter pattern)
  // TODO: Given a list of CommittableRecord[String, String] (simulating a ZStream),
  //   filter records where value is non-empty, then transform values to uppercase.
  //   Return the list of transformed CommittableRecords (keep the original offset info).
  def exercise4_consumerStream(
    records: List[CommittableRecord[String, String]]
  ): List[CommittableRecord[String, String]] = ???

  // Exercise 5: Build an offset batch for committing
  // TODO: Given a list of CommittableOffsets, build an OffsetBatch that contains
  //   the maximum offset for each (topic, partition) pair.
  //   This simulates batching offsets before committing.
  def exercise5_buildOffsetBatch(
    offsets: List[CommittableOffset]
  ): OffsetBatch = ???

  // Exercise 6: Handle consumer errors with retry logic
  // TODO: Given a list of ZEffect[String, String] results (each representing processing
  //   one record), partition them into successes and failures.
  //   Return (successes: List[String], failures: List[String]).
  //   Extract value from Succeed, error from Fail. Ignore FlatMap.
  def exercise6_handleErrors(
    results: List[ZEffect[String, String]]
  ): (List[String], List[String]) = ???

  // Exercise 7: Implement partition assignment mapping
  // TODO: Given a number of partitions and consumers, and a PartitionAssignmentStrategy,
  //   return Map[Int, List[Int]] (consumerId -> list of partition numbers).
  //   Range: divide partitions evenly, first consumers get extras
  //   RoundRobin: assign partitions round-robin across consumers
  //   CooperativeSticky: same as Range for initial assignment
  def exercise7_partitionAssignment(
    numPartitions: Int,
    numConsumers: Int,
    strategy: PartitionAssignmentStrategy
  ): Map[Int, List[Int]] = ???

  // Exercise 8: Merge consumer settings with overrides
  // TODO: Given base ConsumerSettings and a Map[String, String] of overrides,
  //   return new ConsumerSettings with properties merged (overrides take precedence).
  //   Also, if overrides contain "group.id", update the groupId field.
  //   If overrides contain "max.poll.records", update maxPollRecords.
  def exercise8_mergeSettings(
    base: ConsumerSettings,
    overrides: Map[String, String]
  ): ConsumerSettings = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val ps = exercise1_producerSettings
    assert(ps.bootstrapServers.length == 2, "Exercise 1 failed")
    assert(ps.enableIdempotence, "Exercise 1 failed: idempotence")
    assert(ps.acks == "all", "Exercise 1 failed: acks")
    println("Exercise 1 passed: producer settings")

    // Exercise 2
    val cs = exercise2_consumerSettings
    assert(cs.groupId == "order-consumers", "Exercise 2 failed")
    assert(cs.maxPollRecords == 100, "Exercise 2 failed")
    println("Exercise 2 passed: consumer settings")

    // Exercise 3
    val goodRec = ProducerRecord("orders", "k1", "value")
    val badRec = ProducerRecord("orders", "", "value")
    assert(exercise3_producerSend(goodRec).isInstanceOf[ZEffect.Succeed[_]], "Exercise 3 failed: should succeed")
    assert(exercise3_producerSend(badRec).isInstanceOf[ZEffect.Fail[_]], "Exercise 3 failed: should fail")
    println("Exercise 3 passed: producer send effect")

    // Exercise 4
    val committable = List(
      CommittableRecord(ConsumerRecord("t", 0, 0, "k1", "hello"), CommittableOffset("t", 0, 0)),
      CommittableRecord(ConsumerRecord("t", 0, 1, "k2", ""), CommittableOffset("t", 0, 1)),
      CommittableRecord(ConsumerRecord("t", 0, 2, "k3", "world"), CommittableOffset("t", 0, 2))
    )
    val processed = exercise4_consumerStream(committable)
    assert(processed.length == 2, "Exercise 4 failed: should filter empty")
    assert(processed.head.record.value == "HELLO", "Exercise 4 failed: should uppercase")
    println("Exercise 4 passed: consumer stream processing")

    // Exercise 5
    val offsets = List(
      CommittableOffset("t", 0, 5),
      CommittableOffset("t", 0, 10),
      CommittableOffset("t", 1, 3),
      CommittableOffset("t", 0, 8)
    )
    val batch = exercise5_buildOffsetBatch(offsets)
    assert(batch.offsets(("t", 0)) == 10L, "Exercise 5 failed: should take max offset")
    assert(batch.offsets(("t", 1)) == 3L, "Exercise 5 failed")
    println("Exercise 5 passed: offset batch")

    // Exercise 6
    val results: List[ZEffect[String, String]] = List(
      ZEffect.Succeed("ok1"), ZEffect.Fail("err1"),
      ZEffect.Succeed("ok2"), ZEffect.Fail("err2")
    )
    val (succ, fail) = exercise6_handleErrors(results)
    assert(succ == List("ok1", "ok2"), "Exercise 6 failed: successes")
    assert(fail == List("err1", "err2"), "Exercise 6 failed: failures")
    println("Exercise 6 passed: error handling")

    // Exercise 7
    val rangeAssign = exercise7_partitionAssignment(6, 3, PartitionAssignmentStrategy.Range)
    assert(rangeAssign(0).length == 2, "Exercise 7 failed: consumer 0")
    assert(rangeAssign(1).length == 2, "Exercise 7 failed: consumer 1")
    assert(rangeAssign.values.flatten.toSet.size == 6, "Exercise 7 failed: all partitions assigned")
    println("Exercise 7 passed: partition assignment")

    // Exercise 8
    val merged = exercise8_mergeSettings(cs, Map("group.id" -> "new-group", "custom.prop" -> "val"))
    assert(merged.groupId == "new-group", "Exercise 8 failed: groupId not updated")
    assert(merged.properties("custom.prop") == "val", "Exercise 8 failed: prop not merged")
    println("Exercise 8 passed: settings merge")

    println("\nAll Kafka011_ZIOKafka exercises passed!")
  }
}
