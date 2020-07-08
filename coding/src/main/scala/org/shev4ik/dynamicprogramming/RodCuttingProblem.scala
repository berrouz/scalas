package org.shev4ik.dynamicprogramming

import scala.util.Random

object RodCuttingProblem extends App {

  val solved = scala.collection.mutable.Map.empty[Int, Int]

  val cost = 1.to(40).map(i => i -> Random.nextInt(40)).toMap

  solved.put(0,0)
  def rodCut(n: Int): Int = {
      var max = Int.MinValue
      1.to(n).foreach(i => {
        1.to(i).foreach(j => {
        val res = cost(j) + solved(i - j)
        solved.put(j, res)
        max = Math.max(max, res)
      })
      })
      max
  }

  println(rodCut(40))
}
