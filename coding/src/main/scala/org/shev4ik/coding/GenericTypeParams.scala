package org.shev4ik.coding
import shapelesss._

object GenericTypeParams extends App {

  case class Strings(values: List[String])
  case class Ints(values: List[Int])


  def handle(a: Any): Unit = a match {
    case Strings(vs) => println("strings: " + vs.map(_.size).sum)
    case Ints(vs)  => println("ints: " + vs.sum)
    case _ =>
  }

  handle(Strings(List("hello", "world")))
}
