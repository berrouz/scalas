package org.shev4ik.interview.scala_core.level3_advanced

object Core078_TypeclassCoherence {

  // Exercise 1: Coherence principle
  // TODO: Define an Ordering type class and demonstrate coherence:
  //       there should be exactly one Ordering[Int] in scope at any time
  trait MyOrdering[T] {
    def compare(a: T, b: T): Int
  }

  // TODO: Provide the canonical Ordering[Int] instance (natural ordering)
  implicit val intOrdering: MyOrdering[Int] = ???

  def sort[T](list: List[T])(implicit ord: MyOrdering[T]): List[T] = ???

  // Exercise 2: Orphan instances
  // TODO: Show how orphan instances (instances defined outside both the type class
  //       and the data type's companion) can break coherence.
  //       Define a case class Temp and its Show instance in the "wrong" place
  trait Show[T] {
    def show(t: T): String
  }

  case class Temperature(celsius: Double)

  // This is an "orphan" instance - not in Show companion or Temperature companion
  // TODO: Implement it (this demonstrates the anti-pattern)
  val orphanShowTemp: Show[Temperature] = ???

  // Exercise 3: Newtype for instances
  // TODO: Create a newtype wrapper to provide an alternative instance without breaking coherence
  //       For example, a ReverseInt that has reverse ordering
  case class ReverseInt(value: Int) extends AnyVal

  // TODO: Implement MyOrdering[ReverseInt] (reverse of natural Int ordering)
  implicit val reverseIntOrdering: MyOrdering[ReverseInt] = ???

  // Exercise 4: Instance priority
  // TODO: Define a low-priority default instance and a high-priority specific instance
  trait Describable[T] {
    def describe(t: T): String
  }

  trait LowPriorityDescribable {
    // TODO: Default instance for Any
    implicit def anyDescribable[T]: Describable[T] = ???
  }

  object Describable extends LowPriorityDescribable {
    // TODO: Higher-priority instance for String
    implicit val stringDescribable: Describable[String] = ???
  }

  def describe[T](t: T)(implicit d: Describable[T]): String = ???

  // Exercise 5: Global uniqueness
  // TODO: Demonstrate that type class instances should be globally unique per type
  //       Create a Semigroup type class and ensure one instance per type
  trait Semigroup[T] {
    def combine(a: T, b: T): T
  }

  object Semigroup {
    def apply[T](implicit s: Semigroup[T]): Semigroup[T] = s

    // TODO: Implement canonical Semigroup for Int (addition)
    implicit val intSemigroup: Semigroup[Int] = ???

    // TODO: Implement canonical Semigroup for String (concatenation)
    implicit val stringSemigroup: Semigroup[String] = ???
  }

  def combine[T: Semigroup](a: T, b: T): T = ???

  // Exercise 6: Lawful instances
  // TODO: Define laws for Semigroup (associativity) and provide a check method
  def checkAssociativity[T: Semigroup](a: T, b: T, c: T)(implicit eq: Equiv[T]): Boolean = ???

  // Exercise 7: Testing laws
  // TODO: Write a simple law test for Monoid (Semigroup + identity)
  trait Monoid[T] extends Semigroup[T] {
    def empty: T
  }

  object Monoid {
    def apply[T](implicit m: Monoid[T]): Monoid[T] = m

    // TODO: Implement Monoid for Int
    implicit val intMonoid: Monoid[Int] = ???

    // TODO: Implement Monoid for String
    implicit val stringMonoid: Monoid[String] = ???
  }

  // TODO: Implement identity law check: combine(a, empty) == a && combine(empty, a) == a
  def checkIdentityLaw[T](a: T)(implicit m: Monoid[T], eq: Equiv[T]): Boolean = ???

  // Exercise 8: Coherence vs flexibility (6 exercises for last file would be here,
  //             but this is not the last file, so we include 8)
  // TODO: Show how to provide "local" instances without breaking global coherence
  //       using implicit parameter shadowing
  def sortReversed(list: List[Int]): List[Int] = {
    // TODO: Use a locally-scoped implicit to reverse the sort order
    // without changing the global intOrdering
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(sort(List(3, 1, 2)) == List(1, 2, 3))

    // Exercise 2
    assert(orphanShowTemp.show(Temperature(100.0)).contains("100"))

    // Exercise 3
    val reversed = sort(List(ReverseInt(1), ReverseInt(3), ReverseInt(2)))
    assert(reversed == List(ReverseInt(3), ReverseInt(2), ReverseInt(1)))

    // Exercise 4
    assert(describe("hello") == "String: hello")
    assert(describe(42).contains("42"))

    // Exercise 5
    assert(combine(3, 4) == 7)
    assert(combine("hello", " world") == "hello world")

    // Exercise 6
    implicit val intEquiv: Equiv[Int] = Equiv.fromFunction(_ == _)
    implicit val strEquiv: Equiv[String] = Equiv.fromFunction(_ == _)
    assert(checkAssociativity(1, 2, 3))
    assert(checkAssociativity("a", "b", "c"))

    // Exercise 7
    assert(checkIdentityLaw(42))
    assert(checkIdentityLaw("hello"))

    // Exercise 8
    assert(sortReversed(List(1, 3, 2)) == List(3, 2, 1))

    println("All Core078_TypeclassCoherence exercises passed!")
  }
}
