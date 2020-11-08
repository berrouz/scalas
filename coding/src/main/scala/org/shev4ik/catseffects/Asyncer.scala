package org.shev4ik.catseffects

object Asyncer extends App{
  import cats.effect.{IO, Async}

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future

  val apiCall = Future.successful("I come from the Future!")

  val ioa: IO[String] =
    Async[IO].async { cb =>
      import scala.util.{Failure, Success}

      apiCall.onComplete {
        case Success(value) => cb(Right(value))
        case Failure(error) => cb(Left(error))
      }
    }

  ioa.unsafeRunSync()
}
