package org.shev4ik.fp

import scala.language.implicitConversions

object ImplicitMain extends App {

  trait Bookable {
    def name: String
  }
  case class Book(name: String) extends Bookable

  case class Person(name: String) extends Bookable

  implicit def toPerson(book: Bookable): Person = {
    Person(book.name)
  }

  def handle(person: Person): Unit = {
    println(person)
  }

  handle(Book("a"))

}
