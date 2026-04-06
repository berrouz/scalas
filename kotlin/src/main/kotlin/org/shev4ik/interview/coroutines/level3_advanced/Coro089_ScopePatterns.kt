package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine scope patterns
 */
object Coro089_ScopePatterns {

    // Exercise 1: viewModelScope
    // TODO: Implement a coroutine exercise demonstrating viewModelScope.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine scope patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_viewModelScope(): String = TODO()

    // Exercise 2: lifecycleScope
    // TODO: Implement a coroutine exercise demonstrating lifecycleScope.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine scope patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_lifecycleScope(): String = TODO()

    // Exercise 3: applicationScope
    // TODO: Implement a coroutine exercise demonstrating applicationScope.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine scope patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_applicationScope(): String = TODO()

    // Exercise 4: supervisorScope
    // TODO: Implement a coroutine exercise demonstrating supervisorScope.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine scope patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_supervisorScope(): Boolean = TODO()

    // Exercise 5: customScope
    // TODO: Implement a coroutine exercise demonstrating customScope.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine scope patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_customScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_viewModelScope().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_lifecycleScope().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_applicationScope().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_supervisorScope() == true) { "Exercise 4 failed" }
        assert(exercise5_customScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro089_ScopePatterns exercises passed!")
    }
}
