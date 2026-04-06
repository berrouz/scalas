package org.shev4ik.interview.algorithms.level3_advanced

import scala.util.Random

/**
 * Skip List - a probabilistic alternative to balanced trees.
 *
 * Key concepts:
 * - Multiple levels of linked lists
 * - Each level is a subset of the level below
 * - Expected O(log n) search, insert, delete
 * - Coin-flip to determine level of new element
 */
object Algo087_SkipList {

  /** Skip list node */
  case class SkipNode(value: Int, forward: Array[Option[SkipNode]]) {
    def level: Int = forward.length
    override def toString: String = s"SkipNode($value, level=$level)"
  }

  /** Skip list with max levels */
  case class SkipList(head: SkipNode, maxLevel: Int, currentLevel: Int) {
    override def toString: String = s"SkipList(maxLevel=$maxLevel, currentLevel=$currentLevel)"
  }

  def createSkipList(maxLevel: Int): SkipList = {
    val head = SkipNode(Int.MinValue, Array.fill(maxLevel)(None))
    SkipList(head, maxLevel, 0)
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Skip list search
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for a value in the skip list.
   *       Start from highest level, move right while next value < target,
   *       then drop down a level. Return true if found.
   *
   * @param sl    skip list
   * @param value value to search
   * @return true if value exists in skip list
   */
  def skipListSearch(sl: SkipList, value: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Skip list insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a value into the skip list.
   *       1. Find insertion position at each level
   *       2. Generate random level for new node
   *       3. Update forward pointers
   *       Return the updated skip list.
   *       Note: Since nodes are mutable (arrays), this modifies in place.
   *
   * @param sl    skip list
   * @param value value to insert
   * @param rng   random number generator
   * @return updated skip list
   */
  def skipListInsert(sl: SkipList, value: Int, rng: Random = new Random()): SkipList = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Skip list delete
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete a value from the skip list.
   *       Find the node at each level and update forward pointers.
   *       Return the updated skip list.
   *
   * @param sl    skip list
   * @param value value to delete
   * @return updated skip list
   */
  def skipListDelete(sl: SkipList, value: Int): SkipList = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Skip list level generation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate a random level for a new skip list node.
   *       Flip a coin: with probability p (typically 0.5), go to next level.
   *       Cap at maxLevel.
   *
   * @param maxLevel maximum allowed level
   * @param p        probability of promotion
   * @param rng      random generator
   * @return level for new node (1 to maxLevel)
   */
  def randomLevel(maxLevel: Int, p: Double = 0.5, rng: Random = new Random()): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Skip list analysis - count nodes at each level
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of nodes at each level of the skip list.
   *       Level 0 is the bottom level containing all elements.
   *       Return array where result(i) = number of nodes at level i.
   *
   * @param sl skip list
   * @return array of node counts per level
   */
  def nodesPerLevel(sl: SkipList): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Concurrent skip list concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate a thread-safe skip list using Scala's concurrent collections.
   *       For simplicity, implement a skip list backed by a sorted set with
   *       synchronized access. Provide search, insert, delete operations.
   *       Return (search, insert, delete) functions.
   *
   * @return (search: Int => Boolean, insert: Int => Unit, delete: Int => Unit)
   */
  def concurrentSkipList(): (Int => Boolean, Int => Unit, Int => Unit) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Skip list vs BST comparison
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build both a skip list and a sorted list from the same data.
   *       Compare the number of "comparisons" needed to search for a value.
   *       For skip list: count hops. For sorted list: count binary search steps.
   *       Return (skipListHops, binarySearchSteps).
   *
   * @param data   sorted data to build from
   * @param target value to search
   * @return (skip list hops, binary search comparisons)
   */
  def compareSearchEfficiency(data: List[Int], target: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Skip list iterator
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an iterator that traverses all elements in the skip list
   *       in sorted order (using the bottom level).
   *       Return elements as a List[Int].
   *
   * @param sl skip list
   * @return sorted list of all elements
   */
  def skipListToList(sl: SkipList): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val rng = new Random(42)
    var sl = createSkipList(4)

    // Exercise 2 (insert first so we have data)
    for (v <- List(3, 6, 7, 9, 12, 19, 17, 26, 21, 25)) {
      sl = skipListInsert(sl, v, rng)
    }
    println("Exercise 2 (Skip list insert) passed.")

    // Exercise 1
    assert(skipListSearch(sl, 19))
    assert(skipListSearch(sl, 3))
    assert(!skipListSearch(sl, 10))
    println("Exercise 1 (Skip list search) passed.")

    // Exercise 3
    sl = skipListDelete(sl, 19)
    assert(!skipListSearch(sl, 19))
    assert(skipListSearch(sl, 17))
    println("Exercise 3 (Skip list delete) passed.")

    // Exercise 4
    val levels = (1 to 1000).map(_ => randomLevel(4, 0.5, rng))
    assert(levels.count(_ == 1) > 400) // roughly half should be level 1
    assert(levels.max <= 4)
    println("Exercise 4 (Random level) passed.")

    // Exercise 5
    val npl = nodesPerLevel(sl)
    assert(npl(0) == 9) // 10 inserted - 1 deleted
    println("Exercise 5 (Nodes per level) passed.")

    // Exercise 6
    val (cSearch, cInsert, cDelete) = concurrentSkipList()
    cInsert(5)
    cInsert(10)
    assert(cSearch(5))
    assert(!cSearch(7))
    cDelete(5)
    assert(!cSearch(5))
    println("Exercise 6 (Concurrent skip list) passed.")

    // Exercise 7
    val (slHops, bsSteps) = compareSearchEfficiency((1 to 100).toList, 50)
    assert(slHops > 0 && bsSteps > 0)
    println("Exercise 7 (Search comparison) passed.")

    // Exercise 8
    val elements = skipListToList(sl)
    assert(elements == elements.sorted)
    assert(elements.size == 9)
    println("Exercise 8 (Skip list iterator) passed.")

    println("All Algo087_SkipList exercises passed!")
  }
}
