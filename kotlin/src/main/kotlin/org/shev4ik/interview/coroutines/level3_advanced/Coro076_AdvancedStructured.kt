package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced structured concurrency
 */
object Coro076_AdvancedStructured {

    // Exercise 1: scopeManagement
    // TODO: Implement a coroutine exercise demonstrating scopeManagement.
    // TODO: Use runBlocking to make it testable. Topic: Advanced structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise1_scopeManagement(): String = TODO()

    // Exercise 2: lifetimeScope
    // TODO: Implement a coroutine exercise demonstrating lifetimeScope.
    // TODO: Use runBlocking to make it testable. Topic: Advanced structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise2_lifetimeScope(): String = TODO()

    // Exercise 3: cancelOnError
    // TODO: Implement a coroutine exercise demonstrating cancelOnError.
    // TODO: Use runBlocking to make it testable. Topic: Advanced structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise3_cancelOnError(): String = TODO()

    // Exercise 4: parallelScope
    // TODO: Implement a coroutine exercise demonstrating parallelScope.
    // TODO: Use runBlocking to make it testable. Topic: Advanced structured concurrency.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_parallelScope(): List<Int> = TODO()

    // Exercise 5: supervisorScope
    // TODO: Implement a coroutine exercise demonstrating supervisorScope.
    // TODO: Use runBlocking to make it testable. Topic: Advanced structured concurrency.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_supervisorScope(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_scopeManagement().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_lifetimeScope().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_cancelOnError().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_parallelScope().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_supervisorScope() == true) { "Exercise 5 failed" }
        println("All Coro076_AdvancedStructured exercises passed!")
    }
}
