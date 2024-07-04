package org.shev4ik.rockjvm.data_manipulation

import cats.data
import cats.data.Writer


object WriterApp extends App {

  import cats.data.Writer
  import cats.instances.list._
  import cats.instances.vector._

  val writer: Writer[List[String], Int] = data.Writer(List("a"), 1)

  val increasedWriter = writer.map(_ + 1)
  val aLogsWriter = writer.mapWritten(_ :+ "added value")
  val empty = writer.reset

  val biChanges = writer.bimap(list => list :+ ("help"), f => f + 2 )


  def countAndLog(n: Int): Writer[Vector[String], Int] = {
    if (n <= 0) Writer(Vector("starting"), 0)
    else
      countAndLog(n-1).flatMap(_ => Writer(Vector(s"$n"), n))
  }

  def naiveSum(n: Int): Writer[List[String], Int] = {
    if (n <= 0)
      Writer(List(), 0)
    else {
      for {
        log1 <- Writer(List(s"Now at $n"), n)
        sum <- naiveSum(n-1)
        log2 <- Writer(List(s"Computed sum (${n-1}) = $sum"), n)
      } yield sum + n
    }
  }

  naiveSum(10).written.foreach(println)
}



