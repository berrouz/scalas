package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._
import zio.stream._

/**
 * ZIO122 - ZIO Kafka Patterns (Simulated)
 *
 * Learn Kafka consumer/producer patterns simulated with ZIO Queues and Streams.
 */
object Zio122_ZIOKafka extends App {

  // Simulated Kafka types
  case class ConsumerRecord(topic: String, partition: Int, offset: Long, key: String, value: String)
  case class ProducerRecord(topic: String, key: String, value: String)

  // ============================================================
  // Exercise 1: Consumer settings (simulated)
  // TODO: Define consumer settings as a case class:
  //       groupId, topics, autoOffsetReset, maxPollRecords.
  //       Create a ZLayer that provides ConsumerSettings. Print the config.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Producer settings (simulated)
  // TODO: Define producer settings as a case class:
  //       bootstrapServers, acks, retries, batchSize.
  //       Create a ZLayer that provides ProducerSettings. Print the config.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Consumer stream (simulated)
  // TODO: Simulate a Kafka consumer stream using ZStream.fromQueue.
  //       Create a Queue[ConsumerRecord]. Feed it with test records.
  //       Process the stream (print each record).
  // ============================================================
  val exercise3: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Producer effect (simulated)
  // TODO: Simulate a Kafka producer using a Queue[ProducerRecord].
  //       Implement produce(record: ProducerRecord): Task[Unit].
  //       Produce several records. Print them from the queue.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Offset commit (simulated)
  // TODO: Simulate offset management with Ref[Map[String, Long]].
  //       Track last committed offset per partition.
  //       Process records and commit offsets periodically. Print commits.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Error handling
  // TODO: Implement error handling for Kafka consumption:
  //       - Deserialization errors -> dead letter queue
  //       - Processing errors -> retry then DLQ
  //       - Fatal errors -> stop consumer
  //       Simulate each case. Print error handling events.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Partition assignment (simulated)
  // TODO: Simulate partition assignment for 2 consumers, 4 partitions.
  //       Each consumer gets 2 partitions. On rebalance, reassign.
  //       Print partition assignment events.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Consumer group (simulated)
  // TODO: Simulate a consumer group with 3 consumers processing from
  //       the same topic. Each record is processed by exactly one consumer.
  //       Use distributedWith or round-robin Queue. Print processing events.
  // ============================================================
  val exercise8: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
