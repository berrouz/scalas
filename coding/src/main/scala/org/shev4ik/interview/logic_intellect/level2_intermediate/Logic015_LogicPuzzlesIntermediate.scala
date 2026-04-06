package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Intermediate Logic Puzzles (Логічні головоломки середнього рівня)=
 *
 * ==Theory: Classic Logic Puzzles and Common Knowledge==
 *
 * Logic puzzles in interviews test structured reasoning, common knowledge vs mutual
 * knowledge, backward induction, and ability to model constraints.
 *
 * '''Cheryl's Birthday Puzzle:'''
 * A famous elimination puzzle where two people receive partial information (month
 * and day respectively) and through logical deduction of what the other knows,
 * determine the answer. The key insight is that stating "I knew you didn't know"
 * provides information by eliminating months that contain unique days.
 *
 * '''Pirates Gold Division (Pirate Game):'''
 * Uses '''backward induction''': solve from the last pirate's perspective backward.
 * Each pirate proposes a division; if at least half accept, it passes. The optimal
 * strategy for pirate 1 (with 5 pirates, 100 gold) is to keep 98, give 1 coin each
 * to pirates 3 and 5 (who would get 0 if pirate 2 proposes). Key insight: a pirate
 * votes yes if the offer is strictly better than what they'd get if the proposal fails.
 *
 * '''Blue Eyes Puzzle:'''
 * N people with blue eyes, a public announcement "I see someone with blue eyes,"
 * and a rule: leave if you know your own eye color. With '''common knowledge''',
 * all N leave on day N. The announcement creates a shared logical chain:
 * {{{
 *   N=1: leave day 1. N=2: each waits, sees other didn't leave -> both leave day 2.
 *   By induction, N people leave on day N.
 * }}}
 *
 * '''Sum-Product Puzzle:'''
 * One person knows the sum S of two numbers, another knows the product P.
 * Through a series of statements ("I knew you didn't know," "Now I know,"
 * "Now I know too"), the numbers can be deduced. Tests constraint propagation.
 *
 * '''Prisoners and Hats:'''
 * N prisoners in a line, each sees all hats in front. The last prisoner guesses
 * first. Strategy: last prisoner announces XOR (parity) of all hats seen.
 * Each subsequent prisoner can deduce their own hat. Guarantees N-1 survivors.
 *
 * '''Weighing Puzzle:'''
 * Classic balance scale problem. With k weighings, you can distinguish among
 * 3^k outcomes (left-heavy, balanced, right-heavy per weighing). To find the
 * heavy ball among n: need ceil(log3(n)) weighings.
 *
 * '''Hilbert's Hotel:'''
 * An infinite hotel where every room is occupied can still accommodate new guests
 * by shifting: move guest in room k to room k+n, freeing rooms 1..n.
 *
 * ==Comparison: Puzzle-Solving Techniques==
 *
 * | Technique             | Applicable Puzzles                    | Key Idea              |
 * |-----------------------|---------------------------------------|-----------------------|
 * | Backward Induction    | Pirates, game theory                  | Solve from the end    |
 * | Common Knowledge      | Blue eyes, muddy children             | Public announcements  |
 * | Constraint Elimination| Cheryl's birthday, sum-product        | Narrow possibilities  |
 * | Parity/XOR            | Prisoner hats, coin puzzles           | Information encoding  |
 * | Information Theory    | Weighing puzzles                      | log3(n) bounds        |
 *
 * ==Interview Tips==
 *
 *  - '''State your assumptions clearly.''' Many puzzles have variants; clarify rules.
 *  - '''Start with small cases.''' For pirates: solve for 2 pirates first, then 3, etc.
 *  - '''Distinguish mutual from common knowledge.''' "Everyone knows X" differs from
 *    "Everyone knows that everyone knows X."
 *  - '''Use backward induction''' for sequential decision problems.
 *  - '''For weighing puzzles,''' think in terms of information: each weighing gives
 *    one of 3 outcomes = log2(3) ≈ 1.585 bits of information.
 *  - '''The liar's paradox''' is a classic example of undecidability — recognizing
 *    undecidable statements shows mathematical maturity.
 *  - For open-ended puzzles, explain your reasoning process, not just the answer.
 *
 * ==Complexity Note==
 *
 * Most logic puzzles don't have "algorithmic complexity" in the traditional sense.
 * However, the constraint-elimination approach in Cheryl's birthday is analogous
 * to constraint propagation in CSP solvers. The pirates problem is O(n^2) if
 * generalized to n pirates.
 */
object Logic015_LogicPuzzlesIntermediate {

  /**
   * Exercise 1: Cheryl's Birthday
   *
   * Classic puzzle: Cheryl gives Albert the month and Bernard the day from
   * a list of candidate dates. Through logical elimination:
   *   - Albert: "I don't know, but I know Bernard doesn't know either."
   *   - Bernard: "At first I didn't know, but now I do."
   *   - Albert: "Now I know too."
   *
   * Given the standard candidate dates, determine Cheryl's birthday.
   *
   * The standard candidates are:
   *   May 15, May 16, May 19,
   *   June 17, June 18,
   *   July 14, July 16,
   *   August 14, August 15, August 17
   *
   * @return the birthday as a String, e.g., "July 16"
   */
  def exercise1_cherylsBirthday(): String = ???

  /**
   * Exercise 2: Pirates Gold Division
   *
   * 5 pirates divide 100 gold coins. Pirate 1 (most senior) proposes first.
   * A proposal passes if at least half vote yes (proposer can vote).
   * Pirates prefer: (1) survival, (2) more gold, (3) seeing others thrown overboard.
   * Using backward induction, determine pirate 1's optimal proposal.
   *
   * @return List of 5 integers representing gold for pirates 1-5
   */
  def exercise2_piratesGold(): List[Int] = ???

  /**
   * Exercise 3: Blue Eyes Puzzle
   *
   * N people on an island all have blue eyes. A visitor announces publicly
   * "I can see someone with blue eyes." Anyone who can deduce their own eye
   * color must leave that midnight. On which day do they all leave?
   *
   * @param n number of people with blue eyes
   * @return the day number on which all blue-eyed people leave
   */
  def exercise3_blueEyes(n: Int): Int = ???

  /**
   * Exercise 4: Sum-Product Puzzle
   *
   * Two numbers x, y with 1 < x < y and x + y <= 100.
   * S (who knows x+y) says: "I knew you didn't know."
   * P (who knows x*y) says: "Now I know."
   * S says: "Now I know too."
   * Find the pair (x, y).
   *
   * @return (x, y) — the unique pair satisfying all constraints
   */
  def exercise4_sumProduct(): (Int, Int) = ???

  /**
   * Exercise 5: Liar's Paradox
   *
   * The statement "This statement is false" is self-referential.
   * If true, then it must be false. If false, then it must be true.
   * This makes it undecidable in classical logic.
   *
   * @return "undecidable"
   */
  def exercise5_liarsParadox(): String = ???

  /**
   * Exercise 6: Prisoner Hats
   *
   * N prisoners stand in a line, each wearing a black or white hat.
   * Each prisoner can see all hats in front of them but not their own.
   * Starting from the back, each must guess their hat color.
   * Optimal strategy: last prisoner announces XOR parity of all hats seen.
   * This guarantees at least N-1 correct guesses.
   *
   * @param n number of prisoners
   * @return number of prisoners guaranteed to survive
   */
  def exercise6_prisonerHats(n: Int): Int = ???

  /**
   * Exercise 7: Weighing Puzzle
   *
   * Given n balls, one heavier than the rest, and a balance scale,
   * compute the minimum number of weighings needed to identify the heavy ball.
   * Each weighing has 3 outcomes, so we need ceil(log3(n)) weighings.
   *
   * @param n number of balls
   * @return minimum number of weighings
   */
  def exercise7_weighingPuzzle(n: Int): Int = ???

  /**
   * Exercise 8: Hilbert's Hotel
   *
   * An infinite hotel with all rooms occupied. n new guests arrive.
   * Each existing guest in room k moves to room k + n, freeing rooms 1..n.
   * Return the mapping for the first 5 rooms showing where existing guests move.
   *
   * @param n number of new guests
   * @return Map from old room number to new room number, for rooms 1 through 5
   */
  def exercise8_infiniteHotel(n: Int): Map[Int, Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Cheryl's Birthday
    assert(exercise1_cherylsBirthday() == "July 16")
    println("Exercise 1 passed: cherylsBirthday")

    // Exercise 2: Pirates Gold
    val proposal = exercise2_piratesGold()
    assert(proposal == List(98, 0, 1, 0, 1), s"Expected List(98,0,1,0,1), got $proposal")
    assert(proposal.sum == 100)
    println("Exercise 2 passed: piratesGold")

    // Exercise 3: Blue Eyes
    assert(exercise3_blueEyes(1) == 1)
    assert(exercise3_blueEyes(2) == 2)
    assert(exercise3_blueEyes(100) == 100)
    println("Exercise 3 passed: blueEyes")

    // Exercise 4: Sum-Product
    val (x, y) = exercise4_sumProduct()
    assert(x == 4 && y == 13, s"Expected (4, 13), got ($x, $y)")
    println("Exercise 4 passed: sumProduct")

    // Exercise 5: Liar's Paradox
    assert(exercise5_liarsParadox() == "undecidable")
    println("Exercise 5 passed: liarsParadox")

    // Exercise 6: Prisoner Hats
    assert(exercise6_prisonerHats(1) == 0)
    assert(exercise6_prisonerHats(2) == 1)
    assert(exercise6_prisonerHats(10) == 9)
    assert(exercise6_prisonerHats(100) == 99)
    println("Exercise 6 passed: prisonerHats")

    // Exercise 7: Weighing Puzzle
    assert(exercise7_weighingPuzzle(1) == 0)   // 1 ball, no weighing needed
    assert(exercise7_weighingPuzzle(3) == 1)   // 3 balls: 1 weighing
    assert(exercise7_weighingPuzzle(9) == 2)   // 9 balls: 2 weighings
    assert(exercise7_weighingPuzzle(12) == 3)  // 12 balls: 3 weighings
    assert(exercise7_weighingPuzzle(27) == 3)  // 27 balls: 3 weighings
    assert(exercise7_weighingPuzzle(28) == 4)  // 28 balls: 4 weighings
    println("Exercise 7 passed: weighingPuzzle")

    // Exercise 8: Hilbert's Hotel
    val mapping1 = exercise8_infiniteHotel(3)
    assert(mapping1 == Map(1 -> 4, 2 -> 5, 3 -> 6, 4 -> 7, 5 -> 8))
    val mapping2 = exercise8_infiniteHotel(1)
    assert(mapping2 == Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5, 5 -> 6))
    println("Exercise 8 passed: infiniteHotel")

    println("\nAll exercises passed!")
  }
}
