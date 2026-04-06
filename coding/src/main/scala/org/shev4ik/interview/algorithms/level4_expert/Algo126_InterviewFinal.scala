package org.shev4ik.interview.algorithms.level4_expert

import scala.collection.mutable

/**
 * Interview Final - complex system design problems as coding exercises.
 *
 * Key concepts:
 * - Meeting scheduler with conflict detection
 * - File system design with directory operations
 * - Text editor with undo/redo
 * - Autocomplete, spreadsheet, task scheduler
 */
object Algo126_InterviewFinal {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Meeting scheduler
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a meeting scheduler that supports:
   *       - book(start, end, title): book a meeting, return true if no conflict
   *       - cancel(title): cancel a meeting by title
   *       - findFreeSlots(dayStart, dayEnd, duration): find all free slots
   *         of at least `duration` minutes
   *       Process a list of operations and return results.
   *
   * @param operations list of operations:
   *                   ("book", start, end, title) -> Boolean (success)
   *                   ("cancel", 0, 0, title) -> Boolean (found and cancelled)
   *                   ("free", dayStart, dayEnd, duration) -> List of (start, end)
   * @return list of results as strings
   */
  def meetingScheduler(operations: List[(String, Int, Int, String)]): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: File system design
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an in-memory file system supporting:
   *       - mkdir(path): create directory (and parent dirs)
   *       - addFile(path, content): create file with content
   *       - readFile(path): read file content
   *       - ls(path): list directory contents (sorted)
   *       - rm(path): remove file or directory
   *       Return results of read and ls operations.
   *
   * @param operations list of (operation, path, content)
   * @return list of results for "read" and "ls" operations
   */
  def fileSystem(operations: List[(String, String, String)]): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Text editor with undo/redo
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a text editor supporting:
   *       - insert(pos, text): insert text at position
   *       - delete(pos, length): delete `length` characters from pos
   *       - undo(): undo last operation
   *       - redo(): redo last undone operation
   *       - getText(): return current text
   *       Process operations and return getText results.
   *
   * @param operations list of operations:
   *                   ("insert", pos, text) / ("delete", pos, lengthStr)
   *                   ("undo", "", "") / ("redo", "", "") / ("get", "", "")
   * @return list of getText results
   */
  def textEditor(operations: List[(String, String, String)]): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Autocomplete system
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an autocomplete system.
   *       - Build a trie from a list of (sentence, frequency) pairs
   *       - For a given prefix, return top-k sentences by frequency
   *       - Support addSentence to add new sentences dynamically
   *       Return top-k suggestions for each query prefix.
   *
   * @param sentences initial (sentence, frequency) pairs
   * @param queries   list of prefix queries
   * @param k         max number of suggestions per query
   * @return list of suggestion lists, one per query
   */
  def autocomplete(sentences: List[(String, Int)], queries: List[String], k: Int): List[List[String]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Spreadsheet engine
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simple spreadsheet that supports:
   *       - setCellValue(cell, value): set a numeric value
   *       - setCellFormula(cell, formula): set formula like "=A1+B2"
   *       - getCellValue(cell): evaluate and return value
   *       - Detect circular references
   *       Cells are named like "A1", "B2", etc.
   *       Support +, -, * operators in formulas.
   *       Return evaluated values for requested cells.
   *
   * @param operations list of ("set", cell, valueOrFormula) or ("get", cell, "")
   * @return list of values for "get" operations (as strings, "ERROR" for circular refs)
   */
  def spreadsheet(operations: List[(String, String, String)]): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Task scheduler with dependencies
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a task scheduler with:
   *       - addTask(id, duration): add a task
   *       - addDependency(taskId, dependsOn): task depends on another
   *       - schedule(): return execution order (topological sort)
   *       - totalTime(): minimum completion time with unlimited parallelism
   *         (critical path length)
   *       Return (execution order, minimum completion time).
   *
   * @param tasks        list of (taskId, duration)
   * @param dependencies list of (taskId, dependsOnTaskId)
   * @return (valid execution order, minimum total time)
   */
  def taskScheduler(tasks: List[(String, Int)], dependencies: List[(String, String)]): (List[String], Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val schedResults = meetingScheduler(List(
      ("book", 900, 1000, "standup"),
      ("book", 930, 1030, "design"),  // conflict
      ("book", 1000, 1100, "review"),
      ("cancel", 0, 0, "standup"),
      ("free", 800, 1200, "60")       // find 60-min free slots
    ))
    assert(schedResults.head == "true", s"First booking should succeed")
    assert(schedResults(1) == "false", s"Second booking should fail (conflict)")
    println(s"Exercise 1 (Meeting scheduler) passed.")

    // Exercise 2
    val fsResults = fileSystem(List(
      ("mkdir", "/home/user", ""),
      ("addFile", "/home/user/hello.txt", "Hello World"),
      ("read", "/home/user/hello.txt", ""),
      ("ls", "/home", ""),
      ("mkdir", "/home/user/docs", ""),
      ("ls", "/home/user", "")
    ))
    assert(fsResults(0) == "Hello World", s"Expected 'Hello World', got '${fsResults(0)}'")
    assert(fsResults(1) == "user", s"Expected 'user', got '${fsResults(1)}'")
    println("Exercise 2 (File system) passed.")

    // Exercise 3
    val editorResults = textEditor(List(
      ("insert", "0", "Hello"),
      ("get", "", ""),
      ("insert", "5", " World"),
      ("get", "", ""),
      ("delete", "5", "6"),
      ("get", "", ""),
      ("undo", "", ""),
      ("get", "", "")
    ))
    assert(editorResults(0) == "Hello", s"Got '${editorResults(0)}'")
    assert(editorResults(1) == "Hello World", s"Got '${editorResults(1)}'")
    assert(editorResults(2) == "Hello", s"Got '${editorResults(2)}'")
    assert(editorResults(3) == "Hello World", s"Got '${editorResults(3)}'")
    println("Exercise 3 (Text editor) passed.")

    // Exercise 4
    val suggestions = autocomplete(
      List(("i love you", 5), ("island", 3), ("ironman", 2), ("i love leetcode", 2)),
      List("i ", "is", "ir", "xyz"),
      k = 2
    )
    assert(suggestions(0) == List("i love you", "i love leetcode"),
      s"Got ${suggestions(0)}")
    assert(suggestions(1) == List("island"), s"Got ${suggestions(1)}")
    assert(suggestions(3).isEmpty, s"Expected empty for 'xyz', got ${suggestions(3)}")
    println("Exercise 4 (Autocomplete) passed.")

    // Exercise 5
    val ssResults = spreadsheet(List(
      ("set", "A1", "5"),
      ("set", "B1", "3"),
      ("set", "C1", "=A1+B1"),
      ("get", "C1", ""),
      ("set", "A1", "10"),
      ("get", "C1", "")
    ))
    assert(ssResults(0) == "8", s"Expected 8 (5+3), got '${ssResults(0)}'")
    assert(ssResults(1) == "13", s"Expected 13 (10+3), got '${ssResults(1)}'")
    println("Exercise 5 (Spreadsheet) passed.")

    // Exercise 6
    val (order, totalTime) = taskScheduler(
      List(("A", 3), ("B", 2), ("C", 4), ("D", 1)),
      List(("B", "A"), ("C", "A"), ("D", "B"), ("D", "C"))
    )
    // A must come first, then B and C (parallel), then D
    assert(order.indexOf("A") < order.indexOf("B"), "A before B")
    assert(order.indexOf("A") < order.indexOf("C"), "A before C")
    assert(order.indexOf("B") < order.indexOf("D"), "B before D")
    assert(order.indexOf("C") < order.indexOf("D"), "C before D")
    // Critical path: A(3) -> C(4) -> D(1) = 8
    assert(totalTime == 8, s"Expected 8, got $totalTime")
    println("Exercise 6 (Task scheduler) passed.")

    println("All Algo126_InterviewFinal exercises passed!")
  }
}
