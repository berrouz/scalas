package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine debugging
 */
object Coro093_Debugging {

    // Exercise 1: debugMode
    // TODO: Implement a coroutine exercise demonstrating debugMode.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine debugging.
    // TODO: Return a verifiable result of type String.
    fun exercise1_debugMode(): String = TODO()

    // Exercise 2: coroutineDump
    // TODO: Implement a coroutine exercise demonstrating coroutineDump.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine debugging.
    // TODO: Return a verifiable result of type String.
    fun exercise2_coroutineDump(): String = TODO()

    // Exercise 3: naming
    // TODO: Implement a coroutine exercise demonstrating naming.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine debugging.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_naming(): Int = TODO()

    // Exercise 4: threadDump
    // TODO: Implement a coroutine exercise demonstrating threadDump.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine debugging.
    // TODO: Return a verifiable result of type String.
    fun exercise4_threadDump(): String = TODO()

    // Exercise 5: probing
    // TODO: Implement a coroutine exercise demonstrating probing.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine debugging.
    // TODO: Return a verifiable result of type String.
    fun exercise5_probing(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_debugMode().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_coroutineDump().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_naming()
        assert(exercise4_threadDump().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_probing().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro093_Debugging exercises passed!")
    }
}
