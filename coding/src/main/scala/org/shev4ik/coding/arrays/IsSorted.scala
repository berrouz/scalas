package org.shev4ik.coding.arrays

import scala.annotation.tailrec

object IsSorted extends App {

  def isSorted[A](arr: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def inner(list: List[A]): Boolean = {
      list match {
        case _ :: Nil | Nil          => true
        case first :: second :: tail => if (ordered(first, second)) inner(second :: tail) else false
      }
    }

    inner(arr.toList)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  def compose[A, B, C](f: B => C, g: A => B): A => C = f.compose(g)

}
