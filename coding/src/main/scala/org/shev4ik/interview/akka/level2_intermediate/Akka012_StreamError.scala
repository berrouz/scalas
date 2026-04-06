package org.shev4ik.interview.akka.level2_intermediate

import scala.util.{Try, Success, Failure}

/**
 * Akka 012 - Stream Error Handling
 *
 * Akka Streams provides several strategies for handling errors:
 *   - recover: replace a failure with a final element
 *   - recoverWith: replace a failure with an alternative source
 *   - recoverWithRetries: retry with alternative source up to N times
 *   - Supervision strategy: Resume, Stop, Restart for stream stages
 *   - Log and resume: log errors and continue processing
 *   - Restart source: automatically restart a failed source
 *   - divertTo: send elements matching a condition to a side channel
 *   - watchTermination: observe when a stream completes or fails
 *
 * We simulate these concepts using Try and Either.
 */
object Akka012_StreamError {

  // --- Domain models ---

  sealed trait StreamSupervisionDirective
  case object Resume extends StreamSupervisionDirective
  case object StopStream extends StreamSupervisionDirective
  case object RestartStage extends StreamSupervisionDirective

  case class StreamResult[A](
    elements: List[A],
    errors: List[String],
    isCompleted: Boolean,
    terminationReason: Option[String]
  )

  // Exercise 1: Recover — replace failure with a default value
  // TODO: Given a list of Try[A] elements and a recovery function (Throwable => A),
  //   process the stream: Success values pass through, Failure values are replaced
  //   with the recovery function result. The stream continues after recovery.
  //   Return the list of recovered values.
  //   In real Akka: source.recover { case ex => defaultValue }
  def exercise1_recover[A](elements: List[Try[A]], recovery: Throwable => A): List[A] = ???

  // Exercise 2: RecoverWith — replace failure with alternative source
  // TODO: Given a list of Try[A] elements and an alternative list to use on failure,
  //   process elements until a Failure is encountered.
  //   On failure, switch to the alternative source for remaining elements.
  //   Return all successfully processed elements.
  //   In real Akka: source.recoverWith { case _ => alternativeSource }
  def exercise2_recoverWith[A](elements: List[Try[A]], alternative: List[A]): List[A] = ???

  // Exercise 3: RecoverWithRetries — retry with alternative up to N times
  // TODO: Given a function that produces a list of Try[A] (simulating a source),
  //   and maxRetries, attempt to process the source.
  //   If a Failure is encountered, retry from scratch (call the producer again).
  //   After maxRetries failures, return what was successfully collected plus the error.
  //   Return StreamResult with elements collected, errors encountered, and completion status.
  def exercise3_recoverWithRetries[A](
    sourceProducer: () => List[Try[A]],
    maxRetries: Int
  ): StreamResult[A] = ???

  // Exercise 4: Stream supervision strategy
  // TODO: Given a list of Try[A] elements and a supervision decider (Throwable => Directive):
  //   - Resume: skip the failed element, continue processing
  //   - StopStream: stop processing, return what we have
  //   - RestartStage: clear accumulated results, start over from next element
  //   Return StreamResult with collected elements and errors.
  def exercise4_supervisionStrategy[A](
    elements: List[Try[A]],
    decider: Throwable => StreamSupervisionDirective
  ): StreamResult[A] = ???

  // Exercise 5: Log and resume
  // TODO: Given a list of Either[String, A] where Left is an error message:
  //   Collect all successful (Right) values into the result.
  //   Collect all error messages (Left) into an error log.
  //   Return (successValues, errorLog).
  //   In real Akka: .log("stream").withAttributes(supervisionStrategy(resumingDecider))
  def exercise5_logAndResume[A](elements: List[Either[String, A]]): (List[A], List[String]) = ???

  // Exercise 6: Restart source simulation
  // TODO: Given a source producer function and maxRestarts,
  //   process elements. If an exception message contains "transient",
  //   restart the source (call producer again) and continue collecting.
  //   Non-transient errors stop the stream.
  //   Return all collected elements across restarts.
  def exercise6_restartSource[A](
    sourceProducer: () => List[Try[A]],
    maxRestarts: Int
  ): List[A] = ???

  // Exercise 7: DivertTo — side channel for problematic elements
  // TODO: Given a list of integers, divert negative numbers to an "error sink"
  //   and keep positive numbers in the main flow.
  //   Return (mainFlow, errorSink) as two separate lists.
  //   In real Akka: source.divertTo(errorSink, _.isNegative)
  def exercise7_divertTo(elements: List[Int]): (List[Int], List[Int]) = ???

  // Exercise 8: WatchTermination — observe stream completion
  // TODO: Process a list of Try[A] elements. Track the termination status:
  //   If all elements succeed, terminationReason = None, isCompleted = true
  //   If any element fails, terminationReason = Some(error message), isCompleted = false
  //   Return StreamResult with all successfully processed elements up to the failure.
  def exercise8_watchTermination[A](elements: List[Try[A]]): StreamResult[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_recover(
      List(Success(1), Failure(new Exception("err")), Success(3)),
      (_: Throwable) => -1
    )
    assert(r1 == List(1, -1, 3), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2_recoverWith(
      List(Success(1), Success(2), Failure(new Exception("boom")), Success(4)),
      List(10, 20, 30)
    )
    assert(r2 == List(1, 2, 10, 20, 30), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    var attempt3 = 0
    val r3 = exercise3_recoverWithRetries(
      () => {
        attempt3 += 1
        if (attempt3 <= 2) List(Success(1), Failure(new Exception(s"fail-$attempt3")))
        else List(Success(1), Success(2), Success(3))
      },
      maxRetries = 3
    )
    assert(r3.elements == List(1, 2, 3), s"Exercise 3 failed: ${r3.elements}")
    assert(r3.isCompleted, "Exercise 3 failed: should be completed")
    println(s"Exercise 3 passed: ${r3.elements}")

    // Exercise 4
    val r4 = exercise4_supervisionStrategy(
      List(Success(1), Failure(new Exception("skip")), Success(3), Failure(new Exception("stop")), Success(5)),
      ex => if (ex.getMessage == "skip") Resume else StopStream
    )
    assert(r4.elements == List(1, 3), s"Exercise 4 failed: ${r4.elements}")
    assert(r4.errors.contains("skip"), s"Exercise 4 failed: errors = ${r4.errors}")
    println(s"Exercise 4 passed: elements=${r4.elements}, errors=${r4.errors}")

    // Exercise 5
    val (succ5, errs5) = exercise5_logAndResume(
      List(Right(1), Left("bad-1"), Right(2), Left("bad-2"), Right(3))
    )
    assert(succ5 == List(1, 2, 3), s"Exercise 5 failed: $succ5")
    assert(errs5 == List("bad-1", "bad-2"), s"Exercise 5 failed: $errs5")
    println(s"Exercise 5 passed: values=$succ5, errors=$errs5")

    // Exercise 6
    var attempt6 = 0
    val r6 = exercise6_restartSource(
      () => {
        attempt6 += 1
        if (attempt6 == 1) List(Success(1), Failure(new Exception("transient error")))
        else if (attempt6 == 2) List(Success(2), Success(3))
        else List(Success(99))
      },
      maxRestarts = 3
    )
    assert(r6 == List(1, 2, 3), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val (main7, err7) = exercise7_divertTo(List(1, -2, 3, -4, 5, 0))
    assert(main7 == List(1, 3, 5, 0), s"Exercise 7 failed: main=$main7")
    assert(err7 == List(-2, -4), s"Exercise 7 failed: errors=$err7")
    println(s"Exercise 7 passed: main=$main7, errors=$err7")

    // Exercise 8
    val r8a = exercise8_watchTermination(List(Success(1), Success(2), Success(3)))
    assert(r8a.isCompleted, "Exercise 8 failed: should be completed")
    assert(r8a.terminationReason.isEmpty, "Exercise 8 failed: no error expected")
    val r8b = exercise8_watchTermination(List(Success(1), Failure(new Exception("crash")), Success(3)))
    assert(!r8b.isCompleted, "Exercise 8 failed: should not be completed")
    assert(r8b.terminationReason.contains("crash"), s"Exercise 8 failed: ${r8b.terminationReason}")
    assert(r8b.elements == List(1), s"Exercise 8 failed: ${r8b.elements}")
    println("Exercise 8 passed: watchTermination works")

    println("\nAll Akka012_StreamError exercises passed!")
  }
}
