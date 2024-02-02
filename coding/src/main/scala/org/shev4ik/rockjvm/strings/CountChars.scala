package org.shev4ik.rockjvm.strings

import scala.annotation.tailrec

object CountChars extends App {

  def countChars(s: String): Map[Char, Int] = {
    s.toCharArray.groupBy(identity).map { case (c, s) =>
      (c, s.length)
    }
  }

  def countCharsTailrec(s: String): Map[Char, Int] = {
    @tailrec
    def loop(chars: List[Char], acc: Map[Char, Int]): Map[Char, Int] = {
      chars match {
        case Nil    => acc
        case h :: t => loop(t, acc + ((h, acc.getOrElse(h, 0) + 1)))
      }
    }
    loop(s.toCharArray.toList, Map.empty)
  }

  println(countChars("Monaco"))
  println(countCharsTailrec("Monaco"))
  println(checkAnagrams("Monaco", "Moanco"))

  def checkAnagrams(s: String, f: String): Boolean = {
    countCharsTailrec(s) == countCharsTailrec(f)
  }
}

object ParenthesisProblem extends App {
  def hasValidParentheses(string: String): Boolean = {
    def loop(t: List[Char], stack: List[Char]): Boolean = {
      (t, stack) match {
        case ('(' :: tail, _)                    => loop(tail, ')' :: stack)
        case (h :: tail, stackHead :: stackTail) => h == stackHead && loop(tail, stackTail)
        case _                                   => t.isEmpty && stack.isEmpty
      }
    }
    loop(string.toList, Nil)
  }

  println(hasValidParentheses("()"))
  println(hasValidParentheses("("))
  println(hasValidParentheses("(()))"))
}
