package org.shev4ik.advanced.scala2

object MagnetApp extends App {

  trait Handle[I, Out] {
    type Result = Out
    def handle(t: I): Result
  }

  trait Aux[A, B] {
    type Out = B
  }

  implicit val auxAb: Aux[Option[Int], Option[Int]] = new Aux[Option[Int], Option[Int]] {}

  implicit val h: Handle[Option[Int], Option[Int]] = new Handle[Option[Int], Option[Int]] {
    override def handle(t: Option[Int]): Option[Int] = ???
  }

  def hello[I, O](arg: I)(implicit aux: Aux[I, O], handler: Handle[I, O]): handler.Result =
    handler.handle(arg)

  trait Primary   {}
  trait Secondary {}

  sealed trait Fees

  case class BillingFees()      extends Fees
  case class SplitBillingFees() extends Fees

  sealed trait MagnetProvider {
    type Provider

    type Fees
    def provide(fees: Fees)(implicit p: CpayEventProvider[Provider, Fees]): String = p.provide(fees)
  }

  implicit def primaryProvider(primary: Primary) = new MagnetProvider {
    override type Provider = Primary
    override type Fees     = BillingFees
    override def provide(fees: BillingFees)(implicit
        p: CpayEventProvider[Primary, BillingFees]
    ): String = p.provide(fees)
  }

  implicit def secondaryProvider(secondary: Secondary) = new MagnetProvider {
    override type Provider = Secondary
    override type Fees     = BillingFees
    override def provide(fees: Fees)(implicit p: CpayEventProvider[Provider, Fees]): String =
      p.provide(fees)

  }
  // def magnetProvider(magnet: MagnetProvider)= magnet.provide()

  trait CpayEventProvider[P, F] {
    def provide(fees: F): String = ???
  }
  implicit val pp: CpayEventProvider[Primary, BillingFees] =
    new CpayEventProvider[Primary, BillingFees] {
      def provide(fees: Fees): String = ???
    }
  class SecondaryProvider() {
    def provide(): String = ???
  }

  // magnetProvider(new Primary{}).provide(BillingFees())
  // hello(Option(1))
  // hello(Option(1))
}
