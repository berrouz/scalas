package org.shev4ik.interview.algorithms.level2_intermediate

object Algo040_BFS {

  // Exercise 1: BFS traversal of a graph from a start node, return visited order
  // TODO: Use a queue. Mark visited. Enqueue neighbors. Return order of visited nodes.
  def bfsTraversal(adj: Map[Int, List[Int]], start: Int): List[Int] = ???

  // Exercise 2: Shortest path in an unweighted graph (number of edges from start to end)
  // TODO: BFS from start. Track distance. Return distance to end, or -1 if unreachable.
  def shortestPathUnweighted(adj: Map[Int, List[Int]], start: Int, end: Int): Int = ???

  // Exercise 3: Word Ladder — shortest transformation sequence from beginWord to endWord
  // TODO: BFS where neighbors are words differing by one letter. Return number of words in shortest path, 0 if impossible.
  def wordLadder(beginWord: String, endWord: String, wordList: List[String]): Int = ???

  // Exercise 4: Minimum knight moves — min moves for a chess knight from (0,0) to (x,y)
  // TODO: BFS on 2D grid. Knight moves in 8 directions. Track visited positions. Return min steps.
  def minKnightMoves(x: Int, y: Int): Int = ???

  // Exercise 5: Open the Lock — 4-digit lock, avoid deadends, start "0000", reach target
  // TODO: BFS on states. Each state has 8 neighbors (each digit +1 or -1). Skip deadends.
  def openLock(deadends: Array[String], target: String): Int = ???

  // Exercise 6: Rotting Oranges — BFS from all rotten oranges, return minutes until all rot or -1
  // TODO: Multi-source BFS. Start from all rotten (2). Each step rots adjacent fresh (1). Count steps.
  def orangesRotting(grid: Array[Array[Int]]): Int = ???

  // Exercise 7: Walls and Gates — fill each empty room with distance to nearest gate
  // TODO: Multi-source BFS from all gates (0). Fill INF cells with distance. Return updated grid.
  def wallsAndGates(rooms: Array[Array[Int]]): Array[Array[Int]] = ???

  // Exercise 8: Multi-source BFS — given multiple start nodes, find min distance from any source to all nodes
  // TODO: Enqueue all sources at once. BFS. Return distance array.
  def multiSourceBFS(adj: Map[Int, List[Int]], n: Int, sources: List[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    val adj = Map(
      0 -> List(1, 2),
      1 -> List(0, 3),
      2 -> List(0, 3),
      3 -> List(1, 2, 4),
      4 -> List(3)
    )

    // Exercise 1
    val traversal = bfsTraversal(adj, 0)
    assert(traversal.head == 0, "BFS starts at 0")
    assert(traversal.toSet == Set(0, 1, 2, 3, 4), "BFS visits all nodes")

    // Exercise 2
    assert(shortestPathUnweighted(adj, 0, 4) == 3, "Shortest path 0->4 is 3 edges")
    assert(shortestPathUnweighted(adj, 0, 0) == 0, "Distance to self is 0")

    // Exercise 3
    assert(wordLadder("hit", "cog", List("hot", "dot", "dog", "lot", "log", "cog")) == 5, "Word ladder")
    assert(wordLadder("hit", "cog", List("hot", "dot", "dog", "lot", "log")) == 0, "No path")

    // Exercise 4
    assert(minKnightMoves(1, 1) == 2, "Knight to (1,1) takes 2 moves")
    assert(minKnightMoves(2, 1) == 1, "Knight to (2,1) takes 1 move")

    // Exercise 5
    assert(openLock(Array("0201", "0101", "0102", "1212", "2002"), "0202") == 6, "Open lock")
    assert(openLock(Array("8888"), "0009") == 1, "Simple lock")

    // Exercise 6
    val orangeGrid = Array(Array(2, 1, 1), Array(1, 1, 0), Array(0, 1, 1))
    assert(orangesRotting(orangeGrid) == 4, "Rotting oranges takes 4 minutes")

    // Exercise 7
    val INF = Int.MaxValue
    val rooms = Array(
      Array(INF, -1, 0, INF),
      Array(INF, INF, INF, -1),
      Array(INF, -1, INF, -1),
      Array(0, -1, INF, INF)
    )
    val filled = wallsAndGates(rooms)
    assert(filled(0)(0) == 3, "Room (0,0) is 3 from gate")
    assert(filled(1)(2) == 1, "Room (1,2) is 1 from gate")

    // Exercise 8
    val dist = multiSourceBFS(adj, 5, List(0, 4))
    assert(dist(0) == 0, "Source 0 distance is 0")
    assert(dist(3) == 1, "Node 3 is 1 from source 4")

    println("All Algo040_BFS exercises passed!")
  }
}
