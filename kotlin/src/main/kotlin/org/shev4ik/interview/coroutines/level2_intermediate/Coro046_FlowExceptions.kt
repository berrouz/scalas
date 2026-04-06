package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow exception handling
 */
object Coro046_FlowExceptions {

    // Exercise 1: catchOperator
    // TODO: Implement a coroutine exercise demonstrating catchOperator.
    // TODO: Use runBlocking to make it testable. Topic: Flow exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise1_catchOperator(): String = TODO()

    // Exercise 2: onCompletion
    // TODO: Implement a coroutine exercise demonstrating onCompletion.
    // TODO: Use runBlocking to make it testable. Topic: Flow exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise2_onCompletion(): String = TODO()

    // Exercise 3: retryFlow
    // TODO: Implement a coroutine exercise demonstrating retryFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise3_retryFlow(): String = TODO()

    // Exercise 4: retryWhen
    // TODO: Implement a coroutine exercise demonstrating retryWhen.
    // TODO: Use runBlocking to make it testable. Topic: Flow exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise4_retryWhen(): String = TODO()

    // Exercise 5: exceptionTransparency
    // TODO: Implement a coroutine exercise demonstrating exceptionTransparency.
    // TODO: Use runBlocking to make it testable. Topic: Flow exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise5_exceptionTransparency(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_catchOperator().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_onCompletion().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_retryFlow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_retryWhen().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_exceptionTransparency().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro046_FlowExceptions exercises passed!")
    }
}
