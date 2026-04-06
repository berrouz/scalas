package org.shev4ik.dynamicprogramming.fp

object Monads extends App {

  implicit val e: Execute[String] = ExecImpl

  def doSome[A: Execute](s: A): A = {
    implicitly[Execute[A]].run(s)
  }

  println(doSome("running"))

  case class Box[A](val a: A) {

    def map[B](implicit ev: A <:< Option[B]): B = {
      a match {
        case Some(x) => a.get
        case _       => throw new OutOfMemoryError("")
      }
    }
  }

  println(Box(Some(2)).map)

}

object ExecImpl extends Execute[String] {
  override def run(a: String): String = a
}
trait Execute[A] {
  def run(a: A): A
}
