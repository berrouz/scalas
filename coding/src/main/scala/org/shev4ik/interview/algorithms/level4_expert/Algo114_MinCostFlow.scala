package org.shev4ik.interview.algorithms.level4_expert

/**
 * Min-Cost Flow algorithms and applications.
 *
 * Key concepts:
 * - Minimum cost maximum flow: find max flow with minimum total cost
 * - Successive shortest path algorithm
 * - Cost scaling for better complexity
 * - Applications: assignment, transportation, network simplex
 */
object Algo114_MinCostFlow {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Min cost max flow (successive shortest paths)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement min-cost max flow using successive shortest paths.
   *       Repeatedly find shortest path (by cost) from source to sink
   *       using Bellman-Ford/SPFA, augment flow along it.
   *       Return (maxFlow, minCost).
   *
   * @param n     number of vertices
   * @param edges list of (from, to, capacity, cost)
   * @param source source vertex
   * @param sink   sink vertex
   * @return (maximum flow, minimum cost to achieve that flow)
   */
  def minCostMaxFlow(n: Int, edges: List[(Int, Int, Int, Int)], source: Int, sink: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Successive shortest path with potentials (Johnson's)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Improve successive shortest paths by using potentials
   *       (reduced costs) so Dijkstra can be used instead of Bellman-Ford.
   *       Initialize potentials with one Bellman-Ford run.
   *       Then use Dijkstra with reduced costs for subsequent iterations.
   *       Return (maxFlow, minCost).
   *
   * @param n     number of vertices
   * @param edges list of (from, to, capacity, cost)
   * @param source source vertex
   * @param sink   sink vertex
   * @return (maximum flow, minimum cost)
   */
  def minCostFlowWithPotentials(n: Int, edges: List[(Int, Int, Int, Int)], source: Int, sink: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Cost scaling concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the concept of cost scaling for min-cost flow.
   *       Maintain epsilon-optimality: no negative reduced cost cycles
   *       with cost > -epsilon. Refine epsilon by half each iteration.
   *       For simplicity, solve a small instance and verify correctness.
   *       Return (maxFlow, minCost).
   *
   * @param n     number of vertices
   * @param edges list of (from, to, capacity, cost)
   * @param source source vertex
   * @param sink   sink vertex
   * @return (maximum flow, minimum cost)
   */
  def costScaling(n: Int, edges: List[(Int, Int, Int, Int)], source: Int, sink: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Assignment problem
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve the assignment problem using min-cost flow.
   *       Given an n x n cost matrix, assign n workers to n jobs
   *       minimizing total cost. Each worker does exactly one job.
   *       Model as bipartite graph with source and sink.
   *       Return (minimum total cost, assignment as list of job indices).
   *
   * @param cost n x n cost matrix where cost(i)(j) = cost of worker i doing job j
   * @return (minimum total cost, assignment where result(i) = job assigned to worker i)
   */
  def assignmentProblem(cost: Array[Array[Int]]): (Int, Array[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Transportation problem
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve the transportation problem using min-cost flow.
   *       Given supplies at sources, demands at destinations, and
   *       shipping costs, find the minimum cost shipping plan.
   *       Return the minimum total shipping cost.
   *
   * @param supply  supply at each source
   * @param demand  demand at each destination
   * @param cost    cost(i)(j) = cost of shipping one unit from source i to dest j
   * @return minimum total transportation cost
   */
  def transportationProblem(supply: Array[Int], demand: Array[Int], cost: Array[Array[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Network simplex concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified network simplex for min-cost flow.
   *       Maintain a spanning tree basis. At each step, find an
   *       entering arc (negative reduced cost), compute the cycle,
   *       find the leaving arc (min flow on cycle), pivot.
   *       For simplicity, solve the same problem as Exercise 1
   *       and return (maxFlow, minCost).
   *
   * @param n     number of vertices
   * @param edges list of (from, to, capacity, cost)
   * @param source source vertex
   * @param sink   sink vertex
   * @return (maximum flow, minimum cost)
   */
  def networkSimplex(n: Int, edges: List[(Int, Int, Int, Int)], source: Int, sink: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Detect and eliminate negative cost cycles
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a flow network with existing flow, detect if there
   *       are negative cost cycles in the residual graph.
   *       If found, push flow around the cycle to reduce cost.
   *       Return the improved total cost, or the original cost if
   *       no negative cycle exists.
   *
   * @param n     number of vertices
   * @param edges list of (from, to, capacity, cost, currentFlow)
   * @return optimized total cost after eliminating negative cycles
   */
  def eliminateNegativeCycles(n: Int, edges: List[(Int, Int, Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Min cost flow application - minimum weight bipartite matching
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the minimum weight perfect matching in a bipartite graph.
   *       Left vertices: 0..n-1, Right vertices: 0..m-1.
   *       Each edge (l, r, weight) connects left l to right r.
   *       Use min-cost flow to find perfect matching of minimum weight.
   *       Return (minWeight, list of matched pairs (left, right)).
   *
   * @param n     number of left vertices
   * @param m     number of right vertices
   * @param edges list of (left, right, weight)
   * @return (minimum weight, list of matched pairs)
   */
  def minWeightBipartiteMatching(n: Int, m: Int, edges: List[(Int, Int, Int)]): (Int, List[(Int, Int)]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Network:
    //   0 -> 1 (cap 2, cost 1)
    //   0 -> 2 (cap 3, cost 5)
    //   1 -> 2 (cap 1, cost 2)
    //   1 -> 3 (cap 2, cost 3)
    //   2 -> 3 (cap 3, cost 1)
    val edges = List(
      (0, 1, 2, 1), (0, 2, 3, 5),
      (1, 2, 1, 2), (1, 3, 2, 3),
      (2, 3, 3, 1)
    )

    // Exercise 1
    val (flow1, cost1) = minCostMaxFlow(4, edges, 0, 3)
    assert(flow1 == 4, s"Expected flow 4, got $flow1")
    println(s"Exercise 1 (Min cost max flow) passed. Flow=$flow1, Cost=$cost1")

    // Exercise 2
    val (flow2, cost2) = minCostFlowWithPotentials(4, edges, 0, 3)
    assert(flow2 == flow1 && cost2 == cost1, "Potentials method should match")
    println("Exercise 2 (With potentials) passed.")

    // Exercise 3
    val (flow3, cost3) = costScaling(4, edges, 0, 3)
    assert(flow3 == flow1, s"Expected flow $flow1, got $flow3")
    println("Exercise 3 (Cost scaling) passed.")

    // Exercise 4
    val costMatrix = Array(
      Array(9, 2, 7, 8),
      Array(6, 4, 3, 7),
      Array(5, 8, 1, 8),
      Array(7, 6, 9, 4)
    )
    val (totalCost, assignment) = assignmentProblem(costMatrix)
    assert(totalCost == 13, s"Expected 13, got $totalCost") // 2+3+1+4 = 10? or optimal
    assert(assignment.length == 4)
    println(s"Exercise 4 (Assignment) passed. Cost=$totalCost")

    // Exercise 5
    val supply = Array(20, 30)
    val demand = Array(10, 25, 15)
    val shipCost = Array(Array(8, 6, 10), Array(9, 12, 7))
    val transCost = transportationProblem(supply, demand, shipCost)
    assert(transCost > 0, s"Expected positive cost, got $transCost")
    println(s"Exercise 5 (Transportation) passed. Cost=$transCost")

    // Exercise 6
    val (flow6, cost6) = networkSimplex(4, edges, 0, 3)
    assert(flow6 == flow1, s"Expected flow $flow1, got $flow6")
    println("Exercise 6 (Network simplex) passed.")

    // Exercise 7
    val flowEdges = List(
      (0, 1, 2, 1, 2), (0, 2, 3, 5, 2),
      (1, 2, 1, 2, 0), (1, 3, 2, 3, 2),
      (2, 3, 3, 1, 2)
    )
    val optCost = eliminateNegativeCycles(4, flowEdges)
    assert(optCost > 0, s"Expected positive cost, got $optCost")
    println(s"Exercise 7 (Negative cycles) passed. Cost=$optCost")

    // Exercise 8
    val bEdges = List((0,0,5),(0,1,2),(1,0,3),(1,1,7))
    val (mw, pairs) = minWeightBipartiteMatching(2, 2, bEdges)
    assert(mw == 5, s"Expected 5 (2+3), got $mw")
    println(s"Exercise 8 (Min weight matching) passed. Weight=$mw")

    println("All Algo114_MinCostFlow exercises passed!")
  }
}
