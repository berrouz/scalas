package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Topological Puzzles (Топологічні головоломки)=
 *
 * ==Theory: Topology in Discrete Mathematics and Computer Science==
 *
 * Topology studies properties preserved under continuous deformations. Several
 * topological theorems have direct applications in combinatorics, graph theory,
 * and computational geometry, making them relevant in advanced interviews.
 *
 * '''Euler's Formula:''' For any connected planar graph, V - E + F = 2, where
 * V = vertices, E = edges, F = faces (including the unbounded face). This
 * implies E ≤ 3V - 6 for simple planar graphs (V ≥ 3), and E ≤ 2V - 4 for
 * triangle-free planar graphs. These bounds are essential for planarity testing.
 *
 * '''Kuratowski's Theorem:''' A graph is planar if and only if it contains no
 * subdivision of K₅ (complete graph on 5 vertices) or K₃,₃ (complete bipartite
 * graph on 3+3 vertices). In practice, the bound E ≤ 3V - 6 is a quick
 * necessary condition.
 *
 * '''Sperner's Lemma:''' Given a triangulation of a triangle with vertices
 * labeled 1, 2, 3 (with boundary constraints: each edge of the big triangle
 * uses only two labels), the number of "rainbow" cells (small triangles with
 * all three labels) is odd (and hence at least 1). This is a discrete analog
 * of Brouwer's fixed point theorem.
 *
 * '''Borsuk-Ulam Theorem:''' For any continuous function f: Sⁿ → Rⁿ, there
 * exists a point x where f(x) = f(-x). Implication: you cannot embed Sⁿ into
 * Rⁿ⁻¹ injectively. The "ham sandwich theorem" follows from this.
 *
 * '''Graph Genus:''' The genus g of a graph is the minimum genus of a surface
 * on which it can be embedded without crossings. For orientable surfaces:
 * V - E + F = 2 - 2g. The torus has genus 1 and allows graphs needing up to
 * 7 colors (Heawood conjecture, proven as the Map Color Theorem).
 *
 * '''Jordan Curve Theorem:''' A simple closed curve in the plane divides it
 * into exactly two regions (interior and exterior). The ray-casting algorithm
 * for point-in-polygon is a computational application: cast a ray from the
 * point and count edge crossings. Odd crossings = inside.
 *
 * ==Comparison: Topological Results and Applications==
 *
 * | Theorem             | Statement                              | CS Application                   |
 * |---------------------|----------------------------------------|----------------------------------|
 * | Euler's Formula     | V - E + F = 2 (planar)                 | Planarity testing, face counting |
 * | Kuratowski          | No K₅ or K₃,₃ subdivision ⟹ planar    | Graph drawing, circuit layout    |
 * | Sperner's Lemma     | Rainbow triangle exists (odd count)    | Fixed point computation, fair div|
 * | Borsuk-Ulam         | Antipodal points map to same value     | Ham sandwich, necklace splitting |
 * | Jordan Curve        | Simple curve splits plane into 2       | Point-in-polygon, ray casting    |
 * | Four Color Theorem  | 4 colors suffice for planar graphs     | Map coloring, register allocation|
 *
 * ==Interview Tips==
 *
 *  - '''Euler's formula''' is a common warm-up: "prove E ≤ 3V - 6 for planar graphs."
 *  - '''Point-in-polygon''' (Jordan curve) is a classic geometry interview question.
 *  - '''Four color theorem''' is rarely asked to prove but good to know for coloring problems.
 *  - '''Sperner's lemma''' appears in fair division algorithms (envy-free cake cutting).
 *  - Know that K₅ and K₃,₃ are the '''minimal non-planar''' graphs.
 *  - Graph genus questions appear in topological graph theory — rare but impressive to know.
 *  - '''Brouwer fixed point''' can be approximated computationally via bisection.
 *
 * ==Complexity Note==
 *
 * Planarity testing can be done in O(V) using algorithms by Hopcroft-Tarjan or
 * Boyer-Myrvold. Point-in-polygon ray casting is O(E) where E is the number of
 * polygon edges. Sperner's lemma proof is constructive and runs in O(number of cells).
 */
object Logic038_TopologicalPuzzles {

  /**
   * Exercise 1: Euler's Formula Verification
   *
   * Verify that V - E + F = 2 for a given planar graph. This is Euler's
   * formula for connected planar graphs.
   *
   * @param v number of vertices
   * @param e number of edges
   * @param f number of faces (including unbounded face)
   * @return true if Euler's formula holds
   */
  def exercise1_eulerFormula(v: Int, e: Int, f: Int): Boolean = ???

  /**
   * Exercise 2: Planarity Check (Simplified)
   *
   * A necessary condition for planarity of a simple graph: E ≤ 3V - 6
   * (for V ≥ 3). This is derived from Euler's formula by noting each face
   * is bounded by at least 3 edges. Return whether this condition holds.
   *
   * @param v number of vertices (v >= 3)
   * @param e number of edges
   * @return true if the edge count is consistent with planarity
   */
  def exercise2_isPlanar(v: Int, e: Int): Boolean = ???

  /**
   * Exercise 3: Sperner Triangle Counting
   *
   * Given a triangulation as a list of triples (label1, label2, label3) where
   * labels are 1, 2, or 3, count the number of "rainbow" triangles (cells
   * containing all three labels). By Sperner's lemma, this count is odd.
   *
   * @param triangles list of (label, label, label) for each cell in the triangulation
   * @return number of rainbow triangles (cells with all 3 distinct labels)
   */
  def exercise3_spernerTriangle(triangles: List[(Int, Int, Int)]): Int = ???

  /**
   * Exercise 4: Genus of Graph
   *
   * Compute the genus of a graph from its embedding data using the generalized
   * Euler formula: V - E + F = 2 - 2g, so g = (2 - V + E - F) / 2.
   *
   * @param v number of vertices
   * @param e number of edges
   * @param f number of faces in the embedding
   * @return genus of the surface (0 = sphere/plane, 1 = torus, etc.)
   */
  def exercise4_genusOfGraph(v: Int, e: Int, f: Int): Int = ???

  /**
   * Exercise 5: Verify 4-Coloring
   *
   * Given a graph as an adjacency list and a coloring (vertex -> color with
   * colors 1-4), verify that no two adjacent vertices share the same color.
   *
   * @param adjacency adjacency list: vertex index -> list of neighbor indices
   * @param coloring  array where coloring(i) is the color of vertex i (1 to 4)
   * @return true if the coloring is valid
   */
  def exercise5_fourColorVerify(adjacency: Array[List[Int]], coloring: Array[Int]): Boolean = ???

  /**
   * Exercise 6: Point-in-Polygon (Jordan Curve Theorem)
   *
   * Determine if a point (px, py) is inside a polygon defined by a sequence
   * of vertices using the ray casting algorithm. Cast a horizontal ray to
   * the right and count edge crossings. Odd = inside.
   *
   * @param polygon list of (x, y) vertices defining the polygon in order
   * @param px      x-coordinate of the query point
   * @param py      y-coordinate of the query point
   * @return true if the point is inside the polygon
   */
  def exercise6_jordanCurve(polygon: List[(Double, Double)], px: Double, py: Double): Boolean = ???

  /**
   * Exercise 7: Torus Chromatic Number Bound
   *
   * The Heawood number gives the maximum chromatic number for graphs on a
   * surface of genus g: H(g) = floor((7 + sqrt(1 + 48g)) / 2).
   * For the torus (g=1), this is 7. Compute H(g) for a given genus.
   *
   * @param g genus of the surface (g >= 1)
   * @return the Heawood number (maximum chromatic number on that surface)
   */
  def exercise7_torusGraph(g: Int): Int = ???

  /**
   * Exercise 8: Brouwer Fixed Point Approximation
   *
   * Given a continuous function f: [0,1] -> [0,1], find an approximate fixed
   * point (where f(x) = x) using bisection on g(x) = f(x) - x. Since
   * g(0) = f(0) >= 0 and g(1) = f(1) - 1 <= 0, by IVT there exists x with
   * g(x) = 0, i.e., f(x) = x.
   *
   * @param f       continuous function from [0,1] to [0,1]
   * @param epsilon precision: stop when interval width < epsilon
   * @return approximate fixed point x where |f(x) - x| < epsilon
   */
  def exercise8_brouwerFixedPoint(f: Double => Double, epsilon: Double): Double = ???

  def main(args: Array[String]): Unit = {

    // Exercise 1: Euler's Formula
    // Tetrahedron: V=4, E=6, F=4 → 4-6+4 = 2 ✓
    assert(exercise1_eulerFormula(4, 6, 4) == true, "Tetrahedron should satisfy Euler's formula")
    // Cube: V=8, E=12, F=6 → 8-12+6 = 2 ✓
    assert(exercise1_eulerFormula(8, 12, 6) == true, "Cube should satisfy Euler's formula")
    assert(exercise1_eulerFormula(4, 6, 5) == false, "V=4,E=6,F=5 violates Euler's formula")
    println(s"Exercise 1 - Euler formula (tetrahedron): ${exercise1_eulerFormula(4, 6, 4)}")

    // Exercise 2: Planarity Check
    // K4: V=4, E=6. 3*4-6 = 6. 6 <= 6 ✓
    assert(exercise2_isPlanar(4, 6) == true, "K4 is planar, E=6 ≤ 3*4-6=6")
    // K5: V=5, E=10. 3*5-6 = 9. 10 > 9 ✗
    assert(exercise2_isPlanar(5, 10) == false, "K5 is not planar, E=10 > 3*5-6=9")
    println(s"Exercise 2 - Planarity K4 (V=4,E=6): ${exercise2_isPlanar(4, 6)}")
    println(s"Exercise 2 - Planarity K5 (V=5,E=10): ${exercise2_isPlanar(5, 10)}")

    // Exercise 3: Sperner Triangle
    val triangles = List((1, 2, 3), (1, 1, 2), (2, 2, 3), (1, 2, 3), (3, 3, 1), (1, 3, 2))
    val rainbowCount = exercise3_spernerTriangle(triangles)
    assert(rainbowCount == 3, s"Should have 3 rainbow triangles (odd per Sperner's lemma), got $rainbowCount")
    println(s"Exercise 3 - Sperner rainbow triangles: $rainbowCount")

    // Exercise 4: Genus of Graph
    // Planar graph: g = (2-4+6-4)/2 = 0
    assert(exercise4_genusOfGraph(4, 6, 4) == 0, "Tetrahedron has genus 0")
    // Torus embedding: V-E+F = 0, so g = (2-0)/2 = 1
    assert(exercise4_genusOfGraph(1, 3, 2) == 1, "Graph with V-E+F=0 has genus 1")
    println(s"Exercise 4 - Genus (tetrahedron): ${exercise4_genusOfGraph(4, 6, 4)}")

    // Exercise 5: Verify 4-Coloring
    // Triangle with valid coloring
    val adj5 = Array(List(1, 2), List(0, 2), List(0, 1))
    val validColoring = Array(1, 2, 3)
    assert(exercise5_fourColorVerify(adj5, validColoring) == true, "Valid 3-coloring of triangle")
    val invalidColoring = Array(1, 2, 1)
    assert(exercise5_fourColorVerify(adj5, invalidColoring) == false, "Invalid: vertices 0 and 2 are adjacent with same color")
    println(s"Exercise 5 - Valid 4-coloring (triangle): ${exercise5_fourColorVerify(adj5, validColoring)}")

    // Exercise 6: Point-in-Polygon
    val square = List((0.0, 0.0), (4.0, 0.0), (4.0, 4.0), (0.0, 4.0))
    assert(exercise6_jordanCurve(square, 2.0, 2.0) == true, "Center of square should be inside")
    assert(exercise6_jordanCurve(square, 5.0, 5.0) == false, "Point outside square")
    println(s"Exercise 6 - Point (2,2) in square: ${exercise6_jordanCurve(square, 2.0, 2.0)}")
    println(s"Exercise 6 - Point (5,5) in square: ${exercise6_jordanCurve(square, 5.0, 5.0)}")

    // Exercise 7: Torus Chromatic Number
    // Genus 1 (torus): H(1) = floor((7 + sqrt(49))/2) = floor(7) = 7
    assert(exercise7_torusGraph(1) == 7, "Heawood number for torus should be 7")
    println(s"Exercise 7 - Heawood number (torus, g=1): ${exercise7_torusGraph(1)}")

    // Exercise 8: Brouwer Fixed Point
    // f(x) = x^2 has fixed points at 0 and 1. Bisection on g(x) = x^2 - x should find one.
    val fixedPt = exercise8_brouwerFixedPoint(x => 0.5 * x + 0.25, 1e-6)
    // Fixed point: 0.5x + 0.25 = x → x = 0.5
    assert(math.abs(fixedPt - 0.5) < 1e-4, s"Fixed point of 0.5x+0.25 should be ~0.5, got $fixedPt")
    println(s"Exercise 8 - Brouwer fixed point (0.5x+0.25): $fixedPt")

    println("\nAll Logic038_TopologicalPuzzles exercises passed!")
  }
}
