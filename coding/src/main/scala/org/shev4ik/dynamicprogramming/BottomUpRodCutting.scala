package org.shev4ik.dynamicprogramming

object BottomUpRodCutting extends App {

  val costs: Map[Int, Int] = Map(1 -> 4, 2 -> 6, 3 -> 5, 4 -> 10)

  def rod(n: Int, res: Seq[Int]): (Int, Seq[Int]) = {
    if (n == 0) return (0, Nil)
    var sum = Int.MinValue

    var tuple: (Int, Seq[Int]) = null
    1.to(n)
      .foreach(i => {
        tuple = rod(n - i, res :+ n)
        sum = Math.max(sum, costs(i) + tuple._1)

      })
    (sum, tuple._2)
  }

  println(rod(4, Nil))

  // def same(a: Any, b: a.type) = ???
}
