package org.shev4ik.interview.scala_core.level1_beginner

object Core012_ForComprehensions {

  // Exercise 1: Basic for/yield
  // TODO: Use for/yield to generate a list of squares from 1 to 5.
  //       List(1, 4, 9, 16, 25)
  def exercise1_basicForYield: List[Int] = ???

  // Exercise 2: Nested for
  // TODO: Use nested generators in a for/yield to generate all pairs (i, j)
  //       where i <- 1 to 3 and j <- 1 to 3 and i != j.
  //       Return as a List of tuples.
  def exercise2_nestedFor: List[(Int, Int)] = ???

  // Exercise 3: For with guard (if)
  // TODO: Use for/yield with a guard to get all even numbers from 1 to 20.
  //       Return as a List.
  def exercise3_withGuard: List[Int] = ???

  // Exercise 4: For with pattern matching
  // TODO: Given a list of tuples List(("a", 1), ("b", 2), ("c", 3)),
  //       use for/yield with pattern matching to extract and format as "a=1", "b=2", "c=3".
  def exercise4_withPatternMatch: List[String] = ???

  // Exercise 5: Multiple generators
  // TODO: Use for/yield with multiple generators to compute a multiplication table.
  //       For i <- 1 to 3, j <- 1 to 3, yield (i, j, i*j).
  //       Return as List of (Int, Int, Int).
  def exercise5_multipleGenerators: List[(Int, Int, Int)] = ???

  // Exercise 6: Desugaring to map/flatMap
  // TODO: Rewrite this for-comprehension using explicit map/flatMap:
  //       for { x <- List(1, 2, 3); y <- List(10, 20) } yield x + y
  //       Write it as: List(1,2,3).flatMap(x => List(10,20).map(y => x + y))
  //       Return the result.
  def exercise6_desugaring: List[Int] = ???

  // Exercise 7: For with Option
  // TODO: Use a for-comprehension to combine two Options:
  //       val a = Some(3); val b = Some(4)
  //       for { x <- a; y <- b } yield x + y
  //       Also try with val c: Option[Int] = None mixed in.
  //       Return (someResult, noneResult).
  def exercise7_forWithOption: (Option[Int], Option[Int]) = ???

  // Exercise 8: For with Either
  // TODO: Use a for-comprehension with Either[String, Int]:
  //       val a: Either[String, Int] = Right(10)
  //       val b: Either[String, Int] = Right(20)
  //       for { x <- a; y <- b } yield x + y
  //       Also try with Left("error") mixed in.
  //       Return (rightResult, leftResult).
  def exercise8_forWithEither: (Either[String, Int], Either[String, Int]) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicForYield == List(1, 4, 9, 16, 25), "Exercise 1 failed")

    val nested = exercise2_nestedFor
    assert(nested.length == 6, "Exercise 2 failed: length")
    assert(nested.contains((1, 2)), "Exercise 2 failed: (1,2)")
    assert(!nested.contains((1, 1)), "Exercise 2 failed: no (1,1)")

    assert(exercise3_withGuard == List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20), "Exercise 3 failed")

    assert(exercise4_withPatternMatch == List("a=1", "b=2", "c=3"), "Exercise 4 failed")

    assert(exercise5_multipleGenerators.length == 9, "Exercise 5 failed: length")
    assert(exercise5_multipleGenerators.contains((2, 3, 6)), "Exercise 5 failed: (2,3,6)")

    assert(exercise6_desugaring == List(11, 21, 12, 22, 13, 23), "Exercise 6 failed")

    val (someR, noneR) = exercise7_forWithOption
    assert(someR == Some(7), "Exercise 7 failed: some")
    assert(noneR == None, "Exercise 7 failed: none")

    val (rightR, leftR) = exercise8_forWithEither
    assert(rightR == Right(30), "Exercise 8 failed: right")
    assert(leftR.isLeft, "Exercise 8 failed: left")

    println("All Core012_ForComprehensions exercises passed!")
  }
}
