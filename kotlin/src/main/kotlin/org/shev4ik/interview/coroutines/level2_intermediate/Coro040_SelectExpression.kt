package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Select expression
 */
object Coro040_SelectExpression {

    // Exercise 1: onReceive
    // TODO: Implement a coroutine exercise demonstrating onReceive.
    // TODO: Use runBlocking to make it testable. Topic: Select expression.
    // TODO: Return a verifiable result of type String.
    fun exercise1_onReceive(): String = TODO()

    // Exercise 2: onSend
    // TODO: Implement a coroutine exercise demonstrating onSend.
    // TODO: Use runBlocking to make it testable. Topic: Select expression.
    // TODO: Return a verifiable result of type String.
    fun exercise2_onSend(): String = TODO()

    // Exercise 3: onAwait
    // TODO: Implement a coroutine exercise demonstrating onAwait.
    // TODO: Use runBlocking to make it testable. Topic: Select expression.
    // TODO: Return a verifiable result of type String.
    fun exercise3_onAwait(): String = TODO()

    // Exercise 4: selectTimeout
    // TODO: Implement a coroutine exercise demonstrating selectTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Select expression.
    // TODO: Return a verifiable result of type String.
    fun exercise4_selectTimeout(): String = TODO()

    // Exercise 5: selectLoop
    // TODO: Implement a coroutine exercise demonstrating selectLoop.
    // TODO: Use runBlocking to make it testable. Topic: Select expression.
    // TODO: Return a verifiable result of type String.
    fun exercise5_selectLoop(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_onReceive().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_onSend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_onAwait().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_selectTimeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_selectLoop().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro040_SelectExpression exercises passed!")
    }
}
