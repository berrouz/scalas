package org.shev4ik.interview.circe.level2_intermediate

/**
 * Circe 009 - Validation and Error Accumulation
 *
 * Standard circe decoding is fail-fast: it returns the first error encountered.
 * For validation scenarios (e.g., form validation, API request validation), you
 * want to accumulate ALL errors so the user can fix them in one pass.
 *
 * In real circe: use Decoder with AccumulatingDecoder, or integrate with
 * cats.data.Validated / cats.data.ValidatedNel.
 *
 * In this exercise we build a simplified Validated type and an accumulating
 * decoder to understand the pattern.
 *
 * Key concepts: Validated, NonEmptyList of errors, accumulating decoders,
 * combining validations with mapN / product.
 */
object Circe009_Validation {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Validated (like cats.data.Validated)
  sealed trait Validated[+E, +A] {
    def map[B](f: A => B): Validated[E, B] = this match {
      case Valid(a)   => Valid(f(a))
      case Invalid(e) => Invalid(e)
    }

    def toEither: Either[List[E], A] = this match {
      case Valid(a)   => Right(a)
      case Invalid(e) => Left(e)
    }
  }
  case class Valid[A](value: A) extends Validated[Nothing, A]
  case class Invalid[E](errors: List[E]) extends Validated[E, Nothing]

  object Validated {
    def valid[A](a: A): Validated[Nothing, A] = Valid(a)
    def invalid[E](e: E): Validated[E, Nothing] = Invalid(List(e))
    def invalidList[E](es: List[E]): Validated[E, Nothing] = Invalid(es)

    // Combine two Validated: accumulate errors if both fail
    def product[E, A, B](va: Validated[E, A], vb: Validated[E, B]): Validated[E, (A, B)] =
      (va, vb) match {
        case (Valid(a), Valid(b))       => Valid((a, b))
        case (Invalid(e1), Invalid(e2)) => Invalid(e1 ++ e2)
        case (Invalid(e), _)           => Invalid(e)
        case (_, Invalid(e))           => Invalid(e)
      }
  }

  // Simplified cursor
  case class Cursor(focus: Option[Json]) {
    def downField(name: String): Cursor = focus match {
      case Some(JObject(fields)) => Cursor(fields.get(name))
      case _                     => Cursor(None)
    }
  }

  // Domain types
  case class RegistrationForm(username: String, email: String, age: Int)
  case class Address(street: String, city: String, zip: String)

  // -------------------------------------------------------------------------
  // Exercise 1: Validate that a Json is a non-empty JString.
  // TODO: If JString with non-empty value, return Valid(value).
  //       If JString(""), return Invalid with "must not be empty".
  //       If not a JString, return Invalid with "expected string".
  // -------------------------------------------------------------------------
  def exercise1_validateNonEmptyString(json: Json, fieldName: String): Validated[String, String] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Validate that a Json is a JNumber in a given range.
  // TODO: If JNumber in [min, max], return Valid(value.toInt).
  //       If JNumber out of range, return Invalid("fieldName must be between min and max").
  //       If not a JNumber, return Invalid("fieldName: expected number").
  // -------------------------------------------------------------------------
  def exercise2_validateNumberRange(json: Json, fieldName: String, min: Int, max: Int): Validated[String, Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Validate an email format (simplified: must contain '@').
  // TODO: First validate it's a non-empty string, then check for '@'.
  //       If no '@', return Invalid("email must contain @").
  //       Accumulate errors (e.g., empty AND no '@' should show both).
  // -------------------------------------------------------------------------
  def exercise3_validateEmail(json: Json): Validated[String, String] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Combine two validations using Validated.product.
  // TODO: Validate "username" (non-empty string) and "age" (number 1-150)
  //       from a JObject. Combine with product. If both fail, accumulate both errors.
  //       Return Validated[String, (String, Int)].
  // -------------------------------------------------------------------------
  def exercise4_combineTwoValidations(json: Json): Validated[String, (String, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Build an accumulating decoder for RegistrationForm.
  // TODO: Validate all three fields:
  //   "username" -> non-empty string
  //   "email"    -> must contain '@'
  //   "age"      -> number between 1 and 150
  //   Accumulate ALL errors. Return Validated[String, RegistrationForm].
  // Hint: Use nested Validated.product calls or manual accumulation.
  // -------------------------------------------------------------------------
  def exercise5_validateRegistration(json: Json): Validated[String, RegistrationForm] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Validate all elements in a JArray.
  // TODO: Given a JArray and a validation function for each element,
  //       validate every element and accumulate all errors.
  //       If all valid, return Valid(List[A]).
  //       If any invalid, return Invalid with all accumulated errors.
  // -------------------------------------------------------------------------
  def exercise6_validateArray[A](json: Json, validate: (Json, Int) => Validated[String, A]): Validated[String, List[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Validate an Address with custom error messages.
  // TODO: Validate "street" (non-empty), "city" (non-empty),
  //       "zip" (non-empty, must be 5 digits).
  //       Accumulate all errors. For zip validation, check:
  //         - non-empty
  //         - matches pattern of 5 digits (use forall(_.isDigit) && length == 5)
  // -------------------------------------------------------------------------
  def exercise7_validateAddress(json: Json): Validated[String, Address] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Convert between Validated and Either.
  // TODO: Implement two functions:
  //   a) eitherToValidated: Convert Either[String, A] to Validated[String, A]
  //   b) validatedToEither: Convert Validated[String, A] to Either[List[String], A]
  //   Return them as a tuple of functions.
  // -------------------------------------------------------------------------
  def exercise8_conversions: (
    Either[String, Any] => Validated[String, Any],
    Validated[String, Any] => Either[List[String], Any]
  ) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_validateNonEmptyString(JString("hello"), "name") == Valid("hello"))
    assert(exercise1_validateNonEmptyString(JString(""), "name") == Invalid(List("name must not be empty")))
    assert(exercise1_validateNonEmptyString(JNumber(42), "name") == Invalid(List("name: expected string")))
    println("Exercise 1 passed: non-empty string validation works")

    // Exercise 2
    assert(exercise2_validateNumberRange(JNumber(25), "age", 1, 150) == Valid(25))
    assert(exercise2_validateNumberRange(JNumber(200), "age", 1, 150) == Invalid(List("age must be between 1 and 150")))
    assert(exercise2_validateNumberRange(JString("x"), "age", 1, 150) == Invalid(List("age: expected number")))
    println("Exercise 2 passed: number range validation works")

    // Exercise 3
    assert(exercise3_validateEmail(JString("a@b.com")) == Valid("a@b.com"))
    assert(exercise3_validateEmail(JString("invalid")) == Invalid(List("email must contain @")))
    assert(exercise3_validateEmail(JString("")) == Invalid(List("email must not be empty")))
    println("Exercise 3 passed: email validation works")

    // Exercise 4
    val goodPair = JObject(Map("username" -> JString("alice"), "age" -> JNumber(25)))
    assert(exercise4_combineTwoValidations(goodPair) == Valid(("alice", 25)))
    val badPair = JObject(Map("username" -> JString(""), "age" -> JNumber(200)))
    val badResult = exercise4_combineTwoValidations(badPair)
    assert(badResult.isInstanceOf[Invalid[_]])
    assert(badResult.toEither.left.getOrElse(Nil).size == 2)
    println("Exercise 4 passed: combined validations accumulate errors")

    // Exercise 5
    val goodReg = JObject(Map("username" -> JString("alice"), "email" -> JString("a@b.com"), "age" -> JNumber(25)))
    assert(exercise5_validateRegistration(goodReg) == Valid(RegistrationForm("alice", "a@b.com", 25)))
    val badReg = JObject(Map("username" -> JString(""), "email" -> JString("bad"), "age" -> JNumber(200)))
    val badRegResult = exercise5_validateRegistration(badReg)
    assert(badRegResult.isInstanceOf[Invalid[_]])
    assert(badRegResult.toEither.left.getOrElse(Nil).size == 3)
    println("Exercise 5 passed: registration validation accumulates all errors")

    // Exercise 6
    val arr = JArray(Vector(JNumber(5), JNumber(200), JNumber(3), JNumber(-1)))
    val arrResult = exercise6_validateArray[Int](arr, (j, idx) =>
      exercise2_validateNumberRange(j, s"element[$idx]", 1, 100)
    )
    assert(arrResult.isInstanceOf[Invalid[_]])
    assert(arrResult.toEither.left.getOrElse(Nil).size == 2)
    val goodArr = JArray(Vector(JNumber(1), JNumber(50), JNumber(99)))
    assert(exercise6_validateArray[Int](goodArr, (j, _) =>
      exercise2_validateNumberRange(j, "elem", 1, 100)
    ) == Valid(List(1, 50, 99)))
    println("Exercise 6 passed: array validation works")

    // Exercise 7
    val goodAddr = JObject(Map("street" -> JString("123 Main"), "city" -> JString("NYC"), "zip" -> JString("10001")))
    assert(exercise7_validateAddress(goodAddr) == Valid(Address("123 Main", "NYC", "10001")))
    val badAddr = JObject(Map("street" -> JString(""), "city" -> JString(""), "zip" -> JString("abc")))
    val badAddrResult = exercise7_validateAddress(badAddr)
    assert(badAddrResult.isInstanceOf[Invalid[_]])
    assert(badAddrResult.toEither.left.getOrElse(Nil).size == 3)
    println("Exercise 7 passed: address validation works")

    // Exercise 8
    val (e2v, v2e) = exercise8_conversions
    assert(e2v(Right(42)) == Valid(42))
    assert(e2v(Left("err")) == Invalid(List("err")))
    assert(v2e(Valid(42)) == Right(42))
    assert(v2e(Invalid(List("a", "b"))) == Left(List("a", "b")))
    println("Exercise 8 passed: conversions work")

    println("\nAll Circe009_Validation exercises passed!")
  }
}
