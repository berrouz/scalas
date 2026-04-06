package org.shev4ik.algorithms.leetcode_classic

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class RomanToInteger12LeetcodeApp extends AnyFlatSpec with Matchers {

  val values: Map[Char, Int] = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

  private def romanToInt(s: String): Int = {
    var result = 0
    0.until(s.length-1).foreach { i =>
      val curr = values(s.charAt(i))
      val next = values(s.charAt(i + 1))
      if (curr < next)
        result-= values(s.charAt(i))
      else
        result+= values(s.charAt(i))
    }
    result + values(s.last)
  }

  "method" should "work" in {
    romanToInt("III") mustBe 3
    romanToInt("II") mustBe 2
    romanToInt("IV") mustBe 4
    romanToInt("XL") mustBe 40
    romanToInt("XC") mustBe 90
  }


  def transformRomans(s: String): Int = {
    val (_, sum) = s.foldLeft((0,0)){ case ((prev, acc), ch) =>
      val curr = values(ch)
      if (curr > prev){
        (curr, acc + curr - 2*prev)
      } else {
        (curr, acc + curr)
      }
    }
    sum
  }

  "Roman to Int" should "be transformed" in {
    transformRomans("X") mustBe 10
  }
}
