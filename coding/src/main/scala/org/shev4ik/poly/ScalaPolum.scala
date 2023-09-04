package org.shev4ik.poly

object ScalaPolum extends App {

  trait AbstractAlgorithm {
    type Result <: Thing
    def paint(): Result
  }

  trait Thing

  class Door   extends Thing
  class Window extends Thing

  class WindowAlgorithm() extends AbstractAlgorithm {
    override type Result = Window

    override def paint(): Window = ???
  }

  class DoorAlgorithm() extends AbstractAlgorithm {
    override type Result = Door

    override def paint(): Door = ???
  }
}
