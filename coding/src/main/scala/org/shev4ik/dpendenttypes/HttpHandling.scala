package org.shev4ik.dpendenttypes

object HttpHandling extends App {
  trait Handler[T, O]{
    def apply(t: T): O
  }

  trait ToHandler[H] {
    type In
    type Out

    def toHandler(h: => H): Handler[In, Out]
  }

  type Typed[H, In0, Out0] = ToHandler[H] {
    type In = In0;
    type Out = Out0
  }

  def handler[H](handler: => H)(implicit h: ToHandler[H]): Handler[h.In, h.Out] =
    h.toHandler(handler)

  implicit def toHandler[In0, Out0]: Typed[In0 => Out0, In0, Out0] = new ToHandler[In0 => Out0] {
    override type In = In0
    override type Out = Out0
    type F = (In0 => Out0)

    override def toHandler(h: => F): Handler[In, Out] = (t: In0) => h(t)
  }

  /*implicit def toHandler[In0,In1, Out0]: Typed[(In0, In1) => Out0, (In0, In1), Out0] = new ToHandler[(In0, In1) => Out0] {
    override type In = (In0, In1)
    override type Out = Out0
    type F = ((In0, In1) => Out0)

    override def toHandler(h: => F): Handler[In, Out] = (t: (In0, In1)) => h(t._1, t._2)
  }*/

  //private val value = handler { (s: String, i: Int) => s.toInt }

}
