package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Ranges and Progressions
 */
object Core010_Ranges {

    // Exercise 1: intRange
    // TODO: Check if 5 is in IntRange 1..10. Return result.
    fun exercise1_intRange(): Boolean = TODO()

    // Exercise 2: untilRange
    // TODO: Create range 0 until 5 (exclusive end). Convert to list. Return it.
    fun exercise2_untilRange(): List<Int> = TODO()

    // Exercise 3: downToRange
    // TODO: Create range 5 downTo 1. Convert to list. Return it.
    fun exercise3_downToRange(): List<Int> = TODO()

    // Exercise 4: stepRange
    // TODO: Create range 0..20 step 5. Convert to list. Return it.
    fun exercise4_stepRange(): List<Int> = TODO()

    // Exercise 5: charRange
    // TODO: Create range 'a'..'e'. Convert to list. Return it.
    fun exercise5_charRange(): List<Char> = TODO()

    // Exercise 6: rangeContains
    // TODO: Check if 15 is in 1..10 and if 5 is in 1..10. Return Pair(first, second).
    fun exercise6_rangeContains(): Pair<Boolean, Boolean> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_intRange() == true) { "Ex1 failed" }
        assert(exercise2_untilRange() == listOf(0, 1, 2, 3, 4)) { "Ex2 failed" }
        assert(exercise3_downToRange() == listOf(5, 4, 3, 2, 1)) { "Ex3 failed" }
        assert(exercise4_stepRange() == listOf(0, 5, 10, 15, 20)) { "Ex4 failed" }
        assert(exercise5_charRange() == listOf('a', 'b', 'c', 'd', 'e')) { "Ex5 failed" }
        assert(exercise6_rangeContains() == Pair(false, true)) { "Ex6 failed" }
        println("All Core010_Ranges exercises passed!")
    }
}
