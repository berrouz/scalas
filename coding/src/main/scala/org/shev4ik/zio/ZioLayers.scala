package org.shev4ik.zio

import eu.timepit.refined.types.string.NonEmptyString
import org.shev4ik.zio.HelloService.HelloService
import org.shev4ik.zio.UserDb.UserDb
import org.shev4ik.zio.UserService.UserService
import zio.config._
import zio.config.getConfig
import zio.config.refined.{deriveRefinedDescriptor, refine}
import zio.config.typesafe.TypesafeConfigSource
import zio.console.putStrLn
import zio.config.magnolia.DeriveConfigDescriptor.descriptor
import zio.{ExitCode, Has, IO, Task, ULayer, URLayer, ZIO, ZLayer}
object ZioLayers extends zio.App {

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = {

    val program: ZIO[HelloService with UserService with Has[MyConfig], Throwable, Unit] = for {
      s <- ZIO.service[HelloService.Service]
      userService <- ZIO.service[UserService.Service]
      _ <- s.hello()
      config <- getConfig[MyConfig]
      _ <- userService.hello(config.ldap.loc.value)
    } yield ()


    case class MyConfig(ldap: Ldap, port: Int, dburl: String)

    case class Ldap(loc: NonEmptyString)

    val myConfig: ConfigDescriptor[MyConfig] = descriptor[MyConfig]
     // (refine[String, NonEmpty]("LDAP") |@| int("PORT")|@| string("DB_URL"))(MyConfig.apply, MyConfig.unapply)


    val sourceString = """
                {
                    key-values : {
                       key1 : "usa"
                       key2 : "111111111111"
                       key3 : "australia"
                    }
                 }
              """

    val source = TypesafeConfigSource.fromHoconString(sourceString)



    val layers: URLayer[UserDb with HelloService, HelloService with UserService with UserDb] = HelloService.live ++ UserService.live >+> UserDb.live

    val l: ZLayer[UserDb with HelloService, Throwable, UserDb] = layers >>> layers

    val app = program.provideLayer((UserDb.live >+> HelloService.live  >>> layers) ++
      ZConfig.fromPropertiesFile(getClass.getResource("/file.conf").getPath, myConfig) )
    app.foldM(
      err => putStrLn(s"Execution failed with: $err").orDie.exitCode,
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
    def hello(s: String): Task[Unit]
  }

  val live: URLayer[HelloService, UserService] = ZLayer.succeed(new Service {
    override def hello(s: String): Task[Unit] = IO.effect(println(s))
  })
}

object UserDb {
  type UserDb = Has[Service]

  trait Service {
    def getUser(): Task[Unit]
  }

  val live: ULayer[UserDb] = ZLayer.succeed(() => IO.effect(println("User")))
}