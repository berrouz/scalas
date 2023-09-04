package org.shev4ik.coding.catz

import scala.language.higherKinds
object CustomFunctor extends App {
  trait Functor[F[_]] {
    def mapper[A, B](a: F[A])(f: A => B): F[B]
    def lift[A, B](f: A => B): F[A] => F[B]
  }
  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    override def mapper[A, B](a: Option[A])(f: A => B): Option[B] = a match {
      case Some(value) => Some(f(value))
      case None        => None
    }
    override def lift[A, B](f: A => B): Option[A] => Option[B] = fa => mapper(fa)(f)
  }
  val ff: Option[Int] => Option[Int] = implicitly[Functor[Option]].lift((a: Int) => a + 1)
}
