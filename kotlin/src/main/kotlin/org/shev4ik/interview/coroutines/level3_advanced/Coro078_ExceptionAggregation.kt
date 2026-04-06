package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Exception aggregation
 */
object Coro078_ExceptionAggregation {

    // Exercise 1: suppressed
    // TODO: Implement a coroutine exercise demonstrating suppressed.
    // TODO: Use runBlocking to make it testable. Topic: Exception aggregation.
    // TODO: Return a verifiable result of type String.
    fun exercise1_suppressed(): String = TODO()

    // Exercise 2: multipleFailures
    // TODO: Implement a coroutine exercise demonstrating multipleFailures.
    // TODO: Use runBlocking to make it testable. Topic: Exception aggregation.
    // TODO: Return a verifiable result of type String.
    fun exercise2_multipleFailures(): String = TODO()

    // Exercise 3: firstException
    // TODO: Implement a coroutine exercise demonstrating firstException.
    // TODO: Use runBlocking to make it testable. Topic: Exception aggregation.
    // TODO: Return a verifiable result of type String.
    fun exercise3_firstException(): String = TODO()

    // Exercise 4: aggregatedHandler
    // TODO: Implement a coroutine exercise demonstrating aggregatedHandler.
    // TODO: Use runBlocking to make it testable. Topic: Exception aggregation.
    // TODO: Return a verifiable result of type String.
    fun exercise4_aggregatedHandler(): String = TODO()

    // Exercise 5: exceptionUnwrap
    // TODO: Implement a coroutine exercise demonstrating exceptionUnwrap.
    // TODO: Use runBlocking to make it testable. Topic: Exception aggregation.
    // TODO: Return a verifiable result of type String.
    fun exercise5_exceptionUnwrap(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_suppressed().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_multipleFailures().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_firstException().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_aggregatedHandler().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_exceptionUnwrap().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro078_ExceptionAggregation exercises passed!")
    }
}
