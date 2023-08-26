package org.shev4ik.tranzzo

import java.util.UUID

object TransformationTypeclass extends App{


  type Command = String


  case class BillingEvent()
  trait Billing[T]{
    def cpayId: UUID
    def posId: UUID
    def orderId: String
  }

  implicit val billingEvent: Billing[BillingEvent] = new Billing[BillingEvent]{
    override def cpayId: UUID = ???

    override def posId: UUID = ???

    override def orderId: Command = ???
  }


  trait Quality

  case class SuperQuality() extends Quality
  case class LowQuality() extends Quality
  class SuperClass(){
    def calc(quality: SuperQuality): Unit = {
      println("high")
    }

    def calc(quality: LowQuality): Unit = {
      println("low")
    }

  }


  val clazz  = new SuperClass

  clazz.calc(SuperQuality())
  clazz.calc(LowQuality())
}
