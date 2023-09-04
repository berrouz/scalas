package org.shev4ik.monads

import scala.language.higherKinds

object MonadMain extends App {

  trait MonadCustom[F[_]] {
    def unit[A](a: => A): F[A]

    def flatMap[A, B](ma: F[A])(f: A => F[B]): F[B]

    def map[A, B](ma: F[A])(f: A => B): F[B] = flatMap(ma)(a => unit(f(a)))

    def map2[A, B, C](ma: F[A], mb: F[B])(f: (A, B) => C): F[C] =
      flatMap(ma)(a => map(mb)(b => f(a, b)))
  }

  object MonadCustom {

    val listMonad: MonadCustom[List] = new MonadCustom[List] {
      override def unit[A](a: => A): List[A] = List(a)

      override def flatMap[A, B](ma: List[A])(f: A => List[B]): List[B] =
        ma flatMap f
    }

  }

}
