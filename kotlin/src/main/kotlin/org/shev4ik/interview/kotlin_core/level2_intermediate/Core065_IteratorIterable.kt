package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Iterator and Iterable
 */
object Core065_IteratorIterable {

    // Exercise 1: customIterator
    // TODO: Create class CountDown(val start: Int) : Iterable<Int> with iterator that goes from start to 1.
    // TODO: Return CountDown(5).toList().
    fun exercise1_customIterator(): List<Int> = TODO()

    // Exercise 2: fibonacciIterator
    // TODO: Create an iterator that yields fibonacci numbers. Take first 7. Return list.
    fun exercise2_fibonacciIterator(): List<Int> = TODO()

    // Exercise 3: transformIterator
    // TODO: Create an iterator that squares each element from listOf(1,2,3,4).iterator().
    // TODO: Return collected list.
    fun exercise3_transformIterator(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_customIterator() == listOf(5,4,3,2,1)) { "Exercise 1 failed" }
        assert(exercise2_fibonacciIterator() == listOf(0,1,1,2,3,5,8)) { "Exercise 2 failed" }
        assert(exercise3_transformIterator() == listOf(1,4,9,16)) { "Exercise 3 failed" }
        println("All Core065_IteratorIterable exercises passed!")
    }
}
