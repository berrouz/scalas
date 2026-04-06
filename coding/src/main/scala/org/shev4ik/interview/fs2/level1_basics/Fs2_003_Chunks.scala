package org.shev4ik.interview.fs2.level1_basics

/**
 * FS2 003 - Chunks
 *
 * In fs2, streams process data in Chunks - contiguous arrays of elements.
 * This is critical for performance: operations on chunks avoid per-element
 * overhead and enable batch processing.
 *
 * Key concepts: Chunk creation, chunk-based map/filter, converting between
 * chunks and collections, chunk concatenation, chunk size management.
 */
object Fs2_003_Chunks {

  // Simplified Chunk type modeling fs2.Chunk[O]
  case class Chunk[O](toArray: Array[O]) {
    def toList: List[O] = toArray.toList
    def size: Int = toArray.length
    def isEmpty: Boolean = toArray.isEmpty
    def apply(i: Int): O = toArray(i)
    override def toString: String = s"Chunk(${toList.mkString(", ")})"
    override def equals(obj: Any): Boolean = obj match {
      case c: Chunk[_] => toList == c.toList
      case _ => false
    }
    override def hashCode(): Int = toList.hashCode()
  }

  object Chunk {
    def empty[O: scala.reflect.ClassTag]: Chunk[O] = Chunk(Array.empty[O])
    def singleton[O: scala.reflect.ClassTag](o: O): Chunk[O] = Chunk(Array(o))
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a Chunk from a sequence of elements.
  // TODO: Implement fromSeq that wraps a Seq into a Chunk.
  // Hint: In fs2 this is Chunk.from(seq) or Chunk.seq(seq).
  // -------------------------------------------------------------------------
  def exercise1_fromSeq[A: scala.reflect.ClassTag](as: Seq[A]): Chunk[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Map over a Chunk, producing a new Chunk with transformed elements.
  // TODO: Implement chunkMap that applies f to every element.
  // Hint: In fs2 this is chunk.map(f).
  // -------------------------------------------------------------------------
  def exercise2_chunkMap[A: scala.reflect.ClassTag, B: scala.reflect.ClassTag](
    chunk: Chunk[A]
  )(f: A => B): Chunk[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Filter elements in a Chunk by a predicate.
  // TODO: Implement chunkFilter that keeps only elements where p is true.
  // Hint: In fs2 this is chunk.filter(p).
  // -------------------------------------------------------------------------
  def exercise3_chunkFilter[A: scala.reflect.ClassTag](
    chunk: Chunk[A]
  )(p: A => Boolean): Chunk[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Concatenate two Chunks into one.
  // TODO: Implement chunkConcat that joins two chunks sequentially.
  // Hint: In fs2 you can use Chunk.concat(Seq(c1, c2)).
  // -------------------------------------------------------------------------
  def exercise4_chunkConcat[A: scala.reflect.ClassTag](
    c1: Chunk[A],
    c2: Chunk[A]
  ): Chunk[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: FlatMap over a Chunk, expanding each element into a new Chunk.
  // TODO: Implement chunkFlatMap that maps each element to a Chunk and
  //       concatenates all results.
  // Hint: In fs2 this is chunk.flatMap(f).
  // -------------------------------------------------------------------------
  def exercise5_chunkFlatMap[A: scala.reflect.ClassTag, B: scala.reflect.ClassTag](
    chunk: Chunk[A]
  )(f: A => Chunk[B]): Chunk[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Fold a Chunk into a single value.
  // TODO: Implement chunkFold that reduces left-to-right with init and f.
  // Hint: In fs2 this is chunk.foldLeft(init)(f).
  // -------------------------------------------------------------------------
  def exercise6_chunkFold[A, B](chunk: Chunk[A])(init: B)(f: (B, A) => B): B = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Take the first n elements of a Chunk.
  // TODO: Implement chunkTake that returns a Chunk of at most n elements.
  // Hint: In fs2 this is chunk.take(n).
  // -------------------------------------------------------------------------
  def exercise7_chunkTake[A: scala.reflect.ClassTag](
    chunk: Chunk[A],
    n: Int
  ): Chunk[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Split a Chunk into two at a given index.
  // TODO: Implement chunkSplitAt that returns (left, right) chunks.
  //       Left contains elements [0, n), right contains [n, size).
  // Hint: In fs2 this is chunk.splitAt(n).
  // -------------------------------------------------------------------------
  def exercise8_chunkSplitAt[A: scala.reflect.ClassTag](
    chunk: Chunk[A],
    n: Int
  ): (Chunk[A], Chunk[A]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_fromSeq(Seq(1, 2, 3)).toList == List(1, 2, 3))
    assert(exercise1_fromSeq(Seq.empty[Int]).isEmpty)
    println("Exercise 1 passed: Chunk created from Seq")

    // Exercise 2
    val chunk123 = Chunk(Array(1, 2, 3))
    assert(exercise2_chunkMap(chunk123)(_ * 2).toList == List(2, 4, 6))
    assert(exercise2_chunkMap(chunk123)(_.toString).toList == List("1", "2", "3"))
    println("Exercise 2 passed: chunkMap transforms elements")

    // Exercise 3
    assert(exercise3_chunkFilter(chunk123)(_ % 2 != 0).toList == List(1, 3))
    assert(exercise3_chunkFilter(chunk123)(_ > 10).isEmpty)
    println("Exercise 3 passed: chunkFilter keeps matching elements")

    // Exercise 4
    val c1 = Chunk(Array(1, 2))
    val c2 = Chunk(Array(3, 4))
    assert(exercise4_chunkConcat(c1, c2).toList == List(1, 2, 3, 4))
    println("Exercise 4 passed: chunkConcat joins two chunks")

    // Exercise 5
    val expanded = exercise5_chunkFlatMap(chunk123)(a => Chunk(Array(a, a * 10)))
    assert(expanded.toList == List(1, 10, 2, 20, 3, 30))
    println("Exercise 5 passed: chunkFlatMap expands and concatenates")

    // Exercise 6
    assert(exercise6_chunkFold(chunk123)(0)(_ + _) == 6)
    assert(exercise6_chunkFold(chunk123)("")(_ + _.toString) == "123")
    println("Exercise 6 passed: chunkFold reduces to single value")

    // Exercise 7
    assert(exercise7_chunkTake(chunk123, 2).toList == List(1, 2))
    assert(exercise7_chunkTake(chunk123, 0).isEmpty)
    println("Exercise 7 passed: chunkTake returns first n elements")

    // Exercise 8
    val (left, right) = exercise8_chunkSplitAt(Chunk(Array(1, 2, 3, 4, 5)), 3)
    assert(left.toList == List(1, 2, 3))
    assert(right.toList == List(4, 5))
    println("Exercise 8 passed: chunkSplitAt splits chunk at index")

    println("\nAll Fs2_003_Chunks exercises passed!")
  }
}
