package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 036 - Chain
 *
 * Chain is an immutable sequence data structure that provides O(1) append and prepend,
 * unlike List (O(1) prepend, O(n) append) or Vector (effectively O(1) but with overhead).
 * Chain is the recommended accumulator type in Cats (used in Validated, Writer, etc.).
 */
object Cats036_Chain {

  // Exercise 1: Chain basics - create and inspect a Chain
  // TODO: Create a Chain from elements and inspect its properties.
  def exercise1_basics(): (Int, List[Int], Boolean) = {
    val chain: Chain[Int] = ??? // Create Chain(1, 2, 3)

    // Return (size, toList, isEmpty)
    ???
  }

  // Exercise 2: Chain.one - create a single-element Chain
  // TODO: Use Chain.one to create a singleton Chain.
  def exercise2_one(): Chain[String] = {
    // Create a Chain with just one element "hello"
    ???
  }

  // Exercise 3: Chain.empty - create an empty Chain
  // TODO: Create an empty Chain and verify its properties.
  def exercise3_empty(): (Chain[Int], Boolean, Int) = {
    val empty: Chain[Int] = ??? // Chain.empty[Int]

    // Return (the chain, isEmpty, size)
    ???
  }

  // Exercise 4: append - add elements to the end (O(1))
  // TODO: Use append (+:+) or :+ to add elements to the Chain.
  def exercise4_append(): Chain[Int] = {
    val chain = Chain(1, 2, 3)

    // Append 4 and 5. Use chain :+ 4 :+ 5 or Chain.append syntax
    ???
  }

  // Exercise 5: prepend - add elements to the front (O(1))
  // TODO: Use prepend to add elements to the front of the Chain.
  def exercise5_prepend(): Chain[Int] = {
    val chain = Chain(3, 4, 5)

    // Prepend 1 and 2. Use n +: chain syntax
    ???
  }

  // Exercise 6: concat - concatenate two Chains (O(1))
  // TODO: Use ++ or Chain.concat to join two Chains.
  def exercise6_concat(): Chain[Int] = {
    val chain1 = Chain(1, 2, 3)
    val chain2 = Chain(4, 5, 6)

    // Concatenate chain1 and chain2
    ???
  }

  // Exercise 7: toList - convert Chain to List
  // TODO: Convert a Chain to a List and other collection types.
  def exercise7_toList(): (List[Int], Vector[Int]) = {
    val chain = Chain(1, 2, 3, 4, 5)

    // Convert to List and Vector
    val list: List[Int] = ???
    val vector: Vector[Int] = ???
    (list, vector)
  }

  // Exercise 8: Chain vs List performance - demonstrate the advantage
  // TODO: Show why Chain is preferred for repeated appends.
  //       List append is O(n) per operation; Chain append is O(1).
  def exercise8_performance(): (Chain[Int], List[Int]) = {
    // Build a Chain by appending 1 to 1000 (O(n) total with Chain)
    val chain: Chain[Int] = (1 to 1000).foldLeft(Chain.empty[Int]) { (acc, n) =>
      ???  // Append n to acc using :+
    }

    // For comparison, building a List by appending is O(n^2) total!
    // Instead, prepend and reverse (which is the idiomatic List way):
    val list: List[Int] = (1 to 1000).foldLeft(List.empty[Int]) { (acc, n) =>
      n :: acc  // Prepend is O(1) for List
    }.reverse

    // Chain is the better choice when you need frequent appends (logs, errors, etc.)
    (chain, list)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (size1, list1, empty1) = exercise1_basics()
    assert(size1 == 3 && list1 == List(1, 2, 3) && !empty1, s"Exercise 1 failed: ($size1, $list1, $empty1)")
    println(s"Exercise 1 passed: Chain basics => size=$size1, list=$list1, empty=$empty1")

    // Exercise 2
    val r2 = exercise2_one()
    assert(r2.toList == List("hello"), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: Chain.one => ${r2.toList}")

    // Exercise 3
    val (chain3, empty3, size3) = exercise3_empty()
    assert(empty3 && size3 == 0, s"Exercise 3 failed: ($empty3, $size3)")
    println(s"Exercise 3 passed: Chain.empty => empty=$empty3, size=$size3")

    // Exercise 4
    val r4 = exercise4_append()
    assert(r4.toList == List(1, 2, 3, 4, 5), s"Exercise 4 failed: ${r4.toList}")
    println(s"Exercise 4 passed: append => ${r4.toList}")

    // Exercise 5
    val r5 = exercise5_prepend()
    assert(r5.toList == List(1, 2, 3, 4, 5), s"Exercise 5 failed: ${r5.toList}")
    println(s"Exercise 5 passed: prepend => ${r5.toList}")

    // Exercise 6
    val r6 = exercise6_concat()
    assert(r6.toList == List(1, 2, 3, 4, 5, 6), s"Exercise 6 failed: ${r6.toList}")
    println(s"Exercise 6 passed: concat => ${r6.toList}")

    // Exercise 7
    val (list7, vec7) = exercise7_toList()
    assert(list7 == List(1, 2, 3, 4, 5) && vec7 == Vector(1, 2, 3, 4, 5), s"Exercise 7 failed")
    println(s"Exercise 7 passed: toList => $list7, toVector => $vec7")

    // Exercise 8
    val (chain8, list8) = exercise8_performance()
    assert(chain8.toList == list8, s"Exercise 8 failed: chains and lists differ")
    assert(chain8.toList.size == 1000, s"Exercise 8 failed: size=${chain8.toList.size}")
    println(s"Exercise 8 passed: Chain vs List performance => both have ${chain8.toList.size} elements")

    println("\nAll Cats036_Chain exercises passed!")
  }
}
