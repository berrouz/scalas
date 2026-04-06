package org.shev4ik.interview.scala3.level3_advanced

/**
 * Scala 3: Multiversal Equality (CanEqual / strict equality)
 * (modeled conceptually in Scala 2.13)
 *
 * In Scala 3, multiversal equality prevents comparing unrelated types:
 *   - `import scala.language.strictEquality`
 *   - Only types with a `CanEqual[A, B]` instance can be compared with == / !=
 *   - `derives CanEqual` for case classes
 * In Scala 2, == works on any two values (universal equality). We model strict equality here.
 */
object Sc3_014_MultiversalEquality {

  // Exercise 1: The problem with universal equality
  // In Scala 2 (and Java), you can compare any two types: "hello" == 42 compiles fine!
  // TODO: Demonstrate the problem by implementing `unsafeComparisons` that returns
  //       a list of (description, result) for nonsensical comparisons that Scala 2 allows.
  //       Show at least 4 comparisons that compile but are always false/meaningless.
  def exercise1_unsafeComparisons: List[(String, Boolean)] = ???
  // Expected: List of pairs like ("String == Int", "hello" == 42) etc.

  // Exercise 2: Modeling CanEqual (Scala 3: given CanEqual[A, B])
  // TODO: Create a type class `CanEqual[A, B]` (empty marker trait).
  //       Implement a `safeEquals[A, B](a: A, b: B)(implicit ev: CanEqual[A, B]): Boolean`
  //       that only compiles when a CanEqual instance exists.
  //       Provide instances for:
  //       - CanEqual[Int, Int]
  //       - CanEqual[String, String]
  //       - CanEqual[Boolean, Boolean]
  trait CanEqual[A, B]
  implicit val intCanEqual: CanEqual[Int, Int] = ???
  implicit val stringCanEqual: CanEqual[String, String] = ???
  implicit val boolCanEqual: CanEqual[Boolean, Boolean] = ???
  def exercise2_safeEquals[A, B](a: A, b: B)(implicit ev: CanEqual[A, B]): Boolean = ???

  // Exercise 3: CanEqual for related types (Scala 3: cross-type equality)
  // Scala 3 allows: given CanEqual[Int, Long] for related numeric types.
  // TODO: Provide CanEqual instances for Int <-> Long comparison (both directions).
  //       Implement `safeNumericEquals` that compares Int and Long safely.
  implicit val intLongCanEqual: CanEqual[Int, Long] = ???
  implicit val longIntCanEqual: CanEqual[Long, Int] = ???
  def exercise3_safeNumericEquals(a: Int, b: Long)(implicit ev: CanEqual[Int, Long]): Boolean = ???

  // Exercise 4: CanEqual for ADTs (Scala 3: derives CanEqual)
  // In Scala 3: enum Color derives CanEqual { case Red, Green, Blue }
  // TODO: Create a sealed trait `Color` with Red, Green, Blue.
  //       Provide a CanEqual[Color, Color] instance.
  //       Implement `colorsEqual(a: Color, b: Color): Boolean` using safeEquals.
  //       Show that comparing Color with Int would NOT compile (explain in a string).
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color
  implicit val colorCanEqual: CanEqual[Color, Color] = ???
  def exercise4_colorsEqual(a: Color, b: Color)(implicit ev: CanEqual[Color, Color]): Boolean = ???
  def exercise4_whyStrict: String = ???
  // TODO: "Strict equality prevents comparing Color == Int at compile time, catching bugs early"

  // Exercise 5: CanEqual with generics
  // Scala 3: given [A, B](using CanEqual[A, B]): CanEqual[List[A], List[B]]
  // TODO: Provide a CanEqual instance for List[A] given CanEqual[A, A].
  //       Implement `listsEqual[A](a: List[A], b: List[A])(implicit eq: CanEqual[List[A], List[A]]): Boolean`.
  implicit def listCanEqual[A](implicit ev: CanEqual[A, A]): CanEqual[List[A], List[A]] = ???
  def exercise5_listsEqual[A](a: List[A], b: List[A])(implicit ev: CanEqual[List[A], List[A]]): Boolean = ???

  // Exercise 6: CanEqual with Option
  // Scala 3: given [A, B](using CanEqual[A, B]): CanEqual[Option[A], Option[B]]
  // TODO: Provide CanEqual for Option[A] given CanEqual[A, A].
  //       Implement `optionsEqual` that compares two Options safely.
  implicit def optionCanEqual[A](implicit ev: CanEqual[A, A]): CanEqual[Option[A], Option[A]] = ???
  def exercise6_optionsEqual[A](a: Option[A], b: Option[A])(implicit ev: CanEqual[Option[A], Option[A]]): Boolean = ???

  // Exercise 7: Custom equality with CanEqual
  // TODO: Create case class `UserId(value: Int)` and case class `OrderId(value: Int)`.
  //       Even though both wrap Int, they should NOT be comparable.
  //       Provide CanEqual[UserId, UserId] and CanEqual[OrderId, OrderId] but NOT cross-type.
  //       Implement `userIdsEqual` and `orderIdsEqual`.
  //       Answer: What would happen if you tried `UserId(1) == OrderId(1)` with strict equality?
  case class UserId(value: Int)
  case class OrderId(value: Int)
  implicit val userIdCanEqual: CanEqual[UserId, UserId] = ???
  implicit val orderIdCanEqual: CanEqual[OrderId, OrderId] = ???
  def exercise7_userIdsEqual(a: UserId, b: UserId)(implicit ev: CanEqual[UserId, UserId]): Boolean = ???
  def exercise7_orderIdsEqual(a: OrderId, b: OrderId)(implicit ev: CanEqual[OrderId, OrderId]): Boolean = ???
  def exercise7_crossCompareAnswer: String = ???
  // TODO: "Compile error: no given CanEqual[UserId, OrderId] — prevents comparing different ID types"

  // Exercise 8: Summary — multiversal equality concepts
  // TODO: Answer questions about Scala 3 multiversal equality.
  def exercise8_q1: String = ???  // What import enables strict equality in Scala 3?
  // "import scala.language.strictEquality"
  def exercise8_q2: String = ???  // What type class controls which types can be compared?
  // "CanEqual[A, B] (also known as Eql in earlier Scala 3 versions)"
  def exercise8_q3: String = ???  // How do you opt a case class into strict equality in Scala 3?
  // "case class Foo(x: Int) derives CanEqual"
  def exercise8_q4: String = ???  // Why is multiversal equality useful?
  // "It catches meaningless comparisons at compile time, like String == Int, preventing bugs"
  def exercise8_q5: String = ???  // What is the difference between universal and multiversal equality?
  // "Universal allows comparing any two types; multiversal only allows types with a CanEqual instance"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val unsafe = exercise1_unsafeComparisons
    assert(unsafe.length >= 4, "Exercise 1 should have at least 4 comparisons")
    assert(unsafe.forall(_._2 == false), "Exercise 1: all nonsensical comparisons should be false")

    // Exercise 2
    assert(exercise2_safeEquals(42, 42), "Exercise 2 equal ints failed")
    assert(!exercise2_safeEquals(42, 43), "Exercise 2 unequal ints failed")
    assert(exercise2_safeEquals("hello", "hello"), "Exercise 2 equal strings failed")
    // The following should NOT compile (no CanEqual[Int, String]):
    // exercise2_safeEquals(42, "hello")  // compile error!

    // Exercise 3
    assert(exercise3_safeNumericEquals(42, 42L), "Exercise 3 equal failed")
    assert(!exercise3_safeNumericEquals(42, 43L), "Exercise 3 unequal failed")

    // Exercise 4
    assert(exercise4_colorsEqual(Red, Red), "Exercise 4 same color failed")
    assert(!exercise4_colorsEqual(Red, Blue), "Exercise 4 different colors failed")
    assert(exercise4_whyStrict == "Strict equality prevents comparing Color == Int at compile time, catching bugs early",
      "Exercise 4 answer failed")

    // Exercise 5
    assert(exercise5_listsEqual(List(1, 2, 3), List(1, 2, 3)), "Exercise 5 equal lists failed")
    assert(!exercise5_listsEqual(List(1, 2), List(1, 3)), "Exercise 5 unequal lists failed")

    // Exercise 6
    assert(exercise6_optionsEqual(Some(42), Some(42)), "Exercise 6 equal options failed")
    assert(!exercise6_optionsEqual(Some(42), Some(43)), "Exercise 6 unequal options failed")
    assert(exercise6_optionsEqual(None: Option[Int], None: Option[Int]), "Exercise 6 both none failed")
    assert(!exercise6_optionsEqual(Some(42), None: Option[Int]), "Exercise 6 some vs none failed")

    // Exercise 7
    assert(exercise7_userIdsEqual(UserId(1), UserId(1)), "Exercise 7 same user id failed")
    assert(!exercise7_userIdsEqual(UserId(1), UserId(2)), "Exercise 7 different user id failed")
    assert(exercise7_orderIdsEqual(OrderId(1), OrderId(1)), "Exercise 7 same order id failed")
    assert(exercise7_crossCompareAnswer ==
      "Compile error: no given CanEqual[UserId, OrderId] — prevents comparing different ID types",
      "Exercise 7 answer failed")

    // Exercise 8
    assert(exercise8_q1 == "import scala.language.strictEquality", "Exercise 8 Q1 failed")
    assert(exercise8_q2 == "CanEqual[A, B] (also known as Eql in earlier Scala 3 versions)", "Exercise 8 Q2 failed")
    assert(exercise8_q3 == "case class Foo(x: Int) derives CanEqual", "Exercise 8 Q3 failed")
    assert(exercise8_q4 == "It catches meaningless comparisons at compile time, like String == Int, preventing bugs", "Exercise 8 Q4 failed")
    assert(exercise8_q5 == "Universal allows comparing any two types; multiversal only allows types with a CanEqual instance", "Exercise 8 Q5 failed")

    println("All Sc3_014_MultiversalEquality exercises passed!")
  }
}
