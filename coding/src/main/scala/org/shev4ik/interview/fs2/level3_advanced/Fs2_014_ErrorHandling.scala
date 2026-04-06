package org.shev4ik.interview.fs2.level3_advanced

import scala.util.{Try, Success, Failure}

/**
 * FS2 014 - Error Handling
 *
 * fs2 streams provide robust error handling:
 * - handleErrorWith: recover from errors with a fallback stream
 * - attempt: convert errors to Either values in the stream
 * - retry: retry failed operations with configurable delays
 * - onError: perform side-effect on error without recovering
 * - raiseError: introduce an error into the stream
 *
 * Errors in fs2 short-circuit the stream unless caught. The type system
 * tracks that errors are possible through the effect type F.
 *
 * Key concepts: error recovery, attempt/Either pattern, retry with backoff,
 * error logging, error propagation, partial failure handling.
 */
object Fs2_014_ErrorHandling {

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
    def empty[O]: Stream[O] = Stream(Nil)
  }

  type Log = scala.collection.mutable.ListBuffer[String]
  def newLog(): Log = scala.collection.mutable.ListBuffer.empty[String]

  // -------------------------------------------------------------------------
  // Exercise 1: Implement handleErrorWith - recover from a thrown exception.
  // TODO: Apply f to each element. If f throws for any element, catch the
  //       error and use the fallback function to produce a replacement value.
  //       Continue processing remaining elements.
  // Hint: In fs2, stream.map(f).handleErrorWith(e => Stream.emit(fallback(e)))
  // -------------------------------------------------------------------------
  def exercise1_handleErrorWith[A, B](
    s: Stream[A]
  )(f: A => B)(fallback: Throwable => B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement attempt - wrap results in Either.
  // TODO: Apply f to each element. Return Right(result) on success,
  //       Left(error) on failure. Never stop processing due to errors.
  // Hint: In fs2, stream.evalMap(a => IO(f(a))).attempt gives Stream[IO, Either[Throwable, B]]
  // -------------------------------------------------------------------------
  def exercise2_attempt[A, B](
    s: Stream[A]
  )(f: A => B): Stream[Either[Throwable, B]] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement retry - retry a failing operation up to maxRetries times.
  // TODO: Try f(). If it throws, retry up to maxRetries times.
  //       Return Right(result) on success, Left(lastError) after all retries fail.
  //       Log each attempt in the provided log.
  // Hint: In fs2, Stream.retry(fo, delay, nextDelay, maxRetries).
  // -------------------------------------------------------------------------
  def exercise3_retry[A](
    f: () => A,
    maxRetries: Int,
    log: Log
  ): Either[Throwable, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement onError - log the error but don't recover.
  // TODO: Apply f to each element. If f throws, log the error message
  //       and re-throw (stop processing). Return elements processed before error.
  // Hint: In fs2, stream.onError(e => Stream.exec(IO(log(e)))).
  // -------------------------------------------------------------------------
  def exercise4_onError[A, B](
    s: Stream[A]
  )(f: A => B)(log: Log): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement error recovery with a fallback stream.
  // TODO: Process the primary stream. If processing any element fails,
  //       stop the primary stream and switch to the fallback stream.
  //       Return all successfully processed elements + all fallback elements.
  // Hint: In fs2, primaryStream.handleErrorWith(_ => fallbackStream).
  // -------------------------------------------------------------------------
  def exercise5_fallbackStream[A, B](
    primary: Stream[A],
    fallback: Stream[B]
  )(f: A => B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement partial failure handling - skip failed elements.
  // TODO: Apply f to each element. Skip elements where f throws,
  //       but continue processing the rest. Return only successful results.
  // Hint: Models stream.evalMap(a => IO(f(a)).attempt).collect { case Right(b) => b }
  // -------------------------------------------------------------------------
  def exercise6_skipFailures[A, B](
    s: Stream[A]
  )(f: A => B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement retry with exponential backoff (simulated).
  // TODO: Try f(). On failure, retry with increasing delay.
  //       Delays: initialDelayMs, initialDelayMs*2, initialDelayMs*4, ...
  //       Return (result, delays used). Don't actually sleep, just record delays.
  // Hint: In fs2, Stream.retry(fo, delay, _ * 2, maxRetries).
  // -------------------------------------------------------------------------
  def exercise7_retryWithBackoff[A](
    f: () => A,
    maxRetries: Int,
    initialDelayMs: Long
  ): (Either[Throwable, A], List[Long]) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a circuit breaker pattern for stream processing.
  // TODO: Process elements through f. Track consecutive failures. When
  //       consecutive failures reach `threshold`, "open" the circuit:
  //       skip all subsequent elements until a "reset" element is seen
  //       (determined by resetPredicate). After reset, close circuit.
  //       Return (processed results, skipped count).
  // Hint: Models resilient stream processing with circuit breaker state.
  // -------------------------------------------------------------------------
  def exercise8_circuitBreaker[A, B](
    s: Stream[A],
    threshold: Int
  )(f: A => B)(resetPredicate: A => Boolean): (Stream[B], Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val result1 = exercise1_handleErrorWith(Stream("1", "abc", "3"))(
      _.toInt
    )(e => -1)
    assert(result1.toList == List(1, -1, 3))
    println("Exercise 1 passed: handleErrorWith recovers from errors")

    // Exercise 2
    val result2 = exercise2_attempt(Stream("1", "abc", "3"))(_.toInt)
    assert(result2.toList.head == Right(1))
    assert(result2.toList(1).isLeft)
    assert(result2.toList(2) == Right(3))
    println("Exercise 2 passed: attempt wraps in Either")

    // Exercise 3
    var counter3 = 0
    val log3 = newLog()
    val result3 = exercise3_retry(() => {
      counter3 += 1
      if (counter3 < 3) throw new RuntimeException(s"fail-$counter3")
      else "success"
    }, 5, log3)
    assert(result3 == Right("success"))
    assert(log3.size == 3) // 2 failures + 1 success
    println("Exercise 3 passed: retry retries on failure")

    // Exercise 4
    val log4 = newLog()
    val result4 = exercise4_onError(Stream("1", "abc", "3"))(_.toInt)(log4)
    assert(result4.toList == List(1))
    assert(log4.nonEmpty)
    println("Exercise 4 passed: onError logs and stops on error")

    // Exercise 5
    val result5 = exercise5_fallbackStream(
      Stream("1", "abc", "3"),
      Stream(99, 100)
    )(_.toInt)
    assert(result5.toList == List(1, 99, 100))
    println("Exercise 5 passed: fallback stream on error")

    // Exercise 6
    val result6 = exercise6_skipFailures(Stream("1", "abc", "3", "xyz", "5"))(_.toInt)
    assert(result6.toList == List(1, 3, 5))
    println("Exercise 6 passed: skipFailures continues past errors")

    // Exercise 7
    var counter7 = 0
    val (result7, delays7) = exercise7_retryWithBackoff(() => {
      counter7 += 1
      if (counter7 < 3) throw new RuntimeException("fail")
      else "ok"
    }, 5, 100L)
    assert(result7 == Right("ok"))
    assert(delays7 == List(100L, 200L))
    println("Exercise 7 passed: retry with exponential backoff")

    // Exercise 8
    val items8 = Stream("ok1", "fail", "fail", "fail", "skipped", "reset", "ok2")
    val (result8, skipped8) = exercise8_circuitBreaker(items8, 3)(s =>
      if (s.startsWith("fail")) throw new RuntimeException("fail") else s
    )(_.startsWith("reset"))
    assert(result8.toList == List("ok1", "reset", "ok2"))
    assert(skipped8 == 1) // "skipped" was skipped
    println("Exercise 8 passed: circuit breaker opens and resets")

    println("\nAll Fs2_014_ErrorHandling exercises passed!")
  }
}
