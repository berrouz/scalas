package org.shev4ik.interview.coroutines.level1_basics

/**
 * Child coroutine lifecycle
 */
object Coro025_ChildCoroutines {

    // Exercise 1: childLifecycle
    // TODO: Implement a coroutine exercise demonstrating childLifecycle.
    // TODO: Use runBlocking to make it testable. Topic: Child coroutine lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise1_childLifecycle(): String = TODO()

    // Exercise 2: childCancel
    // TODO: Implement a coroutine exercise demonstrating childCancel.
    // TODO: Use runBlocking to make it testable. Topic: Child coroutine lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise2_childCancel(): String = TODO()

    // Exercise 3: parentWaits
    // TODO: Implement a coroutine exercise demonstrating parentWaits.
    // TODO: Use runBlocking to make it testable. Topic: Child coroutine lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise3_parentWaits(): String = TODO()

    // Exercise 4: childException
    // TODO: Implement a coroutine exercise demonstrating childException.
    // TODO: Use runBlocking to make it testable. Topic: Child coroutine lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise4_childException(): String = TODO()

    // Exercise 5: childScope
    // TODO: Implement a coroutine exercise demonstrating childScope.
    // TODO: Use runBlocking to make it testable. Topic: Child coroutine lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise5_childScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_childLifecycle().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_childCancel().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parentWaits().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_childException().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_childScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro025_ChildCoroutines exercises passed!")
    }
}
