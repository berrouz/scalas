package org.shev4ik.algorithms.graphs

object DepthFirstSearch extends App {

  val map = Map(
    'a' -> List('b', 'c'),
    'b' -> List('d'),
    'c' -> List('e'),
    'd' -> List('f'),
    'e' -> List.empty,
    'f' -> List.empty
  )
  printer(List('a'))
  def printer(chars: List[Char]): Unit = {
    if (chars.nonEmpty) {
      print(chars.head)
      for (c <- map(chars.head)) {
        printer(List(c))
      }
    }
  }
}
