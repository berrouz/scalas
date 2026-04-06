package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine performance
 */
object Coro094_Performance {

    // Exercise 1: benchmark
    // TODO: Implement a coroutine exercise demonstrating benchmark.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine performance.
    // TODO: Return a verifiable result of type String.
    fun exercise1_benchmark(): String = TODO()

    // Exercise 2: overhead
    // TODO: Implement a coroutine exercise demonstrating overhead.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine performance.
    // TODO: Return a verifiable result of type String.
    fun exercise2_overhead(): String = TODO()

    // Exercise 3: allocation
    // TODO: Implement a coroutine exercise demonstrating allocation.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine performance.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_allocation(): List<Int> = TODO()

    // Exercise 4: contextSwitch
    // TODO: Implement a coroutine exercise demonstrating contextSwitch.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine performance.
    // TODO: Return a verifiable result of type String.
    fun exercise4_contextSwitch(): String = TODO()

    // Exercise 5: throughput
    // TODO: Implement a coroutine exercise demonstrating throughput.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine performance.
    // TODO: Return a verifiable result of type String.
    fun exercise5_throughput(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_benchmark().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_overhead().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_allocation().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_contextSwitch().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_throughput().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro094_Performance exercises passed!")
    }
}
