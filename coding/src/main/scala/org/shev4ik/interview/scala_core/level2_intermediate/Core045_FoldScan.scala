package org.shev4ik.interview.scala_core.level2_intermediate

object Core045_FoldScan {

  // Exercise 1: foldLeft sum/product
  // TODO: Implement sum and product using foldLeft (not using built-in sum/product)
  def sum(list: List[Int]): Int = ???
  def product(list: List[Int]): Int = ???

  // Exercise 2: foldLeft reverse
  // TODO: Implement List reverse using foldLeft
  def reverse[A](list: List[A]): List[A] = ???

  // Exercise 3: foldRight
  // TODO: Implement a method that converts a List[Int] to a String
  //       using foldRight, joining elements with " :: " and ending with "Nil"
  //       Example: List(1,2,3) => "1 :: 2 :: 3 :: Nil"
  def listToString(list: List[Int]): String = ???

  // Exercise 4: foldLeft vs foldRight
  // TODO: Implement flatten (List[List[A]] => List[A]) using:
  //       a) foldLeft  b) foldRight
  //       Note: foldLeft is tail-recursive (stack-safe), foldRight is not
  def flattenLeft[A](lists: List[List[A]]): List[A] = ???
  def flattenRight[A](lists: List[List[A]]): List[A] = ???

  // Exercise 5: scanLeft
  // TODO: Use scanLeft to compute running sum of a list
  //       List(1, 2, 3, 4) => List(0, 1, 3, 6, 10)
  def runningSum(list: List[Int]): List[Int] = ???

  // Exercise 6: scanRight
  // TODO: Use scanRight to compute running product from right
  //       List(1, 2, 3, 4) => List(24, 24, 12, 4, 1)
  def runningProductRight(list: List[Int]): List[Int] = ???

  // Exercise 7: reduce vs fold
  // TODO: Implement max using reduce (throws on empty) and fold-based (returns Option)
  //       reduceMax should throw on empty list
  //       foldMax should return None on empty list
  def reduceMax(list: List[Int]): Int = ???
  def foldMax(list: List[Int]): Option[Int] = ???

  // Exercise 8: aggregate
  // TODO: Use aggregate to compute both sum and count in parallel-ready fashion
  //       Return (sum, count) for a list of integers
  //       aggregate takes: zero, seqOp, combOp
  def sumAndCount(list: List[Int]): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(sum(List(1, 2, 3, 4, 5)) == 15, "sum of 1-5")
    assert(sum(Nil) == 0, "sum of empty")
    assert(product(List(1, 2, 3, 4)) == 24, "product of 1-4")
    assert(product(Nil) == 1, "product of empty")

    // Exercise 2 assertions
    assert(reverse(List(1, 2, 3)) == List(3, 2, 1), "reverse 1,2,3")
    assert(reverse(Nil) == Nil, "reverse empty")

    // Exercise 3 assertions
    assert(listToString(List(1, 2, 3)) == "1 :: 2 :: 3 :: Nil", "listToString")
    assert(listToString(Nil) == "Nil", "listToString empty")

    // Exercise 4 assertions
    assert(flattenLeft(List(List(1, 2), List(3), List(4, 5))) == List(1, 2, 3, 4, 5), "flattenLeft")
    assert(flattenRight(List(List(1, 2), List(3), List(4, 5))) == List(1, 2, 3, 4, 5), "flattenRight")

    // Exercise 5 assertions
    assert(runningSum(List(1, 2, 3, 4)) == List(0, 1, 3, 6, 10), "runningSum")

    // Exercise 6 assertions
    assert(runningProductRight(List(1, 2, 3, 4)) == List(24, 24, 12, 4, 1), "runningProductRight")

    // Exercise 7 assertions
    assert(reduceMax(List(3, 1, 4, 1, 5)) == 5, "reduceMax")
    assert(foldMax(List(3, 1, 4, 1, 5)) == Some(5), "foldMax non-empty")
    assert(foldMax(Nil) == None, "foldMax empty")
    try {
      reduceMax(Nil)
      assert(false, "reduceMax should throw on empty")
    } catch {
      case _: UnsupportedOperationException => // expected
    }

    // Exercise 8 assertions
    assert(sumAndCount(List(10, 20, 30)) == (60, 3), "sumAndCount")
    assert(sumAndCount(Nil) == (0, 0), "sumAndCount empty")

    println("All Core045_FoldScan exercises passed!")
  }
}
