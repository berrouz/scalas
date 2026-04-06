package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 002 - Show Type Class
 *
 * =What is Show?=
 *
 * `Show[A]` is a type class that provides a '''type-safe''' alternative to Java's `.toString`.
 * Every object in the JVM has `.toString`, which means you can accidentally call it on types
 * where the default output is meaningless (e.g., `new Thread().toString` => "Thread[...]").
 * With `Show`, you must explicitly define how a type is rendered as a `String`. If no instance
 * exists, you get a '''compile-time error''' instead of a garbage string at runtime.
 *
 * =Why does Show exist?=
 *   - '''Type safety''': prevents accidental use of unhelpful default `toString` implementations.
 *   - '''Explicitness''': you opt in to string rendering per type, making intentions clear.
 *   - '''Composability''': Show instances for `Option[A]`, `List[A]`, etc. are derived
 *     automatically if `Show[A]` exists (via Cats implicit machinery).
 *
 * =How to create Show instances=
 *   - `Show.show[A](a => ...)` -- factory method, most common for custom types.
 *   - `Show.fromToString[A]` -- delegates to `.toString`, useful as a quick bridge.
 *   - Manual `new Show[A] { def show(a: A) = ... }` -- full control.
 *   - `Show[B].contramap[A](f: A => B)` -- derive from an existing instance via contravariant
 *     mapping (e.g., derive `Show[UserId]` from `Show[String]` by extracting the id string).
 *
 * =Key methods=
 *   - `.show` -- extension method on any `A` with a `Show[A]` in scope.
 *   - `show"..."` -- string interpolator that uses `Show` instances for embedded expressions.
 *   - `Show.show(f)` / `Show.fromToString` -- factory methods for creating instances.
 *   - `.contramap` -- derives new Show from existing one (Show is contravariant functor).
 *
 * =Interview Tips=
 *   - "Show is a simple example to explain the type class pattern in interviews." It demonstrates
 *     the full pattern: trait + companion object + implicit instances + extension methods.
 *   - Explain contravariance: `Show[String]` can become `Show[Person]` via `.contramap(_.name)`
 *     because Show '''consumes''' a value (contravariant position).
 *   - Show is a good stepping stone before discussing more complex type classes like Eq, Order,
 *     Functor, Monad.
 *   - In Scala 3, type class derivation with `derives Show` makes this even more ergonomic.
 */
object Cats002_Show {

  case class Person(name: String, age: Int)
  case class Product(id: Int, label: String, price: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Use .show on an Int to get its string representation.
  // TODO: Return the string representation of the integer using .show.
  // Hint: cats.implicits._ provides Show instances for standard types.
  // -------------------------------------------------------------------------
  def exercise1_showInt(n: Int): String = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a Show instance using Show.show (factory method).
  // TODO: Create Show[Person] that formats as "Person(name=..., age=...)".
  // -------------------------------------------------------------------------
  implicit val personShow: Show[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Show instance using Show.fromToString.
  // TODO: Delegate to the default toString method but wrap it in Show.
  // -------------------------------------------------------------------------
  def exercise3_fromToString[A]: Show[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use the show string interpolator.
  // TODO: Given a Person, use show"..." interpolator to produce a string.
  // Format: "Name: <name>, Age: <age>"
  // Hint: You need Show[String] and Show[Int] in scope (they come from implicits).
  // -------------------------------------------------------------------------
  def exercise4_showInterpolator(p: Person): String = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use .show on a List[Int].
  // TODO: Return the show representation of a List[Int].
  // -------------------------------------------------------------------------
  def exercise5_showList(xs: List[Int]): String = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use .show on an Option[String].
  // TODO: Return the show representation of an Option[String].
  // -------------------------------------------------------------------------
  def exercise6_showOption(opt: Option[String]): String = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Create a Show instance for Product.
  // TODO: Format as "$<price> - <label> (id=<id>)"
  // -------------------------------------------------------------------------
  implicit val productShow: Show[Product] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use contramap on Show to derive a new Show instance.
  // TODO: Given Show[String], derive Show[Person] that shows only the name.
  // Hint: Show[String].contramap[Person](_.name)
  // -------------------------------------------------------------------------
  def exercise8_contramapShow: Show[Person] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_showInt(42) == "42")
    println("Exercise 1 passed: .show on Int")

    // Exercise 2
    val alice = Person("Alice", 30)
    assert(alice.show == "Person(name=Alice, age=30)")
    println("Exercise 2 passed: Show.show for Person")

    // Exercise 3
    val showInt = exercise3_fromToString[Int]
    assert(showInt.show(42) == "42")
    println("Exercise 3 passed: Show.fromToString")

    // Exercise 4
    assert(exercise4_showInterpolator(alice) == "Name: Alice, Age: 30")
    println("Exercise 4 passed: show interpolator")

    // Exercise 5
    assert(exercise5_showList(List(1, 2, 3)) == "List(1, 2, 3)")
    println("Exercise 5 passed: .show on List[Int]")

    // Exercise 6
    assert(exercise6_showOption(Some("hello")) == "Some(hello)")
    assert(exercise6_showOption(None) == "None")
    println("Exercise 6 passed: .show on Option[String]")

    // Exercise 7
    val p = Product(1, "Widget", 9.99)
    assert(p.show == "$9.99 - Widget (id=1)")
    println("Exercise 7 passed: Show for Product")

    // Exercise 8
    val nameShow = exercise8_contramapShow
    assert(nameShow.show(alice) == "Alice")
    println("Exercise 8 passed: contramap on Show")

    println("\nAll Cats002_Show exercises passed!")
  }
}
