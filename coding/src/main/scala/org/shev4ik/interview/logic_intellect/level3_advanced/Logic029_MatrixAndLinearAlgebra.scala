package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Matrix and Linear Algebra Puzzles (Матриці та лінійна алгебра)=
 *
 * ==Theory: Foundations of Computational Mathematics==
 *
 * Linear algebra is the backbone of machine learning, computer graphics,
 * graph algorithms, and scientific computing. This module covers essential
 * matrix operations and their applications.
 *
 * '''Matrix Multiplication:''' For A (m x n) and B (n x p), the product C = A * B
 * is an (m x p) matrix where:
 * {{{
 *   C[i][j] = sum_{k=0}^{n-1} A[i][k] * B[k][j]
 * }}}
 * Time complexity: O(m * n * p). Strassen's algorithm achieves O(n^2.807).
 *
 * '''Determinant:''' A scalar value that encodes properties of a square matrix.
 * {{{
 *   det(2x2): ad - bc for [[a,b],[c,d]]
 *   det(3x3): cofactor expansion along any row or column
 *   det(A) = 0  iff  A is singular (non-invertible)
 * }}}
 *
 * '''Matrix Exponentiation:''' Compute A^n efficiently using repeated squaring
 * in O(k^3 * log n) where k is the matrix dimension. Crucial for:
 *  - Fibonacci in O(log n)
 *  - Graph path counting
 *  - Linear recurrence relations
 *
 * '''Markov Chains:''' A transition matrix T where T[i][j] = P(state j | state i).
 * The steady-state distribution pi satisfies pi * T = pi and sum(pi) = 1.
 * Found by iterating T^n * v0 as n -> infinity, or solving the eigenvector
 * equation directly.
 *
 * '''PageRank:''' Google's algorithm models the web as a Markov chain with
 * damping factor d (typically 0.85):
 * {{{
 *   PR(i) = (1-d)/N + d * sum_{j->i} PR(j) / outDegree(j)
 * }}}
 * Computed via power iteration until convergence.
 *
 * '''Gaussian Elimination:''' Solve Ax = b by transforming [A|b] to row echelon
 * form, then back-substituting. O(n^3) for an n x n system.
 *
 * '''Rotation Matrix:''' Rotate point (x, y) by angle theta:
 * {{{
 *   x' = x * cos(theta) - y * sin(theta)
 *   y' = x * sin(theta) + y * cos(theta)
 * }}}
 *
 * ==Comparison: Matrix Operations==
 *
 * | Operation              | Time Complexity | Key Application           |
 * |------------------------|-----------------|---------------------------|
 * | Multiplication (n x n) | O(n^3)          | Graph algorithms, ML      |
 * | Determinant             | O(n^3)          | Invertibility check       |
 * | Matrix Power            | O(n^3 log k)   | Fibonacci, recurrences    |
 * | Gaussian Elimination    | O(n^3)          | Linear system solving     |
 * | Power Iteration         | O(n^2 * iters) | PageRank, eigenvalues     |
 *
 * ==Interview Tips==
 *
 *  - '''Matrix exponentiation''' is a common competitive programming technique.
 *    Any linear recurrence f(n) = a1*f(n-1) + ... + ak*f(n-k) can be solved
 *    in O(k^3 * log n) using matrix power.
 *  - '''Determinant = 0''' means the system has no unique solution (either
 *    no solution or infinitely many).
 *  - '''PageRank''' is a classic system design interview topic. Know power
 *    iteration and the damping factor's purpose (handling dangling nodes).
 *  - '''Markov chains''' appear in random walk problems and stochastic processes.
 *  - Always check for numerical stability in Gaussian elimination (use partial
 *    pivoting in practice).
 *  - '''Rotation matrices''' are orthogonal: R^T * R = I, det(R) = 1.
 *
 * ==Complexity Note==
 *
 * All standard matrix operations on n x n matrices are O(n^3).
 * Matrix power via repeated squaring is O(n^3 * log k) for A^k.
 * Power iteration for PageRank/Markov is O(n^2) per iteration.
 */
object Logic029_MatrixAndLinearAlgebra {

  /**
   * Exercise 1: Matrix Multiplication
   *
   * Multiply two matrices A (m x n) and B (n x p). Return the resulting (m x p) matrix.
   * Assume dimensions are compatible.
   *
   * @param a matrix A as Array[Array[Double]]
   * @param b matrix B as Array[Array[Double]]
   * @return the product A * B
   */
  def exercise1_matrixMultiply(a: Array[Array[Double]], b: Array[Array[Double]]): Array[Array[Double]] = ???

  /**
   * Exercise 2: Determinant of 2x2 Matrix
   *
   * Compute the determinant of a 2x2 matrix [[a, b], [c, d]] = a*d - b*c.
   *
   * @param m a 2x2 matrix
   * @return the determinant
   */
  def exercise2_determinant2x2(m: Array[Array[Double]]): Double = ???

  /**
   * Exercise 3: Determinant of 3x3 Matrix
   *
   * Compute the determinant of a 3x3 matrix using cofactor expansion along
   * the first row:
   * det = a(ei - fh) - b(di - fg) + c(dh - eg)
   * for matrix [[a,b,c],[d,e,f],[g,h,i]].
   *
   * @param m a 3x3 matrix
   * @return the determinant
   */
  def exercise3_determinant3x3(m: Array[Array[Double]]): Double = ???

  /**
   * Exercise 4: Matrix Power via Repeated Squaring
   *
   * Compute A^n for a square matrix A using repeated squaring.
   * A^0 = Identity matrix.
   * A^n = (A^(n/2))^2 if n is even, A * A^(n-1) if n is odd.
   *
   * @param matrix a square matrix
   * @param n      the exponent (n >= 0)
   * @return matrix raised to power n
   */
  def exercise4_matrixPower(matrix: Array[Array[Long]], n: Int): Array[Array[Long]] = ???

  /**
   * Exercise 5: Markov Chain Steady State
   *
   * Given a transition matrix (row-stochastic: rows sum to 1), find the
   * steady-state distribution by power iteration. Start with uniform
   * distribution and iterate v = v * T until convergence (L1 norm of
   * change < epsilon).
   *
   * @param transition row-stochastic transition matrix
   * @param epsilon    convergence threshold
   * @return steady-state probability distribution
   */
  def exercise5_markovSteadyState(transition: Array[Array[Double]], epsilon: Double): Array[Double] = ???

  /**
   * Exercise 6: Simple PageRank
   *
   * Compute PageRank scores given an adjacency matrix and damping factor.
   * adjacency[i][j] = 1 if page i links to page j, 0 otherwise.
   *
   * PR(i) = (1-d)/N + d * sum_{j: j->i} PR(j) / outDegree(j)
   *
   * Iterate until convergence (max change < epsilon).
   *
   * @param adjacency adjacency matrix (0s and 1s)
   * @param damping   damping factor (typically 0.85)
   * @param epsilon   convergence threshold
   * @return PageRank scores for each page
   */
  def exercise6_pageRankSimple(adjacency: Array[Array[Double]], damping: Double, epsilon: Double): Array[Double] = ???

  /**
   * Exercise 7: Gaussian Elimination
   *
   * Solve the system Ax = b using Gaussian elimination with back-substitution.
   * Assume the system has a unique solution (non-singular A).
   * Use partial pivoting for numerical stability.
   *
   * @param a coefficient matrix (n x n)
   * @param b right-hand side vector (length n)
   * @return solution vector x
   */
  def exercise7_gaussianElimination(a: Array[Array[Double]], b: Array[Double]): Array[Double] = ???

  /**
   * Exercise 8: 2D Rotation via Rotation Matrix
   *
   * Rotate point (x, y) by angle theta (in radians) counterclockwise:
   *   x' = x * cos(theta) - y * sin(theta)
   *   y' = x * sin(theta) + y * cos(theta)
   *
   * @param x     x-coordinate
   * @param y     y-coordinate
   * @param theta rotation angle in radians
   * @return (x', y') the rotated point
   */
  def exercise8_matrixRotation(x: Double, y: Double, theta: Double): (Double, Double) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Matrix Multiplication
    val a1 = Array(Array(1.0, 2.0), Array(3.0, 4.0))
    val b1 = Array(Array(5.0, 6.0), Array(7.0, 8.0))
    val c1 = exercise1_matrixMultiply(a1, b1)
    assert(math.abs(c1(0)(0) - 19.0) < 1e-9 && math.abs(c1(0)(1) - 22.0) < 1e-9)
    assert(math.abs(c1(1)(0) - 43.0) < 1e-9 && math.abs(c1(1)(1) - 50.0) < 1e-9)
    println("Exercise 1 passed: matrixMultiply")

    // Exercise 2: Determinant 2x2
    val m2 = Array(Array(3.0, 8.0), Array(4.0, 6.0))
    assert(math.abs(exercise2_determinant2x2(m2) - (-14.0)) < 1e-9)
    val identity2 = Array(Array(1.0, 0.0), Array(0.0, 1.0))
    assert(math.abs(exercise2_determinant2x2(identity2) - 1.0) < 1e-9)
    println("Exercise 2 passed: determinant2x2")

    // Exercise 3: Determinant 3x3
    val m3 = Array(Array(6.0, 1.0, 1.0), Array(4.0, -2.0, 5.0), Array(2.0, 8.0, 7.0))
    assert(math.abs(exercise3_determinant3x3(m3) - (-306.0)) < 1e-9)
    val identity3 = Array(Array(1.0, 0.0, 0.0), Array(0.0, 1.0, 0.0), Array(0.0, 0.0, 1.0))
    assert(math.abs(exercise3_determinant3x3(identity3) - 1.0) < 1e-9)
    println("Exercise 3 passed: determinant3x3")

    // Exercise 4: Matrix Power
    val fib = Array(Array(1L, 1L), Array(1L, 0L))
    val fib10 = exercise4_matrixPower(fib, 10)
    assert(fib10(0)(0) == 89L, s"F(11) = 89, got ${fib10(0)(0)}") // [[1,1],[1,0]]^10 has F(11)=89 at [0][0]
    val fib0 = exercise4_matrixPower(fib, 0)
    assert(fib0(0)(0) == 1L && fib0(0)(1) == 0L) // Identity
    println("Exercise 4 passed: matrixPower")

    // Exercise 5: Markov Steady State
    // Two-state chain: P(A->B) = 0.3, P(B->A) = 0.5
    val trans = Array(Array(0.7, 0.3), Array(0.5, 0.5))
    val steady = exercise5_markovSteadyState(trans, 1e-8)
    assert(math.abs(steady(0) - 5.0 / 8) < 1e-6, s"Expected 5/8, got ${steady(0)}")
    assert(math.abs(steady(1) - 3.0 / 8) < 1e-6, s"Expected 3/8, got ${steady(1)}")
    println("Exercise 5 passed: markovSteadyState")

    // Exercise 6: PageRank
    // 3 pages: 0->1, 1->2, 2->0 (cycle)
    val adj = Array(
      Array(0.0, 1.0, 0.0),
      Array(0.0, 0.0, 1.0),
      Array(1.0, 0.0, 0.0)
    )
    val pr = exercise6_pageRankSimple(adj, 0.85, 1e-8)
    // In a symmetric cycle, all pages should have equal PageRank
    assert(math.abs(pr(0) - pr(1)) < 1e-4, s"PageRanks should be equal: ${pr.mkString(", ")}")
    assert(math.abs(pr(1) - pr(2)) < 1e-4, s"PageRanks should be equal: ${pr.mkString(", ")}")
    println("Exercise 6 passed: pageRankSimple")

    // Exercise 7: Gaussian Elimination
    // 2x + y = 5, x + 3y = 10 => x = 1, y = 3
    val a7 = Array(Array(2.0, 1.0), Array(1.0, 3.0))
    val b7 = Array(5.0, 10.0)
    val x7 = exercise7_gaussianElimination(a7, b7)
    assert(math.abs(x7(0) - 1.0) < 1e-9, s"Expected x=1, got ${x7(0)}")
    assert(math.abs(x7(1) - 3.0) < 1e-9, s"Expected y=3, got ${x7(1)}")
    println("Exercise 7 passed: gaussianElimination")

    // Exercise 8: Rotation
    // Rotate (1, 0) by 90 degrees (pi/2) => (0, 1)
    val (rx, ry) = exercise8_matrixRotation(1.0, 0.0, math.Pi / 2)
    assert(math.abs(rx - 0.0) < 1e-9, s"Expected x'=0, got $rx")
    assert(math.abs(ry - 1.0) < 1e-9, s"Expected y'=1, got $ry")
    // Rotate (1, 1) by 180 degrees => (-1, -1)
    val (rx2, ry2) = exercise8_matrixRotation(1.0, 1.0, math.Pi)
    assert(math.abs(rx2 - (-1.0)) < 1e-9, s"Expected x'=-1, got $rx2")
    assert(math.abs(ry2 - (-1.0)) < 1e-9, s"Expected y'=-1, got $ry2")
    println("Exercise 8 passed: matrixRotation")

    println("\nAll exercises passed!")
  }
}
