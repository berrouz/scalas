package org.shev4ik.interview.algorithms.level4_expert

/**
 * Matroid Theory and Matroid Intersection.
 *
 * Key concepts:
 * - Matroid: (E, I) where I is a family of independent sets satisfying
 *   hereditary property and exchange property
 * - Graphic matroid: independent sets = forests of a graph
 * - Partition matroid: elements partitioned into groups with capacity limits
 * - Matroid intersection: find largest set independent in two matroids
 * - Greedy algorithm is optimal on matroids for weighted problems
 */
object Algo113_MatroidIntersect {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Matroid definition - verify independence
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a ground set E = {0, 1, ..., n-1} and a family of
   *       independent sets, verify that it forms a matroid.
   *       Check: (1) empty set is independent, (2) hereditary property
   *       (subset of independent set is independent),
   *       (3) exchange property (if |A| < |B| and both independent,
   *       exists e in B\A such that A + e is independent).
   *
   * @param n               size of ground set
   * @param independentSets all independent sets
   * @return true if the family forms a matroid
   */
  def isMatroid(n: Int, independentSets: Set[Set[Int]]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Graphic matroid - find maximum forest
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a graph as edges, the graphic matroid has forests as
   *       independent sets. Find the maximum independent set (spanning forest).
   *       Use union-find to greedily add edges that don't create cycles.
   *       Return the number of edges in the maximum forest.
   *
   * @param n     number of vertices
   * @param edges list of (u, v) edges
   * @return size of maximum forest (number of edges)
   */
  def graphicMatroidMaxForest(n: Int, edges: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Partition matroid
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a partition matroid. Elements are partitioned into
   *       groups, each group has a capacity. A set is independent if
   *       it takes at most capacity[i] elements from group i.
   *       Given a candidate set, check if it is independent.
   *
   * @param groups   map from element -> group index
   * @param capacity map from group index -> max allowed elements
   * @param subset   candidate set to check
   * @return true if subset is independent in the partition matroid
   */
  def isPartitionIndependent(groups: Map[Int, Int], capacity: Map[Int, Int], subset: Set[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Matroid intersection
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the maximum cardinality set that is independent in
   *       both matroid M1 and matroid M2.
   *       Use the augmenting path algorithm:
   *       - Build exchange graph
   *       - Find augmenting path from source to sink via BFS
   *       - Augment along the path
   *       For simplicity, M1 and M2 are given as independence oracles.
   *       Return the size of the maximum common independent set.
   *
   * @param groundSet      elements {0, ..., n-1}
   * @param isIndependent1 oracle for matroid 1
   * @param isIndependent2 oracle for matroid 2
   * @return size of maximum common independent set
   */
  def matroidIntersectionSize(
    groundSet: Set[Int],
    isIndependent1: Set[Int] => Boolean,
    isIndependent2: Set[Int] => Boolean
  ): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Weighted matroid - greedy algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the maximum weight independent set in a matroid.
   *       Sort elements by weight (descending), greedily add element
   *       if it keeps the set independent.
   *       The independence oracle checks if a set is independent.
   *       Return the maximum total weight.
   *
   * @param elements list of (element, weight)
   * @param isIndependent oracle to check independence
   * @return maximum weight of an independent set
   */
  def weightedMatroidGreedy(
    elements: List[(Int, Double)],
    isIndependent: Set[Int] => Boolean
  ): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Greedy on graphic matroid (Kruskal's MST)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Demonstrate that the greedy algorithm on a graphic matroid
   *       yields a minimum spanning tree (Kruskal's algorithm).
   *       Sort edges by weight ascending, add edge if it doesn't
   *       create a cycle. Return total MST weight.
   *
   * @param n     number of vertices
   * @param edges list of (u, v, weight)
   * @return total weight of MST
   */
  def greedyMST(n: Int, edges: List[(Int, Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Matroid union
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: The union of matroids M1 and M2 has independent sets that
   *       can be partitioned into I1 (independent in M1) and I2
   *       (independent in M2). Find the maximum independent set
   *       in the union. Use matroid intersection on a related problem.
   *       Return the size of the maximum set in the matroid union.
   *
   * @param groundSet      elements
   * @param isIndependent1 oracle for M1
   * @param isIndependent2 oracle for M2
   * @return size of maximum set in matroid union
   */
  def matroidUnionSize(
    groundSet: Set[Int],
    isIndependent1: Set[Int] => Boolean,
    isIndependent2: Set[Int] => Boolean
  ): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Scheduling with matroid
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Schedule jobs with deadlines and profits using matroid theory.
   *       Each job has (deadline, profit). A set of jobs is independent
   *       if they can all be scheduled before their deadlines (one job
   *       per time slot). Use the greedy matroid algorithm.
   *       Return the maximum total profit.
   *
   * @param jobs list of (deadline, profit), deadlines are 1-based
   * @return maximum total profit of schedulable jobs
   */
  def scheduleWithMatroid(jobs: List[(Int, Int)]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    // Uniform matroid of rank 2 on {0,1,2}: independent sets are all subsets of size <= 2
    val indSets: Set[Set[Int]] = Set(
      Set(), Set(0), Set(1), Set(2), Set(0,1), Set(0,2), Set(1,2)
    )
    assert(isMatroid(3, indSets), "Expected valid matroid")
    // Not a matroid: add {0,1,2} but not exchange property
    val badSets = indSets + Set(0,1,2)
    // This might still be valid (uniform rank 3), test a truly bad one
    val reallyBad: Set[Set[Int]] = Set(Set(), Set(0), Set(1), Set(0,1))
    // Missing Set(2) subsets - not hereditary if we add Set(0,2)
    assert(isMatroid(2, Set(Set(), Set(0), Set(1), Set(0,1))), "Expected valid matroid on 2 elements")
    println("Exercise 1 (Matroid definition) passed.")

    // Exercise 2
    val forest = graphicMatroidMaxForest(4, List((0,1),(1,2),(2,3),(0,3),(1,3)))
    assert(forest == 3, s"Expected 3, got $forest") // spanning tree of 4 nodes
    println("Exercise 2 (Graphic matroid) passed.")

    // Exercise 3
    val groups = Map(0 -> 0, 1 -> 0, 2 -> 1, 3 -> 1)
    val cap = Map(0 -> 1, 1 -> 1)
    assert(isPartitionIndependent(groups, cap, Set(0, 2)), "Expected independent")
    assert(!isPartitionIndependent(groups, cap, Set(0, 1)), "Expected dependent (both in group 0)")
    println("Exercise 3 (Partition matroid) passed.")

    // Exercise 4
    // Graphic matroid: forests on 3 vertices {edge 0=(0,1), edge 1=(1,2), edge 2=(0,2)}
    // Partition matroid: group A={0,1}, group B={2}, cap A=1, cap B=1
    val gSet = Set(0, 1, 2)
    val graphOracle: Set[Int] => Boolean = s => {
      val edgeList = List((0,1),(1,2),(0,2))
      val selected = s.toList.map(edgeList)
      // Check if forest using union-find
      val parent = Array.tabulate(3)(identity)
      def find(x: Int): Int = { if (parent(x) != x) parent(x) = find(parent(x)); parent(x) }
      selected.forall { case (u, v) => val fu = find(u); val fv = find(v); if (fu == fv) false else { parent(fu) = fv; true } }
    }
    val partOracle: Set[Int] => Boolean = s => {
      val g = Map(0 -> 0, 1 -> 0, 2 -> 1)
      val c = Map(0 -> 1, 1 -> 1)
      s.groupBy(g).forall { case (grp, elems) => elems.size <= c(grp) }
    }
    val isectSize = matroidIntersectionSize(gSet, graphOracle, partOracle)
    assert(isectSize == 2, s"Expected 2, got $isectSize")
    println("Exercise 4 (Matroid intersection) passed.")

    // Exercise 5
    val wt = weightedMatroidGreedy(
      List((0, 10.0), (1, 5.0), (2, 8.0)),
      (s: Set[Int]) => s.size <= 2 // uniform matroid rank 2
    )
    assert(wt == 18.0, s"Expected 18.0, got $wt") // pick 0 (10) and 2 (8)
    println("Exercise 5 (Weighted matroid greedy) passed.")

    // Exercise 6
    val mst = greedyMST(4, List((0,1,1),(1,2,2),(2,3,3),(0,3,4),(1,3,5)))
    assert(mst == 6, s"Expected 6 (1+2+3), got $mst")
    println("Exercise 6 (Greedy MST) passed.")

    // Exercise 7
    val unionSize = matroidUnionSize(
      Set(0, 1, 2, 3),
      (s: Set[Int]) => s.size <= 2, // uniform rank 2
      (s: Set[Int]) => s.size <= 2  // uniform rank 2
    )
    assert(unionSize == 4, s"Expected 4, got $unionSize") // union can pick all 4
    println("Exercise 7 (Matroid union) passed.")

    // Exercise 8
    val profit = scheduleWithMatroid(List((2, 100), (1, 19), (2, 27), (1, 25), (3, 15)))
    assert(profit == 142, s"Expected 142 (100+27+15), got $profit")
    println("Exercise 8 (Scheduling with matroid) passed.")

    println("All Algo113_MatroidIntersect exercises passed!")
  }
}
