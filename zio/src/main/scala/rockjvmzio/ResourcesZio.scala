package main.scala.rockjvmzio

import main.scala.rockjvmzio.utils.ZioThreadUtils._
import zio.{Scope, Task, UIO, ZIO, ZIOAppArgs, ZIOAppDefault, durationInt}

import java.io.{BufferedReader, FileReader}
object ResourcesZio extends ZIOAppDefault {

  def unsafe(): Int = throw new RuntimeException("Not an int here for you")

  val anAttempt: Task[Int] = ZIO.attempt(unsafe())

  val attemptWithFinalizers = anAttempt.ensuring(ZIO.succeed("finalizer!").debugT)

  val attemptWithFinalizers2 = attemptWithFinalizers.ensuring(ZIO.succeed("finalizer2!").debugT)

  class Connection(url: String) {
    def open()  = ZIO.succeed(s"opening connection $url").debugT
    def close() = ZIO.succeed(s"closing connection $url").debugT
  }
  object Connection {
    def create(url: String) = ZIO.succeed(new Connection(url))
  }

  val cleanConnection = ZIO.acquireReleaseWith(Connection.create("url"))(_.close())(connection =>
    connection.open() *> ZIO.sleep(2000.seconds)
  )

  val fetchUrl = for {
    connection <- cleanConnection.fork
    _          <- ZIO.succeed("interruption").debugT.delay(1.second) *> connection.interrupt
    _          <- connection.join
  } yield ()

  // acquireRelease

  def openFileScanner(path: String): Task[BufferedReader] =
    ZIO.attempt(new BufferedReader(new FileReader(path)))

  def acquireOpenFile(path: String): ZIO[Any, Throwable, Unit] = {
    def printAll(reader: BufferedReader): Task[Unit] = {
      ZIO.attempt(
        reader
          .lines()
          .forEach(line => {
            println(line)
            Thread.sleep(100)
          })
      )
    }
    def release(reader: BufferedReader): UIO[Unit] = {
      ZIO.succeed(reader.close())
    }
    ZIO.acquireReleaseWith(openFileScanner(path))(release)(printAll)
  }

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] =
    acquireOpenFile(
      "/Users/shevchyk/projects/scalas/zio/src/main/scala/rockjvmzio/utils/ZioThreadUtils.scala"
    )
}
