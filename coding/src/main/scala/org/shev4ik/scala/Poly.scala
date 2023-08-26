package org.shev4ik.scala

object Poly extends App {

  trait Generic {
    def name: String

    type B
    def billing: B
  }

  trait Billing

  case class PersonBilling() extends Billing
  case class AnimalBilling(name: String) extends Billing

  case class Person(billing: PersonBilling) extends Generic {
    def name: String = "person"

    type B = PersonBilling
  }

  case class Animal(billing: AnimalBilling) extends Generic {
    type B = AnimalBilling
    def name: String = "animal"
  }

  val things = Seq(Animal(billing = AnimalBilling("")), Person(billing = PersonBilling()))

  things.foreach(thing => println(thing.name))

  trait Has[T <: Generic] {
    type B <: Billing
    def billingData(t: T): T#B
  }

  object Has {
    implicit val aaa: Has[Animal] = new Has[Animal] {
      type B = AnimalBilling
      override def billingData(t: Animal): B = t.billing
    }

    implicit val bbb: Has[Person] = new Has[Person] {
      type B = PersonBilling
      override def billingData(t: Person): B = t.billing
    }

    def apply[T <: Generic](implicit ev: Has[T]): Has[T] = ev
  }

  //val billingA: AnimalBilling = program(things.head)
  val billingB: PersonBilling = program(Person(billing = PersonBilling()))

  def program[T <: Generic: Has](t: T): T#B = Has[T].billingData(t)
}
