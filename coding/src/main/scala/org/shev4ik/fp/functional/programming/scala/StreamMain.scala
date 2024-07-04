package org.shev4ik.fp.functional.programming.scala

object StreamMain extends App {

  sealed trait Stream[+A] {
    def toList: List[A]

    def take(n: Int): Stream[A]

    def takeWhile(p: A => Boolean): Stream[A]

    def forAll(p: A => Boolean): Boolean
    def foldRight[B](z: => B)(f: (A, => B) => B): B
  }

  case object Empty extends Stream[Nothing] {
    override def toList: List[Nothing] = List.empty

    override def take(n: Int): Stream[Nothing] = Empty

    override def takeWhile(p: Nothing => Boolean): Stream[Nothing] = Empty

    override def forAll(p: Nothing => Boolean): Boolean = false

    def foldRight[B](z: => B)(f: (Nothing, => B) => B): B = z
  }

  case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A] {
    override def toList: List[A] = t() match {
      case Empty         => h() :: Nil
      case Cons(head, t) => h() :: head() :: t().toList
    }

    override def take(n: Int): Stream[A] = {
      if (n > 0)
        Stream.cons[A](h(), t().take(n - 1))
      else
        Stream.empty[A]
    }

    override def takeWhile(p: A => Boolean): Stream[A] = {
      foldRight(Stream.empty[A])((a, b) =>
        if (p(a))
          Cons(() => a, () => b)
        else
          Stream.empty[A]
      )
    }

    override def forAll(p: A => Boolean): Boolean = p(h()) && t().forAll(p)

    def foldRight[B](z: => B)(f: (A, => B) => B): B =
      this match {
        case Cons(h, t) => f(h(), t().foldRight(z)(f))
      }
  }

  object Stream {

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }

    def empty[A]: Stream[A] = Empty

    def apply[A](as: A*): Stream[A] = if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }

  println(Stream.cons(1, Stream.cons(2, Stream.cons(3, Empty))).takeWhile(x => x != 3).toList)
}
