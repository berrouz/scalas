package org.shev4ik.coding.scalatypes.pathdependent

object OrderingPathDependent extends App {

  trait Comparator[T] {
    def ordering: Ordering[T]
    def compare(a: T, b: T): Int = ordering.compare(a, b)
  }

  object IntComparator extends Comparator[Int] {
    def ordering: Ordering[Int] = Ordering.Int
  }

  // def process[T: Comparator](items: Seq[T]): Int = 1

  def process[T: Comparator](items: Seq[T]): Int = 1
}
