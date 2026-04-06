package org.shev4ik.interview.scala3.level1_basics

/**
 * Scala 3: Opaque Type Aliases (modeled with value classes in Scala 2.13)
 *
 * In Scala 3, `opaque type UserId = Int` creates a zero-cost abstraction.
 * The type is distinct at compile time but erased at runtime.
 * In Scala 2.13, we approximate this with value classes (extends AnyVal).
 */
object Sc3_005_OpaqueTypes {

  // Exercise 1: Basic opaque type (Scala 3: opaque type UserId = Int)
  // TODO: Create a value class `UserId` wrapping an Int.
  //       Add a companion object with:
  //       - `apply(id: Int): UserId` — constructor
  //       - `value` extension to extract the Int (via implicit class or method on UserId)
  //       Implement `exercise1_createAndExtract` that creates a UserId(42) and returns its value.
  case class UserId(value: Int) extends AnyVal
  def exercise1_createAndExtract: Int = ???

  // Exercise 2: Opaque type with validation (Scala 3: companion with smart constructor)
  // TODO: Create a value class `NonEmptyString` wrapping a String.
  //       In the companion, provide `from(s: String): Option[NonEmptyString]`
  //       that returns None for empty strings.
  //       Implement `exercise2_validate` that tries to create a NonEmptyString and
  //       returns the inner string or "EMPTY".
  case class NonEmptyString(value: String) extends AnyVal
  object NonEmptyString {
    def from(s: String): Option[NonEmptyString] = ???
  }
  def exercise2_validate(s: String): String = ???

  // Exercise 3: Opaque type with operations (Scala 3: extension methods on opaque types)
  // TODO: Create a value class `Meters` wrapping a Double.
  //       Add operations via an implicit class:
  //       - `+(other: Meters): Meters` — add distances
  //       - `toFeet: Double` — convert to feet (1 meter = 3.28084 feet)
  //       - `toKilometers: Double` — meters / 1000
  case class Meters(value: Double) extends AnyVal
  implicit class MetersOps(val m: Meters) {
    def +(other: Meters): Meters = ???
    def toFeet: Double = ???
    def toKilometers: Double = ???
  }
  def exercise3_addMeters(a: Double, b: Double): Double = ???
  def exercise3_toFeet(m: Double): Double = ???

  // Exercise 4: Multiple opaque types preventing mixups
  // TODO: Create value classes `Celsius` and `Fahrenheit` both wrapping Double.
  //       This prevents accidentally passing Fahrenheit where Celsius is expected.
  //       Implement conversions:
  //       - `celsiusToFahrenheit(c: Celsius): Fahrenheit` — (c * 9/5) + 32
  //       - `fahrenheitToCelsius(f: Fahrenheit): Celsius` — (f - 32) * 5/9
  //       The point: type safety prevents mixing them up at compile time!
  case class Celsius(value: Double) extends AnyVal
  case class Fahrenheit(value: Double) extends AnyVal
  def exercise4_celsiusToFahrenheit(c: Celsius): Fahrenheit = ???
  def exercise4_fahrenheitToCelsius(f: Fahrenheit): Celsius = ???

  // Exercise 5: Opaque type for domain modeling
  // TODO: Create value classes for a simple money domain:
  //       - `Amount(value: BigDecimal)` — monetary amount
  //       - `Currency(code: String)` — currency code (e.g., "USD")
  //       Create a case class `Money(amount: Amount, currency: Currency)`.
  //       Implement `addMoney(a: Money, b: Money): Option[Money]` that only adds
  //       if currencies match, returning None otherwise.
  case class Amount(value: BigDecimal) extends AnyVal
  case class Currency(code: String) extends AnyVal
  case class Money(amount: Amount, currency: Currency)
  def exercise5_addMoney(a: Money, b: Money): Option[Money] = ???

  // Exercise 6: Opaque type with ordering
  // TODO: Create a value class `Score(value: Int)`.
  //       Provide an implicit Ordering[Score] that orders by value descending (highest first).
  //       Implement `topScores(scores: List[Score], n: Int): List[Score]` that returns top n scores.
  case class Score(value: Int) extends AnyVal
  implicit val scoreOrdering: Ordering[Score] = ???
  def exercise6_topScores(scores: List[Score], n: Int): List[Score] = ???

  // Exercise 7: Opaque type for tagged types pattern
  // A common Scala 2 pattern for phantom types / tagged types.
  // TODO: Implement a tagged type system using a trait `Tag[T]`.
  //       `type Tagged[A, T] = A with Tag[T]` (compile-time tagging)
  //       Create tags: `trait NameTag` and `trait EmailTag`.
  //       `type Name = Tagged[String, NameTag]`
  //       `type Email = Tagged[String, EmailTag]`
  //       Provide smart constructors: `mkName(s: String): Name`, `mkEmail(s: String): Option[Email]`
  //       (email must contain '@').
  //       Implement `greet(name: Name, email: Email): String` => "Hello <name>, your email is <email>"
  trait Tag[T]
  type Tagged[A, T] = A with Tag[T]
  trait NameTag
  trait EmailTag
  type Name = Tagged[String, NameTag]
  type Email = Tagged[String, EmailTag]
  def exercise7_mkName(s: String): Name = ???
  def exercise7_mkEmail(s: String): Option[Email] = ???
  def exercise7_greet(name: Name, email: Email): String = ???

  // Exercise 8: Opaque type for refinement (positive integers only)
  // TODO: Create a value class `PosInt(value: Int)`.
  //       Provide `from(n: Int): Option[PosInt]` that returns None for non-positive.
  //       Provide `unsafeFrom(n: Int): PosInt` that throws for non-positive.
  //       Implement `sumPositives(xs: List[Int]): Option[PosInt]` that filters positives,
  //       sums them, and returns as PosInt (None if no positives).
  case class PosInt(value: Int) extends AnyVal
  object PosInt {
    def from(n: Int): Option[PosInt] = ???
    def unsafeFrom(n: Int): PosInt = ???
  }
  def exercise8_sumPositives(xs: List[Int]): Option[PosInt] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_createAndExtract == 42, "Exercise 1 failed")

    // Exercise 2
    assert(exercise2_validate("hello") == "hello", "Exercise 2 failed")
    assert(exercise2_validate("") == "EMPTY", "Exercise 2 failed")

    // Exercise 3
    assert(exercise3_addMeters(100.0, 200.0) == 300.0, "Exercise 3 add failed")
    assert(Math.abs(exercise3_toFeet(1.0) - 3.28084) < 0.001, "Exercise 3 toFeet failed")

    // Exercise 4
    val f = exercise4_celsiusToFahrenheit(Celsius(100.0))
    assert(Math.abs(f.value - 212.0) < 0.001, "Exercise 4 C->F failed")
    val c = exercise4_fahrenheitToCelsius(Fahrenheit(32.0))
    assert(Math.abs(c.value - 0.0) < 0.001, "Exercise 4 F->C failed")

    // Exercise 5
    val usd1 = Money(Amount(BigDecimal(10)), Currency("USD"))
    val usd2 = Money(Amount(BigDecimal(20)), Currency("USD"))
    val eur = Money(Amount(BigDecimal(5)), Currency("EUR"))
    assert(exercise5_addMoney(usd1, usd2).map(_.amount.value) == Some(BigDecimal(30)), "Exercise 5 failed")
    assert(exercise5_addMoney(usd1, eur) == None, "Exercise 5 currency mismatch failed")

    // Exercise 6
    val scores = List(Score(50), Score(90), Score(30), Score(80), Score(70))
    val top3 = exercise6_topScores(scores, 3)
    assert(top3.map(_.value) == List(90, 80, 70), "Exercise 6 failed")

    // Exercise 7
    val name = exercise7_mkName("Alice")
    val emailOpt = exercise7_mkEmail("alice@example.com")
    assert(emailOpt.isDefined, "Exercise 7 email should be valid")
    assert(exercise7_mkEmail("invalid") == None, "Exercise 7 should reject invalid email")
    assert(exercise7_greet(name, emailOpt.get) == "Hello Alice, your email is alice@example.com", "Exercise 7 failed")

    // Exercise 8
    assert(exercise8_sumPositives(List(1, -2, 3, -4, 5)).map(_.value) == Some(9), "Exercise 8 failed")
    assert(exercise8_sumPositives(List(-1, -2)) == None, "Exercise 8 failed: no positives")

    println("All Sc3_005_OpaqueTypes exercises passed!")
  }
}
