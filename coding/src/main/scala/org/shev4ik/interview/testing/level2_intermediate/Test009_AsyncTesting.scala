package org.shev4ik.interview.testing.level2_intermediate

import scala.concurrent.{Future, Promise, Await, ExecutionContext}
import scala.concurrent.duration._
import scala.util.{Try, Success, Failure}

/**
 * Test009 - Async Testing
 *
 * Testing Futures, timeouts, the eventually pattern,
 * and async assertion helpers.
 */
object Test009_AsyncTesting {

  implicit val ec: ExecutionContext = ExecutionContext.global

  // ==========================================================================
  // Exercise 1: Implement an async assertion helper
  // ==========================================================================
  // TODO: Implement `assertFutureEquals` that takes a Future[A] and an expected
  //       value. It should await the future (with a timeout) and assert equality.
  //       Return true if the value matches, throw AssertionError otherwise.
  //       If the future fails, throw AssertionError with the failure message.
  def assertFutureEquals[A](future: Future[A], expected: A, timeout: Duration = 5.seconds): Boolean = ???

  // ==========================================================================
  // Exercise 2: Implement assertFutureFailsWith
  // ==========================================================================
  // TODO: Implement `assertFutureFailsWith` that asserts a Future fails with
  //       a specific exception type. Return true if it fails with the expected type.
  //       Throw AssertionError if:
  //       - The future succeeds (message: "Expected failure but got success: [value]")
  //       - The future fails with wrong exception type
  import scala.reflect.ClassTag
  def assertFutureFailsWith[E <: Throwable : ClassTag](
    future: Future[Any],
    timeout: Duration = 5.seconds
  ): Boolean = ???

  // ==========================================================================
  // Exercise 3: Implement the "eventually" pattern
  // ==========================================================================
  // TODO: Implement `eventually` that retries a block until it succeeds or
  //       a timeout is reached. Parameters:
  //       - block: => A  (the assertion/check to retry)
  //       - timeout: Duration  (max time to keep trying)
  //       - interval: Duration  (wait between retries)
  //       Return the successful result, or throw the last exception if timed out.
  def eventually[A](
    timeout: Duration = 5.seconds,
    interval: Duration = 100.millis
  )(block: => A): A = ???

  // ==========================================================================
  // Exercise 4: Implement a Future sequence tester
  // ==========================================================================
  // TODO: Implement `assertAllSucceed` that takes a List[Future[A]] and asserts
  //       all complete successfully within a timeout. Return List[A] of results.
  //       Implement `assertAnySucceeds` that returns as soon as any one succeeds.
  //       Implement `assertNoneSucceed` that asserts ALL futures fail.
  def assertAllSucceed[A](futures: List[Future[A]], timeout: Duration = 5.seconds): List[A] = ???
  def assertAnySucceeds[A](futures: List[Future[A]], timeout: Duration = 5.seconds): A = ???
  def assertNoneSucceed(futures: List[Future[Any]], timeout: Duration = 5.seconds): Boolean = ???

  // ==========================================================================
  // Exercise 5: Implement an async test runner
  // ==========================================================================
  // TODO: Implement `runAsyncTest` that takes a test name and an async test body
  //       (=> Future[Unit]). It should:
  //       - Run the future
  //       - Await completion with timeout
  //       - Return AsyncTestResult(name, passed, durationMs, error)
  //       Implement `runAsyncSuite` that runs multiple async tests sequentially.
  case class AsyncTestResult(name: String, passed: Boolean, durationMs: Long, error: Option[String])

  def runAsyncTest(name: String, timeout: Duration = 5.seconds)(body: => Future[Unit]): AsyncTestResult = ???
  def runAsyncSuite(tests: List[(String, () => Future[Unit])], timeout: Duration = 5.seconds): List[AsyncTestResult] = ???

  // ==========================================================================
  // Exercise 6: Implement a promise-based test synchronizer
  // ==========================================================================
  // TODO: Implement `TestLatch` that helps synchronize async test steps:
  //       - await(timeout: Duration): Boolean  (blocks until released or timeout)
  //       - release(): Unit  (unblocks waiting threads)
  //       - isReleased: Boolean
  //       Implement `TestBarrier` that waits for N parties:
  //       - arrive(): Unit  (one party arrives)
  //       - awaitAll(timeout: Duration): Boolean  (waits until all parties arrived)
  class TestLatch {
    def await(timeout: Duration = 5.seconds): Boolean = ???
    def release(): Unit = ???
    def isReleased: Boolean = ???
  }

  class TestBarrier(parties: Int) {
    def arrive(): Unit = ???
    def awaitAll(timeout: Duration = 5.seconds): Boolean = ???
  }

  // ==========================================================================
  // Exercise 7: Implement async callback testing
  // ==========================================================================
  // TODO: Implement `CallbackCapture[A]` that captures async callback results:
  //       - callback: A => Unit  (the callback function to pass to async code)
  //       - awaitResult(timeout: Duration): A  (blocks until callback is invoked)
  //       - resultOption: Option[A]  (non-blocking check)
  //       - awaitN(n: Int, timeout: Duration): List[A]  (wait for N callbacks)
  class CallbackCapture[A] {
    def callback: A => Unit = ???
    def awaitResult(timeout: Duration = 5.seconds): A = ???
    def resultOption: Option[A] = ???
    def awaitN(n: Int, timeout: Duration = 5.seconds): List[A] = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a deterministic async scheduler for testing
  // ==========================================================================
  // TODO: Implement `TestScheduler` that allows manual control of async execution:
  //       - schedule(delay: Long)(task: => Unit): Unit  (schedule task at delay ms)
  //       - advanceTime(ms: Long): Unit  (advance virtual time, executing due tasks)
  //       - currentTime: Long  (virtual time in ms)
  //       - pendingCount: Int  (number of unexecuted tasks)
  //       - executeAll(): Unit  (execute all pending tasks regardless of time)
  class TestScheduler {
    def schedule(delay: Long)(task: => Unit): Unit = ???
    def advanceTime(ms: Long): Unit = ???
    def currentTime: Long = ???
    def pendingCount: Int = ???
    def executeAll(): Unit = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(assertFutureEquals(Future.successful(42), 42))
    assert(assertFutureEquals(Future { Thread.sleep(10); "hello" }, "hello"))
    var failedAsExpected = false
    try { assertFutureEquals(Future.successful(1), 2) }
    catch { case _: AssertionError => failedAsExpected = true }
    assert(failedAsExpected)
    println("Exercise 1 passed: assertFutureEquals works")

    // Exercise 2
    assert(assertFutureFailsWith[ArithmeticException](Future { 1 / 0 }))
    assert(assertFutureFailsWith[RuntimeException](Future.failed(new RuntimeException("boom"))))
    var successNotExpected = false
    try { assertFutureFailsWith[RuntimeException](Future.successful(42)) }
    catch { case _: AssertionError => successNotExpected = true }
    assert(successNotExpected)
    println("Exercise 2 passed: assertFutureFailsWith works")

    // Exercise 3
    var eventualCounter = 0
    val result = eventually(timeout = 2.seconds, interval = 50.millis) {
      eventualCounter += 1
      assert(eventualCounter >= 3)
      eventualCounter
    }
    assert(result >= 3)
    println("Exercise 3 passed: eventually pattern works")

    // Exercise 4
    val allResults = assertAllSucceed(List(
      Future(1), Future(2), Future(3)
    ))
    assert(allResults == List(1, 2, 3))
    val anyResult = assertAnySucceeds(List(
      Future { Thread.sleep(500); 1 },
      Future(2)
    ))
    assert(anyResult == 2 || anyResult == 1)
    println("Exercise 4 passed: Future sequence testing works")

    // Exercise 5
    val asyncResult = runAsyncTest("fast test") {
      Future { assert(1 + 1 == 2) }
    }
    assert(asyncResult.passed)
    val asyncFail = runAsyncTest("fail test") {
      Future { throw new RuntimeException("async fail") }
    }
    assert(!asyncFail.passed)
    println("Exercise 5 passed: async test runner works")

    // Exercise 6
    val latch = new TestLatch
    Future { Thread.sleep(50); latch.release() }
    assert(latch.await(2.seconds))
    assert(latch.isReleased)
    val barrier = new TestBarrier(2)
    Future { barrier.arrive() }
    Future { Thread.sleep(50); barrier.arrive() }
    assert(barrier.awaitAll(2.seconds))
    println("Exercise 6 passed: test synchronization works")

    // Exercise 7
    val capture = new CallbackCapture[String]
    Future { Thread.sleep(50); capture.callback("result!") }
    assert(capture.awaitResult(2.seconds) == "result!")
    println("Exercise 7 passed: callback capture works")

    // Exercise 8
    val scheduler = new TestScheduler
    var executed = List.empty[String]
    scheduler.schedule(100) { executed :+= "task1" }
    scheduler.schedule(200) { executed :+= "task2" }
    scheduler.schedule(150) { executed :+= "task3" }
    assert(scheduler.pendingCount == 3)
    scheduler.advanceTime(100)
    assert(executed == List("task1"))
    scheduler.advanceTime(100)
    assert(executed.contains("task2") && executed.contains("task3"))
    assert(scheduler.currentTime == 200)
    println("Exercise 8 passed: test scheduler works")

    println("\nAll Test009 exercises passed!")
  }
}
