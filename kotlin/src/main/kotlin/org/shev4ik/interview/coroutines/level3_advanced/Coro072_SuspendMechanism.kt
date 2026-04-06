package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Suspend mechanism
 */
object Coro072_SuspendMechanism {

    // Exercise 1: suspendCoroutine
    // TODO: Implement a coroutine exercise demonstrating suspendCoroutine.
    // TODO: Use runBlocking to make it testable. Topic: Suspend mechanism.
    // TODO: Return a verifiable result of type String.
    fun exercise1_suspendCoroutine(): String = TODO()

    // Exercise 2: suspendCancellable
    // TODO: Implement a coroutine exercise demonstrating suspendCancellable.
    // TODO: Use runBlocking to make it testable. Topic: Suspend mechanism.
    // TODO: Return a verifiable result of type String.
    fun exercise2_suspendCancellable(): String = TODO()

    // Exercise 3: resumeWith
    // TODO: Implement a coroutine exercise demonstrating resumeWith.
    // TODO: Use runBlocking to make it testable. Topic: Suspend mechanism.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_resumeWith(): Int = TODO()

    // Exercise 4: resumeException
    // TODO: Implement a coroutine exercise demonstrating resumeException.
    // TODO: Use runBlocking to make it testable. Topic: Suspend mechanism.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_resumeException(): Int = TODO()

    // Exercise 5: intercepted
    // TODO: Implement a coroutine exercise demonstrating intercepted.
    // TODO: Use runBlocking to make it testable. Topic: Suspend mechanism.
    // TODO: Return a verifiable result of type String.
    fun exercise5_intercepted(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_suspendCoroutine().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_suspendCancellable().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_resumeWith()
        exercise4_resumeException()
        assert(exercise5_intercepted().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro072_SuspendMechanism exercises passed!")
    }
}
