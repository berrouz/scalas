package org.shev4ik.interview.coroutines.level1_basics

/**
 * Job cancellation
 */
object Coro007_JobCancellation {

    // Exercise 1: cancelJob
    // TODO: Implement a coroutine exercise demonstrating cancelJob.
    // TODO: Use runBlocking to make it testable. Topic: Job cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise1_cancelJob(): String = TODO()

    // Exercise 2: cancelAndJoin
    // TODO: Implement a coroutine exercise demonstrating cancelAndJoin.
    // TODO: Use runBlocking to make it testable. Topic: Job cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise2_cancelAndJoin(): String = TODO()

    // Exercise 3: isActiveCheck
    // TODO: Implement a coroutine exercise demonstrating isActiveCheck.
    // TODO: Use runBlocking to make it testable. Topic: Job cancellation.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_isActiveCheck(): Boolean = TODO()

    // Exercise 4: cancellationException
    // TODO: Implement a coroutine exercise demonstrating cancellationException.
    // TODO: Use runBlocking to make it testable. Topic: Job cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cancellationException(): String = TODO()

    // Exercise 5: parentCancel
    // TODO: Implement a coroutine exercise demonstrating parentCancel.
    // TODO: Use runBlocking to make it testable. Topic: Job cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise5_parentCancel(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cancelJob().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_cancelAndJoin().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_isActiveCheck() == true) { "Exercise 3 failed" }
        assert(exercise4_cancellationException().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_parentCancel().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro007_JobCancellation exercises passed!")
    }
}
