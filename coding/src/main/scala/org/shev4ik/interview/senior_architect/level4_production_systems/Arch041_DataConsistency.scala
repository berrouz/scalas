package org.shev4ik.interview.senior_architect.level4_production_systems

object Arch041_DataConsistency {

  // Exercise 1: Saga Pattern Implementation
  sealed trait SagaStepResult; case object StepSuccess extends SagaStepResult; case class StepFailure(error: String) extends SagaStepResult
  case class SagaStep(name: String, execute: () => Either[String, Unit], compensate: () => Either[String, Unit])
  sealed trait SagaResult; case object SagaCompleted extends SagaResult
  case class SagaCompensated(failedStep: String, error: String) extends SagaResult; case class SagaFailed(step: String, error: String) extends SagaResult
  trait SagaOrchestrator {
    def execute(steps: List[SagaStep]): Either[String, SagaResult]
  }
  class OrderSagaOrchestrator extends SagaOrchestrator {
    def execute(steps: List[SagaStep]): Either[String, SagaResult] = ???
    // Step 1: Reserve inventory -> compensate: release inventory
    // Step 2: Process payment -> compensate: refund payment
    // Step 3: Create shipment -> compensate: cancel shipment
    // Step 4: Send notification (no compensation needed)
  }
  def orderSagaSteps(): List[SagaStep] = ???

  // Exercise 2: Compensation Logic
  trait CompensatingAction { def compensate(): Either[String, Unit]; def isReversible: Boolean; def timeout: Long }
  trait CompensationLog {
    def record(sagaId: String, step: String, action: String): Either[String, Unit]
    def getLog(sagaId: String): Either[String, List[(String, String, Long)]]
    def markCompensated(sagaId: String, step: String): Either[String, Unit]
  }
  class InMemoryCompensationLog extends CompensationLog {
    def record(sagaId: String, step: String, action: String): Either[String, Unit] = ???
    def getLog(sagaId: String): Either[String, List[(String, String, Long)]] = ???
    def markCompensated(sagaId: String, step: String): Either[String, Unit] = ???
  }

  // Exercise 3: Idempotency Design
  case class IdempotencyKey(key: String, createdAt: Long, expiresAt: Long)
  trait IdempotencyStore {
    def check(key: String): Either[String, Option[String]]  // returns cached result if exists
    def store(key: String, result: String, ttlMs: Long): Either[String, Unit]
    def delete(key: String): Either[String, Unit]
  }
  def makeIdempotent[A](key: String, store: IdempotencyStore)(action: => Either[String, A])(serialize: A => String)(deserialize: String => A): Either[String, A] = ???

  // Exercise 4: Deduplication
  trait DeduplicationService {
    def isDuplicate(messageId: String): Either[String, Boolean]
    def markProcessed(messageId: String): Either[String, Unit]
    def cleanup(olderThanMs: Long): Either[String, Int]
  }
  class BloomFilterDeduplication(expectedSize: Int, falsePositiveRate: Double) extends DeduplicationService {
    def isDuplicate(messageId: String): Either[String, Boolean] = ???
    def markProcessed(messageId: String): Either[String, Unit] = ???
    def cleanup(olderThanMs: Long): Either[String, Int] = ???
  }

  // Exercise 5: Exactly-Once Processing
  trait ExactlyOnceProcessor[A, B] {
    def process(input: A, messageId: String): Either[String, B]
    def isProcessed(messageId: String): Boolean
  }
  class TransactionalProcessor[A, B](processor: A => Either[String, B], idempotencyStore: IdempotencyStore) extends ExactlyOnceProcessor[A, B] {
    def process(input: A, messageId: String): Either[String, B] = ???
    def isProcessed(messageId: String): Boolean = ???
  }

  // Exercise 6: Outbox Pattern
  case class OutboxEntry(id: String, aggregateType: String, aggregateId: String, eventType: String, payload: String, createdAt: Long, publishedAt: Option[Long])
  trait OutboxStore {
    def save(entry: OutboxEntry): Either[String, Unit]
    def getUnpublished(limit: Int): Either[String, List[OutboxEntry]]
    def markPublished(id: String): Either[String, Unit]
    def cleanup(olderThanMs: Long): Either[String, Int]
  }
  // TODO: Implement outbox pattern: save event in same transaction as data, publish async
  class OutboxPublisher(store: OutboxStore, publisher: String => Either[String, Unit]) {
    def publishPending(): Either[String, Int] = ???
    def startPolling(intervalMs: Long): Either[String, Unit] = ???
  }

  // Exercise 7: Change Data Capture
  sealed trait CDCEvent; case class Insert(table: String, data: Map[String, Any]) extends CDCEvent
  case class Update(table: String, before: Map[String, Any], after: Map[String, Any]) extends CDCEvent
  case class Delete(table: String, data: Map[String, Any]) extends CDCEvent
  trait CDCConnector {
    def subscribe(tables: List[String], handler: CDCEvent => Either[String, Unit]): Either[String, Unit]
    def currentPosition(): Either[String, String]
    def seekTo(position: String): Either[String, Unit]
  }
  class DebeziumStyleCDC extends CDCConnector {
    def subscribe(tables: List[String], handler: CDCEvent => Either[String, Unit]): Either[String, Unit] = ???
    def currentPosition(): Either[String, String] = ???
    def seekTo(position: String): Either[String, Unit] = ???
  }

  // Exercise 8: Two-Phase Commit Concept
  sealed trait TwoPhaseResult; case object Committed extends TwoPhaseResult; case object Aborted extends TwoPhaseResult
  trait TwoPhaseCoordinator {
    def prepare(participants: List[String]): Either[String, Boolean]  // all vote yes?
    def commit(): Either[String, TwoPhaseResult]
    def abort(): Either[String, TwoPhaseResult]
  }
  class SimpleTwoPhaseCoordinator extends TwoPhaseCoordinator {
    def prepare(participants: List[String]): Either[String, Boolean] = ???
    def commit(): Either[String, TwoPhaseResult] = ???
    def abort(): Either[String, TwoPhaseResult] = ???
  }
  // Note: 2PC is generally avoided in microservices due to blocking nature. Prefer saga pattern.

  def main(args: Array[String]): Unit = {
    println("=== Arch041: Data Consistency ===")
    (1 to 8).foreach(i => println(s"Exercise $i"))
  }
}
