package org.shev4ik.rockjvm.catseffects.parallelist

import cats.effect.{ExitCode, IO, IOApp}

object IOParallelism extends IOApp {
  val ioA: IO[Unit] = IO(println(s"${Thread.currentThread().getName} a"))
  val ioB: IO[Unit] = IO(println(s"${Thread.currentThread().getName} b"))

  override def run(args: List[String]): IO[ExitCode] = {
    ioA.flatMap(_ => ioB).as(ExitCode.Success)
  }
}
