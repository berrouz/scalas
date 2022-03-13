package org.shev4ik.fp

object TypeToType extends App {


  trait Strategy

  case object IntStr extends Strategy
  case object StrStr extends Strategy
  trait DepValue {
    type V <: Strategy
    val value: V
  }

  def magic(that: DepValue): that.V = that.value

  def mk[T <: Strategy](x: T)= new DepValue{
    type V = T
    val value: T = x
  }
  val depInt = mk(IntStr)
  //val depString = mk("two")

  val itWorks = magic(depInt)
  //val again: String = magic(depString)


  val opts = Seq(None, Some(1))

  opts.collect {
    case Some(x) => x
  }


  final case class Frac[T]()

  implicit val fracDB: Frac[BigDecimal]= Frac()
  val fracD: Frac[Double] = Frac()


  def avg[T: Frac](s: Seq[T]): T = s.head


  avg(Seq(BigDecimal(1)))
}
