package main.scala.rockjvmzio

import zio.{Fiber, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Fibers extends ZIOAppDefault {

  def zioFibers[E,A,B](fiber1: Fiber[E, A], fiber2: Fiber[E, B]): ZIO[Any, Nothing, Fiber[E, (A,B)]] = {
    (for {
      f1 <- fiber1.join
      f2 <- fiber2.join
    } yield (f1, f2)).fork
  }

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    ???
  }
}
