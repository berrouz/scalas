package org.shev4ik.scala

object ScalaOverride extends App {

  println(Cats().body)

  trait BaseClass {
    def body: String = "a"
  }

  trait OtherTrait {
    def body: String = "b"
  }
  case class Cats() extends BaseClass with OtherTrait {
    override val body: String = "body"
  }
}
