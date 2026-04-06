package org.shev4ik.interview.coroutines.level1_basics

/**
 * GlobalScope dangers
 */
object Coro022_GlobalScope {

    // Exercise 1: globalScopeDanger
    // TODO: Implement a coroutine exercise demonstrating globalScopeDanger.
    // TODO: Use runBlocking to make it testable. Topic: GlobalScope dangers.
    // TODO: Return a verifiable result of type String.
    fun exercise1_globalScopeDanger(): String = TODO()

    // Exercise 2: structuredAlternative
    // TODO: Implement a coroutine exercise demonstrating structuredAlternative.
    // TODO: Use runBlocking to make it testable. Topic: GlobalScope dangers.
    // TODO: Return a verifiable result of type String.
    fun exercise2_structuredAlternative(): String = TODO()

    // Exercise 3: leakPrevention
    // TODO: Implement a coroutine exercise demonstrating leakPrevention.
    // TODO: Use runBlocking to make it testable. Topic: GlobalScope dangers.
    // TODO: Return a verifiable result of type String.
    fun exercise3_leakPrevention(): String = TODO()

    // Exercise 4: applicationScope
    // TODO: Implement a coroutine exercise demonstrating applicationScope.
    // TODO: Use runBlocking to make it testable. Topic: GlobalScope dangers.
    // TODO: Return a verifiable result of type String.
    fun exercise4_applicationScope(): String = TODO()

    // Exercise 5: daemonCoroutine
    // TODO: Implement a coroutine exercise demonstrating daemonCoroutine.
    // TODO: Use runBlocking to make it testable. Topic: GlobalScope dangers.
    // TODO: Return a verifiable result of type String.
    fun exercise5_daemonCoroutine(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_globalScopeDanger().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_structuredAlternative().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_leakPrevention().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_applicationScope().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_daemonCoroutine().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro022_GlobalScope exercises passed!")
    }
}
