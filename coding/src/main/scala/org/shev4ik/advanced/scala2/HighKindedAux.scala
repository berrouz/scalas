package org.shev4ik.advanced.scala2

import scala.language.higherKinds
import scala.util.Try

object HighKindedAux extends App {

  trait Printable[T, R[S <: T]] {
    def print(): String
  }

  implicit val a: Printable[Int, Option] = () => "option"

  implicit val b: Printable[String, Option] = () => "option"

  def print[T](s: Option[T])(implicit printable: Printable[T, Option]) =
    printable.print()

  print(Some(1))
  print(Some("a"))
}
