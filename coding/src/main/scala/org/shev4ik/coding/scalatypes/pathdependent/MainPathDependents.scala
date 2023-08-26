package org.shev4ik.coding.scalatypes.pathdependent

import scala.language.higherKinds

object MainPathDependents extends App {

  sealed trait Nat
  class Succ[N <: Nat] extends Nat
  object Zero extends Nat
  type Zero = Zero.type
  type One = Succ[Zero]
  type Two = Succ[One]
  type Three = Succ[Two]
  type Four = Succ[Three]

  sealed trait Shape {
    type CornerCount <: Nat
  }

  object Circle extends Shape {
    override type CornerCount = Zero
  }
  object Triangle extends Shape {
    override type CornerCount = Three
  }
  object Square extends Shape {
    override type CornerCount = Four
  }

  type Circle = Circle.type
  type Triangle = Triangle.type
  type Square = Square.type

  implicitly[Circle#CornerCount =:= Zero]
  implicitly[Triangle#CornerCount =:= Three]
  implicitly[Square# CornerCount =:= Four]


  trait CornerCount[In <: Shape] {
    type Out <: Nat
  }

  implicit val circleCornerCount= new CornerCount[Circle] {
    override type Out = Zero
  }

  implicit val triangleCornerCount = new CornerCount[Triangle] {
    override type Out = Three
  }

  implicit val squareCornerCount = new CornerCount[Square] {
    override type Out = Four
  }

  implicitly[CornerCount[Circle] { type Out = Zero } ]
  implicitly[CornerCount[Triangle] { type Out = Three } ]
  implicitly[CornerCount[Square] { type Out = Four } ]


  trait Inner[F]{
    type T
  }


  object Inner{
    def apply[F](implicit inner: Inner[F]): Inner[F] = inner

    implicit def mk[F[_], A]: Inner[F[A]] {
      type T = A
    } = new Inner[F[A]]{
      type T = A
    }
  }

  def hello[F[_], T](a: T)(implicit inner: Inner[F[T]]): inner.T= a.asInstanceOf[inner.T]


  hello(1)
  hello("a")

}
