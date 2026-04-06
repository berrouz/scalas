package org.shev4ik.interview.coroutines.level1_basics

/**
 * Sequence builder with yield
 */
object Coro019_SequenceBuilder {

    // Exercise 1: sequenceYield
    // TODO: Implement a coroutine exercise demonstrating sequenceYield.
    // TODO: Use runBlocking to make it testable. Topic: Sequence builder with yield.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_sequenceYield(): List<Int> = TODO()

    // Exercise 2: yieldAll
    // TODO: Implement a coroutine exercise demonstrating yieldAll.
    // TODO: Use runBlocking to make it testable. Topic: Sequence builder with yield.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_yieldAll(): List<Int> = TODO()

    // Exercise 3: fibonacciSeq
    // TODO: Implement a coroutine exercise demonstrating fibonacciSeq.
    // TODO: Use runBlocking to make it testable. Topic: Sequence builder with yield.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_fibonacciSeq(): Boolean = TODO()

    // Exercise 4: infiniteSeq
    // TODO: Implement a coroutine exercise demonstrating infiniteSeq.
    // TODO: Use runBlocking to make it testable. Topic: Sequence builder with yield.
    // TODO: Return a verifiable result of type String.
    fun exercise4_infiniteSeq(): String = TODO()

    // Exercise 5: constrainOnce
    // TODO: Implement a coroutine exercise demonstrating constrainOnce.
    // TODO: Use runBlocking to make it testable. Topic: Sequence builder with yield.
    // TODO: Return a verifiable result of type String.
    fun exercise5_constrainOnce(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sequenceYield().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_yieldAll().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_fibonacciSeq() == true) { "Exercise 3 failed" }
        assert(exercise4_infiniteSeq().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_constrainOnce().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro019_SequenceBuilder exercises passed!")
    }
}
