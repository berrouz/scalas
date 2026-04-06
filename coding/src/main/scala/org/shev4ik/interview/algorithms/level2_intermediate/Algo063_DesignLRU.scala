package org.shev4ik.interview.algorithms.level2_intermediate

object Algo063_DesignLRU {

  // Exercise 1: LRU Cache using LinkedHashMap
  // TODO: Use scala.collection.mutable.LinkedHashMap. On get, remove and re-insert. On put, evict oldest if full.
  class LRUCacheSimple(capacity: Int) {
    def get(key: Int): Int = ???
    def put(key: Int, value: Int): Unit = ???
  }

  // Exercise 2: LRU Cache from scratch with doubly linked list + HashMap
  // TODO: Doubly linked list for order. HashMap for O(1) access. Move to front on access. Remove tail on eviction.
  class LRUCache(capacity: Int) {
    def get(key: Int): Int = ???
    def put(key: Int, value: Int): Unit = ???
  }

  // Exercise 3: LFU Cache — evict least frequently used, break ties by LRU
  // TODO: Track frequency for each key. Map from frequency to ordered set. Maintain minFreq.
  class LFUCache(capacity: Int) {
    def get(key: Int): Int = ???
    def put(key: Int, value: Int): Unit = ???
  }

  // Exercise 4: All O(1) Data Structure — inc, dec, getMaxKey, getMinKey all in O(1)
  // TODO: Doubly linked list of count buckets. Each bucket holds a set of keys with that count.
  class AllOne {
    def inc(key: String): Unit = ???
    def dec(key: String): Unit = ???
    def getMaxKey: String = ???
    def getMinKey: String = ???
  }

  // Exercise 5: Insert Delete GetRandom O(1)
  // TODO: ArrayList + HashMap. Swap with last element on remove. Random index for getRandom.
  class RandomizedSet {
    def insert(value: Int): Boolean = ???
    def remove(value: Int): Boolean = ???
    def getRandom(): Int = ???
  }

  // Exercise 6: Maximum Frequency Stack — pop most frequent element (break ties by recency)
  // TODO: Map from frequency to stack. Track maxFreq. Push: increment freq, add to freq stack. Pop: from maxFreq stack.
  class FreqStack {
    def push(value: Int): Unit = ???
    def pop(): Int = ???
  }

  // Exercise 7: Time Based Key-Value Store — get value at or before given timestamp
  // TODO: Map from key to sorted list of (timestamp, value). Binary search for timestamp.
  class TimeMap {
    def set(key: String, value: String, timestamp: Int): Unit = ???
    def get(key: String, timestamp: Int): String = ???
  }

  // Exercise 8: Snapshot Array — take snapshots and get value at any snapshot
  // TODO: For each index, store list of (snapId, value). Binary search for snap.
  class SnapshotArray(length: Int) {
    def set(index: Int, value: Int): Unit = ???
    def snap(): Int = ???
    def get(index: Int, snapId: Int): Int = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val lru1 = new LRUCacheSimple(2)
    lru1.put(1, 1)
    lru1.put(2, 2)
    assert(lru1.get(1) == 1, "Get key 1")
    lru1.put(3, 3) // evicts key 2
    assert(lru1.get(2) == -1, "Key 2 evicted")

    // Exercise 2
    val lru2 = new LRUCache(2)
    lru2.put(1, 1)
    lru2.put(2, 2)
    assert(lru2.get(1) == 1, "Get key 1")
    lru2.put(3, 3)
    assert(lru2.get(2) == -1, "Key 2 evicted")

    // Exercise 3
    val lfu = new LFUCache(2)
    lfu.put(1, 1)
    lfu.put(2, 2)
    assert(lfu.get(1) == 1, "LFU get 1")
    lfu.put(3, 3) // evicts key 2 (least frequent)
    assert(lfu.get(2) == -1, "Key 2 evicted (LFU)")

    // Exercise 4
    val ao = new AllOne()
    ao.inc("hello")
    ao.inc("hello")
    ao.inc("world")
    assert(ao.getMaxKey == "hello", "Max key is hello")
    assert(ao.getMinKey == "world", "Min key is world")

    // Exercise 5
    val rs = new RandomizedSet()
    assert(rs.insert(1), "Insert 1")
    assert(!rs.insert(1), "Duplicate insert")
    assert(rs.remove(1), "Remove 1")
    assert(!rs.remove(1), "Remove non-existent")

    // Exercise 6
    val fs = new FreqStack()
    fs.push(5); fs.push(7); fs.push(5); fs.push(7); fs.push(4); fs.push(5)
    assert(fs.pop() == 5, "Most frequent is 5")
    assert(fs.pop() == 7, "Next most frequent is 7")

    // Exercise 7
    val tm = new TimeMap()
    tm.set("foo", "bar", 1)
    assert(tm.get("foo", 1) == "bar", "Get at timestamp 1")
    assert(tm.get("foo", 3) == "bar", "Get at timestamp 3 returns bar")
    tm.set("foo", "bar2", 4)
    assert(tm.get("foo", 4) == "bar2", "Get at timestamp 4")
    assert(tm.get("foo", 5) == "bar2", "Get at timestamp 5")

    // Exercise 8
    val sa = new SnapshotArray(3)
    sa.set(0, 5)
    val snap0 = sa.snap()
    sa.set(0, 6)
    assert(sa.get(0, snap0) == 5, "Snapshot 0 value is 5")

    println("All Algo063_DesignLRU exercises passed!")
  }
}
