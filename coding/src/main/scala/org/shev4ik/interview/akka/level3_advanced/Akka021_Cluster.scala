package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 021 - Cluster Basics
 *
 * Akka Cluster provides distribution and fault tolerance:
 *   - Cluster config: seed nodes, join/leave protocol
 *   - Seed nodes: initial contact points for cluster formation
 *   - Member events: MemberUp, MemberRemoved, UnreachableMember
 *   - Cluster Singleton: exactly one instance of an actor across the cluster
 *   - Cluster Sharding: distribute actors across the cluster by entity ID
 *   - Distributed Pub-Sub: publish/subscribe across cluster nodes
 *   - Cluster-aware router: route messages to actors on different nodes
 *   - Split Brain Resolver: handle network partitions
 *
 * We model these concepts using pure Scala.
 */
object Akka021_Cluster {

  // --- Domain models ---

  sealed trait MemberStatus
  case object Joining extends MemberStatus
  case object Up extends MemberStatus
  case object Leaving extends MemberStatus
  case object Exiting extends MemberStatus
  case object Down extends MemberStatus
  case object Removed extends MemberStatus
  case object Unreachable extends MemberStatus

  case class ClusterMember(address: String, roles: Set[String], status: MemberStatus)

  sealed trait MemberEvent
  case class MemberJoined(address: String) extends MemberEvent
  case class MemberUp(address: String) extends MemberEvent
  case class MemberLeft(address: String) extends MemberEvent
  case class MemberExited(address: String) extends MemberEvent
  case class MemberDowned(address: String) extends MemberEvent
  case class MemberRemoved(address: String) extends MemberEvent
  case class MemberUnreachable(address: String) extends MemberEvent
  case class MemberReachable(address: String) extends MemberEvent

  case class ClusterState(
    members: Map[String, ClusterMember],
    leader: Option[String],
    seedNodes: List[String]
  )

  case class PubSubTopic(name: String, subscribers: Set[String])

  sealed trait SplitBrainStrategy
  case class KeepMajority(role: Option[String]) extends SplitBrainStrategy
  case class KeepOldest(downIfAlone: Boolean) extends SplitBrainStrategy
  case class StaticQuorum(quorumSize: Int) extends SplitBrainStrategy
  case object KeepReferee extends SplitBrainStrategy

  // Exercise 1: Cluster configuration
  // TODO: Create a ClusterState with seed nodes and initial members.
  //   Given a list of seed node addresses and roles for each,
  //   create members with status=Joining. Leader is the first seed node.
  def exercise1_clusterConfig(
    seedNodes: List[(String, Set[String])]
  ): ClusterState = ???

  // Exercise 2: Seed node management
  // TODO: Given a ClusterState and a new node address wanting to join,
  //   add the member with status=Joining and roles from the provided set.
  //   If the node is already in the cluster, return state unchanged.
  def exercise2_seedNodeJoin(
    state: ClusterState,
    address: String,
    roles: Set[String]
  ): ClusterState = ???

  // Exercise 3: Member events processing
  // TODO: Given a ClusterState and a list of MemberEvents, process each:
  //   - MemberJoined: add member with status=Joining (if not exists)
  //   - MemberUp: set status=Up
  //   - MemberLeft: set status=Leaving
  //   - MemberExited: set status=Exiting
  //   - MemberDowned: set status=Down
  //   - MemberRemoved: remove member from the map
  //   - MemberUnreachable: set status=Unreachable
  //   - MemberReachable: set status=Up (back to Up from Unreachable)
  //   Return the final ClusterState.
  def exercise3_memberEvents(state: ClusterState, events: List[MemberEvent]): ClusterState = ???

  // Exercise 4: Cluster Singleton concept
  // TODO: Given a ClusterState, determine which node should host the singleton.
  //   The singleton runs on the oldest Up member (first to join = lowest address lexicographically among Up members).
  //   If a required role is specified, only consider members with that role.
  //   Return the address of the singleton host, or None if no eligible members.
  def exercise4_clusterSingleton(state: ClusterState, requiredRole: Option[String]): Option[String] = ???

  // Exercise 5: Cluster Sharding concept
  // TODO: Given an entity ID and a number of shards, determine the shard ID.
  //   Use: shardId = abs(entityId.hashCode) % numberOfShards
  //   Then, given a mapping of shardId -> nodeAddress, return the node hosting this entity.
  //   Return (shardId, nodeAddress) or (shardId, "unassigned") if shard has no node.
  def exercise5_clusterSharding(
    entityId: String,
    numberOfShards: Int,
    shardAllocation: Map[Int, String]
  ): (Int, String) = ???

  // Exercise 6: Distributed Pub-Sub
  // TODO: Implement pub-sub operations:
  //   Given a Map of topics and operations:
  //   - ("subscribe", topic, subscriber): add subscriber to topic
  //   - ("unsubscribe", topic, subscriber): remove subscriber from topic
  //   - ("publish", topic, _): return the set of subscribers for that topic
  //   Process operations in order and return (final topic map, list of publish results).
  def exercise6_distributedPubSub(
    initialTopics: Map[String, PubSubTopic],
    operations: List[(String, String, String)]
  ): (Map[String, PubSubTopic], List[Set[String]]) = ???

  // Exercise 7: Cluster-aware router
  // TODO: Given a ClusterState and a role filter, select routee nodes.
  //   Only consider members with status=Up and matching the required role.
  //   Given a list of messages, distribute them round-robin across selected nodes.
  //   Return Map[String, List[String]] (nodeAddress -> messages routed to it).
  def exercise7_clusterRouter(
    state: ClusterState,
    role: String,
    messages: List[String]
  ): Map[String, List[String]] = ???

  // Exercise 8: Split Brain Resolver
  // TODO: Given two partitions (each a list of member addresses) and a strategy,
  //   determine which partition survives:
  //   - KeepMajority: partition with more members survives. Tie: both down.
  //   - KeepOldest: partition containing the oldest member (first in the provided sortedMembers list) survives.
  //     If downIfAlone and oldest is alone in its partition, down it instead.
  //   - StaticQuorum: partition with >= quorumSize members survives.
  //   Return (survivingAddresses, downedAddresses).
  def exercise8_splitBrainResolver(
    partition1: List[String],
    partition2: List[String],
    strategy: SplitBrainStrategy,
    sortedMembers: List[String] // oldest first
  ): (List[String], List[String]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_clusterConfig(List(
      ("node-1:2551", Set("frontend")),
      ("node-2:2552", Set("backend")),
      ("node-3:2553", Set("backend"))
    ))
    assert(r1.members.size == 3, s"Exercise 1 failed: ${r1.members.size} members")
    assert(r1.leader.contains("node-1:2551"), s"Exercise 1 failed: leader = ${r1.leader}")
    assert(r1.members("node-1:2551").status == Joining, "Exercise 1 failed: should be Joining")
    println("Exercise 1 passed: cluster config created")

    // Exercise 2
    val r2 = exercise2_seedNodeJoin(r1, "node-4:2554", Set("worker"))
    assert(r2.members.size == 4, s"Exercise 2 failed: ${r2.members.size}")
    val r2b = exercise2_seedNodeJoin(r2, "node-4:2554", Set("worker"))
    assert(r2b.members.size == 4, "Exercise 2 failed: duplicate should not add")
    println("Exercise 2 passed: seed node join")

    // Exercise 3
    val events3 = List(
      MemberUp("node-1:2551"),
      MemberUp("node-2:2552"),
      MemberUp("node-3:2553"),
      MemberUnreachable("node-3:2553"),
      MemberReachable("node-3:2553")
    )
    val r3 = exercise3_memberEvents(r1, events3)
    assert(r3.members("node-1:2551").status == Up, "Exercise 3 failed: node-1 should be Up")
    assert(r3.members("node-3:2553").status == Up, "Exercise 3 failed: node-3 should be Up after reachable")
    println("Exercise 3 passed: member events processed")

    // Exercise 4
    val r4 = exercise4_clusterSingleton(r3, None)
    assert(r4.isDefined, "Exercise 4 failed: should find a singleton host")
    val r4b = exercise4_clusterSingleton(r3, Some("frontend"))
    assert(r4b.contains("node-1:2551"), s"Exercise 4 failed: frontend singleton = $r4b")
    println(s"Exercise 4 passed: singleton on ${r4.get}")

    // Exercise 5
    val alloc = Map(0 -> "node-A", 1 -> "node-B", 2 -> "node-C")
    val (shard5, node5) = exercise5_clusterSharding("entity-42", 3, alloc)
    assert(alloc.contains(shard5), s"Exercise 5 failed: shard $shard5 not in allocation")
    println(s"Exercise 5 passed: entity-42 -> shard $shard5 on $node5")

    // Exercise 6
    val topics0 = Map("news" -> PubSubTopic("news", Set.empty))
    val ops6 = List(
      ("subscribe", "news", "actor-1"),
      ("subscribe", "news", "actor-2"),
      ("publish", "news", ""),
      ("unsubscribe", "news", "actor-1"),
      ("publish", "news", "")
    )
    val (topics6, pubs6) = exercise6_distributedPubSub(topics0, ops6)
    assert(pubs6(0) == Set("actor-1", "actor-2"), s"Exercise 6 failed: first publish = ${pubs6(0)}")
    assert(pubs6(1) == Set("actor-2"), s"Exercise 6 failed: second publish = ${pubs6(1)}")
    println("Exercise 6 passed: distributed pub-sub")

    // Exercise 7
    val r7 = exercise7_clusterRouter(r3, "backend", List("m1", "m2", "m3", "m4", "m5"))
    assert(r7.values.flatten.toList.sorted == List("m1", "m2", "m3", "m4", "m5"),
      s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val (surv8, down8) = exercise8_splitBrainResolver(
      List("A", "B", "C"),
      List("D", "E"),
      KeepMajority(None),
      List("A", "B", "C", "D", "E")
    )
    assert(surv8 == List("A", "B", "C"), s"Exercise 8 failed: surviving = $surv8")
    assert(down8 == List("D", "E"), s"Exercise 8 failed: downed = $down8")
    println("Exercise 8 passed: split brain resolver")

    println("\nAll Akka021_Cluster exercises passed!")
  }
}
