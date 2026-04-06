package org.shev4ik.interview.coroutines.level1_basics

/**
 * Suspending vs blocking
 */
object Coro020_SuspendVsBlocking {

    // Exercise 1: delayVsSleep
    // TODO: Implement a coroutine exercise demonstrating delayVsSleep.
    // TODO: Use runBlocking to make it testable. Topic: Suspending vs blocking.
    // TODO: Return a verifiable result of type String.
    fun exercise1_delayVsSleep(): String = TODO()

    // Exercise 2: suspendFun
    // TODO: Implement a coroutine exercise demonstrating suspendFun.
    // TODO: Use runBlocking to make it testable. Topic: Suspending vs blocking.
    // TODO: Return a verifiable result of type String.
    fun exercise2_suspendFun(): String = TODO()

    // Exercise 3: blockingBridge
    // TODO: Implement a coroutine exercise demonstrating blockingBridge.
    // TODO: Use runBlocking to make it testable. Topic: Suspending vs blocking.
    // TODO: Return a verifiable result of type String.
    fun exercise3_blockingBridge(): String = TODO()

    // Exercise 4: nonBlocking
    // TODO: Implement a coroutine exercise demonstrating nonBlocking.
    // TODO: Use runBlocking to make it testable. Topic: Suspending vs blocking.
    // TODO: Return a verifiable result of type String.
    fun exercise4_nonBlocking(): String = TODO()

    // Exercise 5: performance
    // TODO: Implement a coroutine exercise demonstrating performance.
    // TODO: Use runBlocking to make it testable. Topic: Suspending vs blocking.
    // TODO: Return a verifiable result of type String.
    fun exercise5_performance(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_delayVsSleep().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_suspendFun().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_blockingBridge().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_nonBlocking().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_performance().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro020_SuspendVsBlocking exercises passed!")
    }
}
