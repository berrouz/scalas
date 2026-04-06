package org.shev4ik.interview.fs2.level1_basics

/**
 * FS2 005 - Pipes
 *
 * A Pipe[F, I, O] is simply a function Stream[F, I] => Stream[F, O].
 * Pipes are the primary way to compose stream transformations in fs2.
 * They can be applied with the `through` method: stream.through(pipe).
 *
 * Key concepts: Pipe type alias, creating pipes, composing pipes via andThen,
 * applying pipes with through, reusable transformation building blocks.
 */
object Fs2_005_Pipes {

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def take(n: Int): Stream[O] = Stream(toList.take(n))
    def drop(n: Int): Stream[O] = Stream(toList.drop(n))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)

    // Apply a pipe to this stream (models fs2's stream.through(pipe))
    def through[B](pipe: Stream[O] => Stream[B]): Stream[B] = pipe(this)
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // In fs2: type Pipe[F[_], -I, +O] = Stream[F, I] => Stream[F, O]
  // For pure streams: type Pipe[I, O] = Stream[I] => Stream[O]
  type Pipe[I, O] = Stream[I] => Stream[O]

  // -------------------------------------------------------------------------
  // Exercise 1: Create a pipe that doubles every integer.
  // TODO: Return a Pipe[Int, Int] that maps each element to element * 2.
  // Hint: A pipe is just a function: s => s.map(_ * 2)
  // -------------------------------------------------------------------------
  def exercise1_doublePipe: Pipe[Int, Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a pipe that filters to only even numbers.
  // TODO: Return a Pipe[Int, Int] that keeps only even elements.
  // -------------------------------------------------------------------------
  def exercise2_evenFilterPipe: Pipe[Int, Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a pipe that converts strings to uppercase.
  // TODO: Return a Pipe[String, String] that uppercases each element.
  // -------------------------------------------------------------------------
  def exercise3_uppercasePipe: Pipe[String, String] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Apply a pipe to a stream using `through`.
  // TODO: Apply the given pipe to the given stream.
  // Hint: In fs2 this is stream.through(pipe).
  // -------------------------------------------------------------------------
  def exercise4_applyPipe[A, B](s: Stream[A], pipe: Pipe[A, B]): Stream[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Compose two pipes into one using andThen.
  // TODO: Given pipe1: Pipe[A, B] and pipe2: Pipe[B, C], return Pipe[A, C].
  // Hint: Since pipes are functions, use pipe1 andThen pipe2.
  // -------------------------------------------------------------------------
  def exercise5_composePipes[A, B, C](
    pipe1: Pipe[A, B],
    pipe2: Pipe[B, C]
  ): Pipe[A, C] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Create a pipe that takes the first n elements.
  // TODO: Return a Pipe[A, A] that limits output to n elements.
  // Hint: s => s.take(n)
  // -------------------------------------------------------------------------
  def exercise6_takePipe[A](n: Int): Pipe[A, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Create a pipe that deduplicates consecutive equal elements.
  // TODO: Return a Pipe[A, A] that removes consecutive duplicates.
  //       E.g., [1,1,2,2,2,3,1,1] -> [1,2,3,1]
  // Hint: Process the list, keeping an element only if it differs from
  //       the previous one.
  // -------------------------------------------------------------------------
  def exercise7_deduplicatePipe[A]: Pipe[A, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Create a pipe that batches elements into groups of size n.
  // TODO: Return a Pipe[A, List[A]] that groups consecutive elements.
  //       E.g., n=2, [1,2,3,4,5] -> [List(1,2), List(3,4), List(5)]
  // Hint: Use grouped(n) on the underlying list.
  // -------------------------------------------------------------------------
  def exercise8_batchPipe[A](n: Int): Pipe[A, List[A]] = ???

  def main(args: Array[String]): Unit = {
    val nums = Stream(1, 2, 3, 4, 5)
    val words = Stream("hello", "world", "scala")

    // Exercise 1
    assert(nums.through(exercise1_doublePipe).toList == List(2, 4, 6, 8, 10))
    println("Exercise 1 passed: double pipe works")

    // Exercise 2
    assert(nums.through(exercise2_evenFilterPipe).toList == List(2, 4))
    println("Exercise 2 passed: even filter pipe works")

    // Exercise 3
    assert(words.through(exercise3_uppercasePipe).toList == List("HELLO", "WORLD", "SCALA"))
    println("Exercise 3 passed: uppercase pipe works")

    // Exercise 4
    val tripled: Pipe[Int, Int] = s => s.map(_ * 3)
    assert(exercise4_applyPipe(nums, tripled).toList == List(3, 6, 9, 12, 15))
    println("Exercise 4 passed: pipe applied via through")

    // Exercise 5
    val doubleAndFilter = exercise5_composePipes(exercise1_doublePipe, exercise2_evenFilterPipe)
    assert(nums.through(doubleAndFilter).toList == List(2, 4, 6, 8, 10))
    println("Exercise 5 passed: pipes composed with andThen")

    // Exercise 6
    assert(nums.through(exercise6_takePipe(3)).toList == List(1, 2, 3))
    println("Exercise 6 passed: take pipe limits elements")

    // Exercise 7
    val dupes = Stream(1, 1, 2, 2, 2, 3, 1, 1)
    assert(dupes.through(exercise7_deduplicatePipe).toList == List(1, 2, 3, 1))
    assert(Stream(5, 5, 5).through(exercise7_deduplicatePipe[Int]).toList == List(5))
    println("Exercise 7 passed: deduplicate pipe removes consecutive duplicates")

    // Exercise 8
    assert(nums.through(exercise8_batchPipe(2)).toList == List(List(1, 2), List(3, 4), List(5)))
    assert(nums.through(exercise8_batchPipe(3)).toList == List(List(1, 2, 3), List(4, 5)))
    println("Exercise 8 passed: batch pipe groups elements")

    println("\nAll Fs2_005_Pipes exercises passed!")
  }
}
