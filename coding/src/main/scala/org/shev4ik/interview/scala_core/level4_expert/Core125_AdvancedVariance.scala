package org.shev4ik.interview.scala_core.level4_expert

/**
 * Core125 - Advanced Variance
 * Level: Expert
 *
 * Deep dive into variance in complex type hierarchies,
 * variance flip in function types, and practical variance design.
 *
 * Key concepts:
 * - Variance in complex hierarchies
 * - Variance flip in function types
 * - Use-site vs declaration-site variance
 */
object Core125_AdvancedVariance {

  // Exercise 1: Variance flip in Function types
  // TODO: Explain why Function1[-A, +B] has contravariant input and covariant output.
  // Implement a demonstration showing that Function1[Animal, Cat] is a subtype of Function1[Cat, Animal].
  trait Animal { def name: String }
  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  def exercise1(): Boolean = ???

  // Exercise 2: Covariant container with lower bound
  // TODO: Implement a covariant immutable stack that uses lower bounds for push.
  // Push should accept supertypes: Stack[Cat].push(animal: Animal) => Stack[Animal]
  sealed trait Stack[+A] {
    def push[B >: A](item: B): Stack[B] = ???
    def pop: (A, Stack[A]) = ???
    def isEmpty: Boolean = ???
  }

  // Exercise 3: Contravariant type class
  // TODO: Implement a contravariant Comparator that demonstrates variance flip.
  // If you can compare Animals, you can compare Cats (contravariance).
  trait Comparator[-A] {
    def compare(a1: A, a2: A): Int
  }

  def exercise3(): Comparator[Cat] = ???

  // Exercise 4: Invariant container with type-safe update
  // TODO: Implement an invariant mutable-like container (using copy) where
  // the type parameter must be exactly matched for safety.
  case class Cell[A](value: A) {
    def update(newValue: A): Cell[A] = ???
    def map[B](f: A => B): Cell[B] = ???
  }

  // Exercise 5: Variance and bounds interaction
  // TODO: Implement a covariant Writer that accumulates values.
  // The combine method should use a lower bound to allow combining with wider types.
  trait Writer[+A] {
    def value: A
    def combine[B >: A](other: Writer[B])(f: (B, B) => B): Writer[B] = ???
  }

  // Exercise 6: Phantom variance
  // TODO: Demonstrate that phantom type parameters can be safely declared as
  // covariant even though they appear in no method signatures.
  sealed trait Permission
  trait ReadOnly extends Permission
  trait ReadWrite extends ReadOnly

  case class Handle[+P <: Permission](id: String)

  def exercise6(): Handle[ReadOnly] = ???

  // Exercise 7: Bivariance simulation
  // TODO: Show how a type parameter that appears in neither covariant nor
  // contravariant position can be treated as bivariant (both co- and contra-).
  // In Scala 2, this isn't directly expressible — show with phantom type.
  trait Bivariant[A] {
    def process: String = ???
  }

  // Exercise 8: Variance in nested type constructors
  // TODO: Implement a Functor for a nested type F[G[A]] where F is covariant
  // and G is covariant, showing that covariance composes.
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  type Composed[F[_], G[_]] = { type L[A] = F[G[A]] }
  def exercise8[F[_], G[_]](implicit ff: Functor[F], fg: Functor[G]): Functor[Composed[F, G]#L] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1(), "Exercise 1: variance flip demo")
    println("Exercise 1 passed: Variance flip in Function types")

    // Exercise 3
    val animalComp: Comparator[Animal] = (a1: Animal, a2: Animal) => a1.name.compareTo(a2.name)
    val catComp: Comparator[Cat] = animalComp // contravariance allows this
    assert(catComp.compare(Cat("Alice"), Cat("Bob")) < 0)
    println("Exercise 3 passed: Contravariant Comparator")

    // Exercise 6
    val rwHandle: Handle[ReadWrite] = Handle[ReadWrite]("rw-1")
    val roHandle: Handle[ReadOnly] = rwHandle // covariance allows this
    assert(roHandle.id == "rw-1")
    println("Exercise 6 passed: Phantom variance")

    println("\nAll Core125 exercises passed!")
  }
}
