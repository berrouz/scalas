package org.shev4ik.interview.scala_core.level1_beginner

object Core018_Either {

  // Exercise 1: Left and Right
  // TODO: Create a Right[String, Int](42) and a Left[String, Int]("error").
  //       Return (rightValue, leftValue).
  def exercise1_leftRight: (Either[String, Int], Either[String, Int]) = ???

  // Exercise 2: Either.cond
  // TODO: Use Either.cond to create an Either:
  //       Either.cond(test, right, left) => if test is true, Right(right), else Left(left).
  //       Create one with condition true (Right(42)) and one with false (Left("error")).
  //       Return (trueResult, falseResult).
  def exercise2_eitherCond: (Either[String, Int], Either[String, Int]) = ???

  // Exercise 3: map and flatMap
  // TODO: Given Right(10): Either[String, Int], use map to double it => Right(20).
  //       Given Left("error"): Either[String, Int], use map to double it => Left("error") (unchanged).
  //       Return (mappedRight, mappedLeft).
  def exercise3_mapFlatMap: (Either[String, Int], Either[String, Int]) = ???

  // Exercise 4: fold
  // TODO: Use fold to handle both cases of Either[String, Int]:
  //       Right(42).fold(l => s"Error: $l", r => s"Value: $r") => "Value: 42"
  //       Left("oops").fold(l => s"Error: $l", r => s"Value: $r") => "Error: oops"
  //       Return (rightFolded, leftFolded).
  def exercise4_fold: (String, String) = ???

  // Exercise 5: getOrElse
  // TODO: Use getOrElse to extract value or provide default:
  //       Right(42).getOrElse(0) => 42
  //       Left("error").getOrElse(0) => 0
  //       Return (rightResult, leftResult).
  def exercise5_getOrElse: (Int, Int) = ???

  // Exercise 6: swap
  // TODO: Use swap to switch Left and Right:
  //       Right(42).swap => Left(42)
  //       Left("error").swap => Right("error")
  //       Return (swappedRight, swappedLeft).
  def exercise6_swap: (Either[Int, String], Either[Int, String]) = ???

  // Exercise 7: toOption
  // TODO: Convert Either to Option:
  //       Right(42).toOption => Some(42)
  //       Left("error").toOption => None
  //       Return (rightToOption, leftToOption).
  def exercise7_toOption: (Option[Int], Option[Int]) = ???

  // Exercise 8: Either in for-comprehensions
  // TODO: Use a for-comprehension to chain Either operations:
  //       def parseInt(s: String): Either[String, Int] =
  //         try Right(s.toInt) catch { case _: Exception => Left(s"Invalid: $s") }
  //       Compute: for { a <- parseInt("10"); b <- parseInt("20") } yield a + b
  //       Also: for { a <- parseInt("10"); b <- parseInt("abc") } yield a + b
  //       Return (successResult, failureResult).
  def exercise8_forComprehension: (Either[String, Int], Either[String, Int]) = ???

  def main(args: Array[String]): Unit = {
    val (r, l) = exercise1_leftRight
    assert(r == Right(42), "Exercise 1 failed: right")
    assert(l == Left("error"), "Exercise 1 failed: left")

    val (tr, fr) = exercise2_eitherCond
    assert(tr == Right(42), "Exercise 2 failed: true")
    assert(fr == Left("error"), "Exercise 2 failed: false")

    val (mr, ml) = exercise3_mapFlatMap
    assert(mr == Right(20), "Exercise 3 failed: mapped right")
    assert(ml == Left("error"), "Exercise 3 failed: mapped left")

    assert(exercise4_fold == ("Value: 42", "Error: oops"), "Exercise 4 failed")

    assert(exercise5_getOrElse == (42, 0), "Exercise 5 failed")

    val (sr, sl) = exercise6_swap
    assert(sr == Left(42), "Exercise 6 failed: swap right")
    assert(sl == Right("error"), "Exercise 6 failed: swap left")

    val (ro, lo) = exercise7_toOption
    assert(ro == Some(42), "Exercise 7 failed: right to option")
    assert(lo == None, "Exercise 7 failed: left to option")

    val (suc, fail) = exercise8_forComprehension
    assert(suc == Right(30), "Exercise 8 failed: success")
    assert(fail.isLeft, "Exercise 8 failed: failure should be Left")

    println("All Core018_Either exercises passed!")
  }
}
