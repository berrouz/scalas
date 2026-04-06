package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Basic Combinatorics=
 *
 * ==Theory: The Fundamental Counting Principle==
 *
 * If there are n1 ways to make the first choice, n2 ways to make the second choice
 * (independent of the first), ..., and nk ways to make the kth choice, then the total
 * number of ways to make all k choices is n1 * n2 * ... * nk.
 *
 * This principle underlies all combinatorial counting.
 *
 * ==Theory: Permutations==
 *
 * A '''permutation''' is an ordered arrangement of objects.
 *
 *  - '''P(n, n) = n!''' -- the number of ways to arrange n distinct objects in a line.
 *  - '''P(n, k) = n! / (n-k)!''' -- the number of ways to choose and arrange k objects
 *    from n distinct objects.
 *
 * {{{
 * n! = n * (n-1) * (n-2) * ... * 1
 * 0! = 1 (by convention, and necessary for formulas to work)
 * }}}
 *
 * ==Theory: Combinations==
 *
 * A '''combination''' is an unordered selection of objects.
 *
 * {{{
 * C(n, k) = n! / (k! * (n-k)!)
 * }}}
 *
 * Also written as "n choose k" or (n k). Key properties:
 *  - '''Symmetry:''' C(n, k) = C(n, n-k)
 *  - '''Pascal's identity:''' C(n, k) = C(n-1, k-1) + C(n-1, k)
 *  - '''Sum of row:''' C(n,0) + C(n,1) + ... + C(n,n) = 2^n
 *  - '''Hockey stick:''' C(r,r) + C(r+1,r) + ... + C(n,r) = C(n+1, r+1)
 *
 * ==Theory: Pascal's Triangle==
 *
 * Each entry is the sum of the two entries above it:
 * {{{
 *         1
 *        1 1
 *       1 2 1
 *      1 3 3 1
 *     1 4 6 4 1
 * }}}
 *
 * Row n contains C(n,0), C(n,1), ..., C(n,n). Pascal's triangle encodes binomial
 * coefficients and has connections to probability, number theory, and fractal geometry
 * (Sierpinski triangle via mod 2).
 *
 * ==Theory: Catalan Numbers==
 *
 * The nth Catalan number is:
 * {{{
 * C(n) = C(2n, n) / (n + 1) = (2n)! / ((n+1)! * n!)
 * }}}
 *
 * Catalan numbers count an astonishing variety of structures:
 *  - Number of valid parenthesizations of n pairs of parentheses
 *  - Number of distinct binary search trees with n nodes
 *  - Number of ways to triangulate a convex polygon with n+2 sides
 *  - Number of paths in an n x n grid that don't cross the diagonal
 *  - Number of non-crossing partitions of {1, ..., n}
 *
 * First few values: 1, 1, 2, 5, 14, 42, 132, 429, 1430, ...
 *
 * ==Theory: Stars and Bars==
 *
 * The number of ways to distribute n identical items into k distinct bins is:
 * {{{
 * C(n + k - 1, k - 1)
 * }}}
 *
 * Equivalently, the number of non-negative integer solutions to x1 + x2 + ... + xk = n.
 * Visualize: n stars and k-1 bars (separators), choose positions for the bars.
 *
 * ==Theory: Lattice Paths==
 *
 * The number of paths from (0,0) to (m,n) using only right (R) and down (D) moves is:
 * {{{
 * C(m + n, m)  =  C(m + n, n)
 * }}}
 *
 * This is because any path consists of exactly m right moves and n down moves, and we
 * choose which m of the (m+n) total moves are rightward.
 *
 * ==Comparison: Permutations vs Combinations==
 *
 * | Aspect        | Permutations P(n,k)    | Combinations C(n,k)     |
 * |---------------|------------------------|-------------------------|
 * | Order matters | Yes                    | No                      |
 * | Formula       | n!/(n-k)!              | n!/(k!(n-k)!)           |
 * | Example       | Ranking, arrangements  | Committees, subsets     |
 * | Relationship  | P(n,k) = k! * C(n,k)  | C(n,k) = P(n,k) / k!   |
 *
 * ==Interview Tips==
 *
 *  - Always clarify: does order matter? This determines permutation vs combination.
 *  - Use BigInt for factorials to avoid overflow (20! > Long.MaxValue).
 *  - Compute C(n,k) incrementally to avoid computing huge factorials:
 *    C(n,k) = (n * (n-1) * ... * (n-k+1)) / (k * (k-1) * ... * 1)
 *  - The staircase problem (climb n stairs, 1 or 2 steps) gives Fibonacci numbers.
 *    This is a classic DP/recursion interview question.
 *  - Know that Catalan numbers appear in many tree-counting problems.
 *  - Pascal's triangle can be generated row by row in O(n^2) time and O(n) space
 *    (only need previous row to compute current row).
 */
object Logic004_BasicCombinatorics {

  // Exercise 1: Compute n! (n factorial).
  // 0! = 1, n! = n * (n-1)!
  // Use BigInt to handle large values.
  // Example: exercise1_factorial(5) => 120
  def exercise1_factorial(n: Int): BigInt = ???

  // Exercise 2: Compute C(n, k) = n! / (k! * (n-k)!).
  // Use an efficient method to avoid unnecessarily large intermediate values.
  // Handle edge cases: k > n => 0, k == 0 or k == n => 1.
  // Example: exercise2_combinations(10, 3) => 120
  def exercise2_combinations(n: Int, k: Int): BigInt = ???

  // Exercise 3: Generate the first n rows (0-indexed) of Pascal's triangle.
  // Row 0 = List(1), Row 1 = List(1,1), Row 2 = List(1,2,1), etc.
  // Example: exercise3_pascalTriangle(5) =>
  //   List(List(1), List(1,1), List(1,2,1), List(1,3,3,1), List(1,4,6,4,1))
  def exercise3_pascalTriangle(n: Int): List[List[Int]] = ???

  // Exercise 4: How many distinct ways can you climb n stairs if you can take 1 or 2 steps?
  // This is the Fibonacci sequence: f(1)=1, f(2)=2, f(n)=f(n-1)+f(n-2).
  // Example: exercise4_climbStairs(5) => 8
  def exercise4_climbStairs(n: Int): Int = ???

  // Exercise 5: Count the number of paths in an m x n grid from top-left to bottom-right,
  // moving only right or down. Answer = C(m + n, m) = C(m + n, n).
  // Note: m and n represent the number of moves right and down respectively
  // (so a grid with m+1 columns and n+1 rows).
  // Example: exercise5_latticePaths(2, 3) => 10 (C(5,2))
  def exercise5_latticePaths(m: Int, n: Int): BigInt = ???

  // Exercise 6: Compute the nth Catalan number (0-indexed).
  // C(0) = 1, C(n) = C(2n, n) / (n + 1)
  // Example: exercise6_catalanNumber(0) => 1
  // Example: exercise6_catalanNumber(3) => 5
  // Example: exercise6_catalanNumber(5) => 42
  def exercise6_catalanNumber(n: Int): BigInt = ???

  // Exercise 7: Count permutations P(n, k) = n! / (n-k)!
  // Example: exercise7_permutationsCount(5, 3) => 60
  def exercise7_permutationsCount(n: Int, k: Int): BigInt = ???

  // Exercise 8: Stars and Bars -- distribute n identical items into k distinct bins.
  // Number of ways = C(n + k - 1, k - 1).
  // Example: exercise8_starsAndBars(5, 3) => C(7, 2) = 21
  def exercise8_starsAndBars(n: Int, k: Int): BigInt = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: factorial
    assert(exercise1_factorial(0) == BigInt(1))
    assert(exercise1_factorial(1) == BigInt(1))
    assert(exercise1_factorial(5) == BigInt(120))
    assert(exercise1_factorial(10) == BigInt(3628800))
    assert(exercise1_factorial(20) == BigInt("2432902008176640000"))
    println("Exercise 1 passed: exercise1_factorial")

    // Exercise 2: combinations
    assert(exercise2_combinations(10, 3) == BigInt(120))
    assert(exercise2_combinations(5, 0) == BigInt(1))
    assert(exercise2_combinations(5, 5) == BigInt(1))
    assert(exercise2_combinations(3, 4) == BigInt(0))
    assert(exercise2_combinations(20, 10) == BigInt(184756))
    println("Exercise 2 passed: exercise2_combinations")

    // Exercise 3: pascalTriangle
    assert(exercise3_pascalTriangle(1) == List(List(1)))
    assert(exercise3_pascalTriangle(5) == List(
      List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1), List(1, 4, 6, 4, 1)
    ))
    println("Exercise 3 passed: exercise3_pascalTriangle")

    // Exercise 4: climbStairs
    assert(exercise4_climbStairs(1) == 1)
    assert(exercise4_climbStairs(2) == 2)
    assert(exercise4_climbStairs(3) == 3)
    assert(exercise4_climbStairs(5) == 8)
    assert(exercise4_climbStairs(10) == 89)
    println("Exercise 4 passed: exercise4_climbStairs")

    // Exercise 5: latticePaths
    assert(exercise5_latticePaths(2, 3) == BigInt(10))
    assert(exercise5_latticePaths(0, 5) == BigInt(1))
    assert(exercise5_latticePaths(3, 3) == BigInt(20))
    println("Exercise 5 passed: exercise5_latticePaths")

    // Exercise 6: catalanNumber
    assert(exercise6_catalanNumber(0) == BigInt(1))
    assert(exercise6_catalanNumber(1) == BigInt(1))
    assert(exercise6_catalanNumber(2) == BigInt(2))
    assert(exercise6_catalanNumber(3) == BigInt(5))
    assert(exercise6_catalanNumber(4) == BigInt(14))
    assert(exercise6_catalanNumber(5) == BigInt(42))
    println("Exercise 6 passed: exercise6_catalanNumber")

    // Exercise 7: permutationsCount
    assert(exercise7_permutationsCount(5, 3) == BigInt(60))
    assert(exercise7_permutationsCount(5, 0) == BigInt(1))
    assert(exercise7_permutationsCount(5, 5) == BigInt(120))
    assert(exercise7_permutationsCount(10, 2) == BigInt(90))
    println("Exercise 7 passed: exercise7_permutationsCount")

    // Exercise 8: starsAndBars
    assert(exercise8_starsAndBars(5, 3) == BigInt(21))
    assert(exercise8_starsAndBars(0, 3) == BigInt(1))
    assert(exercise8_starsAndBars(10, 1) == BigInt(1))
    assert(exercise8_starsAndBars(3, 2) == BigInt(4))
    println("Exercise 8 passed: exercise8_starsAndBars")

    println("\nAll exercises passed!")
  }
}
