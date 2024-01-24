package main.scala.rockjvmzio

import zio.{Duration, Scope, ZIO, ZIOAppArgs, ZIOAppDefault, durationInt}

object InterruptionsZio extends ZIOAppDefault {
  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = for {
    result <- timeout(ZIO.succeed(199) *> ZIO.fail(new IllegalAccessError()), 1.second)
    _ <- zio.Console.printLine(result)
  } yield ()

  def timeout[R,E,A](zio: ZIO[R,E,A], time: Duration): ZIO[R, E, A] = for {
    fiber <- zio.fork
    _ <- fiber.interruptFork.delay(time)
    result <- fiber.join
  } yield result
}
