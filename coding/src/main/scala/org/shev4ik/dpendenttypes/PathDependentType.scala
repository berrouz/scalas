package org.shev4ik.dpendenttypes

import scala.language.higherKinds

object PathDependentType extends App {

  trait Unwrap[T[_], R] {
    type Out
    def apply(tr: T[R]): Out
  }


  object Unwrap {
    implicit def list[S]: Unwrap[List, S] = new  Unwrap[List, S] {
      type Out = S
      def apply(tr: List[Out]): Out = tr.head
    }
  }

  trait Printer[T] {
    def apply(t: T): (String, T)
  }

  object Printer {
    implicit object stringPrinter extends Printer[String] {
      def apply(s: String): (String, String) = ("String: " + s, s)
    }

    implicit object intPrinter extends Printer[Int] {
      def apply(i: Int): (String, Int) = ("Int: " + i, i)
    }
  }

  trait UnwrapAux[T[_], R, Out] {
    def apply(tr: T[R]): Out
  }

  object UnwrapAux {
    implicit object listStringSize extends UnwrapAux[List, String, Int] {
      def apply(tr: List[String]): Int = tr.size
    }

    implicit object listIntMax extends UnwrapAux[List, Int, Int] {
      def apply(tr: List[Int]): Int = tr.max
    }
  }
  def extractorX[T[_], R](in: T[R])(
    implicit
    unwrap: Unwrap[T, R]
  ): unwrap.Out = {
    unwrap(in)
  }

  def ex[A](list: List[A]): A = {
    list.head
  }

/*  println(extractorX(List(2)))
  println(extractorX(List("a")))
  println(extractorX(List('a')))
  println(ex(List('a')))
  println(ex(List(1)))*/

  def extractor[T[_], R, Out](in: T[R])(
    implicit
    unwrap: UnwrapAux[T, R, Out],
    withPrinter: Printer[Out]
  ): (String, Out) = {
    withPrinter(unwrap(in))
  }


  println(extractor(List(1)))

}
