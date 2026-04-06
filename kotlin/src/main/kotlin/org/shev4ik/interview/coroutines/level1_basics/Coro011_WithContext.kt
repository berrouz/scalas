package org.shev4ik.interview.coroutines.level1_basics

/**
 * Context switching
 */
object Coro011_WithContext {

    // Exercise 1: switchToIO
    // TODO: Implement a coroutine exercise demonstrating switchToIO.
    // TODO: Use runBlocking to make it testable. Topic: Context switching.
    // TODO: Return a verifiable result of type String.
    fun exercise1_switchToIO(): String = TODO()

    // Exercise 2: switchToDefault
    // TODO: Implement a coroutine exercise demonstrating switchToDefault.
    // TODO: Use runBlocking to make it testable. Topic: Context switching.
    // TODO: Return a verifiable result of type String.
    fun exercise2_switchToDefault(): String = TODO()

    // Exercise 3: nestedWithContext
    // TODO: Implement a coroutine exercise demonstrating nestedWithContext.
    // TODO: Use runBlocking to make it testable. Topic: Context switching.
    // TODO: Return a verifiable result of type String.
    fun exercise3_nestedWithContext(): String = TODO()

    // Exercise 4: resultFromContext
    // TODO: Implement a coroutine exercise demonstrating resultFromContext.
    // TODO: Use runBlocking to make it testable. Topic: Context switching.
    // TODO: Return a verifiable result of type String.
    fun exercise4_resultFromContext(): String = TODO()

    // Exercise 5: combineContexts
    // TODO: Implement a coroutine exercise demonstrating combineContexts.
    // TODO: Use runBlocking to make it testable. Topic: Context switching.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_combineContexts(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_switchToIO().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_switchToDefault().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_nestedWithContext().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_resultFromContext().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_combineContexts().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro011_WithContext exercises passed!")
    }
}
