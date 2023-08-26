package org.shev4ik.advanced.scala2

object CaptureTypes extends App {

  case class Something[F[_], A](value: A)

    private final class Capture[A](val a: A) extends AnyVal {
      type Tpe = A

      final def value: Tpe = a
    }

    private object Capture {
      implicit def apply[A](a: A): Capture[A] = new Capture(a)
    }

    def apply[F[_]](capture: Capture[_]): Something[F, capture.Tpe] =
      new Something[F, capture.Tpe](capture.value)

    //println(Capture(List(1)).a)



  case class Thing[T](value: T)

  def processThing[T](thing: Thing[T]) = {
    thing match {
      case Thing(value: Int) => "Thing of int"
      case Thing(value: String) => "Thing of string"
      case Thing(value: Seq[Int]) => "Thing of Seq[int]" + value.sum
      case _ => "Thing of something else"
    }
  }

  println(processThing(Thing(1)))
  println(processThing(Thing("hello")))
  println(processThing(Thing(Seq("s"))))
}
