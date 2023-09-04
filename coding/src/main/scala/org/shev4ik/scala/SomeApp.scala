package org.shev4ik.scala

object SomeApp extends App {

  trait Hello[A] {
    def print(a: A): Any
  }

  class SuperHello extends Hello[String] {
    override def print(a: String): String = a
  }

  val g: Hello[String] = new SuperHello

  g.print("Hello")
}
