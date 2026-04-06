package org.shev4ik.interview.scala_core.level2_intermediate

object Core034_UpperLowerBounds {

  // Exercise 1: Upper bound <:
  // TODO: Implement a method `findMin` that takes a List[A] where A is a subtype of Ordered[A]
  //       and returns the minimum element wrapped in Option
  def findMin[A <: Ordered[A]](list: List[A]): Option[A] = ???

  // Exercise 2: Lower bound >:
  // TODO: Implement a method `prepend` on a simple immutable list node
  //       that uses a lower bound so you can prepend a supertype element
  sealed trait MyList[+A] {
    // TODO: B >: A ensures we can add supertypes
    def prepend[B >: A](elem: B): MyList[B] = ???
  }
  case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]
  case object Empty extends MyList[Nothing]

  // Exercise 3: Combined bounds
  // TODO: Implement a method `clamp` that takes a value, min, and max
  //       where A must be both Ordered[A] and Serializable
  //       Returns the value clamped between min and max
  def clamp[A <: Ordered[A] with Serializable](value: A, min: A, max: A): A = ???

  // Exercise 4: Context bound
  // TODO: Implement `sortAndTake` using a context bound for Ordering
  //       Takes a List[A] and n: Int, returns the first n elements when sorted
  def sortAndTake[A: Ordering](list: List[A], n: Int): List[A] = ???

  // Exercise 5: View bound (deprecated note)
  // TODO: Implement `toStrings` that converts a List[A] to List[String]
  //       Note: View bounds (A <% B) are deprecated in Scala 2.13
  //       Use an implicit conversion parameter instead
  //       def toStrings[A](list: List[A])(implicit conv: A => String): List[String]
  def toStrings[A](list: List[A])(implicit conv: A => String): List[String] = ???

  // Exercise 6: Bound with multiple types
  // TODO: Implement a method `process` where A must be a subtype of both
  //       Comparable[A] and Cloneable. For testing, just require Comparable[A].
  //       Return the larger of two values.
  def process[A <: Comparable[A]](a: A, b: A): A = ???

  // Exercise 7: Bounds in method
  // TODO: Implement a generic method `insertSorted` that inserts an element
  //       into an already sorted list, keeping it sorted. Use Ordering context bound.
  def insertSorted[A: Ordering](list: List[A], elem: A): List[A] = ???

  // Exercise 8: Bounds in class
  // TODO: Create a class SortedCollection[A: Ordering] that maintains elements
  //       in sorted order. Implement add(elem: A) and toList.
  class SortedCollection[A: Ordering] private(elements: List[A]) {
    def add(elem: A): SortedCollection[A] = ???
    def toList: List[A] = ???
    def size: Int = ???
  }
  object SortedCollection {
    def empty[A: Ordering]: SortedCollection[A] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    // Using a wrapper since basic types don't extend Ordered directly in tests
    case class OrdInt(value: Int) extends Ordered[OrdInt] {
      def compare(that: OrdInt): Int = this.value.compare(that.value)
    }
    assert(findMin(List(OrdInt(3), OrdInt(1), OrdInt(2))) == Some(OrdInt(1)), "findMin should return smallest")
    assert(findMin(List.empty[OrdInt]) == None, "findMin of empty list should be None")

    // Exercise 2 assertions
    val myList: MyList[Int] = Cons(2, Cons(3, Empty))
    val prepended = myList.prepend(1)
    assert(prepended.isInstanceOf[Cons[_]], "prepend should create a Cons")
    assert(prepended.asInstanceOf[Cons[Int]].head == 1, "prepended head should be 1")

    // Exercise 3 assertions
    case class OrdSerInt(value: Int) extends Ordered[OrdSerInt] with Serializable {
      def compare(that: OrdSerInt): Int = this.value.compare(that.value)
    }
    assert(clamp(OrdSerInt(5), OrdSerInt(1), OrdSerInt(10)) == OrdSerInt(5), "5 clamped to [1,10] = 5")
    assert(clamp(OrdSerInt(0), OrdSerInt(1), OrdSerInt(10)) == OrdSerInt(1), "0 clamped to [1,10] = 1")
    assert(clamp(OrdSerInt(15), OrdSerInt(1), OrdSerInt(10)) == OrdSerInt(10), "15 clamped to [1,10] = 10")

    // Exercise 4 assertions
    assert(sortAndTake(List(5, 3, 1, 4, 2), 3) == List(1, 2, 3), "sortAndTake should return first 3 sorted")

    // Exercise 5 assertions
    implicit val intToString: Int => String = _.toString
    assert(toStrings(List(1, 2, 3)) == List("1", "2", "3"), "toStrings should convert ints")

    // Exercise 6 assertions
    assert(process("apple", "banana") == "banana", "process should return larger string")
    assert(process("zebra", "apple") == "zebra", "process should return larger string")

    // Exercise 7 assertions
    assert(insertSorted(List(1, 3, 5), 4) == List(1, 3, 4, 5), "insertSorted should maintain order")
    assert(insertSorted(List(1, 3, 5), 0) == List(0, 1, 3, 5), "insertSorted at beginning")
    assert(insertSorted(List(1, 3, 5), 6) == List(1, 3, 5, 6), "insertSorted at end")

    // Exercise 8 assertions
    val sc = SortedCollection.empty[Int].add(3).add(1).add(2)
    assert(sc.toList == List(1, 2, 3), "SortedCollection should maintain sorted order")
    assert(sc.size == 3, "SortedCollection should have 3 elements")

    println("All Core034_UpperLowerBounds exercises passed!")
  }
}
