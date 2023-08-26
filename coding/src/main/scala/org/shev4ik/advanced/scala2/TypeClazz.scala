package org.shev4ik.advanced.scala2

object TypeClazz extends App {

  trait Eq[T]{
    def apply(a: T, b: T): Boolean
  }

  implicit class EqOps[T](a: T){
    def eqa(b: T)(implicit eq: Eq[T]): Boolean = eq(a, b)
  }

  implicit object EqString extends Eq[String]{
    override def apply(a: String, b: String): Boolean = a == b
  }

  println("a".eqa("b"))

  trait Req
  case class Primary() extends Req
  case class Secondary() extends Req


  trait Aux[T, R] {
    type OutType <: Context

    def getMember(t: T): OutType
  }

  trait Context

  trait Printer[R, T]{
    def print(t: R): String
  }

  implicit val myPrinter: Printer[Primary, PrimaryContext] = (t: Primary) => t.toString

  case class PrimaryContext() extends Context
  object Aux {
    implicit val x: Aux[Primary, PrimaryContext] = new Aux[Primary, PrimaryContext] {
      override type OutType = PrimaryContext

      override def getMember(t: Primary): PrimaryContext = PrimaryContext()
    }
  }
  def handle[T, R](req: T)(implicit aux: Aux[T, R], context: Printer[T, R]) = {
    aux.getMember(req)
  }


  handle(Primary())
}
