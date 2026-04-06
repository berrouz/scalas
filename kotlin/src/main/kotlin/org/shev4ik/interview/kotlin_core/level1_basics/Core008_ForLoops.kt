package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * For Loops
 */
object Core008_ForLoops {

    // Exercise 1: rangeFor
    // TODO: Sum numbers from 1 to 10 using for(i in 1..10). Return sum.
    fun exercise1_rangeFor(): Int = TODO()

    // Exercise 2: indexFor
    // TODO: Given list = listOf(10,20,30), sum the indices (0+1+2=3) using .indices.
    fun exercise2_indexFor(): Int = TODO()

    // Exercise 3: withIndexFor
    // TODO: Given list = listOf(10,20,30), use withIndex() to sum indices and values.
    // TODO: Return Pair(indexSum, valueSum).
    fun exercise3_withIndexFor(): Pair<Int, Int> = TODO()

    // Exercise 4: downToFor
    // TODO: Collect numbers from 5 downTo 1 into a list. Return it.
    fun exercise4_downToFor(): List<Int> = TODO()

    // Exercise 5: stepFor
    // TODO: Collect even numbers from 2 to 10 using step 2. Return list.
    fun exercise5_stepFor(): List<Int> = TODO()

    // Exercise 6: nestedFor
    // TODO: Count pairs (i,j) where i in 1..3 and j in 1..3 and i != j.
    fun exercise6_nestedFor(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_rangeFor() == 55) { "Ex1 failed" }
        assert(exercise2_indexFor() == 3) { "Ex2 failed" }
        assert(exercise3_withIndexFor() == Pair(3, 60)) { "Ex3 failed" }
        assert(exercise4_downToFor() == listOf(5, 4, 3, 2, 1)) { "Ex4 failed" }
        assert(exercise5_stepFor() == listOf(2, 4, 6, 8, 10)) { "Ex5 failed" }
        assert(exercise6_nestedFor() == 6) { "Ex6 failed" }
        println("All Core008_ForLoops exercises passed!")
    }
}
