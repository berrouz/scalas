package org.shev4ik.interview.system_design.level1_fundamentals

/**
 * Caching -- Patterns, Strategies, and Trade-offs
 *
 * =Why caching?=
 * Caching stores frequently accessed data in a fast layer (memory) to reduce latency and load
 * on slower backends (databases, APIs). It is one of the most impactful performance optimizations
 * and appears in almost every system design interview.
 *
 * =Caching Patterns=
 *
 * '''1. Cache-Aside (Lazy Loading)'''
 *   - Application checks cache first. On miss, reads from DB, populates cache, returns.
 *   - Pros: only requested data is cached; cache failure does not break reads (fallback to DB).
 *   - Cons: cache miss = 3 round trips (check cache, read DB, write cache); data can become stale.
 *
 * '''2. Read-Through'''
 *   - Cache sits between app and DB. On miss, the cache itself loads from DB transparently.
 *   - Pros: simpler application code; consistent cache population logic.
 *   - Cons: first request for each key is slow; cache library must support this pattern.
 *
 * '''3. Write-Through'''
 *   - Every write goes to both cache AND DB synchronously before confirming success.
 *   - Pros: cache is always consistent with DB; reads are always fast after a write.
 *   - Cons: higher write latency (two writes per operation); unused data may fill cache.
 *
 * '''4. Write-Behind (Write-Back)'''
 *   - Writes go to cache only; dirty entries are flushed to DB asynchronously in batches.
 *   - Pros: very fast writes; reduces DB write load via batching.
 *   - Cons: risk of data loss if cache crashes before flush; eventual consistency.
 *
 * =Eviction Policies=
 *   - '''LRU''' (Least Recently Used) -- evicts the entry not accessed for the longest time.
 *     Implemented with a HashMap + doubly-linked list. O(1) get/put.
 *   - '''LFU''' (Least Frequently Used) -- evicts the entry with the fewest accesses.
 *     More complex (frequency buckets). Good for skewed access patterns.
 *   - '''FIFO''' -- evicts the oldest entry. Simple but ignores access patterns.
 *   - '''TTL''' (Time-To-Live) -- entries expire after a fixed duration. Good for freshness.
 *
 * =Interview Context=
 * "Caching is asked in almost every system design interview. Know the trade-offs: consistency
 * vs performance, TTL strategies, cache invalidation (one of the 'two hard things in CS')."
 *
 * Key discussion points:
 *   - '''Cache invalidation''': How do you ensure stale data is removed? TTL, event-driven
 *     invalidation, versioning.
 *   - '''Thundering herd''': When a popular key expires, many requests hit the DB simultaneously.
 *     Solutions: locking, request coalescing, pre-warming.
 *   - '''Consistency''': Write-through gives strong consistency; cache-aside + TTL gives eventual.
 *   - '''Distributed caching''': Consistent hashing for key distribution across nodes. Redis,
 *     Memcached as real-world examples.
 *   - '''Cache sizing''': Pareto principle -- 80/20 rule. Cache the hot 20% of data.
 *
 * =Complexity of exercises below=
 *   - LRU Cache: O(1) get/put with HashMap + ordered structure (LeetCode #146).
 *   - LFU Cache: O(1) get/put with HashMap + frequency buckets (LeetCode #460).
 *   - TTL Cache: O(1) get/put, O(n) cleanup.
 *   - Write-through/Write-back: O(1) per operation.
 *   - Distributed cache: O(1) routing via hash, O(1) per-node LRU operations.
 */
object SysDes002_Caching {

  // ---- Exercise 1 ----
  // TODO: Implement an LRU (Least Recently Used) cache.
  // - `capacity`: max number of entries
  // - `get(key)`: return Some(value) if present (marks as recently used), None otherwise
  // - `put(key, value)`: insert or update; if over capacity, evict least recently used
  // - `toList`: return entries from most-recently-used to least-recently-used as List[(K,V)]
  // Hint: use a combination of a Map and a List/Vector to track access order.
  trait LRUCache[K, V] {
    def get(key: K): (LRUCache[K, V], Option[V])
    def put(key: K, value: V): LRUCache[K, V]
    def toList: List[(K, V)]
    def size: Int
  }

  def createLRUCache[K, V](capacity: Int): LRUCache[K, V] = ???

  // ---- Exercise 2 ----
  // TODO: Implement an LFU (Least Frequently Used) cache.
  // - `get(key)`: return Some(value) and increment frequency, None if missing
  // - `put(key, value)`: insert or update; if over capacity, evict the key with lowest frequency
  //   (break ties by least recently used)
  // - `frequencies`: return Map[K, Int] showing access frequency per key
  trait LFUCache[K, V] {
    def get(key: K): (LFUCache[K, V], Option[V])
    def put(key: K, value: V): LFUCache[K, V]
    def frequencies: Map[K, Int]
    def size: Int
  }

  def createLFUCache[K, V](capacity: Int): LFUCache[K, V] = ???

  // ---- Exercise 3 ----
  // TODO: Implement a TTL (Time-To-Live) cache.
  // Each entry has an expiration timestamp. `get` should return None for expired entries.
  // `put` adds an entry with `currentTime + ttl` as expiration.
  // `cleanup(currentTime)` removes all expired entries.
  // Use Long for timestamps (milliseconds).
  case class TTLEntry[V](value: V, expiresAt: Long)

  trait TTLCache[K, V] {
    def get(key: K, currentTime: Long): (TTLCache[K, V], Option[V])
    def put(key: K, value: V, currentTime: Long, ttlMs: Long): TTLCache[K, V]
    def cleanup(currentTime: Long): TTLCache[K, V]
    def size: Int
  }

  def createTTLCache[K, V](): TTLCache[K, V] = ???

  // ---- Exercise 4 ----
  // TODO: Implement a write-through cache simulation.
  // On `put`, write to both cache AND the backing store (a Map).
  // On `get`, read from cache first; if missing, read from store, populate cache, and return.
  // Return (updatedCache, updatedStore, result).
  def writeThroughGet[K, V](
    cache: Map[K, V],
    store: Map[K, V],
    key: K
  ): (Map[K, V], Map[K, V], Option[V]) = ???

  def writeThroughPut[K, V](
    cache: Map[K, V],
    store: Map[K, V],
    key: K,
    value: V
  ): (Map[K, V], Map[K, V]) = ???

  // ---- Exercise 5 ----
  // TODO: Implement a write-back (write-behind) cache concept.
  // On `put`, write to cache only and mark key as "dirty".
  // `flush` writes all dirty entries to the store and clears dirty set.
  // Return updated (cache, store, dirtyKeys).
  def writeBackPut[K, V](
    cache: Map[K, V],
    store: Map[K, V],
    dirtyKeys: Set[K],
    key: K,
    value: V
  ): (Map[K, V], Map[K, V], Set[K]) = ???

  def writeBackFlush[K, V](
    cache: Map[K, V],
    store: Map[K, V],
    dirtyKeys: Set[K]
  ): (Map[K, V], Map[K, V], Set[K]) = ???

  // ---- Exercise 6 ----
  // TODO: Implement multiple eviction policies as functions.
  // Given a cache as Map[String, (Int, Long)] where value = (accessCount, lastAccessTime),
  // return the key to evict based on the policy:
  // - "LRU": evict key with smallest lastAccessTime
  // - "LFU": evict key with smallest accessCount (break ties by lastAccessTime)
  // - "FIFO": evict key with smallest insertionOrder (use lastAccessTime as proxy for insertion)
  def evictionCandidate(
    cache: Map[String, (Int, Long)],
    policy: String
  ): String = ???

  // ---- Exercise 7 ----
  // TODO: Calculate cache hit rate.
  // Given a list of key access requests and a cache with fixed capacity (LRU policy),
  // simulate the accesses and return the hit rate as a Double (hits / totalRequests).
  // Use your LRU cache or a simplified simulation.
  // Example: capacity=2, requests=[A,B,A,C,B] => hits=1(A), misses=4 => rate=1/5=0.2
  def cacheHitRate(capacity: Int, requests: List[String]): Double = ???

  // ---- Exercise 8 ----
  // TODO: Simulate a distributed cache with N nodes.
  // Use consistent hashing (key.hashCode.abs % numNodes) to route keys to nodes.
  // Each node is an independent LRU cache with given capacity.
  // `put(key, value)` routes to the correct node and inserts.
  // `get(key)` routes to the correct node and retrieves.
  // Return the node index a key maps to with `nodeFor(key)`.
  trait DistributedCache[V] {
    def put(key: String, value: V): DistributedCache[V]
    def get(key: String): (DistributedCache[V], Option[V])
    def nodeFor(key: String): Int
  }

  def createDistributedCache[V](numNodes: Int, capacityPerNode: Int): DistributedCache[V] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: LRU Cache
    val lru0 = createLRUCache[String, Int](2)
    val lru1 = lru0.put("a", 1).put("b", 2)
    assert(lru1.size == 2)
    val (lru2, v1) = lru1.get("a")
    assert(v1.contains(1))
    val lru3 = lru2.put("c", 3) // evicts "b" (least recently used)
    val (_, vb) = lru3.get("b")
    assert(vb.isEmpty)
    val (_, va) = lru3.get("a")
    assert(va.contains(1))
    println("Exercise 1 passed: LRU Cache")

    // Exercise 2: LFU Cache
    val lfu0 = createLFUCache[String, Int](2)
    val lfu1 = lfu0.put("a", 1).put("b", 2)
    val (lfu2, _) = lfu1.get("a") // a freq=2, b freq=1
    val lfu3 = lfu2.put("c", 3) // evicts "b" (lowest freq)
    val (_, lfuVb) = lfu3.get("b")
    assert(lfuVb.isEmpty)
    val (_, lfuVa) = lfu3.get("a")
    assert(lfuVa.contains(1))
    println("Exercise 2 passed: LFU Cache")

    // Exercise 3: TTL Cache
    val ttl0 = createTTLCache[String, Int]()
    val ttl1 = ttl0.put("a", 1, currentTime = 100, ttlMs = 50)
    val (_, tv1) = ttl1.get("a", currentTime = 120) // not expired
    assert(tv1.contains(1))
    val (_, tv2) = ttl1.get("a", currentTime = 200) // expired
    assert(tv2.isEmpty)
    println("Exercise 3 passed: TTL Cache")

    // Exercise 4: Write-through cache
    val (wc1, ws1, wv1) = writeThroughGet(Map.empty[String, Int], Map("x" -> 10), "x")
    assert(wv1.contains(10))
    assert(wc1.contains("x")) // cache populated
    val (wc2, ws2) = writeThroughPut(Map.empty[String, Int], Map.empty[String, Int], "y", 20)
    assert(wc2("y") == 20 && ws2("y") == 20) // both updated
    println("Exercise 4 passed: Write-through cache")

    // Exercise 5: Write-back cache
    val (wbc, wbs, wbd) = writeBackPut(Map.empty[String, Int], Map.empty[String, Int], Set.empty[String], "a", 1)
    assert(wbc("a") == 1)
    assert(!wbs.contains("a")) // not in store yet
    assert(wbd.contains("a")) // marked dirty
    val (_, wbs2, wbd2) = writeBackFlush(wbc, wbs, wbd)
    assert(wbs2("a") == 1) // flushed to store
    assert(wbd2.isEmpty)
    println("Exercise 5 passed: Write-back cache")

    // Exercise 6: Eviction policies
    val evCache = Map("a" -> (5, 100L), "b" -> (2, 200L), "c" -> (2, 150L))
    assert(evictionCandidate(evCache, "LRU") == "a") // oldest access
    assert(evictionCandidate(evCache, "LFU") == "c") // lowest freq, older access
    assert(evictionCandidate(evCache, "FIFO") == "a") // earliest insertion
    println("Exercise 6 passed: Eviction policies")

    // Exercise 7: Cache hit rate
    val rate = cacheHitRate(2, List("a", "b", "a", "c", "b"))
    assert(rate >= 0.19 && rate <= 0.21) // 1 hit out of 5 = 0.2
    assert(cacheHitRate(1, List("a", "a", "a")) >= 0.65) // 2 hits out of 3
    println("Exercise 7 passed: Cache hit rate")

    // Exercise 8: Distributed cache
    val dc0 = createDistributedCache[Int](3, 2)
    val dc1 = dc0.put("key1", 100).put("key2", 200)
    val (_, dcv1) = dc1.get("key1")
    assert(dcv1.contains(100))
    // Same key always goes to same node
    assert(dc1.nodeFor("key1") == dc1.nodeFor("key1"))
    println("Exercise 8 passed: Distributed cache")

    println("All SysDes002_Caching exercises passed!")
  }
}
