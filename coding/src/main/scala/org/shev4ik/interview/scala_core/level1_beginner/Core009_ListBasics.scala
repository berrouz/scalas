package org.shev4ik.interview.scala_core.level1_beginner

object Core009_ListBasics {

  // Exercise 1: List creation
  // TODO: Create a List(1, 2, 3, 4, 5) and return it.
  def exercise1_listCreation: List[Int] = ???

  // Exercise 2: Nil and :: (cons)
  // TODO: Build the list List(1, 2, 3) using :: and Nil.
  //       i.e., 1 :: 2 :: 3 :: Nil
  def exercise2_consOperator: List[Int] = ???

  // Exercise 3: head and tail
  // TODO: Given List(10, 20, 30, 40), return (head, tail).
  //       head is 10, tail is List(20, 30, 40).
  def exercise3_headTail: (Int, List[Int]) = ???

  // Exercise 4: isEmpty
  // TODO: Return (List().isEmpty, List(1).isEmpty).
  //       Should be (true, false).
  def exercise4_isEmpty: (Boolean, Boolean) = ???

  // Exercise 5: length
  // TODO: Return the length of List("a", "b", "c", "d", "e").
  def exercise5_length: Int = ???

  // Exercise 6: take and drop
  // TODO: Given List(1, 2, 3, 4, 5):
  //       take the first 3 elements, and drop the first 3 elements.
  //       Return (taken, dropped).
  def exercise6_takeDrop: (List[Int], List[Int]) = ???

  // Exercise 7: slice
  // TODO: Given List(10, 20, 30, 40, 50), use .slice(1, 4) to get elements
  //       at indices 1, 2, 3 => List(20, 30, 40). Return it.
  def exercise7_slice: List[Int] = ???

  // Exercise 8: Prepend, append, and concatenation
  // TODO: Given List(2, 3, 4):
  //       Prepend 1 using :: => List(1, 2, 3, 4)
  //       Append 5 using :+ => List(2, 3, 4, 5)
  //       Concatenate List(1) ++ List(2, 3) ++ List(4, 5) => List(1, 2, 3, 4, 5)
  //       Return (prepended, appended, concatenated).
  def exercise8_prependAppendConcat: (List[Int], List[Int], List[Int]) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_listCreation == List(1, 2, 3, 4, 5), "Exercise 1 failed")

    assert(exercise2_consOperator == List(1, 2, 3), "Exercise 2 failed")

    val (head, tail) = exercise3_headTail
    assert(head == 10, "Exercise 3 failed: head")
    assert(tail == List(20, 30, 40), "Exercise 3 failed: tail")

    assert(exercise4_isEmpty == (true, false), "Exercise 4 failed")

    assert(exercise5_length == 5, "Exercise 5 failed")

    val (taken, dropped) = exercise6_takeDrop
    assert(taken == List(1, 2, 3), "Exercise 6 failed: take")
    assert(dropped == List(4, 5), "Exercise 6 failed: drop")

    assert(exercise7_slice == List(20, 30, 40), "Exercise 7 failed")

    val (prep, app, concat) = exercise8_prependAppendConcat
    assert(prep == List(1, 2, 3, 4), "Exercise 8 failed: prepend")
    assert(app == List(2, 3, 4, 5), "Exercise 8 failed: append")
    assert(concat == List(1, 2, 3, 4, 5), "Exercise 8 failed: concat")

    println("All Core009_ListBasics exercises passed!")
  }
}
