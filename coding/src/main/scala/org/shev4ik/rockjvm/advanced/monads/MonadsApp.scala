package org.shev4ik.rockjvm.advanced.monads

import cats.instances.unit

import scala.language.higherKinds

object MonadsApp extends App {
  // 1. left-identity
  // 2. associativity
  // 3. right-identity

  val f: Int => List[Int] = List(_)
  List(1).flatMap(f)

  trait Attempt[+A] {
    def flatMap[B](f: A => Attempt[B]): Attempt[B]

  }
  object Attempt {
    def apply[A](a: => A): Attempt[A] =
      try {
        Success(a)
      } catch {
        case e: Throwable => Fail(e)
      }
  }
  case class Success[A](value: A) extends Attempt[A]{
    override def flatMap[B](f: A => Attempt[B]): Attempt[B] =
      try {
        f(value)
      } catch {
        case e: Throwable => Fail(e)
      }
  }

  case class Fail(e: Throwable) extends Attempt[Nothing] {
    override def flatMap[B](f: Nothing => Attempt[B]): Attempt[B] = this
  }

  val hashSet = new java.util.HashSet[Integer]()
}
