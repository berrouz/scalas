package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka 001 - Producer Basics
 *
 * Apache Kafka producers send records to topics. Key concepts:
 *   - ProducerRecord[K, V] contains topic, optional partition, optional key, value
 *   - Acks: 0 (fire-and-forget), 1 (leader only), all (all ISR replicas)
 *   - Idempotent producer: enable.idempotence=true ensures exactly-once per partition
 *   - Batching: batch.size + linger.ms control micro-batching behavior
 *   - Compression: none, gzip, snappy, lz4, zstd
 */
object Kafka001_ProducerBasics {

  // --- Domain models for exercises ---

  sealed trait Acks
  object Acks {
    case object Zero extends Acks   // acks=0, no acknowledgment
    case object One  extends Acks   // acks=1, leader acknowledged
    case object All  extends Acks   // acks=all (-1), all ISR replicas
  }

  sealed trait CompressionType
  object CompressionType {
    case object None   extends CompressionType
    case object Gzip   extends CompressionType
    case object Snappy extends CompressionType
    case object Lz4    extends CompressionType
    case object Zstd   extends CompressionType
  }

  case class ProducerRecord[K, V](
    topic: String,
    partition: Option[Int],
    key: Option[K],
    value: V
  )

  case class ProducerConfig(
    bootstrapServers: String,
    keySerializer: String,
    valueSerializer: String,
    acks: Acks,
    enableIdempotence: Boolean,
    batchSize: Int,
    lingerMs: Int,
    compressionType: CompressionType
  )

  case class RecordMetadata(topic: String, partition: Int, offset: Long)

  type Callback = Either[Throwable, RecordMetadata] => Unit

  // Exercise 1: Configure basic producer properties
  // TODO: Create a ProducerConfig with:
  //   bootstrapServers = "localhost:9092"
  //   keySerializer = "org.apache.kafka.common.serialization.StringSerializer"
  //   valueSerializer = "org.apache.kafka.common.serialization.StringSerializer"
  //   acks = Acks.All
  //   enableIdempotence = false
  //   batchSize = 16384 (default 16KB)
  //   lingerMs = 0
  //   compressionType = CompressionType.None
  def exercise1_basicProducerConfig: ProducerConfig = ???

  // Exercise 2: Create a ProducerRecord with key and value
  // TODO: Create a ProducerRecord[String, String] for topic "orders"
  //   with key = Some("order-123"), value = """{"amount": 99.99}""",
  //   and partition = None (let partitioner decide)
  def exercise2_createRecord: ProducerRecord[String, String] = ???

  // Exercise 3: Implement a send-with-callback concept
  // TODO: Given a ProducerRecord and a Callback function, simulate sending a record.
  //   Return a RecordMetadata(record.topic, partition=0, offset=42L) on success.
  //   Invoke the callback with Right(metadata) and return the metadata.
  def exercise3_sendWithCallback(
    record: ProducerRecord[String, String],
    callback: Callback
  ): RecordMetadata = ???

  // Exercise 4: Determine the correct Acks level for a given reliability requirement
  // TODO: Given a reliability level string ("none", "leader", "all"),
  //   return the corresponding Acks value.
  //   "none" -> Acks.Zero, "leader" -> Acks.One, "all" -> Acks.All
  //   For any other string, return Acks.All as the safest default.
  def exercise4_acksFromReliability(reliability: String): Acks = ???

  // Exercise 5: Configure an idempotent producer
  // TODO: Create a ProducerConfig identical to exercise1 but with:
  //   enableIdempotence = true, acks = Acks.All (required for idempotence)
  //   This ensures exactly-once delivery per partition via producer sequence numbers.
  def exercise5_idempotentProducerConfig: ProducerConfig = ???

  // Exercise 6: Create records with different key serialization strategies
  // TODO: Given a list of (key, value) pairs, create ProducerRecords for topic "events".
  //   Keys determine partition assignment. Return List[ProducerRecord[String, String]].
  //   Set partition = None for all records.
  def exercise6_keyBasedRecords(
    pairs: List[(String, String)]
  ): List[ProducerRecord[String, String]] = ???

  // Exercise 7: Calculate optimal batch configuration
  // TODO: Given messageSize (bytes), messagesPerSecond, and desiredLatencyMs,
  //   return a tuple (batchSize, lingerMs) where:
  //   batchSize = messageSize * messagesPerSecond * desiredLatencyMs / 1000
  //   lingerMs = desiredLatencyMs
  //   This models the tradeoff between throughput and latency.
  def exercise7_batchConfig(
    messageSize: Int,
    messagesPerSecond: Int,
    desiredLatencyMs: Int
  ): (Int, Int) = ???

  // Exercise 8: Select compression type based on requirements
  // TODO: Given two booleans — `highThroughput` and `lowCpu`:
  //   (true, true)   -> CompressionType.Lz4    (fast, moderate compression)
  //   (true, false)  -> CompressionType.Zstd   (best compression ratio)
  //   (false, true)  -> CompressionType.Snappy  (low CPU, decent speed)
  //   (false, false) -> CompressionType.Gzip    (good compression, slower)
  def exercise8_selectCompression(
    highThroughput: Boolean,
    lowCpu: Boolean
  ): CompressionType = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val cfg = exercise1_basicProducerConfig
    assert(cfg.bootstrapServers == "localhost:9092", "Exercise 1 failed: wrong bootstrapServers")
    assert(cfg.acks == Acks.All, "Exercise 1 failed: wrong acks")
    assert(cfg.batchSize == 16384, "Exercise 1 failed: wrong batchSize")
    println(s"Exercise 1 passed: basic producer config created")

    // Exercise 2
    val rec = exercise2_createRecord
    assert(rec.topic == "orders", "Exercise 2 failed: wrong topic")
    assert(rec.key.contains("order-123"), "Exercise 2 failed: wrong key")
    assert(rec.value == """{"amount": 99.99}""", "Exercise 2 failed: wrong value")
    println(s"Exercise 2 passed: ProducerRecord created")

    // Exercise 3
    var callbackResult: Option[Either[Throwable, RecordMetadata]] = None
    val meta = exercise3_sendWithCallback(rec, result => callbackResult = Some(result))
    assert(meta.offset == 42L, "Exercise 3 failed: wrong offset")
    assert(callbackResult.exists(_.isRight), "Exercise 3 failed: callback not invoked")
    println(s"Exercise 3 passed: send with callback works")

    // Exercise 4
    assert(exercise4_acksFromReliability("none") == Acks.Zero, "Exercise 4 failed for 'none'")
    assert(exercise4_acksFromReliability("leader") == Acks.One, "Exercise 4 failed for 'leader'")
    assert(exercise4_acksFromReliability("all") == Acks.All, "Exercise 4 failed for 'all'")
    assert(exercise4_acksFromReliability("unknown") == Acks.All, "Exercise 4 failed for default")
    println("Exercise 4 passed: acks mapping correct")

    // Exercise 5
    val idempCfg = exercise5_idempotentProducerConfig
    assert(idempCfg.enableIdempotence, "Exercise 5 failed: idempotence not enabled")
    assert(idempCfg.acks == Acks.All, "Exercise 5 failed: acks must be All for idempotence")
    println("Exercise 5 passed: idempotent producer config")

    // Exercise 6
    val pairs = List(("k1", "v1"), ("k2", "v2"), ("k3", "v3"))
    val records = exercise6_keyBasedRecords(pairs)
    assert(records.length == 3, "Exercise 6 failed: wrong number of records")
    assert(records.head.topic == "events", "Exercise 6 failed: wrong topic")
    assert(records.head.key.contains("k1"), "Exercise 6 failed: wrong key")
    println("Exercise 6 passed: key-based records created")

    // Exercise 7
    val (batchSz, linger) = exercise7_batchConfig(1000, 100, 50)
    assert(batchSz == 5000, "Exercise 7 failed: wrong batchSize")
    assert(linger == 50, "Exercise 7 failed: wrong lingerMs")
    println(s"Exercise 7 passed: batch config ($batchSz, $linger)")

    // Exercise 8
    assert(exercise8_selectCompression(true, true) == CompressionType.Lz4, "Exercise 8 failed")
    assert(exercise8_selectCompression(true, false) == CompressionType.Zstd, "Exercise 8 failed")
    assert(exercise8_selectCompression(false, true) == CompressionType.Snappy, "Exercise 8 failed")
    assert(exercise8_selectCompression(false, false) == CompressionType.Gzip, "Exercise 8 failed")
    println("Exercise 8 passed: compression selection correct")

    println("\nAll Kafka001_ProducerBasics exercises passed!")
  }
}
