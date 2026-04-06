package org.shev4ik.interview.algorithms.level2_intermediate

object Algo070_GraphShortestPath {

  // Exercise 1: Dijkstra's Algorithm — shortest path from source to all nodes in weighted graph
  // TODO: Use priority queue (min-heap) of (distance, node). Relax edges greedily. Return distance array.
  def dijkstra(n: Int, adj: Map[Int, List[(Int, Int)]], source: Int): Array[Int] = ???

  // Exercise 2: BFS Shortest Path — shortest path in unweighted graph (number of edges)
  // TODO: Standard BFS from source. Track distance. Return distance array (-1 for unreachable).
  def bfsShortestPath(n: Int, adj: Map[Int, List[Int]], source: Int): Array[Int] = ???

  // Exercise 3: Bellman-Ford intro — shortest path with possible negative weights
  // TODO: Relax all edges n-1 times. Check for negative cycles on nth pass. Return distance array.
  def bellmanFord(n: Int, edges: List[(Int, Int, Int)], source: Int): Option[Array[Int]] = ???

  // Exercise 4: Network Delay Time — time for signal to reach all nodes (Dijkstra application)
  // TODO: Run Dijkstra from source. Return max distance. If any node unreachable, return -1.
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 — Dijkstra
    val wAdj: Map[Int, List[(Int, Int)]] = Map(
      0 -> List((1, 4), (2, 1)),
      1 -> List((3, 1)),
      2 -> List((1, 2), (3, 5)),
      3 -> List()
    )
    val dist = dijkstra(4, wAdj, 0)
    assert(dist(0) == 0, "Distance to self is 0")
    assert(dist(1) == 3, "Shortest to 1: 0->2->1 = 1+2 = 3")
    assert(dist(3) == 4, "Shortest to 3: 0->2->1->3 = 1+2+1 = 4")

    // Exercise 2 — BFS
    val uAdj: Map[Int, List[Int]] = Map(
      0 -> List(1, 2),
      1 -> List(0, 3),
      2 -> List(0, 3),
      3 -> List(1, 2, 4),
      4 -> List(3)
    )
    val bfsDist = bfsShortestPath(5, uAdj, 0)
    assert(bfsDist(0) == 0, "BFS distance to self")
    assert(bfsDist(3) == 2, "BFS distance 0->1->3 or 0->2->3 = 2")
    assert(bfsDist(4) == 3, "BFS distance to 4 = 3")

    // Exercise 3 — Bellman-Ford
    val edges = List((0, 1, 4), (0, 2, 1), (2, 1, 2), (1, 3, 1), (2, 3, 5))
    val bfDist = bellmanFord(4, edges, 0)
    assert(bfDist.isDefined, "No negative cycle")
    assert(bfDist.get(3) == 4, "Bellman-Ford shortest to 3 = 4")

    // Negative cycle detection
    val negCycleEdges = List((0, 1, 1), (1, 2, -1), (2, 0, -1))
    assert(bellmanFord(3, negCycleEdges, 0).isEmpty, "Negative cycle detected")

    // Exercise 4 — Network Delay Time
    val times = Array(Array(2, 1, 1), Array(2, 3, 1), Array(3, 4, 1))
    assert(networkDelayTime(times, 4, 2) == 2, "Network delay = 2")

    val times2 = Array(Array(1, 2, 1))
    assert(networkDelayTime(times2, 2, 2) == -1, "Node 1 unreachable from 2")

    println("All Algo070_GraphShortestPath exercises passed!")
  }
}
