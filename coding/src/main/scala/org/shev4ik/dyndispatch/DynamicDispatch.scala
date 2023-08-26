package org.shev4ik.dyndispatch

object DynamicDispatch extends App {

  trait Receiver {
    def call(p: Parent)
  }

  class ReceiverImpl extends Receiver {
    override def call (p: Parent): Unit = println(p.name)
  }


  trait Parent {
    def name: String = "parent"
  }

  class Child extends Parent {
    override def name: String = "child"
  }


  val receiver: Receiver = new ReceiverImpl

  receiver.call(new Child)

}
