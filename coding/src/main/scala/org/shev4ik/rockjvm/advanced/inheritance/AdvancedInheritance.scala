package org.shev4ik.rockjvm.advanced.inheritance

object AdvancedInheritance extends App {
  trait Writer[T] {
    def write(value: T): Unit
  }

  trait Closeable {
    def close(status: Int): Unit
  }

  trait GenericStream[T] {
    def foreach(f: T => Unit): Unit
  }

  def processStream[T](stream: GenericStream[T] with Writer[T] with Closeable): Unit = {
    stream.foreach(println)
    stream.close(0)
  }

  // diamond problem

  trait Animal { def name: String }
  trait Lion extends Animal {
    override def name: String = "lion"
  }
  trait Tiger extends Animal {
    override def name: String = "tiger"
  }

  class Mutant extends Lion with Tiger {
    override def name: String = "ALIEN"
  }

  // trait type linearization

  trait Cold {
    def print: Unit = println("cold")
  }

  trait Green extends Cold {

  }
}

