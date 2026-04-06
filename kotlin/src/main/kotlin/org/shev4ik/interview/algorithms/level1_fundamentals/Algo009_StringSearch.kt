package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * String Search
 */
object Algo009_StringSearch {

    // Exercise 1: findSubstring
    // TODO: Find first index of "world" in "hello world". Return -1 if not found.
    fun exercise1_findSubstring(): Int = TODO()

    // Exercise 2: countSubstring
    // TODO: Count non-overlapping occurrences of "ab" in "ababab". Return count.
    fun exercise2_countSubstring(): Int = TODO()

    // Exercise 3: allUniqueChars
    // TODO: Check if "abcdef" has all unique characters.
    fun exercise3_allUniqueChars(): Boolean = TODO()

    // Exercise 4: longestCommonPrefix
    // TODO: Find longest common prefix of listOf("flower", "flow", "flight").
    fun exercise4_longestCommonPrefix(): String = TODO()

    // Exercise 5: isRotation
    // TODO: Check if "waterbottle" is a rotation of "erbottlewat".
    fun exercise5_isRotation(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_findSubstring() == 6) { "Exercise 1 failed" }
        assert(exercise2_countSubstring() == 3) { "Exercise 2 failed" }
        assert(exercise3_allUniqueChars() == true) { "Exercise 3 failed" }
        assert(exercise4_longestCommonPrefix() == "fl") { "Exercise 4 failed" }
        assert(exercise5_isRotation() == true) { "Exercise 5 failed" }
        println("All Algo009_StringSearch exercises passed!")
    }
}
