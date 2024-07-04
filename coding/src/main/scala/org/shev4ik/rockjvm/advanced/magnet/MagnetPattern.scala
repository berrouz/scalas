package org.shev4ik.rockjvm.advanced.magnet

import scala.concurrent.Future

class MagnetPattern extends App {

    class P2PRequest
    class P2PResponse

    class Serializer[T]

    trait Actor {
      def receive(statusCode: Int): Int
      def receive(request: P2PRequest): Int
      def receive(request: P2PResponse): Int
      def receive[T: Serializer](message: T): Int
      def receive[T: Serializer](message: T, statusCode: Int): Int
      def receive(future: Future[P2PRequest]): Int
    }

  trait MessageMagnet[Result]{
    def apply(): Result
  }

  def receive[R](magnet: MessageMagnet[R]): R = magnet()

  receive(new P2PRequest)
  receive(new P2PResponse())

  implicit class FromP2PRequest(request: P2PRequest) extends MessageMagnet[Int] {
    override def apply(): Int = {
      println("Handling p2p request")
      42
    }
  }

  implicit class FromP2PResponse(request: P2PResponse) extends MessageMagnet[Int] {
    override def apply(): Int = {
      println("Handling p2p response")
      43
    }
  }
}
