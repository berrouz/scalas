package org.shev4ik.interview.algorithms.level2_intermediate

object Algo044_UnionFind {

  // Exercise 1: Basic Union-Find — implement find and union without optimizations
  // TODO: parent array where parent(i) = i initially. find follows parent chain. union sets parent.
  class BasicUnionFind(n: Int) {
    val parent: Array[Int] = Array.tabulate(n)(identity)

    def find(x: Int): Int = ???
    def union(x: Int, y: Int): Unit = ???
    def connected(x: Int, y: Int): Boolean = ???
  }

  // Exercise 2: Union-Find with union by rank
  // TODO: Track rank. On union, attach smaller rank tree under larger rank root.
  class UnionFindByRank(n: Int) {
    val parent: Array[Int] = Array.tabulate(n)(identity)
    val rank: Array[Int] = Array.fill(n)(0)

    def find(x: Int): Int = ???
    def union(x: Int, y: Int): Unit = ???
  }

  // Exercise 3: Union-Find with path compression
  // TODO: During find, make every node on the path point directly to root.
  class UnionFindPathCompression(n: Int) {
    val parent: Array[Int] = Array.tabulate(n)(identity)

    def find(x: Int): Int = ???
    def union(x: Int, y: Int): Unit = ???
  }

  // Exercise 4: Count connected components using Union-Find
  // TODO: Process all edges with union. Count distinct roots.
  def countComponents(n: Int, edges: List[(Int, Int)]): Int = ???

  // Exercise 5: Number of Provinces — connected components in adjacency matrix
  // TODO: For each pair (i,j) with isConnected(i)(j)==1, union i and j. Count roots.
  def findCircleNum(isConnected: Array[Array[Int]]): Int = ???

  // Exercise 6: Accounts Merge — merge accounts with same email, return merged accounts
  // TODO: Map emails to account index. Union accounts sharing an email. Group by root.
  // Input: List of (name, List[email]). Output: List of (name, sorted List[email]).
  def accountsMerge(accounts: List[(String, List[String])]): List[(String, List[String])] = ???

  // Exercise 7: Redundant Connection using Union-Find — find the edge that creates a cycle
  // TODO: Process edges. If two nodes already connected, that edge is redundant.
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = ???

  // Exercise 8: Earliest time when all nodes become connected
  // TODO: Sort edges by time. Process in order using UF. When components == 1, return that time. -1 if never.
  def earliestAllConnected(n: Int, logs: Array[(Int, Int, Int)]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val uf1 = new BasicUnionFind(5)
    uf1.union(0, 1)
    uf1.union(1, 2)
    assert(uf1.connected(0, 2), "0 and 2 connected")
    assert(!uf1.connected(0, 3), "0 and 3 not connected")

    // Exercise 2
    val uf2 = new UnionFindByRank(5)
    uf2.union(0, 1)
    uf2.union(2, 3)
    uf2.union(1, 3)
    assert(uf2.find(0) == uf2.find(3), "All connected by rank")

    // Exercise 3
    val uf3 = new UnionFindPathCompression(5)
    uf3.union(0, 1)
    uf3.union(1, 2)
    uf3.union(2, 3)
    uf3.find(3) // triggers path compression
    assert(uf3.parent(3) == uf3.find(0), "Path compression applied")

    // Exercise 4
    assert(countComponents(5, List((0, 1), (1, 2), (3, 4))) == 2, "2 components")

    // Exercise 5
    val conn = Array(Array(1, 1, 0), Array(1, 1, 0), Array(0, 0, 1))
    assert(findCircleNum(conn) == 2, "2 provinces")

    // Exercise 6
    val accts = List(
      ("John", List("john@mail.com", "john2@mail.com")),
      ("John", List("john@mail.com", "john3@mail.com")),
      ("Mary", List("mary@mail.com"))
    )
    val merged = accountsMerge(accts)
    assert(merged.exists { case (name, emails) => name == "John" && emails.size == 3 }, "John's accounts merged")

    // Exercise 7
    assert(findRedundantConnection(Array(Array(1, 2), Array(1, 3), Array(2, 3))).toList == List(2, 3),
      "Redundant edge")

    // Exercise 8
    // logs: (timestamp, node1, node2)
    val logs = Array((0, 0, 1), (1, 1, 2), (2, 2, 3))
    assert(earliestAllConnected(4, logs) == 2, "All connected at time 2")

    println("All Algo044_UnionFind exercises passed!")
  }
}
