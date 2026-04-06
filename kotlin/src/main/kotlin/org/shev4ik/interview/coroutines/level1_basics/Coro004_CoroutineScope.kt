package org.shev4ik.interview.coroutines.level1_basics

/**
 * CoroutineScope basics
 */
object Coro004_CoroutineScope {

    // Exercise 1: scopeBuilder
    // TODO: Implement a coroutine exercise demonstrating scopeBuilder.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineScope basics.
    // TODO: Return a verifiable result of type String.
    fun exercise1_scopeBuilder(): String = TODO()

    // Exercise 2: coroutineScope
    // TODO: Implement a coroutine exercise demonstrating coroutineScope.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineScope basics.
    // TODO: Return a verifiable result of type String.
    fun exercise2_coroutineScope(): String = TODO()

    // Exercise 3: customScope
    // TODO: Implement a coroutine exercise demonstrating customScope.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineScope basics.
    // TODO: Return a verifiable result of type String.
    fun exercise3_customScope(): String = TODO()

    // Exercise 4: scopeCancel
    // TODO: Implement a coroutine exercise demonstrating scopeCancel.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineScope basics.
    // TODO: Return a verifiable result of type String.
    fun exercise4_scopeCancel(): String = TODO()

    // Exercise 5: nestedScope
    // TODO: Implement a coroutine exercise demonstrating nestedScope.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineScope basics.
    // TODO: Return a verifiable result of type String.
    fun exercise5_nestedScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_scopeBuilder().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_coroutineScope().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_customScope().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_scopeCancel().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_nestedScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro004_CoroutineScope exercises passed!")
    }
}
