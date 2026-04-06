package org.shev4ik.coding.scalatypes

object Capitals extends App {

  trait Country

  class France  extends Country
  class Ukraine extends Country
  class Poland  extends Country

  trait City
  class Paris  extends City
  class Warsaw extends City
  class Kiev   extends City
  trait HasCapital[T <: Country] {
    type C
    def capital: C
  }

  implicit val capitalFrance = new HasCapital[France] {
    override type C = Paris
    override def capital: Paris = new Paris
  }
  implicit val capitalPoland = new HasCapital[Poland] {
    override type C = Warsaw
    override def capital: Warsaw = new Warsaw
  }
  implicit val capitalUkraine = new HasCapital[Ukraine] {
    override type C = Kiev
    override def capital: Kiev = new Kiev
  }

  def lookup[T <: Country](implicit ic: HasCapital[T]): ic.C = {
    ic.capital
  }

  val a: Paris = lookup[France]
  val b: Kiev  = lookup[Ukraine]
}
