package org.shev4ik.interview.scala_core.level2_intermediate

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object Core047_Futures {

  // Exercise 1: Future.apply
  // TODO: Create a Future that computes the sum of numbers from 1 to n
  def asyncSum(n: Int): Future[Int] = ???

  // Exercise 2: map
  // TODO: Given a Future[Int], map it to a Future[String] by converting the int to a string
  //       prefixed with "Result: "
  def formatResult(f: Future[Int]): Future[String] = ???

  // Exercise 3: flatMap
  // TODO: Given a userId, first fetch the user name (Future[String]),
  //       then fetch the user's score (Future[Int]) based on the name
  //       Chain these with flatMap
  def fetchUserName(userId: Int): Future[String] = ???
  def fetchUserScore(name: String): Future[Int] = ???
  def fetchUserScoreById(userId: Int): Future[Int] = ???

  // Exercise 4: recover
  // TODO: Create a Future that might fail, and recover from the failure
  //       If the future fails with an exception, recover to a default value of -1
  def riskyComputation(fail: Boolean): Future[Int] = ???
  def safeComputation(fail: Boolean): Future[Int] = ???

  // Exercise 5: recoverWith
  // TODO: Similar to recover, but recoverWith returns a Future
  //       If primary computation fails, fall back to a backup computation
  def primaryComputation(): Future[Int] = ???
  def backupComputation(): Future[Int] = ???
  def withFallback(): Future[Int] = ???

  // Exercise 6: fallbackTo
  // TODO: Use fallbackTo to provide an alternative Future if the first one fails
  def unreliable(): Future[String] = ???
  def reliable(): Future[String] = ???
  def withFallbackTo(): Future[String] = ???

  // Exercise 7: zip
  // TODO: Zip two independent Futures together to get a Future of a tuple
  //       Compute name and age in parallel, then combine
  def getName(): Future[String] = ???
  def getAge(): Future[Int] = ???
  def getNameAndAge(): Future[(String, Int)] = ???

  // Exercise 8: firstCompletedOf
  // TODO: Race two Futures and return whichever completes first
  //       Create two futures with different delays, return the faster one
  def fast(): Future[String] = ???
  def slow(): Future[String] = ???
  def race(): Future[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(Await.result(asyncSum(10), 5.seconds) == 55, "asyncSum(10) should be 55")

    // Exercise 2 assertions
    val formatted = Await.result(formatResult(Future.successful(42)), 5.seconds)
    assert(formatted == "Result: 42", "formatResult should prefix with 'Result: '")

    // Exercise 3 assertions
    val score = Await.result(fetchUserScoreById(1), 5.seconds)
    assert(score > 0, "fetchUserScoreById should return positive score")

    // Exercise 4 assertions
    assert(Await.result(safeComputation(false), 5.seconds) > 0, "safe computation should succeed")
    assert(Await.result(safeComputation(true), 5.seconds) == -1, "safe computation should recover to -1")

    // Exercise 5 assertions
    val fallback = Await.result(withFallback(), 5.seconds)
    assert(fallback > 0, "withFallback should return positive value")

    // Exercise 6 assertions
    val result = Await.result(withFallbackTo(), 5.seconds)
    assert(result.nonEmpty, "withFallbackTo should return a string")

    // Exercise 7 assertions
    val (name, age) = Await.result(getNameAndAge(), 5.seconds)
    assert(name.nonEmpty && age > 0, "getNameAndAge should return valid tuple")

    // Exercise 8 assertions
    val winner = Await.result(race(), 5.seconds)
    assert(winner == "fast", "race should return the fast future's result")

    println("All Core047_Futures exercises passed!")
  }
}
