package org.shev4ik.coding.arrays

import scala.annotation.tailrec

object ConsList extends App {

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f)) }

  def foldRightR[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldLeft(xs, z)((a,b) => f(b,a))) }

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  def foldLeftR[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldRight(xs, z)((a,b) => f(b,a))
  }

  def map[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => map(xs, f(z, x))(f)
  }

  def reverse[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => map(xs, f(z, x))(f)
  }

  object List {
    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }

  //println(foldLeft(List(1,2,3), Nil: List[Int])((b,a) => Cons(a*2, b)))

  def append[B, A <:B](b: B, res: List[A]): List[B] = {
    foldLeft(Nil: List[B], Nil: List[B])((list,_) => Cons(b, list))
  }

  println(foldRightR(List(1,2,3), Nil: List[Int])((b,a) => Cons(b*2, a)))
  println(append(4, List(1,2,3)))

}
