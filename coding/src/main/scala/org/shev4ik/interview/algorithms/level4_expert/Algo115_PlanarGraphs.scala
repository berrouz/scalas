package org.shev4ik.interview.algorithms.level4_expert

/**
 * Planar Graphs - theory, algorithms, and geometric duality.
 *
 * Key concepts:
 * - Planar graph: can be drawn without edge crossings
 * - Euler's formula: V - E + F = 2 for connected planar graphs
 * - Kuratowski's theorem: non-planar iff contains K5 or K3,3 subdivision
 * - Dual graph, planar separators, point location
 */
object Algo115_PlanarGraphs {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Planarity testing concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a basic planarity test using Euler's formula.
   *       For a simple connected graph: if E > 3V - 6, it's not planar.
   *       For bipartite: if E > 2V - 4, it's not planar.
   *       This is a necessary but not sufficient condition.
   *       Return true if the graph MIGHT be planar (passes the test).
   *
   * @param n     number of vertices
   * @param edges list of (u, v) edges
   * @return true if the graph passes the Euler formula planarity bound
   */
  def mightBePlanar(n: Int, edges: List[(Int, Int)]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Euler's formula verification
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a planar graph with its face list, verify Euler's formula:
   *       V - E + F = 2 (for connected graphs) or V - E + F = C + 1
   *       where C is the number of connected components.
   *       Return (V, E, F, components, eulerResult) where eulerResult = V - E + F.
   *
   * @param n     number of vertices
   * @param edges list of (u, v) edges
   * @param faces number of faces (including outer face)
   * @return (V, E, F, components, V-E+F)
   */
  def verifyEulerFormula(n: Int, edges: List[(Int, Int)], faces: Int): (Int, Int, Int, Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Face enumeration for planar embedding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a planar embedding (adjacency list with clockwise ordering),
   *       enumerate all faces by following the face-tracing algorithm.
   *       For each directed edge (u,v), the next edge in the face is
   *       (v, next_clockwise_neighbor_of_u_after_v_in_v's_list).
   *       Return the number of faces found.
   *
   * @param n         number of vertices
   * @param embedding adjacency list: embedding(v) = clockwise ordered neighbors of v
   * @return number of faces in the planar embedding
   */
  def countFaces(n: Int, embedding: Array[List[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Dual graph construction
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a planar graph with its faces enumerated, build the dual graph.
   *       Each face becomes a vertex in the dual. Two dual vertices are
   *       connected if their faces share an edge in the primal.
   *       Return the number of edges in the dual graph.
   *
   * @param n         number of primal vertices
   * @param embedding planar embedding
   * @return number of edges in the dual graph
   */
  def dualGraphEdges(n: Int, embedding: Array[List[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Kuratowski's theorem - check for K5 or K3,3 minor
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Check if a graph contains K5 (complete graph on 5 vertices)
   *       or K3,3 (complete bipartite 3,3) as a subgraph (simplified).
   *       A graph with these subgraphs is definitely not planar.
   *       Return ("K5", vertices) if K5 found, ("K3,3", vertices) if K3,3
   *       found, or ("none", empty) if neither found.
   *       Note: full Kuratowski test requires subdivision check.
   *
   * @param n     number of vertices
   * @param edges list of (u, v) edges
   * @return (type of forbidden subgraph found, involved vertices)
   */
  def findForbiddenSubgraph(n: Int, edges: List[(Int, Int)]): (String, Set[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Planar separator theorem
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find a separator of size O(sqrt(n)) for a planar graph.
   *       Use BFS layering: find a BFS tree, pick a level with few
   *       vertices that splits the graph roughly in half.
   *       Return the separator vertices that split the graph into
   *       two parts, each with at most 2n/3 vertices.
   *
   * @param n     number of vertices
   * @param edges list of (u, v) edges
   * @return set of separator vertices
   */
  def planarSeparator(n: Int, edges: List[(Int, Int)]): Set[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Planar point location
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a planar subdivision (set of non-crossing line segments),
   *       determine which face a query point lies in.
   *       Use a simple approach: for each face, check if the point
   *       is inside using the winding number or ray casting.
   *       Return the face index containing the query point (-1 for outer face).
   *
   * @param faces  list of faces, each face is a list of (x, y) vertices in order
   * @param queryX x-coordinate of query point
   * @param queryY y-coordinate of query point
   * @return index of the face containing the point, or -1 for outer face
   */
  def pointLocation(faces: List[List[(Double, Double)]], queryX: Double, queryY: Double): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Voronoi diagram concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a set of 2D points (sites), compute which site is
   *       closest to a query point (nearest neighbor in Voronoi sense).
   *       This is a simplified version - just find the nearest site.
   *       For a full Voronoi diagram, Fortune's algorithm would be used.
   *       Return the index of the nearest site.
   *
   * @param sites  list of (x, y) site locations
   * @param queryX x-coordinate of query point
   * @param queryY y-coordinate of query point
   * @return index of the nearest site
   */
  def nearestSite(sites: List[(Double, Double)], queryX: Double, queryY: Double): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    // K4 (complete graph on 4 vertices): V=4, E=6, 3*4-6=6 -> might be planar
    assert(mightBePlanar(4, List((0,1),(0,2),(0,3),(1,2),(1,3),(2,3))),
      "K4 should pass planarity bound")
    // K5 (complete graph on 5 vertices): V=5, E=10, 3*5-6=9 -> not planar
    val k5Edges = for (i <- 0 to 4; j <- i+1 to 4) yield (i, j)
    assert(!mightBePlanar(5, k5Edges.toList), "K5 should fail planarity bound")
    println("Exercise 1 (Planarity testing) passed.")

    // Exercise 2
    // Triangle: V=3, E=3, F=2 (inner face + outer face), V-E+F = 2
    val (v, e, f, c, euler) = verifyEulerFormula(3, List((0,1),(1,2),(0,2)), 2)
    assert(euler == 2, s"Expected V-E+F=2, got $euler")
    println("Exercise 2 (Euler's formula) passed.")

    // Exercise 3
    // Square with diagonal: 4 vertices, 5 edges
    val emb = Array(
      List(1, 3, 2), // vertex 0: neighbors in clockwise order
      List(2, 0),     // vertex 1
      List(3, 1, 0),  // vertex 2
      List(0, 2)      // vertex 3
    )
    val faceCount = countFaces(4, emb)
    assert(faceCount > 0, s"Expected > 0 faces, got $faceCount")
    println(s"Exercise 3 (Face enumeration) passed. Faces=$faceCount")

    // Exercise 4
    val dualEdges = dualGraphEdges(4, emb)
    assert(dualEdges > 0, s"Expected > 0 dual edges, got $dualEdges")
    println(s"Exercise 4 (Dual graph) passed. Dual edges=$dualEdges")

    // Exercise 5
    val (subType, _) = findForbiddenSubgraph(5, k5Edges.toList)
    assert(subType == "K5", s"Expected K5, got $subType")
    println("Exercise 5 (Kuratowski check) passed.")

    // Exercise 6
    // Grid graph 3x3
    val gridEdges = (for {
      i <- 0 until 3; j <- 0 until 3
      (di, dj) <- List((0,1),(1,0))
      ni = i + di; nj = j + dj if ni < 3 && nj < 3
    } yield (i * 3 + j, ni * 3 + nj)).toList
    val sep = planarSeparator(9, gridEdges)
    assert(sep.nonEmpty, "Expected non-empty separator")
    println(s"Exercise 6 (Planar separator) passed. Separator size=${sep.size}")

    // Exercise 7
    val triangle = List(List((0.0, 0.0), (4.0, 0.0), (2.0, 3.0)))
    val inside = pointLocation(triangle, 2.0, 1.0)
    assert(inside == 0, s"Expected face 0, got $inside")
    val outside = pointLocation(triangle, 10.0, 10.0)
    assert(outside == -1, s"Expected -1 (outer), got $outside")
    println("Exercise 7 (Point location) passed.")

    // Exercise 8
    val sites = List((0.0, 0.0), (10.0, 0.0), (5.0, 8.0))
    val nearest = nearestSite(sites, 1.0, 1.0)
    assert(nearest == 0, s"Expected site 0, got $nearest")
    val nearest2 = nearestSite(sites, 9.0, 1.0)
    assert(nearest2 == 1, s"Expected site 1, got $nearest2")
    println("Exercise 8 (Voronoi concept) passed.")

    println("All Algo115_PlanarGraphs exercises passed!")
  }
}
