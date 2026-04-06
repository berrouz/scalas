package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Kafka 005 - Exactly-Once Semantics (EOS)
 *
 * Kafka supports exactly-once delivery through:
 *   - Idempotent producer: enable.idempotence=true, deduplicates retries per partition
 *   - Transactional producer: atomic writes across multiple partitions/topics
 *   - Consume-transform-produce: read, process, write atomically
 *   - isolation.level=read_committed: consumers only see committed transactional messages
 *   - Zombie fencing: new producer with same transactional.id fences old one
 */
object Kafka005_ExactlyOnce {

  // --- Domain models ---

  sealed trait IsolationLevel
  object IsolationLevel {
    case object ReadUncommitted extends IsolationLevel
    case object ReadCommitted   extends IsolationLevel
  }

  sealed trait TransactionState
  object TransactionState {
    case object Uninitialized extends TransactionState
    case object Initialized  extends TransactionState
    case object InProgress   extends TransactionState
    case object Committed    extends TransactionState
    case object Aborted      extends TransactionState
  }

  case class IdempotentConfig(
    enableIdempotence: Boolean,
    maxInFlightRequestsPerConnection: Int, // must be <= 5 for idempotence
    retries: Int,                           // should be > 0
    acks: String                            // must be "all"
  )

  case class TransactionalConfig(
    transactionalId: String,
    enableIdempotence: Boolean, // must be true
    transactionTimeoutMs: Int
  )

  case class ProducerRecord[K, V](topic: String, key: Option[K], value: V)

  case class TransactionContext(
    state: TransactionState,
    transactionalId: String,
    producerEpoch: Int,
    records: List[ProducerRecord[String, String]]
  )

  case class ConsumeTransformProduceResult(
    consumed: List[String],
    transformed: List[String],
    produced: List[ProducerRecord[String, String]],
    committed: Boolean
  )

  // Exercise 1: Configure an idempotent producer
  // TODO: Create an IdempotentConfig with:
  //   enableIdempotence = true, maxInFlightRequestsPerConnection = 5,
  //   retries = Int.MaxValue, acks = "all"
  //   These settings ensure per-partition exactly-once without transactions.
  def exercise1_idempotentConfig: IdempotentConfig = ???

  // Exercise 2: Configure a transactional producer
  // TODO: Create a TransactionalConfig with:
  //   transactionalId = "order-processor-tx-0",
  //   enableIdempotence = true (required for transactions),
  //   transactionTimeoutMs = 60000
  def exercise2_transactionalConfig: TransactionalConfig = ???

  // Exercise 3: Model the consume-transform-produce pattern
  // TODO: Given a list of input strings (consumed values), a transform function (String => String),
  //   and an output topic name, produce a ConsumeTransformProduceResult where:
  //   - consumed = inputs
  //   - transformed = inputs.map(transform)
  //   - produced = transformed values as ProducerRecords (key = None, topic = outputTopic)
  //   - committed = true (simulating successful transaction commit)
  def exercise3_consumeTransformProduce(
    inputs: List[String],
    transform: String => String,
    outputTopic: String
  ): ConsumeTransformProduceResult = ???

  // Exercise 4: Validate idempotent config constraints
  // TODO: Given an IdempotentConfig, validate it returns true only if:
  //   - enableIdempotence is true
  //   - maxInFlightRequestsPerConnection <= 5
  //   - retries > 0
  //   - acks == "all"
  def exercise4_validateIdempotentConfig(config: IdempotentConfig): Boolean = ???

  // Exercise 5: Model transaction lifecycle state transitions
  // TODO: Given a current TransactionState and an action string, return the next state.
  //   "init"   + Uninitialized -> Initialized
  //   "begin"  + Initialized   -> InProgress
  //   "begin"  + Committed     -> InProgress  (start new transaction)
  //   "begin"  + Aborted       -> InProgress  (start new transaction)
  //   "commit" + InProgress    -> Committed
  //   "abort"  + InProgress    -> Aborted
  //   Any other combination    -> current state (no-op)
  def exercise5_transactionStateTransition(
    current: TransactionState,
    action: String
  ): TransactionState = ???

  // Exercise 6: Determine correct isolation level
  // TODO: Given a boolean `requireExactlyOnce`, return the isolation level:
  //   true  -> IsolationLevel.ReadCommitted (only see committed transactional messages)
  //   false -> IsolationLevel.ReadUncommitted (see all messages including uncommitted)
  def exercise6_isolationLevel(requireExactlyOnce: Boolean): IsolationLevel = ???

  // Exercise 7: Simulate zombie fencing
  // TODO: Given two TransactionContexts (oldProducer, newProducer) with the same
  //   transactionalId, the new producer fences the old. Return a tuple:
  //   (fencedOld, activeNew) where:
  //   - fencedOld = oldProducer.copy(state = TransactionState.Aborted)
  //   - activeNew = newProducer.copy(producerEpoch = oldProducer.producerEpoch + 1,
  //                                  state = TransactionState.Initialized)
  def exercise7_zombieFencing(
    oldProducer: TransactionContext,
    newProducer: TransactionContext
  ): (TransactionContext, TransactionContext) = ???

  // Exercise 8: Calculate the number of transaction markers in a log
  // TODO: Given a list of TransactionState values representing completed transactions,
  //   count how many Committed and Aborted markers there are.
  //   Return (commitCount, abortCount). Only count Committed and Aborted states.
  def exercise8_transactionMarkers(
    states: List[TransactionState]
  ): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val idemp = exercise1_idempotentConfig
    assert(idemp.enableIdempotence, "Exercise 1 failed")
    assert(idemp.acks == "all", "Exercise 1 failed: acks must be all")
    assert(idemp.maxInFlightRequestsPerConnection <= 5, "Exercise 1 failed: max in-flight > 5")
    println("Exercise 1 passed: idempotent config")

    // Exercise 2
    val txCfg = exercise2_transactionalConfig
    assert(txCfg.transactionalId == "order-processor-tx-0", "Exercise 2 failed")
    assert(txCfg.enableIdempotence, "Exercise 2 failed: idempotence required")
    println("Exercise 2 passed: transactional config")

    // Exercise 3
    val ctp = exercise3_consumeTransformProduce(
      List("hello", "world"), _.toUpperCase, "output-topic"
    )
    assert(ctp.consumed == List("hello", "world"), "Exercise 3 failed: consumed")
    assert(ctp.transformed == List("HELLO", "WORLD"), "Exercise 3 failed: transformed")
    assert(ctp.produced.length == 2, "Exercise 3 failed: produced count")
    assert(ctp.committed, "Exercise 3 failed: not committed")
    println("Exercise 3 passed: consume-transform-produce")

    // Exercise 4
    assert(exercise4_validateIdempotentConfig(idemp), "Exercise 4 failed: valid config rejected")
    assert(!exercise4_validateIdempotentConfig(idemp.copy(acks = "1")), "Exercise 4 failed: invalid acks accepted")
    assert(!exercise4_validateIdempotentConfig(idemp.copy(maxInFlightRequestsPerConnection = 10)), "Exercise 4 failed")
    println("Exercise 4 passed: config validation")

    // Exercise 5
    assert(exercise5_transactionStateTransition(TransactionState.Uninitialized, "init") == TransactionState.Initialized, "Ex 5")
    assert(exercise5_transactionStateTransition(TransactionState.Initialized, "begin") == TransactionState.InProgress, "Ex 5")
    assert(exercise5_transactionStateTransition(TransactionState.InProgress, "commit") == TransactionState.Committed, "Ex 5")
    assert(exercise5_transactionStateTransition(TransactionState.InProgress, "abort") == TransactionState.Aborted, "Ex 5")
    assert(exercise5_transactionStateTransition(TransactionState.Committed, "begin") == TransactionState.InProgress, "Ex 5")
    println("Exercise 5 passed: transaction state transitions")

    // Exercise 6
    assert(exercise6_isolationLevel(true) == IsolationLevel.ReadCommitted, "Exercise 6 failed")
    assert(exercise6_isolationLevel(false) == IsolationLevel.ReadUncommitted, "Exercise 6 failed")
    println("Exercise 6 passed: isolation level selection")

    // Exercise 7
    val oldCtx = TransactionContext(TransactionState.InProgress, "tx-0", 5, Nil)
    val newCtx = TransactionContext(TransactionState.Uninitialized, "tx-0", 0, Nil)
    val (fenced, active) = exercise7_zombieFencing(oldCtx, newCtx)
    assert(fenced.state == TransactionState.Aborted, "Exercise 7 failed: old not fenced")
    assert(active.producerEpoch == 6, "Exercise 7 failed: wrong epoch")
    assert(active.state == TransactionState.Initialized, "Exercise 7 failed: not initialized")
    println("Exercise 7 passed: zombie fencing")

    // Exercise 8
    val states = List(
      TransactionState.Committed, TransactionState.Committed,
      TransactionState.Aborted, TransactionState.InProgress, TransactionState.Committed
    )
    val (commits, aborts) = exercise8_transactionMarkers(states)
    assert(commits == 3, "Exercise 8 failed: wrong commit count")
    assert(aborts == 1, "Exercise 8 failed: wrong abort count")
    println("Exercise 8 passed: transaction markers counted")

    println("\nAll Kafka005_ExactlyOnce exercises passed!")
  }
}
