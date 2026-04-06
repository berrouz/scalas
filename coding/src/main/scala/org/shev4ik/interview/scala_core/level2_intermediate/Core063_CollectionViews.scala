package org.shev4ik.interview.scala_core.level2_intermediate

object Core063_CollectionViews {

  // Exercise 1: view method
  // TODO: Use .view on a collection to create a lazy view
  //       Apply map and filter on a large range, then take only first 5
  //       Without view, all elements would be processed
  def firstFiveSquaresOver10(n: Int): List[Int] = ???

  // Exercise 2: Lazy transformations
  // TODO: Chain multiple transformations using view
  //       The transformations should only be applied when the result is materialized
  //       Apply: filter even, map * 3, filter > 10, take 3
  def lazyChain(list: List[Int]): List[Int] = ???

  // Exercise 3: view vs strict
  // TODO: Demonstrate the difference between strict and view operations
  //       Count how many times a transformation function is called
  //       Return (strictCount, viewCount) where viewCount < strictCount
  def countTransformations(list: List[Int]): (Int, Int) = ???

  // Exercise 4: view for large collections
  // TODO: Process a large range efficiently using view
  //       Find the first number in 1 to 1000000 whose digits sum to 25
  def firstWithDigitSum(targetSum: Int): Option[Int] = ???

  // Exercise 5: force evaluation
  // TODO: Create a view, apply transformations, then force evaluation with .toList
  //       Also demonstrate .to(Vector), .to(Set)
  def viewToList(list: List[Int]): List[Int] = ???
  def viewToVector(list: List[Int]): Vector[Int] = ???
  def viewToSet(list: List[Int]): Set[Int] = ???

  // Exercise 6: view composition
  // TODO: Compose multiple views and demonstrate that computation is deferred
  //       Create a pipeline: view -> map -> filter -> map -> toList
  def pipeline(input: List[String]): List[Int] = ???

  // Exercise 7: LazyList
  // TODO: Create a LazyList (Scala 2.13 replacement for Stream)
  //       Generate Fibonacci numbers lazily and take the first n
  def fibonacci: Stream[BigInt] = ???
  def firstNFibs(n: Int): List[BigInt] = ???

  // Exercise 8: Iterator vs View
  // TODO: Compare Iterator and View:
  //       - Iterator: one-pass, consumed after traversal
  //       - View: can be traversed multiple times, lazy wrapper over collection
  //       Demonstrate by traversing twice
  def iteratorVsView(list: List[Int]): (List[Int], List[Int], List[Int]) = ???
  // Returns: (firstIteratorTraversal, viewTraversal1, viewTraversal2)
  // Iterator would be empty on second traversal

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val result1 = firstFiveSquaresOver10(1000)
    assert(result1.length == 5, "should return 5 elements")
    assert(result1.forall(_ > 10), "all squares should be > 10")

    // Exercise 2 assertions
    val result2 = lazyChain((1 to 20).toList)
    assert(result2.length == 3, "should return 3 elements")
    assert(result2.forall(_ > 10), "all should be > 10")

    // Exercise 3 assertions
    val (strict, view) = countTransformations((1 to 100).toList)
    assert(view <= strict, s"view ($view) should process <= strict ($strict) elements")

    // Exercise 4 assertions
    val found = firstWithDigitSum(25)
    assert(found.isDefined, "should find a number with digit sum 25")
    assert(found.get.toString.map(_.asDigit).sum == 25, "digit sum should be 25")

    // Exercise 5 assertions
    val input = List(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)
    assert(viewToList(input).isInstanceOf[List[_]], "should return List")
    assert(viewToVector(input).isInstanceOf[Vector[_]], "should return Vector")
    assert(viewToSet(input).isInstanceOf[Set[_]], "should return Set")

    // Exercise 6 assertions
    val result6 = pipeline(List("hello", "hi", "hey", "world", "ok"))
    assert(result6.nonEmpty, "pipeline should produce results")

    // Exercise 7 assertions
    val fibs = firstNFibs(10)
    assert(fibs == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34).map(BigInt(_)), "first 10 fibonacci numbers")

    // Exercise 8 assertions
    val (iter1, view1, view2) = iteratorVsView(List(1, 2, 3))
    assert(iter1 == List(2, 4, 6), "first iterator traversal")
    assert(view1 == List(2, 4, 6), "first view traversal")
    assert(view2 == List(2, 4, 6), "second view traversal (view can be reused)")

    println("All Core063_CollectionViews exercises passed!")
  }
}
