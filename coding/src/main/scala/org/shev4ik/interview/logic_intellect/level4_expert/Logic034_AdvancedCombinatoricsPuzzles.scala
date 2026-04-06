package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Olympiad-Level Combinatorics (Олімпіадна комбінаторика)=
 *
 * ==Theory: Prufer Sequences, Hook Lengths, and Enumerative Combinatorics==
 *
 * This module covers advanced enumerative combinatorics topics that appear in
 * mathematical olympiads, competitive programming, and research-level interviews
 * at firms valuing deep mathematical foundations (Jane Street, Google Research,
 * quantitative hedge funds).
 *
 * '''Prufer Sequence:''' A bijection between labeled trees on n vertices and
 * sequences of length n-2 with entries in {1, ..., n}. This proves Cayley's
 * formula: the number of labeled trees on n vertices is n^(n-2).
 * {{{
 *   Encoding: Repeatedly remove the leaf with the smallest label, record
 *             the label of its neighbor. Stop when 2 vertices remain.
 *   Decoding: Reconstruct the tree from the sequence by identifying missing
 *             labels and connecting them in order.
 * }}}
 *
 * '''Cayley's Formula:''' The number of labeled trees on n vertices is exactly
 * n^(n-2). For n=3: 3^1 = 3 trees. For n=4: 4^2 = 16 trees.
 *
 * '''Hook Length Formula:''' For a partition lambda, the number of standard
 * Young tableaux of shape lambda is:
 * {{{
 *   f^lambda = n! / product of hook lengths
 * }}}
 * where the hook length of cell (i,j) is the number of cells directly to the
 * right and directly below, plus 1 (for the cell itself). This formula is central
 * to the representation theory of the symmetric group.
 *
 * '''Chromatic Polynomial:''' P(G, k) counts the number of proper k-colorings
 * of graph G. It is a polynomial in k of degree n (number of vertices).
 * Deletion-contraction recurrence: P(G, k) = P(G-e, k) - P(G/e, k).
 * For a tree on n vertices: P(T, k) = k * (k-1)^(n-1).
 *
 * '''Eulerian Numbers:''' A(n, k) counts permutations of {1,...,n} with exactly
 * k ascents (positions i where sigma(i) < sigma(i+1)). Recurrence:
 * {{{
 *   A(n, k) = (k+1) * A(n-1, k) + (n-k) * A(n-1, k-1)
 *   A(0, 0) = 1, A(n, k) = 0 for k < 0 or k >= n
 * }}}
 *
 * '''Permanent of a Matrix:''' Like the determinant, but with all positive signs:
 * {{{
 *   perm(A) = sum over all permutations sigma of: product A[i][sigma(i)]
 * }}}
 * Computing the permanent is #P-complete (much harder than determinant!).
 * Ryser's formula computes it in O(2^n * n) time.
 *
 * '''Unsigned Stirling Numbers of the First Kind:''' |s(n, k)| counts the number
 * of permutations of n elements with exactly k cycles. Recurrence:
 * {{{
 *   |s(n, k)| = (n-1) * |s(n-1, k)| + |s(n-1, k-1)|
 * }}}
 * Base cases: |s(0, 0)| = 1, |s(n, 0)| = 0 for n > 0, |s(0, k)| = 0 for k > 0.
 *
 * ==Comparison: Enumerative Techniques==
 *
 * | Object              | Count Formula                       | Key Technique                   |
 * |---------------------|-------------------------------------|---------------------------------|
 * | Labeled trees       | n^(n-2) (Cayley)                    | Prufer sequence bijection       |
 * | Standard tableaux   | n! / prod(hooks)                    | Hook length formula             |
 * | Proper colorings    | Chromatic polynomial P(G,k)          | Deletion-contraction            |
 * | Perms w/ k ascents  | Eulerian number A(n,k)              | DP recurrence                   |
 * | Matrix permanent    | Sum over permutations               | Ryser's formula (O(2^n * n))    |
 * | Perms w/ k cycles   | Unsigned Stirling 1st kind |s(n,k)| | DP: insert n into perm of n-1   |
 *
 * ==Interview Tips==
 *
 *  - '''Prufer sequences''' are a beautiful bijective proof — know both encoding
 *    and decoding. They test algorithmic thinking and graph theory.
 *  - '''Hook length formula''' often appears in "counting" interview problems.
 *    Practice drawing the Young diagram and computing hooks.
 *  - '''Chromatic polynomial''' is a staple of graph theory. Know the
 *    deletion-contraction method and special cases (complete graph, tree, cycle).
 *  - '''Eulerian numbers''' connect to sorting, statistics, and generating functions.
 *  - '''Permanent vs determinant:''' Know that permanent is #P-hard and how
 *    Ryser's formula improves over brute force.
 *  - '''Stirling numbers:''' Understand the combinatorial interpretation
 *    (cycles vs subsets for 1st vs 2nd kind).
 *
 * @see [[https://en.wikipedia.org/wiki/Pr%C3%BCfer_sequence Prufer Sequence]]
 * @see [[https://en.wikipedia.org/wiki/Hook_length_formula Hook Length Formula]]
 * @see [[https://en.wikipedia.org/wiki/Chromatic_polynomial Chromatic Polynomial]]
 */
object Logic034_AdvancedCombinatoricsPuzzles {

  /** Exercise 1: Prufer Sequence Encoding
   *
   * Given a labeled tree on vertices {1, ..., n} represented as an edge list,
   * compute its Prufer sequence (length n-2).
   *
   * Algorithm: Repeatedly find the leaf with the smallest label, record the
   * label of its neighbor, and remove the leaf. Stop when 2 vertices remain.
   *
   * @param n number of vertices
   * @param edges list of edges as (u, v) pairs
   * @return Prufer sequence as List[Int]
   */
  def exercise1_pruferEncode(n: Int, edges: List[(Int, Int)]): List[Int] = ???

  /** Exercise 2: Prufer Sequence Decoding
   *
   * Given a Prufer sequence, reconstruct the labeled tree as an edge list.
   *
   * Algorithm: Let seq be the Prufer sequence. The set of labels is {1,...,n}
   * where n = seq.length + 2. Repeatedly find the smallest label NOT in the
   * remaining sequence, connect it to the first element of the sequence,
   * and remove the first element. Connect the last two remaining labels.
   *
   * @param seq Prufer sequence
   * @return list of edges as (Int, Int) pairs
   */
  def exercise2_pruferDecode(seq: List[Int]): List[(Int, Int)] = ???

  /** Exercise 3: Cayley's Formula Verification
   *
   * Verify that the number of labeled trees on n vertices is n^(n-2).
   *
   * @param n number of vertices, n >= 2
   * @return n^(n-2) as BigInt
   */
  def exercise3_cayleyFormula(n: Int): BigInt = ???

  /** Exercise 4: Hook Length Formula
   *
   * Given a partition (e.g., List(4, 3, 1) represents a Young diagram with
   * rows of sizes 4, 3, 1), compute the number of standard Young tableaux
   * using the hook length formula: f^lambda = n! / product(hook lengths).
   *
   * The hook length of cell (i, j) is: (number of cells to the right in row i)
   * + (number of cells below in column j) + 1.
   *
   * @param partition a partition given as a weakly decreasing list of positive integers
   * @return number of standard Young tableaux
   */
  def exercise4_hookLength(partition: List[Int]): BigInt = ???

  /** Exercise 5: Chromatic Polynomial Evaluation
   *
   * Compute the number of proper k-colorings of a graph G.
   * Use deletion-contraction: P(G, k) = P(G-e, k) - P(G/e, k).
   * Base cases: P(empty graph on n vertices, k) = k^n,
   *             P(complete graph K_n, k) = k * (k-1) * ... * (k-n+1).
   *
   * @param n number of vertices (labeled 0 to n-1)
   * @param edges edge list
   * @param k number of colors
   * @return number of proper k-colorings
   */
  def exercise5_chromaticPolynomial(n: Int, edges: List[(Int, Int)], k: Int): BigInt = ???

  /** Exercise 6: Eulerian Numbers
   *
   * Compute A(n, k): the number of permutations of {1,...,n} with exactly
   * k ascents. An ascent is a position i where sigma(i) < sigma(i+1).
   *
   * Recurrence: A(n, k) = (k+1)*A(n-1, k) + (n-k)*A(n-1, k-1)
   * Base: A(0, 0) = 1
   *
   * @param n size of permutation
   * @param k number of ascents
   * @return Eulerian number A(n, k)
   */
  def exercise6_eulerianNumbers(n: Int, k: Int): BigInt = ???

  /** Exercise 7: Permanent of a Matrix
   *
   * Compute the permanent of an n x n integer matrix.
   * perm(A) = sum over all permutations sigma of product(A[i][sigma(i)]).
   *
   * For small n, enumerate all permutations. For larger n (up to ~20),
   * use Ryser's formula with inclusion-exclusion.
   *
   * @param matrix square matrix as List[List[Int]]
   * @return permanent as BigInt
   */
  def exercise7_permanentMatrix(matrix: List[List[Int]]): BigInt = ???

  /** Exercise 8: Unsigned Stirling Numbers of the First Kind
   *
   * Compute |s(n, k)|: the number of permutations of {1,...,n} with exactly k cycles.
   *
   * Recurrence: |s(n, k)| = (n-1) * |s(n-1, k)| + |s(n-1, k-1)|
   * Base: |s(0, 0)| = 1, |s(n, 0)| = 0 for n > 0
   *
   * @param n number of elements
   * @param k number of cycles
   * @return unsigned Stirling number of the first kind
   */
  def exercise8_cyclicPermutations(n: Int, k: Int): BigInt = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Prufer Encoding
    // Tree: 1-2, 1-3, 1-4, 1-5 (star with center 1) -> Prufer sequence: [1, 1, 1]
    val r1 = exercise1_pruferEncode(5, List((1, 2), (1, 3), (1, 4), (1, 5)))
    assert(r1 == List(1, 1, 1), s"Exercise 1 failed: expected List(1,1,1), got $r1")
    println(s"Exercise 1 - Prufer encode star(5): $r1")

    // Exercise 2: Prufer Decoding
    val r2 = exercise2_pruferDecode(List(1, 1, 1))
    assert(r2.length == 4, s"Exercise 2 failed: expected 4 edges, got ${r2.length}")
    println(s"Exercise 2 - Prufer decode [1,1,1]: $r2")

    // Exercise 3: Cayley's Formula
    val r3a = exercise3_cayleyFormula(3)
    assert(r3a == BigInt(3), s"Exercise 3 failed for n=3: expected 3, got $r3a")
    val r3b = exercise3_cayleyFormula(4)
    assert(r3b == BigInt(16), s"Exercise 3 failed for n=4: expected 16, got $r3b")
    val r3c = exercise3_cayleyFormula(5)
    assert(r3c == BigInt(125), s"Exercise 3 failed for n=5: expected 125, got $r3c")
    println(s"Exercise 3 - Cayley's formula: T(3)=$r3a, T(4)=$r3b, T(5)=$r3c")

    // Exercise 4: Hook Length Formula
    // Partition (2,1): 3 cells, hooks are 3,1,1 -> 3!/(3*1*1) = 2
    val r4a = exercise4_hookLength(List(2, 1))
    assert(r4a == BigInt(2), s"Exercise 4 failed for (2,1): expected 2, got $r4a")
    // Partition (3,2): 5 cells -> hooks: (4,3,1,2,1) -> 5!/(4*3*1*2*1) = 120/24 = 5
    val r4b = exercise4_hookLength(List(3, 2))
    assert(r4b == BigInt(5), s"Exercise 4 failed for (3,2): expected 5, got $r4b")
    println(s"Exercise 4 - Hook length: f^(2,1)=$r4a, f^(3,2)=$r4b")

    // Exercise 5: Chromatic Polynomial
    // Triangle (K3): P(K3, 3) = 3*2*1 = 6
    val r5a = exercise5_chromaticPolynomial(3, List((0, 1), (1, 2), (0, 2)), 3)
    assert(r5a == BigInt(6), s"Exercise 5 failed for K3,k=3: expected 6, got $r5a")
    // Path 0-1-2: P = k*(k-1)^2 = 3*4 = 12 for k=3
    val r5b = exercise5_chromaticPolynomial(3, List((0, 1), (1, 2)), 3)
    assert(r5b == BigInt(12), s"Exercise 5 failed for path,k=3: expected 12, got $r5b")
    println(s"Exercise 5 - Chromatic polynomial: P(K3,3)=$r5a, P(path3,3)=$r5b")

    // Exercise 6: Eulerian Numbers
    // A(3, 1) = 4 (permutations of {1,2,3} with exactly 1 ascent: 132, 213, 231, 312)
    val r6a = exercise6_eulerianNumbers(3, 1)
    assert(r6a == BigInt(4), s"Exercise 6 failed: A(3,1) should be 4, got $r6a")
    val r6b = exercise6_eulerianNumbers(4, 2)
    assert(r6b == BigInt(11), s"Exercise 6 failed: A(4,2) should be 11, got $r6b")
    println(s"Exercise 6 - Eulerian numbers: A(3,1)=$r6a, A(4,2)=$r6b")

    // Exercise 7: Permanent
    // Identity matrix: perm = 1
    val r7a = exercise7_permanentMatrix(List(List(1, 0), List(0, 1)))
    assert(r7a == BigInt(1), s"Exercise 7 failed for I2: expected 1, got $r7a")
    // All-ones 3x3: perm = 3! = 6
    val r7b = exercise7_permanentMatrix(List(List(1, 1, 1), List(1, 1, 1), List(1, 1, 1)))
    assert(r7b == BigInt(6), s"Exercise 7 failed for J3: expected 6, got $r7b")
    println(s"Exercise 7 - Permanent: perm(I2)=$r7a, perm(J3)=$r7b")

    // Exercise 8: Stirling Numbers (1st kind, unsigned)
    // |s(3, 1)| = 2 (two permutations of 3 elements with 1 cycle: (123) and (132))
    val r8a = exercise8_cyclicPermutations(3, 1)
    assert(r8a == BigInt(2), s"Exercise 8 failed: |s(3,1)| should be 2, got $r8a")
    // |s(4, 2)| = 11
    val r8b = exercise8_cyclicPermutations(4, 2)
    assert(r8b == BigInt(11), s"Exercise 8 failed: |s(4,2)| should be 11, got $r8b")
    // |s(4, 1)| = 6
    val r8c = exercise8_cyclicPermutations(4, 1)
    assert(r8c == BigInt(6), s"Exercise 8 failed: |s(4,1)| should be 6, got $r8c")
    println(s"Exercise 8 - Stirling 1st kind: |s(3,1)|=$r8a, |s(4,2)|=$r8b, |s(4,1)|=$r8c")

    println("\nAll Advanced Combinatorics exercises passed!")
  }
}
