package org.shev4ik.interview.coroutines.level4_expert

/**
 * Reactive patterns with coroutines
 */
object Coro117_ReactivePatterns {

    // Exercise 1: observe
    // TODO: Implement a coroutine exercise demonstrating observe.
    // TODO: Use runBlocking to make it testable. Topic: Reactive patterns with coroutines.
    // TODO: Return a verifiable result of type String.
    fun exercise1_observe(): String = TODO()

    // Exercise 2: publish
    // TODO: Implement a coroutine exercise demonstrating publish.
    // TODO: Use runBlocking to make it testable. Topic: Reactive patterns with coroutines.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_publish(): Boolean = TODO()

    // Exercise 3: replay
    // TODO: Implement a coroutine exercise demonstrating replay.
    // TODO: Use runBlocking to make it testable. Topic: Reactive patterns with coroutines.
    // TODO: Return a verifiable result of type String.
    fun exercise3_replay(): String = TODO()

    // Exercise 4: connectable
    // TODO: Implement a coroutine exercise demonstrating connectable.
    // TODO: Use runBlocking to make it testable. Topic: Reactive patterns with coroutines.
    // TODO: Return a verifiable result of type String.
    fun exercise4_connectable(): String = TODO()

    // Exercise 5: autoConnect
    // TODO: Implement a coroutine exercise demonstrating autoConnect.
    // TODO: Use runBlocking to make it testable. Topic: Reactive patterns with coroutines.
    // TODO: Return a verifiable result of type String.
    fun exercise5_autoConnect(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_observe().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_publish() == true) { "Exercise 2 failed" }
        assert(exercise3_replay().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_connectable().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_autoConnect().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro117_ReactivePatterns exercises passed!")
    }
}
