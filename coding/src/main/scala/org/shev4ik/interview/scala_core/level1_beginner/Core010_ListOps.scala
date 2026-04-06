package org.shev4ik.interview.scala_core.level1_beginner

object Core010_ListOps {

  // Exercise 1: map
  // TODO: Given List("hello", "world", "scala"), use map to convert each to uppercase.
  //       Return the resulting list.
  def exercise1_map: List[String] = ???

  // Exercise 2: flatMap
  // TODO: Given List("hello world", "foo bar"), use flatMap to split each string by space
  //       and flatten into a single list of words: List("hello", "world", "foo", "bar").
  def exercise2_flatMap: List[String] = ???

  // Exercise 3: filter
  // TODO: Given List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), filter to keep only
  //       numbers divisible by 3. Return the result.
  def exercise3_filter: List[Int] = ???

  // Exercise 4: find
  // TODO: Given List(1, 2, 3, 4, 5), use find to locate the first element > 3.
  //       Return the Option result.
  def exercise4_find: Option[Int] = ???

  // Exercise 5: exists and forall
  // TODO: Given List(2, 4, 6, 8):
  //       Check if any element > 5 (exists), and check if all elements are even (forall).
  //       Return (existsResult, forallResult).
  def exercise5_existsForall: (Boolean, Boolean) = ???

  // Exercise 6: foldLeft
  // TODO: Use foldLeft to compute:
  //       1. The sum of List(1, 2, 3, 4, 5) starting from 0.
  //       2. The product of List(1, 2, 3, 4, 5) starting from 1.
  //       Return (sum, product).
  def exercise6_foldLeft: (Int, Int) = ???

  // Exercise 7: foldRight
  // TODO: Use foldRight to build a string from List("a", "b", "c"):
  //       Start with "" and prepend each element with a dash: "a-b-c-"
  //       i.e., List("a","b","c").foldRight("")((elem, acc) => elem + "-" + acc)
  //       Return the result.
  def exercise7_foldRight: String = ???

  // Exercise 8: Chaining operations
  // TODO: Given List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10):
  //       1. Filter even numbers
  //       2. Map each to its square
  //       3. Take the first 3
  //       Return the result.
  def exercise8_chaining: List[Int] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_map == List("HELLO", "WORLD", "SCALA"), "Exercise 1 failed")

    assert(exercise2_flatMap == List("hello", "world", "foo", "bar"), "Exercise 2 failed")

    assert(exercise3_filter == List(3, 6, 9), "Exercise 3 failed")

    assert(exercise4_find == Some(4), "Exercise 4 failed")

    assert(exercise5_existsForall == (true, true), "Exercise 5 failed")

    assert(exercise6_foldLeft == (15, 120), "Exercise 6 failed")

    assert(exercise7_foldRight == "a-b-c-", "Exercise 7 failed")

    assert(exercise8_chaining == List(4, 16, 36), "Exercise 8 failed")

    println("All Core010_ListOps exercises passed!")
  }
}
