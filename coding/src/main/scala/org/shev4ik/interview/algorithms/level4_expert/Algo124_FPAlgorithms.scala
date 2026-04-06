package org.shev4ik.interview.algorithms.level4_expert

/**
 * Functional Programming Algorithms - purely functional data structures and patterns.
 *
 * Key concepts:
 * - Purely functional (persistent) data structures
 * - Zipper for efficient local navigation
 * - Church encodings, catamorphisms
 * - Lens-based transformations
 */
object Algo124_FPAlgorithms {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Purely functional queue (Banker's queue)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a purely functional queue using two lists.
   *       Front list for dequeue, rear list (reversed) for enqueue.
   *       When front is empty, reverse rear into front.
   *       Amortized O(1) for enqueue and dequeue.
   *       Process a sequence of operations and return dequeued elements.
   *
   * @param operations list of ("enq", value) or ("deq", -1) operations
   * @return list of dequeued values in order
   */
  def functionalQueueOps(operations: List[(String, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Purely functional red-black tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement insertion into a purely functional red-black tree.
   *       Use Okasaki's balance function to fix violations after insert.
   *       The tree is immutable; insert returns a new tree.
   *       Insert all elements and return the in-order traversal.
   *
   * @param elements elements to insert
   * @return sorted list (in-order traversal of the red-black tree)
   */
  def functionalRBTreeInsert(elements: List[Int]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Persistent vector (trie-based)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified persistent vector using a trie.
   *       Use branching factor of 4 (2 bits per level).
   *       Support: append, get(index), update(index, value).
   *       Each operation returns a new vector (old one unchanged).
   *       Return (elementAtIndex, vectorAfterUpdate).
   *
   * @param elements initial elements to append
   * @param getIdx   index to retrieve
   * @param updIdx   index to update
   * @param updVal   new value for update
   * @return (value at getIdx, value at updIdx after update)
   */
  def persistentVectorOps(elements: List[Int], getIdx: Int, updIdx: Int, updVal: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Finger tree - deque operations
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement basic finger tree operations for a double-ended queue.
   *       Support: pushFront, pushBack, popFront, popBack.
   *       A finger tree has O(1) amortized access to both ends.
   *       Simplified: use a structure with front/back digit arrays
   *       and a middle spine.
   *       Process operations and return popped values.
   *
   * @param operations list of ("pushF", v), ("pushB", v), ("popF", -1), ("popB", -1)
   * @return list of values from pop operations
   */
  def fingerTreeDeque(operations: List[(String, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Zipper for tree navigation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a tree zipper for efficient local navigation.
   *       A zipper consists of (focus node, context/breadcrumbs).
   *       Support: goLeft, goRight, goUp, modify(f).
   *       Build a binary tree, navigate to a node, modify it,
   *       then reconstruct the full tree.
   *       Return the root value after modification.
   *
   * @param treeValues values to build a complete binary tree (level order)
   * @param path       navigation path: list of "L"/"R" directions
   * @param newValue   new value for the focused node
   * @return list of values in level-order after modification
   */
  def zipperTreeModify(treeValues: List[Int], path: List[String], newValue: Int): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Lens-based tree operations
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simple Lens for accessing/modifying nested structures.
   *       A Lens[S, A] has: get(s: S) -> A and set(s: S, a: A) -> S.
   *       Compose lenses for deep access.
   *       Apply to a nested case class tree to modify a deep node.
   *       Return the modified structure's value at the targeted path.
   *
   * @param values nested list representing a tree [[1,2],[3,4]]
   * @param path   path to modify (list of indices)
   * @param newVal new value
   * @return the modified nested list
   */
  def lensModifyNested(values: List[List[Int]], path: (Int, Int), newVal: Int): List[List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Church-encoded list algorithms
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement list operations using Church encoding.
   *       A Church-encoded list is a function:
   *       type ChurchList[A] = [B] => (A => B => B) => B => B
   *       Implement: fromList, toList, map, filter, fold using Church encoding.
   *       For testing: convert a Scala list to Church encoding,
   *       apply map (double each element), convert back.
   *       Return the resulting list.
   *
   * @param input  input list
   * @param factor multiply each element by this
   * @return result after Church-encoded map operation
   */
  def churchEncodedMap(input: List[Int], factor: Int): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Catamorphism (generalized fold)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement catamorphisms (generalized folds) for a tree ADT.
   *       sealed trait Tree[+A]
   *       case class Leaf[A](value: A) extends Tree[A]
   *       case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
   *
   *       cata takes: leafF: A => B, branchF: (B, B) => B
   *       and folds the tree bottom-up.
   *       Use it to compute: sum, depth, and mirror of a tree.
   *       Return (sum, depth, mirroredInOrder).
   *
   * @param values values to build a complete binary tree (level order)
   * @return (sum of all values, depth of tree, in-order of mirrored tree)
   */
  def treeCatamorphisms(values: List[Int]): (Int, Int, List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val dequeued = functionalQueueOps(List(
      ("enq", 1), ("enq", 2), ("enq", 3),
      ("deq", -1), ("deq", -1),
      ("enq", 4),
      ("deq", -1), ("deq", -1)
    ))
    assert(dequeued == List(1, 2, 3, 4), s"Expected List(1,2,3,4), got $dequeued")
    println("Exercise 1 (Functional queue) passed.")

    // Exercise 2
    val rbInOrder = functionalRBTreeInsert(List(5, 3, 7, 1, 4, 6, 8, 2))
    assert(rbInOrder == List(1, 2, 3, 4, 5, 6, 7, 8), s"Got $rbInOrder")
    println("Exercise 2 (Functional RB tree) passed.")

    // Exercise 3
    val (getVal, updVal) = persistentVectorOps(List(10, 20, 30, 40, 50), 2, 3, 99)
    assert(getVal == 30, s"Expected 30, got $getVal")
    assert(updVal == 99, s"Expected 99, got $updVal")
    println("Exercise 3 (Persistent vector) passed.")

    // Exercise 4
    val ftResult = fingerTreeDeque(List(
      ("pushF", 1), ("pushF", 2), ("pushB", 3), ("pushB", 4),
      ("popF", -1), ("popB", -1), ("popF", -1)
    ))
    assert(ftResult == List(2, 4, 1), s"Expected List(2,4,1), got $ftResult")
    println("Exercise 4 (Finger tree deque) passed.")

    // Exercise 5
    // Tree:     1
    //          / \
    //         2   3
    //        / \
    //       4   5
    // Path "L", "R" -> node 5, change to 99
    val modified = zipperTreeModify(List(1, 2, 3, 4, 5), List("L", "R"), 99)
    assert(modified.contains(99), s"Expected 99 in tree, got $modified")
    assert(!modified.contains(5), s"5 should be replaced")
    println(s"Exercise 5 (Zipper) passed. Modified=$modified")

    // Exercise 6
    val nested = List(List(1, 2), List(3, 4))
    val modNested = lensModifyNested(nested, (1, 0), 99)
    assert(modNested == List(List(1, 2), List(99, 4)), s"Got $modNested")
    println("Exercise 6 (Lens) passed.")

    // Exercise 7
    val churchResult = churchEncodedMap(List(1, 2, 3, 4), 3)
    assert(churchResult == List(3, 6, 9, 12), s"Got $churchResult")
    println("Exercise 7 (Church-encoded map) passed.")

    // Exercise 8
    // Tree:     1
    //          / \
    //         2   3
    //        / \  / \
    //       4  5 6  7
    val (sum, depth, mirrored) = treeCatamorphisms(List(1, 2, 3, 4, 5, 6, 7))
    assert(sum == 28, s"Expected sum=28, got $sum")
    assert(depth == 3, s"Expected depth=3, got $depth")
    assert(mirrored == List(7, 3, 6, 1, 5, 2, 4), s"Expected mirrored in-order, got $mirrored")
    println("Exercise 8 (Catamorphisms) passed.")

    println("All Algo124_FPAlgorithms exercises passed!")
  }
}
