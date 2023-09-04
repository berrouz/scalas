package org.shev4ik.pattterns

object Solution {
  def letterCombinations(digits: String): List[String] = {
    val map = Map(
      '2' -> Seq("a", "b", "c"),
      '3' -> Seq("d", "e", "f"),
      '4' -> Seq("g", "h", "i"),
      '5' -> Seq("j", "k", "l"),
      '6' -> Seq("m", "n", "o"),
      '7' -> Seq("p", "q", "r", "s"),
      '8' -> Seq("t", "u", "v"),
      '9' -> Seq("w", "x", "y", "z")
    )

    def combinations(result: List[String], strs: List[Char], curr: String): List[String] = {
      strs match {
        case Nil => result :+ curr
        case (h :: tail) =>
          map(h).foldLeft(List.empty[String]) { case (res, c) =>
            res ++ combinations(result, tail, curr + c)
          }
      }
    }
    null
  }

}
