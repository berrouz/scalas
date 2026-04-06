package org.shev4ik.interview.scala_core.level2_intermediate

import scala.collection.mutable
import scala.collection.generic.CanBuildFrom

object Core066_CanBuildFrom {

  // Exercise 1: CanBuildFrom concept (2.12)
  // TODO: In Scala 2.12, CanBuildFrom[From, Elem, To] was used to determine
  //       the result collection type after map, flatMap, etc.
  //       In 2.13, this was replaced with BuildFrom and Factory.
  //       Explain the concept and return a description string.
  def explainCanBuildFrom: String = ???

  // Exercise 2: BuildFrom (2.13)
  // TODO: Use BuildFrom in Scala 2.13 to create a generic method
  //       that maps over a collection, preserving the collection type
  def mapPreservingType[A, B, CC[X] <: Iterable[X]](
    coll: CC[A]
  )(f: A => B)(implicit bf: CanBuildFrom[CC[A], B, CC[B]]): CC[B] = ???

  // Exercise 3: Custom collection builder
  // TODO: Use mutable.Builder to build a custom collection step by step
  //       Create a method that builds a List from individual additions
  def buildList[A](elements: A*): List[A] = ???

  // Exercise 4: Collection factory
  // TODO: Use Factory (Scala 2.13) to create collections generically
  //       Factory[A, CC[A]] creates CC[A] from elements of type A
  def createCollection[A, C](elements: Iterable[A])(implicit bf: CanBuildFrom[Nothing, A, C]): C = ???

  // Exercise 5: IterableFactory
  // TODO: Use the companion object's methods (which are IterableFactory methods)
  //       to create collections: empty, fill, tabulate, iterate
  def createEmpty[A]: List[A] = ???
  def createFilled(n: Int, value: String): List[String] = ???
  def createTabulated(n: Int): Vector[Int] = ???
  def createIterated(start: Int, n: Int): List[Int] = ???

  // Exercise 6: newBuilder pattern
  // TODO: Use the newBuilder pattern to efficiently build a collection
  //       Demonstrate adding elements one by one and converting to result
  def efficientBuild(n: Int): Vector[Int] = ???

  // Exercise 7: breakOut (2.12) - deprecated
  // TODO: In 2.12, breakOut was used to avoid intermediate collections:
  //       val result: Set[Int] = list.map(f)(breakOut)
  //       In 2.13, use .to(Set) or .view.map(f).to(Set) instead
  //       Implement the 2.13 equivalent
  def mapToSet(list: List[Int]): Set[String] = ???
  def mapToVector(list: List[Int]): Vector[Int] = ???

  // Exercise 8: to(Factory) (2.13)
  // TODO: Use .to(TargetCollection) to convert between collection types
  //       This is the 2.13 way to do what breakOut used to do
  def listToVector[A](list: List[A]): Vector[A] = ???
  def listToSet[A](list: List[A]): Set[A] = ???
  def vectorToList[A](vec: Vector[A]): List[A] = ???
  def iterableToArray(iter: Iterable[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(explainCanBuildFrom.nonEmpty, "should explain CanBuildFrom")

    // Exercise 2 assertions
    val mappedList = mapPreservingType(List(1, 2, 3))(_ * 2)
    assert(mappedList == List(2, 4, 6), "mapPreservingType List")
    val mappedVec = mapPreservingType(Vector(1, 2, 3))(_ * 2)
    assert(mappedVec == Vector(2, 4, 6), "mapPreservingType Vector")

    // Exercise 3 assertions
    assert(buildList(1, 2, 3) == List(1, 2, 3), "buildList")
    assert(buildList[String]() == List.empty[String], "buildList empty")

    // Exercise 4 assertions
    val asList: List[Int] = createCollection[Int, List[Int]](Seq(1, 2, 3))
    assert(asList == List(1, 2, 3), "createCollection List")
    val asSet: Set[Int] = createCollection[Int, Set[Int]](Seq(1, 2, 2, 3))
    assert(asSet == Set(1, 2, 3), "createCollection Set")

    // Exercise 5 assertions
    assert(createEmpty[Int] == Nil, "createEmpty")
    assert(createFilled(3, "x") == List("x", "x", "x"), "createFilled")
    assert(createTabulated(5) == Vector(0, 1, 2, 3, 4), "createTabulated")
    assert(createIterated(1, 4) == List(1, 2, 4, 8), "createIterated (doubling)")

    // Exercise 6 assertions
    assert(efficientBuild(5) == Vector(0, 1, 2, 3, 4), "efficientBuild")

    // Exercise 7 assertions
    assert(mapToSet(List(1, 2, 3)) == Set("1", "2", "3"), "mapToSet")
    assert(mapToVector(List(1, 2, 3)) == Vector(2, 4, 6), "mapToVector")

    // Exercise 8 assertions
    assert(listToVector(List(1, 2, 3)) == Vector(1, 2, 3), "listToVector")
    assert(listToSet(List(1, 2, 2, 3)) == Set(1, 2, 3), "listToSet")
    assert(vectorToList(Vector(1, 2, 3)) == List(1, 2, 3), "vectorToList")
    assert(iterableToArray(List(1, 2, 3)).toList == List(1, 2, 3), "iterableToArray")

    println("All Core066_CanBuildFrom exercises passed!")
  }
}
