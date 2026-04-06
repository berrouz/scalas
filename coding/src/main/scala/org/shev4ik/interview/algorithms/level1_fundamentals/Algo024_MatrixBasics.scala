package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo024_MatrixBasics {

  // TODO: Transpose a matrix (swap rows and columns)
  // Example: [[1,2,3],[4,5,6],[7,8,9]] => [[1,4,7],[2,5,8],[3,6,9]]
  def transpose(matrix: Array[Array[Int]]): Array[Array[Int]] = ???

  // TODO: Rotate a square matrix 90 degrees clockwise
  // Example: [[1,2,3],[4,5,6],[7,8,9]] => [[7,4,1],[8,5,2],[9,6,3]]
  def rotate90(matrix: Array[Array[Int]]): Array[Array[Int]] = ???

  // TODO: Return elements in spiral order
  // Example: [[1,2,3],[4,5,6],[7,8,9]] => List(1,2,3,6,9,8,7,4,5)
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = ???

  // TODO: Set entire row and column to zero if an element is 0
  // Modify in place
  // Example: [[1,1,1],[1,0,1],[1,1,1]] => [[1,0,1],[0,0,0],[1,0,1]]
  def setZeroes(matrix: Array[Array[Int]]): Unit = ???

  // TODO: Search for target in a matrix where rows are sorted and
  // first element of each row > last element of previous row
  // Return true if found
  def searchInMatrix(matrix: Array[Array[Int]], target: Int): Boolean = ???

  // TODO: Return diagonal traversal of a matrix
  // Example: [[1,2,3],[4,5,6],[7,8,9]] => List(1,2,4,7,5,3,6,8,9) (not standard — just traverse diagonals)
  def diagonalTraverse(matrix: Array[Array[Int]]): List[Int] = ???

  // TODO: Reshape a matrix to given dimensions r x c
  // If reshape is not possible, return the original matrix
  // Example: [[1,2],[3,4]], r=1, c=4 => [[1,2,3,4]]
  def reshapeMatrix(matrix: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = ???

  // TODO: Compute the next state of Conway's Game of Life
  // Rules: live cell with 2-3 neighbors survives, dead cell with exactly 3 neighbors becomes live
  // 1 = live, 0 = dead. Modify in place (all cells update simultaneously)
  def gameOfLife(board: Array[Array[Int]]): Unit = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: transpose
    val t = transpose(Array(Array(1,2,3), Array(4,5,6), Array(7,8,9)))
    assert(t.map(_.toSeq).toSeq == Seq(Seq(1,4,7), Seq(2,5,8), Seq(3,6,9)))
    println("Exercise 1 passed: transpose")

    // Exercise 2: rotate90
    val r = rotate90(Array(Array(1,2,3), Array(4,5,6), Array(7,8,9)))
    assert(r.map(_.toSeq).toSeq == Seq(Seq(7,4,1), Seq(8,5,2), Seq(9,6,3)))
    println("Exercise 2 passed: rotate90")

    // Exercise 3: spiralOrder
    assert(spiralOrder(Array(Array(1,2,3), Array(4,5,6), Array(7,8,9))) == List(1,2,3,6,9,8,7,4,5))
    println("Exercise 3 passed: spiralOrder")

    // Exercise 4: setZeroes
    val m4 = Array(Array(1,1,1), Array(1,0,1), Array(1,1,1))
    setZeroes(m4)
    assert(m4.map(_.toSeq).toSeq == Seq(Seq(1,0,1), Seq(0,0,0), Seq(1,0,1)))
    println("Exercise 4 passed: setZeroes")

    // Exercise 5: searchInMatrix
    val m5 = Array(Array(1,3,5,7), Array(10,11,16,20), Array(23,30,34,60))
    assert(searchInMatrix(m5, 3) == true)
    assert(searchInMatrix(m5, 13) == false)
    println("Exercise 5 passed: searchInMatrix")

    // Exercise 6: diagonalTraverse
    val dt = diagonalTraverse(Array(Array(1,2,3), Array(4,5,6), Array(7,8,9)))
    assert(dt == List(1, 2, 4, 7, 5, 3, 6, 8, 9))
    println("Exercise 6 passed: diagonalTraverse")

    // Exercise 7: reshapeMatrix
    val rm = reshapeMatrix(Array(Array(1,2), Array(3,4)), 1, 4)
    assert(rm.map(_.toSeq).toSeq == Seq(Seq(1,2,3,4)))
    val rm2 = reshapeMatrix(Array(Array(1,2), Array(3,4)), 2, 4)
    assert(rm2.map(_.toSeq).toSeq == Seq(Seq(1,2), Seq(3,4))) // impossible, return original
    println("Exercise 7 passed: reshapeMatrix")

    // Exercise 8: gameOfLife
    val gol = Array(Array(0,1,0), Array(0,0,1), Array(1,1,1), Array(0,0,0))
    gameOfLife(gol)
    assert(gol.map(_.toSeq).toSeq == Seq(Seq(0,0,0), Seq(1,0,1), Seq(0,1,1), Seq(0,1,0)))
    println("Exercise 8 passed: gameOfLife")

    println("All Algo024_MatrixBasics exercises passed!")
  }
}
