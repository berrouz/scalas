package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stm._

/**
 * ZIO 053 - TMap: transactional concurrent map.
 *
 * TMap[K, V] is a concurrent map that operates within STM transactions.
 * All operations are atomic and composable with other STM operations.
 */
object Zio053_TMap {

  // Exercise 1: Create a TMap and put a key-value pair
  // TODO: TMap.empty[String, Int].flatMap(m => m.put("a", 1) *> m.get("a")).commit
  val exercise1: UIO[Option[Int]] = ???

  // Exercise 2: Create a TMap from initial entries
  // TODO: TMap.make(("a", 1), ("b", 2)).flatMap(_.get("b")).commit
  val exercise2: UIO[Option[Int]] = ???

  // Exercise 3: Delete a key from TMap
  // TODO: Create a TMap with entries, delete one, verify it's gone
  val exercise3: UIO[Option[Int]] = ???

  // Exercise 4: Convert TMap to a regular Map
  // TODO: tmap.toMap.commit => Map[String, Int]
  val exercise4: UIO[Map[String, Int]] = ???

  // Exercise 5: Get all keys from a TMap
  // TODO: tmap.keys.commit => List[String]
  val exercise5: UIO[List[String]] = ???

  // Exercise 6: Get all values from a TMap
  // TODO: tmap.values.commit => List[Int]
  val exercise6: UIO[List[Int]] = ???

  // Exercise 7: Check if a TMap contains a key
  // TODO: tmap.contains("a").commit => true/false
  val exercise7: UIO[(Boolean, Boolean)] = ???

  // Exercise 8: Use TMap for a concurrent word counter
  // TODO: Fork multiple fibers that increment word counts in a TMap atomically
  val exercise8: UIO[Map[String, Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1.contains(1), s"Exercise 1 failed: expected Some(1), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.contains(2), s"Exercise 2 failed: expected Some(2), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.isEmpty, s"Exercise 3 failed: expected None, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.nonEmpty, s"Exercise 4 failed: got empty map")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.nonEmpty, s"Exercise 5 failed: got empty list")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.nonEmpty, s"Exercise 6 failed: got empty list")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7._1, s"Exercise 7 failed: expected true for existing key")
    assert(!r7._2, s"Exercise 7 failed: expected false for missing key")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty map")
    println(s"Exercise 8 passed: $r8")

    println("All Zio053_TMap exercises passed!")
  }
}
