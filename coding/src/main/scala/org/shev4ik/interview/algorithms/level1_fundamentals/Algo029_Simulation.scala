package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo029_Simulation {

  // TODO: Generate an n x n matrix filled with elements 1 to n^2 in spiral order
  // Example: n=3 => [[1,2,3],[8,9,4],[7,6,5]]
  def spiralMatrixGeneration(n: Int): Array[Array[Int]] = ???

  // TODO: Simulate a robot on an infinite grid starting at (0,0) facing north
  // Commands: -2 = turn left, -1 = turn right, 1..9 = move forward that many steps
  // Obstacles is a set of (x,y) positions. Return max distance squared from origin.
  // Example: commands=Array(4,-1,3), obstacles=Set() => 25
  def simulateRobot(commands: Array[Int], obstacles: Set[(Int, Int)]): Int = ???

  // TODO: Compute the next state of Conway's Game of Life
  // 1 = live, 0 = dead
  // Live cell: survives with 2-3 neighbors, dies otherwise
  // Dead cell: becomes live with exactly 3 neighbors
  // Return new board (do not modify input)
  def gameOfLifeSimulation(board: Array[Array[Int]]): Array[Array[Int]] = ???

  // TODO: Given an array of words and a width, format text with full justification
  // Pad with spaces so each line is exactly `maxWidth` characters
  // Last line should be left-justified
  // Example: words=Array("This","is","an","example"), maxWidth=16
  //       => List("This    is    an", "example         ")
  def textJustification(words: Array[String], maxWidth: Int): List[String] = ???

  // TODO: Convert string to zigzag pattern with numRows rows, then read line by line
  // Example: "PAYPALISHIRING", numRows=3 => "PAHNAPLSIIGYIR"
  def zigzagConversion(s: String, numRows: Int): String = ???

  // TODO: Compress a character array in-place: consecutive duplicates become char+count
  // Single characters have no count. Return the new length.
  // Example: Array('a','a','b','b','c','c','c') => Array('a','2','b','2','c','3'), length=6
  def stringCompression(chars: Array[Char]): Int = ???

  // TODO: Generate the nth term of the "look and say" sequence
  // Start: "1". Each term describes the previous.
  // 1, 11, 21, 1211, 111221, ...
  // Example: n=4 => "1211"
  def lookAndSay(n: Int): String = ???

  // TODO: Find the next permutation in lexicographic order
  // If no next permutation exists (descending order), return the smallest (ascending)
  // Example: Array(1,2,3) => Array(1,3,2), Array(3,2,1) => Array(1,2,3)
  def nextPermutation(nums: Array[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: spiralMatrixGeneration
    val sm = spiralMatrixGeneration(3)
    assert(sm.map(_.toSeq).toSeq == Seq(Seq(1,2,3), Seq(8,9,4), Seq(7,6,5)))
    println("Exercise 1 passed: spiralMatrixGeneration")

    // Exercise 2: simulateRobot
    assert(simulateRobot(Array(4, -1, 3), Set()) == 25)
    assert(simulateRobot(Array(4, -1, 4, -2, 4), Set((2, 4))) == 65)
    println("Exercise 2 passed: simulateRobot")

    // Exercise 3: gameOfLifeSimulation
    val gol = gameOfLifeSimulation(Array(Array(0,1,0), Array(0,0,1), Array(1,1,1), Array(0,0,0)))
    assert(gol.map(_.toSeq).toSeq == Seq(Seq(0,0,0), Seq(1,0,1), Seq(0,1,1), Seq(0,1,0)))
    println("Exercise 3 passed: gameOfLifeSimulation")

    // Exercise 4: textJustification
    val tj = textJustification(Array("This","is","an","example","of","text","justification."), 16)
    assert(tj(0) == "This    is    an")
    assert(tj(1) == "example  of text")
    assert(tj(2) == "justification.  ")
    println("Exercise 4 passed: textJustification")

    // Exercise 5: zigzagConversion
    assert(zigzagConversion("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    assert(zigzagConversion("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    assert(zigzagConversion("A", 1) == "A")
    println("Exercise 5 passed: zigzagConversion")

    // Exercise 6: stringCompression
    val chars6 = Array('a','a','b','b','c','c','c')
    val len6 = stringCompression(chars6)
    assert(len6 == 6)
    assert(chars6.take(len6).toSeq == Seq('a','2','b','2','c','3'))
    println("Exercise 6 passed: stringCompression")

    // Exercise 7: lookAndSay
    assert(lookAndSay(1) == "1")
    assert(lookAndSay(2) == "11")
    assert(lookAndSay(3) == "21")
    assert(lookAndSay(4) == "1211")
    assert(lookAndSay(5) == "111221")
    println("Exercise 7 passed: lookAndSay")

    // Exercise 8: nextPermutation
    assert(nextPermutation(Array(1, 2, 3)).toSeq == Seq(1, 3, 2))
    assert(nextPermutation(Array(3, 2, 1)).toSeq == Seq(1, 2, 3))
    assert(nextPermutation(Array(1, 1, 5)).toSeq == Seq(1, 5, 1))
    println("Exercise 8 passed: nextPermutation")

    println("All Algo029_Simulation exercises passed!")
  }
}
