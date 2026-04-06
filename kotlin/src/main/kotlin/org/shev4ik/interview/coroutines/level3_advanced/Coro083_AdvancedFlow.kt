package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced flow patterns
 */
object Coro083_AdvancedFlow {

    // Exercise 1: customOperator
    // TODO: Implement a coroutine exercise demonstrating customOperator.
    // TODO: Use runBlocking to make it testable. Topic: Advanced flow patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_customOperator(): String = TODO()

    // Exercise 2: flowInternals
    // TODO: Implement a coroutine exercise demonstrating flowInternals.
    // TODO: Use runBlocking to make it testable. Topic: Advanced flow patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_flowInternals(): String = TODO()

    // Exercise 3: flowCollector
    // TODO: Implement a coroutine exercise demonstrating flowCollector.
    // TODO: Use runBlocking to make it testable. Topic: Advanced flow patterns.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_flowCollector(): List<Int> = TODO()

    // Exercise 4: flowEmitter
    // TODO: Implement a coroutine exercise demonstrating flowEmitter.
    // TODO: Use runBlocking to make it testable. Topic: Advanced flow patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_flowEmitter(): String = TODO()

    // Exercise 5: flowScope
    // TODO: Implement a coroutine exercise demonstrating flowScope.
    // TODO: Use runBlocking to make it testable. Topic: Advanced flow patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_flowScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_customOperator().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flowInternals().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_flowCollector().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flowEmitter().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_flowScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro083_AdvancedFlow exercises passed!")
    }
}
