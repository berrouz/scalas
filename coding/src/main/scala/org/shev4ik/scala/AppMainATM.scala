package org.shev4ik.scala

object AppMainATM extends App {

  trait Food
  trait Grass extends Food

  abstract class Animal {
    type T <: Food
    def eat(t: T): Unit
  }

  class Cow extends Animal {
    type T = Grass
    override def eat(t: Grass): Unit = ???
  }

  val cow = new Cow

  val animal: Animal = cow

  // animal.eat(new Food {})
}
