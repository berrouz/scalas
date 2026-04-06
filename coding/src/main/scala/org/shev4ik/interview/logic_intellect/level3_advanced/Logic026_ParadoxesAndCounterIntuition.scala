package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Paradoxes and Counter-Intuitive Results (Парадокси та контрінтуїтивні результати)=
 *
 * ==Theory: When Intuition Fails==
 *
 * Many probability and logic puzzles produce results that violate our intuitive
 * expectations. Understanding these paradoxes is critical for rigorous reasoning
 * in interviews and real-world decision-making.
 *
 * '''Simpson's Paradox:''' A trend that appears in several groups of data can
 * reverse when those groups are combined. This happens because of lurking
 * variables that affect group sizes disproportionately.
 * {{{
 *   Group 1: A wins 80/100 (80%), B wins 9/10 (90%)
 *   Group 2: A wins 18/20 (90%), B wins 70/100 (70%)
 *   Combined: A wins 98/120 (81.7%), B wins 79/110 (71.8%)
 *   => A better overall despite B better in each group!
 *   (reverse the sizes to see the paradox from B's side)
 * }}}
 *
 * '''St. Petersburg Paradox:''' A game where you flip a coin until heads appears
 * on flip k, winning 2^k. The expected value is infinite:
 * {{{
 *   E = sum_{k=1}^{inf} (1/2^k) * 2^k = sum_{k=1}^{inf} 1 = infinity
 * }}}
 * Yet no rational person would pay a large amount to play. This paradox
 * motivated the development of utility theory (Bernoulli, 1738).
 *
 * '''Bertrand's Box Paradox:''' Three boxes contain (gold, gold), (gold, silver),
 * (silver, silver). You pick a box at random and draw a gold coin. The probability
 * that the other coin is also gold is 2/3, not 1/2. This is because there are
 * 3 equally likely gold coins you could have drawn, and 2 of them come from
 * the (gold, gold) box.
 *
 * '''Condorcet Paradox:''' With 3+ candidates, majority preferences can be cyclic:
 * A > B > C > A. This means there is no Condorcet winner (a candidate who beats
 * every other candidate in pairwise majority vote).
 *
 * '''Braess's Paradox:''' Adding a new road to a traffic network can increase
 * the overall travel time for all drivers. This occurs in Nash equilibrium when
 * selfish routing differs from the social optimum.
 *
 * '''Inspection Paradox (Waiting Time Paradox):''' If buses arrive with
 * exponential inter-arrival times (mean m), a random arrival waits on average
 * m minutes, not m/2. This is because longer intervals are more likely to be
 * "hit" by a random arrival.
 *
 * ==Comparison: Key Paradoxes==
 *
 * | Paradox              | Domain          | Key Insight                        |
 * |----------------------|-----------------|------------------------------------|
 * | Simpson's            | Statistics      | Aggregation reverses trends        |
 * | St. Petersburg       | Decision Theory | Infinite EV, finite willingness    |
 * | Bertrand's Box       | Probability     | Conditional probability != naive   |
 * | Condorcet            | Voting Theory   | Cyclic majority preferences        |
 * | Braess's             | Game Theory     | More capacity can hurt everyone    |
 * | Exchange/Envelope    | Probability     | Symmetric reasoning breaks down    |
 *
 * ==Interview Tips==
 *
 *  - '''Simpson's paradox''' is extremely common in A/B testing interviews.
 *    Always ask about confounding variables and segment sizes.
 *  - '''Bayes' theorem''' is the cure for the base-rate fallacy (false positive).
 *    Memorize: P(A|B) = P(B|A)*P(A) / P(B). Draw a 2x2 contingency table.
 *  - '''Bertrand's box''' teaches the importance of counting sample space correctly.
 *  - For '''Braess's paradox''', think Nash equilibrium vs social optimum.
 *  - '''St. Petersburg''' shows why expected value alone is insufficient for
 *    decision-making — utility functions matter.
 *  - When faced with counter-intuitive results, verify by enumeration on small cases.
 *
 * ==Complexity Note==
 *
 * These exercises focus on reasoning and verification rather than algorithmic
 * efficiency. Most computations are O(1) or O(n) for small fixed inputs.
 */
object Logic026_ParadoxesAndCounterIntuition {

  /**
   * Exercise 1: Simpson's Paradox
   *
   * Demonstrate Simpson's paradox with concrete numbers. Given success rates
   * for two treatments across two groups, show that treatment A can be better
   * in both groups individually yet worse overall.
   *
   * Use these numbers:
   *   Group 1: A succeeds 1/10 (10%), B succeeds 30/100 (30%) — B better
   *   Group 2: A succeeds 70/100 (70%), B succeeds 9/10 (90%) — B better
   *   Overall: A succeeds 71/110 (64.5%), B succeeds 39/110 (35.5%) — A better!
   *
   * Return true if the paradox is demonstrated (A worse in both groups but
   * better overall).
   *
   * @return true if Simpson's paradox is demonstrated
   */
  def exercise1_simpsonsParadox: Boolean = ???

  /**
   * Exercise 2: St. Petersburg Paradox (Truncated)
   *
   * Compute the expected value of the truncated St. Petersburg game with
   * at most n flips. On flip k (1-indexed), you win 2^k if it is the first heads.
   * E = sum_{k=1}^{n} (1/2^k) * 2^k = n.
   *
   * @param n maximum number of flips
   * @return expected value of the truncated game
   */
  def exercise2_stPetersburg(n: Int): Double = ???

  /**
   * Exercise 3: Bertrand's Box Paradox
   *
   * Three boxes: (gold, gold), (gold, silver), (silver, silver).
   * You pick a box at random and draw one coin, which is gold.
   * What is the probability that the other coin in the same box is also gold?
   *
   * Answer: 2/3 (not 1/2).
   *
   * @return P(other coin is gold | drawn coin is gold)
   */
  def exercise3_bertrandsBox: Double = ???

  /**
   * Exercise 4: Condorcet Paradox
   *
   * Given 3 candidates (0, 1, 2) and a list of voter preference orderings
   * (each is a permutation of [0, 1, 2] from most to least preferred),
   * check if there is a Condorcet cycle: A > B > C > A in pairwise majority.
   *
   * @param preferences list of voter preference orderings (each a List[Int])
   * @return true if a Condorcet cycle exists
   */
  def exercise4_condorcetParadox(preferences: List[List[Int]]): Boolean = ???

  /**
   * Exercise 5: Braess's Paradox
   *
   * Model a simple 4-node network (S -> A, S -> B, A -> T, B -> T) with
   * latency functions. Show that adding a zero-cost edge A -> B can increase
   * total latency at Nash equilibrium.
   *
   * Without shortcut: each driver uses S->A->T or S->B->T.
   *   S->A: x/100, A->T: 45, S->B: 45, B->T: x/100
   *   With 4000 drivers, equilibrium: 2000 each route, latency = 20+45 = 65.
   *
   * With shortcut A->B (cost 0): all drivers use S->A->B->T.
   *   Latency = 40/100*4000 + 0 + 40/100*4000 = 40+0+40 = 80. Worse!
   *
   * @param numDrivers total number of drivers (e.g. 4000)
   * @return true if adding the shortcut increases equilibrium latency
   */
  def exercise5_braessParadox(numDrivers: Int): Boolean = ???

  /**
   * Exercise 6: Exchange (Envelope) Paradox
   *
   * Two envelopes: one has amount X, the other has 2X. You pick one and see
   * amount A. The naive argument says switch because EV = 0.5*(A/2) + 0.5*(2A)
   * = 1.25A > A. But this is flawed because it conflates different sample spaces.
   *
   * Given that the two amounts are (small, big) = (v, 2v) and you hold amount a,
   * compute the true expected value of the other envelope. Since a is equally
   * likely to be v or 2v, EV of other = 0.5*(2v) + 0.5*(v) = 1.5v.
   * But your held amount a = 0.5*(v + 2v) = 1.5v in expectation too.
   *
   * Given the smaller value v, return the expected value of the other envelope
   * (which equals 1.5 * v, same as the expected value of your own).
   *
   * @param v the smaller of the two amounts
   * @return expected value of the other envelope
   */
  def exercise6_exchangeParadox(v: Double): Double = ???

  /**
   * Exercise 7: Waiting/Bus Paradox (Inspection Paradox)
   *
   * Buses arrive according to an exponential distribution with mean inter-arrival
   * time of `meanMinutes`. Due to the memoryless property, a random arrival
   * expects to wait `meanMinutes` (not meanMinutes/2).
   *
   * Simulate: generate n exponential inter-arrival times, pick a random arrival
   * time uniformly in [0, total], find the gap it falls in, and return the
   * remaining time. Average over many trials.
   *
   * For this exercise, compute the theoretical expected wait for exponential
   * inter-arrivals with the given mean.
   *
   * @param meanMinutes mean inter-arrival time in minutes
   * @return expected waiting time (equals meanMinutes for exponential)
   */
  def exercise7_waitingBusParadox(meanMinutes: Double): Double = ???

  /**
   * Exercise 8: False Positive Paradox (Base Rate Fallacy)
   *
   * Disease prevalence = prevalence (e.g. 0.01 = 1%).
   * Test sensitivity (true positive rate) = sensitivity (e.g. 0.99).
   * Test specificity (true negative rate) = specificity (e.g. 0.99).
   *
   * Using Bayes' theorem:
   * P(disease | positive) = P(pos|dis)*P(dis) / (P(pos|dis)*P(dis) + P(pos|healthy)*P(healthy))
   *
   * With 1% prevalence and 99% accuracy: P ≈ 0.5 (50%), not 99%!
   *
   * @param prevalence  P(disease) in the population
   * @param sensitivity P(positive | disease) — true positive rate
   * @param specificity P(negative | healthy) — true negative rate
   * @return P(disease | positive test)
   */
  def exercise8_falsePositive(prevalence: Double, sensitivity: Double, specificity: Double): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Simpson's Paradox
    assert(exercise1_simpsonsParadox)
    println("Exercise 1 passed: simpsonsParadox")

    // Exercise 2: St. Petersburg (Truncated)
    assert(exercise2_stPetersburg(1) == 1.0)
    assert(exercise2_stPetersburg(10) == 10.0)
    assert(exercise2_stPetersburg(20) == 20.0)
    println("Exercise 2 passed: stPetersburg")

    // Exercise 3: Bertrand's Box
    assert(math.abs(exercise3_bertrandsBox - 2.0 / 3.0) < 1e-9)
    println("Exercise 3 passed: bertrandsBox")

    // Exercise 4: Condorcet Paradox
    // Classic cycle: 1 voter A>B>C, 1 voter B>C>A, 1 voter C>A>B
    val cyclePrefs = List(List(0, 1, 2), List(1, 2, 0), List(2, 0, 1))
    assert(exercise4_condorcetParadox(cyclePrefs))
    // No cycle: 2 voters A>B>C, 1 voter B>C>A
    val noCyclePrefs = List(List(0, 1, 2), List(0, 1, 2), List(1, 2, 0))
    assert(!exercise4_condorcetParadox(noCyclePrefs))
    println("Exercise 4 passed: condorcetParadox")

    // Exercise 5: Braess's Paradox
    assert(exercise5_braessParadox(4000))
    println("Exercise 5 passed: braessParadox")

    // Exercise 6: Exchange Paradox
    assert(math.abs(exercise6_exchangeParadox(100.0) - 150.0) < 1e-9)
    assert(math.abs(exercise6_exchangeParadox(50.0) - 75.0) < 1e-9)
    println("Exercise 6 passed: exchangeParadox")

    // Exercise 7: Waiting Bus Paradox
    assert(math.abs(exercise7_waitingBusParadox(10.0) - 10.0) < 1e-9)
    assert(math.abs(exercise7_waitingBusParadox(15.0) - 15.0) < 1e-9)
    println("Exercise 7 passed: waitingBusParadox")

    // Exercise 8: False Positive
    val result8 = exercise8_falsePositive(0.01, 0.99, 0.99)
    assert(math.abs(result8 - 0.5) < 0.01, s"Expected ~0.5 but got $result8")
    val result8b = exercise8_falsePositive(0.001, 0.99, 0.99)
    assert(result8b < 0.1, s"Expected < 0.1 but got $result8b")
    println("Exercise 8 passed: falsePositive")

    println("\nAll exercises passed!")
  }
}
