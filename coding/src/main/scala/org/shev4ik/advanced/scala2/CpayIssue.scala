package org.shev4ik.advanced.scala2

import scala.language.{higherKinds, implicitConversions}

object CpayIssue extends App {


  trait Unwrap[T[_], R] {
    type Out

    def apply(tr: T[R]): Out
  }
  object Unwrap {
    implicit object listStringSize extends Unwrap[List, String] {
      type Out = Int
      def apply(tr: List[String]): Int = tr.size
    }

    implicit object listIntMax extends Unwrap[List, Int] {
      type Out = Int
      def apply(tr: List[Int]): Int = tr.max
    }

    implicit object optIntMax extends Unwrap[Option, Int] {
      type Out = Int

      def apply(tr: Option[Int]): Int = tr.max
    }

    type Ty[A] = Tuple2[A, A]

    implicit object soptIntMax extends Unwrap[Ty, Int] {
      type Out = Int

      def apply(tr: Ty[Int]): Int = tr._1
    }
  }

  trait Printer[T]{
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

  def extractor[T[_], R, Out](in: T[R])(implicit
    unwrap: UnwrapAux[T, R, Out]): Out = {
    unwrap(in)
  }

  println(extractor(List(1)))


}
