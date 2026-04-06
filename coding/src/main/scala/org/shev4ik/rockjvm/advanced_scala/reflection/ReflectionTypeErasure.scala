package org.shev4ik.rockjvm.advanced_scala.reflection

import org.shev4ik.rockjvm.advanced_scala.reflection.ReflectionMain.Person

import scala.reflect.runtime.universe.typeTag

object ReflectionTypeErasure extends App {


  // type erasure

  // 1. differentiate types at runtime

  val numbers = List(1,2,3)

  numbers match {
    case listOfStrings: List[String] => println("list of string")
    case listOfInts: List[Int] => println("list of ints")
  }

  /* 2. limitations on overloads

  def processList(list: List[Int]): Int = 43
  def processList(list: List[String]): Int = 43

   */

  val tt = typeTag[Person]

  println(tt.tpe)

  //
}
