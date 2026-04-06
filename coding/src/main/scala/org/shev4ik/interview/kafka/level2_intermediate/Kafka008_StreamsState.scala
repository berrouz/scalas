package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Kafka 008 - Kafka Streams State Management
 *
 * Kafka Streams provides stateful processing via state stores:
 *   - State store: local key-value store backed by a changelog topic
 *   - Persistent store (RocksDB): survives restarts, backed by changelog
 *   - In-memory store: faster, lost on restart, rebuilt from changelog
 *   - Tumbling window: fixed-size, non-overlapping time windows
 *   - Hopping window: fixed-size, overlapping windows (advance < size)
 *   - Session window: dynamic windows based on activity gaps
 *   - Punctuator: periodic callback based on stream-time or wall-clock-time
 */
object Kafka008_StreamsState {

  // --- Domain models ---

  sealed trait StoreType
  object StoreType {
    case object Persistent extends StoreType // RocksDB-backed
    case object InMemory   extends StoreType // heap-based
  }

  case class StateStoreConfig(
    name: String,
    storeType: StoreType,
    changelogEnabled: Boolean,
    cachingEnabled: Boolean
  )

  case class KeyValueStore[K, V](
    config: StateStoreConfig,
    data: Map[K, V]
  ) {
    def get(key: K): Option[V] = data.get(key)
    def put(key: K, value: V): KeyValueStore[K, V] = copy(data = data + (key -> value))
    def delete(key: K): KeyValueStore[K, V] = copy(data = data - key)
    def all: Map[K, V] = data
  }

  case class TimestampedRecord[K, V](key: K, value: V, timestamp: Long)

  case class Window(startMs: Long, endMs: Long)

  sealed trait WindowType
  object WindowType {
    case class Tumbling(sizeMs: Long)                         extends WindowType
    case class Hopping(sizeMs: Long, advanceMs: Long)         extends WindowType
    case class Session(inactivityGapMs: Long)                 extends WindowType
  }

  sealed trait PunctuationType
  object PunctuationType {
    case object StreamTime    extends PunctuationType
    case object WallClockTime extends PunctuationType
  }

  case class PunctuatorConfig(
    intervalMs: Long,
    punctuationType: PunctuationType
  )

  // Exercise 1: Create and operate on a state store
  // TODO: Create a KeyValueStore[String, Int] with a Persistent store config
  //   (name = "counts-store", changelogEnabled = true, cachingEnabled = true).
  //   Then put ("a" -> 1), ("b" -> 2), ("c" -> 3) and return the store.
  def exercise1_createStateStore: KeyValueStore[String, Int] = ???

  // Exercise 2: Choose store type based on requirements
  // TODO: Given two booleans — `needsFastRestart` and `hasLargeState`:
  //   (true, _)      -> StoreType.Persistent (RocksDB survives restarts)
  //   (false, true)  -> StoreType.Persistent (large state shouldn't be in heap)
  //   (false, false) -> StoreType.InMemory   (small state, fast access, ok to rebuild)
  def exercise2_chooseStoreType(needsFastRestart: Boolean, hasLargeState: Boolean): StoreType = ???

  // Exercise 3: Compute tumbling windows for a list of timestamped records
  // TODO: Given a list of TimestampedRecord[String, Int] and a tumbling window size,
  //   assign each record to its window. Window start = (timestamp / sizeMs) * sizeMs.
  //   Return Map[Window, List[TimestampedRecord[String, Int]]].
  def exercise3_tumblingWindows[K, V](
    records: List[TimestampedRecord[K, V]],
    sizeMs: Long
  ): Map[Window, List[TimestampedRecord[K, V]]] = ???

  // Exercise 4: Compute hopping windows for a list of timestamped records
  // TODO: Given records and a hopping window config (sizeMs, advanceMs),
  //   a record at timestamp T belongs to all windows where:
  //   windowStart <= T < windowStart + sizeMs
  //   and windowStart is a multiple of advanceMs.
  //   The earliest possible windowStart = max(0, ((T - sizeMs) / advanceMs + 1) * advanceMs)
  //   Return Map[Window, List[TimestampedRecord[String, Int]]].
  def exercise4_hoppingWindows(
    records: List[TimestampedRecord[String, Int]],
    sizeMs: Long,
    advanceMs: Long
  ): Map[Window, List[TimestampedRecord[String, Int]]] = ???

  // Exercise 5: Compute session windows based on inactivity gap
  // TODO: Given records for a SINGLE key sorted by timestamp, and an inactivityGapMs,
  //   group consecutive records into sessions. A new session starts when the gap
  //   between consecutive records exceeds inactivityGapMs.
  //   Return List[(Window, List[TimestampedRecord[String, Int]])] where Window
  //   spans from first to last timestamp in the session.
  def exercise5_sessionWindows(
    records: List[TimestampedRecord[String, Int]],
    inactivityGapMs: Long
  ): List[(Window, List[TimestampedRecord[String, Int]])] = ???

  // Exercise 6: Perform windowed aggregation (sum values in each tumbling window per key)
  // TODO: Given records with String keys and Int values, and a tumbling window sizeMs,
  //   group by (key, window) and sum the values.
  //   Return Map[(String, Window), Int].
  def exercise6_windowedAggregation(
    records: List[TimestampedRecord[String, Int]],
    sizeMs: Long
  ): Map[(String, Window), Int] = ???

  // Exercise 7: Simulate a punctuator firing schedule
  // TODO: Given a PunctuatorConfig and a time range (startMs, endMs),
  //   return the list of timestamps at which the punctuator would fire.
  //   Fires at: startMs, startMs + interval, startMs + 2*interval, ...
  //   Include only times <= endMs.
  def exercise7_punctuatorSchedule(
    config: PunctuatorConfig,
    startMs: Long,
    endMs: Long
  ): List[Long] = ???

  // Exercise 8: Implement state store compaction
  // TODO: Given a KeyValueStore[String, Option[Int]], remove all entries where
  //   the value is None (tombstone compaction). Return the cleaned store
  //   with only Some(v) entries, unwrapped to KeyValueStore[String, Int].
  def exercise8_compactStore(
    store: KeyValueStore[String, Option[Int]]
  ): KeyValueStore[String, Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val store = exercise1_createStateStore
    assert(store.get("a").contains(1), "Exercise 1 failed: missing 'a'")
    assert(store.get("b").contains(2), "Exercise 1 failed: missing 'b'")
    assert(store.config.storeType == StoreType.Persistent, "Exercise 1 failed: wrong type")
    println("Exercise 1 passed: state store created")

    // Exercise 2
    assert(exercise2_chooseStoreType(true, false) == StoreType.Persistent, "Ex 2 failed")
    assert(exercise2_chooseStoreType(false, true) == StoreType.Persistent, "Ex 2 failed")
    assert(exercise2_chooseStoreType(false, false) == StoreType.InMemory, "Ex 2 failed")
    println("Exercise 2 passed: store type selection")

    // Exercise 3
    val recs = List(
      TimestampedRecord("a", 1, 100L), TimestampedRecord("a", 2, 150L),
      TimestampedRecord("a", 3, 250L)
    )
    val tumbling = exercise3_tumblingWindows(recs, 200L)
    assert(tumbling(Window(0L, 200L)).length == 2, "Exercise 3 failed")
    assert(tumbling(Window(200L, 400L)).length == 1, "Exercise 3 failed")
    println("Exercise 3 passed: tumbling windows")

    // Exercise 4
    val hopRecs = List(TimestampedRecord("a", 1, 150L))
    val hopping = exercise4_hoppingWindows(hopRecs, 200L, 100L)
    // 150 should fall in windows [0,200) and [100,300)
    assert(hopping.contains(Window(0L, 200L)), "Exercise 4 failed: missing [0,200)")
    assert(hopping.contains(Window(100L, 300L)), "Exercise 4 failed: missing [100,300)")
    println("Exercise 4 passed: hopping windows")

    // Exercise 5
    val sessRecs = List(
      TimestampedRecord("a", 1, 100L), TimestampedRecord("a", 2, 150L),
      TimestampedRecord("a", 3, 500L)
    )
    val sessions = exercise5_sessionWindows(sessRecs, 200L)
    assert(sessions.length == 2, s"Exercise 5 failed: expected 2 sessions, got ${sessions.length}")
    assert(sessions.head._1 == Window(100L, 150L), "Exercise 5 failed: wrong first session")
    println("Exercise 5 passed: session windows")

    // Exercise 6
    val aggRecs = List(
      TimestampedRecord("a", 5, 100L), TimestampedRecord("a", 3, 150L),
      TimestampedRecord("b", 10, 100L), TimestampedRecord("a", 7, 250L)
    )
    val agg = exercise6_windowedAggregation(aggRecs, 200L)
    assert(agg(("a", Window(0, 200))) == 8, "Exercise 6 failed")
    assert(agg(("b", Window(0, 200))) == 10, "Exercise 6 failed")
    assert(agg(("a", Window(200, 400))) == 7, "Exercise 6 failed")
    println("Exercise 6 passed: windowed aggregation")

    // Exercise 7
    val schedule = exercise7_punctuatorSchedule(
      PunctuatorConfig(100L, PunctuationType.StreamTime), 0L, 350L
    )
    assert(schedule == List(0L, 100L, 200L, 300L), s"Exercise 7 failed: got $schedule")
    println("Exercise 7 passed: punctuator schedule")

    // Exercise 8
    val dirtyStore = KeyValueStore(
      StateStoreConfig("test", StoreType.InMemory, true, false),
      Map("a" -> Some(1), "b" -> None, "c" -> Some(3), "d" -> None)
    )
    val clean = exercise8_compactStore(dirtyStore)
    assert(clean.all == Map("a" -> 1, "c" -> 3), "Exercise 8 failed")
    println("Exercise 8 passed: store compaction")

    println("\nAll Kafka008_StreamsState exercises passed!")
  }
}
