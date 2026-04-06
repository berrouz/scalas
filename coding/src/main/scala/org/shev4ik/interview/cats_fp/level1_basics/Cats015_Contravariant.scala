package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 015 - Contravariant Functor
 *
 * Contravariant[F[_]] is the dual of Functor. While Functor's map transforms
 * the output (covariant position), Contravariant's contramap transforms the
 * input (contravariant position).
 *
 * If you have F[B] and a function A => B, you get F[A] via contramap.
 * Typical examples: Show, Eq, Order, Predicate-like types.
 *
 * Key methods: contramap, narrow
 */
object Cats015_Contravariant {

  case class Money(amount: Int)
  case class Salary(money: Money)
  case class Person(name: String, age: Int)

  // -------------------------------------------------------------------------
  // Exercise 1: Use contramap on Show to derive Show[Money] from Show[Int].
  // TODO: Derive Show[Money] using Show[Int].contramap(_.amount).
  // -------------------------------------------------------------------------
  implicit val moneyShow: Show[Money] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use contramap on Eq to derive Eq[Money] from Eq[Int].
  // TODO: Derive Eq[Money] that compares by amount.
  // -------------------------------------------------------------------------
  implicit val moneyEq: Eq[Money] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use contramap on Order to derive Order[Money] from Order[Int].
  // TODO: Derive Order[Money] that orders by amount.
  // -------------------------------------------------------------------------
  implicit val moneyOrder: Order[Money] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Chain multiple contramaps.
  // TODO: Derive Show[Salary] from Show[Int] by contramapping through Money.
  // Hint: Show[Int].contramap[Money](_.amount).contramap[Salary](_.money)
  // -------------------------------------------------------------------------
  implicit val salaryShow: Show[Salary] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use Contravariant[Show].contramap explicitly.
  // TODO: Use Contravariant[Show].contramap(Show[String])(_.age.toString) for Person.
  // -------------------------------------------------------------------------
  def exercise5_contravariantInstance: Show[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use contramap to adapt Eq for a different type.
  // TODO: Given Eq[String], derive Eq[Person] that compares by name only.
  // -------------------------------------------------------------------------
  def exercise6_eqByName: Eq[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use contramap to build a comparator from a simpler one.
  // TODO: Given Order[String], derive Order[Person] ordering by name alphabetically.
  // -------------------------------------------------------------------------
  def exercise7_orderByName: Order[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Demonstrate that Contravariant reverses the arrow direction.
  // Functor:       F[A], A => B  gives  F[B]    (covariant)
  // Contravariant: F[B], A => B  gives  F[A]    (contravariant)
  // TODO: Given Show[String] and a function Int => String (_.toString),
  // derive Show[Int] using contramap. Return the show result for 42.
  // -------------------------------------------------------------------------
  def exercise8_arrowReversal: String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(Money(100).show == "100")
    println("Exercise 1 passed: contramap on Show for Money")

    // Exercise 2
    assert(Money(100) === Money(100))
    assert(Money(100) =!= Money(200))
    println("Exercise 2 passed: contramap on Eq for Money")

    // Exercise 3
    assert(moneyOrder.compare(Money(100), Money(200)) < 0)
    assert(moneyOrder.compare(Money(200), Money(100)) > 0)
    println("Exercise 3 passed: contramap on Order for Money")

    // Exercise 4
    assert(Salary(Money(50000)).show == "50000")
    println("Exercise 4 passed: chained contramap for Salary")

    // Exercise 5
    val personShow = exercise5_contravariantInstance
    assert(personShow.show(Person("Alice", 30)) == "30")
    println("Exercise 5 passed: Contravariant[Show].contramap")

    // Exercise 6
    val nameEq = exercise6_eqByName
    assert(nameEq.eqv(Person("Alice", 30), Person("Alice", 25)) == true)
    assert(nameEq.eqv(Person("Alice", 30), Person("Bob", 30)) == false)
    println("Exercise 6 passed: Eq by name via contramap")

    // Exercise 7
    val nameOrd = exercise7_orderByName
    assert(nameOrd.compare(Person("Alice", 30), Person("Bob", 25)) < 0)
    assert(nameOrd.compare(Person("Bob", 30), Person("Alice", 25)) > 0)
    println("Exercise 7 passed: Order by name via contramap")

    // Exercise 8
    assert(exercise8_arrowReversal == "42")
    println("Exercise 8 passed: arrow reversal demonstration")

    println("\nAll Cats015_Contravariant exercises passed!")
  }
}
