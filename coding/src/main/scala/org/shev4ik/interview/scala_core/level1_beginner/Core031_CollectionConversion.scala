package org.shev4ik.interview.scala_core.level1_beginner

object Core031_CollectionConversion {

  // Exercise 1: toList
  // TODO: Convert Vector(1, 2, 3) to a List. Return the result.
  def exercise1_toList: List[Int] = ???

  // Exercise 2: toSet
  // TODO: Convert List(1, 2, 2, 3, 3, 3) to a Set. Return the result.
  def exercise2_toSet: Set[Int] = ???

  // Exercise 3: toMap
  // TODO: Convert List(("a", 1), ("b", 2), ("c", 3)) to a Map. Return the result.
  def exercise3_toMap: Map[String, Int] = ???

  // Exercise 4: toArray
  // TODO: Convert List(1, 2, 3) to an Array. Return the array as a List (for easy assertion).
  def exercise4_toArray: List[Int] = ???

  // Exercise 5: toVector
  // TODO: Convert List(1, 2, 3, 4, 5) to a Vector. Return the result.
  def exercise5_toVector: Vector[Int] = ???

  // Exercise 6: to(collection) factory
  // TODO: In Scala 2.13, use .to(Collection) syntax:
  //       List(1, 2, 3).to(Vector) => Vector(1, 2, 3)
  //       List(1, 2, 2, 3).to(Set) => Set(1, 2, 3)
  //       Return (asVector, asSet).
  def exercise6_toFactory: (Vector[Int], Set[Int]) = ???

  // Exercise 7: view conversions (lazy)
  // TODO: Use .view for lazy evaluation:
  //       List(1,2,3,4,5).view.map(_ * 2).filter(_ > 4).toList
  //       The view makes map and filter lazy — only materialized when .toList is called.
  //       Return the result.
  def exercise7_viewConversions: List[Int] = ???

  // Exercise 8: collect with specific target type
  // TODO: Use collect to filter and transform, then convert:
  //       List(1, "two", 3, "four", 5).collect { case i: Int => i * 10 }
  //       Return the result as a Vector.
  def exercise8_collectToSpecific: Vector[Int] = ???

  // Exercise 9 (Bonus - 6 exercises for last file, so this is extra):
  // Keeping 8 exercises as specified, using implicit conversions between as topic.
  // Actually, let's use exercise 8 as the last one and keep just collect.

  def main(args: Array[String]): Unit = {
    assert(exercise1_toList == List(1, 2, 3), "Exercise 1 failed")

    assert(exercise2_toSet == Set(1, 2, 3), "Exercise 2 failed")

    assert(exercise3_toMap == Map("a" -> 1, "b" -> 2, "c" -> 3), "Exercise 3 failed")

    assert(exercise4_toArray == List(1, 2, 3), "Exercise 4 failed")

    assert(exercise5_toVector == Vector(1, 2, 3, 4, 5), "Exercise 5 failed")

    val (asVec, asSet) = exercise6_toFactory
    assert(asVec == Vector(1, 2, 3), "Exercise 6 failed: vector")
    assert(asSet == Set(1, 2, 3), "Exercise 6 failed: set")

    assert(exercise7_viewConversions == List(6, 8, 10), "Exercise 7 failed")

    assert(exercise8_collectToSpecific == Vector(10, 30, 50), "Exercise 8 failed")

    println("All Core031_CollectionConversion exercises passed!")
  }
}
