package org.shev4ik.interview.coroutines.level4_expert

/**
 * Virtual threads integration
 */
object Coro120_VirtualThreads {

    // Exercise 1: loomDispatcher
    // TODO: Implement a coroutine exercise demonstrating loomDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Virtual threads integration.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_loomDispatcher(): Boolean = TODO()

    // Exercise 2: virtualThread
    // TODO: Implement a coroutine exercise demonstrating virtualThread.
    // TODO: Use runBlocking to make it testable. Topic: Virtual threads integration.
    // TODO: Return a verifiable result of type String.
    fun exercise2_virtualThread(): String = TODO()

    // Exercise 3: pinning
    // TODO: Implement a coroutine exercise demonstrating pinning.
    // TODO: Use runBlocking to make it testable. Topic: Virtual threads integration.
    // TODO: Return a verifiable result of type String.
    fun exercise3_pinning(): String = TODO()

    // Exercise 4: migration
    // TODO: Implement a coroutine exercise demonstrating migration.
    // TODO: Use runBlocking to make it testable. Topic: Virtual threads integration.
    // TODO: Return a verifiable result of type String.
    fun exercise4_migration(): String = TODO()

    // Exercise 5: comparison
    // TODO: Implement a coroutine exercise demonstrating comparison.
    // TODO: Use runBlocking to make it testable. Topic: Virtual threads integration.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_comparison(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_loomDispatcher() == true) { "Exercise 1 failed" }
        assert(exercise2_virtualThread().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_pinning().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_migration().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_comparison() == true) { "Exercise 5 failed" }
        println("All Coro120_VirtualThreads exercises passed!")
    }
}
