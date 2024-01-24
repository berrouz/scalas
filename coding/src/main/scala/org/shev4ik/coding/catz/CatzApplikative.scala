package org.shev4ik.coding.catz

import scala.language.higherKinds

object CatzApplikative extends App {

  type Animal

  type Cat <: Animal

  implicitly[List[Cat] <:< List[Animal]]
}
