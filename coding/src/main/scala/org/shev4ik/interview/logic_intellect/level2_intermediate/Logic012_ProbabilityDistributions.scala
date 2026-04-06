package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Probability Distributions and Bounds (Розподіли ймовірностей та оцінки)=
 *
 * ==Theory: Key Probability Distributions==
 *
 * '''Binomial Distribution B(n, p):''' Models the number of successes in n
 * independent Bernoulli trials, each with success probability p.
 * {{{
 *   P(X = k) = C(n, k) * p^k * (1-p)^(n-k)
 *   E[X] = n*p,  Var[X] = n*p*(1-p)
 * }}}
 *
 * '''Poisson Distribution Pois(λ):''' Approximates Binomial(n, p) when n is large
 * and p is small, with λ = n*p. Good when n >= 20 and p <= 0.05.
 * {{{
 *   P(X = k) = e^(-λ) * λ^k / k!
 * }}}
 *
 * '''Geometric Distribution Geom(p):''' Number of trials until first success.
 * {{{
 *   P(X = k) = (1-p)^(k-1) * p,  for k = 1, 2, 3, ...
 *   E[X] = 1/p,  Var[X] = (1-p)/p^2
 * }}}
 *
 * '''Hypergeometric Distribution:''' Drawing without replacement. N total items,
 * K successes in population, n draws.
 * {{{
 *   P(X = k) = C(K, k) * C(N-K, n-k) / C(N, n)
 * }}}
 *
 * ==Theory: Probability Bounds==
 *
 * '''Markov's Inequality:''' For non-negative random variable X with mean μ:
 * {{{
 *   P(X >= a) <= μ / a    (for a > 0)
 * }}}
 *
 * '''Chebyshev's Inequality:''' For any random variable X with mean μ and
 * standard deviation σ:
 * {{{
 *   P(|X - μ| >= k*σ) <= 1/k^2    (for k > 0)
 * }}}
 *
 * '''Normal (Gaussian) Approximation:''' By the Central Limit Theorem, for large n,
 * Binomial(n, p) is approximately Normal(np, np(1-p)). The CDF can be
 * computed using the error function: Φ(x) = 0.5 * (1 + erf(x / sqrt(2))).
 *
 * ==Comparison: When to Use Which Distribution==
 *
 * | Distribution    | Setting                           | Key Parameters |
 * |-----------------|-----------------------------------|----------------|
 * | Binomial        | Fixed n trials, with replacement  | n, p           |
 * | Poisson         | Rare events, large n, small p     | λ = n*p        |
 * | Geometric       | Trials until first success        | p              |
 * | Hypergeometric  | Sampling without replacement      | N, K, n        |
 * | Normal (approx) | Large n, CLT applies              | μ = np, σ²     |
 *
 * ==Interview Tips==
 *
 *  - '''Binomial vs Hypergeometric:''' Use binomial for sampling with replacement
 *    (or independent trials), hypergeometric for without replacement.
 *  - '''Poisson approximation:''' When told "n is very large and p is very small,"
 *    immediately think Poisson. Common in system reliability problems.
 *  - '''Markov/Chebyshev:''' These give ''worst-case'' bounds without knowing the
 *    exact distribution. Chebyshev is tighter if you know the variance.
 *  - '''Normal approximation:''' Use continuity correction: P(X <= k) ≈ Φ((k + 0.5 - μ) / σ).
 *  - Know that E[X] = n*p and Var[X] = n*p*(1-p) for binomial — these come up
 *    constantly in interviews.
 *
 * ==Complexity Note==
 *
 * Computing binomial probabilities naively involves factorials, which can overflow.
 * Use logarithmic computation or BigInt-based binomial coefficients. The erf
 * approximation used here has accuracy within 1.5 * 10^-7.
 */
object Logic012_ProbabilityDistributions {

  /**
   * Exercise 1: Binomial Probability
   *
   * Compute P(X = k) for X ~ Binomial(n, p).
   * P(X = k) = C(n, k) * p^k * (1-p)^(n-k)
   *
   * @param n number of trials
   * @param p probability of success on each trial
   * @param k number of successes
   * @return P(X = k)
   */
  def exercise1_binomialProbability(n: Int, p: Double, k: Int): Double = ???

  /**
   * Exercise 2: Binomial Expected Value and Variance
   *
   * Compute E[X] and Var[X] for X ~ Binomial(n, p).
   * E[X] = n*p, Var[X] = n*p*(1-p)
   *
   * @param n number of trials
   * @param p probability of success
   * @return (expected value, variance)
   */
  def exercise2_binomialExpectedValue(n: Int, p: Double): (Double, Double) = ???

  /**
   * Exercise 3: Poisson Approximation
   *
   * Approximate P(X = k) for X ~ Binomial(n, p) using Poisson distribution
   * with λ = n*p. P(X = k) ≈ e^(-λ) * λ^k / k!
   *
   * @param n number of trials
   * @param p probability of success
   * @param k number of successes
   * @return Poisson approximation of P(X = k)
   */
  def exercise3_poissonApprox(n: Int, p: Double, k: Int): Double = ???

  /**
   * Exercise 4: Markov's Inequality
   *
   * For a non-negative random variable with mean mu, compute the upper
   * bound on P(X >= a) using Markov's inequality: P(X >= a) <= mu / a.
   *
   * @param mu mean of the random variable
   * @param a  threshold value (a > 0)
   * @return upper bound on P(X >= a)
   */
  def exercise4_markovInequality(mu: Double, a: Double): Double = ???

  /**
   * Exercise 5: Chebyshev's Inequality
   *
   * Compute the upper bound on P(|X - mu| >= k*sigma) using Chebyshev's
   * inequality: P(|X - mu| >= k*sigma) <= 1/k^2.
   *
   * @param k number of standard deviations from the mean
   * @return upper bound 1/k^2
   */
  def exercise5_chebyshevInequality(k: Double): Double = ???

  /**
   * Exercise 6: Geometric Expected Value
   *
   * Compute the expected number of trials until the first success for
   * a geometric distribution with parameter p. E[X] = 1/p.
   *
   * @param p probability of success on each trial (0 < p <= 1)
   * @return expected number of trials
   */
  def exercise6_geometricExpected(p: Double): Double = ???

  /**
   * Exercise 7: Hypergeometric Probability
   *
   * Compute P(X = k) for a hypergeometric distribution.
   * P(X = k) = C(K, k) * C(N-K, n-k) / C(N, n)
   *
   * @param totalN total population size N
   * @param successK number of success states in population K
   * @param draws number of draws n
   * @param k number of observed successes
   * @return P(X = k)
   */
  def exercise7_hypergeometric(totalN: Int, successK: Int, draws: Int, k: Int): Double = ???

  /**
   * Exercise 8: Normal Approximation with Continuity Correction
   *
   * Approximate P(X <= k) for X ~ Binomial(n, p) using the normal CDF
   * with continuity correction: P(X <= k) ≈ Φ((k + 0.5 - μ) / σ)
   * where μ = np, σ = sqrt(np(1-p)), and Φ(x) = 0.5 * (1 + erf(x / sqrt(2))).
   *
   * Uses the Abramowitz and Stegun erf approximation.
   *
   * @param n number of trials
   * @param p probability of success
   * @param k threshold
   * @return approximate P(X <= k)
   */
  def exercise8_normalApprox(n: Int, p: Double, k: Int): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Binomial Probability
    val binom1 = exercise1_binomialProbability(10, 0.5, 5)
    assert(math.abs(binom1 - 0.24609375) < 1e-6, s"Expected ~0.2461, got $binom1")
    val binom2 = exercise1_binomialProbability(5, 0.3, 2)
    assert(math.abs(binom2 - 0.3087) < 1e-3, s"Expected ~0.3087, got $binom2")
    println("Exercise 1 passed: binomialProbability")

    // Exercise 2: Binomial Expected Value
    val (ev1, var1) = exercise2_binomialExpectedValue(10, 0.5)
    assert(math.abs(ev1 - 5.0) < 1e-9)
    assert(math.abs(var1 - 2.5) < 1e-9)
    val (ev2, var2) = exercise2_binomialExpectedValue(100, 0.3)
    assert(math.abs(ev2 - 30.0) < 1e-9)
    assert(math.abs(var2 - 21.0) < 1e-9)
    println("Exercise 2 passed: binomialExpectedValue")

    // Exercise 3: Poisson Approximation
    val pois1 = exercise3_poissonApprox(1000, 0.001, 1)
    // lambda = 1.0, P(X=1) = e^(-1) * 1 / 1! ≈ 0.3679
    assert(math.abs(pois1 - 0.3679) < 1e-3, s"Expected ~0.3679, got $pois1")
    val pois2 = exercise3_poissonApprox(100, 0.01, 0)
    // lambda = 1.0, P(X=0) = e^(-1) ≈ 0.3679
    assert(math.abs(pois2 - 0.3679) < 1e-3, s"Expected ~0.3679, got $pois2")
    println("Exercise 3 passed: poissonApprox")

    // Exercise 4: Markov's Inequality
    assert(math.abs(exercise4_markovInequality(10.0, 20.0) - 0.5) < 1e-9)
    assert(math.abs(exercise4_markovInequality(5.0, 25.0) - 0.2) < 1e-9)
    println("Exercise 4 passed: markovInequality")

    // Exercise 5: Chebyshev's Inequality
    assert(math.abs(exercise5_chebyshevInequality(2.0) - 0.25) < 1e-9)
    assert(math.abs(exercise5_chebyshevInequality(3.0) - 1.0 / 9.0) < 1e-9)
    println("Exercise 5 passed: chebyshevInequality")

    // Exercise 6: Geometric Expected
    assert(math.abs(exercise6_geometricExpected(0.5) - 2.0) < 1e-9)
    assert(math.abs(exercise6_geometricExpected(0.1) - 10.0) < 1e-9)
    assert(math.abs(exercise6_geometricExpected(1.0) - 1.0) < 1e-9)
    println("Exercise 6 passed: geometricExpected")

    // Exercise 7: Hypergeometric
    // Example: deck of 52 cards, 13 hearts, draw 5, P(exactly 2 hearts)
    val hyp1 = exercise7_hypergeometric(52, 13, 5, 2)
    assert(math.abs(hyp1 - 0.2743) < 1e-3, s"Expected ~0.2743, got $hyp1")
    // Simple example: 10 items, 4 defective, draw 3, P(1 defective)
    val hyp2 = exercise7_hypergeometric(10, 4, 3, 1)
    assert(math.abs(hyp2 - 0.5) < 1e-3, s"Expected ~0.5, got $hyp2")
    println("Exercise 7 passed: hypergeometric")

    // Exercise 8: Normal Approximation
    // Binomial(100, 0.5), P(X <= 50) should be close to 0.5398 (with continuity correction)
    val norm1 = exercise8_normalApprox(100, 0.5, 50)
    assert(math.abs(norm1 - 0.5398) < 0.02, s"Expected ~0.54, got $norm1")
    // Binomial(100, 0.5), P(X <= 60) should be close to 0.9824
    val norm2 = exercise8_normalApprox(100, 0.5, 60)
    assert(math.abs(norm2 - 0.9824) < 0.02, s"Expected ~0.98, got $norm2")
    println("Exercise 8 passed: normalApprox")

    println("\nAll exercises passed!")
  }
}
