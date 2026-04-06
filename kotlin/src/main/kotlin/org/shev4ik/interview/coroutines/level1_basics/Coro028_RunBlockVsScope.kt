package org.shev4ik.interview.coroutines.level1_basics

/**
 * runBlocking vs coroutineScope
 */
object Coro028_RunBlockVsScope {

    // Exercise 1: runBlockingUsage
    // TODO: Implement a coroutine exercise demonstrating runBlockingUsage.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking vs coroutineScope.
    // TODO: Return a verifiable result of type String.
    fun exercise1_runBlockingUsage(): String = TODO()

    // Exercise 2: coroutineScopeUsage
    // TODO: Implement a coroutine exercise demonstrating coroutineScopeUsage.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking vs coroutineScope.
    // TODO: Return a verifiable result of type String.
    fun exercise2_coroutineScopeUsage(): String = TODO()

    // Exercise 3: nestingRules
    // TODO: Implement a coroutine exercise demonstrating nestingRules.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking vs coroutineScope.
    // TODO: Return a verifiable result of type String.
    fun exercise3_nestingRules(): String = TODO()

    // Exercise 4: threadBehavior
    // TODO: Implement a coroutine exercise demonstrating threadBehavior.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking vs coroutineScope.
    // TODO: Return a verifiable result of type String.
    fun exercise4_threadBehavior(): String = TODO()

    // Exercise 5: exceptionBehavior
    // TODO: Implement a coroutine exercise demonstrating exceptionBehavior.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking vs coroutineScope.
    // TODO: Return a verifiable result of type String.
    fun exercise5_exceptionBehavior(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_runBlockingUsage().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_coroutineScopeUsage().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_nestingRules().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_threadBehavior().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_exceptionBehavior().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro028_RunBlockVsScope exercises passed!")
    }
}
