package org.shev4ik.interview.scala_core.level2_intermediate

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

object Core049_Promises {

  // Exercise 1: Promise creation
  // TODO: Create a Promise[Int], complete it with a value, and return its future
  def createAndComplete(value: Int): Future[Int] = ???

  // Exercise 2: success
  // TODO: Create a Promise, complete it successfully, and verify the future contains the value
  def promiseSuccess(): Future[String] = ???

  // Exercise 3: failure
  // TODO: Create a Promise, complete it with a failure, and return its future
  def promiseFailure(msg: String): Future[String] = ???

  // Exercise 4: future from promise
  // TODO: Use a Promise to create a Future that completes after a condition
  //       Simulate an async callback-based API by completing the promise from another thread
  def asyncCallback(): Future[String] = ???

  // Exercise 5: trySuccess
  // TODO: Demonstrate trySuccess - it returns false if the promise is already completed
  //       Complete a promise, then try to complete it again
  def demonstrateTrySuccess(): (Boolean, Boolean) = ???

  // Exercise 6: tryFailure
  // TODO: Demonstrate tryFailure - complete a promise with success first,
  //       then try to fail it (should return false)
  def demonstrateTryFailure(): (Boolean, Boolean) = ???

  // Exercise 7: completing from another future
  // TODO: Create a Promise and complete it with the result of another Future
  //       using promise.completeWith(future)
  def completeFromFuture(): Future[Int] = ???

  // Exercise 8: Promise as bridge
  // TODO: Use Promise as a bridge between callback-based and Future-based APIs
  //       Simulate a callback API: def fetchData(callback: Either[String, Int] => Unit): Unit
  //       Convert it to return a Future[Int]
  def fetchDataCallback(callback: Either[String, Int] => Unit): Unit = {
    // Simulates async callback with successful result
    Future {
      Thread.sleep(10)
      callback(Right(42))
    }
  }

  def fetchDataAsFuture(): Future[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(Await.result(createAndComplete(42), 5.seconds) == 42, "createAndComplete should return 42")

    // Exercise 2 assertions
    assert(Await.result(promiseSuccess(), 5.seconds) == "done", "promiseSuccess should return 'done'")

    // Exercise 3 assertions
    try {
      Await.result(promiseFailure("oops"), 5.seconds)
      assert(false, "should have thrown")
    } catch {
      case e: RuntimeException => assert(e.getMessage == "oops", "failure message should be 'oops'")
    }

    // Exercise 4 assertions
    val callbackResult = Await.result(asyncCallback(), 5.seconds)
    assert(callbackResult == "callback done", "asyncCallback should complete")

    // Exercise 5 assertions
    val (first, second) = demonstrateTrySuccess()
    assert(first, "first trySuccess should return true")
    assert(!second, "second trySuccess should return false")

    // Exercise 6 assertions
    val (successResult, failResult) = demonstrateTryFailure()
    assert(successResult, "trySuccess should return true")
    assert(!failResult, "tryFailure after success should return false")

    // Exercise 7 assertions
    val fromFuture = Await.result(completeFromFuture(), 5.seconds)
    assert(fromFuture == 100, "completeFromFuture should return 100")

    // Exercise 8 assertions
    val bridged = Await.result(fetchDataAsFuture(), 5.seconds)
    assert(bridged == 42, "fetchDataAsFuture should bridge callback to Future")

    println("All Core049_Promises exercises passed!")
  }
}
