package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP014 - Optional and Traversal
 *
 * Optional[S, A] is like a Lens but the focus may not exist (Lens + Prism).
 * Traversal[S, A] focuses on zero or more targets within S.
 */
object AdvFP014_OptionalTraversal {

  // ============================================================
  // Exercise 1: Define Optional optic
  // Optional[S, A] = getOption: S => Option[A], set: A => S => S
  // ============================================================
  case class Optional[S, A](getOption: S => Option[A], set: A => S => S) {
    def modify(f: A => A)(s: S): S =
      getOption(s).map(a => set(f(a))(s)).getOrElse(s)
  }

  // TODO: Create an Optional for the head of a List
  def headOptional[A]: Optional[List[A], A] = ???

  // ============================================================
  // Exercise 2: Implement Optional composition
  // Given Optional[S, A] and Optional[A, B], produce Optional[S, B]
  // ============================================================
  // TODO: Compose two Optionals
  def composeOptional[S, A, B](outer: Optional[S, A], inner: Optional[A, B]): Optional[S, B] = ???

  // ============================================================
  // Exercise 3: Define Traversal optic
  // Traversal[S, A] focuses on all A's within S.
  // Simplified: getAll: S => List[A], modify: (A => A) => S => S
  // ============================================================
  case class Traversal[S, A](getAll: S => List[A], modifyF: (A => A) => S => S)

  // TODO: Create a Traversal for all elements in a List
  def listTraversal[A]: Traversal[List[A], A] = ???

  // ============================================================
  // Exercise 4: Create a Traversal for all values in a Map
  // ============================================================
  // TODO: Traversal for Map values
  def mapValuesTraversal[K, V]: Traversal[Map[K, V], V] = ???

  // ============================================================
  // Exercise 5: Implement Traversal composition
  // Given Traversal[S, A] and Traversal[A, B], produce Traversal[S, B]
  // ============================================================
  // TODO: Compose two Traversals
  def composeTraversal[S, A, B](outer: Traversal[S, A], inner: Traversal[A, B]): Traversal[S, B] = ???

  // ============================================================
  // Exercise 6: Create an Optional for a Map key lookup
  // ============================================================
  // TODO: Optional that focuses on a specific key in a Map
  def atKey[K, V](key: K): Optional[Map[K, V], V] = ???

  // ============================================================
  // Exercise 7: Implement Traversal's getAll for nested structures
  // Given a list of lists, get all inner elements.
  // ============================================================
  // TODO: Traversal for nested lists (flattening)
  def nestedListTraversal[A]: Traversal[List[List[A]], A] = ???

  // ============================================================
  // Exercise 8: Implement a filter-based Traversal
  // Focus only on elements matching a predicate.
  // ============================================================
  // TODO: Traversal that only focuses on elements matching a predicate
  def filterTraversal[A](pred: A => Boolean): Traversal[List[A], A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Head optional
    val ho = headOptional[Int]
    assert(ho.getOption(List(1, 2, 3)) == Some(1))
    assert(ho.getOption(Nil) == None)
    assert(ho.set(10)(List(1, 2, 3)) == List(10, 2, 3))
    assert(ho.set(10)(Nil) == Nil)
    println("Exercise 1 passed: Head optional")

    // Exercise 2: Optional composition
    val ho2 = headOptional[List[Int]]
    val composed = composeOptional(ho2, headOptional[Int])
    assert(composed.getOption(List(List(1, 2), List(3, 4))) == Some(1))
    assert(composed.getOption(List(Nil, List(3))) == None)
    assert(composed.getOption(Nil) == None)
    println("Exercise 2 passed: Optional composition")

    // Exercise 3: List traversal
    val lt = listTraversal[Int]
    assert(lt.getAll(List(1, 2, 3)) == List(1, 2, 3))
    assert(lt.modifyF(_ * 2)(List(1, 2, 3)) == List(2, 4, 6))
    println("Exercise 3 passed: List traversal")

    // Exercise 4: Map values traversal
    val mt = mapValuesTraversal[String, Int]
    val m = Map("a" -> 1, "b" -> 2)
    assert(mt.getAll(m).sorted == List(1, 2))
    assert(mt.modifyF(_ * 10)(m) == Map("a" -> 10, "b" -> 20))
    println("Exercise 4 passed: Map values traversal")

    // Exercise 5: Traversal composition
    val nested = List(List(1, 2), List(3, 4))
    val outerT = listTraversal[List[Int]]
    val innerT = listTraversal[Int]
    val composedT = composeTraversal(outerT, innerT)
    assert(composedT.getAll(nested) == List(1, 2, 3, 4))
    assert(composedT.modifyF(_ * 10)(nested) == List(List(10, 20), List(30, 40)))
    println("Exercise 5 passed: Traversal composition")

    // Exercise 6: atKey
    val ak = atKey[String, Int]("x")
    assert(ak.getOption(Map("x" -> 1, "y" -> 2)) == Some(1))
    assert(ak.getOption(Map("y" -> 2)) == None)
    assert(ak.set(10)(Map("x" -> 1, "y" -> 2)) == Map("x" -> 10, "y" -> 2))
    println("Exercise 6 passed: atKey optional")

    // Exercise 7: Nested list traversal
    val nlt = nestedListTraversal[Int]
    assert(nlt.getAll(List(List(1, 2), List(3), List(4, 5))) == List(1, 2, 3, 4, 5))
    assert(nlt.modifyF(_ + 100)(List(List(1), List(2, 3))) == List(List(101), List(102, 103)))
    println("Exercise 7 passed: Nested list traversal")

    // Exercise 8: Filter traversal
    val ft = filterTraversal[Int](_ % 2 == 0)
    assert(ft.getAll(List(1, 2, 3, 4, 5)) == List(2, 4))
    assert(ft.modifyF(_ * 10)(List(1, 2, 3, 4, 5)) == List(1, 20, 3, 40, 5))
    println("Exercise 8 passed: Filter traversal")

    println("\nAll exercises passed!")
  }
}
