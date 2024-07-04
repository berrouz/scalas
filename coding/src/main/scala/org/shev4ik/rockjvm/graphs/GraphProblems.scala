package org.shev4ik.rockjvm.graphs

import scala.annotation.tailrec

object GraphProblems extends App {

  type Graph[T] = Map[T, Set[T]]

  val socialNetwork: Graph[String] = Map(
    "Alice"   -> Set("Bob", "David"),
    "Bob"     -> Set("Alice"),
    "Charlie" -> Set("David"),
    "David"   -> Set("Bob", "Mary"),
    "Mary"    -> Set("Bob", "Charlie")
  )

  def outDegree[T](graph: Graph[T], node: T): Int = graph.getOrElse(node, Set.empty[T]).size

  def inDegree[T](graph: Graph[T], node: T): Int = graph.values.count(_.contains(node))

  def isPath[T](graph: Graph[T], start: T, end: T): Boolean = {
    @tailrec
    def loop(neighbours: List[T], considered: Set[T]): Boolean = {
      neighbours.nonEmpty && {
        val node = neighbours.head
        (node == end) || {
          if (considered.contains(node))
            loop(neighbours.tail, considered) // go to next if the loop
          else
            loop(neighbours.tail ++ graph(node), considered + node)
        }
      }
    }
    loop(List(start), Set.empty)
  }


  def findPath[T](graph: Graph[T], start: T, end: T): List[T] = {
    @tailrec
    def loop(neighbours: List[(T, List[T])], considered: Set[T]): List[T] = {
      if (neighbours.isEmpty){
        Nil
      } else {
        val (node, path) = neighbours.head
        if (node == end) {
          path.reverse
        } else {
          if (considered.contains(node))
            loop(neighbours.tail, considered) // go to next if the loop
          else
            loop(neighbours.tail ++ graph(node).map{ each => (each, each::path)}, considered + node)
        }
      }
    }
    loop(List((start, List(start))), Set.empty)
  }

  //println("Hello" == "Hello")
  //println(isPath(socialNetwork, "Alice", "Charlie"))
  println(findPath(socialNetwork, "Alice", "Alice"))
}
