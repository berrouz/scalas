package org.shev4ik.interview.testing.level2_intermediate

/**
 * Test014 - Error Testing
 *
 * Testing error paths, boundary conditions, edge cases,
 * and building utilities for thorough error scenario coverage.
 */
object Test014_ErrorTesting {

  // ==========================================================================
  // Exercise 1: Implement a boundary value test generator
  // ==========================================================================
  // TODO: Implement `BoundaryValues` that generates test inputs at boundaries:
  //       - forInt(min: Int, max: Int): List[Int]
  //         Generates: min-1, min, min+1, max-1, max, max+1
  //       - forString(minLen: Int, maxLen: Int): List[String]
  //         Generates strings of lengths: 0, minLen-1, minLen, maxLen, maxLen+1
  //         (use 'a' repeated for content)
  //       - forCollection(minSize: Int, maxSize: Int): List[List[Int]]
  //         Generates lists of sizes at boundary values using sequential ints.
  object BoundaryValues {
    def forInt(min: Int, max: Int): List[Int] = ???
    def forString(minLen: Int, maxLen: Int): List[String] = ???
    def forCollection(minSize: Int, maxSize: Int): List[List[Int]] = ???
  }

  // ==========================================================================
  // Exercise 2: Implement an error scenario catalog
  // ==========================================================================
  // TODO: Implement `ErrorCatalog` that catalogs common error scenarios for testing:
  //       - nullInputs[A](f: A => Any): Boolean  (test with null, expect NPE or graceful handling)
  //       - emptyInputs(f: String => Any): List[(String, Boolean)]
  //         Tests with: "", " ", "\t", "\n" and returns (input, passed) pairs
  //         where passed means the function didn't throw unexpectedly.
  //       - numericEdgeCases(f: Int => Any): List[(Int, Either[Throwable, Any])]
  //         Tests with: 0, -1, 1, Int.MinValue, Int.MaxValue
  //       - collectionEdgeCases[A](f: List[A] => Any): List[(String, Either[Throwable, Any])]
  //         Tests with: Nil, single element, large list (1000 elements)
  //         Returns (description, result) pairs.
  object ErrorCatalog {
    def nullInputs[A >: Null](f: A => Any): Boolean = ???
    def emptyInputs(f: String => Any): List[(String, Boolean)] = ???
    def numericEdgeCases(f: Int => Any): List[(Int, Either[Throwable, Any])] = ???
    def collectionEdgeCases(f: List[Int] => Any): List[(String, Either[Throwable, Any])] = ???
  }

  // ==========================================================================
  // Exercise 3: Implement an error recovery tester
  // ==========================================================================
  // TODO: Implement `RecoveryTester` that verifies error recovery behavior:
  //       - testRecovery[A](operation: => A, fallback: Throwable => A): RecoveryResult[A]
  //         Runs operation; if it succeeds, returns RecoveryResult(value, recovered=false).
  //         If it throws, calls fallback and returns RecoveryResult(fallbackValue, recovered=true, error).
  //       - testRetryRecovery[A](operation: => A, maxRetries: Int): RetryRecoveryResult[A]
  //         Retries the operation; returns attempts count and final result (success or last error).
  case class RecoveryResult[A](value: A, recovered: Boolean, error: Option[Throwable] = None)
  case class RetryRecoveryResult[A](
    result: Either[Throwable, A],
    attempts: Int,
    errors: List[Throwable]
  )

  def testRecovery[A](operation: => A, fallback: Throwable => A): RecoveryResult[A] = ???
  def testRetryRecovery[A](operation: => A, maxRetries: Int): RetryRecoveryResult[A] = ???

  // ==========================================================================
  // Exercise 4: Implement an exception chain analyzer
  // ==========================================================================
  // TODO: Implement `ExceptionChainAnalyzer` that analyzes exception cause chains:
  //       - analyze(ex: Throwable): ExceptionChainInfo
  //       ExceptionChainInfo should contain:
  //       - depth: Int  (how many causes deep)
  //       - rootCause: Throwable  (the deepest cause)
  //       - chain: List[String]  (class names from outermost to innermost)
  //       - containsType[E : ClassTag]: Boolean  (any exception in chain matches)
  import scala.reflect.ClassTag
  case class ExceptionChainInfo(
    depth: Int,
    rootCause: Throwable,
    chain: List[String]
  ) {
    def containsType[E <: Throwable : ClassTag]: Boolean = ???
  }

  def analyzeExceptionChain(ex: Throwable): ExceptionChainInfo = ???

  // ==========================================================================
  // Exercise 5: Implement an input validation tester
  // ==========================================================================
  // TODO: Implement `ValidationTester` that systematically tests input validation:
  //       - testValidation[A](inputs: List[A], validator: A => Either[String, A]): ValidationReport
  //       ValidationReport contains:
  //       - accepted: List[A]  (inputs that passed validation)
  //       - rejected: List[(A, String)]  (inputs with rejection reason)
  //       - acceptRate: Double
  //       Also implement `fuzz[A](validInput: A, mutations: List[A => A], validator: A => Either[String, A]): List[(A, Boolean)]`
  //       that applies mutations to a valid input and checks if validation catches them.
  case class ValidationReport[A](
    accepted: List[A],
    rejected: List[(A, String)],
    acceptRate: Double
  )

  def testValidation[A](inputs: List[A], validator: A => Either[String, A]): ValidationReport[A] = ???
  def fuzz[A](validInput: A, mutations: List[A => A], validator: A => Either[String, A]): List[(A, Boolean)] = ???

  // ==========================================================================
  // Exercise 6: Implement a timeout and cancellation tester
  // ==========================================================================
  // TODO: Implement `TimeoutTester` that verifies timeout behavior:
  //       - testTimeout(operation: => Unit, expectedMaxMs: Long): TimeoutTestResult
  //         Runs the operation and checks it completes within expectedMaxMs.
  //         Returns TimeoutTestResult(actualMs, withinTimeout, timedOut).
  //       - testCancellation(operation: Thread => Unit): CancellationResult
  //         Starts operation in a thread, interrupts it after 100ms,
  //         verifies the thread terminates within 500ms.
  //         Returns CancellationResult(interrupted, terminatedCleanly).
  case class TimeoutTestResult(actualMs: Long, withinTimeout: Boolean, timedOut: Boolean)
  case class CancellationResult(interrupted: Boolean, terminatedCleanly: Boolean)

  def testTimeout(operation: => Unit, expectedMaxMs: Long): TimeoutTestResult = ???
  def testCancellation(operation: Thread => Unit): CancellationResult = ???

  // ==========================================================================
  // Exercise 7: Implement a resource leak detector
  // ==========================================================================
  // TODO: Implement `ResourceLeakDetector` that tracks resource open/close:
  //       - trackOpen(resourceId: String): Unit
  //       - trackClose(resourceId: String): Unit
  //       - openResources: Set[String]  (currently open, not yet closed)
  //       - closedResources: Set[String]
  //       - leakedResources: Set[String]  (opened but never closed, same as openResources)
  //       - hasLeaks: Boolean
  //       - doubleCloses: List[String]  (resources closed more than once)
  //       Implement `withLeakDetection[A](test: ResourceLeakDetector => A): (A, Set[String])`
  //       that runs test and returns result plus any leaked resources.
  class ResourceLeakDetector {
    def trackOpen(resourceId: String): Unit = ???
    def trackClose(resourceId: String): Unit = ???
    def openResources: Set[String] = ???
    def closedResources: Set[String] = ???
    def leakedResources: Set[String] = ???
    def hasLeaks: Boolean = ???
    def doubleCloses: List[String] = ???
  }

  def withLeakDetection[A](test: ResourceLeakDetector => A): (A, Set[String]) = ???

  // ==========================================================================
  // Exercise 8: Implement an error injection framework
  // ==========================================================================
  // TODO: Implement `ErrorInjector` that wraps a function and can inject errors:
  //       - onNthCall(n: Int, error: Throwable): ErrorInjector[A, B]
  //         (throw on the nth call, 1-based)
  //       - withProbability(p: Double, error: Throwable, seed: Long): ErrorInjector[A, B]
  //         (throw with probability p on each call)
  //       - onCondition(pred: A => Boolean, error: Throwable): ErrorInjector[A, B]
  //         (throw when input matches predicate)
  //       - apply(arg: A): B  (calls wrapped function or throws injected error)
  //       - errorCount: Int  (number of errors injected so far)
  //       - successCount: Int
  class ErrorInjector[A, B](f: A => B) {
    def onNthCall(n: Int, error: Throwable): ErrorInjector[A, B] = ???
    def withProbability(p: Double, error: Throwable, seed: Long = 42L): ErrorInjector[A, B] = ???
    def onCondition(pred: A => Boolean, error: Throwable): ErrorInjector[A, B] = ???
    def apply(arg: A): B = ???
    def errorCount: Int = ???
    def successCount: Int = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val intBounds = BoundaryValues.forInt(1, 100)
    assert(intBounds.contains(0) && intBounds.contains(1) && intBounds.contains(2))
    assert(intBounds.contains(99) && intBounds.contains(100) && intBounds.contains(101))
    val strBounds = BoundaryValues.forString(3, 5)
    assert(strBounds.exists(_.length == 0))
    assert(strBounds.exists(_.length == 3))
    assert(strBounds.exists(_.length == 5))
    println("Exercise 1 passed: boundary value generation works")

    // Exercise 2
    val emptyResults = ErrorCatalog.emptyInputs(s => s.trim.nonEmpty)
    assert(emptyResults.nonEmpty)
    val numResults = ErrorCatalog.numericEdgeCases(n => 100 / n)
    assert(numResults.exists { case (0, Left(_)) => true; case _ => false })
    println("Exercise 2 passed: error catalog works")

    // Exercise 3
    val recovered = testRecovery(throw new RuntimeException("fail"), (_: Throwable) => "fallback")
    assert(recovered.recovered && recovered.value == "fallback")
    val noRecovery = testRecovery("success", (_: Throwable) => "fallback")
    assert(!noRecovery.recovered && noRecovery.value == "success")
    var retryCount = 0
    val retryResult = testRetryRecovery({ retryCount += 1; if (retryCount < 3) throw new RuntimeException("not yet"); "ok" }, 5)
    assert(retryResult.result.isRight && retryResult.attempts == 3)
    println("Exercise 3 passed: recovery testing works")

    // Exercise 4
    val chained = new RuntimeException("outer",
      new IllegalArgumentException("middle",
        new NullPointerException("root")))
    val chainInfo = analyzeExceptionChain(chained)
    assert(chainInfo.depth == 3)
    assert(chainInfo.rootCause.isInstanceOf[NullPointerException])
    assert(chainInfo.chain.length == 3)
    assert(chainInfo.containsType[IllegalArgumentException])
    println("Exercise 4 passed: exception chain analysis works")

    // Exercise 5
    val validator: Int => Either[String, Int] = n =>
      if (n >= 1 && n <= 100) Right(n) else Left(s"$n out of range")
    val valReport = testValidation(List(0, 1, 50, 100, 101), validator)
    assert(valReport.accepted == List(1, 50, 100))
    assert(valReport.rejected.length == 2)
    val fuzzResults = fuzz[Int](50, List(_ - 100, _ + 100, _ => -1), validator)
    assert(fuzzResults.forall(!_._2)) // all mutations should be rejected
    println("Exercise 5 passed: validation testing works")

    // Exercise 6
    val fastResult = testTimeout({ Thread.sleep(10) }, 500)
    assert(fastResult.withinTimeout && !fastResult.timedOut)
    println("Exercise 6 passed: timeout testing works")

    // Exercise 7
    val (testResult, leaks) = withLeakDetection { detector =>
      detector.trackOpen("file1")
      detector.trackOpen("file2")
      detector.trackClose("file1")
      // file2 is leaked!
      "test done"
    }
    assert(testResult == "test done")
    assert(leaks == Set("file2"))
    println("Exercise 7 passed: resource leak detection works")

    // Exercise 8
    val injector = new ErrorInjector[Int, Int](_ * 2)
      .onNthCall(2, new RuntimeException("injected"))
    assert(injector(5) == 10)
    var injectedError = false
    try { injector(5) } catch { case _: RuntimeException => injectedError = true }
    assert(injectedError)
    assert(injector(5) == 10) // 3rd call succeeds
    assert(injector.errorCount == 1)
    assert(injector.successCount == 2)
    println("Exercise 8 passed: error injection works")

    println("\nAll Test014 exercises passed!")
  }
}
