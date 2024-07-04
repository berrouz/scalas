package org.shev4ik.algorithms.graphs

object BreadthFirstSearch extends App {

  val map = Map(
    'a' -> List('c', 'b'),
    'b' -> List('d'),
    'c' -> List('e'),
    'd' -> List('f'),
    'e' -> List.empty,
    'f' -> List.empty
  )
  bfs('a') // abcdef // acdedf
  def bfs(char: Char): Unit = {
    val queue = scala.collection.mutable.Queue[Char](char)
    while (queue.nonEmpty) {
      val elem = queue.dequeue()
      println(elem)
      for (c <- map(elem)) {
        queue.enqueue(c)
      }
    }
  }
}
