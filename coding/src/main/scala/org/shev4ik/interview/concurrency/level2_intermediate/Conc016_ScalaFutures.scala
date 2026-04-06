package org.shev4ik.interview.concurrency.level2_intermediate

import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Success, Failure, Try}

object Conc016_ScalaFutures {

  implicit val ec: ExecutionContext = ExecutionContext.global

  // Exercise 1: Basic Future
  // TODO: Create a Future { 42 } using scala.concurrent.Future.
  //       Use Await.result with 5.seconds timeout to get the value. Return it.
  def exercise1_basicFuture(): Int = ???

  // Exercise 2: Future.map
  // TODO: Create a Future { 10 } and map it to multiply by 5.
  //       Await the result. Return it (should be 50).
  def exercise2_map(): Int = ???

  // Exercise 3: Future.flatMap
  // TODO: Create a Future { "hello" } and flatMap it to Future { s + " world" }.
  //       Await the result. Return it (should be "hello world").
  def exercise3_flatMap(): String = ???

  // Exercise 4: for-comprehension with Futures
  // TODO: Create Future { 10 } and Future { 20 }. Use a for-comprehension to add them.
  //       Await the result. Return it (should be 30).
  def exercise4_forComprehension(): Int = ???

  // Exercise 5: Future.recover
  // TODO: Create a Future[Int] { throw new RuntimeException("error") }.
  //       Use recover { case _: RuntimeException => -1 }.
  //       Await the result. Return it (should be -1).
  def exercise5_recover(): Int = ???

  // Exercise 6: Future.sequence
  // TODO: Create a List of Futures: List(Future(1), Future(2), Future(3)).
  //       Use Future.sequence to convert List[Future[Int]] to Future[List[Int]].
  //       Await the result and sum the list. Return it (should be 6).
  def exercise6_sequence(): Int = ???

  // Exercise 7: Promise
  // TODO: Create a Promise[String]. In a new thread (or Future), complete the promise
  //       with Success("promised-value"). Get the future from the promise.
  //       Await the result. Return it (should be "promised-value").
  def exercise7_promise(): String = ???

  // Exercise 8: Future.traverse
  // TODO: Use Future.traverse on List(1, 2, 3, 4, 5) with function i => Future(i * i).
  //       Await the result. Return the list (should be List(1, 4, 9, 16, 25)).
  def exercise8_traverse(): List[Int] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicFuture() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_map() == 50, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_flatMap() == "hello world", "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_forComprehension() == 30, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_recover() == -1, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_sequence() == 6, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_promise() == "promised-value", "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_traverse() == List(1, 4, 9, 16, 25), "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc016_ScalaFutures exercises passed!")
  }
}
