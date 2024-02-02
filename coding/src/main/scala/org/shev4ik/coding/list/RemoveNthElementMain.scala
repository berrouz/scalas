package org.shev4ik.coding.list

object RemoveNthElementMain extends App {

  def removeAt(list: List[Int], index: Int): List[Int] = {
    def removeNthElement(
        list: List[Int],
        counter: Int,
        result: List[Int],
        elemInd: Int
    ): List[Int] = {
      if (elemInd == counter) {
        (list.tail.reverse ++ result).reverse
      } else {
        removeNthElement(list.tail, counter + 1, list.head :: result, elemInd)
      }
    }
    if (index < 0 || index > list.length - 1) {
      list
    } else
      removeNthElement(list, 0, Nil, index)
  }

  println(removeAt(1 :: 2 :: 3 :: Nil, 0))
  println(removeAt(1 :: 2 :: 3 :: Nil, 1))
  println(removeAt(1 :: 2 :: 3 :: Nil, 2))
  println(removeAt(1 :: 2 :: 3 :: Nil, 3))
}
