package org.shev4ik.interview.scala_core.level2_intermediate

object Core046_GroupBy {

  // Exercise 1: groupBy
  // TODO: Group a list of words by their first character
  //       Return Map[Char, List[String]]
  def groupByFirstChar(words: List[String]): Map[Char, List[String]] = ???

  // Exercise 2: groupMap
  // TODO: Given a list of (name, score) pairs, group by name and collect scores
  //       Using groupMap (Scala 2.13+): groupMap(keyFn)(valueFn)
  def groupScores(entries: List[(String, Int)]): Map[String, List[Int]] = ???

  // Exercise 3: groupMapReduce
  // TODO: Given a list of (department, salary) pairs, compute total salary per department
  //       Using groupMapReduce (Scala 2.13+): groupMapReduce(keyFn)(valueFn)(reduceFn)
  def totalSalaryByDept(entries: List[(String, Int)]): Map[String, Int] = ???

  // Exercise 4: partition
  // TODO: Partition a list of integers into (evens, odds)
  def partitionEvenOdd(list: List[Int]): (List[Int], List[Int]) = ???

  // Exercise 5: span
  // TODO: Use span to split a list at the first element that doesn't satisfy the predicate
  //       Split a sorted list at the first element >= 5
  def splitAtThreshold(list: List[Int], threshold: Int): (List[Int], List[Int]) = ???

  // Exercise 6: splitAt
  // TODO: Split a list at index n, returning (first n elements, rest)
  def splitAtIndex[A](list: List[A], n: Int): (List[A], List[A]) = ???

  // Exercise 7: sliding
  // TODO: Compute moving average with a window of size n
  //       For List(1,2,3,4,5) with window 3: List(2.0, 3.0, 4.0)
  def movingAverage(list: List[Double], window: Int): List[Double] = ???

  // Exercise 8: grouped
  // TODO: Split a list into chunks of size n
  //       For List(1,2,3,4,5) with size 2: List(List(1,2), List(3,4), List(5))
  def chunk[A](list: List[A], size: Int): List[List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val grouped = groupByFirstChar(List("apple", "banana", "avocado", "blueberry"))
    assert(grouped('a') == List("apple", "avocado"), "group by 'a'")
    assert(grouped('b') == List("banana", "blueberry"), "group by 'b'")

    // Exercise 2 assertions
    val scores = groupScores(List(("Alice", 90), ("Bob", 80), ("Alice", 95)))
    assert(scores("Alice") == List(90, 95), "Alice's scores")
    assert(scores("Bob") == List(80), "Bob's scores")

    // Exercise 3 assertions
    val salaries = totalSalaryByDept(List(("IT", 5000), ("HR", 4000), ("IT", 6000)))
    assert(salaries("IT") == 11000, "IT total salary")
    assert(salaries("HR") == 4000, "HR total salary")

    // Exercise 4 assertions
    val (evens, odds) = partitionEvenOdd(List(1, 2, 3, 4, 5, 6))
    assert(evens == List(2, 4, 6), "evens")
    assert(odds == List(1, 3, 5), "odds")

    // Exercise 5 assertions
    val (before, after) = splitAtThreshold(List(1, 2, 3, 5, 6, 7), 5)
    assert(before == List(1, 2, 3), "before threshold")
    assert(after == List(5, 6, 7), "after threshold")

    // Exercise 6 assertions
    val (first, rest) = splitAtIndex(List("a", "b", "c", "d"), 2)
    assert(first == List("a", "b"), "first 2")
    assert(rest == List("c", "d"), "rest after 2")

    // Exercise 7 assertions
    val avg = movingAverage(List(1.0, 2.0, 3.0, 4.0, 5.0), 3)
    assert(avg == List(2.0, 3.0, 4.0), "moving average with window 3")

    // Exercise 8 assertions
    assert(chunk(List(1, 2, 3, 4, 5), 2) == List(List(1, 2), List(3, 4), List(5)), "chunk by 2")
    assert(chunk(List(1, 2, 3), 3) == List(List(1, 2, 3)), "chunk by 3 exact")

    println("All Core046_GroupBy exercises passed!")
  }
}
