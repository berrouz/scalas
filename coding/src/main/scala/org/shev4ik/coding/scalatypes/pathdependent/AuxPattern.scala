package org.shev4ik.coding.scalatypes.pathdependent

import enumeratum.{Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

import scala.collection.immutable.IndexedSeq

sealed trait UserStatus extends EnumEntry with Snakecase

case object UserStatus extends Enum[UserStatus] {
  case object Active                   extends UserStatus
  case object IncorrectOtpBlocked      extends UserStatus
  case object IncorrectPasswordBlocked extends UserStatus
  case object PasswordRecoveryBlocked  extends UserStatus

  val values: IndexedSeq[UserStatus] = findValues
}

object AuxPattern extends App {

  trait Foo[A] {
    type B
    def body(b: B): String
  }

  implicit def fs = new Foo[String] {
    type B = Boolean
    def body(b: B): String = b.toString
  }

  implicit def generalF[T]() = new Foo[T] {
    type B = T
    def body(b: B): String = b.toString
  }

  trait Template[TT] {
    type T = TT
    def body(t: T): String
  }

  implicit def ttt = new Template[Boolean] {
    override type T = Boolean
    override def body(t: T): String = t.toString
  }
  type Aux[T, R] = Foo[T] { type B = R }

}
