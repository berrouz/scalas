package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Collection Operations
 */
object Core020_CollectionOperations {

    // Exercise 1: mapOp
    // TODO: Map listOf(1,2,3) to their string representations. Return result.
    fun exercise1_mapOp(): List<String> = TODO()

    // Exercise 2: filterOp
    // TODO: Filter listOf(1,2,3,4,5,6) to keep only even numbers.
    fun exercise2_filterOp(): List<Int> = TODO()

    // Exercise 3: flatMapOp
    // TODO: FlatMap listOf(listOf(1,2), listOf(3,4), listOf(5)) to a single list.
    fun exercise3_flatMapOp(): List<Int> = TODO()

    // Exercise 4: foldOp
    // TODO: Fold listOf(1,2,3,4,5) with initial 0 and operation { acc, n -> acc + n }.
    fun exercise4_foldOp(): Int = TODO()

    // Exercise 5: reduceOp
    // TODO: Reduce listOf(1,2,3,4) with { acc, n -> acc * n }. Return product.
    fun exercise5_reduceOp(): Int = TODO()

    // Exercise 6: sortedOp
    // TODO: Sort listOf(5,3,1,4,2) in ascending order. Return result.
    fun exercise6_sortedOp(): List<Int> = TODO()

    // Exercise 7: groupByOp
    // TODO: Group listOf(1,2,3,4,5,6) by { it % 2 == 0 }. Return result.
    fun exercise7_groupByOp(): Map<Boolean, List<Int>> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mapOp() == listOf("1", "2", "3")) { "Ex1 failed" }
        assert(exercise2_filterOp() == listOf(2, 4, 6)) { "Ex2 failed" }
        assert(exercise3_flatMapOp() == listOf(1, 2, 3, 4, 5)) { "Ex3 failed" }
        assert(exercise4_foldOp() == 15) { "Ex4 failed" }
        assert(exercise5_reduceOp() == 24) { "Ex5 failed" }
        assert(exercise6_sortedOp() == listOf(1, 2, 3, 4, 5)) { "Ex6 failed" }
        assert(exercise7_groupByOp() == mapOf(false to listOf(1,3,5), true to listOf(2,4,6))) { "Ex7 failed" }
        println("All Core020_CollectionOperations exercises passed!")
    }
}
