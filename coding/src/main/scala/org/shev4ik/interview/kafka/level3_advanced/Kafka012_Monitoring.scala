package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka 012 - Monitoring
 *
 * Monitoring Kafka clusters and clients is essential for production:
 *   - Consumer lag: how far behind consumers are from the latest messages
 *   - Producer metrics: record-send-rate, byte-rate, request-latency
 *   - Consumer metrics: fetch-rate, records-consumed-rate, commit-rate
 *   - JMX metrics: Kafka exposes all metrics via JMX MBeans
 *   - Under-replicated partitions: partitions where ISR < replication factor
 *   - ISR (In-Sync Replicas): replicas that are up-to-date with the leader
 *   - Throughput: messages/sec and bytes/sec
 *   - End-to-end latency: time from produce to consume
 */
object Kafka012_Monitoring {

  // --- Domain models ---

  case class TopicPartition(topic: String, partition: Int)

  case class ConsumerLagInfo(
    topicPartition: TopicPartition,
    currentOffset: Long,
    logEndOffset: Long,
    lag: Long,
    consumerId: String
  )

  case class ProducerMetrics(
    recordSendRate: Double,    // records/sec
    byteRate: Double,          // bytes/sec
    requestLatencyAvg: Double, // ms
    requestLatencyP99: Double, // ms
    batchSizeAvg: Double,      // bytes
    recordsPerRequestAvg: Double,
    compressionRatio: Double   // 0.0 to 1.0
  )

  case class ConsumerMetrics(
    fetchRate: Double,             // fetches/sec
    recordsConsumedRate: Double,   // records/sec
    bytesConsumedRate: Double,     // bytes/sec
    commitRate: Double,            // commits/sec
    pollLatencyAvg: Double,        // ms
    rebalanceRate: Double          // rebalances/sec
  )

  case class JmxMetricPath(
    domain: String,       // e.g., "kafka.consumer"
    metricType: String,   // e.g., "consumer-fetch-manager-metrics"
    attributes: Map[String, String]
  )

  case class PartitionReplicaInfo(
    topicPartition: TopicPartition,
    leader: Int,               // broker ID
    replicas: Set[Int],        // all replica broker IDs
    inSyncReplicas: Set[Int],  // ISR broker IDs
    replicationFactor: Int
  )

  case class ThroughputSnapshot(
    timestampMs: Long,
    messagesPerSec: Double,
    bytesPerSec: Double
  )

  case class EndToEndLatency(
    topic: String,
    produceTimestampMs: Long,
    consumeTimestampMs: Long,
    latencyMs: Long
  )

  // Exercise 1: Calculate consumer lag for a consumer group
  // TODO: Given two maps — consumerOffsets: Map[(String, TopicPartition), Long]
  //   (consumerId, tp -> current offset) and logEndOffsets: Map[TopicPartition, Long],
  //   compute List[ConsumerLagInfo] for all consumer-partition pairs.
  //   lag = logEndOffset - currentOffset (min 0).
  //   Sort by lag descending.
  def exercise1_consumerLag(
    consumerOffsets: Map[(String, TopicPartition), Long],
    logEndOffsets: Map[TopicPartition, Long]
  ): List[ConsumerLagInfo] = ???

  // Exercise 2: Evaluate producer health from metrics
  // TODO: Given ProducerMetrics, return a health status string:
  //   - If requestLatencyP99 > 1000 -> "CRITICAL: high latency"
  //   - If requestLatencyP99 > 500  -> "WARNING: elevated latency"
  //   - If recordSendRate < 1.0     -> "WARNING: low throughput"
  //   - Otherwise                   -> "HEALTHY"
  //   Check conditions in order, return the first match.
  def exercise2_producerHealth(metrics: ProducerMetrics): String = ???

  // Exercise 3: Evaluate consumer health from metrics
  // TODO: Given ConsumerMetrics, return a health status string:
  //   - If rebalanceRate > 0.1     -> "CRITICAL: frequent rebalances"
  //   - If recordsConsumedRate < 1 -> "WARNING: low consumption rate"
  //   - If commitRate < 0.01       -> "WARNING: commits too infrequent"
  //   - Otherwise                  -> "HEALTHY"
  def exercise3_consumerHealth(metrics: ConsumerMetrics): String = ???

  // Exercise 4: Build a JMX metric path for a consumer metric
  // TODO: Given a consumer groupId and a metric name, construct a JmxMetricPath:
  //   domain = "kafka.consumer"
  //   metricType = "consumer-fetch-manager-metrics"
  //   attributes = Map("client-id" -> groupId, "metric-name" -> metricName)
  def exercise4_jmxMetricPath(groupId: String, metricName: String): JmxMetricPath = ???

  // Exercise 5: Detect under-replicated partitions
  // TODO: Given a list of PartitionReplicaInfo, return those where
  //   inSyncReplicas.size < replicationFactor.
  //   These are under-replicated and may indicate broker issues.
  def exercise5_underReplicatedPartitions(
    partitions: List[PartitionReplicaInfo]
  ): List[PartitionReplicaInfo] = ???

  // Exercise 6: Monitor ISR shrink/expand events
  // TODO: Given before and after ISR sets for a partition, return a status:
  //   If after.size < before.size -> "ISR_SHRINK: lost brokers " + (before -- after).toList.sorted.mkString(",")
  //   If after.size > before.size -> "ISR_EXPAND: added brokers " + (after -- before).toList.sorted.mkString(",")
  //   If same size                -> "ISR_STABLE"
  def exercise6_isrEvent(before: Set[Int], after: Set[Int]): String = ???

  // Exercise 7: Calculate throughput from snapshots
  // TODO: Given two ThroughputSnapshots (earlier and later), calculate:
  //   avgMessagesPerSec = (s2.messagesPerSec + s1.messagesPerSec) / 2
  //   avgBytesPerSec = (s2.bytesPerSec + s1.bytesPerSec) / 2
  //   durationSec = (s2.timestampMs - s1.timestampMs) / 1000.0
  //   Return (avgMessagesPerSec, avgBytesPerSec, durationSec).
  def exercise7_throughputCalc(
    s1: ThroughputSnapshot,
    s2: ThroughputSnapshot
  ): (Double, Double, Double) = ???

  // Exercise 8: Calculate end-to-end latency statistics
  // TODO: Given a list of EndToEndLatency measurements, compute:
  //   - avgLatency: average of all latencyMs values
  //   - maxLatency: maximum latencyMs
  //   - p99Latency: 99th percentile (sort ascending, take element at index (n * 0.99).toInt)
  //   Return (avgLatency, maxLatency, p99Latency). If list is empty, return (0, 0, 0).
  def exercise8_latencyStats(
    latencies: List[EndToEndLatency]
  ): (Long, Long, Long) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val tp0 = TopicPartition("orders", 0)
    val tp1 = TopicPartition("orders", 1)
    val consOff = Map(("c1", tp0) -> 100L, ("c1", tp1) -> 200L)
    val endOff = Map(tp0 -> 150L, tp1 -> 210L)
    val lags = exercise1_consumerLag(consOff, endOff)
    assert(lags.head.lag == 50L, s"Exercise 1 failed: got ${lags.head.lag}")
    assert(lags(1).lag == 10L, "Exercise 1 failed")
    println("Exercise 1 passed: consumer lag calculation")

    // Exercise 2
    assert(exercise2_producerHealth(ProducerMetrics(100, 1000, 50, 1500, 1000, 10, 0.5)) == "CRITICAL: high latency", "Ex 2")
    assert(exercise2_producerHealth(ProducerMetrics(100, 1000, 50, 200, 1000, 10, 0.5)) == "HEALTHY", "Ex 2")
    assert(exercise2_producerHealth(ProducerMetrics(0.5, 100, 50, 200, 1000, 10, 0.5)) == "WARNING: low throughput", "Ex 2")
    println("Exercise 2 passed: producer health")

    // Exercise 3
    assert(exercise3_consumerHealth(ConsumerMetrics(10, 100, 5000, 1, 50, 0.2)) == "CRITICAL: frequent rebalances", "Ex 3")
    assert(exercise3_consumerHealth(ConsumerMetrics(10, 100, 5000, 1, 50, 0.01)) == "HEALTHY", "Ex 3")
    println("Exercise 3 passed: consumer health")

    // Exercise 4
    val jmx = exercise4_jmxMetricPath("my-group", "records-lag")
    assert(jmx.domain == "kafka.consumer", "Exercise 4 failed")
    assert(jmx.attributes("client-id") == "my-group", "Exercise 4 failed")
    println("Exercise 4 passed: JMX metric path")

    // Exercise 5
    val replicas = List(
      PartitionReplicaInfo(tp0, 0, Set(0, 1, 2), Set(0, 1, 2), 3),
      PartitionReplicaInfo(tp1, 0, Set(0, 1, 2), Set(0, 1), 3) // under-replicated
    )
    val underRep = exercise5_underReplicatedPartitions(replicas)
    assert(underRep.length == 1, "Exercise 5 failed")
    assert(underRep.head.topicPartition == tp1, "Exercise 5 failed")
    println("Exercise 5 passed: under-replicated detection")

    // Exercise 6
    assert(exercise6_isrEvent(Set(0, 1, 2), Set(0, 1)) == "ISR_SHRINK: lost brokers 2", "Ex 6")
    assert(exercise6_isrEvent(Set(0, 1), Set(0, 1, 2)) == "ISR_EXPAND: added brokers 2", "Ex 6")
    assert(exercise6_isrEvent(Set(0, 1), Set(0, 1)) == "ISR_STABLE", "Ex 6")
    println("Exercise 6 passed: ISR events")

    // Exercise 7
    val snap1 = ThroughputSnapshot(1000L, 100.0, 50000.0)
    val snap2 = ThroughputSnapshot(2000L, 200.0, 80000.0)
    val (avgMsg, avgBytes, dur) = exercise7_throughputCalc(snap1, snap2)
    assert(avgMsg == 150.0, "Exercise 7 failed: avgMsg")
    assert(dur == 1.0, "Exercise 7 failed: duration")
    println("Exercise 7 passed: throughput calculation")

    // Exercise 8
    val lats = (1 to 100).map(i => EndToEndLatency("t", 0, i.toLong, i.toLong)).toList
    val (avg, max, p99) = exercise8_latencyStats(lats)
    assert(max == 100L, "Exercise 8 failed: max")
    assert(p99 >= 99L, s"Exercise 8 failed: p99=$p99")
    println("Exercise 8 passed: latency stats")

    println("\nAll Kafka012_Monitoring exercises passed!")
  }
}
