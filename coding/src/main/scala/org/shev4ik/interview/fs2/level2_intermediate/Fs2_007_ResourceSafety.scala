package org.shev4ik.interview.fs2.level2_intermediate

/**
 * FS2 007 - Resource Safety
 *
 * FS2 guarantees resource safety: acquired resources are always released,
 * even if the stream fails or is interrupted. Key constructs:
 * - bracket: acquire/use/release pattern
 * - onFinalize: run cleanup when stream completes
 * - Resource integration for safe resource management
 *
 * This exercise models resource safety patterns using simplified types.
 *
 * Key concepts: bracket, onFinalize, resource lifecycle, guaranteed cleanup,
 * nested resources, error-safe resource handling.
 */
object Fs2_007_ResourceSafety {

  // Simplified IO
  case class IO[+A](unsafeRun: () => A) {
    def map[B](f: A => B): IO[B] = IO(() => f(unsafeRun()))
    def flatMap[B](f: A => IO[B]): IO[B] = IO(() => f(unsafeRun()).unsafeRun())
  }

  object IO {
    def pure[A](a: A): IO[A] = IO(() => a)
    def delay[A](a: => A): IO[A] = IO(() => a)
  }

  // Resource tracks acquisition and release
  case class Resource[A](
    acquire: IO[A],
    release: A => IO[Unit]
  )

  // Simplified stream with lifecycle hooks
  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // Log for tracking resource lifecycle events
  type Log = scala.collection.mutable.ListBuffer[String]
  def newLog(): Log = scala.collection.mutable.ListBuffer.empty[String]

  // -------------------------------------------------------------------------
  // Exercise 1: Implement bracket - acquire, use, and guarantee release.
  // TODO: Acquire the resource, use it to produce a result, then release.
  //       Return the result. Release must happen even if use throws.
  // Hint: In fs2 this is Stream.bracket(acquire)(release).flatMap(use).
  // -------------------------------------------------------------------------
  def exercise1_bracket[R, A](
    acquire: IO[R]
  )(use: R => A)(release: R => IO[Unit]): A = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement bracket that produces a stream from a resource.
  // TODO: Acquire the resource, use it to produce a Stream, then release.
  //       Log "acquired" on acquire and "released" on release.
  // Hint: In fs2, Stream.bracket(acquire)(release).flatMap(r => Stream.emits(use(r)))
  // -------------------------------------------------------------------------
  def exercise2_bracketStream[R](
    acquire: IO[R],
    release: R => IO[Unit],
    use: R => List[String]
  ): (List[String], IO[Unit]) = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement onFinalize - run a cleanup action when stream ends.
  // TODO: Process all stream elements, then run the finalizer IO.
  //       Return elements and the finalizer.
  // Hint: In fs2 this is stream.onFinalize(IO(...)).
  // -------------------------------------------------------------------------
  def exercise3_onFinalize[A](
    s: Stream[A],
    finalizer: IO[Unit]
  ): (List[A], IO[Unit]) = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Bracket with error handling - release must run on failure.
  // TODO: Acquire resource, try to use it. If use throws an exception,
  //       still release the resource and return Left(error).
  //       If successful, release and return Right(result).
  // Hint: This models fs2's guarantee that bracket always releases.
  // -------------------------------------------------------------------------
  def exercise4_bracketWithError[R, A](
    acquire: IO[R]
  )(use: R => A)(release: R => IO[Unit]): Either[Throwable, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Nested resource acquisition (bracket within bracket).
  // TODO: Acquire outer resource, then acquire inner resource, use both,
  //       release inner first, then outer. Log all lifecycle events.
  // Hint: In fs2, nested brackets automatically compose with correct ordering.
  // -------------------------------------------------------------------------
  def exercise5_nestedBracket(log: Log): String = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a Resource type that can be used with bracket.
  // TODO: Given a Resource[A], use bracket to safely acquire, use, and release.
  //       Return the result of the use function.
  // Hint: In fs2, Stream.resource(r) integrates cats.effect.Resource.
  // -------------------------------------------------------------------------
  def exercise6_useResource[A, B](resource: Resource[A])(use: A => B): B = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Compose two Resources sequentially.
  // TODO: Given two Resources, acquire both (first then second), use them
  //       together via the combine function, then release in reverse order.
  //       Return the combined result.
  // Hint: This models Resource flatMap composition.
  // -------------------------------------------------------------------------
  def exercise7_composeResources[A, B, C](
    r1: Resource[A],
    r2: Resource[B]
  )(combine: (A, B) => C): C = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a stream that processes items with a pooled resource.
  // TODO: Acquire a "connection" (string), process each item by prepending
  //       the connection string, then release. Track lifecycle in the log.
  //       Return (processed items, log entries).
  // Hint: Models the pattern of bracket(acquireConnection)(releaseConnection)
  //       then mapping each stream element using the connection.
  // -------------------------------------------------------------------------
  def exercise8_pooledResource(
    items: List[String],
    log: Log
  ): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val log1 = newLog()
    val result1 = exercise1_bracket(
      IO.delay { log1 += "acquired"; "resource" }
    )(r => r.toUpperCase)(r => IO.delay { log1 += "released"; () })
    assert(result1 == "RESOURCE")
    assert(log1.toList == List("acquired", "released"))
    println("Exercise 1 passed: bracket acquires, uses, and releases")

    // Exercise 2
    val log2 = newLog()
    val (items2, release2) = exercise2_bracketStream(
      IO.delay { log2 += "acquired"; List("a", "b", "c") },
      (_: List[String]) => IO.delay { log2 += "released"; () },
      identity[List[String]]
    )
    assert(items2 == List("a", "b", "c"))
    release2.unsafeRun()
    assert(log2.contains("acquired"))
    assert(log2.contains("released"))
    println("Exercise 2 passed: bracket produces stream from resource")

    // Exercise 3
    val log3 = newLog()
    val (items3, fin3) = exercise3_onFinalize(
      Stream(1, 2, 3),
      IO.delay { log3 += "finalized"; () }
    )
    assert(items3 == List(1, 2, 3))
    fin3.unsafeRun()
    assert(log3.toList == List("finalized"))
    println("Exercise 3 passed: onFinalize runs cleanup")

    // Exercise 4
    val log4 = newLog()
    val err4 = exercise4_bracketWithError(
      IO.delay { log4 += "acquired"; "res" }
    )(_ => throw new RuntimeException("boom"))(
      _ => IO.delay { log4 += "released"; () }
    )
    assert(err4.isLeft)
    assert(log4.toList == List("acquired", "released"))
    println("Exercise 4 passed: bracket releases on error")

    // Exercise 5
    val log5 = newLog()
    val result5 = exercise5_nestedBracket(log5)
    assert(result5 == "outer+inner")
    assert(log5.toList == List("acquire-outer", "acquire-inner", "use", "release-inner", "release-outer"))
    println("Exercise 5 passed: nested brackets release in correct order")

    // Exercise 6
    val log6 = newLog()
    val res6 = Resource(
      IO.delay { log6 += "acquired"; 42 },
      (_: Int) => IO.delay { log6 += "released"; () }
    )
    assert(exercise6_useResource(res6)(_ * 2) == 84)
    assert(log6.toList == List("acquired", "released"))
    println("Exercise 6 passed: Resource used with bracket")

    // Exercise 7
    val log7 = newLog()
    val r7a = Resource(
      IO.delay { log7 += "acquire-a"; "A" },
      (_: String) => IO.delay { log7 += "release-a"; () }
    )
    val r7b = Resource(
      IO.delay { log7 += "acquire-b"; "B" },
      (_: String) => IO.delay { log7 += "release-b"; () }
    )
    val result7 = exercise7_composeResources(r7a, r7b)(_ + _)
    assert(result7 == "AB")
    assert(log7.toList == List("acquire-a", "acquire-b", "release-b", "release-a"))
    println("Exercise 7 passed: composed resources release in reverse order")

    // Exercise 8
    val log8 = newLog()
    val result8 = exercise8_pooledResource(List("x", "y", "z"), log8)
    assert(result8 == List("conn:x", "conn:y", "conn:z"))
    assert(log8.head == "acquire-connection")
    assert(log8.last == "release-connection")
    println("Exercise 8 passed: pooled resource processes items")

    println("\nAll Fs2_007_ResourceSafety exercises passed!")
  }
}
