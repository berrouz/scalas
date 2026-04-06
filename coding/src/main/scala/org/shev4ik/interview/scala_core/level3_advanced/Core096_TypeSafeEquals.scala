package org.shev4ik.interview.scala_core.level3_advanced

object Core096_TypeSafeEquals {

  // Exercise 1: === operator
  // TODO: Define an Eq type class with a type-safe === method
  trait Eq[T] {
    def eqv(a: T, b: T): Boolean
  }

  object Eq {
    def apply[T](implicit ev: Eq[T]): Eq[T] = ev
    def instance[T](f: (T, T) => Boolean): Eq[T] = new Eq[T] { def eqv(a: T, b: T): Boolean = f(a, b) }
  }

  // TODO: Add === syntax via implicit class
  implicit class EqOps[T](val lhs: T) extends AnyVal {
    def ===(rhs: T)(implicit eq: Eq[T]): Boolean = ???
    def =!=(rhs: T)(implicit eq: Eq[T]): Boolean = ???
  }

  // Exercise 2: Type-safe equality instances
  // TODO: Implement Eq for Int, String, and Boolean
  implicit val eqInt: Eq[Int] = ???
  implicit val eqString: Eq[String] = ???
  implicit val eqBoolean: Eq[Boolean] = ???

  // Exercise 3: Eq type class for custom types
  // TODO: Implement Eq for a custom case class
  case class UserId(value: Long)
  case class User(id: UserId, name: String)

  implicit val eqUserId: Eq[UserId] = ???
  implicit val eqUser: Eq[User] = ???

  // Exercise 4: Equality for ADTs
  // TODO: Implement Eq for a sealed trait hierarchy
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape

  implicit val eqShape: Eq[Shape] = ???

  // Exercise 5: Universal equals problem
  // TODO: Demonstrate the problem with universal equals (== works on any two types)
  //       and show how type-safe === prevents it
  def universalEqualsProblem(): Boolean = {
    // This compiles with == but shouldn't make sense:
    // "hello" == 42  // always false, likely a bug
    // With === this would NOT compile (different types)
    // TODO: Return true to indicate we understand the problem
    ???
  }

  // Exercise 6: Strict equality concept (Scala 3 multiversal equality)
  // TODO: Simulate Scala 3's strict equality using CanEqual-like evidence
  @annotation.implicitNotFound("Cannot compare ${A} with ${B}")
  trait CanEqual[A, B]

  object CanEqual {
    // Same type can always be compared
    implicit def sameType[A]: CanEqual[A, A] = new CanEqual[A, A] {}

    // Allow comparing Int with Long
    implicit val intLong: CanEqual[Int, Long] = new CanEqual[Int, Long] {}
    implicit val longInt: CanEqual[Long, Int] = new CanEqual[Long, Int] {}
  }

  // TODO: Write a method that requires CanEqual evidence
  def safeEquals[A, B](a: A, b: B)(implicit ev: CanEqual[A, B]): Boolean = ???

  // Exercise 7: Multiversal equality
  // TODO: Extend the CanEqual system to allow comparing subtypes of a sealed trait
  sealed trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  object Animal {
    implicit val canEqualDogDog: CanEqual[Dog, Dog] = new CanEqual[Dog, Dog] {}
    implicit val canEqualCatCat: CanEqual[Cat, Cat] = new CanEqual[Cat, Cat] {}
    implicit val canEqualDogCat: CanEqual[Dog, Cat] = new CanEqual[Dog, Cat] {}
    implicit val canEqualCatDog: CanEqual[Cat, Dog] = new CanEqual[Cat, Dog] {}
  }

  // Exercise 8: Equality best practices
  // TODO: Implement Eq derivation for Option[T] and List[T]
  implicit def eqOption[T](implicit eq: Eq[T]): Eq[Option[T]] = ???

  implicit def eqList[T](implicit eq: Eq[T]): Eq[List[T]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 & 2
    assert((42 === 42) == true)
    assert((42 === 43) == false)
    assert(("hello" === "hello") == true)
    assert(("hello" =!= "world") == true)

    // Exercise 3
    assert((UserId(1L) === UserId(1L)) == true)
    assert((UserId(1L) === UserId(2L)) == false)
    val u1 = User(UserId(1), "Alice")
    val u2 = User(UserId(1), "Alice")
    val u3 = User(UserId(2), "Bob")
    assert((u1 === u2) == true)
    assert((u1 === u3) == false)

    // Exercise 4
    assert((Circle(5.0): Shape) === (Circle(5.0): Shape))
    assert(!((Circle(5.0): Shape) === (Rectangle(3.0, 4.0): Shape)))

    // Exercise 5
    assert(universalEqualsProblem() == true)

    // Exercise 6
    assert(safeEquals(42, 42) == true)
    assert(safeEquals(42, 42L) == false)

    // Exercise 7
    assert(safeEquals(Dog("Rex"), Dog("Rex")) == true)
    assert(safeEquals(Dog("Rex"), Cat("Whiskers")) == false)

    // Exercise 8
    assert((Some(1): Option[Int]) === (Some(1): Option[Int]))
    assert(!((Some(1): Option[Int]) === (None: Option[Int])))
    assert(List(1, 2, 3) === List(1, 2, 3))
    assert(!(List(1, 2) === List(1, 3)))

    println("All Core096_TypeSafeEquals exercises passed!")
  }
}
