package org.shev4ik.mastering_type_system.higher_kinded_types

import scala.language.higherKinds

object HigherKindedTypes extends App {
  trait Functor[F[_]] {
    def map[A,B](fa: F[A])(f: A => B): F[B]
  }

  // F[_] - higher-kinded type

  trait Doubler[A] {
    def double(f: A): A
  }

  def doubleElements[F[_]: Functor, A](f: F[A])(implicit d: Doubler[A]): F[A] =  implicitly[Functor[F]].map(f)(a => d.double(a))

  implicit val doublerIo: Functor[Option] = new Functor[Option] {
    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }
  implicit val doublerInt: Doubler[Int] = (f: Int) => f * 2

  implicit val doublerStr: Doubler[String] = (f: String) => f * 2


  implicit val doublerList: Functor[List] = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  println(doubleElements(Some(2): Option[Int]))
  println(doubleElements(Some("A"): Option[String]))
  println(doubleElements(List(2): List[Int]))
}
