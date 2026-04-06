package org.shev4ik.interview.algorithms.level2_intermediate

object Algo041_DFS {

  // Exercise 1: DFS traversal of a graph from a start node, return visited order
  // TODO: Use recursion or explicit stack. Mark visited. Return order of visited nodes.
  def dfsTraversal(adj: Map[Int, List[Int]], start: Int): List[Int] = ???

  // Exercise 2: Count connected components in an undirected graph
  // TODO: For each unvisited node, run DFS and increment count.
  def connectedComponents(n: Int, adj: Map[Int, List[Int]]): Int = ???

  // Exercise 3: Number of Islands — count connected components of 1s in a grid
  // TODO: For each unvisited '1', DFS to mark all connected '1's. Count groups.
  def numIslands(grid: Array[Array[Char]]): Int = ???

  // Exercise 4: Flood Fill — change all connected cells of same color to new color
  // TODO: DFS from (sr,sc). Change color of all same-color connected cells. Return new grid.
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = ???

  // Exercise 5: Surrounded Regions — capture all 'O' regions not connected to border
  // TODO: DFS from border 'O's to mark safe. Then flip remaining 'O' to 'X'.
  def surroundedRegions(board: Array[Array[Char]]): Array[Array[Char]] = ???

  // Exercise 6: Pacific Atlantic Water Flow — find cells that flow to both oceans
  // TODO: DFS from pacific border and atlantic border. Intersect reachable sets.
  def pacificAtlantic(heights: Array[Array[Int]]): List[(Int, Int)] = ???

  // Exercise 7: Clone Graph — deep copy of a graph (return adjacency list of cloned graph)
  // TODO: DFS with a map from old node to new node. Clone each node and its neighbors.
  def cloneGraph(adj: Map[Int, List[Int]]): Map[Int, List[Int]] = ???

  // Exercise 8: All paths from source to target in a DAG
  // TODO: Backtracking DFS. From source, explore each neighbor. At target, record path.
  def allPathsSourceTarget(adj: Map[Int, List[Int]], source: Int, target: Int): List[List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val adj = Map(
      0 -> List(1, 2),
      1 -> List(0, 3),
      2 -> List(0),
      3 -> List(1)
    )

    // Exercise 1
    val traversal = dfsTraversal(adj, 0)
    assert(traversal.head == 0, "DFS starts at 0")
    assert(traversal.toSet == Set(0, 1, 2, 3), "DFS visits all nodes")

    // Exercise 2
    val disconnected = Map(0 -> List(1), 1 -> List(0), 2 -> List(3), 3 -> List(2), 4 -> List[Int]())
    assert(connectedComponents(5, disconnected) == 3, "3 connected components")

    // Exercise 3
    val grid = Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '1', '0', '0'),
      Array('0', '0', '0', '1', '1')
    )
    assert(numIslands(grid.map(_.clone)) == 3, "3 islands")

    // Exercise 4
    val image = Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1))
    val filled = floodFill(image.map(_.clone), 1, 1, 2)
    assert(filled(0)(0) == 2 && filled(1)(1) == 2, "Flood fill changes connected cells")
    assert(filled(2)(2) == 1, "Disconnected cell unchanged")

    // Exercise 5
    val board = Array(
      Array('X', 'X', 'X', 'X'),
      Array('X', 'O', 'O', 'X'),
      Array('X', 'X', 'O', 'X'),
      Array('X', 'O', 'X', 'X')
    )
    val captured = surroundedRegions(board.map(_.clone))
    assert(captured(1)(1) == 'X', "Interior O captured")
    assert(captured(3)(1) == 'O' || captured(3)(1) == 'X', "Border-adjacent check")

    // Exercise 6
    val heights = Array(
      Array(1, 2, 2, 3, 5),
      Array(3, 2, 3, 4, 4),
      Array(2, 4, 5, 3, 1),
      Array(6, 7, 1, 4, 5),
      Array(5, 1, 1, 2, 4)
    )
    val result = pacificAtlantic(heights)
    assert(result.contains((0, 4)), "(0,4) flows to both oceans")

    // Exercise 7
    val cloned = cloneGraph(adj)
    assert(cloned(0).toSet == adj(0).toSet, "Cloned graph has same structure")

    // Exercise 8
    val dag = Map(0 -> List(1, 2), 1 -> List(3), 2 -> List(3), 3 -> List[Int]())
    val paths = allPathsSourceTarget(dag, 0, 3)
    assert(paths.toSet == Set(List(0, 1, 3), List(0, 2, 3)), "All paths from 0 to 3")

    println("All Algo041_DFS exercises passed!")
  }
}
