package org.shev4ik.interview.algorithms.level1_fundamentals

import scala.collection.mutable.ListBuffer

object Algo032_Misc {

  // TODO: FizzBuzz — for numbers 1 to n:
  // Return "FizzBuzz" if divisible by both 3 and 5
  // Return "Fizz" if divisible by 3
  // Return "Buzz" if divisible by 5
  // Return the number as a string otherwise
  // Example: n=15 => List("1","2","Fizz","4","Buzz",...,"FizzBuzz")
  def fizzBuzz(n: Int): List[String] = {
    val result = ListBuffer[Int]()
    for(i <- 1.to(n)){
      val resp = n match {
        case _ if n%3 == 0 && n%5==0 => "Fi"
      }
      result :+ resp
    }
    List()

  }

  // TODO: Generate the first numRows of Pascal's triangle
  // Example: numRows=5 => List(List(1), List(1,1), List(1,2,1), List(1,3,3,1), List(1,4,6,4,1))
  def pascalsTriangle(numRows: Int): List[List[Int]] = ???

  // TODO: Check if a number is a valid perfect square without using sqrt
  // Example: 16 => true, 14 => false
  def validPerfectSquare(num: Int): Boolean = ???

  // TODO: Check if a number is an ugly number (only prime factors are 2, 3, 5)
  // 1 is considered ugly. Negative numbers and 0 are not ugly.
  // Example: 6 => true, 8 => true, 14 => false
  def uglyNumber(n: Int): Boolean = ???

  // TODO: Check if a number is a power of three
  // Example: 27 => true, 0 => false, 9 => true, 45 => false
  def powerOfThree(n: Int): Boolean = ???

  // TODO: Convert an Excel column title to its corresponding column number
  // Example: "A" => 1, "AB" => 28, "ZY" => 701
  def excelColumnNumber(columnTitle: String): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: fizzBuzz
    val fb = fizzBuzz(15)
    assert(fb.length == 15)
    assert(fb(0) == "1")
    assert(fb(2) == "Fizz")
    assert(fb(4) == "Buzz")
    assert(fb(14) == "FizzBuzz")
    assert(fb(8) == "Fizz")
    println("Exercise 1 passed: fizzBuzz")

    // Exercise 2: pascalsTriangle
    val pt = pascalsTriangle(5)
    assert(pt == List(List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1), List(1, 4, 6, 4, 1)))
    assert(pascalsTriangle(1) == List(List(1)))
    println("Exercise 2 passed: pascalsTriangle")

    // Exercise 3: validPerfectSquare
    assert(validPerfectSquare(16) == true)
    assert(validPerfectSquare(14) == false)
    assert(validPerfectSquare(1) == true)
    assert(validPerfectSquare(0) == false)
    println("Exercise 3 passed: validPerfectSquare")

    // Exercise 4: uglyNumber
    assert(uglyNumber(6) == true)
    assert(uglyNumber(8) == true)
    assert(uglyNumber(14) == false)
    assert(uglyNumber(1) == true)
    assert(uglyNumber(0) == false)
    println("Exercise 4 passed: uglyNumber")

    // Exercise 5: powerOfThree
    assert(powerOfThree(27) == true)
    assert(powerOfThree(0) == false)
    assert(powerOfThree(9) == true)
    assert(powerOfThree(45) == false)
    assert(powerOfThree(1) == true)
    println("Exercise 5 passed: powerOfThree")

    // Exercise 6: excelColumnNumber
    assert(excelColumnNumber("A") == 1)
    assert(excelColumnNumber("AB") == 28)
    assert(excelColumnNumber("ZY") == 701)
    assert(excelColumnNumber("Z") == 26)
    println("Exercise 6 passed: excelColumnNumber")

    println("All Algo032_Misc exercises passed!")
  }
}
