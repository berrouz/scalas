package org.shev4ik.rockjvm.catseffects

import cats.effect.{ExitCode, IO, IOApp}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object AsyncMain extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = ???

  import scala.concurrent.ExecutionContext.Implicits.global

  def compute(): Int = ???

  lazy val molFuture: Future[Int] = Future { compute() }

  def futureToIO(future: () => Future[Int]): IO[Int] = {
    IO.async { cb =>
      future().onComplete {
        result => cb(result.toEither)
      }
    }
  }

  def neverEnding(): IO[Int] = {
    IO.async { cb =>

    }
  }
}
