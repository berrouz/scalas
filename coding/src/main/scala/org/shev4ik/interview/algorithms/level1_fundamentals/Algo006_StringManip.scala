package org.shev4ik.interview.algorithms.level1_fundamentals

import scala.annotation.tailrec

object Algo006_StringManip {

  // TODO: Count how many times a substring appears in a string (non-overlapping)
  // Example: "abcabcabc", sub="abc" => 3
  def substringCount(s: String, sub: String): Int = {
    @tailrec
    def inner(str: String, count: Int): Int = {
      if (str.contains(sub)){
        inner(str.replaceFirst(sub, ""), count +1)
      } else
        count
    }
    inner(s, 0)
  }

  // TODO: Replace all occurrences of oldChar with newChar in the string
  // Example: "hello world", old='o', new='0' => "hell0 w0rld"
  def replaceChars(s: String, oldChar: Char, newChar: Char): String = {
    s.replaceAll(oldChar.toString, newChar.toString)
  }

  // TODO: Convert string to zigzag pattern with numRows rows, then read line by line
  // Example: "PAYPALISHIRING", numRows=3 =>
  //   P   A   H   N
  //   A P L S I I G
  //   Y   I   R
  // Result: "PAHNAPLSIIGYIR"
  def zigzagString(s: String, numRows: Int): String = {
    ???
  }

  // TODO: Reverse the order of words in a string
  // Example: "  hello world  " => "world hello"
  def reverseWords(s: String): String = {
    s.trim.split("\\s+").reverse.mkString(" ")
  }

  // TODO: Multiply two non-negative integers represented as strings
  // Do not use BigInt or built-in multiplication for the core logic
  // Example: "123", "456" => "56088"
  def stringMultiply(num1: String, num2: String): String = {
    ???
  }

  // TODO: Add two binary strings and return the result as a binary string
  // Example: "1010", "1011" => "10101"
  def addBinaryStrings(a: String, b: String): String = ???

  // TODO: Check if a string represents a valid integer or decimal number
  // Valid: "123", "-45", "3.14", "-.5", "+.8"
  // Invalid: "abc", "12.3.4", ".", ""
  def validNumberCheck(s: String): Boolean = ???

  // TODO: Convert a Roman numeral string to an integer
  // I=1, V=5, X=10, L=50, C=100, D=500, M=1000
  // Example: "MCMXCIV" => 1994
  def romanToInteger(s: String): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: substringCount
    assert(substringCount("abcabcabc", "abc") == 3)
    assert(substringCount("aaaa", "aa") == 2)
    assert(substringCount("hello", "xyz") == 0)
    println("Exercise 1 passed: substringCount")

    // Exercise 2: replaceChars
    assert(replaceChars("hello world", 'o', '0') == "hell0 w0rld")
    assert(replaceChars("aaa", 'a', 'b') == "bbb")
    println("Exercise 2 passed: replaceChars")

    // Exercise 4: reverseWords
    assert(reverseWords("  hello world  ") == "world hello")
    assert(reverseWords("the sky is blue") == "blue is sky the")
    println("Exercise 4 passed: reverseWords")


    // Exercise 3: zigzagString
    assert(zigzagString("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    assert(zigzagString("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    assert(zigzagString("A", 1) == "A")
    println("Exercise 3 passed: zigzagString")

    // Exercise 5: stringMultiply
    assert(stringMultiply("123", "456") == "56088")
    assert(stringMultiply("0", "12345") == "0")
    println("Exercise 5 passed: stringMultiply")

    // Exercise 6: addBinaryStrings
    assert(addBinaryStrings("1010", "1011") == "10101")
    assert(addBinaryStrings("0", "0") == "0")
    println("Exercise 6 passed: addBinaryStrings")

    // Exercise 7: validNumberCheck
    assert(validNumberCheck("123") == true)
    assert(validNumberCheck("-45") == true)
    assert(validNumberCheck("3.14") == true)
    assert(validNumberCheck("abc") == false)
    assert(validNumberCheck("12.3.4") == false)
    assert(validNumberCheck(".") == false)
    println("Exercise 7 passed: validNumberCheck")

    // Exercise 8: romanToInteger
    assert(romanToInteger("III") == 3)
    assert(romanToInteger("LVIII") == 58)
    assert(romanToInteger("MCMXCIV") == 1994)
    println("Exercise 8 passed: romanToInteger")

    println("All Algo006_StringManip exercises passed!")
  }
}
