package org.shev4ik.interview.scala_core.level1_beginner

import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.{Try, Using}

object Core032_BasicIO {

  // Exercise 1: println and print
  // TODO: Create a function that builds a string using StringBuilder to simulate print output.
  //       Append "Hello" + " " + "World" + "\n" (simulating println).
  //       Return the resulting string.
  def exercise1_printSimulation: String = ???

  // Exercise 2: String formatting for output
  // TODO: Format a string for display: given name="Alice" and score=95.5,
  //       return f"$name scored $score%.1f out of 100"
  //       (formatted with 1 decimal place)
  def exercise2_formatting(name: String, score: Double): String = ???

  // Exercise 3: Source.fromFile (reading a file)
  // TODO: Write a function that reads a file and returns its content as a List[String].
  //       Use Source.fromFile(path).getLines().toList.
  //       Wrap in Try to handle missing files gracefully. Return the Try result.
  def exercise3_sourceFromFile(path: String): Try[List[String]] = ???

  // Exercise 4: Writing to a file
  // TODO: Write a function that writes lines to a file.
  //       Use new PrintWriter(path) and writer.println(line) for each line.
  //       Close the writer when done. Return true if successful.
  def exercise4_writeToFile(path: String, lines: List[String]): Boolean = ???

  // Exercise 5: Using block pattern (resource management)
  // TODO: Use scala.util.Using to safely read a file (auto-close):
  //       Using(Source.fromFile(path)) { source => source.getLines().toList }
  //       Return the Try result.
  def exercise5_usingBlock(path: String): Try[List[String]] = ???

  // Exercise 6: Read and write round-trip
  // TODO: Write lines to a temp file, then read them back and verify.
  //       1. Create a temp file using File.createTempFile("test", ".txt")
  //       2. Write List("line1", "line2", "line3") to it
  //       3. Read it back
  //       4. Return the read lines
  def exercise6_roundTrip: List[String] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_printSimulation == "Hello World\n", "Exercise 1 failed")

    assert(exercise2_formatting("Alice", 95.5) == "Alice scored 95.5 out of 100", "Exercise 2 failed")

    // Exercise 3: test with non-existent file
    assert(exercise3_sourceFromFile("/nonexistent/file.txt").isFailure, "Exercise 3 failed: missing file")

    // Exercise 4 & 5: write then read
    val tmpFile = File.createTempFile("core032_test", ".txt")
    tmpFile.deleteOnExit()
    val testLines = List("hello", "world", "scala")

    assert(exercise4_writeToFile(tmpFile.getAbsolutePath, testLines), "Exercise 4 failed")

    val readResult = exercise5_usingBlock(tmpFile.getAbsolutePath)
    assert(readResult.isSuccess, "Exercise 5 failed: should succeed")
    assert(readResult.get == testLines, "Exercise 5 failed: content mismatch")

    val roundTrip = exercise6_roundTrip
    assert(roundTrip == List("line1", "line2", "line3"), "Exercise 6 failed")

    println("All Core032_BasicIO exercises passed!")
  }
}
