package org.shev4ik.kafka

import zio.ExitCode
import zio.Has
import zio.IO
import zio.RIO
import zio.URIO
import zio.ZLayer
import zio.blocking.Blocking
import zio.clock.Clock
import zio.console.Console
import zio.console.putStr
import zio.console.putStrLn
import zio.duration.{Duration, durationInt}
import zio.kafka.consumer.Consumer
import zio.kafka.consumer.ConsumerSettings
import zio.kafka.consumer.Subscription
import zio.kafka.serde.Serde

object KafkaProducer extends zio.App {

  private val host = "localhost:9092"
  private val group = "group"
  private val timeout: Duration = 30.seconds

  val settings: ConsumerSettings =
    ConsumerSettings(List(host))
      .withGroupId(group)
      .withClientId("client")
      .withCloseTimeout(timeout)

  private val updates = "updates"

  val subscription: Subscription = Subscription.topics(updates)

  val consumer: RIO[Any with Console with Blocking with Clock, Unit] = Consumer
    .consumeWith(settings, subscription, Serde.string, Serde.string) {
      case (key, value) =>
        putStrLn(s"Received message $key: $value").orDie
    }

  val env: ZLayer[Clock with Blocking, Throwable, Has[Consumer]] = ZLayer.fromManaged(Consumer.make(settings))

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] =
    Consumer
      .subscribeAnd(subscription)
      .plainStream(Serde.string, Serde.string)
      .tap(cr ⇒ putStr(cr.value))
      .map(_.offset)
      .aggregateAsync(Consumer.offsetBatches)
      .mapM(_.commit)
      .runDrain
      .provideCustomLayer(env)
      .exitCode

}
