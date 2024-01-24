package rockjvmzio

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

class ParallelZio extends ZIOAppDefault {

  val meanOfLife = ZIO.succeed(19)
  val favourite = ZIO.succeed("Scala")

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    meanOfLife.zipPar(favourite)
  }
}
