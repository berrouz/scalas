package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 020 - Non-Empty Collections
 *
 * Cats provides non-empty variants of common collections that guarantee
 * at least one element at the type level, enabling safer APIs.
 */
object Cats020_NonEmptyCollections {

  // Exercise 1: NonEmptyList - the most commonly used non-empty collection
  // TODO: Create a NonEmptyList and demonstrate basic operations: head, tail, size.
  def exercise1_nonEmptyList(): (Int, List[Int], Int) = {
    val nel: NonEmptyList[Int] = ??? // Create NonEmptyList.of(1, 2, 3)

    // Return (head, tail, size)
    ???
  }

  // Exercise 2: NonEmptyVector - non-empty variant with O(1) indexed access
  // TODO: Create a NonEmptyVector and access elements by index.
  def exercise2_nonEmptyVector(): (Int, Option[Int], Vector[Int]) = {
    val nev: NonEmptyVector[Int] = ??? // Create NonEmptyVector.of(10, 20, 30)

    // Return (head, getUnsafe(1) wrapped in Option via get, toVector)
    val head: Int = ???
    val second: Option[Int] = ??? // use .get(1)
    val asVector: Vector[Int] = ???
    (head, second, asVector)
  }

  // Exercise 3: NonEmptyChain - efficient append/prepend non-empty collection
  // TODO: Create a NonEmptyChain and demonstrate append/prepend.
  //       Chain is optimized for repeated concatenation (O(1) append/prepend).
  def exercise3_nonEmptyChain(): (Int, NonEmptyChain[Int]) = {
    val nec: NonEmptyChain[Int] = ??? // Create NonEmptyChain.of(1, 2, 3)

    // Prepend 0 and append 4
    val result: NonEmptyChain[Int] = ???
    (nec.head, result)
  }

  // Exercise 4: NonEmptySet - non-empty sorted set
  // TODO: Create a NonEmptySet. Note: NonEmptySet requires an Order instance.
  def exercise4_nonEmptySet(): (Int, Boolean, Int) = {
    val nes: NonEmptySet[Int] = ??? // Create NonEmptySet.of(3, 1, 2, 5, 4)

    // Return (minimum element, contains(3), size)
    ???
  }

  // Exercise 5: NonEmptyMap - non-empty sorted map
  // TODO: Create a NonEmptyMap from key-value pairs.
  def exercise5_nonEmptyMap(): (Option[String], Int) = {
    val nem: NonEmptyMap[Int, String] = ??? // Create NonEmptyMap.of(1 -> "a", 2 -> "b", 3 -> "c")

    // Return (lookup(2), length)
    ???
  }

  // Exercise 6: concatNel - concatenate NonEmptyLists
  // TODO: Concatenate two NonEmptyLists using concatNel (or :::).
  def exercise6_concatNel(): NonEmptyList[Int] = {
    val nel1 = NonEmptyList.of(1, 2, 3)
    val nel2 = NonEmptyList.of(4, 5, 6)

    // Concatenate nel1 and nel2
    ???
  }

  // Exercise 7: groupByNel - group a NonEmptyList by a key function
  // TODO: Use groupByNem or groupBy to group elements by a key.
  //       Returns a NonEmptyMap of NonEmptyLists.
  def exercise7_groupByNel(): Map[String, NonEmptyList[Int]] = {
    val numbers = NonEmptyList.of(1, 2, 3, 4, 5, 6)

    // Group by "even" or "odd"
    // Use .groupBy(n => if (n % 2 == 0) "even" else "odd") and convert to Map
    ???
  }

  // Exercise 8: toNel - safe conversion from possibly-empty to non-empty
  // TODO: Convert various collections to their non-empty counterparts.
  def exercise8_toNel(): (Option[NonEmptyList[Int]], Option[NonEmptyList[Int]], Option[NonEmptyChain[String]]) = {
    val list1 = List(1, 2, 3)
    val list2 = List.empty[Int]
    val chain1 = Chain("a", "b")

    // Convert each to their non-empty Option variant
    val nel1: Option[NonEmptyList[Int]] = ???   // list1.toNel
    val nel2: Option[NonEmptyList[Int]] = ???   // list2.toNel
    val nec1: Option[NonEmptyChain[String]] = ??? // chain1.toNec ... but Chain doesn't have toNec, use NonEmptyChain.fromChain

    (nel1, nel2, nec1)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (h1, t1, s1) = exercise1_nonEmptyList()
    assert(h1 == 1 && t1 == List(2, 3) && s1 == 3, s"Exercise 1 failed: ($h1, $t1, $s1)")
    println(s"Exercise 1 passed: NonEmptyList => head=$h1, tail=$t1, size=$s1")

    // Exercise 2
    val (h2, s2, v2) = exercise2_nonEmptyVector()
    assert(h2 == 10 && s2 == Some(20) && v2 == Vector(10, 20, 30), s"Exercise 2 failed")
    println(s"Exercise 2 passed: NonEmptyVector => head=$h2, second=$s2, vector=$v2")

    // Exercise 3
    val (h3, r3) = exercise3_nonEmptyChain()
    assert(h3 == 1, s"Exercise 3 failed: head=$h3")
    assert(r3.toList == List(0, 1, 2, 3, 4), s"Exercise 3 failed: result=${r3.toList}")
    println(s"Exercise 3 passed: NonEmptyChain => head=$h3, withPrependAppend=${r3.toList}")

    // Exercise 4
    val (min4, contains4, size4) = exercise4_nonEmptySet()
    assert(min4 == 1 && contains4 && size4 == 5, s"Exercise 4 failed: ($min4, $contains4, $size4)")
    println(s"Exercise 4 passed: NonEmptySet => min=$min4, contains3=$contains4, size=$size4")

    // Exercise 5
    val (lookup5, len5) = exercise5_nonEmptyMap()
    assert(lookup5 == Some("b") && len5 == 3, s"Exercise 5 failed: ($lookup5, $len5)")
    println(s"Exercise 5 passed: NonEmptyMap => lookup(2)=$lookup5, length=$len5")

    // Exercise 6
    val r6 = exercise6_concatNel()
    assert(r6.toList == List(1, 2, 3, 4, 5, 6), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: concatNel => ${r6.toList}")

    // Exercise 7
    val r7 = exercise7_groupByNel()
    assert(r7("even").toList.sorted == List(2, 4, 6), s"Exercise 7 failed: $r7")
    assert(r7("odd").toList.sorted == List(1, 3, 5), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: groupByNel => $r7")

    // Exercise 8
    val (nel8a, nel8b, nec8) = exercise8_toNel()
    assert(nel8a.isDefined && nel8b.isEmpty && nec8.isDefined, s"Exercise 8 failed")
    println(s"Exercise 8 passed: toNel => nel1=$nel8a, nel2=$nel8b, nec=$nec8")

    println("\nAll Cats020_NonEmptyCollections exercises passed!")
  }
}
