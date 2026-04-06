package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Kafka 007 - Kafka Streams
 *
 * Kafka Streams is a client library for stream processing:
 *   - KStream: unbounded stream of records (event log)
 *   - KTable: changelog stream (latest value per key, like a table)
 *   - GlobalKTable: fully replicated table on every instance
 *   - Joins: stream-stream, stream-table, table-table, windowed
 *   - Interactive queries: query local state stores from outside the topology
 */
object Kafka007_Streams {

  // --- Domain models ---

  case class KRecord[K, V](key: K, value: V, timestamp: Long)

  // KStream: append-only log, all records matter
  case class KStream[K, V](records: List[KRecord[K, V]])

  // KTable: latest value per key (changelog semantics)
  case class KTable[K, V](entries: Map[K, V])

  // GlobalKTable: same as KTable but fully replicated
  case class GlobalKTable[K, V](entries: Map[K, V])

  sealed trait JoinType
  object JoinType {
    case object Inner extends JoinType
    case object Left  extends JoinType
    case object Outer extends JoinType
  }

  case class JoinWindow(beforeMs: Long, afterMs: Long)

  case class InteractiveQueryResult[V](storeName: String, key: String, value: Option[V])

  // Exercise 1: Implement KStream filter and map
  // TODO: Given a KStream[String, Int], filter records where value > threshold,
  //   then map remaining values by applying the transform function.
  //   Return a new KStream[String, Int] with filtered and transformed records.
  def exercise1_streamFilterMap(
    stream: KStream[String, Int],
    threshold: Int,
    transform: Int => Int
  ): KStream[String, Int] = ???

  // Exercise 2: Build a KTable from a KStream (changelog reduction)
  // TODO: Given a KStream[String, String], reduce it to a KTable[String, String]
  //   by keeping only the latest record per key (highest timestamp wins).
  //   Return KTable with the resulting entries.
  def exercise2_streamToTable(
    stream: KStream[String, String]
  ): KTable[String, String] = ???

  // Exercise 3: Create a GlobalKTable from a map of reference data
  // TODO: Given a Map[String, String] representing reference/lookup data,
  //   wrap it in a GlobalKTable. GlobalKTables are used for enrichment joins
  //   where every instance needs the full dataset.
  def exercise3_globalKTable(
    referenceData: Map[String, String]
  ): GlobalKTable[String, String] = ???

  // Exercise 4: Implement stream-stream inner join
  // TODO: Given two KStreams with the same key type, join them within a JoinWindow.
  //   Two records join if they have the same key and their timestamps are within
  //   [leftTs - window.beforeMs, leftTs + window.afterMs].
  //   Apply the joiner function to matched (leftValue, rightValue) pairs.
  //   Return a new KStream with joined results.
  def exercise4_streamStreamJoin[V1, V2, VR](
    left: KStream[String, V1],
    right: KStream[String, V2],
    window: JoinWindow,
    joiner: (V1, V2) => VR
  ): KStream[String, VR] = ???

  // Exercise 5: Implement stream-table join (enrichment)
  // TODO: Given a KStream[String, String] and a KTable[String, String],
  //   join each stream record with the table entry having the same key.
  //   If the key exists in the table, combine values with the joiner.
  //   If the key is not in the table, drop the record (inner join).
  //   Return a new KStream[String, String].
  def exercise5_streamTableJoin(
    stream: KStream[String, String],
    table: KTable[String, String],
    joiner: (String, String) => String
  ): KStream[String, String] = ???

  // Exercise 6: Implement table-table join
  // TODO: Given two KTables, perform an inner join on matching keys.
  //   Apply the joiner function to produce the result value.
  //   Return a new KTable with only keys present in both tables.
  def exercise6_tableTableJoin[V1, V2, VR](
    left: KTable[String, V1],
    right: KTable[String, V2],
    joiner: (V1, V2) => VR
  ): KTable[String, VR] = ???

  // Exercise 7: Implement a windowed aggregation
  // TODO: Given a KStream[String, Int] and a window size (windowMs),
  //   group records by key, then by time window (timestamp / windowMs),
  //   and sum the values in each window.
  //   Return Map[(String, Long), Int] where Long is the window start time.
  //   Window start = (timestamp / windowMs) * windowMs
  def exercise7_windowedAggregation(
    stream: KStream[String, Int],
    windowMs: Long
  ): Map[(String, Long), Int] = ???

  // Exercise 8: Simulate interactive query
  // TODO: Given a KTable[String, String] (representing a state store named storeName),
  //   a store name, and a key, look up the value and return an InteractiveQueryResult.
  //   value = table.entries.get(key)
  def exercise8_interactiveQuery(
    table: KTable[String, String],
    storeName: String,
    key: String
  ): InteractiveQueryResult[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val stream1 = KStream(List(
      KRecord("a", 10, 1L), KRecord("b", 5, 2L), KRecord("c", 20, 3L)
    ))
    val filtered = exercise1_streamFilterMap(stream1, 7, _ * 2)
    assert(filtered.records.length == 2, "Exercise 1 failed: wrong count")
    assert(filtered.records.map(_.value) == List(20, 40), "Exercise 1 failed: wrong values")
    println("Exercise 1 passed: stream filter + map")

    // Exercise 2
    val changelog = KStream(List(
      KRecord("k1", "old", 1L), KRecord("k2", "v2", 2L), KRecord("k1", "new", 3L)
    ))
    val table = exercise2_streamToTable(changelog)
    assert(table.entries("k1") == "new", "Exercise 2 failed: should have latest value")
    assert(table.entries("k2") == "v2", "Exercise 2 failed")
    println("Exercise 2 passed: stream to table")

    // Exercise 3
    val gTable = exercise3_globalKTable(Map("US" -> "United States", "UK" -> "United Kingdom"))
    assert(gTable.entries.size == 2, "Exercise 3 failed")
    println("Exercise 3 passed: GlobalKTable created")

    // Exercise 4
    val left = KStream(List(KRecord("k1", "A", 100L), KRecord("k2", "B", 200L)))
    val right = KStream(List(KRecord("k1", "X", 105L), KRecord("k1", "Y", 500L)))
    val joined = exercise4_streamStreamJoin(left, right, JoinWindow(10L, 10L), (a: String, b: String) => s"$a+$b")
    assert(joined.records.exists(_.value == "A+X"), "Exercise 4 failed: k1 should join")
    assert(!joined.records.exists(_.value == "A+Y"), "Exercise 4 failed: Y is outside window")
    println("Exercise 4 passed: stream-stream join")

    // Exercise 5
    val s = KStream(List(KRecord("k1", "order", 1L), KRecord("k3", "order", 2L)))
    val t = KTable(Map("k1" -> "customer-A", "k2" -> "customer-B"))
    val enriched = exercise5_streamTableJoin(s, t, (sv, tv) => s"$sv:$tv")
    assert(enriched.records.length == 1, "Exercise 5 failed: only k1 should join")
    assert(enriched.records.head.value == "order:customer-A", "Exercise 5 failed")
    println("Exercise 5 passed: stream-table join")

    // Exercise 6
    val t1 = KTable(Map("k1" -> 10, "k2" -> 20))
    val t2 = KTable(Map("k1" -> 100, "k3" -> 300))
    val tableJoined = exercise6_tableTableJoin(t1, t2, (a: Int, b: Int) => a + b)
    assert(tableJoined.entries == Map("k1" -> 110), "Exercise 6 failed")
    println("Exercise 6 passed: table-table join")

    // Exercise 7
    val windowed = KStream(List(
      KRecord("a", 5, 100L), KRecord("a", 3, 150L), KRecord("a", 7, 250L), KRecord("b", 1, 100L)
    ))
    val agg = exercise7_windowedAggregation(windowed, 200L)
    assert(agg(("a", 0L)) == 8, s"Exercise 7 failed: got ${agg.get(("a", 0L))}")
    assert(agg(("a", 200L)) == 7, "Exercise 7 failed")
    assert(agg(("b", 0L)) == 1, "Exercise 7 failed")
    println("Exercise 7 passed: windowed aggregation")

    // Exercise 8
    val store = KTable(Map("user1" -> "Alice", "user2" -> "Bob"))
    val q1 = exercise8_interactiveQuery(store, "user-store", "user1")
    assert(q1.value.contains("Alice"), "Exercise 8 failed")
    val q2 = exercise8_interactiveQuery(store, "user-store", "user99")
    assert(q2.value.isEmpty, "Exercise 8 failed: missing key should return None")
    println("Exercise 8 passed: interactive query")

    println("\nAll Kafka007_Streams exercises passed!")
  }
}
