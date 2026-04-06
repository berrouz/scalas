package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Zipper - a functional technique for navigating and modifying immutable data structures.
 *
 * Key concepts:
 * - Zipper = (focus, context) - current element + how to get back
 * - Enables O(1) local modifications in immutable structures
 * - Context stores the "path" back to the root
 * - Common for trees, lists, and other recursive structures
 */
object Algo098_ZipperTree {

  /** Binary tree */
  sealed trait Tree[+A]
  case object Leaf extends Tree[Nothing]
  case class Branch[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

  /** Context for navigating back up the tree */
  sealed trait Context[+A]
  case object Top extends Context[Nothing]
  case class LeftCtx[A](value: A, right: Tree[A], parent: Context[A]) extends Context[A]
  case class RightCtx[A](value: A, left: Tree[A], parent: Context[A]) extends Context[A]

  /** Tree zipper = focus tree + context */
  case class TreeZipper[A](focus: Tree[A], context: Context[A])

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Tree zipper definition - create from tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Create a tree zipper focused on the root of the given tree.
   *
   * @param tree the tree to create a zipper from
   * @return zipper focused on root
   */
  def fromTree[A](tree: Tree[A]): TreeZipper[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Move left/right/up
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement navigation operations for the tree zipper.
   *       - moveLeft: focus on left child
   *       - moveRight: focus on right child
   *       - moveUp: focus on parent
   *       Return None if movement is not possible.
   */
  def moveLeft[A](z: TreeZipper[A]): Option[TreeZipper[A]] = {
    ???
  }

  def moveRight[A](z: TreeZipper[A]): Option[TreeZipper[A]] = {
    ???
  }

  def moveUp[A](z: TreeZipper[A]): Option[TreeZipper[A]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Modify at focus
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Modify the value at the current focus.
   *       Return None if focus is a Leaf.
   *
   * @param z zipper
   * @param f transformation function
   * @return updated zipper
   */
  def modify[A](z: TreeZipper[A], f: A => A): Option[TreeZipper[A]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Insert at focus
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Replace the current focus with a new subtree.
   *       This effectively "inserts" a new subtree at the current position.
   *
   * @param z       zipper
   * @param newTree tree to place at focus
   * @return updated zipper
   */
  def insertAtFocus[A](z: TreeZipper[A], newTree: Tree[A]): TreeZipper[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Delete at focus
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete the subtree at the current focus (replace with Leaf).
   *       Return the zipper focused on the Leaf.
   *
   * @param z zipper
   * @return zipper with focus replaced by Leaf
   */
  def deleteAtFocus[A](z: TreeZipper[A]): TreeZipper[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Zipper for list
  // ──────────────────────────────────────────────────────────────────────

  /**
   * TODO: Implement a list zipper.
   *       ListZipper = (left elements reversed, focus, right elements)
   *       Support: moveLeftL, moveRightL, modifyL, insertL, deleteL.
   */
  case class ListZipper[A](left: List[A], focus: A, right: List[A])

  def listZipperFromList[A](list: List[A]): Option[ListZipper[A]] = {
    ???
  }

  def moveLeftL[A](z: ListZipper[A]): Option[ListZipper[A]] = {
    ???
  }

  def moveRightL[A](z: ListZipper[A]): Option[ListZipper[A]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Zipper for binary tree - reconstruct tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Convert a tree zipper back to a tree by moving up to the root.
   *       Navigate up until context is Top, then return the focus.
   *
   * @param z tree zipper
   * @return reconstructed tree
   */
  def toTree[A](z: TreeZipper[A]): Tree[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Zipper applications - find and modify
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Navigate a BST using zipper to find a value, then modify it.
   *       If found, apply the modification function and reconstruct the tree.
   *       If not found, return the original tree.
   *
   * @param tree tree to search
   * @param target value to find
   * @param f modification function
   * @return modified tree (or original if not found)
   */
  def findAndModify(tree: Tree[Int], target: Int, f: Int => Int): Tree[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val tree = Branch(1,
      Branch(2, Branch(4, Leaf, Leaf), Branch(5, Leaf, Leaf)),
      Branch(3, Leaf, Branch(6, Leaf, Leaf))
    )

    // Exercise 1
    val z0 = fromTree(tree)
    assert(z0.focus == tree)
    assert(z0.context == Top)
    println("Exercise 1 (From tree) passed.")

    // Exercise 2
    val z1 = moveLeft(z0)
    assert(z1.isDefined)
    assert(z1.get.focus match { case Branch(2, _, _) => true; case _ => false })
    val z2 = moveRight(z0)
    assert(z2.get.focus match { case Branch(3, _, _) => true; case _ => false })
    val z3 = moveUp(z1.get)
    assert(z3.get.focus match { case Branch(1, _, _) => true; case _ => false })
    println("Exercise 2 (Navigation) passed.")

    // Exercise 3
    val z4 = modify(z1.get, (x: Int) => x * 10)
    assert(z4.get.focus match { case Branch(20, _, _) => true; case _ => false })
    println("Exercise 3 (Modify) passed.")

    // Exercise 4
    val newSubtree = Branch(99, Leaf, Leaf)
    val z5 = moveRight(z0).map(z => insertAtFocus(z, newSubtree))
    assert(z5.get.focus == newSubtree)
    println("Exercise 4 (Insert) passed.")

    // Exercise 5
    val z6 = moveLeft(z0).map(deleteAtFocus)
    assert(z6.get.focus == Leaf)
    println("Exercise 5 (Delete) passed.")

    // Exercise 6
    val lz = listZipperFromList(List(1, 2, 3, 4, 5))
    assert(lz.isDefined)
    assert(lz.get.focus == 1)
    val lz2 = moveRightL(lz.get)
    assert(lz2.get.focus == 2)
    val lz3 = moveLeftL(lz2.get)
    assert(lz3.get.focus == 1)
    println("Exercise 6 (List zipper) passed.")

    // Exercise 7
    val z7 = moveLeft(moveLeft(z0).get)
    val reconstructed = toTree(z7.get)
    assert(reconstructed == tree) // should reconstruct original tree
    println("Exercise 7 (Reconstruct) passed.")

    // Exercise 8
    val bst = Branch(5, Branch(3, Branch(1, Leaf, Leaf), Branch(4, Leaf, Leaf)), Branch(7, Leaf, Leaf))
    val modified = findAndModify(bst, 3, _ * 100)
    assert(modified match {
      case Branch(5, Branch(300, _, _), _) => true
      case _ => false
    })
    val unchanged = findAndModify(bst, 99, _ * 100)
    assert(unchanged == bst)
    println("Exercise 8 (Find and modify) passed.")

    println("All Algo098_ZipperTree exercises passed!")
  }
}
