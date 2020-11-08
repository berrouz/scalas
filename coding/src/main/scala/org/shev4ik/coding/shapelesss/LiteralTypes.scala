package org.shev4ik.coding.shapelesss

object LiteralTypes extends App {
  import shapeless.syntax.singleton._

  val x = 42.narrow


  import shapeless._
  def only20(x: Witness.`20`.T) = x

  only20(20)


  case class Wide[T <: Singleton](t: T) {
    println(t)
  }


}
