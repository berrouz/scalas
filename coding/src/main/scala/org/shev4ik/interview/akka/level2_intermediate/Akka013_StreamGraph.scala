package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 013 - Stream Graph DSL
 *
 * Akka Streams GraphDSL allows building complex stream topologies:
 *   - Broadcast: fan-out to multiple outputs (1 input -> N outputs)
 *   - Merge: fan-in from multiple inputs (N inputs -> 1 output)
 *   - Zip: combines elements from two inputs into tuples
 *   - Unzip: splits tuples into two outputs
 *   - Balance: distributes elements evenly across outputs
 *   - Partition: routes elements based on a function
 *   - Fan-out/Fan-in: general patterns for splitting and joining streams
 *
 * We simulate these graph operators using pure Scala.
 */
object Akka013_StreamGraph {

  // Exercise 1: Broadcast — send each element to all outputs
  // TODO: Given a list of elements and N output count,
  //   return N copies of the input list (one per output).
  //   In real Akka: GraphDSL broadcast ~> out1, broadcast ~> out2
  def exercise1_broadcast[A](elements: List[A], outputCount: Int): List[List[A]] = ???

  // Exercise 2: Merge — combine multiple input streams into one
  // TODO: Given a list of input streams, merge them by interleaving:
  //   Take one element from each stream in round-robin fashion.
  //   Continue until all streams are exhausted.
  //   In real Akka: Merge[T](inputCount)
  def exercise2_merge[A](inputs: List[List[A]]): List[A] = ???

  // Exercise 3: Zip — combine two streams into tuples
  // TODO: Given two lists, zip them into pairs.
  //   Stop when either list is exhausted (like Akka's Zip).
  //   In real Akka: Zip[A, B]
  def exercise3_zip[A, B](left: List[A], right: List[B]): List[(A, B)] = ???

  // Exercise 4: Unzip — split tuples into two streams
  // TODO: Given a list of tuples, split into two separate lists.
  //   In real Akka: Unzip[A, B]
  def exercise4_unzip[A, B](elements: List[(A, B)]): (List[A], List[B]) = ???

  // Exercise 5: Balance — distribute elements evenly
  // TODO: Given a list of elements and N output count,
  //   distribute elements round-robin across N output lists.
  //   In real Akka: Balance[T](outputCount)
  def exercise5_balance[A](elements: List[A], outputCount: Int): List[List[A]] = ???

  // Exercise 6: Partition — route by function
  // TODO: Given a list of elements and a partition function (A => Int)
  //   that returns the output index (0 to partitionCount-1),
  //   route each element to the appropriate output list.
  //   Return a list of lists indexed by partition number.
  //   In real Akka: Partition[T](outputCount, partitioner)
  def exercise6_partition[A](
    elements: List[A],
    partitionCount: Int,
    partitioner: A => Int
  ): List[List[A]] = ???

  // Exercise 7: Fan-out then Fan-in pattern
  // TODO: Given a list of integers, implement a fan-out/fan-in graph:
  //   1. Broadcast to 3 paths
  //   2. Path 1: multiply by 1 (identity)
  //   3. Path 2: multiply by 2
  //   4. Path 3: multiply by 3
  //   5. Merge all paths by concatenation (path1 ++ path2 ++ path3)
  //   Return the merged result.
  def exercise7_fanOutFanIn(elements: List[Int]): List[Int] = ???

  // Exercise 8: Complex graph — broadcast, transform, zip, merge
  // TODO: Given a list of integers, build this graph:
  //   1. Broadcast to 2 paths
  //   2. Path A: add 10 to each element
  //   3. Path B: multiply by 2 each element
  //   4. Zip paths A and B into tuples
  //   5. Map each tuple (a, b) => a + b
  //   Return the final list.
  //   Example: [1, 2] -> pathA=[11,12], pathB=[2,4] -> zipped=[(11,2),(12,4)] -> [13, 16]
  def exercise8_complexGraph(elements: List[Int]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_broadcast(List(1, 2, 3), 3)
    assert(r1.length == 3, s"Exercise 1 failed: expected 3 outputs, got ${r1.length}")
    assert(r1.forall(_ == List(1, 2, 3)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: ${r1.length} broadcast outputs")

    // Exercise 2
    val r2 = exercise2_merge(List(List(1, 4, 7), List(2, 5), List(3, 6, 8, 9)))
    assert(r2 == List(1, 2, 3, 4, 5, 6, 7, 8, 9), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = exercise3_zip(List(1, 2, 3), List("a", "b"))
    assert(r3 == List((1, "a"), (2, "b")), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val (left4, right4) = exercise4_unzip(List((1, "a"), (2, "b"), (3, "c")))
    assert(left4 == List(1, 2, 3), s"Exercise 4 failed: left = $left4")
    assert(right4 == List("a", "b", "c"), s"Exercise 4 failed: right = $right4")
    println(s"Exercise 4 passed: ($left4, $right4)")

    // Exercise 5
    val r5 = exercise5_balance(List(1, 2, 3, 4, 5), 3)
    assert(r5(0) == List(1, 4), s"Exercise 5 failed: output 0 = ${r5(0)}")
    assert(r5(1) == List(2, 5), s"Exercise 5 failed: output 1 = ${r5(1)}")
    assert(r5(2) == List(3), s"Exercise 5 failed: output 2 = ${r5(2)}")
    println(s"Exercise 5 passed: balanced to $r5")

    // Exercise 6
    val r6 = exercise6_partition[Int](List(1, 2, 3, 4, 5, 6), 3, _ % 3)
    assert(r6(0) == List(3, 6), s"Exercise 6 failed: partition 0 = ${r6(0)}")
    assert(r6(1) == List(1, 4), s"Exercise 6 failed: partition 1 = ${r6(1)}")
    assert(r6(2) == List(2, 5), s"Exercise 6 failed: partition 2 = ${r6(2)}")
    println(s"Exercise 6 passed: partitioned to $r6")

    // Exercise 7
    val r7 = exercise7_fanOutFanIn(List(1, 2, 3))
    assert(r7 == List(1, 2, 3, 2, 4, 6, 3, 6, 9), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = exercise8_complexGraph(List(1, 2, 3))
    assert(r8 == List(13, 16, 19), s"Exercise 8 failed: expected List(13,16,19), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka013_StreamGraph exercises passed!")
  }
}
