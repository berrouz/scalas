package org.shev4ik.interview.scala3.level1_basics

/**
 * Scala 3: Union Types (A | B) and Intersection Types (A & B)
 * (modeled with Either, type members, and with-types in Scala 2.13)
 *
 * In Scala 3, union types `A | B` allow a value to be either A or B without a wrapper.
 * Intersection types `A & B` require a value to satisfy both A and B.
 * In Scala 2.13, we approximate these with Either and with-types.
 */
object Sc3_004_UnionIntersection {

  // === Setup ===

  trait Printable {
    def printMe: String
  }

  trait Loggable {
    def logMessage: String
  }

  trait Serializable {
    def serialize: String
  }

  case class User(name: String, age: Int)
  case class Admin(name: String, level: Int)

  // Exercise 1: Union type basics (Scala 3: String | Int)
  // Modeled with Either in Scala 2.
  // TODO: Implement `describe` that takes an Either[String, Int] and returns:
  //       - For a String: "String: <value>"
  //       - For an Int: "Int: <value>"
  def exercise1_describe(value: Either[String, Int]): String = ???

  // Exercise 2: Multi-union type (Scala 3: String | Int | Boolean)
  // In Scala 2, we can nest Either or use a sealed trait.
  // TODO: Model a union of String, Int, and Boolean using a sealed trait `StringIntBool`.
  //       Add case classes StrVal(s: String), IntVal(n: Int), BoolVal(b: Boolean).
  //       Implement `classify` that returns "string", "int", or "bool" accordingly.
  sealed trait StringIntBool
  // TODO: Define case classes StrVal, IntVal, BoolVal
  def exercise2_classify(v: StringIntBool): String = ???

  // Exercise 3: Intersection type basics (Scala 3: Printable & Loggable)
  // Modeled with `with` types in Scala 2.
  // TODO: Implement `printAndLog` that takes a value of type `Printable with Loggable`
  //       and returns s"${v.printMe} | ${v.logMessage}".
  //       Then create a case class `PrintableLoggable` that extends both traits and
  //       implement a factory method `makePrintableLoggable`.
  def exercise3_printAndLog(v: Printable with Loggable): String = ???
  def exercise3_makePrintableLoggable(msg: String): Printable with Loggable = ???

  // Exercise 4: Triple intersection (Scala 3: Printable & Loggable & Serializable)
  // TODO: Implement `allThree` that takes a `Printable with Loggable with Serializable`
  //       and returns a tuple (printMe, logMessage, serialize).
  //       Create a class `SuperEntity(name: String)` that implements all three traits:
  //       - printMe: s"Print: $name"
  //       - logMessage: s"Log: $name"
  //       - serialize: s"""{"name":"$name"}"""
  def exercise4_allThree(v: Printable with Loggable with Serializable): (String, String, String) = ???
  def exercise4_makeSuperEntity(name: String): Printable with Loggable with Serializable = ???

  // Exercise 5: Union types for error handling (Scala 3: Result | Error)
  // TODO: Model success/error using Either[ErrorInfo, SuccessInfo].
  //       case class ErrorInfo(code: Int, message: String)
  //       case class SuccessInfo(data: String)
  //       Implement `process` that:
  //       - Returns Right(SuccessInfo("ok")) if input is non-empty
  //       - Returns Left(ErrorInfo(400, "empty input")) if input is empty
  //       Implement `render` that converts Either to a display string:
  //       - Right: "Success: <data>"
  //       - Left: "Error <code>: <message>"
  case class ErrorInfo(code: Int, message: String)
  case class SuccessInfo(data: String)
  def exercise5_process(input: String): Either[ErrorInfo, SuccessInfo] = ???
  def exercise5_render(result: Either[ErrorInfo, SuccessInfo]): String = ???

  // Exercise 6: Intersection types with type classes
  // Scala 3: def process[A: Show & Eq](a: A) — requires both type classes.
  // In Scala 2, use multiple context bounds or implicit parameters.
  // TODO: Define traits MyShow[A] { def show(a: A): String } and MyEq[A] { def eqv(a: A, b: A): Boolean }.
  //       Implement instances for Int and String.
  //       Implement `showIfEqual[A: MyShow: MyEq](a: A, b: A): Option[String]`
  //       that returns Some(show(a)) if a == b, None otherwise.
  trait MyShow[A] { def show(a: A): String }
  trait MyEq[A] { def eqv(a: A, b: A): Boolean }
  implicit val intMyShow: MyShow[Int] = ???
  implicit val intMyEq: MyEq[Int] = ???
  implicit val stringMyShow: MyShow[String] = ???
  implicit val stringMyEq: MyEq[String] = ???
  def exercise6_showIfEqual[A: MyShow: MyEq](a: A, b: A): Option[String] = ???

  // Exercise 7: Simulating union type pattern matching
  // In Scala 3, you can match on union types directly.
  // TODO: Using Either[User, Admin], implement `getName` to extract the name from either.
  //       Implement `promote`: given Either[User, Admin], if it is a User with age > 30,
  //       convert to Admin with level 1; otherwise keep as-is.
  def exercise7_getName(person: Either[User, Admin]): String = ???
  def exercise7_promote(person: Either[User, Admin]): Either[User, Admin] = ???

  // Exercise 8: Structural intersection type (Scala 3: { def name: String } & { def age: Int })
  // In Scala 2, structural types work similarly.
  // TODO: Implement `describeEntity` that takes a structural type with both `name: String` and `age: Int`,
  //       and returns s"$name is $age years old".
  //       Implement `makeEntity` that returns an object conforming to this structural type.
  //       Note: Requires import scala.language.reflectiveCalls
  import scala.language.reflectiveCalls
  type Named = { def name: String }
  type Aged = { def age: Int }
  def exercise8_describeEntity(entity: Named with Aged): String = ???
  def exercise8_makeEntity(n: String, a: Int): Named with Aged = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_describe(Left("hello")) == "String: hello", "Exercise 1 failed")
    assert(exercise1_describe(Right(42)) == "Int: 42", "Exercise 1 failed")

    // Exercise 2
    // assert(exercise2_classify(StrVal("hi")) == "string", "Exercise 2 failed")
    // assert(exercise2_classify(IntVal(1)) == "int", "Exercise 2 failed")
    // assert(exercise2_classify(BoolVal(true)) == "bool", "Exercise 2 failed")
    println("Exercise 2: Define case classes and uncomment assertions")

    // Exercise 3
    val pl = exercise3_makePrintableLoggable("test")
    assert(exercise3_printAndLog(pl) == "test | test", "Exercise 3 failed")

    // Exercise 4
    val se = exercise4_makeSuperEntity("Alice")
    assert(exercise4_allThree(se) == ("Print: Alice", "Log: Alice", """{"name":"Alice"}"""), "Exercise 4 failed")

    // Exercise 5
    assert(exercise5_process("data") == Right(SuccessInfo("ok")), "Exercise 5 failed")
    assert(exercise5_process("") == Left(ErrorInfo(400, "empty input")), "Exercise 5 failed")
    assert(exercise5_render(Right(SuccessInfo("ok"))) == "Success: ok", "Exercise 5 failed")
    assert(exercise5_render(Left(ErrorInfo(400, "empty input"))) == "Error 400: empty input", "Exercise 5 failed")

    // Exercise 6
    assert(exercise6_showIfEqual(42, 42) == Some("42"), "Exercise 6 failed")
    assert(exercise6_showIfEqual(1, 2) == None, "Exercise 6 failed")
    assert(exercise6_showIfEqual("hi", "hi") == Some("hi"), "Exercise 6 failed")

    // Exercise 7
    assert(exercise7_getName(Left(User("Alice", 25))) == "Alice", "Exercise 7 failed")
    assert(exercise7_getName(Right(Admin("Bob", 3))) == "Bob", "Exercise 7 failed")
    assert(exercise7_promote(Left(User("Alice", 35))) == Right(Admin("Alice", 1)), "Exercise 7 promote failed")
    assert(exercise7_promote(Left(User("Bob", 25))) == Left(User("Bob", 25)), "Exercise 7 promote failed")

    // Exercise 8
    val entity = exercise8_makeEntity("Alice", 30)
    assert(exercise8_describeEntity(entity) == "Alice is 30 years old", "Exercise 8 failed")

    println("All Sc3_004_UnionIntersection exercises passed!")
  }
}
