package org.shev4ik.refactoring

import zio._
import zio.console._

import java.io.File

object ExampleComplex extends zio.App {

  import scala.io.Source
  import java.io.PrintWriter


  private def print(grouped: Map[String, Int]): ZIO[Any, Throwable, Unit] = {
    ZIO.bracket(ZIO.effect(new PrintWriter(new File(""))))(w => UIO(w.close())) { writer =>
      ZIO.foreach_(grouped) { case (key, value) =>
        ZIO.effect(writer.println(s"$key -> $value"))
      }
    }
  }

  private def filter(lines: List[String]): List[(String, Int)] = {
    val filtered = lines.filter(_.nonEmpty).filterNot(_.startsWith("#"))
    filtered.map { line =>
      val parts = line.split(",")
      (parts(0), parts(1).toInt)
    }
  }

  private def parse(filePath: String): ZIO[Any, Throwable, List[String]] = {
    ZIO.effect(Source.fromFile(filePath)).flatMap { source =>
      ZIO.effect(source.getLines().toList)
    }
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = {
    (for {
      lines <- parse("data.csv")
      _ <- ZIO.foreach_(lines)(line => putStrLn(line))
      transformed = filter(lines)
      _ <- print(transformed.toMap)
    } yield ()).exitCode
  }
}
