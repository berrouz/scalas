package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Pigeonhole Principle (Принцип Дирихле)=
 *
 * ==Theory: The Pigeonhole Principle==
 *
 * The '''Pigeonhole Principle''' (also known as Dirichlet's box principle) states:
 *
 * ''If n+1 objects are placed into n containers, then at least one container must hold
 * more than one object.''
 *
 * More generally: if n objects are placed into k containers and n > k, then at least one
 * container holds at least ceil(n/k) objects.
 *
 * '''Formal statement:'''
 * {{{
 * For any function f: A -> B where |A| > |B|,
 * there exist distinct a1, a2 in A such that f(a1) = f(a2).
 * In other words, f cannot be injective.
 * }}}
 *
 * ==Applications in Computer Science==
 *
 *  - '''Proving duplicates exist:''' Given n+1 elements from a set of size n, at least
 *    two elements must be identical. This is used in cycle detection (Floyd's algorithm),
 *    duplicate finding problems, and hash collision proofs.
 *
 *  - '''Birthday Paradox connection:''' With 367 people, at least two share a birthday
 *    (deterministic). The probabilistic version (23 people for 50% chance) is related
 *    but uses different reasoning.
 *
 *  - '''Hash collisions:''' If a hash function maps an infinite (or very large) domain
 *    to a finite codomain of size m, then collisions are unavoidable when more than m
 *    items are hashed. This is why hash tables need collision resolution strategies.
 *
 *  - '''Lossless compression:''' No lossless compression algorithm can compress ALL inputs
 *    of size n into fewer bits. If it could, by pigeonhole, two distinct inputs would
 *    map to the same compressed form, contradicting losslessness.
 *
 *  - '''IP address exhaustion:''' IPv4 has ~4.3 billion addresses. With more devices than
 *    addresses, NAT was invented because pigeonhole guarantees address conflicts.
 *
 * ==Comparison with Related Principles==
 *
 *  - '''Pigeonhole vs Counting argument:''' Pigeonhole is a special case of counting.
 *    Counting arguments are more general and can prove tighter bounds.
 *  - '''Pigeonhole vs Probabilistic method:''' Pigeonhole gives deterministic existence
 *    guarantees, while the probabilistic method shows existence via positive probability.
 *  - '''Pigeonhole vs Parity argument:''' Parity arguments use even/odd properties,
 *    while pigeonhole uses size comparisons.
 *
 * ==Interview Tips==
 *
 *  - When a problem says "prove that X must exist" or "find a guaranteed duplicate",
 *    immediately think pigeonhole.
 *  - Identify the "pigeons" (objects) and "holes" (containers/categories).
 *  - Common patterns: array of n+1 elements from range [1,n], prefix sums mod n,
 *    points in geometric regions, substrings from finite alphabets.
 *  - The principle only proves EXISTENCE -- it does not directly tell you HOW to find
 *    the duplicate, but it guarantees your search will succeed.
 *  - Time complexity of pigeonhole-based solutions is often O(n) using hash sets or
 *    O(n log n) using sorting, but some clever formulations achieve O(1) extra space
 *    (e.g., Floyd's cycle detection for the duplicate number problem).
 */
object Logic001_PigeonholePrinciple {

  // Exercise 1: Find any duplicate in an Array[Int] of n+1 elements where values are in [1, n].
  // By the pigeonhole principle, a duplicate is guaranteed to exist.
  // Example: Array(1, 3, 4, 2, 2) => 2
  def exercise1_findDuplicate(arr: Array[Int]): Int = ???

  // Exercise 2: Given counts of sock colors in a drawer, find the minimum number of draws
  // (without looking) to GUARANTEE you have at least one matching pair.
  // By pigeonhole: you need (number_of_colors + 1) draws to guarantee a pair.
  // Example: Map("red" -> 5, "blue" -> 3, "green" -> 2) => 4 (3 colors + 1)
  def exercise2_sockDrawer(sockCounts: Map[String, Int]): Int = ???

  // Exercise 3: Given n points in a unit square [0,1] x [0,1], determine if n is large
  // enough that the pigeonhole principle guarantees at least two points are within
  // distance 1/sqrt(n) of each other.
  // By subdividing the unit square into a grid, for n > 4 this is always true.
  // Return true if n > 4, false otherwise.
  def exercise3_pointsInSquare(n: Int): Boolean = ???

  // Exercise 4: Given a string of length n built from an alphabet of size k,
  // find the maximum length L such that there MUST exist duplicate substrings of length L.
  // Duplicates are guaranteed when the number of possible substrings (n - L + 1) exceeds
  // the number of distinct strings of length L (k^L), i.e., n - L + 1 > k^L.
  // Return the largest such L (or 0 if no such L exists).
  // Example: n=10, k=2 => 3 (since 10-3+1=8 > 2^3=8 is false, but 10-2+1=9 > 2^2=4, so L=2... check carefully)
  def exercise4_substringDuplicates(n: Int, k: Int): Int = ???

  // Exercise 5: Given n+1 integers and a modulus n, find two elements that have the same
  // remainder when divided by n. By pigeonhole on remainders {0, 1, ..., n-1}, two of the
  // n+1 integers must share a remainder.
  // Return the pair (a, b) where a appears before b in the array.
  // Example: Array(2, 5, 11, 8, 3), n=4 => (2, 6)... wait, let's use: Array(10, 21, 33, 44, 15), n=4
  //   remainders: 2, 1, 1, 0, 3 => 21 and 33 both have remainder 1 => (21, 33)
  def exercise5_remainderPigeonhole(arr: Array[Int], n: Int): (Int, Int) = ???

  // Exercise 6: Given a sequence of n positive integers, find indices (startIdx, endIdx) of a
  // contiguous subsequence whose sum is divisible by n.
  // By pigeonhole on prefix sums mod n: among n+1 prefix sums (including 0) and n possible
  // remainders, two prefix sums must share a remainder. Their difference gives the subsequence.
  // Return (startIdx, endIdx) inclusive.
  // Example: Array(3, 1, 2) => one valid answer is (0, 2) since 3+1+2=6 divisible by 3
  def exercise6_sequenceWithSum(arr: Array[Int]): (Int, Int) = ???

  // Exercise 7: At a party of n people, prove that at least 2 people have the same number
  // of friends (assuming "friends" is a symmetric relation among partygoers).
  // Each person can have 0 to n-1 friends, but 0 and n-1 cannot coexist (if someone knows
  // everyone, no one knows nobody). So n people map to at most n-1 possible friend counts.
  // By pigeonhole, two must match. Return true for n >= 2.
  def exercise7_friendsAtParty(n: Int): Boolean = ???

  // Exercise 8: Given n+1 balls colored with colors from {0, 1, ..., n-1} (i.e., n colors),
  // find a color that appears at least twice. By pigeonhole, such a color must exist.
  // Return any such color.
  // Example: Array(0, 1, 2, 1) => 1
  def exercise8_coloring(colors: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: findDuplicate
    assert(exercise1_findDuplicate(Array(1, 3, 4, 2, 2)) == 2)
    assert(exercise1_findDuplicate(Array(3, 1, 3, 4, 2)) == 3)
    assert(exercise1_findDuplicate(Array(1, 1)) == 1)
    println("Exercise 1 passed: exercise1_findDuplicate")

    // Exercise 2: sockDrawer
    assert(exercise2_sockDrawer(Map("red" -> 5, "blue" -> 3, "green" -> 2)) == 4)
    assert(exercise2_sockDrawer(Map("red" -> 10)) == 2)
    assert(exercise2_sockDrawer(Map("a" -> 1, "b" -> 1, "c" -> 1, "d" -> 1, "e" -> 1)) == 6)
    println("Exercise 2 passed: exercise2_sockDrawer")

    // Exercise 3: pointsInSquare
    assert(exercise3_pointsInSquare(5) == true)
    assert(exercise3_pointsInSquare(100) == true)
    assert(exercise3_pointsInSquare(4) == false)
    assert(exercise3_pointsInSquare(3) == false)
    println("Exercise 3 passed: exercise3_pointsInSquare")

    // Exercise 4: substringDuplicates
    assert(exercise4_substringDuplicates(10, 2) == 2)
    assert(exercise4_substringDuplicates(100, 26) == 1)
    assert(exercise4_substringDuplicates(2, 26) == 0)
    println("Exercise 4 passed: exercise4_substringDuplicates")

    // Exercise 5: remainderPigeonhole
    val pair5 = exercise5_remainderPigeonhole(Array(10, 21, 33, 44, 15), 4)
    assert(pair5._1 % 4 == pair5._2 % 4)
    val pair5b = exercise5_remainderPigeonhole(Array(2, 5, 7), 2)
    assert(pair5b._1 % 2 == pair5b._2 % 2)
    println("Exercise 5 passed: exercise5_remainderPigeonhole")

    // Exercise 6: sequenceWithSum
    val (s6, e6) = exercise6_sequenceWithSum(Array(3, 1, 2))
    assert(Array(3, 1, 2).slice(s6, e6 + 1).sum % 3 == 0)
    val (s6b, e6b) = exercise6_sequenceWithSum(Array(5, 3, 7, 2))
    assert(Array(5, 3, 7, 2).slice(s6b, e6b + 1).sum % 4 == 0)
    println("Exercise 6 passed: exercise6_sequenceWithSum")

    // Exercise 7: friendsAtParty
    assert(exercise7_friendsAtParty(2) == true)
    assert(exercise7_friendsAtParty(100) == true)
    assert(exercise7_friendsAtParty(1) == false)
    println("Exercise 7 passed: exercise7_friendsAtParty")

    // Exercise 8: coloring
    assert(exercise8_coloring(Array(0, 1, 2, 1)) == 1)
    assert(exercise8_coloring(Array(0, 0)) == 0)
    val color8 = exercise8_coloring(Array(3, 2, 1, 0, 2))
    assert(Array(3, 2, 1, 0, 2).count(_ == color8) >= 2)
    println("Exercise 8 passed: exercise8_coloring")

    println("\nAll exercises passed!")
  }
}
