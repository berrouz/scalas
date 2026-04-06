package org.shev4ik.coding

import java.util.Date

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.util.Timeout

import scala.concurrent.duration._
object AkkaSystemApp extends App {
  implicit val system: ActorSystem = ActorSystem()

  val actor                     = system.actorOf(SuperActor.props)
  implicit val timeout: Timeout = 2.seconds
  actor ! Start
}

class SuperActor extends Actor {
  val dateActor: ActorRef = context.actorOf(Props[CurrentDateActor])
  override def receive: Receive = {
    case Start             ⇒ dateActor ! GetDate
    case CurrentDate(date) ⇒ println(s"Current date is $date")
  }
}
object SuperActor {
  def props: Props = Props(new SuperActor())
}

class CurrentDateActor extends Actor {
  override def receive: Receive = { case GetDate ⇒
    sender() ! CurrentDate(new Date())
  }
}

object CurrentDateActor {
  def props: Props = Props(new CurrentDateActor)
}

object GetDate
object Start
case class CurrentDate(date: Date)
