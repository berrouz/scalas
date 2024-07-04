package org.shev4ik.rockjvm.catseffects.errorhandling

import cats.effect.{ExitCode, IO, IOApp}

import scala.util.{Failure, Try}

object ErrorHandling extends IOApp {


  def optionIO[A](option: Option[A])(ifEmpty: Throwable): IO[A] =
    option match {
      case Some(v) => IO.pure(v)
      case None => IO.raiseError(ifEmpty)
    }

  def tryIo[A](aTry: Try[A]): IO[A] = {
    aTry match {
      case scala.util.Success(s) => IO.pure(s)
      case Failure(exception) => IO.raiseError(exception)
    }
  }

  def eitherIO[A](either: Either[Throwable, A]): IO[A] = {
    either match {
      case Left(exc) => IO.raiseError(exc)
      case Right(value) => IO.pure(value)
    }
  }

  def handleIoError[A](io: IO[A])(handle: Throwable => A): IO[A] ={
    io.attempt.map { case Left(exc) => handle(exc) }
  }

  def handleIOErrorWith[A](io: IO[A])(handle: Throwable => IO[A]): IO[A] = {
    io.handleErrorWith(handle)
  }


  override def run(args: List[String]): IO[ExitCode] = {
    optionIO(Some(1))(new IllegalAccessError()).as(ExitCode.Success)
  }
}
