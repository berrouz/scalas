package org.shev4ik.interview.concurrency.level3_advanced

import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Try, Success, Failure}
import scala.util.control.NonFatal

object Conc022_AdvancedScalaConc {

  implicit val ec: ExecutionContext = ExecutionContext.global

  // Exercise 1: Future.successful and Future.failed
  // TODO: Create a Future.successful(42) and a Future.failed(new RuntimeException("err")).
  //       Await the successful one. For the failed one, use recover to return -1.
  //       Return (successResult, failedRecovered) — should be (42, -1).
  def exercise1_successfulFailed(): (Int, Int) = ???

  // Exercise 2: Future.recoverWith
  // TODO: Create a Future[Int] { throw new IllegalArgumentException("bad") }.
  //       Use recoverWith { case _: IllegalArgumentException => Future.successful(99) }.
  //       Await the result. Return it (should be 99).
  def exercise2_recoverWith(): Int = ???

  // Exercise 3: Future.transform
  // TODO: Create a Future { 10 }. Use transform to modify both success and failure:
  //       On success: multiply by 3. On failure: return -1.
  //       Await the result. Return it (should be 30).
  def exercise3_transform(): Int = ???

  // Exercise 4: Future.fallbackTo
  // TODO: Create a failed Future[String] { throw new RuntimeException("primary failed") }.
  //       Use fallbackTo(Future.successful("fallback-value")).
  //       Await the result. Return it (should be "fallback-value").
  def exercise4_fallbackTo(): String = ???

  // Exercise 5: NonFatal pattern matching
  // TODO: Implement a function safeDivide(a: Int, b: Int): Either[String, Int] that:
  //       - tries a / b
  //       - catches NonFatal exceptions and returns Left(exception.getMessage)
  //       - returns Right(result) on success
  //       Test: safeDivide(10, 2) should be Right(5), safeDivide(10, 0) should be Left("/ by zero").
  //       Return (safeDivide(10, 2), safeDivide(10, 0)).
  def exercise5_nonFatal(): (Either[String, Int], Either[String, Int]) = ???

  // Exercise 6: blocking construct
  // TODO: Use scala.concurrent.blocking { } to wrap a blocking operation inside a Future.
  //       Create a Future { blocking { Thread.sleep(10); 42 } }.
  //       Await the result. Return it (should be 42).
  //       Note: blocking hints the ExecutionContext to potentially expand the thread pool.
  def exercise6_blocking(): Int = ???

  // Exercise 7: Custom ExecutionContext
  // TODO: Create a custom ExecutionContext from a fixed thread pool with 2 threads:
  //       ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2)).
  //       Run a Future { 100 }(customEc). Await the result.
  //       Shutdown the custom EC. Return the result (should be 100).
  def exercise7_customExecutionContext(): Int = ???

  // Exercise 8: Promise with tryComplete and tryFailure
  // TODO: Create a Promise[Int]. Try to complete it with Success(42) — should return true.
  //       Try to complete it again with Success(99) — should return false (already completed).
  //       Await the promise's future. Return (firstTry, secondTry, value) — should be (true, false, 42).
  def exercise8_promiseTryComplete(): (Boolean, Boolean, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_successfulFailed() == (42, -1), "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_recoverWith() == 99, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_transform() == 30, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_fallbackTo() == "fallback-value", "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_nonFatal() == (Right(5), Left("/ by zero")), "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_blocking() == 42, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_customExecutionContext() == 100, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_promiseTryComplete() == (true, false, 42), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc022_AdvancedScalaConc exercises passed!")
  }
}
