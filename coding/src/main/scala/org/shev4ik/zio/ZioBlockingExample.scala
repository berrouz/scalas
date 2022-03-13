package org.shev4ik.zio
import zio.{ExitCode, URIO}
import zio.{URIO, ZIO}
import zio.console._
import zio.blocking._

import java.io.IOException
object ZioBlockingExample extends zio.App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    val program = ZIO.foreachPar((1 to 100).toArray)(blockingTask)
    program.exitCode
  }

  def blockingTask(n: Int): ZIO[Console with Blocking, IOException, Unit] =
    putStrLn(s"running blocking task number $n") *>
      effectBlocking(Thread.sleep(3000)).orDie
      //blockingTask(n).orDie

}
