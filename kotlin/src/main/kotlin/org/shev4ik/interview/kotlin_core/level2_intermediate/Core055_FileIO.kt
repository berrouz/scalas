package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * File I/O Concepts
 */
object Core055_FileIO {

    // Exercise 1: readTextConcept
    // TODO: Simulate: given a string content = "hello\nworld", split by lines and return first line.
    // TODO: (No actual file I/O needed, simulate the pattern.)
    fun exercise1_readTextConcept(): String = TODO()

    // Exercise 2: useLinesPattern
    // TODO: Simulate useLines: given content = "line1\nline2\nline3", count lines. Return count.
    fun exercise2_useLinesPattern(): Int = TODO()

    // Exercise 3: writeTextConcept
    // TODO: Simulate: create a list of strings, join with newline. Return true if result contains newline.
    fun exercise3_writeTextConcept(): Boolean = TODO()

    // Exercise 4: pathOperations
    // TODO: Given path = "/Users/test/file.txt", extract filename using substringAfterLast("/").
    // TODO: Return result.
    fun exercise4_pathOperations(): String = TODO()

    // Exercise 5: extensionExtract
    // TODO: Given filename = "report.pdf", extract extension using substringAfterLast(".").
    // TODO: Return result.
    fun exercise5_extensionExtract(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readTextConcept() == "hello") { "Exercise 1 failed" }
        assert(exercise2_useLinesPattern() == 3) { "Exercise 2 failed" }
        assert(exercise3_writeTextConcept() == true) { "Exercise 3 failed" }
        assert(exercise4_pathOperations() == "file.txt") { "Exercise 4 failed" }
        assert(exercise5_extensionExtract() == "pdf") { "Exercise 5 failed" }
        println("All Core055_FileIO exercises passed!")
    }
}
