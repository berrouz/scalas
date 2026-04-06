package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.arrow.FunctionK
import cats.free.Free

/**
 * Cats 056 - Natural Transformation (FunctionK / ~>)
 *
 * A natural transformation (FunctionK or ~>) transforms F[A] to G[A]
 * for all types A, without knowing what A is. This is a morphism between
 * functors and is fundamental to Free monad interpretation.
 */
object Cats056_NaturalTransformation {

  // Exercise 1: FunctionK (~>) - create a natural transformation from Option to List
  // TODO: Create a FunctionK that converts Option[A] to List[A] for any A.
  def exercise1_optionToList(): FunctionK[Option, List] = {
    // Option ~> List: Some(a) => List(a), None => Nil
    ???
  }

  // Exercise 2: Id ~> Option - create a natural transformation from Id to Option
  // TODO: Create a FunctionK that wraps any Id value in Some.
  def exercise2_idToOption(): FunctionK[Id, Option] = {
    // Id ~> Option: a => Some(a)
    ???
  }

  // Exercise 3: Composing FunctionK - compose two natural transformations
  // TODO: Compose Id ~> Option and Option ~> List to get Id ~> List.
  def exercise3_compose(): FunctionK[Id, List] = {
    val idToOption: FunctionK[Id, Option] = exercise2_idToOption()
    val optionToList: FunctionK[Option, List] = exercise1_optionToList()

    // Compose: Id ~> Option ~> List = Id ~> List
    ???
  }

  // Exercise 4: FunctionK for interpreter - use FunctionK to interpret a DSL
  // TODO: Create a FunctionK that interprets a simple DSL to Id.
  sealed trait CalcOp[A]
  case class Add(a: Int, b: Int) extends CalcOp[Int]
  case class Multiply(a: Int, b: Int) extends CalcOp[Int]
  case class Negate(a: Int) extends CalcOp[Int]

  def exercise4_interpreter(): FunctionK[CalcOp, Id] = {
    // Interpret CalcOp to Id by actually performing the computation
    ???
  }

  // Exercise 5: FunctionK and Free - use FunctionK to run Free programs
  // TODO: Use the CalcOp interpreter with Free.foldMap.
  type CalcProgram[A] = Free[CalcOp, A]

  def exercise5_freeWithFunctionK(): Int = {
    val program: CalcProgram[Int] = for {
      sum <- Free.liftF(Add(3, 4))
      product <- Free.liftF(Multiply(sum, 2))
      result <- Free.liftF(Negate(product))
    } yield result

    // Interpret using exercise4_interpreter
    ???
  }

  // Exercise 6: FunctionK to different targets - same DSL, different interpreters
  // TODO: Create an interpreter to Option (returns None for overflow).
  def exercise6_optionInterpreter(): FunctionK[CalcOp, Option] = {
    // Interpret CalcOp to Option: return None if result would overflow Int
    // For simplicity: Negate(Int.MinValue) returns None, else Some(result)
    ???
  }

  // Exercise 7: FunctionK laws - demonstrate naturality condition
  // TODO: Verify that FunctionK preserves structure (naturality).
  def exercise7_laws(): Boolean = {
    val natTrans: FunctionK[Option, List] = exercise1_optionToList()
    val f: Int => String = _.toString

    val value: Option[Int] = Some(42)

    // Naturality: natTrans(value.map(f)) == natTrans(value).map(f)
    // i.e., mapping then transforming == transforming then mapping
    val lhs: List[String] = ???  // natTrans(value.map(f))
    val rhs: List[String] = ???  // natTrans(value).map(f)

    lhs == rhs
  }

  // Exercise 8: Rank-2 polymorphism - FunctionK as rank-2 polymorphic function
  // TODO: Demonstrate that FunctionK works for ALL types A simultaneously.
  def exercise8_rank2(): (List[Int], List[String], List[Boolean]) = {
    val optToList: FunctionK[Option, List] = exercise1_optionToList()

    // The SAME natural transformation works for Int, String, Boolean, etc.
    // This is rank-2 polymorphism: forall A. Option[A] => List[A]
    val ints: List[Int] = ???      // optToList(Some(42))
    val strings: List[String] = ???  // optToList(Some("hello"))
    val bools: List[Boolean] = ???   // optToList(None: Option[Boolean])

    (ints, strings, bools)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_optionToList()
    assert(r1(Some(42)) == List(42), s"Exercise 1 failed: Some")
    assert(r1(None) == Nil, s"Exercise 1 failed: None")
    println(s"Exercise 1 passed: Option ~> List => Some(42)=${r1(Some(42))}, None=${r1(None)}")

    // Exercise 2
    val r2 = exercise2_idToOption()
    assert(r2(42) == Some(42), s"Exercise 2 failed: ${r2(42)}")
    println(s"Exercise 2 passed: Id ~> Option => ${r2(42)}")

    // Exercise 3
    val r3 = exercise3_compose()
    assert(r3(42) == List(42), s"Exercise 3 failed: ${r3(42)}")
    println(s"Exercise 3 passed: composed Id ~> List => ${r3(42)}")

    // Exercise 4
    val r4 = exercise4_interpreter()
    assert(r4(Add(3, 4)) == 7, s"Exercise 4 failed: Add")
    assert(r4(Multiply(3, 4)) == 12, s"Exercise 4 failed: Multiply")
    assert(r4(Negate(5)) == -5, s"Exercise 4 failed: Negate")
    println(s"Exercise 4 passed: CalcOp interpreter => Add=${r4(Add(3, 4))}, Mul=${r4(Multiply(3, 4))}")

    // Exercise 5
    val r5 = exercise5_freeWithFunctionK()
    assert(r5 == -14, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: Free + FunctionK => $r5")

    // Exercise 6
    val r6 = exercise6_optionInterpreter()
    assert(r6(Add(1, 2)) == Some(3), s"Exercise 6 failed: Add")
    assert(r6(Negate(Int.MinValue)) == None, s"Exercise 6 failed: overflow")
    println(s"Exercise 6 passed: Option interpreter => Add=${r6(Add(1, 2))}, overflow=${r6(Negate(Int.MinValue))}")

    // Exercise 7
    val r7 = exercise7_laws()
    assert(r7, s"Exercise 7 failed: naturality violated")
    println(s"Exercise 7 passed: naturality law holds => $r7")

    // Exercise 8
    val (r8a, r8b, r8c) = exercise8_rank2()
    assert(r8a == List(42), s"Exercise 8 failed: ints=$r8a")
    assert(r8b == List("hello"), s"Exercise 8 failed: strings=$r8b")
    assert(r8c == Nil, s"Exercise 8 failed: bools=$r8c")
    println(s"Exercise 8 passed: rank-2 => ints=$r8a, strings=$r8b, bools=$r8c")

    println("\nAll Cats056_NaturalTransformation exercises passed!")
  }
}
