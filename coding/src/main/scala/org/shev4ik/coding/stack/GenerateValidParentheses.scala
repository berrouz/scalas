package org.shev4ik.coding.stack


object GenerateValidParentheses {
  def main(args: Array[String]): Unit = {
    assert(generate(1, "", Nil, 0, 0) == List("()"));
  }

  def generate(n: Int, curr: String, result: List[String], open: Int, closed: Int): List[String] = {
    if (open == closed && closed == n){
      result :+ curr
    } else {
      val a = if (open > closed) generate(n, curr + ")", result, open, closed+1) else Nil
      val b = if (open < n) generate(n, curr + "(", result, open+1, closed) else Nil
      a ++ b
    }
  }
}
