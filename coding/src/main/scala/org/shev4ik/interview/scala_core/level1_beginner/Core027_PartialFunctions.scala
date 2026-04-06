package org.shev4ik.interview.scala_core.level1_beginner

object Core027_PartialFunctions {

  // Exercise 1: PartialFunction definition
  // TODO: Define a PartialFunction[Int, String] that handles:
  //       1 => "one", 2 => "two", 3 => "three"
  //       (It is not defined for other values.)
  def exercise1_partialFunction: PartialFunction[Int, String] = ???

  // Exercise 2: isDefinedAt
  // TODO: Using the PartialFunction from exercise 1 concept,
  //       define a PF for even numbers: { case n if n % 2 == 0 => s"even: $n" }
  //       Check isDefinedAt(4) and isDefinedAt(3). Return (definedAt4, definedAt3).
  def exercise2_isDefinedAt: (Boolean, Boolean) = ???

  // Exercise 3: orElse
  // TODO: Define two partial functions:
  //       val positive: PF[Int, String] = { case n if n > 0 => "positive" }
  //       val negative: PF[Int, String] = { case n if n < 0 => "negative" }
  //       Combine them with orElse and apply to 5 and -3.
  //       Return (result5, resultMinus3).
  def exercise3_orElse: (String, String) = ???

  // Exercise 4: andThen on PartialFunction
  // TODO: Define a PF that doubles even numbers: { case n if n % 2 == 0 => n * 2 }
  //       Chain with andThen(_.toString) to convert the result to String.
  //       Apply to 4. Return the result.
  def exercise4_andThen: String = ???

  // Exercise 5: collect
  // TODO: Use collect (which takes a PartialFunction) on a list:
  //       List(1, 2, 3, 4, 5, 6).collect { case n if n % 2 == 0 => n * n }
  //       This filters and maps in one step. Return the result.
  def exercise5_collect: List[Int] = ???

  // Exercise 6: lift (PF to total function returning Option)
  // TODO: Define a PF[Int, String] that handles 1 => "one", 2 => "two".
  //       Lift it to a total function: pf.lift
  //       Apply lift(1) and lift(99). Return (result1, result99).
  def exercise6_lift: (Option[String], Option[String]) = ???

  // Exercise 7: unlift (total function to PF)
  // TODO: Define a total function f: Int => Option[String] =
  //       n => if (n > 0) Some(s"pos: $n") else None
  //       Use Function.unlift(f) to create a PartialFunction.
  //       Check isDefinedAt(5) and isDefinedAt(-1). Return (defined5, definedMinus1).
  def exercise7_unlift: (Boolean, Boolean) = ???

  // Exercise 8: case syntax as PF
  // TODO: Demonstrate that a block of case statements is a PartialFunction.
  //       val pf: PartialFunction[Any, String] = {
  //         case s: String => s"string: $s"
  //         case i: Int => s"int: $i"
  //       }
  //       Apply to "hello" and 42. Return (resultString, resultInt).
  def exercise8_caseSyntaxAsPF: (String, String) = ???

  def main(args: Array[String]): Unit = {
    val pf1 = exercise1_partialFunction
    assert(pf1(1) == "one", "Exercise 1 failed: 1")
    assert(pf1(2) == "two", "Exercise 1 failed: 2")
    assert(pf1(3) == "three", "Exercise 1 failed: 3")

    assert(exercise2_isDefinedAt == (true, false), "Exercise 2 failed")

    assert(exercise3_orElse == ("positive", "negative"), "Exercise 3 failed")

    assert(exercise4_andThen == "8", "Exercise 4 failed")

    assert(exercise5_collect == List(4, 16, 36), "Exercise 5 failed")

    val (l1, l99) = exercise6_lift
    assert(l1 == Some("one"), "Exercise 6 failed: 1")
    assert(l99 == None, "Exercise 6 failed: 99")

    assert(exercise7_unlift == (true, false), "Exercise 7 failed")

    assert(exercise8_caseSyntaxAsPF == ("string: hello", "int: 42"), "Exercise 8 failed")

    println("All Core027_PartialFunctions exercises passed!")
  }
}
