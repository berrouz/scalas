package org.shev4ik.interview.scala_core.level2_intermediate

object Core053_ValueClasses {

  // Exercise 1: extends AnyVal
  // TODO: Create a value class Meters(val value: Double) extends AnyVal
  //       with a method toFeet: Double (1 meter = 3.28084 feet)
  class Meters(val value: Double) extends AnyVal {
    def toFeet: Double = ???
  }

  // Exercise 2: Boxing avoidance
  // TODO: Create a value class UserId(val id: Long) extends AnyVal
  //       This avoids boxing - at runtime it's just a Long, no object allocation
  //       Add a method isValid: Boolean (id > 0)
  class UserId(val id: Long) extends AnyVal {
    def isValid: Boolean = ???
  }

  // Exercise 3: Limitations
  // TODO: Document and demonstrate value class limitations:
  //       1. Can only have one val parameter
  //       2. Cannot be extended
  //       3. Cannot have secondary constructors
  //       4. Cannot define equals/hashCode
  //       5. Are boxed when: treated as another type, used in arrays, pattern matched
  //       Create a value class Email(val address: String) extends AnyVal
  //       with a method domain: String
  class Email(val address: String) extends AnyVal {
    def domain: String = ???
  }

  // Exercise 4: Tagged types concept
  // TODO: Use value classes to create "tagged" types for type safety
  //       Prevent mixing up firstName and lastName even though both are String
  class FirstName(val value: String) extends AnyVal
  class LastName(val value: String) extends AnyVal

  // TODO: Create a method that only accepts properly typed names
  def formatName(first: FirstName, last: LastName): String = ???

  // Exercise 5: Meter/Kilogram types
  // TODO: Create value classes for units of measurement
  //       Meter(value: Double), Kilogram(value: Double), Second(value: Double)
  //       Add arithmetic within same units (add, subtract)
  class Meter(val value: Double) extends AnyVal {
    def +(other: Meter): Meter = ???
    def -(other: Meter): Meter = ???
  }
  class Kilogram(val value: Double) extends AnyVal {
    def +(other: Kilogram): Kilogram = ???
    def -(other: Kilogram): Kilogram = ???
  }
  class Second(val value: Double) extends AnyVal {
    def +(other: Second): Second = ???
    def -(other: Second): Second = ???
  }

  // Exercise 6: Type safety without overhead
  // TODO: Create value classes for a banking domain:
  //       AccountId(value: String), Amount(value: BigDecimal), Currency(code: String)
  //       These prevent accidentally passing an AccountId where Currency is expected
  class AccountId(val value: String) extends AnyVal
  class Amount(val value: BigDecimal) extends AnyVal {
    def +(other: Amount): Amount = ???
    def -(other: Amount): Amount = ???
    def isPositive: Boolean = ???
  }
  class CurrencyCode(val code: String) extends AnyVal

  def transfer(from: AccountId, to: AccountId, amount: Amount): String = ???

  // Exercise 7: Universal traits
  // TODO: Create a universal trait (extends Any) that value classes can extend
  //       trait Printable extends Any { def print: String }
  //       Value class Name(val s: String) extends AnyVal with Printable
  //       Note: universal traits can only have def members (no val/var)
  trait Printable extends Any {
    def print: String
  }
  class Name(val s: String) extends AnyVal with Printable {
    def print: String = ???
  }

  // Exercise 8: Value class with implicit
  // TODO: Create an implicit value class that adds methods to String
  //       without boxing (extends AnyVal)
  //       Add: toSlug (lowercase, spaces to hyphens), initials (first letter of each word)
  implicit class StringValueOps(val s: String) extends AnyVal {
    def toSlug: String = ???
    def initials: String = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val m = new Meters(1.0)
    assert(math.abs(m.toFeet - 3.28084) < 0.001, "1 meter should be ~3.28 feet")

    // Exercise 2 assertions
    val uid = new UserId(42L)
    assert(uid.isValid, "UserId(42) should be valid")
    assert(!new UserId(-1L).isValid, "UserId(-1) should be invalid")

    // Exercise 3 assertions
    val email = new Email("user@example.com")
    assert(email.domain == "example.com", "Email domain extraction")

    // Exercise 4 assertions
    val first = new FirstName("John")
    val last = new LastName("Doe")
    assert(formatName(first, last) == "John Doe", "formatName should combine names")
    // The following should NOT compile (type safety):
    // formatName(last, first) // won't compile!

    // Exercise 5 assertions
    val m1 = new Meter(5.0)
    val m2 = new Meter(3.0)
    assert((m1 + m2).value == 8.0, "5m + 3m = 8m")
    assert((m1 - m2).value == 2.0, "5m - 3m = 2m")

    // Exercise 6 assertions
    val from = new AccountId("ACC001")
    val to = new AccountId("ACC002")
    val amt = new Amount(BigDecimal(100))
    assert(amt.isPositive, "Amount(100) should be positive")
    assert((amt + new Amount(BigDecimal(50))).value == BigDecimal(150), "100 + 50 = 150")
    assert(transfer(from, to, amt).nonEmpty, "transfer should return a description")

    // Exercise 7 assertions
    val name = new Name("Alice")
    assert(name.print == "Alice", "Name.print should return the name")

    // Exercise 8 assertions
    assert("Hello World".toSlug == "hello-world", "toSlug")
    assert("John Michael Doe".initials == "JMD", "initials")

    println("All Core053_ValueClasses exercises passed!")
  }
}
