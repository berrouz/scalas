package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Balanced BST - self-balancing binary search tree variants.
 *
 * Key concepts:
 * - AVL: height-balanced, |height(left) - height(right)| <= 1
 * - Rotations: LL, RR, LR, RL
 * - Red-Black: color-based balancing, less strict than AVL
 * - Treap: BST + heap property using random priorities
 */
object Algo085_BalancedBST {

  /** AVL Tree node */
  sealed trait AVLTree[+A]
  case object AVLEmpty extends AVLTree[Nothing]
  case class AVLNode[A](value: A, left: AVLTree[A], right: AVLTree[A], height: Int) extends AVLTree[A]

  /** Helper: get height */
  def avlHeight[A](t: AVLTree[A]): Int = t match {
    case AVLEmpty       => 0
    case AVLNode(_, _, _, h) => h
  }

  /** Helper: balance factor */
  def balanceFactor[A](t: AVLTree[A]): Int = t match {
    case AVLEmpty              => 0
    case AVLNode(_, l, r, _) => avlHeight(l) - avlHeight(r)
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: AVL tree insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a value into an AVL tree maintaining the balance invariant.
   *       After insertion, rebalance using rotations if needed.
   *       Return the new root.
   *
   * @param tree current AVL tree
   * @param value value to insert
   * @return new AVL tree with value inserted and balanced
   */
  def avlInsert(tree: AVLTree[Int], value: Int): AVLTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: AVL rotations (LL, RR, LR, RL)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the four AVL rotation cases.
   *       - rightRotate: for left-heavy (LL case)
   *       - leftRotate: for right-heavy (RR case)
   *       These are composed for LR and RL cases.
   *
   * @param tree unbalanced subtree
   * @return balanced subtree after rotation
   */
  def rightRotate(tree: AVLTree[Int]): AVLTree[Int] = {
    ???
  }

  def leftRotate(tree: AVLTree[Int]): AVLTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: AVL tree delete
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete a value from an AVL tree and rebalance.
   *       If node has two children, replace with in-order successor.
   *
   * @param tree AVL tree
   * @param value value to delete
   * @return new AVL tree with value removed and balanced
   */
  def avlDelete(tree: AVLTree[Int], value: Int): AVLTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Red-Black tree insert concept
  // ──────────────────────────────────────────────────────────────────────

  sealed trait Color
  case object Red extends Color
  case object Black extends Color

  sealed trait RBTree[+A]
  case object RBEmpty extends RBTree[Nothing]
  case class RBNode[A](color: Color, value: A, left: RBTree[A], right: RBTree[A]) extends RBTree[A]

  /**
   * TODO: Implement red-black tree insertion (Okasaki's functional approach).
   *       1. Insert as red node (standard BST insert)
   *       2. Balance: fix red-red violations
   *       3. Blacken the root
   *
   * @param tree red-black tree
   * @param value value to insert
   * @return new balanced red-black tree
   */
  def rbInsert(tree: RBTree[Int], value: Int): RBTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Red-Black tree properties verification
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Verify that a tree satisfies all red-black properties:
   *       1. Root is black
   *       2. Red nodes have black children
   *       3. All paths from root to leaves have same number of black nodes
   *       4. All values satisfy BST property
   *
   * @param tree red-black tree to verify
   * @return true if all properties hold
   */
  def isValidRBTree(tree: RBTree[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Splay tree concept
  // ──────────────────────────────────────────────────────────────────────

  sealed trait SplayTree[+A]
  case object SplayEmpty extends SplayTree[Nothing]
  case class SplayNode[A](value: A, left: SplayTree[A], right: SplayTree[A]) extends SplayTree[A]

  /**
   * TODO: Implement the splay operation: bring the accessed key to the root.
   *       Use zig, zig-zig, and zig-zag rotations.
   *       Return the splayed tree (accessed node at root).
   *       If key not found, splay the last accessed node.
   *
   * @param tree splay tree
   * @param key  key to splay
   * @return splayed tree with key at root (or closest)
   */
  def splay(tree: SplayTree[Int], key: Int): SplayTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Treap (tree + heap)
  // ──────────────────────────────────────────────────────────────────────

  case class TreapNode(key: Int, priority: Int, left: Option[TreapNode], right: Option[TreapNode])

  /**
   * TODO: Insert into a treap. The treap maintains BST property on keys
   *       and max-heap property on priorities.
   *       After BST insertion, rotate up if heap property is violated.
   *
   * @param root treap root (None if empty)
   * @param key  key to insert
   * @param priority priority (random)
   * @return new treap root
   */
  def treapInsert(root: Option[TreapNode], key: Int, priority: Int): Option[TreapNode] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Randomized BST - size-balanced insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a randomized BST where insertion at root happens with
   *       probability 1/(size+1), otherwise recurse into subtree.
   *       Root insertion uses split and merge.
   *       For simplicity, use a deterministic "insert at root" function.
   *
   * @param tree BST (using SplayTree structure for simplicity)
   * @param value value to insert at root
   * @return new tree with value at root
   */
  def insertAtRoot(tree: SplayTree[Int], value: Int): SplayTree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    var avl: AVLTree[Int] = AVLEmpty
    for (v <- List(10, 20, 30, 40, 50, 25)) avl = avlInsert(avl, v)
    assert(avlHeight(avl) <= 3, s"Height should be <= 3, got ${avlHeight(avl)}")
    println("Exercise 1 (AVL insert) passed.")

    // Exercise 2
    val unbalR = AVLNode(3, AVLNode(2, AVLNode(1, AVLEmpty, AVLEmpty, 1), AVLEmpty, 2), AVLEmpty, 3)
    val rotated = rightRotate(unbalR)
    assert(rotated.isInstanceOf[AVLNode[Int]])
    println("Exercise 2 (AVL rotations) passed.")

    // Exercise 3
    val avlDel = avlDelete(avl, 40)
    // Should still be balanced
    assert(math.abs(balanceFactor(avlDel)) <= 1)
    println("Exercise 3 (AVL delete) passed.")

    // Exercise 4
    var rb: RBTree[Int] = RBEmpty
    for (v <- List(10, 20, 30, 15, 25, 5)) rb = rbInsert(rb, v)
    println("Exercise 4 (RB insert) passed.")

    // Exercise 5
    assert(isValidRBTree(rb))
    println("Exercise 5 (RB validation) passed.")

    // Exercise 6
    val sp = SplayNode(5, SplayNode(3, SplayNode(1, SplayEmpty, SplayEmpty), SplayNode(4, SplayEmpty, SplayEmpty)), SplayNode(7, SplayEmpty, SplayEmpty))
    val splayed = splay(sp, 3)
    assert(splayed.isInstanceOf[SplayNode[Int]])
    println("Exercise 6 (Splay) passed.")

    // Exercise 7
    var treap: Option[TreapNode] = None
    treap = treapInsert(treap, 5, 10)
    treap = treapInsert(treap, 3, 20)
    treap = treapInsert(treap, 7, 15)
    assert(treap.get.priority == 20) // max priority at root
    println("Exercise 7 (Treap) passed.")

    // Exercise 8
    val bst8 = SplayNode(5, SplayNode(3, SplayEmpty, SplayEmpty), SplayNode(7, SplayEmpty, SplayEmpty))
    val rooted = insertAtRoot(bst8, 4)
    assert(rooted match { case SplayNode(v, _, _) => v == 4; case _ => false })
    println("Exercise 8 (Randomized BST) passed.")

    println("All Algo085_BalancedBST exercises passed!")
  }
}
