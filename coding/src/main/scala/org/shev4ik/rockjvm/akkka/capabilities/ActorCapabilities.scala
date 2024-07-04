package org.shev4ik.rockjvm.akkka.capabilities

import akka.actor.{Actor, ActorSystem, Props}

object ActorCapabilities extends App {

  class SimpleActor extends Actor {
    override def receive: Receive = {
      case message: String => println(s"[$self] I have received $message")
    }
  }

  val system = ActorSystem("actorCapabilitiesDemo")

  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")


  simpleActor ! "hello, actor"
  simpleActor ! 42

  case class SpecialMessage(contents: String)

  class BankAccount extends Actor {
    var balance: BigDecimal = 0
    override def receive: Receive = {
      case Statement => sender() ! Right(balance)
      case Deposit(amount) =>
        balance += amount
        sender() ! Right(balance)
      case Withdraw(amount) =>
        if (balance >= amount){
          balance -= amount
          sender() ! Right(balance)
        } else {
          sender() ! Left("Not sufficient amount of money")
        }

    }
  }

  case class Deposit(amount: BigDecimal)
  case class Withdraw(amount: BigDecimal)
  object Statement

  val acc = system.actorOf(Props(new BankAccount))

  acc ! Deposit(100)
  acc ! Withdraw(50)
  acc ! Withdraw(60)
  println(acc ! Statement)
  system.terminate()
}
