package org.shev4ik.rockjvm.data_manipulation

import cats.Eval

object Evaluation extends App {

  def defer[T](eval: => Eval[T]): Eval[T] = Eval.later().flatMap(_ => eval)

  println(defer(Eval.now {
    println("now")
    41
  }))

  def reverseList[T](list: List[T]): List[T] = {
    if (list.isEmpty) list
    else reverseList(list.tail) :+ list.head
  }


  def reverse[T](list: List[T]): Eval[List[T]] = {
    if (list.isEmpty) Eval.now(list)
    else
      defer(reverse(list.tail).map(l => l :+ list.head))
  }

  println(reverse(50000.until(0).by(-1).toList).value)


}
