package org.shev4ik.kafka

import org.apache.kafka.clients.producer.ProducerRecord
import zio._
import zio.blocking.Blocking
import zio.clock.Clock
import zio.console._
import zio.duration._
import zio.kafka.consumer.{Consumer, ConsumerSettings, Subscription}
import zio.kafka.producer.{Producer, ProducerSettings}
import zio.kafka.serde.Serde
import zio.stream.ZStream

import java.util.Date

object KafkaProducer extends zio.App {

  private val BOOSTRAP_SERVERS = List("localhost:9092")
  private val KAFKA_TOPIC      = "streaming-hello"

  private val producerLayer: ZLayer[Blocking, Throwable, Has[Producer]] =
    ZLayer.fromManaged(
      Producer.make(
        ProducerSettings(BOOSTRAP_SERVERS)
      )
    )

  def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = {
    val p: ZStream[Clock with Has[Producer], Throwable, Nothing] =
      ZStream
        .repeatEffect(zio.clock.currentDateTime)
        .schedule(Schedule.spaced(1.second))
        .map(time => {
          val record = new ProducerRecord(
            KAFKA_TOPIC,
            time.getMinute % 3,
            time.getMinute,
            s"Message ${new Date().toInstant}"
          )
          record
        })
        .mapM(record => Producer.produce[Any, Int, String](record, Serde.int, Serde.string))
        .drain

    val c1: ZStream[Has[Consumer] with Console, Throwable, Nothing] =
      Consumer
        .subscribeAnd(Subscription.manual(KAFKA_TOPIC -> 1))
        .plainStream(Serde.int, Serde.string)
        .tap(record =>
          putStrLn(s"Consumer 1 ${record.value} partition ${record.partition}")
        )
        .map(_.offset)
        .mapM(_.commit)
        .drain

    val c2: ZStream[Has[Consumer] with Console, Throwable, Nothing] =
      Consumer
        .subscribeAnd(Subscription.manual(KAFKA_TOPIC -> 2, KAFKA_TOPIC -> 0))
        .plainStream(Serde.int, Serde.string)
        .tap(record =>
          putStrLn(s"Consumer 2 ${record.value} partition ${record.partition}")
        )
        .map(_.offset)
        .mapM(_.commit)
        .drain

    val consumerLayer1: ZLayer[Clock with Blocking, Throwable, Has[Consumer]] =
      ZLayer.fromManaged(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId("group1")))

    val consumerLayer2: ZLayer[Clock with Blocking, Throwable, Has[Consumer]] =
      ZLayer.fromManaged(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId("group2")))

    val stream1 = c1.provideSomeLayer[Console with Clock with Blocking](consumerLayer1)
    val stream2 = c2.provideSomeLayer[Console with Clock with Blocking](consumerLayer2)

    val program = (stream1 merge stream2).runDrain

    program.provideSomeLayer[ZEnv](producerLayer).exitCode
  }
}
