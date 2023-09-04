package org.shev4ik.coding.catz

import scala.language.higherKinds

object CatzApplikative extends App {
  type A[T]

  type B[T] <: A[T]

}
