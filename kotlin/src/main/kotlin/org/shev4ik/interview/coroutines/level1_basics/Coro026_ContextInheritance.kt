package org.shev4ik.interview.coroutines.level1_basics

/**
 * Context inheritance
 */
object Coro026_ContextInheritance {

    // Exercise 1: inheritDispatcher
    // TODO: Implement a coroutine exercise demonstrating inheritDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Context inheritance.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_inheritDispatcher(): Boolean = TODO()

    // Exercise 2: overrideElement
    // TODO: Implement a coroutine exercise demonstrating overrideElement.
    // TODO: Use runBlocking to make it testable. Topic: Context inheritance.
    // TODO: Return a verifiable result of type String.
    fun exercise2_overrideElement(): String = TODO()

    // Exercise 3: mergeContext
    // TODO: Implement a coroutine exercise demonstrating mergeContext.
    // TODO: Use runBlocking to make it testable. Topic: Context inheritance.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_mergeContext(): List<Int> = TODO()

    // Exercise 4: childContext
    // TODO: Implement a coroutine exercise demonstrating childContext.
    // TODO: Use runBlocking to make it testable. Topic: Context inheritance.
    // TODO: Return a verifiable result of type String.
    fun exercise4_childContext(): String = TODO()

    // Exercise 5: parentContext
    // TODO: Implement a coroutine exercise demonstrating parentContext.
    // TODO: Use runBlocking to make it testable. Topic: Context inheritance.
    // TODO: Return a verifiable result of type String.
    fun exercise5_parentContext(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_inheritDispatcher() == true) { "Exercise 1 failed" }
        assert(exercise2_overrideElement().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_mergeContext().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_childContext().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_parentContext().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro026_ContextInheritance exercises passed!")
    }
}
