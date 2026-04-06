package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Comparable and Comparator
 */
object Core064_ComparableComparator {

    // Exercise 1: comparableImpl
    // TODO: Create data class Age(val value: Int) : Comparable<Age> (compare by value).
    // TODO: Return Age(25) < Age(30).
    fun exercise1_comparableImpl(): Boolean = TODO()

    // Exercise 2: compareBy
    // TODO: Sort listOf("banana","apple","cherry") using sortedWith(compareBy { it.length }).
    // TODO: Return result.
    fun exercise2_compareBy(): List<String> = TODO()

    // Exercise 3: thenBy
    // TODO: Sort listOf("bb","aa","ba","ab") by length then alphabetically.
    // TODO: Return result.
    fun exercise3_thenBy(): List<String> = TODO()

    // Exercise 4: reversed
    // TODO: Sort listOf(1,3,2,5,4) descending using sortedWith(compareBy<Int> { it }.reversed()).
    // TODO: Return result.
    fun exercise4_reversed(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_comparableImpl() == true) { "Exercise 1 failed" }
        assert(exercise2_compareBy() == listOf("apple", "banana", "cherry")) { "Exercise 2 failed" }
        assert(exercise3_thenBy() == listOf("aa", "ab", "ba", "bb")) { "Exercise 3 failed" }
        assert(exercise4_reversed() == listOf(5,4,3,2,1)) { "Exercise 4 failed" }
        println("All Core064_ComparableComparator exercises passed!")
    }
}
