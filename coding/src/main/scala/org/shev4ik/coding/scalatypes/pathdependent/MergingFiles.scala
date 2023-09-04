package org.shev4ik.coding.scalatypes.pathdependent

import java.io.File

import scala.collection.immutable
import scala.language.higherKinds

object MergingFiles extends App {

  sealed trait MergeStrategy {
    type T

    def body(s: T): String
  }
  object MergeStrategy {
    case object Single extends MergeStrategy {
      type T = String
      override def body(s: T): String = s
    }
    case object Multiple extends MergeStrategy {
      type T = Int
      override def body(s: T): String = s.toString
    }
  }

  def merge[E, O[_], T](files: O[T], mergeStrategy: MergeStrategy)(m: mergeStrategy.T): String = {
    mergeStrategy.body(m)
  }

  val list: immutable.List[Int] = List(1, 2)

  merge(list, MergeStrategy.Multiple)(1)
  merge(list, MergeStrategy.Single)("1")

}
