package org.shev4ik.interview.coroutines.level4_expert

/**
 * Continuation internals
 */
object Coro103_ContinuationInternals {

    // Exercise 1: continuationInterface
    // TODO: Implement a coroutine exercise demonstrating continuationInterface.
    // TODO: Use runBlocking to make it testable. Topic: Continuation internals.
    // TODO: Return a verifiable result of type String.
    fun exercise1_continuationInterface(): String = TODO()

    // Exercise 2: resume
    // TODO: Implement a coroutine exercise demonstrating resume.
    // TODO: Use runBlocking to make it testable. Topic: Continuation internals.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_resume(): Int = TODO()

    // Exercise 3: resumeWithException
    // TODO: Implement a coroutine exercise demonstrating resumeWithException.
    // TODO: Use runBlocking to make it testable. Topic: Continuation internals.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_resumeWithException(): Int = TODO()

    // Exercise 4: intercepted
    // TODO: Implement a coroutine exercise demonstrating intercepted.
    // TODO: Use runBlocking to make it testable. Topic: Continuation internals.
    // TODO: Return a verifiable result of type String.
    fun exercise4_intercepted(): String = TODO()

    // Exercise 5: createCoroutine
    // TODO: Implement a coroutine exercise demonstrating createCoroutine.
    // TODO: Use runBlocking to make it testable. Topic: Continuation internals.
    // TODO: Return a verifiable result of type String.
    fun exercise5_createCoroutine(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_continuationInterface().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_resume()
        exercise3_resumeWithException()
        assert(exercise4_intercepted().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_createCoroutine().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro103_ContinuationInternals exercises passed!")
    }
}
