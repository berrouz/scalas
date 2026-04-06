package org.shev4ik.interview.algorithms.level3_advanced

/**
 * B-Tree - balanced tree for disk-based storage and databases.
 *
 * Key concepts:
 * - All leaves at same depth
 * - Node has between t-1 and 2t-1 keys (t = minimum degree)
 * - Root can have as few as 1 key
 * - Optimized for systems that read/write large blocks of data
 */
object Algo086_BTree {

  /** B-tree node */
  case class BTreeNode(
    keys: Vector[Int],
    children: Vector[BTreeNode],
    isLeaf: Boolean
  )

  /** B-tree with minimum degree t */
  case class BTree(root: Option[BTreeNode], t: Int)

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: B-tree properties check
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Verify that a B-tree satisfies all properties:
   *       1. All leaves at same depth
   *       2. Every non-root node has at least t-1 keys
   *       3. Every node has at most 2t-1 keys
   *       4. Keys within each node are sorted
   *       5. Number of children = number of keys + 1 (for non-leaf)
   *
   * @param tree B-tree to validate
   * @return true if valid B-tree
   */
  def isValidBTree(tree: BTree): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: B-tree search
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for a key in a B-tree.
   *       Return Some((node, index)) if found, None otherwise.
   *       At each node, find the appropriate child to descend into.
   *
   * @param tree B-tree
   * @param key  key to search
   * @return Option of (node containing key, index within node)
   */
  def bTreeSearch(tree: BTree, key: Int): Option[(BTreeNode, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: B-tree insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Insert a key into a B-tree. If root is full, split it first.
   *       Use proactive splitting: split full nodes on the way down.
   *       Return the new B-tree.
   *
   * @param tree B-tree
   * @param key  key to insert
   * @return new B-tree with key inserted
   */
  def bTreeInsert(tree: BTree, key: Int): BTree = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: B-tree split child
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Split the i-th child of node which is full (has 2t-1 keys).
   *       The median key moves up to the parent.
   *       Return the updated parent node.
   *
   * @param parent parent node
   * @param i      index of full child
   * @param t      minimum degree
   * @return updated parent after split
   */
  def splitChild(parent: BTreeNode, i: Int, t: Int): BTreeNode = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: B-tree delete concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Delete a key from a B-tree. Handle three cases:
   *       1. Key in leaf: simply remove
   *       2. Key in internal node: replace with predecessor/successor
   *       3. Key not in node: ensure child has >= t keys before descending
   *       Return the new B-tree.
   *
   * @param tree B-tree
   * @param key  key to delete
   * @return new B-tree with key removed
   */
  def bTreeDelete(tree: BTree, key: Int): BTree = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: B+ tree concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate a B+ tree where all data is in leaves and internal nodes
   *       only contain keys for routing. Leaves form a linked list.
   *       Implement a range query: find all keys in [lo, hi].
   *
   * @param keys   sorted list of all keys (simulating leaf-level data)
   * @param lo     lower bound (inclusive)
   * @param hi     upper bound (inclusive)
   * @return list of keys in range
   */
  def bPlusRangeQuery(keys: List[Int], lo: Int, hi: Int): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: B-tree order / degree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a B-tree, determine its minimum degree t.
   *       t = ceil(maxChildren / 2) where maxChildren = max keys + 1.
   *       Inspect the tree to find the maximum number of keys in any node.
   *
   * @param tree B-tree
   * @return minimum degree t
   */
  def determineDegree(tree: BTree): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Database index analogy
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate a simple database index using a sorted collection.
   *       Support: insert key, search key, range query [lo, hi], delete key.
   *       Model it as a class with immutable state (return new state after mutation).
   *       For simplicity, use a sorted Vector internally.
   *
   * @param data sorted vector of keys (initial state)
   * @return functions for (insert, search, rangeQuery, delete)
   */
  def createIndex(data: Vector[Int]): (
    Int => Vector[Int],              // insert
    Int => Boolean,                   // search
    (Int, Int) => Vector[Int],       // rangeQuery
    Int => Vector[Int]               // delete
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val t = 2 // minimum degree

    // Exercise 1
    val leaf1 = BTreeNode(Vector(1, 2), Vector.empty, isLeaf = true)
    val leaf2 = BTreeNode(Vector(4, 5), Vector.empty, isLeaf = true)
    val leaf3 = BTreeNode(Vector(7, 8), Vector.empty, isLeaf = true)
    val root = BTreeNode(Vector(3, 6), Vector(leaf1, leaf2, leaf3), isLeaf = false)
    val tree = BTree(Some(root), t)
    assert(isValidBTree(tree))
    println("Exercise 1 (B-tree properties) passed.")

    // Exercise 2
    val found = bTreeSearch(tree, 5)
    assert(found.isDefined)
    assert(found.get._2 == 1) // index 1 in leaf2
    assert(bTreeSearch(tree, 9).isEmpty)
    println("Exercise 2 (B-tree search) passed.")

    // Exercise 3
    var bt = BTree(None, 2)
    for (k <- List(10, 20, 5, 6, 12, 30, 7, 17)) bt = bTreeInsert(bt, k)
    assert(bTreeSearch(bt, 12).isDefined)
    assert(bTreeSearch(bt, 99).isEmpty)
    println("Exercise 3 (B-tree insert) passed.")

    // Exercise 4
    val fullChild = BTreeNode(Vector(1, 2, 3), Vector.empty, isLeaf = true)
    val parentNode = BTreeNode(Vector(5), Vector(fullChild, BTreeNode(Vector(7), Vector.empty, isLeaf = true)), isLeaf = false)
    val split = splitChild(parentNode, 0, 2)
    assert(split.keys.contains(2))
    println("Exercise 4 (Split child) passed.")

    // Exercise 5
    val btDel = bTreeDelete(bt, 6)
    assert(bTreeSearch(btDel, 6).isEmpty)
    println("Exercise 5 (B-tree delete) passed.")

    // Exercise 6
    val rq = bPlusRangeQuery(List(1, 3, 5, 7, 9, 11), 3, 9)
    assert(rq == List(3, 5, 7, 9))
    println("Exercise 6 (B+ range query) passed.")

    // Exercise 7
    val deg = determineDegree(tree)
    assert(deg == 2, s"Expected 2, got $deg")
    println("Exercise 7 (Determine degree) passed.")

    // Exercise 8
    val (ins, srch, rng, del) = createIndex(Vector(1, 3, 5, 7))
    assert(srch(3))
    assert(!srch(4))
    assert(rng(2, 6) == Vector(3, 5))
    val afterIns = ins(4)
    assert(afterIns == Vector(1, 3, 4, 5, 7))
    val afterDel = del(3)
    assert(afterDel == Vector(1, 5, 7))
    println("Exercise 8 (Database index) passed.")

    println("All Algo086_BTree exercises passed!")
  }
}
