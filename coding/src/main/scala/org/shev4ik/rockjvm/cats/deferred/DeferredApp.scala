package org.shev4ik.rockjvm.cats.deferred

import cats.effect.concurrent.Deferred
import cats.effect.{ExitCode, IO, IOApp}

import scala.concurrent.duration.DurationInt

object DeferredApp extends IOApp {
  val deferred: IO[Deferred[IO, Int]] = Deferred[IO, Int]

  implicit class IOOps(io: IO[_]){
    def debug(): IO[_] ={
      io.flatMap(in => {
        println(in)
        io
      })
    }
  }

  val reader: IO[Int] = deferred.flatMap { signal =>
    signal.get
  }
  val writer: IO[Unit] = deferred.flatMap(signal => signal.complete(42))

  def demo(): IO[Unit] = {
    def consumer(signal: Deferred[IO, Int]): IO[Unit] = for {
      _ <- IO("[consumer] waiting for the result").debug()
      result <- signal.get
      _ <- IO(s"[consumer] got result $result").debug()
    } yield ()

    def producer(signal: Deferred[IO, Int]): IO[Unit] = for {
      _ <- IO("[producer] crunching the result").debug()
      _ <- IO.sleep(1.second)
      _ <- IO(s"[producer] produces the result 43").debug()
      result <- IO(43)
      _ <- signal.complete(result)
    } yield ()

    for {
      signal <- Deferred[IO, Int]
      fibConsumer <- consumer(signal).start
      fibProducer <- producer(signal).start
      _ <- fibConsumer.join
      _ <- fibProducer.join
    } yield ()
  }

  override def run(args: List[String]): IO[ExitCode] = demo().as(ExitCode.Success)
}
