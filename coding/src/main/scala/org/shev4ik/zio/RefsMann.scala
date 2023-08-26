package org.shev4ik.zio

import zio.{Ref, Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault}

object RefsMann extends ZIOAppDefault {
  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    val effects = List("jello", "hello", "world hey").map(task)

    ZIO.collectAllParDiscard(effects)
  }

  def task(str: String): Task[Unit] = for {
    _ <- Ref.make(0)
  } yield ()
}
