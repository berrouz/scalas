package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Bellman-Ford Algorithm - shortest paths with negative edge weights.
 *
 * Key concepts:
 * - Relaxes all edges V-1 times
 * - Can detect negative weight cycles
 * - Time: O(V * E)
 * - Works with negative edges (unlike Dijkstra)
 */
object Algo072_BellmanFord {

  /** Weighted directed edge */
  case class Edge(from: Int, to: Int, weight: Double)

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Basic Bellman-Ford
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the basic Bellman-Ford algorithm.
   *       Return an array of shortest distances from src to all vertices.
   *       Use Double.MaxValue for unreachable vertices.
   *
   * @param n     number of vertices
   * @param edges list of directed weighted edges
   * @param src   source vertex
   * @return distance array
   */
  def bellmanFord(n: Int, edges: List[Edge], src: Int): Array[Double] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Detect negative cycle
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Run Bellman-Ford and detect if there is a negative weight cycle
   *       reachable from src. Return true if a negative cycle exists.
   *       Hint: After V-1 relaxations, do one more pass. If any distance improves,
   *       a negative cycle exists.
   *
   * @param n     number of vertices
   * @param edges list of directed weighted edges
   * @param src   source vertex
   * @return true if negative cycle is reachable from src
   */
  def hasNegativeCycle(n: Int, edges: List[Edge], src: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Shortest path with negative edges
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the shortest path from src to dst in a graph that may have
   *       negative edge weights. Return None if dst is unreachable or if
   *       it is affected by a negative cycle.
   *
   * @param n     number of vertices
   * @param edges list of edges
   * @param src   source
   * @param dst   destination
   * @return Option[Double] shortest distance, None if unreachable or negative cycle
   */
  def shortestPathNegative(n: Int, edges: List[Edge], src: Int, dst: Int): Option[Double] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Cheapest flights within k stops
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find cheapest price from src to dst with at most k stops.
   *       Use a modified Bellman-Ford that runs only k+1 iterations.
   *       Return -1 if no such route exists.
   *
   * @param n       number of cities
   * @param flights list of (from, to, price)
   * @param src     source city
   * @param dst     destination city
   * @param k       max stops
   * @return cheapest price or -1
   */
  def cheapestFlightsKStops(n: Int, flights: List[(Int, Int, Int)], src: Int, dst: Int, k: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Arbitrage detection concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given exchange rates between currencies, detect if arbitrage is possible.
   *       Arbitrage = a cycle where product of exchange rates > 1.
   *       Hint: Take -log of rates, then detect negative cycle with Bellman-Ford.
   *       Return true if arbitrage opportunity exists.
   *
   * @param n     number of currencies
   * @param rates rates(i)(j) = exchange rate from currency i to j
   * @return true if arbitrage is possible
   */
  def detectArbitrage(n: Int, rates: Array[Array[Double]]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: SPFA optimization (Shortest Path Faster Algorithm)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement SPFA, an optimization of Bellman-Ford using a queue.
   *       Only vertices whose distance was updated are re-processed.
   *       Return the distance array.
   *       Average case: O(E), worst case: O(V*E).
   *
   * @param n     number of vertices
   * @param graph adjacency list: graph(u) = List((v, weight))
   * @param src   source vertex
   * @return distance array
   */
  def spfa(n: Int, graph: Map[Int, List[(Int, Double)]], src: Int): Array[Double] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Shortest distance with hop constraint
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find shortest distance from src to dst using at most maxHops edges.
   *       Return Double.MaxValue if unreachable within the constraint.
   *
   * @param n       number of vertices
   * @param edges   list of edges
   * @param src     source
   * @param dst     destination
   * @param maxHops maximum number of edges in the path
   * @return shortest distance within hop limit
   */
  def shortestWithHopLimit(n: Int, edges: List[Edge], src: Int, dst: Int, maxHops: Int): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Currency exchange - max amount
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given currency exchange rates, find the maximum amount of target currency
   *       you can get starting with `amount` of source currency.
   *       Hint: Use Bellman-Ford on -log(rate) or modify to track max product.
   *       Return 0.0 if no path exists.
   *
   * @param n      number of currencies
   * @param edges  list of (from, to, rate)
   * @param src    source currency
   * @param dst    target currency
   * @param amount starting amount
   * @return maximum amount of target currency
   */
  def maxCurrencyExchange(n: Int, edges: List[(Int, Int, Double)], src: Int, dst: Int, amount: Double): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val edges1 = List(Edge(0, 1, 4), Edge(0, 2, 5), Edge(1, 2, -3), Edge(2, 3, 4))
    val dist1 = bellmanFord(4, edges1, 0)
    assert(dist1(0) == 0.0)
    assert(dist1(1) == 4.0)
    assert(dist1(2) == 1.0)
    assert(dist1(3) == 5.0)
    println("Exercise 1 (Basic Bellman-Ford) passed.")

    // Exercise 2
    val edgesNeg = List(Edge(0, 1, 1), Edge(1, 2, -1), Edge(2, 0, -1))
    assert(hasNegativeCycle(3, edgesNeg, 0))
    assert(!hasNegativeCycle(4, edges1, 0))
    println("Exercise 2 (Detect negative cycle) passed.")

    // Exercise 3
    val sp3 = shortestPathNegative(4, edges1, 0, 3)
    assert(sp3.contains(5.0), s"Expected Some(5.0), got $sp3")
    val sp3neg = shortestPathNegative(3, edgesNeg, 0, 1)
    assert(sp3neg.isEmpty, "Expected None for negative cycle")
    println("Exercise 3 (Shortest path negative) passed.")

    // Exercise 4
    val flights4 = List((0, 1, 100), (1, 2, 100), (0, 2, 500))
    assert(cheapestFlightsKStops(3, flights4, 0, 2, 1) == 200)
    assert(cheapestFlightsKStops(3, flights4, 0, 2, 0) == 500)
    println("Exercise 4 (Cheapest flights k stops) passed.")

    // Exercise 5
    val rates5 = Array(
      Array(1.0, 0.5, 2.0),
      Array(2.0, 1.0, 3.0),
      Array(0.5, 0.34, 1.0)
    )
    // 1.0 * 0.5 * 3.0 * 0.5 = 0.75 < 1 ... let's use a real arbitrage
    val ratesArb = Array(
      Array(1.0, 2.0, 0.5),
      Array(0.5, 1.0, 4.0),
      Array(2.0, 0.25, 1.0)
    )
    // 0 -> 1 (rate 2.0) -> 2 (rate 4.0) -> 0 (rate 2.0) = 16 > 1
    assert(detectArbitrage(3, ratesArb))
    println("Exercise 5 (Arbitrage detection) passed.")

    // Exercise 6
    val graph6: Map[Int, List[(Int, Double)]] = Map(
      0 -> List((1, 4.0), (2, 5.0)),
      1 -> List((2, -3.0)),
      2 -> List((3, 4.0)),
      3 -> Nil
    )
    val dist6 = spfa(4, graph6, 0)
    assert(dist6(3) == 5.0, s"Expected 5.0, got ${dist6(3)}")
    println("Exercise 6 (SPFA) passed.")

    // Exercise 7
    val dist7 = shortestWithHopLimit(4, edges1, 0, 3, 2)
    assert(dist7 == 9.0, s"Expected 9.0 (0->2->3), got $dist7")
    val dist7b = shortestWithHopLimit(4, edges1, 0, 3, 3)
    assert(dist7b == 5.0, s"Expected 5.0, got $dist7b")
    println("Exercise 7 (Hop limit) passed.")

    // Exercise 8
    val exEdges = List((0, 1, 2.0), (1, 2, 3.0), (0, 2, 5.0))
    val maxAmt = maxCurrencyExchange(3, exEdges, 0, 2, 100.0)
    assert(maxAmt == 600.0, s"Expected 600.0, got $maxAmt")
    println("Exercise 8 (Currency exchange) passed.")

    println("All Algo072_BellmanFord exercises passed!")
  }
}
