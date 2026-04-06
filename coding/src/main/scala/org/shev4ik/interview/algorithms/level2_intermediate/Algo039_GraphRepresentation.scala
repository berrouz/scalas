package org.shev4ik.interview.algorithms.level2_intermediate

object Algo039_GraphRepresentation {

  // Exercise 1: Build an adjacency list from a list of undirected edges
  // TODO: For each edge (u,v), add v to adj(u) and u to adj(v). Return Map[Int, List[Int]].
  def adjListFromEdges(n: Int, edges: List[(Int, Int)]): Map[Int, List[Int]] = ???

  // Exercise 2: Build an adjacency matrix from a list of undirected edges
  // TODO: Create n x n matrix. For each edge (u,v), set matrix(u)(v) = 1 and matrix(v)(u) = 1.
  def adjMatrix(n: Int, edges: List[(Int, Int)]): Array[Array[Int]] = ???

  // Exercise 3: Convert edge list to adjacency list for a directed graph
  // TODO: For each edge (u,v), add v to adj(u) only.
  def directedAdjList(n: Int, edges: List[(Int, Int)]): Map[Int, List[Int]] = ???

  // Exercise 4: Build a weighted adjacency list from weighted edges (u, v, weight)
  // TODO: For each (u,v,w), add (v,w) to adj(u) and (u,w) to adj(v) for undirected.
  def weightedAdjList(n: Int, edges: List[(Int, Int, Int)]): Map[Int, List[(Int, Int)]] = ???

  // Exercise 5: Determine if a graph is directed or undirected from edge list
  // TODO: A graph is undirected if for every edge (u,v), edge (v,u) also exists. Return true if undirected.
  def isUndirected(edges: List[(Int, Int)]): Boolean = ???

  // Exercise 6: Compute in-degree and out-degree of each node in a directed graph
  // TODO: For each edge (u,v), out-degree of u++ and in-degree of v++. Return (inDegree, outDegree) maps.
  def degrees(n: Int, edges: List[(Int, Int)]): (Map[Int, Int], Map[Int, Int]) = ???

  // Exercise 7: Build a graph from a 2D grid — each cell connects to its 4 neighbors
  // TODO: Node id = row * cols + col. Connect to valid neighbors (up, down, left, right). Return adjacency list.
  def graphFromGrid(grid: Array[Array[Int]]): Map[Int, List[Int]] = ???

  // Exercise 8: Given an adjacency list, return all neighbors of a node
  // TODO: Simple lookup in the adjacency map.
  def neighbors(adjList: Map[Int, List[Int]], node: Int): List[Int] = ???

  def main(args: Array[String]): Unit = {
    val edges = List((0, 1), (0, 2), (1, 2), (2, 3))

    // Exercise 1
    val adj = adjListFromEdges(4, edges)
    assert(adj(0).toSet == Set(1, 2), "Node 0 connects to 1 and 2")
    assert(adj(2).toSet == Set(0, 1, 3), "Node 2 connects to 0, 1, 3")

    // Exercise 2
    val matrix = adjMatrix(4, edges)
    assert(matrix(0)(1) == 1 && matrix(1)(0) == 1, "Edge 0-1 in matrix")
    assert(matrix(0)(3) == 0, "No edge 0-3")

    // Exercise 3
    val dirAdj = directedAdjList(4, edges)
    assert(dirAdj(0).toSet == Set(1, 2), "Directed: 0 -> 1, 2")
    assert(dirAdj.getOrElse(3, Nil).isEmpty, "Node 3 has no outgoing edges")

    // Exercise 4
    val wEdges = List((0, 1, 5), (0, 2, 3), (1, 2, 1))
    val wAdj = weightedAdjList(3, wEdges)
    assert(wAdj(0).exists { case (v, w) => v == 1 && w == 5 }, "Weighted edge 0->1 weight 5")

    // Exercise 5
    val undirEdges = List((0, 1), (1, 0), (1, 2), (2, 1))
    assert(isUndirected(undirEdges), "Is undirected")
    assert(!isUndirected(edges), "Directed edges are not undirected")

    // Exercise 6
    val (inDeg, outDeg) = degrees(4, edges)
    assert(outDeg(0) == 2, "Out-degree of 0 is 2")
    assert(inDeg(3) == 1, "In-degree of 3 is 1")

    // Exercise 7
    val grid = Array(Array(1, 1), Array(1, 0))
    val gAdj = graphFromGrid(grid)
    assert(gAdj(0).contains(1), "Cell (0,0) connects to (0,1)")
    assert(gAdj(0).contains(2), "Cell (0,0) connects to (1,0)")

    // Exercise 8
    assert(neighbors(adj, 2).toSet == Set(0, 1, 3), "Neighbors of 2")

    println("All Algo039_GraphRepresentation exercises passed!")
  }
}
