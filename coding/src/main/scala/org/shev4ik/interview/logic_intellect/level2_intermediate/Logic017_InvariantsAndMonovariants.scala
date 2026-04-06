package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Invariants and Monovariants=
 *
 * ==Theory: Invariants==
 *
 * An '''invariant''' is a property that remains unchanged throughout a process — across loop
 * iterations, game moves, or algorithm steps. Invariants are the most powerful tool for:
 *  - '''Proving correctness:''' Show the invariant holds initially and is preserved by each step.
 *  - '''Proving impossibility:''' Show that the target state violates the invariant.
 *
 * '''Formal definition:''' Given a state space S and transition function T: S → S, a predicate
 * P: S → Boolean is an invariant if P(s) implies P(T(s)) for all s in S.
 *
 * ==Theory: Monovariants==
 *
 * A '''monovariant''' (or potential function) is a quantity that changes monotonically — it
 * either always increases or always decreases with each operation. Monovariants prove
 * '''termination''': if a monovariant is bounded and strictly monotone, the process must
 * eventually stop.
 *
 * {{{
 *   If Φ: S → ℤ is non-negative and Φ(T(s)) < Φ(s) for all s, then
 *   any sequence of transitions must terminate in at most Φ(s₀) steps.
 * }}}
 *
 * ==Classic Example: The 15-Puzzle==
 *
 * The 15-puzzle has 16!/2 solvable configurations out of 16! total. The invariant is the
 * '''parity of inversions plus blank row''': a configuration is solvable if and only if
 * (number_of_inversions + row_of_blank_from_bottom) is even. Each legal move changes the
 * inversion count by an odd number and changes the blank row by 1, preserving parity.
 *
 * ==Loop Invariants in Programming==
 *
 * A '''loop invariant''' holds true before and after each iteration. For binary search:
 * "target is in arr[lo..hi] if it exists in the array." This must hold:
 *  - '''Initialization:''' lo=0, hi=n-1 covers entire array.
 *  - '''Maintenance:''' Each step narrows [lo..hi] while preserving the property.
 *  - '''Termination:''' When lo > hi, the target is not in the array.
 *
 * ==Comparison: Invariants vs Monovariants==
 *
 * | Property      | Invariant                        | Monovariant                     |
 * |---------------|----------------------------------|---------------------------------|
 * | Changes?      | No — stays the same              | Yes — monotonically             |
 * | Proves what?  | Correctness or impossibility     | Termination                     |
 * | Example       | Parity, total sum, coloring      | Max element, total length       |
 * | Bound needed? | No                               | Yes — needs a floor or ceiling  |
 *
 * ==Interview Tips==
 *
 *  - '''Finding invariants:''' Look at what quantities the operations preserve. Parity,
 *    sums, products modulo k, coloring arguments are common.
 *  - '''Impossibility proofs:''' If the initial state has invariant value X and the target
 *    has value Y ≠ X, the target is unreachable. This is elegant and decisive.
 *  - '''Loop invariants:''' For any algorithm with a loop, stating the invariant shows you
 *    truly understand ''why'' it works, not just ''how''. Interviewers love this.
 *  - '''Chocolate bar problem:''' Breaking an m×n bar into m*n unit squares always requires
 *    exactly m*n - 1 breaks. The invariant is: #pieces increases by exactly 1 per break.
 *  - '''Common monovariants:''' Sum of squares, maximum element, number of distinct elements,
 *    length of sequence, potential energy function.
 *  - '''Termination arguments:''' When asked "does this process always terminate?", look for
 *    a bounded monovariant.
 */
object Logic017_InvariantsAndMonovariants {

  /**
   * Exercise 1: Loop Invariant Verification
   *
   * Implement binary search that tracks the loop invariant "target is in arr[lo..hi]
   * (if it exists in arr)" at each iteration. Return a list of Booleans indicating
   * whether the invariant holds at the start of each iteration.
   *
   * @param arr    sorted array of integers
   * @param target value to search for
   * @return list of Boolean values, one per iteration, each true if invariant holds
   */
  def exercise1_loopInvariant(arr: Array[Int], target: Int): List[Boolean] = ???

  /**
   * Exercise 2: 15-Puzzle Solvability
   *
   * Determine if a given 15-puzzle configuration is solvable. The puzzle is represented
   * as a flat array of 16 elements (0 = blank). A configuration is solvable iff
   * (inversions + blankRowFromBottom) is even, where an inversion is a pair (i,j) with
   * i < j and arr(i) > arr(j) > 0.
   *
   * @param board array of 16 integers (0-15) representing the puzzle state
   * @return true if the configuration is solvable
   */
  def exercise2_fifteenPuzzle(board: Array[Int]): Boolean = ???

  /**
   * Exercise 3: Tile Coloring (Mutilated Chessboard)
   *
   * An 8×8 chessboard has two diagonally opposite corners removed (both are the same
   * color). Count the number of black and white squares remaining. Since they are unequal,
   * domino tiling (each domino covers one black and one white) is impossible.
   *
   * @param boardSize size of the square board (default 8)
   * @return (blackCount, whiteCount) after removing two opposite corners
   */
  def exercise3_tileColoring(boardSize: Int): (Int, Int) = ???

  /**
   * Exercise 4: Chocolate Breaking
   *
   * An m×n chocolate bar must be broken into m*n unit squares. Each break splits one
   * piece into two along a straight line. Prove (by invariant: #pieces increases by 1
   * per break) that exactly m*n - 1 breaks are always needed, regardless of strategy.
   *
   * @param m number of rows
   * @param n number of columns
   * @return minimum (and maximum) number of breaks needed = m*n - 1
   */
  def exercise4_chocolateBreaking(m: Int, n: Int): Int = ???

  /**
   * Exercise 5: Coin Flipping Parity
   *
   * Start with n coins all heads up. Each move flips exactly k coins. Determine if
   * it is possible to reach a state where all coins are tails. This depends on parity:
   * the total number of heads changes by k - 2*j for some 0 <= j <= k (where j coins
   * go from heads to tails). All coins tails is reachable iff n is reachable from
   * start by subtracting multiples of gcd-related steps. Simplified: possible iff
   * k divides n and (k is even or n is even or n == 0).
   *
   * For the simplified version: return true if n coins can all be flipped to tails
   * when flipping exactly k coins per move.
   *
   * @param n total number of coins (initially all heads)
   * @param k number of coins flipped per move
   * @return true if all-tails state is reachable
   */
  def exercise5_coinFlipping(n: Int, k: Int): Boolean = ???

  /**
   * Exercise 6: Water Pouring Invariant
   *
   * Three glasses contain a, b, c liters of water respectively. Water can be poured
   * between glasses (no spillage). Verify that the total a + b + c is invariant
   * across a sequence of pouring operations. Each operation is (from, to, amount).
   *
   * @param initial   initial amounts (a, b, c)
   * @param operations list of (fromGlass, toGlass, amount) — 0-indexed glasses
   * @return true if total water is preserved after all operations
   */
  def exercise6_waterPouring(initial: (Int, Int, Int),
                             operations: List[(Int, Int, Int)]): Boolean = ???

  /**
   * Exercise 7: Monovariant — Splitting Numbers
   *
   * Start with a list of positive integers. Operation: remove any number x > 1 and
   * replace it with two positive integers a, b such that a + b = x. This strictly
   * increases the list length while the sum stays constant. The process terminates
   * when all elements are 1. Compute the total number of operations needed (= sum - length).
   *
   * @param numbers initial list of positive integers
   * @return total number of split operations until all elements are 1
   */
  def exercise7_monovariant(numbers: List[Int]): Int = ???

  /**
   * Exercise 8: Potential Function Tracking
   *
   * Define potential Φ = sum of absolute values of a list of integers. Given a sequence
   * of operations where each operation replaces element at index i with a new value,
   * track Φ after each operation. Return the list of Φ values.
   *
   * @param initial    initial list of integers
   * @param operations list of (index, newValue) replacements
   * @return list of Φ (sum of absolute values) after each operation
   */
  def exercise8_potentialFunction(initial: List[Int],
                                  operations: List[(Int, Int)]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Loop Invariant
    val arr1 = Array(1, 3, 5, 7, 9, 11, 13, 15)
    val invariants = exercise1_loopInvariant(arr1, 7)
    assert(invariants.forall(_ == true), s"Exercise 1 failed: all invariants should hold, got $invariants")
    println(s"Exercise 1 - Loop invariant checks (searching for 7): $invariants")

    // Also test when target is absent
    val invariants2 = exercise1_loopInvariant(arr1, 6)
    assert(invariants2.forall(_ == true), s"Exercise 1 failed: invariants should hold even when target absent")
    println(s"Exercise 1 - Loop invariant checks (searching for 6): $invariants2")

    // Exercise 2: 15-Puzzle
    // Standard solved position is solvable
    val solved = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0)
    assert(exercise2_fifteenPuzzle(solved), "Exercise 2 failed: solved state should be solvable")
    // Swap 14 and 15 — unsolvable
    val unsolvable = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0)
    assert(!exercise2_fifteenPuzzle(unsolvable), "Exercise 2 failed: swapped 14/15 should be unsolvable")
    println(s"Exercise 2 - Solved is solvable: true, swapped 14/15: false")

    // Exercise 3: Tile Coloring
    val (black, white) = exercise3_tileColoring(8)
    assert(black != white, "Exercise 3 failed: black and white counts should differ")
    assert(black + white == 62, s"Exercise 3 failed: total should be 62, got ${black + white}")
    println(s"Exercise 3 - After removing corners: black=$black, white=$white")

    // Exercise 4: Chocolate Breaking
    val breaks = exercise4_chocolateBreaking(3, 4)
    assert(breaks == 11, s"Exercise 4 failed: expected 11 breaks, got $breaks")
    val breaks2 = exercise4_chocolateBreaking(1, 1)
    assert(breaks2 == 0, s"Exercise 4 failed: expected 0 breaks for 1x1, got $breaks2")
    println(s"Exercise 4 - Breaks for 3x4 chocolate: $breaks")

    // Exercise 5: Coin Flipping
    // 4 coins, flip 2 at a time: possible (flip pairs systematically)
    assert(exercise5_coinFlipping(4, 2), "Exercise 5 failed: 4 coins, k=2 should be possible")
    // 3 coins, flip 2 at a time: impossible (parity argument)
    assert(!exercise5_coinFlipping(3, 2), "Exercise 5 failed: 3 coins, k=2 should be impossible")
    println(s"Exercise 5 - n=4,k=2: ${exercise5_coinFlipping(4, 2)}, n=3,k=2: ${exercise5_coinFlipping(3, 2)}")

    // Exercise 6: Water Pouring
    val preserved = exercise6_waterPouring((5, 3, 0), List((0, 1, 2), (1, 2, 1)))
    assert(preserved, "Exercise 6 failed: total water should be preserved")
    println(s"Exercise 6 - Water invariant preserved: $preserved")

    // Exercise 7: Monovariant
    val steps = exercise7_monovariant(List(3, 5, 2))
    // sum=10, length=3, so 10-3=7 operations needed
    assert(steps == 7, s"Exercise 7 failed: expected 7 operations, got $steps")
    val steps2 = exercise7_monovariant(List(1, 1, 1))
    assert(steps2 == 0, s"Exercise 7 failed: expected 0 operations for all-ones, got $steps2")
    println(s"Exercise 7 - Split operations for [3,5,2]: $steps")

    // Exercise 8: Potential Function
    val potentials = exercise8_potentialFunction(List(3, -2, 5), List((1, 1), (0, -1), (2, 0)))
    // Initial Φ = |3| + |-2| + |5| = 10
    // After (1, 1): |3| + |1| + |5| = 9
    // After (0, -1): |-1| + |1| + |5| = 7
    // After (2, 0): |-1| + |1| + |0| = 2
    assert(potentials == List(9, 7, 2), s"Exercise 8 failed: expected List(9, 7, 2), got $potentials")
    println(s"Exercise 8 - Potential values: $potentials")

    println("\nAll invariant and monovariant exercises completed!")
  }
}
