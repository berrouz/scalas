package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Graph-Based Puzzles (Графові головоломки)=
 *
 * ==Theory: Graphs as Puzzle Models==
 *
 * Many classic puzzles can be elegantly modeled as graph problems. Understanding
 * the connection between puzzles and graph theory is a powerful interview skill.
 *
 * '''Euler Paths and Circuits:'''
 * An '''Euler path''' traverses every ''edge'' exactly once. An '''Euler circuit'''
 * is an Euler path that starts and ends at the same vertex.
 * {{{
 *   Euler circuit exists ⟺ graph is connected AND every vertex has even degree
 *   Euler path exists    ⟺ graph is connected AND has 0 or 2 odd-degree vertices
 * }}}
 * The classic Königsberg bridge problem (1736) was the first graph theory result:
 * Euler proved no Euler circuit exists because all 4 vertices have odd degree.
 *
 * '''Hamiltonian Paths and Circuits:'''
 * A '''Hamiltonian path''' visits every ''vertex'' exactly once. Unlike Euler paths,
 * deciding existence is NP-complete. However, in tournament graphs (complete directed
 * graphs), a Hamiltonian path always exists (proved by induction).
 *
 * '''Graph Coloring:'''
 * A proper vertex coloring assigns colors such that no two adjacent vertices share
 * a color. The '''chromatic number''' χ(G) is the minimum number of colors needed.
 * {{{
 *   χ(G) = 2 ⟺ G is bipartite (contains no odd cycles)
 *   χ(G) <= Δ(G) + 1  (Brook's theorem, with equality only for odd cycles and complete graphs)
 * }}}
 *
 * '''Ramsey Theory:'''
 * R(s, t) is the smallest n such that any 2-coloring of K_n edges contains a
 * monochromatic K_s in color 1 or K_t in color 2. The classic result: R(3,3) = 6.
 *
 * '''Handshaking Lemma:'''
 * In any graph, the sum of all vertex degrees equals twice the number of edges:
 * {{{
 *   Σ deg(v) = 2|E|
 * }}}
 * Corollary: the number of vertices with odd degree is always even.
 *
 * ==Comparison: Euler vs Hamiltonian==
 *
 * | Property          | Euler Path/Circuit    | Hamiltonian Path/Circuit |
 * |-------------------|-----------------------|--------------------------|
 * | Traverses         | Every edge once       | Every vertex once        |
 * | Existence check   | Polynomial (degree)   | NP-complete              |
 * | Key condition     | Degree parity         | No simple criterion      |
 * | Classic puzzle    | Königsberg bridges    | Traveling salesman       |
 *
 * ==Interview Tips==
 *
 *  - '''Euler problems''' are recognizable: "traverse every edge/bridge/road exactly once."
 *  - '''Bipartiteness''' (2-colorability) is tested via BFS/DFS — O(V + E).
 *  - '''Handshaking lemma''' is often used as a "gotcha" proof question.
 *  - For '''Ramsey''', knowing R(3,3) = 6 is sufficient for most interviews.
 *  - '''Tournament graphs''' guarantee Hamiltonian paths — useful for sorting arguments.
 *  - When asked "is it possible to...," model as a graph and check structural properties.
 *
 * ==Complexity Note==
 *
 * Euler path/circuit existence: O(V + E). Finding the actual path: O(V + E) via Hierholzer's.
 * Bipartiteness: O(V + E) via BFS. Graph coloring for k >= 3: NP-complete.
 * Hamiltonian path: NP-complete in general, but O(V log V) in tournaments via divide-and-conquer.
 */
object Logic013_GraphPuzzles {

  /**
   * Exercise 1: Euler Circuit Check
   *
   * Check if an undirected graph has an Euler circuit. An Euler circuit exists
   * if and only if the graph is connected (considering only vertices with degree > 0)
   * and every vertex has even degree.
   *
   * @param adjacencyList map from vertex to list of adjacent vertices
   * @return true if an Euler circuit exists
   */
  def exercise1_eulerCircuit(adjacencyList: Map[Int, List[Int]]): Boolean = ???

  /**
   * Exercise 2: Euler Path Check
   *
   * Check if an undirected graph has an Euler path. An Euler path exists if and
   * only if the graph is connected and has exactly 0 or 2 vertices with odd degree.
   *
   * @param adjacencyList map from vertex to list of adjacent vertices
   * @return true if an Euler path exists
   */
  def exercise2_eulerPath(adjacencyList: Map[Int, List[Int]]): Boolean = ???

  /**
   * Exercise 3: Königsberg Bridges
   *
   * Model the Königsberg bridges problem as a graph and verify that no Euler
   * circuit exists. The graph has 4 vertices (landmasses) with degrees 3, 3, 3, 5
   * (all odd), so no Euler circuit or even Euler path exists.
   *
   * @return false, confirming no Euler circuit
   */
  def exercise3_koenigsberg(): Boolean = ???

  /**
   * Exercise 4: Graph 2-Colorability (Bipartiteness)
   *
   * Determine if a graph is 2-colorable (bipartite) using BFS/DFS.
   * A graph is bipartite iff it contains no odd-length cycles.
   *
   * @param adjacencyList map from vertex to list of adjacent vertices
   * @return true if the graph is bipartite (2-colorable)
   */
  def exercise4_graphColoring(adjacencyList: Map[Int, List[Int]]): Boolean = ???

  /**
   * Exercise 5: Chromatic Number Upper Bound
   *
   * Compute the upper bound on the chromatic number using Brook's theorem:
   * χ(G) <= Δ(G) + 1, where Δ(G) is the maximum degree of the graph.
   *
   * @param adjacencyList map from vertex to list of adjacent vertices
   * @return max_degree + 1
   */
  def exercise5_chromaticBound(adjacencyList: Map[Int, List[Int]]): Int = ???

  /**
   * Exercise 6: Handshaking Lemma Verification
   *
   * Verify the handshaking lemma: the sum of all vertex degrees equals
   * twice the number of edges. Count edges as |E| = sum_of_degrees / 2
   * (for undirected graph where each edge is listed in both endpoints).
   *
   * @param adjacencyList map from vertex to list of adjacent vertices
   * @return true if the handshaking lemma holds (it always should)
   */
  def exercise6_handshakingLemma(adjacencyList: Map[Int, List[Int]]): Boolean = ???

  /**
   * Exercise 7: Tournament Hamiltonian Path (Greedy)
   *
   * In a tournament graph (complete directed graph where every pair of vertices
   * has exactly one directed edge), find the length of the longest path using
   * a greedy insertion approach. By theorem, every tournament has a Hamiltonian
   * path, so the result should be n-1 for n vertices.
   *
   * @param wins map from vertex to set of vertices it beats (directed edges)
   * @return length of the longest path found (number of edges)
   */
  def exercise7_tournamentProperty(wins: Map[Int, Set[Int]]): Int = ???

  /**
   * Exercise 8: Ramsey R(3,3) Verification
   *
   * Verify that R(3,3) = 6: in any 2-coloring of the edges of K6 (complete
   * graph on 6 vertices), there must exist a monochromatic triangle.
   * Given a coloring (set of "red" edges, remaining are "blue"), check
   * if a monochromatic triangle exists.
   *
   * @param n number of vertices (should be 6)
   * @param redEdges set of (i, j) pairs representing red edges (i < j)
   * @return true if a monochromatic triangle exists
   */
  def exercise8_ramseySmall(n: Int, redEdges: Set[(Int, Int)]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Euler Circuit
    // Square graph: 0-1-2-3-0, all degrees = 2 (even) -> Euler circuit exists
    val square = Map(0 -> List(1, 3), 1 -> List(0, 2), 2 -> List(1, 3), 3 -> List(2, 0))
    assert(exercise1_eulerCircuit(square) == true)
    // Path graph: 0-1-2, degrees 1,2,1 -> no Euler circuit
    val path = Map(0 -> List(1), 1 -> List(0, 2), 2 -> List(1))
    assert(exercise1_eulerCircuit(path) == false)
    println("Exercise 1 passed: eulerCircuit")

    // Exercise 2: Euler Path
    // Path graph: 0-1-2, exactly 2 odd-degree vertices -> Euler path exists
    assert(exercise2_eulerPath(path) == true)
    // Square: 0 odd-degree vertices -> Euler path exists (circuit is a special case)
    assert(exercise2_eulerPath(square) == true)
    // K4 with extra edge: vertex degrees 3,3,3,3 -> 4 odd vertices -> no Euler path
    val k4 = Map(0 -> List(1,2,3), 1 -> List(0,2,3), 2 -> List(0,1,3), 3 -> List(0,1,2))
    assert(exercise2_eulerPath(k4) == false)
    println("Exercise 2 passed: eulerPath")

    // Exercise 3: Königsberg
    assert(exercise3_koenigsberg() == false)
    println("Exercise 3 passed: koenigsberg")

    // Exercise 4: Graph Coloring (Bipartite)
    // Square (even cycle) is bipartite
    assert(exercise4_graphColoring(square) == true)
    // Triangle is NOT bipartite
    val triangle = Map(0 -> List(1, 2), 1 -> List(0, 2), 2 -> List(0, 1))
    assert(exercise4_graphColoring(triangle) == false)
    println("Exercise 4 passed: graphColoring (bipartite)")

    // Exercise 5: Chromatic Bound
    assert(exercise5_chromaticBound(square) == 3)   // max degree 2, bound = 3
    assert(exercise5_chromaticBound(triangle) == 3)  // max degree 2, bound = 3
    assert(exercise5_chromaticBound(k4) == 4)        // max degree 3, bound = 4
    println("Exercise 5 passed: chromaticBound")

    // Exercise 6: Handshaking Lemma
    assert(exercise6_handshakingLemma(square) == true)
    assert(exercise6_handshakingLemma(triangle) == true)
    assert(exercise6_handshakingLemma(k4) == true)
    println("Exercise 6 passed: handshakingLemma")

    // Exercise 7: Tournament Property
    // Tournament on 4 vertices: 0 beats 1,2,3; 1 beats 2,3; 2 beats 3
    val tournament4 = Map(
      0 -> Set(1, 2, 3),
      1 -> Set(2, 3),
      2 -> Set(3),
      3 -> Set[Int]()
    )
    assert(exercise7_tournamentProperty(tournament4) == 3) // Hamiltonian path has n-1 edges
    println("Exercise 7 passed: tournamentProperty")

    // Exercise 8: Ramsey R(3,3)
    // Any 2-coloring of K6 must have a monochromatic triangle
    val redEdges1 = Set((0,1), (0,2), (1,2), (3,4), (3,5), (4,5))
    assert(exercise8_ramseySmall(6, redEdges1) == true)
    // Another coloring
    val redEdges2 = Set((0,1), (1,2), (2,3), (3,4), (4,5), (5,0), (0,3), (1,4), (2,5))
    assert(exercise8_ramseySmall(6, redEdges2) == true)
    println("Exercise 8 passed: ramseySmall")

    println("\nAll exercises passed!")
  }
}
