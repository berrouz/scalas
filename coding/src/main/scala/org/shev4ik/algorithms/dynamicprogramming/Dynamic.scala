package org.shev4ik.algorithms.dynamicprogramming

import scala.collection.mutable

object Dynamic extends App {
  def fib(n: Int): Int = {
    val map = new mutable.HashMap[Int, Int]()

    def inner(nn: Int): Int = {
      val rr = map.get(nn)
      rr.getOrElse(nn match {
        case 0 | 1 => 1
        case _ =>
          val r = inner(nn - 1) + inner(nn - 2)
          map.put(nn, r) match {
            case Some(_) =>
            case None =>
          }
          r
      })
    }
    inner(n-1)
  }

  println(fib(11))
}
