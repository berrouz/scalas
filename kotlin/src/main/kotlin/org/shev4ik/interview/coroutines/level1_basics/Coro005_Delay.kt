package org.shev4ik.interview.coroutines.level1_basics

/**
 * Delay and suspension
 */
object Coro005_Delay {

    // Exercise 1: basicDelay
    // TODO: Implement a coroutine exercise demonstrating basicDelay.
    // TODO: Use runBlocking to make it testable. Topic: Delay and suspension.
    // TODO: Return a verifiable result of type String.
    fun exercise1_basicDelay(): String = TODO()

    // Exercise 2: yield
    // TODO: Implement a coroutine exercise demonstrating yield.
    // TODO: Use runBlocking to make it testable. Topic: Delay and suspension.
    // TODO: Return a verifiable result of type String.
    fun exercise2_yield(): String = TODO()

    // Exercise 3: delayVsSleep
    // TODO: Implement a coroutine exercise demonstrating delayVsSleep.
    // TODO: Use runBlocking to make it testable. Topic: Delay and suspension.
    // TODO: Return a verifiable result of type String.
    fun exercise3_delayVsSleep(): String = TODO()

    // Exercise 4: timeoutDelay
    // TODO: Implement a coroutine exercise demonstrating timeoutDelay.
    // TODO: Use runBlocking to make it testable. Topic: Delay and suspension.
    // TODO: Return a verifiable result of type String.
    fun exercise4_timeoutDelay(): String = TODO()

    // Exercise 5: suspensionPoint
    // TODO: Implement a coroutine exercise demonstrating suspensionPoint.
    // TODO: Use runBlocking to make it testable. Topic: Delay and suspension.
    // TODO: Return a verifiable result of type String.
    fun exercise5_suspensionPoint(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicDelay().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_yield().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_delayVsSleep().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_timeoutDelay().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_suspensionPoint().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro005_Delay exercises passed!")
    }
}
