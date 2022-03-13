package org.shev4ik.algorithms.graphs

object BreadthFirstSearch extends App {

  val map = Map(
    'a' -> List('b','c'),
    'b' -> List('d'),
    'c' -> List('e'),
    'd' -> List('f'),
    'e' -> List.empty,
    'f' -> List.empty
  )
  printer(List('a')) // abcdef // acdedf
  def printer(chars: List[Char]): Unit = {
    if (chars.nonEmpty) {
      chars.foreach(print)
      for (c <- chars){
        printer(map(c))
      }
    }
  }
}
