package org.shev4ik.coding.core

object ScalaTypeObject extends App {


  case class Person(name: String)

  object Person

  private def hello(p: Person): Unit = println(p)
}
