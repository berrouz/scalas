package rockjvmzio

import main.scala.rockjvmzio.utils.ZioThreadUtils.ThreadUtils
import zio.{Promise, Ref, Scope, Task, UIO, ZIO, ZIOAppArgs, ZIOAppDefault}

object PromisesMain extends ZIOAppDefault {

  val promise = Promise.make[Throwable, Int]

  val reader = promise.flatMap { pr =>
    pr.await
  }


  def eggBoiler(): UIO[Unit] = {

    def makeCounter(promise: Promise[Throwable, Int]): Task[Unit] = for {
      _ <- promise.await
      _ <- ZIO.succeed("Ring Bell").debugT
    } yield ()

    def count(c: Int, promise: Promise[Throwable, Int]): UIO[Unit] = for {
      _ <- ZIO.succeed(s"tick $c").debugT
      _ =  Thread.sleep(1000)
      res = c + 1
      _ <- if (res == 10) promise.complete(ZIO.succeed(10)) else count(res, promise)
    } yield ()

    for {
      ref <- Ref.make(0)
      promise <- Promise.make[Throwable, Int]
      _ <- (makeCounter(promise) zipPar count(0, promise)).exit
    } yield ()
  }


  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = eggBoiler()


}
