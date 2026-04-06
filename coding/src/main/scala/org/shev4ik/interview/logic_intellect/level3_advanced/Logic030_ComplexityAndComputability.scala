package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Complexity Theory and Computability (Теорія складності та обчислюваність)=
 *
 * ==Theory: Understanding Computational Limits==
 *
 * Complexity theory classifies problems by the resources (time, space) required
 * to solve them. Computability theory asks which problems can be solved at all.
 *
 * '''The Halting Problem:''' Given a program P and input I, can we determine
 * whether P(I) halts? Alan Turing proved this is undecidable (1936) using a
 * diagonal argument:
 * {{{
 *   Assume H(P, I) decides halting. Define D(P) = if H(P,P) then loop else halt.
 *   D(D) halts iff H(D,D) = false iff D(D) loops. Contradiction!
 * }}}
 *
 * '''P vs NP:''' P = problems solvable in polynomial time. NP = problems whose
 * solutions are verifiable in polynomial time. The P vs NP question asks whether
 * P = NP. Most experts believe P != NP, but it remains the most important open
 * problem in theoretical CS (Clay Millennium Prize).
 *
 * '''NP-Completeness:''' A problem X is NP-complete if:
 *  1. X is in NP (solutions verifiable in poly time)
 *  2. Every NP problem reduces to X in poly time
 * The Cook-Levin theorem (1971) proved SAT is NP-complete. Many reductions:
 * {{{
 *   SAT -> 3-SAT -> Vertex Cover -> Independent Set -> Clique
 *   SAT -> 3-SAT -> Subset Sum -> Knapsack
 *   SAT -> 3-SAT -> Hamiltonian Path -> TSP
 * }}}
 *
 * '''Amortized Analysis:''' Averages the cost of operations over a worst-case
 * sequence, not over random inputs. Key techniques:
 *  - '''Aggregate method:''' Total cost of n ops / n
 *  - '''Accounting method:''' Assign amortized costs; bank excess for expensive ops
 *  - '''Potential method:''' Define potential function Phi; amortized = actual + Delta(Phi)
 *
 * '''Reduction Arguments:''' To prove problem A is at least as hard as problem B:
 *  - Show a polynomial-time transformation from B instances to A instances
 *  - If B is NP-hard, then A is NP-hard
 *  - Direction matters: reduce FROM the known-hard problem TO the new problem
 *
 * '''Rice's Theorem:''' Every non-trivial semantic property of programs is
 * undecidable. A property is "non-trivial" if some programs have it and some
 * don't. Examples: "does program P ever print 42?", "does P compute a total
 * function?", "is P's output always positive?".
 *
 * ==Comparison: Complexity Classes==
 *
 * | Class      | Definition                          | Examples                  |
 * |------------|-------------------------------------|---------------------------|
 * | P          | Solvable in O(n^k) time             | Sorting, MST, Matching    |
 * | NP         | Verifiable in O(n^k) time           | SAT, Clique, Subset Sum   |
 * | NP-Complete| Hardest problems in NP              | 3-SAT, Vertex Cover, TSP  |
 * | NP-Hard    | At least as hard as NP-complete     | Halting, Optimization TSP |
 * | PSPACE     | Solvable with polynomial space      | QBF, Generalized chess    |
 * | Undecidable| No algorithm exists                 | Halting problem           |
 *
 * ==Interview Tips==
 *
 *  - '''P vs NP:''' Know the definitions cold. P is in NP (trivially). The question
 *    is whether NP is in P. Most believe no.
 *  - '''NP-completeness reductions''' always go FROM known NP-complete TO new
 *    problem. Getting the direction wrong is a common interview mistake.
 *  - '''Amortized analysis''' is different from average-case analysis. Amortized
 *    guarantees worst-case total, not expected behavior.
 *  - Know the classic '''NP-complete problems''' and their relationships.
 *  - '''Halting problem''' is the go-to example for undecidability. Know the
 *    diagonal argument proof sketch.
 *  - '''Rice's theorem''' tells us we cannot build a perfect static analyzer.
 *    Any interesting program property is undecidable in general.
 *  - Dynamic arrays (ArrayList) have O(1) amortized append because doubling
 *    spreads the O(n) copy cost over n/2 prior O(1) inserts.
 *
 * ==Complexity Note==
 *
 * The exercises here verify properties and simulate computations. Verification
 * is typically O(n) or O(n^2). The theoretical questions return explanatory
 * strings or demonstrate concepts on small instances.
 */
object Logic030_ComplexityAndComputability {

  /**
   * Exercise 1: Halting Problem — Diagonal Argument
   *
   * Explain the diagonal argument for the undecidability of the halting problem.
   * Return a string with the key steps of the proof by contradiction:
   * 1. Assume a decider H(P, I) exists
   * 2. Construct D(P) that does the opposite of H(P, P)
   * 3. Ask what D(D) does — leads to contradiction
   *
   * @return a string explaining the diagonal argument (at least 3 sentences)
   */
  def exercise1_haltingArgument: String = ???

  /**
   * Exercise 2: SAT Verification (NP Witness)
   *
   * Show that SAT is in NP by verifying a given truth assignment against
   * a set of clauses in polynomial time. Each clause is a list of literals
   * (positive int = variable true, negative int = variable false).
   * The formula is satisfiable if all clauses have at least one true literal.
   *
   * @param clauses    list of clauses, each clause is a list of literals
   * @param assignment map from variable number to its truth value
   * @return true if the assignment satisfies all clauses
   */
  def exercise2_reductionSAT(clauses: List[List[Int]], assignment: Map[Int, Boolean]): Boolean = ???

  /**
   * Exercise 3: Subset Sum Verification
   *
   * Given a set of integers and a target sum, verify that a proposed subset
   * sums to the target. This is the NP verification step — runs in O(n).
   *
   * @param numbers  the full set of numbers
   * @param subset   indices of the proposed subset
   * @param target   the target sum
   * @return true if the subset sums to target
   */
  def exercise3_verifySolution(numbers: List[Int], subset: List[Int], target: Int): Boolean = ???

  /**
   * Exercise 4: Dynamic Array Amortized Analysis
   *
   * Simulate n insertions into a dynamic array that doubles when full.
   * Start with capacity 1. Track:
   *  - Actual total cost: 1 per insertion + size at doubling when array is full
   *  - Amortized total cost: 2 per insertion (accounting method)
   *
   * Return (total actual cost, total amortized cost).
   *
   * @param n number of insertions
   * @return (total actual cost, total amortized cost = 2 * n)
   */
  def exercise4_amortizedDynamic(n: Int): (Int, Int) = ???

  /**
   * Exercise 5: Classify Time Complexity
   *
   * Given a description of an algorithm's behavior, classify its time complexity.
   * Input is a string like "binary_search", "bubble_sort", "hash_lookup",
   * "merge_sort", "power_set", "linear_scan".
   *
   * Return the complexity class as a string: "O(1)", "O(log n)", "O(n)",
   * "O(n log n)", "O(n^2)", "O(2^n)".
   *
   * @param algorithm name/description of the algorithm
   * @return the time complexity class as a string
   */
  def exercise5_complexityClass(algorithm: String): String = ???

  /**
   * Exercise 6: Vertex Cover to Independent Set Reduction
   *
   * Verify the reduction: a graph G has a vertex cover of size k if and only if
   * it has an independent set of size n - k (where n = number of vertices).
   *
   * Given an adjacency list, a proposed vertex cover, and a proposed independent
   * set, verify that:
   *  1. The vertex cover covers all edges
   *  2. The independent set has no edges between its members
   *  3. VC size + IS size = n
   *
   * @param edges    list of edges (pairs of vertices)
   * @param n        number of vertices (0 to n-1)
   * @param vc       proposed vertex cover (set of vertices)
   * @param is_      proposed independent set (set of vertices)
   * @return true if both are valid and complementary
   */
  def exercise6_polynomialReduction(edges: List[(Int, Int)], n: Int, vc: Set[Int], is_ : Set[Int]): Boolean = ???

  /**
   * Exercise 7: Amortized Stack with Multipop
   *
   * A stack supports push (cost 1) and multipop(k) which pops min(k, size)
   * elements (cost = number popped). Using the potential method with
   * Phi = stack size, the amortized cost of each operation is O(1):
   *  - push: actual 1 + Delta(Phi) = 1 + 1 = 2
   *  - multipop(k): actual k + Delta(Phi) = k + (-k) = 0
   *
   * Simulate a sequence of operations and return the amortized cost per operation.
   * Operations: positive int = push, negative int = multipop(|val|).
   *
   * @param operations sequence of operations (positive = push, negative = multipop)
   * @return average amortized cost per operation (should be <= 2.0)
   */
  def exercise7_amortizedStack(operations: List[Int]): Double = ???

  /**
   * Exercise 8: Rice's Theorem — Undecidable Properties
   *
   * Rice's theorem states that every non-trivial property of the language
   * recognized by a Turing machine is undecidable. Return an example of
   * such a property as a descriptive string.
   *
   * A property is non-trivial if some TMs have it and some don't.
   * Examples: "The program outputs an even number", "The program halts on
   * empty input", "The program recognizes a finite language".
   *
   * @return a string describing an undecidable property of programs
   */
  def exercise8_riceTheorem: String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Halting Argument
    val halting = exercise1_haltingArgument
    assert(halting.nonEmpty && halting.length > 50, "Explanation too short")
    assert(halting.toLowerCase.contains("contradict") || halting.toLowerCase.contains("contradiction"),
      "Should mention contradiction")
    println("Exercise 1 passed: haltingArgument")

    // Exercise 2: SAT Verification
    // (x1 OR x2) AND (NOT x1 OR x3) AND (NOT x2 OR NOT x3)
    val clauses = List(List(1, 2), List(-1, 3), List(-2, -3))
    val goodAssignment = Map(1 -> true, 2 -> false, 3 -> true) // satisfies all
    assert(exercise2_reductionSAT(clauses, goodAssignment))
    val badAssignment = Map(1 -> true, 2 -> true, 3 -> true) // fails clause 3
    assert(!exercise2_reductionSAT(clauses, badAssignment))
    println("Exercise 2 passed: reductionSAT")

    // Exercise 3: Subset Sum Verification
    val numbers = List(3, 7, 1, 8, -2, 5)
    assert(exercise3_verifySolution(numbers, List(0, 2, 5), 9))   // 3 + 1 + 5 = 9
    assert(!exercise3_verifySolution(numbers, List(0, 1), 9))      // 3 + 7 = 10 != 9
    assert(exercise3_verifySolution(numbers, List(1, 4), 5))       // 7 + (-2) = 5
    println("Exercise 3 passed: verifySolution")

    // Exercise 4: Amortized Dynamic Array
    val (actual1, amortized1) = exercise4_amortizedDynamic(1)
    assert(actual1 == 1 && amortized1 == 2, s"n=1: actual=$actual1, amortized=$amortized1")
    val (actual8, amortized8) = exercise4_amortizedDynamic(8)
    assert(amortized8 == 16, s"n=8: amortized should be 16, got $amortized8")
    assert(actual8 <= amortized8, s"Actual $actual8 should be <= amortized $amortized8")
    println("Exercise 4 passed: amortizedDynamic")

    // Exercise 5: Complexity Classification
    assert(exercise5_complexityClass("binary_search") == "O(log n)")
    assert(exercise5_complexityClass("bubble_sort") == "O(n^2)")
    assert(exercise5_complexityClass("hash_lookup") == "O(1)")
    assert(exercise5_complexityClass("merge_sort") == "O(n log n)")
    assert(exercise5_complexityClass("power_set") == "O(2^n)")
    assert(exercise5_complexityClass("linear_scan") == "O(n)")
    println("Exercise 5 passed: complexityClass")

    // Exercise 6: Vertex Cover <-> Independent Set
    // Triangle graph: 0-1, 1-2, 0-2
    val edges = List((0, 1), (1, 2), (0, 2))
    assert(exercise6_polynomialReduction(edges, 3, Set(0, 1), Set(2)))
    assert(!exercise6_polynomialReduction(edges, 3, Set(0), Set(1, 2))) // VC doesn't cover edge 1-2
    println("Exercise 6 passed: polynomialReduction")

    // Exercise 7: Amortized Stack
    // Push 5 times, multipop 3, push 2 times = 8 operations
    val ops = List(1, 1, 1, 1, 1, -3, 1, 1)
    val amortizedCost = exercise7_amortizedStack(ops)
    assert(amortizedCost <= 2.0 + 1e-9, s"Amortized cost should be <= 2, got $amortizedCost")
    assert(amortizedCost > 0, s"Amortized cost should be > 0, got $amortizedCost")
    println("Exercise 7 passed: amortizedStack")

    // Exercise 8: Rice's Theorem
    val rice = exercise8_riceTheorem
    assert(rice.nonEmpty && rice.length > 10, "Should return a meaningful property description")
    println("Exercise 8 passed: riceTheorem")

    println("\nAll exercises passed!")
  }
}
