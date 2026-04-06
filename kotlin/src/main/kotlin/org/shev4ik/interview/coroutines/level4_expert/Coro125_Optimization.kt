package org.shev4ik.interview.coroutines.level4_expert

/**
 * Coroutine optimization
 */
object Coro125_Optimization {

    // Exercise 1: reduceAllocation
    // TODO: Implement a coroutine exercise demonstrating reduceAllocation.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine optimization.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_reduceAllocation(): List<Int> = TODO()

    // Exercise 2: inlineSuspend
    // TODO: Implement a coroutine exercise demonstrating inlineSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine optimization.
    // TODO: Return a verifiable result of type String.
    fun exercise2_inlineSuspend(): String = TODO()

    // Exercise 3: fastPath
    // TODO: Implement a coroutine exercise demonstrating fastPath.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine optimization.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_fastPath(): List<Int> = TODO()

    // Exercise 4: slowPath
    // TODO: Implement a coroutine exercise demonstrating slowPath.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine optimization.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_slowPath(): List<Int> = TODO()

    // Exercise 5: pooling
    // TODO: Implement a coroutine exercise demonstrating pooling.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine optimization.
    // TODO: Return a verifiable result of type String.
    fun exercise5_pooling(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reduceAllocation().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_inlineSuspend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_fastPath().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_slowPath().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_pooling().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro125_Optimization exercises passed!")
    }
}
