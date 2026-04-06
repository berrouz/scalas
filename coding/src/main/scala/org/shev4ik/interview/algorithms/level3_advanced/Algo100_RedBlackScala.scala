package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Functional Red-Black Tree - Okasaki's approach in Scala.
 *
 * Key concepts:
 * - Insert as red, then balance to fix red-red violations
 * - Four balance cases (rotations) handled uniformly
 * - Blacken the root after insertion
 * - Purely functional: all operations return new trees
 */
object Algo100_RedBlackScala {

  sealed trait Color
  case object R extends Color
  case object B extends Color

  sealed trait RBTree[+A]
  case object E extends RBTree[Nothing]
  case class T[A](color: Color, left: RBTree[A], value: A, right: RBTree[A]) extends RBTree[A]

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Functional red-black insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a value into the red-black tree using Okasaki's method.
   *       1. Insert as red node (standard BST insert with Red color)
   *       2. Balance on the way up
   *       3. Blacken the root
   *
   * @param tree red-black tree
   * @param x    value to insert
   * @return new balanced red-black tree
   */
  def insert(tree: RBTree[Int], x: Int): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Balance function
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the balance function that handles all four red-red violation cases.
   *       Each case involves a black node with a red child that has a red child.
   *       All four cases produce the same result: red node with two black children.
   *       Use pattern matching for elegance.
   *
   * @param color color of current node
   * @param left  left subtree
   * @param value current value
   * @param right right subtree
   * @return balanced subtree
   */
  def balance(color: Color, left: RBTree[Int], value: Int, right: RBTree[Int]): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Blacken root
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Make the root of the tree black.
   *       This is called after each insertion to maintain the root-is-black invariant.
   *
   * @param tree tree (root may be red)
   * @return tree with black root
   */
  def blacken(tree: RBTree[Int]): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Search
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for a value in the red-black tree.
   *       Standard BST search (color doesn't affect search).
   *
   * @param tree red-black tree
   * @param x    value to find
   * @return true if value exists
   */
  def search(tree: RBTree[Int], x: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Delete concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement delete for red-black tree.
   *       This is significantly more complex than insert.
   *       Use the approach: make the node red before deleting to avoid black height violations.
   *       Handle cases: leaf, one child, two children (replace with successor).
   *
   * @param tree red-black tree
   * @param x    value to delete
   * @return new tree without x
   */
  def delete(tree: RBTree[Int], x: Int): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: RB tree properties verification
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Verify all red-black tree properties:
   *       1. Root is black
   *       2. Red nodes have black children only
   *       3. All paths from root to leaves have the same black height
   *       4. BST ordering property
   *       Return true if all properties hold.
   *
   * @param tree red-black tree
   * @return true if valid
   */
  def isValid(tree: RBTree[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Build from sorted list
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a red-black tree from a sorted list in O(n) time.
   *       The resulting tree should be balanced.
   *       Hint: Build a complete tree and assign colors appropriately.
   *
   * @param sorted sorted list
   * @return balanced red-black tree
   */
  def fromSortedList(sorted: List[Int]): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Convert to sorted list (in-order traversal)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Convert a red-black tree to a sorted list via in-order traversal.
   *       Use an efficient approach (avoid quadratic list concatenation).
   *       Hint: Use accumulator-based approach or difference lists.
   *
   * @param tree red-black tree
   * @return sorted list of elements
   */
  def toSortedList(tree: RBTree[Int]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1 & 2 & 3 (insert uses balance and blacken)
    var rb: RBTree[Int] = E
    for (x <- List(7, 3, 18, 10, 22, 8, 11, 26, 2, 6, 13)) {
      rb = insert(rb, x)
    }
    println("Exercise 1 (Insert) passed.")
    println("Exercise 2 (Balance) passed.")
    println("Exercise 3 (Blacken) passed.")

    // Exercise 4
    assert(search(rb, 10))
    assert(search(rb, 22))
    assert(!search(rb, 99))
    println("Exercise 4 (Search) passed.")

    // Exercise 5
    val rb2 = delete(rb, 10)
    assert(!search(rb2, 10))
    assert(search(rb2, 11))
    assert(search(rb, 10)) // original unchanged
    println("Exercise 5 (Delete) passed.")

    // Exercise 6
    assert(isValid(rb))
    assert(isValid(rb2))
    println("Exercise 6 (Validation) passed.")

    // Exercise 7
    val rb3 = fromSortedList((1 to 15).toList)
    assert(isValid(rb3))
    assert(search(rb3, 8))
    assert(search(rb3, 1))
    assert(search(rb3, 15))
    println("Exercise 7 (From sorted list) passed.")

    // Exercise 8
    val sorted = toSortedList(rb)
    assert(sorted == List(2, 3, 6, 7, 8, 10, 11, 13, 18, 22, 26))
    println("Exercise 8 (To sorted list) passed.")

    println("All Algo100_RedBlackScala exercises passed!")
  }
}
