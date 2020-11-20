package org.shev4ik.zio

import org.shev4ik.zio.HelloService.HelloService
import org.shev4ik.zio.UserDb.UserDb
import org.shev4ik.zio.UserService.UserService
import zio.console.putStrLn
import zio.{ExitCode, Has, IO, Task, ULayer, URLayer, ZEnv, ZIO, ZLayer}

object ZioLayers extends zio.App {

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = {

    val program: ZIO[HelloService with UserService, Throwable, Unit] = for {
      s <- ZIO.service[HelloService.Service]
      userService <- ZIO.service[UserService.Service]
      _ <- s.hello()
      _ <- userService.hello()
    } yield ()


    val layers = UserDb.live >+> HelloService.live ++ UserService.live

    val app = program.provideLayer(layers)
    app.foldM(
      err => putStrLn(s"Execution failed with: $err") *> ZIO.succeed(ExitCode.failure),
      _ => ZIO.succeed(ExitCode.success)
    )
  }
}

object HelloService {
  type HelloService = Has[Service]

  trait Service {
    def hello(): Task[Unit]
  }

  val live: URLayer[UserDb, HelloService] = ZLayer.fromService[UserDb.Service, Service](db => new Service {
    override def hello(): Task[Unit] = db.getUser()
  })
}


object UserService {
  type UserService = Has[Service]

  trait Service {
    def hello(): Task[Unit]
  }

  val live: ULayer[UserService] = ZLayer.succeed(new Service {
    override def hello(): Task[Unit] = IO.effect(println("Hello User Service"))
  })
}

object UserDb {
  type UserDb = Has[Service]

  trait Service {
    def getUser(): Task[Unit]
  }

  val live: ULayer[UserDb] = ZLayer.succeed(() => IO.effect(println("User")))
}