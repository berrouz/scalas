package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Information Theory (Теорія інформації)=
 *
 * ==Theory: Shannon Entropy, Coding, and Information Measures==
 *
 * Information theory, founded by Claude Shannon in 1948, provides the
 * mathematical foundation for data compression, communication, and modern
 * machine learning. These concepts appear in ML interviews, system design,
 * and quantitative reasoning questions.
 *
 * '''Shannon Entropy:''' The expected information content of a random variable:
 * {{{
 *   H(X) = -Σ p(x) * log₂(p(x))
 * }}}
 * Entropy is maximized for uniform distributions and equals 0 for deterministic
 * outcomes. Measured in bits when using log base 2.
 *
 * '''Binary Entropy Function:''' For a Bernoulli random variable with parameter p:
 * {{{
 *   H(p) = -p * log₂(p) - (1-p) * log₂(1-p)
 * }}}
 * Maximum at p = 0.5 (H = 1 bit). Used extensively in decision trees and
 * binary classification metrics.
 *
 * '''Huffman Coding:''' An optimal prefix-free coding scheme that assigns shorter
 * codes to more frequent symbols. The algorithm:
 * 1. Create a leaf node for each symbol with its frequency
 * 2. Repeatedly merge the two nodes with lowest frequency
 * 3. Assign 0/1 to left/right branches
 * The average code length approaches entropy: H(X) ≤ L < H(X) + 1.
 *
 * '''Kraft Inequality:''' A necessary and sufficient condition for the existence
 * of a prefix-free code with code lengths l₁, l₂, ..., lₙ:
 * {{{
 *   Σ 2^(-lᵢ) ≤ 1
 * }}}
 *
 * '''Mutual Information:''' Measures the information shared between two variables:
 * {{{
 *   I(X;Y) = H(X) + H(Y) - H(X,Y)
 *          = Σₓ Σᵧ p(x,y) * log₂(p(x,y) / (p(x)*p(y)))
 * }}}
 * I(X;Y) = 0 iff X and Y are independent. Used in feature selection.
 *
 * '''Channel Capacity:''' The maximum rate of reliable communication over a noisy
 * channel. For a binary symmetric channel (BSC) with crossover probability p:
 * {{{
 *   C = 1 - H(p)    (bits per channel use)
 * }}}
 *
 * ==Comparison: Information Measures==
 *
 * | Measure            | Formula                       | Range           | Use Case                |
 * |--------------------|-------------------------------|-----------------|-------------------------|
 * | Entropy H(X)       | -Σ p log p                    | [0, log₂(n)]   | Uncertainty of X        |
 * | Binary Entropy     | -p log p - (1-p) log(1-p)     | [0, 1]         | Bernoulli variables     |
 * | Joint Entropy      | -Σ p(x,y) log p(x,y)         | [0, log₂(mn)]  | Combined uncertainty    |
 * | Mutual Information  | H(X) + H(Y) - H(X,Y)         | [0, min(H(X),H(Y))]| Shared information |
 * | KL Divergence      | Σ p log(p/q)                  | [0, ∞)         | Distribution difference |
 * | Channel Capacity   | max I(X;Y) over input dist    | [0, 1] for BSC | Communication limit     |
 *
 * ==Interview Tips==
 *
 *  - '''Entropy''' appears in decision tree splitting criteria (ID3, C4.5 use information gain).
 *  - Know that entropy is maximized by the uniform distribution — a common trick question.
 *  - '''Huffman coding''' is a greedy algorithm — understand why greedy works here.
 *  - '''Kraft inequality''' connects to uniquely decodable codes, not just prefix-free.
 *  - '''Mutual information''' is symmetric: I(X;Y) = I(Y;X). Common interview gotcha.
 *  - For '''compression ratio''', the theoretical limit is H(X)/log₂(|alphabet|).
 *  - '''Cross-entropy''' loss in ML is: -Σ y * log(ŷ), directly from information theory.
 *  - The '''20 questions''' game is an application of binary search / entropy: ceil(log₂(n)).
 *
 * ==Complexity Note==
 *
 * Entropy computation is O(n) where n is the number of symbols. Huffman coding
 * is O(n log n) using a priority queue. Mutual information from a joint table
 * is O(|X| * |Y|).
 */
object Logic024_InformationTheory {

  /**
   * Exercise 1: Shannon Entropy
   *
   * Compute the Shannon entropy H(X) = -Σ p_i * log₂(p_i) for a given
   * probability distribution. By convention, 0 * log₂(0) = 0.
   *
   * @param probs a probability distribution (non-negative values summing to 1)
   * @return entropy in bits
   */
  def exercise1_shannonEntropy(probs: List[Double]): Double = ???

  /**
   * Exercise 2: Binary Entropy Function
   *
   * Compute the binary entropy H(p) = -p * log₂(p) - (1-p) * log₂(1-p).
   * H(0) = H(1) = 0 by convention.
   *
   * @param p probability parameter (0 <= p <= 1)
   * @return binary entropy in bits
   */
  def exercise2_binaryEntropy(p: Double): Double = ???

  /**
   * Exercise 3: Huffman Code Lengths
   *
   * Given a map of symbol frequencies, compute the optimal Huffman code lengths.
   * Build a Huffman tree by repeatedly merging the two lowest-frequency nodes,
   * then determine the depth (code length) of each symbol in the tree.
   *
   * @param frequencies map from symbol to its frequency (positive integers)
   * @return map from symbol to its Huffman code length
   */
  def exercise3_huffmanLengths(frequencies: Map[Char, Int]): Map[Char, Int] = ???

  /**
   * Exercise 4: Kraft Inequality Check
   *
   * Verify whether a set of code lengths satisfies the Kraft inequality:
   * Σ 2^(-l_i) <= 1. This is necessary and sufficient for a prefix-free
   * code with those lengths to exist.
   *
   * @param lengths list of code lengths (positive integers)
   * @return true if the Kraft inequality is satisfied
   */
  def exercise4_kraftInequality(lengths: List[Int]): Boolean = ???

  /**
   * Exercise 5: Mutual Information
   *
   * Compute mutual information I(X;Y) = H(X) + H(Y) - H(X,Y) from a joint
   * probability distribution represented as a 2D array. The joint distribution
   * p(x,y) is given; marginals are computed by summing rows/columns.
   *
   * @param joint 2D array representing the joint distribution p(x,y)
   * @return mutual information I(X;Y) in bits
   */
  def exercise5_mutualInformation(joint: Array[Array[Double]]): Double = ???

  /**
   * Exercise 6: Optimal Number of Yes/No Questions
   *
   * Given n equally likely items, compute the minimum number of yes/no
   * questions needed to identify the item. This is ceil(log₂(n)).
   *
   * @param n number of equally likely items (n >= 1)
   * @return minimum number of binary questions
   */
  def exercise6_optimalQuestions(n: Int): Int = ???

  /**
   * Exercise 7: Theoretical Compression Ratio
   *
   * Given a string, compute the ratio of Shannon entropy per character to
   * 8 bits (one byte). This represents the theoretical best compression ratio.
   * First compute the character frequency distribution, then entropy, then
   * divide by 8.
   *
   * @param s input string (non-empty)
   * @return compression ratio (entropy / 8), a value between 0 and 1
   */
  def exercise7_compressionRatio(s: String): Double = ???

  /**
   * Exercise 8: Binary Symmetric Channel Capacity
   *
   * The capacity of a binary symmetric channel with crossover probability p is:
   * C = 1 - H(p), where H(p) is the binary entropy function.
   * C = 0 when p = 0.5 (completely noisy), C = 1 when p = 0 or p = 1 (noiseless).
   *
   * @param p crossover (error) probability (0 <= p <= 1)
   * @return channel capacity in bits per channel use
   */
  def exercise8_channelCapacity(p: Double): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Shannon Entropy
    // Uniform over 2 symbols: H = 1 bit
    assert(math.abs(exercise1_shannonEntropy(List(0.5, 0.5)) - 1.0) < 1e-9)
    // Deterministic: H = 0
    assert(math.abs(exercise1_shannonEntropy(List(1.0, 0.0)) - 0.0) < 1e-9)
    // Uniform over 4 symbols: H = 2 bits
    assert(math.abs(exercise1_shannonEntropy(List(0.25, 0.25, 0.25, 0.25)) - 2.0) < 1e-9)
    // Non-uniform: p = (0.5, 0.25, 0.25) -> H = 0.5*1 + 0.25*2 + 0.25*2 = 1.5
    assert(math.abs(exercise1_shannonEntropy(List(0.5, 0.25, 0.25)) - 1.5) < 1e-9)
    println("Exercise 1 passed: shannonEntropy")

    // Exercise 2: Binary Entropy
    assert(math.abs(exercise2_binaryEntropy(0.5) - 1.0) < 1e-9)
    assert(math.abs(exercise2_binaryEntropy(0.0) - 0.0) < 1e-9)
    assert(math.abs(exercise2_binaryEntropy(1.0) - 0.0) < 1e-9)
    val h025 = -(0.25 * math.log(0.25) + 0.75 * math.log(0.75)) / math.log(2)
    assert(math.abs(exercise2_binaryEntropy(0.25) - h025) < 1e-9)
    println("Exercise 2 passed: binaryEntropy")

    // Exercise 3: Huffman Code Lengths
    // Frequencies: a=5, b=9, c=12, d=13, e=16, f=45
    // Expected Huffman tree lengths: f=1, c=3, d=3, a=4, b=4, e=3
    // (or similar optimal configuration)
    val freqs = Map('a' -> 5, 'b' -> 9, 'c' -> 12, 'd' -> 13, 'e' -> 16, 'f' -> 45)
    val huff = exercise3_huffmanLengths(freqs)
    // Verify Kraft inequality holds for the produced lengths
    val kraftSum = huff.values.map(l => math.pow(2, -l)).sum
    assert(kraftSum <= 1.0 + 1e-9, s"Kraft inequality violated: $kraftSum")
    // Verify that the weighted average code length is optimal (≤ entropy + 1)
    val totalFreq = freqs.values.sum.toDouble
    val avgLen = huff.map { case (c, l) => freqs(c).toDouble / totalFreq * l }.sum
    val entropy = freqs.map { case (_, f) =>
      val p = f / totalFreq
      if (p > 0) -p * math.log(p) / math.log(2) else 0.0
    }.sum
    assert(avgLen >= entropy - 1e-9, "Average code length below entropy")
    assert(avgLen < entropy + 1.0 + 1e-9, "Average code length too high")
    println("Exercise 3 passed: huffmanLengths")

    // Exercise 4: Kraft Inequality
    assert(exercise4_kraftInequality(List(1, 2, 2)) == true)     // 0.5 + 0.25 + 0.25 = 1.0
    assert(exercise4_kraftInequality(List(1, 1, 1)) == false)    // 0.5 + 0.5 + 0.5 = 1.5
    assert(exercise4_kraftInequality(List(2, 2, 2, 2)) == true)  // 4 * 0.25 = 1.0
    assert(exercise4_kraftInequality(List(1, 2, 3, 3)) == true)  // 0.5 + 0.25 + 0.125 + 0.125 = 1.0
    println("Exercise 4 passed: kraftInequality")

    // Exercise 5: Mutual Information
    // Independent variables: I(X;Y) = 0
    val indep = Array(Array(0.25, 0.25), Array(0.25, 0.25))
    assert(math.abs(exercise5_mutualInformation(indep) - 0.0) < 1e-9)
    // Perfectly correlated: joint = ((0.5, 0), (0, 0.5)), I = H(X) = 1 bit
    val corr = Array(Array(0.5, 0.0), Array(0.0, 0.5))
    assert(math.abs(exercise5_mutualInformation(corr) - 1.0) < 1e-9)
    println("Exercise 5 passed: mutualInformation")

    // Exercise 6: Optimal Questions
    assert(exercise6_optimalQuestions(1) == 0)
    assert(exercise6_optimalQuestions(2) == 1)
    assert(exercise6_optimalQuestions(3) == 2)
    assert(exercise6_optimalQuestions(4) == 2)
    assert(exercise6_optimalQuestions(5) == 3)
    assert(exercise6_optimalQuestions(8) == 3)
    assert(exercise6_optimalQuestions(9) == 4)
    assert(exercise6_optimalQuestions(1024) == 10)
    println("Exercise 6 passed: optimalQuestions")

    // Exercise 7: Compression Ratio
    // All same characters: entropy = 0, ratio = 0
    assert(math.abs(exercise7_compressionRatio("aaaa") - 0.0) < 1e-9)
    // Two equally frequent chars: entropy = 1 bit, ratio = 1/8 = 0.125
    assert(math.abs(exercise7_compressionRatio("abab") - 0.125) < 1e-9)
    println("Exercise 7 passed: compressionRatio")

    // Exercise 8: Channel Capacity
    // Noiseless channel: C = 1
    assert(math.abs(exercise8_channelCapacity(0.0) - 1.0) < 1e-9)
    // Completely noisy: C = 0
    assert(math.abs(exercise8_channelCapacity(0.5) - 0.0) < 1e-9)
    // Deterministic flip: C = 1
    assert(math.abs(exercise8_channelCapacity(1.0) - 1.0) < 1e-9)
    // Intermediate: C = 1 - H(0.25)
    val c025 = 1.0 - h025
    assert(math.abs(exercise8_channelCapacity(0.25) - c025) < 1e-9)
    println("Exercise 8 passed: channelCapacity")

    println("\nAll exercises passed!")
  }
}
