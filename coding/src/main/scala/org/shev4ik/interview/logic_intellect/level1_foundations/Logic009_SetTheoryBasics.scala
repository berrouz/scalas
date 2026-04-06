package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Set Theory Basics=
 *
 * ==Theory: Sets in Computer Science==
 *
 * Set theory is the foundation of modern mathematics and deeply embedded in CS.
 * Types are sets of values, databases use relational algebra (set operations),
 * and formal languages are sets of strings.
 *
 * ==Power Sets==
 *
 * The '''power set''' P(S) of a set S is the set of all subsets of S, including the
 * empty set and S itself. If |S| = n, then |P(S)| = 2^n.
 *
 * {{{
 * P({1, 2}) = { {}, {1}, {2}, {1, 2} }
 * }}}
 *
 * '''Interview relevance:''' Power set generation is equivalent to enumerating all
 * bitmasks from 0 to 2^n - 1. Each bit position decides "include or exclude" an element.
 * This is the basis of brute-force subset enumeration.
 *
 * ==Cartesian Product==
 *
 * A x B = { (a, b) | a in A, b in B }. If |A| = m and |B| = n, then |A x B| = m*n.
 *
 * '''CS connection:''' SQL CROSS JOIN is exactly the Cartesian product of two tables.
 * Type theory: a product type (tuple, case class) corresponds to Cartesian product.
 *
 * ==Partitions==
 *
 * A '''partition''' of set S is a collection of non-empty, pairwise disjoint subsets
 * (called ''blocks'' or ''parts'') whose union equals S.
 *
 * {{{
 * S = {1, 2, 3}
 * Valid partitions: {{1,2,3}}, {{1},{2,3}}, {{1,2},{3}}, {{1,3},{2}}, {{1},{2},{3}}
 * // That's 5 partitions = B(3) (the 3rd Bell number)
 * }}}
 *
 * ==Equivalence Relations and Classes==
 *
 * An '''equivalence relation''' R on S is reflexive, symmetric, and transitive.
 * It partitions S into '''equivalence classes''': [a] = { x in S | x R a }.
 *
 * {{{
 * // Example: integers mod 3
 * // [0] = {..., -3, 0, 3, 6, ...}
 * // [1] = {..., -2, 1, 4, 7, ...}
 * // [2] = {..., -1, 2, 5, 8, ...}
 * }}}
 *
 * '''CS connection:''' Union-Find data structure maintains equivalence classes efficiently.
 * Hashing groups elements into equivalence classes (same hash = same class).
 *
 * ==Bell Numbers==
 *
 * The nth Bell number B(n) counts the number of partitions of an n-element set.
 * Computed via the '''Bell triangle''':
 *
 * {{{
 * B(0) = 1
 * B(n) = sum(k=0 to n-1) C(n-1, k) * B(k)
 * // First values: 1, 1, 2, 5, 15, 52, 203, 877, ...
 * }}}
 *
 * ==Symmetric Difference==
 *
 * A symmetric_diff B = (A - B) union (B - A) = (A union B) - (A intersect B)
 *
 * This gives the elements in exactly one of the two sets. It forms a group operation
 * on sets (associative, has identity = empty set, every set is its own inverse).
 *
 * ==Inclusion-Exclusion Principle==
 *
 * For computing the size of a union:
 * {{{
 * |A ∪ B ∪ C| = |A| + |B| + |C| - |A∩B| - |A∩C| - |B∩C| + |A∩B∩C|
 * }}}
 *
 * '''Interview relevance:''' Counting problems, derangements, and Euler's totient
 * function all use inclusion-exclusion.
 *
 * ==Interview Tips==
 *
 *  - Power set generation is a must-know: use either recursion or bitmask enumeration.
 *  - Understand the relationship between partitions and equivalence relations.
 *  - Inclusion-exclusion is essential for counting problems in competitive programming.
 *  - Symmetric difference is useful in XOR-based problems.
 *  - Bell numbers grow super-exponentially; always use BigInt.
 *
 * ==Comparison: Set Operations Complexity (Scala immutable sets)==
 *
 * | Operation            | HashSet     | TreeSet      | Sorted?  |
 * |----------------------|-------------|--------------|----------|
 * | contains             | O(1) avg    | O(log n)     | No / Yes |
 * | add / remove         | O(1) avg    | O(log n)     | No / Yes |
 * | union                | O(n + m)    | O(n log(n+m))| No / Yes |
 * | intersect            | O(min(n,m)) | O(n log m)   | No / Yes |
 */
object Logic009_SetTheoryBasics {

  // TODO: Generate the power set of a given Set[Int].
  // The power set contains all possible subsets, including the empty set and the set itself.
  // Example: Set(1, 2) => Set(Set(), Set(1), Set(2), Set(1, 2))
  def exercise1_powerSet(s: Set[Int]): Set[Set[Int]] = ???

  // TODO: Compute the Cartesian product of two sets A and B.
  // A x B = { (a, b) | a in A, b in B }
  // Example: Set(1, 2), Set(3, 4) => Set((1,3), (1,4), (2,3), (2,4))
  def exercise2_cartesianProduct(a: Set[Int], b: Set[Int]): Set[(Int, Int)] = ???

  // TODO: Check if a collection of sets forms a valid partition of a universe set.
  // A valid partition requires:
  //   1. All parts are non-empty.
  //   2. Parts are pairwise disjoint.
  //   3. Union of all parts equals the universe.
  // Example: universe = Set(1,2,3), parts = List(Set(1), Set(2,3)) => true
  //          universe = Set(1,2,3), parts = List(Set(1,2), Set(2,3)) => false (overlap)
  def exercise3_isPartition(universe: Set[Int], parts: List[Set[Int]]): Boolean = ???

  // TODO: Compute the symmetric difference of two sets: (A - B) union (B - A).
  // This gives elements that are in exactly one of the two sets.
  // Example: Set(1,2,3), Set(2,3,4) => Set(1, 4)
  def exercise4_symmetricDifference(a: Set[Int], b: Set[Int]): Set[Int] = ???

  // TODO: Compute |A ∪ B ∪ C| using the inclusion-exclusion principle.
  // |A ∪ B ∪ C| = |A| + |B| + |C| - |A∩B| - |A∩C| - |B∩C| + |A∩B∩C|
  // Verify the formula matches the actual union size and return the union size.
  // Example: A={1,2,3}, B={2,3,4}, C={3,4,5} => 5
  def exercise5_inclusionExclusion(a: Set[Int], b: Set[Int], c: Set[Int]): Int = ???

  // TODO: Compute the nth Bell number (number of partitions of an n-element set).
  // Use the Bell triangle:
  //   Row 0: [1]
  //   Each subsequent row starts with the last element of the previous row,
  //   then each element = previous element in this row + element above that.
  //   B(n) = first element of row n (or last element of row n-1).
  // B(0)=1, B(1)=1, B(2)=2, B(3)=5, B(4)=15, B(5)=52
  def exercise6_bellNumber(n: Int): BigInt = ???

  // TODO: Given a set of integers and an equivalence relation (represented as a function
  // (Int, Int) => Boolean), partition the set into equivalence classes.
  // Two elements are in the same class if the relation holds between them.
  // Example: Set(1,2,3,4,5,6), relation = (a,b) => a % 3 == b % 3
  //          => Set(Set(3,6), Set(1,4), Set(2,5))
  def exercise7_equivalenceClasses(s: Set[Int], relation: (Int, Int) => Boolean): Set[Set[Int]] = ???

  // TODO: Generate all partitions of the set {1, 2, ..., n}.
  // Each partition is a List of Lists (blocks). Return all possible partitions.
  // Order of blocks and elements within blocks does not matter for correctness,
  // but sort each block and sort the partition for consistent output.
  // Example: n=2 => List(List(List(1,2)), List(List(1), List(2)))
  def exercise8_setPartitions(n: Int): List[List[List[Int]]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: powerSet
    assert(exercise1_powerSet(Set()) == Set(Set()))
    assert(exercise1_powerSet(Set(1)) == Set(Set(), Set(1)))
    assert(exercise1_powerSet(Set(1, 2)).size == 4)
    assert(exercise1_powerSet(Set(1, 2, 3)).size == 8)
    println("Exercise 1 passed: exercise1_powerSet")

    // Exercise 2: cartesianProduct
    assert(exercise2_cartesianProduct(Set(1, 2), Set(3, 4)) == Set((1, 3), (1, 4), (2, 3), (2, 4)))
    assert(exercise2_cartesianProduct(Set(1), Set(2)) == Set((1, 2)))
    assert(exercise2_cartesianProduct(Set(), Set(1, 2)) == Set())
    println("Exercise 2 passed: exercise2_cartesianProduct")

    // Exercise 3: isPartition
    assert(exercise3_isPartition(Set(1, 2, 3), List(Set(1), Set(2, 3))) == true)
    assert(exercise3_isPartition(Set(1, 2, 3), List(Set(1, 2), Set(2, 3))) == false)
    assert(exercise3_isPartition(Set(1, 2, 3), List(Set(1, 2))) == false)
    assert(exercise3_isPartition(Set(1, 2, 3), List(Set(1), Set(), Set(2, 3))) == false)
    println("Exercise 3 passed: exercise3_isPartition")

    // Exercise 4: symmetricDifference
    assert(exercise4_symmetricDifference(Set(1, 2, 3), Set(2, 3, 4)) == Set(1, 4))
    assert(exercise4_symmetricDifference(Set(1, 2), Set(1, 2)) == Set())
    assert(exercise4_symmetricDifference(Set(1), Set(2)) == Set(1, 2))
    println("Exercise 4 passed: exercise4_symmetricDifference")

    // Exercise 5: inclusionExclusion
    assert(exercise5_inclusionExclusion(Set(1, 2, 3), Set(2, 3, 4), Set(3, 4, 5)) == 5)
    assert(exercise5_inclusionExclusion(Set(1), Set(2), Set(3)) == 3)
    assert(exercise5_inclusionExclusion(Set(1, 2), Set(1, 2), Set(1, 2)) == 2)
    println("Exercise 5 passed: exercise5_inclusionExclusion")

    // Exercise 6: bellNumber
    assert(exercise6_bellNumber(0) == BigInt(1))
    assert(exercise6_bellNumber(1) == BigInt(1))
    assert(exercise6_bellNumber(2) == BigInt(2))
    assert(exercise6_bellNumber(3) == BigInt(5))
    assert(exercise6_bellNumber(4) == BigInt(15))
    assert(exercise6_bellNumber(5) == BigInt(52))
    println("Exercise 6 passed: exercise6_bellNumber")

    // Exercise 7: equivalenceClasses
    val modClasses = exercise7_equivalenceClasses(Set(1, 2, 3, 4, 5, 6), (a, b) => a % 3 == b % 3)
    assert(modClasses.size == 3)
    assert(modClasses.contains(Set(3, 6)))
    assert(modClasses.contains(Set(1, 4)))
    assert(modClasses.contains(Set(2, 5)))
    val singletonClasses = exercise7_equivalenceClasses(Set(1, 2, 3), (a, b) => a == b)
    assert(singletonClasses == Set(Set(1), Set(2), Set(3)))
    println("Exercise 7 passed: exercise7_equivalenceClasses")

    // Exercise 8: setPartitions
    assert(exercise8_setPartitions(1).size == 1) // {{1}}
    assert(exercise8_setPartitions(2).size == 2) // {{1,2}}, {{1},{2}}
    assert(exercise8_setPartitions(3).size == 5) // B(3) = 5
    assert(exercise8_setPartitions(4).size == 15) // B(4) = 15
    println("Exercise 8 passed: exercise8_setPartitions")

    println("All Logic009_SetTheoryBasics exercises passed!")
  }
}
