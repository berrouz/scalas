package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Eulerian Paths and Circuits - traversing every edge exactly once.
 *
 * Key concepts:
 * - Eulerian circuit: visit every edge exactly once, return to start
 * - Eulerian path: visit every edge exactly once (start != end possible)
 * - Hierholzer's algorithm: O(E) using edge removal and circuit merging
 * - Existence conditions: degree parity (undirected), in/out degree (directed)
 */
object Algo078_EulerianPath {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Eulerian path existence check
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Check if an undirected graph has an Eulerian path (or circuit).
   *       Eulerian circuit: all vertices have even degree.
   *       Eulerian path: exactly 0 or 2 vertices have odd degree.
   *       Return "circuit", "path", or "none".
   *       Assume the graph is connected.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return "circuit", "path", or "none"
   */
  def eulerianType(n: Int, edges: List[(Int, Int)]): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Hierholzer's algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Hierholzer's algorithm to find an Eulerian circuit
   *       in an undirected graph. Return the circuit as a list of vertices.
   *       Assume the graph has an Eulerian circuit.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return Eulerian circuit as list of vertices (first = last)
   */
  def hierholzerCircuit(n: Int, edges: List[(Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Euler circuit in directed graph
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find Eulerian circuit in a directed graph.
   *       Exists iff: every vertex has in-degree == out-degree, and graph is connected.
   *       Return the circuit as list of vertices.
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return Eulerian circuit or empty list if none exists
   */
  def eulerCircuitDirected(n: Int, edges: List[(Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Reconstruct itinerary
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a list of airline tickets (from, to), reconstruct the itinerary
   *       in lexicographic order. All tickets must be used exactly once.
   *       Start from "JFK". This is an Eulerian path problem.
   *
   * @param tickets list of (from, to) airport codes
   * @return itinerary as list of airports
   */
  def reconstructItinerary(tickets: List[(String, String)]): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Chinese postman concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Chinese Postman Problem: find minimum weight closed walk that visits
   *       every edge at least once. If graph has Eulerian circuit, cost = sum of all edges.
   *       Otherwise, find minimum weight matching on odd-degree vertices.
   *       Return the minimum total distance.
   *
   * @param n     number of vertices
   * @param edges list of (u, v, weight) undirected
   * @return minimum total distance for the postman tour
   */
  def chinesePostman(n: Int, edges: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: De Bruijn sequence
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate a de Bruijn sequence B(2, n): a cyclic sequence where
   *       every binary string of length n appears as a substring exactly once.
   *       Use Eulerian circuit on de Bruijn graph.
   *       Return the sequence as a String of '0' and '1'.
   *
   * @param n length of binary strings
   * @return de Bruijn sequence
   */
  def deBruijnSequence(n: Int): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Eulerian path in directed graph
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find an Eulerian path in a directed graph (not necessarily a circuit).
   *       Conditions: at most one vertex with out-in=1 (start), at most one with in-out=1 (end),
   *       all others have equal in/out degree.
   *       Return the path as list of vertices, or empty list if none exists.
   *
   * @param n     number of vertices
   * @param edges directed edges
   * @return Eulerian path or empty list
   */
  def eulerianPathDirected(n: Int, edges: List[(Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Valid arrangement of pairs
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given pairs (a, b), arrange them so that for consecutive pairs
   *       (a1, b1), (a2, b2): b1 == a2. Use all pairs exactly once.
   *       This is an Eulerian path on a graph where each pair is an edge.
   *       Return the arranged pairs, or empty list if impossible.
   *
   * @param pairs list of (start, end) pairs
   * @return arranged list of pairs
   */
  def validArrangement(pairs: List[(Int, Int)]): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(eulerianType(3, List((0,1),(1,2),(2,0))) == "circuit")
    assert(eulerianType(3, List((0,1),(1,2))) == "path")
    println("Exercise 1 (Eulerian type) passed.")

    // Exercise 2
    val circuit2 = hierholzerCircuit(3, List((0,1),(1,2),(2,0)))
    assert(circuit2.head == circuit2.last)
    assert(circuit2.length == 4) // 3 edges + return
    println("Exercise 2 (Hierholzer) passed.")

    // Exercise 3
    val circuit3 = eulerCircuitDirected(3, List((0,1),(1,2),(2,0)))
    assert(circuit3.nonEmpty)
    assert(circuit3.head == circuit3.last)
    println("Exercise 3 (Euler circuit directed) passed.")

    // Exercise 4
    val itin = reconstructItinerary(List(("JFK","SFO"),("JFK","ATL"),("SFO","ATL"),("ATL","JFK"),("ATL","SFO")))
    assert(itin.head == "JFK")
    assert(itin.length == 6)
    println("Exercise 4 (Reconstruct itinerary) passed.")

    // Exercise 5
    val cp = chinesePostman(4, List((0,1,1),(1,2,2),(2,3,3),(3,0,4),(0,2,5)))
    assert(cp > 0)
    println("Exercise 5 (Chinese postman) passed.")

    // Exercise 6
    val db = deBruijnSequence(2)
    assert(db.length == 4, s"Expected length 4, got ${db.length}")
    println("Exercise 6 (De Bruijn) passed.")

    // Exercise 7
    val ep7 = eulerianPathDirected(3, List((0,1),(1,2)))
    assert(ep7 == List(0,1,2), s"Expected List(0,1,2), got $ep7")
    println("Exercise 7 (Eulerian path directed) passed.")

    // Exercise 8
    val arr8 = validArrangement(List((1,2),(2,3),(3,1)))
    assert(arr8.length == 3)
    println("Exercise 8 (Valid arrangement) passed.")

    println("All Algo078_EulerianPath exercises passed!")
  }
}
