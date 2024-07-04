package org.shev4ik.rockjvm.cats.apply

import cats.{Apply, Functor, Semigroupal}

import scala.language.higherKinds

object Apply{

  def main(args: Array[String]): Unit = {


    trait MyFlatMap[M[_]] extends Apply[M] {
      def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B]

      def ap[A, B](wf: M[A => B])(wa: M[A]): M[B] = flatMap(wa)(a => map(wf)(f => f(a)))
    }


    trait MyApplicative[W[_]] extends Functor[W] with Semigroupal[W] {
      def pure[A](x: A): W[A] = ???
    }
  }
}
