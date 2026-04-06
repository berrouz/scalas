package org.shev4ik.rockjvm.advanced_scala.self_types

object SelfTypes extends App {


  trait InstrumentList {
    def play(): Unit
  }

  trait Singer { self: InstrumentList =>
    def sing(): Unit
  }

  class LeadSinger extends Singer with InstrumentList {
    override def sing(): Unit = ???
    override def play(): Unit = ???
  }

  val jamesHetField = new Singer with InstrumentList {
    override def play(): Unit = ???
    override def sing(): Unit = ???
  }
}
