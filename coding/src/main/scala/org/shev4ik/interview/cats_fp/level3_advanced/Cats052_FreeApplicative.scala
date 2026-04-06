package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.free.FreeApplicative

/**
 * Cats 052 - Free Applicative
 *
 * FreeApplicative[F, A] is like Free[F, A] but only provides Applicative,
 * not Monad. This restriction enables static analysis of programs before
 * interpretation, and allows batch optimization of independent operations.
 */
object Cats052_FreeApplicative {

  type ConstListStr[A] = List[String]
  type ConstInt[A] = Int

  // A simple validation algebra
  sealed trait ValidationOp[A]
  case class ValidateNonEmpty(field: String, value: String) extends ValidationOp[String]
  case class ValidateMinLength(field: String, min: Int, value: String) extends ValidationOp[String]
  case class ValidateEmail(field: String, value: String) extends ValidationOp[String]
  case class ValidateAge(field: String, value: Int) extends ValidationOp[Int]

  type Validation[A] = FreeApplicative[ValidationOp, A]

  // Exercise 1: FreeApplicative lift - lift an operation into FreeApplicative
  // TODO: Use FreeApplicative.lift to create a validation step.
  def exercise1_lift(): Validation[String] = {
    // Lift ValidateNonEmpty("name", "Alice") into FreeApplicative
    ???
  }

  // Exercise 2: FreeApplicative.pure - create a pure value
  // TODO: Create a FreeApplicative that returns a pure value.
  def exercise2_pure(): Validation[Int] = {
    // Create a pure FreeApplicative returning 42
    ???
  }

  // Exercise 3: ap (Applicative) - combine FreeApplicative values
  // TODO: Use mapN to combine multiple validations applicatively.
  case class FormData(name: String, email: String, age: Int)

  def exercise3_applicative(): Validation[FormData] = {
    val nameV: Validation[String] = FreeApplicative.lift(ValidateNonEmpty("name", "Alice"))
    val emailV: Validation[String] = FreeApplicative.lift(ValidateEmail("email", "alice@example.com"))
    val ageV: Validation[Int] = FreeApplicative.lift(ValidateAge("age", 25))

    // Combine using mapN to create FormData
    ???
  }

  // Exercise 4: analyze - statically analyze a FreeApplicative program
  // TODO: Use analyze to extract information from a program without running it.
  def exercise4_analyze(): List[String] = {
    val program: Validation[FormData] = exercise3_applicative()

    // Analyze: collect all field names being validated
    // analyze takes a cats.arrow.FunctionK[ValidationOp, Const[M, ?]] where M is a Monoid
    val fieldCollector: cats.arrow.FunctionK[ValidationOp, ConstListStr] =
      new cats.arrow.FunctionK[ValidationOp, ConstListStr] {
        def apply[A](fa: ValidationOp[A]): List[String] = fa match {
          case ValidateNonEmpty(field, _) => List(field)
          case ValidateMinLength(field, _, _) => List(field)
          case ValidateEmail(field, _) => List(field)
          case ValidateAge(field, _) => List(field)
        }
      }

    // Use analyze with the fieldCollector to get all field names
    ???
  }

  // Exercise 5: foldMap - interpret a FreeApplicative program
  // TODO: Create a natural transformation and use foldMap to run the program.
  def exercise5_foldMap(): FormData = {
    val program: Validation[FormData] = exercise3_applicative()

    // Create an interpreter to Id that returns the validated values
    val interpreter: cats.arrow.FunctionK[ValidationOp, Id] = ???

    // Run the program
    program.foldMap(interpreter)
  }

  // Exercise 6: Static analysis - demonstrate the key advantage over Free Monad
  // TODO: Show how FreeApplicative enables knowing all operations upfront.
  def exercise6_staticAnalysis(): (Int, List[String]) = {
    val nameV: Validation[String] = FreeApplicative.lift(ValidateNonEmpty("name", "Alice"))
    val emailV: Validation[String] = FreeApplicative.lift(ValidateEmail("email", "a@b.com"))
    val lengthV: Validation[String] = FreeApplicative.lift(ValidateMinLength("password", 8, "secret123"))

    val program: Validation[(String, String, String)] = (nameV, emailV, lengthV).mapN((a, b, c) => (a, b, c))

    // Count total operations and collect field names
    val counter: cats.arrow.FunctionK[ValidationOp, ConstInt] =
      new cats.arrow.FunctionK[ValidationOp, ConstInt] {
        def apply[A](fa: ValidationOp[A]): Int = 1
      }

    val namer: cats.arrow.FunctionK[ValidationOp, ConstListStr] =
      new cats.arrow.FunctionK[ValidationOp, ConstListStr] {
        def apply[A](fa: ValidationOp[A]): List[String] = fa match {
          case ValidateNonEmpty(f, _) => List(f)
          case ValidateMinLength(f, _, _) => List(f)
          case ValidateEmail(f, _) => List(f)
          case ValidateAge(f, _) => List(f)
        }
      }

    val count: Int = ???     // analyze with counter
    val fields: List[String] = ???  // analyze with namer

    (count, fields)
  }

  // Exercise 7: Batch optimization - show how FreeAp enables batching
  // TODO: Demonstrate how independent operations can be batched.
  sealed trait FetchOp[A]
  case class FetchUser(id: Int) extends FetchOp[String]
  case class FetchOrder(id: Int) extends FetchOp[String]

  type FetchProgram[A] = FreeApplicative[FetchOp, A]

  def exercise7_batchOptimization(): List[String] = {
    val user1: FetchProgram[String] = FreeApplicative.lift(FetchUser(1))
    val user2: FetchProgram[String] = FreeApplicative.lift(FetchUser(2))
    val order1: FetchProgram[String] = FreeApplicative.lift(FetchOrder(100))

    val program: FetchProgram[(String, String, String)] =
      (user1, user2, order1).mapN((a, b, c) => (a, b, c))

    // Analyze to find all fetch operation IDs (could be used for batching)
    val idCollector: cats.arrow.FunctionK[FetchOp, ConstListStr] =
      new cats.arrow.FunctionK[FetchOp, ConstListStr] {
        def apply[A](fa: FetchOp[A]): List[String] = fa match {
          case FetchUser(id) => List(s"user:$id")
          case FetchOrder(id) => List(s"order:$id")
        }
      }

    // Collect all IDs for potential batch fetching
    ???
  }

  // Exercise 8: FreeAp vs Free - compare applicative vs monadic free
  // TODO: Demonstrate the key difference: FreeAp allows static analysis, Free doesn't.
  def exercise8_freeApVsFree(): (String, String) = {
    // FreeApplicative: all operations are known statically (no dependencies)
    val freeApResult = "applicative: operations known at compile time"

    // Free Monad: operations depend on runtime values (no static analysis)
    val freeResult = "monadic: operations depend on previous results"

    // Return both descriptions
    // In practice:
    //   FreeAp: good for validation, batching, static optimization
    //   Free: good for sequential workflows, dependent operations
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_lift()
    println(s"Exercise 1 passed: FreeApplicative.lift created")

    // Exercise 2
    val r2interp: cats.arrow.FunctionK[ValidationOp, Id] = new (ValidationOp ~> Id) {
      def apply[A](fa: ValidationOp[A]): Id[A] = fa match {
        case ValidateNonEmpty(_, v) => v
        case ValidateMinLength(_, _, v) => v
        case ValidateEmail(_, v) => v
        case ValidateAge(_, v) => v
      }
    }
    val r2 = exercise2_pure().foldMap(r2interp)
    assert(r2 == 42, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: pure => $r2")

    // Exercise 3
    val r3 = exercise3_applicative().foldMap(r2interp)
    assert(r3 == FormData("Alice", "alice@example.com", 25), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: applicative => $r3")

    // Exercise 4
    val r4 = exercise4_analyze()
    assert(r4.contains("name") && r4.contains("email") && r4.contains("age"), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: analyze => $r4")

    // Exercise 5
    val r5 = exercise5_foldMap()
    assert(r5 == FormData("Alice", "alice@example.com", 25), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: foldMap => $r5")

    // Exercise 6
    val (r6count, r6fields) = exercise6_staticAnalysis()
    assert(r6count == 3, s"Exercise 6 failed: count=$r6count")
    assert(r6fields.size == 3, s"Exercise 6 failed: fields=$r6fields")
    println(s"Exercise 6 passed: static analysis => count=$r6count, fields=$r6fields")

    // Exercise 7
    val r7 = exercise7_batchOptimization()
    assert(r7.size == 3, s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: batch optimization => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_freeApVsFree()
    assert(r8a.contains("applicative"), s"Exercise 8 failed: $r8a")
    println(s"Exercise 8 passed: FreeAp vs Free => ap=$r8a, free=$r8b")

    println("\nAll Cats052_FreeApplicative exercises passed!")
  }
}
