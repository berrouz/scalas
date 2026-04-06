package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Immutable BST - purely functional binary search tree operations.
 *
 * Key concepts:
 * - Every operation returns a new tree; original is unchanged
 * - Path copying for O(h) space per operation
 * - Functional programming patterns: recursion, pattern matching
 */
object Algo097_ImmutableBST {

  sealed trait BST[+A]
  case object Empty extends BST[Nothing]
  case class Node[A](value: A, left: BST[A], right: BST[A]) extends BST[A]

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Immutable BST insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a value into an immutable BST.
   *       Return a new tree with the value inserted.
   *       If value already exists, return tree unchanged.
   *
   * @param tree BST
   * @param value value to insert
   * @return new BST with value
   */
  def insert(tree: BST[Int], value: Int): BST[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Immutable BST delete
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete a value from an immutable BST.
   *       If node has two children, replace with in-order successor (smallest in right subtree).
   *       Return new tree with value removed.
   *
   * @param tree BST
   * @param value value to delete
   * @return new BST without value
   */
  def delete(tree: BST[Int], value: Int): BST[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Immutable BST search
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for a value in the BST. Return true if found.
   *       Use tail-recursive approach for efficiency.
   *
   * @param tree BST
   * @param value value to search
   * @return true if value exists
   */
  def search(tree: BST[Int], value: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Build immutable BST from sorted array
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a balanced BST from a sorted array.
   *       Use the middle element as root, recurse on left and right halves.
   *       O(n) time.
   *
   * @param sorted sorted array
   * @return balanced BST
   */
  def fromSorted(sorted: Array[Int]): BST[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Check if BST is balanced
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Check if the BST is height-balanced (height difference of subtrees <= 1 at every node).
   *       Return true if balanced.
   *
   * @param tree BST
   * @return true if balanced
   */
  def isBalanced(tree: BST[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Merge two immutable BSTs
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Merge two BSTs into one balanced BST.
   *       1. Convert both to sorted lists (in-order traversal)
   *       2. Merge the two sorted lists
   *       3. Build balanced BST from merged sorted list
   *
   * @param t1 first BST
   * @param t2 second BST
   * @return merged balanced BST
   */
  def merge(t1: BST[Int], t2: BST[Int]): BST[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Split BST at value
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Split BST into two BSTs: one with all values < pivot, another with values >= pivot.
   *       Both resulting BSTs should be valid BSTs.
   *
   * @param tree BST
   * @param pivot split value
   * @return (BST with values < pivot, BST with values >= pivot)
   */
  def split(tree: BST[Int], pivot: Int): (BST[Int], BST[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Persistent BST with version history
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a persistent BST wrapper that tracks all versions.
   *       - insert returns new version ID
   *       - getVersion retrieves BST at any version
   *       - search on any version
   *       Return (insert, getVersion, search) functions.
   *
   * @return (insert: (versionId, value) => newVersionId,
   *          search: (versionId, value) => Boolean,
   *          toList: versionId => List[Int])
   */
  def persistentBST(): (
    (Int, Int) => Int,       // insert(version, value) => newVersion
    (Int, Int) => Boolean,   // search(version, value) => found
    Int => List[Int]         // toList(version) => sorted elements
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Helper: in-order traversal to sorted list
  def toSortedList(tree: BST[Int]): List[Int] = tree match {
    case Empty => Nil
    case Node(v, l, r) => toSortedList(l) ::: (v :: toSortedList(r))
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val t1 = insert(insert(insert(Empty, 5), 3), 7)
    assert(toSortedList(t1) == List(3, 5, 7))
    println("Exercise 1 (Insert) passed.")

    // Exercise 2
    val t2 = delete(t1, 5)
    assert(toSortedList(t2) == List(3, 7))
    assert(toSortedList(t1) == List(3, 5, 7)) // t1 unchanged
    println("Exercise 2 (Delete) passed.")

    // Exercise 3
    assert(search(t1, 5))
    assert(!search(t1, 6))
    println("Exercise 3 (Search) passed.")

    // Exercise 4
    val t4 = fromSorted(Array(1, 2, 3, 4, 5, 6, 7))
    assert(toSortedList(t4) == List(1, 2, 3, 4, 5, 6, 7))
    assert(isBalanced(t4))
    println("Exercise 4 (From sorted) passed.")

    // Exercise 5
    assert(isBalanced(t4))
    val unbalanced = Node(1, Empty, Node(2, Empty, Node(3, Empty, Empty)))
    assert(!isBalanced(unbalanced))
    println("Exercise 5 (Is balanced) passed.")

    // Exercise 6
    val ta = fromSorted(Array(1, 3, 5))
    val tb = fromSorted(Array(2, 4, 6))
    val tm = merge(ta, tb)
    assert(toSortedList(tm) == List(1, 2, 3, 4, 5, 6))
    println("Exercise 6 (Merge) passed.")

    // Exercise 7
    val (left, right) = split(t4, 4)
    assert(toSortedList(left) == List(1, 2, 3))
    assert(toSortedList(right) == List(4, 5, 6, 7))
    println("Exercise 7 (Split) passed.")

    // Exercise 8
    val (pInsert, pSearch, pToList) = persistentBST()
    val v1 = pInsert(0, 5)
    val v2 = pInsert(v1, 3)
    val v3 = pInsert(v2, 7)
    assert(pSearch(v3, 5))
    assert(!pSearch(v1, 3)) // v1 only has 5
    assert(pToList(v3) == List(3, 5, 7))
    assert(pToList(v1) == List(5))
    println("Exercise 8 (Persistent BST) passed.")

    println("All Algo097_ImmutableBST exercises passed!")
  }
}
