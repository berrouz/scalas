package org.shev4ik.rockjvm.cats.monad.UsingMonads

import cats.Monad

import scala.annotation.tailrec

object CustomMonads extends App {


  type Identity[T] = T

  val aNumber: Identity[Int] = 42


  implicit object OptionMonad extends Monad[Option] {
    override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] =
      fa.flatMap(f)

    @tailrec
    override def tailRecM[A, B](a: A)(f: A => Option[Either[A, B]]): Option[B] = f(a) match {
      case None => None
      case Some(Right(b)) => Some(b)
      case Some(Left(a)) => tailRecM(a)(f)
    }

    override def pure[A](x: A): Option[A] = Option(x)
  }


  implicit object IdentityMonad extends Monad[Identity] {
    override def flatMap[A, B](fa: Identity[A])(f: A => Identity[B]): Identity[B] = f(fa)

    @tailrec
    override def tailRecM[A, B](a: A)(f: A => Identity[Either[A, B]]): Identity[B] =
      f(a) match {
        case Left(a) => tailRecM(a)(f)
        case Right(b) => b
      }

    override def pure[A](x: A): Identity[A] = x
  }

  sealed trait Tree[+A]

  final case class Leaf[+A](value: A) extends Tree[A]
  final case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A]

  implicit object TreeMonad extends Monad[Tree] {
    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] =
      fa match {
        case Leaf(value) => f(value)
        case Branch(left, right) => Branch(flatMap(left)(f), flatMap(right)(f))
      }

    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = f(a) match {
      case Leaf(Right(b)) => Leaf(b)
      case Leaf(Left(a)) => tailRecM(a)(f)
      case Branch(a,b) => ??? //Branch(tailRecM(a), tailRecM(b))
    }

    override def pure[A](x: A): Tree[A] = Leaf(x)
  }
}
