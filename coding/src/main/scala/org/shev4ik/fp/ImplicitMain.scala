package org.shev4ik.fp

import scala.language.{higherKinds, implicitConversions}

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


  val f = for {
    a <- MyFlatMappable("hello")
    b <- MyFlatMappable("world")
  } yield (a,b)

  println(f)


  case class MyFlatMappable[A](book: A){
    def flatMap[B](a: A => MyFlatMappable[B]): MyFlatMappable[B] = {
      a(book)
    }

    def map[B](a: A => B): MyFlatMappable[B] = {
      MyFlatMappable(a(book))
    }
  }
}
