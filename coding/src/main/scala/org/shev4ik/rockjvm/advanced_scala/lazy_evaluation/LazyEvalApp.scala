package org.shev4ik.rockjvm.advanced_scala.lazy_evaluation

import scala.collection.immutable.List.empty

object LazyEvalApp extends App {

  // lazy eval delays the evaluation of values
  lazy val x: Int = {
    println("hello")
    1
  }


  // example of implications

  def sideEffectCondition: Boolean = {
    println("Boo")
    true
  }

  def simpleCondition: Boolean = false

  lazy val lazyCondition = sideEffectCondition

  //println(if (simpleCondition && lazyCondition) "yes" else "no")

  // in conjunction with call by name

  def byNameMethod(n: => Int): Int = n + n + n + 1

  lazy val retrieveMagicValue: Int = {
    // side effect or
    Thread.sleep(1000)
    42
  }

  // println(byNameMethod(retrieveMagicValue))


  List(1,2,3).withFilter(_%2 == 0)


  abstract class MyStream[+A] {
    def isEmpty: Boolean
    def head: A
    def tail: MyStream[A]

    def #::[B >: A](element: B): MyStream[B]

    def ++[B >: A](anotherStream: MyStream[B]): MyStream[B]
    def foreach(f: A => Unit): Unit

    def map[B](f: A => B): MyStream[B]
    def flatMap[B](f: A => MyStream[B]): MyStream[B]
    def filter(predicate: A => Boolean): MyStream[A]

    def take(n: Int): MyStream[A]

    def takeAsList(n: Int): List[A]


    object MyStream {
      def from[A](start: A)(generator: A => A): MyStream[A] = ???
    }

    object EmptyStream extends MyStream[Nothing]{

      override def isEmpty: Boolean = true

      override def head: Nothing = throw new RuntimeException()

      override def tail: MyStream[Nothing] = throw new RuntimeException()

      override def #::[B >: Nothing](element: B): MyStream[B] = new Cons(element, this)

      override def ++[B >: Nothing](anotherStream: MyStream[B]): MyStream[B] = anotherStream

      override def foreach(f: Nothing => Unit): Unit = ()

      override def map[B](f: Nothing => B): MyStream[B] = this

      override def flatMap[B](f: Nothing => MyStream[B]): MyStream[B] = this

      override def filter(predicate: Nothing => Boolean): MyStream[Nothing] = this

      override def take(n: Int): MyStream[Nothing] = this

      override def takeAsList(n: Int): List[Nothing] = empty[Nothing]
    }

    class Cons[+A](h: A, tl: => MyStream[A]) extends MyStream[A]{

      override def isEmpty: Boolean = false

      override def head: A = h

      override def tail: MyStream[A] = tl

      override def #::[B >: A](element: B): MyStream[B] = new Cons(element, this)

      override def ++[B >: A](anotherStream: MyStream[B]): MyStream[B] = new Cons(head, tl ++ anotherStream)

      override def foreach(f: A => Unit): Unit = {
        f(head)
        tl.foreach(f)
      }

      override def map[B](f: A => B): MyStream[B] = {
        new Cons(f(head), tl.map(f))
      }

      override def flatMap[B](f: A => MyStream[B]): MyStream[B] = {
        f(head) ++ tail.flatMap(f)
      }

      override def filter(predicate: A => Boolean): MyStream[A] = {
        if (predicate(head)){
          new Cons(head, tl.filter(predicate))
        } else tl.filter(predicate)
      }

      override def take(n: Int): MyStream[A] = {
        if (n <= 0) EmptyStream else new Cons(head, tail.take(n-1))
      }

      override def takeAsList(n: Int): List[A] = ???
    }
  }


}
