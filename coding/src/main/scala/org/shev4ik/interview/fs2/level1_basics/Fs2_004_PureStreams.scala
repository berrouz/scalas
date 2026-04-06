package org.shev4ik.interview.fs2.level1_basics

/**
 * FS2 004 - Pure Streams
 *
 * Pure streams (Stream[Pure, O]) have no effects and can be converted to
 * standard collections directly. The compile object provides methods like
 * toList, toVector, fold, count, last, and drain.
 *
 * Key concepts: compile.toList, compile.toVector, compile.fold,
 * compile.count, compile.last, compile.string, chaining pure transformations.
 */
object Fs2_004_PureStreams {

  case class Stream[O](private val elements: List[O]) {
    def toList: List[O] = elements
    def map[B](f: O => B): Stream[B] = Stream(elements.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(elements.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(elements.flatMap(a => f(a).toList))
    def take(n: Int): Stream[O] = Stream(elements.take(n))
    def drop(n: Int): Stream[O] = Stream(elements.drop(n))
    def ++(other: => Stream[O]): Stream[O] = Stream(elements ++ other.toList)

    // compile object modeling fs2's compile
    object compile {
      def toList: List[O] = elements
      def toVector: Vector[O] = elements.toVector
      def last: Option[O] = elements.lastOption
      def count: Int = elements.size
      def drain: Unit = ()
    }
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
    def range(start: Int, end: Int): Stream[Int] = Stream((start until end).toList)
    def empty[O]: Stream[O] = Stream(Nil)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Compile a stream to a List.
  // TODO: Given a stream of integers, return its elements as a List.
  // Hint: In fs2 this is stream.compile.toList (for Pure streams returns List directly).
  // -------------------------------------------------------------------------
  def exercise1_compileToList(s: Stream[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Compile a stream to a Vector.
  // TODO: Given a stream, return its elements as a Vector.
  // Hint: In fs2 this is stream.compile.toVector.
  // -------------------------------------------------------------------------
  def exercise2_compileToVector(s: Stream[Int]): Vector[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Compile with fold - reduce stream to a single value.
  // TODO: Fold the stream using the given initial value and combining function.
  // Hint: In fs2 this is stream.compile.fold(init)(f).
  // -------------------------------------------------------------------------
  def exercise3_compileFold(s: Stream[Int])(init: Int)(f: (Int, Int) => Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Get the last element from a compiled stream.
  // TODO: Return the last element of the stream, or None if empty.
  // Hint: In fs2 this is stream.compile.last.
  // -------------------------------------------------------------------------
  def exercise4_compileLast(s: Stream[Int]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Count the elements in a stream.
  // TODO: Return the number of elements in the stream.
  // Hint: In fs2 this is stream.compile.count.
  // -------------------------------------------------------------------------
  def exercise5_compileCount(s: Stream[Int]): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Chain multiple pure transformations and compile.
  // TODO: Given a stream of ints, filter evens, multiply by 3, take first 4,
  //       and compile to List.
  // Hint: stream.filter(...).map(...).take(...).compile.toList
  // -------------------------------------------------------------------------
  def exercise6_chainedTransformations(s: Stream[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use flatMap with a pure stream to repeat each element n times.
  // TODO: For each element in the stream, emit it `n` times, compile to List.
  // Hint: stream.flatMap(a => Stream.emits(List.fill(n)(a))).compile.toList
  // -------------------------------------------------------------------------
  def exercise7_flatMapRepeat(s: Stream[Int], n: Int): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Build a pipeline that creates a running sum stream.
  // TODO: Given a stream of ints, produce a stream where each element is
  //       the cumulative sum up to that point. Compile to List.
  //       E.g., Stream(1,2,3) -> List(1, 3, 6)
  // Hint: Use a foldLeft-like approach to build a new stream of partial sums.
  // -------------------------------------------------------------------------
  def exercise8_runningSum(s: Stream[Int]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    val nums = Stream(1, 2, 3, 4, 5)

    // Exercise 1
    assert(exercise1_compileToList(nums) == List(1, 2, 3, 4, 5))
    assert(exercise1_compileToList(Stream.empty[Int]) == Nil)
    println("Exercise 1 passed: compile.toList works")

    // Exercise 2
    assert(exercise2_compileToVector(nums) == Vector(1, 2, 3, 4, 5))
    println("Exercise 2 passed: compile.toVector works")

    // Exercise 3
    assert(exercise3_compileFold(nums)(0)(_ + _) == 15)
    assert(exercise3_compileFold(nums)(1)(_ * _) == 120)
    println("Exercise 3 passed: compile.fold reduces correctly")

    // Exercise 4
    assert(exercise4_compileLast(nums) == Some(5))
    assert(exercise4_compileLast(Stream.empty[Int]) == None)
    println("Exercise 4 passed: compile.last returns last element")

    // Exercise 5
    assert(exercise5_compileCount(nums) == 5)
    assert(exercise5_compileCount(Stream.empty[Int]) == 0)
    println("Exercise 5 passed: compile.count returns element count")

    // Exercise 6
    val big = Stream.emits(1 to 20)
    assert(exercise6_chainedTransformations(big) == List(6, 12, 18, 24))
    println("Exercise 6 passed: chained transformations with compile")

    // Exercise 7
    assert(exercise7_flatMapRepeat(Stream(1, 2, 3), 2) == List(1, 1, 2, 2, 3, 3))
    assert(exercise7_flatMapRepeat(Stream(5), 3) == List(5, 5, 5))
    println("Exercise 7 passed: flatMap repeat with compile")

    // Exercise 8
    assert(exercise8_runningSum(Stream(1, 2, 3)) == List(1, 3, 6))
    assert(exercise8_runningSum(Stream(10, 20, 30)) == List(10, 30, 60))
    println("Exercise 8 passed: running sum stream compiled")

    println("\nAll Fs2_004_PureStreams exercises passed!")
  }
}
