package org.shev4ik.coding.scalatypes.abstracttypes

object AbstractTypeMembersMain extends App {


  trait Vehicle {
    type T
    def vehicleModel(vmt: T): T
    val color: T
  }

  class Mercedes extends Vehicle {
    override type T = String

    override def vehicleModel(vmt: String): String = vmt

    override val color: String = "grey"
  }
}
