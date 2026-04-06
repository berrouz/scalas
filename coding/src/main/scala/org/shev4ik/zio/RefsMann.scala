package org.shev4ik.zio

import zio.{Ref, Task, ZIO, ExitCode}

object RefsMann extends zio.App {
  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = {
    val effects = List("jello", "hello", "world hey").map(task)

    ZIO.collectAllPar_(effects).exitCode
  }

  def task(str: String): Task[Unit] = for {
    _ <- Ref.make(0)
  } yield ()
}
