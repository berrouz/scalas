package org.shev4ik.coding.arrays

object CheckIfExist extends App {
  def checkIfExist(arr: Array[Int]): Boolean = {
    val set = collection.mutable.Set[Int]()
    arr.exists(i => set.contains(i))
  }
}
