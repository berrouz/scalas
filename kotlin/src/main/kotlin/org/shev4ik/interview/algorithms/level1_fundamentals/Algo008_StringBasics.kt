package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * String Fundamentals
 */
object Algo008_StringBasics {

    // Exercise 1: reverseString
    // TODO: Reverse the string "hello". Return result.
    fun exercise1_reverseString(): String = TODO()

    // Exercise 2: isPalindrome
    // TODO: Check if "racecar" is a palindrome (case insensitive).
    fun exercise2_isPalindrome(): Boolean = TODO()

    // Exercise 3: isAnagram
    // TODO: Check if "listen" and "silent" are anagrams.
    fun exercise3_isAnagram(): Boolean = TODO()

    // Exercise 4: charFrequency
    // TODO: Return character frequency map for "aabbccc".
    fun exercise4_charFrequency(): Map<Char, Int> = TODO()

    // Exercise 5: compressString
    // TODO: Compress "aabcccccaaa" to "a2b1c5a3". Return compressed string.
    fun exercise5_compressString(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reverseString() == "olleh") { "Exercise 1 failed" }
        assert(exercise2_isPalindrome() == true) { "Exercise 2 failed" }
        assert(exercise3_isAnagram() == true) { "Exercise 3 failed" }
        assert(exercise4_charFrequency() == mapOf('a' to 2, 'b' to 2, 'c' to 3)) { "Exercise 4 failed" }
        assert(exercise5_compressString() == "a2b1c5a3") { "Exercise 5 failed" }
        println("All Algo008_StringBasics exercises passed!")
    }
}
