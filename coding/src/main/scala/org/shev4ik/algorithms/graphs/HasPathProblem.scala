package org.shev4ik.algorithms.graphs

object HasPathProblem extends App {

  val graph: Map[Char, List[Char]] = Map(
    'a' -> List('b', 'c'),
    'b' -> List('d'),
    'c' -> List('e'),
    'd' -> List('f'),
    'e' -> List.empty,
    'f' -> List.empty
  )

  def hasPath(start: Char, end: Char): Boolean = {
    var curr = start
    val q = scala.collection.mutable.Queue[Char](curr)
    while(q.nonEmpty){
      curr = q.dequeue()
      if (curr == end) return true
      for (elem <- graph(curr)){
        q.enqueue(elem)
      }
    }
    false
  }

  println(hasPath('a', 'd'))
}
