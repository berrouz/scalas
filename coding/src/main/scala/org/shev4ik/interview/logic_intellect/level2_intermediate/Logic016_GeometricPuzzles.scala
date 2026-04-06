package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Geometric Puzzles and Computational Geometry=
 *
 * ==Theory: Geometry as Algebra==
 *
 * Computational geometry reduces spatial reasoning to algebraic computation. Many interview
 * problems that ''seem'' geometric can be solved with a few well-known formulas. The key
 * insight is that coordinates turn shapes into numbers, and relationships between shapes
 * become equations.
 *
 * ==The Shoelace Formula==
 *
 * Given a simple polygon with vertices (x1,y1), (x2,y2), ..., (xn,yn) listed in order,
 * the signed area is:
 * {{{
 *   A = 0.5 * |Σ(xi * y(i+1) - x(i+1) * yi)|    (indices mod n)
 * }}}
 * This works because each term computes the signed area of a trapezoid formed by an edge
 * and the x-axis. Named "shoelace" because the cross-multiplication pattern resembles
 * lacing a shoe.
 *
 * ==Pick's Theorem==
 *
 * For a simple lattice polygon (vertices at integer coordinates):
 * {{{
 *   Area = I + B/2 - 1
 * }}}
 * where I = number of interior lattice points, B = number of boundary lattice points.
 * This elegantly connects discrete counting with continuous area.
 *
 * ==Convex Hull Intuition==
 *
 * A polygon is '''convex''' if every interior angle is less than 180° — equivalently, if
 * all cross products of consecutive edge vectors have the same sign. The convex hull of a
 * point set is the smallest convex polygon enclosing all points (think of stretching a
 * rubber band around pins). Algorithms: Graham scan O(n log n), Jarvis march O(nh).
 *
 * ==Tiling and Dissection Problems==
 *
 * Domino tiling of a 2×N board is a classic puzzle with Fibonacci-number solutions:
 * f(1)=1, f(2)=2, f(n) = f(n-1) + f(n-2). This arises because the last column is either
 * filled by one vertical domino (leaving 2×(n-1)) or two horizontal dominoes (leaving
 * 2×(n-2)).
 *
 * ==Comparison: Geometric Techniques==
 *
 * | Technique              | Use Case                         | Complexity    |
 * |------------------------|----------------------------------|---------------|
 * | Shoelace formula       | Area of simple polygon           | O(n)          |
 * | Cross product          | Orientation test, triangle area  | O(1)          |
 * | Barycentric coords     | Point-in-triangle test           | O(1)          |
 * | Line intersection      | Segment intersection             | O(1)          |
 * | Convex hull (Graham)   | Enclosing convex polygon         | O(n log n)    |
 *
 * ==Interview Tips==
 *
 *  - '''Reduce to algebra:''' Most geometry interview problems boil down to cross products,
 *    dot products, or the shoelace formula. Don't try to reason visually — compute.
 *  - '''Watch for degenerate cases:''' Collinear points, zero-area triangles, overlapping
 *    segments. Interviewers love edge cases in geometry.
 *  - '''Floating point:''' Use epsilon comparisons (e.g., Math.abs(a - b) < 1e-9) rather
 *    than exact equality. Mention this proactively in interviews.
 *  - '''Orientation test:''' The sign of cross product (B-A) × (C-A) tells you if A,B,C
 *    are counterclockwise (+), clockwise (-), or collinear (0). This is the workhorse of
 *    computational geometry.
 *  - '''Common patterns:''' Point-in-polygon via ray casting or winding number, closest pair
 *    via divide-and-conquer, line sweep for intersection detection.
 */
object Logic016_GeometricPuzzles {

  /**
   * Exercise 1: Shoelace Area
   *
   * Compute the area of a simple polygon given its vertices in order using the
   * shoelace formula: A = 0.5 * |Σ(xi * y(i+1) - x(i+1) * yi)|.
   *
   * @param vertices list of (x, y) coordinates in order (either CW or CCW)
   * @return the area of the polygon (always positive)
   */
  def exercise1_shoelaceArea(vertices: List[(Double, Double)]): Double = ???

  /**
   * Exercise 2: Triangle Area
   *
   * Compute the area of a triangle defined by three points using the cross product
   * formula: Area = 0.5 * |(B-A) × (C-A)|.
   *
   * @return the area of the triangle (always non-negative)
   */
  def exercise2_triangleArea(a: (Double, Double), b: (Double, Double), c: (Double, Double)): Double = ???

  /**
   * Exercise 3: Is Convex
   *
   * Determine whether a polygon (given as ordered vertices) is convex. A polygon is
   * convex if all cross products of consecutive edge vectors have the same sign.
   *
   * @param vertices list of (x, y) coordinates in order
   * @return true if the polygon is convex
   */
  def exercise3_isConvex(vertices: List[(Double, Double)]): Boolean = ???

  /**
   * Exercise 4: Pick's Theorem
   *
   * Given the number of interior lattice points I and boundary lattice points B
   * of a simple lattice polygon, compute the area using Pick's theorem:
   * Area = I + B/2 - 1.
   *
   * @param interiorPoints number of lattice points strictly inside the polygon
   * @param boundaryPoints number of lattice points on the boundary
   * @return the area of the polygon
   */
  def exercise4_picksTheorem(interiorPoints: Int, boundaryPoints: Int): Double = ???

  /**
   * Exercise 5: Domino Tiling
   *
   * Count the number of ways to tile a 2×N board with 1×2 dominoes.
   * This follows the Fibonacci recurrence: f(1)=1, f(2)=2, f(n)=f(n-1)+f(n-2).
   *
   * @param n the width of the 2×N board (n >= 1)
   * @return the number of distinct tilings
   */
  def exercise5_dominoTiling(n: Int): Int = ???

  /**
   * Exercise 6: Point in Triangle
   *
   * Check whether point P lies inside triangle ABC using barycentric coordinates.
   * Compute signs of cross products for PA×PB, PB×PC, PC×PA — if all have the
   * same sign, P is inside.
   *
   * @return true if point P is inside or on the boundary of triangle ABC
   */
  def exercise6_pointInTriangle(p: (Double, Double),
                                a: (Double, Double),
                                b: (Double, Double),
                                c: (Double, Double)): Boolean = ???

  /**
   * Exercise 7: Line Intersection
   *
   * Find the intersection point of two line segments (p1,p2) and (p3,p4), if it exists.
   * Uses parametric form and solves the 2×2 linear system. Returns None if segments
   * are parallel or do not intersect within their extents.
   *
   * @return Some((x, y)) if segments intersect, None otherwise
   */
  def exercise7_lineIntersection(p1: (Double, Double), p2: (Double, Double),
                                 p3: (Double, Double), p4: (Double, Double)): Option[(Double, Double)] = ???

  /**
   * Exercise 8: Circumscribed Circle (Circumcircle)
   *
   * Given three non-collinear points, find the circumscribed circle — the unique circle
   * passing through all three points. Return center (cx, cy) and radius r.
   *
   * @return (cx, cy, r) — center coordinates and radius of the circumscribed circle
   */
  def exercise8_circumscribedCircle(a: (Double, Double),
                                    b: (Double, Double),
                                    c: (Double, Double)): (Double, Double, Double) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Shoelace Area
    // Square with vertices (0,0), (4,0), (4,4), (0,4) => area = 16
    val square = List((0.0, 0.0), (4.0, 0.0), (4.0, 4.0), (0.0, 4.0))
    val area1 = exercise1_shoelaceArea(square)
    assert(Math.abs(area1 - 16.0) < 1e-9, s"Exercise 1 failed: expected 16.0, got $area1")
    println(s"Exercise 1 - Shoelace area of square: $area1")

    // Triangle (0,0), (6,0), (0,8) => area = 24
    val triangle = List((0.0, 0.0), (6.0, 0.0), (0.0, 8.0))
    val area1b = exercise1_shoelaceArea(triangle)
    assert(Math.abs(area1b - 24.0) < 1e-9, s"Exercise 1 failed: expected 24.0, got $area1b")
    println(s"Exercise 1 - Shoelace area of triangle: $area1b")

    // Exercise 2: Triangle Area
    val area2 = exercise2_triangleArea((0.0, 0.0), (3.0, 0.0), (0.0, 4.0))
    assert(Math.abs(area2 - 6.0) < 1e-9, s"Exercise 2 failed: expected 6.0, got $area2")
    println(s"Exercise 2 - Triangle area: $area2")

    // Exercise 3: Is Convex
    val convexPoly = List((0.0, 0.0), (4.0, 0.0), (4.0, 4.0), (0.0, 4.0))
    assert(exercise3_isConvex(convexPoly), "Exercise 3 failed: square should be convex")
    val concavePoly = List((0.0, 0.0), (4.0, 0.0), (2.0, 1.0), (4.0, 4.0), (0.0, 4.0))
    assert(!exercise3_isConvex(concavePoly), "Exercise 3 failed: L-shape should not be convex")
    println(s"Exercise 3 - Square is convex: true, L-shape is convex: false")

    // Exercise 4: Pick's Theorem
    // Rectangle 4x3: I=6, B=14 => area = 6 + 14/2 - 1 = 12
    val area4 = exercise4_picksTheorem(6, 14)
    assert(Math.abs(area4 - 12.0) < 1e-9, s"Exercise 4 failed: expected 12.0, got $area4")
    println(s"Exercise 4 - Pick's theorem area: $area4")

    // Exercise 5: Domino Tiling
    assert(exercise5_dominoTiling(1) == 1, "Exercise 5 failed for n=1")
    assert(exercise5_dominoTiling(2) == 2, "Exercise 5 failed for n=2")
    assert(exercise5_dominoTiling(3) == 3, "Exercise 5 failed for n=3")
    assert(exercise5_dominoTiling(5) == 8, "Exercise 5 failed for n=5")
    println(s"Exercise 5 - Domino tilings for 2x5: ${exercise5_dominoTiling(5)}")

    // Exercise 6: Point in Triangle
    val inside = exercise6_pointInTriangle((1.0, 1.0), (0.0, 0.0), (4.0, 0.0), (0.0, 4.0))
    assert(inside, "Exercise 6 failed: (1,1) should be inside triangle")
    val outside = exercise6_pointInTriangle((3.0, 3.0), (0.0, 0.0), (4.0, 0.0), (0.0, 4.0))
    assert(!outside, "Exercise 6 failed: (3,3) should be outside triangle")
    println(s"Exercise 6 - (1,1) inside: $inside, (3,3) inside: $outside")

    // Exercise 7: Line Intersection
    // Segments (0,0)-(4,4) and (0,4)-(4,0) intersect at (2,2)
    val inter = exercise7_lineIntersection((0.0, 0.0), (4.0, 4.0), (0.0, 4.0), (4.0, 0.0))
    assert(inter.isDefined, "Exercise 7 failed: segments should intersect")
    val (ix, iy) = inter.get
    assert(Math.abs(ix - 2.0) < 1e-9 && Math.abs(iy - 2.0) < 1e-9,
      s"Exercise 7 failed: expected (2,2), got ($ix,$iy)")
    // Parallel segments
    val noInter = exercise7_lineIntersection((0.0, 0.0), (4.0, 0.0), (0.0, 1.0), (4.0, 1.0))
    assert(noInter.isEmpty, "Exercise 7 failed: parallel segments should not intersect")
    println(s"Exercise 7 - Intersection at: $inter, parallel: $noInter")

    // Exercise 8: Circumscribed Circle
    // Right triangle (0,0), (4,0), (0,3) => circumcenter at (2, 1.5), r = 2.5
    val (cx, cy, r) = exercise8_circumscribedCircle((0.0, 0.0), (4.0, 0.0), (0.0, 3.0))
    assert(Math.abs(cx - 2.0) < 1e-9, s"Exercise 8 failed: expected cx=2.0, got $cx")
    assert(Math.abs(cy - 1.5) < 1e-9, s"Exercise 8 failed: expected cy=1.5, got $cy")
    assert(Math.abs(r - 2.5) < 1e-9, s"Exercise 8 failed: expected r=2.5, got $r")
    println(s"Exercise 8 - Circumscribed circle: center=($cx, $cy), radius=$r")

    println("\nAll geometric puzzle exercises completed!")
  }
}
