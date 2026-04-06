package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 003 - Order Type Class
 *
 * Order extends Eq and provides total ordering. It is the Cats equivalent of
 * scala.math.Ordering but integrated with the Cats type class hierarchy.
 *
 * Key methods: compare, min, max, Order.from, toOrdering
 */
object Cats003_Order {

  case class Person(name: String, age: Int)
  case class Employee(name: String, salary: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Use Order[Int].compare to compare two integers.
  // TODO: Return the result of Order[Int].compare(a, b).
  // Returns negative if a < b, 0 if a == b, positive if a > b.
  // -------------------------------------------------------------------------
  def exercise1_compareInts(a: Int, b: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use Order[Int].min to get the smaller of two integers.
  // TODO: Return the minimum of a and b using Order.
  // -------------------------------------------------------------------------
  def exercise2_minOfTwo(a: Int, b: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use Order[Int].max to get the larger of two integers.
  // TODO: Return the maximum of a and b using Order.
  // -------------------------------------------------------------------------
  def exercise3_maxOfTwo(a: Int, b: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create an Order instance using Order.from.
  // TODO: Create Order[Person] that orders by age ascending.
  // Hint: Order.from((a, b) => ...)
  // -------------------------------------------------------------------------
  implicit val personOrder: Order[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create an Order[Employee] by salary descending using Order.by and reverse.
  // TODO: Use Order.by[Employee, Double](_.salary).reverse for descending order.
  // -------------------------------------------------------------------------
  implicit val employeeOrder: Order[Employee] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Convert Order to scala.math.Ordering and sort a list.
  // TODO: Sort a list of Person using the implicit Order[Person] above.
  // Hint: personOrder.toOrdering can be used, or use .sorted with implicit Ordering.
  // -------------------------------------------------------------------------
  def exercise6_sortWithOrder(persons: List[Person]): List[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use comparison operators from Order syntax.
  // TODO: Return true if p1 < p2 according to the Order[Person] (by age).
  // Hint: With cats.implicits._ and an implicit Order[Person], you can use p1 < p2.
  // -------------------------------------------------------------------------
  def exercise7_comparisonOperators(p1: Person, p2: Person): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use Order.whenEqual to compose orderings.
  // TODO: Create an Order[Person] that orders by age first, then by name.
  // Hint: Order.whenEqual(Order.by(_.age), Order.by(_.name))
  // -------------------------------------------------------------------------
  def exercise8_composedOrder: Order[Person] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_compareInts(1, 2) < 0)
    assert(exercise1_compareInts(2, 2) == 0)
    assert(exercise1_compareInts(3, 2) > 0)
    println("Exercise 1 passed: Order[Int].compare")

    // Exercise 2
    assert(exercise2_minOfTwo(3, 7) == 3)
    assert(exercise2_minOfTwo(10, 5) == 5)
    println("Exercise 2 passed: Order[Int].min")

    // Exercise 3
    assert(exercise3_maxOfTwo(3, 7) == 7)
    assert(exercise3_maxOfTwo(10, 5) == 10)
    println("Exercise 3 passed: Order[Int].max")

    // Exercise 4
    val alice = Person("Alice", 30)
    val bob = Person("Bob", 25)
    assert(personOrder.compare(bob, alice) < 0)
    println("Exercise 4 passed: Order.from for Person")

    // Exercise 5
    val e1 = Employee("Alice", 100000)
    val e2 = Employee("Bob", 120000)
    assert(employeeOrder.compare(e2, e1) < 0) // Bob earns more, comes first in descending
    println("Exercise 5 passed: Order.by with reverse for Employee")

    // Exercise 6
    val persons = List(Person("Charlie", 35), Person("Alice", 30), Person("Bob", 25))
    val sorted = exercise6_sortWithOrder(persons)
    assert(sorted == List(Person("Bob", 25), Person("Alice", 30), Person("Charlie", 35)))
    println("Exercise 6 passed: sort with Order -> Ordering")

    // Exercise 7
    assert(exercise7_comparisonOperators(bob, alice) == true) // 25 < 30
    assert(exercise7_comparisonOperators(alice, bob) == false)
    println("Exercise 7 passed: comparison operators via Order syntax")

    // Exercise 8
    val composed = exercise8_composedOrder
    val p1 = Person("Alice", 30)
    val p2 = Person("Bob", 30)
    assert(composed.compare(p1, p2) < 0) // same age, Alice < Bob by name
    println("Exercise 8 passed: Order.whenEqual composition")

    println("\nAll Cats003_Order exercises passed!")
  }
}
