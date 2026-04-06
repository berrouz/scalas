package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Dijkstra's Algorithm - shortest path from a single source in graphs with non-negative weights.
 *
 * Key concepts:
 * - Greedy approach: always expand the nearest unvisited node
 * - Priority queue for efficient minimum extraction
 * - Time: O((V + E) log V) with binary heap
 * - Does NOT work with negative edge weights
 */
object Algo071_Dijkstra {

  /** Weighted directed edge */
  case class Edge(to: Int, weight: Double)

  /** Result of Dijkstra: distances and predecessors for path reconstruction */
  case class DijkstraResult(dist: Array[Double], prev: Array[Int])

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Dijkstra with adjacency list
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Dijkstra's algorithm using an adjacency list representation.
   *       Return an array of shortest distances from `src` to every other vertex.
   *       Use Double.MaxValue for unreachable vertices.
   *
   * Time: O((V + E) log V), Space: O(V + E)
   * Hint: Initialize dist array to MaxValue, set dist(src) = 0. Use a visited set and
   *       repeatedly pick the unvisited vertex with the smallest distance, relax its neighbors.
   *
   * @param graph adjacency list: graph(u) contains edges from u
   * @param src   source vertex
   * @return array where result(v) = shortest distance from src to v
   */
  def dijkstraAdjList(graph: Map[Int, List[Edge]], src: Int, n: Int): Array[Double] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Dijkstra with priority queue
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Dijkstra using a mutable priority queue (min-heap).
   *       Return DijkstraResult with both distances and predecessor array.
   *
   * Time: O((V + E) log V), Space: O(V + E)
   * Hint: Use scala.collection.mutable.PriorityQueue with Ordering.by(-_._2) for min-heap
   *       behavior. Track predecessors in a prev array (initialized to -1) and update
   *       prev(v) = u whenever you relax edge u -> v.
   *
   * @param graph adjacency list
   * @param src   source vertex
   * @param n     number of vertices
   * @return DijkstraResult containing dist and prev arrays
   */
  def dijkstraWithPQ(graph: Map[Int, List[Edge]], src: Int, n: Int): DijkstraResult = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Shortest path reconstruction
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a DijkstraResult, reconstruct the shortest path from src to dst.
   *       Return None if dst is unreachable, otherwise Some(List of vertices).
   *
   * Time: O(V), Space: O(V)
   * Hint: Start from dst, follow prev pointers back to src, then reverse the collected list.
   *       If dist(dst) == MaxValue, return None.
   *
   * @param result DijkstraResult from dijkstraWithPQ
   * @param src    source vertex
   * @param dst    destination vertex
   * @return Option containing the path as a list of vertex indices
   */
  def reconstructPath(result: DijkstraResult, src: Int, dst: Int): Option[List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Negative edge detection
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Before running Dijkstra, check if any edge has a negative weight.
   *       Return Left(errorMsg) if negative edges found, Right(distances) otherwise.
   *
   * Time: O(V + E) for validation + O((V + E) log V) for Dijkstra, Space: O(V + E)
   * Hint: Iterate over all edges via graph.values.flatten and check weight < 0.
   *       If valid, delegate to dijkstraAdjList.
   *
   * @param graph adjacency list
   * @param src   source vertex
   * @param n     number of vertices
   * @return Either error message or distance array
   */
  def safeDijkstra(graph: Map[Int, List[Edge]], src: Int, n: Int): Either[String, Array[Double]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Single source all destinations
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Run Dijkstra and return a Map from each reachable vertex to its distance.
   *       Only include vertices that are actually reachable (distance < Double.MaxValue).
   *
   * Time: O((V + E) log V), Space: O(V)
   * Hint: Run dijkstraAdjList, then filter the result array with zipWithIndex
   *       to build a Map of only reachable vertices.
   *
   * @param graph adjacency list
   * @param src   source vertex
   * @param n     number of vertices
   * @return Map[vertex -> shortest distance] for reachable vertices only
   */
  def allReachableDistances(graph: Map[Int, List[Edge]], src: Int, n: Int): Map[Int, Double] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Modified Dijkstra with at most k stops
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find shortest path from src to dst using at most k intermediate stops.
   *       This is a modified Dijkstra where state = (vertex, stops_used).
   *       Return -1.0 if no such path exists.
   *
   * Time: O(V * K * log(V * K)), Space: O(V * K)
   * Hint: This is LeetCode 787. Use BFS/modified Dijkstra with state (node, stops).
   *       PQ entries are (cost, node, stopsUsed). Only enqueue if stopsUsed <= k.
   *       Alternatively, use Bellman-Ford with k+1 relaxation rounds.
   *
   * @param n     number of vertices
   * @param edges list of (from, to, weight)
   * @param src   source
   * @param dst   destination
   * @param k     max intermediate stops
   * @return shortest distance or -1.0
   */
  def shortestPathKStops(n: Int, edges: List[(Int, Int, Double)], src: Int, dst: Int, k: Int): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Network delay time
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a network of n nodes and weighted directed edges,
   *       find the time it takes for a signal from node `src` to reach ALL nodes.
   *       Return -1 if not all nodes are reachable.
   *       (This is the maximum of all shortest distances.)
   *
   * Time: O((V + E) log V), Space: O(V + E)
   * Hint: LeetCode 743 - Network Delay Time. Run standard Dijkstra from src,
   *       then return the max distance. If any node has distance MaxValue, return -1.
   *       Note: nodes are 1-indexed in the problem.
   *
   * @param times list of (from, to, time)
   * @param n     number of nodes (1-indexed)
   * @param src   source node
   * @return time for signal to reach all nodes, or -1
   */
  def networkDelayTime(times: List[(Int, Int, Int)], n: Int, src: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Path with maximum probability
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an undirected graph where edges have success probabilities (0..1),
   *       find the path from src to dst with maximum probability.
   *
   * Time: O((V + E) log V), Space: O(V + E)
   * Hint: LeetCode 1514. Convert probabilities to -log for Dijkstra (minimizing
   *       -log(prob) maximizes prob), or use a max-heap Dijkstra directly where you
   *       multiply probabilities. Initialize dist(src) = 1.0, relax with
   *       newProb = dist(u) * prob(u,v), update if newProb > dist(v).
   *       Remember the graph is undirected - add edges in both directions.
   *
   * @param n       number of nodes
   * @param edges   list of (u, v)
   * @param probs   probability for each edge (same index as edges)
   * @param src     source
   * @param dst     destination
   * @return maximum probability (0.0 if unreachable)
   */
  def maxProbability(n: Int, edges: List[(Int, Int)], probs: List[Double], src: Int, dst: Int): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Sample graph:
    //   0 --(1)--> 1 --(2)--> 2
    //   0 --(4)--> 2
    //   1 --(1)--> 3
    //   2 --(1)--> 3
    val graph: Map[Int, List[Edge]] = Map(
      0 -> List(Edge(1, 1.0), Edge(2, 4.0)),
      1 -> List(Edge(2, 2.0), Edge(3, 1.0)),
      2 -> List(Edge(3, 1.0)),
      3 -> Nil
    )

    // Exercise 1
    val dist1 = dijkstraAdjList(graph, 0, 4)
    assert(dist1(0) == 0.0, s"Expected 0.0 for dist(0), got ${dist1(0)}")
    assert(dist1(1) == 1.0, s"Expected 1.0 for dist(1), got ${dist1(1)}")
    assert(dist1(2) == 3.0, s"Expected 3.0 for dist(2), got ${dist1(2)}")
    assert(dist1(3) == 2.0, s"Expected 2.0 for dist(3), got ${dist1(3)}")
    println("Exercise 1 (Dijkstra adj list) passed.")

    // Exercise 2
    val res2 = dijkstraWithPQ(graph, 0, 4)
    assert(res2.dist(3) == 2.0, s"Expected 2.0 for dist(3), got ${res2.dist(3)}")
    println("Exercise 2 (Dijkstra with PQ) passed.")

    // Exercise 3
    val path3 = reconstructPath(res2, 0, 3)
    assert(path3.contains(List(0, 1, 3)), s"Expected Some(List(0,1,3)), got $path3")
    println("Exercise 3 (Path reconstruction) passed.")

    // Exercise 4
    val negGraph: Map[Int, List[Edge]] = Map(0 -> List(Edge(1, -1.0)))
    val safe4 = safeDijkstra(negGraph, 0, 2)
    assert(safe4.isLeft, "Expected Left for negative edges")
    val safe4ok = safeDijkstra(graph, 0, 4)
    assert(safe4ok.isRight, "Expected Right for valid graph")
    println("Exercise 4 (Negative edge detection) passed.")

    // Exercise 5
    val reach5 = allReachableDistances(graph, 0, 4)
    assert(reach5.size == 4)
    assert(reach5(2) == 3.0)
    println("Exercise 5 (All reachable distances) passed.")

    // Exercise 6
    val edges6 = List((0, 1, 1.0), (1, 2, 1.0), (0, 2, 5.0))
    assert(shortestPathKStops(3, edges6, 0, 2, 1) == 2.0)
    assert(shortestPathKStops(3, edges6, 0, 2, 0) == 5.0)
    println("Exercise 6 (K stops) passed.")

    // Exercise 7
    val times7 = List((1, 2, 1), (2, 3, 2), (1, 3, 4))
    assert(networkDelayTime(times7, 3, 1) == 3)
    println("Exercise 7 (Network delay time) passed.")

    // Exercise 8
    val edges8 = List((0, 1), (1, 2), (0, 2))
    val probs8 = List(0.5, 0.5, 0.2)
    val prob8 = maxProbability(3, edges8, probs8, 0, 2)
    assert(math.abs(prob8 - 0.25) < 1e-9, s"Expected 0.25, got $prob8")
    println("Exercise 8 (Max probability) passed.")

    println("All Algo071_Dijkstra exercises passed!")
  }
}
