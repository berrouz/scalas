package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Flow sharing
 */
object Coro084_FlowSharing {

    // Exercise 1: shareIn
    // TODO: Implement a coroutine exercise demonstrating shareIn.
    // TODO: Use runBlocking to make it testable. Topic: Flow sharing.
    // TODO: Return a verifiable result of type String.
    fun exercise1_shareIn(): String = TODO()

    // Exercise 2: stateIn
    // TODO: Implement a coroutine exercise demonstrating stateIn.
    // TODO: Use runBlocking to make it testable. Topic: Flow sharing.
    // TODO: Return a verifiable result of type String.
    fun exercise2_stateIn(): String = TODO()

    // Exercise 3: sharingStarted
    // TODO: Implement a coroutine exercise demonstrating sharingStarted.
    // TODO: Use runBlocking to make it testable. Topic: Flow sharing.
    // TODO: Return a verifiable result of type String.
    fun exercise3_sharingStarted(): String = TODO()

    // Exercise 4: whileSubscribed
    // TODO: Implement a coroutine exercise demonstrating whileSubscribed.
    // TODO: Use runBlocking to make it testable. Topic: Flow sharing.
    // TODO: Return a verifiable result of type String.
    fun exercise4_whileSubscribed(): String = TODO()

    // Exercise 5: eagerly
    // TODO: Implement a coroutine exercise demonstrating eagerly.
    // TODO: Use runBlocking to make it testable. Topic: Flow sharing.
    // TODO: Return a verifiable result of type String.
    fun exercise5_eagerly(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_shareIn().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_stateIn().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_sharingStarted().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_whileSubscribed().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_eagerly().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro084_FlowSharing exercises passed!")
    }
}
