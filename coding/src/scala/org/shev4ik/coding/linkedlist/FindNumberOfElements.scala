package org.shev4ik.coding.linkedlist

object FindNumberOfElements extends App {
  def size(l: List[Int]): Int = {
    def inner(l: List[Int], sum: Int): Int = {
      l match {
        case _ :: t ⇒ inner(t, sum + 1)
        case Nil ⇒ sum
      }
    }
    inner(l, 0)
  }
  Some(size(1 :: 2 :: 3 :: Nil)) foreach println
}

object FindNumberOfElementsFold extends App {
  def sizeFoldLeft(l: List[Int]): Int = l.foldRight(0) { (_, b) ⇒
    b + 1
  }
  def sizeFoldRight(l: List[Int]): Int = l.foldRight(0) { (_, b) ⇒
    b + 1
  }

  Some(sizeFoldLeft(1 :: 2 :: 3 :: Nil)) foreach println
  Some(sizeFoldRight(1 :: 2 :: 3 :: Nil)) foreach println
}
