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
  dfs('a')
  def dfs(char: Char): Unit = {
    val stack = scala.collection.mutable.Stack[Char](char)
    while (stack.nonEmpty) {
      val elem = stack.pop()
      println(elem)
      for (c <- map(elem)) {
        stack.push(c)
      }
    }
  }
}
