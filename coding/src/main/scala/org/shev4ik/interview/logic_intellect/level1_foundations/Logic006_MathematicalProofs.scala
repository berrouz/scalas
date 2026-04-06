package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Mathematical Proofs as Algorithms=
 *
 * ==Theory: Proof Techniques in Computer Science==
 *
 * Mathematical proofs are not just abstract exercises -- they are the backbone of algorithm
 * correctness. Every loop invariant, every recursive argument, every complexity bound relies
 * on a proof technique. Understanding these techniques makes you a better algorithm designer
 * and a more convincing interviewer.
 *
 * ==Proof by Induction==
 *
 * The workhorse of algorithm correctness proofs. The structure mirrors recursion:
 *
 *  - '''Base case:''' Prove the statement holds for the smallest input (n = 0 or n = 1).
 *  - '''Inductive step:''' Assume it holds for n = k (the ''inductive hypothesis''),
 *    then prove it holds for n = k + 1.
 *
 * {{{
 * // Example: prove sum(1..n) = n*(n+1)/2
 * // Base: n=1 => 1 = 1*2/2 = 1  ✓
 * // Step: assume sum(1..k) = k*(k+1)/2
 * //       sum(1..k+1) = k*(k+1)/2 + (k+1) = (k+1)*(k+2)/2  ✓
 * }}}
 *
 * '''Strong induction''' assumes the statement holds for ALL values up to k (not just k).
 * This is needed for proofs like the Fundamental Theorem of Arithmetic (prime factorization).
 *
 * ==Proof by Contradiction==
 *
 * Assume the negation of what you want to prove, then derive a logical impossibility.
 * Classic example: proving sqrt(2) is irrational.
 *
 * {{{
 * // Assume sqrt(2) = p/q in lowest terms (gcd(p,q) = 1)
 * // Then p^2 = 2*q^2, so p^2 is even, so p is even, say p = 2k
 * // Then 4k^2 = 2*q^2, so q^2 = 2k^2, so q is even
 * // But both p and q are even contradicts gcd(p,q) = 1  ✗
 * }}}
 *
 * ==Loop Invariants==
 *
 * A loop invariant is a property that holds before and after each iteration.
 * To prove an algorithm correct using invariants:
 *
 *  1. '''Initialization:''' The invariant holds before the first iteration.
 *  2. '''Maintenance:''' If it holds before iteration i, it holds after iteration i.
 *  3. '''Termination:''' When the loop ends, the invariant gives us the desired result.
 *
 * This is essentially induction applied to loops.
 *
 * ==Parity Arguments==
 *
 * Parity (odd/even) arguments are powerful for impossibility proofs. The mutilated
 * chessboard problem is a classic: removing two same-color corners makes tiling with
 * dominoes impossible because each domino must cover one black and one white square.
 *
 * ==Constructive vs. Non-Constructive Proofs==
 *
 *  - '''Constructive:''' Explicitly build the object whose existence you claim.
 *    Preferred in CS because the proof IS the algorithm.
 *  - '''Non-constructive:''' Show existence without building it (e.g., pigeonhole).
 *
 * ==Well-Ordering Principle==
 *
 * Every non-empty set of positive integers has a least element. This is equivalent
 * to the principle of mathematical induction and is used in proofs about the integers.
 *
 * ==Interview Tips==
 *
 *  - When asked "prove your algorithm is correct," use '''loop invariants''' or '''induction'''.
 *  - When asked "is this possible?", consider '''parity''' or '''invariant''' arguments.
 *  - '''Contradiction''' is useful for proving impossibility or uniqueness.
 *  - Always state your inductive hypothesis clearly and separately.
 *  - Constructive proofs are more valuable in interviews: they give the algorithm directly.
 *
 * ==Comparison: Proof Techniques==
 *
 * | Technique          | When to Use                        | Algorithm Analog          |
 * |--------------------|------------------------------------|---------------------------|
 * | Induction          | Recursive correctness              | Recursive algorithms      |
 * | Strong Induction   | Depends on multiple prior values   | Dynamic programming       |
 * | Contradiction      | Impossibility / uniqueness         | Lower bounds              |
 * | Invariant          | Loop correctness                   | Iterative algorithms      |
 * | Parity             | Tiling, coloring problems          | Graph coloring            |
 * | Constructive       | "Find such an X"                   | The algorithm itself      |
 * | Well-ordering      | Minimal counterexample             | Greedy correctness        |
 */
object Logic006_MathematicalProofs {

  // TODO: Verify the formula sum(1 + 2 + ... + n) = n * (n + 1) / 2 for a given n.
  // Compute the actual sum iteratively and compare with the formula.
  // Example: n = 100 => true
  def exercise1_sumFormula(n: Int): Boolean = ???

  // TODO: Compute the sum of the first n odd numbers (1 + 3 + 5 + ... + (2n-1))
  // and verify it equals n^2.
  // Return a tuple of (the computed sum, whether sum == n*n).
  // Example: n = 5 => (25, true)
  def exercise2_inductiveProof(n: Int): (Int, Boolean) = ???

  // TODO: Check if coprime integers p, q satisfy p^2 = 2 * q^2.
  // In a proof by contradiction of sqrt(2)'s irrationality, we assume p/q is in lowest
  // terms, so gcd(p,q) = 1. If p^2 = 2*q^2, both p and q must be even -- contradiction.
  // Return true only if gcd(p,q) == 1 AND p*p == 2*q*q (which should be impossible).
  // Example: (3, 2) => false, (2, 1) => false (gcd=1 but 4 != 2)
  def exercise3_contradiction(p: Int, q: Int): Boolean = ???

  // TODO: Simulate a process: given a list of numbers, repeatedly replace the first two
  // elements a, b with (a + b - 1) until one element remains.
  // Verify the invariant: sum(list) - (list.length - 1) remains constant throughout.
  // Return true if the invariant held at every step.
  // Example: List(3, 5, 7, 2) => true
  def exercise4_invariant(numbers: List[Int]): Boolean = ???

  // TODO: Determine if a mutilated chessboard (8x8 with two diagonally opposite corners
  // removed) can be tiled with dominoes. Each domino covers exactly one white and one
  // black square. The two removed corners are the same color, so the remaining board
  // has unequal numbers of black and white squares.
  // Return false (it is impossible due to parity).
  def exercise5_parityArgument: Boolean = ???

  // TODO: Find the prime factorization of n (n >= 2) using strong induction reasoning.
  // Return the sorted list of prime factors (with repetition).
  // Example: 12 => List(2, 2, 3), 7 => List(7), 100 => List(2, 2, 5, 5)
  def exercise6_strongInduction(n: Int): List[Int] = ???

  // TODO: Given a non-empty set of positive integers, find the smallest element.
  // This demonstrates the well-ordering principle: every non-empty subset of positive
  // integers has a least element.
  // Example: Set(5, 3, 8, 1, 4) => 1
  def exercise7_wellordering(s: Set[Int]): Int = ???

  // TODO: For any n >= 8, find non-negative integers a, b such that n = 3*a + 5*b.
  // This is a constructive proof: we don't just say it exists, we find it.
  // If no solution exists (n < 8 and not representable), return (-1, -1).
  // Example: n = 8 => (1, 1), n = 11 => (2, 1), n = 14 => (3, 1) or (0, 2) + ...
  def exercise8_constructiveProof(n: Int): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: sumFormula
    assert(exercise1_sumFormula(1) == true)
    assert(exercise1_sumFormula(100) == true)
    assert(exercise1_sumFormula(1000) == true)
    println("Exercise 1 passed: exercise1_sumFormula")

    // Exercise 2: inductiveProof
    assert(exercise2_inductiveProof(1) == (1, true))
    assert(exercise2_inductiveProof(5) == (25, true))
    assert(exercise2_inductiveProof(10) == (100, true))
    println("Exercise 2 passed: exercise2_inductiveProof")

    // Exercise 3: contradiction
    assert(exercise3_contradiction(3, 2) == false)
    assert(exercise3_contradiction(2, 1) == false)
    assert(exercise3_contradiction(7, 5) == false)
    assert(exercise3_contradiction(4, 2) == false) // gcd != 1
    println("Exercise 3 passed: exercise3_contradiction")

    // Exercise 4: invariant
    assert(exercise4_invariant(List(3, 5, 7, 2)) == true)
    assert(exercise4_invariant(List(1, 1, 1, 1)) == true)
    assert(exercise4_invariant(List(10)) == true)
    println("Exercise 4 passed: exercise4_invariant")

    // Exercise 5: parityArgument
    assert(exercise5_parityArgument == false)
    println("Exercise 5 passed: exercise5_parityArgument")

    // Exercise 6: strongInduction
    assert(exercise6_strongInduction(2) == List(2))
    assert(exercise6_strongInduction(12) == List(2, 2, 3))
    assert(exercise6_strongInduction(7) == List(7))
    assert(exercise6_strongInduction(100) == List(2, 2, 5, 5))
    println("Exercise 6 passed: exercise6_strongInduction")

    // Exercise 7: wellordering
    assert(exercise7_wellordering(Set(5, 3, 8, 1, 4)) == 1)
    assert(exercise7_wellordering(Set(42)) == 42)
    assert(exercise7_wellordering(Set(10, 20, 30)) == 10)
    println("Exercise 7 passed: exercise7_wellordering")

    // Exercise 8: constructiveProof
    val (a8, b8) = exercise8_constructiveProof(8)
    assert(a8 >= 0 && b8 >= 0 && 3 * a8 + 5 * b8 == 8)
    val (a11, b11) = exercise8_constructiveProof(11)
    assert(a11 >= 0 && b11 >= 0 && 3 * a11 + 5 * b11 == 11)
    val (a14, b14) = exercise8_constructiveProof(14)
    assert(a14 >= 0 && b14 >= 0 && 3 * a14 + 5 * b14 == 14)
    assert(exercise8_constructiveProof(1) == (-1, -1))
    println("Exercise 8 passed: exercise8_constructiveProof")

    println("All Logic006_MathematicalProofs exercises passed!")
  }
}
