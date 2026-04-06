package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Data Pipeline Architecture
 *
 * Senior/Architect focus:
 * - ETL/ELT pipeline design for batch and streaming
 * - Data quality, idempotency, and exactly-once semantics
 */
object Arch023_DataPipeline {

  // Exercise 1: ETL Pipeline Design
  trait Extractor[A] { def extract(): Either[String, Iterator[A]] }
  trait Transformer[A, B] { def transform(record: A): Either[String, B] }
  trait Loader[A] { def load(records: List[A]): Either[String, Long] }
  case class ETLResult(extracted: Long, transformed: Long, loaded: Long, errors: Long, durationMs: Long)
  class ETLPipeline[A, B](extractor: Extractor[A], transformer: Transformer[A, B], loader: Loader[B], batchSize: Int) {
    def run(): Either[String, ETLResult] = ???
  }

  // Exercise 2: Streaming Pipeline
  sealed trait StreamRecord[+A]
  case class DataRecord[A](key: String, value: A, timestamp: Long, partition: Int) extends StreamRecord[A]
  case class Watermark(timestamp: Long) extends StreamRecord[Nothing]
  trait StreamProcessor[A, B] {
    def process(record: StreamRecord[A]): Either[String, List[StreamRecord[B]]]
    def onWatermark(watermark: Long): Either[String, List[StreamRecord[B]]]
  }
  class FilterMapProcessor[A, B](filter: A => Boolean, mapper: A => B) extends StreamProcessor[A, B] {
    def process(record: StreamRecord[A]): Either[String, List[StreamRecord[B]]] = ???
    def onWatermark(watermark: Long): Either[String, List[StreamRecord[B]]] = ???
  }

  // Exercise 3: Batch vs Stream Tradeoffs
  sealed trait ProcessingMode
  case class BatchMode(scheduleInterval: Long, windowSize: Long) extends ProcessingMode
  case class StreamMode(latencyTarget: Long, checkpointInterval: Long) extends ProcessingMode
  case class LambdaMode(batchLayer: BatchMode, speedLayer: StreamMode) extends ProcessingMode
  def chooseProcessingMode(latencyRequirement: Long, dataVolume: Long, complexity: String): ProcessingMode = ???

  // Exercise 4: Data Validation Stage
  sealed trait ValidationResult[+A]
  case class Valid[A](record: A) extends ValidationResult[A]
  case class Invalid[A](record: A, errors: List[String]) extends ValidationResult[A]
  trait DataValidator[A] {
    def validate(record: A): ValidationResult[A]
    def rules: List[String]
  }
  class SchemaValidator extends DataValidator[Map[String, Any]] {
    def validate(record: Map[String, Any]): ValidationResult[Map[String, Any]] = ???
    def rules: List[String] = ???
  }

  // Exercise 5: Transformation Stage
  trait DataTransformation[A, B] {
    def transform(input: A): Either[String, B]
    def compose[C](next: DataTransformation[B, C]): DataTransformation[A, C] = ???
  }
  class FieldMappingTransformation(mappings: Map[String, String]) extends DataTransformation[Map[String, Any], Map[String, Any]] {
    def transform(input: Map[String, Any]): Either[String, Map[String, Any]] = ???
  }

  // Exercise 6: Data Quality
  case class DataQualityMetrics(totalRecords: Long, validRecords: Long, invalidRecords: Long, duplicateRecords: Long, nullFields: Map[String, Long], completenessScore: Double, accuracyScore: Double)
  trait DataQualityChecker[A] {
    def check(records: List[A]): Either[String, DataQualityMetrics]
    def setThresholds(thresholds: Map[String, Double]): Unit
    def passesQualityGate(metrics: DataQualityMetrics): Boolean
  }
  class DefaultDataQualityChecker extends DataQualityChecker[Map[String, Any]] {
    def check(records: List[Map[String, Any]]): Either[String, DataQualityMetrics] = ???
    def setThresholds(thresholds: Map[String, Double]): Unit = ???
    def passesQualityGate(metrics: DataQualityMetrics): Boolean = ???
  }

  // Exercise 7: Idempotent Processing
  trait IdempotencyKey { def key: String }
  trait IdempotentProcessor[A, B] {
    def process(record: A, key: IdempotencyKey): Either[String, Option[B]]
    def isProcessed(key: IdempotencyKey): Boolean
    def markProcessed(key: IdempotencyKey): Either[String, Unit]
  }
  class DeduplicatingProcessor[A, B](underlying: A => Either[String, B]) extends IdempotentProcessor[A, B] {
    private val processed = scala.collection.mutable.Set.empty[String]
    def process(record: A, key: IdempotencyKey): Either[String, Option[B]] = ???
    def isProcessed(key: IdempotencyKey): Boolean = ???
    def markProcessed(key: IdempotencyKey): Either[String, Unit] = ???
  }

  // Exercise 8: Exactly-Once Semantics
  sealed trait DeliverySemantics
  case object AtMostOnce extends DeliverySemantics
  case object AtLeastOnce extends DeliverySemantics
  case object ExactlyOnce extends DeliverySemantics
  trait TransactionalProcessor[A, B] {
    def processWithTransaction(record: A): Either[String, B]
    def beginTransaction(): Either[String, String]
    def commitTransaction(txId: String): Either[String, Unit]
    def rollbackTransaction(txId: String): Either[String, Unit]
  }
  class ExactlyOnceProcessor[A, B](processor: A => Either[String, B], idempotencyStore: IdempotentProcessor[A, B]) extends TransactionalProcessor[A, B] {
    def processWithTransaction(record: A): Either[String, B] = ???
    def beginTransaction(): Either[String, String] = ???
    def commitTransaction(txId: String): Either[String, Unit] = ???
    def rollbackTransaction(txId: String): Either[String, Unit] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch023: Data Pipeline ===")
    println()
    println("Exercise 1: ETL Pipeline Design")
    println("Exercise 2: Streaming Pipeline")
    println("Exercise 3: Batch vs Stream")
    println("Exercise 4: Data Validation Stage")
    println("Exercise 5: Transformation Stage")
    println("Exercise 6: Data Quality")
    println("Exercise 7: Idempotent Processing")
    println("Exercise 8: Exactly-Once Semantics")
  }
}
