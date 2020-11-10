package org.shev4ik.coding.scalatypes.pathdependent

import java.io.File

import scala.collection.immutable
import scala.language.higherKinds

object MergingFiles extends App {
/*

  sealed trait MergeStrategy {
    type Output[_]
  }
  object MergeStrategy {
    case object Single extends MergeStrategy { type Output[A] = A }
    case object Multiple extends MergeStrategy { type Output[A] = List[A] }
    case object None extends MergeStrategy { type Output[_] = Unit }
  }


  def merge[E](files: List[E]): E = {
    files.head
  }
  def merge[E, O[_], T](files: List[E], mergeStrategy: MergeStrategy {type Output[A] = O[A]})(f: O[E] => T): T = {
    mergeStrategy match {
      case MergeStrategy.Single => f(merge(files))
      case MergeStrategy.Multiple => f(files)
      case MergeStrategy.None => f(())
    }
  }

  val list: immutable.List[Int] = List(1,2)

  merge(list, MergeStrategy.Single){ file: Int => 1}
  //merge(List(1,2), MergeStrategy.Multiple){ files => ???}*/

}
