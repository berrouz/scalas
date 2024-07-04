package org.shev4ik.rockjvm.advanced.dark_syntax

object DarkSyntaxStyle extends App {

  // 2 0 single abstract method pattern (Since 2.10)

  trait Action {
    def act(x: Int): Int
  }

  val anAction = new Action {
    override def act(x: Int): Int = x + 1
  }

  val anotherOne: Action = (x: Int) => x + 1

  val aThread = new Thread(() => println(s"hi Scala from thread ${Thread.currentThread.getName}"))

  val aList = List(1,2,3)

  val aPrependedList = 0::aList

  val aThing = aList.::(0)


  val aBigList = {println(1); 1} :: { println(2); 2} :: Nil

  val aListAn = List(3,4).::(2).::(1).::(0)

  println(aListAn)


  class MyStream[T]{
    def -->:(value: T): MyStream[T] = this
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  case class Holder() {
    def update(i: Int, value: Int): Unit = println(s"updated $value")
  }

  Holder()(1) = 1
}
