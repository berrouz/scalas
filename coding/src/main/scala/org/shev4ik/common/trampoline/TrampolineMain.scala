package org.shev4ik.common.trampoline

object TrampolineMain extends App {

  def even[A](lst: List[A]): Trampoline[Boolean] = {
    lst match {
      case Nil => Done(true)
      case x :: xs => More(() => odd(xs))
    }
  }

  def odd[A](lst: List[A]): Trampoline[Boolean] = {
    lst match {
      case Nil => Done(false)
      case x :: xs => More( () => even(xs))
    }
  }

  println(run(even((0 to 100000).toList)))

  def run[A](trampoline: Trampoline[A]): A ={
    trampoline match {
      case Done(value) => value
      case More(more) => run(more())
    }
  }

  sealed trait Trampoline[A]

  case class Done[A](value: A) extends Trampoline[A]
  case class More[A](call: () => Trampoline[A]) extends Trampoline[A]
}
