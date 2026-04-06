package org.shev4ik.interview.algorithms.level3_advanced

import scala.util.Random

/**
 * Treap and Rope - balanced BST with heap property + string data structure.
 *
 * Key concepts:
 * - Treap: BST on keys + max-heap on random priorities => balanced in expectation
 * - Split and merge as fundamental operations
 * - Rope: balanced binary tree for efficient string operations
 * - Rope enables O(log n) split, concat, and index
 */
object Algo106_TreapRope {

  /** Treap node */
  case class TNode(key: Int, priority: Int, size: Int, left: Option[TNode], right: Option[TNode])

  def tSize(node: Option[TNode]): Int = node.map(_.size).getOrElse(0)

  def updateSize(node: TNode): TNode =
    node.copy(size = 1 + tSize(node.left) + tSize(node.right))

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Treap insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a key into a treap using split and merge.
   *       1. Split the treap at key into (left, right)
   *       2. Create new node with random priority
   *       3. Merge(left, newNode, right)
   *
   * @param root treap root
   * @param key  key to insert
   * @param rng  random generator for priority
   * @return new treap root
   */
  def treapInsert(root: Option[TNode], key: Int, rng: Random = new Random()): Option[TNode] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Treap delete
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete a key from the treap.
   *       1. Split at key-1 into (left, right)
   *       2. Split right at key into (mid, right2) where mid has only the key
   *       3. Merge(left, right2)
   *
   * @param root treap root
   * @param key  key to delete
   * @return new treap root
   */
  def treapDelete(root: Option[TNode], key: Int): Option[TNode] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Treap split
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Split treap into two treaps: all keys <= splitKey, and all keys > splitKey.
   *       This is the fundamental treap operation.
   *
   * @param root     treap root
   * @param splitKey split key
   * @return (left treap with keys <= splitKey, right treap with keys > splitKey)
   */
  def treapSplit(root: Option[TNode], splitKey: Int): (Option[TNode], Option[TNode]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Treap merge
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Merge two treaps where all keys in left < all keys in right.
   *       Compare priorities to maintain heap property.
   *
   * @param left  left treap
   * @param right right treap
   * @return merged treap
   */
  def treapMerge(left: Option[TNode], right: Option[TNode]): Option[TNode] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Rope data structure
  // ──────────────────────────────────────────────────────────────────────

  sealed trait Rope
  case class RopeLeaf(s: String) extends Rope
  case class RopeNode(left: Rope, right: Rope, len: Int) extends Rope

  def ropeLen(r: Rope): Int = r match {
    case RopeLeaf(s) => s.length
    case RopeNode(_, _, len) => len
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Rope data structure - create from string
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a rope from a string.
   *       Split the string into chunks of at most `leafSize` characters.
   *       Build a balanced binary tree of these chunks.
   *
   * @param s        input string
   * @param leafSize max size of each leaf
   * @return rope
   */
  def ropeFromString(s: String, leafSize: Int = 10): Rope = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Rope split
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Split a rope at position i.
   *       Returns (rope for s[0..i-1], rope for s[i..n-1]).
   *
   * @param rope rope to split
   * @param i    split position
   * @return (left rope, right rope)
   */
  def ropeSplit(rope: Rope, i: Int): (Rope, Rope) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Rope concat
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Concatenate two ropes.
   *       Simply create a new internal node.
   *
   * @param r1 first rope
   * @param r2 second rope
   * @return concatenated rope
   */
  def ropeConcat(r1: Rope, r2: Rope): Rope = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Rope index (charAt)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Get the character at position i in the rope.
   *       Navigate the tree: if i < left.length, go left; else go right with adjusted index.
   *
   * @param rope rope
   * @param i    index
   * @return character at index i
   */
  def ropeIndex(rope: Rope, i: Int): Char = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Helper: rope to string
  def ropeToString(rope: Rope): String = rope match {
    case RopeLeaf(s) => s
    case RopeNode(l, r, _) => ropeToString(l) + ropeToString(r)
  }

  def main(args: Array[String]): Unit = {
    val rng = new Random(42)

    // Exercise 1
    var treap: Option[TNode] = None
    treap = treapInsert(treap, 5, rng)
    treap = treapInsert(treap, 3, rng)
    treap = treapInsert(treap, 7, rng)
    treap = treapInsert(treap, 1, rng)
    assert(tSize(treap) == 4)
    println("Exercise 1 (Treap insert) passed.")

    // Exercise 2
    treap = treapDelete(treap, 3)
    assert(tSize(treap) == 3)
    println("Exercise 2 (Treap delete) passed.")

    // Exercise 3
    treap = treapInsert(treap, 3, rng)
    treap = treapInsert(treap, 9, rng)
    val (left3, right3) = treapSplit(treap, 5)
    assert(tSize(left3) + tSize(right3) == tSize(treap))
    println("Exercise 3 (Treap split) passed.")

    // Exercise 4
    val merged = treapMerge(left3, right3)
    assert(tSize(merged) == tSize(treap))
    println("Exercise 4 (Treap merge) passed.")

    // Exercise 5
    val rope5 = ropeFromString("Hello, World! This is a test string for ropes.", 5)
    assert(ropeToString(rope5) == "Hello, World! This is a test string for ropes.")
    println("Exercise 5 (Rope from string) passed.")

    // Exercise 6
    val (rl, rr) = ropeSplit(rope5, 13)
    assert(ropeToString(rl) == "Hello, World!")
    assert(ropeToString(rr) == " This is a test string for ropes.")
    println("Exercise 6 (Rope split) passed.")

    // Exercise 7
    val rc = ropeConcat(rl, rr)
    assert(ropeToString(rc) == "Hello, World! This is a test string for ropes.")
    println("Exercise 7 (Rope concat) passed.")

    // Exercise 8
    assert(ropeIndex(rope5, 0) == 'H')
    assert(ropeIndex(rope5, 7) == 'W')
    println("Exercise 8 (Rope index) passed.")

    println("All Algo106_TreapRope exercises passed!")
  }
}
