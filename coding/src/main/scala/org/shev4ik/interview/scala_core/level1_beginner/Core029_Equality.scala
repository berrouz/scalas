package org.shev4ik.interview.scala_core.level1_beginner

object Core029_Equality {

  // Exercise 1: == vs eq
  // TODO: Demonstrate the difference between == (structural equality) and eq (reference equality).
  //       val a = new String("hello")
  //       val b = new String("hello")
  //       val c = a
  //       Return (a == b, a eq b, a eq c).
  //       == compares content (true), eq compares references (false for a/b, true for a/c).
  def exercise1_equalsVsEq: (Boolean, Boolean, Boolean) = ???

  // Exercise 2: equals override
  // TODO: Define a class Point(val x: Int, val y: Int) that overrides equals:
  //       Two Points are equal if they have the same x and y.
  //       Check that Point(1, 2) == Point(1, 2) is true and Point(1, 2) == Point(3, 4) is false.
  //       Return (samePoints, differentPoints).
  class Point(val x: Int, val y: Int) {
    override def equals(obj: Any): Boolean = obj match {
      case p: Point => x == p.x && y == p.y
      case _ => false
    }
    override def hashCode(): Int = (x, y).hashCode()
  }

  def exercise2_equalsOverride: (Boolean, Boolean) = ???

  // Exercise 3: hashCode contract
  // TODO: The contract: if a == b, then a.hashCode == b.hashCode.
  //       Using the Point class above, check that equal points have equal hash codes.
  //       Return (areEqual, sameHashCode).
  def exercise3_hashCodeContract: (Boolean, Boolean) = ???

  // Exercise 4: canEqual pattern
  // TODO: Demonstrate the canEqual pattern for safe equality in class hierarchies.
  //       Define a class ColorPoint(x: Int, y: Int, val color: String) extends Point(x, y)
  //       that overrides equals to also check color.
  //       Check: Point(1,2) == ColorPoint(1,2,"red") and ColorPoint(1,2,"red") == Point(1,2)
  //       With proper canEqual, the second should be false.
  //       For simplicity, return whether two ColorPoints with same values are equal.
  class ColorPoint(x: Int, y: Int, val color: String) extends Point(x, y) {
    override def equals(obj: Any): Boolean = obj match {
      case cp: ColorPoint => x == cp.x && y == cp.y && color == cp.color
      case _ => false
    }
    override def hashCode(): Int = (x, y, color).hashCode()
  }

  def exercise4_canEqual: Boolean = ???

  // Exercise 5: Case class equality
  // TODO: Case classes get equals/hashCode for free.
  //       case class Person(name: String, age: Int)
  //       Create Person("Alice", 30) twice and check equality.
  //       Also check that they have the same hashCode. Return (equal, sameHash).
  case class Person(name: String, age: Int)

  def exercise5_caseClassEquality: (Boolean, Boolean) = ???

  // Exercise 6: Reference equality
  // TODO: Use `eq` and `ne` for reference equality checks.
  //       val list1 = List(1, 2, 3)
  //       val list2 = list1         // same reference
  //       val list3 = List(1, 2, 3) // different reference, same content
  //       Return (list1 eq list2, list1 eq list3, list1 == list3).
  def exercise6_referenceEquality: (Boolean, Boolean, Boolean) = ???

  // Exercise 7: Structural equality with collections
  // TODO: Check equality of collections:
  //       List(1,2,3) == List(1,2,3) => true (structural)
  //       Set(1,2,3) == Set(3,2,1) => true (order doesn't matter)
  //       Map("a"->1) == Map("a"->1) => true
  //       Return (listEqual, setEqual, mapEqual).
  def exercise7_structuralEquality: (Boolean, Boolean, Boolean) = ???

  // Exercise 8: Ordering-based comparison
  // TODO: Use Ordering to compare values:
  //       implicitly[Ordering[Int]].compare(3, 5) returns negative (3 < 5)
  //       implicitly[Ordering[Int]].compare(5, 3) returns positive (5 > 3)
  //       implicitly[Ordering[Int]].compare(3, 3) returns 0
  //       Return (lessThan, greaterThan, equal) as (Boolean, Boolean, Boolean)
  //       using the sign of compare result.
  def exercise8_orderingEquality: (Boolean, Boolean, Boolean) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_equalsVsEq == (true, false, true), "Exercise 1 failed")

    assert(exercise2_equalsOverride == (true, false), "Exercise 2 failed")

    val (eq3, hash3) = exercise3_hashCodeContract
    assert(eq3, "Exercise 3 failed: equal")
    assert(hash3, "Exercise 3 failed: hashCode")

    assert(exercise4_canEqual, "Exercise 4 failed")

    assert(exercise5_caseClassEquality == (true, true), "Exercise 5 failed")

    assert(exercise6_referenceEquality == (true, false, true), "Exercise 6 failed")

    assert(exercise7_structuralEquality == (true, true, true), "Exercise 7 failed")

    assert(exercise8_orderingEquality == (true, true, true), "Exercise 8 failed")

    println("All Core029_Equality exercises passed!")
  }
}
