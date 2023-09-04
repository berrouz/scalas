package org.shev4ik.rockjvm.lists

import scala.annotation.tailrec

sealed abstract class RList[+T] {
  def head: T

  def tail: RList[T]

  def isEmpty: Boolean

  def ::[S >: T](s: S): RList[S] = new ::(s, this)

  def apply(index: Int): T

  def length: Int

  def reverse: RList[T]

  def ++[S >: T](anotherList: RList[S]): RList[S]

  def map[S](f: T => S): RList[S]

  def flatMap[S](f: T => RList[S]): RList[S]

  def rle: RList[(T, Int)]

  def duplicateEach(k: Int): RList[T]

  def rotate(k: Int): RList[T]

  def insertionSort[S >: T](implicit ordering: Ordering[S]): RList[S]

  def mergeSort[S >: T](implicit ordering: Ordering[S]): RList[S]

  def quickSort[S >: T](implicit ordering: Ordering[S]): RList[S]

  def splitAt(n: Int): (RList[T], RList[T])
}

case object RNil extends RList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: RList[Nothing] = RNil

  override def isEmpty: Boolean = true

  override def apply(index: Int): Nothing = throw new NoSuchElementException

  override def length: Int = 0

  override def reverse: RList[Nothing] = this

  override def ++[S >: Nothing](anotherList: RList[S]): RList[S] = anotherList

  override def map[S](f: Nothing => S): RList[S] = this

  override def flatMap[S](f: Nothing => RList[S]): RList[S] = this

  override def rle: RList[(Nothing, Int)] = this

  override def duplicateEach(k: Int): RList[Nothing] = RNil

  override def rotate(k: Int): RList[Nothing] = RNil

  override def insertionSort[S >: Nothing](implicit ordering: Ordering[S]): RList[S] = RNil

  override def mergeSort[S](implicit ordering: Ordering[S]): RList[S] = this

  override def quickSort[S](implicit ordering: Ordering[S]): RList[S] = this

  override def splitAt(n: Int): (RList[Nothing], RList[Nothing]) = (RNil, RNil)
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def toString: String = {
    @tailrec
    def toStringTailrec(remaining: RList[T], result: String): String = {
      if (remaining.isEmpty) result
      else if (remaining.tail.isEmpty) s"$result${remaining.head}"
      else toStringTailrec(remaining.tail, s"$result${remaining.head},")
    }

    "[" + toStringTailrec(this, "") + "]"
  }

  override def apply(index: Int): T = {
    @tailrec
    def rec(remaining: RList[T], counter: Int): T = {
      remaining match {
        case RNil => throw new NoSuchElementException
        case h :: tail =>
          if (counter == index) {
            h
          } else {
            rec(tail, counter + 1)
          }
      }
    }

    rec(head :: tail, 0)
  }

  override def length: Int = {
    @tailrec
    def lengthRecursive(list: RList[T], counter: Int): Int = {
      list match {
        case RNil      => counter
        case _ :: tail => lengthRecursive(list.tail, counter + 1)
      }
    }

    lengthRecursive(head :: tail, 0)
  }

  override def reverse: RList[T] = {
    @tailrec
    def reverseRecursive(remain: RList[T], acc: RList[T]): RList[T] = {
      remain match {
        case RNil      => acc
        case h :: tail => reverseRecursive(tail, h :: acc)
      }
    }

    reverseRecursive(head :: tail, RNil)
  }

  override def ++[S >: T](anotherList: RList[S]): RList[S] = {
    @tailrec
    def rec(another: RList[S], acc: RList[S]): RList[S] = {
      another match {
        case RNil      => acc
        case h :: tail => rec(tail, h :: acc)
      }
    }

    rec(this.reverse, anotherList)
  }

  override def map[S](f: T => S): RList[S] = {
    @tailrec
    def rec(rest: RList[T], result: RList[S]): RList[S] = {
      rest match {
        case RNil   => result
        case h :: t => rec(t, f(h) :: result)
      }
    }

    rec(this, RNil).reverse
  }

  override def flatMap[S](f: T => RList[S]): RList[S] = {
    @tailrec
    def inner(rest: RList[T], result: RList[S]): RList[S] = {
      rest match {
        case RNil   => result
        case h :: t => inner(t, f(h) ++ result)
      }
    }

    inner(this, RNil)
  }

  override def rle: RList[(T, Int)] = {
    @tailrec
    def inner(rest: RList[T], current: (T, Int), result: RList[(T, Int)]): RList[(T, Int)] = {
      if (rest.isEmpty && current._2 == 0) result
      else if (rest.isEmpty) current :: result
      else if (rest.head == current._1) inner(rest.tail, current.copy(_2 = current._2 + 1), result)
      else inner(rest.tail, (rest.head, 1), current :: result)
    }

    inner(this, (head, 0), RNil)
  }

  override def duplicateEach(k: Int): RList[T] = {
    def inner(rest: RList[T], times: Int, result: RList[T]): RList[T] = {
      rest match {
        case RNil => result
        case h :: tail =>
          if (times > 0) {
            inner(rest, times - 1, h :: result)
          } else
            inner(tail, k, result)
      }
    }

    inner(this, k, RNil).reverse
  }

  override def rotate(k: Int): RList[T] = {
    @tailrec
    def loop(rest: RList[T], counter: Int, left: RList[T], right: RList[T]): RList[T] = {
      rest match {
        case RNil => left ++ right
        case h :: t =>
          if (counter < k) {
            loop(t, counter + 1, h :: left, right)
          } else
            loop(t, counter + 1, left, h :: right)
      }
    }

    loop(this, 0, RNil, RNil).reverse
  }

  override def insertionSort[S >: T](implicit ordering: Ordering[S]): RList[S] = {
    @tailrec
    def loop(rest: RList[S], result: RList[S]): RList[S] = {
      rest match {
        case RNil         => result
        case head :: tail => loop(tail, insert(head, RNil, result))
      }
    }

    loop(this, RNil)
  }

  def splitAt(n: Int): (RList[T], RList[T]) = {
    def inner(first: RList[T], second: RList[T], counter: Int): (RList[T], RList[T]) = {
      if (counter == n) {
        (first, second)
      } else {
        inner(second.head :: first, second.tail, counter + 1)
      }
    }
    inner(RNil, this, 0)
  }

  override def mergeSort[S >: T](implicit ordering: Ordering[S]): RList[S] = {
    def merge(listA: RList[S], listB: RList[S]): RList[S] = {
      (listA, listB) match {
        case (RNil, b) => b
        case (a, RNil) => a
        case (headA :: tailA, headB :: tailB) =>
          if (ordering.lt(headA, headB)) {
            headA :: merge(tailA, listB)
          } else {
            headB :: merge(tailB, listA)
          }
      }
    }

    val size = this.length / 2
    if (size == 0) {
      this
    } else {
      val (a, b) = splitAt(size)
      merge(a.mergeSort(ordering), b.mergeSort(ordering))
    }
  }

  override def quickSort[S](implicit ordering: Ordering[S]): RList[S] = {
    ???
  }

  /*
   *   3 [1,2,4] []
   *     [2,4] [1]
   *     [4]   [1,2]
   *     []   [1,2,3,4]
   * */
  @tailrec
  final def insert[S](elem: S, before: RList[S], after: RList[S])(implicit
      ordering: Ordering[S]
  ): RList[S] = {
    if (after.isEmpty || ordering.lteq(elem, after.head)) {
      before.reverse ++ (elem :: after)
    } else
      insert(elem, after.head :: before, after.tail)
  }

}

// 3 -> 1 -> 2
/*
 *  1 -> 2   RList(3)
 *  2    RList(1::3::2)
 * */
object ListProblems extends App {
  val list =
    1 :: 2 :: 3 :: 1 :: 2 :: 3 :: 1 :: 2 :: 3 :: 1 :: 2 :: 3 :: 1 :: 2 :: 3 :: 1 :: 2 :: 3 :: 1 :: 2 :: 3 :: RNil
  val simple = 1 :: 2 :: 3 :: RNil

  // println(list(-1))
  // println(list.length)
  // println(list.reverse)
  // println(list.++(4::5::6::RNil))
  // println(list.map(_*2))
  // println(list.flatMap(s => s::2::3::RNil))
  // println(list.rle)
  // println(simple.duplicateEach(3))
  // println(( 0:: simple).rotate(2))
  // println(unsorted.insertionSort(Ordering.Int))
  // println(insert(3, 1::RNil)(Ordering.Int))
  // ((1::3::2::30::4::RNil).insertionSort(Ordering.Int))
  // println(unsorted.insertionSort(Ordering.Int))
  println((2 :: 5 :: 2 :: 1 :: 3 :: RNil).mergeSort(Ordering.Int))

  List(1, 2, 3).sorted
}
