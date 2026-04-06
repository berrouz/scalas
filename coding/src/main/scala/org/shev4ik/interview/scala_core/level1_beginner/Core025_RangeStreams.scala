package org.shev4ik.interview.scala_core.level1_beginner

object Core025_RangeStreams {

  // Exercise 1: Range with `to` (inclusive)
  // TODO: Create a Range from 1 to 5 (inclusive) using `1 to 5`.
  //       Return it as a List.
  def exercise1_rangeTo: List[Int] = ???

  // Exercise 2: Range with `until` (exclusive)
  // TODO: Create a Range from 1 until 5 (exclusive) using `1 until 5`.
  //       Return it as a List.
  def exercise2_rangeUntil: List[Int] = ???

  // Exercise 3: Range with `by` (step)
  // TODO: Create a Range from 0 to 20 by 5: (0 to 20 by 5).
  //       Also create a reverse range: (10 to 1 by -2).
  //       Return (forward.toList, reverse.toList).
  def exercise3_rangeBy: (List[Int], List[Int]) = ???

  // Exercise 4: Stream basics (deprecated in 2.13, but good to know)
  // TODO: In Scala 2.13, Stream is deprecated in favor of LazyList.
  //       Create Stream(1, 2, 3) and convert to List. Return the list.
  //       Note: Use #:: for cons in Stream.
  def exercise4_streamBasics: List[Int] = ???

  // Exercise 5: LazyList (Scala 2.13+)
  // TODO: Create a LazyList from 1 to infinity: LazyList.from(1).
  //       Take the first 10 elements and return as a List.
  def exercise5_lazyList: List[Int] = ???

  // Exercise 6: LazyList.iterate
  // TODO: Use LazyList.iterate to create a sequence where each element is double the previous.
  //       Start with 1: LazyList.iterate(1)(_ * 2)
  //       Take the first 8 elements and return as a List.
  //       Expected: List(1, 2, 4, 8, 16, 32, 64, 128)
  def exercise6_iterate: List[Int] = ???

  // Exercise 7: LazyList.unfold
  // TODO: Use LazyList.unfold to generate Fibonacci numbers.
  //       LazyList.unfold((0, 1)) { case (a, b) => Some((a, (b, a + b))) }
  //       Take the first 10 and return as a List.
  def exercise7_unfold: List[Int] = ???

  // Exercise 8: Range operations
  // TODO: Given the range 1 to 100:
  //       1. Filter even numbers
  //       2. Take the first 5
  //       3. Sum them
  //       Return the sum. (2 + 4 + 6 + 8 + 10 = 30)
  def exercise8_rangeOps: Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_rangeTo == List(1, 2, 3, 4, 5), "Exercise 1 failed")

    assert(exercise2_rangeUntil == List(1, 2, 3, 4), "Exercise 2 failed")

    val (forward, reverse) = exercise3_rangeBy
    assert(forward == List(0, 5, 10, 15, 20), "Exercise 3 failed: forward")
    assert(reverse == List(10, 8, 6, 4, 2), "Exercise 3 failed: reverse")

    assert(exercise4_streamBasics == List(1, 2, 3), "Exercise 4 failed")

    assert(exercise5_lazyList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), "Exercise 5 failed")

    assert(exercise6_iterate == List(1, 2, 4, 8, 16, 32, 64, 128), "Exercise 6 failed")

    assert(exercise7_unfold == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), "Exercise 7 failed")

    assert(exercise8_rangeOps == 30, "Exercise 8 failed")

    println("All Core025_RangeStreams exercises passed!")
  }
}
