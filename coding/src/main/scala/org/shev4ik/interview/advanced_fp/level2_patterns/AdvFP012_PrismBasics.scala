package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP012 - Prism Basics
 *
 * A Prism[S, A] focuses on one case of a sum type S.
 * It provides getOption: S => Option[A] and reverseGet: A => S.
 * Laws: getOption(reverseGet(a)) == Some(a), reverseGet is injective.
 */
object AdvFP012_PrismBasics {

  // ============================================================
  // Exercise 1: Define the Prism type
  // ============================================================
  case class Prism[S, A](getOption: S => Option[A], reverseGet: A => S) {
    def modify(f: A => A)(s: S): S =
      getOption(s).map(a => reverseGet(f(a))).getOrElse(s)
  }

  // TODO: Create a Prism for extracting Int from a String (parsing)
  val stringToInt: Prism[String, Int] = ???

  // ============================================================
  // Exercise 2: Create Prisms for a sealed trait hierarchy
  // ============================================================
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
  case class Triangle(base: Double, height: Double) extends Shape

  // TODO: Prism focusing on Circle within Shape
  val circlePrism: Prism[Shape, Circle] = ???

  // TODO: Prism focusing on Rectangle within Shape
  val rectanglePrism: Prism[Shape, Rectangle] = ???

  // ============================================================
  // Exercise 3: Implement Prism composition
  // Given Prism[S, A] and Prism[A, B], produce Prism[S, B]
  // ============================================================
  // TODO: Compose two prisms
  def composePrism[S, A, B](outer: Prism[S, A], inner: Prism[A, B]): Prism[S, B] = ???

  // ============================================================
  // Exercise 4: Create a Prism for Option (Some case)
  // ============================================================
  // TODO: Prism focusing on the Some case of Option
  def somePrism[A]: Prism[Option[A], A] = ???

  // ============================================================
  // Exercise 5: Verify Prism law: getOption(reverseGet(a)) == Some(a)
  // ============================================================
  // TODO: Verify the review-preview law
  def verifyReviewPreview[S, A](prism: Prism[S, A], a: A): Boolean = ???

  // ============================================================
  // Exercise 6: Verify Prism law: getOption(s).map(reverseGet) is either None or Some(s)
  // If getOption returns Some(a), then reverseGet(a) should equal s.
  // ============================================================
  // TODO: Verify the preview-review law
  def verifyPreviewReview[S, A](prism: Prism[S, A], s: S): Boolean = ???

  // ============================================================
  // Exercise 7: Implement a Prism for Either's Left case
  // ============================================================
  // TODO: Prism for Left[A, B]
  def leftPrism[A, B]: Prism[Either[A, B], A] = ???

  // ============================================================
  // Exercise 8: Use Prism for safe pattern matching and construction
  // Implement a function that doubles the radius of a Shape if it's a Circle,
  // otherwise leaves it unchanged.
  // ============================================================
  // TODO: Double circle radius using Prism
  def doubleCircleRadius(shape: Shape): Shape = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: String to Int prism
    assert(stringToInt.getOption("42") == Some(42))
    assert(stringToInt.getOption("abc") == None)
    assert(stringToInt.reverseGet(42) == "42")
    println("Exercise 1 passed: String to Int prism")

    // Exercise 2: Shape prisms
    val c: Shape = Circle(5.0)
    val r: Shape = Rectangle(3.0, 4.0)
    assert(circlePrism.getOption(c) == Some(Circle(5.0)))
    assert(circlePrism.getOption(r) == None)
    assert(rectanglePrism.getOption(r) == Some(Rectangle(3.0, 4.0)))
    println("Exercise 2 passed: Shape prisms")

    // Exercise 3: Prism composition
    sealed trait JsonValue
    case class JsonStr(value: String) extends JsonValue
    case class JsonNum(value: Double) extends JsonValue

    val jsonStrPrism = Prism[JsonValue, String](
      { case JsonStr(s) => Some(s); case _ => None },
      JsonStr
    )
    val jsonStrToInt = composePrism(jsonStrPrism, stringToInt)
    assert(jsonStrToInt.getOption(JsonStr("42")) == Some(42))
    assert(jsonStrToInt.getOption(JsonStr("abc")) == None)
    assert(jsonStrToInt.getOption(JsonNum(1.0)) == None)
    println("Exercise 3 passed: Prism composition")

    // Exercise 4: Some prism
    val sp = somePrism[Int]
    assert(sp.getOption(Some(42)) == Some(42))
    assert(sp.getOption(None) == None)
    assert(sp.reverseGet(42) == Some(42))
    println("Exercise 4 passed: Some prism")

    // Exercise 5: Review-preview law
    assert(verifyReviewPreview(circlePrism, Circle(5.0)))
    assert(verifyReviewPreview(stringToInt, 42))
    println("Exercise 5 passed: Review-preview law")

    // Exercise 6: Preview-review law
    assert(verifyPreviewReview(circlePrism, Circle(5.0)))
    assert(verifyPreviewReview(circlePrism, Rectangle(1.0, 2.0)))
    println("Exercise 6 passed: Preview-review law")

    // Exercise 7: Left prism
    val lp = leftPrism[String, Int]
    assert(lp.getOption(Left("hi")) == Some("hi"))
    assert(lp.getOption(Right(42)) == None)
    assert(lp.reverseGet("hello") == Left("hello"))
    println("Exercise 7 passed: Left prism")

    // Exercise 8: Double circle radius
    assert(doubleCircleRadius(Circle(5.0)) == Circle(10.0))
    assert(doubleCircleRadius(Rectangle(3.0, 4.0)) == Rectangle(3.0, 4.0))
    println("Exercise 8 passed: Double circle radius")

    println("\nAll exercises passed!")
  }
}
