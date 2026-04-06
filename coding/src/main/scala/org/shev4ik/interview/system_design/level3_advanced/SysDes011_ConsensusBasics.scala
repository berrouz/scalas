package org.shev4ik.interview.system_design.level3_advanced

object SysDes011_ConsensusBasics {

  // ---- Domain types ----

  case class LogEntry(term: Int, index: Int, command: String)

  sealed trait NodeRole
  case object Follower extends NodeRole
  case object Candidate extends NodeRole
  case object Leader extends NodeRole

  case class RaftNode(
    nodeId: String,
    role: NodeRole = Follower,
    currentTerm: Int = 0,
    votedFor: Option[String] = None,
    log: List[LogEntry] = Nil,
    commitIndex: Int = -1,
    lastApplied: Int = -1
  )

  sealed trait VoteResult
  case object VoteGranted extends VoteResult
  case object VoteDenied extends VoteResult

  // ---- Exercise 1 ----
  // TODO: Implement leader election.
  // A node starts an election by incrementing its term, voting for itself, and
  // requesting votes from other nodes.
  // `startElection(node)`: transition to Candidate, increment term, vote for self.
  // `requestVote(voter, candidateId, candidateTerm, candidateLastLogIndex, candidateLastLogTerm)`:
  //   - Grant vote if candidateTerm >= voter's term AND voter hasn't voted this term
  //     AND candidate's log is at least as up-to-date.
  //   - Return (updatedVoter, VoteResult)
  // `becomeLeader(node)`: transition to Leader.
  def startElection(node: RaftNode): RaftNode = ???

  def requestVote(
    voter: RaftNode,
    candidateId: String,
    candidateTerm: Int,
    candidateLastLogIndex: Int,
    candidateLastLogTerm: Int
  ): (RaftNode, VoteResult) = ???

  def becomeLeader(node: RaftNode): RaftNode = ???

  // ---- Exercise 2 ----
  // TODO: Implement Raft log replication concept.
  // The leader appends a new entry to its log and sends it to followers.
  // `appendToLeaderLog(leader, command)`: add a LogEntry with leader's current term.
  // `replicateEntry(follower, entry, leaderTerm)`:
  //   - If leaderTerm >= follower's term, append entry and update term. Return (updated, true)
  //   - Otherwise reject. Return (follower, false)
  def appendToLeaderLog(leader: RaftNode, command: String): RaftNode = ???

  def replicateEntry(
    follower: RaftNode,
    entry: LogEntry,
    leaderTerm: Int
  ): (RaftNode, Boolean) = ???

  // ---- Exercise 3 ----
  // TODO: Implement term and vote tracking.
  // `updateTerm(node, newTerm)`: if newTerm > currentTerm, update term, revert to Follower,
  //   clear votedFor. Return updated node.
  // `hasVoted(node)`: check if node has voted in current term.
  // `castVote(node, candidateId)`: set votedFor. Only works if not already voted.
  //   Return (updatedNode, success)
  def updateTerm(node: RaftNode, newTerm: Int): RaftNode = ???

  def hasVoted(node: RaftNode): Boolean = ???

  def castVote(node: RaftNode, candidateId: String): (RaftNode, Boolean) = ???

  // ---- Exercise 4 ----
  // TODO: Implement append entries (heartbeat / log replication).
  // `appendEntries(follower, leaderTerm, prevLogIndex, prevLogTerm, entries)`:
  //   - If leaderTerm < follower's term, reject.
  //   - If prevLogIndex >= 0 and follower's log doesn't match at prevLogIndex/prevLogTerm, reject.
  //   - Otherwise, append entries (overwriting conflicts) and return success.
  //   - Update follower's term if needed.
  // Return (updatedFollower, success)
  def appendEntries(
    follower: RaftNode,
    leaderTerm: Int,
    prevLogIndex: Int,
    prevLogTerm: Int,
    entries: List[LogEntry]
  ): (RaftNode, Boolean) = ???

  // ---- Exercise 5 ----
  // TODO: Implement commit index advancement.
  // The leader advances commitIndex when a majority of nodes have replicated an entry.
  // `advanceCommitIndex(leader, matchIndices, clusterSize)`:
  //   - Find the highest index N such that a majority of matchIndices >= N
  //     and log[N].term == currentTerm.
  //   - Update leader's commitIndex to N.
  // matchIndices: Map[nodeId, highestReplicatedIndex]
  def advanceCommitIndex(
    leader: RaftNode,
    matchIndices: Map[String, Int],
    clusterSize: Int
  ): RaftNode = ???

  // ---- Exercise 6 ----
  // TODO: Implement log matching property check.
  // Two logs are consistent if for every index where both have entries,
  // the terms match. Check if follower's log is consistent with leader's log.
  // Return the index of the first mismatch, or -1 if fully consistent.
  def findLogMismatch(leaderLog: List[LogEntry], followerLog: List[LogEntry]): Int = ???

  // ---- Exercise 7 ----
  // TODO: Implement a simplified Paxos concept.
  // Phase 1 (Prepare): Proposer sends proposal number N.
  //   Acceptor promises not to accept proposals < N if N > highest seen.
  //   Return (updatedAcceptor, promised: Boolean, previouslyAccepted: Option[(Int, String)])
  // Phase 2 (Accept): Proposer sends (N, value).
  //   Acceptor accepts if N >= its promised number.
  //   Return (updatedAcceptor, accepted: Boolean)
  case class PaxosAcceptor(
    promisedNum: Int = 0,
    acceptedNum: Int = 0,
    acceptedValue: Option[String] = None
  )

  def prepare(acceptor: PaxosAcceptor, proposalNum: Int): (PaxosAcceptor, Boolean, Option[(Int, String)]) = ???

  def accept(acceptor: PaxosAcceptor, proposalNum: Int, value: String): (PaxosAcceptor, Boolean) = ???

  // ---- Exercise 8 ----
  // TODO: Implement two-phase commit (2PC).
  // Coordinator sends Prepare to all participants.
  // If all vote Yes, coordinator sends Commit. Otherwise sends Abort.
  // `twoPhaseCommit(participantVotes)`:
  //   - participantVotes: List[(participantId, vote: Boolean)]
  //   - If all votes are true, return ("commit", List of participants)
  //   - If any vote is false, return ("abort", List of participants that voted no)
  def twoPhaseCommit(
    participantVotes: List[(String, Boolean)]
  ): (String, List[String]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Leader Election
    val n1 = RaftNode("n1", Follower, currentTerm = 1)
    val n1c = startElection(n1)
    assert(n1c.role == Candidate)
    assert(n1c.currentTerm == 2)
    assert(n1c.votedFor.contains("n1"))

    val n2 = RaftNode("n2", Follower, currentTerm = 1)
    val (n2v, vote) = requestVote(n2, "n1", 2, -1, 0)
    assert(vote == VoteGranted)
    assert(n2v.votedFor.contains("n1"))

    val leader = becomeLeader(n1c)
    assert(leader.role == Leader)
    println("Exercise 1 passed: Leader Election")

    // Exercise 2: Log Replication
    val l1 = RaftNode("l1", Leader, currentTerm = 2)
    val l1a = appendToLeaderLog(l1, "SET x=1")
    assert(l1a.log.length == 1)
    assert(l1a.log.head.term == 2)

    val f1 = RaftNode("f1", Follower, currentTerm = 1)
    val (f1r, success) = replicateEntry(f1, l1a.log.head, 2)
    assert(success)
    assert(f1r.log.length == 1)
    assert(f1r.currentTerm == 2)
    println("Exercise 2 passed: Log Replication")

    // Exercise 3: Term and Vote
    val n3 = RaftNode("n3", Leader, currentTerm = 3, votedFor = Some("n3"))
    val n3u = updateTerm(n3, 5)
    assert(n3u.currentTerm == 5)
    assert(n3u.role == Follower)
    assert(n3u.votedFor.isEmpty)
    assert(!hasVoted(n3u))
    val (n3v, vs) = castVote(n3u, "n2")
    assert(vs && n3v.votedFor.contains("n2"))
    val (_, vs2) = castVote(n3v, "n1")
    assert(!vs2) // already voted
    println("Exercise 3 passed: Term and Vote")

    // Exercise 4: Append Entries
    val fol = RaftNode("f1", Follower, currentTerm = 1, log = List(LogEntry(1, 0, "cmd1")))
    val newEntries = List(LogEntry(2, 1, "cmd2"))
    val (folU, aeSuccess) = appendEntries(fol, 2, 0, 1, newEntries)
    assert(aeSuccess)
    assert(folU.log.length == 2)
    val (_, aeFail) = appendEntries(fol, 0, 0, 1, newEntries) // stale term
    assert(!aeFail)
    println("Exercise 4 passed: Append Entries")

    // Exercise 5: Commit Index
    val ldr = RaftNode("l1", Leader, currentTerm = 2, log = List(
      LogEntry(1, 0, "a"), LogEntry(2, 1, "b"), LogEntry(2, 2, "c")
    ), commitIndex = 0)
    val matchIdx = Map("f1" -> 2, "f2" -> 2, "f3" -> 1) // majority have index 2
    val ldrU = advanceCommitIndex(ldr, matchIdx, 4) // 4 nodes including leader
    assert(ldrU.commitIndex >= 1) // at least index 1 committed
    println("Exercise 5 passed: Commit Index")

    // Exercise 6: Log Matching
    val leaderLog = List(LogEntry(1, 0, "a"), LogEntry(1, 1, "b"), LogEntry(2, 2, "c"))
    val followerLog = List(LogEntry(1, 0, "a"), LogEntry(1, 1, "b"), LogEntry(3, 2, "d"))
    assert(findLogMismatch(leaderLog, followerLog) == 2) // mismatch at index 2
    val followerLog2 = List(LogEntry(1, 0, "a"), LogEntry(1, 1, "b"))
    assert(findLogMismatch(leaderLog, followerLog2) == -1) // consistent (subset)
    println("Exercise 6 passed: Log Matching")

    // Exercise 7: Paxos
    val acc0 = PaxosAcceptor()
    val (acc1, p1, prev1) = prepare(acc0, 1)
    assert(p1)
    assert(prev1.isEmpty)
    val (acc2, accepted) = accept(acc1, 1, "valueA")
    assert(accepted)
    val (acc3, p2, prev2) = prepare(acc2, 2)
    assert(p2)
    assert(prev2.contains((1, "valueA"))) // previously accepted
    val (_, p3, _) = prepare(acc3, 1) // lower proposal
    assert(!p3)
    println("Exercise 7 passed: Paxos")

    // Exercise 8: Two-Phase Commit
    val (decision1, _) = twoPhaseCommit(List(("p1", true), ("p2", true), ("p3", true)))
    assert(decision1 == "commit")
    val (decision2, noVoters) = twoPhaseCommit(List(("p1", true), ("p2", false), ("p3", true)))
    assert(decision2 == "abort")
    assert(noVoters.contains("p2"))
    println("Exercise 8 passed: Two-Phase Commit")

    println("All SysDes011_ConsensusBasics exercises passed!")
  }
}
