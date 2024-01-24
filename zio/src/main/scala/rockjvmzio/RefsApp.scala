package rockjvmzio

import main.scala.rockjvmzio.utils.ZioThreadUtils.ThreadUtils
import zio.{Ref, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object RefsApp extends ZIOAppDefault {
  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {

    def demoConcurrentWorkImpure() = {
      def task(workload: String, ref: Ref[Int]) = {
        val wordCount = workload.split(" ").length
        for {
          updated <- ref.updateAndGet(x => x + wordCount)
          _       <- ZIO.succeed(s"New total $updated").debugT
        } yield ()
      }

      for {
        ref <- Ref.make(0)
        _ <- ZIO.collectAllParDiscard(
          Set("I love ZIO", "This ref thing is cool", "Daniel writes a lot of code").map(str =>
            task(str, ref)
          )
        )
      } yield ()
    }

    demoConcurrentWorkImpure()

  }
}
