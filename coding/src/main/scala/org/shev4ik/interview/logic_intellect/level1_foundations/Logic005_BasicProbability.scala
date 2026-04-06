package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Basic Probability=
 *
 * ==Theory: Probability Fundamentals==
 *
 * '''Probability''' is a measure of how likely an event is to occur, expressed as a number
 * between 0 (impossible) and 1 (certain).
 *
 * Key axioms (Kolmogorov):
 *  - P(S) = 1 where S is the entire sample space.
 *  - P(A) >= 0 for any event A.
 *  - P(A union B) = P(A) + P(B) if A and B are mutually exclusive.
 *
 * Derived rules:
 *  - '''Complement:''' P(not A) = 1 - P(A)
 *  - '''Inclusion-exclusion:''' P(A union B) = P(A) + P(B) - P(A intersect B)
 *  - '''Conditional probability:''' P(A | B) = P(A intersect B) / P(B)
 *
 * ==Theory: Birthday Paradox==
 *
 * The '''birthday paradox''' asks: how many people do you need in a room before there's
 * a >50% chance that two share a birthday?
 *
 * The answer is surprisingly small: '''23 people.'''
 *
 * Calculation: P(all different among n people) = 365/365 * 364/365 * 363/365 * ... * (365-n+1)/365
 *
 * P(at least one match) = 1 - P(all different)
 *
 * {{{
 * P(match | n people) = 1 - product(i=0 to n-1) of (365 - i) / 365
 * }}}
 *
 * CS applications:
 *  - Hash collision probability: with m hash values and n items, collision probability
 *    follows the same formula with 365 replaced by m.
 *  - Birthday attack on cryptographic hashes: to find a collision with 50% probability,
 *    you need roughly sqrt(pi * m / 2) hashes, not m/2.
 *
 * ==Theory: Coupon Collector's Problem==
 *
 * How many items must you sample (with replacement) to collect all n distinct types?
 *
 * '''Expected value = n * H(n)''' where H(n) = 1 + 1/2 + 1/3 + ... + 1/n is the nth
 * harmonic number.
 *
 * Intuition: after collecting k distinct types, the probability of getting a new type
 * is (n-k)/n, so the expected draws to get the next new type is n/(n-k).
 * Total = sum over k=0 to n-1 of n/(n-k) = n * (1/n + 1/(n-1) + ... + 1/1) = n * H(n).
 *
 * H(n) ~ ln(n) + gamma (Euler-Mascheroni constant ~ 0.5772), so the expected draws
 * are approximately n * ln(n).
 *
 * CS applications: randomized algorithms, cache warming, test coverage estimation.
 *
 * ==Theory: Bayes' Theorem==
 *
 * '''Bayes' theorem''' relates conditional probabilities:
 *
 * {{{
 * P(A | B) = P(B | A) * P(A) / P(B)
 * }}}
 *
 * where P(B) = P(B|A)*P(A) + P(B|not A)*P(not A) (law of total probability).
 *
 * This is fundamental to:
 *  - Medical testing (false positive analysis)
 *  - Spam filtering (naive Bayes classifier)
 *  - Machine learning (Bayesian inference)
 *  - A/B testing (Bayesian approach)
 *
 * ==Theory: Expected Value==
 *
 * The '''expected value''' E[X] of a random variable X is the weighted average of all
 * possible values, weighted by their probabilities:
 *
 * {{{
 * E[X] = sum of x * P(X = x) for all possible x
 * }}}
 *
 * Key properties:
 *  - '''Linearity:''' E[aX + bY] = a*E[X] + b*E[Y] (always, even for dependent variables!)
 *  - E[dice roll] = (1+2+3+4+5+6)/6 = 3.5
 *  - E[sum of k dice] = k * 3.5 (by linearity)
 *
 * ==Theory: Geometric Distribution==
 *
 * The number of trials until the first success, where each trial succeeds with probability p:
 *  - P(X = k) = (1-p)^(k-1) * p
 *  - E[X] = 1/p
 *  - Var[X] = (1-p)/p^2
 *
 * Example: expected coin flips to get heads (p=0.5) is 1/0.5 = 2.
 *
 * ==Theory: Random Walks==
 *
 * A '''1D random walk''' starts at 0 and at each step moves +1 or -1 with equal probability.
 *
 * The probability of returning to the origin after exactly n steps:
 *  - If n is odd: 0 (impossible, since each step changes parity)
 *  - If n is even: C(n, n/2) / 2^n (must take exactly n/2 steps right and n/2 steps left)
 *
 * '''Recurrence theorem:''' in 1D and 2D, a random walk returns to the origin with
 * probability 1 (given infinite time). In 3D and higher, the probability is < 1.
 *
 * ==Comparison: Frequentist vs Bayesian Probability==
 *
 *  - '''Frequentist:''' probability = long-run frequency of events. P(heads) = lim(heads/flips).
 *  - '''Bayesian:''' probability = degree of belief, updated via Bayes' theorem as evidence arrives.
 *  - In interviews, most probability questions use frequentist reasoning, but Bayes' theorem
 *    questions are common for data science and ML roles.
 *
 * ==Interview Tips==
 *
 *  - For birthday-style problems: compute P(no collision) as a product, then take complement.
 *  - For expected value: use linearity of expectation aggressively -- it simplifies many problems.
 *  - For Bayes: always write out P(B) using the law of total probability.
 *  - Watch out for "without replacement" vs "with replacement" -- they change probabilities.
 *  - Common trick: "probability of at least one" = 1 - P(none).
 *  - For random walks: remember the parity constraint (can only return at even steps).
 *  - Know that C(n, n/2) / 2^n ~ sqrt(2 / (pi * n)) by Stirling's approximation.
 */
object Logic005_BasicProbability {

  // Exercise 1: Birthday Paradox.
  // Compute the probability that at least 2 of n people share a birthday (365-day year).
  // P(at least one match) = 1 - P(all different)
  // P(all different) = (365/365) * (364/365) * (363/365) * ... * ((365-n+1)/365)
  // For n > 365, return 1.0. For n <= 1, return 0.0.
  // Example: exercise1_birthdayParadox(23) => ~0.5073 (> 0.5)
  def exercise1_birthdayParadox(n: Int): Double = ???

  // Exercise 2: Coupon Collector's Problem.
  // Expected number of draws to collect all n distinct coupons.
  // E = n * H(n) where H(n) = 1 + 1/2 + 1/3 + ... + 1/n (harmonic number).
  // Example: exercise2_couponCollector(5) => 5 * (1 + 0.5 + 0.333... + 0.25 + 0.2) = 5 * 2.2833... = 11.4166...
  def exercise2_couponCollector(n: Int): Double = ???

  // Exercise 3: Bayes' Theorem.
  // Given P(A), P(B|A), and P(B|not A), compute P(A|B).
  // P(A|B) = P(B|A) * P(A) / P(B)
  // where P(B) = P(B|A) * P(A) + P(B|not A) * P(not A)
  // Example: disease test: P(disease) = 0.01, P(positive|disease) = 0.99,
  //   P(positive|no disease) = 0.05
  //   P(disease|positive) = 0.99 * 0.01 / (0.99*0.01 + 0.05*0.99) = 0.0099 / 0.0594 ~ 0.1667
  def exercise3_bayesTheorem(pA: Double, pBgivenA: Double, pBgivenNotA: Double): Double = ???

  // Exercise 4: Expected value of the sum of k dice rolls.
  // Each die has faces 1, 2, ..., n. By linearity of expectation:
  // E[sum] = k * E[single die] = k * (n + 1) / 2
  // Example: exercise4_expectedValueDice(k=2, n=6) => 2 * 3.5 = 7.0
  def exercise4_expectedValueDice(k: Int, n: Int): Double = ???

  // Exercise 5: Geometric Distribution expected value.
  // Expected number of independent trials to get the first success,
  // where each trial succeeds with probability p.
  // E[X] = 1 / p
  // Example: exercise5_geometricDistribution(0.5) => 2.0
  // Example: exercise5_geometricDistribution(0.1) => 10.0
  def exercise5_geometricDistribution(p: Double): Double = ???

  // Exercise 6: Conditional probability -- drawing cards without replacement.
  // A deck has n cards, k of which are red. Two cards are drawn without replacement.
  // What is P(second card is red | first card is red)?
  // P = (k - 1) / (n - 1)
  // Example: exercise6_conditionalProbability(n=52, k=26) => 25.0/51.0 ~ 0.4902
  def exercise6_conditionalProbability(n: Int, k: Int): Double = ???

  // Exercise 7: Monty Hall exact probability.
  // Calculate the exact probability of winning with the "always switch" strategy.
  // Derivation: P(initial pick is car) = 1/3. If you switch, you lose.
  //             P(initial pick is goat) = 2/3. If you switch, you win (host reveals the other goat).
  // So P(win | switch) = 2/3.
  // Return this exact value.
  def exercise7_montyHallProbability: Double = ???

  // Exercise 8: 1D Random Walk -- probability of returning to origin after exactly n steps.
  // Each step is +1 or -1 with equal probability.
  // If n is odd: impossible (return 0.0).
  // If n is even: P = C(n, n/2) / 2^n
  // Use BigInt for C(n, n/2) and BigDecimal for the division to handle large n.
  // Example: exercise8_randomWalk1D(2) => C(2,1)/4 = 2/4 = 0.5
  // Example: exercise8_randomWalk1D(4) => C(4,2)/16 = 6/16 = 0.375
  def exercise8_randomWalk1D(n: Int): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: birthdayParadox
    assert(exercise1_birthdayParadox(1) == 0.0)
    val p23 = exercise1_birthdayParadox(23)
    assert(p23 > 0.50 && p23 < 0.51, s"Expected ~0.5073, got $p23")
    val p50 = exercise1_birthdayParadox(50)
    assert(p50 > 0.97 && p50 < 0.98, s"Expected ~0.9704, got $p50")
    assert(exercise1_birthdayParadox(366) == 1.0)
    println("Exercise 1 passed: exercise1_birthdayParadox")

    // Exercise 2: couponCollector
    val cc5 = exercise2_couponCollector(5)
    assert(cc5 > 11.41 && cc5 < 11.42, s"Expected ~11.4167, got $cc5")
    val cc1 = exercise2_couponCollector(1)
    assert(cc1 == 1.0, s"Expected 1.0, got $cc1")
    println("Exercise 2 passed: exercise2_couponCollector")

    // Exercise 3: bayesTheorem
    val bt = exercise3_bayesTheorem(0.01, 0.99, 0.05)
    assert(bt > 0.166 && bt < 0.168, s"Expected ~0.1667, got $bt")
    val bt2 = exercise3_bayesTheorem(0.5, 1.0, 0.0)
    assert(bt2 == 1.0, s"Expected 1.0, got $bt2")
    println("Exercise 3 passed: exercise3_bayesTheorem")

    // Exercise 4: expectedValueDice
    assert(exercise4_expectedValueDice(2, 6) == 7.0)
    assert(exercise4_expectedValueDice(1, 6) == 3.5)
    assert(exercise4_expectedValueDice(3, 6) == 10.5)
    assert(exercise4_expectedValueDice(1, 20) == 10.5)
    println("Exercise 4 passed: exercise4_expectedValueDice")

    // Exercise 5: geometricDistribution
    assert(exercise5_geometricDistribution(0.5) == 2.0)
    assert(exercise5_geometricDistribution(0.1) == 10.0)
    assert(exercise5_geometricDistribution(1.0) == 1.0)
    println("Exercise 5 passed: exercise5_geometricDistribution")

    // Exercise 6: conditionalProbability
    val cp1 = exercise6_conditionalProbability(52, 26)
    assert(math.abs(cp1 - 25.0 / 51.0) < 0.0001, s"Expected ~0.4902, got $cp1")
    val cp2 = exercise6_conditionalProbability(10, 5)
    assert(math.abs(cp2 - 4.0 / 9.0) < 0.0001, s"Expected ~0.4444, got $cp2")
    println("Exercise 6 passed: exercise6_conditionalProbability")

    // Exercise 7: montyHallProbability
    assert(math.abs(exercise7_montyHallProbability - 2.0 / 3.0) < 0.0001)
    println("Exercise 7 passed: exercise7_montyHallProbability")

    // Exercise 8: randomWalk1D
    assert(exercise8_randomWalk1D(1) == 0.0)
    assert(exercise8_randomWalk1D(2) == 0.5)
    assert(exercise8_randomWalk1D(4) == 0.375)
    assert(exercise8_randomWalk1D(3) == 0.0)
    val rw6 = exercise8_randomWalk1D(6)
    assert(math.abs(rw6 - 0.3125) < 0.0001, s"Expected 0.3125, got $rw6")
    println("Exercise 8 passed: exercise8_randomWalk1D")

    println("\nAll exercises passed!")
  }
}
