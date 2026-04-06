package org.shev4ik.exercises

/**
 * Exercise: Implement Validation type that accumulates errors
 *
 * This is a classic interview question that tests understanding of:
 * - Applicative vs Monad
 * - Error accumulation
 * - Type classes
 *
 * Key insight: Validation can be an Applicative but NOT a Monad
 * because it needs to accumulate errors independently (Applicative)
 * rather than short-circuit on first error (Monad).
 */

sealed trait Validation[+E, +A] {

  // TODO: Implement map
  // Transform the success value, leave errors unchanged
  def map[B](f: A => B): Validation[E, B] = this match {
    case Valid(value) => Valid(f(value))
    case Invalid(value) => Invalid(value)
  }

  // TODO: Implement map2
  // Combine two validations, accumulating errors if both fail
  // This is the KEY method for Applicative
  def map2[EE >: E, B, C](vb: Validation[EE, B])(f: (A, B) => C): Validation[EE, C] = ???

  // Alternative: try to implement flatMap
  // Question: Why can't flatMap accumulate errors?
  // def flatMap[EE >: E, B](f: A => Validation[EE, B]): Validation[EE, B] = ???
}

case class Valid[+A](value: A) extends Validation[Nothing, A]
case class Invalid[+E](errors: List[E]) extends Validation[E, Nothing]

object Validation {

  // TODO: Implement pure (also called success)
  def pure[A](a: A): Validation[Nothing, A] = ???

  // TODO: Implement fail
  def fail[E](error: E): Validation[E, Nothing] = ???

  // TODO: Implement fromOption
  def fromOption[E, A](opt: Option[A], error: E): Validation[E, A] = ???

  // TODO: Implement fromEither
  def fromEither[E, A](either: Either[E, A]): Validation[E, A] = ???

  // TODO: Implement sequence
  // Convert List[Validation[E, A]] to Validation[E, List[A]]
  // Accumulate ALL errors
  def sequence[E, A](validations: List[Validation[E, A]]): Validation[E, List[A]] = ???

  // TODO: Implement traverse
  def traverse[E, A, B](list: List[A])(f: A => Validation[E, B]): Validation[E, List[B]] = ???
}

/**
 * Real-world example: Form validation
 */
case class User(name: String, age: Int, email: String)

sealed trait ValidationError
case class EmptyField(field: String) extends ValidationError
case class InvalidFormat(field: String, reason: String) extends ValidationError
case class OutOfRange(field: String, min: Int, max: Int, actual: Int) extends ValidationError

object UserValidator {

  // TODO: Implement validateName
  // Rules:
  // - Not empty
  // - At least 2 characters
  // - Only letters and spaces
  def validateName(name: String): Validation[ValidationError, String] = ???

  // TODO: Implement validateAge
  // Rules:
  // - Between 0 and 150
  def validateAge(age: Int): Validation[ValidationError, Int] = ???

  // TODO: Implement validateEmail
  // Rules:
  // - Not empty
  // - Contains @
  // - Has text before and after @
  def validateEmail(email: String): Validation[ValidationError, String] = ???

  // TODO: Implement validateUser
  // Use map2 or sequence to accumulate ALL validation errors
  def validateUser(name: String, age: Int, email: String): Validation[ValidationError, User] = ???
}

/**
 * Tests - Run with ScalaTest
 */
object ValidationSpec extends App {

  // Test cases
  assert(Validation.pure(42) == Valid(42))
  assert(Validation.fail("error") == Invalid(List("error")))

  // Test map
  assert(Valid(42).map(_ * 2) == Valid(84))
  assert(Invalid(List("err")).map((x: Int) => x * 2) == Invalid(List("err")))

  // Test map2 - should accumulate errors
  val v1: Validation[String, Int] = Valid(1)
  val v2: Validation[String, Int] = Valid(2)
  val e1: Validation[String, Int] = Invalid(List("error1"))
  val e2: Validation[String, Int] = Invalid(List("error2"))

  assert(v1.map2(v2)(_ + _) == Valid(3))
  assert(v1.map2(e1)(_ + _) == Invalid(List("error1")))
  assert(e1.map2(v1)(_ + _) == Invalid(List("error1")))

  // KEY TEST: Should accumulate BOTH errors
  assert(e1.map2(e2)(_ + _) == Invalid(List("error1", "error2")))

  // Test user validation
  val invalidUser = UserValidator.validateUser("", -5, "invalid")
  invalidUser match {
    case Invalid(errors) =>
      println(s"✓ Accumulated ${errors.length} errors: $errors")
      assert(errors.length == 3) // Should catch all 3 errors
    case Valid(_) =>
      println("✗ Should have failed validation")
      assert(false)
  }

  val validUser = UserValidator.validateUser("John Doe", 30, "john@example.com")
  validUser match {
    case Valid(user) =>
      println(s"✓ Valid user: $user")
      assert(user.name == "John Doe")
    case Invalid(errors) =>
      println(s"✗ Should have passed validation, got errors: $errors")
      assert(false)
  }

  println("\n✓ All validation tests passed!")
}

/**
 * Discussion Questions (prepare answers):
 *
 * 1. Why can Validation be an Applicative but not a Monad?
 * 2. What's the difference between Validation and Either?
 * 3. When would you use Validation vs Either in production code?
 * 4. How would you implement a typeclass instance for Validation?
 * 5. Can you implement map2 in terms of flatMap? Why or why not?
 * 6. What are the Applicative laws and how can you verify them for Validation?
 * 7. How does error accumulation work with map3, map4, mapN?
 */
