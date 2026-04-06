package org.shev4ik.interview.algorithms.level4_expert

/**
 * Link-Cut Tree - dynamic tree structure using splay trees.
 *
 * Key concepts:
 * - Represented forest where trees can be linked and cut dynamically
 * - Preferred path decomposition using splay trees
 * - Access operation: makes root-to-v path preferred
 * - O(log n) amortized for link, cut, find root, path queries
 */
object Algo112_LinkCutTree {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Link-cut tree concept - node structure
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Define the link-cut tree node structure and initialize n nodes.
   *       Each node has: parent, left child, right child (splay tree),
   *       a value, and an aggregate for path queries.
   *       Return the number of initialized nodes (should equal n).
   *       Nodes are 0-indexed.
   *
   * @param n number of nodes
   * @return number of initialized nodes
   */
  def initLinkCutTree(n: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Access operation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the access(v) operation.
   *       This makes the path from v to the root of its tree a preferred path.
   *       Steps: splay v, cut preferred child, walk up splaying and linking.
   *       After access, v is the root of its auxiliary splay tree.
   *       For testing: given edges forming a path 0-1-2-..-(n-1),
   *       access node v, then return the depth of node v in the
   *       splay tree (root has depth 0).
   *
   * @param n     number of nodes
   * @param edges list of (parent, child) edges
   * @param v     node to access
   * @return depth of v in its splay tree after access (should be 0)
   */
  def access(n: Int, edges: List[(Int, Int)], v: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Splay operation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement splay(v) for the auxiliary splay tree.
   *       Perform zig, zig-zig, or zig-zag rotations until v is root.
   *       For testing: build a chain 0-1-2-3-4, splay node 4,
   *       return true if node 4 becomes the splay tree root.
   *
   * @param n     number of nodes
   * @param edges edges forming a tree
   * @param v     node to splay
   * @return true if v becomes root of its splay tree
   */
  def splay(n: Int, edges: List[(Int, Int)], v: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Link two trees
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement link(u, v): make u a child of v.
   *       Precondition: u and v are in different trees, u is a root.
   *       After linking, u's tree is attached under v.
   *       For testing: start with n isolated nodes, perform links,
   *       then return true if findRoot of u equals findRoot of v.
   *
   * @param n     number of nodes
   * @param links list of (u, v) link operations to perform
   * @return true if all linked nodes share the same root
   */
  def link(n: Int, links: List[(Int, Int)]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Cut a node from its parent
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement cut(v): disconnect v from its parent.
   *       After cutting, v becomes the root of its own tree.
   *       For testing: build a path, cut node v, return true if
   *       findRoot(v) == v.
   *
   * @param n     number of nodes
   * @param edges initial edges forming a tree
   * @param v     node to cut from its parent
   * @return true if v is the root of its own tree after cut
   */
  def cut(n: Int, edges: List[(Int, Int)], v: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Find root of a node's tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement findRoot(v): find the root of the tree containing v.
   *       Access v, then walk to the leftmost node in the splay tree.
   *       For testing: given a tree, return the root of v's tree.
   *
   * @param n     number of nodes
   * @param edges edges forming the tree (parent, child)
   * @param v     node to find root for
   * @return root of the tree containing v
   */
  def findRoot(n: Int, edges: List[(Int, Int)], v: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Path aggregate query (path sum)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the sum of values on the path from u to v.
   *       Use makeRoot(u) + access(v), then the splay tree of v
   *       holds the entire path, and its aggregate is the answer.
   *       Each node has value = nodeIndex + 1.
   *
   * @param n     number of nodes
   * @param edges edges forming the tree
   * @param u     one endpoint
   * @param v     other endpoint
   * @return sum of node values on path from u to v (inclusive)
   */
  def pathSum(n: Int, edges: List[(Int, Int)], u: Int, v: Int): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Dynamic connectivity queries
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support a sequence of operations:
   *       - "link u v": link u and v
   *       - "cut u v": cut edge between u and v
   *       - "connected u v": query if u and v are in the same tree
   *       Return the list of boolean answers for "connected" queries.
   *
   * @param n          number of nodes
   * @param operations list of ("link"/"cut"/"connected", u, v)
   * @return list of boolean answers for connected queries
   */
  def dynamicConnectivity(n: Int, operations: List[(String, Int, Int)]): List[Boolean] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val nodes = initLinkCutTree(10)
    assert(nodes == 10, s"Expected 10, got $nodes")
    println("Exercise 1 (Init link-cut tree) passed.")

    // Exercise 2
    val depth = access(5, List((0,1),(1,2),(2,3),(3,4)), 4)
    assert(depth == 0, s"Expected 0 (root of splay), got $depth")
    println("Exercise 2 (Access) passed.")

    // Exercise 3
    val isRoot = splay(5, List((0,1),(1,2),(2,3),(3,4)), 4)
    assert(isRoot, "Expected node 4 to be splay root")
    println("Exercise 3 (Splay) passed.")

    // Exercise 4
    val linked = link(5, List((1,0), (2,0), (3,1), (4,1)))
    assert(linked, "Expected all nodes connected after linking")
    println("Exercise 4 (Link) passed.")

    // Exercise 5
    val isCutRoot = cut(5, List((0,1),(1,2),(2,3),(3,4)), 2)
    assert(isCutRoot, "Expected node 2 to be root after cut")
    println("Exercise 5 (Cut) passed.")

    // Exercise 6
    val root = findRoot(5, List((0,1),(1,2),(2,3),(3,4)), 4)
    assert(root == 0, s"Expected root 0, got $root")
    println("Exercise 6 (Find root) passed.")

    // Exercise 7
    // Tree: 0-1-2-3-4, values = 1,2,3,4,5
    // Path 1 to 3: nodes 1,2,3 -> sum = 2+3+4 = 9
    val psum = pathSum(5, List((0,1),(1,2),(2,3),(3,4)), 1, 3)
    assert(psum == 9, s"Expected 9, got $psum")
    println("Exercise 7 (Path sum) passed.")

    // Exercise 8
    val results = dynamicConnectivity(5, List(
      ("link", 0, 1),
      ("link", 1, 2),
      ("connected", 0, 2),  // true
      ("connected", 0, 3),  // false
      ("link", 3, 4),
      ("link", 2, 3),
      ("connected", 0, 4),  // true
      ("cut", 1, 2),
      ("connected", 0, 3)   // false
    ))
    assert(results == List(true, false, true, false), s"Expected List(true,false,true,false), got $results")
    println("Exercise 8 (Dynamic connectivity) passed.")

    println("All Algo112_LinkCutTree exercises passed!")
  }
}
