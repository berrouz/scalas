package org.shev4ik.rockjvm.cats.monad.UsingMonads

import cats.Monad
import cats.instances.list._

object UsingMonads extends App {

  val monadList = Monad[List]

  val aSimpleList = monadList.pure(1)

  val anExtendedList = monadList.flatMap(aSimpleList)(x => List(x, x + 1))

  val aManualEither: Either[String, Int] = Right(42)

  type LoadingOr[T] = Either[String, T]

  type ErrorOr[T] = Either[Throwable, T]

  import cats.instances.either._

  val loadingMonad: Monad[LoadingOr] = Monad[LoadingOr]

  val anEither: LoadingOr[Int] = loadingMonad.flatMap(anEither) { n =>
    if (n % 2 == 0)
      Right(n + 1)
    else
      Left("err")
  }

}
