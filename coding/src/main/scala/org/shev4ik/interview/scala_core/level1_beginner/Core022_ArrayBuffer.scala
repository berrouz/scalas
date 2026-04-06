package org.shev4ik.interview.scala_core.level1_beginner

import scala.collection.mutable.ArrayBuffer

object Core022_ArrayBuffer {

  // Exercise 1: Array creation
  // TODO: Create an Array(1, 2, 3, 4, 5). Access element at index 2.
  //       Return (array.length, element).
  def exercise1_arrayCreation: (Int, Int) = ???

  // Exercise 2: ArrayBuffer (mutable, resizable)
  // TODO: Create an ArrayBuffer[Int](), append 1, 2, 3 using +=.
  //       Remove the element at index 1 using .remove(1).
  //       Return the ArrayBuffer as a List.
  def exercise2_arrayBuffer: List[Int] = ???

  // Exercise 3: Vector (immutable, indexed)
  // TODO: Create a Vector(1, 2, 3, 4, 5). Append 6 using :+.
  //       Prepend 0 using +:.  Update index 2 to 99 using .updated(2, 99).
  //       Return (appended.last, prepended.head, updated(2)).
  def exercise3_vector: (Int, Int, Int) = ???

  // Exercise 4: IndexedSeq
  // TODO: Create an IndexedSeq(10, 20, 30, 40, 50).
  //       Access element at index 3. Return the element.
  //       Note: IndexedSeq defaults to Vector in Scala 2.13.
  def exercise4_indexedSeq: Int = ???

  // Exercise 5: Mutable vs immutable
  // TODO: Demonstrate the difference:
  //       1. Create an immutable List(1, 2, 3), append 4 => new list (original unchanged)
  //       2. Create a mutable ArrayBuffer(1, 2, 3), append 4 => same buffer modified
  //       Return (originalList.length, newList.length, buffer.length).
  def exercise5_mutableVsImmutable: (Int, Int, Int) = ???

  // Exercise 6: Performance characteristics
  // TODO: Demonstrate the performance difference:
  //       List is O(1) for head/prepend, O(n) for index access and append.
  //       Vector is O(~1) (effectively constant) for both indexed access and append.
  //       Array is O(1) for indexed access, but fixed size.
  //       Create a List, Vector, and Array with 1 to 5. Access index 2 from each.
  //       Return (listElem, vectorElem, arrayElem) — all should be 3.
  def exercise6_performance: (Int, Int, Int) = ???

  // Exercise 7: Conversion between collections
  // TODO: Convert between collection types:
  //       Array(1,2,3).toList, List(1,2,3).toVector, Vector(1,2,3).toArray.toList
  //       Return (fromArray, fromList, fromVector) — all should be List(1,2,3).
  def exercise7_conversion: (List[Int], Vector[Int], List[Int]) = ???

  // Exercise 8: Array vs List characteristics
  // TODO: Demonstrate key differences:
  //       1. Array is mutable — update element at index 1 to 99 in Array(1, 2, 3)
  //       2. List is immutable — cannot modify in place
  //       3. Array preserves Java interop, List is purely Scala
  //       Create Array(1, 2, 3), modify index 1 to 99. Return array as List.
  def exercise8_arrayVsList: List[Int] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_arrayCreation == (5, 3), "Exercise 1 failed")

    assert(exercise2_arrayBuffer == List(1, 3), "Exercise 2 failed")

    assert(exercise3_vector == (6, 0, 99), "Exercise 3 failed")

    assert(exercise4_indexedSeq == 40, "Exercise 4 failed")

    val (origLen, newLen, bufLen) = exercise5_mutableVsImmutable
    assert(origLen == 3, "Exercise 5 failed: original")
    assert(newLen == 4, "Exercise 5 failed: new")
    assert(bufLen == 4, "Exercise 5 failed: buffer")

    assert(exercise6_performance == (3, 3, 3), "Exercise 6 failed")

    val (fromArr, fromList, fromVec) = exercise7_conversion
    assert(fromArr == List(1, 2, 3), "Exercise 7 failed: fromArray")
    assert(fromList == Vector(1, 2, 3), "Exercise 7 failed: fromList")
    assert(fromVec == List(1, 2, 3), "Exercise 7 failed: fromVector")

    assert(exercise8_arrayVsList == List(1, 99, 3), "Exercise 8 failed")

    println("All Core022_ArrayBuffer exercises passed!")
  }
}
