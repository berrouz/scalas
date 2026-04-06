package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP013 - Iso Basics
 *
 * An Iso[S, A] (isomorphism) witnesses that S and A are equivalent.
 * get: S => A and reverseGet: A => S are inverses of each other.
 * Iso is the most constrained optic - it says the two types are "the same shape."
 */
object AdvFP013_IsoBasics {

  // ============================================================
  // Exercise 1: Define the Iso type
  // ============================================================
  case class Iso[S, A](get: S => A, reverseGet: A => S) {
    def modify(f: A => A)(s: S): S = reverseGet(f(get(s)))
  }

  // TODO: Create an Iso between (A, B) and (B, A) (swap)
  def swapIso[A, B]: Iso[(A, B), (B, A)] = ???

  // ============================================================
  // Exercise 2: Create an Iso for a newtype wrapper
  // ============================================================
  case class Name(value: String)

  // TODO: Iso between Name and String
  val nameIso: Iso[Name, String] = ???

  // ============================================================
  // Exercise 3: Implement Iso composition
  // Given Iso[S, A] and Iso[A, B], produce Iso[S, B]
  // ============================================================
  // TODO: Compose two Isos
  def composeIso[S, A, B](outer: Iso[S, A], inner: Iso[A, B]): Iso[S, B] = ???

  // ============================================================
  // Exercise 4: Implement Iso reverse
  // Given Iso[S, A], produce Iso[A, S]
  // ============================================================
  // TODO: Reverse an Iso
  def reverseIso[S, A](iso: Iso[S, A]): Iso[A, S] = ???

  // ============================================================
  // Exercise 5: Implement the identity Iso
  // ============================================================
  // TODO: Identity Iso[A, A]
  def identityIso[A]: Iso[A, A] = ???

  // ============================================================
  // Exercise 6: Create an Iso between a case class and a tuple
  // ============================================================
  case class Point(x: Double, y: Double)

  // TODO: Iso between Point and (Double, Double)
  val pointTupleIso: Iso[Point, (Double, Double)] = ???

  // ============================================================
  // Exercise 7: Verify Iso laws
  // Law 1: reverseGet(get(s)) == s
  // Law 2: get(reverseGet(a)) == a
  // ============================================================
  // TODO: Verify both Iso laws
  def verifyIsoLaws[S, A](iso: Iso[S, A], s: S, a: A): (Boolean, Boolean) = ???

  // ============================================================
  // Exercise 8: Create an Iso between String and List[Char]
  // and use it to reverse a string.
  // ============================================================
  // TODO: Iso between String and List[Char]
  val stringCharsIso: Iso[String, List[Char]] = ???

  // TODO: Reverse a string using the Iso
  def reverseString(s: String): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: swap iso
    val swap = swapIso[Int, String]
    assert(swap.get((1, "a")) == ("a", 1))
    assert(swap.reverseGet(("a", 1)) == (1, "a"))
    println("Exercise 1 passed: Swap iso")

    // Exercise 2: Name iso
    assert(nameIso.get(Name("Alice")) == "Alice")
    assert(nameIso.reverseGet("Alice") == Name("Alice"))
    println("Exercise 2 passed: Name iso")

    // Exercise 3: Iso composition
    case class Email(value: String)
    val emailIso = Iso[Email, String](_.value, Email)
    val emailNameIso = composeIso(emailIso, reverseIso(nameIso))
    assert(emailNameIso.get(Email("test")) == Name("test"))
    println("Exercise 3 passed: Iso composition")

    // Exercise 4: Reverse iso
    val rev = reverseIso(nameIso)
    assert(rev.get("Bob") == Name("Bob"))
    assert(rev.reverseGet(Name("Bob")) == "Bob")
    println("Exercise 4 passed: Reverse iso")

    // Exercise 5: Identity iso
    val id = identityIso[Int]
    assert(id.get(42) == 42)
    assert(id.reverseGet(42) == 42)
    println("Exercise 5 passed: Identity iso")

    // Exercise 6: Point tuple iso
    val p = Point(1.0, 2.0)
    assert(pointTupleIso.get(p) == (1.0, 2.0))
    assert(pointTupleIso.reverseGet((3.0, 4.0)) == Point(3.0, 4.0))
    println("Exercise 6 passed: Point-tuple iso")

    // Exercise 7: Iso laws
    val (law1, law2) = verifyIsoLaws(nameIso, Name("Alice"), "Alice")
    assert(law1 && law2)
    println("Exercise 7 passed: Iso laws verified")

    // Exercise 8: String reverse via Iso
    assert(reverseString("hello") == "olleh")
    assert(reverseString("") == "")
    println("Exercise 8 passed: Reverse string via Iso")

    println("\nAll exercises passed!")
  }
}
