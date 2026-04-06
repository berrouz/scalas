package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO118 - Distributed Patterns (Simulated)
 *
 * Learn distributed system patterns simulated with ZIO: counters, locks, leader election, CRDTs.
 */
object Zio118_DistributedPatterns extends App {

  // ============================================================
  // Exercise 1: Distributed counter
  // TODO: Simulate a distributed counter with 3 nodes (3 Refs).
  //       Each node increments its local counter.
  //       Periodically sync (sum all nodes). Print node values and total.
  // ============================================================
  val exercise1: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Distributed lock with ZIO
  // TODO: Simulate a distributed lock using a Ref[Option[String]] (lock holder).
  //       Implement acquire (with retry), release, and isLocked.
  //       Multiple fibers compete for the lock. Print events.
  // ============================================================
  val exercise2: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Leader election concept
  // TODO: Simulate leader election among 3 nodes.
  //       Use a Ref[Option[String]] for the leader.
  //       Nodes compete to become leader. If leader goes down,
  //       re-election occurs. Print election events.
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Consensus concept
  // TODO: Simulate a simple consensus protocol:
  //       3 nodes must agree on a value. Use Refs for proposals.
  //       A value is committed when 2/3 agree (majority).
  //       Print proposal and commit events.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Partition handling
  // TODO: Simulate a network partition:
  //       3 nodes, partition isolates node 3.
  //       Nodes 1 and 2 continue operating (majority).
  //       Node 3 detects it's isolated. Print partition events.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Split brain
  // TODO: Simulate a split brain scenario:
  //       Two groups of nodes can't communicate.
  //       Each group elects its own leader.
  //       On reconnection, resolve the split brain. Print events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: CRDT concept
  // TODO: Implement a G-Counter CRDT (grow-only counter):
  //       Each node has its own counter. Merge = take max per node.
  //       Total = sum of all node counters.
  //       Demonstrate convergence after merge. Print counter states.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Eventual consistency
  // TODO: Simulate eventual consistency:
  //       Write to one node, reads from other nodes see stale data initially.
  //       After sync delay, all nodes have consistent data.
  //       Print read results at different times.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
