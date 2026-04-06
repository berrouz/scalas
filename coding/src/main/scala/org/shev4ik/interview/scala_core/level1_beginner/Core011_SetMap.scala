package org.shev4ik.interview.scala_core.level1_beginner

object Core011_SetMap {

  // Exercise 1: Set creation
  // TODO: Create a Set(1, 2, 3, 2, 1) and return it. Note: duplicates are removed.
  def exercise1_setCreation: Set[Int] = ???

  // Exercise 2: Set add and remove
  // TODO: Starting with Set(1, 2, 3), add 4 (using +) and remove 2 (using -).
  //       Return the resulting set.
  def exercise2_addRemove: Set[Int] = ???

  // Exercise 3: Set contains
  // TODO: Given Set("apple", "banana", "cherry"), check if it contains "banana"
  //       and if it contains "grape". Return (containsBanana, containsGrape).
  def exercise3_contains: (Boolean, Boolean) = ???

  // Exercise 4: Set intersection and union
  // TODO: Given Set(1, 2, 3, 4) and Set(3, 4, 5, 6):
  //       Compute intersection (intersect) and union. Return (intersection, union).
  def exercise4_intersectionUnion: (Set[Int], Set[Int]) = ???

  // Exercise 5: Map creation
  // TODO: Create a Map("one" -> 1, "two" -> 2, "three" -> 3) and return it.
  def exercise5_mapCreation: Map[String, Int] = ???

  // Exercise 6: Map get and getOrElse
  // TODO: Given Map("a" -> 1, "b" -> 2, "c" -> 3):
  //       Use get("b") to return Option[Int] and getOrElse("d", 0) for missing key.
  //       Return (getB, getOrElseD).
  def exercise6_getOrElse: (Option[Int], Int) = ???

  // Exercise 7: Map updated
  // TODO: Given Map("x" -> 10, "y" -> 20):
  //       Add a new key "z" -> 30 using updated (or +).
  //       Update existing key "x" to 100.
  //       Return the resulting map.
  def exercise7_updated: Map[String, Int] = ???

  // Exercise 8: Map operations
  // TODO: Given Map("alice" -> 85, "bob" -> 92, "charlie" -> 78):
  //       1. Get all keys as a Set
  //       2. Get all values as an Iterable and convert to List, then sort
  //       3. Filter entries where value >= 80
  //       Return (keys, sortedValues, filtered).
  def exercise8_mapOps: (Set[String], List[Int], Map[String, Int]) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_setCreation == Set(1, 2, 3), "Exercise 1 failed")

    assert(exercise2_addRemove == Set(1, 3, 4), "Exercise 2 failed")

    assert(exercise3_contains == (true, false), "Exercise 3 failed")

    val (inter, uni) = exercise4_intersectionUnion
    assert(inter == Set(3, 4), "Exercise 4 failed: intersection")
    assert(uni == Set(1, 2, 3, 4, 5, 6), "Exercise 4 failed: union")

    assert(exercise5_mapCreation == Map("one" -> 1, "two" -> 2, "three" -> 3), "Exercise 5 failed")

    assert(exercise6_getOrElse == (Some(2), 0), "Exercise 6 failed")

    assert(exercise7_updated == Map("x" -> 100, "y" -> 20, "z" -> 30), "Exercise 7 failed")

    val (keys, sortedVals, filtered) = exercise8_mapOps
    assert(keys == Set("alice", "bob", "charlie"), "Exercise 8 failed: keys")
    assert(sortedVals == List(78, 85, 92), "Exercise 8 failed: values")
    assert(filtered == Map("alice" -> 85, "bob" -> 92), "Exercise 8 failed: filtered")

    println("All Core011_SetMap exercises passed!")
  }
}
