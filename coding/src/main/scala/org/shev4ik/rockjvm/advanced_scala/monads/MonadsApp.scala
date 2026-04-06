package org.shev4ik.rockjvm.advanced_scala.monads

object MonadsApp extends App {

  def listStory(): Unit = {
    val aList = List(1,2,3)
    val listMultiply = for {
      x <- List(1,2,3)
      y <- List(4,5,6)
      if (x != y)
    } yield x*y

    List(1,2,3).flatMap(x => List(4,5,6).map(y => (x,y))).withFilter { case (x: Int,y:Int) => x!=y }


    val f = (x: Int) => List(x, x + 1)
    val g = (x: Int) => List(x, 2*x)

    val pure = (x: Int) => List(x)
    // left identity
    val LeftIdentity = pure(42).flatMap(f) == f(42)

    // right identity
    val RightIdentity = aList.flatMap(pure) == aList

    // associativity

    val Associativity = aList.flatMap(f).flatMap(g)
  }







}
