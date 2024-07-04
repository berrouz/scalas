package org.shev4ik.advanced.scala2

object InheritanceImplicits extends App {

  trait Base[-T]

  trait Thing

  case class Auto() extends Thing
  case class Bike() extends Thing

  implicit val b: Base[Auto] = new Base[Auto] {}

  def hello[T](t: T)(implicit b: Base[T]) = ???

  hello(new Auto{})

}
