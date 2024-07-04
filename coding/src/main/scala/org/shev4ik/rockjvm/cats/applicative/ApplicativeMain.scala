package org.shev4ik.rockjvm.cats.applicative

import cats.Applicative
import cats.implicits.catsStdInstancesForFuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.higherKinds

object ApplicativeMain extends App {

  import cats.syntax.applicative._
  import cats.instances.list._
  import cats.instances.option._
  import cats.instances.future._

  val appList = Applicative[List]
  val appOpt = Applicative[Option]

  1.pure[List]
  1.pure[Option]


  import cats.data.Validated
  type ErrorsOr[T] = Validated[List[String], T]

  val aValidated: ErrorsOr[Int] = Validated.valid(43)


  val modifiedValidated: ErrorsOr[Int] = aValidated.map(_ + 1)

  val validatedApplicative = Applicative[ErrorsOr]


  def productWithApplicatives[W[_], A, B](wa: W[A], wb: W[B])
                                         (implicit applicative: Applicative[W]): W[(A,B)] =
    {
      applicative.product(wa, wb)
    }
}
