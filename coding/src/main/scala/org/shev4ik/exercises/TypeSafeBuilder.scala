package org.shev4ik.exercises

/**
 * Exercise: Type-Safe Builder Pattern
 *
 * Create a builder that enforces correct construction at COMPILE TIME
 * using phantom types and type-level state machines.
 *
 * This tests understanding of:
 * - Phantom types
 * - Type-level programming
 * - Evidence/witness types (=:=)
 * - API design
 *
 * Goal: Make it impossible to:
 * - Build without required fields
 * - Set the same field twice
 * - Call methods in wrong order
 */

// Phase 1: Define the type-level states
sealed trait BuilderState
sealed trait Empty extends BuilderState
sealed trait HasName extends BuilderState
sealed trait HasAge extends BuilderState
sealed trait Complete extends BuilderState

// TODO: Define a Person case class
case class Person(name: String, age: Int, email: Option[String] = None)

/**
 * TODO: Implement PersonBuilder
 *
 * Requirements:
 * 1. Must call withName first
 * 2. Must call withAge second
 * 3. withEmail is optional
 * 4. Can only call build() when complete
 * 5. All enforced at compile time!
 */
class PersonBuilder[S <: BuilderState] private (
  private val name: Option[String] = None,
  private val age: Option[Int] = None,
  private val email: Option[String] = None
) {

  // TODO: Implement withName
  // Should only work when S =:= Empty
  // Returns PersonBuilder[HasName]
  def withName(n: String)(implicit ev: S =:= Empty): PersonBuilder[HasName] = ???

  // TODO: Implement withAge
  // Should only work when S =:= HasName
  // Returns PersonBuilder[Complete]
  def withAge(a: Int)(implicit ev: S =:= HasName): PersonBuilder[Complete] = ???

  // TODO: Implement withEmail
  // Should work when S =:= HasName or S =:= Complete
  // Note: This is trickier - need to preserve state or use different approach
  def withEmail(e: String): PersonBuilder[S] = ???

  // TODO: Implement build
  // Should only work when S =:= Complete
  def build(implicit ev: S =:= Complete): Person = ???
}

object PersonBuilder {
  // TODO: Implement apply
  // Create a new builder in Empty state
  def apply(): PersonBuilder[Empty] = ???
}

/**
 * Alternative Implementation: Using HList-style type concatenation
 *
 * This allows methods in any order but still ensures all required fields are set
 */
sealed trait Has[+A]
case object Missing extends Has[Nothing]
case class Present[A](value: A) extends Has[A]

class FlexiblePersonBuilder[N <: Has[String], A <: Has[Int]] private (
  private val name: N,
  private val age: A,
  private val email: Option[String] = None
) {

  // TODO: Implement withName - can be called anytime
  def withName(n: String): FlexiblePersonBuilder[Present[String], A] = ???

  // TODO: Implement withAge - can be called anytime
  def withAge(a: Int): FlexiblePersonBuilder[N, Present[Int]] = ???

  // TODO: Implement withEmail
  def withEmail(e: String): FlexiblePersonBuilder[N, A] = ???

  // TODO: Implement build
  // Only works when N =:= Present[String] AND A =:= Present[Int]
  def build(implicit
    evName: N =:= Present[String],
    evAge: A =:= Present[Int]
  ): Person = ???
}

object FlexiblePersonBuilder {
  def apply(): FlexiblePersonBuilder[Missing.type, Missing.type] = ???
}

/**
 * Advanced: Generic Builder Framework
 *
 * Create a generic builder that works for any case class
 */

// Phantom type to track which fields have been set
sealed trait FieldSet
sealed trait FieldUnset extends FieldSet
sealed trait FieldSet1 extends FieldSet

// TODO: Implement a generic builder trait
trait GenericBuilder[T, S <: FieldSet] {
  def build(implicit ev: S =:= FieldSet1): T
}

/**
 * Tests
 */
object TypeSafeBuilderSpec extends App {

  println("Testing Type-Safe Builder Pattern...\n")

  // Test 1: Valid construction
  println("Test 1: Valid construction")
  val person1 = PersonBuilder()
    .withName("Alice")
    .withAge(30)
    .build

  assert(person1.name == "Alice")
  assert(person1.age == 30)
  assert(person1.email.isEmpty)
  println(s"✓ Built person: $person1")

  // Test 2: With email
  println("\nTest 2: With email")
  val person2 = PersonBuilder()
    .withName("Bob")
    .withAge(25)
    .withEmail("bob@example.com")
    .build

  assert(person2.email == Some("bob@example.com"))
  println(s"✓ Built person with email: $person2")

  // Test 3: These should NOT compile (uncomment to verify)
  /*
  // Missing name
  val invalid1 = PersonBuilder()
    .withAge(30)
    .build  // Compile error!

  // Missing age
  val invalid2 = PersonBuilder()
    .withName("Charlie")
    .build  // Compile error!

  // Wrong order
  val invalid3 = PersonBuilder()
    .withAge(30)
    .withName("Charlie")  // Compile error!
    .build

  // Duplicate name
  val invalid4 = PersonBuilder()
    .withName("Dave")
    .withName("Eve")  // Compile error!
    .withAge(35)
    .build
  */

  // Test 4: Flexible builder (any order)
  println("\nTest 3: Flexible builder")
  val person3 = FlexiblePersonBuilder()
    .withAge(40)
    .withName("Charlie")
    .withEmail("charlie@example.com")
    .build

  assert(person3.name == "Charlie")
  assert(person3.age == 40)
  println(s"✓ Built person with flexible builder: $person3")

  // Test 5: These should NOT compile with flexible builder
  /*
  // Missing name
  val invalidFlex1 = FlexiblePersonBuilder()
    .withAge(30)
    .build  // Compile error!

  // Missing age
  val invalidFlex2 = FlexiblePersonBuilder()
    .withName("Dave")
    .build  // Compile error!
  */

  println("\n✓ All type-safe builder tests passed!")
  println("\n💡 Try uncommenting the invalid examples to see compile-time safety!")
}

/**
 * Real-World Example: HTTP Request Builder
 */
sealed trait RequestState
sealed trait NoUrl extends RequestState
sealed trait HasUrl extends RequestState

class HttpRequestBuilder[S <: RequestState] private (
  private val url: Option[String] = None,
  private val method: String = "GET",
  private val headers: Map[String, String] = Map.empty,
  private val body: Option[String] = None
) {

  // TODO: Implement withUrl - required first step
  def withUrl(u: String)(implicit ev: S =:= NoUrl): HttpRequestBuilder[HasUrl] = ???

  // TODO: Implement withMethod - only after URL is set
  def withMethod(m: String)(implicit ev: S =:= HasUrl): HttpRequestBuilder[HasUrl] = ???

  // TODO: Implement withHeader
  def withHeader(key: String, value: String)(implicit ev: S =:= HasUrl): HttpRequestBuilder[HasUrl] = ???

  // TODO: Implement withBody
  def withBody(b: String)(implicit ev: S =:= HasUrl): HttpRequestBuilder[HasUrl] = ???

  // TODO: Implement build
  def build(implicit ev: S =:= HasUrl): HttpRequest = ???
}

case class HttpRequest(
  url: String,
  method: String,
  headers: Map[String, String],
  body: Option[String]
)

object HttpRequestBuilder {
  def apply(): HttpRequestBuilder[NoUrl] = new HttpRequestBuilder[NoUrl]()
}

/**
 * Discussion Questions (prepare answers):
 *
 * 1. What are phantom types and how do they help with compile-time safety?
 * 2. Explain the =:= type (type equality evidence). How does it work internally?
 * 3. What are the trade-offs of type-safe builders vs runtime validation?
 * 4. How would you implement this pattern with Scala 3's match types?
 * 5. Can you achieve similar safety with value classes instead of phantom types?
 * 6. What's the relationship between phantom types and dependent types?
 * 7. How does this pattern compare to the Builder pattern in Java?
 * 8. What are the performance implications of this approach?
 * 9. How would you handle optional fields in a type-safe way?
 * 10. Can you make the builder work with multiple required fields in any order?
 *
 * Bonus Challenge:
 * - Implement a type-safe builder for SQL queries
 * - Create a generic builder that works with any case class using Shapeless
 * - Add support for field validation at the type level
 */
