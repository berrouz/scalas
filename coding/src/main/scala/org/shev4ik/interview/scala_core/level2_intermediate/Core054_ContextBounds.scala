package org.shev4ik.interview.scala_core.level2_intermediate

object Core054_ContextBounds {

  // Exercise 1: Context bound syntax
  // TODO: Write a method `max` using context bound syntax [A: Ordering]
  //       that returns the maximum of two values
  def max[A: Ordering](a: A, b: A): A = ???

  // Exercise 2: Desugaring to implicit
  // TODO: Write the same `max` method WITHOUT context bounds,
  //       using an explicit implicit parameter instead
  //       This is what the compiler desugars context bounds to
  def maxDesugared[A](a: A, b: A)(implicit ord: Ordering[A]): A = ???

  // Exercise 3: Multiple context bounds
  // TODO: Write a method that requires both Ordering and Show (custom) for A
  //       def showSorted[A: Ordering: Show](list: List[A]): List[String]
  trait Show[A] {
    def show(a: A): String
  }
  object Show {
    def apply[A](implicit s: Show[A]): Show[A] = s
    implicit val intShow: Show[Int] = new Show[Int] { def show(a: Int): String = a.toString }
    implicit val stringShow: Show[String] = new Show[String] { def show(a: String): String = a }
  }

  def showSorted[A: Ordering: Show](list: List[A]): List[String] = ???

  // Exercise 4: implicitly access
  // TODO: Use `implicitly[Ordering[A]]` inside a context-bounded method
  //       to access the implicit instance. Implement `isSorted` for a List[A].
  def isSorted[A: Ordering](list: List[A]): Boolean = ???

  // Exercise 5: Context bound with type class
  // TODO: Define a type class Semigroup[A] with combine(a: A, b: A): A
  //       Use context bound to write combineAll[A: Semigroup](list: List[A], zero: A): A
  trait Semigroup[A] {
    def combine(a: A, b: A): A
  }
  object Semigroup {
    implicit val intSemigroup: Semigroup[Int] = ???
    implicit val stringSemigroup: Semigroup[String] = ???
  }

  def combineAll[A: Semigroup](list: List[A], zero: A): A = ???

  // Exercise 6: Context bound vs implicit param
  // TODO: Show when you NEED an explicit implicit parameter instead of context bound:
  //       when you need to name the parameter to call methods on it directly.
  //       Write both versions of a sort method.
  def sortWithContextBound[A: Ordering](list: List[A]): List[A] = ???
  def sortWithImplicitParam[A](list: List[A])(implicit ord: Ordering[A]): List[A] = ???

  // Exercise 7: Summoner pattern
  // TODO: Create a type class Encoder[A] with encode(a: A): String
  //       Add a companion object with apply[A](implicit e: Encoder[A]): Encoder[A]
  //       This "summoner" pattern lets you write Encoder[Int] instead of implicitly[Encoder[Int]]
  trait Encoder[A] {
    def encode(a: A): String
  }
  object Encoder {
    def apply[A](implicit e: Encoder[A]): Encoder[A] = ???

    implicit val intEncoder: Encoder[Int] = ???
    implicit val stringEncoder: Encoder[String] = ???
    implicit val boolEncoder: Encoder[Boolean] = ???
  }

  def encode[A: Encoder](a: A): String = ???

  // Exercise 8: Context bound in practice
  // TODO: Implement a generic method `topN` that returns the top N elements from a list
  //       using context bound for Ordering
  def topN[A: Ordering](list: List[A], n: Int): List[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(max(3, 5) == 5, "max(3, 5) should be 5")
    assert(max("apple", "banana") == "banana", "max strings")

    // Exercise 2 assertions
    assert(maxDesugared(3, 5) == 5, "maxDesugared(3, 5) should be 5")

    // Exercise 3 assertions
    assert(showSorted(List(3, 1, 2)) == List("1", "2", "3"), "showSorted ints")

    // Exercise 4 assertions
    assert(isSorted(List(1, 2, 3, 4)), "1,2,3,4 is sorted")
    assert(!isSorted(List(1, 3, 2, 4)), "1,3,2,4 is not sorted")
    assert(isSorted(List.empty[Int]), "empty list is sorted")
    assert(isSorted(List(1)), "single element is sorted")

    // Exercise 5 assertions
    assert(combineAll(List(1, 2, 3, 4), 0) == 10, "combineAll ints")
    assert(combineAll(List("a", "b", "c"), "") == "abc", "combineAll strings")

    // Exercise 6 assertions
    assert(sortWithContextBound(List(3, 1, 2)) == List(1, 2, 3), "sort with context bound")
    assert(sortWithImplicitParam(List(3, 1, 2)) == List(1, 2, 3), "sort with implicit param")

    // Exercise 7 assertions
    assert(Encoder[Int].encode(42) == "42", "summoner pattern for Int")
    assert(encode(42) == "42", "encode via context bound")
    assert(encode("hello") == "hello", "encode string")
    assert(encode(true) == "true", "encode boolean")

    // Exercise 8 assertions
    assert(topN(List(5, 3, 8, 1, 9, 2), 3) == List(9, 8, 5), "top 3 elements")
    assert(topN(List(1, 2), 5) == List(2, 1), "topN with n > list size")

    println("All Core054_ContextBounds exercises passed!")
  }
}
