package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Distributed Systems Concepts
 *
 * Senior/Architect focus:
 * - CAP theorem, consistency models, partition tolerance
 * - Leader election, consensus, distributed locks
 * - CRDTs and vector clocks
 */
object Arch025_DistributedSystem {

  // Exercise 1: CAP Theorem Tradeoffs
  sealed trait CAPChoice
  case object CP extends CAPChoice  // Consistency + Partition tolerance (sacrifice Availability)
  case object AP extends CAPChoice  // Availability + Partition tolerance (sacrifice Consistency)
  case object CA extends CAPChoice  // Consistency + Availability (sacrifice Partition tolerance - not viable in distributed)
  case class SystemDesignChoice(name: String, capChoice: CAPChoice, justification: String, examples: List[String])
  val bankingSystem: SystemDesignChoice = ???
  val socialMediaFeed: SystemDesignChoice = ???
  val shoppingCart: SystemDesignChoice = ???
  def recommendCAPChoice(requirements: Map[String, String]): CAPChoice = ???

  // Exercise 2: Consistency Models
  sealed trait ConsistencyModel
  case object StrongConsistency extends ConsistencyModel
  case object EventualConsistency extends ConsistencyModel
  case object CausalConsistency extends ConsistencyModel
  case object ReadYourWritesConsistency extends ConsistencyModel
  case object SessionConsistency extends ConsistencyModel
  trait DistributedStore[K, V] {
    def write(key: K, value: V, consistency: ConsistencyModel): Either[String, Unit]
    def read(key: K, consistency: ConsistencyModel): Either[String, Option[V]]
  }
  class SimulatedDistributedStore[K, V](replicaCount: Int) extends DistributedStore[K, V] {
    def write(key: K, value: V, consistency: ConsistencyModel): Either[String, Unit] = ???
    def read(key: K, consistency: ConsistencyModel): Either[String, Option[V]] = ???
  }

  // Exercise 3: Partition Tolerance
  sealed trait PartitionBehavior
  case class RejectWrites(reason: String) extends PartitionBehavior
  case class AcceptWritesWithConflict(conflictResolution: String) extends PartitionBehavior
  case class QueueWrites(maxQueueSize: Int) extends PartitionBehavior
  trait PartitionHandler {
    def onPartitionDetected(affectedNodes: List[String]): PartitionBehavior
    def onPartitionHealed(affectedNodes: List[String]): Either[String, Unit]
    def isPartitioned: Boolean
  }
  class DefaultPartitionHandler(strategy: PartitionBehavior) extends PartitionHandler {
    def onPartitionDetected(affectedNodes: List[String]): PartitionBehavior = ???
    def onPartitionHealed(affectedNodes: List[String]): Either[String, Unit] = ???
    def isPartitioned: Boolean = ???
  }

  // Exercise 4: Leader Election Concept
  case class Node(id: String, address: String, priority: Int, isAlive: Boolean)
  sealed trait ElectionResult
  case class LeaderElected(leaderId: String, term: Long) extends ElectionResult
  case class ElectionFailed(reason: String) extends ElectionResult
  trait LeaderElection {
    def startElection(): Either[String, ElectionResult]
    def currentLeader: Option[Node]
    def isLeader(nodeId: String): Boolean
    def onLeaderFailure(): Either[String, ElectionResult]
  }
  class BullyElection(nodes: List[Node], selfId: String) extends LeaderElection {
    def startElection(): Either[String, ElectionResult] = ???
    def currentLeader: Option[Node] = ???
    def isLeader(nodeId: String): Boolean = ???
    def onLeaderFailure(): Either[String, ElectionResult] = ???
  }

  // Exercise 5: Consensus Concept
  case class Proposal(proposalId: Long, value: String, proposer: String)
  sealed trait ConsensusPhase
  case object Prepare extends ConsensusPhase
  case object Promise extends ConsensusPhase
  case object Accept extends ConsensusPhase
  case object Accepted extends ConsensusPhase
  trait ConsensusProtocol {
    def propose(value: String): Either[String, String]
    def getAgreedValue(): Either[String, Option[String]]
    def quorumSize: Int
  }
  class SimplifiedPaxos(nodes: List[String], selfId: String) extends ConsensusProtocol {
    def propose(value: String): Either[String, String] = ???
    def getAgreedValue(): Either[String, Option[String]] = ???
    def quorumSize: Int = ???
  }

  // Exercise 6: Distributed Lock
  case class LockInfo(lockId: String, owner: String, acquiredAt: Long, expiresAt: Long, fencingToken: Long)
  trait DistributedLock {
    def acquire(lockId: String, owner: String, ttlMs: Long): Either[String, LockInfo]
    def release(lockId: String, owner: String, fencingToken: Long): Either[String, Unit]
    def extend(lockId: String, owner: String, additionalTtlMs: Long): Either[String, LockInfo]
    def isLocked(lockId: String): Either[String, Boolean]
  }
  class RedlockAlgorithm(instances: List[String]) extends DistributedLock {
    def acquire(lockId: String, owner: String, ttlMs: Long): Either[String, LockInfo] = ???
    def release(lockId: String, owner: String, fencingToken: Long): Either[String, Unit] = ???
    def extend(lockId: String, owner: String, additionalTtlMs: Long): Either[String, LockInfo] = ???
    def isLocked(lockId: String): Either[String, Boolean] = ???
  }

  // Exercise 7: Vector Clock Concept
  case class VectorClock(clocks: Map[String, Long]) {
    def increment(nodeId: String): VectorClock = ???
    def merge(other: VectorClock): VectorClock = ???
    def happensBefore(other: VectorClock): Boolean = ???
    def happensAfter(other: VectorClock): Boolean = ???
    def concurrent(other: VectorClock): Boolean = ???
  }
  object VectorClock {
    def empty: VectorClock = VectorClock(Map.empty)
    def forNode(nodeId: String): VectorClock = ???
  }
  // TODO: Implement ordering using vector clocks
  case class VersionedValue[A](value: A, clock: VectorClock)
  def resolveConflict[A](v1: VersionedValue[A], v2: VersionedValue[A])(merge: (A, A) => A): VersionedValue[A] = ???

  // Exercise 8: CRDT Concept
  // Conflict-free Replicated Data Types
  trait CRDT[A] {
    def value: A
    def merge(other: CRDT[A]): CRDT[A]
  }
  // G-Counter: grow-only counter
  case class GCounter(counts: Map[String, Long]) extends CRDT[Long] {
    def value: Long = ???
    def merge(other: CRDT[Long]): CRDT[Long] = ???
    def increment(nodeId: String): GCounter = ???
  }
  // PN-Counter: increment and decrement
  case class PNCounter(positive: GCounter, negative: GCounter) extends CRDT[Long] {
    def value: Long = ???
    def merge(other: CRDT[Long]): CRDT[Long] = ???
    def increment(nodeId: String): PNCounter = ???
    def decrement(nodeId: String): PNCounter = ???
  }
  // LWW-Register: last-writer-wins
  case class LWWRegister[A](value: A, timestamp: Long, nodeId: String) extends CRDT[A] {
    def merge(other: CRDT[A]): CRDT[A] = ???
    def set(newValue: A, ts: Long, node: String): LWWRegister[A] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch025: Distributed Systems ===")
    println()
    println("Exercise 1: CAP Theorem Tradeoffs")
    println("Exercise 2: Consistency Models")
    println("Exercise 3: Partition Tolerance")
    println("Exercise 4: Leader Election Concept")
    println("Exercise 5: Consensus Concept")
    println("Exercise 6: Distributed Lock")
    println("Exercise 7: Vector Clock Concept")
    println("Exercise 8: CRDT Concept")
  }
}
