package org.shev4ik.interview.scala_core.level1_beginner

import scala.util.{Try, Success, Failure}

object Core019_Try {

  // Exercise 1: Try, Success, Failure
  // TODO: Wrap a computation in Try:
  //       Try("42".toInt) => Success(42)
  //       Try("abc".toInt) => Failure(NumberFormatException)
  //       Return (successTry.isSuccess, failureTry.isFailure).
  def exercise1_tryBasics: (Boolean, Boolean) = ???

  // Exercise 2: map and flatMap on Try
  // TODO: Given Try(10), use map to double it => Success(20).
  //       Given Try(10), use flatMap to safely divide by 0:
  //       flatMap(x => Try(x / 0)) => Failure(ArithmeticException)
  //       Return (mapped.isSuccess, flatMapped.isFailure).
  def exercise2_mapFlatMap: (Boolean, Boolean) = ???

  // Exercise 3: recover
  // TODO: Given a failed Try, use recover to provide a fallback:
  //       Try("abc".toInt).recover { case _: NumberFormatException => 0 }
  //       Return the recovered value.
  def exercise3_recover: Try[Int] = ???

  // Exercise 4: recoverWith
  // TODO: Given a failed Try, use recoverWith to try an alternative computation:
  //       Try("abc".toInt).recoverWith { case _: NumberFormatException => Try("42".toInt) }
  //       Return the recovered Try.
  def exercise4_recoverWith: Try[Int] = ???

  // Exercise 5: getOrElse
  // TODO: Use getOrElse on Try:
  //       Success(42).getOrElse(0) => 42
  //       Failure(new Exception("oops")).getOrElse(0) => 0
  //       Return (successResult, failureResult).
  def exercise5_getOrElse: (Int, Int) = ???

  // Exercise 6: toOption
  // TODO: Convert Try to Option:
  //       Success(42).toOption => Some(42)
  //       Try("abc".toInt).toOption => None
  //       Return (successOption, failureOption).
  def exercise6_toOption: (Option[Int], Option[Int]) = ???

  // Exercise 7: toEither
  // TODO: Convert Try to Either:
  //       Success(42).toEither => Right(42)
  //       Try("abc".toInt).toEither.left.map(_.getMessage) should contain the error message
  //       Return (successEither.isRight, failureEither.isLeft).
  def exercise7_toEither: (Boolean, Boolean) = ???

  // Exercise 8: Try in for-comprehensions
  // TODO: Use a for-comprehension to chain Try operations:
  //       for { a <- Try("10".toInt); b <- Try("20".toInt) } yield a + b
  //       Also: for { a <- Try("10".toInt); b <- Try("abc".toInt) } yield a + b
  //       Return (successResult, failureResult.isFailure).
  def exercise8_forComprehension: (Try[Int], Boolean) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_tryBasics == (true, true), "Exercise 1 failed")

    assert(exercise2_mapFlatMap == (true, true), "Exercise 2 failed")

    assert(exercise3_recover == Success(0), "Exercise 3 failed")

    assert(exercise4_recoverWith == Success(42), "Exercise 4 failed")

    assert(exercise5_getOrElse == (42, 0), "Exercise 5 failed")

    val (so, fo) = exercise6_toOption
    assert(so == Some(42), "Exercise 6 failed: success")
    assert(fo == None, "Exercise 6 failed: failure")

    assert(exercise7_toEither == (true, true), "Exercise 7 failed")

    val (sr, fr) = exercise8_forComprehension
    assert(sr == Success(30), "Exercise 8 failed: success")
    assert(fr, "Exercise 8 failed: failure")

    println("All Core019_Try exercises passed!")
  }
}
