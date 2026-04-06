package org.shev4ik.interview.scala_core.level3_advanced

import scala.reflect.runtime.universe._
import scala.reflect.{ClassTag, classTag}

object Core074_TypeTags {

  // Exercise 1: TypeTag
  // TODO: Write a method `typeName` that returns the string representation of a type
  //       using TypeTag. Example: typeName[Int] => "Int", typeName[List[String]] => "List[String]"
  def typeName[T: TypeTag]: String = ???

  // Exercise 2: ClassTag
  // TODO: Write a method `makeArray` that creates an Array[T] of the given size
  //       using ClassTag (needed to create arrays of generic types at runtime)
  def makeArray[T: ClassTag](size: Int): Array[T] = ???

  // Exercise 3: WeakTypeTag
  // TODO: Write a method `weakTypeName` that returns the type name using WeakTypeTag
  //       WeakTypeTag allows abstract types, unlike TypeTag
  def weakTypeName[T: WeakTypeTag]: String = ???

  // Exercise 4: typeOf
  // TODO: Write a method `isSubtype` that checks if type A is a subtype of type B at runtime
  //       using typeOf and <:< operator on Type
  def isSubtype[A: TypeTag, B: TypeTag]: Boolean = ???

  // Exercise 5: classTag usage
  // TODO: Write a method `filterByType` that filters a List[Any] to only keep elements of type T
  //       using ClassTag for pattern matching
  def filterByType[T: ClassTag](list: List[Any]): List[T] = ???

  // Exercise 6: Runtime type checking
  // TODO: Write a method `isSameType` that checks if two TypeTags represent the same type
  def isSameType[A: TypeTag, B: TypeTag]: Boolean = ???

  // Exercise 7: TypeTag vs ClassTag
  // TODO: Write a method `typeInfo` that returns a tuple of (typeTag info, classTag info)
  //       showing what each provides. Return (full type string, runtime class name)
  def typeInfo[T: TypeTag: ClassTag]: (String, String) = ???

  // Exercise 8: Reified generics
  // TODO: Write a method `matchType` that pattern matches on the type parameter
  //       and returns a description string.
  //       Handle: Int, String, List[Int], List[String], Option[_], and default
  def matchType[T: TypeTag]: String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(typeName[Int] == "Int")
    assert(typeName[List[String]] == "List[String]")

    // Exercise 2
    val arr = makeArray[Int](5)
    assert(arr.length == 5)
    assert(arr.isInstanceOf[Array[Int]])

    // Exercise 3
    assert(weakTypeName[String] == "String")

    // Exercise 4
    assert(isSubtype[String, Any] == true)
    assert(isSubtype[Int, AnyVal] == true)
    assert(isSubtype[String, Int] == false)

    // Exercise 5
    val mixed = List(1, "hello", 2, "world", 3.0)
    assert(filterByType[Int](mixed) == List(1, 2))
    assert(filterByType[String](mixed) == List("hello", "world"))

    // Exercise 6
    assert(isSameType[Int, Int] == true)
    assert(isSameType[Int, String] == false)
    assert(isSameType[List[Int], List[Int]] == true)
    assert(isSameType[List[Int], List[String]] == false)

    // Exercise 7
    val (tInfo, cInfo) = typeInfo[List[Int]]
    assert(tInfo == "List[Int]")
    assert(cInfo.contains("List") || cInfo.contains("list"))

    // Exercise 8
    assert(matchType[Int] == "Int")
    assert(matchType[String] == "String")
    assert(matchType[List[Int]] == "List[Int]")
    assert(matchType[List[String]] == "List[String]")

    println("All Core074_TypeTags exercises passed!")
  }
}
