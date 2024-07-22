package org.shev4ik.coding.stack


import org.scalatest.MustMatchers.convertToAnyMustWrapper
import org.scalatest.WordSpec

import scala.annotation.tailrec

object ValidParentheses {
  def isValid(s: String): Boolean = {
    @tailrec
    def inner(str: List[Char], stack: List[Char]): Boolean = {
      (str, stack) match {
        case ('(' :: tail, _) => inner(tail, ')' :: stack)
        case ('{' :: tail, _) => inner(tail, '}' :: stack)
        case ('[' :: tail, _) => inner(tail, ']' :: stack)
        case (head :: tail, sHead :: sTail) =>
          sHead == head && inner(tail, sTail)
        case _ => str.isEmpty && stack.isEmpty
      }
    }

    inner(s.toList, Nil)
  }
}

class TestsSpec extends WordSpec {
  "tests" should {
    "valid" in {
      ValidParentheses.isValid("()") mustBe true
      ValidParentheses.isValid("(") mustBe false
      ValidParentheses.isValid("]") mustBe false
      ValidParentheses.isValid("(]") mustBe false
      ValidParentheses.isValid("()[]{}") mustBe true
      ValidParentheses.isValid("(])[") mustBe false
      ValidParentheses.isValid("{[]}") mustBe true
      ValidParentheses.isValid("(])") mustBe false
      ValidParentheses.isValid("(})") mustBe false
      ValidParentheses.isValid("())") mustBe false
    }
  }
}
