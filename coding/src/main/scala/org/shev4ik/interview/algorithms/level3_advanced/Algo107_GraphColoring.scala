package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Graph Coloring - assigning colors to vertices with constraints.
 *
 * Key concepts:
 * - Proper coloring: no two adjacent vertices share a color
 * - Chromatic number: minimum colors needed
 * - NP-hard in general, but polynomial for special graph classes
 * - Applications: scheduling, register allocation, map coloring
 */
object Algo107_GraphColoring {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Greedy coloring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement greedy graph coloring.
   *       Process vertices in order 0..n-1. Assign each vertex the smallest
   *       color not used by its already-colored neighbors.
   *       Return the color assignment array.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return color assignment (color(i) = color of vertex i, 0-indexed)
   */
  def greedyColoring(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Is k-colorable (backtracking)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Determine if the graph can be properly colored with at most k colors.
   *       Use backtracking: try assigning each color to each vertex,
   *       prune if a conflict is detected.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @param k     number of colors
   * @return true if k-colorable
   */
  def isKColorable(n: Int, edges: List[(Int, Int)], k: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Chromatic number
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the chromatic number (minimum number of colors needed).
   *       Try k = 1, 2, 3, ... until isKColorable returns true.
   *       For small graphs only (exponential worst case).
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return chromatic number
   */
  def chromaticNumber(n: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Welsh-Powell algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Welsh-Powell coloring algorithm.
   *       1. Sort vertices by degree in decreasing order
   *       2. Assign colors greedily in this order
   *       This often produces better results than naive greedy.
   *       Return color assignment.
   *
   * @param n     number of vertices
   * @param edges undirected edges
   * @return color assignment array
   */
  def welshPowell(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Interval graph coloring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Color an interval graph: vertices are intervals, edges connect overlapping intervals.
   *       The chromatic number of an interval graph equals its clique number
   *       (maximum number of simultaneously overlapping intervals).
   *       Return the coloring and the number of colors used.
   *
   * @param intervals list of (start, end)
   * @return (color assignment, number of colors used)
   */
  def intervalGraphColoring(intervals: List[(Int, Int)]): (Array[Int], Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Edge coloring concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Color edges such that no two edges sharing a vertex have the same color.
   *       By Vizing's theorem, this requires either Delta or Delta+1 colors
   *       (where Delta = max vertex degree).
   *       Implement a simple greedy edge coloring.
   *       Return color for each edge.
   *
   * @param n     number of vertices
   * @param edges list of edges (u, v)
   * @return array of edge colors (same index as edges)
   */
  def edgeColoring(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: List coloring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a graph where each vertex has a list of available colors,
   *       find a proper coloring using only colors from each vertex's list.
   *       Return None if no valid coloring exists.
   *
   * @param n              number of vertices
   * @param edges          undirected edges
   * @param availableColors list of available colors for each vertex
   * @return Option of color assignment
   */
  def listColoring(n: Int, edges: List[(Int, Int)], availableColors: Array[Set[Int]]): Option[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Map coloring (four color theorem application)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a planar graph (representing a map), color it using at most 4 colors.
   *       By the Four Color Theorem, this is always possible for planar graphs.
   *       Use backtracking with 4 colors.
   *       Return the coloring.
   *
   * @param n     number of regions
   * @param edges adjacency between regions
   * @return color assignment (values 0-3)
   */
  def mapColoring(n: Int, edges: List[(Int, Int)]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Simple graph: 0-1, 1-2, 2-0, 2-3
    val edges = List((0, 1), (1, 2), (2, 0), (2, 3))

    // Exercise 1
    val colors1 = greedyColoring(4, edges)
    // Verify proper coloring
    assert(edges.forall { case (u, v) => colors1(u) != colors1(v) })
    println("Exercise 1 (Greedy coloring) passed.")

    // Exercise 2
    assert(!isKColorable(4, edges, 2)) // triangle needs 3 colors
    assert(isKColorable(4, edges, 3))
    println("Exercise 2 (k-colorable) passed.")

    // Exercise 3
    assert(chromaticNumber(4, edges) == 3)
    assert(chromaticNumber(4, List((0, 1), (2, 3))) == 2) // bipartite
    println("Exercise 3 (Chromatic number) passed.")

    // Exercise 4
    val colors4 = welshPowell(4, edges)
    assert(edges.forall { case (u, v) => colors4(u) != colors4(v) })
    println("Exercise 4 (Welsh-Powell) passed.")

    // Exercise 5
    val intervals5 = List((1, 3), (2, 5), (4, 7), (6, 8))
    val (iColors, numColors) = intervalGraphColoring(intervals5)
    assert(numColors == 2)
    println("Exercise 5 (Interval graph coloring) passed.")

    // Exercise 6
    val eColors = edgeColoring(4, edges)
    // Verify: no two edges sharing a vertex have same color
    val adj6 = mutable.Map[Int, List[(Int, Int)]]().withDefaultValue(Nil) // vertex -> list of (edge_idx, color)
    edges.zipWithIndex.foreach { case ((u, v), i) =>
      adj6(u) = (i, eColors(i)) :: adj6(u)
      adj6(v) = (i, eColors(i)) :: adj6(v)
    }
    adj6.values.foreach { edgeList =>
      val colors = edgeList.map(_._2)
      assert(colors.distinct.size == colors.size, s"Edge coloring conflict: $edgeList")
    }
    println("Exercise 6 (Edge coloring) passed.")

    // Exercise 7
    val avail7 = Array(Set(0, 1), Set(1, 2), Set(0, 2), Set(0, 1))
    val lc = listColoring(4, edges, avail7)
    assert(lc.isDefined)
    assert(edges.forall { case (u, v) => lc.get(u) != lc.get(v) })
    println("Exercise 7 (List coloring) passed.")

    // Exercise 8
    val mc = mapColoring(4, edges)
    assert(mc.forall(c => c >= 0 && c <= 3))
    assert(edges.forall { case (u, v) => mc(u) != mc(v) })
    println("Exercise 8 (Map coloring) passed.")

    println("All Algo107_GraphColoring exercises passed!")
  }
}
