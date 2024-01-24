package main.scala.rockjvmzio

import zio.{Scope, UIO, ZIO, ZIOAppArgs, ZIOAppDefault}

object Essentials extends ZIOAppDefault {



  def fiboZio(n: Int): UIO[BigInt] = {
    if (n < 2) ZIO.succeed(1)
    else
      for {
        last <- ZIO.suspendSucceed(fiboZio(n - 1))
        prev <- fiboZio(n - 2)
      } yield last + prev
  }

  override def run:  ZIO[Environment with ZIOAppArgs with Scope, Any, Any] = {

    val result: ZIO[Any, Throwable, Nothing] =
      ZIO.succeed(throw new RuntimeException()).unrefine {
      case e => e
    }

    fiboZio(100)
  }
}
