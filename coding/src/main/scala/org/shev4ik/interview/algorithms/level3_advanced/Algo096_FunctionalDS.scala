package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Functional (Persistent) Data Structures - immutable versions with efficient updates.
 *
 * Key concepts:
 * - Path copying: share unchanged parts, copy only modified path
 * - Persistent = all versions remain accessible after modification
 * - Fat node: store all versions in each node
 * - Confluent persistence: can merge different versions
 */
object Algo096_FunctionalDS {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Persistent stack
  // ──────────────────────────────────────────────────────────────────────

  sealed trait PStack[+A]
  case object PStackEmpty extends PStack[Nothing]
  case class PStackCons[A](head: A, tail: PStack[A]) extends PStack[A]

  /**
   * TODO: Implement a persistent stack with push, pop, and top.
   *       Each operation returns a new stack; the old one remains unchanged.
   *       push returns new stack.
   *       pop returns (top element, remaining stack).
   *
   * @return (push, pop, top, isEmpty) functions
   */
  def persistentStack[A](): (
    (PStack[A], A) => PStack[A],           // push
    PStack[A] => Option[(A, PStack[A])],   // pop
    PStack[A] => Option[A],                // top
    PStack[A] => Boolean                   // isEmpty
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Persistent queue (Banker's queue)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a persistent queue using the Banker's method.
   *       Use two lists (front and rear). When front is empty, reverse rear.
   *       Amortized O(1) enqueue and dequeue.
   *
   * @return (enqueue, dequeue, front, isEmpty)
   */
  case class BankersQueue[A](front: List[A], rear: List[A])

  def emptyQueue[A]: BankersQueue[A] = BankersQueue(Nil, Nil)

  def enqueue[A](q: BankersQueue[A], elem: A): BankersQueue[A] = {
    ???
  }

  def dequeue[A](q: BankersQueue[A]): Option[(A, BankersQueue[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Persistent linked list
  // ──────────────────────────────────────────────────────────────────────

  sealed trait PList[+A]
  case object PNil extends PList[Nothing]
  case class PCons[A](head: A, tail: PList[A]) extends PList[A]

  /**
   * TODO: Implement persistent list operations:
   *       - prepend: add element at front (O(1))
   *       - update: change element at index (O(n), but shares tail)
   *       - get: retrieve element at index
   *
   * @param list persistent list
   * @param idx  index
   * @param elem new element (for update)
   */
  def pListPrepend[A](list: PList[A], elem: A): PList[A] = {
    ???
  }

  def pListUpdate[A](list: PList[A], idx: Int, elem: A): PList[A] = {
    ???
  }

  def pListGet[A](list: PList[A], idx: Int): Option[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Persistent BST
  // ──────────────────────────────────────────────────────────────────────

  sealed trait PBST[+A]
  case object PBSTEmpty extends PBST[Nothing]
  case class PBSTNode[A](value: A, left: PBST[A], right: PBST[A]) extends PBST[A]

  /**
   * TODO: Implement persistent BST insert.
   *       Creates a new path from root to inserted node; shares all other nodes.
   *       O(h) new nodes created, where h is the height.
   *
   * @param tree current BST
   * @param value value to insert
   * @return new BST with value inserted
   */
  def pbstInsert(tree: PBST[Int], value: Int): PBST[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Fat node method
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simple "fat node" persistent array.
   *       Each cell stores a list of (version, value) pairs.
   *       - set(version, idx, val): store value at idx for given version
   *       - get(version, idx): retrieve value at idx for given version
   *       Return (set, get) functions.
   *
   * @param size  array size
   * @param initVal initial value for all cells
   * @return (set, get) functions
   */
  def fatNodeArray(size: Int, initVal: Int): ((Int, Int, Int) => Unit, (Int, Int) => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Path copying explanation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Demonstrate path copying on a binary tree.
   *       Given a BST, insert a value and return both old and new trees.
   *       Verify that unchanged subtrees are shared (same reference).
   *       Return (oldTree, newTree, sharedNodes count).
   *
   * @param tree  original BST
   * @param value value to insert
   * @return (old tree, new tree, number of shared nodes)
   */
  def pathCopyingDemo(tree: PBST[Int], value: Int): (PBST[Int], PBST[Int], Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Confluent persistence concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simple version of confluent persistence:
   *       merge two persistent lists into one.
   *       Given two persistent lists, create a new list that is the concatenation.
   *       Note: this creates a new version that depends on two previous versions.
   *
   * @param list1 first list
   * @param list2 second list
   * @return concatenated persistent list
   */
  def confluentConcat[A](list1: PList[A], list2: PList[A]): PList[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Version tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a version tree where each version is derived from a parent version.
   *       Support: create new version from existing, get data at any version.
   *       Internally, store a map from version ID to (parent version, modifications).
   *       Use path traversal to reconstruct state at any version.
   *
   * @param initialData initial array data
   * @return (createVersion: (parentVersion, idx, val) => newVersionId,
   *          getData: (versionId, idx) => value)
   */
  def versionTree(initialData: Array[Int]): ((Int, Int, Int) => Int, (Int, Int) => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (push, pop, top, isEmpty) = persistentStack[Int]()
    val s0: PStack[Int] = PStackEmpty
    val s1 = push(s0, 1)
    val s2 = push(s1, 2)
    assert(top(s2).contains(2))
    assert(top(s1).contains(1)) // s1 unchanged
    val Some((v, s3)) = pop(s2): @unchecked
    assert(v == 2)
    assert(top(s3).contains(1))
    println("Exercise 1 (Persistent stack) passed.")

    // Exercise 2
    val q0 = emptyQueue[Int]
    val q1 = enqueue(q0, 1)
    val q2 = enqueue(q1, 2)
    val Some((v2, q3)) = dequeue(q2): @unchecked
    assert(v2 == 1)
    val Some((v3, _)) = dequeue(q3): @unchecked
    assert(v3 == 2)
    println("Exercise 2 (Banker's queue) passed.")

    // Exercise 3
    val l0: PList[Int] = PNil
    val l1 = pListPrepend(l0, 3)
    val l2 = pListPrepend(l1, 2)
    val l3 = pListPrepend(l2, 1)
    assert(pListGet(l3, 0).contains(1))
    assert(pListGet(l3, 2).contains(3))
    val l4 = pListUpdate(l3, 1, 99)
    assert(pListGet(l4, 1).contains(99))
    assert(pListGet(l3, 1).contains(2)) // l3 unchanged
    println("Exercise 3 (Persistent list) passed.")

    // Exercise 4
    var bst: PBST[Int] = PBSTEmpty
    val bst1 = pbstInsert(bst, 5)
    val bst2 = pbstInsert(bst1, 3)
    val bst3 = pbstInsert(bst2, 7)
    // bst1 should still just have 5
    assert(bst1 match { case PBSTNode(5, PBSTEmpty, PBSTEmpty) => true; case _ => false })
    println("Exercise 4 (Persistent BST) passed.")

    // Exercise 5
    val (fnSet, fnGet) = fatNodeArray(3, 0)
    fnSet(1, 0, 10)
    fnSet(2, 1, 20)
    assert(fnGet(1, 0) == 10)
    assert(fnGet(0, 0) == 0) // version 0 unchanged
    assert(fnGet(2, 1) == 20)
    println("Exercise 5 (Fat node) passed.")

    // Exercise 6
    val demoTree = PBSTNode(5, PBSTNode(3, PBSTEmpty, PBSTEmpty), PBSTNode(7, PBSTEmpty, PBSTEmpty))
    val (oldT, newT, shared) = pathCopyingDemo(demoTree, 6)
    assert(shared >= 1) // at least left subtree should be shared
    println("Exercise 6 (Path copying demo) passed.")

    // Exercise 7
    val la = PCons(1, PCons(2, PNil))
    val lb = PCons(3, PCons(4, PNil))
    val lc = confluentConcat(la, lb)
    assert(pListGet(lc, 0).contains(1))
    assert(pListGet(lc, 3).contains(4))
    println("Exercise 7 (Confluent concat) passed.")

    // Exercise 8
    val (createVer, getData) = versionTree(Array(0, 0, 0))
    val v1id = createVer(0, 0, 10) // version 1: set index 0 to 10
    val v2id = createVer(v1id, 1, 20) // version 2: set index 1 to 20
    assert(getData(v2id, 0) == 10)
    assert(getData(v2id, 1) == 20)
    assert(getData(0, 0) == 0) // original unchanged
    println("Exercise 8 (Version tree) passed.")

    println("All Algo096_FunctionalDS exercises passed!")
  }
}
