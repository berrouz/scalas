package org.shev4ik.fp.functional.programming.scala

import scala.util.Try

object OptionDataType extends App {

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A,B) => C): Option[C] = for {
    aVal <- a
    bVal <- b
  } yield f(aVal,bVal)

  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    a.foldLeft[Option[List[A]]](Some(List.empty))((x,y) => if (y.isEmpty) None else x.map(list => list :+ y.head))
  }

  def traverse[A,B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a.foldLeft[Option[List[B]]](Some(List.empty))( (acc, elem) => if (f(elem).isEmpty) None else acc.map(list => list :+ f(elem).head))
  }

  println(sequence(List(Some(1), Some(3), None)))
  println(traverse(List("1", "2", ""))( e => Try(e.toInt).toOption))
}
