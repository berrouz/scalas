package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Basic Logic Puzzles=
 *
 * ==Theory: Propositional Logic Fundamentals==
 *
 * '''Propositional logic''' deals with statements (propositions) that are either true or false,
 * and the logical connectives that combine them:
 *
 *  - '''AND (conjunction, &&):''' P AND Q is true only when both P and Q are true.
 *  - '''OR (disjunction, ||):''' P OR Q is true when at least one of P, Q is true.
 *  - '''NOT (negation, !):''' NOT P is true when P is false.
 *  - '''IMPLIES (=>):''' P => Q is equivalent to (NOT P) OR Q. It is false only when P is
 *    true and Q is false.
 *  - '''XOR (exclusive or, ^):''' P XOR Q is true when exactly one of P, Q is true.
 *
 * ==Theory: Knights and Knaves==
 *
 * A classic family of logic puzzles introduced by Raymond Smullyan:
 *
 *  - '''Knights''' always tell the truth.
 *  - '''Knaves''' always lie.
 *  - You must determine who is a knight and who is a knave based on their statements.
 *
 * Key insight: if a knight says statement S, then S is true. If a knave says S, then S is false.
 * So the meta-statement is: "person X is a knight if and only if X's statement is true."
 *
 * '''Self-referential paradox:''' A person says "I am a knave."
 *  - If knight: the statement must be true, so they're a knave -- contradiction.
 *  - If knave: the statement must be false, so they're NOT a knave (they're a knight) -- contradiction.
 *  - Result: this situation is impossible; no consistent assignment exists.
 *
 * ==Theory: The Monty Hall Problem==
 *
 * Three doors: behind one is a car, behind the others are goats.
 *  1. You pick a door.
 *  2. The host (who knows what's behind each door) opens another door revealing a goat.
 *  3. You may switch to the remaining unopened door.
 *
 * '''Should you switch?''' Yes! Switching wins with probability 2/3.
 *
 * Intuition: your initial choice has 1/3 chance of being correct. The host's action doesn't
 * change that. So the remaining door has 2/3 chance. This is counterintuitive because people
 * assume the reveal creates a 50/50 scenario, but the host's knowledge breaks symmetry.
 *
 * ==Theory: Hat Puzzles==
 *
 * Hat puzzles test logical deduction chains. The key technique is '''reasoning about what
 * others can see and what their silence implies:'''
 *
 * Classic puzzle: 3 people, 5 hats (3 white, 2 black). Each person can see others' hats
 * but not their own. Asked in order if they know their hat color:
 *  - Person 1 says "I don't know" => not both others wearing black (else they'd deduce white)
 *  - Person 2 says "I don't know" => person 3's hat is not black (else person 2 would deduce
 *    white using person 1's information)
 *  - Person 3 deduces: "My hat is white"
 *
 * ==Comparison: Logic Puzzles vs Formal Proofs==
 *
 *  - '''Logic puzzles''' require informal but rigorous reasoning, case analysis, and elimination.
 *  - '''Formal proofs''' use axioms, inference rules, and symbolic manipulation.
 *  - In interviews, puzzle-style reasoning is more common. Show systematic case analysis.
 *
 * ==Interview Tips==
 *
 *  - Always enumerate all possible cases systematically. Don't skip cases.
 *  - For knights/knaves: set up equations. Let X = "person is knight" (boolean).
 *    Then: X iff statement_is_true.
 *  - For probability puzzles: draw a tree diagram or enumerate the sample space.
 *  - For deduction chains: work backwards from what you know (modus tollens).
 *  - XOR properties are frequently tested: a^a=0, a^0=a, commutativity, associativity.
 *    These underlie the "find single number" interview classic.
 *  - State your assumptions clearly. Many puzzles have tricky edge cases.
 */
object Logic002_LogicPuzzlesBasic {

  // Exercise 1: Knights and Knaves self-reference.
  // A says "I am a knave." Determine if A is a knight or a knave.
  // Analysis: if knight, statement is true => A is a knave (contradiction).
  //           if knave, statement is false => A is NOT a knave => A is a knight (contradiction).
  // Return "impossible" since no consistent assignment exists.
  def exercise1_knightsAndKnaves: String = ???

  // Exercise 2: Two Guards puzzle.
  // One guard always tells truth, the other always lies.
  // One door is safe, one is deadly. You can ask one guard one question.
  // Strategy: ask "Would the other guard say this door is safe?"
  // If the answer is "yes", the door is actually dangerous.
  // Model: given whether this guard is the truthTeller and whether the safe door is Left,
  // return what the guard answers to "Would the other guard say Left is safe?"
  // The answer is always the OPPOSITE of reality (both truth-about-lie and lie-about-truth invert).
  def exercise2_twoGuards(truthTeller: Boolean, safeIsLeft: Boolean): Boolean = ???

  // Exercise 3: Monty Hall simulation.
  // Simulate n trials of the Monty Hall problem with the "always switch" strategy.
  // Return the fraction of wins (should converge to ~2/3).
  // Use a fixed seed for reproducibility: scala.util.Random with seed 42.
  def exercise3_montyHall(n: Int): Double = ???

  // Exercise 4: Hat puzzle.
  // 3 people, 5 hats (3 white, 2 black). Each sees others' hats but not their own.
  // Person 1 says "I don't know my hat color."
  // Person 2 says "I don't know my hat color."
  // What does Person 3 deduce about their own hat color?
  // Return the color as a String.
  def exercise4_hatPuzzle: String = ???

  // Exercise 5: Truth table evaluation.
  // Evaluate the expression: (P AND Q) OR (NOT P AND R)
  // Return the boolean result.
  def exercise5_truthTable(p: Boolean, q: Boolean, r: Boolean): Boolean = ???

  // Exercise 6: Verify XOR properties for given integers a and b.
  // Property 1: a ^ a == 0
  // Property 2: a ^ 0 == a
  // Property 3: a ^ b == b ^ a (commutativity)
  // Property 4: (a ^ b) ^ b == a (associativity / self-inverse)
  // Return a tuple of 4 booleans, each indicating whether the property holds.
  def exercise6_xorProperties(a: Int, b: Int): (Boolean, Boolean, Boolean, Boolean) = ???

  // Exercise 7: Verify that P => Q is equivalent to (!P) || Q for all combinations of P, Q.
  // The implication P => Q is false only when P is true and Q is false.
  // Check all 4 combinations: (T,T), (T,F), (F,T), (F,F).
  // Return true if the equivalence holds for ALL combinations.
  def exercise7_implication: Boolean = ???

  // Exercise 8: Logical deduction using Modus Tollens.
  // Rule: "If it rains, then the streets are wet." (rains => streetsWet)
  // Given observed values of rains and streetsWet, determine if the scenario is
  // logically consistent with the rule.
  // The only inconsistent case: rains = true AND streetsWet = false.
  def exercise8_logicalDeduction(rains: Boolean, streetsWet: Boolean): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: knightsAndKnaves
    assert(exercise1_knightsAndKnaves == "impossible")
    println("Exercise 1 passed: exercise1_knightsAndKnaves")

    // Exercise 2: twoGuards
    // If truthTeller asks about Left, and Left IS safe:
    //   Truth-teller knows liar would say "Left is NOT safe" (false), so truth-teller says false.
    // The answer is always the opposite of reality.
    assert(exercise2_twoGuards(truthTeller = true, safeIsLeft = true) == false)
    assert(exercise2_twoGuards(truthTeller = true, safeIsLeft = false) == true)
    assert(exercise2_twoGuards(truthTeller = false, safeIsLeft = true) == false)
    assert(exercise2_twoGuards(truthTeller = false, safeIsLeft = false) == true)
    println("Exercise 2 passed: exercise2_twoGuards")

    // Exercise 3: montyHall
    val winRate = exercise3_montyHall(10000)
    assert(winRate > 0.6 && winRate < 0.72, s"Monty Hall win rate was $winRate, expected ~0.667")
    println("Exercise 3 passed: exercise3_montyHall")

    // Exercise 4: hatPuzzle
    assert(exercise4_hatPuzzle == "white")
    println("Exercise 4 passed: exercise4_hatPuzzle")

    // Exercise 5: truthTable
    assert(exercise5_truthTable(p = true, q = true, r = false) == true)
    assert(exercise5_truthTable(p = true, q = false, r = false) == false)
    assert(exercise5_truthTable(p = false, q = false, r = true) == true)
    assert(exercise5_truthTable(p = false, q = false, r = false) == false)
    assert(exercise5_truthTable(p = true, q = true, r = true) == true)
    println("Exercise 5 passed: exercise5_truthTable")

    // Exercise 6: xorProperties
    assert(exercise6_xorProperties(42, 17) == (true, true, true, true))
    assert(exercise6_xorProperties(0, 0) == (true, true, true, true))
    assert(exercise6_xorProperties(255, 128) == (true, true, true, true))
    println("Exercise 6 passed: exercise6_xorProperties")

    // Exercise 7: implication
    assert(exercise7_implication == true)
    println("Exercise 7 passed: exercise7_implication")

    // Exercise 8: logicalDeduction
    assert(exercise8_logicalDeduction(rains = true, streetsWet = true) == true)
    assert(exercise8_logicalDeduction(rains = true, streetsWet = false) == false)
    assert(exercise8_logicalDeduction(rains = false, streetsWet = true) == true)
    assert(exercise8_logicalDeduction(rains = false, streetsWet = false) == true)
    println("Exercise 8 passed: exercise8_logicalDeduction")

    println("\nAll exercises passed!")
  }
}
