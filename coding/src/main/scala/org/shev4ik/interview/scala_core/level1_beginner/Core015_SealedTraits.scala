package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Sealed Traits and Algebraic Data Types (ADTs)=
 *
 * ==Theory: Algebraic Data Types==
 *
 * An '''Algebraic Data Type (ADT)''' is a composite type formed by combining other types.
 * There are two fundamental kinds:
 *
 *  - '''Sum Types''' (also called coproducts or tagged unions): A value is ONE OF several
 *    alternatives. In Scala, modeled as a `sealed trait` with `case class`/`case object` subtypes.
 *    {{{
 *    sealed trait Shape                        // Shape = Circle | Rectangle | Triangle
 *    case class Circle(r: Double) extends Shape
 *    case class Rectangle(w: Double, h: Double) extends Shape
 *    }}}
 *    The number of inhabitants = sum of inhabitants of each alternative (hence "sum type").
 *
 *  - '''Product Types''': A value contains ALL of several fields simultaneously.
 *    Case classes and tuples are product types.
 *    {{{
 *    case class Point(x: Int, y: Int)  // Point = Int AND Int
 *    }}}
 *    The number of inhabitants = product of inhabitants of each field (hence "product type").
 *
 * Most real-world domain models combine both: sealed traits (sum) containing case classes (product).
 *
 * ==Theory: Sealed Trait + Case Class/Object Pattern==
 *
 * The `sealed` keyword restricts all subtypes to be defined in the '''same source file'''.
 * This gives two major benefits:
 *
 *  1. '''Exhaustive match checking:''' The compiler knows all possible subtypes and warns
 *     if your pattern match does not cover all cases.
 *  2. '''Closed world assumption:''' No one can add new subtypes outside the file, making
 *     the hierarchy safe to match on exhaustively.
 *
 * {{{
 * sealed trait Result
 * case class Success(value: Int) extends Result
 * case class Failure(msg: String) extends Result
 *
 * def handle(r: Result): String = r match {
 *   case Success(v)   => s"Got $v"
 *   case Failure(msg) => s"Error: $msg"
 *   // No wildcard needed -- compiler knows this is exhaustive!
 * }
 * }}}
 *
 * ==Theory: Recursive ADTs==
 *
 * ADTs can be recursive -- a subtype can reference the sealed trait in its fields.
 * This is the standard pattern for tree structures, expression languages, and linked lists:
 * {{{
 * sealed trait Expr
 * case class Num(value: Int) extends Expr
 * case class Add(left: Expr, right: Expr) extends Expr    // recursive!
 * case class Mul(left: Expr, right: Expr) extends Expr    // recursive!
 *
 * // Evaluate by structural recursion:
 * def eval(e: Expr): Int = e match {
 *   case Num(v)      => v
 *   case Add(l, r)   => eval(l) + eval(r)
 *   case Mul(l, r)   => eval(l) * eval(r)
 * }
 * }}}
 *
 * ==Theory: Scala 3 Enums==
 *
 * In Scala 3, simple ADTs can be expressed more concisely using `enum`:
 * {{{
 * enum Color:
 *   case Red, Green, Blue
 *
 * enum Shape:
 *   case Circle(r: Double)
 *   case Rectangle(w: Double, h: Double)
 * }}}
 * Under the hood, `enum` compiles to the same sealed trait + case class/object pattern.
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "How do you model a domain in Scala using ADTs? Give an example."'''
 *    Answer: Use a sealed trait as the base and case classes/objects as the variants.
 *    For example, modeling a payment method:
 *    {{{
 *    sealed trait Payment
 *    case class CreditCard(number: String, expiry: String) extends Payment
 *    case class BankTransfer(iban: String) extends Payment
 *    case object Cash extends Payment
 *    }}}
 *    Then use pattern matching to handle each case exhaustively. The sealed keyword ensures
 *    the compiler warns you if you forget a case.
 *
 *  - '''Follow-up: "What is the difference between a sealed trait and a regular trait?"'''
 *    Answer: A sealed trait restricts its subtypes to the same source file, enabling
 *    exhaustive pattern match checking. A regular trait can be extended anywhere, so
 *    the compiler cannot guarantee exhaustive matching.
 *
 *  - '''Follow-up: "Sum types vs product types?"'''
 *    Answer: A sum type represents alternatives (OR) -- a value is one of N possibilities.
 *    A product type represents combinations (AND) -- a value contains all of N fields.
 *    In Scala: `sealed trait` = sum type, `case class` = product type. Most domain models
 *    are sum-of-products: a sealed trait whose cases are case classes with fields.
 *
 *  - '''Follow-up: "Why not just use inheritance with abstract classes?"'''
 *    Answer: You can, but `sealed` is critical for exhaustive matching. Without `sealed`,
 *    anyone can extend the trait in another file, and the compiler cannot check completeness.
 *    ADTs also encourage immutability and value semantics (via case classes), which aligns
 *    with functional programming principles.
 *
 * ==Approach Hints==
 *
 *  - For exhaustive matching (Exercises 1-3), handle every case of the sealed trait -- no wildcard needed.
 *  - For Exercise 5 (recursive ADT), use structural recursion: match on Num/Add/Mul and
 *    call `exercise5_nestedSealed` recursively for left/right subtrees.
 *  - For Exercise 7 (sum types to Either), `Success(v) => Right(v)` and `Failure(msg) => Left(msg)`.
 *  - For Exercise 8, construct the expression tree first, then pass it to your eval function.
 */
object Core015_SealedTraits {

  // Shared types for exercises
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color

  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
  case class Triangle(base: Double, height: Double) extends Shape

  // Exercise 1: Sealed trait basics
  // TODO: Write an exhaustive match on Color and return the color name as a String.
  //       Red => "red", Green => "green", Blue => "blue"
  def exercise1_sealedTraitBasics(color: Color): String = ???

  // Exercise 2: Exhaustive match on Shape
  // TODO: Write an exhaustive match that computes the area of each Shape.
  //       Circle => Pi * r^2, Rectangle => w * h, Triangle => 0.5 * base * height
  def exercise2_exhaustiveMatch(shape: Shape): Double = ???

  // Exercise 3: ADT modeling (Algebraic Data Types)
  // TODO: Define a sealed trait Result with:
  //       case class Success(value: Int) extends Result
  //       case class Failure(message: String) extends Result
  //       Write a function that pattern matches to return:
  //       Success(v) => s"Success: $v", Failure(msg) => s"Failure: $msg"
  sealed trait Result
  case class Success(value: Int) extends Result
  case class Failure(message: String) extends Result

  def exercise3_adtModeling(result: Result): String = ???

  // Exercise 4: Enum-like sealed trait
  // TODO: Using the Color sealed trait above, write a function that maps
  //       a String to a Color Option:
  //       "red" => Some(Red), "green" => Some(Green), "blue" => Some(Blue), _ => None
  def exercise4_enumLike(s: String): Option[Color] = ???

  // Exercise 5: Nested sealed traits
  // TODO: Define nested sealed traits for a simple expression tree:
  //       sealed trait Expr
  //       case class Num(value: Int) extends Expr
  //       case class Add(left: Expr, right: Expr) extends Expr
  //       case class Mul(left: Expr, right: Expr) extends Expr
  //       Write an eval function that evaluates the expression.
  sealed trait Expr
  case class Num(value: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends Expr
  case class Mul(left: Expr, right: Expr) extends Expr

  def exercise5_nestedSealed(expr: Expr): Int = ???

  // Exercise 6: Product types
  // TODO: A product type combines multiple values. Case classes are product types.
  //       Given case class Point(x: Int, y: Int), write a function that returns
  //       the Manhattan distance between two points: |x1-x2| + |y1-y2|.
  case class Point(x: Int, y: Int)

  def exercise6_productTypes(p1: Point, p2: Point): Int = ???

  // Exercise 7: Sum types
  // TODO: A sum type is one of several alternatives (sealed trait + case classes).
  //       Given the Result ADT above, write a function that converts Result to Either:
  //       Success(v) => Right(v), Failure(msg) => Left(msg)
  def exercise7_sumTypes(result: Result): Either[String, Int] = ???

  // Exercise 8: Recursive ADTs
  // TODO: Using the Expr ADT above, build and evaluate the expression: (2 + 3) * 4
  //       Construct it as Mul(Add(Num(2), Num(3)), Num(4)) and evaluate using exercise5.
  //       Return the evaluated result.
  def exercise8_recursiveADT: Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_sealedTraitBasics(Red) == "red", "Exercise 1 failed: red")
    assert(exercise1_sealedTraitBasics(Green) == "green", "Exercise 1 failed: green")
    assert(exercise1_sealedTraitBasics(Blue) == "blue", "Exercise 1 failed: blue")

    assert(math.abs(exercise2_exhaustiveMatch(Circle(1.0)) - math.Pi) < 1e-10, "Exercise 2 failed: circle")
    assert(exercise2_exhaustiveMatch(Rectangle(3.0, 4.0)) == 12.0, "Exercise 2 failed: rect")
    assert(exercise2_exhaustiveMatch(Triangle(6.0, 4.0)) == 12.0, "Exercise 2 failed: triangle")

    assert(exercise3_adtModeling(Success(42)) == "Success: 42", "Exercise 3 failed: success")
    assert(exercise3_adtModeling(Failure("oops")) == "Failure: oops", "Exercise 3 failed: failure")

    assert(exercise4_enumLike("red") == Some(Red), "Exercise 4 failed: red")
    assert(exercise4_enumLike("unknown") == None, "Exercise 4 failed: unknown")

    assert(exercise5_nestedSealed(Num(5)) == 5, "Exercise 5 failed: num")
    assert(exercise5_nestedSealed(Add(Num(2), Num(3))) == 5, "Exercise 5 failed: add")
    assert(exercise5_nestedSealed(Mul(Num(3), Num(4))) == 12, "Exercise 5 failed: mul")

    assert(exercise6_productTypes(Point(1, 2), Point(4, 6)) == 7, "Exercise 6 failed")

    assert(exercise7_sumTypes(Success(42)) == Right(42), "Exercise 7 failed: success")
    assert(exercise7_sumTypes(Failure("err")) == Left("err"), "Exercise 7 failed: failure")

    assert(exercise8_recursiveADT == 20, "Exercise 8 failed")

    println("All Core015_SealedTraits exercises passed!")
  }
}
