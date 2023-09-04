package org.shev4ik.kafka

import cats.implicits.catsStdShowForString
import org.apache.kafka.clients.producer.ProducerRecord
import zio.Config.LocalDateTime
import zio._
import zio.interop.console.cats.putStr
import zio.kafka.consumer.{Consumer, ConsumerSettings, Subscription}
import zio.kafka.producer.{Producer, ProducerSettings}
import zio.kafka.serde.Serde
import zio.stream.ZStream

import java.time.LocalDate
import java.util.Date
object KafkaProducer extends zio.ZIOAppDefault {
  private val BOOSTRAP_SERVERS = List("localhost:9092")
  private val KAFKA_TOPIC      = "streaming-hello"
  private val producer: ZLayer[Any, Throwable, Producer] =
    ZLayer.scoped(
      Producer.make(
        ProducerSettings(BOOSTRAP_SERVERS)
      )
    )

  /* private val consumerB: ZLayer[MyConsumerB, Throwable, Consumer] = for {
    c <- ZLayer.environment[MyConsumerB]
    cc <- ZLayer.scoped(
      Consumer.make(
        ConsumerSettings(BOOSTRAP_SERVERS)
          .withGroupId(c.get.group)
      )
    )
  } yield cc
   */
  def run = {
    val p: ZStream[Producer, Throwable, Nothing] =
      ZStream
        .repeatZIO(Clock.currentDateTime)
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
        .via(Producer.produceAll(Serde.int, Serde.string))
        .drain

    val c1: ZStream[Any, Throwable, Nothing] =
      Consumer
        .subscribeAnd(Subscription.manual(KAFKA_TOPIC -> 1))
        .plainStream(Serde.int, Serde.string)
        .tap(record => {
          Console.printLine(s"Consumer 1 ${record.value} partition ${record.partition}")
        })
        .map(_.offset)
        .mapZIO(_.commit)
        .provideSomeLayer(
          ZLayer.scoped(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId("group1")))
        )
        .drain

    val c2: ZStream[Any, Throwable, Nothing] =
      Consumer
        .subscribeAnd(Subscription.manual(KAFKA_TOPIC -> 2, KAFKA_TOPIC -> 0))
        .plainStream(Serde.int, Serde.string)
        .tap(record => {
          Console.printLine(s"Consumer 2 ${record.value} partition ${record.partition}")
        })
        .map(_.offset)
        .mapZIO(_.commit)
        .provideSomeLayer(
          ZLayer.scoped(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId("group2")))
        )
        .drain

    (c1 merge c2).runDrain.provide(producer)
  }
}
