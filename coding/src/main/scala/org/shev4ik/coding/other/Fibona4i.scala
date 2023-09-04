package org.shev4ik.coding.other

object Fibona4i extends App {
  Some(fibona4i(10)) foreach println

  def fib(n: Int): Int = {
    def inner(n: Int, prev: Int, next: Int): Int = {
      n match {
        case 0 | 1 ⇒ next
        case _     ⇒ inner(n - 1, next, prev + next)
      }
    }
    inner(n, 0, 1)
  }

  def fibona4i(i: Long): Long = {
    val map = scala.collection.mutable.Map[Long, Long]()
    def fib(n: Long): Long = {
      if (map.contains(n)) {
        map(n)
      } else {
        if (n <= 2)
          1
        else {
          val calculated = fib(n - 1) + fib(n - 2)
          map += (n -> calculated)
          calculated
        }
      }
    }
    fib(i)
  }

}
