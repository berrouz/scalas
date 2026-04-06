package org.shev4ik.interview.system_design.level3_advanced

object SysDes012_Sharding {

  // ---- Domain types ----

  case class Shard(id: Int, data: Map[String, String] = Map.empty, requestCount: Long = 0)

  // ---- Exercise 1 ----
  // TODO: Implement range-based sharding.
  // Given N shards and a key space of integers [0, maxKey), assign each key to a shard
  // based on equal-sized ranges.
  // `shardForKey(key, numShards, maxKey)`: return the shard index (0-based).
  // Example: maxKey=100, numShards=4 => shard0=[0,25), shard1=[25,50), etc.
  // `distributeData(data, numShards, maxKey)`: distribute Map[Int, String] into shards.
  //   Return Map[shardIndex, Map[Int, String]]
  def rangeShardForKey(key: Int, numShards: Int, maxKey: Int): Int = ???

  def distributeByRange(data: Map[Int, String], numShards: Int, maxKey: Int): Map[Int, Map[Int, String]] = ???

  // ---- Exercise 2 ----
  // TODO: Implement hash-based sharding.
  // Use (key.hashCode.abs % numShards) to determine the shard.
  // `hashShardForKey(key, numShards)`: return shard index.
  // `distributeByHash(data, numShards)`: distribute Map[String, String] into shards.
  //   Return Map[shardIndex, Map[String, String]]
  def hashShardForKey(key: String, numShards: Int): Int = ???

  def distributeByHash(data: Map[String, String], numShards: Int): Map[Int, Map[String, String]] = ???

  // ---- Exercise 3 ----
  // TODO: Implement consistent hashing for sharding.
  // Place shards on a ring of size `ringSize`. Each shard has a position = (shardId.hashCode.abs % ringSize).
  // To find the shard for a key, compute keyPos = (key.hashCode.abs % ringSize),
  // then walk clockwise to find the first shard.
  // `buildRing(shardIds, ringSize)`: return sorted list of (position, shardId)
  // `findShard(ring, key, ringSize)`: return shardId for the given key
  def buildRing(shardIds: List[String], ringSize: Int): List[(Int, String)] = ???

  def findShard(ring: List[(Int, String)], key: String, ringSize: Int): String = ???

  // ---- Exercise 4 ----
  // TODO: Implement virtual nodes for consistent hashing.
  // Each physical shard gets `numVirtual` virtual nodes on the ring.
  // Virtual node positions: ((shardId + "#" + i).hashCode.abs % ringSize) for i in [0, numVirtual).
  // Return the ring with virtual nodes sorted by position.
  // `findShardVirtual` maps back to the physical shard.
  def buildVirtualRing(shardIds: List[String], numVirtual: Int, ringSize: Int): List[(Int, String)] = ???

  def findShardVirtual(ring: List[(Int, String)], key: String, ringSize: Int): String = ???

  // ---- Exercise 5 ----
  // TODO: Implement shard rebalancing.
  // When a new shard is added, some keys need to move from existing shards to the new one.
  // Given current assignment (Map[String, Int] = key -> shardIndex) and new total shards,
  // recalculate using hash-based sharding and return:
  // - newAssignment: Map[String, Int]
  // - movedKeys: Set[String] (keys that changed shard)
  def rebalance(
    currentAssignment: Map[String, Int],
    newNumShards: Int
  ): (Map[String, Int], Set[String]) = ???

  // ---- Exercise 6 ----
  // TODO: Implement shard routing.
  // Given a request key and a shard map (Map[shardIndex, hostAddress]),
  // determine which host should handle the request.
  // Use hash-based sharding.
  // Also implement a router that handles multiple strategies.
  def routeRequest(key: String, shardMap: Map[Int, String], numShards: Int): String = ???

  // Route with custom shard function
  def routeWithStrategy(
    key: String,
    shardMap: Map[Int, String],
    shardFn: String => Int
  ): String = ???

  // ---- Exercise 7 ----
  // TODO: Implement hot shard detection.
  // Given a list of shards with their request counts, detect shards that are "hot"
  // (request count > mean + threshold * stddev).
  // Return the list of hot shard IDs.
  // Also calculate the load distribution: Map[shardId, Double] as percentage of total.
  def detectHotShards(shards: List[Shard], thresholdMultiplier: Double): List[Int] = ???

  def loadDistribution(shards: List[Shard]): Map[Int, Double] = ???

  // ---- Exercise 8 ----
  // TODO: Implement cross-shard query.
  // A query that spans multiple shards. Given a predicate on values, query all shards
  // and merge results.
  // `crossShardQuery(shards, predicate)`: search all shards for entries matching the predicate.
  //   Return List[(shardId, key, value)] for all matches.
  // `crossShardAggregate(shards, aggregateFn)`: apply an aggregate function across all shards.
  //   aggregateFn takes all (key, value) pairs and produces a result.
  def crossShardQuery(
    shards: List[Shard],
    predicate: (String, String) => Boolean
  ): List[(Int, String, String)] = ???

  def crossShardAggregate[A](
    shards: List[Shard],
    aggregateFn: List[(String, String)] => A
  ): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Range-based sharding
    assert(rangeShardForKey(10, 4, 100) == 0)   // [0,25)
    assert(rangeShardForKey(30, 4, 100) == 1)   // [25,50)
    assert(rangeShardForKey(75, 4, 100) == 3)   // [75,100)
    val rangeData = Map(5 -> "a", 30 -> "b", 60 -> "c", 90 -> "d")
    val distributed = distributeByRange(rangeData, 4, 100)
    assert(distributed(0).contains(5))
    assert(distributed(1).contains(30))
    println("Exercise 1 passed: Range-based sharding")

    // Exercise 2: Hash-based sharding
    val hs1 = hashShardForKey("key1", 4)
    assert(hs1 >= 0 && hs1 < 4)
    assert(hashShardForKey("key1", 4) == hashShardForKey("key1", 4)) // deterministic
    val hashData = Map("a" -> "1", "b" -> "2", "c" -> "3")
    val hashDist = distributeByHash(hashData, 3)
    assert(hashDist.values.flatMap(_.keys).toSet == Set("a", "b", "c"))
    println("Exercise 2 passed: Hash-based sharding")

    // Exercise 3: Consistent Hashing
    val ring = buildRing(List("shard0", "shard1", "shard2"), 360)
    assert(ring.nonEmpty)
    val foundShard = findShard(ring, "myKey", 360)
    assert(List("shard0", "shard1", "shard2").contains(foundShard))
    // Same key always maps to same shard
    assert(findShard(ring, "test", 360) == findShard(ring, "test", 360))
    println("Exercise 3 passed: Consistent Hashing")

    // Exercise 4: Virtual Nodes
    val vRing = buildVirtualRing(List("s0", "s1"), 3, 360)
    assert(vRing.length == 6) // 2 shards * 3 virtual each
    val vShard = findShardVirtual(vRing, "someKey", 360)
    assert(vShard == "s0" || vShard == "s1") // maps back to physical
    println("Exercise 4 passed: Virtual Nodes")

    // Exercise 5: Shard Rebalancing
    val current = Map("k1" -> 0, "k2" -> 1, "k3" -> 0)
    val (newAssign, moved) = rebalance(current, 4)
    assert(newAssign.size == 3)
    assert(newAssign.values.forall(v => v >= 0 && v < 4))
    println("Exercise 5 passed: Shard Rebalancing")

    // Exercise 6: Shard Routing
    val shardMap = Map(0 -> "host-a:8080", 1 -> "host-b:8080", 2 -> "host-c:8080")
    val host = routeRequest("user123", shardMap, 3)
    assert(shardMap.values.toSet.contains(host))
    val host2 = routeWithStrategy("user123", shardMap, k => k.length % 3)
    assert(shardMap.values.toSet.contains(host2))
    println("Exercise 6 passed: Shard Routing")

    // Exercise 7: Hot Shard Detection
    val shards = List(
      Shard(0, requestCount = 100),
      Shard(1, requestCount = 110),
      Shard(2, requestCount = 500),  // hot!
      Shard(3, requestCount = 90)
    )
    val hot = detectHotShards(shards, 1.5)
    assert(hot.contains(2))
    assert(!hot.contains(0))
    val dist = loadDistribution(shards)
    assert(dist.values.sum > 0.99 && dist.values.sum < 1.01) // sums to ~1.0
    println("Exercise 7 passed: Hot Shard Detection")

    // Exercise 8: Cross-shard Query
    val queryShards = List(
      Shard(0, data = Map("k1" -> "apple", "k2" -> "banana")),
      Shard(1, data = Map("k3" -> "avocado", "k4" -> "cherry"))
    )
    val results = crossShardQuery(queryShards, (_, v) => v.startsWith("a"))
    assert(results.length == 2) // apple, avocado
    assert(results.exists(_._3 == "apple"))
    assert(results.exists(_._3 == "avocado"))
    val totalEntries = crossShardAggregate(queryShards, pairs => pairs.length)
    assert(totalEntries == 4)
    println("Exercise 8 passed: Cross-shard Query")

    println("All SysDes012_Sharding exercises passed!")
  }
}
