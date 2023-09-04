package org.shev4ik.rockjvm.lists.numbers

object ParseInteger extends App {

  def parseInteger(string: String): Int = {
    def tailRec(digits: List[String], acc: Int): Int = {
      digits match {
        case " " :: tail => tailRec(tail, acc)
        case "-" :: tail => -tailRec(tail, acc)
        case Nil         => acc
        case d :: tail =>
          if (acc * 10 < 0) 0
          else
            tailRec(tail, acc * 10 + d.toInt)
      }
    }
    if (string.isEmpty) 0
    else
      tailRec(string.split("").toList, 0)
  }
  println(parseInteger("10232423233"))
}
