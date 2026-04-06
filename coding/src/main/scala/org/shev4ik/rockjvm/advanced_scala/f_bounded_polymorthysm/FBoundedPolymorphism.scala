package org.shev4ik.rockjvm.advanced_scala.f_bounded_polymorthysm

object FBoundedPolymorphism extends App {

  trait Animal[A] { this: Animal[A] =>
    def breed: List[A]
  }

  class Cat extends Animal[Cat] {
    override def breed: List[Cat] = ???
  }

  class Dog extends Animal[Dog] {
    override def breed: List[Dog] = ???
  }

}
