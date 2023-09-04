package org.shev4ik.coding.core

import scala.collection.mutable

object ScalaEqualsHashcode extends App {

  val map = mutable.Map[Person, String]()

  Some(Person("jack", "london") == Person("jack", "clay")) foreach println
  Some(Person("jack", "london") == null) foreach println
  Some(1 == Person("jack", "london")) foreach println

  case class Person(firstName: String, lastName: String) {
    override def equals(obj: Any): Boolean = {
      obj match {
        case p: Person ⇒ firstName == p.firstName && lastName == p.lastName
        case _         ⇒ false
      }
    }

    // intention - to put objects in the same bucket
    override def hashCode(): Int = 31
  }
  map += (Person("peter", "johnson") → "Moscow")
  map += (Person("peter", "beck")    → "Paris")

  Some(map.get(Person("peter", "beck"))) foreach println
  Some(map.get(Person("peter", "johnson"))) foreach println

}
