package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 006 - Functor Type Class
 *
 * Functor[F[_]] provides the `map` operation, allowing you to transform
 * the value inside a context F without changing the structure.
 *
 * Laws:
 *   fa.map(identity) == fa  (identity)
 *   fa.map(f).map(g) == fa.map(f andThen g)  (composition)
 *
 * Key methods: map, as, void, fproduct, compose, lift, widen
 */
object Cats006_Functor {

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // -------------------------------------------------------------------------
  // Exercise 1: Use Functor[Option].map to transform the value inside Option.
  // TODO: Map the function f over the option using Functor[Option].map.
  // -------------------------------------------------------------------------
  def exercise1_functorMap(opt: Option[Int], f: Int => String): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use .as to replace the value inside a Functor with a constant.
  // TODO: Replace the value inside the Option with the given constant.
  // Hint: opt.as(value) replaces whatever is inside with value.
  // -------------------------------------------------------------------------
  def exercise2_as(opt: Option[Int], value: String): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use .void to discard the value, replacing it with Unit.
  // TODO: Return opt.void.
  // -------------------------------------------------------------------------
  def exercise3_void(opt: Option[Int]): Option[Unit] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use .fproduct to pair each value with the result of a function.
  // TODO: Return list.fproduct(f), which gives List[(A, B)].
  // -------------------------------------------------------------------------
  def exercise4_fproduct(list: List[String], f: String => Int): List[(String, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a Functor instance for Tree using Functor.instance (custom type).
  // TODO: Implement Functor[Tree] by recursively mapping over Leaf and Branch.
  // -------------------------------------------------------------------------
  implicit val treeFunctor: Functor[Tree] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use Functor.compose to compose two functors (e.g. List and Option).
  // TODO: Map a function over List[Option[Int]] using composed functor.
  // Hint: Functor[List].compose[Option].map(data)(f)
  // -------------------------------------------------------------------------
  def exercise6_compose(data: List[Option[Int]], f: Int => String): List[Option[String]] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use Functor.lift to lift a function A => B to F[A] => F[B].
  // TODO: Lift the function f into the Option functor, then apply it.
  // Hint: Functor[Option].lift(f) returns Option[A] => Option[B].
  // -------------------------------------------------------------------------
  def exercise7_lift(opt: Option[Int], f: Int => String): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use .widen to upcast the value inside a Functor.
  // TODO: Given a List[Int], widen it to List[Any] using .widen.
  // Hint: list.widen[Any] upcasts the inner type.
  // -------------------------------------------------------------------------
  def exercise8_widen(list: List[Int]): List[Any] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_functorMap(Some(42), _.toString) == Some("42"))
    assert(exercise1_functorMap(None, _.toString) == None)
    println("Exercise 1 passed: Functor[Option].map")

    // Exercise 2
    assert(exercise2_as(Some(42), "hello") == Some("hello"))
    assert(exercise2_as(None, "hello") == None)
    println("Exercise 2 passed: .as replaces value")

    // Exercise 3
    assert(exercise3_void(Some(42)) == Some(()))
    assert(exercise3_void(None) == None)
    println("Exercise 3 passed: .void discards value")

    // Exercise 4
    assert(exercise4_fproduct(List("hi", "hello"), _.length) == List(("hi", 2), ("hello", 5)))
    println("Exercise 4 passed: .fproduct pairs with result")

    // Exercise 5
    val tree: Tree[Int] = Branch(Leaf(1), Branch(Leaf(2), Leaf(3)))
    val mapped = Functor[Tree].map(tree)(_ * 10)
    assert(mapped == Branch(Leaf(10), Branch(Leaf(20), Leaf(30))))
    println("Exercise 5 passed: Functor[Tree] custom instance")

    // Exercise 6
    val data = List(Some(1), None, Some(3))
    assert(exercise6_compose(data, _.toString) == List(Some("1"), None, Some("3")))
    println("Exercise 6 passed: Functor.compose")

    // Exercise 7
    assert(exercise7_lift(Some(42), _.toString) == Some("42"))
    assert(exercise7_lift(None, (_: Int).toString) == None)
    println("Exercise 7 passed: Functor.lift")

    // Exercise 8
    val widened: List[Any] = exercise8_widen(List(1, 2, 3))
    assert(widened == List(1, 2, 3))
    println("Exercise 8 passed: .widen upcasts inner type")

    println("\nAll Cats006_Functor exercises passed!")
  }
}
