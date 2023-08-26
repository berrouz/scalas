package org.shev4ik.advanced.scala2

import scala.language.higherKinds
import scala.util.Try

object HighKindedAux extends App {


  trait Printable[T, R[S <: T]] {
    def print(): String
  }

  implicit val a: Printable[Int, Option] = new Printable[Int, Option] {
    override def print(): String = "option"
  }

  implicit val b: Printable[String, Option] = new Printable[String, Option] {
    override def print(): String = "option"
  }

  def print[T](s: Option[T])(implicit printable: Printable[T, Option]) = printable.print()

  print(Some(1))
}
