package org.shev4ik.interview.scala_core.level3_advanced

object Core076_Manifests {

  // Exercise 1: Manifest (legacy)
  // TODO: Write a method using Manifest to get the runtime type string of T
  //       Note: Manifest is deprecated in favor of TypeTag but still appears in older code
  @deprecated("Use TypeTag instead", "2.10")
  def manifestTypeName[T](implicit m: Manifest[T]): String = ???

  // Exercise 2: ClassManifest / ClassTag equivalent
  // TODO: Write a method using scala.reflect.ClassTag to create an array of T
  //       This is the modern replacement for ClassManifest
  import scala.reflect.ClassTag
  def createArray[T: ClassTag](size: Int, default: T): Array[T] = ???

  // Exercise 3: manifest method
  // TODO: Write a method that uses manifest[T] to check if two types are the same
  @deprecated("Use TypeTag instead", "2.10")
  def sameManifest[A: Manifest, B: Manifest]: Boolean = ???

  // Exercise 4: Manifest in arrays
  // TODO: Write a method that creates a 2D array using ClassTag
  //       (Historically required Manifest)
  def create2DArray[T: ClassTag](rows: Int, cols: Int): Array[Array[T]] = ???

  // Exercise 5: Migration to TypeTag
  // TODO: Write a pair of methods showing the Manifest way and the TypeTag way
  //       to get type information. Both should return a string describing the type.
  import scala.reflect.runtime.universe._

  @deprecated("Use TypeTag version", "2.10")
  def describeWithManifest[T: Manifest]: String = ???

  def describeWithTypeTag[T: TypeTag]: String = ???

  // Exercise 6: Runtime array creation
  // TODO: Write a method `arrayOfType` that creates an Array and fills it with computed values
  //       using ClassTag for array creation
  def arrayOfType[T: ClassTag](size: Int)(init: Int => T): Array[T] = ???

  // Exercise 7: Manifest erasure info
  // TODO: Write a method that uses ClassTag to check if an Any value is of type T
  def isInstanceOfType[T: ClassTag](value: Any): Boolean = ???

  // Exercise 8: Manifest vs ClassTag
  // TODO: Write a method that demonstrates ClassTag can handle simple types but not
  //       full generic types. Return true if ClassTag can distinguish the types.
  //       For example, ClassTag can't distinguish List[Int] from List[String]
  def classTagCanDistinguish[A: ClassTag, B: ClassTag]: Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(manifestTypeName[Int] == "Int")
    assert(manifestTypeName[String] == "java.lang.String" || manifestTypeName[String] == "String")

    // Exercise 2
    val arr = createArray[Int](3, 0)
    assert(arr.length == 3)
    assert(arr.forall(_ == 0))
    assert(arr.isInstanceOf[Array[Int]])

    // Exercise 3
    assert(sameManifest[Int, Int] == true)
    assert(sameManifest[Int, String] == false)

    // Exercise 4
    val arr2d = create2DArray[Int](2, 3)
    assert(arr2d.length == 2)
    assert(arr2d(0).length == 3)

    // Exercise 5
    val mDesc = describeWithManifest[List[Int]]
    assert(mDesc.nonEmpty)
    val tDesc = describeWithTypeTag[List[Int]]
    assert(tDesc.contains("List") && tDesc.contains("Int"))

    // Exercise 6
    val squares = arrayOfType[Int](5)(i => i * i)
    assert(squares.toList == List(0, 1, 4, 9, 16))

    // Exercise 7
    assert(isInstanceOfType[Int](42) == true)
    assert(isInstanceOfType[String]("hello") == true)
    assert(isInstanceOfType[Int]("hello") == false)

    // Exercise 8
    assert(classTagCanDistinguish[Int, String] == true)
    // ClassTag cannot distinguish List[Int] from List[String] due to erasure
    assert(classTagCanDistinguish[List[Int], List[String]] == false)

    println("All Core076_Manifests exercises passed!")
  }
}
