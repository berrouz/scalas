package org.shev4ik.interview.scala_core.level1_beginner

object Core028_Imports {

  // Exercise 1: Import package
  // TODO: Import scala.collection.mutable and create a mutable.ListBuffer[Int].
  //       Append 1, 2, 3 and return as a List.
  def exercise1_importPackage: List[Int] = {
    import scala.collection.mutable
    ???
  }

  // Exercise 2: Import specific members
  // TODO: Import only ListBuffer from scala.collection.mutable.
  //       Create a ListBuffer("a", "b", "c") and return as a List.
  def exercise2_importSpecific: List[String] = {
    import scala.collection.mutable.ListBuffer
    ???
  }

  // Exercise 3: Import with rename
  // TODO: Import java.util.{HashMap => JavaHashMap} to rename the import.
  //       Create a JavaHashMap[String, Int], put "key" -> 42, and return the value for "key".
  def exercise3_importRename: Int = {
    import java.util.{HashMap => JavaHashMap}
    ???
  }

  // Exercise 4: Import with hide
  // TODO: Import everything from scala.collection.mutable EXCEPT HashMap:
  //       import scala.collection.mutable.{HashMap => _, _}
  //       Create a mutable.ListBuffer[Int](1, 2, 3) to prove ListBuffer is available.
  //       Return the list.
  def exercise4_importHide: List[Int] = {
    import scala.collection.mutable.{HashMap => _, _}
    ???
  }

  // Exercise 5: Import all members
  // TODO: Import all members from scala.math using `import scala.math._`
  //       Compute sqrt(16.0) + pow(2.0, 3.0) + Pi (rounded to 2 decimal places).
  //       Return the result rounded: math.round(result * 100) / 100.0
  def exercise5_importAll: Double = {
    import scala.math._
    ???
  }

  // Exercise 6: Relative imports (import inside a scope)
  // TODO: Demonstrate that imports can be scoped.
  //       Inside a block, import scala.util.Random.
  //       Create a Random with seed 42, get nextInt(100), and return it.
  //       The import is only valid inside the block.
  def exercise6_relativeImports: Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_importPackage == List(1, 2, 3), "Exercise 1 failed")

    assert(exercise2_importSpecific == List("a", "b", "c"), "Exercise 2 failed")

    assert(exercise3_importRename == 42, "Exercise 3 failed")

    assert(exercise4_importHide == List(1, 2, 3), "Exercise 4 failed")

    val result5 = exercise5_importAll
    assert(math.abs(result5 - 15.14) < 0.01, s"Exercise 5 failed: got $result5")

    // Exercise 6: deterministic because we use a seed
    val r = exercise6_relativeImports
    assert(r == new scala.util.Random(42).nextInt(100), "Exercise 6 failed")

    println("All Core028_Imports exercises passed!")
  }
}
