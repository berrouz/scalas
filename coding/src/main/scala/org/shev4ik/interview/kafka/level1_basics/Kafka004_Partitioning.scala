package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka 004 - Partitioning (6 exercises)
 *
 * Partitions are the unit of parallelism in Kafka. Key concepts:
 *   - Default partitioner: hash(key) % numPartitions, or round-robin if no key
 *   - Custom partitioner: implement logic to route records to specific partitions
 *   - Key-based partitioning ensures ordering per key
 *   - Partition count affects parallelism and consumer scaling
 *   - Consumer-partition assignment: one partition per consumer max in a group
 */
object Kafka004_Partitioning {

  // --- Domain models ---

  case class ProducerRecord[K, V](
    topic: String,
    partition: Option[Int],
    key: Option[K],
    value: V
  )

  case class TopicPartition(topic: String, partition: Int)

  sealed trait PartitionStrategy
  object PartitionStrategy {
    case object RoundRobin extends PartitionStrategy
    case object KeyHash    extends PartitionStrategy
    case object Sticky     extends PartitionStrategy
    case class  Custom(f: (String, Int) => Int) extends PartitionStrategy // (key, numPartitions) => partition
  }

  // Exercise 1: Implement default partitioner (key-based hash)
  // TODO: Given a key (String) and numPartitions, compute the partition:
  //   partition = Math.abs(key.hashCode) % numPartitions
  //   This ensures the same key always goes to the same partition.
  def exercise1_defaultPartitioner(key: String, numPartitions: Int): Int = ???

  // Exercise 2: Implement round-robin partition assignment
  // TODO: Given a list of records (with no keys) and numPartitions,
  //   assign partition numbers in round-robin fashion (0, 1, 2, ..., 0, 1, 2, ...).
  //   Return a List[Int] of assigned partition numbers.
  def exercise2_roundRobinAssignment(recordCount: Int, numPartitions: Int): List[Int] = ???

  // Exercise 3: Implement a custom partitioner for priority routing
  // TODO: Given a key string, if the key starts with "PRIORITY-", route to partition 0.
  //   Otherwise, use Math.abs(key.hashCode) % (numPartitions - 1) + 1
  //   (skip partition 0 for non-priority). Partition 0 is reserved for high-priority.
  def exercise3_priorityPartitioner(key: String, numPartitions: Int): Int = ???

  // Exercise 4: Calculate consumer-partition assignment
  // TODO: Given numPartitions and numConsumers (in a group), calculate how many
  //   partitions each consumer gets. Return List[Int] where index = consumer,
  //   value = number of partitions assigned. Use range assignment:
  //   each consumer gets numPartitions / numConsumers, and the first
  //   (numPartitions % numConsumers) consumers get 1 extra.
  def exercise4_partitionAssignment(numPartitions: Int, numConsumers: Int): List[Int] = ???

  // Exercise 5: Determine the effect of partition count on parallelism
  // TODO: Given partitionCount and consumerCount, return a tuple:
  //   (activeConsumers, idleConsumers) where:
  //   activeConsumers = min(partitionCount, consumerCount)
  //   idleConsumers = max(0, consumerCount - partitionCount)
  //   Idle consumers exist when consumerCount > partitionCount.
  def exercise5_parallelismEffect(partitionCount: Int, consumerCount: Int): (Int, Int) = ???

  // Exercise 6: Group records by their assigned partition
  // TODO: Given a list of ProducerRecord[String, String] (all with Some(key)),
  //   and numPartitions, assign each record to a partition using
  //   Math.abs(key.hashCode) % numPartitions, then group records by partition.
  //   Return Map[Int, List[ProducerRecord[String, String]]].
  def exercise6_groupByPartition(
    records: List[ProducerRecord[String, String]],
    numPartitions: Int
  ): Map[Int, List[ProducerRecord[String, String]]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val p1 = exercise1_defaultPartitioner("order-123", 6)
    assert(p1 >= 0 && p1 < 6, s"Exercise 1 failed: partition $p1 out of range")
    val p1b = exercise1_defaultPartitioner("order-123", 6)
    assert(p1 == p1b, "Exercise 1 failed: same key should always map to same partition")
    println(s"Exercise 1 passed: 'order-123' -> partition $p1")

    // Exercise 2
    val rr = exercise2_roundRobinAssignment(7, 3)
    assert(rr == List(0, 1, 2, 0, 1, 2, 0), s"Exercise 2 failed: got $rr")
    println(s"Exercise 2 passed: round-robin -> $rr")

    // Exercise 3
    val prio = exercise3_priorityPartitioner("PRIORITY-urgent", 4)
    assert(prio == 0, "Exercise 3 failed: priority should go to partition 0")
    val normal = exercise3_priorityPartitioner("regular-key", 4)
    assert(normal >= 1 && normal < 4, "Exercise 3 failed: normal should avoid partition 0")
    println(s"Exercise 3 passed: priority -> $prio, normal -> $normal")

    // Exercise 4
    val assign = exercise4_partitionAssignment(7, 3)
    assert(assign == List(3, 2, 2), s"Exercise 4 failed: got $assign")
    assert(assign.sum == 7, "Exercise 4 failed: total partitions mismatch")
    println(s"Exercise 4 passed: assignment -> $assign")

    // Exercise 5
    val (active, idle) = exercise5_parallelismEffect(3, 5)
    assert(active == 3, "Exercise 5 failed: wrong active count")
    assert(idle == 2, "Exercise 5 failed: wrong idle count")
    println(s"Exercise 5 passed: active=$active, idle=$idle")

    // Exercise 6
    val records = List(
      ProducerRecord("t", None, Some("a"), "v1"),
      ProducerRecord("t", None, Some("b"), "v2"),
      ProducerRecord("t", None, Some("a"), "v3")
    )
    val grouped = exercise6_groupByPartition(records, 3)
    // Records with key "a" should be in the same partition
    val aPartition = Math.abs("a".hashCode) % 3
    assert(grouped.getOrElse(aPartition, Nil).length == 2, "Exercise 6 failed: 'a' records not grouped")
    println(s"Exercise 6 passed: grouped into ${grouped.size} partitions")

    println("\nAll Kafka004_Partitioning exercises passed!")
  }
}
