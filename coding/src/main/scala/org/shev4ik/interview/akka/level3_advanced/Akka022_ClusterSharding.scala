package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 022 - Cluster Sharding
 *
 * Cluster Sharding distributes actors across the cluster by entity ID:
 *   - Shard Region: the entry point for sending messages to sharded entities
 *   - Entity ID: unique identifier for each entity actor
 *   - Shard ID: groups entities, determines which node hosts them
 *   - Passivation: stopping idle entities to free resources
 *   - Remember Entities: re-create entities after rebalance/restart
 *   - Shard Allocation: strategy for assigning shards to nodes
 *   - Rebalancing: moving shards between nodes for even distribution
 *   - Multi-DC: running shards across data centers
 *
 * We model these concepts using pure Scala.
 */
object Akka022_ClusterSharding {

  // --- Domain models ---

  case class Entity(entityId: String, shardId: Int, state: Map[String, Any], isActive: Boolean, lastAccessMs: Long)

  case class ShardRegion(
    regionName: String,
    numberOfShards: Int,
    shards: Map[Int, Shard],
    shardAllocation: Map[Int, String] // shardId -> nodeAddress
  )

  case class Shard(
    shardId: Int,
    entities: Map[String, Entity],
    nodeAddress: String
  )

  case class PassivationConfig(idleTimeoutMs: Long, maxEntitiesPerShard: Int)

  case class RebalanceResult(
    movedShards: List[(Int, String, String)], // (shardId, fromNode, toNode)
    finalAllocation: Map[Int, String]
  )

  // Exercise 1: Shard Region — extract entity ID and shard ID
  // TODO: Given a message envelope (entityId, payload) and numberOfShards,
  //   calculate shardId = abs(entityId.hashCode) % numberOfShards.
  //   Return (entityId, shardId).
  def exercise1_shardRegion(entityId: String, numberOfShards: Int): (String, Int) = ???

  // Exercise 2: Entity ID to shard mapping
  // TODO: Given a list of entity IDs and numberOfShards,
  //   group entities by their shard ID.
  //   Return Map[Int, List[String]] (shardId -> list of entity IDs).
  def exercise2_entityShardMapping(entityIds: List[String], numberOfShards: Int): Map[Int, List[String]] = ???

  // Exercise 3: Shard ID calculation strategies
  // TODO: Implement two shard ID extraction strategies:
  //   "hashCode": abs(entityId.hashCode) % numberOfShards
  //   "prefix": extract numeric prefix from entityId (e.g., "123-order" -> 123 % numberOfShards)
  //     If no numeric prefix, use hashCode strategy as fallback.
  //   Return the shardId for the given strategy.
  def exercise3_shardIdStrategies(
    entityId: String,
    numberOfShards: Int,
    strategy: String
  ): Int = ???

  // Exercise 4: Passivation — stop idle entities
  // TODO: Given a Shard and a PassivationConfig, determine which entities to passivate:
  //   1. Entities idle longer than idleTimeoutMs (currentTimeMs - lastAccessMs > idleTimeoutMs)
  //   2. If entities exceed maxEntitiesPerShard, passivate least recently accessed first
  //   Return (list of passivated entity IDs, updated Shard with passivated entities removed).
  def exercise4_passivation(
    shard: Shard,
    config: PassivationConfig,
    currentTimeMs: Long
  ): (List[String], Shard) = ???

  // Exercise 5: Remember Entities
  // TODO: Given a list of previously known entity IDs and a current Shard,
  //   determine which entities need to be re-created (present in known list but not in shard).
  //   Create new Entity entries for them with empty state, isActive=true, lastAccessMs=currentTimeMs.
  //   Return the updated Shard.
  def exercise5_rememberEntities(
    knownEntityIds: List[String],
    shard: Shard,
    currentTimeMs: Long
  ): Shard = ???

  // Exercise 6: Shard Allocation — least-shards strategy
  // TODO: Given a list of node addresses and current allocation (Map[Int, String]),
  //   allocate a new shard to the node with the fewest shards.
  //   In case of tie, pick the node that comes first alphabetically.
  //   Return the updated allocation.
  def exercise6_shardAllocation(
    nodes: List[String],
    currentAllocation: Map[Int, String],
    newShardId: Int
  ): Map[Int, String] = ???

  // Exercise 7: Rebalancing — even distribution
  // TODO: Given a current allocation and list of active nodes,
  //   rebalance shards so each node has approximately equal count.
  //   Move shards from nodes with most shards to nodes with fewest.
  //   Target: each node should have at most ceil(totalShards / nodeCount) shards.
  //   Return RebalanceResult with moved shards and final allocation.
  def exercise7_rebalancing(
    currentAllocation: Map[Int, String],
    activeNodes: List[String]
  ): RebalanceResult = ???

  // Exercise 8: Multi-DC concept
  // TODO: Given a list of entities with DC tags (entityId -> dcName),
  //   and a numberOfShards, assign shards per DC independently.
  //   Each DC has its own shard space. Return Map[String, Map[Int, List[String]]]
  //   (dcName -> (shardId -> entityIds)).
  def exercise8_multiDC(
    entities: List[(String, String)], // (entityId, dcName)
    numberOfShards: Int
  ): Map[String, Map[Int, List[String]]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (eid1, sid1) = exercise1_shardRegion("order-123", 10)
    assert(eid1 == "order-123", s"Exercise 1 failed: entityId = $eid1")
    assert(sid1 >= 0 && sid1 < 10, s"Exercise 1 failed: shardId = $sid1")
    println(s"Exercise 1 passed: entity=$eid1, shard=$sid1")

    // Exercise 2
    val r2 = exercise2_entityShardMapping(List("a", "b", "c", "d", "e"), 3)
    val totalMapped = r2.values.flatten.toList.sorted
    assert(totalMapped == List("a", "b", "c", "d", "e"), s"Exercise 2 failed: $totalMapped")
    println(s"Exercise 2 passed: mapping = $r2")

    // Exercise 3
    val r3a = exercise3_shardIdStrategies("entity-1", 10, "hashCode")
    assert(r3a >= 0 && r3a < 10, s"Exercise 3 failed: hashCode result = $r3a")
    val r3b = exercise3_shardIdStrategies("42-order", 10, "prefix")
    assert(r3b == 2, s"Exercise 3 failed: prefix result = $r3b (expected 42 % 10 = 2)")
    println(s"Exercise 3 passed: hashCode=$r3a, prefix=$r3b")

    // Exercise 4
    val entities4 = Map(
      "e1" -> Entity("e1", 0, Map.empty, isActive = true, lastAccessMs = 1000L),
      "e2" -> Entity("e2", 0, Map.empty, isActive = true, lastAccessMs = 5000L),
      "e3" -> Entity("e3", 0, Map.empty, isActive = true, lastAccessMs = 9000L)
    )
    val shard4 = Shard(0, entities4, "node-1")
    val config4 = PassivationConfig(idleTimeoutMs = 5000L, maxEntitiesPerShard = 10)
    val (passivated4, shard4b) = exercise4_passivation(shard4, config4, 10000L)
    assert(passivated4.contains("e1"), s"Exercise 4 failed: passivated = $passivated4")
    assert(!shard4b.entities.contains("e1"), "Exercise 4 failed: e1 should be removed")
    println(s"Exercise 4 passed: passivated = $passivated4")

    // Exercise 5
    val shard5 = Shard(0, Map("e1" -> Entity("e1", 0, Map.empty, isActive = true, 1000L)), "node-1")
    val r5 = exercise5_rememberEntities(List("e1", "e2", "e3"), shard5, 5000L)
    assert(r5.entities.size == 3, s"Exercise 5 failed: ${r5.entities.size} entities")
    assert(r5.entities("e2").lastAccessMs == 5000L, "Exercise 5 failed: e2 timestamp wrong")
    println(s"Exercise 5 passed: ${r5.entities.size} entities after remember")

    // Exercise 6
    val alloc6 = Map(0 -> "node-A", 1 -> "node-A", 2 -> "node-B")
    val r6 = exercise6_shardAllocation(List("node-A", "node-B", "node-C"), alloc6, 3)
    assert(r6(3) == "node-C", s"Exercise 6 failed: shard 3 -> ${r6(3)}")
    println(s"Exercise 6 passed: shard 3 allocated to ${r6(3)}")

    // Exercise 7
    val alloc7 = Map(0 -> "A", 1 -> "A", 2 -> "A", 3 -> "B")
    val r7 = exercise7_rebalancing(alloc7, List("A", "B"))
    // A has 3, B has 1. Target: 2 each. Move 1 shard from A to B.
    assert(r7.movedShards.size == 1, s"Exercise 7 failed: moved ${r7.movedShards.size}")
    val aCount = r7.finalAllocation.values.count(_ == "A")
    val bCount = r7.finalAllocation.values.count(_ == "B")
    assert(aCount == 2 && bCount == 2, s"Exercise 7 failed: A=$aCount, B=$bCount")
    println(s"Exercise 7 passed: rebalanced, moved=${r7.movedShards.size}")

    // Exercise 8
    val entities8 = List(
      ("order-1", "us-east"),
      ("order-2", "us-east"),
      ("order-3", "eu-west"),
      ("order-4", "eu-west")
    )
    val r8 = exercise8_multiDC(entities8, 3)
    assert(r8.contains("us-east"), "Exercise 8 failed: missing us-east")
    assert(r8.contains("eu-west"), "Exercise 8 failed: missing eu-west")
    val usEntities = r8("us-east").values.flatten.toList
    assert(usEntities.sorted == List("order-1", "order-2"), s"Exercise 8 failed: us = $usEntities")
    println(s"Exercise 8 passed: ${r8.keys.mkString(", ")} DCs configured")

    println("\nAll Akka022_ClusterSharding exercises passed!")
  }
}
