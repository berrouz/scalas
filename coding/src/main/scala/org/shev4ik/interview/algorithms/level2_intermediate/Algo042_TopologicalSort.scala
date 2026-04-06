package org.shev4ik.interview.algorithms.level2_intermediate

object Algo042_TopologicalSort {

  // Exercise 1: Kahn's algorithm — BFS-based topological sort
  // TODO: Compute in-degrees. Enqueue nodes with 0 in-degree. Process queue, decrementing neighbors' in-degrees.
  def kahnsAlgorithm(n: Int, edges: List[(Int, Int)]): List[Int] = ???

  // Exercise 2: DFS-based topological sort
  // TODO: DFS from each unvisited node. Prepend to result after visiting all descendants.
  def dfsTopologicalSort(n: Int, edges: List[(Int, Int)]): List[Int] = ???

  // Exercise 3: Course Schedule — can all courses be finished? (cycle detection in directed graph)
  // TODO: Build graph from prerequisites. If topological sort includes all nodes, return true.
  def canFinish(numCourses: Int, prerequisites: List[(Int, Int)]): Boolean = ???

  // Exercise 4: Course Schedule II — return a valid order to take all courses
  // TODO: Topological sort. Return empty list if cycle exists.
  def findOrder(numCourses: Int, prerequisites: List[(Int, Int)]): List[Int] = ???

  // Exercise 5: Alien Dictionary — determine order of characters from sorted alien words
  // TODO: Build graph from adjacent word pairs. For each pair, find first differing char => edge. Topological sort.
  def alienOrder(words: List[String]): String = ???

  // Exercise 6: Sequence Reconstruction — check if original sequence is uniquely reconstructible from subsequences
  // TODO: Build graph from subsequences. Topological sort. Check that at each step queue has exactly one element.
  def sequenceReconstruction(original: List[Int], sequences: List[List[Int]]): Boolean = ???

  // Exercise 7: Parallel Courses — minimum semesters to take all courses (longest path in DAG)
  // TODO: Topological sort level by level. Number of levels = minimum semesters. Return -1 if cycle.
  def minimumSemesters(n: Int, relations: List[(Int, Int)]): Int = ???

  // Exercise 8: Minimum semesters to complete all courses with max k courses per semester
  // TODO: Similar to parallel courses but cap at k courses per level. Return minimum levels needed.
  def minSemestersWithLimit(n: Int, relations: List[(Int, Int)], k: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val edges = List((5, 2), (5, 0), (4, 0), (4, 1), (2, 3), (3, 1))
    val kahn = kahnsAlgorithm(6, edges)
    assert(kahn.size == 6, "All nodes in topological order")
    // Verify order: for each edge (u,v), u appears before v
    edges.foreach { case (u, v) => assert(kahn.indexOf(u) < kahn.indexOf(v), s"$u before $v") }

    // Exercise 2
    val dfsOrder = dfsTopologicalSort(6, edges)
    assert(dfsOrder.size == 6, "All nodes in DFS topo order")
    edges.foreach { case (u, v) => assert(dfsOrder.indexOf(u) < dfsOrder.indexOf(v), s"$u before $v in DFS") }

    // Exercise 3
    assert(canFinish(4, List((1, 0), (2, 1), (3, 2))), "Can finish linear chain")
    assert(!canFinish(2, List((0, 1), (1, 0))), "Cannot finish with cycle")

    // Exercise 4
    val order = findOrder(4, List((1, 0), (2, 0), (3, 1), (3, 2)))
    assert(order.nonEmpty, "Valid order exists")
    assert(order.indexOf(0) < order.indexOf(1), "0 before 1")

    // Exercise 5
    assert(alienOrder(List("wrt", "wrf", "er", "ett", "rftt")).nonEmpty, "Alien order found")

    // Exercise 6
    assert(sequenceReconstruction(List(1, 2, 3), List(List(1, 2), List(1, 3), List(2, 3))), "Unique reconstruction")

    // Exercise 7
    assert(minimumSemesters(3, List((1, 3), (2, 3))) == 2, "2 semesters: take 1,2 then 3")

    // Exercise 8
    assert(minSemestersWithLimit(3, List((1, 3), (2, 3)), 1) == 3, "With limit 1: 3 semesters")

    println("All Algo042_TopologicalSort exercises passed!")
  }
}
