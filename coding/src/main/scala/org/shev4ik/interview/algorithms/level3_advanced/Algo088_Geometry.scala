package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Computational Geometry - fundamental geometric algorithms.
 *
 * Key concepts:
 * - Cross product for orientation tests
 * - Convex hull: Graham scan O(n log n), Jarvis march O(nh)
 * - Closest pair of points: O(n log n) divide and conquer
 * - Sweep line techniques
 */
object Algo088_Geometry {

  case class Point(x: Double, y: Double)
  case class Segment(p1: Point, p2: Point)

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Point distance
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the Euclidean distance between two points.
   *
   * @param p1 first point
   * @param p2 second point
   * @return Euclidean distance
   */
  def distance(p1: Point, p2: Point): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Line intersection
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the intersection point of two lines, each defined by two points.
   *       Line 1: through p1 and p2. Line 2: through p3 and p4.
   *       Return None if lines are parallel.
   *
   * @param p1 first point of line 1
   * @param p2 second point of line 1
   * @param p3 first point of line 2
   * @param p4 second point of line 2
   * @return Option[Point] intersection point
   */
  def lineIntersection(p1: Point, p2: Point, p3: Point, p4: Point): Option[Point] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Convex hull (Graham scan)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the convex hull using Graham scan algorithm.
   *       1. Find the bottommost (then leftmost) point.
   *       2. Sort by polar angle.
   *       3. Process points using a stack, removing clockwise turns.
   *       Return hull vertices in counter-clockwise order.
   *
   * @param points set of 2D points
   * @return convex hull vertices in CCW order
   */
  def convexHullGraham(points: List[Point]): List[Point] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Convex hull (Jarvis march / Gift wrapping)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the convex hull using Jarvis march (gift wrapping).
   *       Start from leftmost point, always pick the most counter-clockwise point.
   *       O(nh) where h = number of hull vertices.
   *
   * @param points set of 2D points
   * @return convex hull vertices in CCW order
   */
  def convexHullJarvis(points: List[Point]): List[Point] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Closest pair of points
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the closest pair of points using divide and conquer.
   *       O(n log n) time.
   *       Return (point1, point2, distance).
   *
   * @param points list of points
   * @return (closest point 1, closest point 2, distance)
   */
  def closestPair(points: List[Point]): (Point, Point, Double) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Polygon area (Shoelace formula)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the area of a simple polygon given its vertices in order.
   *       Use the Shoelace formula:
   *       Area = 0.5 * |sum of (x_i * y_{i+1} - x_{i+1} * y_i)|
   *
   * @param vertices polygon vertices in order (first != last, loop implied)
   * @return area of polygon
   */
  def polygonArea(vertices: List[Point]): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Point in polygon (ray casting)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Determine if a point is inside a simple polygon using ray casting.
   *       Cast a ray from point to the right; count edge crossings.
   *       Odd crossings = inside, even = outside.
   *
   * @param point    query point
   * @param polygon  polygon vertices in order
   * @return true if point is inside polygon
   */
  def pointInPolygon(point: Point, polygon: List[Point]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Line segment intersection
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Determine if two line segments intersect.
   *       Use orientation tests (cross product).
   *       Handle collinear overlap cases.
   *
   * @param s1 first segment
   * @param s2 second segment
   * @return true if segments intersect
   */
  def segmentsIntersect(s1: Segment, s2: Segment): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val d = distance(Point(0, 0), Point(3, 4))
    assert(math.abs(d - 5.0) < 1e-9, s"Expected 5.0, got $d")
    println("Exercise 1 (Point distance) passed.")

    // Exercise 2
    val inter = lineIntersection(Point(0, 0), Point(1, 1), Point(0, 1), Point(1, 0))
    assert(inter.isDefined)
    assert(math.abs(inter.get.x - 0.5) < 1e-9)
    println("Exercise 2 (Line intersection) passed.")

    // Exercise 3
    val pts3 = List(Point(0,0), Point(1,0), Point(1,1), Point(0,1), Point(0.5,0.5))
    val hull3 = convexHullGraham(pts3)
    assert(hull3.size == 4)
    println("Exercise 3 (Graham scan) passed.")

    // Exercise 4
    val hull4 = convexHullJarvis(pts3)
    assert(hull4.size == 4)
    println("Exercise 4 (Jarvis march) passed.")

    // Exercise 5
    val pts5 = List(Point(0,0), Point(1,1), Point(3,3), Point(0.1, 0.1))
    val (cp1, cp2, cd) = closestPair(pts5)
    assert(cd < 0.2)
    println("Exercise 5 (Closest pair) passed.")

    // Exercise 6
    val area = polygonArea(List(Point(0,0), Point(4,0), Point(4,3), Point(0,3)))
    assert(math.abs(area - 12.0) < 1e-9)
    println("Exercise 6 (Polygon area) passed.")

    // Exercise 7
    val poly = List(Point(0,0), Point(4,0), Point(4,4), Point(0,4))
    assert(pointInPolygon(Point(2, 2), poly))
    assert(!pointInPolygon(Point(5, 5), poly))
    println("Exercise 7 (Point in polygon) passed.")

    // Exercise 8
    assert(segmentsIntersect(Segment(Point(0,0), Point(1,1)), Segment(Point(0,1), Point(1,0))))
    assert(!segmentsIntersect(Segment(Point(0,0), Point(1,0)), Segment(Point(0,1), Point(1,1))))
    println("Exercise 8 (Segment intersection) passed.")

    println("All Algo088_Geometry exercises passed!")
  }
}
