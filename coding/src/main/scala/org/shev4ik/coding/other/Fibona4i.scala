package org.shev4ik.coding.other

object Fibona4i extends App {
  Some(fib(10)) foreach println
  def fib(n: Int): Int = {
    def inner(n: Int, prev: Int, next: Int): Int = {
      n match {
        case 0 | 1 ⇒ next
        case _ ⇒ inner(n - 1, next, prev + next)
      }
    }
    inner(n, 0, 1)
  }
}
