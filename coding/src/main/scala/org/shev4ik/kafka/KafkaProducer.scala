package org.shev4ik.kafka

import org.apache.kafka.clients.producer.ProducerRecord
import zio._
import zio.kafka.consumer.{Consumer, ConsumerSettings, Subscription}
import zio.kafka.producer.{Producer, ProducerSettings}
import zio.kafka.serde.Serde
import zio.stream.ZStream

import java.util.Date

object KafkaProducer extends zio.ZIOAppDefault {
  private val BOOSTRAP_SERVERS = List("localhost:29092")
  private val KAFKA_TOPIC      = "streaming-hello"
  private val groupId = "group1"

  private val producer: ZLayer[Any, Throwable, Producer] =
    ZLayer.scoped(
      Producer.make(
        ProducerSettings(BOOSTRAP_SERVERS)
      )
    )

  private val consumer: ZLayer[Any, Throwable, Consumer] =
    ZLayer.scoped(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId(groupId)))

  def run: ZIO[Any, Throwable, Unit] = {
    val p: ZStream[Producer, Throwable, Nothing] =
      ZStream
        .repeatZIO(Clock.currentDateTime)
        .schedule(Schedule.spaced(5.second))
        .map(time => {
          val date = new Date()
          val record = new ProducerRecord(
            KAFKA_TOPIC,
            date.getTime,
            s"Message ${date.toInstant}"
          )
          record
        })
        .via(Producer.produceAll(Serde.long, Serde.string))
        .drain

    val c: ZStream[Any, Throwable, Nothing] =
      Consumer.plainStream(Subscription.topics(KAFKA_TOPIC), Serde.long, Serde.string)
        .tap(record => {
          Console.printLine(s"Consumer 1 ${record.value} partition ${record.partition}")
        })
        .map(_.offset)
        .mapZIO(_.commit)
        .provideSomeLayer(
          ZLayer.scoped(Consumer.make(ConsumerSettings(BOOSTRAP_SERVERS).withGroupId(groupId)))
        )
        .drain


    (p merge c).runDrain.provide(producer)
  }
}
