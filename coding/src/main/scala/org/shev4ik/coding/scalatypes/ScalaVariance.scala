package org.shev4ik.coding.scalatypes

object ScalaVariance extends App {

  val a: List[AnyRef] = List("a", "b")
  val b: List[AnyVal] = List(1, 2)

  trait Parent
  trait Child      extends Parent
  trait ChildChild extends Child

  val f: Function1[Child, Child] = (v1: Child) => v1.asInstanceOf[Child]

  case class ContainerPlus[A](value: A)
}
