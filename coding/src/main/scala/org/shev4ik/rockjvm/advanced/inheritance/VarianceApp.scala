package org.shev4ik.rockjvm.advanced.inheritance

object VarianceApp extends App {


  trait Animal

  case class Dog() extends Animal
  case class Cat() extends Animal


  case class Home[+A](){
    //def handle(a: A) = ???
  }

  //val homeDog: Home[Dog] = Home[Animal]()
  //val homeCat: Home[Cat] = Home[Animal]()

  //paintHome(homeDog)
  //paintHome(homeCat)


  def paintHome(h: Home[Animal]): Unit ={
    println("executed")

  }
}
