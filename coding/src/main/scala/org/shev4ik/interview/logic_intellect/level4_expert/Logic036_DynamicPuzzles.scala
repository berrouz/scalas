package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Dynamic Puzzles: State Transitions and Search (Динамічні головоломки)=
 *
 * ==Theory: Puzzles as State Space Search Problems==
 *
 * Many classic puzzles can be modeled as state transition systems. The puzzle's
 * configuration is a state, each legal move is a transition, and solving the
 * puzzle means finding a path from the initial state to a goal state. This
 * naturally leads to BFS (shortest path in unweighted graphs) or DFS
 * (existence of any path) over the state space.
 *
 * '''Lights Out Puzzle:''' An n×n grid of lights, each on or off. Pressing a
 * light toggles it and its orthogonal neighbors. The goal is to turn all lights
 * off. Solvability can be determined via linear algebra over GF(2) (the field
 * with elements 0 and 1). The puzzle is solvable iff the initial state is in
 * the column space of the toggle matrix.
 *
 * '''Pancake Sorting:''' Sort a stack of pancakes (array) using only prefix
 * reversals: pick a position k and reverse elements 0..k. The pancake number
 * P(n) is the maximum number of flips needed for any permutation of size n.
 * Known bounds: (15/14)n ≤ P(n) ≤ (5n+5)/3. This connects to sorting networks
 * and the "diameter of the pancake graph" (a Cayley graph).
 *
 * '''Sliding Puzzle (8-puzzle / 15-puzzle):''' A grid with numbered tiles and
 * one blank. Tiles slide into the blank. Solvability: count inversions and
 * blank row parity. For the 8-puzzle (3×3), it is solvable iff inversion count
 * is even. Optimal solution uses A* with Manhattan distance heuristic.
 *
 * '''Gray Code:''' A sequence of n-bit binary numbers where consecutive numbers
 * differ in exactly one bit. Constructed recursively: reflect the (n-1)-bit
 * code and prefix with 1. Formula: G(i) = i XOR (i >> 1).
 *
 * '''Tower of Hanoi:''' Classic recursive puzzle. Minimum moves = 2^n - 1 for
 * n disks. Given an arbitrary state, the minimum moves to reach the goal can
 * be computed by analyzing which disks are on the correct peg.
 *
 * '''Water Pouring (Die Hard):''' Given jugs of capacity a and b, reach a
 * target volume. Solvable iff target is a multiple of gcd(a, b) and target ≤
 * max(a, b). BFS over states (amount in jug A, amount in jug B) finds
 * minimum steps.
 *
 * ==Comparison: Puzzle Search Strategies==
 *
 * | Puzzle           | State Space     | Best Algorithm         | Complexity           |
 * |------------------|-----------------|------------------------|----------------------|
 * | Lights Out       | 2^(n²)          | Gaussian elimination   | O(n⁶) over GF(2)    |
 * | Pancake Sort     | n!              | BFS / greedy           | O(n²) greedy         |
 * | 8-Puzzle         | 9!/2            | A* + Manhattan dist    | Varies, often fast   |
 * | Gray Code        | 2^n             | Direct formula         | O(2^n) to enumerate  |
 * | Tower of Hanoi   | 3^n             | Recursive / formula    | O(2^n) moves         |
 * | Water Pouring    | O(a*b)          | BFS                    | O(a*b) states        |
 *
 * ==Interview Tips==
 *
 *  - '''State space search''' is the unifying idea. Identify state, transitions, and goal.
 *  - For '''Lights Out''', mention GF(2) linear algebra — interviewers love algebraic insight.
 *  - '''Pancake sorting''' is a Google interview classic (the "burnt pancake" variant too).
 *  - For '''sliding puzzles''', always check solvability via inversions before searching.
 *  - '''Gray code''' formula `i ^ (i >> 1)` is a must-know one-liner.
 *  - '''BFS guarantees shortest path''' in unweighted state graphs; DFS does not.
 *  - For coin change, recognize it as a classic DP problem on state transitions.
 *
 * ==Complexity Note==
 *
 * BFS/DFS on state space is O(|states| + |transitions|). For many puzzles the
 * state space is exponential, so heuristic search (A*, IDA*) or algebraic
 * methods are essential. Coin change DP is O(n * |denominations|).
 */
object Logic036_DynamicPuzzles {

  /**
   * Exercise 1: Lights Out — Solvability Check
   *
   * Given an n×n Lights Out board represented as a flattened Array[Int] of 0s
   * and 1s, determine if the puzzle is solvable. A simplified approach: for
   * small n, use Gaussian elimination over GF(2) on the toggle matrix.
   *
   * @param board flattened board of size n*n with 0 (off) and 1 (on)
   * @param n     board dimension
   * @return true if the board can be solved (all lights turned off)
   */
  def exercise1_lightsOut(board: Array[Int], n: Int): Boolean = ???

  /**
   * Exercise 2: Pancake Sort — Count Flips
   *
   * Given an array of distinct integers, sort it using pancake sorting (only
   * prefix reversals allowed). Return the number of flips needed.
   * Use the standard greedy algorithm: repeatedly bring the max unsorted
   * element to the front, then flip it into position.
   *
   * @param arr array of distinct integers to sort
   * @return the number of prefix reversals needed
   */
  def exercise2_pancakeSort(arr: Array[Int]): Int = ???

  /**
   * Exercise 3: Pancake Sort — Flip Sequence
   *
   * Same as exercise 2, but return the sequence of flip positions (1-indexed
   * prefix lengths). Each flip reverses arr(0..k-1) for position k.
   *
   * @param arr array of distinct integers to sort
   * @return list of flip positions (prefix lengths) in order
   */
  def exercise3_pancakeFlips(arr: Array[Int]): List[Int] = ???

  /**
   * Exercise 4: Sliding Puzzle — Solvability Check
   *
   * Given a 3×3 sliding puzzle (8-puzzle) as a flattened array of 0-8 where
   * 0 is the blank, determine if it is solvable. The puzzle is solvable iff
   * the number of inversions (pairs (i,j) where i < j but arr(i) > arr(j),
   * ignoring 0) is even.
   *
   * @param board flattened 3×3 board with values 0 to 8
   * @return true if the puzzle is solvable
   */
  def exercise4_slidingPuzzle(board: Array[Int]): Boolean = ???

  /**
   * Exercise 5: Gray Code Generation
   *
   * Generate the n-bit Gray code sequence. The sequence has 2^n elements,
   * and consecutive elements differ in exactly one bit. Use the formula:
   * G(i) = i XOR (i >> 1).
   *
   * @param n number of bits (n >= 1)
   * @return list of integers in Gray code order
   */
  def exercise5_grayCode(n: Int): List[Int] = ???

  /**
   * Exercise 6: Tower of Hanoi — Moves from Arbitrary State
   *
   * Given the current state of Tower of Hanoi as an array where state(i) is
   * the peg (0, 1, or 2) of disk i (0 = smallest disk), and the goal is all
   * disks on peg 2, compute the minimum number of moves to reach the goal.
   *
   * Key insight: the largest misplaced disk determines the strategy. If disk
   * k is not on peg 2, we need 2^k moves for it plus moves for smaller disks.
   *
   * @param state array where state(i) = peg of disk i (0-indexed, 0 = smallest)
   * @return minimum number of moves to solve
   */
  def exercise6_towerOfHanoiState(state: Array[Int]): Int = ???

  /**
   * Exercise 7: Water Pouring Puzzle — BFS
   *
   * Given two jugs of capacity a and b (both initially empty), find the
   * minimum number of steps to measure exactly target units of water.
   * Allowed operations: fill a jug, empty a jug, pour from one to another.
   * Use BFS over (amountInA, amountInB) states.
   *
   * @param a      capacity of jug A
   * @param b      capacity of jug B
   * @param target desired amount in either jug
   * @return minimum number of steps, or -1 if impossible
   */
  def exercise7_waterPouring(a: Int, b: Int, target: Int): Int = ???

  /**
   * Exercise 8: Coin Change — Minimum Transitions
   *
   * Given coin denominations and a target amount, find the minimum number
   * of coins needed to make the target (classic DP). Each coin usage is a
   * state transition from amount k to amount k - coin.
   *
   * @param coins  available denominations
   * @param amount target amount
   * @return minimum number of coins, or -1 if impossible
   */
  def exercise8_coinChange(coins: Array[Int], amount: Int): Int = ???

  def main(args: Array[String]): Unit = {

    // Exercise 1: Lights Out
    // A fully-off board is trivially solvable
    val offBoard = Array(0, 0, 0, 0)
    assert(exercise1_lightsOut(offBoard, 2) == true, "All-off 2×2 board should be solvable (already solved)")
    println(s"Exercise 1 - Lights Out (2×2 all off): ${exercise1_lightsOut(offBoard, 2)}")

    // Exercise 2: Pancake Sort — Count Flips
    val arr2 = Array(3, 1, 2)
    val flips2 = exercise2_pancakeSort(arr2.clone())
    assert(flips2 >= 0, "Flip count should be non-negative")
    println(s"Exercise 2 - Pancake sort flips for [3,1,2]: $flips2")

    // Exercise 3: Pancake Sort — Flip Sequence
    val arr3 = Array(3, 1, 2)
    val flipSeq = exercise3_pancakeFlips(arr3.clone())
    assert(flipSeq.nonEmpty || arr3.sorted.sameElements(arr3), "Flip sequence should be non-empty for unsorted array")
    println(s"Exercise 3 - Pancake flip sequence for [3,1,2]: $flipSeq")

    // Exercise 4: Sliding Puzzle — Solvability
    val solvableBoard = Array(1, 2, 3, 4, 5, 6, 7, 8, 0) // already solved
    assert(exercise4_slidingPuzzle(solvableBoard) == true, "Goal state should be solvable")
    val unsolvableBoard = Array(1, 2, 3, 4, 5, 6, 8, 7, 0) // one swap = odd inversions
    assert(exercise4_slidingPuzzle(unsolvableBoard) == false, "Single swap from goal should be unsolvable")
    println(s"Exercise 4 - Sliding puzzle solvable (goal): ${exercise4_slidingPuzzle(solvableBoard)}")
    println(s"Exercise 4 - Sliding puzzle solvable (swapped): ${exercise4_slidingPuzzle(unsolvableBoard)}")

    // Exercise 5: Gray Code
    val gray2 = exercise5_grayCode(2)
    assert(gray2 == List(0, 1, 3, 2), s"2-bit Gray code should be [0,1,3,2], got $gray2")
    println(s"Exercise 5 - 2-bit Gray code: $gray2")

    val gray3 = exercise5_grayCode(3)
    assert(gray3.size == 8, "3-bit Gray code should have 8 elements")
    println(s"Exercise 5 - 3-bit Gray code: $gray3")

    // Exercise 6: Tower of Hanoi — Arbitrary State
    val solvedState = Array(2, 2, 2) // all 3 disks on peg 2
    assert(exercise6_towerOfHanoiState(solvedState) == 0, "Already solved should need 0 moves")
    val startState = Array(0, 0, 0) // all 3 disks on peg 0
    assert(exercise6_towerOfHanoiState(startState) == 7, "Standard 3-disk Hanoi needs 7 moves")
    println(s"Exercise 6 - Hanoi moves (all on peg 0, 3 disks): ${exercise6_towerOfHanoiState(startState)}")

    // Exercise 7: Water Pouring
    val waterSteps = exercise7_waterPouring(3, 5, 4)
    assert(waterSteps >= 0, "Should find a solution for (3,5,4)")
    println(s"Exercise 7 - Water pouring (3,5) target 4: $waterSteps steps")

    val waterImpossible = exercise7_waterPouring(2, 4, 3)
    assert(waterImpossible == -1, "Cannot measure 3 with jugs 2 and 4")
    println(s"Exercise 7 - Water pouring (2,4) target 3: $waterImpossible")

    // Exercise 8: Coin Change
    val coins8 = Array(1, 5, 10, 25)
    assert(exercise8_coinChange(coins8, 30) == 2, "30 cents = 25 + 5 = 2 coins")
    assert(exercise8_coinChange(Array(2), 3) == -1, "Cannot make 3 from only 2s")
    println(s"Exercise 8 - Coin change [1,5,10,25] for 30: ${exercise8_coinChange(coins8, 30)}")
    println(s"Exercise 8 - Coin change [2] for 3: ${exercise8_coinChange(Array(2), 3)}")

    println("\nAll Logic036_DynamicPuzzles exercises passed!")
  }
}
