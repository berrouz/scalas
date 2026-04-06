package org.shev4ik.interview.algorithms.level2_intermediate

object Algo043_GraphCycle {

  // Exercise 1: Detect cycle in undirected graph using DFS
  // TODO: DFS with parent tracking. If we visit a neighbor that is visited and not parent, cycle exists.
  def hasCycleUndirected(n: Int, edges: List[(Int, Int)]): Boolean = ???

  // Exercise 2: Detect cycle in directed graph using DFS with recursion stack
  // TODO: Track visited and inStack. If we reach a node in current recursion stack, cycle exists.
  def hasCycleDirected(n: Int, edges: List[(Int, Int)]): Boolean = ???

  // Exercise 3: Detect cycle in directed graph using 3-color approach (white/gray/black)
  // TODO: WHITE=unvisited, GRAY=in progress, BLACK=done. If we reach GRAY node, cycle exists.
  def hasCycleColoring(n: Int, edges: List[(Int, Int)]): Boolean = ???

  // Exercise 4: Find the actual cycle path in a directed graph (return list of nodes forming cycle, or empty)
  // TODO: DFS. When cycle detected via back edge, reconstruct the cycle path from the stack.
  def findCyclePath(n: Int, edges: List[(Int, Int)]): List[Int] = ???

  // Exercise 5: Redundant Connection — find the edge that causes a cycle in an undirected graph
  // TODO: Process edges one by one. Use union-find or DFS. Return the first edge that creates a cycle.
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = ???

  // Exercise 6: Is Graph Bipartite? — can we 2-color the graph?
  // TODO: BFS/DFS with coloring. Alternate colors. If neighbor has same color, not bipartite.
  def isBipartite(adj: Map[Int, List[Int]], n: Int): Boolean = ???

  // Exercise 7: Minimum Height Trees — find roots that give minimum height trees
  // TODO: Repeatedly remove leaf nodes (degree 1) until 1-2 nodes remain. These are MHT roots.
  def findMinHeightTrees(n: Int, edges: List[(Int, Int)]): List[Int] = ???

  // Exercise 8: Critical Connections (bridges) — edges whose removal disconnects the graph
  // TODO: Tarjan's bridge-finding algorithm. Track discovery time and low value. Edge (u,v) is bridge if low[v] > disc[u].
  def criticalConnections(n: Int, connections: List[(Int, Int)]): List[(Int, Int)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(hasCycleUndirected(4, List((0, 1), (1, 2), (2, 0))), "Cycle in undirected graph")
    assert(!hasCycleUndirected(3, List((0, 1), (1, 2))), "No cycle in tree")

    // Exercise 2
    assert(hasCycleDirected(3, List((0, 1), (1, 2), (2, 0))), "Cycle in directed graph")
    assert(!hasCycleDirected(3, List((0, 1), (0, 2))), "No cycle in DAG")

    // Exercise 3
    assert(hasCycleColoring(3, List((0, 1), (1, 2), (2, 0))), "Cycle detected by coloring")

    // Exercise 4
    val cycle = findCyclePath(3, List((0, 1), (1, 2), (2, 0)))
    assert(cycle.nonEmpty, "Cycle path found")

    // Exercise 5
    assert(findRedundantConnection(Array(Array(1, 2), Array(1, 3), Array(2, 3))).toList == List(2, 3),
      "Redundant edge is [2,3]")

    // Exercise 6
    val biAdj = Map(0 -> List(1, 3), 1 -> List(0, 2), 2 -> List(1, 3), 3 -> List(2, 0))
    assert(isBipartite(biAdj, 4), "Even cycle is bipartite")
    val nonBi = Map(0 -> List(1, 2), 1 -> List(0, 2), 2 -> List(0, 1))
    assert(!isBipartite(nonBi, 3), "Triangle is not bipartite")

    // Exercise 7
    assert(findMinHeightTrees(4, List((1, 0), (1, 2), (1, 3))) == List(1), "MHT root is 1")
    assert(findMinHeightTrees(6, List((0, 3), (1, 3), (2, 3), (4, 3), (5, 4))).toSet == Set(3, 4),
      "MHT roots are 3 and 4")

    // Exercise 8
    val bridges = criticalConnections(4, List((0, 1), (1, 2), (2, 0), (1, 3)))
    assert(bridges.exists { case (a, b) => Set(a, b) == Set(1, 3) }, "Edge (1,3) is a bridge")

    println("All Algo043_GraphCycle exercises passed!")
  }
}
