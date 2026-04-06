package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Lazy Data Structures - deferred computation for potentially infinite structures.
 *
 * Key concepts:
 * - Stream (Stream): elements computed on demand
 * - Memoization: computed values are cached
 * - Enables working with infinite sequences
 * - Useful for search algorithms, mathematical sequences
 */
object Algo102_LazyStructures {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Lazy list (Stream) basics
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Create basic lazy list operations:
   *       - naturals: infinite lazy list of natural numbers starting from n
   *       - takeL: take first n elements as a regular List
   *       - mapL: lazy map over a Stream
   *
   * @param n starting number
   * @return Stream of naturals from n
   */
  def naturals(n: Int): Stream[Int] = {
    ???
  }

  def takeL[A](ll: Stream[A], n: Int): List[A] = {
    ???
  }

  def mapL[A, B](ll: Stream[A], f: A => B): Stream[B] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Memoized Fibonacci
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate the infinite Fibonacci sequence as a Stream.
   *       fibs = 0, 1, 1, 2, 3, 5, 8, 13, ...
   *       Use the self-referential definition: fibs.zip(fibs.tail).map(sum).
   *       Values are automatically memoized by Stream.
   *
   * @return infinite Stream of Fibonacci numbers
   */
  def fibonacci: Stream[Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Sieve of Eratosthenes (lazy)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a lazy sieve of Eratosthenes.
   *       sieve(s) = s.head #:: sieve(s.tail.filter(_ % s.head != 0))
   *       Return infinite Stream of primes.
   *
   * @return infinite Stream of prime numbers
   */
  def primes: Stream[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Lazy BFS
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement BFS as a lazy sequence of visited nodes.
   *       Generate nodes level by level on demand.
   *       This allows stopping early without exploring the entire graph.
   *
   * @param start starting node
   * @param neighbors function to get neighbors
   * @return Stream of nodes in BFS order
   */
  def lazyBFS(start: Int, neighbors: Int => List[Int]): Stream[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Lazy DFS
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement DFS as a lazy sequence of visited nodes.
   *
   * @param start starting node
   * @param neighbors function to get neighbors
   * @return Stream of nodes in DFS order
   */
  def lazyDFS(start: Int, neighbors: Int => List[Int]): Stream[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Lazy merge of sorted streams
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Merge two sorted Streams into one sorted Stream.
   *       Both input lists may be infinite.
   *
   * @param s1 first sorted Stream
   * @param s2 second sorted Stream
   * @return merged sorted Stream
   */
  def mergeSorted(s1: Stream[Int], s2: Stream[Int]): Stream[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Lazy takeWhile
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a lazy takeWhile that produces elements while predicate holds.
   *       Stops as soon as predicate fails (doesn't evaluate further).
   *
   * @param ll lazy list
   * @param p  predicate
   * @return Stream of elements satisfying p from the start
   */
  def lazyTakeWhile[A](ll: Stream[A], p: A => Boolean): Stream[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Infinite streams - Hamming numbers
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate the infinite sequence of Hamming numbers (regular numbers).
   *       Hamming numbers have no prime factors other than 2, 3, or 5.
   *       Sequence: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, ...
   *       Use lazy merge of multiples.
   *
   * @return infinite Stream of Hamming numbers
   */
  def hammingNumbers: Stream[Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val nats = naturals(1)
    assert(takeL(nats, 5) == List(1, 2, 3, 4, 5))
    assert(takeL(mapL(nats, (x: Int) => x * x), 4) == List(1, 4, 9, 16))
    println("Exercise 1 (Stream basics) passed.")

    // Exercise 2
    val fibs = fibonacci
    assert(fibs.take(8).toList == List(0L, 1, 1, 2, 3, 5, 8, 13))
    println("Exercise 2 (Fibonacci) passed.")

    // Exercise 3
    val ps = primes
    assert(ps.take(5).toList == List(2, 3, 5, 7, 11))
    assert(ps.take(10).toList == List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
    println("Exercise 3 (Sieve) passed.")

    // Exercise 4
    val graph = Map(0 -> List(1, 2), 1 -> List(3), 2 -> List(3), 3 -> Nil)
      .withDefaultValue(Nil)
    val bfs = lazyBFS(0, graph).take(4).toList
    assert(bfs == List(0, 1, 2, 3))
    println("Exercise 4 (Lazy BFS) passed.")

    // Exercise 5
    val dfs = lazyDFS(0, graph).take(4).toList
    assert(dfs.head == 0)
    assert(dfs.toSet == Set(0, 1, 2, 3))
    println("Exercise 5 (Lazy DFS) passed.")

    // Exercise 6
    val s1 = Stream(1, 3, 5, 7, 9)
    val s2 = Stream(2, 4, 6, 8, 10)
    assert(mergeSorted(s1, s2).take(10).toList == (1 to 10).toList)
    println("Exercise 6 (Merge sorted) passed.")

    // Exercise 7
    val tw = lazyTakeWhile(naturals(1), (x: Int) => x < 6)
    assert(tw.toList == List(1, 2, 3, 4, 5))
    println("Exercise 7 (TakeWhile) passed.")

    // Exercise 8
    val ham = hammingNumbers
    assert(ham.take(12).toList == List(1L, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16))
    println("Exercise 8 (Hamming numbers) passed.")

    println("All Algo102_LazyStructures exercises passed!")
  }
}
