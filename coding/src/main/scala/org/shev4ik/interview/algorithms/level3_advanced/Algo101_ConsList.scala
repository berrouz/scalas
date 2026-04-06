package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Cons List - the fundamental functional list data structure.
 *
 * Key concepts:
 * - Singly-linked immutable list
 * - Cons cell: (head, tail)
 * - O(1) prepend, O(n) append
 * - Foundation for functional programming in Scala
 */
object Algo101_ConsList {

  sealed trait ConsList[+A]
  case object CNil extends ConsList[Nothing]
  case class Cons[A](head: A, tail: ConsList[A]) extends ConsList[A]

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Cons list definition and basic ops
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement basic cons list operations:
   *       - fromList: build ConsList from Scala List
   *       - toList: convert ConsList to Scala List
   *       - length: count elements
   *       - isEmpty: check if empty
   */
  def fromList[A](list: List[A]): ConsList[A] = {
    ???
  }

  def toList[A](cl: ConsList[A]): List[A] = {
    ???
  }

  def length[A](cl: ConsList[A]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: map, filter, flatMap
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement map, filter, and flatMap for ConsList.
   *       All should return new ConsLists (immutable).
   */
  def map[A, B](cl: ConsList[A], f: A => B): ConsList[B] = {
    ???
  }

  def filter[A](cl: ConsList[A], p: A => Boolean): ConsList[A] = {
    ???
  }

  def flatMap[A, B](cl: ConsList[A], f: A => ConsList[B]): ConsList[B] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: foldLeft and foldRight
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement foldLeft (tail-recursive) and foldRight.
   *       foldLeft processes left-to-right with accumulator.
   *       foldRight processes right-to-left (not tail-recursive natively).
   */
  def foldLeft[A, B](cl: ConsList[A], z: B)(f: (B, A) => B): B = {
    ???
  }

  def foldRight[A, B](cl: ConsList[A], z: B)(f: (A, B) => B): B = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: zip
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Zip two ConsLists into a ConsList of pairs.
   *       Stop at the shorter list.
   *
   * @param cl1 first list
   * @param cl2 second list
   * @return zipped list of pairs
   */
  def zip[A, B](cl1: ConsList[A], cl2: ConsList[B]): ConsList[(A, B)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: take and drop
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement take(n) and drop(n).
   *       take(n) returns the first n elements.
   *       drop(n) skips the first n elements.
   */
  def take[A](cl: ConsList[A], n: Int): ConsList[A] = {
    ???
  }

  def drop[A](cl: ConsList[A], n: Int): ConsList[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: reverse
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Reverse a ConsList. Use tail-recursive approach with accumulator.
   *
   * @param cl list to reverse
   * @return reversed list
   */
  def reverse[A](cl: ConsList[A]): ConsList[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: partition
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Partition a ConsList into two based on a predicate.
   *       Returns (elements satisfying predicate, elements not satisfying).
   *       Preserve relative order in each partition.
   *
   * @param cl list to partition
   * @param p  predicate
   * @return (satisfying, not satisfying)
   */
  def partition[A](cl: ConsList[A], p: A => Boolean): (ConsList[A], ConsList[A]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: unfold
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate a ConsList from an initial state using an unfold function.
   *       f(state) returns Some((element, nextState)) to continue, None to stop.
   *       This is the dual of fold.
   *
   * @param init initial state
   * @param f    unfold function
   * @return generated ConsList
   */
  def unfold[A, S](init: S)(f: S => Option[(A, S)]): ConsList[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val cl = fromList(List(1, 2, 3, 4, 5))
    assert(toList(cl) == List(1, 2, 3, 4, 5))
    assert(length(cl) == 5)
    println("Exercise 1 (Basic ops) passed.")

    // Exercise 2
    assert(toList(map(cl, (x: Int) => x * 2)) == List(2, 4, 6, 8, 10))
    assert(toList(filter(cl, (x: Int) => x % 2 == 0)) == List(2, 4))
    assert(toList(flatMap(cl, (x: Int) => fromList(List(x, x)))) == List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5))
    println("Exercise 2 (map/filter/flatMap) passed.")

    // Exercise 3
    assert(foldLeft(cl, 0)(_ + _) == 15)
    assert(foldRight(cl, "")((a, b) => a.toString + b) == "12345")
    println("Exercise 3 (foldLeft/foldRight) passed.")

    // Exercise 4
    val cl2 = fromList(List("a", "b", "c"))
    val zipped = toList(zip(cl, cl2))
    assert(zipped == List((1, "a"), (2, "b"), (3, "c")))
    println("Exercise 4 (zip) passed.")

    // Exercise 5
    assert(toList(take(cl, 3)) == List(1, 2, 3))
    assert(toList(drop(cl, 3)) == List(4, 5))
    println("Exercise 5 (take/drop) passed.")

    // Exercise 6
    assert(toList(reverse(cl)) == List(5, 4, 3, 2, 1))
    println("Exercise 6 (reverse) passed.")

    // Exercise 7
    val (evens, odds) = partition(cl, (x: Int) => x % 2 == 0)
    assert(toList(evens) == List(2, 4))
    assert(toList(odds) == List(1, 3, 5))
    println("Exercise 7 (partition) passed.")

    // Exercise 8
    val generated = unfold(1)((s: Int) => if (s <= 5) Some((s, s + 1)) else None)
    assert(toList(generated) == List(1, 2, 3, 4, 5))
    println("Exercise 8 (unfold) passed.")

    println("All Algo101_ConsList exercises passed!")
  }
}
