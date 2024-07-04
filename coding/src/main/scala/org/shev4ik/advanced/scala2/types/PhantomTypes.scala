package org.shev4ik.advanced.scala2.types

object PhantomTypes extends App {

  sealed trait Switch
  sealed trait On extends Switch
  sealed trait Off extends Switch


  class Bulb[S <: Switch] {
    def turnOn(implicit ev: S =:= Off): Bulb[On] = new Bulb[On]
    def turnOff(implicit ev: S =:= On): Bulb[Off] = new Bulb[Off]
    val bulb = new Bulb[Off]

    bulb.turnOn.turnOff.turnOn
  }
}
