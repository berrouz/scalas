package org.shev4ik.coding.scalatypes.pathdependent

import scala.concurrent.{ExecutionContext, Future}

object ImplicitGuard extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  trait IsFuture[F] {
    type T

    def apply(f: F): Future[T]
  }

  object IsFuture {
    def apply[F](implicit isf: IsFuture[F]) = isf

    implicit def mk[A] = new IsFuture[Future[A]] {
      type T = A

      def apply(f: Future[A]): Future[A] = f
    }
  }

  def logResult[T](thing: T)(implicit isf: IsFuture[T]): Future[isf.T] =
    isf(thing) map { x =>
      println(s"I got a result of $x")
      x
    }

  implicit val isF: IsFuture[List[String]] = new IsFuture[List[String]] {
    override type T = List[String]

    override def apply(f: List[String]): Future[T] = Future.successful(f)
  }

  // val res: Future[List[String]] = logResult(List(""))

}
