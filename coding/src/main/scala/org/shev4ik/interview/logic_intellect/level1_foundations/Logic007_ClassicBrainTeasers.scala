package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Classic Brain Teasers=
 *
 * ==Theory: Brain Teasers in Technical Interviews==
 *
 * Brain teasers test your ability to break down constraints, identify patterns, and
 * reason about edge cases. While some companies have moved away from pure puzzles,
 * many of these problems teach fundamental algorithmic thinking.
 *
 * ==Tower of Hanoi==
 *
 * Move n disks from peg A to peg C using peg B as auxiliary:
 *
 *  - Only one disk can be moved at a time.
 *  - No disk may be placed on top of a smaller disk.
 *  - Minimum moves: '''2^n - 1''' (proved by induction).
 *
 * {{{
 * // Recursive solution:
 * // 1. Move top n-1 disks from source to auxiliary
 * // 2. Move the largest disk from source to target
 * // 3. Move n-1 disks from auxiliary to target
 * // T(n) = 2*T(n-1) + 1 => T(n) = 2^n - 1
 * }}}
 *
 * ==Josephus Problem==
 *
 * N people stand in a circle. Starting from person 0, every k-th person is eliminated.
 * The recurrence for the survivor position (0-indexed) is:
 *
 * {{{
 * J(1, k) = 0
 * J(n, k) = (J(n-1, k) + k) % n
 * }}}
 *
 * This is a classic example of reducing a problem to a smaller subproblem.
 *
 * ==Water Jug Problem==
 *
 * Given two jugs of capacity a and b, you can measure any multiple of gcd(a, b).
 * This follows from '''Bezout's identity''': there exist integers x, y such that
 * a*x + b*y = gcd(a, b). Therefore, target is measurable iff target % gcd(a, b) == 0
 * and target <= max(a, b).
 *
 * ==Egg Drop Problem==
 *
 * Given k eggs and n floors, find the minimum number of trials to determine the
 * critical floor. The key insight is:
 *
 *  - With 1 egg: must try linearly, so n trials needed.
 *  - With infinite eggs: binary search, so log2(n) trials.
 *  - General: dp(k, n) = 1 + min over x of max(dp(k-1, x-1), dp(k, n-x))
 *
 * An alternative formulation: with k eggs and t trials, the maximum number of
 * floors you can check is C(t,1) + C(t,2) + ... + C(t,k).
 *
 * ==River Crossing Puzzles==
 *
 * The wolf-goat-cabbage problem requires 7 crossings. Constraints:
 *  - Wolf and goat cannot be left alone (wolf eats goat).
 *  - Goat and cabbage cannot be left alone (goat eats cabbage).
 *  - Only one item can be carried per crossing.
 *
 * ==Interview Tips==
 *
 *  - '''Break constraints into rules:''' List what is and is not allowed explicitly.
 *  - '''Look for invariants:''' What quantity is preserved across operations?
 *  - '''Try small cases first:''' Solve for n=1, n=2, n=3, then generalize.
 *  - '''Recurrences are key:''' Many puzzles have elegant recursive formulations.
 *  - '''Think about information theory:''' How much information does each trial give you?
 *
 * ==Comparison: Brain Teaser Complexity==
 *
 * | Problem         | Optimal Solution | Key Insight                        |
 * |-----------------|------------------|------------------------------------|
 * | Tower of Hanoi  | 2^n - 1 moves    | Recursive decomposition            |
 * | Josephus        | O(n) recurrence  | Modular arithmetic                 |
 * | Water Jug       | GCD check        | Bezout's identity                  |
 * | Egg Drop        | O(k*n^2) DP      | Binary search with limited retries |
 * | River Crossing  | 7 crossings      | Constraint satisfaction / BFS      |
 */
object Logic007_ClassicBrainTeasers {

  // TODO: Return the minimum number of moves to solve Tower of Hanoi with n disks.
  // Formula: 2^n - 1
  // Example: n = 3 => 7, n = 1 => 1, n = 10 => 1023
  def exercise1_towerOfHanoi(n: Int): Long = ???

  // TODO: Generate the list of moves (from_peg, to_peg) to solve Tower of Hanoi
  // with n disks. Pegs are numbered 1, 2, 3. Move all disks from peg 1 to peg 3.
  // Example: n = 2 => List((1,2), (1,3), (2,3))
  def exercise2_hanoiMoves(n: Int): List[(Int, Int)] = ???

  // TODO: Solve the Josephus problem. N people in a circle (0-indexed), every k-th
  // person is eliminated. Return the position of the survivor.
  // Recurrence: J(1,k) = 0, J(n,k) = (J(n-1,k) + k) % n
  // Example: n = 5, k = 2 => 2, n = 7, k = 3 => 3
  def exercise3_josephus(n: Int, k: Int): Int = ???

  // TODO: Determine if you can measure exactly 'target' liters using two jugs of
  // capacity a and b. Possible iff target % gcd(a, b) == 0 and target <= max(a, b).
  // Example: a = 3, b = 5, target = 4 => true
  //          a = 2, b = 6, target = 5 => false
  def exercise4_waterJug(a: Int, b: Int, target: Int): Boolean = ???

  // TODO: Compute the minimum number of trials needed with k eggs and n floors
  // to find the critical floor in the worst case.
  // Use DP: dp(k, n) = 1 + min over x in [1..n] of max(dp(k-1, x-1), dp(k, n-x))
  // Base cases: dp(1, n) = n, dp(k, 0) = 0, dp(k, 1) = 1
  // Example: k = 2, n = 10 => 4, k = 1, n = 5 => 5
  def exercise5_eggDrop(k: Int, n: Int): Int = ???

  // TODO: Return the minimum number of crossings for the wolf-goat-cabbage river
  // crossing puzzle. The farmer must transport all three across. Only one item fits
  // in the boat at a time. Wolf+goat and goat+cabbage cannot be left unattended.
  // The answer is always 7.
  def exercise6_riverCrossing: Int = ???

  // TODO: Two ropes each burn completely in 60 minutes, but they burn non-uniformly
  // (so half the rope does NOT necessarily burn in 30 minutes).
  // Describe a strategy to measure exactly 45 minutes.
  // Return the strategy as a String description.
  def exercise7_ropeBurning: String = ???

  // TODO: Three switches in one room, three light bulbs in another room. You can
  // flip switches as much as you want but can only visit the bulb room once.
  // Strategy: turn switch 1 on for a while (bulb gets hot), turn it off, turn
  // switch 2 on, then visit. Hot-off = switch 1, on = switch 2, cold-off = switch 3.
  // Return the minimum number of visits needed: 1.
  def exercise8_lightSwitches: Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: towerOfHanoi
    assert(exercise1_towerOfHanoi(1) == 1L)
    assert(exercise1_towerOfHanoi(3) == 7L)
    assert(exercise1_towerOfHanoi(10) == 1023L)
    assert(exercise1_towerOfHanoi(20) == 1048575L)
    println("Exercise 1 passed: exercise1_towerOfHanoi")

    // Exercise 2: hanoiMoves
    assert(exercise2_hanoiMoves(1) == List((1, 3)))
    assert(exercise2_hanoiMoves(2) == List((1, 2), (1, 3), (2, 3)))
    assert(exercise2_hanoiMoves(3).length == 7)
    println("Exercise 2 passed: exercise2_hanoiMoves")

    // Exercise 3: josephus
    assert(exercise3_josephus(1, 3) == 0)
    assert(exercise3_josephus(5, 2) == 2)
    assert(exercise3_josephus(7, 3) == 3)
    assert(exercise3_josephus(6, 2) == 4)
    println("Exercise 3 passed: exercise3_josephus")

    // Exercise 4: waterJug
    assert(exercise4_waterJug(3, 5, 4) == true)
    assert(exercise4_waterJug(2, 6, 5) == false)
    assert(exercise4_waterJug(3, 5, 1) == true)
    assert(exercise4_waterJug(4, 6, 3) == false)
    println("Exercise 4 passed: exercise4_waterJug")

    // Exercise 5: eggDrop
    assert(exercise5_eggDrop(1, 5) == 5)
    assert(exercise5_eggDrop(2, 10) == 4)
    assert(exercise5_eggDrop(2, 6) == 3)
    assert(exercise5_eggDrop(3, 14) == 4)
    println("Exercise 5 passed: exercise5_eggDrop")

    // Exercise 6: riverCrossing
    assert(exercise6_riverCrossing == 7)
    println("Exercise 6 passed: exercise6_riverCrossing")

    // Exercise 7: ropeBurning
    val strategy = exercise7_ropeBurning
    assert(strategy.nonEmpty)
    assert(strategy.toLowerCase.contains("45") || strategy.toLowerCase.contains("forty"))
    println("Exercise 7 passed: exercise7_ropeBurning")
    println(s"  Strategy: $strategy")

    // Exercise 8: lightSwitches
    assert(exercise8_lightSwitches == 1)
    println("Exercise 8 passed: exercise8_lightSwitches")

    println("All Logic007_ClassicBrainTeasers exercises passed!")
  }
}
