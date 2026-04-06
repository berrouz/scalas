package org.shev4ik.algorithms.leetcode_classic

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Pattern: Stack
 * Time: O(n)
 * Space: O(n)
 */
object L020_ValidParentheses {

  def isValid(s: String): Boolean = {
    // TODO: Implement using Stack
    // Hint: Push opening brackets, pop and compare for closing brackets
    ???
  }

  // Functional solution with foldLeft
  def isValidFunctional(s: String): Boolean = {
    // TODO: Implement using foldLeft with List as stack
    ???
  }

  def main(args: Array[String]): Unit = {
    println(isValid("()"))      // Expected: true
    println(isValid("()[]{}"))  // Expected: true
    println(isValid("(]"))      // Expected: false
    println(isValid("([)]"))    // Expected: false
    println(isValid("{[]}"))    // Expected: true
  }
}
