package org.shev4ik.interview.fs2.level2_intermediate

import scala.util.{Try, Success, Failure}

/**
 * FS2 006 - Effectful Streams
 *
 * In fs2, Stream[F, O] can interleave effects of type F[_] with stream
 * processing. Common operations: eval (lift single effect), evalMap (map with
 * effect), evalFilter (filter with effect), evalTap (side-effect without
 * transforming).
 *
 * This exercise uses a simplified IO-like wrapper to model effectful stream
 * operations without requiring the cats-effect dependency.
 *
 * Key concepts: lifting effects into streams, evalMap, evalFilter, evalTap,
 * exec, effectful stream compilation.
 */
object Fs2_006_EffectfulStreams {

  // Simplified IO modeling cats.effect.IO
  case class IO[+A](unsafeRun: () => A) {
    def map[B](f: A => B): IO[B] = IO(() => f(unsafeRun()))
    def flatMap[B](f: A => IO[B]): IO[B] = IO(() => f(unsafeRun()).unsafeRun())
  }

  object IO {
    def pure[A](a: A): IO[A] = IO(() => a)
    def delay[A](a: => A): IO[A] = IO(() => a)
  }

  // Effectful stream: each step may perform an IO effect
  case class EffStream[O](run: () => List[(IO[Unit], O)]) {
    def toList: List[O] = {
      val steps = run()
      steps.map { case (eff, o) => eff.unsafeRun(); o }
    }
  }

  // Simple stream that tracks effects via a mutable log
  case class Stream[+O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Lift a single IO action into a stream (eval).
  // TODO: Given an IO[A], produce a Stream containing the single result.
  // Hint: In fs2 this is Stream.eval(io) which creates Stream[IO, A].
  // -------------------------------------------------------------------------
  def exercise1_eval[A](io: IO[A]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Apply an effectful function to each element (evalMap).
  // TODO: For each element in the stream, apply f which returns IO[B],
  //       run the IO, and collect results into a new Stream.
  // Hint: In fs2 this is stream.evalMap(a => IO(transform(a))).
  // -------------------------------------------------------------------------
  def exercise2_evalMap[A, B](s: Stream[A])(f: A => IO[B]): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Filter with an effectful predicate (evalFilter).
  // TODO: For each element, run the IO predicate; keep element if true.
  // Hint: In fs2 this is stream.evalFilter(a => IO(predicate(a))).
  // -------------------------------------------------------------------------
  def exercise3_evalFilter[A](s: Stream[A])(p: A => IO[Boolean]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Perform a side-effect for each element without changing it (evalTap).
  // TODO: For each element, run the IO side-effect, then pass element through.
  //       Record side-effects in the provided log buffer.
  // Hint: In fs2 this is stream.evalTap(a => IO(println(a))).
  // -------------------------------------------------------------------------
  def exercise4_evalTap[A](s: Stream[A])(f: A => IO[Unit]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Execute an IO action in the stream without emitting a value.
  // TODO: Given a stream and an IO action, run the action after the stream
  //       completes but don't add any elements. Return the original elements.
  // Hint: In fs2 this is stream ++ Stream.exec(action).
  // -------------------------------------------------------------------------
  def exercise5_exec[A](s: Stream[A])(action: IO[Unit]): (Stream[A], IO[Unit]) = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Chain multiple evalMaps together.
  // TODO: Given a stream of Ints, first evalMap to double each value,
  //       then evalMap to convert to String. Return the final Stream[String].
  // Hint: stream.evalMap(a => IO(a * 2)).evalMap(a => IO(a.toString))
  // -------------------------------------------------------------------------
  def exercise6_chainedEvalMap(s: Stream[Int]): Stream[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use evalMap with error handling (attempt-like).
  // TODO: Apply f to each element. If f throws, replace with the default value.
  //       Model this by catching exceptions in the IO execution.
  // Hint: In fs2 this is stream.evalMap(a => IO(f(a)).handleError(_ => default)).
  // -------------------------------------------------------------------------
  def exercise7_evalMapWithRecovery[A, B](
    s: Stream[A]
  )(f: A => B)(default: B): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement evalMapChunk - evalMap that processes elements
  //             and also tracks how many effects were executed.
  // TODO: Apply the effectful function f to each element. Return a tuple of
  //       (result stream, total effect count).
  // Hint: This models the concept that evalMap runs one effect per element.
  // -------------------------------------------------------------------------
  def exercise8_evalMapWithCount[A, B](
    s: Stream[A]
  )(f: A => IO[B]): (Stream[B], Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val io42 = IO.pure(42)
    assert(exercise1_eval(io42).toList == List(42))
    assert(exercise1_eval(IO.delay("hello")).toList == List("hello"))
    println("Exercise 1 passed: eval lifts IO into stream")

    // Exercise 2
    val nums = Stream(1, 2, 3, 4, 5)
    val doubled = exercise2_evalMap(nums)(a => IO.pure(a * 2))
    assert(doubled.toList == List(2, 4, 6, 8, 10))
    println("Exercise 2 passed: evalMap applies effectful function")

    // Exercise 3
    val evens = exercise3_evalFilter(nums)(a => IO.pure(a % 2 == 0))
    assert(evens.toList == List(2, 4))
    println("Exercise 3 passed: evalFilter with effectful predicate")

    // Exercise 4
    val log = scala.collection.mutable.ListBuffer.empty[Int]
    val tapped = exercise4_evalTap(nums)(a => IO.delay { log += a; () })
    assert(tapped.toList == List(1, 2, 3, 4, 5))
    assert(log.toList == List(1, 2, 3, 4, 5))
    println("Exercise 4 passed: evalTap performs side-effect without changing stream")

    // Exercise 5
    var executed = false
    val (resultStream, action) = exercise5_exec(nums)(IO.delay { executed = true })
    assert(resultStream.toList == List(1, 2, 3, 4, 5))
    action.unsafeRun()
    assert(executed)
    println("Exercise 5 passed: exec runs action without emitting")

    // Exercise 6
    val chained = exercise6_chainedEvalMap(Stream(1, 2, 3))
    assert(chained.toList == List("2", "4", "6"))
    println("Exercise 6 passed: chained evalMaps compose")

    // Exercise 7
    val risky = exercise7_evalMapWithRecovery(Stream("1", "abc", "3"))(_.toInt)(0)
    assert(risky.toList == List(1, 0, 3))
    println("Exercise 7 passed: evalMap with error recovery")

    // Exercise 8
    val (result, count) = exercise8_evalMapWithCount(nums)(a => IO.pure(a.toString))
    assert(result.toList == List("1", "2", "3", "4", "5"))
    assert(count == 5)
    println("Exercise 8 passed: evalMap with effect counting")

    println("\nAll Fs2_006_EffectfulStreams exercises passed!")
  }
}
