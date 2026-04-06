package org.shev4ik.interview.scala_core.level2_intermediate

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Core048_FutureComposition {

  // Exercise 1: Future.sequence
  // TODO: Convert a List[Future[Int]] to a Future[List[Int]]
  //       using Future.sequence
  def combineAll(futures: List[Future[Int]]): Future[List[Int]] = ???

  // Exercise 2: Future.traverse
  // TODO: Given a List[Int], apply an async function to each element
  //       and collect results using Future.traverse
  def asyncDouble(n: Int): Future[Int] = ???
  def doubleAll(nums: List[Int]): Future[List[Int]] = ???

  // Exercise 3: for-comprehension
  // TODO: Use a for-comprehension to combine three Futures:
  //       fetch a name, fetch an age, fetch a city
  //       Return a formatted string "name (age) from city"
  def fetchName(): Future[String] = ???
  def fetchAge(): Future[Int] = ???
  def fetchCity(): Future[String] = ???
  def fetchProfile(): Future[String] = ???

  // Exercise 4: andThen
  // TODO: Use andThen to perform a side effect (logging) without affecting the result
  //       Return the Future with a side effect that records to a var
  var sideEffectLog: String = ""
  def computeWithLogging(n: Int): Future[Int] = ???

  // Exercise 5: transform
  // TODO: Use transform to convert a Future[Int] to a Future[String]
  //       On success: "ok: $value", on failure: "error: $message"
  def transformResult(f: Future[Int]): Future[String] = ???

  // Exercise 6: transformWith
  // TODO: Use transformWith to chain a Future based on its result
  //       If the Future succeeds with n > 0, return Future(n * 2)
  //       If it fails or n <= 0, return Future(0)
  def doubleIfPositive(f: Future[Int]): Future[Int] = ???

  // Exercise 7: Future.unit
  // TODO: Use Future.unit (a pre-completed Future[Unit]) as a starting point
  //       Chain operations using flatMap to build a computation
  def startFromUnit(): Future[String] = ???

  // Exercise 8: Future.never
  // TODO: Demonstrate Future.never - a Future that never completes
  //       Use it with Future.firstCompletedOf to show that the other Future wins
  def neverVsImmediate(): Future[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val futures = List(Future(1), Future(2), Future(3))
    assert(Await.result(combineAll(futures), 5.seconds) == List(1, 2, 3), "sequence should combine futures")

    // Exercise 2 assertions
    assert(Await.result(doubleAll(List(1, 2, 3)), 5.seconds) == List(2, 4, 6), "traverse should double all")

    // Exercise 3 assertions
    val profile = Await.result(fetchProfile(), 5.seconds)
    assert(profile.nonEmpty, "fetchProfile should return non-empty string")
    assert(profile.contains("from"), "profile should contain 'from'")

    // Exercise 4 assertions
    sideEffectLog = ""
    val result4 = Await.result(computeWithLogging(42), 5.seconds)
    assert(result4 == 42, "andThen should not change the result")
    Thread.sleep(100) // give andThen time to execute
    assert(sideEffectLog.nonEmpty, "andThen should have executed side effect")

    // Exercise 5 assertions
    val ok = Await.result(transformResult(Future.successful(42)), 5.seconds)
    assert(ok == "ok: 42", "transform success")
    val err = Await.result(transformResult(Future.failed(new RuntimeException("boom"))), 5.seconds)
    assert(err == "error: boom", "transform failure")

    // Exercise 6 assertions
    assert(Await.result(doubleIfPositive(Future.successful(5)), 5.seconds) == 10, "double positive")
    assert(Await.result(doubleIfPositive(Future.successful(-1)), 5.seconds) == 0, "zero for negative")
    assert(Await.result(doubleIfPositive(Future.failed(new Exception)), 5.seconds) == 0, "zero for failure")

    // Exercise 7 assertions
    val fromUnit = Await.result(startFromUnit(), 5.seconds)
    assert(fromUnit.nonEmpty, "startFromUnit should produce a string")

    // Exercise 8 assertions
    val winner = Await.result(neverVsImmediate(), 5.seconds)
    assert(winner == "immediate", "immediate should win over never")

    println("All Core048_FutureComposition exercises passed!")
  }
}
