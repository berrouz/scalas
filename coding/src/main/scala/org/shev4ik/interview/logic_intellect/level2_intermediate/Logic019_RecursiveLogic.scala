package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Recursive Thinking and Self-Reference=
 *
 * ==Theory: The Nature of Recursion==
 *
 * Recursion is solving a problem by reducing it to smaller instances of ''the same'' problem.
 * Every recursive solution needs:
 *  - '''Base case(s):''' The simplest instances that can be solved directly.
 *  - '''Recursive case:''' Breaking the problem into smaller subproblems and combining results.
 *
 * The key mental model is the '''leap of faith''': assume the recursive call works correctly
 * for smaller inputs, then show how to combine results for the current input.
 *
 * ==Famous Recursive Functions==
 *
 * '''Ackermann function A(m, n):''' Grows faster than any primitive recursive function.
 * {{{
 *   A(0, n) = n + 1
 *   A(m, 0) = A(m-1, 1)
 *   A(m, n) = A(m-1, A(m, n-1))
 * }}}
 * Even A(4, 2) = 2^65536 - 3 — a number with ~19,729 digits. This function demonstrates
 * that not all computable functions are primitive recursive.
 *
 * '''McCarthy 91 function:'''
 * {{{
 *   M(n) = n - 10        if n > 100
 *   M(n) = M(M(n + 11))  if n <= 100
 * }}}
 * Surprisingly, M(n) = 91 for all n <= 100. This is a classic example of a function whose
 * behavior is non-obvious from its definition but has an elegant closed form.
 *
 * ==Stern-Brocot Tree==
 *
 * A binary tree that contains every positive rational number exactly once. Starting from
 * 0/1 and 1/0 as boundaries, the mediant (a+c)/(b+d) of fractions a/b and c/d generates
 * all rationals in lowest terms. Used in clock arithmetic, continued fractions, and
 * number theory.
 *
 * ==Comparison: Recursion Patterns==
 *
 * | Pattern               | Description                                  | Example              |
 * |-----------------------|----------------------------------------------|----------------------|
 * | Linear recursion      | Single recursive call                        | Factorial, McCarthy  |
 * | Binary recursion      | Two recursive calls                          | Fibonacci, Ackermann |
 * | Mutual recursion      | Two functions calling each other              | isEven/isOdd         |
 * | Generate & filter     | Generate candidates, filter valid ones       | Parentheses, subsets |
 * | Divide and conquer    | Split, solve halves, merge                   | Merge sort           |
 * | Backtracking          | Try choices, undo if stuck                   | N-Queens, Sudoku     |
 *
 * ==Interview Tips==
 *
 *  - '''Think recursively first, optimize later:''' Start with the clearest recursive solution,
 *    then discuss memoization or iteration if needed. Interviewers value clarity.
 *  - '''Draw the recursion tree:''' For problems like generating parentheses or power sets,
 *    sketching the tree of choices makes the solution obvious.
 *  - '''Include/exclude pattern:''' For subset generation, at each element decide to include
 *    or exclude it. This gives 2^n subsets and is the basis of many combinatorial problems.
 *  - '''Mutual recursion:''' Less common but elegant. isEven(n) calls isOdd(n-1) and vice versa.
 *    Know that this can always be converted to direct recursion.
 *  - '''Tail recursion:''' Scala optimizes tail-recursive functions with @tailrec. Convert
 *    accumulator-style when possible to avoid stack overflow.
 *  - '''Frame-Stewart:''' The 4-peg Hanoi problem has a conjectured (proven for small n)
 *    optimal solution using Frame-Stewart algorithm. Good for showing mathematical depth.
 */
object Logic019_RecursiveLogic {

  /**
   * Exercise 1: Ackermann Function
   *
   * Compute the Ackermann function A(m, n) for small values of m and n.
   * Warning: grows astronomically fast. Only call with small inputs (m <= 3, n <= 10).
   *
   * @param m non-negative integer (keep small, <= 3)
   * @param n non-negative integer (keep small)
   * @return A(m, n) as BigInt
   */
  def exercise1_ackermann(m: Int, n: Int): BigInt = ???

  /**
   * Exercise 2: McCarthy 91 Function
   *
   * Compute the McCarthy 91 function:
   *   M(n) = n - 10        if n > 100
   *   M(n) = M(M(n + 11))  if n <= 100
   * Verify that M(n) = 91 for all n <= 100.
   *
   * @param n input integer
   * @return M(n)
   */
  def exercise2_mcCarthy91(n: Int): Int = ???

  /**
   * Exercise 3: Stern-Brocot Tree
   *
   * Generate the fractions in the Stern-Brocot tree up to depth d (root is depth 1).
   * At each node with left boundary a/b and right boundary c/d, the mediant is
   * (a+c)/(b+d). Return fractions in breadth-first order.
   *
   * @param depth maximum depth of the tree to generate
   * @return list of fractions as (numerator, denominator) pairs in BFS order
   */
  def exercise3_sternBrocot(depth: Int): List[(Int, Int)] = ???

  /**
   * Exercise 4: Mutual Recursion — isEven / isOdd
   *
   * Determine if a non-negative integer is even using mutual recursion (no modulo):
   *   isEven(0) = true
   *   isEven(n) = isOdd(n - 1)
   *   isOdd(0) = false
   *   isOdd(n) = isEven(n - 1)
   *
   * @param n non-negative integer
   * @return true if n is even
   */
  def exercise4_mutualRecursion(n: Int): Boolean = ???

  /**
   * Exercise 5: 4-Peg Tower of Hanoi (Frame-Stewart)
   *
   * Compute the minimum number of moves for the 4-peg Tower of Hanoi problem using
   * the Frame-Stewart algorithm:
   *   f(0) = 0
   *   f(n) = min over 1 <= k < n of { 2 * f(k) + 2^(n-k) - 1 }
   *
   * @param n number of disks
   * @return minimum number of moves as BigInt
   */
  def exercise5_towerOfHanoiFrameStewart(n: Int): BigInt = ???

  /**
   * Exercise 6: Flatten Nested Structure
   *
   * Flatten a deeply nested structure represented as Either[Int, List[Either[Int, List[...]]]]
   * into a flat list of integers. Since Scala's type system doesn't allow infinite nesting
   * of Either, use Any and pattern matching.
   *
   * @param nested a nested structure: each element is either an Int or a List[Any]
   * @return flat list of all integers in depth-first order
   */
  def exercise6_flattenNested(nested: List[Any]): List[Int] = ???

  /**
   * Exercise 7: Generate Parentheses
   *
   * Generate all valid (well-formed) combinations of n pairs of parentheses.
   * Use the recursive insight: at each step, you can add '(' if open < n,
   * and ')' if close < open.
   *
   * @param n number of pairs of parentheses
   * @return all valid combinations sorted lexicographically
   */
  def exercise7_generateParentheses(n: Int): List[String] = ???

  /**
   * Exercise 8: Power Set
   *
   * Generate the power set of a list of integers recursively using the
   * include/exclude pattern: for each element, branch into two paths —
   * one including the element, one excluding it.
   *
   * @param nums list of distinct integers
   * @return all subsets (power set), each subset as a List[Int]
   */
  def exercise8_powerSet(nums: List[Int]): List[List[Int]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Ackermann Function
    assert(exercise1_ackermann(0, 0) == BigInt(1), "Exercise 1 failed: A(0,0) should be 1")
    assert(exercise1_ackermann(1, 1) == BigInt(3), "Exercise 1 failed: A(1,1) should be 3")
    assert(exercise1_ackermann(2, 2) == BigInt(7), "Exercise 1 failed: A(2,2) should be 7")
    assert(exercise1_ackermann(3, 3) == BigInt(61), "Exercise 1 failed: A(3,3) should be 61")
    println(s"Exercise 1 - A(0,0)=${exercise1_ackermann(0, 0)}, A(1,1)=${exercise1_ackermann(1, 1)}, A(2,2)=${exercise1_ackermann(2, 2)}, A(3,3)=${exercise1_ackermann(3, 3)}")

    // Exercise 2: McCarthy 91
    assert(exercise2_mcCarthy91(99) == 91, "Exercise 2 failed: M(99) should be 91")
    assert(exercise2_mcCarthy91(100) == 91, "Exercise 2 failed: M(100) should be 91")
    assert(exercise2_mcCarthy91(101) == 91, "Exercise 2 failed: M(101) should be 91")
    assert(exercise2_mcCarthy91(111) == 101, "Exercise 2 failed: M(111) should be 101")
    // Verify M(n) = 91 for all n <= 100
    assert((0 to 100).forall(n => exercise2_mcCarthy91(n) == 91), "Exercise 2 failed: M(n) should be 91 for all n <= 100")
    println(s"Exercise 2 - M(99)=${exercise2_mcCarthy91(99)}, M(101)=${exercise2_mcCarthy91(101)}, M(111)=${exercise2_mcCarthy91(111)}")

    // Exercise 3: Stern-Brocot Tree
    val sb = exercise3_sternBrocot(3)
    // Depth 1: 1/1
    // Depth 2: 1/2, 2/1
    // Depth 3: 1/3, 2/3, 3/2, 3/1
    assert(sb.contains((1, 1)), "Exercise 3 failed: should contain 1/1")
    assert(sb.contains((1, 2)), "Exercise 3 failed: should contain 1/2")
    assert(sb.contains((2, 1)), "Exercise 3 failed: should contain 2/1")
    println(s"Exercise 3 - Stern-Brocot tree depth 3: $sb")

    // Exercise 4: Mutual Recursion
    assert(exercise4_mutualRecursion(0), "Exercise 4 failed: 0 should be even")
    assert(!exercise4_mutualRecursion(1), "Exercise 4 failed: 1 should be odd")
    assert(exercise4_mutualRecursion(42), "Exercise 4 failed: 42 should be even")
    assert(!exercise4_mutualRecursion(17), "Exercise 4 failed: 17 should be odd")
    println(s"Exercise 4 - isEven(0)=${exercise4_mutualRecursion(0)}, isEven(1)=${exercise4_mutualRecursion(1)}, isEven(42)=${exercise4_mutualRecursion(42)}")

    // Exercise 5: Frame-Stewart (4-peg Hanoi)
    assert(exercise5_towerOfHanoiFrameStewart(1) == BigInt(1), "Exercise 5 failed: f(1) should be 1")
    assert(exercise5_towerOfHanoiFrameStewart(2) == BigInt(3), "Exercise 5 failed: f(2) should be 3")
    assert(exercise5_towerOfHanoiFrameStewart(3) == BigInt(5), "Exercise 5 failed: f(3) should be 5")
    assert(exercise5_towerOfHanoiFrameStewart(4) == BigInt(9), "Exercise 5 failed: f(4) should be 9")
    println(s"Exercise 5 - 4-peg Hanoi: f(1)=${exercise5_towerOfHanoiFrameStewart(1)}, f(3)=${exercise5_towerOfHanoiFrameStewart(3)}, f(10)=${exercise5_towerOfHanoiFrameStewart(10)}")

    // Exercise 6: Flatten Nested
    val nested: List[Any] = List(1, List(2, 3), List(List(4, 5), 6), 7)
    val flat = exercise6_flattenNested(nested)
    assert(flat == List(1, 2, 3, 4, 5, 6, 7), s"Exercise 6 failed: expected List(1,2,3,4,5,6,7), got $flat")
    val nested2: List[Any] = List(List(List(1)), 2, List(3, List(4)))
    val flat2 = exercise6_flattenNested(nested2)
    assert(flat2 == List(1, 2, 3, 4), s"Exercise 6 failed: expected List(1,2,3,4), got $flat2")
    println(s"Exercise 6 - Flatten nested: $flat")

    // Exercise 7: Generate Parentheses
    val parens1 = exercise7_generateParentheses(1)
    assert(parens1 == List("()"), s"Exercise 7 failed: expected List(()), got $parens1")
    val parens2 = exercise7_generateParentheses(2)
    assert(parens2 == List("(())", "()()"), s"Exercise 7 failed: expected List((()), ()()), got $parens2")
    val parens3 = exercise7_generateParentheses(3)
    assert(parens3.size == 5, s"Exercise 7 failed: expected 5 combinations for n=3, got ${parens3.size}")
    println(s"Exercise 7 - Parentheses for n=3: $parens3")

    // Exercise 8: Power Set
    val ps = exercise8_powerSet(List(1, 2, 3))
    assert(ps.size == 8, s"Exercise 8 failed: expected 8 subsets, got ${ps.size}")
    assert(ps.contains(Nil), "Exercise 8 failed: should contain empty set")
    assert(ps.contains(List(1, 2, 3)), "Exercise 8 failed: should contain full set")
    assert(ps.contains(List(2)), "Exercise 8 failed: should contain List(2)")
    val ps0 = exercise8_powerSet(Nil)
    assert(ps0 == List(Nil), s"Exercise 8 failed: power set of empty should be List(Nil)")
    println(s"Exercise 8 - Power set of [1,2,3]: $ps")

    println("\nAll recursive logic exercises completed!")
  }
}
