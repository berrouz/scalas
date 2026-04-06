package org.shev4ik.monads

import scala.language.higherKinds

object MonadsDiff extends App {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // composition fa.map(f).map(g)  == fa.map(g).map(f)
  // identity fa.map(x => x) == fa

  trait Applicative[F[_]] extends Functor[F] {
    def ap[A, B](ff: F[A => B])(f: F[A]): F[B]

    def pure[A](a: A): F[A]

    def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)

    // associativity fa.product(fb).product(fc) ± fa.product(fb.product(fc))
    // left identity pure(()).product(fa) ± fa
    // right identity fa.product(pure(())) ± fa
  }
}
