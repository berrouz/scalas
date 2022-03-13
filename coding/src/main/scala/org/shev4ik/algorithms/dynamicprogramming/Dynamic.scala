package org.shev4ik.algorithms.dynamicprogramming

import scala.collection.mutable

object Dynamic extends App {
  def fib(n: Long): Long = {
    val map = new mutable.HashMap[Long, Long]()

    def inner(nn: Long): Long = {
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

  println(fib(50))
}
