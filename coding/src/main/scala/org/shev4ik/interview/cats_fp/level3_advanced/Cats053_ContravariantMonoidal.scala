package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 053 - ContravariantMonoidal
 *
 * ContravariantMonoidal combines Contravariant with Monoidal (product + unit).
 * It provides contramap, product, and unit. This is useful for composing
 * Predicates, Equivalences, Comparisons, and Encoders.
 */
object Cats053_ContravariantMonoidal {

  // Exercise 1: Contravariant.contramap - transform input of a function
  // TODO: Use contramap to adapt a predicate to work on a different type.
  def exercise1_contramap(): Int => Boolean = {
    val isPositive: Int => Boolean = _ > 0

    // Use Contravariant to create a predicate that checks if a string's length is positive
    // Actually, let's work with Int => Boolean directly
    // Contramap isPositive to check if (n * -1) is positive (i.e., n is negative)
    ???
  }

  // Exercise 2: product - combine two contravariant functors
  // TODO: Demonstrate the product operation for combining predicates.
  case class Person(name: String, age: Int)

  def exercise2_product(): Person => Boolean = {
    val nameCheck: Person => Boolean = _.name.nonEmpty
    val ageCheck: Person => Boolean = _.age >= 0

    // Combine both checks: person must have non-empty name AND non-negative age
    ???
  }

  // Exercise 3: divide (Contravariant product) - split input for two checks
  // TODO: Use divide to split input and check both parts.
  def exercise3_divide(): String => Boolean = {
    val lengthCheck: Int => Boolean = _ >= 3
    val startsWithUpper: Char => Boolean = _.isUpper

    // Divide: check that string length >= 3 AND first char is upper
    // Split String into (Int, Char) = (length, first char)
    ???
  }

  // Exercise 4: conquer (Contravariant unit) - create a trivially true predicate
  // TODO: Create a predicate that always returns true (the unit of the monoid).
  def exercise4_conquer(): String => Boolean = {
    // Create a predicate that always returns true for any input
    // This is the "conquer" / unit of ContravariantMonoidal
    ???
  }

  // Exercise 5: Predicate composition - compose complex predicates
  // TODO: Build a complex predicate from simple ones using contravariant composition.
  def exercise5_predicateComposition(): Person => Boolean = {
    val hasName: Person => Boolean = _.name.nonEmpty
    val isAdult: Person => Boolean = _.age >= 18
    val nameNotTooLong: Person => Boolean = _.name.length <= 50

    // Compose all three predicates: all must be true
    ???
  }

  // Exercise 6: Equivalence composition - compose equivalence relations
  // TODO: Build equivalence from parts using contravariant patterns.
  type Equiv[A] = (A, A) => Boolean

  def exercise6_equivalenceComposition(): Equiv[Person] = {
    val nameEquiv: Equiv[String] = _ == _
    val ageEquiv: Equiv[Int] = _ == _

    // Compose: two persons are equivalent if name AND age are equal
    ???
  }

  // Exercise 7: Comparison composition - compose orderings
  // TODO: Build a comparator from parts using contravariant patterns.
  def exercise7_comparisonComposition(): (Person, Person) => Int = {
    // Compare by name first, then by age
    val nameCompare: (String, String) => Int = _.compareTo(_)
    val ageCompare: (Int, Int) => Int = _.compareTo(_)

    // Compose: compare persons by name first, then by age for ties
    ???
  }

  // Exercise 8: Practical ContravariantMonoidal - encoder composition
  // TODO: Build a CSV encoder using contravariant composition.
  trait Encoder[A] {
    def encode(a: A): String
  }

  object Encoder {
    def apply[A](f: A => String): Encoder[A] = new Encoder[A] {
      def encode(a: A): String = f(a)
    }

    def contramap[A, B](ea: Encoder[A])(f: B => A): Encoder[B] =
      Encoder[B](b => ea.encode(f(b)))
  }

  case class Product(name: String, price: Double, quantity: Int)

  def exercise8_encoderComposition(): Encoder[Product] = {
    val stringEncoder: Encoder[String] = Encoder(identity)
    val doubleEncoder: Encoder[Double] = Encoder(_.toString)
    val intEncoder: Encoder[Int] = Encoder(_.toString)

    // Build a CSV encoder for Product using contramap on each field encoder
    // Output format: "name,price,quantity"
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_contramap()
    assert(r1(-5) == true && r1(5) == false, s"Exercise 1 failed")
    println(s"Exercise 1 passed: contramap => negative(-5)=${r1(-5)}, negative(5)=${r1(5)}")

    // Exercise 2
    val r2 = exercise2_product()
    assert(r2(Person("Alice", 30)) == true, s"Exercise 2 failed: valid person")
    assert(r2(Person("", 30)) == false, s"Exercise 2 failed: empty name")
    assert(r2(Person("Alice", -1)) == false, s"Exercise 2 failed: negative age")
    println(s"Exercise 2 passed: product => valid=${r2(Person("Alice", 30))}, emptyName=${r2(Person("", 30))}")

    // Exercise 3
    val r3 = exercise3_divide()
    assert(r3("Hello") == true, s"Exercise 3 failed: Hello")
    assert(r3("hi") == false, s"Exercise 3 failed: hi (too short)")
    assert(r3("hello") == false, s"Exercise 3 failed: hello (lowercase)")
    println(s"Exercise 3 passed: divide => Hello=${r3("Hello")}, hi=${r3("hi")}, hello=${r3("hello")}")

    // Exercise 4
    val r4 = exercise4_conquer()
    assert(r4("anything") == true && r4("") == true, s"Exercise 4 failed")
    println(s"Exercise 4 passed: conquer => always true")

    // Exercise 5
    val r5 = exercise5_predicateComposition()
    assert(r5(Person("Alice", 25)) == true, s"Exercise 5 failed: valid")
    assert(r5(Person("", 25)) == false, s"Exercise 5 failed: no name")
    assert(r5(Person("Alice", 10)) == false, s"Exercise 5 failed: underage")
    println(s"Exercise 5 passed: predicate composition => valid=${r5(Person("Alice", 25))}")

    // Exercise 6
    val r6 = exercise6_equivalenceComposition()
    assert(r6(Person("Alice", 30), Person("Alice", 30)) == true, s"Exercise 6 failed: same")
    assert(r6(Person("Alice", 30), Person("Bob", 30)) == false, s"Exercise 6 failed: diff name")
    println(s"Exercise 6 passed: equivalence => same=${r6(Person("Alice", 30), Person("Alice", 30))}")

    // Exercise 7
    val r7 = exercise7_comparisonComposition()
    assert(r7(Person("Alice", 30), Person("Bob", 25)) < 0, s"Exercise 7 failed: Alice < Bob")
    assert(r7(Person("Alice", 25), Person("Alice", 30)) < 0, s"Exercise 7 failed: same name, younger")
    println(s"Exercise 7 passed: comparison composition")

    // Exercise 8
    val r8 = exercise8_encoderComposition()
    val encoded = r8.encode(Product("Widget", 9.99, 100))
    assert(encoded == "Widget,9.99,100", s"Exercise 8 failed: $encoded")
    println(s"Exercise 8 passed: encoder => $encoded")

    println("\nAll Cats053_ContravariantMonoidal exercises passed!")
  }
}
