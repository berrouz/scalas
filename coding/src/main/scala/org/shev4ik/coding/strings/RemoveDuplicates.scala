package org.shev4ik.coding.strings

object RemoveDuplicates extends App {

  Some(removeDuplicatedChars("abcdaefghjlksaf")) foreach println

  def removeDuplicatedChars(s: String): String = {
    def inner(l: List[Char], r: List[Char], bit: Int): List[Char] = {
      l match {
        case h :: tail ⇒
          val m = 1 << h.toInt % 96
          inner(tail, if ((bit & m) == m) r else r :+ h, bit | m)
        case Nil ⇒ r
      }
    }
    inner(s.toList, Nil, 0).mkString("")
  }
}
