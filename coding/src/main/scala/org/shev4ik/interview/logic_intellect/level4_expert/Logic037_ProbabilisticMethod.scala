package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =The Probabilistic Method (Імовірнісний метод)=
 *
 * ==Theory: Proving Existence Without Construction==
 *
 * The probabilistic method, pioneered by Paul Erdős, is a non-constructive
 * technique for proving the existence of combinatorial objects. The key idea:
 * if a randomly chosen object has the desired property with positive
 * probability, then such an object must exist.
 *
 * '''Basic Counting / First Moment Method:''' If the expected value of a
 * random variable X is E[X], then there exists an outcome where X >= E[X]
 * and an outcome where X <= E[X]. This seemingly trivial observation is
 * remarkably powerful.
 *
 * '''Ramsey Number Lower Bound:''' Erdős proved R(k,k) > 2^(k/2) by showing
 * that a random 2-coloring of K_n has positive probability of having no
 * monochromatic k-clique when n is small enough. Expected monochromatic
 * k-cliques = C(n,k) * 2^(1 - C(k,2)). If this < 1, a good coloring exists.
 *
 * '''Lovász Local Lemma (LLL):''' When bad events are "mostly independent,"
 * all can be simultaneously avoided. Symmetric form: if each bad event has
 * probability at most p and depends on at most d other events, and
 * ep(d + 1) ≤ 1, then with positive probability none occur.
 *
 * '''Random Graphs G(n,p):''' Erdős–Rényi model: each edge present
 * independently with probability p. Sharp thresholds exist for many properties.
 * Connectivity threshold: p = ln(n) / n. Giant component: p = 1/n.
 *
 * '''Max Cut:''' A random partition of vertices gives expected cut size m/2
 * (each edge crosses with probability 1/2). So max cut ≥ m/2. This is the
 * basis of the 0.5-approximation, improved to 0.878 by Goemans–Williamson.
 *
 * '''Derandomization — Method of Conditional Expectations:''' Convert a
 * probabilistic proof into a deterministic algorithm. Process random choices
 * one at a time, always picking the option that maintains or improves the
 * conditional expectation.
 *
 * ==Comparison: Probabilistic Techniques==
 *
 * | Technique                | Core Idea                            | Application Example           |
 * |--------------------------|--------------------------------------|-------------------------------|
 * | First Moment             | E[X] > 0 ⟹ X > 0 somewhere         | Ramsey lower bounds           |
 * | Second Moment            | Var[X] small ⟹ X ≈ E[X] likely      | Threshold phenomena           |
 * | Lovász Local Lemma       | Sparse dependency ⟹ avoid all bad    | k-SAT, hypergraph coloring    |
 * | Alteration               | Random + fix violations              | Independent sets              |
 * | Conditional Expectations | Derandomize by greedy choices        | Max-Cut approximation         |
 * | Random Graphs G(n,p)     | Threshold functions for properties   | Connectivity, Hamiltonicity   |
 *
 * ==Interview Tips==
 *
 *  - The '''probabilistic method''' is rarely coded in interviews, but the
 *    reasoning pattern (expectation arguments) appears in approximation problems.
 *  - '''Max cut ≥ m/2''' is a classic interview question for algorithm design courses.
 *  - '''Conditional expectations''' is the go-to derandomization technique.
 *  - Know that '''Ramsey numbers''' grow exponentially; only small values are known exactly.
 *  - '''LLL''' is advanced but appears in theoretical CS interviews (Google Research, MSR).
 *  - For random graphs, remember: connectivity threshold is '''ln(n)/n'''.
 *
 * ==Complexity Note==
 *
 * Probabilistic arguments often yield polynomial-time algorithms after
 * derandomization. The method of conditional expectations runs in O(n * cost_per_step).
 * Computing Ramsey bounds is O(C(n,k)) for enumeration-based approaches.
 */
object Logic037_ProbabilisticMethod {

  /**
   * Exercise 1: Ramsey Lower Bound
   *
   * The probabilistic method shows R(k,k) > n when C(n,k) * 2^(1-C(k,2)) < 1.
   * The classic bound is R(k,k) > 2^(k/2) (more precisely, floor(2^((k-1)/2))).
   * Compute this lower bound for a given k.
   *
   * @param k clique size (k >= 2)
   * @return lower bound on R(k,k) as BigInt
   */
  def exercise1_ramseyLowerBound(k: Int): BigInt = ???

  /**
   * Exercise 2: Expected Monochromatic Cliques
   *
   * In a random 2-coloring of K_n (each edge red or blue independently with
   * probability 1/2), the expected number of monochromatic k-cliques is:
   *   2 * C(n, k) * (1/2)^C(k,2) = C(n, k) * 2^(1 - C(k,2))
   *
   * @param n number of vertices
   * @param k clique size
   * @return expected number of monochromatic k-cliques
   */
  def exercise2_expectedColorings(n: Int, k: Int): Double = ???

  /**
   * Exercise 3: Tournament Hamiltonian Path Bound
   *
   * A tournament is a complete directed graph (every pair has exactly one
   * directed edge). The expected number of Hamiltonian paths in a random
   * tournament on n vertices is n! / 2^(n-1), since each of the n!
   * orderings is a Hamiltonian path with probability (1/2)^(n-1).
   *
   * @param n number of vertices (n >= 2)
   * @return the expected number of Hamiltonian paths (as Double)
   */
  def exercise3_tournamentProperty(n: Int): Double = ???

  /**
   * Exercise 4: Random Graph Connectivity Threshold
   *
   * In the Erdős–Rényi model G(n, p), the sharp threshold for connectivity
   * is p = ln(n) / n. Below this, the graph is almost surely disconnected;
   * above, almost surely connected. Return this threshold.
   *
   * @param n number of vertices
   * @return the connectivity threshold p = ln(n) / n
   */
  def exercise4_randomGraphThreshold(n: Int): Double = ???

  /**
   * Exercise 5: Max Cut Random Lower Bound
   *
   * A random partition of vertices assigns each vertex to one of two sets
   * with equal probability. Each edge crosses the cut with probability 1/2,
   * so the expected cut size is m/2. Therefore max cut >= ceil(m/2).
   *
   * @param m number of edges in the graph
   * @return guaranteed lower bound on max cut size
   */
  def exercise5_maxCutRandom(m: Int): Int = ???

  /**
   * Exercise 6: Independent Set Bound
   *
   * In a graph with n vertices and m edges (average degree d = 2m/n),
   * the probabilistic method (random subset with probability 1/(d+1))
   * guarantees an independent set of size at least n / (d + 1).
   * More precisely, floor(n / (d + 1)) where d = 2m/n.
   *
   * @param n number of vertices
   * @param m number of edges
   * @return lower bound on maximum independent set size
   */
  def exercise6_independentSetBound(n: Int, m: Int): Int = ???

  /**
   * Exercise 7: Lovász Local Lemma Check
   *
   * The symmetric form of LLL: if each bad event has probability at most p,
   * and each event is mutually independent of all but at most d other events,
   * and e * p * (d + 1) <= 1, then there is positive probability that none
   * of the bad events occur. Check whether this condition holds.
   *
   * @param p probability of each bad event
   * @param d maximum dependency degree
   * @return true if the LLL condition ep(d+1) <= 1 is satisfied
   */
  def exercise7_lovaszLocalLemma(p: Double, d: Int): Boolean = ???

  /**
   * Exercise 8: Derandomized Max Cut
   *
   * Method of conditional expectations: given an adjacency list representation
   * of a graph, greedily assign each vertex to the side (A or B) that
   * maximizes the number of edges crossing the cut so far. This deterministic
   * algorithm achieves cut size >= m/2.
   *
   * @param n     number of vertices (0-indexed)
   * @param edges list of (u, v) edges
   * @return the number of edges in the cut produced by the greedy algorithm
   */
  def exercise8_derandomization(n: Int, edges: List[(Int, Int)]): Int = ???

  def main(args: Array[String]): Unit = {

    // Exercise 1: Ramsey Lower Bound
    val r4 = exercise1_ramseyLowerBound(4)
    assert(r4 >= BigInt(2), s"R(4,4) lower bound should be >= 2, got $r4")
    println(s"Exercise 1 - Ramsey lower bound R(4,4) > $r4")

    val r6 = exercise1_ramseyLowerBound(6)
    assert(r6 >= BigInt(5), s"R(6,6) lower bound should be >= 5, got $r6")
    println(s"Exercise 1 - Ramsey lower bound R(6,6) > $r6")

    // Exercise 2: Expected Monochromatic Cliques
    val exp6_3 = exercise2_expectedColorings(6, 3)
    // C(6,3) = 20, C(3,2) = 3, result = 20 * 2^(1-3) = 20 * 0.25 = 5.0
    assert(math.abs(exp6_3 - 5.0) < 0.01, s"Expected monochromatic 3-cliques in K6 should be 5.0, got $exp6_3")
    println(s"Exercise 2 - Expected monochromatic 3-cliques in K6: $exp6_3")

    // Exercise 3: Tournament Hamiltonian Paths
    val th4 = exercise3_tournamentProperty(4)
    // 4! / 2^3 = 24 / 8 = 3.0
    assert(math.abs(th4 - 3.0) < 0.01, s"Expected Hamiltonian paths in tournament on 4: should be 3.0, got $th4")
    println(s"Exercise 3 - Expected Hamiltonian paths (n=4): $th4")

    // Exercise 4: Random Graph Threshold
    val threshold100 = exercise4_randomGraphThreshold(100)
    assert(math.abs(threshold100 - math.log(100) / 100.0) < 0.001,
      s"Threshold for n=100 should be ~${math.log(100) / 100.0}, got $threshold100")
    println(s"Exercise 4 - Connectivity threshold G(100,p): $threshold100")

    // Exercise 5: Max Cut Lower Bound
    assert(exercise5_maxCutRandom(10) == 5, "Max cut lower bound for 10 edges should be 5")
    assert(exercise5_maxCutRandom(7) == 4, "Max cut lower bound for 7 edges should be 4 (ceil(7/2))")
    println(s"Exercise 5 - Max cut lower bound (m=10): ${exercise5_maxCutRandom(10)}")
    println(s"Exercise 5 - Max cut lower bound (m=7): ${exercise5_maxCutRandom(7)}")

    // Exercise 6: Independent Set Bound
    // n=10, m=15, d = 30/10 = 3.0, bound = floor(10/4) = 2
    val isb = exercise6_independentSetBound(10, 15)
    assert(isb == 2, s"Independent set bound for n=10, m=15 should be 2, got $isb")
    println(s"Exercise 6 - Independent set bound (n=10, m=15): $isb")

    // Exercise 7: Lovász Local Lemma
    // e * 0.1 * (3+1) = 2.718... * 0.4 = 1.087... > 1 => false
    assert(exercise7_lovaszLocalLemma(0.1, 3) == false, "LLL: e*0.1*4 > 1, should be false")
    // e * 0.05 * (3+1) = 2.718... * 0.2 = 0.5436... <= 1 => true
    assert(exercise7_lovaszLocalLemma(0.05, 3) == true, "LLL: e*0.05*4 < 1, should be true")
    println(s"Exercise 7 - LLL (p=0.1, d=3): ${exercise7_lovaszLocalLemma(0.1, 3)}")
    println(s"Exercise 7 - LLL (p=0.05, d=3): ${exercise7_lovaszLocalLemma(0.05, 3)}")

    // Exercise 8: Derandomized Max Cut
    // Triangle graph: 3 vertices, 3 edges. Greedy should cut at least 2 edges.
    val triangleEdges = List((0, 1), (1, 2), (0, 2))
    val cutSize = exercise8_derandomization(3, triangleEdges)
    assert(cutSize >= 2, s"Greedy max cut on triangle should be >= 2, got $cutSize")
    println(s"Exercise 8 - Derandomized max cut (triangle): $cutSize")

    println("\nAll Logic037_ProbabilisticMethod exercises passed!")
  }
}
