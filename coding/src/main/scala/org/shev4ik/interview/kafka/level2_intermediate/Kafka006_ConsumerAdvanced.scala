package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Kafka 006 - Advanced Consumer
 *
 * Advanced consumer features beyond basic poll-commit:
 *   - seek(): jump to specific offset in a partition
 *   - assign(): manually assign partitions (no consumer group rebalancing)
 *   - pause()/resume(): flow control for specific partitions
 *   - ConsumerInterceptor: hook into consume pipeline
 *   - ConsumerRebalanceListener: react to partition reassignment
 *   - Cooperative rebalancing: incremental, non-stop-the-world rebalance
 *   - Static group membership: group.instance.id avoids unnecessary rebalances
 *   - Consumer lag: difference between log end offset and consumer offset
 */
object Kafka006_ConsumerAdvanced {

  // --- Domain models ---

  case class TopicPartition(topic: String, partition: Int)

  case class ConsumerRecord[K, V](topic: String, partition: Int, offset: Long, key: K, value: V)

  sealed trait SeekPosition
  object SeekPosition {
    case class ToOffset(offset: Long)   extends SeekPosition
    case object ToBeginning             extends SeekPosition
    case object ToEnd                   extends SeekPosition
    case class ToTimestamp(ts: Long)    extends SeekPosition
  }

  sealed trait PartitionState
  object PartitionState {
    case object Active  extends PartitionState
    case object Paused  extends PartitionState
  }

  sealed trait RebalanceProtocol
  object RebalanceProtocol {
    case object Eager       extends RebalanceProtocol // stop-the-world: revoke all, reassign all
    case object Cooperative extends RebalanceProtocol // incremental: only revoke what moves
  }

  case class ConsumerGroupMember(
    memberId: String,
    groupInstanceId: Option[String], // static membership if Some
    assignedPartitions: Set[TopicPartition]
  )

  case class PartitionLag(
    topicPartition: TopicPartition,
    currentOffset: Long,
    logEndOffset: Long,
    lag: Long
  )

  // Exercise 1: Compute the target offset for a seek operation
  // TODO: Given a SeekPosition and partition metadata (beginOffset, endOffset,
  //   Map[Long, Long] timestampToOffset), return the target offset as Long:
  //   ToOffset(n)     -> n
  //   ToBeginning     -> beginOffset
  //   ToEnd           -> endOffset
  //   ToTimestamp(ts)  -> look up in timestampToOffset map; if not found, return endOffset
  def exercise1_seekToOffset(
    seekPos: SeekPosition,
    beginOffset: Long,
    endOffset: Long,
    timestampToOffset: Map[Long, Long]
  ): Long = ???

  // Exercise 2: Manually assign partitions (no consumer group)
  // TODO: Given a topic name and a list of partition numbers, create the
  //   Set[TopicPartition] that would be used with consumer.assign().
  //   This bypasses consumer group and rebalancing entirely.
  def exercise2_assignPartitions(
    topic: String,
    partitions: List[Int]
  ): Set[TopicPartition] = ???

  // Exercise 3: Implement pause/resume logic
  // TODO: Given a Map[TopicPartition, PartitionState] (current states) and
  //   a TopicPartition to toggle, return the updated map with the partition's
  //   state toggled: Active -> Paused, Paused -> Active.
  //   If the partition is not in the map, add it as Paused.
  def exercise3_togglePauseResume(
    states: Map[TopicPartition, PartitionState],
    tp: TopicPartition
  ): Map[TopicPartition, PartitionState] = ???

  // Exercise 4: Implement a consumer interceptor concept
  // TODO: Given a list of ConsumerRecord[String, String] and an interceptor
  //   function (ConsumerRecord[String, String] => Option[ConsumerRecord[String, String]]),
  //   apply the interceptor to each record. Records where interceptor returns None
  //   are filtered out. Return the filtered/transformed list.
  def exercise4_consumerInterceptor(
    records: List[ConsumerRecord[String, String]],
    interceptor: ConsumerRecord[String, String] => Option[ConsumerRecord[String, String]]
  ): List[ConsumerRecord[String, String]] = ???

  // Exercise 5: Simulate cooperative rebalancing
  // TODO: Given the current assignment Map[String, Set[TopicPartition]] (memberId -> partitions)
  //   and a new member joining with memberId, rebalance ONE partition from the member with
  //   the most partitions to the new member. Return the updated assignment.
  //   If all members have 0 or 1 partition, return unchanged with new member having empty set.
  def exercise5_cooperativeRebalance(
    currentAssignment: Map[String, Set[TopicPartition]],
    newMemberId: String
  ): Map[String, Set[TopicPartition]] = ???

  // Exercise 6: Determine if a member is static (has group.instance.id)
  // TODO: Given a list of ConsumerGroupMembers, partition them into
  //   (staticMembers, dynamicMembers) based on whether groupInstanceId is Some or None.
  def exercise6_staticVsDynamic(
    members: List[ConsumerGroupMember]
  ): (List[ConsumerGroupMember], List[ConsumerGroupMember]) = ???

  // Exercise 7: Calculate consumer lag for all partitions
  // TODO: Given two maps — currentOffsets: Map[TopicPartition, Long] and
  //   logEndOffsets: Map[TopicPartition, Long], compute PartitionLag for each
  //   partition present in both maps. Return List[PartitionLag] sorted by lag descending.
  def exercise7_calculateLag(
    currentOffsets: Map[TopicPartition, Long],
    logEndOffsets: Map[TopicPartition, Long]
  ): List[PartitionLag] = ???

  // Exercise 8: Calculate total consumer group lag
  // TODO: Given a list of PartitionLag objects, return the total lag across all partitions.
  //   Also return the partition with the highest lag. Return (totalLag, maxLagPartition).
  //   If the list is empty, return (0L, None).
  def exercise8_totalGroupLag(
    lags: List[PartitionLag]
  ): (Long, Option[TopicPartition]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val tsMap = Map(1000L -> 50L, 2000L -> 100L)
    assert(exercise1_seekToOffset(SeekPosition.ToOffset(42), 0, 200, tsMap) == 42, "Ex 1 failed")
    assert(exercise1_seekToOffset(SeekPosition.ToBeginning, 0, 200, tsMap) == 0, "Ex 1 failed")
    assert(exercise1_seekToOffset(SeekPosition.ToEnd, 0, 200, tsMap) == 200, "Ex 1 failed")
    assert(exercise1_seekToOffset(SeekPosition.ToTimestamp(1000L), 0, 200, tsMap) == 50, "Ex 1 failed")
    assert(exercise1_seekToOffset(SeekPosition.ToTimestamp(9999L), 0, 200, tsMap) == 200, "Ex 1 failed")
    println("Exercise 1 passed: seek offset computation")

    // Exercise 2
    val assigned = exercise2_assignPartitions("orders", List(0, 1, 2))
    assert(assigned.size == 3, "Exercise 2 failed")
    assert(assigned.contains(TopicPartition("orders", 1)), "Exercise 2 failed")
    println(s"Exercise 2 passed: assigned $assigned")

    // Exercise 3
    val tp = TopicPartition("t", 0)
    val states0 = Map(tp -> PartitionState.Active)
    val states1 = exercise3_togglePauseResume(states0, tp)
    assert(states1(tp) == PartitionState.Paused, "Exercise 3 failed: should be paused")
    val states2 = exercise3_togglePauseResume(states1, tp)
    assert(states2(tp) == PartitionState.Active, "Exercise 3 failed: should be active")
    println("Exercise 3 passed: pause/resume toggle")

    // Exercise 4
    val recs = List(
      ConsumerRecord("t", 0, 0, "k1", "good"),
      ConsumerRecord("t", 0, 1, "k2", "bad"),
      ConsumerRecord("t", 0, 2, "k3", "good-too")
    )
    val filtered = exercise4_consumerInterceptor(recs, r => if (r.value.startsWith("good")) Some(r) else None)
    assert(filtered.length == 2, "Exercise 4 failed")
    println(s"Exercise 4 passed: intercepted ${recs.length} -> ${filtered.length} records")

    // Exercise 5
    val current = Map(
      "c1" -> Set(TopicPartition("t", 0), TopicPartition("t", 1), TopicPartition("t", 2)),
      "c2" -> Set(TopicPartition("t", 3))
    )
    val rebalanced = exercise5_cooperativeRebalance(current, "c3")
    assert(rebalanced("c3").size == 1, "Exercise 5 failed: new member should get 1 partition")
    assert(rebalanced("c1").size == 2, "Exercise 5 failed: c1 should lose 1 partition")
    println("Exercise 5 passed: cooperative rebalance")

    // Exercise 6
    val members = List(
      ConsumerGroupMember("m1", Some("instance-1"), Set()),
      ConsumerGroupMember("m2", None, Set()),
      ConsumerGroupMember("m3", Some("instance-2"), Set())
    )
    val (static, dynamic) = exercise6_staticVsDynamic(members)
    assert(static.length == 2, "Exercise 6 failed: wrong static count")
    assert(dynamic.length == 1, "Exercise 6 failed: wrong dynamic count")
    println("Exercise 6 passed: static vs dynamic members")

    // Exercise 7
    val currentOff = Map(TopicPartition("t", 0) -> 100L, TopicPartition("t", 1) -> 200L)
    val endOff = Map(TopicPartition("t", 0) -> 150L, TopicPartition("t", 1) -> 300L)
    val lags = exercise7_calculateLag(currentOff, endOff)
    assert(lags.head.lag == 100L, s"Exercise 7 failed: expected 100, got ${lags.head.lag}")
    assert(lags(1).lag == 50L, "Exercise 7 failed")
    println("Exercise 7 passed: lag calculated")

    // Exercise 8
    val (totalLag, maxPart) = exercise8_totalGroupLag(lags)
    assert(totalLag == 150L, "Exercise 8 failed: wrong total lag")
    assert(maxPart.contains(TopicPartition("t", 1)), "Exercise 8 failed: wrong max partition")
    println(s"Exercise 8 passed: total lag=$totalLag")

    println("\nAll Kafka006_ConsumerAdvanced exercises passed!")
  }
}
