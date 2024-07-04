package org.shev4ik.rockjvm.cats.semigroupals

import cats.{Monad, Semigroupal}
import cats.instances.list._
import cats.instances.option._

import scala.language.higherKinds

object Semigroupals extends App {

  trait MSemigroupal[F[_]] {
    def product[A, B](fa: F[A], fb: F[B]): F[(A,B)]
  }

  val optSemigroupal = Semigroupal[Option]

  val aTupledOption = optSemigroupal.product(Some(1), Some("a"))

  val listSemigroupal = Semigroupal[List]

  val aTupled = listSemigroupal.product(List(1,2), List("a", "b"))

  println(aTupled)


  def productWithMonads[F[_], A, B](fa: F[A], fb: F[B])(implicit monad: Monad[F]): F[(A,B)] =
    monad.map2(fa, fb)((a,b) => (a,b))

}
