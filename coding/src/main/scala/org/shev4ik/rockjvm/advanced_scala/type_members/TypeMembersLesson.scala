package org.shev4ik.rockjvm.advanced_scala.type_members

object TypeMembersLesson extends App {

  class Animal

  class Dog extends Animal
  class Cat extends Animal

  class AnimalCollection {
    type AnimalType //

    type BoundedAnimal <: Animal

    type SuperBoundedAnimal >: Dog <: Animal

  }

  new AnimalCollection {
    override type AnimalType = Unit
  }

  val ac = new AnimalCollection

  trait MList {
    type A
    def head: A
    def tail: MList
  }

  trait CList extends MList {
    override type A
  }

  class IntList(hd: Integer, t1: IntList) extends CList {
    type A = Integer
    override def head: Integer = hd

    override def tail: MList = t1
  }


  type Req
  type Resp

  type DbCall = Req => Resp

  trait TraitGenerics[A] {
    def get: A
    def doIt(a: A): A
  }

  trait TraitTypeMember {
    type A

    def get: A
    def doIt(a: A): A
  }

  def printerGenerics(c: TraitGenerics[Int]) = c.doIt(c.get)

  def printerTypeMembers(c: TraitTypeMember): c.A = c.doIt(c.get)

  abstract class Number[T] {
    def +(that: T): T
  }

  case class Float64(value: Double) extends Number[Double] {
    override def +(that: Double): Double = ???
  }

  case class Int(value: Int) extends Number[Int] {
    override def +(that: Int): Int = ???
  }

}
