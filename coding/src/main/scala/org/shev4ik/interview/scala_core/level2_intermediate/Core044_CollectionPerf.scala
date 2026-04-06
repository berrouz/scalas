package org.shev4ik.interview.scala_core.level2_intermediate

object Core044_CollectionPerf {

  // Exercise 1: List vs Vector complexity
  // TODO: Implement a method that prepends n elements to a List and a Vector
  //       Return the time taken for each as (listTime, vectorTime) in nanoseconds
  //       List prepend is O(1), Vector prepend is O(log32(n)) effectively O(1)
  //       List random access is O(n), Vector random access is O(log32(n)) effectively O(1)
  def comparePrepend(n: Int): (Long, Long) = ???

  // TODO: Return which collection is better for random access: "List" or "Vector"
  def betterForRandomAccess: String = ???

  // Exercise 2: immutable.Map impl
  // TODO: Explain the internal implementation of immutable.Map for different sizes
  //       Return the implementation class name for maps of size 0, 1, 4, and 5+
  //       Hint: Map.empty, Map1, Map2, Map3, Map4, HashMap for 5+
  def mapImplName(size: Int): String = ???

  // Exercise 3: Mutable vs immutable perf
  // TODO: Implement a method that builds a collection of n integers
  //       using mutable.ListBuffer vs immutable List (prepend + reverse)
  //       Return which approach is better for building: "mutable" or "immutable"
  def betterForBuilding: String = ???

  // TODO: Create n elements using ListBuffer and return the result as List
  def buildWithListBuffer(n: Int): List[Int] = ???

  // Exercise 4: Array vs ArrayBuffer
  // TODO: Describe when to use Array vs ArrayBuffer
  //       Array: fixed size, Java interop, primitive specialization
  //       ArrayBuffer: dynamic size, append O(1) amortized
  //       Return true if Array is better for fixed-size numeric data
  def arrayBetterForFixedNumeric: Boolean = ???

  // TODO: Create an ArrayBuffer, add elements, convert to Array
  def buildArray(elements: Int*): Array[Int] = ???

  // Exercise 5: Set implementations
  // TODO: Return the recommended Set implementation for each use case:
  //       - "HashSet" for general purpose O(1) lookup
  //       - "TreeSet" for sorted iteration
  //       - "BitSet" for small non-negative integers
  //       - "ListSet" for small sets preserving insertion order
  def recommendedSet(useCase: String): String = ???

  // Exercise 6: Queue implementations
  // TODO: Demonstrate immutable.Queue usage
  //       Implement enqueue, dequeue operations
  //       Return (dequeuedElement, remainingQueue) from a queue of 1,2,3
  def queueOperations(): (Int, scala.collection.immutable.Queue[Int]) = ???

  // Exercise 7: Choosing collection
  // TODO: Given requirements, return the best collection type name:
  //       - "need fast append and prepend" => "ArrayDeque" or "Vector"
  //       - "need fast lookup by key" => "HashMap"
  //       - "need sorted elements" => "TreeSet" or "TreeMap"
  //       - "need FIFO" => "Queue"
  //       - "need LIFO" => "List" (or Stack)
  //       - "need indexed access" => "Vector" or "Array"
  def bestCollection(requirement: String): String = ???

  // Exercise 8: Benchmarking approach
  // TODO: Implement a simple benchmarking method that runs a block n times
  //       and returns the average time in nanoseconds
  //       Use System.nanoTime for measurement
  def benchmark(iterations: Int)(block: => Unit): Long = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val (listTime, vectorTime) = comparePrepend(10000)
    assert(listTime > 0 && vectorTime > 0, "Both should take positive time")
    assert(betterForRandomAccess == "Vector", "Vector is better for random access")

    // Exercise 2 assertions
    assert(mapImplName(0).nonEmpty, "Empty map has an impl name")
    assert(mapImplName(1).nonEmpty, "Map of size 1 has an impl name")
    assert(mapImplName(5).nonEmpty, "Map of size 5 has an impl name")

    // Exercise 3 assertions
    assert(betterForBuilding == "mutable", "Mutable is generally better for building")
    assert(buildWithListBuffer(5) == List(0, 1, 2, 3, 4), "buildWithListBuffer should produce 0 to 4")

    // Exercise 4 assertions
    assert(arrayBetterForFixedNumeric, "Array is better for fixed-size numeric data")
    assert(buildArray(1, 2, 3).toList == List(1, 2, 3), "buildArray should create array from varargs")

    // Exercise 5 assertions
    assert(recommendedSet("general") == "HashSet", "HashSet for general purpose")
    assert(recommendedSet("sorted") == "TreeSet", "TreeSet for sorted")
    assert(recommendedSet("small integers") == "BitSet", "BitSet for small integers")

    // Exercise 6 assertions
    val (elem, remaining) = queueOperations()
    assert(elem == 1, "First dequeued should be 1")
    assert(remaining.toList == List(2, 3), "Remaining should be [2, 3]")

    // Exercise 7 assertions
    assert(bestCollection("need fast lookup by key") == "HashMap", "HashMap for lookup by key")
    assert(bestCollection("need indexed access") == "Vector", "Vector for indexed access")

    // Exercise 8 assertions
    val avgTime = benchmark(100) { (1 to 1000).sum }
    assert(avgTime > 0, "Benchmark should return positive time")

    println("All Core044_CollectionPerf exercises passed!")
  }
}
