package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced select
 */
object Coro082_AdvancedSelect {

    // Exercise 1: selectTimeout
    // TODO: Implement a coroutine exercise demonstrating selectTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Advanced select.
    // TODO: Return a verifiable result of type String.
    fun exercise1_selectTimeout(): String = TODO()

    // Exercise 2: selectPriority
    // TODO: Implement a coroutine exercise demonstrating selectPriority.
    // TODO: Use runBlocking to make it testable. Topic: Advanced select.
    // TODO: Return a verifiable result of type String.
    fun exercise2_selectPriority(): String = TODO()

    // Exercise 3: selectLoop
    // TODO: Implement a coroutine exercise demonstrating selectLoop.
    // TODO: Use runBlocking to make it testable. Topic: Advanced select.
    // TODO: Return a verifiable result of type String.
    fun exercise3_selectLoop(): String = TODO()

    // Exercise 4: biasedSelect
    // TODO: Implement a coroutine exercise demonstrating biasedSelect.
    // TODO: Use runBlocking to make it testable. Topic: Advanced select.
    // TODO: Return a verifiable result of type String.
    fun exercise4_biasedSelect(): String = TODO()

    // Exercise 5: selectOnClose
    // TODO: Implement a coroutine exercise demonstrating selectOnClose.
    // TODO: Use runBlocking to make it testable. Topic: Advanced select.
    // TODO: Return a verifiable result of type String.
    fun exercise5_selectOnClose(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_selectTimeout().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_selectPriority().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_selectLoop().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_biasedSelect().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_selectOnClose().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro082_AdvancedSelect exercises passed!")
    }
}
