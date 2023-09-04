package org.shev4ik.advanced.scala2

object OrganizeImplicits extends App {

  implicit val reverse: Ordering[Int] = Ordering.fromLessThan(_ > _)
  println(List(1, 2, 3, 4, 4).sorted)
}
