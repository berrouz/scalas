package org.shev4ik.interview.senior_architect.level4_production_systems

object Arch043_MessageDesign {

  // Exercise 1: Message Schema Design
  case class MessageEnvelope(messageId: String, messageType: String, version: Int, source: String, timestamp: Long, correlationId: String, payload: String, headers: Map[String, String])
  trait MessageSchema { def schemaId: String; def version: Int; def validate(payload: String): Either[List[String], Map[String, Any]] }
  class JsonMessageSchema(val schemaId: String, val version: Int, requiredFields: List[String]) extends MessageSchema {
    def validate(payload: String): Either[List[String], Map[String, Any]] = ???
  }
  def createEnvelope(messageType: String, payload: String, source: String, correlationId: String): MessageEnvelope = ???

  // Exercise 2: Message Versioning
  trait MessageVersioning {
    def canRead(messageVersion: Int): Boolean
    def upgrade(message: MessageEnvelope): Either[String, MessageEnvelope]
    def currentVersion: Int
  }
  class BackwardCompatibleVersioning(supportedVersions: Range) extends MessageVersioning {
    def canRead(messageVersion: Int): Boolean = ???
    def upgrade(message: MessageEnvelope): Either[String, MessageEnvelope] = ???
    def currentVersion: Int = ???
  }

  // Exercise 3: Message Routing
  sealed trait RoutingStrategy; case class TopicBased(topic: String) extends RoutingStrategy
  case class ContentBased(routingKey: String) extends RoutingStrategy; case class HeaderBased(headerKey: String) extends RoutingStrategy
  trait MessageRouter {
    def route(message: MessageEnvelope): Either[String, String]  // returns destination
    def addRoute(pattern: String, destination: String): Either[String, Unit]
    def removeRoute(pattern: String): Either[String, Unit]
  }
  class ContentBasedRouter extends MessageRouter {
    def route(message: MessageEnvelope): Either[String, String] = ???
    def addRoute(pattern: String, destination: String): Either[String, Unit] = ???
    def removeRoute(pattern: String): Either[String, Unit] = ???
  }

  // Exercise 4: Message Ordering
  sealed trait OrderingGuarantee; case object NoOrder extends OrderingGuarantee
  case object PartitionOrder extends OrderingGuarantee; case object TotalOrder extends OrderingGuarantee
  trait OrderedMessageProcessor {
    def process(message: MessageEnvelope): Either[String, Unit]
    def ensureOrdering(guarantee: OrderingGuarantee): Unit
    def outOfOrderCount: Long
  }
  class SequencedProcessor(expectedSequence: String => Long) extends OrderedMessageProcessor {
    def process(message: MessageEnvelope): Either[String, Unit] = ???
    def ensureOrdering(guarantee: OrderingGuarantee): Unit = ???
    def outOfOrderCount: Long = ???
  }

  // Exercise 5: Message Deduplication
  trait MessageDeduplicator {
    def isDuplicate(messageId: String): Boolean
    def markProcessed(messageId: String): Either[String, Unit]
    def cleanup(olderThanMs: Long): Either[String, Int]
  }
  class WindowedDeduplicator(windowMs: Long) extends MessageDeduplicator {
    private val seen = scala.collection.mutable.Map.empty[String, Long]
    def isDuplicate(messageId: String): Boolean = ???
    def markProcessed(messageId: String): Either[String, Unit] = ???
    def cleanup(olderThanMs: Long): Either[String, Int] = ???
  }

  // Exercise 6: Poison Message Handling
  sealed trait PoisonMessageAction; case object SendToDLQ extends PoisonMessageAction
  case object DiscardSilently extends PoisonMessageAction; case class RetryLater(delayMs: Long) extends PoisonMessageAction
  trait PoisonMessageHandler {
    def handle(message: MessageEnvelope, error: String, attemptCount: Int): PoisonMessageAction
    def maxRetries: Int
    def poisonMessageCount: Long
  }
  class DefaultPoisonHandler(maxRetryCount: Int) extends PoisonMessageHandler {
    def handle(message: MessageEnvelope, error: String, attemptCount: Int): PoisonMessageAction = ???
    def maxRetries: Int = maxRetryCount
    def poisonMessageCount: Long = ???
  }

  // Exercise 7: Message Replay
  trait MessageReplayService {
    def replayFromTimestamp(topic: String, timestamp: Long): Either[String, Long]
    def replayRange(topic: String, from: Long, to: Long): Either[String, Long]
    def replayForConsumer(topic: String, consumerId: String, fromOffset: Long): Either[String, Long]
    def dryRunReplay(topic: String, from: Long, to: Long): Either[String, Long]  // count only, no processing
  }
  class KafkaReplayService extends MessageReplayService {
    def replayFromTimestamp(topic: String, timestamp: Long): Either[String, Long] = ???
    def replayRange(topic: String, from: Long, to: Long): Either[String, Long] = ???
    def replayForConsumer(topic: String, consumerId: String, fromOffset: Long): Either[String, Long] = ???
    def dryRunReplay(topic: String, from: Long, to: Long): Either[String, Long] = ???
  }

  // Exercise 8: Message Compression
  sealed trait CompressionCodec; case object NoCompression extends CompressionCodec
  case object Gzip extends CompressionCodec; case object Snappy extends CompressionCodec; case object LZ4 extends CompressionCodec; case object Zstd extends CompressionCodec
  trait MessageCompressor {
    def compress(data: Array[Byte], codec: CompressionCodec): Either[String, Array[Byte]]
    def decompress(data: Array[Byte], codec: CompressionCodec): Either[String, Array[Byte]]
    def selectCodec(dataSize: Int, latencyBudgetMs: Long): CompressionCodec
  }
  class AdaptiveCompressor extends MessageCompressor {
    def compress(data: Array[Byte], codec: CompressionCodec): Either[String, Array[Byte]] = ???
    def decompress(data: Array[Byte], codec: CompressionCodec): Either[String, Array[Byte]] = ???
    def selectCodec(dataSize: Int, latencyBudgetMs: Long): CompressionCodec = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch043: Message Design ===")
    (1 to 8).foreach(i => println(s"Exercise $i"))
  }
}
