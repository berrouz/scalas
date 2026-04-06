package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Collection Aggregations
 */
object Core053_CollectionAggregations {

    // Exercise 1: sumOf
    // TODO: Use listOf("hello","world","hi").sumOf { it.length }. Return result.
    fun exercise1_sumOf(): Int = TODO()

    // Exercise 2: countPredicate
    // TODO: Count even numbers in listOf(1,2,3,4,5,6,7,8,9,10). Return count.
    fun exercise2_countPredicate(): Int = TODO()

    // Exercise 3: minByOrNull
    // TODO: Find shortest string in listOf("hello","hi","hey") using minByOrNull { it.length }.
    fun exercise3_minByOrNull(): String? = TODO()

    // Exercise 4: maxByOrNull
    // TODO: Find max by absolute value in listOf(-5, 3, -8, 2) using maxByOrNull { abs(it) }.
    fun exercise4_maxByOrNull(): Int? = TODO()

    // Exercise 5: anyAllNone
    // TODO: For listOf(1,2,3,4,5): any { it > 4 }, all { it > 0 }, none { it > 10 }.
    // TODO: Return Triple of results.
    fun exercise5_anyAllNone(): Triple<Boolean, Boolean, Boolean> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sumOf() == 12) { "Exercise 1 failed" }
        assert(exercise2_countPredicate() == 5) { "Exercise 2 failed" }
        assert(exercise3_minByOrNull() == "hi") { "Exercise 3 failed" }
        assert(exercise4_maxByOrNull() == -8) { "Exercise 4 failed" }
        assert(exercise5_anyAllNone() == Triple(true, true, true)) { "Exercise 5 failed" }
        println("All Core053_CollectionAggregations exercises passed!")
    }
}
